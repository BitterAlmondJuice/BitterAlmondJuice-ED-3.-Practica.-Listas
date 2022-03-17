import java.lang.ref.SoftReference;

public class Pruebas {

    public static void main(String[] args) {

        System.out.println("********** PRUEBAS **********");

        Pruebas principal = new Pruebas();

        ListaOrdinal listaOrdinal1 = principal.prepararListaOrdinal();

        System.out.println("-------------------------------");

        System.out.println("Convocatorias en ED: " + listaOrdinal1.numConvocatorias("ED"));
        System.out.println("Convocatorias en Algebra: " + listaOrdinal1.numConvocatorias("Algebra"));
        System.out.println("Convocatorias en Fundamentos de Programación: " + listaOrdinal1.numConvocatorias("Fundamentos de Programación"));

        System.out.println("-------------------------------");

        Alumno alumno1 = new Alumno("Felipe García Gómez", 1253);
        Alumno alumno2 = new Alumno("Alicia Blázquez Martín", 5622);

        IteradorListaOrdinal iteradorAsignaturas = listaOrdinal1.getIterador();
        IteradorListaOrdinal iteradorFelipe = alumno1.asignaturasAprobadas().getIterador();
        IteradorListaOrdinal iteradorAlicia = alumno2.asignaturasAprobadas().getIterador();

        while (iteradorAsignaturas.hasNext()) {
            alumno1.nuevaEvaluacion(iteradorAsignaturas.next());
        }

        System.out.println("----------- Asignaturas aprobadas por Felipe García Gómez ----------");

        while (iteradorFelipe.hasNext()) {
            iteradorFelipe.next().mostrar();
        }

        System.out.println("----------- Asignaturas aprobadas por Alicia Blázquez Martín ----------");

        while (iteradorAlicia.hasNext()) {
            iteradorAlicia.next().mostrar();
        }

        System.out.println("----------- MOSTRAR LOS ALUMNOS ------------");

        alumno1.mostrar();
        System.out.println("-------------------------------");
        alumno2.mostrar();
        System.out.println("-------------------------------");

    }


    public ListaOrdinal prepararListaOrdinal() {

        ListaOrdinal listaOrdinal1 = new ListaOrdinal();

        Evaluacion evaluacion1 = new Evaluacion("ED", "Junio 19", 4.5);
        Evaluacion evaluacion2 = new Evaluacion("ED", "Julio 19", -1);
        Evaluacion evaluacion3 = new Evaluacion("ED", "Julio 20", 7.4);
        Evaluacion evaluacion4 = new Evaluacion("Algebra", "Junio 19", 6.4);

        listaOrdinal1.insertar(evaluacion1);
        listaOrdinal1.insertar(evaluacion2);
        listaOrdinal1.insertar(evaluacion3);
        listaOrdinal1.insertar(evaluacion4);

        IteradorListaOrdinal iteradorListaOrdinal = listaOrdinal1.getIterador();

        while (iteradorListaOrdinal.hasNext()) {

            iteradorListaOrdinal.next().mostrar();

        }


        return listaOrdinal1;

    }


}