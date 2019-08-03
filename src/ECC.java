import java.util.Vector;

// An ECC is an Error-correcting code
public interface ECC {

    // Creates a generator Matrix
    Matrix generate();

    // Creates a CodeBook
    Matrix codeBook();

    // Encodes a collection message
    Vector<Integer> encode(Vector message);

    // Decodes a collection message
    Vector<Integer> decode(Vector encodedMessage);
}
