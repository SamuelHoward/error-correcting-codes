import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");


        // Testing NoisyChannel
        /*
        NoisyChannel testChannel = new NoisyChannel(2);
        Vector testVector = new Vector();
        testVector.add(1);
        testVector.add(1);
        testVector.add(1);
        testVector.add(0);
        testVector.add(0);
        testVector.add(0);
        testVector.add(1);
        testVector.add(1);
        testVector.add(1);
        System.out.println("Sent Message:");
        System.out.println(testVector);
        System.out.println("Recieved Message:");
        System.out.println(testChannel.send(testVector));

        Integer testInteger = 111000111;
        System.out.println("Sent Message:");
        System.out.println(testInteger);
        System.out.println("Recieved Message:");
        System.out.println(testChannel.send(testInteger));

        // Testing rowValues
        Matrix testMatrix = new Matrix(testVector, 3);
        System.out.println(testMatrix);
        System.out.println(testMatrix.values);
        System.out.println(testMatrix.rowValues());

        Matrix testMatrix2 = new Matrix(testVector, 3, 3);
        System.out.println(testMatrix2);
        System.out.println(testMatrix2.values);
        System.out.println(testMatrix2.rowValues());

        Vector<Vector<Integer>> test2DVector = new Vector(3);
        test2DVector.add(testVector);
        test2DVector.add(testVector);
        test2DVector.add(testVector);
        Matrix testMatrix3 = new Matrix(test2DVector);
        System.out.println(testMatrix3);
        System.out.println(testMatrix3.values);
        System.out.println(testMatrix3.rows);
        System.out.println(testMatrix3.columns);
        System.out.println(testMatrix3.rowValues());





        // Testing Mult
        Vector testVectorA = new Vector();
        testVectorA.add(1);
        testVectorA.add(1);
        testVectorA.add(0);
        testVectorA.add(0);
        testVectorA.add(1);
        testVectorA.add(0);
        testVectorA.add(1);
        testVectorA.add(1);
        testVectorA.add(1);
        Matrix testMatrixA = new Matrix(testVectorA, 3);

        Vector testVectorB = new Vector();
        testVectorB.add(1);
        testVectorB.add(0);
        testVectorB.add(1);
        testVectorB.add(1);
        testVectorB.add(0);
        testVectorB.add(0);
        testVectorB.add(0);
        testVectorB.add(1);
        testVectorB.add(0);
        Matrix testMatrixB = new Matrix(testVectorB, 3);
        Matrix testMatrixC = testMatrixA.mult(testMatrixB);
        System.out.println(testMatrixC.rowValues());
        Matrix testMatrixD = testMatrixA.mult(testMatrixA);
        System.out.println(testMatrixD.rowValues());
        Matrix testMatrixE = testMatrixB.mult(testMatrixB);
        System.out.println(testMatrixE.rowValues());
        Matrix testMatrixF = testMatrixB.mult(testMatrixA);
        System.out.println(testMatrixF.rowValues());


        Vector testVectorC = new Vector();
        testVectorC.add(1);
        testVectorC.add(0);
        testVectorC.add(0);
        testVectorC.add(1);
        testVectorC.add(1);
        testVectorC.add(0);
        Matrix testMatrixG = new Matrix(testVectorC, 2);

        Vector testVectorD = new Vector();
        testVectorD.add(1);
        testVectorD.add(0);
        testVectorD.add(0);
        testVectorD.add(1);
        testVectorD.add(1);
        testVectorD.add(1);
        testVectorD.add(1);
        testVectorD.add(0);
        testVectorD.add(1);
        testVectorD.add(1);
        testVectorD.add(0);
        testVectorD.add(0);
        Matrix testMatrixH = new Matrix(testVectorD, 3);

        Matrix testMatrixI = testMatrixG.mult(testMatrixH);
        System.out.println(testMatrixI.rowValues());

        // Testing toBinary
        System.out.println(testMatrixI.rowValues());
        System.out.println(testMatrixI.toBinary().rowValues());

        */
        // Testing RepetitionCode
        RepetitionCode RC1 = new RepetitionCode(1, 5);
        System.out.println(RC1.generate().values);

        System.out.println(RC1.encode(1));
        System.out.println(RC1.encode(0));
        Vector<Integer> oneVector = new Vector<Integer>(1);
        oneVector.add(1);
        System.out.println(RC1.encode(oneVector));
        Vector<Integer> zeroVector = new Vector<Integer>(0);
        zeroVector.add(0);
        System.out.println(RC1.encode(zeroVector));

        RepetitionCode RC2 = new RepetitionCode(2, 5);
        Vector<Integer> oneZeroVector = new Vector<Integer>(2);
        oneZeroVector.add(1);
        oneZeroVector.add(0);
        System.out.println(RC2.generate().values);
        System.out.println(oneZeroVector);
        System.out.println(RC2.encode(oneZeroVector));
        Vector<Integer> oneOneVector = new Vector<Integer>(2);
        oneOneVector.add(1);
        oneOneVector.add(1);
        System.out.println(oneOneVector);
        System.out.println(RC2.encode(oneOneVector));
        Vector<Integer> zeroZeroVector = new Vector<Integer>(2);
        zeroZeroVector.add(0);
        zeroZeroVector.add(0);
        System.out.println(RC2.encode(zeroZeroVector));
        Vector<Integer> zeroOneVector = new Vector<Integer>(2);
        zeroOneVector.add(0);
        zeroOneVector.add(1);
        System.out.println(RC2.encode(zeroOneVector));

        RepetitionCode RC3 = new RepetitionCode(8, 3);
        Vector<Integer> byteVector = new Vector<Integer>(8);
        byteVector.add(0);
        byteVector.add(0);
        byteVector.add(1);
        byteVector.add(0);
        byteVector.add(1);
        byteVector.add(1);
        byteVector.add(1);
        byteVector.add(0);
        System.out.println(RC3.encode(byteVector));

        // Testing diffEntries
        Vector<Integer> v1 = new Vector<>(5);
        v1.add(1);
        v1.add(0);
        v1.add(1);
        v1.add(1);
        v1.add(0);
        Vector<Integer> v2 = new Vector<>(5);
        v2.add(1);
        v2.add(0);
        v2.add(0);
        v2.add(0);
        v2.add(0);
        System.out.println(NoisyChannel.diffEntries(v1, v2));
        System.out.println(NoisyChannel.diffEntries(v1, v1));
        System.out.println(NoisyChannel.diffEntries(v2, v2));
        System.out.println(NoisyChannel.diffEntries(v2, v1));

        // testing closestRow
        Vector<Integer> testCodeBookValues = new Vector<Integer>(6);
        testCodeBookValues.add(1);
        testCodeBookValues.add(1);
        testCodeBookValues.add(1);
        testCodeBookValues.add(0);
        testCodeBookValues.add(0);
        testCodeBookValues.add(0);
        Matrix testCodeBook = new Matrix(testCodeBookValues, 2);
        Vector<Integer> testCode1 = new Vector<Integer>(3);
        testCode1.add(1);
        testCode1.add(0);
        testCode1.add(1);
        Vector<Integer> testCode2 = new Vector<Integer>(3);
        testCode2.add(0);
        testCode2.add(0);
        testCode2.add(1);
        System.out.println(testCodeBook.closestRow(testCode1));
        System.out.println(testCodeBook.closestRow(testCode2));

        // Testing codeBook
        System.out.println(RC1.codeBook().rowValues());
        System.out.println(RC2.codeBook().rowValues());
        System.out.println(RC3.codeBook().rowValues());
    }

}
