import java.util.Vector;

// An ECCPipeline is a new ECCPipeline(NoisyChannel, ECC)
// Interpretation: A communication environment that has a noisy channel and error-correcting code
public class ECCPipeLine {
    NoisyChannel channel;
    ECC code;

    ECCPipeLine(NoisyChannel channel, ECC code) {
        this.channel = channel;
        this.code = code;
    }

    // Encodes, sends, and decodes a message
    public Vector<Integer> process(Vector message) {
        Vector encodedMessage = this.code.encode(message);
        Vector sentMessage = this.channel.send(encodedMessage);
        return this.code.decode(sentMessage);
    }
}
