package ds.oops;

/**
 * Number of ways to create the object
 */
public class WaysToCreateObject implements Cloneable{


    public static void main(String[] args) throws Exception{

        //Using new keyword
        WaysToCreateObject waysToCreateObject = new WaysToCreateObject();

        // using Class.forName()
        Class.forName("algorithms.oops.WaysToCreateObject").newInstance();

        //using clone
        waysToCreateObject.clone();

        // using deserialization
        
    }

}
