package Tema4.Ejercicio1;

//import java.util.Scanner;

public class Mainejer1 {
    /*
    public static boolean comprobarHora(int hora) {
        boolean res = true;
        if (hora < 0 || hora >= 24) {
            System.err.println("La hora introducida no es correcta. Debe estar entre 0 y 24");
            res = false;
        }
        return res;
    }

    public static boolean comprobarMinSeg(int numTiempo, String tiempo) {
        boolean res = true;
        if (numTiempo < 0 || numTiempo >= 60) {
            System.err.println("Los " + tiempo + " introducida no es correcta. Debe star entre 0 y 60");
            res = false;
        }
        return res;
    }*/

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in); import java.util.Scanner comentado
        Reloj reloj1 = new Reloj();
        //Instancio y inicializo mas abajo el objeto reloj2
        Reloj reloj2;

        int horas, min, seg;
        boolean formatoHora,respuestaFormato;

        /*
        do {
            System.out.println("Introduce una hora: ");
            horas = sc.nextInt();
        } while (!comprobarHora(horas));

        do {
            System.out.println("Introduce los minutos");
            min = sc.nextInt();
        } while (!comprobarMinSeg(min, "minutos"));

        do {
            System.out.println("Introduce los segundos");
            seg = sc.nextInt();
        } while (!comprobarMinSeg(seg, "segundos"));
         */

        formatoHora=true;

        //Atributos reloj1
        horas=23;
        min=55;
        seg=14;
        reloj1.setFormato24(formatoHora);
        reloj1.setHoras(horas);
        reloj1.setMin(min);
        reloj1.setSeg(seg);

        //Atributos reloj2
        horas=20;
        min=45;
        seg=25;
        formatoHora=false;
        reloj2=new Reloj(horas,min,seg);
        reloj2.setFormato24(formatoHora);

        System.out.println("---Reloj1---");
        reloj1.mostrarHora();
        System.out.println(reloj1);

        System.out.println("---Reloj2---");
        reloj2.mostrarHora();
        System.out.println(reloj2);

    }
}
