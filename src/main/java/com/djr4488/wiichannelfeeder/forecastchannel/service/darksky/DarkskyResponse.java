package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.Alert;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.CurrentForecast;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.DailyForecast;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.HourlyForecast;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.Location;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DarkskyResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String latitude;
    private String longitude;
    private String timezone;
    private Currently currently;
    private Hourly hourly;
    private Daily daily;
    private List<Alerts> alerts;
    private Flags flags;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public List<Alerts> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alerts> alerts) {
        this.alerts = alerts;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
