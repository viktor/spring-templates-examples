package com.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleLogger {

    private static Logger logger = Logger.getLogger(com.example.util.SimpleLogger.class.getName());

    public static void info(String msg, Object... args){
        if(args != null && args.length > 0){
            List<String> toStringArgs = new ArrayList<>();
            for(Object arg : args)
                toStringArgs.add(String.valueOf(arg));
            logger.log(Level.INFO, String.format(msg, toStringArgs.toArray(new String[toStringArgs.size()]) ));
        }else{
            logger.log(Level.INFO, msg);
        }
    }
}
