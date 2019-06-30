import java.util.Collection;
import java.util.Vector;

// A RepetitionCode is a new RepetitionCode(Integer, Integer)
// Interpretation: A Repetition code used for error-correcting
public class RepetitionCode {
    Integer messageLength;
    Integer n;

    RepetitionCode(Integer messageLength, Integer n){
        this.messageLength = messageLength;
        this.n = n;
    }

    // Creates a Generator Matrix
    public Matrix generate() {
        Vector<Integer> generatorVals = new Vector<>(n);
        for(Integer i = 0; i < n; i++) {
            generatorVals.add(1);
        }
        return new Matrix(generatorVals, 1);
    }

    // Creates a CodeBook
    public Matrix codeBook() {
        Vector<Integer> codeBookValues = new Vector<Integer>(n*2);
        for(Integer i = 0; i < n; i++) {
            codeBookValues.add(1);
        }
        for(Integer i = 0; i < n; i++) {
            codeBookValues.add(0);
        }
        return new Matrix(codeBookValues, 2);
    }

    // Encodes an integer message
    public Vector<Integer> encode(Integer message) {
        Vector<Integer> messageVector = NoisyChannel.integerToVector(message);
        return this.encode(messageVector);
    }

    // Encodes a collection message
    public Vector<Integer> encode(Vector message) {
        Matrix verticalVector = new Matrix(message, messageLength);
        return verticalVector.mult(this.generate()).toVector();
    }

    // Decodes a message
}
