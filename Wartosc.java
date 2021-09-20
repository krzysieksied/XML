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
public class Wartosc implements Comparable<Wartosc> {
    
    
    private String wartosc;
    private int liczba;
    
    public Wartosc(String wartosc,int liczba){
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
    public int compareTo(Wartosc o){
    int result= Integer.parseInt(this.wartosc)-Integer.parseInt(o.wartosc);
    return result;
    }
    
    @Override
    public String toString(){
    return ""+liczba;
    }
}

    

