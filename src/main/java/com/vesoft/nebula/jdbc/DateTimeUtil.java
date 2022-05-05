package com.vesoft.nebula.jdbc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author captain
 */

public class DateTimeUtil {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_DATE;
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ISO_TIME;
    private static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    /**
     * @param timestamp millisecond
     * @param zoneId    time zone
     * @return
     */
    public static String formatDate(long timestamp, ZoneId zoneId) {
        if (zoneId == null) {
            zoneId = ZoneId.systemDefault();
        }
        return DATE_FORMAT.format(transformToLocalDateTime(timestamp, zoneId));
    }

    private static LocalDateTime transformToLocalDateTime(long timestamp, ZoneId zoneId) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), zoneId);
    }

    /**
     * @param timestamp millisecond
     * @return
     */
    public static String formatDate(long timestamp) {
        return formatDate(timestamp, null);
    }

    public static String formatTime(long timestamp, ZoneId zoneId) {
        return TIME_FORMAT.format(transformToLocalDateTime(timestamp, zoneId));
    }

    public static String formatTime(long timestamp) {
        return formatDate(timestamp, null);
    }

    public static String formatDateTime(long timestamp, ZoneId zoneId) {
        return DATETIME_FORMAT.format(transformToLocalDateTime(timestamp, zoneId));
    }

    public static String formatDateTime(long timestamp) {
        return formatDateTime(timestamp, null);
    }
}
