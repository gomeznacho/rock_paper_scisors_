package com.xample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainSinComments {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("juega! \nIntroduce 'r' para piedra, 'p' para papel o 's' para tijeras \ngana el que llegue a 5 puntos");

        while(true){

            String jugador =  reader.readLine();

            if (!esValido(jugador)){
                System.out.println("letra incorrecta, solo funciono con 'r', 'p' y 's'");
                break;
            }

            char ju = crearJug(jugador);
            char ma = crearMaq(maquina);

            quienGana(ju, ma);

            System.out.println("jugador: " + jCount + " máquina: " + mCount);

            if(jCount == 5){
                System.out.println("jugador ha ganado");
                break;
            }
            else if(mCount == 5){
                System.out.println("máquina ha ganado");
                break;
            }
        }
    }

    //variables y métodos
    public static char[] maquina = {'r', 'p', 's'};

    public static int jCount = 0;
    public static int mCount = 0;

    public static boolean esValido(String s){
        if (!s.equalsIgnoreCase("r")&&!s.equalsIgnoreCase("s")&&!s.equalsIgnoreCase("p")){
            return false;
        }
        else return true;
    }

    public static char crearJug (String jugador) {
        char[] jug = jugador.toCharArray();
        char ju = jug[0];
        return ju;
    }

    public static char crearMaq (char [] maquina) {
        double select = Math.random() * 3;
        int select2 = (int) (select / 1);
        char ma = maquina[select2];
        System.out.println("maquina elige " + ma);
        return ma;
    }

    public static String quienGana(char j, char m){
        String result = "";
        if ((m=='r' && j=='s') || (m=='s' && j=='p') || (m=='p' && j=='r')){
            result = "Máquina";
            mCount++;
            System.out.println("Máquina gana");
        }
        if((j=='r' && m=='s') || (j=='s' && m=='p') || (j=='p' && m=='r')){
            result = "Jugador";
            jCount++;
            System.out.println("Jugador gana");
        }
        else if(j==m) {
            result = "Empate";
            System.out.println("Empate");
        }
        return result;
    }
}
