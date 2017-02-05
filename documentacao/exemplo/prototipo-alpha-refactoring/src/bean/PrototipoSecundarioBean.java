package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="prototipoSecundarioBean")
@ViewScoped
public class PrototipoSecundarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6179001641134200013L;
	
	private String dumbProperty;

	@PostConstruct
	public void init(){
		
		System.out.println("PrototipoSecundarioBean @PostConstruct");
		
		dumbProperty = "PrototipoSecundarioBean property.";
		
	}

	public String getDumbProperty() {
		return dumbProperty;
	}

	public void setDumbProperty(String dumbProperty) {
		this.dumbProperty = dumbProperty;
	}
	
	
	
}
