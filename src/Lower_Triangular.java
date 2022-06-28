public class Lower_Triangular extends Square{
    private String label;
    Lower_Triangular(float[][] Mmat, int Mrow, int Mcol) {
        super(Mmat, Mrow, Mcol);
        label = "Lower Triangular Matrix";
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
