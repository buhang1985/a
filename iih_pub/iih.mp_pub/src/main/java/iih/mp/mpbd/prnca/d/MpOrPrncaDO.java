package iih.mp.mpbd.prnca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.prnca.d.desc.MpOrPrncaDODesc;
import java.math.BigDecimal;

/**
 * 病区执行打印单据分类 DO数据 
 * 
 */
public class MpOrPrncaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_OR_PRNCA= "Id_or_prnca";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//单据分类类型ID
	public static final String ID_PRNCA_TYPE= "Id_prnca_type";
	//单据分类类型SD
	public static final String SD_PRNCA_TYPE= "Sd_prnca_type";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//序号
	public static final String SORTNO= "Sortno";
	//表单ID
	public static final String ID_BILLFORM= "Id_billform";
	//页签编码
	public static final String TAB_CODE= "Tab_code";
	//所属类型ID
	public static final String ID_OWNTP= "Id_owntp";
	//所属类型编码
	public static final String SD_OWNTP= "Sd_owntp";
	//科室ID
	public static final String ID_DEP= "Id_dep";
	//时间查询类型
	public static final String EU_DATETP= "Eu_datetp";
	//服务全路径
	public static final String QUALIFILD_NAME= "Qualifild_name";
	//方法名
	public static final String METHOD_NAME= "Method_name";
	//允许多选
	public static final String FG_MULTI= "Fg_multi";
	//执行单据类型ID
	public static final String ID_PRNTP= "Id_prntp";
	//执行单据类型编码
	public static final String SD_PRNTP= "Sd_prntp";
	//条件区高度
	public static final String HEIGHT= "Height";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//扩展字段1
	public static final String CTRL1= "Ctrl1";
	//扩展字段2
	public static final String CTRL2= "Ctrl2";
	//扩展字段3
	public static final String CTRL3= "Ctrl3";
	//扩展字段4
	public static final String CTRL4= "Ctrl4";
	//扩展字段5
	public static final String CTRL5= "Ctrl5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人  
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//报表格式类型
	public static final String RPT_FORMATTP= "Rpt_formattp";
	//报表显示格式
	public static final String DIS_FORMAT= "Dis_format";
	//单据分类类型
	public static final String NAME_PRNCA_TYPE= "Name_prnca_type";
	//标题
	public static final String BILLFORMCAPTION= "Billformcaption";
	//所属类型名称
	public static final String NAME_OWNTP= "Name_owntp";
	//科室名称
	public static final String NAME_DEP= "Name_dep";
	//单据类型名称
	public static final String NAME_PRNTP= "Name_prntp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_or_prnca() {
		return ((String) getAttrVal("Id_or_prnca"));
	}	
	/**
	 * 主键
	 * @param Id_or_prnca
	 */
	public void setId_or_prnca(String Id_or_prnca) {
		setAttrVal("Id_or_prnca", Id_or_prnca);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 单据分类类型ID
	 * @return String
	 */
	public String getId_prnca_type() {
		return ((String) getAttrVal("Id_prnca_type"));
	}	
	/**
	 * 单据分类类型ID
	 * @param Id_prnca_type
	 */
	public void setId_prnca_type(String Id_prnca_type) {
		setAttrVal("Id_prnca_type", Id_prnca_type);
	}
	/**
	 * 单据分类类型SD
	 * @return String
	 */
	public String getSd_prnca_type() {
		return ((String) getAttrVal("Sd_prnca_type"));
	}	
	/**
	 * 单据分类类型SD
	 * @param Sd_prnca_type
	 */
	public void setSd_prnca_type(String Sd_prnca_type) {
		setAttrVal("Sd_prnca_type", Sd_prnca_type);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 表单ID
	 * @return String
	 */
	public String getId_billform() {
		return ((String) getAttrVal("Id_billform"));
	}	
	/**
	 * 表单ID
	 * @param Id_billform
	 */
	public void setId_billform(String Id_billform) {
		setAttrVal("Id_billform", Id_billform);
	}
	/**
	 * 页签编码
	 * @return String
	 */
	public String getTab_code() {
		return ((String) getAttrVal("Tab_code"));
	}	
	/**
	 * 页签编码
	 * @param Tab_code
	 */
	public void setTab_code(String Tab_code) {
		setAttrVal("Tab_code", Tab_code);
	}
	/**
	 * 所属类型ID
	 * @return String
	 */
	public String getId_owntp() {
		return ((String) getAttrVal("Id_owntp"));
	}	
	/**
	 * 所属类型ID
	 * @param Id_owntp
	 */
	public void setId_owntp(String Id_owntp) {
		setAttrVal("Id_owntp", Id_owntp);
	}
	/**
	 * 所属类型编码
	 * @return String
	 */
	public String getSd_owntp() {
		return ((String) getAttrVal("Sd_owntp"));
	}	
	/**
	 * 所属类型编码
	 * @param Sd_owntp
	 */
	public void setSd_owntp(String Sd_owntp) {
		setAttrVal("Sd_owntp", Sd_owntp);
	}
	/**
	 * 科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 时间查询类型
	 * @return Integer
	 */
	public Integer getEu_datetp() {
		return ((Integer) getAttrVal("Eu_datetp"));
	}	
	/**
	 * 时间查询类型
	 * @param Eu_datetp
	 */
	public void setEu_datetp(Integer Eu_datetp) {
		setAttrVal("Eu_datetp", Eu_datetp);
	}
	/**
	 * 服务全路径
	 * @return String
	 */
	public String getQualifild_name() {
		return ((String) getAttrVal("Qualifild_name"));
	}	
	/**
	 * 服务全路径
	 * @param Qualifild_name
	 */
	public void setQualifild_name(String Qualifild_name) {
		setAttrVal("Qualifild_name", Qualifild_name);
	}
	/**
	 * 方法名
	 * @return String
	 */
	public String getMethod_name() {
		return ((String) getAttrVal("Method_name"));
	}	
	/**
	 * 方法名
	 * @param Method_name
	 */
	public void setMethod_name(String Method_name) {
		setAttrVal("Method_name", Method_name);
	}
	/**
	 * 允许多选
	 * @return FBoolean
	 */
	public FBoolean getFg_multi() {
		return ((FBoolean) getAttrVal("Fg_multi"));
	}	
	/**
	 * 允许多选
	 * @param Fg_multi
	 */
	public void setFg_multi(FBoolean Fg_multi) {
		setAttrVal("Fg_multi", Fg_multi);
	}
	/**
	 * 执行单据类型ID
	 * @return String
	 */
	public String getId_prntp() {
		return ((String) getAttrVal("Id_prntp"));
	}	
	/**
	 * 执行单据类型ID
	 * @param Id_prntp
	 */
	public void setId_prntp(String Id_prntp) {
		setAttrVal("Id_prntp", Id_prntp);
	}
	/**
	 * 执行单据类型编码
	 * @return String
	 */
	public String getSd_prntp() {
		return ((String) getAttrVal("Sd_prntp"));
	}	
	/**
	 * 执行单据类型编码
	 * @param Sd_prntp
	 */
	public void setSd_prntp(String Sd_prntp) {
		setAttrVal("Sd_prntp", Sd_prntp);
	}
	/**
	 * 条件区高度
	 * @return Integer
	 */
	public Integer getHeight() {
		return ((Integer) getAttrVal("Height"));
	}	
	/**
	 * 条件区高度
	 * @param Height
	 */
	public void setHeight(Integer Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1
	 */
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ctrl2
	 */
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ctrl3
	 */
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getCtrl4() {
		return ((String) getAttrVal("Ctrl4"));
	}	
	/**
	 * 扩展字段4
	 * @param Ctrl4
	 */
	public void setCtrl4(String Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}	
	/**
	 * 扩展字段5
	 * @param Ctrl5
	 */
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
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
	 * 报表格式类型
	 * @return Integer
	 */
	public Integer getRpt_formattp() {
		return ((Integer) getAttrVal("Rpt_formattp"));
	}	
	/**
	 * 报表格式类型
	 * @param Rpt_formattp
	 */
	public void setRpt_formattp(Integer Rpt_formattp) {
		setAttrVal("Rpt_formattp", Rpt_formattp);
	}
	/**
	 * 报表显示格式
	 * @return String
	 */
	public String getDis_format() {
		return ((String) getAttrVal("Dis_format"));
	}	
	/**
	 * 报表显示格式
	 * @param Dis_format
	 */
	public void setDis_format(String Dis_format) {
		setAttrVal("Dis_format", Dis_format);
	}
	/**
	 * 单据分类类型
	 * @return String
	 */
	public String getName_prnca_type() {
		return ((String) getAttrVal("Name_prnca_type"));
	}	
	/**
	 * 单据分类类型
	 * @param Name_prnca_type
	 */
	public void setName_prnca_type(String Name_prnca_type) {
		setAttrVal("Name_prnca_type", Name_prnca_type);
	}
	/**
	 * 标题
	 * @return String
	 */
	public String getBillformcaption() {
		return ((String) getAttrVal("Billformcaption"));
	}	
	/**
	 * 标题
	 * @param Billformcaption
	 */
	public void setBillformcaption(String Billformcaption) {
		setAttrVal("Billformcaption", Billformcaption);
	}
	/**
	 * 所属类型名称
	 * @return String
	 */
	public String getName_owntp() {
		return ((String) getAttrVal("Name_owntp"));
	}	
	/**
	 * 所属类型名称
	 * @param Name_owntp
	 */
	public void setName_owntp(String Name_owntp) {
		setAttrVal("Name_owntp", Name_owntp);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 单据类型名称
	 * @return String
	 */
	public String getName_prntp() {
		return ((String) getAttrVal("Name_prntp"));
	}	
	/**
	 * 单据类型名称
	 * @param Name_prntp
	 */
	public void setName_prntp(String Name_prntp) {
		setAttrVal("Name_prntp", Name_prntp);
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
		return "Id_or_prnca";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_or_prnca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpOrPrncaDODesc.class);
	}
	
}