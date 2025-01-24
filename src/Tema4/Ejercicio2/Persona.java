package Tema4.Ejercicio2;

/* ALEJANDRO ASENCIO GURAU
*  2. Crea un programa principal y una clase Persona que representará los datos
 principales de una persona: dni, nombre, apellidos y edad.
 En el main de la clase principal pide por teclado los datos de 2 personas y
 guárdalos en dos objetos de la clase Persona y utiliza todos los métodos que
 crearemos a continuación.
 Métodos / atributos a implementar:----------
 Implementa un constructor con parámetros.
 Implementar getters y setters.
 print(), muestra por pantalla la información de la persona.
 isAdult(), indica si es mayor de edad o no.
 isRetired(), indica si está jubilado o no (>65 años).
 ageDifference(), recibe como parámetro otra persona e indica la diferencia de
 edad.
 haz que el dni sea un atributo que no se pueda modificar (final).
 crea un atributo adultAge final y static que valga 18. Utilízalo.
 crea un atributo retiredAge final y static que valga 65. Utilízalo.
 checkDNI(), será un método estático que devuelve si el dni es correcto o no*/
public class Persona {
    final static int adultAge = 18;
    final static int retiredAge = 65;
    private final String dni;
    private String nombre, apellidos;
    private int edad;

    public Persona(String nombre, String apellidos, String dni, int edad) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        this.dni=dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad>=0) {
            this.edad = edad;
        }
    }

    public void print() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellidos: "+apellidos);
        System.out.println("DNI: "+dni);
        System.out.println("Edad: "+edad);
    }

    public boolean isAdult(){
        boolean res=false;
        if (this.edad>=adultAge){
            res=true;
        }
        return res;
    }

    public boolean isRetired(){
        boolean res=false;
        if (this.edad>retiredAge){
            res=true;
        }
        return res;
    }

    public int ageDifference(Persona otraPersona){
        int res;
        res=Math.abs(this.edad-otraPersona.getEdad());
        return res;
    }

    public static boolean checkDNI(String dni){
        boolean res;
        String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
        //Extraer los primeros 9 caracteres
        String numDni = dni.substring(0, 8);
        //Extraer los primeros 8 caracteres
        char letraIntroducida = dni.charAt(8);
        //Convertir los primeros 8 caracteres en numeros entero
        int valDni = Integer.parseInt(numDni);
        //calcular la letra correspondiente
        char letraVal = letrasDni.charAt(valDni % 23);
        res = letraVal == letraIntroducida;
        return res;
    }

}
