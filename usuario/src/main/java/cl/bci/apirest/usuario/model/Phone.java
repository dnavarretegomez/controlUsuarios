package cl.bci.apirest.usuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="phone")
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_phone")
	private int idPhone;
	@Column(name="number",length = 8)
	private int number;
	@Column(name="citycode",length = 3)
	private int citycode;
	@Column(name="contrycode",length = 3)
	private int contrycode;
	
	public int getIdPhone() {
		return idPhone;
	}
	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCitycode() {
		return citycode;
	}
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	public int getContrycode() {
		return contrycode;
	}
	public void setContrycode(int contrycode) {
		this.contrycode = contrycode;
	}
	
	
}