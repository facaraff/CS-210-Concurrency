package lecture19;

import org.multiverse.api.StmUtils;
import org.multiverse.api.references.*;


public class BinaryArray {
	
	private TxnBoolean[] array;
	
	private int length;
	
	BinaryArray(int length){
		this.length = length;
		this.array = new TxnBoolean[length];
		for(int i=0; i<length; i++)
			array[i] = StmUtils.newTxnBoolean(false);
	}
	
	public int getLength(){
		return length;
	}
	
	private boolean getStateAtIndex(int Id){
		return array[Id].get();
	}
	
	private boolean setStateAtIndex(int Id, boolean value){
		return array[Id].set(value);
	}
	
	public boolean atomicGetStateAtIndex(int Id){
		return array[Id].atomicGet();
	}
	
	public boolean atomicSetStateAtIndex(int Id, boolean value){
		return array[Id].atomicSet(value);
	}

	public void atomicSwap(BinaryArray destination, int originId, int destId){
		StmUtils.atomic(() -> swap(destination, originId, destId));
	}
	
	private void swap(BinaryArray destination, int originId, int destId){
		boolean currentOrig = getStateAtIndex(originId);
		boolean currentDest = destination.getStateAtIndex(destId);
		setStateAtIndex(originId, currentDest);
		destination.setStateAtIndex(destId, currentOrig);
	}
}