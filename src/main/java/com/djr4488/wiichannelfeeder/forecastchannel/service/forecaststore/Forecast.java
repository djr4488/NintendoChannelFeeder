package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyResponse;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.eclipse.persistence.annotations.DeleteAll;
import org.joda.time.DateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by djr4488 on 6/9/17.
 */
@Entity
@Table(name = "forecasts")
@NamedQueries({
        @NamedQuery(name = "findForecastsByRegion",
            query = "select forecast from Forecast forecast where forecast.regionalForecast = :region"),
        @NamedQuery(name = "deleteForecastsByRegion",
            query = "delete from Forecast forecast where forecast.regionalForecast = :region")
})
public class Forecast extends Identifiable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private RegionalForecast regionalForecast;
    @Column(name = "timezone")
    private String timezone;
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "Forecast", orphanRemoval = true, cascade = CascadeType.REMOVE)
    @DeleteAll
    private HourlyForecast hourlyForecast;
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "Forecast", orphanRemoval = true, cascade = CascadeType.REMOVE)
    @DeleteAll
    private DailyForecast dailyForecast;
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "Forecast", orphanRemoval = true, cascade = CascadeType.REMOVE)
    @DeleteAll
    private CurrentForecast currentForecast;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Forecast", orphanRemoval = true, cascade = CascadeType.REMOVE)
    @DeleteAll
    private List<Alert> alert;

    public Forecast() {
    }

    public Forecast(DarkskyResponse darkskyResponse, RegionalForecast regionalForecast) {
        CopyUtils.copyProperties(darkskyResponse, this);
        this.regionalForecast = regionalForecast;
        Date now = DateTime.now().toDate();
        this.setCreatedAt(now);
        this.setLastUpdatedAt(now);
    }

    public RegionalForecast getRegionalForecast() {
        return regionalForecast;
    }

    public void setRegionalForecast(RegionalForecast regionalForecast) {
        this.regionalForecast = regionalForecast;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public HourlyForecast getHourlyForecast() {
        return hourlyForecast;
    }

    public void setHourlyForecast(HourlyForecast hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }

    public DailyForecast getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(DailyForecast dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    public CurrentForecast getCurrentForecast() {
        return currentForecast;
    }

    public void setCurrentForecast(CurrentForecast currentForecast) {
        this.currentForecast = currentForecast;
    }

    public List<Alert> getAlert() {
        return alert;
    }

    public void setAlert(List<Alert> alert) {
        this.alert = alert;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
