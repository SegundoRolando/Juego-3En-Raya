/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.juego;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Principal {
    int turno;
    int img1;
    int img2;

    public Principal(int turno, int img1, int img2) {
        this.turno = turno;
        this.img1 = img1;
        this.img2 = img2;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    

    
    
    public void intercambio(){
        if(getTurno()==0){
            setTurno(1);
        }else{
            setTurno(0);
        }
    }
    public int juego (int m[][]){
        //comparo la filas
        if((m[0][0]==m[0][1])&&(m[0][0]==m[0][2])){
            return 1;
        }
        if((m[1][0]==m[1][1])&&(m[1][0]==m[1][2])){
           return 2;
        }
        if((m[2][0]==m[2][1])&&(m[2][0]==m[2][2])){
           return 3;
        }
        //COMPARO LAS COLUMNAS
        if((m[0][0]==m[1][0])&&(m[0][0]==m[2][0])){
           return 4;
        }
        if((m[0][1]==m[1][1])&&(m[0][1]==m[2][1])){
           return 5;
        }
        if((m[0][2]==m[1][2])&&(m[0][2]==m[2][2])){
           return 6;
        }
       // COMPARO LAS DIAGONALES
        if((m[0][0]==m[1][1])&&(m[0][0]==m[2][2])){
           return 7;
        }
        if((m[2][0]==m[1][1])&&(m[2][0]==m[0][2])){
           return 1;
        }
        return 8;
    }
    public int  ejecutar(javax.swing.JButton btn,int i, int j,int m[][],javax.swing.JLabel jx, javax.swing.JLabel jo ){
        m[i][j]=getTurno();
        String n=new String();
        if(getTurno()==0){
            n="x";
            btn.setForeground(Color.red);
        }else {
            n="o";
           btn.setForeground(Color.GREEN);
        } 
        intercambio();
        btn.setText(n);
        btn.setEnabled(false);
        
           if(juego(m)!=0){
          JOptionPane.showConfirmDialog(null, "Ganaste "+n);
          if(getTurno()==1){
               setImg1(getImg1()+1);
             jx.setText(String.valueOf(getImg1()));
           }
          if(getTurno()==1){
               setImg2(getImg2()+1);
             jo.setText(String.valueOf(getImg2()));
           }
          return 1;
        }
        return 0;
       
    }
    public void raya(int m[][],javax.swing.JPanel p, int n ,int i ,int j){
        m[i][j]=getTurno();
        
       if(juego(m)==n){
           p.setVisible(true);
       }
    }
    public void raya(int m[][],javax.swing.JLabel p, int n ,int i ,int j){
        m[i][j]=getTurno();
        
       if(juego(m)==n){
           p.setVisible(true);
       }
    }
}
