package Tema4.Ejercicio1;
/*ALEJANDRO ASENCIO GURAU
*  Haz una clase Reloj y una clase que cree uno o varios objetos reloj y ejecute
 todos los métodos. La clase reloj debe ser capaz de almacenar la hora (hora,
 minuto y segundo) y el modo en que se mostrará la hora (12 horas o 24 horas).
 En la clase Reloj se implementará los siguientes métodos:
 a) Un constructor vacío.
 b) Un constructor que reciba 3 parámetros: horas, minutos y segundos.
 c) Getters y setters para todos los atributos (los setters deben validar los
 nuevos valores introducidos).
 d) Un método que mostrará la hora por pantalla.
 e) Intenta hacer un System.out.println(reloj) dónde la variable reloj es de
 la clase Reloj ¿qué ocurre? Implementa un método toString() que
 devuelva una cadena con la hora ¿qué ocurre ahora en el print?*/
public class Reloj {
    private int horas,min,seg;
    private boolean formato24;
    public Reloj(){
        horas=0;
        min=0;
        seg=0;
        this.formato24=true;
    }

    public Reloj(int horas, int min, int seg) {
        this.horas = horas;
        this.min = min;
        this.seg = seg;
        this.formato24=true;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        if (min>=0 && min<=59) {
            this.seg = seg;
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        if (min>=0 && min<=59) {
            this.min = min;
        }
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if (horas>=0 && horas<=23) {
            this.horas = horas;
        }
    }

    public boolean getFormato24(){
        return formato24;
    }

    public void setFormato24(boolean formato24) {
        this.formato24 = formato24;
    }

    public String mostrarHora(int horas, int min, int seg,boolean formato){
      String res;
      if (formato){
          res=String.format("%02d:%02d:%02d", horas, min, seg);
      }else{
          horas%=12;
          if (horas==0){
              horas=12;
          }
          String periodoHora;
          if (horas<12){
              periodoHora="AM";
          }else {
              periodoHora="PM";
          }
          res=String.format("%02d:%02d:%02d %s", horas, min, seg, periodoHora);
      }
      return res;
    }

    @Override
    public String toString() {
        return "Reloj{" +
                "horas=" + horas +
                ", minutos=" + min +
                ", segundos=" + seg +
                ", formato24="+formato24+
                '}';
    }
}
