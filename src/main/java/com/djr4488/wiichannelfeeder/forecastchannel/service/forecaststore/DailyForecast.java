package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

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
public class DailyForecast extends Identifiable {
    @Column(name = "summary")
    private String summary;
    @Column(name = "icon")
    private String icon;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "DailyForecast")
    private List<DailyData> data;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

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
        return data;
    }

    public void setData(List<DailyData> data) {
        this.data = data;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
