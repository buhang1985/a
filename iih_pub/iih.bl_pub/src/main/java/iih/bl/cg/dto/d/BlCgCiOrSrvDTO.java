package iih.bl.cg.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public class BlCgCiOrSrvDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String DT_EFFE= "Dt_effe";
	public static final String DT_STOP= "Dt_stop";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String NAME= "Name";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_DEP= "Id_dep";
	public static final String QUAN= "quan"; //数量
	
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	public FDateTime getDt_stop() {
		return ((FDateTime) getAttrVal("Dt_stop"));
	}	
	public void setDt_stop(FDateTime Dt_stop) {
		setAttrVal("Dt_stop", Dt_stop);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
}
