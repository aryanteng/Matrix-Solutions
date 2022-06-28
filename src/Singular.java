public class Singular extends Square{
    private String label;
    Singular(float[][] Mmat, int Mrow, int Mcol) {
        super(Mmat, Mrow, Mcol);
        label = "Singular Matrix";
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
