package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by djr4488 on 6/11/17.
 */
public class Flags implements Serializable {
    private static final long serialVersionUID = 1L;
    private String units;

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
