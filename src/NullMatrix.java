public class NullMatrix extends Matrix{
    private String label;
    NullMatrix(float[][] Mmat, int Mrow, int Mcol) {
        super(Mmat, Mrow, Mcol);
        label = "Null Matrix";
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
