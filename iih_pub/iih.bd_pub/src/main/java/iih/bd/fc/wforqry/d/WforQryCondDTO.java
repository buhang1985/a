package iih.bd.fc.wforqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class WforQryCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	
	public String getEntp() {
		return ((String) getAttrVal("Entp"));
	}	
	public void setEntp(String Entp) {
		setAttrVal("Entp", Entp);
	}
	public String getSrvtp() {
		return ((String) getAttrVal("Srvtp"));
	}	
	public void setSrvtp(String Srvtp) {
		setAttrVal("Srvtp", Srvtp);
	}
	public String getSrvca() {
		return ((String) getAttrVal("Srvca"));
	}	
	public void setSrvca(String Srvca) {
		setAttrVal("Srvca", Srvca);
	}
	public String getSrv() {
		return ((String) getAttrVal("Srv"));
	}	
	public void setSrv(String Srv) {
		setAttrVal("Srv", Srv);
	}
	public String getUsg() {
		return ((String) getAttrVal("Usg"));
	}	
	public void setUsg(String Usg) {
		setAttrVal("Usg", Usg);
	}
	public String getOrdrecurtp() {
		return ((String) getAttrVal("Ordrecurtp"));
	}	
	public void setOrdrecurtp(String Ordrecurtp) {
		setAttrVal("Ordrecurtp", Ordrecurtp);
	}
	public String getTime_b() {
		return ((String) getAttrVal("Time_b"));
	}	
	public void setTime_b(String Time_b) {
		setAttrVal("Time_b", Time_b);
	}
	public String getTime_e() {
		return ((String) getAttrVal("Time_e"));
	}	
	public void setTime_e(String Time_e) {
		setAttrVal("Time_e", Time_e);
	}
	public String getWeeks() {
		return ((String) getAttrVal("Weeks"));
	}	
	public void setWeeks(String Weeks) {
		setAttrVal("Weeks", Weeks);
	}
	public String getId_qry() {
		return ((String) getAttrVal("Id_qry"));
	}	
	public void setId_qry(String Id_qry) {
		setAttrVal("Id_qry", Id_qry);
	}

	
}