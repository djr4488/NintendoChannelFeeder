package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by djr4488 on 6/10/17.
 */
@Entity
@Table(name = "hourly_data_entries")
public class HourlyData {
    @Column(name = "time")
    private Long time;
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
    @Column(name = "apparent_temperature", precision = 7, scale = 3)
    private BigDecimal apparentTempurature;
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
    @ManyToOne
    @JoinColumn(name = "hourly_id")
    private HourlyForecast hourlyForecast;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
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

    public BigDecimal getApparentTempurature() {
        return apparentTempurature;
    }

    public void setApparentTempurature(BigDecimal apparentTempurature) {
        this.apparentTempurature = apparentTempurature;
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

    public HourlyForecast getHourlyForecast() {
        return hourlyForecast;
    }

    public void setHourlyForecast(HourlyForecast hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
