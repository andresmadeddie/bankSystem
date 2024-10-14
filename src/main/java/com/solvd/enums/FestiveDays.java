package com.solvd.enums;

public enum FestiveDays {

        NEW_YEAR("New Year's Day", 1, "January"),
        INDEPENDENCE_DAY("Independence Day", 4, "July"),
        CHRISTMAS("Christmas", 25, "December");

        private final String name;
        private final int day;
        private final String month;

        FestiveDays(String name, int day, String month) {
            this.name = name;
            this.day = day;
            this.month = month;
        }

        public String getName() {
            return name;
        }

        public int getDay() {
            return day;
        }

        public String getMonth() {
            return month;
        }

}
