package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.Daily;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.DeleteAll;

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
@Table(name = "daily_forecasts")
@CascadeOnDelete
public class DailyForecast extends Identifiable {
    @Column(name = "summary")
    private String summary;
    @Column(name = "icon")
    private String icon;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "DailyForecast", orphanRemoval = true, cascade = CascadeType.REMOVE)
    @DeleteAll
    private List<DailyData> dailyData;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "forecast_id", referencedColumnName = "id")
    private Forecast forecast;

    public DailyForecast() {}

    public DailyForecast(Daily daily) {
        CopyUtils.copyProperties(daily, this);
        dailyData = null;
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

    public List<DailyData> getData() {
        return dailyData;
    }

    public void setData(List<DailyData> dailyData) {
        this.dailyData = dailyData;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
