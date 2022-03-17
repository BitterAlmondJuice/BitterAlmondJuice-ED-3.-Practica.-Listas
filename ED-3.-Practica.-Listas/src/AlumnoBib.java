import java.util.LinkedList;

public class AlumnoBib {
    private String nombre;

    private int matricula;

    private LinkedList<Evaluacion> expediente;

    public AlumnoBib(String nombre, int matricula) {

        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new LinkedList<Evaluacion>();
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

    public LinkedList<Evaluacion> asignaturasAprobadas() {

        LinkedList<Evaluacion> asignaturasAprobadas = new LinkedList<Evaluacion>();

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


        LinkedList<Evaluacion> aprobadas = asignaturasAprobadas();

        IteradorListaOrdinal aprobadasIt = aprobadas.getIterador();

        int numAprobadas = aprobadas.getNumElementos();

        while (aprobadasIt.hasNext()) {

            media += aprobadasIt.next().getNota();

        }

        media = media / numAprobadas;


        return media;
    }

    public int getNumAprobadas() {

        LinkedList<Evaluacion> aprobadas = asignaturasAprobadas();

        int numAprobadas = aprobadas.getNumElementos();

        return numAprobadas;
    }

    public void mostrar() {

        System.out.println(getNombre() + ". Matricula: " + getMatricula());

        IteradorListaOrdinal expedienteAlumnoIt = expediente.getIterador();

        if (!expediente.vacia()) {

            while (expedienteAlumnoIt.hasNext()) {

                expedienteAlumnoIt.next().mostrar();

            }

            System.out.println(expediente.getNumElementos() + " evaluaciones y " + getNumAprobadas() + " asignaturas aprobadas con calificación media " + mediaAprobadas());

        } else {

            System.out.println("No se ha realizado ninguna evaluación");

        }

    }
}
