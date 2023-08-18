import java.util.ArrayList;

public class Subasta
{
    private ArrayList<Lote> lotes;
    private int numeroDeLotesSiguiente;
    
    public Subasta()
    {
         lotes = new ArrayList<Lote>();
         numeroDeLotesSiguiente = 1;
    }
    
    public void ingresarLote(String descripcion)
    {
        lotes.add(new Lote(numeroDeLotesSiguiente, descripcion));
        numeroDeLotesSiguiente++;
    }
    
    public void mostrarLotes()
    {
        for(Lote lote : lotes){
            System.out.println(lote.toString());
        }
    }

    public void ofertarPara(int numeroDeLote, Persona ofertante, long valor)
    {
        Lote loteElegido = getLote(numeroDeLote);
        boolean exito = false;
        
        if(loteElegido != null){
            exito = loteElegido.ofertaPara(new Oferta(ofertante, valor));
        }
        
        if(exito){
            System.out.println("La oferta para el lote N° " + numeroDeLote + " resultó exitosa");
        }
        else{
            Oferta ofertaMaxima = loteElegido.getOfertaMaxima();
            System.out.println("El lote N° " +numeroDeLote+ " tiene una oferta de: " +ofertaMaxima.getMonto());
        }
    }
    
    public Lote getLote(int numeroDeLote)
    {
        if((numeroDeLote >= 1) && (numeroDeLote < numeroDeLotesSiguiente))
        {
            Lote loteElegido = lotes.get(numeroDeLote -1);
            if(loteElegido.getNumero() != numeroDeLote)
            {
                System.out.println("Error interno: se retorno el lote N°: " +loteElegido.getNumero()+ " en lugar de " +numeroDeLote);
            }
            return loteElegido;
        }
        else{
            System.out.println("El lote N°: " +numeroDeLote+ " no existe");
            return null;
        }
    }
    
    public void mostrarAdjudicados()
    {
        for(Lote lote : lotes){
            System.out.println(lote.mostrarGanador());
        }
    }
}
