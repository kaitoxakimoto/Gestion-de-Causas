import java.util.*;

public class MapaCausas {
    // Atrubutos
    private HashMap<String, Causa> mapaCausas;

    // Constructor
    public MapaCausas() {
        mapaCausas = new HashMap<String, Causa>();

    }

    // Getter y Setter

    public HashMap<String, Causa> getMapaCausas() {
        return mapaCausas;
    }

    public void setMapaCausas(HashMap<String, Causa> newMapa) {
        mapaCausas = newMapa;
    }

    // Metodos

    public void mostrarCausas() {

        for (Map.Entry<String, Causa> set : mapaCausas.entrySet()) {
            System.out.println("RIT:" + set.getKey() + " razon:" + set.getValue().getTipoCausa());
        }
        return;
    }

    public void anadirCausa(Causa causa) {
        mapaCausas.put(causa.getRit(), causa);
    }

    public void anadirCausaGUI() {
        // Recipiente a las estructuras usadas
        Causa newCausa = new Causa();
        Scanner input = new Scanner(System.in);

        // Datos de Causa
        System.out.println("Ingrese RIT de la causa: ");
        String rit = input.nextLine();
        newCausa.setRit(rit);

        System.out.println("Ingrese tipo de causa: ");
        String tipoCausa = input.nextLine();
        newCausa.setTipoCausa(tipoCausa);
        gestionDeCausas.clearScreen();

        // Datos demandante
        System.out.println("Ingrese nombre del demandante: ");
        String demandante = input.nextLine();

        System.out.println("Ingrese rut del demandante: ");
        String rutDemandante = input.nextLine();
        gestionDeCausas.clearScreen();

        // Testigos demandante

        ArrayList<Testigo> testigosDemandante = new ArrayList<Testigo>();

        String nombreT = "";
        while (!nombreT.equals("x")) {
            System.out.println("Lista de testigos actuales: ");
            for (int i = 0; i < testigosDemandante.size(); i++) {
                System.out.println(testigosDemandante.get(i).getRut() + " " + testigosDemandante.get(i).getNombre());
            }

            System.out.println("Ingrese nombre de testigo del demandante (Ingrese x para terminar de agregar): ");
            nombreT = input.nextLine();
            if (nombreT.equals("x")) {
                break;
            }
            System.out.println("Ingrese rut de testigo: ");
            String rutT = input.nextLine();

            Testigo testigoAux = new Testigo(nombreT, rutT);
            testigosDemandante.add(testigoAux);
            gestionDeCausas.clearScreen();
        }

        gestionDeCausas.clearScreen();
        // Creacion clase Demandante

        Cliente personaDemandante = new Cliente(demandante, rutDemandante, testigosDemandante);

        // Abogados Demandante

        ArrayList<Abogado> abogados = new ArrayList<Abogado>();
        String nombre = "";
        while (!nombre.equals("x")) {
            System.out.println("Lista de abogados actuales: ");
            for (int i = 0; i < abogados.size(); i++) {
                System.out.println(abogados.get(i).getRut() + " " + abogados.get(i).getNombre());
            }

            System.out.println("Ingrese nombre abogado del demandante (Ingrese x para terminar de agregar): ");
            nombre = input.nextLine();
            if (nombre.equals("x")) {
                break;
            }
            System.out.println("Ingrese rut del abogado: ");
            String rutA = input.nextLine();

            System.out.println("Ingrese especialidad del abogado: ");
            String esp = input.nextLine();

            Abogado abogadoAux = new Abogado(nombre, rutA, esp);
            abogados.add(abogadoAux);
            gestionDeCausas.clearScreen();
        }
        gestionDeCausas.clearScreen();

        // Creacion Parte Acusadora

        ParteAcusadora acusador = new ParteAcusadora(abogados, personaDemandante);
        newCausa.setAcusador(acusador);

        // Datos Demandado
        //

        System.out.println("Ingrese nombre del demandado: ");
        String demandado = input.nextLine();

        System.out.println("Ingrese rut del demandado: ");
        String rutDemandado = input.nextLine();
        gestionDeCausas.clearScreen();

        // Testigos Demandado

        ArrayList<Testigo> testigosDemandado = new ArrayList<Testigo>();

        nombreT = "";
        while (!nombreT.equals("x")) {
            System.out.println("Esta es la lista de testigos actuales: ");
            for (int i = 0; i < testigosDemandado.size(); i++) {
                System.out.println(testigosDemandado.get(i).getRut() + " " + testigosDemandado.get(i).getNombre());
            }

            System.out.println("Ingrese nombre de testigo del demandado (Ingrese x para terminar de agregar): ");
            nombreT = input.nextLine();
            if (nombreT.equals("x")) {
                break;
            }
            System.out.println("Ingrese rut de testigo: ");
            String rutT = input.nextLine();

            Testigo testigoAux = new Testigo(nombreT, rutT);
            testigosDemandado.add(testigoAux);
            gestionDeCausas.clearScreen();
        }
        gestionDeCausas.clearScreen();

        // Creacion clase Demandado

        Cliente personaDemandado = new Cliente(demandado, rutDemandado, testigosDemandado);

        // Abogados Demandado

        ArrayList<Abogado> abogadosDemandado = new ArrayList<Abogado>();
        nombre = "";
        while (!nombre.equals("x")) {
            System.out.println("Esta es la lista de abogados actuales: ");
            for (int i = 0; i < abogadosDemandado.size(); i++) {
                System.out.println(abogadosDemandado.get(i).getRut() + " " + abogadosDemandado.get(i).getNombre());
            }

            System.out.println("Ingrese nombre abogado del demandante (Ingrese x para terminar de agregar): ");
            nombre = input.nextLine();
            if (nombre.equals("x")) {
                break;
            }
            System.out.println("Ingrese rut del abogado: ");
            String rutA = input.nextLine();

            System.out.println("Ingrese especialidad del abogado: ");
            String esp = input.nextLine();

            Abogado abogadoAux = new Abogado(nombre, rutA, esp);
            abogadosDemandado.add(abogadoAux);
            gestionDeCausas.clearScreen();
        }

        // Creacion Parte Defensora

        ParteDefensora defensor = new ParteDefensora(abogadosDemandado, personaDemandado);
        newCausa.setDefensor(defensor);

        gestionDeCausas.clearScreen();
        anadirCausa(newCausa);
        System.out.println("Se ha agregado la causa correctamente\n");
        gestionDeCausas.pause();
    }

    public void editarCausa(String ritAEditar) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        String opcionString;
        int opcionInt;
        gestionDeCausas.clearScreen();

        Causa causaAEditar = mapaCausas.get(ritAEditar);

        System.out.println("Editando la causa RIT: " + causaAEditar.getRit());
        System.out.println("De esta causa usted podria editar: ");
        System.out.println("1) Parte Defensora");
        System.out.println("2) Parte Acusadora");
        System.out.println("3) RIT");
        System.out.println("4) Tipo de Causa");

        opcionInt = scannerInt.nextInt();

        switch (opcionInt) {
            case 1:
                causaAEditar.getDefensor().editarGUI();
                break;
            case 2:
                causaAEditar.getAcusador().editarGUI();
                break;
            case 3:
                gestionDeCausas.clearScreen();
                System.out.println("el RIT actual es " + causaAEditar.getRit());
                System.out.println("el nuevo RIT debe ser: ");
                opcionString = scannerString.nextLine();

                String ritAntiguo = causaAEditar.getRit();
                causaAEditar.setRit(opcionString);
                anadirCausa(causaAEditar);
                mapaCausas.remove(ritAntiguo);
                break;
            case 4:
                gestionDeCausas.clearScreen();
                System.out.println("el tipo actual es " + causaAEditar.getTipoCausa());
                System.out.println("el nuevo tipo debe ser: ");
                opcionString = scannerString.nextLine();
                causaAEditar.setTipoCausa(opcionString);
                break;
        }

    }

    public void eliminarCausa(String ritAEliminar) {
        mapaCausas.remove(ritAEliminar);
        return;
    }

    public void mostrarCausa(String ritAMostrar) {
        mapaCausas.get(ritAMostrar).mostrarCausa();
        return;
    }
}
