public class Abogado extends Persona {

    // Atributos
    private String especialidad;

    // Constructor
    public Abogado(String nombre, String rut, String especialidad) {
        super(nombre,rut);
        this.especialidad = especialidad;
    }

    // Getter

    public String getEspecialidad(){
        return this.especialidad;
    }

    // Setter

    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    @Override //Sobrescritura Método en Persona
    public void identificarse(){
        System.out.println("\t" + getNombre() + " / Rut: " + getRut() + " / Especialidad: " + getEspecialidad());
    }

}