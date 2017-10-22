package padmelina.homework.hwfirst;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Main {
    public static void main(String[] args) {
        double[][] matrixData = { {1d,2d,3d}, {2d,5d,3d}};
        RealMatrix m = MatrixUtils.createRealMatrix(matrixData);

        double[][] matrixData2 = { {1d,2d}, {2d,5d}, {1d, 7d}};
        RealMatrix n = new Array2DRowRealMatrix(matrixData2);

        RealMatrix p = m.multiply(n);
        System.out.println(p.getRowDimension());
        System.out.println(p.getColumnDimension());

        RealMatrix pInverse = new LUDecomposition(p).getSolver().getInverse();
    }
}
