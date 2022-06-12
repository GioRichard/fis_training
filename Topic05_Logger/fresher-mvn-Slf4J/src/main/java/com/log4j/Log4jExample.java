package com.log4j;


//import com.logback.Example;
import org.apache.log4j.Logger;

public class Log4jExample {

    private final static Logger logger = Logger.getLogger(Log4jExample.class);

    public  final  static  void functionOne(){
        logger.debug("Debug log mess");
        logger.error("err log mess");
        logger.warn("warm log mess");
        logger.info("info log mess");
        logger.trace("trace log mess");

        try{
            //log invalid data from users
            logger.info("Info");

            //process data
            //check result after processing
            logger.debug("...");

         //   logger.trace("...");

        }catch (Exception ex){
            logger.error("Error"+ ex.toString());
        }
    }

    public static void main(String[] args) {
        //develop : quan tam den tat ca cac log vaf log ra console de theo doi
        functionOne();

        //operation : quan tam tuwf info tro len ; log ra file | database | globa log system

    }

}
