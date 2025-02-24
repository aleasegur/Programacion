package Tema6.Ejercicio7;

import java.util.InputMismatchException;

public class PruebaAtaques {
    public static void main(String[] args) throws Exception {
        int poderMag,fuerza;
        try {
            poderMag = 5;
            fuerza = 10;
            AtaqueMagico ataqueMagico = new AtaqueMagico(poderMag);
            AtaqueFisico ataqueFisico = new AtaqueFisico(fuerza);
            AtaqueMagicoFisico ataqueMagicoFisico = new AtaqueMagicoFisico(poderMag, fuerza);
            System.out.println("---ATAQUE MAGICO---");
            ataqueMagico.iLanzar();
            System.out.println("---ATAQUE FISICO---");
            ataqueFisico.iLanzar();
            System.out.println("---ATAQUE MAGICO Y FISICO---");
            ataqueMagicoFisico.iLanzar();
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
