package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte mem = 1;
        short age = 30;
        char gender = 'M';
        float height = 1.7F;
        short brick = 5200;
        double bacteria = 1.2E+7;
        boolean resolution = true;
        long size = 3000000;
        LOG.debug("mem : {}, age : {}, gender : {}, height : {}, brick : {}, bacteria : {}, resolution : {}, size : {}",
                mem, age, gender, height, brick, bacteria, resolution, size);
    }
}
