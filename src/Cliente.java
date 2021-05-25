import java.util.*;

public class Cliente extends Persona{
    
    private ArrayList<Testigo> testigos;
    
    
    // Constructor
    public Cliente(String nombre, String rut, ArrayList<Testigo> testigos) {
        super(nombre, rut);
        this.setTestigos(testigos);
    }

    // Getter y Setter
    public ArrayList<Testigo> getTestigos() {
        return testigos;
    }

    public void setTestigos(ArrayList<Testigo> testigos) {
        this.testigos = testigos;
    }

    // Metodos

    public void anadirTestigo(String nombre, String rut) {
        Testigo testigoAux = new Testigo(nombre, rut);

        for (int i = 0; i < testigos.size(); i++) {
            if (testigos.get(i).getRut() == rut) {
                System.out.println("El testigo ya está en la lista");
                return;
            }
        }
        testigos.add(testigoAux);
        return;
    }

    public void eliminarTestigo(String rut) {
        for (int i = 0; i < testigos.size(); i++) {
            if (testigos.get(i).getRut().equals(rut)) {
                testigos.remove(i);
                System.out.print("Testigo eliminado.");
                return;
            }
        }
        System.out.println("Testigo no encontrado.");
        return;
    }

    public void editarTestigo(String rut, String nuevoRut, String nuevoNombre) {
        Testigo testigoAux = new Testigo(nuevoNombre, nuevoRut);
        for (int i = 0; i < testigos.size(); i++) {
            if (testigos.get(i).getRut() == getRut()) {
                testigos.set(i, testigoAux);
                System.out.println("Testigo reemplazado exitosamente.");
                return;
            }
        }
        System.out.println("Rut de testigo a editar no encontrado.");
    }

    public void mostrarTestigos(){
        for (int i = 0; i < testigos.size(); i++) {
            System.out.println(testigos.get(i).getNombre() + " / Rut: " + testigos.get(i).getRut());
        }
    }
    
    @Override // SobreCarga del método en clase Persona
    public void identificarse(){
        
        System.out.println(getNombre() + " / Rut: " + getRut());
        System.out.println("Tiene los siguientes testigos: ");
        for (int i = 0; i < testigos.size(); i++) {
            testigos.get(i).mostrarDatos();
        }
        
    }
       
}
