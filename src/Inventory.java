import java.util.ArrayList;

/**
 * This Class holds the Medicines inventory
 */
public class Inventory {
    //Creates a new Medicine(s) ArrayList
    private ArrayList<Medicine> _allMedicines = new ArrayList();

    /**
     * Adds a new Medicine to the array list
     * @param newMedicine - to be added to the inventory
     * @throws MedicineAlreadyExistException -in case the Medicine already exist in the inventory
     */
    public void addMedicine(Medicine newMedicine) throws MedicineAlreadyExistException
    {
        //If the Medicine does not exist in the Inventory adds it
        if(!searchMedicineByNameAndType(newMedicine.getMedicineName(),newMedicine.getType()))
            _allMedicines.add(newMedicine);
        else
            //If the Medicine already exist in Inventory throws a new MedicineAlreadyExistException
            throw new MedicineAlreadyExistException(newMedicine);
    }

    /**
     * Searches a medicine according to its name and prints its totalInventory
     * HINT: Acamol can be pills and also syrup
     * @param theName - the medicine name to be searched
     * @param type - Medicine type to be searched
     * @return true if found, false if not
     */
    public boolean searchMedicineByNameAndType(String theName, Medicine.Type type)
    {
        boolean found = false;
        for(Medicine medicine:_allMedicines)
        {
            if(medicine.getMedicineName().equalsIgnoreCase(theName) &&
                    medicine.getType().equals(type))
            {
                //System.out.println(theName + " type : " + type + " found in list");
                found = true;
            }
        }
        return found;
    }

    /**
     * Search the first appearance of a medicine according to its name
     * @param theName - the name of the Medicine to be searched
     * @return - the found Medicine
     * @throws MedicineDoesNotExistException - if does not exist in the Inventory
     */
    public Medicine searchMedicineByName(String theName) throws MedicineDoesNotExistException
    {
        Medicine foundMedicine = null;
        for(Medicine medicine:_allMedicines)
        {
            if(medicine.getMedicineName().equalsIgnoreCase(theName))
            {
                System.out.println(theName + " found in list");
                foundMedicine = medicine;
            }
        }

        //if not found throw MedicineDoesNotExistException
        if(foundMedicine == null)
            throw new MedicineDoesNotExistException(theName);

        return foundMedicine;
    }

    /**
     * Search all medicines by type
     * @param type - the required Medicine.Type
     * @return - ArrayList of medicines by its type
     */
    public ArrayList<Medicine> searchMedicineByType(Medicine.Type type)
    {
        ArrayList<Medicine> myList = new ArrayList();
        for(Medicine medicine:_allMedicines)
        {
            if(medicine.getType().equals(type))
                myList.add(medicine);
        }
        return myList;
    }

    /**
     * Search all medicines in stock - i.e. quantity >0
     * @return - ArrayList of Medicines in stock
     */
    public ArrayList<Medicine> getMedicinesInStock()
    {
        ArrayList<Medicine> myList = new ArrayList();
        for(Medicine medicine:_allMedicines)
        {
            if(medicine.getQuantity() > 0)
                myList.add(medicine);
        }
        return myList;
    }

    /**
     * Creates some Medicines according to the supplied parameters
     *
     * @param medicineType          - The type of new Medicines to be created
     * @param numOfMedicineToCreate - The number of new MEdicines to be created
     */
    public void createNewMedicines(Medicine.Type medicineType, int numOfMedicineToCreate) {
        int numOfCreatedMedicines = 0;

        //run in a loop and create the required number of MEdicines
        while (numOfCreatedMedicines < numOfMedicineToCreate) {
            try {
                System.out.println("\nScan " + medicineType + " no. " + (numOfCreatedMedicines + 1) + "\n");
                //creates new Medicines per type and adds to the inventory
                addMedicine(ScannerHelper.scanNewMedicine(medicineType));
                numOfCreatedMedicines++;
            } catch (MedicineAlreadyExistException maee) {
                System.out.println("Please add a medicine with different name !");
            }
        }
    }
}