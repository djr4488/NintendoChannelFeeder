package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by djr4488 on 6/11/17.
 */
@Entity
@Table(name = "daily_data_entries")
public class DailyData {
    @Column(name = "time")
    private DateTime time;
    @Column(name = "summary")
    private String summary;
    @Column(name = "icon")
    private String icon;
    @Column(name = "precip_intensity", precision = 7, scale = 3)
    private BigDecimal precipIntensity;
    @Column(name = "precip_probability", precision = 7, scale = 3)
    private BigDecimal precipProbability;
    private String precipType;
    @Column(name = "temperature", precision = 7, scale = 3)
    private BigDecimal temperature;
    @Column(name = "dewpoint", precision = 7, scale = 3)
    private BigDecimal dew_point;
    @Column(name = "humidity", precision = 7, scale = 3)
    private BigDecimal humidity;
    @Column(name = "wind_speed", precision = 7, scale = 3)
    private BigDecimal windSpeed;
    @Column(name = "wind_bearing")
    private Integer windBearing;
    @Column(name = "visibility", precision = 7, scale = 3)
    private BigDecimal visibility;
    @Column(name = "cloud_cover", precision = 7, scale = 3)
    private BigDecimal cloudCover;
    @Column(name = "pressure", precision = 7, scale = 3)
    private BigDecimal pressure;
    @Column(name = "ozone", precision = 7, scale = 3)
    private BigDecimal ozone;
    @Column(name = "sunrise_time")
    private DateTime sunriseTime;
    @Column(name = "sunset_time")
    private DateTime sunsetTime;
    @Column(name = "moon_phase", precision = 7, scale = 3)
    private BigDecimal moonPhase;
    @Column(name = "precip_intensity_max", precision = 7, scale = 3)
    private BigDecimal precipIntensityMax;
    @Column(name = "precip_intensity_max_time")
    private DateTime precipIntensityMaxTime;
    @Column(name = "temperature_min", precision = 7, scale = 3)
    private BigDecimal temperatureMin;
    @Column(name = "temperature_min_time")
    private DateTime temperatureMinTime;
    @Column(name = "temperature_max", precision = 7, scale = 3)
    private BigDecimal temperatureMax;
    @Column(name = "temperature_max_time")
    private DateTime temperatureMaxTime;
    @Column(name = "apparent_temperature_min", precision = 7, scale = 3)
    private BigDecimal apparentTempuratureMin;
    @Column(name = "apparent_temperature_min_time")
    private DateTime apparentTemperatureMinTime;
    @Column(name = "apparent_temperature_max", precision = 7, scale = 3)
    private BigDecimal apparentTempuratureMax;
    @Column(name = "apparent_temperature_max_time")
    private DateTime apparentTempuratureMaxTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daily_id")
    private DailyForecast dailyForecast;

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public BigDecimal getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(BigDecimal precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public BigDecimal getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(BigDecimal precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getDew_point() {
        return dew_point;
    }

    public void setDew_point(BigDecimal dew_point) {
        this.dew_point = dew_point;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(Integer windBearing) {
        this.windBearing = windBearing;
    }

    public BigDecimal getVisibility() {
        return visibility;
    }

    public void setVisibility(BigDecimal visibility) {
        this.visibility = visibility;
    }

    public BigDecimal getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(BigDecimal cloudCover) {
        this.cloudCover = cloudCover;
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public BigDecimal getOzone() {
        return ozone;
    }

    public void setOzone(BigDecimal ozone) {
        this.ozone = ozone;
    }

    public DateTime getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(DateTime sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public DateTime getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(DateTime sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public BigDecimal getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(BigDecimal moonPhase) {
        this.moonPhase = moonPhase;
    }

    public BigDecimal getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public void setPrecipIntensityMax(BigDecimal precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    public DateTime getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public void setPrecipIntensityMaxTime(DateTime precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    public BigDecimal getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(BigDecimal temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public DateTime getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public void setTemperatureMinTime(DateTime temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public BigDecimal getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(BigDecimal temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public DateTime getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(DateTime temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public BigDecimal getApparentTempuratureMin() {
        return apparentTempuratureMin;
    }

    public void setApparentTempuratureMin(BigDecimal apparentTempuratureMin) {
        this.apparentTempuratureMin = apparentTempuratureMin;
    }

    public DateTime getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(DateTime apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public BigDecimal getApparentTempuratureMax() {
        return apparentTempuratureMax;
    }

    public void setApparentTempuratureMax(BigDecimal apparentTempuratureMax) {
        this.apparentTempuratureMax = apparentTempuratureMax;
    }

    public DateTime getApparentTempuratureMaxTime() {
        return apparentTempuratureMaxTime;
    }

    public void setApparentTempuratureMaxTime(DateTime apparentTempuratureMaxTime) {
        this.apparentTempuratureMaxTime = apparentTempuratureMaxTime;
    }

    public DailyForecast getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(DailyForecast dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
