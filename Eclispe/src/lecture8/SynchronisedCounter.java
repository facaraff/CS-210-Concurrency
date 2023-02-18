package lecture8;

import lecture6.Counter;
import lecture6.Simulate;

//This class has it's a copy of the class Counter, but we are overriding the increment method to synchronise it.
public class SynchronisedCounter extends Counter {

    SynchronisedCounter() {
        super();
    }
    
    @Override
    public synchronized void increment(){
        int temp = getValue(); //read value
        Simulate.HWInterrupt();
        setValue(temp + 1); // set value
    }
}
