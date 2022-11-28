import java.sql.PreparedStatement;

public class Pills extends Medicine{

    private int _numOfPillsInBox;

    public int getNumOfPillsInBox() {
        return _numOfPillsInBox;
    }

    public void setNumOfPillsInBox(int numOfPillsInBox) {
        this._numOfPillsInBox = numOfPillsInBox;
    }

    public Pills(String name, String companyName, String companyEmail,
                 double price, int quantity, int expirationYear,int numOfPillsInBox)
    {
        super(name,companyName,companyEmail,price,quantity,expirationYear,Type.PILLS);
        setNumOfPillsInBox(numOfPillsInBox);
    }

    @Override
    public int totalInventory() {
        return getQuantity() * getNumOfPillsInBox();
    }

    @Override
    public String toString()
    {
        String theResult = super.toString();
        theResult = theResult.concat("\nThe number of Pills in Box = ").concat(String.valueOf(getNumOfPillsInBox()));
        return theResult;
    }
}
