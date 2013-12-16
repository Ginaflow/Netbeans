/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.businesslogic;

import java.util.ArrayList;
import java.util.Random;
import quiz.domain.QuizVraag;


/**
 *
 * @author Robin
 */
public final class LessenQuizManager {
    
    private final ArrayList<QuizVraag> quizVragen;
    public ArrayList<String> listDocenten;
    public ArrayList<String> listLessen;
    
    public LessenQuizManager()
            {
                quizVragen = new ArrayList<>();
                createVraag();
                getDocentNamen();
            }
    
    private void createVraag()
    {
        QuizVraag vraag = new QuizVraag("Software Engineering", "Pascal van Gastel");
        quizVragen.add(vraag);
        vraag = new QuizVraag("Java", "Marice Bastiaensen");
        quizVragen.add(vraag);
        vraag = new QuizVraag("Database", "Robin Schellius");
        quizVragen.add(vraag);
        vraag = new QuizVraag("P&OC", "Jolanda van Houten");
        quizVragen.add(vraag);
        vraag = new QuizVraag("PVO", "Erco Argante");
        quizVragen.add(vraag);
        
    }
    
    public ArrayList getDocentNamen()
    {
        listDocenten = new ArrayList();
        for(int x = 0; x < quizVragen.size(); x++){
            listDocenten.add(quizVragen.get(x).getDocent());}
        return listDocenten;
    }
        
    public String getRandomLesNaam()
    {
        listLessen = new ArrayList();
        for(int x = 0; x < quizVragen.size(); x++){
        listLessen.add(quizVragen.get(x).getLes());}
        Random rand = new Random();
        int index = rand.nextInt(listLessen.size());
        return listLessen.get(index).toString();
    }
    
    public boolean check(String docentNaam, String lesNaam) {
        boolean check = false;
        int counter = 0;

        while (check == false && counter < this.quizVragen.size()) {
            QuizVraag vraag = this.quizVragen.get(counter);
            if (vraag.getDocent().equals(docentNaam)) {
               if(vraag.getLes().equals(lesNaam)  ){
                   check =  true;
               }
            }
            counter++;
        }
        return check;

    }
}
