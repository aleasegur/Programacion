//ALEJANDRO ASENCIO GURAU
/* Realiza un proyecto en Java llamado Programacion con una clase
llamada Tema1Ejercicio5 que muestre por pantalla las siguientes
operaciones y su resultado.
1. 24 % 5
2. 7 / 2 + 2.5
3. 10.8 / 2 + 2
4. ( 4 + 6 ) * 3 + 2 * ( 5 - 1 )
5. 5 / 2 + 17 % 3
6. 7 >= 5 OR 27 <> 8
7. (45 <= 7) OR NOT ( 5 >= 7 )
8. 27 % 4 + 15 / 4
9. 37 / 4 * 4 – 2
10. (25 >= 7) AND NOT (7 <=2)
11. ('H' < 'J') AND ('9' <> '7')
12. 25 > 20 AND 13 > 5
13. 10 + 4 < 15 - 3 OR 2 * 5 + 1 > 14 – 2 * 2
14. 4 * 2 <= 8 OR 2 * 2 < 5 AND 4 > 3 + 1
15. 10 <= 2 * 5 AND 3 < 4 OR NOT (8>7) AND 3 * 2 <= 4 * 2 - 1*/
public class Tema1Ejercicio5 {
    public static void main(String[] args) {

        int oper1=24%5,
                oper4=( 4 + 6 ) * 3 + 2 * ( 5 - 1 ),
                oper5=5 / 2 + 17 % 3,
                oper8=27 % 4 + 15 / 4,
                oper9=37/4*4-2;

        double oper2=7 / 2 + 2.5,
                oper3=10.8 / 2 + 2;

        boolean oper6=7 >= 5 || 27 != 8,
                oper7= (45 <= 7) || ! ( 5 >= 7 ),
                oper10=(25 >= 7) && ! (7 <=2),
                oper11=('H' < 'J') && ('9' != '7'),
                oper12=25 > 20 && 13 > 5,
                oper13= 10 + 4 < 15 - 3 || 2 * 5 + 1 > 14 - 2 * 2,
                oper14=4 * 2 <= 8 || 2 * 2 < 5 && 4 > 3 + 1,
                oper15=10 <= 2 * 5 && 3 < 4 || ! (8>7) && 3 * 2 <= 4 * 2 - 1;

        System.out.println("1. 24 % 5 = "+oper1+"\n" +
                "2. 7 / 2 + 2.5 = "+oper2+"\n" +
                "3. 10.8 / 2 + 2 = "+oper3+"\n" +
                "4. ( 4 + 6 ) * 3 + 2 * ( 5 - 1 ) = "+oper4+"\n" +
                "5. 5 / 2 + 17 % 3 = "+oper5+"\n" +
                "6. 7 >= 5 OR 27 <> 8 = "+oper6+"\n" +
                "7. (45 <= 7) OR NOT ( 5 >= 7 ) = "+oper7+"\n" +
                "8. 27 % 4 + 15 / 4 = "+oper8+"\n" +
                "9. 37 / 4 * 4 – 2 = "+oper9+"\n" +
                "10. (25 >= 7) AND NOT (7 <=2) = "+oper10+"\n" +
                "11. ('H' < 'J') AND ('9' <> '7') = "+oper11+"\n" +
                "12. 25 > 20 AND 13 > 5 = "+oper12+"\n" +
                "13. 10 + 4 < 15 - 3 OR 2 * 5 + 1 > 14 – 2 * 2 = "+oper13+"\n" +
                "14. 4 * 2 <= 8 OR 2 * 2 < 5 AND 4 > 3 + 1 = "+oper14+"\n" +
                "15. 10 <= 2 * 5 AND 3 < 4 OR NOT (8>7) AND 3 * 2 <= 4 * 2 - 1 = " +oper15);
    }
}