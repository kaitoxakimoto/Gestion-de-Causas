import java.util.ArrayList;
import java.util.*;

public class ParteDefensora implements abogadoManejable {
    // Atributos
    private ArrayList<Abogado> defensor;
    private Cliente demandado;

    // Constructor
    public ParteDefensora(ArrayList<Abogado> defensor, Cliente demandado) {
        this.defensor = defensor;
        this.demandado = demandado;
    }

    public ParteDefensora() {
        ArrayList<Abogado> defensor = new ArrayList<Abogado>();
        this.defensor = defensor;
    }

    // Getter y Setter

    public ArrayList<Abogado> getDefensor() {
        return defensor;
    }

    public void setDefensor(ArrayList<Abogado> defensor) {
        this.defensor = defensor;
    }

    public Persona getDemandado() {
        return demandado;
    }

    public void setDemandado(Cliente demandado) {
        this.demandado = demandado;
    }

    // Metodos

    public void anadirAbogado(String nombre, String rut, String especialidad) {
        Abogado abogadoAux = new Abogado(nombre, rut,especialidad);
        for(int i = 0 ; i < defensor.size() ; i++){
            if(defensor.get(i).getRut() == rut ){
                System.out.println("El abogado ya se encuentra en la lista");
                return;
            }
        }
        defensor.add(abogadoAux);
    }
    
    public void eliminarAbogado(String rut){
        for(int i = 0; i< defensor.size() ; i++){
            if(defensor.get(i).getRut().equals(rut)){
                defensor.remove(i);
                System.out.println("El Abogado fue eliminado exitosamente.");
                return;
            }
        }
        System.out.println("El Abogado no está en la lista.");
        return;
    }

    public void editarAbogado(String rut, String nuevoRut, String nuevoNombre, String nuevaEspecialidad){
        Abogado abogadoAux = new Abogado(nuevoNombre,nuevoRut,nuevaEspecialidad);
        for(int i = 0 ; i < defensor.size() ; i++){
            if(defensor.get(i).getRut() == rut){
                defensor.set(i,abogadoAux);
                System.out.println("El Abogado fue editado exitosamente.");
            }
        }
        System.out.println("El Abogado a editar no fue encontrado");
        return;
    }

    public void mostrarAbogados(){
        System.out.println("Los Abogados defensores son:");
        for (int i = 0 ; i < defensor.size(); i++){
            defensor.get(i).identificarse();
        }
        return;

    }


    public void editarGUI() {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        String opcionString;
        int opcionInt;
        int opcionInt2;
        gestionDeCausas.clearScreen();

        System.out.println("De esta parte usted podria editar: ");
        System.out.println("1) Buffet de Abogados");
        System.out.println("2) Persona (" + demandado.getNombre() + ")");
        System.out.println("3) Testigos");

        opcionInt = scannerInt.nextInt();

        switch (opcionInt) {
            case 1:
                gestionDeCausas.clearScreen();
                mostrarAbogados();
                System.out.println();
                System.out.println("Usted desea");
                System.out.println("1) Eliminar a un Abogado");
                System.out.println("2) Agregar a un Abogado");
                opcionInt2 = scannerInt.nextInt();
                switch (opcionInt2) {
                    case 1:
                        gestionDeCausas.clearScreen();
                        mostrarAbogados();
                        System.out.println("ingrese el rut del abogado a elimiar: ");
                        opcionString = scannerString.nextLine();
                        eliminarAbogado(opcionString);
                        gestionDeCausas.pause();
                        break;
                    case 2:
                        gestionDeCausas.clearScreen();
                        System.out.println("Ingrese el rut del nuevo abogado");
                        String nuevoRut = scannerString.nextLine();

                        System.out.println("Ingrese el nombre del nuevo abogado");
                        String nuevoNombre = scannerString.nextLine();

                        System.out.println("Ingrese la especialidad del nuevo abogado");
                        String nuevaEspecialidad = scannerString.nextLine();

                        anadirAbogado(nuevoNombre, nuevoRut, nuevaEspecialidad);
                }
                break;
            case 2:
                gestionDeCausas.clearScreen();
                System.out.println("Nombre: " + demandado.getNombre() + " RUT: " + demandado.getRut());
                System.out.println("Usted desea:");
                System.out.println("1) Cambiar el nombre");
                System.out.println("2) Cambiar el RUT");  
                opcionInt2 = scannerInt.nextInt();
                switch (opcionInt2) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre: ");
                        opcionString = scannerString.nextLine();
                        demandado.setNombre(opcionString);
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo rut: ");
                        opcionString = scannerString.nextLine();
                        demandado.setRut(opcionString);
                        break;
                }
                break;
            case 3:
                gestionDeCausas.clearScreen();
                demandado.mostrarTestigos();
                System.out.println("");
                System.out.println("Usted desea");
                System.out.println("1) Eliminar a un Testigo");
                System.out.println("2) Agregar a un Testigo");
                opcionInt2 = scannerInt.nextInt();
                switch (opcionInt2) {
                    case 1:
                        gestionDeCausas.clearScreen();
                        demandado.mostrarTestigos();
                        System.out.println("ingrese el rut del Testigo a elimiar: ");
                        opcionString = scannerString.nextLine();
                        demandado.eliminarTestigo(opcionString);
                        gestionDeCausas.pause();
                        break;
                    case 2:
                        System.out.println("Ingrese el rut del nuevo Testigo");
                        String nuevoRut = scannerString.nextLine();

                        System.out.println("Ingrese el nombre del nuevo abogado");
                        String nuevoNombre = scannerString.nextLine();

                        demandado.anadirTestigo(nuevoNombre, nuevoRut);
                }
                break;
        }
    }

    public void mostrarDatos(){
        System.out.println("La persona demandandada es");
        System.out.print("\t");
        demandado.identificarse();
        
        System.out.println("El buffet de abogados es el siguente");
        mostrarAbogados();

    }
}
