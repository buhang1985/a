package iih.hp.cp.eletp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletp.d.desc.HpCpElemTypeNestableDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划可嵌套元素类型 DO数据 
 * 
 */
public class HpCpElemTypeNestableDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//关系id
	public static final String ID_NESTABLE= "Id_nestable";
	//元素类型id
	public static final String ID_ELETP= "Id_eletp";
	//可嵌套元素类型
	public static final String ID_ELETP_NESTABLE= "Id_eletp_nestable";
	//名称
	public static final String NAME_ELETP= "Name_eletp";
	//包标志
	public static final String FG_PKG= "Fg_pkg";
	//是否需要对照
	public static final String FG_NEEDMATCH= "Fg_needmatch";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 关系id
	 * @return String
	 */
	public String getId_nestable() {
		return ((String) getAttrVal("Id_nestable"));
	}	
	/**
	 * 关系id
	 * @param Id_nestable
	 */
	public void setId_nestable(String Id_nestable) {
		setAttrVal("Id_nestable", Id_nestable);
	}
	/**
	 * 元素类型id
	 * @return String
	 */
	public String getId_eletp() {
		return ((String) getAttrVal("Id_eletp"));
	}	
	/**
	 * 元素类型id
	 * @param Id_eletp
	 */
	public void setId_eletp(String Id_eletp) {
		setAttrVal("Id_eletp", Id_eletp);
	}
	/**
	 * 可嵌套元素类型
	 * @return String
	 */
	public String getId_eletp_nestable() {
		return ((String) getAttrVal("Id_eletp_nestable"));
	}	
	/**
	 * 可嵌套元素类型
	 * @param Id_eletp_nestable
	 */
	public void setId_eletp_nestable(String Id_eletp_nestable) {
		setAttrVal("Id_eletp_nestable", Id_eletp_nestable);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_eletp() {
		return ((String) getAttrVal("Name_eletp"));
	}	
	/**
	 * 名称
	 * @param Name_eletp
	 */
	public void setName_eletp(String Name_eletp) {
		setAttrVal("Name_eletp", Name_eletp);
	}
	/**
	 * 包标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pkg() {
		return ((FBoolean) getAttrVal("Fg_pkg"));
	}	
	/**
	 * 包标志
	 * @param Fg_pkg
	 */
	public void setFg_pkg(FBoolean Fg_pkg) {
		setAttrVal("Fg_pkg", Fg_pkg);
	}
	/**
	 * 是否需要对照
	 * @return FBoolean
	 */
	public FBoolean getFg_needmatch() {
		return ((FBoolean) getAttrVal("Fg_needmatch"));
	}	
	/**
	 * 是否需要对照
	 * @param Fg_needmatch
	 */
	public void setFg_needmatch(FBoolean Fg_needmatch) {
		setAttrVal("Fg_needmatch", Fg_needmatch);
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
		return "Id_nestable";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_cp_eletpnestable";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemTypeNestableDODesc.class);
	}
	
}