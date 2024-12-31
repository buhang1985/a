package iih.pe.pbd.pedeptset.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.pedeptset.d.desc.PeDeptSetSrvCaDODesc;
import java.math.BigDecimal;

/**
 * 体检科室包含医疗服务基本分类 DO数据 
 * 
 */
public class PeDeptSetSrvCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检对应医疗服务类型主键标识
	public static final String ID_PEDEPTSETSRVCA= "Id_pedeptsetsrvca";
	//体检科室ID
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//服务基本分类ID
	public static final String ID_SRVCA= "Id_srvca";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//默认服务类型编码
	public static final String SD_SRVTP_SRVCA= "Sd_srvtp_srvca";
	//服务分类编码
	public static final String CODE_SRVCA= "Code_srvca";
	//服务分类名称
	public static final String NAME_SRVCA= "Name_srvca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检对应医疗服务类型主键标识
	 * @return String
	 */
	public String getId_pedeptsetsrvca() {
		return ((String) getAttrVal("Id_pedeptsetsrvca"));
	}	
	/**
	 * 体检对应医疗服务类型主键标识
	 * @param Id_pedeptsetsrvca
	 */
	public void setId_pedeptsetsrvca(String Id_pedeptsetsrvca) {
		setAttrVal("Id_pedeptsetsrvca", Id_pedeptsetsrvca);
	}
	/**
	 * 体检科室ID
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 体检科室ID
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 服务基本分类ID
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 服务基本分类ID
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 默认服务类型编码
	 * @return String
	 */
	public String getSd_srvtp_srvca() {
		return ((String) getAttrVal("Sd_srvtp_srvca"));
	}	
	/**
	 * 默认服务类型编码
	 * @param Sd_srvtp_srvca
	 */
	public void setSd_srvtp_srvca(String Sd_srvtp_srvca) {
		setAttrVal("Sd_srvtp_srvca", Sd_srvtp_srvca);
	}
	/**
	 * 服务分类编码
	 * @return String
	 */
	public String getCode_srvca() {
		return ((String) getAttrVal("Code_srvca"));
	}	
	/**
	 * 服务分类编码
	 * @param Code_srvca
	 */
	public void setCode_srvca(String Code_srvca) {
		setAttrVal("Code_srvca", Code_srvca);
	}
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}	
	/**
	 * 服务分类名称
	 * @param Name_srvca
	 */
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
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
		return "Id_pedeptsetsrvca";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_deptsetsrvca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDeptSetSrvCaDODesc.class);
	}
	
}