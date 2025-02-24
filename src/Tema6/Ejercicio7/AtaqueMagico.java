package Tema6.Ejercicio7;

public class AtaqueMagico implements Ataque{
    private int poderMag;

    public AtaqueMagico(){
        poderMag=0;
    }

    public AtaqueMagico(int poderMag)throws Exception {
        if (poderMag>0) {
            this.poderMag = poderMag;
        }else{
            throw new Exception("El valor no puede ser negativo");
        }
    }

    public int getPoderMag() {
        return poderMag;
    }

    public void setPoderMag(int poderMag)throws Exception {
        if (poderMag>0) {
            this.poderMag = poderMag;
        }else {
            throw new Exception("El valor no puede ser negativo");
        }
    }

    @Override
    public int iCoste() {
        return 2*poderMag;
    }

    @Override
    public int idamageInflingido() {
        return 3*poderMag;
    }

    @Override
    public void iLanzar() {
        System.out.println("Ha lanzado un ataque magico de "+idamageInflingido()+" daño con coste "+iCoste());
    }
}
