package iih.bd.pp.samppri.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.samppri.d.desc.BdSampPriItmDODesc;
import java.math.BigDecimal;

/**
 * 标本费用明细 DO数据 
 * 
 */
public class BdSampPriItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//标本费用明细ID
	public static final String ID_SAMP_PRI_ITM= "Id_samp_pri_itm";
	//标本费用ID
	public static final String ID_SAMP_PRI= "Id_samp_pri";
	//费用类型
	public static final String EU_PRITP= "Eu_pritp";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//数值_医学单位
	public static final String QUAN_MEDU= "Quan_medu";
	//医学单位
	public static final String ID_UNIT= "Id_unit";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//参考价格
	public static final String PRI_STD= "Pri_std";
	//服务编码
	public static final String SRVCODE= "Srvcode";
	//服务名称
	public static final String SRVNAME= "Srvname";
	//计量单位编码
	public static final String UNITCODE= "Unitcode";
	//计量单位名称
	public static final String UNITNAME= "Unitname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 标本费用明细ID
	 * @return String
	 */
	public String getId_samp_pri_itm() {
		return ((String) getAttrVal("Id_samp_pri_itm"));
	}	
	/**
	 * 标本费用明细ID
	 * @param Id_samp_pri_itm
	 */
	public void setId_samp_pri_itm(String Id_samp_pri_itm) {
		setAttrVal("Id_samp_pri_itm", Id_samp_pri_itm);
	}
	/**
	 * 标本费用ID
	 * @return String
	 */
	public String getId_samp_pri() {
		return ((String) getAttrVal("Id_samp_pri"));
	}	
	/**
	 * 标本费用ID
	 * @param Id_samp_pri
	 */
	public void setId_samp_pri(String Id_samp_pri) {
		setAttrVal("Id_samp_pri", Id_samp_pri);
	}
	/**
	 * 费用类型
	 * @return Integer
	 */
	public Integer getEu_pritp() {
		return ((Integer) getAttrVal("Eu_pritp"));
	}	
	/**
	 * 费用类型
	 * @param Eu_pritp
	 */
	public void setEu_pritp(Integer Eu_pritp) {
		setAttrVal("Eu_pritp", Eu_pritp);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 数值_医学单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 数值_医学单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 医学单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}	
	/**
	 * 参考价格
	 * @param Pri_std
	 */
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrvcode() {
		return ((String) getAttrVal("Srvcode"));
	}	
	/**
	 * 服务编码
	 * @param Srvcode
	 */
	public void setSrvcode(String Srvcode) {
		setAttrVal("Srvcode", Srvcode);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}	
	/**
	 * 服务名称
	 * @param Srvname
	 */
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
	}
	/**
	 * 计量单位编码
	 * @return String
	 */
	public String getUnitcode() {
		return ((String) getAttrVal("Unitcode"));
	}	
	/**
	 * 计量单位编码
	 * @param Unitcode
	 */
	public void setUnitcode(String Unitcode) {
		setAttrVal("Unitcode", Unitcode);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getUnitname() {
		return ((String) getAttrVal("Unitname"));
	}	
	/**
	 * 计量单位名称
	 * @param Unitname
	 */
	public void setUnitname(String Unitname) {
		setAttrVal("Unitname", Unitname);
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
		return "Id_samp_pri_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_samp_pri_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdSampPriItmDODesc.class);
	}
	
}