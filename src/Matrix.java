import java.util.Vector;

// A Matrix is a new Matrix(Vector<Vector<Integer>>)
// Alternative: A Matrix<Integer> is a new Matrix(Vector<Integer>, Integer, Integer)
// Alternative: A Matrix<Integer> is a new Matrix(Vector<Integer>, Integer)
// Interpretation: A Matrix for use with error-correcting codes
public class Matrix {
    Vector<Vector<Integer>> values;
    Integer rows;
    Integer columns;

    Matrix(Vector<Vector<Integer>> values) {
        this.values = values;
        this.rows = values.firstElement().size();
        this.columns = values.size();
    }

    Matrix(Vector<Integer> values, Integer rows, Integer columns) {
        this.values = new Vector<Vector<Integer>>(columns);
        for(Integer i = 0; i < columns; i++) {
            Vector<Integer> currentColumn = new Vector<Integer>(rows);
            for(Integer j = 0; j < rows; j++) {
                currentColumn.add(values.elementAt(i + j*columns));
            }
            this.values.add(currentColumn);
        }
        this.rows = rows;
        this.columns = columns;
    }

    Matrix(Vector<Integer> values, Integer rows) {
        Integer columns = values.size()/rows;
        this.values = new Vector<Vector<Integer>>(columns);
        for(Integer i = 0; i < columns; i++) {
            Vector<Integer> currentColumn = new Vector<Integer>(rows);
            for(Integer j = 0; j < rows; j++) {
                currentColumn.add(values.elementAt(i + j*columns));
            }
            this.values.add(currentColumn);
        }
        this.rows = rows;
        this.columns = columns;
    }

    // Access the rows of a matrix
    public Vector<Vector<Integer>> rowValues() {
        Vector<Vector<Integer>> rowVals = new Vector<Vector<Integer>>(this.rows);
        for(Integer i = 0; i < this.rows; i++) {
            Vector<Integer> currentRow = new Vector<Integer>(this.columns);
            for(Integer j = 0; j < this.columns; j++) {
                currentRow.add(this.values.elementAt(j).elementAt(i));
            }
            rowVals.add(currentRow);
        }
        return rowVals;
    }

    // Multiply this matrix and the given matrix
    public Matrix mult(Matrix that) {
        Vector<Integer> productValues = new Vector<Integer>(this.rows * that.columns);
        for(Integer i = 0; i < this.rows; i++) {
            Vector<Integer> ARow = this.rowValues().elementAt(i);
            for(Integer j = 0; j < that.columns; j++) {
                Vector<Integer> BColumn = that.values.elementAt(j);
                Integer currentEntry = 0;
                for (Integer k = 0; k < this.columns; k++) {
                    currentEntry += ARow.elementAt(k) * BColumn.elementAt(k);
                }
                productValues.add(currentEntry);
            }
        }
        return new Matrix(productValues, this.rows);
    }

    // Convert this matrix to binary
    public Matrix toBinary() {
        Vector<Integer> binaryValues = new Vector<Integer>(this.rows * this.columns);
        for(Integer i = 0; i < this.columns; i++) {
            for(Integer j = 0; j < this.rows; j++) {
                Integer newEntry = this.values.elementAt(i).elementAt(j) % 2;
                binaryValues.add(newEntry);
            }
        }
        return new Matrix(binaryValues, this.rows);
    }

    // Convert this matrix to a vector
    public Vector<Integer> toVector() {
        Vector<Integer> result = new Vector<Integer>(this.rows*this.columns);
        for(Integer i = 0; i < this.rows; i++) {
            for (Integer j = 0; j < this.columns; j++) {
                result.add(this.values.elementAt(j).elementAt(i));
            }
        }
        return result;
    }

    // Finds the row in this matrix that is closest to the given vector
    public Vector<Integer> closestRow(Vector<Integer> message) {
        Integer closestIndex = 0;
        Integer diffMin = message.size();
        for(Integer i = 0; i < this.rowValues().size(); i++) {
            if(NoisyChannel.diffEntries(this.rowValues().elementAt(i), message) < diffMin) {
                diffMin = NoisyChannel.diffEntries(this.rowValues().elementAt(i), message);
                closestIndex = i;
            }
        }
        return this.rowValues().elementAt(closestIndex);
    }

}
