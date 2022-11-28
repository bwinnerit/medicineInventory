public class Syrup extends Medicine{
    private int _bottleContent;

    public int getBottleContent() {
        return _bottleContent;
    }

    public void setBottleContent(int bottleContent) {
        this._bottleContent = bottleContent;
    }

    public Syrup(String name, String companyName, String companyEmail,
                 double price, int quantity, int expirationYear,int bottleContent)
    {
        super(name,companyName,companyEmail,price,quantity,expirationYear,Type.SYRUP);
        setBottleContent(bottleContent);
    }

    @Override
    public int totalInventory() {
        return getQuantity() * getBottleContent();
    }

    @Override
    public String toString()
    {
        String theResult = super.toString();
        theResult = theResult.concat("\nThe bottle content is = ").concat(String.valueOf(getBottleContent()));
        return theResult;
    }
}
