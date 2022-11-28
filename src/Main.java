import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Create inventory
        System.out.println("******* Create a new Inventory ********");
        Inventory myInventory = new Inventory();

        int numberOfMedicinesToCreate = ScannerHelper.scanInt("number of medicines to create",Consts.CONST_MIN_MEDICINES_TO_SCAN,Consts.CONST_MAX_MEDICINES_TO_SCAN);

        //create n new Medicines of each type and add all of them to the inventory
        System.out.println("\n******* Create " + numberOfMedicinesToCreate + " Medicines of each Type and add them to the Inventory ********");
        System.out.println("Please REMEMBER to test invalid e-mail address and adding an already existing Medicine !\n");

        //create Pills
        myInventory.createNewMedicines(Medicine.Type.PILLS, numberOfMedicinesToCreate);

        //create Syrups
        myInventory.createNewMedicines(Medicine.Type.SYRUP, numberOfMedicinesToCreate);

        //create Inhalers
        myInventory.createNewMedicines(Medicine.Type.INHALER, numberOfMedicinesToCreate);

        System.out.println("\n******* Search for a specific medicine name in the inventory ********");
        try {
            Medicine m = myInventory.searchMedicineByName("a");
            System.out.println(m.toString());
        }
        catch (Exception e){}


        System.out.println("\n******* Search for a non existing medicine name in the inventory ********");
        try {
            myInventory.searchMedicineByName("Syrup222").toString();
        }catch (Exception e){}

        System.out.println("\n******* Search for all medicines by type Inhaler ********");
        ArrayList<Medicine> allInhalers = myInventory.searchMedicineByType(Medicine.Type.INHALER);
        for(Medicine medicine : allInhalers)
        {
            System.out.println(medicine.toString());
        }

        System.out.println("\n******* Print all medicines in stock ********");
        ArrayList<Medicine> allInStock = myInventory.getMedicinesInStock();
        for(Medicine medicine : allInStock)
        {
            System.out.println(medicine.toString());
        }

        System.out.println("\n******* Print 1 medicine details in upper case (toUpperCase) ********");
        try {
            Medicine m = myInventory.searchMedicineByName("a");
            System.out.println(m.toString().toUpperCase());
        } catch (Exception e){}

        System.out.println("\n******* This is THE END of the test ! ********");
    }
}
