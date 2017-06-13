package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.DailyData;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.DailyForecast;
import com.djr4488.wiichannelfeeder.utils.CopyUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

public class Daily {
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

    public DailyForecast toDailyForecast() {
        DailyForecast dailyForecast = CopyUtils.copyProperties(this, new DailyForecast());
        dailyForecast.setData(toDailyDataList());
        return dailyForecast;
    }

    private List<DailyData> toDailyDataList() {
        List<DailyData> dailyDataList = new ArrayList<>(data.size());
        for (Data dataElement : data) {
            dailyDataList.add(dataElement.toDailyData());
        }
        return dailyDataList;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
