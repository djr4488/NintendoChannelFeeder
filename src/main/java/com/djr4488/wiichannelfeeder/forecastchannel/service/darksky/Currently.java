package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.CurrentForecast;
import com.djr4488.wiichannelfeeder.utils.ConversionUtils;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Currently implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long time;
    private String summary;
    private String icon;
    private BigDecimal nearestStormDistance;
    private BigDecimal nearestStormBearing;
    private BigDecimal precipIntensity;
    private BigDecimal precipIntensityError;
    private BigDecimal precipProbability;
    private String precipType;
    private BigDecimal precipTemperature;
    private BigDecimal temperature;
    private BigDecimal apparentTemperature;
    private BigDecimal dewPoint;
    private BigDecimal humidity;
    private BigDecimal windSpeed;
    private BigDecimal windBearing;
    private BigDecimal visibility;
    private BigDecimal cloudCover;
    private BigDecimal pressure;
    private BigDecimal ozone;
    private BigDecimal uvIndex;

    public Long getTime() {
        return time;
    }

    public DateTime getDateTime(String timezone) {
        return ConversionUtils.convertUnixToDateTime(getTime(), timezone);
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

    public CurrentForecast toCurrently() {
        CurrentForecast currentForecast = CopyUtils.copyProperties(this, new CurrentForecast());
        currentForecast.setCreatedAt(DateTime.now().toDate());
        currentForecast.setLastUpdatedAt(DateTime.now().toDate());
        return currentForecast;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
