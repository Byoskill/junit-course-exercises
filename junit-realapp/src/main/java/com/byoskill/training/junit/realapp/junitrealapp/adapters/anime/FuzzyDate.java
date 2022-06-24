package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

import java.time.LocalDate;

public class FuzzyDate {
    public int year;
    public int month;
    public int day;

    public LocalDate toLocalDate() {
        if (year < 1) return null;
        if (month < 1) return null;
        if (day < 1) return null;
        return LocalDate.of(year, month, day);
    }
}
