public class Inhaler extends Medicine {
    private int _amountOfClicks;

    public int getAmountOfClicks() {
        return _amountOfClicks;
    }

    public void setAmountOfClicks(int amountOfClicks) {
        this._amountOfClicks = amountOfClicks;
    }

    public Inhaler(String name, String companyName, String companyEmail,
                 double price, int quantity, int expirationYear,int amountOfClicks)
    {
        super(name,companyName,companyEmail,price,quantity,expirationYear,Type.INHALER);
        setAmountOfClicks(amountOfClicks);
    }

    @Override
    public int totalInventory() {
        return getQuantity() * getAmountOfClicks();
    }


    @Override
    public String toString()
    {
        String theResult = super.toString();
        theResult = theResult.concat("\nThe amount of clicks = ").concat(String.valueOf(getAmountOfClicks()));
        return theResult;
    }
}