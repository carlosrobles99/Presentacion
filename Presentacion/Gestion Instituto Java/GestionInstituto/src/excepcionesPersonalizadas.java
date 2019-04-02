
public class excepcionesPersonalizadas  extends Exception{
    
    private int valor;
    
    public excepcionesPersonalizadas() {
        this.valor = 0;
    }

    public excepcionesPersonalizadas(int valor) {
        this.valor = valor;
    }
    
    public String toString(){
        String texto = "";
        switch(valor){
            case 1:
                texto="\nEl DNI esta repetido";
                break;
            case 2:
                texto="\nEl DNI no existe";
                break;
            case 3:
                texto="\nEl salario no puede ser negativo";
                break;
            case 4:
                texto="\nEl año de incorporacion no es valido";
                break;
        }
        
        return texto;
        
    }
    
}
 