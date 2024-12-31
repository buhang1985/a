package iih.bd.pp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 服务价格计算DTO DTO数据 
 * 
 */
public class PriCalDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}	
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	public String getSrvsetadds() {
		return ((String) getAttrVal("Srvsetadds"));
	}	
	public void setSrvsetadds(String Srvsetadds) {
		setAttrVal("Srvsetadds", Srvsetadds);
	}

	
}