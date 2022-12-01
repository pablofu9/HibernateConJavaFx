package entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="zonas")
public class Zona {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="Id_Zona")
	private int id_zona;
	
	@Column(name="nombre_zona")
	private String nombre_zona;
	
	@OneToMany(mappedBy="id_piso",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Piso> pisos;

	
	public Zona() {
		super();
	}


	public Zona(String nombre_zona) {
		this.nombre_zona = nombre_zona;
	}

	public Zona(int id_zona, String nombre_zona) {
		super();
		this.id_zona = id_zona;
		this.nombre_zona = nombre_zona;
	}



	public Zona(int id_zona, String nombre_zona, List<Piso> pisos) {
		super();
		this.id_zona = id_zona;
		this.nombre_zona = nombre_zona;
		this.pisos = pisos;
	}



	public int getId_zona() {
		return id_zona;
	}



	public void setId_zona(int id_zona) {
		this.id_zona = id_zona;
	}



	public String getNombre_zona() {
		return nombre_zona;
	}



	public void setNombre_zona(String nombre_zona) {
		this.nombre_zona = nombre_zona;
	}



	public List<Piso> getPisos() {
		return pisos;
	}



	public void setPisos(List<Piso> pisos) {
		this.pisos = pisos;
	}


	@Override
	public String toString() {
		return +id_zona+" - "+nombre_zona;
	}
}
