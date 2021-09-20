/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pzj_zajecie2_gr1;

/**
 *
 * @author krzysiek
 */
public class Liczba implements Comparable<Liczba> {
    
    
    private String wartosc;
    private int liczba;
    
    public Liczba(String wartosc,int liczba){
    this.wartosc=wartosc;
    this.liczba=liczba;
    }
    
    public int  getliczba(){
        return liczba;
    }
    
    public void setLiczba(int liczba){
    this.liczba=liczba;
    }
    
    public String getWartosc(){
    return wartosc;  
    }
    
    public void setWartosc(String wartosc){
    this.wartosc=wartosc;
    }
    
    
    @Override
    public int compareTo(Liczba o){
    int result= o.liczba-this.liczba;
    return result;
    }
    
    @Override
    public String toString(){
    return wartosc;
    }
}