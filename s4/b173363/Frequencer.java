package s4.b173363; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;

public class Frequencer implements FrequencerInterface{
    // Code to start with: This code is not working, but good start point to work.
    byte [] myTarget;
    byte [] mySpace;
    boolean targetReady = false;
    boolean spaceReady = false;
    int [] suffixArray;//文字列の開始位置を記憶
    
    // The variable, "suffixArray" is the sorted array of all suffixes of mySpace.
    // Each suffix is expressed by a interger, which is the starting position in mySpace. // The following is the code to print the variable
    
    private void printSuffixArray() {//SuffixArrayの出力
        if(spaceReady) {
            for(int i=0; i< mySpace.length; i++) {
                int s = suffixArray[i];
                for(int j=s;j<mySpace.length;j++) {
                    System.out.write(mySpace[j]); }
                System.out.write('\n'); }
        }
    }
    
    private int suffixCompare(int i, int j) {//Suffix同士の比較
        
	int s1=suffixArray[i];
	int s2=suffixArray[j];
        int s=0;
        if(s1 > s) s=s1;
        if(s2 > s) s=s2;
        int n = mySpace.length - s;//spaceの長さと長い方のsuffixの長さのさを取る
	for(int k=0;k<n;k++) {
	    if(mySpace[s1+k]>mySpace[s2+k]) return 1;
	    if(mySpace[s1+k]<mySpace[s2+k]) return -1;
	}
	if(s1 < s2) return 1;
	if(s1 > s2) return -1;
	return 0;
    }

    public void Swap(int i, int j){
	int tmp = suffixArray[i];
	suffixArray[i] = suffixArray[j];
	suffixArray[j] = tmp;
    }

    public void quickSort(int l, int r){
	int left = l;
	int right = r;
	int pivot = l;
	
	while(true){
	    while(suffixCompare(pivot, left)>0){ left++; }
	    while(suffixCompare(pivot, right)<0){ right--; }
	    if(left >= right) break;
	    Swap(left, right);
	    left++;
	    right--;
	}
	if(left-l >= 2){
	    quickSort(l, left-1);
	}
	if(r-right >= 2){
	    quickSort(right+1, r);
	}
	
    }
	
    
    public void setSpace(byte []space) {
	mySpace = space;
	if(mySpace != null){
	    if(mySpace.length>0){
		spaceReady = true;
		suffixArray = new int[space.length];
		// put all suffixes in suffixArray. Each suffix is expressed by one interger.
		for(int i = 0; i< space.length; i++) {
		    suffixArray[i] = i;
		}
		quickSort(0, space.length-1);
	    }
	}
	// Sorting is not implmented yet. /* Example from "Hi Ho Hi Ho"
	//printSuffixArray();
    }


    private int targetCompare(int i, int j, int end) {
	// comparing suffix_i and target_j_end by dictonary order with limitation of length;
	// if the beginning of suffix_i matches target_i_end, and suffix is longer than target it returns 0;
	// if suffix_i > target_i_end it return 1;
	// if suffix_i < target_i_end it return -1
	// It is not implemented yet.
	// It should be used to search the apropriate index of some suffix. // Example of search
	// suffix
	// "o"
	// "o"
	// "o"
	// "o"
	// "Ho" // "Ho" // "Ho" //"Ho" // "Ho" return 0;
        
        int s1=suffixArray[i];
        int s2=end-j;

	if(mySpace.length == 0) return 0;
        if(s2 > mySpace.length - s1) return -1;
        int n = end-j;

        for(int k=0;k<n;k++) {
	    if(s1+k <= mySpace.length-1){
		if(mySpace[s1+k]>myTarget[j+k]) return 1;
		if(mySpace[s1+k]<myTarget[j+k]) return -1;
	    }else{ return -1; }
        }
        return 0;
    }
    

    private int subByteStartIndex(int start, int end) {
	// It returns the index of the first suffix which is equal or greater than subBytes; // not implemented yet;
	// For "Ho", it will return 5 for "Hi Ho Hi Ho".
	// For "Ho ", it will return 6 for "Hi Ho Hi Ho".

	int l = 0;
	int r =mySpace.length-1;
	int mid;

	while(l <= r){
	    mid = (l + r)/2;
	    if(targetCompare(mid,start,end)==0){
		do{
		    mid--;
		    if(mid<0) return 0;
		}while(targetCompare(mid,start,end)==0);
		return mid+1;
	    }else if(targetCompare(mid,start,end)>0){ r = mid-1;
	    }else{ l = mid+1;}
	}

	return suffixArray.length;
    }

	private int subByteEndIndex(int start, int end) {
	    // It returns the next index of the first suffix which is greater than subBytes; // not implemented yet
	    // For "Ho", it will return 7 for "Hi Ho Hi Ho".
	    // For "Ho ", it will return 7 for "Hi Ho Hi Ho".

	    int l = 0;
	    int r = mySpace.length-1;
	    int mid;

	    //System.out.println(mySpace.length);
 
	    while(l <= r){
		mid = (l + r)/2;
		// System.out.println("mid=" + mid);
		if(targetCompare(mid,start,end)==0){
		    do{
			mid++;
			if(mid>mySpace.length-1) return mySpace.length;	 
		    }while(targetCompare(mid,start,end)==0);
		    return mid;
		}else if(targetCompare(mid,start,end)>0){ r = mid-1;
		}else{ l = mid+1;}
	    }
    
	    return suffixArray.length;
	}

    public int subByteFrequency(int start, int end) {
	/* This method could be defined as follows though it is slow.*/
	int spaceLength = mySpace.length;
	int count = 0;
	for(int offset = 0; offset< spaceLength - (end - start); offset++) {
	    boolean abort = false;
	    for(int i = 0; i< (end - start); i++) {
		if(myTarget[start+i] != mySpace[offset+i]) { abort = true; break; } }
	    if(abort == false) { count++; } }
 
	int first = subByteStartIndex(start,end);
	int last1 = subByteEndIndex(start, end);
	/* inspection code*/
	//for(int k=start;k<end;k++) { System.out.write(myTarget[k]); }
	//System.out.printf(": first=%d last1=%d\n", first, last1);
 
	return last1 - first;
    }
    public void setTarget(byte [] target) {
	myTarget = target;
	if( myTarget != null){
	    if(myTarget.length>0) targetReady = true;
	}
    }
    public int frequency() {
	if(targetReady == false) return -1; if(spaceReady == false) return 0;
	return subByteFrequency(0, myTarget.length);
    }

    public static void main(String[] args) { Frequencer frequencerObject;
	try {
    
	    frequencerObject = new Frequencer();
	    frequencerObject.setSpace("Hi Ho Hi Ho".getBytes());
	    //frequencerObject.setSpace(null);
	    frequencerObject.setTarget("H".getBytes());
	    //frequencerObject.setTarget(null);
	    int result = frequencerObject.frequency();
	    System.out.print("Freq = "+ result+" ");
	    if(4 == result) { System.out.println("OK"); }
	    else {System.out.println("WRONG"); }
    

	}
	catch(Exception e) {
	    System.out.println("STOP"); }
    } }
