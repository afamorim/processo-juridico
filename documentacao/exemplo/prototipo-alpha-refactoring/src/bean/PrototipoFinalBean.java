package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="prototipoFinalBean")
@ViewScoped
public class PrototipoFinalBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3908869848645516821L;
	
	private String dumbProperty;

	@PostConstruct
	public void init(){
		
		System.out.println("PrototipoFinalBean @PostConstruct");
		
		dumbProperty = "PrototipoFinalBean property.";
		
	}

	public String getDumbProperty() {
		return dumbProperty;
	}

	public void setDumbProperty(String dumbProperty) {
		this.dumbProperty = dumbProperty;
	}
	
	
	
}
