import Controller.Controller;
import Model.Model;
import View.View;

public class Main {

    public static void main(String[] args) {
	View view = new View();
	Model model= new Model();
	/*MonomialInt monom= new MonomialInt(2,1);
	MonomialInt monom1= new MonomialInt(0,1);


	Polynomial p2= new Polynomial();
	p2.add(monom);
	p2.add(monom1);



        MonomialInt monom3= new MonomialInt(2,2);
        MonomialInt monom4= new MonomialInt(1,1);
        MonomialInt monom2= new MonomialInt(0,1);

        Polynomial p1= new Polynomial();
        p1.add(monom3);
        p1.add(monom4);
        p1.add(monom2);

        Polynomial p3 = new Polynomial();

        Controller controller= new Controller(view);

        p3=p3.minusPolynoms(p1,p2);
      for(Monomial s : p3.getPolynom())
          if(s instanceof MonomialInt)
       System.out.print(((MonomialInt)s).getCoeficient());

        // for( Monomial monomi:p3.getPolynom())
          //   System.out.print(monomi.getCoeficient());*/

        Controller controller= new Controller(view,model);



    }
}
