
package iih.bl.cg.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public class BlcgOepAggDTO  extends BaseDTO{
private static final long serialVersionUID = 1L;

	
	public String getId_cgoep() {
		return ((String) getAttrVal("Id_cgoep"));
	}	
	public void setId_cgoep(String Id_cgoep) {
		setAttrVal("Id_cgoep", Id_cgoep);
	}
	public String getId_cgitmoep() {
		return ((String) getAttrVal("Id_cgitmoep"));
	}	
	public void setId_cgitmoep(String Id_cgitmoep) {
		setAttrVal("Id_cgitmoep", Id_cgitmoep);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public FDateTime getBl_cg_oep_sv() {
		return ((FDateTime) getAttrVal("Bl_cg_oep_sv"));
	}	
	public void setBl_cg_oep_sv(FDateTime Bl_cg_oep_sv) {
		setAttrVal("Bl_cg_oep_sv", Bl_cg_oep_sv);
	}
	public FDateTime getBl_cg_itm_oep_sv() {
		return ((FDateTime) getAttrVal("Bl_cg_itm_oep_sv"));
	}	
	public void setBl_cg_itm_oep_sv(FDateTime Bl_cg_itm_oep_sv) {
		setAttrVal("Bl_cg_itm_oep_sv", Bl_cg_itm_oep_sv);
	}
	
}
