import java.util.Collection;
import java.util.Vector;

// A ReedMullerCode is a new ReedMullerCode(Integer, Integer)
// Interpretation: A Reed Muller code used for error-correcting
public class ReedMullerCode implements ECC {
    Integer r;
    Integer m;

    ReedMullerCode(Integer r, Integer m) {
        this.r = r;
        this.m = m;
    }

    // Creates a generator Matrix
    public Matrix generate() {
        Vector<Integer> generatorVals = new Vector<Integer>();

        // Add values for first vector of all 1s
        for(Integer i = 0; i < (Math.pow(2, this.m)); i++) {
            generatorVals.add(1);
        }

        // Add values for next m vectors containing alternating groups of 1s and 0s, doubling in size each vector
        for(Integer i = 0; i < this.m; i++) {
            Double bitGroup = Math.pow(2, i);
            for(Integer j = 0; j < (Math.pow(2, this.m))/bitGroup; j++) {
                for(Integer k = 0; k < bitGroup; k++) {
                    generatorVals.add((j + 1) % 2);
                }
            }
        }

        // Add values for remaining vectors containing wedge products of the vectors in the previous section
        Integer h = 0;
        for(Integer i = 0; i < this.m; i++) {
            for(Integer j = i + 1; j < this.m; j++) {
                for(Integer k = 0; k < (Math.pow(2, this.m)); k++) {
                    Integer firstVectorIndex = (int) ((Math.pow(2, this.m) * (1 + i)) + k);
                    Integer secondVectorIndex = (int) ((Math.pow(2, this.m) * (1 + j)) + k);
                    if (generatorVals.elementAt(firstVectorIndex) == generatorVals.elementAt(secondVectorIndex)) {
                        generatorVals.add(generatorVals.elementAt(firstVectorIndex));
                    } else {
                        generatorVals.add(0);
                    }
                }
                h++;
            }
        }

        // Return Generator matrix
        return new Matrix(generatorVals, this.m + 1 + h);
    }

    // Creates a CodeBook
    public Matrix codeBook() {
        return null;
    }

    // Encodes a collection message
    public Vector<Integer> encode(Vector message) {
        return null;
    }

    // Decodes a collection message
    public Vector<Integer> decode(Vector encodedMessage) {
        return null;
    }

}
