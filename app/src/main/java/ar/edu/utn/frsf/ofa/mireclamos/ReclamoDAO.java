package ar.edu.utn.frsf.ofa.mireclamos;

import java.util.ArrayList;
import java.util.List;

public class ReclamoDAO {

    private static ReclamoDAO instancia=null;
    private List<Reclamo> lista;
    private  ReclamoDAO(){
        lista = new ArrayList<>();
    }

    public static ReclamoDAO getInstance(){
        if(instancia==null) instancia = new ReclamoDAO();
        return instancia;
    }

    public void add(Reclamo r){
        this.lista.add(r);
    }

    public void quitar(Reclamo r){
        this.lista.remove(r);
    }

    public List<Reclamo> listar(){
        return  this.lista;
    }

    public Reclamo buscar(Integer id){
        Reclamo aux = new Reclamo();
        aux.setId(id);
        return this.lista.get(this.lista.indexOf(aux));
    }
}
