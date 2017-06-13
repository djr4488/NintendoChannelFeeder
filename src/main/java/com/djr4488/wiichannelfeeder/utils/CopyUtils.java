package com.djr4488.wiichannelfeeder.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

/**
 * Created by djr4488 on 6/12/17.
 */
public class CopyUtils {
    private static final Logger log = LoggerFactory.getLogger(CopyUtils.class);
    public static <T, R> R copyProperties(T from, R destinationAndReturn) {
        BigDecimalConverter bdc = new BigDecimalConverter(null);
        ConvertUtils.register(bdc, BigDecimal.class);
        try {
            BeanUtils.copyProperties(destinationAndReturn, from);
            return destinationAndReturn;
        } catch (IllegalAccessException | InvocationTargetException iaItEx) {
            log.error("copyProperties() unable to copy properties", iaItEx);
        }
        return null;
    }
}
