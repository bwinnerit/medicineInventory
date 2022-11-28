public abstract class Medicine {
    private String  _medicineName;
    private String  _companyName;
    private String  _companyEmail;
    private double  _price;
    private int     _quantity; // number of boxes
    private int     _expirationYear; // in format YYYY
    private Type    _type;

    enum Type {
        PILLS,
        SYRUP,
        INHALER
    }

    public String getMedicineName() {
        return _medicineName;
    }

    public void setMedicineName(String medicineName)
    {
        this._medicineName = medicineName.toUpperCase();
    }

    public String getCompanyName() {
        return _companyName;
    }

    public void setCompanyName(String companyName) {
        this._companyName = companyName;
    }

    public String getCompanyEmail() {
        return _companyEmail;
    }


    public void setCompanyEmail(String companyEmail)
    {
        this._companyEmail = companyEmail;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        this._price = price;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        this._quantity = quantity;
    }

    public int getExpirationYear() {
        return _expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this._expirationYear = expirationYear;
    }

    private Medicine(){}

    public Medicine(String name, String companyName, String companyEmail,
                    double price, int quantity, int expirationYear, Type type)
    {
        setMedicineName(name);
        setCompanyName(companyName);
        setCompanyEmail(companyEmail);
        setPrice(price);
        setQuantity(quantity);
        setExpirationYear(expirationYear);
        setType(type);
    }

    public String toString()
    {
        String theResult = "Medicine Type = ".concat(getType().name());
        theResult = theResult.concat("\nMedicine Name = ").concat(getMedicineName());
        theResult = theResult.concat("\nCompany Name = ").concat(getCompanyName());
        theResult = theResult.concat("\nCompany e-mail = ").concat(getCompanyEmail());
        theResult = theResult.concat("\nPrice = ").concat(String.valueOf(getPrice()));
        theResult = theResult.concat("\nNumber of Boxes = ").concat(String.valueOf(getQuantity()));
        theResult = theResult.concat("\nExpiration Year = ").concat(String.valueOf(getExpirationYear()));

        return theResult;
    }

    /**
     * Hidden from external world in order to prevent initialization
     * @param type The Type of the Medicine
     */
    private void setType(Type type)
    {
        this._type = type;
    }

    public Type getType()
    {
        return this._type;
    }

    /**
     * an abstract method to calculate the total
     * inventory for each medicine type
     * (ex: 1 Acamol box has 50 pills,
     * if we have 1000 boxes = total 1000X50),
     * @return - calculated amount
     */
    public abstract int totalInventory();

    //true if quantity >0 else false
    public boolean inStock()
    {
        if(getQuantity() > 0)
            return true;
        else
            return false;
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

        // create  anew Medicine according to the supplied medicine type
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
            //This is the new look and feel of switch case
            case PILLS   -> newMedicine = new Pills(name, compName, email, price, quantity, expirationYear, numOfPillsInBox);
            case INHALER -> newMedicine = new Inhaler(name, compName, email, price, quantity, expirationYear, numOfPillsInBox);
            case SYRUP   -> newMedicine = new Syrup(name, compName, email, price, quantity, expirationYear, numOfPillsInBox);
        }
        return newMedicine;
    }
}
