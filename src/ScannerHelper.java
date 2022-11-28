import java.util.Scanner;

public class ScannerHelper {

    /**
     * Checks whenever the 'mail address' field has valid value.
     * The email address shuold:
     * 1. contain the @ sign
     * 2. @ is not the first char, and not the last char (use charAt, endWith…)
     * 3. the domain - part of mail address after the @ contains at least 1 dot(.) (use subString)
     *
     * @param theEmailAddress - the e-mail address
     * @throws InvalidEmailAddressException
     */
    static void emailValidator(String theEmailAddress) throws InvalidEmailAddressException {
        //if the e-mail is null throw exception
        if (theEmailAddress == null)
            throw new InvalidEmailAddressException(theEmailAddress, "The provided e-mail address is empty");

        //check if contains @
        if (!theEmailAddress.contains(Consts.STRUDEL))
            throw new InvalidEmailAddressException(theEmailAddress, "The e-mail address does not contain @");

        //check if the address does not start or end with @
        if (theEmailAddress.startsWith(Consts.STRUDEL) || theEmailAddress.endsWith(Consts.STRUDEL))
            throw new InvalidEmailAddressException(theEmailAddress, "The e-mail address should not start or end with the @ character");

        //check if the email contains one . after the @
        if (!theEmailAddress.substring(theEmailAddress.indexOf(Consts.STRUDEL)).contains(Consts.DOT))
            throw new InvalidEmailAddressException(theEmailAddress, "The e-mail address should contain at least 1 dot in the domain i.e. after the @ character");
    }

    /**
     * Scan a new Medicine from command line including basic validation
     *
     * @param medicineType - The type of the Medicine to be scanned
     * @return - The newly scanned and validated Medicine
     */
    static Medicine scanNewMedicine(Medicine.Type medicineType) {
        //create a new scanner object
        Scanner aScanner = new Scanner(System.in);

        String name = scanString(aScanner, "medicine name", false);

        String compName = scanString(aScanner, "company name", false);

        String email = scanEmail(aScanner);

        double price = scanDouble(aScanner, "price");

        int quantity = scanInt(aScanner, "quantity");

        int expirationYear = scanInt(aScanner, "expiration year");

        int numOfPillsInBox = scanInt(aScanner, "num of pills in box");

        //creates a new Medicine by type
        return createNewMedicineByType(medicineType, name, compName, email, price,
                quantity, expirationYear, numOfPillsInBox);
    }

    /**
     * Creates a new single Medicine type according to the supplied parameters
     *
     * @param medicineType    - the Medicine.Type of the new Medicine
     * @param name            - name of the Medicine
     * @param compName        - company name of the Medicine manufacturer
     * @param email           - email address of the company
     * @param price           - the price of 1 box
     * @param quantity        - the quantity in inventory
     * @param expirationYear  - year of expiration
     * @param numOfPillsInBox - number of pills in a box
     * @return - new Medicine
     */
    static Medicine createNewMedicineByType(Medicine.Type medicineType,
                                            String name, String compName, String email,
                                            double price, int quantity, int expirationYear, int numOfPillsInBox) {
        Medicine newMedicine = null;

        // create  a new Medicine according to the supplied medicine type
        switch (medicineType) {
            /*
            This is the old fashion look of swith case !
            case PILLS:
                newMedicine = new Pills(name, compName, email, price, quantity, expirationYear, numOfPillsInBox);
                break;
            case INHALER:
                newMedicine = new Inhaler(name, compName, email, price, quantity, expirationYear, numOfPillsInBox);
                break;
            case SYRUP:
                newMedicine = new Syrup(name, compName, email, price, quantity, expirationYear, numOfPillsInBox);
                break;
            */
            //This is the new look and feel of swith case
            case PILLS   -> newMedicine = new Pills(name, compName, email, price, quantity, expirationYear, numOfPillsInBox);
            case INHALER -> newMedicine = new Inhaler(name, compName, email, price, quantity, expirationYear, numOfPillsInBox);
            case SYRUP   -> newMedicine = new Syrup(name, compName, email, price, quantity, expirationYear, numOfPillsInBox);
        }
        return newMedicine;
    }

    /**
     * Scans a double type input including value validation
     *
     * @param aScanner      - the scanner object in order to prevent creation again and again
     * @param parameterName - the name of the parameter to be scanned, it will be presented to the end user
     * @return - the validated double value
     */
    static double scanDouble(Scanner aScanner, String parameterName) {
        double theScannedValue = 0;
        boolean scannedSuccessfuly = false;

        //scan until a valid value entered
        while (!scannedSuccessfuly) {
            System.out.println("Enter the '" + parameterName + "' :");
            try {
                theScannedValue = aScanner.nextDouble();
                scannedSuccessfuly = true;
            } catch (Exception e) {
                System.out.println("The '" + parameterName + "' MUST have double value !");
                //in case of error we MUST read the next line
                aScanner.nextLine();
            }
        }
        return theScannedValue;
    }

    // Deligator to scanInt with min and max value
    static int scanInt(String parameterName, int minValue, int maxValue)
    {
        return scanInt(new Scanner(System.in),parameterName,minValue,maxValue);
    }

    // Deligator to scanInt without min and max values validation
    static int scanInt(Scanner aScanner, String parameterName) {
        return scanInt(aScanner,parameterName,-1,-1);
    }



        /**
         * Scans an int type input including value validation
         *
         * @param aScanner      - the scanner object in order to prevent creation again and again
         * @param parameterName - the name of the parameter to be scanned, it will be presented to the end user
         * @param minVal        - the minmum value to be calidated
         * @param maxVal        - the max value to be validated
         * If both values are -1 ignore validation
         * @return - the validated int value
         */
    static int scanInt(Scanner aScanner, String parameterName, int minVal, int maxVal) {
        int theScannedValue = 0;
        boolean scannedSuccessfuly = false;

        //scan until a valid value entered
        while (!scannedSuccessfuly) {
            System.out.println("Enter the '" + parameterName + "' :");
            try {
                theScannedValue = aScanner.nextInt();
                //ignore min and max validation
                if((minVal == -1 && maxVal == -1))
                    scannedSuccessfuly = true;
                else if (theScannedValue >= minVal && theScannedValue <= maxVal)
                    scannedSuccessfuly = true;
                else
                    System.out.println("The '" + parameterName + "' MUST be between " + minVal +" and " + maxVal +"!");

            } catch (Exception e) {
                System.out.println("The '" + parameterName + "' MUST have integer value !");
                //in case of error we MUST read the next line
                aScanner.nextLine();
            }
        }
        return theScannedValue;
    }

    /**
     * Scans a string type input including value validation
     *
     * @param aScanner      - the scanner object in order to prevent creation again and again
     * @param parameterName - the name of the parameter to be scanned, it will be presented to the end user
     * @param allowEmpty    - true if empty value is valid
     * @return - the validated string value
     */
    static String scanString(Scanner aScanner, String parameterName, boolean allowEmpty) {
        String theScannedValue = "";
        boolean scannedSuccessfuly = false;

        //scan until a valid value entered
        while (!scannedSuccessfuly) {
            System.out.println("Enter the '" + parameterName + "' :");
            theScannedValue = aScanner.nextLine();
            if (!allowEmpty && (theScannedValue == null || theScannedValue.trim().length() == 0))
                System.out.println("The '" + parameterName + "' MUST have value !");
            else
                scannedSuccessfuly = true;
        }
        return theScannedValue;
    }

    /**
     * Scans an e-mail type input value including validation
     *
     * @param aScanner - the scanner object in order to prevent creation again and again
     * @return - the validated double value
     */
    static String scanEmail(Scanner aScanner) {
        String email = null;
        boolean validEmailAddress = false;

        //read until a valid e-mail supplied
        while (!validEmailAddress) {
            System.out.println("Enter 'e-mail' :");
            email = aScanner.nextLine();

            //Validate the e-mail address
            try {
                ScannerHelper.emailValidator(email);
                validEmailAddress = true;
            } catch (InvalidEmailAddressException ieae) {
                System.out.println("The e-mail address '" + email + "' is invalid !");
            }
        }
        return email;
    }
}