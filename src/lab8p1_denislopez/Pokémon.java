/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_denislopez;

/**
 *
 * @author djlop
 */
public class Pokémon {
    private String nombre;
    private String tipo;
    private int nivel;   
    private int salud;   
    private int ataque;  
    private int defensa;
    
   
    public Pokémon() {
    }

    public Pokémon(String nombre, String tipo, int nivel, int salud, int ataque, int defensa) {
        this.nombre=nombre;
        this.tipo=tipo;
        this.nivel=nivel; 
        this.salud=salud;
        this.ataque=ataque;
        this.defensa=defensa;
    }

    public String getNombre(){ 
        return nombre; 
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getTipo(){
        return tipo; 
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
     
    public int getNivel(){
        return nivel; 
    }
    
    public void setNivel(int nivel){
        if (nivel >= 1 && nivel <= 100) {
        this.nivel = nivel;
        }
    }
    
    public int getSalud(){ 
        return salud; 
    }
    
    public void setSalud(int salud){
        if (salud >= 0 && salud <= 100){
          this.salud = salud;  
        }
    }
    
    public int getAtaque(){ 
        return ataque;
    }
    
     public void setAtaque(int ataque){
        if (ataque >= 1 && ataque <= 100){
           this.ataque = ataque; 
        }
    }
     
    public int getDefensa(){ 
        return defensa; 
    }

    public void setDefensa(int defensa) {
        if (defensa >= 1 && defensa <= 100){
            this.defensa = defensa;
        }
    }

    @Override
    public String toString() {
        return this.nombre+" "+this.tipo+" "+this.nivel+" "+this.salud+" "+this.ataque+" "+this.defensa;
    }   
}
