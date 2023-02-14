package lecture6;


public class Simulate {
    public static void HWInterrupt(){
        if (Math.random()>0.5) //50% probability of simulating an external interrupt request 
            Thread.yield(); //A hint to the scheduler that the current thread is willing to yield its current use of a processor. 
        //The scheduler is free to ignore this hint.  Yield is a heuristic attempt to improve relative progression between threads that would otherwise over-utilise a CPU

    }
}
