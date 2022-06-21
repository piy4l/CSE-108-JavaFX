/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offline;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
       //view_the_words(ActionEvent event);
 
    @FXML  private TableView<tableview>myTable;
    @FXML  private TableColumn<tableview,String>word;
    @FXML  private TableColumn<tableview,Integer>freq;
    private Label label;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        //TableColumn word=new TableColumn("Words");
        //TableColumn freq=new TableColumn("Frequency");
       // myTable.getColumns().addAll(word,freq);
        
     
    
        
    }  
  String str=new String();
  String multi_del=" //.//,//?//!//&//;//://@";
 
    public void choose_file(ActionEvent event) throws FileNotFoundException{
        
        int i=0;
        str=new String();
         FileChooser fc=new FileChooser();
        File selected_file=fc.showOpenDialog(null);
        Scanner s=new Scanner(selected_file);
        while(s.hasNext()){
            str=str+" "+s.nextLine();
        }
          //  System.out.println(str);
    }
    public void view_the_words(ActionEvent event){
       //label.setText(str);
       StringTokenizer tok=new StringTokenizer(str,multi_del);
        //System.out.println(tok.countTokens());
        int count=tok.countTokens(),i=0,flag=1,k=0,j=0,a=0;
        int count2=count;
        String[] arr=new String[tok.countTokens()];
        while(tok.hasMoreTokens()){
           
           arr[i]=tok.nextToken();
           i++;
        }
        
         for(k=0;k<i-1;k++){
             for(j=k+1;j<i;j++){
             if(arr[k].equals(arr[j])){
             count--;
             break;
             }
         }
             
    }
         String[] arr2=new String[1000];
         int[] arr3=new int[1000];
         for(i=0;i<count2;i++){
             int c=1;
             flag=1;
             for(j=i+1;j<count2;j++){
                 for(k=0;arr2[k]!=null;k++){
                     if(arr[i].equals(arr2[k])){
                          flag=0;
                         break;
                     }                        
                 }               
                 if(flag==0) break;                 
                 else {
                     flag=1;
                     if(arr[i].equals(arr[j])){
                     c++;
                 }
                 }
             }
             if(flag==0) {
             } else{
                 arr2[a]=arr[i];
                 arr3[a]=c;
                 a++;
             }
         }
        // for(i=0;i<count;i++){
          //   System.out.println(arr2[i]+' '+arr3[i]);
         //}
       word.setCellValueFactory(new PropertyValueFactory<>("word"));
     freq.setCellValueFactory(new PropertyValueFactory<>("freq"));
    ObservableList<tableview>list=FXCollections.observableArrayList();
    
     myTable.setItems(list);
     for(i=0;i<count;i++){
         list.add(new tableview(arr2[i],arr3[i]));
     }
    }

    private Readable newFile(FileChooser fc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

