package Model;

public class MonomialInt extends Monomial{
    private int coeficient;
    public MonomialInt(int grad, int coeficient) {
        super(grad);
        this.coeficient=coeficient;
    }

    public int getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

}
