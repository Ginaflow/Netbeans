/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.domain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Robin
 */
public class QuizVraag {
    
    private String les;
    private String docent;

    
    public QuizVraag(String les, String docent)
            {
                this.les = les;
                this.docent = docent;   
            }
    
    public void setLes(String les)
    {
        this.les = les;
    }
    
    public String getLes()
    {
        return les;
    }
    
    public void setDocent(String docent)
    {
        this.docent = docent;
    }
    
    public String getDocent()
    {
        return docent;
    }
}
