public class Diagonal extends Symmetric{
    private String label;
    Diagonal(float[][] Mmat, int Mrow, int Mcol) {
        super(Mmat, Mrow, Mcol);
        label = "Diagonal Matrix";
    }
    @Override
    public String getLabel() {return label;}

    @Override
    public void all_labels(){
        System.out.println(label);
        if (super.getLabel() != null) {
            super.all_labels();
        }
    }
}
