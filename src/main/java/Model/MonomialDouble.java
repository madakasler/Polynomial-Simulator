package Model;

public class MonomialDouble extends Monomial{
    private double coeficient;
    public MonomialDouble(int grad,double coeficient) {
        super(grad);
        this.coeficient=coeficient;

    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }
}
