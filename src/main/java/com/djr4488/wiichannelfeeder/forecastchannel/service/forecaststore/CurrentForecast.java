package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.Currently;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by djr4488 on 6/9/17.
 */
@Entity
@Table(name = "current_forecasts")
public class CurrentForecast extends Identifiable {
    @Column(name = "time")
    private Long time;
    @Column(name = "summary")
    private String summary;
    @Column(name = "icon")
    private String icon;
    @Column(name = "nearest_storm_distance")
    private BigDecimal nearestStormDistance;
    @Column(name = "neareset_storm_bearing")
    private BigDecimal nearestStormBearing;
    @Column(name = "precip_intensity")
    private BigDecimal precipIntensity;
    @Column(name = "precip_intensity_error")
    private BigDecimal precipIntensityError;
    @Column(name = "precip_probability")
    private BigDecimal precipProbability;
    @Column(name = "precip_type")
    private String precipType;
    @Column(name = "precip_temperature")
    private BigDecimal precipTemperature;
    @Column(name = "temperature")
    private BigDecimal temperature;
    @Column(name = "apparent_temperature")
    private BigDecimal apparentTemperature;
    @Column(name = "dew_point")
    private BigDecimal dewPoint;
    @Column(name = "humidity")
    private BigDecimal humidity;
    @Column(name = "wind_speed")
    private BigDecimal windSpeed;
    @Column(name = "wind_bearing")
    private BigDecimal windBearing;
    @Column(name = "visibitiliy")
    private BigDecimal visibility;
    @Column(name = "cloud_cover")
    private BigDecimal cloudCover;
    @Column(name = "pressure")
    private BigDecimal pressure;
    @Column(name = "ozone")
    private BigDecimal ozone;
    @Column(name = "uv_index")
    private BigDecimal uvIndex;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Location location;

    public CurrentForecast() {}

    public CurrentForecast(Currently currently) {
        CopyUtils.copyProperties(currently, this);
    }

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

    public BigDecimal getNearestStormDistance() {
        return nearestStormDistance;
    }

    public void setNearestStormDistance(BigDecimal nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

    public BigDecimal getNearestStormBearing() {
        return nearestStormBearing;
    }

    public void setNearestStormBearing(BigDecimal nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
    }

    public BigDecimal getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(BigDecimal precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public BigDecimal getPrecipIntensityError() {
        return precipIntensityError;
    }

    public void setPrecipIntensityError(BigDecimal precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
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

    public BigDecimal getPrecipTemperature() {
        return precipTemperature;
    }

    public void setPrecipTemperature(BigDecimal precipTemperature) {
        this.precipTemperature = precipTemperature;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(BigDecimal apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public BigDecimal getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(BigDecimal dewPoint) {
        this.dewPoint = dewPoint;
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

    public BigDecimal getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(BigDecimal windBearing) {
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

    public BigDecimal getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(BigDecimal uvIndex) {
        this.uvIndex = uvIndex;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
