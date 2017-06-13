package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.HourlyData;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.HourlyForecast;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;


public class Hourly {
    private String summary;
    private String icon;
    private List<Data> data;

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

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public HourlyForecast toHourlyForecast() {
        HourlyForecast hourlyForecast = CopyUtils.copyProperties(this, new HourlyForecast());
        hourlyForecast.setData(toHourlyDataList());
        return hourlyForecast;
    }

    public List<HourlyData> toHourlyDataList() {
        List<HourlyData> hourlyDataList = new ArrayList<>(data.size());
        for (Data dataElement : data) {
            hourlyDataList.add(dataElement.toHourlyData());
        }
        return hourlyDataList;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
