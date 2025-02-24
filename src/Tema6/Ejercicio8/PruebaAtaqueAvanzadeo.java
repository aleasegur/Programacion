package Tema6.Ejercicio8;

import java.util.InputMismatchException;

public class PruebaAtaqueAvanzadeo {
    public static void main(String[] args) {
        int fuerza,poderMag;
        try {
            poderMag =15;
            fuerza=20;
            AtaqueBolaFuego ataqueBolaFuego=new AtaqueBolaFuego(poderMag);
            AtaqueEspadazo ataqueEspadazo=new AtaqueEspadazo(fuerza);
            AtaqueEspadazoEncantado ataqueEspadazoEncantado=new AtaqueEspadazoEncantado(poderMag,fuerza);
            System.out.println("---ATAQUE BOLA DE FUEGO---");
            ataqueBolaFuego.iLanzar();
            System.out.println("---ATAQUE ESPADAZO---");
            ataqueEspadazo.iLanzar();
            System.out.println("---ATAQUE ESPADAZO ENCANTADO---");
            ataqueEspadazoEncantado.iLanzar();
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
