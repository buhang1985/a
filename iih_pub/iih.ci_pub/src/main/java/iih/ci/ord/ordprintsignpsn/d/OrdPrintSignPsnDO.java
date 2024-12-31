package iih.ci.ord.ordprintsignpsn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ordprintsignpsn.d.desc.OrdPrintSignPsnDODesc;
import java.math.BigDecimal;

/**
 * 医嘱打印人员签字信息 DO数据 
 * 
 */
public class OrdPrintSignPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_ORPRNSIGNPSN= "Id_orprnsignpsn";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//页数
	public static final String PAGE_NUM= "Page_num";
	//人员id
	public static final String ID_PSN= "Id_psn";
	//人员签名
	public static final String NAME_PSN= "Name_psn";
	//类型
	public static final String TYPE= "Type";
	//长临标识
	public static final String FG_LONG= "Fg_long";
	//中医医嘱标识
	public static final String FG_HERB= "Fg_herb";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_orprnsignpsn() {
		return ((String) getAttrVal("Id_orprnsignpsn"));
	}	
	/**
	 * 主键
	 * @param Id_orprnsignpsn
	 */
	public void setId_orprnsignpsn(String Id_orprnsignpsn) {
		setAttrVal("Id_orprnsignpsn", Id_orprnsignpsn);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 页数
	 * @return String
	 */
	public String getPage_num() {
		return ((String) getAttrVal("Page_num"));
	}	
	/**
	 * 页数
	 * @param Page_num
	 */
	public void setPage_num(String Page_num) {
		setAttrVal("Page_num", Page_num);
	}
	/**
	 * 人员id
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}	
	/**
	 * 人员id
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
	}
	/**
	 * 人员签名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 人员签名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 类型
	 * @return String
	 */
	public String getType() {
		return ((String) getAttrVal("Type"));
	}	
	/**
	 * 类型
	 * @param Type
	 */
	public void setType(String Type) {
		setAttrVal("Type", Type);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 中医医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_herb() {
		return ((FBoolean) getAttrVal("Fg_herb"));
	}	
	/**
	 * 中医医嘱标识
	 * @param Fg_herb
	 */
	public void setFg_herb(FBoolean Fg_herb) {
		setAttrVal("Fg_herb", Fg_herb);
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
		return "Id_orprnsignpsn";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_prn_signpsn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdPrintSignPsnDODesc.class);
	}
	
}