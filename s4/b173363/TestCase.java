package s4.b173363; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //Otherwise, get the frequency of TAGET in SPACE
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    // For the incorrect value of START or END, the behavior is undefined.
}
*/

/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    void setSpace(byte space[]); // set data for sample space to computer probability
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// Otherwise, estimation of information quantity, 
}                        
*/


public class TestCase {
    public static void main(String[] args) {
	try {
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("checking s4.b173363.Frequencer");
	    myObject = new s4.b173363.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

	}catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {/*TARGET is not set(return -1)*/
	    FrequencerInterface  myObject1;
	    int freq1;
	    System.out.println("");
	    myObject1 = new s4.b173363.Frequencer();
	    myObject1.setSpace("Hi Ho Hi Ho".getBytes());
	    //myObject1.setTarget("".getBytes());
	    freq1 = myObject1.frequency();
	    System.out.print("\"\" in \"Hi Ho Hi Ho\" appears "+freq1+" times. ");
	    if(-1 == freq1) { System.out.println("TARGET is not set"); } else {System.out.println("WRONG"); }
	}catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {/*TARGET's length us zero(return -1)*/
	    FrequencerInterface  myObject2;
	    int freq2;
	    System.out.println("");
	    myObject2 = new s4.b173363.Frequencer();
	    myObject2.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject2.setTarget("".getBytes());
	    freq2 = myObject2.frequency();
	    System.out.print("\"\" in \"Hi Ho Hi Ho\" appears "+freq2+" times. ");
	    if(-1 == freq2) { System.out.println("TARGET's length is zero"); } else {System.out.println("WRONG"); }
	}catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {/*SPACE is not set(return 0)*/
	    FrequencerInterface  myObject3;
	    int freq3;
	    System.out.println("");
	    myObject3 = new s4.b173363.Frequencer();
	    //myObject3.setSpace("".getBytes());
	    myObject3.setTarget("H".getBytes());
	    freq3 = myObject3.frequency();
	    System.out.print("\"H\" in \"\" appears "+freq3+" times. ");
	    if(0 == freq3) { System.out.println("SPACE is not set"); } else {System.out.println("WRONG"); }
	    System.out.println();
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {/*SPACE's length is zero(return 0)*/
	    FrequencerInterface  myObject4;
	    int freq4;
	    System.out.println("");
	    myObject4 = new s4.b173363.Frequencer();
	    myObject4.setSpace("".getBytes());
	    myObject4.setTarget("H".getBytes());
	    freq4 = myObject4.frequency();
	    System.out.print("\"H\" in \"\" appears "+freq4+" times. ");
	    if(0 == freq4) { System.out.println("SPACE's length is zero"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	System.out.println();

	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.b173363.InformationEstimator");
	    myObject = new s4.b173363.InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());
	    myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0 "+value);
	    myObject.setTarget("01".getBytes());
	    value = myObject.estimation();
	    System.out.println(">01 "+value);
	    myObject.setTarget("0123".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0123 "+value);
	    myObject.setTarget("00".getBytes());
	    value = myObject.estimation();
	    System.out.println(">00 "+value);
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	    System.out.println();
	
	try {//the TARGET is not set(return 0.0)
	    InformationEstimatorInterface myObject1;
	    myObject1 = new s4.b173363.InformationEstimator();
	    myObject1.setSpace("3210321001230123".getBytes());
	    // myObject.setTarget("".getBytes());
	    double value1 = myObject1.estimation();
	    System.out.print(">  "+value1);
	    if(0.0 == value1) { System.out.println(" the TARGET is not set"); } else {System.out.println("WRONG"); }
	    System.out.println();
 	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {//the TARGET's length is zero(return 0.0)
	    InformationEstimatorInterface myObject2;
	    myObject2 = new s4.b173363.InformationEstimator();
	    myObject2.setSpace("3210321001230123".getBytes());
	    myObject2.setTarget("".getBytes());
	    double value2 = myObject2.estimation();
	    System.out.print(">  "+value2);
	    if(0.0 == value2) { System.out.println(" TARGET's length is zero"); } else {System.out.println("WRONG"); }
	    System.out.println();
    	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {//the true value is infinite(return Double.MAX_VALUE)
	    InformationEstimatorInterface myObject3;
	    myObject3 = new s4.b173363.InformationEstimator();
	    myObject3.setSpace("".getBytes());
	    myObject3.setTarget("012".getBytes());
	    double value3 = myObject3.estimation();
	    System.out.print(">012 "+value3);
	    if(Double.MAX_VALUE == value3) { System.out.println(" the true value is infinite"); } else {System.out.println(" WRONG"); }
	    System.out.println();
	}
    	catch(Exception e) {
    	    System.out.println("Exception occurred: STOP");
    	}
	
	try {//SPACE is not set(return Double.MAX_VALUE)
	    InformationEstimatorInterface myObject4;
	    myObject4 = new s4.b173363.InformationEstimator();
	    // myObject4.setSpace("".getBytes());
	    myObject4.setTarget("012".getBytes());
	    double value4 = myObject4.estimation();
	    System.out.print(">012 "+value4);
	    if(Double.MAX_VALUE == value4) { System.out.println(" SPACE is not set"); } else {System.out.println("WRONG"); }
	    System.out.println();
	}
    	catch(Exception e) {
    	    System.out.println("Exception occurred: STOP");
    	}

    }
}	    
	    
