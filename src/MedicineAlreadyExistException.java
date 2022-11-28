public class MedicineAlreadyExistException extends Exception
{
    //Empty hidden constructor
    private MedicineAlreadyExistException(){}

    /**
     * To be thrown if a Medicine to be added already exist in the inventory
     * @param theMedicine - The Medicine
     */
    public MedicineAlreadyExistException(Medicine theMedicine)
    {
        System.out.println("ERROR :: Medicine already exist in the Inventory \n'"+ theMedicine.toString() + "'");
    }
}
