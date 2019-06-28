import java.util.Collection;
import java.util.Random;
import java.util.Vector;

// A NoisyChannel is a new NoisyChannel(Integer)
// Interpretation: A channel for binary messages with some interference
public class NoisyChannel {
    Integer errors;

    NoisyChannel(Integer errors) {
        this.errors = errors;
    }

    // Converts a binary integer to a vector of binary characters
    static Vector<Integer> integerToVector(Integer num) {
        // Convert Integer to String
        String messageString = num.toString();

        // Convert the String to a Vector
        Vector messageVector = new Vector(messageString.length());
        for (int i = 0; i < messageString.length(); i++) {
            messageVector.add(Integer.parseInt(messageString.substring(i, i+1)));
        }

        return messageVector;
    }

    // Send a binary message (given as an Integer) through this channel
    public Vector<Integer> send(Integer intendedMessage) {
        // Convert Integer to String
        Vector<Integer> messageVector = NoisyChannel.integerToVector(intendedMessage);

        // Call send with the new Vector
        return this.send(messageVector);
    }

    // Send a binary message (given as a collection) through this channel
    public Vector<Integer> send(Collection intendedMessage) {

        // Randomly select which bits of the message will be erroneous
        Vector<Integer> errorIndexes = new Vector();
        for(Integer i = 0; i < this.errors; i++) {
            Random rand = new Random();
            Integer errorIndex = rand.nextInt(intendedMessage.size());
            if(errorIndexes.contains(errorIndex)) {
                i--;
            } else {
                errorIndexes.add(errorIndex);
            }
        }

        // Insert the erroneous bits
        Vector<Integer> sentVector = new Vector(intendedMessage);
        for (Integer index : errorIndexes) {
            Integer error = (sentVector.get(index) + 1) % 2;
            System.out.println(index);
            sentVector.removeElementAt(index);
            sentVector.insertElementAt(error, index);
        }

        // Return the now erroneous message
        return sentVector;
    }


}
