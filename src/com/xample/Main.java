package com.xample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //las variables que puede usar la máquina
        char[] maquina = {'r', 'p', 's'};
        //contadores de puntos
        int jCount = 0;
        int mCount = 0;
        System.out.println("juega! \nIntroduce 'r' para piedra, 'p' para papel o 's' para tijeras \ngana el que llegue a 5 puntos");

        while(true){
            //se introduce la eleccción
            String jugador =  reader.readLine();
            //se comprueba que cumpla con los requisitos
            if (!jugador.equalsIgnoreCase("r")&&!jugador.equalsIgnoreCase("s")&&!jugador.equalsIgnoreCase("p")){
                System.out.println("letra incorrecta, solo funciono con 'r', 'p' y 's'");
                break;
            }
            //convierto la string en un char, seguro que hay una manera simple y limpia de hacerlo, pero no la conozco
            char[] jug = jugador.toCharArray();
            char ju = jug[0];

            //la máquine elige aleatoriamente su char
            double select = Math.random()*3;
            int select2 = (int) (select / 1);
            char ma = maquina[select2];
            System.out.println("maquina elige " + ma);
            //se implementa el método para saber quien gana, no lo hice con un boolean, porque está la posibilidad de empate
            quienGana(ju, ma);
            if (quienGana(ju , ma).equals("Jugador")){
                jCount++;
                System.out.println("Jugador gana");
            }
            else if (quienGana(ju , ma).equals("Máquina")){
                mCount++;
                System.out.println("Máquina gana");
            }
            else{
                System.out.println("Empate");
            }
            System.out.println("jugador: " + jCount + " máquina: " + mCount);
            //esta es la condición para salir del bucle, que uno de los dos gane llegando a 5 puntos
            if(jCount == 5){
                System.out.println("jugador ha ganado");
                break;
            }
            else if(mCount == 5){
                System.out.println("máquina ha ganado");
            }
        }
    }
    //el método para saber quien gana, aquí también seguro qeu hay maneras más limpias de hacerlo.
    public static String quienGana(char j, char m){
        String result = "";
        if ((m=='r' && j=='s') || (m=='s' && j=='p') || (m=='p' && j=='r')){
            result = "Máquina";
        }
        if((j=='r' && m=='s') || (j=='s' && m=='p') || (j=='p' && m=='r')){
            result = "Jugador";
        }
        else if(j==m) {
            result = "Empate";
        }
        return result;
    }
}
