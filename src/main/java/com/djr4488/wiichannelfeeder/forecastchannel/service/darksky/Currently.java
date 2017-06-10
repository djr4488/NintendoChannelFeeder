package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

import java.util.TimeZone;

public class Currently {
    private Long time;
    private String summary;
    private String icon;
    private Float nearestStormDistance;
    private Float nearestStormBearing;
    private Float precipIntensity;
    private Float precipIntensityError;
    private Float precipProbability;
    private String precipType;
    private Float precipTemperature;
    private Float temperature;
    private Float apparentTemperature;
    private Float dewPoint;
    private Float humidity;
    private Float windSpeed;
    private Float windBearing;
    private Float visibility;
    private Float cloudCover;
    private Float pressure;
    private Float ozone;

    public Long getTime() {
        return time;
    }

    public DateTime getDateTime(String timezone) {
        return new DateTime(time * 1000, ISOChronology.getInstanceUTC()).withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone(timezone)));
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

    public Float getNearestStormDistance() {
        return nearestStormDistance;
    }

    public void setNearestStormDistance(Float nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

    public Float getNearestStormBearing() {
        return nearestStormBearing;
    }

    public void setNearestStormBearing(Float nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
    }

    public Float getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(Float precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public Float getPrecipIntensityError() {
        return precipIntensityError;
    }

    public void setPrecipIntensityError(Float precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
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

    public Float getPrecipTemperature() {
        return precipTemperature;
    }

    public void setPrecipTemperature(Float precipTemperature) {
        this.precipTemperature = precipTemperature;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(Float apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
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

    public Float getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(Float windBearing) {
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
