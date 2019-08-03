import java.util.Collection;
import java.util.Vector;

// A RepetitionCode is a new RepetitionCode(Integer, Integer)
// Interpretation: A Repetition code used for error-correcting
public class RepetitionCode implements ECC {
    Integer messageLength;
    Integer n;

    RepetitionCode(Integer messageLength, Integer n){
        this.messageLength = messageLength;
        this.n = n;
    }

    // Creates a Generator Matrix
    public Matrix generate() {
        Vector<Integer> generatorVals = new Vector<>(this.n);
        for(Integer i = 0; i < this.n; i++) {
            generatorVals.add(1);
        }
        return new Matrix(generatorVals, 1);
    }

    // Creates a CodeBook
    public Matrix codeBook() {
        Vector<Integer> codeBookValues = new Vector<Integer>(this.n*2);
        for(Integer i = 0; i < this.n; i++) {
            codeBookValues.add(1);
        }
        for(Integer i = 0; i < this.n; i++) {
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
        Matrix verticalVector = new Matrix(message, this.messageLength);
        return verticalVector.mult(this.generate()).toVector();
    }

    // Decodes a collection message
    public Vector<Integer> decode(Vector encodedMessage) {
        Matrix messyMessage = new Matrix(encodedMessage, this.messageLength);
        Vector<Integer> cleanMessageVector = new Vector(this.messageLength * this.n);
        //System.out.println(messyMessage.rowValues());
        for (Integer i = 0; i < messyMessage.rows; i++) {
            //System.out.println(this.generate().closestRow(messyMessage.rowValues().elementAt(i)).firstElement());
            //System.out.println(this.generate().closestRow(messyMessage.rowValues().elementAt(i)));
            //System.out.println(messyMessage.rowValues().elementAt(i));
            //System.out.println(this.generate().rowValues());
            cleanMessageVector.add(this.codeBook().closestRow(messyMessage.rowValues().elementAt(i)).firstElement());
        }
        return cleanMessageVector;
    }
}
