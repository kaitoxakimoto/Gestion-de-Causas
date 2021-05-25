public interface abogadoManejable {

    public void anadirAbogado(String nombre, String rut, String especialidad);

    public void eliminarAbogado(String rut);

    public void editarAbogado(String rut, String nuevoRut, String nuevoNombre, String nuevaEspecialidad);

    public void mostrarAbogados();

}

