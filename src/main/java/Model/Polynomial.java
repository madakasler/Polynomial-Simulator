package Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polynomial {
    private ArrayList<Monomial> polynom;
    public Polynomial() {
        this.polynom = new ArrayList<Monomial>();
    }
    public int size() {
        return polynom.size();
    }
    public void add(Monomial m) {
        polynom.add(m);
    }
    public ArrayList<Monomial> getPolynom() {
        return polynom;
    }
    public void setPolynom(ArrayList<Monomial> polynom) {
        this.polynom = polynom;
    }
    public Polynomial sumPolynoms(Polynomial p1, Polynomial p2) {
        Polynomial p3 = new Polynomial();
        if(p1.size()==1 && p2.size()==1)
        {
            p3.add(p1.getPolynom().get(0));
            p3.add(p2.getPolynom().get(0));
        }
        else {
                for (Monomial monom : p1.getPolynom()) {
                    boolean noCoeficient = false;
                    for (Monomial monom2 : p2.getPolynom()) {
                        if (monom.getGrad() == monom2.getGrad()) {
                            noCoeficient = true;
                            MonomialInt monomial = new MonomialInt(monom.getGrad(), ((MonomialInt) monom).getCoeficient() + ((MonomialInt) monom2).getCoeficient());
                            p3.getPolynom().add(monomial);                       }
                    }
                    if (noCoeficient == false) {
                        MonomialInt monomial = new MonomialInt(monom.getGrad(), ((MonomialInt) monom).getCoeficient());
                        p3.getPolynom().add(monomial);                   }
                }
                for(Monomial monom: p2.getPolynom()){
                    boolean noCoeficient = false;
                    for(Monomial monom2: p3.getPolynom()){
                        if (monom.getGrad() == monom2.getGrad())
                            noCoeficient = true;                    }
                    if (noCoeficient == false) {
                        MonomialInt monomial = new MonomialInt(monom.getGrad(), ((MonomialInt) monom).getCoeficient());
                        p3.getPolynom().add(monomial);                    }                }
                   }
        return p3;    }
    public Polynomial minusPolynoms(Polynomial p1, Polynomial p2) {
        Polynomial p3 = new Polynomial();
      //  Collections.sort(p1.getPolynom());
       // Collections.sort(p2.getPolynom());
        if(p1.size()==1 && p2.size()==1)        {
            p3.add(p1.getPolynom().get(0));
            MonomialInt monomialInt= new MonomialInt(p2.getPolynom().get(0).getGrad(),((MonomialInt)p2.getPolynom().get(0)).getCoeficient()*(-1));
                    p3.add(monomialInt);        }      else {
                for (Monomial monom : p1.getPolynom()) { boolean noCoeficient = false;
                    for (Monomial monom2 : p2.getPolynom()) {
                        if (monom.getGrad() == monom2.getGrad()) {          noCoeficient = true;
                            MonomialInt monomial = new MonomialInt(monom.getGrad(), ((MonomialInt) monom).getCoeficient() - ((MonomialInt) monom2).getCoeficient());
                            p3.getPolynom().add(monomial);               }                    }
                    if (noCoeficient == false) {
                        MonomialInt monomial = new MonomialInt(monom.getGrad(), ((MonomialInt) monom).getCoeficient());
                        p3.getPolynom().add(monomial);                    }                }
                for (Monomial monom : p1.getPolynom()) {
                    boolean noCoeficient = false;
                    for (Monomial monom2 : p3.getPolynom()) {
                        if (monom.getGrad() == monom2.getGrad()) {    noCoeficient = true;                       }                    }
                    if (noCoeficient == false) {
                        MonomialInt monomial = new MonomialInt(monom.getGrad(), ((MonomialInt) monom).getCoeficient());
                        p3.getPolynom().add(monomial);                    }                }
                for (Monomial monom : p2.getPolynom()) {
                    boolean noCoeficient = false;
                    for (Monomial monom2 : p3.getPolynom()) {
                        if (monom.getGrad() == monom2.getGrad())      noCoeficient = true;                    }
                    if (noCoeficient == false) {
                        MonomialInt monomial = new MonomialInt(monom.getGrad(), ((MonomialInt) monom).getCoeficient() * (-1));
                        p3.getPolynom().add(monomial);                    }
                }            }

        return p3;    }
    public Polynomial deviativePolynomial(Polynomial p1) {
        Polynomial p2 = new Polynomial();
        for (Monomial monomial : p1.getPolynom()) {
            if (monomial.getGrad() > 0) {
                MonomialInt monomial1 = new MonomialInt(monomial.getGrad() - 1, ((MonomialInt) monomial).getCoeficient() * monomial.getGrad());
                p2.getPolynom().add(monomial1);
            } else {
                MonomialInt monomial1 = new MonomialInt(0,0);
                p2.getPolynom().add(monomial1);
            }
        }
        return p2;    }
    public Polynomial multiplyPolynomial(Polynomial p1, Polynomial p2) {
        Polynomial p3 = new Polynomial();
        Polynomial p4 = new Polynomial();
        for (Monomial monomial1 : p1.getPolynom()) {
            for (Monomial monomial2 : p2.getPolynom()) {
                p3.getPolynom().add(new MonomialInt(monomial1.getGrad() + monomial2.getGrad(), ((MonomialInt) monomial1).getCoeficient() * ((MonomialInt) monomial2).getCoeficient())); }
            Collections.sort(p3.getPolynom());
       int ok=1;
            for (int i = 0; i < p3.getPolynom().size()-1; i++) {
               for(int contor=i+1;contor<p3.getPolynom().size();contor++)
                    if (p3.getPolynom().get(i).getGrad() == p3.getPolynom().get(contor).getGrad()) {
                        ((MonomialInt)p3.getPolynom().get(i)).setCoeficient(((MonomialInt)p3.getPolynom().get(i)).getCoeficient()+((MonomialInt)p3.getPolynom().get(contor)).getCoeficient());
                        p4.getPolynom().add(new MonomialInt(p3.getPolynom().get(i).getGrad(), ((MonomialInt) p3.getPolynom().get(i)).getCoeficient() + ((MonomialInt) p3.getPolynom().get(contor)).getCoeficient()));
                        p3.getPolynom().remove(contor);
                        ok=0;                }
            }
        }

        return p3;    }
    public Polynomial integrarePolinom(Polynomial p) {
        Polynomial p2 = new Polynomial();
        for (Monomial monom : p.getPolynom()) {
            Double coeficient=((MonomialInt) monom).getCoeficient()*1.0 / (monom.getGrad()+1);
            System.out.println(coeficient);
            MonomialDouble monomialDouble=new MonomialDouble((monom.getGrad()) + 1, coeficient);
            p2.getPolynom().add(monomialDouble);        }
        return p2;    }
 public Polynomial transformarePolinom(Polynomial p1 ) {
     Polynomial pol4 = new Polynomial();
     for (Monomial monomial : p1.getPolynom()) {
         pol4.getPolynom().add(new MonomialDouble(monomial.getGrad(), ((MonomialInt) monomial).getCoeficient()));     }
     return pol4; }
    public ArrayList<Polynomial> divPol(Polynomial p1,Polynomial p2){
        ArrayList<Polynomial> rezultat = new ArrayList<Polynomial>();
        Collections.sort(p2.getPolynom());        Collections.sort(p1.getPolynom());
       Polynomial p3 = new Polynomial();        Polynomial p4 = new Polynomial();        Polynomial rest= new Polynomial();        int need=0;  int i=0;        int test=0;
        p4=p4.transformarePolinom(p1);
        while(i< p4.getPolynom().size()) {
           Collections.sort(p4.getPolynom(), Comparator.comparing(Monomial::getGrad));
           Collections.reverse(p4.getPolynom());
           boolean conditie=true;
            if (p4.getPolynom().get(i).getGrad() >= p2.getPolynom().get(0).getGrad()) {
                conditie=true;}
                else{
                    conditie=false;}
                if(conditie==true){
                    MonomialDouble m1= new MonomialDouble(p4.getPolynom().get(i).getGrad() - p2.getPolynom().get(0).getGrad(),((MonomialDouble) p4.getPolynom().get(i)).getCoeficient() / ((MonomialInt) p2.getPolynom().get(0)).getCoeficient());
                        p3.getPolynom().add(m1);
                        int k=0;
                while(k< p2.getPolynom().size())  {
                        test=0;
                        for(Monomial monom:p4.getPolynom()){
                            if(monom.getGrad()==m1.getGrad()+p2.getPolynom().get(k).getGrad()){
                                if(test==0) {
                                    test = 1;
                                    ((MonomialDouble) monom).setCoeficient(((MonomialDouble) monom).getCoeficient() - ((MonomialDouble) m1).getCoeficient() * ((MonomialInt) p2.getPolynom().get(k)).getCoeficient());
                                    break;
                                }
                                else
                                    break;
                            }
                        }
                        if(test==0){
                            p4.getPolynom().add(new MonomialDouble(m1.getGrad()+p2.getPolynom().get(k).getGrad(),-(((MonomialDouble)m1).getCoeficient() * ((MonomialInt) p2.getPolynom().get(k)).getCoeficient())));
                        }
                        k++;
                    }
            }else
                rest.add(p4.getPolynom().get(i));
            i++;
        }
           rezultat.add(p3);           rezultat.add(rest);           return  rezultat;        }
    public String showPoly(Polynomial p1) {
        int size = this.size();
        Collections.sort(p1.getPolynom());
       String show="";
            for (Monomial monomial : p1.getPolynom()) {
                if (monomial instanceof MonomialInt) {
                    size = size - 1;
                        if (size == 0) {
                            show=show+"("+Integer.toString(((MonomialInt) monomial).getCoeficient())+"*x^"+Integer.toString((monomial).getGrad())+")";
                        } else {
                            show=show+"("+Integer.toString(((MonomialInt) monomial).getCoeficient())+"*x^"+Integer.toString((monomial).getGrad())+")+";
                        }
                } else {
                    size = size - 1;
                        if (size == 0) {
                            show=show+"("+Double.toString(((MonomialDouble) monomial).getCoeficient())+"*x^"+Integer.toString(( monomial).getGrad())+")";;
                        } else {
                            show=show+"("+Double.toString(((MonomialDouble) monomial).getCoeficient())+"*x^"+Integer.toString(( monomial).getGrad())+")+";;
                        }
                    }
                }
        return show;    }}
