package baseline;


public class itemgettersetter {
    private String SerialNumber;
    private String Name;
    private int Value;



    public String getSerialNumber(){
        return SerialNumber;
    }
    public void setSerialNumber(String SerialNumber){
        this.SerialNumber=SerialNumber;
    }

    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }


    public void setValue(int Value){
        this.Value=Value;
    }
    public int getValue(){
        return Value;
    }

    public itemgettersetter(String SerialNumber, String Name, int Value){
        this.setSerialNumber(SerialNumber);
        this.setName(Name);
        this.setValue(Value);
    }
    @Override
    public String toString(){
        //returns the input from text box to readable string for date and description
        return this.getSerialNumber() + " "+ this.getName() ;

    }
}
