package logger;

import org.apache.log4j.Logger;

public class CheckOutPage {

    private static final Logger logger = Logger.getLogger(pages.CheckOutPage.class);

    public static void main(String[] args) {
        logger.info("Checkout page extends");
        System.out.println("Base page");
    }
}