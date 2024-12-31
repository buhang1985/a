package iih.bd.srv.mrmtype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrmtype.d.desc.MrmTypeDODesc;
import java.math.BigDecimal;

/**
 * 病案分类 DO数据 
 * 
 */
public class MrmTypeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//病案分类主键
	public static final String ID_BD_MRM_TP= "Id_bd_mrm_tp";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//描述
	public static final String DES= "Des";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//排序
	public static final String SORTNO= "Sortno";
	//就诊类型主键
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//科室
	public static final String ID_DEP= "Id_dep";
	//是否自动生成电子文档
	public static final String FG_AUTO= "Fg_auto";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//病案归档来源id
	public static final String ID_ARCHIVE_SRC= "Id_archive_src";
	//病案归档来源code
	public static final String SD_ARCHIVE_SRC= "Sd_archive_src";
	//病案归档来源name
	public static final String NAME_ARCHIVE_SRC= "Name_archive_src";
	//来源编码
	public static final String ARCHIVE_CODE= "Archive_code";
	//来源名称
	public static final String ARCHIVE_NAME= "Archive_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 病案分类主键
	 * @return String
	 */
	public String getId_bd_mrm_tp() {
		return ((String) getAttrVal("Id_bd_mrm_tp"));
	}	
	/**
	 * 病案分类主键
	 * @param Id_bd_mrm_tp
	 */
	public void setId_bd_mrm_tp(String Id_bd_mrm_tp) {
		setAttrVal("Id_bd_mrm_tp", Id_bd_mrm_tp);
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
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 排序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 排序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 就诊类型主键
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型主键
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 是否自动生成电子文档
	 * @return FBoolean
	 */
	public FBoolean getFg_auto() {
		return ((FBoolean) getAttrVal("Fg_auto"));
	}	
	/**
	 * 是否自动生成电子文档
	 * @param Fg_auto
	 */
	public void setFg_auto(FBoolean Fg_auto) {
		setAttrVal("Fg_auto", Fg_auto);
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
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 病案归档来源id
	 * @return String
	 */
	public String getId_archive_src() {
		return ((String) getAttrVal("Id_archive_src"));
	}	
	/**
	 * 病案归档来源id
	 * @param Id_archive_src
	 */
	public void setId_archive_src(String Id_archive_src) {
		setAttrVal("Id_archive_src", Id_archive_src);
	}
	/**
	 * 病案归档来源code
	 * @return String
	 */
	public String getSd_archive_src() {
		return ((String) getAttrVal("Sd_archive_src"));
	}	
	/**
	 * 病案归档来源code
	 * @param Sd_archive_src
	 */
	public void setSd_archive_src(String Sd_archive_src) {
		setAttrVal("Sd_archive_src", Sd_archive_src);
	}
	/**
	 * 病案归档来源name
	 * @return String
	 */
	public String getName_archive_src() {
		return ((String) getAttrVal("Name_archive_src"));
	}	
	/**
	 * 病案归档来源name
	 * @param Name_archive_src
	 */
	public void setName_archive_src(String Name_archive_src) {
		setAttrVal("Name_archive_src", Name_archive_src);
	}
	/**
	 * 来源编码
	 * @return String
	 */
	public String getArchive_code() {
		return ((String) getAttrVal("Archive_code"));
	}	
	/**
	 * 来源编码
	 * @param Archive_code
	 */
	public void setArchive_code(String Archive_code) {
		setAttrVal("Archive_code", Archive_code);
	}
	/**
	 * 来源名称
	 * @return String
	 */
	public String getArchive_name() {
		return ((String) getAttrVal("Archive_name"));
	}	
	/**
	 * 来源名称
	 * @param Archive_name
	 */
	public void setArchive_name(String Archive_name) {
		setAttrVal("Archive_name", Archive_name);
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
		return "Id_bd_mrm_tp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrm_tp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrmTypeDODesc.class);
	}
	
}