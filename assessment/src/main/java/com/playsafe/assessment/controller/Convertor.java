package com.playsafe.assessment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
public class Convertor {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @GetMapping("/conversions/ktoc/{k}")
    public String getCelsius(@PathVariable("k") float kelvin) {
        return df2.format(kelvin - 273.15) + " Degree";
    }

    @GetMapping("/conversions/ctok/{c}")
    public String getKelvin(@PathVariable("c") float celsius) {
        return df2.format(celsius + 273.15) + " Kelvin";
    }

    @GetMapping("/conversions/mtok/{m}")
    public String getKm(@PathVariable("m") double miles) {
        return df2.format(miles * 1.60934) + " km";
    }

    @GetMapping("/conversions/ktom/{k}")
    public String getMiles(@PathVariable("k") double km) {
        double miles = km * 0.621371;
        return df2.format(miles)  + " miles";
    }

}
