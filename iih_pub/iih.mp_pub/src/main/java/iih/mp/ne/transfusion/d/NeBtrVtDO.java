package iih.mp.ne.transfusion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ne.transfusion.d.desc.NeBtrVtDODesc;
import java.math.BigDecimal;

/**
 * 输血记录体征测量 DO数据 
 * 
 */
public class NeBtrVtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NEBTRVT= "Id_nebtrvt";
	public static final String ID_NEBTR= "Id_nebtr";
	public static final String DT_VT= "Dt_vt";
	public static final String SORTNO= "Sortno";
	public static final String FG_TEMSHEET= "Fg_temsheet";
	public static final String ID_SRV= "Id_srv";
	public static final String NAME= "Name";
	public static final String VALCOUNT= "Valcount";
	public static final String VALUE= "Value";
	public static final String FG_POS= "Fg_pos";
	public static final String ID_VT_POS= "Id_vt_pos";
	public static final String SD_VT_POS= "Sd_vt_pos";
	public static final String FG_AUX= "Fg_aux";
	public static final String ID_VT_AUX= "Id_vt_aux";
	public static final String SD_VT_AUX= "Sd_vt_aux";
	public static final String VALUE1= "Value1";
	public static final String VALUE2= "Value2";
	public static final String VALUE3= "Value3";
	public static final String SRV_NAME= "Srv_name";
	public static final String SRV_CODE= "Srv_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nebtrvt() {
		return ((String) getAttrVal("Id_nebtrvt"));
	}	
	public void setId_nebtrvt(String Id_nebtrvt) {
		setAttrVal("Id_nebtrvt", Id_nebtrvt);
	}
	public String getId_nebtr() {
		return ((String) getAttrVal("Id_nebtr"));
	}	
	public void setId_nebtr(String Id_nebtr) {
		setAttrVal("Id_nebtr", Id_nebtr);
	}
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}	
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FBoolean getFg_temsheet() {
		return ((FBoolean) getAttrVal("Fg_temsheet"));
	}	
	public void setFg_temsheet(FBoolean Fg_temsheet) {
		setAttrVal("Fg_temsheet", Fg_temsheet);
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
	public Integer getValcount() {
		return ((Integer) getAttrVal("Valcount"));
	}	
	public void setValcount(Integer Valcount) {
		setAttrVal("Valcount", Valcount);
	}
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}	
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	public FBoolean getFg_pos() {
		return ((FBoolean) getAttrVal("Fg_pos"));
	}	
	public void setFg_pos(FBoolean Fg_pos) {
		setAttrVal("Fg_pos", Fg_pos);
	}
	public String getId_vt_pos() {
		return ((String) getAttrVal("Id_vt_pos"));
	}	
	public void setId_vt_pos(String Id_vt_pos) {
		setAttrVal("Id_vt_pos", Id_vt_pos);
	}
	public String getSd_vt_pos() {
		return ((String) getAttrVal("Sd_vt_pos"));
	}	
	public void setSd_vt_pos(String Sd_vt_pos) {
		setAttrVal("Sd_vt_pos", Sd_vt_pos);
	}
	public FBoolean getFg_aux() {
		return ((FBoolean) getAttrVal("Fg_aux"));
	}	
	public void setFg_aux(FBoolean Fg_aux) {
		setAttrVal("Fg_aux", Fg_aux);
	}
	public String getId_vt_aux() {
		return ((String) getAttrVal("Id_vt_aux"));
	}	
	public void setId_vt_aux(String Id_vt_aux) {
		setAttrVal("Id_vt_aux", Id_vt_aux);
	}
	public String getSd_vt_aux() {
		return ((String) getAttrVal("Sd_vt_aux"));
	}	
	public void setSd_vt_aux(String Sd_vt_aux) {
		setAttrVal("Sd_vt_aux", Sd_vt_aux);
	}
	public String getValue1() {
		return ((String) getAttrVal("Value1"));
	}	
	public void setValue1(String Value1) {
		setAttrVal("Value1", Value1);
	}
	public String getValue2() {
		return ((String) getAttrVal("Value2"));
	}	
	public void setValue2(String Value2) {
		setAttrVal("Value2", Value2);
	}
	public String getValue3() {
		return ((String) getAttrVal("Value3"));
	}	
	public void setValue3(String Value3) {
		setAttrVal("Value3", Value3);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_nebtrvt";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_NE_BTR_VT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NeBtrVtDODesc.class);
	}
	
}