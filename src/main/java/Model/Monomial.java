package Model;

public class Monomial implements Comparable<Monomial> {
    private int grad;


    public Monomial(int grad) {
        this.grad = grad;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }


    public int compareTo(Monomial a) {
        if(this.getGrad() > a.getGrad())
            return -1;
        else if(this.getGrad() < a.getGrad())
            return 1;
        else
            return 0;
    }
}
