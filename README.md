# error-correcting-codes
A library for experimenting with error-correcting codes. 

This repository is very much a work in progress at the moment. When finished, this repository is intended to be used by anyone interested in error-correcting codes for educational purposes. This is not a library intended to be used to actually send secure messages across noisy channels.

# What are error-correcting codes?

Error-correcting codes are used to protect against and fix errors in messages sent through noisy channels. Essentially, error-correcting codes are a family of techniques that encode a message into a format that is able to be decoded into the original message despite a certain amount of errors introduced while the message is sending.

# What does this library do?

This library introduces classes that are able to encode a message, send a message through a noisy channel, and decode the erroneous message back to the original message (unless the channel introduces too many errors).

# How do I use this library?

Detailed documentation is a goal, but for now there are a few details that may help users understand this library.

Certain classes and methods in this library are intended to be used by all users, others are intended to be used to investigate what is happening 'behind the scenes', and some others are only used by myself and others who may want to build on top of this library (such as the matrix class created for this library).

The most fundamental tool of this library is the NoisyChannel class. A NoisyChannel object is able to introduce a set amount of errors into a message. At the moment, 'a message' refers to a vector of 1s and 0s, but being able to use other data types as messages is intend for the future.

There are many types of error-correcting codes, so each type implemented in this library will be contained in its own class. The only method included currently is a repetition code. So a RepetitionCode object can take care of encoding a message prior to being sent via a NoisyChannel object, then the same RepetitionCode object can decode the message. This is done as an example below.

        // Create a RepetitionCode object for 8 bit messages that repeats each bit 6 times
        RepetitionCode RC = new RepetitionCode(8, 6);
        // Create the message that will be used for this experiment
        Vector<Integer> BYTEMESSAGE = new Vector<>(8);
        BYTEMESSAGE.add(1);
        BYTEMESSAGE.add(0);
        BYTEMESSAGE.add(1);
        BYTEMESSAGE.add(0);
        BYTEMESSAGE.add(1);
        BYTEMESSAGE.add(0);
        BYTEMESSAGE.add(1);
        BYTEMESSAGE.add(0);
        // Encode the message using the RepetitionCode object
        Vector<Integer> ENCODEDBYTEMESSAGE = RC.encode(BYTEMESSAGE);
        // Create a NoisyChannel object that introduces 10 errors into messages sent via the channel
        NoisyChannel NC4RC = new NoisyChannel(10);
        // Send the encoded message through the noisy channel
        Vector<Integer> MESSYENCODEDBYTEMESSAGE = NC4RC.send(ENCODEDBYTEMESSAGE);
        // Decode the erroneous message using the same RepetitionCode object used to encode the message originally
        Vector<Integer> DECODEDBYTEMESSAGE = RC.decode(MESSYENCODEDBYTEMESSAGE);
        
# How can I add to this?

There are many types of error-correcting codes and I hope to include many of these types in this library, each as a class. If you are interested in error-correcting codes too, you might like to try implementing a type of error-correcting code into this library yourself. Otherwise, feel free to make suggestions to the existing code.

Thanks for looking into this project!
