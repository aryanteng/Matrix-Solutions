public class Functions {
    public Matrix Addition(Matrix a, Matrix b) {
        float[][] c = new float[a.getRow()][a.getCol()];
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                c[i][j] = a.getMat()[i][j] + b.getMat()[i][j];
            }
        }
        return new Matrix(c, a.getRow(), a.getCol());
    }

    public Matrix Subtraction(Matrix a, Matrix b) {
        float[][] c = new float[a.getRow()][a.getCol()];
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                c[i][j] = a.getMat()[i][j] - b.getMat()[i][j];
            }
        }
        return new Matrix(c, a.getRow(), a.getCol());
    }

    public Matrix Multiplication(Matrix a, Matrix b) {
        float[][] c = new float[a.getRow()][b.getCol()];
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < b.getCol(); j++) {
                for (int k = 0; k < b.getRow(); k++) {
                    c[i][j] += a.getMat()[i][k] * b.getMat()[k][j];
                }
            }
        }
        return new Matrix(c, a.getRow(), b.getCol());
    }

    public Matrix Division(Matrix a, Matrix b) {
        float[][] c = new float[a.getRow()][a.getCol()];
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                c[i][j] = a.getMat()[i][j] / b.getMat()[i][j];
            }
        }
        return new Matrix(c, a.getRow(), a.getCol());
    }

    public Matrix Element_wise(Matrix a, Matrix b) {
        float[][] c = new float[a.getRow()][a.getCol()];
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < b.getRow(); j++) {
                c[i][j] = a.getMat()[i][j] * b.getMat()[i][j];
            }
        }
        return new Matrix(c, a.getRow(), a.getCol());
    }

    public Matrix Transpose(Matrix a) {
        float[][] c = new float[a.getRow()][a.getCol()];
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                c[i][j] = a.getMat()[j][i];
            }
        }
        return new Matrix(c, a.getRow(), a.getCol());
    }

    public void Row_wise_mean(Matrix a) {
        float[] mean = new float[a.getRow()];
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                mean[i] += a.getMat()[i][j];
            }
            mean[i] = mean[i] / a.getCol();
        }
        for (int i = 0; i < a.getRow(); i++) {
            System.out.println("Mean of Row " + i + ": " + mean[i]);
        }
    }

    public void Column_wise_mean(Matrix a) {
        float[] mean = new float[a.getCol()];
        for (int i = 0; i < a.getCol(); i++) {
            for (int j = 0; j < a.getRow(); j++) {
                mean[i] += a.getMat()[j][i];
            }
            mean[i] = mean[i] / a.getRow();
        }
        for (int i = 0; i < a.getCol(); i++) {
            System.out.println("Mean of Column " + i + ": " + mean[i]);
        }
    }

    public void Mean(Matrix a) {
        float sum = 0;
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                sum += a.getMat()[i][j];
            }
        }
        float mean = sum / (a.getRow() * a.getCol());
        System.out.println("Mean of Matrix: " + mean);
    }
    public float Determinant(Matrix a, int len) {
        float det = 0;
        if (len == 1) {
            det = a.getMat()[0][0];
            return det;
        }
        float[][] m = new float[len][len];
        Matrix M = new Matrix(m, len, len);
        int flag = 1;
        for (int i = 0; i < len; i++) {
            Cofactor(a, M, 0, i, len);
            det += flag * a.getMat()[0][i] * Determinant(M, len - 1);
            flag = -flag;
        }
        return det;
    }

    public Matrix Sum_of_Transpose(Matrix a) {
        float[][] t = new float[a.getRow()][a.getCol()];
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getRow(); j++) {
                t[i][j] = a.getMat()[j][i];
            }
        }
        Matrix T = new Matrix(t, a.getRow(), a.getCol());
        return Addition(a, T);

    }

    public void Cofactor(Matrix a, Matrix m, int x, int y, int len) {
        int p = 0;
        int q = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j != y && i != x) {
                    m.getMat()[p][q++] = a.getMat()[i][j];
                    if (q == len - 1) {
                        q = 0;
                        p++;
                    }
                }
            }
        }
    }

    public void Adjoint(Matrix a, Matrix adj) {
        if (a.getMat().length == 1) {
            adj.getMat()[0][0] = 1;
        }
        int flag = 1;
        float[][] mat = new float[a.getMat().length][a.getMat().length];
        Matrix M = new Matrix(mat, a.getMat().length, a.getMat().length);
        for (int i = 0; i < a.getMat().length; i++) {
            for (int j = 0; j < a.getMat().length; j++) {
                Cofactor(a, M, i, j, a.getMat().length);
                flag = ((i + j) % 2 == 0 ? 1 : -1);
                adj.getMat()[j][i] = flag * Determinant(M, a.getMat().length - 1);
            }
        }
    }

    public Matrix Inverse(Matrix a) {
        float[][] inverse = new float[a.getMat().length][a.getMat().length];
        float det = Determinant(a, a.getMat().length);
        if (det == 0) {
            System.out.println("This is a singular matrix and it does not have an Inverse!");
            return null;
        }
        float[][] adj = new float[a.getMat().length][a.getMat().length];
        Matrix A = new Matrix(adj, a.getMat().length, a.getMat().length);
        Adjoint(a, A);
        for (int i = 0; i < a.getMat().length; i++) {
            for (int j = 0; j < a.getMat().length; j++) {
                inverse[i][j] = adj[i][j] / det;
            }
        }
        return new Matrix(inverse, a.getMat().length, a.getMat().length);
    }

    public float UseScalar(Matrix a) {
        if (a.getRow() == 1 && a.getCol() == 1) {
            return a.getMat()[0][0];
        }
        return 0;
    }

    public Matrix LinearEquation(Matrix a, Matrix b) {
        Matrix inverse = Inverse(a);
        return Multiplication(inverse, b);
    }

    public float[] Eigen_Values(Matrix a) {
        if (a.getMat().length == 1) {
            return new float[]{a.getMat()[0][0]};
        }
        else if (a.getMat().length == 2) {
            float b, c, d, e, f, g;
            float B = a.getMat()[0][1];
            float D = a.getMat()[1][1];
            float A = a.getMat()[0][0];
            float C = a.getMat()[1][0];
            c = (a.getMat()[0][0] * a.getMat()[1][1]) - (a.getMat()[0][1] * a.getMat()[1][0]);
            b = (a.getMat()[0][0] + a.getMat()[1][1]);
            double sqrt = Math.sqrt(Math.pow(b, 2) - 4 * c);
            f = (float) (b - sqrt);
            d = (float) (b + sqrt);
            g = f / 2;
            e = d / 2;
            float[] result = {e, g};
            float y = e - A;
            float x = B;
            float r = (float) Math.sqrt(x * x + y * y);
            if (r > 0) {
                y /= r;
                x /= r;
            }
            else {
                y = D;
                x = e - D;
                r = (float) Math.sqrt(x * x + y * y);
                if (r > 0) {
                    y /= r;
                    x /= r;
                }
                else {
                    y = 0;
                    x = 1;
                }
            }
            System.out.println("Eigenvector: " + x + "," + y);
            y = g - A;
            x = B;
            r = (float) Math.sqrt(x * x + y * y);
            if (r > 0) {
                y /= r;
                x /= r;
            }
            else {
                y = C;
                x = g - D;
                r = (float) Math.sqrt(x * x + y * y);
                if (r > 0) {
                    y /= r;
                    x /= r;
                }
                else{
                    y = 1;
                    x = 0;
                }
            }
            System.out.println("Eigenvector: " + x + "," + y);
            return result;
        }
        return null;
    }
}





