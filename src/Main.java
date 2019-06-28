import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");


        // Testing NoisyChannel
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
    }
}
