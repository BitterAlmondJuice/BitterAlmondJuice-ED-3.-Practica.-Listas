public class Pruebas {

    public static void main(String[] args) {

        System.out.println("********** PRUEBAS **********");

        Pruebas principal = new Pruebas();

        ListaOrdinal listaOrdinal1 = principal.prepararListaOrdinal();

        System.out.println("-------------------------------");

        System.out.println("Convocatorias en ED: " +listaOrdinal1.numConvocatorias("ED"));
        System.out.println("Convocatorias en Algebra: " +listaOrdinal1.numConvocatorias("Algebra"));
        System.out.println("Convocatorias en Fundamentos de Programación: " +listaOrdinal1.numConvocatorias("Fundamentos de Programación"));


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