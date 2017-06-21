package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.Hourly;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.DeleteAll;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
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
@CascadeOnDelete
public class HourlyForecast extends Identifiable {
    @Column(name = "summary")
    private String summary;
    @Column(name = "icon")
    private String icon;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "HourlyForecast", orphanRemoval = true, cascade = CascadeType.REMOVE)
    @DeleteAll
    private List<HourlyData> hourlyData;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "forecast_id", referencedColumnName = "id")
    private Forecast forecast;

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

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

