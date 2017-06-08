package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.TimeZone;


public class Data {
    private Long time;
    private String summary;
    private String icon;
    private Float precipIntensity;
    private Float precipProbability;
    private String precipType;
    private Float temperature;
    private Float apparentTempurature;
    private Float dewPoint;
    private Float humidity;
    private Float windSpeed;
    private Integer windBearing;
    private Float visibility;
    private Float cloudCover;
    private Float pressure;
    private Float ozone;
    private DateTime sunriseTime;
    private DateTime sunsetTime;
    private Float moonPhase;
    private Float precipIntensityMax;
    private DateTime precipIntensityMaxTime;
    private Float temperatureMin;
    private DateTime temperatureMinTime;
    private Float temperatureMax;
    private DateTime temperatureMaxTime;
    private Float apparentTempuratureMin;
    private DateTime apparentTemperatureMinTime;
    private Float apparentTempuratureMax;
    private DateTime apparentTempuratureMaxTime;

    public Long getTime() {
        return time;
    }

    public DateTime getDateTime(String timezone) {
        return DateTime.now().withMillis(time).withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone(timezone)));
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

    public Float getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(Float precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public Float getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(Float precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getApparentTempurature() {
        return apparentTempurature;
    }

    public void setApparentTempurature(Float apparentTempurature) {
        this.apparentTempurature = apparentTempurature;
    }

    public Float getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Float dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(Integer windBearing) {
        this.windBearing = windBearing;
    }

    public Float getVisibility() {
        return visibility;
    }

    public void setVisibility(Float visibility) {
        this.visibility = visibility;
    }

    public Float getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Float cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Float getOzone() {
        return ozone;
    }

    public void setOzone(Float ozone) {
        this.ozone = ozone;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
