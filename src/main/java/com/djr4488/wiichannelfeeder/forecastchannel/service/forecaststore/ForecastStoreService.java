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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;

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
    
    public void saveForecastForLocation(DarkskyResponse darkskyResponse) {
        log.debug("saveForecastForLocation() darkskyResponse:{}", darkskyResponse);
        try {
            Location location = storeLocation(darkskyResponse);
            storeCurrentForecast(darkskyResponse, location);
            storeDailyForecast(darkskyResponse, location);
            storeHourlyForecast(darkskyResponse, location);
            storeAlerts(darkskyResponse, location);
        } catch (NullPointerException npEx) {
            log.error("saveForecastForLocation() ", npEx);
            throw npEx;
        }
    }

    private Location storeLocation(DarkskyResponse darkskyResponse) {
        log.debug("storeLocation() darkskyResponse:{}", darkskyResponse);
        TypedQuery<Location> locationQuery = em.createNamedQuery("findByLatitudeAndLongitude", Location.class);
        locationQuery.setParameter("latitude", darkskyResponse.getLatitude());
        locationQuery.setParameter("longitude", darkskyResponse.getLongitude());
        Location location = null;
        try {
            location = locationQuery.getSingleResult();
            setCreatedAndLastUpdateAtDates(location);
            em.remove(location.getDailyForecast());
            location.setDailyForecast(null);
            em.remove(location.getHourlyForecast());
            location.setHourlyForecast(null);
            if (null != location.getAlert()) {
                for (Alert alert : location.getAlert()) {
                    em.remove(alert);
                }
                location.setAlert(null);
            }
            em.remove(location.getCurrentForecast());
            location.setCurrentForecast(null);
            em.flush();
        } catch (NoResultException nrEx) {
            location = new Location(darkskyResponse);
            setCreatedAndLastUpdateAtDates(location);
            em.persist(location);
            em.flush();
        }
        return location;
    }

    private void storeAlerts(DarkskyResponse darkskyResponse, Location location) {
        if (null != darkskyResponse.getAlerts()) {
            log.debug("storeAlerts() darkskyAlerts:{}, location:{}", darkskyResponse.getAlerts().size(), location);
            for (Alerts alertData : darkskyResponse.getAlerts()) {
                Alert alert = new Alert(alertData);
                alert.setLocation(location);
                setCreatedAndLastUpdateAtDates(alert);
                em.persist(alert);
                em.flush();
            }
        } else {
            log.trace("storeAlerts() no alerts to store");
        }
    }

    private void storeHourlyForecast(DarkskyResponse darkskyResponse, Location location) {
        log.debug("storeHourlyForecast() darkskyResponseHourly:{}, location:{}", darkskyResponse.getHourly(), location);
        HourlyForecast hourlyForecast = new HourlyForecast(darkskyResponse.getHourly());
        hourlyForecast.setLocation(location);
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

    private void storeDailyForecast(DarkskyResponse darkskyResponse, Location location) {
        log.debug("storeDailyForecast() darkskyDailyForecast:{}, location:{}", darkskyResponse.getDaily(), location);
        DailyForecast dailyForecast = new DailyForecast(darkskyResponse.getDaily());
        dailyForecast.setLocation(location);
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

    private void storeCurrentForecast(DarkskyResponse darkskyResponse, Location location) {
        log.debug("storeCurrentForecast() darkskyCurrentForecast:{}, location:{}", darkskyResponse.getCurrently(), location);
        CurrentForecast currentForecast = new CurrentForecast(darkskyResponse.getCurrently());
        currentForecast.setLocation(location);
        setCreatedAndLastUpdateAtDates(currentForecast);
        em.persist(currentForecast);
        em.flush();
    }

    public <T extends Identifiable> void setCreatedAndLastUpdateAtDates(T entity) {
        Date date = DateTime.now().toDate();
        if (!(entity instanceof Location) || null == entity.getId()) {
            entity.setCreatedAt(date);
        }
        entity.setLastUpdatedAt(date);
    }
}
