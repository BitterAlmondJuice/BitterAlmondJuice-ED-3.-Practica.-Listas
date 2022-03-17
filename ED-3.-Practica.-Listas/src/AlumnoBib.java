import java.util.Iterator;
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

        expediente.add(evaluacion);
    }

    public boolean estaAprobado(String nombreAsig) {

        boolean aprobado = false;
        Iterator<Evaluacion> it = expediente.iterator();
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

        Iterator<Evaluacion> asignaturas = expediente.iterator();

        while (asignaturas.hasNext()) {


            Evaluacion auxEvaluacion = asignaturas.next();

            if (auxEvaluacion.getNota() >= 5) {
                asignaturasAprobadas.add(auxEvaluacion);
            }

        }

        return asignaturasAprobadas;

    }

    public double mediaAprobadas() {
        double media = 0;


        LinkedList<Evaluacion> aprobadas = asignaturasAprobadas();

        Iterator<Evaluacion> aprobadasIt = aprobadas.iterator();

        int numAprobadas = aprobadas.size();

        while (aprobadasIt.hasNext()) {

            media += aprobadasIt.next().getNota();

        }

        media = media / numAprobadas;


        return media;
    }

    public int getNumAprobadas() {

        LinkedList<Evaluacion> aprobadas = asignaturasAprobadas();

        int numAprobadas = aprobadas.size();

        return numAprobadas;
    }

    public void mostrar() {

        System.out.println(getNombre() + ". Matricula: " + getMatricula());

        Iterator<Evaluacion> expedienteAlumnoIt = expediente.iterator();

        if (!expediente.isEmpty()) {

            while (expedienteAlumnoIt.hasNext()) {

                expedienteAlumnoIt.next().mostrar();

            }

            System.out.println(expediente.size() + " evaluaciones y " + getNumAprobadas() + " asignaturas aprobadas con calificación media " + mediaAprobadas());

        } else {

            System.out.println("No se ha realizado ninguna evaluación");

        }

    }
}
