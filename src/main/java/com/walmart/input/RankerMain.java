package com.walmart.input;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.walmart.processor.WalmartRankingProcessor;

@SpringBootApplication
public class RankerMain implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RankerMain.class);

    
    public static void main(String[] args) {
        SpringApplication.run(RankerMain.class);
    }
        
    public void run(String... args) throws Exception {

        /*
         * Step 1 : Get input from user to execute product search (Through command line) Step 2 : Validate input IF
         * Error, Display error message and prompt for input again ELSE proceed to print Input value and begin Search
         * Step 3 : Proceed to begin search
         */
        logger.info("Entered Ranker Main class : Main method");
        // asking for input
        
        try {
        Scanner sc = new Scanner(System.in);

        // Variable for the query string
        String productName = null;

        // validation flag
        boolean error = false;
        int maxTry = 0;

        do {
            System.out.println("Enter the product name:");
            error = false;
            productName = sc.nextLine();
            logger.debug("Input entered by user is : " + productName);
            maxTry++;
            // Minimum product name length is assumed to be 3 and maximum is 50
            // Using regex to validate input
            if (productName == null || productName.isEmpty()) {
                logger.debug("User input is null or empty");
                System.out.println("Input entered is invalid. Please enter again");
                error = true;
            }
            else {
                if (productName.matches("[0-9a-zA-Z&@.'+-/\\s]{3,50}")) {
                    logger.debug("Input is valid. Exiting loop");
                    System.out.println("Search term entered is valid : " + productName);
                    System.out.println("Beginning search");
                    error = false;
                    break;
                }
                else {
                    logger.debug("Input does match regex");
                    System.out.println("Input entered is invalid. Please enter again");
                    error = true;
                }
            }
            if (maxTry > 5) {
                logger.debug("Number of attempts exceed limit");
                System.out.println("Maximum number of attempts exceeded. Please try again later.");
                error = true;
                break;
            }

        }
        while (error == true);

        WalmartRankingProcessor wrp = new WalmartRankingProcessor();
        String rankOrder = "";
        
        rankOrder = wrp.process(productName);
        
        System.out.println(rankOrder);

        // exiting the program
        if (sc != null) {
            sc.close();
        }

        logger.info("Exiting Ranker Main class : Main method");
        }  catch (Exception e){
            logger.error("Ran into a snag processing your request. Run the search again");
            System.out.println("Ran into a snag processing your request. Run the search again");
        }

    }


}
