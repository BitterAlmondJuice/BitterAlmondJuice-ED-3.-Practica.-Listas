public class Alumno {

    private String nombre;

    private int matricula;

    private LinkedList<Evaluacion> expediente;

    public Alumno(String nombre, int matricula) {

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
            if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
                    evaluacion.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public LinkedList<Evaluacion> asignaturasAprobadas() {

        LinkedList<Evaluacion> asignaturasAprobadas = new LinkedList<Evaluacion>();

        IteradorListaOrdinal aprobadas = expediente.getIterador();

        while (aprobadas.hasNext()) {

            if (aprobadas.next().getNota()>=5){
                asignaturasAprobadas.insertar(aprobadas.next());
            }

        }















        return asignaturasAprobadas;

    }

    public double mediaAprobadas() {

        return 0.0;  // Eliminar esta línea al codificar el método
    }

    public int getNumAprobadas() {

        return 0;  // Eliminar esta línea al codificar el método
    }

    public void mostrar() {

    }



}


