package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.Alerts;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by djr4488 on 6/9/17.
 */
@Entity
@Table(name = "alert_entries")
public class Alert extends Identifiable {
    @Column(name = "title")
    private String title;
    @Column(name = "time")
    private Long time;
    @Column(name = "expires")
    private Long expires;
    @Column(name = "description", columnDefinition = "BLOB")
    private String description;
    @Column(name = "uri")
    private String uri;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    public Alert() {}

    public Alert(Alerts alerts) {
        CopyUtils.copyProperties(alerts, this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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
