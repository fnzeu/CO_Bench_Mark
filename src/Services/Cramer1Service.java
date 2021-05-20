package Services;

public class Cramer1Service {

    private long finalTimeout;

    private double[][] a = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},     /**Matrix of coefficinets **/
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {9, 1, 2, 3, 4, 5, 6, 7, 8},
    };

    private double[] b = {10, 20, 5, 2, 1, 0, 0, 10, 5};    /**Right part of eccuation **/

    /**
     * Calculate determinant using recursion.
     * Square matrix(2x2)- calculate determinant by "cross" method, else separate matrix for minors.
     * For every minor calculate itself determinant recursively.
     */

    private double getDeterminant(final double[][] M) {
        double Result = 0.0;
        if(M.length == 2) {
            Result = M[0][0] * M[1][1] - M[1][0] * M[0][1];
        }
        else {
            int coefficient = 1;
            for(int i=0, length=M.length; i<length; i++) {
                if(i%2==1)
                    coefficient=-1;
                else
                    coefficient=1;
                Result+=coefficient*M[0][i]*this.getDeterminant(this.getMinor(M, i));
            }
        }
        return Result;
    }

    private double[][] getMinor(final double[][] M, final int column) {
        int minorL=M.length-1;
        double[][] minor = new double[minorL][minorL];
        int dI=0;
        int dJ;
        for(int i=0; i<=minorL; i++) {
            dJ=0;
            for(int j=0; j<=minorL;j++)
                if(i==0)
                    dI=1;
                else if(j==column)
                    dJ=1;
                else
                    minor[i-dI][j-dJ]=M[i][j];
        }
        return minor;
    }

    public void solutionOfCramerSystem() {
        double[][] tmp=new double[a.length][a.length];
        double[] x=new double[a.length];
        double detA;
        long timeout = System.currentTimeMillis();
        detA = getDeterminant(a);
        for(int m=0, n=a.length; m<n; m++) {
            for(int i=0; i<n; i++)
                System.arraycopy(a[i], 0, tmp[i], 0, n);
            for(int j=0; j<n; j++)
                tmp[j][m]=b[j];
            x[m]=getDeterminant(tmp)/detA;
        }
        timeout=System.currentTimeMillis()-timeout;
        finalTimeout=finalTimeout+timeout;

    }

    public long getTimeout() {
        return finalTimeout;
    }

}
