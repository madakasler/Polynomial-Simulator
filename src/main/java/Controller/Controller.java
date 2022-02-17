package Controller;

import Model.Model;
import Model.MonomialInt;
import Model.Polynomial;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private View view;
    private Model model;
    private Polynomial polynomial= new Polynomial();
    private Polynomial polynomial1= new Polynomial();

    public Controller(View view,Model model) {
        this.view = view;
        this.model=model;
        this.view.sum(new Listener());
        this.view.dif(new Listener());
        this.view.div(new Listener());
        this.view.deriv(new Listener());
        this.view.mul(new Listener());
        this.view.integrare(new Listener());
        this.view.div1(new Listener());



    }
    class Listener implements ActionListener{


        public void polinoame()
        {
            ArrayList<Integer> integerPolinom1= new ArrayList<Integer>();
            ArrayList<Integer> integerPolinom2= new ArrayList<Integer>();
            String convertedPolinom1;
            String convertedPolinom2;
            String polinom1 = view.getPol1();
            String polinom2 = view.getPol2();
            String patternToLookFor = "(([+()\\d-]+)(x\\^)([0-9]+))";
            String patterntoLookFor2 = "(([+()\\d-]+))";
            Pattern pattern = Pattern.compile(patternToLookFor);
            Matcher matcher = pattern.matcher(polinom1);
            Pattern pattern1 = Pattern.compile(patterntoLookFor2);
            Matcher matcher1 = pattern.matcher(matcher.group(1));


            while(matcher.find()==true) {
                 convertedPolinom1=matcher.group(1);
                while(matcher1.find()==true) {

                    MonomialInt monomialInt = new MonomialInt(0,0);
                    monomialInt.setCoeficient(Integer.parseInt(matcher1.group(1)));
                    matcher1.find();
                    monomialInt.setGrad(Integer.parseInt(matcher1.group(1)));
                   polynomial.getPolynom().add(monomialInt);
                }
            }
            Pattern pattern2 = Pattern.compile(patternToLookFor);
            Matcher matcher2 = pattern.matcher(polinom2);
            Pattern pattern3 = Pattern.compile(patterntoLookFor2);
            Matcher matcher3 = pattern.matcher(matcher.group(1));

            while(matcher2.find()==true) {
                convertedPolinom2=matcher2.group(1);
                while(matcher3.find()==true) {
                    MonomialInt monomialInt = new MonomialInt(0,0);
                    monomialInt.setCoeficient(Integer.parseInt(matcher3.group(1)));
                    matcher3.find();
                    monomialInt.setGrad(Integer.parseInt(matcher3.group(1)));
                    polynomial1.getPolynom().add(monomialInt);
                }

            }

        }
        @Override
        public void actionPerformed(ActionEvent e) {


                  view.sum(e1 ->{
                    model.polinoame(view.getPol1(), view.getPol2());
                    view.setText(model.adunare());

                        });
               view.dif(e1 ->{
                   model.polinoame(view.getPol1(), view.getPol2());
                   view.setText(model.scadere());

            });

            view.mul(e1 ->{
                model.polinoame(view.getPol1(), view.getPol2());
                view.setText(model.mul());

            });

            view.div(e1 ->{
                model.polinoame(view.getPol1(), view.getPol2());
                view.setText(model.div());

            });
            view.integrare(e1 ->{
                model.polinoame(view.getPol1(), view.getPol2());
                view.setText(model.integrare());

            });

            view.deriv(e1 ->{
                model.polinoame(view.getPol1(), view.getPol2());
                view.setText(model.derivare());


            });

            view.div1(e1 ->{
                model.polinoame(view.getPol1(), view.getPol2());
                view.setText1(model.div1());

            });



        }

    }

}
