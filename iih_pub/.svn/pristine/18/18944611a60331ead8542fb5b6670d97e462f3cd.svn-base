package iih.bd.pp.bdbltpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.bdbltpl.d.desc.BdBltplItmDODesc;
import java.math.BigDecimal;

/**
 * 自定义费用模板明细 DO数据 
 * 
 */
public class BdBltplItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//自定义模板明细主键
	public static final String ID_BLTPLITM= "Id_bltplitm";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//自定义费用模板
	public static final String ID_BLTPL= "Id_bltpl";
	//序号
	public static final String SORTNO= "Sortno";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//医疗物品
	public static final String ID_MM= "Id_mm";
	//数值_医学单位
	public static final String QUAN_MEDU= "Quan_medu";
	//医学单位
	public static final String ID_UNIT= "Id_unit";
	//价格
	public static final String PRI= "Pri";
	//金额
	public static final String AMT= "Amt";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//服务编码
	public static final String SRVCODE= "Srvcode";
	//服务名称
	public static final String SRVNAME= "Srvname";
	//医疗物品标识
	public static final String FG_MM= "Fg_mm";
	//医疗物品名称
	public static final String NAME_MM= "Name_mm";
	//医疗物品规格
	public static final String SPEC_MM= "Spec_mm";
	//计量单位名称
	public static final String UNITNAME= "Unitname";
	//计量单位编码
	public static final String UNITCODE= "Unitcode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 自定义模板明细主键
	 * @return String
	 */
	public String getId_bltplitm() {
		return ((String) getAttrVal("Id_bltplitm"));
	}	
	/**
	 * 自定义模板明细主键
	 * @param Id_bltplitm
	 */
	public void setId_bltplitm(String Id_bltplitm) {
		setAttrVal("Id_bltplitm", Id_bltplitm);
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
	 * 自定义费用模板
	 * @return String
	 */
	public String getId_bltpl() {
		return ((String) getAttrVal("Id_bltpl"));
	}	
	/**
	 * 自定义费用模板
	 * @param Id_bltpl
	 */
	public void setId_bltpl(String Id_bltpl) {
		setAttrVal("Id_bltpl", Id_bltpl);
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
	 * 医疗物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 医疗物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
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
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	/**
	 * 价格
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	 * 医疗物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	/**
	 * 医疗物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 医疗物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 医疗物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 医疗物品规格
	 * @return String
	 */
	public String getSpec_mm() {
		return ((String) getAttrVal("Spec_mm"));
	}	
	/**
	 * 医疗物品规格
	 * @param Spec_mm
	 */
	public void setSpec_mm(String Spec_mm) {
		setAttrVal("Spec_mm", Spec_mm);
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
		return "Id_bltplitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_bltpl_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdBltplItmDODesc.class);
	}
	
}