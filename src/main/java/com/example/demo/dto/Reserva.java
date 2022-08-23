package com.example.demo.dto;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "comienzo")
	private Date comienzo;
	@Column(name = "fin")
	private Date fin;
	
	@ManyToOne
    @JoinColumn(name = "equipo")
     Equipo equipo;
 
    @ManyToOne
    @JoinColumn(name = "investigador")
    Investigador investigador;
    
    
	//Constructors
	
	public Reserva() {
	
	}


	/**
	 * @param id
	 * @param comienzo
	 * @param fin
	 * @param equipo
	 * @param investigador
	 */
	public Reserva(int id, Date comienzo, Date fin, Equipo equipo, Investigador investigador) {
		this.id = id;
		this.comienzo = comienzo;
		this.fin = fin;
		this.equipo = equipo;
		this.investigador = investigador;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the comienzo
	 */
	public Date getComienzo() {
		return comienzo;
	}


	/**
	 * @param comienzo the comienzo to set
	 */
	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}


	/**
	 * @return the fin
	 */
	public Date getFin() {
		return fin;
	}


	/**
	 * @param fin the fin to set
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}


	/**
	 * @return the equipo
	 */
	public Equipo getEquipo() {
		return equipo;
	}


	/**
	 * @param equipo the equipo to set
	 */
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	/**
	 * @return the investigador
	 */
	public Investigador getInvestigador() {
		return investigador;
	}


	/**
	 * @param investigador the investigador to set
	 */
	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}


	@Override
	public String toString() {
		return "Reserva [id=" + id + ", comienzo=" + comienzo + ", fin=" + fin + ", equipo=" + equipo
				+ ", investigador=" + investigador + "]";
	}


	
}












	

