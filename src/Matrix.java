public class Matrix {
    private float[][] mat;
    private int row;
    private int col;
    private String label;
    private String name;
    Matrix(float[][] Mmat, int Mrow, int Mcol){
        setMat(Mmat);
        setCol(Mcol);
        setRow(Mrow);
    }
    void display(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(getMat()[i][j] + " ");
            }
            System.out.println();
        }
    }
    public float[][] getMat() {
        return mat;
    }
    public void setMat(float[][] mat) {
        this.mat = mat;
    }
    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {this.row = row;}
    public int getCol() {return col;}
    public void setCol(int col) {this.col = col;}
    public String getLabel() {return label;}
    public void all_labels(){}
}
