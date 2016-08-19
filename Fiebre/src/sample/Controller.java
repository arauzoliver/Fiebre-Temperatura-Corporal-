package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.*;



public class Controller {
    //BufferedReader k = new BufferedReader(new InputStreamReader(System.in));

    public TextField Us;
    public Label LoginLabel;
    public Label CreateLabel;


    public void DAT(){
        double[] datos = {37,38,39,40};
        //double PTemp= Double.parseDouble(Us.getText());
        try{
        DataOutputStream output = new DataOutputStream(new FileOutputStream("Temperatura.dat"));
        for (double dato: datos){
            output.writeDouble(dato);
            System.out.println(dato+ System.lineSeparator());
        }
        output.close();
    }catch (IOException e) {
    e.printStackTrace();
}}

    public void Leer(){
        try{
        DataInputStream input = new DataInputStream(new FileInputStream("Temperatura.dat"));
        while (input.available() > 0) {
            double x = input.readDouble();
            LoginLabel.setText(String.valueOf(x));
        }
        input.close();
    }catch (IOException e) {
        e.printStackTrace();
    }}

    public void Temp(ActionEvent actionEvent) {
   DAT();
   Leer();

    }

    public void Exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Borrar(){
        Us.setText(null);
        //LoginLabel.setText("Datos almacenados");
       // CreateLabel.setText(null);
    }

}
