package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemIndexDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_患者关键指标 DO数据 
 * 
 */
public class HpCpElemIndexDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//关键指标ID
	public static final String ID_ELE_IND= "Id_ele_ind";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//指标
	public static final String ID_SRV= "Id_srv";
	//服务名称
	public static final String ID_SRV_NAME= "Id_srv_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 关键指标ID
	 * @return String
	 */
	public String getId_ele_ind() {
		return ((String) getAttrVal("Id_ele_ind"));
	}	
	/**
	 * 关键指标ID
	 * @param Id_ele_ind
	 */
	public void setId_ele_ind(String Id_ele_ind) {
		setAttrVal("Id_ele_ind", Id_ele_ind);
	}
	/**
	 * 元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}	
	/**
	 * 元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 指标
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 指标
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getId_srv_name() {
		return ((String) getAttrVal("Id_srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Id_srv_name
	 */
	public void setId_srv_name(String Id_srv_name) {
		setAttrVal("Id_srv_name", Id_srv_name);
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
		return "Id_ele_ind";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_IND";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemIndexDODesc.class);
	}
	
}