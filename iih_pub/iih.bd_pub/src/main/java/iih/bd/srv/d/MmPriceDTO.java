package iih.bd.srv.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDouble;

public class MmPriceDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 读写服务ID字段
	 * @return
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	/**
	 * 读写物品ID字段
	 * @return
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	
	/**
	 * 读写物品名称
	 * @return
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	
	/**
	 * 读写物品规格
	 * @return
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	public void setSpec(String spec) {
		setAttrVal("Spec", spec);
	}
	
	/**
	 * 读写物品价格
	 * @return
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	public void setPrice(FDouble price) {
		setAttrVal("Price", price);
	}

}
