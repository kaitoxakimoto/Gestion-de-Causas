import java.util.*;
import java.util.Iterator;

public class gestionDeCausas {
    private static MapaCausas mapaCausas = new MapaCausas();
    public static void main(String[] args) {
        // Ataque
        Testigo testigoAta = new Testigo("Fulanita", "19343935-8");
        ArrayList<Testigo> testigosAta = new ArrayList<Testigo>();
        testigosAta.add(testigoAta);

        Cliente atacante = new Cliente("Atacante", "44444444-4", testigosAta);

        Abogado abogadoAta = new Abogado("Pheonix", "1231231-1", "Cocina");
        ArrayList<Abogado> abogadosAta = new ArrayList<Abogado>();
        abogadosAta.add(abogadoAta);

        ParteAcusadora pAta = new ParteAcusadora(abogadosAta, atacante);

        // Defensa
        Testigo testigoDef = new Testigo("Fulanito", "19343935-1");
        ArrayList<Testigo> testigosDef = new ArrayList<Testigo>();
        testigosDef.add(testigoDef);

        Cliente defensor = new Cliente("Defensor", "44444444-4", testigosDef);

        Abogado abogadoDef = new Abogado("Adolfo", "1231231-1", "Pintura");
        ArrayList<Abogado> abogadosDef = new ArrayList<Abogado>();
        abogadosDef.add(abogadoDef);

        ParteDefensora pDef = new ParteDefensora(abogadosDef, defensor);

        Causa nuevaCausa = new Causa(pAta, pDef, "Pelea cocinapintura", "11112");

        // Asignación Causa al Mapa
        mapaCausas.anadirCausa(nuevaCausa);

        principal();
    }

    public static void principal() {

        clearScreen();

        System.out.println("Bienvenido al programa de gestion de causas");
        System.out.println("Ingrese la opcion que desea ejecutar: ");
        System.out.println("1 Agregar Causa");
        System.out.println("2 Editar Causa");
        System.out.println("3 Eliminar Causa");
        System.out.println("4 Mostrar Causa");
        System.out.println("5 Búsqueda de Abogados según especialidad");
        System.out.println("6 Mostrar el Abogado con más causas");
        System.out.print("Opcion elegida: ");

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        String opcionString;
        int opcionInt;

        opcionInt = scannerInt.nextInt();

        switch (opcionInt) {
            case 1:
                clearScreen();
                mapaCausas.anadirCausaGUI();
                break;
            case 2:
                clearScreen();
                System.out.println("Las causas actuales son");
                mapaCausas.mostrarCausas();
                System.out.println("Ingrese el RIT de la causa a editar: ");

                opcionString = scannerString.nextLine();
                mapaCausas.editarCausa(opcionString);
                break;

            case 3:
                clearScreen();
                System.out.println("Las causas actuales son");
                mapaCausas.mostrarCausas();
                System.out.println("Ingrese el RIT de la causa a eliminar: ");

                opcionString = scannerString.nextLine();
                mapaCausas.eliminarCausa(opcionString);
                break;
            
            case 4:
                clearScreen();
                System.out.println("Las causas actuales son");
                mapaCausas.mostrarCausas();
                System.out.println("Ingrese el RIT de la causa a observar: ");

                opcionString = scannerString.nextLine();
                mapaCausas.mostrarCausa(opcionString);
                break;
            case 5:
                clearScreen();
                System.out.println("Seleccione una de las especialidades para buscar abogados:");
                
                opcionString = scannerString.nextLine();
                EspecialidadAbogados(mapaCausas,opcionString);
                break;
            case 6:
                clearScreen();
                AbogadoConMasCausas(mapaCausas);
                break;
                
                
            case 0:
                return;
        }
        pause();
        principal();
    }

    //Metodos

    public static void EspecialidadAbogados(MapaCausas mapaCausa, String especialidadBuscada){
        Iterator<Map.Entry<String,Causa>> iterador = mapaCausa.getMapaCausas().entrySet().iterator();
        ArrayList<String> AbogadosBuscados = new ArrayList<String>();
        while(iterador.hasNext()){
            Map.Entry<String,Causa> aux = (Map.Entry<String,Causa>)iterador.next();
            //Abogados Parte Acusadora
            for(int i = 0; i < aux.getValue().getAcusador().getAcusador().size();i++){
                if(aux.getValue().getAcusador().getAcusador().get(i).getEspecialidad().equals(especialidadBuscada)){
                    if(!AbogadosBuscados.contains(aux.getValue().getAcusador().getAcusador().get(i).getNombre())){
                        AbogadosBuscados.add(aux.getValue().getAcusador().getAcusador().get(i).getNombre());
                    }
                }
            }
            //Abogados Parte Defensora
            for(int i = 0; i < aux.getValue().getDefensor().getDefensor().size();i++){
                if(aux.getValue().getDefensor().getDefensor().get(i).getEspecialidad().equals(especialidadBuscada)){
                    if(!AbogadosBuscados.contains(aux.getValue().getDefensor().getDefensor().get(i).getNombre())){
                        AbogadosBuscados.add(aux.getValue().getDefensor().getDefensor().get(i).getNombre());
                    }
                }
            }
            //Mostrar en pantalla datos conseguidos
            System.out.println("Los abogados de especialidad " + especialidadBuscada + " son:");
            for (int i = 0; i < AbogadosBuscados.size();i++ ){
                System.out.println(AbogadosBuscados.get(i));

            }
        }
    }

    public static void AbogadoConMasCausas(MapaCausas mapaCausa){
        Iterator<Map.Entry<String,Causa>> iterador = mapaCausa.getMapaCausas().entrySet().iterator();
        ArrayList<String> Abogados = new ArrayList<String>();
        String abogadoMasCausas = "";
        int contador = 0 ;
        int maxContador = 0;
        while(iterador.hasNext()){
            Map.Entry<String,Causa> aux = (Map.Entry<String,Causa>)iterador.next();
            //Abogados Parte Acusadora
            for(int i = 0; i < aux.getValue().getAcusador().getAcusador().size();i++){
                if(!Abogados.contains(aux.getValue().getAcusador().getAcusador().get(i).getNombre())){
                    Abogados.add(aux.getValue().getAcusador().getAcusador().get(i).getNombre());
                }
            }
            //Abogados Parte Defensora
            for(int i = 0; i < aux.getValue().getDefensor().getDefensor().size();i++){
                if(!Abogados.contains(aux.getValue().getDefensor().getDefensor().get(i).getNombre())){
                    Abogados.add(aux.getValue().getDefensor().getDefensor().get(i).getNombre());
                }
            }
                
        }
        for(int j = 0; j < Abogados.size();j++){
            contador = 0;
            iterador = mapaCausa.getMapaCausas().entrySet().iterator();
            while(iterador.hasNext()){
                Map.Entry<String,Causa> aux = (Map.Entry<String,Causa>)iterador.next();
                //Parte Acusadora
                for(int i = 0; i < aux.getValue().getAcusador().getAcusador().size();i++){
                    if(aux.getValue().getAcusador().getAcusador().get(i).getNombre().equals(Abogados.get(j))){
                        contador++;
                    }
                }
                //Parte Defensora
                for(int i = 0; i < aux.getValue().getDefensor().getDefensor().size();i++ ){
                    if(aux.getValue().getDefensor().getDefensor().get(i).getNombre().equals(Abogados.get(j))){
                        contador++;
                    }
                }
                    
            }
            if(contador > maxContador){
                maxContador = contador;
                abogadoMasCausas = Abogados.get(j);
            }

            System.out.println("El abogado con mas Causas es: "+ abogadoMasCausas);
            System.out.println("Con un total de: " + (maxContador) + " causas.");
            return;
        }

            
    }

    //Utilidades

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause()
    { 
           System.out.println("Presione una tecla para continuar...");
           try{
               System.in.read();
           }  
           catch(Exception e){

           } 
    }

}
