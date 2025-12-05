/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8p1_denislopez;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author djlop
 */
public class Lab8P1_DenisLopez {
    public static Scanner sc = new Scanner (System.in);
    static ArrayList<Pokémon>pokemons=new ArrayList<Pokémon>();
    Pokémon p=new Pokémon();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op = menu();
        while(op!=8){
            switch(op){
                case 1:{
                    agregarPokemon();
                    break;
                }
                case 2:{
                    if (pokemons.size() == 0) {
                        JOptionPane.showMessageDialog(null, "El pokemon no existe");
                    } else {
                        consultarPokemon();
                    }
                    break;
                }
                case 3:{
                    if (pokemons.size() == 0) {
                        JOptionPane.showMessageDialog(null, "El pokemon no existe");
                    } else {
                        modificarPokemon();
                    }
                    break;    
                }
                case 4:{
                    if (pokemons.size() == 0) {
                        JOptionPane.showMessageDialog(null, "El pokemon no existe");
                    } else {
                        eliminarPokemon();
                    }
                    break;
                }
                case 5:{
                    mostrarTodos();
                    break;         
                }
                case 6:{
                    
                    break;
                }
                case 7:{
                    
                    break;
                }
                default:{
                    
                }
            }
            op=menu();
        }
    }
    
    public static int menu(){
        String salida= " Sistema Pokémon \n 1. Agregar Pokémon \n 2. Consultar Pokémon \n 3. Modificar Pokémon \n 4. Eliminar Pokémon \n 5. Mostrar todos \n 6. Entrenar Pokémon \n 7. Simular Batalla \n 8. Salir";
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(salida));
        return opcion;
    }
    
    public static void agregarPokemon(){
        String nombre = JOptionPane.showInputDialog("Ingrese nombre: ");
        if(nombre==" "){
            String nombre1 = JOptionPane.showInputDialog("Ingrese nombre del pokemon para acceder a las demas opciones: ");
        }
        String tipo = JOptionPane.showInputDialog("Ingrese tipo: ");
        int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nivel (1-100): "));
        if (nivel < 1 || nivel > 100) {
             int nivel1 = Integer.parseInt(JOptionPane.showInputDialog("Nivel incorrecto. Ingrese nivel (1-100): "));
        }
        int salud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese salud (0-100): "));
        if (salud < 0 && salud > 100){
             int salud1 = Integer.parseInt(JOptionPane.showInputDialog("Salud incorrecto. Ingrese salud (0-100): "));
        }
        int ataque = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ataque (1-100): "));
        if (ataque < 1 && ataque > 100){
            int ataque1 = Integer.parseInt(JOptionPane.showInputDialog("Ataque incorrecto. Ingrese ataque (1-100): "));
        }
        int defensa = Integer.parseInt(JOptionPane.showInputDialog("Ingrese defensa (1-100): "));
        if (defensa < 1 && defensa > 100){
            int defensa1 = Integer.parseInt(JOptionPane.showInputDialog("Defensa incorrecto. Ingrese defensa (1-100): "));
        }
        Pokémon temp = new Pokémon(nombre,tipo,nivel,salud,ataque,defensa);
        pokemons.add(temp);
        JOptionPane.showMessageDialog(null, "Pokémon agregado");
    }
    
    public static void consultarPokemon(){
        mostrarTodos();
        int consultar= Integer.parseInt(JOptionPane.showInputDialog("Seleccione el Pokémon por número para consultar:"));
        if(consultar>=0&&consultar<pokemons.size()){
            JOptionPane.showMessageDialog(null, pokemons.get(consultar).toString());
        }
        else{
            JOptionPane.showMessageDialog(null,"El pokemon no se encuentra aqui");
        }
    }
    
    public static void modificarPokemon(){
        mostrarTodos();
        int modificar= Integer.parseInt(JOptionPane.showInputDialog("Seleccione el Pokémon por número para modificar:"));
        if (modificar<0||modificar >= pokemons.size()) {
            JOptionPane.showMessageDialog(null, "Índice no existe");
            return;
        }
        Pokémon p = pokemons.get(modificar);
        String nombre = JOptionPane.showInputDialog("Nuevo nombre:",p.getNombre());
        String tipo = JOptionPane.showInputDialog("Nuevo tipo:", p.getTipo());
        int nivel = Integer.parseInt(JOptionPane.showInputDialog("Nivel (1-100):", p.getNivel()));
        if (nivel<1||nivel>100) {
            nivel = Integer.parseInt(JOptionPane.showInputDialog("Nivel incorrecto (1-100):"));
        }
        int salud = Integer.parseInt(JOptionPane.showInputDialog("Salud (0-100):", p.getSalud()));
        if (salud<0||salud>100) {
            salud = Integer.parseInt(JOptionPane.showInputDialog("Salud incorrecto (0-100):"));
        }
        int ataque = Integer.parseInt(JOptionPane.showInputDialog("Ataque (1-100):", p.getAtaque()));
        if (ataque<1||ataque>100) {
            ataque = Integer.parseInt(JOptionPane.showInputDialog("Ataque incorrecto (1-100):"));
        }
        int defensa = Integer.parseInt(JOptionPane.showInputDialog("Defensa (1-100):", p.getDefensa()));
        if (defensa<1||defensa>100) {
            defensa = Integer.parseInt(JOptionPane.showInputDialog("Defensa incorrecto (1-100):"));
        }
        p.setNombre(nombre);
        p.setTipo(tipo);
        p.setNivel(nivel);
        p.setSalud(salud);
        p.setAtaque(ataque);
        p.setDefensa(defensa);
        JOptionPane.showMessageDialog(null, "Pokémon modificado");
    }
    
     public static void eliminarPokemon() { 
        mostrarTodos();
        int eliminar = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el Pokémon por número para eliminar:"));
        if (eliminar >= 0 && eliminar < pokemons.size()) {
            pokemons.remove(eliminar);
            JOptionPane.showMessageDialog(null, "Pokémon eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "Índice no existe");
        }
    }
    
    public static void mostrarTodos(){
        String salida=" ";
        for(int i=0;i<pokemons.size();i++){
            salida += i+". "+pokemons.get(i).toString()+"\n";
        }
        
        if(pokemons.size()==0){
            salida=" El pokemon no existe ";
        }
        JOptionPane.showMessageDialog(null, salida);
    }
    
}
