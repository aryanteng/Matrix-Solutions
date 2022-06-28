public class Check {
    Functions functions = new Functions();
    public boolean Column(Matrix a){
        if (a.getCol() == 1){
            return true;
        }
        return false;
    }
    public boolean Row(Matrix a){
        if (a.getRow() == 1){
            return true;
        }
        return false;
    }
    public boolean Diagonal(Matrix a){
        int d = 0;
        for(int i = 0; i < a.getRow(); i++){
            for(int j = 0; j < a.getCol(); j++){
                if (a.getMat()[i][j] != 0 && (i != j)) {
                    d++;
                    break;
                }
            }
        }
        if (d == 0){
            return true;
        }
        return false;
    }
    public boolean Identity(Matrix a){
        int id1 = 0;
        int id2 = 0;
        for(int i = 0; i < a.getRow(); i++){
            for(int j = 0; j < a.getCol(); j++){
                if (a.getMat()[i][j] != 0 && (i != j)) {
                    id2++;
                    break;
                }
                if (a.getMat()[i][j] != 1 && (i == j)) {
                    id1++;
                    break;
                }
            }
        }
        if (id1 == 0 && id2 == 0) {
            return true;
        }
        return false;
    }
    public boolean NullMatrix(Matrix a) {
        int nullmat = 0;
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                if (a.getMat()[i][j] != 0) {
                    nullmat++;
                    break;
                }
            }
        }
        if (nullmat == 0) {
            return true;
        }
        return false;
    }
    public boolean OnesMatrix(Matrix a){
        int onesmat = 0;
        for(int i = 0; i < a.getRow(); i++){
            for(int j = 0; j < a.getCol(); j++){
                if (a.getMat()[i][j] != 1){
                    onesmat++;
                    break;
                }
            }
        }
        if (onesmat == 0){
            return true;
        }
        return false;
    }
    public boolean Rectangular(Matrix a){
        if (a.getRow() > a.getCol() || a.getCol() > a.getRow()){
            return true;
        }
        return false;
    }
    public boolean Scalar(Matrix a){
        int s1 = 0;
        int s2 = 0;
        float element = a.getMat()[0][0];
        for(int i = 0; i < a.getRow(); i++){
            for(int j = 0; j < a.getCol(); j++){
                if (a.getMat()[i][j] != 0 && (i != j)) {
                    s2++;
                    break;
                }
                if (a.getMat()[i][j] != element && (i == j)) {
                    s1++;
                    break;
                }
            }
        }
        if (s1 == 0 && s2 == 0) {
            return true;
        }
        return false;
    }
    public boolean Singleton(Matrix a){
        if (a.getRow() == 1 && a.getCol() == 1){
            return true;
        }
        return false;
    }
    public boolean Singular(Matrix a) {
        Functions functions = new Functions();
        float det = functions.Determinant(a, a.getRow());
        if (det == 0) {
            return true;
        }
        return false;
    }
    public boolean Lower_Triangular(Matrix a){
        int lt = 0;
        for(int i = 0; i < a.getRow(); i++){
            for(int j = i+1 ; j < a.getCol(); j++){
                if (a.getMat()[i][j] != 0) {
                    lt++;
                    break;
                }
            }
        }
        if (lt == 0){
            return true;
        }
        return false;
    }
    public boolean Upper_Triangular(Matrix a){
        int ut = 0;
        for(int i = 0; i < a.getRow(); i++){
            for(int j = 0 ; j < i; j++){
                if (a.getMat()[i][j] != 0) {
                    ut++;
                    break;
                }
            }
        }
        if (ut == 0){
            return true;
        }
        return false;
    }
    public boolean SquareMatrix(Matrix a){
        if (a.getRow() == a.getCol()){
            return true;
        }
        return false;
    }
    public boolean Symmetric(Matrix a){
        Matrix t = functions.Transpose(a);
        if (a.getMat().length == 2){
            if (a.getMat()[0][1] == t.getMat()[0][1]){
                return true;
            }
        }
        else if (a.getMat().length == 3) {
            if (a.getMat()[0][1] == t.getMat()[0][1] && a.getMat()[0][2] == t.getMat()[0][2] && a.getMat()[1][2] == t.getMat()[1][2]) {
                return true;
            }
        }
        return false;
    }
    public boolean Skew_Symmetric(Matrix a){
        Matrix t = functions.Transpose(a);
        if (a.getMat().length == 2){
            if (a.getMat()[0][1] == -t.getMat()[0][1]){
                return true;
            }
        }
        else if (a.getMat().length == 3) {
            if (a.getMat()[0][1] == -t.getMat()[0][1] && a.getMat()[0][2] == -t.getMat()[0][2] && a.getMat()[1][2] == -t.getMat()[0][2]) {
                return true;
            }
        }
        return false;
    }
}

