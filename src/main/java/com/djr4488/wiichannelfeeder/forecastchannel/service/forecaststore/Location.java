package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by djr4488 on 6/9/17.
 */
@Entity
@Table(name = "locations")
public class Location extends Identifiable {
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode", length = 5)
    private String zipCode;
    @Column(name = "timezone")
    private String timezone;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "Location")
    private HourlyForecast hourlyForecast;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "Location")
    private DailyForecast dailyForecast;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "Location")
    private CurrentForecast currentForecast;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
