package net.kokohadoko.instil.androidmvvm.models.util;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Date型変換用クラス
 *
 * @author katsuya
 * @since 1.0.0
 */
public class DateConverter {

    /**
     * timestamp から Date型へ変換
     *
     * @param timestamp タイムスタンプ
     * @return Date型に変換した値
     */
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    /**
     * Date型 から timestamp へ変換
     *
     * @param date 日付
     * @return タイムスタンプに変換した値
     */
    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
