package Tema7.Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EjercicioB2 {
    public static void main(String[] args) {
        String fileName="Documentos/alumnos_notas.txt";
        ArrayList<String> nombres=new ArrayList<>();
        ArrayList<Double> notasMedia=new ArrayList<>();

        try(BufferedReader br=new BufferedReader(new FileReader(fileName))) {
            String linea;

            while ((linea=br.readLine())!=null){
                //Separa nombres y notas por espacios
                String[] partes=linea.trim().split("\\s+");
                //Ignorar lineas invalidas
                if (partes.length<3) {
                    System.err.println("Formato incorrecto " + linea);
                }else {
                    String nombreCompleto = partes[0] + " " + partes[1];
                    double suma = 0;
                    int cantidadNotas = 0;
                    //Notas desde la tercera posicion
                    for (int i = 2; i < partes.length; i++) {
                        try {
                            suma += Double.parseDouble(partes[i]);
                            cantidadNotas++;
                        } catch (NumberFormatException e) {
                            System.err.println("Nota inválida ignorada para " + nombreCompleto + ": " + partes[i]);
                        }
                    }

                    if (cantidadNotas > 0) {
                        double promedio = suma / cantidadNotas;
                        nombres.add(nombreCompleto);
                        notasMedia.add(promedio);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //Ordena de mayor a menor
        for (int i = 0; i < notasMedia.size()-1; i++) {
            int maxInd = i;
            for (int j = i + 1; j < notasMedia.size(); j++) {
                if (notasMedia.get(j) > notasMedia.get(maxInd)) {
                    maxInd = j;
                }
            }

            //Intercambio de notas
            double tempNota = notasMedia.get(i);
            notasMedia.set(i,notasMedia.get(maxInd));
            notasMedia.set(maxInd,tempNota);

            //Intercambio de nombres
            String tempNombre=nombres.get(i);
            nombres.set(i,nombres.get(maxInd));
            nombres.set(maxInd,tempNombre);
        }

        System.out.println("Notas media de los alumnos: ");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(nombres.get(i)+", nota media="+notasMedia.get(i));
        }

    }
}
