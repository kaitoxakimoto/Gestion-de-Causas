public class Testigo {
    // Atributos
    private String nombre;
    private String rut;

    // Constructor
    public Testigo(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    // Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void mostrarDatos(){
        System.out.println("\t" + nombre + " / Rut: " + rut);
    }
}
