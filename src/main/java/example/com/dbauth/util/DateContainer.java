package example.com.dbauth.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateContainer {

    public Date date;

    public DateContainer(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");

        return sdFormat.format(date);

    }

    public static DateContainer valueOf(String dateString) throws ParseException {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");

        return new DateContainer(sdFormat.parse(dateString));
    }

}
