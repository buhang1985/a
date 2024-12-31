package iih.bd.pp.priboildes.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.priboildes.d.desc.BdPriBoilDesDODesc;
import java.math.BigDecimal;

/**
 * 煎法要求费用对照 DO数据 
 * 
 */
public class BdPriBoilDesDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱煎法要求价格主键
	public static final String ID_PRIBOILDES= "Id_priboildes";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//煎法要求
	public static final String ID_BOILDES= "Id_boildes";
	//序号
	public static final String SORTNO= "Sortno";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//数值_医学单位
	public static final String QUAN_MEDU= "Quan_medu";
	//医学单位
	public static final String ID_UNIT= "Id_unit";
	//按重量收费标志
	public static final String FG_WEIGHT= "Fg_weight";
	//重量（每收费单元）
	public static final String QUAN_PER= "Quan_per";
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
	//煎法要求编码
	public static final String BOILDES_CODE= "Boildes_code";
	//煎法要求名称
	public static final String BOILDES_NAME= "Boildes_name";
	//服务项目名称
	public static final String SRV_NAME= "Srv_name";
	//服务项目编码
	public static final String SRV_CODE= "Srv_code";
	//医学单位编码
	public static final String UNIT_CODE= "Unit_code";
	//医学单位名称
	public static final String UNIT_NAME= "Unit_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱煎法要求价格主键
	 * @return String
	 */
	public String getId_priboildes() {
		return ((String) getAttrVal("Id_priboildes"));
	}	
	/**
	 * 医嘱煎法要求价格主键
	 * @param Id_priboildes
	 */
	public void setId_priboildes(String Id_priboildes) {
		setAttrVal("Id_priboildes", Id_priboildes);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
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
	 * 按重量收费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_weight() {
		return ((FBoolean) getAttrVal("Fg_weight"));
	}	
	/**
	 * 按重量收费标志
	 * @param Fg_weight
	 */
	public void setFg_weight(FBoolean Fg_weight) {
		setAttrVal("Fg_weight", Fg_weight);
	}
	/**
	 * 重量（每收费单元）
	 * @return FDouble
	 */
	public FDouble getQuan_per() {
		return ((FDouble) getAttrVal("Quan_per"));
	}	
	/**
	 * 重量（每收费单元）
	 * @param Quan_per
	 */
	public void setQuan_per(FDouble Quan_per) {
		setAttrVal("Quan_per", Quan_per);
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
	 * 煎法要求编码
	 * @return String
	 */
	public String getBoildes_code() {
		return ((String) getAttrVal("Boildes_code"));
	}	
	/**
	 * 煎法要求编码
	 * @param Boildes_code
	 */
	public void setBoildes_code(String Boildes_code) {
		setAttrVal("Boildes_code", Boildes_code);
	}
	/**
	 * 煎法要求名称
	 * @return String
	 */
	public String getBoildes_name() {
		return ((String) getAttrVal("Boildes_name"));
	}	
	/**
	 * 煎法要求名称
	 * @param Boildes_name
	 */
	public void setBoildes_name(String Boildes_name) {
		setAttrVal("Boildes_name", Boildes_name);
	}
	/**
	 * 服务项目名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务项目名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 服务项目编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 服务项目编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 医学单位编码
	 * @return String
	 */
	public String getUnit_code() {
		return ((String) getAttrVal("Unit_code"));
	}	
	/**
	 * 医学单位编码
	 * @param Unit_code
	 */
	public void setUnit_code(String Unit_code) {
		setAttrVal("Unit_code", Unit_code);
	}
	/**
	 * 医学单位名称
	 * @return String
	 */
	public String getUnit_name() {
		return ((String) getAttrVal("Unit_name"));
	}	
	/**
	 * 医学单位名称
	 * @param Unit_name
	 */
	public void setUnit_name(String Unit_name) {
		setAttrVal("Unit_name", Unit_name);
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
		return "Id_priboildes";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_PRI_BOIL_DES";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdPriBoilDesDODesc.class);
	}
	
}