package iih.hp.cp.eletpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletpl.d.desc.HpCpElemIndexTplDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_患者关键指标_模板 DO数据 
 * 
 */
public class HpCpElemIndexTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ELE_IND_TPL= "Id_ele_ind_tpl";
	public static final String ID_ELE_TPL= "Id_ele_tpl";
	public static final String ID_SRV= "Id_srv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ele_ind_tpl() {
		return ((String) getAttrVal("Id_ele_ind_tpl"));
	}	
	public void setId_ele_ind_tpl(String Id_ele_ind_tpl) {
		setAttrVal("Id_ele_ind_tpl", Id_ele_ind_tpl);
	}
	public String getId_ele_tpl() {
		return ((String) getAttrVal("Id_ele_tpl"));
	}	
	public void setId_ele_tpl(String Id_ele_tpl) {
		setAttrVal("Id_ele_tpl", Id_ele_tpl);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
		return "Id_ele_ind_tpl";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_IND_TPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemIndexTplDODesc.class);
	}
	
}