package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.Alerts;
import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyResponse;
import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.Data;
import org.joda.time.DateTime;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by djr4488 on 6/9/17.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ForecastStoreService {
    @PersistenceContext(unitName = "forecast_persistence")
    private EntityManager em;
    @Inject
    private Logger log;

    public List<RegionalForecast> getRegions() {
        TypedQuery<RegionalForecast> regionQuery = em.createNamedQuery("findRegions", RegionalForecast.class);
        return regionQuery.getResultList();
    }

    public RegionalForecast getRegion(String regionCode) {
        TypedQuery<RegionalForecast> regionQuery = em.createNamedQuery("findRegionByRegionCode", RegionalForecast.class);
        regionQuery.setParameter("regionCode", regionCode);
        return regionQuery.getSingleResult();
    }
    
    public Forecast saveForecastForLocation(DarkskyResponse darkskyResponse, RegionalForecast regionalForecast) {
        log.debug("saveForecastForLocation() darkskyResponse:{}, location:{}, city:{}", darkskyResponse, regionalForecast);
        return storeForecast(darkskyResponse, regionalForecast);
    }

    public void saveForecastDataPoints(DarkskyResponse darkskyResponse, Forecast forecast) {
        storeCurrentForecast(darkskyResponse, forecast);
        storeDailyForecast(darkskyResponse, forecast);
        storeHourlyForecast(darkskyResponse, forecast);
        storeAlerts(darkskyResponse, forecast);
    }

    public void deleteExistingForecastsForRegion(RegionalForecast regionalForecast) {
//        TypedQuery<Forecast> forecastsQuery = em.createNamedQuery("findForecastsByRegion", Forecast.class);
//        forecastsQuery.setParameter("region", regionalForecast);
//        List<Forecast> forecasts = forecastsQuery.getResultList();
//        for (Forecast forecast : forecasts) {
//            deleteCurrentForecast(forecast);
//            deleteHourlyForecast(forecast);
//            deleteDailyForecast(forecast);
//            deleteAlerts(forecast);
//            em.remove(forecast);
//        };
        em.refresh(regionalForecast);
        List<Forecast> forecastsInRegion = regionalForecast.getForecast();
        for (Forecast forecast : forecastsInRegion) {
            em.remove(forecast);
        }
        regionalForecast.getForecast().clear();
        em.flush();
    }

    private void deleteCurrentForecast(Forecast forecast) {
        em.remove(forecast.getCurrentForecast());
    }

    private void deleteHourlyForecast(Forecast forecast) {
        for (HourlyData hourlyData : forecast.getHourlyForecast().getData()) {
            em.remove(hourlyData);
        }
        em.remove(forecast.getHourlyForecast());
    }

    private void deleteDailyForecast(Forecast forecast) {
        for (DailyData dailyData : forecast.getDailyForecast().getData()) {
            em.remove(dailyData);
        }
        em.remove(forecast.getDailyForecast());
    }

    private void deleteAlerts(Forecast forecast) {
        for (Alert alert : forecast.getAlert()) {
            em.remove(alert);
        }
    }

    private Forecast storeForecast(DarkskyResponse darkskyResponse, RegionalForecast regionalForecast) {
        log.debug("storeLocation() darkskyResponse:{}", darkskyResponse);
        Forecast forecast = new Forecast(darkskyResponse, regionalForecast);
        em.persist(forecast);
        regionalForecast.getForecast().add(forecast);
        em.flush();
        return forecast;
    }

    private void storeAlerts(DarkskyResponse darkskyResponse, Forecast location) {
        if (null != darkskyResponse.getAlerts()) {
            log.debug("storeAlerts() darkskyAlerts:{}, location:{}", darkskyResponse.getAlerts().size(), location);
            List<Alert> alerts = new ArrayList<>(darkskyResponse.getAlerts().size());
            for (Alerts alertData : darkskyResponse.getAlerts()) {
                Alert alert = new Alert(alertData);
                alert.setForecast(location);
                setCreatedAndLastUpdateAtDates(alert);
                em.persist(alert);
                em.flush();
                alerts.add(alert);
            }
            location.setAlert(alerts);
            em.flush();
        } else {
            log.trace("storeAlerts() no alerts to store");
        }
    }

    private void storeHourlyForecast(DarkskyResponse darkskyResponse, Forecast location) {
        log.debug("storeHourlyForecast() darkskyResponseHourly:{}, location:{}", darkskyResponse.getHourly(), location);
        HourlyForecast hourlyForecast = new HourlyForecast(darkskyResponse.getHourly());
        hourlyForecast.setForecast(location);
        setCreatedAndLastUpdateAtDates(hourlyForecast);
        em.persist(hourlyForecast);
        em.flush();
        for (Data data : darkskyResponse.getHourly().getData()) {
            HourlyData hourlyData = new HourlyData(data);
            hourlyData.setHourlyForecast(hourlyForecast);
            setCreatedAndLastUpdateAtDates(hourlyData);
            em.persist(hourlyData);
            em.flush();
        }
    }

    private void storeDailyForecast(DarkskyResponse darkskyResponse, Forecast location) {
        log.debug("storeDailyForecast() darkskyDailyForecast:{}, location:{}", darkskyResponse.getDaily(), location);
        DailyForecast dailyForecast = new DailyForecast(darkskyResponse.getDaily());
        dailyForecast.setForecast(location);
        setCreatedAndLastUpdateAtDates(dailyForecast);
        em.persist(dailyForecast);
        em.flush();
        for (Data data : darkskyResponse.getDaily().getData()) {
            DailyData dailyData = new DailyData(data);
            dailyData.setDailyForecast(dailyForecast);
            setCreatedAndLastUpdateAtDates(dailyData);
            em.persist(dailyData);
            em.flush();
        }
    }

    private void storeCurrentForecast(DarkskyResponse darkskyResponse, Forecast location) {
        log.debug("storeCurrentForecast() darkskyCurrentForecast:{}, location:{}", darkskyResponse.getCurrently(), location);
        CurrentForecast currentForecast = new CurrentForecast(darkskyResponse.getCurrently());
        currentForecast.setForecast(location);
        setCreatedAndLastUpdateAtDates(currentForecast);
        em.persist(currentForecast);
        em.flush();
    }

    public <T extends Identifiable> void setCreatedAndLastUpdateAtDates(T entity) {
        Date date = DateTime.now().toDate();
        if (!(entity instanceof Forecast) || null == entity.getId()) {
            entity.setCreatedAt(date);
        }
        entity.setLastUpdatedAt(date);
    }
}
