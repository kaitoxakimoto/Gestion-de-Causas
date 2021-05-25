import java.util.ArrayList;
import java.util.*;

public class ParteAcusadora implements abogadoManejable {

    // Atributos
    private ArrayList<Abogado> acusador;
    private Cliente demandante;

    // Constructor
    public ParteAcusadora(ArrayList<Abogado> acusador, Cliente demandante) {
        this.acusador = acusador;
        this.demandante = demandante;
    }

    public ParteAcusadora() {
        ArrayList<Abogado> acusador = new ArrayList<Abogado>();
        this.acusador = acusador;
    }

    // Getter y Setter

    public ArrayList<Abogado> getAcusador() {
        return acusador;
    }

    public void setAcusador(ArrayList<Abogado> acusador) {
        this.acusador = acusador;
    }

    public Persona getDemandante() {
        return demandante;
    }

    public void setDemandante(Cliente demandante) {
        this.demandante = demandante;
    }

    // Metodos

    public void anadirAbogado(String nombre, String rut, String especialidad) {
        Abogado abogadoAux = new Abogado(nombre, rut, especialidad);
        for (int i = 0; i < acusador.size(); i++) {
            if (acusador.get(i).getRut() == rut) {
                System.out.println("El abogado ya se encuentra en la lista");
                return;
            }
        }
        acusador.add(abogadoAux);
    }

    public void eliminarAbogado(String rut) {
        for (int i = 0; i < acusador.size(); i++) {
            if (acusador.get(i).getRut().equals(rut)) {
                acusador.remove(i);
                System.out.println("El Abogado fue eliminado exitosamente.");
                return;
            }
        }
        System.out.println("El Abogado no está en la lista.");
        return;
    }

    public void editarAbogado(String rut, String nuevoRut, String nuevoNombre, String nuevaEspecialidad) {
        Abogado abogadoAux = new Abogado(nuevoNombre, nuevoRut, nuevaEspecialidad);
        for (int i = 0; i < acusador.size(); i++) {
            if (acusador.get(i).getRut() == rut) {
                acusador.set(i, abogadoAux);
                System.out.println("El Abogado fue editado exitosamente.");
            }
        }
        System.out.println("El Abogado a editar no fue encontrado");
        return;
    }

    public void mostrarAbogados() {
        System.out.println("Los Abogados atacantes son:");
        for (int i = 0; i < acusador.size(); i++) {
            acusador.get(i).identificarse();
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
        System.out.println("2) Persona (" + demandante.getNombre() + ")");
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
                System.out.println("Nombre: " + demandante.getNombre() + " RUT: " + demandante.getRut());
                System.out.println("Usted desea:");
                System.out.println("1) Cambiar el nombre");
                System.out.println("2) Cambiar el RUT");
                opcionInt2 = scannerInt.nextInt();
                switch (opcionInt2) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre: ");
                        opcionString = scannerString.nextLine();
                        demandante.setNombre(opcionString);
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo rut: ");
                        opcionString = scannerString.nextLine();
                        demandante.setRut(opcionString);
                        break;
                }
                break;
            case 3:
                gestionDeCausas.clearScreen();
                demandante.mostrarTestigos();
                System.out.println("");
                System.out.println("Usted desea");
                System.out.println("1) Eliminar a un Testigo");
                System.out.println("2) Agregar a un Testigo");
                opcionInt2 = scannerInt.nextInt();
                switch (opcionInt2) {
                    case 1:
                        gestionDeCausas.clearScreen();
                        demandante.mostrarTestigos();
                        System.out.println("ingrese el rut del Testigo a eliminar: ");
                        opcionString = scannerString.nextLine();
                        demandante.eliminarTestigo(opcionString);
                        gestionDeCausas.pause();
                        break;
                    case 2:
                        gestionDeCausas.clearScreen();
                        System.out.println("Ingrese el rut del nuevo Testigo");
                        String nuevoRut = scannerString.nextLine();

                        System.out.println("Ingrese el nombre del nuevo Testigo");
                        String nuevoNombre = scannerString.nextLine();

                        demandante.anadirTestigo(nuevoNombre, nuevoRut);
                }
                break;
        }
    }

    public void mostrarDatos() {
        System.out.println("La persona demandante es");
        System.out.print("\t");
        demandante.identificarse();

        System.out.println("El buffet de abogados es el siguente");
        mostrarAbogados();

    }
}
