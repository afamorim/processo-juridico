package vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrototipoVO implements Serializable {
	
	private static final long serialVersionUID = 8550821630880786169L;
	
	private boolean checked;
	private boolean isSubChild;
	private boolean isTotalRow;
	
	private int codigo;
	private String attr1;
	private String attr2;
	private String attr3;
	private String attr4;
	private String attr5;
	
	private int attrInt1;
	private int attrInt2;
	private int attrInt3;
	private int attrInt4;
	private int attrInt5;
	
	private Double attrDouble1;
	private Double attrDouble2;
	private Double attrDouble3;
	private Double attrDouble4;
	private Double attrDouble5;
	
	private List<PrototipoVO> children;
	private PrototipoVO childVO;
	
	public PrototipoVO(){
		
	}
	
	public PrototipoVO(int codigo, String attr1, String attr2) {
		setCodigo(codigo);
		setAttr1(attr1);
		setAttr2(attr2);
		
		//setChecked((Math.random()>.5)?Boolean.FALSE:Boolean.TRUE);
		setChecked(Boolean.TRUE);
	}
	
	public PrototipoVO(int codigo, String attr1, String attr2, int attrInt1, int attrInt2) {
		this(codigo,attr1,attr2);
		setAttrInt1(attrInt1);
		setAttrInt2(attrInt2);
	}
	
	public PrototipoVO(int codigo, String attr1, String attr2, Double attrDouble1, Double attrDouble2) {
		this(codigo,attr1,attr2);
		setAttrDouble1(attrDouble1);
		setAttrDouble2(attrDouble2);
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getAttr2() {
		return attr2;
	}
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	public String getAttr3() {
		return attr3;
	}
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}
	public String getAttr4() {
		return attr4;
	}
	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}
	public String getAttr5() {
		return attr5;
	}
	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

	public int getAttrInt1() {
		return attrInt1;
	}

	public void setAttrInt1(int attrInt1) {
		this.attrInt1 = attrInt1;
	}

	public int getAttrInt2() {
		return attrInt2;
	}

	public void setAttrInt2(int attrInt2) {
		this.attrInt2 = attrInt2;
	}

	public int getAttrInt3() {
		return attrInt3;
	}

	public void setAttrInt3(int attrInt3) {
		this.attrInt3 = attrInt3;
	}

	public int getAttrInt4() {
		return attrInt4;
	}

	public void setAttrInt4(int attrInt4) {
		this.attrInt4 = attrInt4;
	}

	public int getAttrInt5() {
		return attrInt5;
	}

	public void setAttrInt5(int attrInt5) {
		this.attrInt5 = attrInt5;
	}

	public List<PrototipoVO> getChildren() {
		return children;
	}

	public void setChildren(List<PrototipoVO> children) {
		this.children = children;
	}

	public Double getAttrDouble1() {
		return attrDouble1;
	}

	public void setAttrDouble1(Double attrDouble1) {
		this.attrDouble1 = attrDouble1;
	}

	public Double getAttrDouble2() {
		return attrDouble2;
	}

	public void setAttrDouble2(Double attrDouble2) {
		this.attrDouble2 = attrDouble2;
	}

	public Double getAttrDouble3() {
		return attrDouble3;
	}

	public void setAttrDouble3(Double attrDouble3) {
		this.attrDouble3 = attrDouble3;
	}

	public Double getAttrDouble4() {
		return attrDouble4;
	}

	public void setAttrDouble4(Double attrDouble4) {
		this.attrDouble4 = attrDouble4;
	}

	public Double getAttrDouble5() {
		return attrDouble5;
	}

	public void setAttrDouble5(Double attrDouble5) {
		this.attrDouble5 = attrDouble5;
	}
	
	public void setChild(PrototipoVO pChild) {
		
		if(getChildren() == null) {
			setChildren(new ArrayList<PrototipoVO>());
		}
		
		getChildren().add(pChild);
		
		if(pChild != null && pChild.getAttrDouble1() != null) {
			if(attrDouble1 == null) {
				attrDouble1 = 0.0;
			}
			this.attrDouble1 += pChild.getAttrDouble1();
		}

		if(pChild != null && pChild.getAttrDouble2() != null) {
			if(attrDouble2 == null) {
				attrDouble2 = 0.0;
			}
			this.attrDouble2 += pChild.getAttrDouble2();
		}
		if(pChild != null && pChild.getAttrDouble3() != null) {
			if(attrDouble3 == null) {
				attrDouble3 = 0.0;
			}
			this.attrDouble3 += pChild.getAttrDouble3();
		}

		if(pChild != null && pChild.getAttrDouble4() != null) {
			if(attrDouble4 == null) {
				attrDouble4 = 0.0;
			}
			this.attrDouble4 += pChild.getAttrDouble4();
		}

		if(pChild != null && pChild.getAttrDouble5() != null) {
			if(attrDouble5 == null) {
				attrDouble5 = 0.0;
			}
			this.attrDouble5 += pChild.getAttrDouble5();
		}

	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isSubChild() {
		return isSubChild;
	}

	public void setSubChild(boolean isSubChild) {
		this.isSubChild = isSubChild;
	}

	public boolean isTotalRow() {
		return isTotalRow;
	}

	public void setTotalRow(boolean isTotalRow) {
		this.isTotalRow = isTotalRow;
	}

	public PrototipoVO getChildVO() {
		return (childVO!=null)?childVO:new PrototipoVO();
	}

	public void setChildVO(PrototipoVO childVO) {
		this.childVO = childVO;
	}
	
	
	
}
