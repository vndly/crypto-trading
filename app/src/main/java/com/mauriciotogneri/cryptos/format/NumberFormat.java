package com.mauriciotogneri.cryptos.format;

import java.math.BigDecimal;

public class NumberFormat
{
    public static String price(Double value)
    {
        return format(value, 8);
    }

    public static String percentage(Double value)
    {
        return format(value * 100, 2) + "%";
    }

    public static String format(Double value, int decimals)
    {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(value));

        return bigDecimal.setScale(decimals, BigDecimal.ROUND_HALF_EVEN).toString();
    }
}