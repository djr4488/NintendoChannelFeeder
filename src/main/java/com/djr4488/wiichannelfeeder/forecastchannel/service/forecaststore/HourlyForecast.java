package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.Hourly;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by djr4488 on 6/9/17.
 */
@Entity
@Table(name = "hourly_forecasts")
public class HourlyForecast extends Identifiable {
    @Column(name = "summary")
    private String summary;
    @Column(name = "icon")
    private String icon;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "HourlyForecast", orphanRemoval = true)
    private List<HourlyData> hourlyData;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    public HourlyForecast() {}

    public HourlyForecast(Hourly hourly) {
        CopyUtils.copyProperties(hourly, this);
        hourlyData = null;
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

    public List<HourlyData> getData() {
        return hourlyData;
    }

    public void setData(List<HourlyData> hourlyData) {
        this.hourlyData = hourlyData;
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

