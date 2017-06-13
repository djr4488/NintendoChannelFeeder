package com.djr4488.wiichannelfeeder.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

import java.util.TimeZone;

/**
 * Created by djr4488 on 6/10/17.
 */
public class ConversionUtils {
    public static DateTime convertUnixToDateTime(Long unixTimestamp, String timezone) {
        return new DateTime(unixTimestamp * 1000, ISOChronology.getInstanceUTC())
                .withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone(timezone)));
    }
}
