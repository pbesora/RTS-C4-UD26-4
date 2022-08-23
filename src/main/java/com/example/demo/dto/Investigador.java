package com.example.demo.dto;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="investigadores")
public class Investigador {

	//Attributes
	@Id
	private String id;
	@Column(name = "nom_apels")
	private String nomApels;
	
	@ManyToOne
	@JoinColumn(name="facultad")
	private Facultad facultad;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Reserva> reserva;
	
	
	//Constructors
	
	public Investigador() {
	
	}


	/**
	 * @param id
	 * @param nomApels
	 * @param facultad
	 */
	public Investigador(String id, String nomApels, Facultad facultad) {
		this.id = id;
		this.nomApels = nomApels;
		this.facultad = facultad;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the nomApels
	 */
	public String getNomApels() {
		return nomApels;
	}


	/**
	 * @param nomApels the nomApels to set
	 */
	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}


	/**
	 * @return the facultad
	 */
	public Facultad getFacultad() {
		return facultad;
	}


	/**
	 * @param facultad the facultad to set
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}


	/**
	 * @return the reserva
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}


	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}


	@Override
	public String toString() {
		return "Investigador [id=" + id + ", nomApels=" + nomApels + ", facultad=" + facultad + "]";
	}
}
