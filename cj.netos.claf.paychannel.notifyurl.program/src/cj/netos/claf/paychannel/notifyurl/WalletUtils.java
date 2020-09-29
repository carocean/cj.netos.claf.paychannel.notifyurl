package cj.netos.claf.paychannel.notifyurl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WalletUtils {
    /**
     * 仅精确到天.返回的格式例如：20190402意为2019年04月02日
     * @param dateTime
     * @return
     */
    public static String dateTimeToDay(long dateTime) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        return dft.format(new Date(dateTime));
    }
    /**
     * 仅精确到秒.返回的格式例如：20190402232214,意为2019年04月02日23点22分14秒
     * @param dateTime
     * @return
     */
    public static String dateTimeToSecond(long dateTime) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
        return dft.format(new Date(dateTime));
    }
    /**
     * 精确到毫秒.返回的格式例如：20190402232214325,意为2019年04月02日23点22分14秒325毫秒
     * @param dateTime
     * @return
     */
    public static String dateTimeToMicroSecond(long dateTime) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.CHINA);
        return dft.format(new Date(dateTime));
    }
}
