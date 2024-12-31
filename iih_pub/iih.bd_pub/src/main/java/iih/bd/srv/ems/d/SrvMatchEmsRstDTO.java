package iih.bd.srv.ems.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public class SrvMatchEmsRstDTO extends BaseDTO {
private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗单主键标识
	 * @return String
	 */
	public String getId_ems() {
		return ((String) getAttrVal("Id_ems"));
	}
	/**
	 * 医疗单主键标识
	 * @param Id_ems
	 */
	public void setId_ems(String Id_ems) {
		setAttrVal("Id_ems", Id_ems);
	}
	/**
	 * 功能类字串
	 * @return String
	 */
	public String getFuncclassstr() {
		return ((String) getAttrVal("Funcclassstr"));
	}
	/**
	 * 功能类字串
	 * @param Funcclassstr
	 */
	public void setFuncclassstr(String Funcclassstr) {
		setAttrVal("Funcclassstr", Funcclassstr);
	}
	/**
	 * 显示名称
	 * @return String
	 */
	public String getName_show() {
		return ((String) getAttrVal("Name_show"));
	}
	/**
	 * 显示名称
	 * @param Name_show
	 */
	public void setName_show(String Name_show) {
		setAttrVal("Name_show", Name_show);
	}
	/**
	 * 生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 生效时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 简化的流程标识
	 * @return FBoolean
	 */
	public FBoolean getFg_quickwflow() {
		return ((FBoolean) getAttrVal("Fg_quickwflow"));
	}
	/**
	 * 简化的流程标识
	 * @param fg_quickwflow
	 */
	public void setFg_quickwflow(FBoolean fg_quickwflow) {
		setAttrVal("Fg_quickwflow", fg_quickwflow);
	}
}
