package bean;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.ToggleSelectEvent;

import vo.PrototipoVO;

@ManagedBean(name="prototipoBean")
@ViewScoped
public class PrototipoBean implements Serializable {

	private static final long serialVersionUID = -383178025787135804L;
	
	private List<PrototipoVO> genericList;
	private List<PrototipoVO> selectedGenericList;
	
	private List<PrototipoVO> genericListSub;
	private List<PrototipoVO> selectedGenericListSub;
	
	private List<PrototipoVO> emptyList;
	
	private PrototipoVO gerenciaDivisao;
	private List<PrototipoVO> gerenciasDivisao;
	private PrototipoVO diretoria;
	
	private boolean bool1 = true;
	
	private String xhtmlPath;
	
	@PostConstruct
	public void init(){
		System.out.println("PrototipoBean @PostConstruct");
		
		xhtmlPath = "";
		
		gerenciaDivisao = new PrototipoVO();
		
		genericList = new ArrayList<PrototipoVO>();
		for(int i=0; i<15; i++){
			genericList.add(new PrototipoVO(i, "Registro de Teste "+i, "Descrição ("+i+") do registro de teste com uma maior quantidade de caracteres, para fins de teste de tamanho em determinados componentes de lista."));
		}
		
		
		genericListSub = new ArrayList<PrototipoVO>();
		int c = 0;
		for(int i=0; i<3; i++){
			PrototipoVO tempItem = new PrototipoVO(i, "("+i+") Licenças SW", "("+i+") Licenças Microsoft");
			for(int s=0; s<((i==0)?6:2); s++){
				Double t = (12.34 * Math.random()) * c;
				
				PrototipoVO tempSubitem = new PrototipoVO(c, "CAP13104"+c, "Licenças Microsoft - 2015 ("+c+")", t*(Math.random()*50), t*(Math.random()*20));
				tempSubitem.setSubChild(false);
				tempSubitem.setTotalRow(false);
				
				if(i==0 && s>0 && s<3){
					tempSubitem.setSubChild(true);
				} else if (i==0 && s==3){
					tempSubitem.setTotalRow(true);
				}
				
				tempItem.setChild(tempSubitem);
				c++;
			}
			
			genericListSub.add(tempItem);
		}
		
	}
	
	public void checkAllLinhas (ToggleSelectEvent e){
		for(PrototipoVO item : genericListSub){
			for(PrototipoVO subitem : item.getChildren()){
				subitem.setChecked(e.isSelected());
			}
		}
	}
	
	public Double sumDoubleByCollection(List<Object> list, String prop){
		System.out.println("passou");
		
		Double d = 0.0;
		
		for(Object item : list){
			
			Class<?> c = item.getClass();
			Field f;
			try {
				f = c.getDeclaredField(prop);
				f.setAccessible(true);
				
				Double value = (Double) f.get(item);
				d += value;
				
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
		return d;
	}
	
	public boolean switchBoolean1(){
		this.bool1 = !this.bool1;
		return this.bool1;
	}

	public List<PrototipoVO> getGenericList() {
		return genericList;
	}

	public void setGenericList(List<PrototipoVO> genericList) {
		this.genericList = genericList;
	}

	public boolean isBool1() {
		return bool1;
	}

	public void setBool1(boolean bool1) {
		this.bool1 = bool1;
	}

	public List<PrototipoVO> getGenericListSub() {
		return genericListSub;
	}

	public void setGenericListSub(List<PrototipoVO> genericListSub) {
		this.genericListSub = genericListSub;
	}

	public List<PrototipoVO> getSelectedGenericListSub() {
		return selectedGenericListSub;
	}

	public void setSelectedGenericListSub(List<PrototipoVO> selectedGenericListSub) {
		this.selectedGenericListSub = selectedGenericListSub;
	}

	public List<PrototipoVO> getSelectedGenericList() {
		return selectedGenericList;
	}

	public void setSelectedGenericList(List<PrototipoVO> selectedGenericList) {
		this.selectedGenericList = selectedGenericList;
	}

	public List<PrototipoVO> getEmptyList() {
		return emptyList;
	}

	public void setEmptyList(List<PrototipoVO> emptyList) {
		this.emptyList = emptyList;
	}

	public PrototipoVO getGerenciaDivisao() {
		return gerenciaDivisao;
	}

	public void setGerenciaDivisao(PrototipoVO gerenciaDivisao) {
		this.gerenciaDivisao = gerenciaDivisao;
	}

	public PrototipoVO getDiretoria() {
		return (diretoria!=null)?diretoria:new PrototipoVO();
	}

	public void setDiretoria(PrototipoVO diretoria) {
		this.diretoria = diretoria;
	}

	public List<PrototipoVO> getGerenciasDivisao() {
		return gerenciasDivisao;
	}

	public void setGerenciasDivisao(List<PrototipoVO> gerenciasDivisao) {
		this.gerenciasDivisao = gerenciasDivisao;
	}

	public String getXhtmlPath() {
		return xhtmlPath;
	}

	public void setXhtmlPath(String xhtmlPath) {
		this.xhtmlPath = xhtmlPath;
	}
	
	
}
