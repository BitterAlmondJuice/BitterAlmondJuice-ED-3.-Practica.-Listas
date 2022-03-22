public class Alumno {

    private String nombre;

    private int matricula;

    private ListaOrdinal expediente;

    public Alumno(String nombre, int matricula) {

        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new ListaOrdinal();
    }

    public int getMatricula() {

        return matricula;
    }

    public void setMatricula(int matricula) {

        this.matricula = matricula;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void nuevaEvaluacion(Evaluacion evaluacion) {

        expediente.insertar(evaluacion);
    }

    public boolean estaAprobado(String nombreAsig) {

        boolean aprobado = false;
        IteradorListaOrdinal it = expediente.getIterador();
        while (it.hasNext() && !aprobado) {
            Evaluacion evaluacion = it.next();
            if (evaluacion.getNombreAsignatura().equals(nombreAsig) && evaluacion.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public ListaOrdinal asignaturasAprobadas() {

        ListaOrdinal asignaturasAprobadas = new ListaOrdinal();

        IteradorListaOrdinal asignaturas = expediente.getIterador();

        while (asignaturas.hasNext()) {

            Evaluacion auxEvaluacion = asignaturas.next();

            if (auxEvaluacion.getNota() >= 5) {
                asignaturasAprobadas.insertar(auxEvaluacion);
            }

        }

        return asignaturasAprobadas;

    }

    public double mediaAprobadas() {
        double media = 0;


        ListaOrdinal aprobadas = asignaturasAprobadas();

        IteradorListaOrdinal aprobadasIt = aprobadas.getIterador();

        int numAprobadas = aprobadas.getNumElementos();

        while (aprobadasIt.hasNext()) {

            media += aprobadasIt.next().getNota();

        }

        media = media / numAprobadas;


        return media;
    }

    public int getNumAprobadas() {

        ListaOrdinal aprobadas = asignaturasAprobadas();

        int numAprobadas = aprobadas.getNumElementos();

        return numAprobadas;
    }

    public void mostrar() {

        System.out.println(getNombre() + ". Matricula: " + getMatricula());



        if (!expediente.vacia()) {

            for (int i = 0; i < expediente.getNumElementos(); i++){

                expediente.getElemento(i).mostrar();

            }

            System.out.println(expediente.getNumElementos() + " evaluaciones y " + getNumAprobadas() + " asignaturas aprobadas con calificación media " + mediaAprobadas());
            System.out.println("-------------------------------");

        } else {

            System.out.println("No se ha realizado ninguna evaluación");
            System.out.println("-------------------------------");

        }


    }

}


