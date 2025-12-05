/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8p1_denislopez;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author djlop
 */
public class Lab8P1_DenisLopez {
    public static Scanner sc = new Scanner (System.in);
    static ArrayList<Pokémon>pokemons=new ArrayList<Pokémon>();
    static Random R = new Random();

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
                        JOptionPane.showMessageDialog(null, "El pokemon no existe. Agregue un pokemon.");
                    } else {
                        mostrarTodos();
                        consultarPokemon();
                    }
                    break;
                }
                case 3:{
                    if (pokemons.size() == 0) {
                        JOptionPane.showMessageDialog(null, "El pokemon no existe. Agregue un pokemon.");
                    } else {
                        mostrarTodos();
                        modificarPokemon();
                    }
                    break;    
                }
                case 4:{
                    if (pokemons.size() == 0) {
                        JOptionPane.showMessageDialog(null, "El pokemon no existe. Agregue un pokemon.");
                    } else {
                        mostrarTodos();
                        eliminarPokemon();
                    }
                    break;
                }
                case 5:{
                    mostrarTodos();
                    break;         
                }
                case 6:{
                    if (pokemons.size() == 0) {
                        JOptionPane.showMessageDialog(null, "El pokemon no existe. Agregue un pokemon.");
                    } else {
                        mostrarTodos();
                        entrenarPokemon();
                    }
                    break;
                }
                case 7:{
                    if (pokemons.size() < 2) {
                        JOptionPane.showMessageDialog(null, "Debe registrar al menos 2 Pokémon");
                    } else {
                        mostrarTodos();
                        simularBatalla();
                    }
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
        String nombre= JOptionPane.showInputDialog("Ingrese nombre: ");
        String tipo= JOptionPane.showInputDialog("Ingrese tipo: ");
        int nivel= Integer.parseInt(JOptionPane.showInputDialog("Ingrese nivel (1-100): "));
        while (nivel<1 || nivel>100) {
              nivel= Integer.parseInt(JOptionPane.showInputDialog("Nivel incorrecto. Ingrese nivel (1-100): "));
        }
        int salud= Integer.parseInt(JOptionPane.showInputDialog("Ingrese salud (0-100): "));
        while (salud<0 || salud>100){
              salud= Integer.parseInt(JOptionPane.showInputDialog("Salud incorrecto. Ingrese salud (0-100): "));
        }
        int ataque= Integer.parseInt(JOptionPane.showInputDialog("Ingrese ataque (1-100): "));
        while (ataque<1 || ataque>100){
             ataque= Integer.parseInt(JOptionPane.showInputDialog("Ataque incorrecto. Ingrese ataque (1-100): "));
        }
        int defensa= Integer.parseInt(JOptionPane.showInputDialog("Ingrese defensa (1-100): "));
        while (defensa<1 || defensa>100){
             defensa= Integer.parseInt(JOptionPane.showInputDialog("Defensa incorrecto. Ingrese defensa (1-100): "));
        }
        Pokémon temp= new Pokémon(nombre,tipo,nivel,salud,ataque,defensa);
        pokemons.add(temp);
        JOptionPane.showMessageDialog(null, "Pokémon agregado");
    }
    
    public static void consultarPokemon(){
        int consultar= Integer.parseInt(JOptionPane.showInputDialog("Seleccione el Pokémon por número para consultar:"));
        if(consultar>=0 && consultar<pokemons.size()){
            JOptionPane.showMessageDialog(null, pokemons.get(consultar).toString());
        }
        else{
            JOptionPane.showMessageDialog(null,"El pokemon no se encuentra aqui");
        }
    }
    
    public static void modificarPokemon(){ 
        int modificar= Integer.parseInt(JOptionPane.showInputDialog("Seleccione el Pokémon por número para modificar:"));
        if (modificar<0 || modificar>=pokemons.size()) {
            JOptionPane.showMessageDialog(null, "Índice no existe");
            return;
        }
        Pokémon p= pokemons.get(modificar);
        String nombre= JOptionPane.showInputDialog("Nuevo nombre:",p.getNombre());
        String tipo= JOptionPane.showInputDialog("Nuevo tipo:", p.getTipo());
        int nivel= Integer.parseInt(JOptionPane.showInputDialog("Nivel (1-100):", p.getNivel()));
        while (nivel<1||nivel>100) {
            nivel= Integer.parseInt(JOptionPane.showInputDialog("Nivel incorrecto (1-100):"));
        }
        int salud= Integer.parseInt(JOptionPane.showInputDialog("Salud (0-100):", p.getSalud()));
        while (salud<0||salud>100) {
            salud= Integer.parseInt(JOptionPane.showInputDialog("Salud incorrecto (0-100):"));
        }
        int ataque = Integer.parseInt(JOptionPane.showInputDialog("Ataque (1-100):", p.getAtaque()));
        while (ataque<1||ataque>100) {
            ataque= Integer.parseInt(JOptionPane.showInputDialog("Ataque incorrecto (1-100):"));
        }
        int defensa= Integer.parseInt(JOptionPane.showInputDialog("Defensa (1-100):", p.getDefensa()));
        while (defensa<1||defensa>100) {
            defensa= Integer.parseInt(JOptionPane.showInputDialog("Defensa incorrecto (1-100):"));
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
        int eliminar= Integer.parseInt(JOptionPane.showInputDialog("Seleccione el Pokémon por número para eliminar:"));
        if (eliminar>=0 && eliminar<pokemons.size()) {
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
     
    public static void entrenarPokemon() {
        int entrenar= Integer.parseInt(JOptionPane.showInputDialog("Seleccione el Pokémon por número para entrenar:"));
        if (entrenar<0 || entrenar>=pokemons.size()) {
            JOptionPane.showMessageDialog(null, "Índice no existe");
            return;
        }
        Pokémon p= pokemons.get(entrenar);
        int subirNivel=1+R.nextInt(10);
        int subirAtaque=1+R.nextInt(7);
        int subirDefensa=1+R.nextInt(6);
        int nivel=p.getNivel()+subirNivel;
        if (nivel > 100) {
            nivel= 100;
        }
        int ataque= p.getAtaque() + subirAtaque;
        if (ataque > 100){
            ataque= 100;
        }
        int defensa = p.getDefensa() + subirDefensa;
        if (defensa > 100) {
            defensa= 100;
        }
        p.setNivel(nivel);
        p.setAtaque(ataque);
        p.setDefensa(defensa);
        JOptionPane.showMessageDialog(null, "Pokémon entrenado");
    }
    
    public static void simularBatalla() {
        int jugador1 = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el primero Pokémon:"));
        int jugador2 = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el segundo Pokémon:"));
        if (jugador1<0 || jugador1>=pokemons.size() || jugador2<0 || jugador2>=pokemons.size() || jugador1==jugador2) {
            JOptionPane.showMessageDialog(null, "Selección inválida");
            return;
        }
        Pokémon A = pokemons.get(jugador1);
        Pokémon B = pokemons.get(jugador2);
        JOptionPane.showMessageDialog(null, "BATALLA POKÉMON");
        if (A.getAtaque() > B.getAtaque()) {
            JOptionPane.showMessageDialog(null,"Ganador: "+A.getNombre());
        } else if (B.getAtaque() > A.getAtaque()) {
            JOptionPane.showMessageDialog(null,"Ganador: "+B.getNombre());
        } else {
            JOptionPane.showMessageDialog(null, "Empate");
        }
    }
}
