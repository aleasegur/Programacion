package Tema6.Ejercicio7;

public class AtaqueFisico implements Ataque{
    private int fuerza;

    public AtaqueFisico(){
        fuerza=0;
    }

    public AtaqueFisico(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public int iCoste() {
        return fuerza;
    }

    @Override
    public int idamageInflingido() {
        return 2*fuerza;
    }

    @Override
    public void iLanzar() {
        System.out.println("Ha lanzado un ataque fisico de "+idamageInflingido()+" daño con coste "+iCoste());
    }
}
