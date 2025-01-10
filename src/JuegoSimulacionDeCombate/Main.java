package JuegoSimulacionDeCombate;

import java.util.Random;
import java.util.Scanner;

//ALEJANDRO ASENCIO GURAU
/*IMPLEMENTACION FUTURA un nuevo atributo que se llame regenerar, dos nuevas variables que seria las acciones de cada turno tanto para el jugador 1
 * como para el jugador 2. Añadir un switch en el bucle principal dentro de los if donde la accion que es de tipo char el usuario elegiria A(atacar)
 * C(curar), en curacion si la vida es mayor a 200, debe ser igual a 200 y en caso que no seleccione ninguno pierde el turno el jugador seleccionado.
 * Luego añdir un ataque critico en el booleano con un random.nextDouble()
 * si es menor a esCritico se multiplica por dos el daño */
public class Main {

    public static void main(String[] args) {
        //Random declarado como rand
        Random rand = new Random();
        //Scanner declarado como sc
        Scanner sc = new Scanner(System.in);
        //Las variables terminado en 2 son para el jugador2
        //las variables del jugador1 cuenta las rondas,daño del ataque,el daño base para atacar
        int velocidad1=0, ataqueBase1=0, defensaBase1=0, vida1=0, sumaAtributos1, hit1, regenerar1=25, rondas = 1,estimulantes1=0;

        //las variables del jugador2
        int velocidad2=0,ataqueBase2=0,defensaBase2=0,vida2=0,sumaAtributos2,hit2,regenerar2=25,estimulantes2=0;

        //opciones para que el usurio introduzca
        int opcionFaccion1, opcionFaccion2, opcionClase1, opcionClase2, opcionJug1, opcionJug2;

        //Variables que afectan al daño
        int aleatorio;

        //Variable final que pone un limite de daño
        final int limiteDamage=5;

        //acciones para que el usurio introduzca
        char accion1,accion2,crearPersonaje,confirmarFaccion1,confirmarFaccion2,confirmarClase1,confirmarClase2;

        //cadenas de texto en el que pone nombre a los jugadores
        String faccion1 = "", faccion2 = "", clase1 = "", clase2 = "",nombre1="",nombre2="",genero1="",genero2="";

        //Variables para multiplicar el daño en caso de critico(20%)
        int esCritico1 = rand.nextInt(100), esCritico2 = rand.nextInt(100), probabilidadCritico = 8;

        //condicion para entrar en el combate entre los dos jugadores, y si quiere crear al personaje o no
        boolean combate = true, crearFac1=true,crearClase1=true,crearFac2=true,crearClase2=true;

        System.out.println("Desea crear un personaje o no(Y/N): ");
        crearPersonaje=sc.next().toUpperCase().charAt(0);
        if (crearPersonaje=='Y') {
            //Realizo un do while para comprobar que la suma de los atributos no supere 500(JUAGDOR1)
            do {
                sc.nextLine();
                System.out.println("Introduce un nombre para tu personaje 1: ");
                nombre1=sc.nextLine();
                System.out.println("Introduce tu sexo: ");
                genero1=sc.nextLine();

                while (crearClase1) {
                    System.out.println(nombre1 + "\nELIGE UNA CLASE " + "\n1.Cientifico" + "\n2.Lider Carismatico" + "\n3.Mercenario" + "\n4.Saqueador");
                    opcionClase1 = sc.nextInt();
                    switch (opcionClase1) {
                        case 1:
                            clase1 = "Cientifico";
                            System.out.println("Habilidad especial: utilizar armas de energia(Daño*2)");
                            System.out.println("Desea esta eleccion de clase(Y/N): ");
                            confirmarClase1=sc.next().toUpperCase().charAt(0);
                            if (confirmarClase1=='Y') {
                                crearClase1 = false;
                            }
                            break;
                        case 2:
                            clase1 = "Lider Carismatico";
                            System.out.println("Habilidad especial: Convencer al rival que pierda");
                            System.out.println("Desea esta eleccion de clase(Y/N): ");
                            confirmarClase1=sc.next().toUpperCase().charAt(0);
                            if (confirmarClase1=='Y') {
                                crearClase1 = false;
                            }
                            break;
                        case 3:
                            clase1 = "Mercenario";
                            System.out.println("Habilidad especial:Atacara tres veces al contraio");
                            System.out.println("Desea esta eleccion de clase(Y/N): ");
                            confirmarClase1=sc.next().toUpperCase().charAt(0);
                            if (confirmarClase1=='Y') {
                                crearClase1 = false;
                            }
                            break;
                        case 4:
                            clase1 = "Saqueador";
                            System.out.println("Habilidad especial le robas su inventario haciendo que no te pueda atacar en ese turno");
                            System.out.println("Desea esta eleccion de clase(Y/N): ");
                            confirmarClase1=sc.next().toUpperCase().charAt(0);
                            if (confirmarClase1=='Y') {
                                crearClase1 = false;
                            }
                            break;
                        default:
                            System.err.println("ERROR: EN LA SELECCION DE CLASE.¡VUELVE A INTRODUCIR LA CLASE!");
                            crearClase1 = true;
                    }
                }
                System.out.println(nombre1);
                System.out.println(faccion1);
                System.out.println(clase1);
                System.out.println("Introduce los valores para velocidad1,vida1,defensa,ataque(La suma de los atributos no debe ser mayor a 500): " + "\nCada uno de los atributos debe ser entre (1-200) ");
                System.out.println("Velocidad: ");
                velocidad1 = sc.nextInt();
                System.out.println("Vida: ");
                vida1 = sc.nextInt();
                System.out.println("Defensa: ");
                defensaBase1 = sc.nextInt();
                System.out.println("Ataque: ");
                ataqueBase1 = sc.nextInt();
                sumaAtributos1 = velocidad1 + vida1 + defensaBase1 + ataqueBase1;
                if ((sumaAtributos1 > 500) && (velocidad1 >= 1 && velocidad1 <= 200 && ataqueBase1 >= 1 && ataqueBase1 <= 200 &&
                        vida1 >= 1 && vida1 <= 200 && defensaBase1 >= 1 && defensaBase1 <= 200)){
                    System.err.println("ERROR: LA SUMA DE LOS ATRIBUTOS O LOS VALORES INTRODUCIDOS NO CUMPLEN EL REQUISITO.¡VUELVA A CREAR LOS PERSONAJES!");
                }
                System.out.println(" ____________JUGADOR1________________\n" +
                        "|"+nombre1+"[HP]"+vida1+"[AB]"+ataqueBase1+"[DF]"+defensaBase1+"[VL]"+velocidad1+"\n" +
                        "|--------------------------------------------|\n" +
                        "| SEX: " + genero1 + "                                 |\n" +
                        "| FACCION:" + faccion1 + "                                |\n" +
                        "| CLASE: " + clase1 + "                           |\n" +
                        "| RAD:         (r)                           |\n" +
                        "| SLP: <<<<<<<<(s)                           |\n" +
                        "| H2O: <<<<<<<<(h)                           |\n" +
                        "| FOD: <<<<<<<<(f)                           |\n" +
                        "|                                            |\n" +
                        "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           |\n" +
                        "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⠿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀          |\n" +
                        "|⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣤⣤⣴⣿⠟⠁⠀⠈⠛⠿⣿⣿⣶⣶⣄         |\n" +
                        "|⠀⢀⣴⣶⣇⠀⢀⣴⣿⠟⠉⠉⠙⠛⠁⠀⠀⠀⠀⠀⠀⠀⠈⠉⠻⣿⣆       |\n" +
                        "|⢀⣿⡟⠙⢿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣷⣄     |\n" +
                        "|⠸⣿⡇⠀⠀⠀⠀⠀⢀⡴⠶⢦⣄⣀⣤⠾⠛⠛⣧⡀⠀⠀⠀⠀⠀⠀⠈⠛⢿⣿⣄ |\n" +
                        "|⢠⣿⣇⠀⠀⠀⠀⣴⠋⠀⠀⠀⠈⠉⠁⠀⠀⠀⠈⠻⣦⣤⡤⠶⠻⢿⣦⠀⠀⢻⣿⣆ |\n" +
                        "|⢸⣿⠉⢳⣶⢶⡿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⣿⠁⠀⠀⣿⣿   |\n" +
                        "|⠘⣿⣄⡾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠄⠀⠀⠀⠀⢠⡼⠋⠀⠀⠀⣿⣿⠀⠀ |\n" +
                        "|⠀⢹⡿⠁⠀⢀⣾⡇⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠠⣝⢦⡀⠀⠀⣿⣿⠀  |\n" +
                        "|⢀⣿⠇⠀⠀⠘⣿⠇⠀⠀⢀⠎⠀⠀⠀⠘⠛⠛⠿⠆⠀⠀⠀⠀⠠⣝⢧⡳⡄⣸⣿⡟⠀ |\n" +
                        "|⢸⣿⠀⠀⠀⠀⠀⠀⢠⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢢⣜⢷⣽⣷⣿⣿⠃⠀⠀⠀ |\n" +
                        "|⢸⡏⠀⠀⠀⠀⠀⠀⢿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠆⣹⣿⣿⠃⠀⠀⠀⠀⠀ |\n" +
                        "|⢸⣇⠀⠀⠀⠀⠀⠀⠈⠛⠂⠀⠀⠀⠀⢠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣷⠀⠀⠀⠀⠀⠀ |\n" +
                        "|⢸⣿⠀⠀⣾⣤⣀⣀⣀⢀⣀⣀⣀⡤⠔⠚⢿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⠀⠀⠀⠀ |\n" +
                        "|⠀⣿⣇⠀⠻⠳⢤⣈⣉⠉⠉⠀⣀⣀⣤⠖⠋⠟⠀⠀⠀⠀⠀⠀⢀⣀⣠⣾⣿⠃⠀⠀⠀⠀ |\n" +
                        "|⠀⠘⣿⣆⠀⠀⠀⠈⠙⣛⣛⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠿⠛⠋⠀⠀⠀⠀⠀⠀⠀ |\n" +
                        "|⠀⠀⠘⢿⣧⡀⠀⠀⠈⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |\n" +
                        "|⠀⠀⠀⠈⠻⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  |\n" +
                        "|⠀⠀⠀⠀⠀⠈⠙⠿⣿⣶⣦⣤⣤⣤⣤⣶⣶⣿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀|\n" +
                        "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |\n" +
                        "| LEVEL 1                                    |\n" +
                        "|--------------------------------------------|\n" +
                        "| Stimpak (a)                                |\n" +
                        "| Bag (d)                                    |\n" +
                        "| EFF:                                       |\n" +
                        "|--------------------------------------------|\n" +
                        "| [Status] (4)SPECIAL (5)Skills              |\n" +
                        "| (6)Perks (7)General                        |\n" +
                        "|--------------------------------------------|\n" +
                        "| STATS ITEMS DATA                           |\n" +
                        "| (1)   (2)   (3)                            |\n" +
                        "|____________________________________________|\n");
            }while ((sumaAtributos1 > 500) && (velocidad1 >= 1 && velocidad1 <= 200 && ataqueBase1 >= 1 && ataqueBase1 <= 200 &&
                    vida1 >= 1 && vida1 <= 200 && defensaBase1 >= 1 && defensaBase1 <= 200));

            //BUCLE PARA EL JUGADOR 2
            do {
                sc.nextLine();
                System.out.println("Introduce un nombre para tu personaje 2: ");
                nombre2=sc.nextLine();
                System.out.println("Introduce tu sexo: ");
                genero2=sc.nextLine();
                while (crearFac2) {
                    System.out.println("HOLA, "+nombre2);
                    System.out.println("Que faccion quieres pertenecer: ");
                    System.out.println("1.PALADIN DE LA HERMANDAD DEL ACERO "+"\n2.SOLDADO DE LA RCN(REPUBLICA DE NUEVA CALIFORNIA)"+"\n3.LEGIONARIO DE LA LEGION DE CESAR"+"\n4.NINGUNA(LLANERO SOLITARIO)");
                    opcionFaccion2 = sc.nextInt();
                    switch (opcionFaccion2) {
                        case 1:
                            faccion2 = "HERMANDAD DEL ACERO";
                            System.out.println("La Hermandad del Acero es una organización tecno-religiosa, " +
                                    "formada por desertores del Ejército de los Estados Unidos durante los últimos momentos de la gran guerra. " +
                                    "Su objetivo es la recopilación del conocimiento y de la tecnología para poder reconstruir el mundo.");
                            System.out.println("Desea esta faccion(Y/N): ");
                            confirmarFaccion2=sc.next().toUpperCase().charAt(0);
                            if (confirmarFaccion2=='Y') {
                                crearFac2 = false;
                            }
                            break;
                        case 2:
                            faccion2 = "RCN";
                            System.out.println("La República de Nueva California (RNC) es una república federal fundada en Nueva California en 2189. Está compuesta por 5 estados contiguos en el sur de California, " +
                                    "con algunos territorios en el norte de California, Oregón y Nevada.\n" +
                                    "La RNC centra su existencia en conservar los valores del antiguo mundo, como la democracia, libertad personal, y las leyes al mismo tiempo que los promueve. " +
                                    "También apunta a restaurar el orden a todo el yermo, la mejora e instalación de infraestructura y sistemas monetarios, y paz incondicional entre la gente.");
                            System.out.println("Desea esta faccion(Y/N): ");
                            confirmarFaccion2=sc.next().toUpperCase().charAt(0);
                            if (confirmarFaccion2=='Y') {
                                crearFac2 = false;
                            }
                            break;
                        case 3:
                            faccion2 = "LEGION DE CESAR";
                            System.out.println("La Legión de César (en latín: Legio Caesaris) es una dictadura imperialista y totalitaria de gran escala basada en la esclavitud. " +
                                    "Fue fundada en 2247 por Edward Sallow, que luego se nombró César él mismo, y Joshua Graham (también conocido como Legado Malpais). " +
                                    "Toda su militarización está inspirada por el Imperio Romano, dándole un nuevo uso a su lenguaje y estéticas en el mundo posnuclear.");
                            System.out.println("Desea esta faccion(Y/N): ");
                            confirmarFaccion2=sc.next().toUpperCase().charAt(0);
                            if (confirmarFaccion2=='Y') {
                                crearFac2 = false;
                            }
                            break;
                        case 4:
                            faccion2="LLANERO SOLITARIO";
                            System.out.println("Estas seguro de esta eleccion?: ");
                            System.out.println("Desea esta faccion(Y/N): ");
                            confirmarFaccion2=sc.next().toUpperCase().charAt(0);
                            if (confirmarFaccion2=='Y') {
                                crearFac2 = false;
                            }
                            break;
                        default:
                            System.err.println("ERROR: LA FACCION NO RECONOCIDA.¡VUELVA A INTRODUCIRLO!");
                            crearFac2=true;
                    }
                }

                while (crearClase2) {
                    System.out.println(nombre2 + "\nELIGE UNA CLASE " + "\n1.Cientifico" + "\n2.Lider Carismatico" + "\n3.Mercenario" + "\n4.Saqueador");
                    opcionClase2 = sc.nextInt();
                    switch (opcionClase2) {
                        case 1:
                            clase2 = "Cientifico";
                            System.out.println("Habilidad especial: utilizar armas de energia(Daño*2)");
                            System.out.println("Desea esta eleccion de clase(Y/N): ");
                            confirmarClase2=sc.next().toUpperCase().charAt(0);
                            if (confirmarClase2=='Y') {
                                crearClase2 = false;

                            }
                            break;
                        case 2:
                            clase2 = "Lider Carismatico";
                            System.out.println("Habilidad especial: Convencer al rival que pierda");
                            System.out.println("Desea esta eleccion de clase(Y/N): ");
                            confirmarClase2=sc.next().toUpperCase().charAt(0);
                            if (confirmarClase2=='Y') {
                                crearClase2 = false;
                            }
                            break;
                        case 3:
                            clase1 = "Mercenario";
                            System.out.println("Habilidad especial:Atacara tres veces al contraio");
                            System.out.println("Desea esta eleccion de clase(Y/N): ");
                            confirmarClase2=sc.next().toUpperCase().charAt(0);
                            if (confirmarClase2=='Y') {
                                crearClase2 = false;
                            }
                            break;
                        case 4:
                            clase2 = "Saqueador";
                            System.out.println("Habilidad especial le robas su inventario haciendo que no te pueda atacar en ese turno");
                            System.out.println("Desea esta eleccion de clase(Y/N): ");
                            confirmarClase2=sc.next().toUpperCase().charAt(0);
                            if (confirmarClase2=='Y') {
                                crearClase2 = false;
                            }
                            break;
                        default:
                            System.err.println("ERROR: EN LA SELECCION DE CLASE.¡VUELVE A INTRODUCIR LA CLASE!");
                            crearClase2 = true;
                    }
                }
                System.out.println(nombre2);
                System.out.println(faccion2);
                System.out.println(clase2);
                System.out.println("Introduce los valores para velocidad1,vida1,defensa,ataque(La suma de los atributos no debe ser mayor a 500): ");
                System.out.println("Velocidad: ");
                velocidad2 = sc.nextInt();
                System.out.println("Vida: ");
                vida2 = sc.nextInt();
                System.out.println("Defensa: ");
                defensaBase2 = sc.nextInt();
                System.out.println("Ataque: ");
                ataqueBase2 = sc.nextInt();
                sumaAtributos2 = velocidad2 + vida2 + defensaBase2 + ataqueBase2;
                if ((sumaAtributos2 > 500) && (velocidad2 >= 1 && velocidad2 <= 200 && ataqueBase2 >= 1 && ataqueBase2 <= 200 &&
                        vida2 >= 1 && vida2 <= 200 && defensaBase2 >= 1 && defensaBase2 <= 200)){
                    System.err.println("ERROR: LA SUMA DE LOS ATRIBUTOS O LOS VALORES INTRODUCIDOS NO CUMPLEN EL REQUISITO.¡VUELVA A CREAR LOS PERSONAJES!");
                }//Cumple la condicion si supera 500 o los valores introducidos son menores a 1 o mayor a 200 PD: SE PUEDE REDUCIR CON UN METODO BOOLEAN
                System.out.println(" ____________JUGADOR2________________\n" +
                        "|"+nombre2+"[HP]"+vida2+"[AB]"+ataqueBase2+"[DF]"+defensaBase2+"[VL]"+velocidad2+"\n" +
                        "|--------------------------------------------|\n" +
                        "| SEX: " + genero2 + "                                 |\n" +
                        "| FACCION:" + faccion2 + "                                |\n" +
                        "| CLASE: " + clase2 + "                           |\n" +
                        "| RAD:         (r)                           |\n" +
                        "| SLP: <<<<<<<<(s)                           |\n" +
                        "| H2O: <<<<<<<<(h)                           |\n" +
                        "| FOD: <<<<<<<<(f)                           |\n" +
                        "|                                            |\n" +
                        "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           |\n" +
                        "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⠿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀          |\n" +
                        "|⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣤⣤⣴⣿⠟⠁⠀⠈⠛⠿⣿⣿⣶⣶⣄         |\n" +
                        "|⠀⢀⣴⣶⣇⠀⢀⣴⣿⠟⠉⠉⠙⠛⠁⠀⠀⠀⠀⠀⠀⠀⠈⠉⠻⣿⣆       |\n" +
                        "|⢀⣿⡟⠙⢿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣷⣄     |\n" +
                        "|⠸⣿⡇⠀⠀⠀⠀⠀⢀⡴⠶⢦⣄⣀⣤⠾⠛⠛⣧⡀⠀⠀⠀⠀⠀⠀⠈⠛⢿⣿⣄ |\n" +
                        "|⢠⣿⣇⠀⠀⠀⠀⣴⠋⠀⠀⠀⠈⠉⠁⠀⠀⠀⠈⠻⣦⣤⡤⠶⠻⢿⣦⠀⠀⢻⣿⣆ |\n" +
                        "|⢸⣿⠉⢳⣶⢶⡿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⣿⠁⠀⠀⣿⣿   |\n" +
                        "|⠘⣿⣄⡾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠄⠀⠀⠀⠀⢠⡼⠋⠀⠀⠀⣿⣿⠀⠀ |\n" +
                        "|⠀⢹⡿⠁⠀⢀⣾⡇⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠠⣝⢦⡀⠀⠀⣿⣿⠀  |\n" +
                        "|⢀⣿⠇⠀⠀⠘⣿⠇⠀⠀⢀⠎⠀⠀⠀⠘⠛⠛⠿⠆⠀⠀⠀⠀⠠⣝⢧⡳⡄⣸⣿⡟⠀ |\n" +
                        "|⢸⣿⠀⠀⠀⠀⠀⠀⢠⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢢⣜⢷⣽⣷⣿⣿⠃⠀⠀⠀ |\n" +
                        "|⢸⡏⠀⠀⠀⠀⠀⠀⢿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠆⣹⣿⣿⠃⠀⠀⠀⠀⠀ |\n" +
                        "|⢸⣇⠀⠀⠀⠀⠀⠀⠈⠛⠂⠀⠀⠀⠀⢠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣷⠀⠀⠀⠀⠀⠀ |\n" +
                        "|⢸⣿⠀⠀⣾⣤⣀⣀⣀⢀⣀⣀⣀⡤⠔⠚⢿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⠀⠀⠀⠀ |\n" +
                        "|⠀⣿⣇⠀⠻⠳⢤⣈⣉⠉⠉⠀⣀⣀⣤⠖⠋⠟⠀⠀⠀⠀⠀⠀⢀⣀⣠⣾⣿⠃⠀⠀⠀⠀ |\n" +
                        "|⠀⠘⣿⣆⠀⠀⠀⠈⠙⣛⣛⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠿⠛⠋⠀⠀⠀⠀⠀⠀⠀ |\n" +
                        "|⠀⠀⠘⢿⣧⡀⠀⠀⠈⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |\n" +
                        "|⠀⠀⠀⠈⠻⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  |\n" +
                        "|⠀⠀⠀⠀⠀⠈⠙⠿⣿⣶⣦⣤⣤⣤⣤⣶⣶⣿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀|\n" +
                        "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |\n" +
                        "| LEVEL 1                                    |\n" +
                        "|--------------------------------------------|\n" +
                        "| Stimpak (a)                                |\n" +
                        "| Bag (d)                                    |\n" +
                        "| EFF:                                       |\n" +
                        "|--------------------------------------------|\n" +
                        "| [Status] (4)SPECIAL (5)Skills              |\n" +
                        "| (6)Perks (7)General                        |\n" +
                        "|--------------------------------------------|\n" +
                        "| STATS ITEMS DATA                           |\n" +
                        "| (1)   (2)   (3)                            |\n" +
                        "|____________________________________________|\n");
            } while ((sumaAtributos2 > 500) && (velocidad2 >= 1 && velocidad2 <= 200 && ataqueBase2 >= 1 && ataqueBase2 <= 200 &&
                    vida2 >= 1 && vida2 <= 200 && defensaBase2 >= 1 && defensaBase2 <= 200));
        }else {
            //PLANTILLA DEFINIDA PARA LOS JUGADORES(REALIZAR PRUEBAS)
            //Plantilla de jugador 1, para realizar pruebas
            System.out.println("JUGADOR 1");
            System.out.println("1.MARCUS->FACCION LEGION DE CESAR ->CLASE:MERCENARIO"+"\n2.VAL->FACCION: RCN-> CLASE:SAQUEADOR "+"\n3.JACQUIE->FACCION: HERMANDAD DEL ACERO -> CLASE: LIDER CARISMATICO");
            System.out.println("Selecciona un jugador: ");
            opcionJug1=sc.nextInt();
            switch (opcionJug1){
                case 1:
                    nombre1="MARCUS";
                    genero1="HOMBRE";
                    faccion1="LEGION DE CESAR";
                    clase1="MERCENARIO";
                    velocidad1=150;
                    vida1=100;
                    defensaBase1=100;
                    ataqueBase1=100;
                    break;
                case 2:
                    nombre1="VAL";
                    genero1="MUJER";
                    faccion1="RCN";
                    clase1="SAQUEADOR";
                    velocidad1=150;
                    vida1=100;
                    defensaBase1=100;
                    ataqueBase1=150;
                    break;
                case 3:
                    nombre1="JACQUIE";
                    genero1="EPSILON";
                    faccion1="HERMANDAD DEL ACERO";
                    clase1="LIDER CARISMATICO";
                    velocidad1=150;
                    vida1=100;
                    defensaBase1=120;
                    ataqueBase1=130;
                    break;

            }

            System.out.println("JUGADOR 2");
            System.out.println("1.HERNAN->FACCION: LLANERO SOLITARIO -> CLASE: LIDER CARISMATICO "+"\n2.JOHN->FACCION:HERMANDAD DEL ACERO -> CLASE: CIENTIFICO "+"\n3.DIEGO->FACCION: LEGION DEL CESAR -> CLASE: SAQUEADOR");
            System.out.println("Seleciona un jugador : ");
            opcionJug2=sc.nextInt();
            switch (opcionJug2){
                case 1:
                    nombre2="HERNAN";
                    genero2="HOMBRE";
                    faccion2="LLANERO SOLITARIO";
                    clase2="LIDER CARISMATICO";
                    velocidad2=100;
                    vida2=100;
                    defensaBase2=100;
                    ataqueBase2=150;
                    break;
                case 2:
                    nombre2="JOHN";
                    genero2="MUJER";
                    faccion2="HERMANDAD DEL ACERO";
                    clase2="CIENTIFICO";
                    velocidad2=200;
                    vida2=100;
                    defensaBase2=100;
                    ataqueBase2=50;
                    break;
                case 3:
                    nombre2="DIEGO";
                    genero2="CIERVO";
                    faccion2="LEGION DEL CESAR";
                    clase2="SAQUEADOR";
                    velocidad2=150;
                    vida2=150;
                    defensaBase2=100;
                    ataqueBase2=100;
                    break;
                default:
                    System.out.println("ELECCION INCORRECTA:¡VUELVA A ELEGIR!");
            }

            System.out.println(" ____________JUGADOR1________________\n" +
                    "|"+nombre1+"[HP]"+vida1+"[AB]"+ataqueBase1+"[DF]"+defensaBase1+"[VL]"+velocidad1+"\n" +
                    "|--------------------------------------------|\n" +
                    "| SEX: " + genero1 + "                                 |\n" +
                    "| FACCION:" + faccion1 + "                                |\n" +
                    "| CLASE: " + clase1 + "                           |\n" +
                    "| RAD:         (r)                           |\n" +
                    "| SLP: <<<<<<<<(s)                           |\n" +
                    "| H2O: <<<<<<<<(h)                           |\n" +
                    "| FOD: <<<<<<<<(f)                           |\n" +
                    "|                                            |\n" +
                    "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           |\n" +
                    "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⠿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀          |\n" +
                    "|⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣤⣤⣴⣿⠟⠁⠀⠈⠛⠿⣿⣿⣶⣶⣄         |\n" +
                    "|⠀⢀⣴⣶⣇⠀⢀⣴⣿⠟⠉⠉⠙⠛⠁⠀⠀⠀⠀⠀⠀⠀⠈⠉⠻⣿⣆       |\n" +
                    "|⢀⣿⡟⠙⢿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣷⣄     |\n" +
                    "|⠸⣿⡇⠀⠀⠀⠀⠀⢀⡴⠶⢦⣄⣀⣤⠾⠛⠛⣧⡀⠀⠀⠀⠀⠀⠀⠈⠛⢿⣿⣄ |\n" +
                    "|⢠⣿⣇⠀⠀⠀⠀⣴⠋⠀⠀⠀⠈⠉⠁⠀⠀⠀⠈⠻⣦⣤⡤⠶⠻⢿⣦⠀⠀⢻⣿⣆ |\n" +
                    "|⢸⣿⠉⢳⣶⢶⡿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⣿⠁⠀⠀⣿⣿   |\n" +
                    "|⠘⣿⣄⡾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠄⠀⠀⠀⠀⢠⡼⠋⠀⠀⠀⣿⣿⠀⠀ |\n" +
                    "|⠀⢹⡿⠁⠀⢀⣾⡇⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠠⣝⢦⡀⠀⠀⣿⣿⠀  |\n" +
                    "|⢀⣿⠇⠀⠀⠘⣿⠇⠀⠀⢀⠎⠀⠀⠀⠘⠛⠛⠿⠆⠀⠀⠀⠀⠠⣝⢧⡳⡄⣸⣿⡟⠀ |\n" +
                    "|⢸⣿⠀⠀⠀⠀⠀⠀⢠⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢢⣜⢷⣽⣷⣿⣿⠃⠀⠀⠀ |\n" +
                    "|⢸⡏⠀⠀⠀⠀⠀⠀⢿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠆⣹⣿⣿⠃⠀⠀⠀⠀⠀ |\n" +
                    "|⢸⣇⠀⠀⠀⠀⠀⠀⠈⠛⠂⠀⠀⠀⠀⢠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣷⠀⠀⠀⠀⠀⠀ |\n" +
                    "|⢸⣿⠀⠀⣾⣤⣀⣀⣀⢀⣀⣀⣀⡤⠔⠚⢿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⠀⠀⠀⠀ |\n" +
                    "|⠀⣿⣇⠀⠻⠳⢤⣈⣉⠉⠉⠀⣀⣀⣤⠖⠋⠟⠀⠀⠀⠀⠀⠀⢀⣀⣠⣾⣿⠃⠀⠀⠀⠀ |\n" +
                    "|⠀⠘⣿⣆⠀⠀⠀⠈⠙⣛⣛⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠿⠛⠋⠀⠀⠀⠀⠀⠀⠀ |\n" +
                    "|⠀⠀⠘⢿⣧⡀⠀⠀⠈⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |\n" +
                    "|⠀⠀⠀⠈⠻⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  |\n" +
                    "|⠀⠀⠀⠀⠀⠈⠙⠿⣿⣶⣦⣤⣤⣤⣤⣶⣶⣿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀|\n" +
                    "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |\n" +
                    "| LEVEL 99                                    |\n" +
                    "|--------------------------------------------|\n" +
                    "| Stimpak (a)                                |\n" +
                    "| Bag (d)                                    |\n" +
                    "| EFF:                                       |\n" +
                    "|--------------------------------------------|\n" +
                    "| [Status] (4)SPECIAL (5)Skills              |\n" +
                    "| (6)Perks (7)General                        |\n" +
                    "|--------------------------------------------|\n" +
                    "| STATS ITEMS DATA                           |\n" +
                    "| (1)   (2)   (3)                            |\n" +
                    "|____________________________________________|\n");

            System.out.println(" ____________JUGADOR2________________\n" +
                    "|"+nombre2+"[HP]"+vida2+"[AB]"+ataqueBase2+"[DF]"+defensaBase2+"[VL]"+velocidad2+"\n" +
                    "|--------------------------------------------|\n" +
                    "| SEX: " + genero2 + "                                 |\n" +
                    "| FACCION:" + faccion2 + "                                |\n" +
                    "| CLASE: " + clase2 + "                           |\n" +
                    "| RAD:         (r)                           |\n" +
                    "| SLP: <<<<<<<<(s)                           |\n" +
                    "| H2O: <<<<<<<<(h)                           |\n" +
                    "| FOD: <<<<<<<<(f)                           |\n" +
                    "|                                            |\n" +
                    "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           |\n" +
                    "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⠿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀          |\n" +
                    "|⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣤⣤⣴⣿⠟⠁⠀⠈⠛⠿⣿⣿⣶⣶⣄         |\n" +
                    "|⠀⢀⣴⣶⣇⠀⢀⣴⣿⠟⠉⠉⠙⠛⠁⠀⠀⠀⠀⠀⠀⠀⠈⠉⠻⣿⣆       |\n" +
                    "|⢀⣿⡟⠙⢿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣷⣄     |\n" +
                    "|⠸⣿⡇⠀⠀⠀⠀⠀⢀⡴⠶⢦⣄⣀⣤⠾⠛⠛⣧⡀⠀⠀⠀⠀⠀⠀⠈⠛⢿⣿⣄ |\n" +
                    "|⢠⣿⣇⠀⠀⠀⠀⣴⠋⠀⠀⠀⠈⠉⠁⠀⠀⠀⠈⠻⣦⣤⡤⠶⠻⢿⣦⠀⠀⢻⣿⣆ |\n" +
                    "|⢸⣿⠉⢳⣶⢶⡿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⣿⠁⠀⠀⣿⣿   |\n" +
                    "|⠘⣿⣄⡾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠄⠀⠀⠀⠀⢠⡼⠋⠀⠀⠀⣿⣿⠀⠀ |\n" +
                    "|⠀⢹⡿⠁⠀⢀⣾⡇⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠠⣝⢦⡀⠀⠀⣿⣿⠀  |\n" +
                    "|⢀⣿⠇⠀⠀⠘⣿⠇⠀⠀⢀⠎⠀⠀⠀⠘⠛⠛⠿⠆⠀⠀⠀⠀⠠⣝⢧⡳⡄⣸⣿⡟⠀ |\n" +
                    "|⢸⣿⠀⠀⠀⠀⠀⠀⢠⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢢⣜⢷⣽⣷⣿⣿⠃⠀⠀⠀ |\n" +
                    "|⢸⡏⠀⠀⠀⠀⠀⠀⢿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠆⣹⣿⣿⠃⠀⠀⠀⠀⠀ |\n" +
                    "|⢸⣇⠀⠀⠀⠀⠀⠀⠈⠛⠂⠀⠀⠀⠀⢠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣷⠀⠀⠀⠀⠀⠀ |\n" +
                    "|⢸⣿⠀⠀⣾⣤⣀⣀⣀⢀⣀⣀⣀⡤⠔⠚⢿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⠀⠀⠀⠀ |\n" +
                    "|⠀⣿⣇⠀⠻⠳⢤⣈⣉⠉⠉⠀⣀⣀⣤⠖⠋⠟⠀⠀⠀⠀⠀⠀⢀⣀⣠⣾⣿⠃⠀⠀⠀⠀ |\n" +
                    "|⠀⠘⣿⣆⠀⠀⠀⠈⠙⣛⣛⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠿⠛⠋⠀⠀⠀⠀⠀⠀⠀ |\n" +
                    "|⠀⠀⠘⢿⣧⡀⠀⠀⠈⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |\n" +
                    "|⠀⠀⠀⠈⠻⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  |\n" +
                    "|⠀⠀⠀⠀⠀⠈⠙⠿⣿⣶⣦⣤⣤⣤⣤⣶⣶⣿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀|\n" +
                    "|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |\n" +
                    "| LEVEL 99                                    |\n" +
                    "|--------------------------------------------|\n" +
                    "| Stimpak (a)                                |\n" +
                    "| Bag (d)                                    |\n" +
                    "| EFF:                                       |\n" +
                    "|--------------------------------------------|\n" +
                    "| [Status] (4)SPECIAL (5)Skills              |\n" +
                    "| (6)Perks (7)General                        |\n" +
                    "|--------------------------------------------|\n" +
                    "| STATS ITEMS DATA                           |\n" +
                    "| (1)   (2)   (3)                            |\n" +
                    "|____________________________________________|\n");


        }

        while (combate) {
            //ESTO SE PODRIA REDUCIR CON UN METODO String
            int barras = vida1 / 2, barras2 = vida2 / 2;
            //Mofifica y ordena la cadena para que me aparezaca recta con StringBuilder como: --------------------------- en vez de - \n -
            StringBuilder barra1 = new StringBuilder();
            StringBuilder barra2 = new StringBuilder();
            //Bucle para reccorer la vida1 del jugador y mostrar la vida1 de manera grafica
            for (int i = 0; i < barras; i++) {
                barra1.append("\uD83E\uDD0D");//CORAZON NEGRO
            }
            for (int i = 0; i < barras2; i++) {
                barra2.append("\uD83E\uDD0D");//CORAZON NEGRO
            }
            System.out.println("\n**********************************************");
            System.out.println("RONDA " + rondas);
            System.out.println(nombre1+" FACCION: "+faccion1 + ", CLASE: "+ clase1+", VIDA: " + vida1 + " " + barra1);
            System.out.println(nombre2+" FACCION: "+faccion2 + ", CLASE: "+ clase2+ ", VIDA: " + vida2 + " " + barra2);

            //determinar quien ataca primero PD: SE PUEDE REDUCIR CON UN METODO INT
            if (velocidad1 >= velocidad2) {
                System.out.println(nombre1+ " Realiza una accion: "+"\nA.Atacar" + "\nC.Curar: ");
                accion1=sc.next().toUpperCase().charAt(0);
                //Ataque jugador 1 a jugador 2
                switch (accion1){
                    case 'A':
                        //Genera cada vez que se da una vuelta al bucle un numero aleatorio entre 0 y 10
                        aleatorio= rand.nextInt(10)+limiteDamage;
                        hit1 = Math.max(limiteDamage, (ataqueBase1-(defensaBase2/2)) + aleatorio);
                        // Verificar si es un ataque crítico
                        if (esCritico1 < probabilidadCritico) {
                            hit1 = (int) (hit1 * 1.3); // Aplica el multiplicador de daño crítico
                            System.out.println(nombre1 + " realiza un ataque CRÍTICO!");
                        }
                        //hit1=Math.min(hit1,limiteDamage);//Utilizo Math.min para que tenga un rango de atque aceptable
                        vida2 -= hit1;
                        vida2 = Math.max(0, vida2); // Evitar que vida2 sea negativa
                        System.out.println(nombre1+" golpea primero con "+hit1+" de daño");
                        //Ataque jugador 2 a jugador 1
                        if (vida2>0){
                            //Genera cada vez que se da una vuelta al bucle un numero aleatorio entre 0 y 10
                            aleatorio= rand.nextInt(10)+limiteDamage;
                            System.out.println(nombre2+ " Reailza una accion: "+"\nA.Atacar"+"\nC.Curar");
                            accion2=sc.next().toUpperCase().charAt(0);
                            switch (accion2) {
                                case 'A':
                                    hit2 = Math.max(limiteDamage, (ataqueBase2-(defensaBase1/2)) + aleatorio);
                                    // Verificar si es un ataque crítico
                                    if (esCritico2 < probabilidadCritico) {
                                        hit2 = (int) (hit2 * 1.3); // Aplica el multiplicador de daño crítico
                                        System.out.println(nombre2 + " realiza un ataque CRÍTICO!");
                                    }
                                    //hit2 = Math.min(hit2, limiteDamage);
                                    vida1 -= hit2;
                                    vida1 = Math.max(0, vida1); // Evitar que vida2 sea negativa
                                    System.out.println(nombre2 + " golpea primero con " + hit2 + " de daño");
                                    break;

                                case 'C':
                                    if (estimulantes2<=5) {
                                        vida2 += regenerar2;
                                        vida2 = Math.min(vida2, 200); // Evitar que vida1 supere 200
                                        estimulantes2++;
                                        System.out.println(nombre2 + " se cura, "+vida2);
                                    }else {
                                        System.out.println(nombre2+" no puedes usar mas estimulantes. Limite: 5");
                                    }
                                    break;
                                default:
                                    System.out.println("Accion no reconocida");
                            }
                        }
                        break;
                    case 'C':
                        if (estimulantes1<=5) {
                            vida1 += regenerar1;
                            vida1 = Math.min(vida1, 200); // Evitar que vida1 supere 200
                            estimulantes1++;
                            System.out.println(nombre1 + " se cura, "+vida1);
                        }else {
                            System.out.println(nombre1+" no puedes usar mas estimulantes. Limite: 5");
                        }
                        break;
                    case 'H':
                        break;
                    default:
                        System.out.println("Caracter no valido, turno no valido");
                }

            } else {
                System.out.println(nombre2 + " Realiza una accion: " + "\nA.Atacar" + "\nC.Curar: ");
                accion2=sc.next().toUpperCase().charAt(0);
                switch (accion2){
                    case 'A':
                        //Genera cada vez que se da una vuelta al bucle un numero aleatorio entre 0 y 10
                        aleatorio= rand.nextInt(10)+limiteDamage;
                        //Ataque del segundo jugador al jugador 1
                        hit2 = Math.max(limiteDamage, (ataqueBase2-(defensaBase1/2)) + aleatorio);
                        if (esCritico2 < probabilidadCritico) {
                            hit2 = (int) (hit2 * 1.3);
                            System.out.println(nombre2 + " realiza un ataque CRÍTICO!");
                        }
                        //hit2=Math.min(hit2,limiteDamage);
                        vida1 -= hit2;
                        vida1 = Math.max(0, vida1);
                        System.out.println(nombre2+" golpea primero con "+hit2+" de daño");

                        //Ataque del primer jugador al segundo
                        if (vida1>0){
                            System.out.println(faccion1+ " Reailza una accion: "+"\nA.Atacar"+"\nC.Curar");
                            accion1=sc.next().toUpperCase().charAt(0);
                            switch (accion1) {
                                case 'A':
                                    //Genera cada vez que se da una vuelta al bucle un numero aleatorio entre 0 y 10
                                    aleatorio= rand.nextInt(10)+limiteDamage;
                                    hit1 = Math.max(limiteDamage, (ataqueBase1-(defensaBase2/2)) + aleatorio);
                                    // Verificar si es un ataque crítico
                                    if (esCritico1 < probabilidadCritico) {
                                        hit1 = (int) (hit1 * 1.5); // Aplica el multiplicador de daño crítico
                                        System.out.println(nombre1 + " realiza un ataque CRÍTICO!");
                                    }
                                    //hit1 = Math.min(hit1, limiteDamage);
                                    vida2 -= hit1;
                                    vida2 = Math.max(0, vida2); // Evitar que vida2 sea negativa
                                    System.out.println(nombre1 + " golpea primero con " + hit1 + " de daño");
                                    break;
                                case 'C':
                                    if (estimulantes1<=5) {
                                        vida1 += regenerar1;
                                        vida1 = Math.min(vida1, 200); // Evitar que vida1 supere 200
                                        estimulantes1++;
                                        System.out.println(nombre1 + " se cura, + " + vida1);
                                    }else {
                                        System.out.println(nombre1+" no puedes usar mas estimulantes. Limite: 5");
                                    }
                                    break;
                                default:
                                    System.out.println("Accion no reconocida");
                            }
                        }
                        break;
                    case 'C':
                        if (estimulantes2<=5) {
                            vida2 += regenerar1;
                            vida2 = Math.min(vida2, 200); // Evitar que vida1 supere 200
                            estimulantes2++;
                            System.out.println(nombre2 + " se cura, + " + vida2);
                        }
                        break;
                    default:
                        System.err.println("Caracter no valido, turno perdido");
                }
            }
            if (vida1 <= 0 || vida2 <= 0) {
                combate = false;
            }
            rondas++;

        }
        if (vida2 <= 0) {
            System.out.println(nombre1+" ¡VICTORIA!");
            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤⢦⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣼⢫⠁⡞⡗⡟⢩⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⢀⠴⡶⡻⢋⣑⣿⠟⠋⣉⢻⢿⣿⡻⡿⣳⣄⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⡴⠚⣉⡾⠷⠛⡟⠁⠐⠀⣀⠀⡾⡋⡘⢿⣷⣾⢿⣿⣶⣆⡀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⢠⢶⣎⠉⡽⠁⢬⡸⣷⢰⠴⠀⠀⢉⣼⠒⣳⢺⣷⡜⠛⢻⣿⣿⣶⡄⠀⠀⠀\n" +
                    "⠀⠀⠀⢐⣫⣇⡤⡟⠰⣏⠀⡹⢿⡀⣂⣶⠚⠿⣿⣿⣽⠿⢃⠆⣿⣿⣿⣿⡅⠀⠀⠀\n" +
                    "⠀⠀⠰⡿⠋⣀⠙⣿⣷⣿⣾⣾⣻⣿⣿⣿⣶⣾⣿⣿⣿⣷⣷⣿⣿⣿⣿⣿⡟⠁⠀⠀\n" +
                    "⠀⠀⠀⢱⣈⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠙⠛⠛⢿⣿⡿⠿⠿⠿⣛⣤⣏⣿⣿⢿⣿⣿⡿⢟⠋⠉⠉⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠐⠋⠛⠂⠀⠀⠀⠀⠀⠂⠘⠋⡙⡿⣿⣿⣿⡖⣂⡀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠂⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠒⠄⠀⠀⠀⠀⣩⣼⢷⡷⣿⣿⢐⠀⠀⠀⠀⠀⠀⠶⠆⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⣤⣤⣤⠀⠀⠀⠀⠀⢲⣾⣷⣻⢿⣿⣾⣧⠠⠤⠄⢀⣀⣠⣤⣤⣄⣀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⡀⠀⢸⡄⣴⣋⣿⣼⣽⣿⣷⣿⣿⣤⣰⣰⣀⡆⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⣤⣤⣤⣤⣤⡤⢤⢿⣿⣟⣛⡛⢻⠻⠿⠿⠿⠿⠿⠿⣿⡿⣿⣼⣿⣤⣤⣤⣤⣤⣤⡄\n" +
                    "⠀⠚⠛⢛⣛⣿⣿⣿⣿⣿⣿⣯⣭⣀⣠⣤⣤⣵⣶⣶⣷⣾⣿⣿⣾⣿⡟⠛⠋⠗⠂");
        } else {
            System.out.println(nombre2+ "¡VICTORIA!");
            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤⢦⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣼⢫⠁⡞⡗⡟⢩⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⢀⠴⡶⡻⢋⣑⣿⠟⠋⣉⢻⢿⣿⡻⡿⣳⣄⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⡴⠚⣉⡾⠷⠛⡟⠁⠐⠀⣀⠀⡾⡋⡘⢿⣷⣾⢿⣿⣶⣆⡀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⢠⢶⣎⠉⡽⠁⢬⡸⣷⢰⠴⠀⠀⢉⣼⠒⣳⢺⣷⡜⠛⢻⣿⣿⣶⡄⠀⠀⠀\n" +
                    "⠀⠀⠀⢐⣫⣇⡤⡟⠰⣏⠀⡹⢿⡀⣂⣶⠚⠿⣿⣿⣽⠿⢃⠆⣿⣿⣿⣿⡅⠀⠀⠀\n" +
                    "⠀⠀⠰⡿⠋⣀⠙⣿⣷⣿⣾⣾⣻⣿⣿⣿⣶⣾⣿⣿⣿⣷⣷⣿⣿⣿⣿⣿⡟⠁⠀⠀\n" +
                    "⠀⠀⠀⢱⣈⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠙⠛⠛⢿⣿⡿⠿⠿⠿⣛⣤⣏⣿⣿⢿⣿⣿⡿⢟⠋⠉⠉⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠐⠋⠛⠂⠀⠀⠀⠀⠀⠂⠘⠋⡙⡿⣿⣿⣿⡖⣂⡀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠂⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠒⠄⠀⠀⠀⠀⣩⣼⢷⡷⣿⣿⢐⠀⠀⠀⠀⠀⠀⠶⠆⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⣤⣤⣤⠀⠀⠀⠀⠀⢲⣾⣷⣻⢿⣿⣾⣧⠠⠤⠄⢀⣀⣠⣤⣤⣄⣀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⡀⠀⢸⡄⣴⣋⣿⣼⣽⣿⣷⣿⣿⣤⣰⣰⣀⡆⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⣤⣤⣤⣤⣤⡤⢤⢿⣿⣟⣛⡛⢻⠻⠿⠿⠿⠿⠿⠿⣿⡿⣿⣼⣿⣤⣤⣤⣤⣤⣤⡄\n" +
                    "⠀⠚⠛⢛⣛⣿⣿⣿⣿⣿⣿⣯⣭⣀⣠⣤⣤⣵⣶⣶⣷⣾⣿⣿⣾⣿⡟⠛⠋⠗");
        }
        sc.close();
    }
}
