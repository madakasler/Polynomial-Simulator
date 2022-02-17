import Model.MonomialInt;
import Model.Polynomial;
import junit.framework.TestCase;

import java.util.ArrayList;

public class JUnit extends TestCase {
    Polynomial polynomial1= new Polynomial();
    Polynomial polynomial2= new Polynomial();
    Polynomial polynomial3= new Polynomial();
    Polynomial polynomial4= new Polynomial();
    MonomialInt monomial1 = new MonomialInt(2,2);
    MonomialInt monomial2 = new MonomialInt(1,1);
    MonomialInt monomial3 = new MonomialInt(0,1);
    MonomialInt monomial4 = new MonomialInt(2,1);
    MonomialInt monomial5 = new MonomialInt(0,1);

    public void testSumaPolinoame(){
        polynomial1.getPolynom().add(monomial1);
        polynomial1.getPolynom().add(monomial2);
        polynomial1.getPolynom().add(monomial3);
        polynomial2.getPolynom().add(monomial4);
        polynomial2.getPolynom().add(monomial5);


        String rezultat ="(3*x^2)+(1*x^1)+(2*x^0)";


       polynomial3=polynomial3.sumPolynoms(polynomial1,polynomial2);


                assertEquals(polynomial3.showPoly(polynomial3),rezultat);
    }
   public void testScaderePolinoame(){
        polynomial1.getPolynom().add(monomial1);
        polynomial1.getPolynom().add(monomial2);
        polynomial1.getPolynom().add(monomial3);
        polynomial2.getPolynom().add(monomial4);
        polynomial2.getPolynom().add(monomial5);


       String rezultat ="(1*x^2)+(1*x^1)+(0*x^0)";

        polynomial3 =polynomial3.minusPolynoms(polynomial1,polynomial2);


       assertEquals(polynomial3.showPoly(polynomial3),rezultat);

    }
    public void testDerivarePolinom(){

        polynomial2.getPolynom().add(monomial4);
        polynomial2.getPolynom().add(monomial5);


        String rezultat ="(2*x^1)+(0*x^0)";
        polynomial3=polynomial3.deviativePolynomial(polynomial2);



        assertEquals(polynomial3.showPoly(polynomial3),rezultat);
    }

    public void testInmultirePolinoame(){
        polynomial1.getPolynom().add(monomial1);
        polynomial2.getPolynom().add(monomial4);


        String rezultat ="(2*x^4)";
        polynomial3=polynomial3.multiplyPolynomial(polynomial1,polynomial2);



        assertEquals(polynomial3.showPoly(polynomial3),rezultat);



    }
    public void testIntegrarePolinom(){
        MonomialInt monomial1 = new MonomialInt(1,2);
        polynomial1.getPolynom().add(monomial1);



        String rezultat ="(1.0*x^2)";


        polynomial3=polynomial3.integrarePolinom(polynomial1);


        assertEquals(polynomial3.showPoly(polynomial3),rezultat);
    }
   public void testImpartirePolinom(){
        MonomialInt monomial1 = new MonomialInt(2,1);
        MonomialInt monomial2 = new MonomialInt(1,2);
        MonomialInt monomial3 = new MonomialInt(0,1);
        MonomialInt monomial4 = new MonomialInt(1,1);
        MonomialInt monomial5 = new MonomialInt(0,1);
        polynomial1.getPolynom().add(monomial1);
        polynomial1.getPolynom().add(monomial2);
        polynomial1.getPolynom().add(monomial3);
        polynomial2.getPolynom().add(monomial5);
        polynomial2.getPolynom().add(monomial5);



       String rezultat ="(1.0*x^2)+(2.0*x^1)+(1.0*x^0)";
        Polynomial p3= new Polynomial();
        ArrayList<Polynomial> p = new ArrayList<Polynomial>();
        p=p3.divPol(polynomial1,polynomial2);
        p3=p.get(0);


        assertEquals(rezultat,p3.showPoly(p3));
    }

}
