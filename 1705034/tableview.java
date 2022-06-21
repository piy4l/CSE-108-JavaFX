/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author User
 */
public class tableview {
    private final SimpleStringProperty word;
    private final SimpleIntegerProperty freq;
    tableview(String word,Integer freq){
        super();
        this.word=new SimpleStringProperty(word);
        this.freq=new SimpleIntegerProperty(freq);
    }
    public String getWord(){
        return word.get();
    }
    public void setWord(String word){
        this.word.set(word);
    }
    public void setFreq(int freq){
        this.freq.set(freq);
    }
    public int getFreq(){
        return freq.get();
    }
}
