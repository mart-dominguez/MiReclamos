package ar.edu.utn.frsf.ofa.mireclamos;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Reclamo {
    private static Integer ID_GEN=0;


    private Integer id;
    private String descripcion;
    private LatLng ubicacion;
    private Boolean resuelto;
    private String mailContacto;
    private String pathImagen;

    public Reclamo() {
        this.id = ++ID_GEN;
        resuelto=false;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LatLng getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(LatLng ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Boolean getResuelto() {
        return resuelto;
    }

    public void setResuelto(Boolean resuelto) {
        this.resuelto = resuelto;
    }

    public String getMailContacto() {
        return mailContacto;
    }

    public void setMailContacto(String mailContacto) {
        this.mailContacto = mailContacto;
    }

    public JSONObject toJson(){
        JSONObject unReclamo = new JSONObject();
        try {
            unReclamo.put("id",this.id);
            unReclamo.put("descripcion",this.descripcion);
            JSONObject latLng = new JSONObject();
            latLng.put("latitud",this.ubicacion.latitude);
            latLng.put("longitud",this.ubicacion.longitude);
            unReclamo.put("ubicacion",latLng);
            unReclamo.put("resuelto",this.resuelto);
            unReclamo.put("mailContacto",this.mailContacto);
            unReclamo.put("pathImagen",this.pathImagen);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return unReclamo;
    }

    public void loadFromJson(JSONObject fila ){
        try {
            this.id=fila.getInt("id");
            this.descripcion= fila.getString("descripcion");
            this.mailContacto = fila.getString("mailContacto");
            this.pathImagen = fila.getString("pathImagen");
            this.resuelto = fila.getBoolean("resuelto");
            JSONObject latLng = fila.getJSONObject("ubicacion");
            this.ubicacion = new LatLng(latLng.getDouble("latitud"),latLng.getDouble("longitud"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reclamo reclamo = (Reclamo) o;
        return Objects.equals(id, reclamo.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
