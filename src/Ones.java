public class Ones extends Matrix {
    private String label;
    Ones(float[][] Mmat, int Mrow, int Mcol) {
        super(Mmat, Mrow, Mcol);
        label = "Ones Matrix";
    }

    @Override
    public String getLabel() {
        return label;
    }
    @Override
    public void all_labels(){
        System.out.println(label);
        if (super.getLabel() != null) {
            super.all_labels();
        }
    }
}
