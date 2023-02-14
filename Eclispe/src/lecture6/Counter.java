package lecture6;

public class Counter {
    int value;

    //setters and getters
    public void setValue(int value) {this.value = value;}
    public int getValue(){return value;}
    
    

    public void increment(){
    	//read value
        int temp = value; 
        //If interrupted, you only look at the value but do not get to increment it - other threads might do that!
        Simulate.HWInterrupt(); 
        // set value
        value = temp + 1; 
    }
}
