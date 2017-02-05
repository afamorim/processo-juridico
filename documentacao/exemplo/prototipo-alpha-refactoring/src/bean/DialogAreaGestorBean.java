package bean;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vo.PrototipoVO;

@ManagedBean(name="dialogAreaGestorBean")
@ViewScoped
public class DialogAreaGestorBean implements Serializable {

	private static final String SELECTION_MODE_SINGLE = "single";

	private static final long serialVersionUID = 5193908304479423288L;
	
	private List<PrototipoVO> list;
	private List<PrototipoVO> selectedItems;
	private PrototipoVO selectedItem;
	
	private Object bean;
	private String property;
	private String update;
	private String selectionMode;
	
	@PostConstruct
	public void init(){
		
		list = new ArrayList<PrototipoVO>();
		for(int i=0; i<7; i++){
			list.add(new PrototipoVO(i, "Lista genérica para dialogs "+i, i+" Exemplo de lista para dialogs"));
		}
		
	}
	
	public void clear(){
		setSelectedItems(null);
		setSelectedItem(null);
		setSelectionMode(null);
	}
	
	public void set(){
		Class<?> c = bean.getClass();
		
		try {
			
			String [] nestedAttributes = property.split("\\.");
			Field f = null;
			Class<?> lastClass = c;
			Object lastObject = bean;
			for(int i=0; i<nestedAttributes.length; i++){
				
				String fieldName = nestedAttributes[i];
				f = lastClass.getDeclaredField(fieldName);
				f.setAccessible(true);
				
				if(i < nestedAttributes.length-1){
					lastObject = f.get(lastObject);
				}
				
				lastClass = f.getType();

			}

			f.set(lastObject, (getSelectionMode().equals(SELECTION_MODE_SINGLE)) ? selectedItem : selectedItems);
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
	
	public List<PrototipoVO> getList() {
		return list;
	}

	public void setList(List<PrototipoVO> list) {
		this.list = list;
	}

	public List<PrototipoVO> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<PrototipoVO> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public PrototipoVO getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(PrototipoVO selectedItem) {
		this.selectedItem = selectedItem;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getSelectionMode() {
		return (selectionMode!=null)?selectionMode:SELECTION_MODE_SINGLE;
	}

	public void setSelectionMode(String selectionMode) {
		this.selectionMode = selectionMode;
	}
	
}
