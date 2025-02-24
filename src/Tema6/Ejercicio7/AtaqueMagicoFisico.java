package Tema6.Ejercicio7;

public class AtaqueMagicoFisico implements Ataque {
    int poderMagico,fuerza;

    public AtaqueMagicoFisico(){
        poderMagico=0;
        fuerza=0;
    }

    public AtaqueMagicoFisico(int poderMagico, int fuerza)throws Exception {
        if (poderMagico>0 && fuerza>0) {
            this.poderMagico = poderMagico;
            this.fuerza = fuerza;
        }else {
            throw new Exception("El valor no puede ser negativo");
        }
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico)throws Exception {
        if (poderMagico>0) {
            this.poderMagico = poderMagico;
        }else{
            throw new Exception("El valor no puede ser negativo");
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza)throws Exception {
        if (fuerza>0) {
            this.fuerza = fuerza;
        }else {
            throw new Exception("El valor no puede ser negativo");
        }
    }

    @Override
    public int iCoste() {
        return (poderMagico*2)+fuerza;
    }

    @Override
    public int idamageInflingido() {
        return (poderMagico*2)+(fuerza*2);
    }

    @Override
    public void iLanzar() {
        System.out.println("He lanzado atauqe magico y fuerza "+idamageInflingido()+"daño con un coste de "+iCoste());
    }
}
