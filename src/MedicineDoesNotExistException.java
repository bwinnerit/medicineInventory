public class MedicineDoesNotExistException extends Exception
{
    /**
     * To be thrown if a searched Medicine does not exist in the inventory
     * @param theName
     */
    public MedicineDoesNotExistException(String theName)
    {
        System.out.println("ERROR :: The '" + theName + "' medicine does dot exist in the Inventory");
    }
}
