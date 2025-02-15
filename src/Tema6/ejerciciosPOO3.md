# Ejercicios de programación orientada a objetos 3.
### **Realiza los siguientes ejercicios siguiendo el paradigma de programación orientada aobjetos,sin repetir código, utilizando métodos que realicen una única tarea. Debes añadirlos ejercicios al repositorio de la asignatura dentro de un package llamado tema4.**
***

1. Crea una clase vehículo con los atributos comunes a turismos, camiones y
   ciclomotores. Para los turismos queremos saber el número de plazas y el tipo
   de uso (profesional o particular). Para los camiones el peso máximo
   autorizado y si la mercancía es peligrosa o no. Para ciclomotores la cilindrada
   y si necesita carnet (a partir de 125 cc necesita carnet). Necesita carnet NO es
   un atributo.
***
2. Crea una clase Animal. Cualquier subclase que creemos de animal debe
   tener los métodos comer, dormir y hacerRuido. Haz 5 subclases de animales
   diferentes piensa que hacen todos más o menos igual, qué diferente e
   implementa un método único para cada animal.
***
3. Crea una clase Figura2D que contendrá los métodos área, perímetro y
   toString. Implementa las siguientes subclases que heredan de Figura2D:
   cuadrado, rectángulo, triángulo y círculo. Piensa que el cuadrado y el
   rectángulo son muy parecidos ;).
***
4. Crea una clase Ficha diseñada para manipular elementos de una biblioteca:
   libros, revistas, DVD… Los atributos comunes serán número y título.
   Los libros: tendrán además autor y editorial.
   Las revistas: número de publicación y año.
   Los DVD: tendrán director, año y tipo (animación, acción, documental, ciencia
   ficción…).
   Define la clase base, las derivadas y los métodos que consideres interesantes.
***
5. Para una red social, crea una interfaz Publicacion con métodos como
   publicar y compartir. Implementa esta interfaz en clases como
   PublicacionTexto, PublicacionFoto, y PublicacionVideo. Cada clase debe tener
   su propia forma de publicar y compartir contenido. Ahora crea la interfaz
   AbrirPublicacion, que sólo implementarán las clases PublicacionFoto y
   PublicacionVideo.
***
6. Crea una interfaz Publicacion Con Reaccion a partir de Publicación con
   métodos como comentar, y compartir. Implementa esta interfaz en las clases
   anteriores.
***
7. Crea una interfaz Ataque con métodos como lanzar (lanza un ataque), coste
   (devuelve lo que cuesta un ataque) y daño infligido (devuelve el daño que
   infringe). Implementa las clases Ataque Mágico, Ataque Físico y Ataque
   Mágico y Físico.
***
8. Crea una interfaz AtaqueAvanzado con métodos como lanzar (lanza un
   ataque), coste (devuelve lo que cuesta un ataque tanto en maná como en
   esfuerzo físico) y daño infligido (devuelve el daño que infringe de tipo mágico
   y de tipo físico). Implementa las clases Ataque Bola Fuego, Ataque Espadazo y
   Ataque Espadazo Encantado