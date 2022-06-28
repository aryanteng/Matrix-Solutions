public class Upper_Triangular extends Square{
    private String label;
    Upper_Triangular(float[][] Mmat, int Mrow, int Mcol){
        super(Mmat, Mrow, Mcol);
        label = "Upper Triangular Matrix";
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
