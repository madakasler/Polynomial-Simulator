package Model;

import java.util.ArrayList;

public class Model {

    Polynomial polynomial = new Polynomial();
    Polynomial polynomial1 = new Polynomial();
    public Model() {

    }
    public void polinoame(String polinom1, String polinom2)
    {

        ArrayList<Integer> integerPolinom1= new ArrayList<Integer>();
        ArrayList<Integer> integerPolinom2= new ArrayList<Integer>();
        String[] convertedPolinom1 = new String[30];
        String[] convertedPolinom2 = new String[30];


        convertedPolinom1=polinom1.replace("^","").split("((?=\\+)|(?=\\-)|x)");
        convertedPolinom2=polinom2.replace("^","").split("((?=\\+)|(?=\\-)|x)");

        for(int count=0; count< convertedPolinom1.length-1;count=count+2)
        {
            integerPolinom1.add(Integer.parseInt(convertedPolinom1[count]));
            integerPolinom1.add(Integer.parseInt(convertedPolinom1[count+1]));
        }
        for(int count=0; count< convertedPolinom2.length-1;count=count+2)
        {
            integerPolinom2.add(Integer.parseInt(convertedPolinom2[count]));
            integerPolinom2.add(Integer.parseInt(convertedPolinom2[count+1]));
        }
        for(int count =0; count < integerPolinom1.size();count=count+2)
        {
            int count1= count+1;
            MonomialInt monomial = new MonomialInt((integerPolinom1.get(count1)),integerPolinom1.get(count));
            polynomial.getPolynom().add(monomial);
        }
        for(int count =0; count < integerPolinom2.size();count=count+2)
        {
            int count1= count+1;
            MonomialInt monomial = new MonomialInt(integerPolinom2.get(count1),integerPolinom2.get(count));
            polynomial1.getPolynom().add(monomial);
        }
    }
   public String adunare()
    {
        Polynomial p3= new Polynomial();
        p3=p3.sumPolynoms(polynomial,polynomial1);
        String rez = "";

        rez=p3.showPoly(p3);

        polynomial.getPolynom().clear();
        polynomial1.getPolynom().clear();
        return rez;
    }
    public String scadere()
    {
        Polynomial p3= new Polynomial();
        p3=p3.minusPolynoms(polynomial,polynomial1);
        String rez = "";

        rez=p3.showPoly(p3);

        polynomial.getPolynom().clear();
        polynomial1.getPolynom().clear();
        return rez;
    }

    public String mul()
    {
        Polynomial p3= new Polynomial();
        p3=p3.multiplyPolynomial(polynomial,polynomial1);
        String rez = "";
        rez=p3.showPoly(p3);

        polynomial.getPolynom().clear();
        polynomial1.getPolynom().clear();
        return rez;
    }

    public String div()
    {

        Polynomial p3= new Polynomial();
        ArrayList<Polynomial> rezi= new ArrayList<Polynomial>();
        rezi=p3.divPol(polynomial,polynomial1);
        String rez = "";
        p3=rezi.get(0);
        rez=p3.showPoly(p3);

        polynomial.getPolynom().clear();
        polynomial1.getPolynom().clear();
        return rez;
    }
    public String div1()
    {

        Polynomial p3= new Polynomial();
        ArrayList<Polynomial> rezi= new ArrayList<Polynomial>();
        rezi=p3.divPol(polynomial,polynomial1);
        String rez = "";
        p3=rezi.get(1);
        rez=p3.showPoly(p3);

        polynomial.getPolynom().clear();
        polynomial1.getPolynom().clear();
        return rez;
    }
    public String integrare()
    {
        Polynomial p3= new Polynomial();
        p3=p3.integrarePolinom(polynomial);
        String rez = "";
        rez=p3.showPoly(p3);

        polynomial.getPolynom().clear();
        polynomial1.getPolynom().clear();
        return rez;
    }

    public String derivare()
    {
        Polynomial p3= new Polynomial();
        p3=p3.deviativePolynomial(polynomial);
        String rez = "";
        rez=p3.showPoly(p3);
        polynomial.getPolynom().clear();
        polynomial1.getPolynom().clear();
        return rez;
    }
}
