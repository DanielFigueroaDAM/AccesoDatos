import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Anime {
    //nombre, descripcion, fecha, puntuacion
    private String nombre;
    private String descripcion;
    private Date fecha;
    private int puntuacion;

    public Anime(String nombre, String descripcion, Date fecha, int puntuacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.puntuacion = puntuacion;
    }
    public Anime() {
    }
    public String dateToString(Date dataD) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(dataD);
    }
    public Date stringToDate(String dataStr) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date dataUtil = formato.parse(dataStr);
            return new Date(dataUtil.getTime());
        } catch (ParseException e) {
            System.out.println("petou " + e.getMessage());
            return null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }


}
