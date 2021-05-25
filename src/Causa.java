public class Causa {
    //Atributos
    private ParteAcusadora acusador;
    private ParteDefensora defensor;
    private String tipoCausa;
    private String rit;
    
    //Constructor
    public Causa(ParteAcusadora acusador, ParteDefensora defensor, String tipoCausa, String rit){
        this.acusador = acusador;
        this.defensor = defensor;
        this.tipoCausa = tipoCausa;
        this.rit = rit;
    }

    public Causa(){
    }
    
    //Getter y Setter
    public ParteAcusadora getAcusador() {
        return acusador;
    }

    public void setAcusador(ParteAcusadora acusador) {
        this.acusador = acusador;
    }

    public ParteDefensora getDefensor() {
        return defensor;
    }

    public void setDefensor(ParteDefensora defensor) {
        this.defensor = defensor;
    }

    public String getTipoCausa() {
        return tipoCausa;
    }

    public void setTipoCausa(String tipoCausa) {
        this.tipoCausa = tipoCausa;
    }

    public String getRit() {
        return rit;
    }

    public void setRit(String rit) {
        this.rit = rit;
    }

    public void mostrarCausa(){
        gestionDeCausas.clearScreen();
        System.out.println("La causa tiene RIT: " + rit);
        System.out.println("El tipo de la causa es: " + tipoCausa);
        System.out.println("");
        System.out.println("La parte Defensora es:");
        defensor.mostrarDatos();
        System.out.println("");
        System.out.println("La parte Atacante es");
        acusador.mostrarDatos();
        return;
    }
    
}
