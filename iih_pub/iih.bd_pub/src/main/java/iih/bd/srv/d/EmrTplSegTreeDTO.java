package iih.bd.srv.d;

import xap.mw.core.data.BaseDTO;
import xap.sys.securityfw.login.d.ILoginConstants;

public class EmrTplSegTreeDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	
//	public static String ID_EMRTPL = "Id_emrtpl";
//	public static String NAME = "Name";
//	public static String NUM = "Num";
	
	public String getId_emrtpl() {
		return (String)getAttrVal("Id_emrtpl");
	}
	public void setId_emrtpl(String id_emrtpl) {
		setAttrVal("Id_emrtpl", id_emrtpl);
	}
	
	public String getName() {
		return (String)getAttrVal("Name");
	}
	public void setName(String name) {
		setAttrVal("Name", name);
	}
	
	public String getId_parent() {
		return (String)getAttrVal("Id_parent");
	}
	public void setId_parent(String id_parent) {
		setAttrVal("Id_parent", id_parent);
	}
	
	public Integer getNum() {
		return (Integer)getAttrVal("Num");
	}
	public void setNum(Integer num) {
		setAttrVal("Num", num);
	}
}
