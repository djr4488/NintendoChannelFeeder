package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.DailyData;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.HourlyData;
import com.djr4488.wiichannelfeeder.utils.ConversionUtils;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.math.BigDecimal;

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long time;
    private String summary;
    private String icon;
    private BigDecimal precipIntensity;
    private BigDecimal precipProbability;
    private String precipType;
    private BigDecimal temperature;
    private BigDecimal apparentTempurature;
    private BigDecimal dewPoint;
    private BigDecimal humidity;
    private BigDecimal windSpeed;
    private Integer windBearing;
    private BigDecimal visibility;
    private BigDecimal cloudCover;
    private BigDecimal pressure;
    private BigDecimal ozone;
    private Long sunriseTime;
    private Long sunsetTime;
    private BigDecimal moonPhase;
    private BigDecimal precipIntensityMax;
    private Long precipIntensityMaxTime;
    private BigDecimal temperatureMin;
    private Long temperatureMinTime;
    private BigDecimal temperatureMax;
    private Long temperatureMaxTime;
    private BigDecimal apparentTempuratureMin;
    private Long apparentTemperatureMinTime;
    private BigDecimal apparentTempuratureMax;
    private Long apparentTempuratureMaxTime;

    public Long getTime() {
        return time;
    }

    public DateTime getDateTime(String timezone) {
        return ConversionUtils.convertUnixToDateTime(time, timezone);
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

    public Long getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(Long sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public DateTime getSunriseDateTime(String timezone) {
        return ConversionUtils.convertUnixToDateTime(getSunriseTime(), timezone);
    }

    public Long getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(Long sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public DateTime getSunsetDateTime(String timezone) {
        return ConversionUtils.convertUnixToDateTime(getSunsetTime(), timezone);
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

    public Long getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public void setPrecipIntensityMaxTime(Long precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    public DateTime getPrecipIntensityMaxDateTime(String timezone) {
        return ConversionUtils.convertUnixToDateTime(getPrecipIntensityMaxTime(), timezone);
    }

    public BigDecimal getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(BigDecimal temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Long getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public void setTemperatureMinTime(Long temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public DateTime getTemperatureMinDateTime(String timezone) {
        return ConversionUtils.convertUnixToDateTime(getTemperatureMinTime(), timezone);
    }

    public BigDecimal getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(BigDecimal temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Long getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(Long temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public DateTime getTemperatureMaxDateTime(String timezone) {
        return ConversionUtils.convertUnixToDateTime(getTemperatureMaxTime(), timezone);
    }

    public BigDecimal getApparentTempuratureMin() {
        return apparentTempuratureMin;
    }

    public void setApparentTempuratureMin(BigDecimal apparentTempuratureMin) {
        this.apparentTempuratureMin = apparentTempuratureMin;
    }

    public Long getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(Long apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public DateTime getApparentTemperatureMinDateTime(String timezone) {
        return ConversionUtils.convertUnixToDateTime(getApparentTemperatureMinTime(), timezone);
    }

    public BigDecimal getApparentTempuratureMax() {
        return apparentTempuratureMax;
    }

    public void setApparentTempuratureMax(BigDecimal apparentTempuratureMax) {
        this.apparentTempuratureMax = apparentTempuratureMax;
    }

    public Long getApparentTempuratureMaxTime() {
        return apparentTempuratureMaxTime;
    }

    public void setApparentTempuratureMaxTime(Long apparentTempuratureMaxTime) {
        this.apparentTempuratureMaxTime = apparentTempuratureMaxTime;
    }

    public DateTime getApparentTemperatureMaxTime(String timezone) {
        return ConversionUtils.convertUnixToDateTime(getApparentTempuratureMaxTime(), timezone);
    }

    public DailyData toDailyData() {
        return CopyUtils.copyProperties(this, new DailyData());
    }

    public HourlyData toHourlyData() {
        return CopyUtils.copyProperties(this, new HourlyData());
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
