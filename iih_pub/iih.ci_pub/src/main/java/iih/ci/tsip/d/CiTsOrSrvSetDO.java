package iih.ci.tsip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.tsip.d.desc.CiTsOrSrvSetDODesc;
import java.math.BigDecimal;

/**
 * 治疗方案医嘱项目服务套 DO数据 
 * 
 */
public class CiTsOrSrvSetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//治疗方案医嘱服务套ID
	public static final String ID_TSORSRVSET= "Id_tsorsrvset";
	//医嘱服务项目ID
	public static final String ID_TSORSRV= "Id_tsorsrv";
	//治疗方案医嘱ID
	public static final String ID_TSOR= "Id_tsor";
	//服务套项目定义主键
	public static final String ID_SRVSETDEF= "Id_srvsetdef";
	//套内服务项目主键
	public static final String ID_SRVSET= "Id_srvset";
	//套内服务项目名称
	public static final String NAME_SRVSET= "Name_srvset";
	//序号
	public static final String SORTNO= "Sortno";
	//数值_医疗单位
	public static final String QUAN_MEDU= "Quan_medu";
	//医疗单位
	public static final String ID_MEDU= "Id_medu";
	//部位ID
	public static final String ID_BODY= "Id_body";
	//部位SD
	public static final String SD_BODY= "Sd_body";
	//部位
	public static final String NAME_BODY= "Name_body";
	//方位ID
	public static final String ID_POS= "Id_pos";
	//方位SD
	public static final String SD_POS= "Sd_pos";
	//方位
	public static final String NAME_POS= "Name_pos";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//计量单位名称
	public static final String MEDU_NAME= "Medu_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 治疗方案医嘱服务套ID
	 * @return String
	 */
	public String getId_tsorsrvset() {
		return ((String) getAttrVal("Id_tsorsrvset"));
	}	
	/**
	 * 治疗方案医嘱服务套ID
	 * @param Id_tsorsrvset
	 */
	public void setId_tsorsrvset(String Id_tsorsrvset) {
		setAttrVal("Id_tsorsrvset", Id_tsorsrvset);
	}
	/**
	 * 医嘱服务项目ID
	 * @return String
	 */
	public String getId_tsorsrv() {
		return ((String) getAttrVal("Id_tsorsrv"));
	}	
	/**
	 * 医嘱服务项目ID
	 * @param Id_tsorsrv
	 */
	public void setId_tsorsrv(String Id_tsorsrv) {
		setAttrVal("Id_tsorsrv", Id_tsorsrv);
	}
	/**
	 * 治疗方案医嘱ID
	 * @return String
	 */
	public String getId_tsor() {
		return ((String) getAttrVal("Id_tsor"));
	}	
	/**
	 * 治疗方案医嘱ID
	 * @param Id_tsor
	 */
	public void setId_tsor(String Id_tsor) {
		setAttrVal("Id_tsor", Id_tsor);
	}
	/**
	 * 服务套项目定义主键
	 * @return String
	 */
	public String getId_srvsetdef() {
		return ((String) getAttrVal("Id_srvsetdef"));
	}	
	/**
	 * 服务套项目定义主键
	 * @param Id_srvsetdef
	 */
	public void setId_srvsetdef(String Id_srvsetdef) {
		setAttrVal("Id_srvsetdef", Id_srvsetdef);
	}
	/**
	 * 套内服务项目主键
	 * @return String
	 */
	public String getId_srvset() {
		return ((String) getAttrVal("Id_srvset"));
	}	
	/**
	 * 套内服务项目主键
	 * @param Id_srvset
	 */
	public void setId_srvset(String Id_srvset) {
		setAttrVal("Id_srvset", Id_srvset);
	}
	/**
	 * 套内服务项目名称
	 * @return String
	 */
	public String getName_srvset() {
		return ((String) getAttrVal("Name_srvset"));
	}	
	/**
	 * 套内服务项目名称
	 * @param Name_srvset
	 */
	public void setName_srvset(String Name_srvset) {
		setAttrVal("Name_srvset", Name_srvset);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 数值_医疗单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 数值_医疗单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医疗单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}	
	/**
	 * 医疗单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 部位ID
	 * @return String
	 */
	public String getId_body() {
		return ((String) getAttrVal("Id_body"));
	}	
	/**
	 * 部位ID
	 * @param Id_body
	 */
	public void setId_body(String Id_body) {
		setAttrVal("Id_body", Id_body);
	}
	/**
	 * 部位SD
	 * @return String
	 */
	public String getSd_body() {
		return ((String) getAttrVal("Sd_body"));
	}	
	/**
	 * 部位SD
	 * @param Sd_body
	 */
	public void setSd_body(String Sd_body) {
		setAttrVal("Sd_body", Sd_body);
	}
	/**
	 * 部位
	 * @return String
	 */
	public String getName_body() {
		return ((String) getAttrVal("Name_body"));
	}	
	/**
	 * 部位
	 * @param Name_body
	 */
	public void setName_body(String Name_body) {
		setAttrVal("Name_body", Name_body);
	}
	/**
	 * 方位ID
	 * @return String
	 */
	public String getId_pos() {
		return ((String) getAttrVal("Id_pos"));
	}	
	/**
	 * 方位ID
	 * @param Id_pos
	 */
	public void setId_pos(String Id_pos) {
		setAttrVal("Id_pos", Id_pos);
	}
	/**
	 * 方位SD
	 * @return String
	 */
	public String getSd_pos() {
		return ((String) getAttrVal("Sd_pos"));
	}	
	/**
	 * 方位SD
	 * @param Sd_pos
	 */
	public void setSd_pos(String Sd_pos) {
		setAttrVal("Sd_pos", Sd_pos);
	}
	/**
	 * 方位
	 * @return String
	 */
	public String getName_pos() {
		return ((String) getAttrVal("Name_pos"));
	}	
	/**
	 * 方位
	 * @param Name_pos
	 */
	public void setName_pos(String Name_pos) {
		setAttrVal("Name_pos", Name_pos);
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
	 * 计量单位名称
	 * @return String
	 */
	public String getMedu_name() {
		return ((String) getAttrVal("Medu_name"));
	}	
	/**
	 * 计量单位名称
	 * @param Medu_name
	 */
	public void setMedu_name(String Medu_name) {
		setAttrVal("Medu_name", Medu_name);
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
		return "Id_tsorsrvset";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ts_or_srv_set";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiTsOrSrvSetDODesc.class);
	}
	
}