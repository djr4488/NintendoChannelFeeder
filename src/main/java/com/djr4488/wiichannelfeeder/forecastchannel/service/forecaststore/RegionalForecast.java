package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by djr4488 on 6/17/17.
 */
@Entity
@Table(name = "regions",
        indexes = {@Index(name = "idx_region", columnList = "region_code")})
@NamedQueries({
        @NamedQuery(name = "findRegionByRegionCode",
            query = "select region from RegionalForecast region where region.regionCode = :regionCode"),
        @NamedQuery(name = "findRegions",
            query = "select region from RegionalForecast region")
})
public class RegionalForecast extends Identifiable {
    @Column(name = "units", length = 5)
    private String units;
    @Column(name = "language", length = 5)
    private String language;
    @Column(name = "regionCode", length = 5)
    private String regionCode;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "RegionalForecast", orphanRemoval = true)
    private List<City> cities;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "RegionalForecast", orphanRemoval = true)
    private List<Forecast> forecast;

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
}
