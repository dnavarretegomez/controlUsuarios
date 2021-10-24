package cl.bci.apirest.usuario.response;

public class DatosRegistroResponse {

	
	private String id;
	private String created;
	private String modified;
	private String last_login;
	private String token;
	private Boolean isactive;
	
	
	public DatosRegistroResponse() {
		
	}
	
	public DatosRegistroResponse(String id, String created, String modified, String last_login, String token,
			Boolean isactive) {
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.token = token;
		this.isactive = isactive;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
}
