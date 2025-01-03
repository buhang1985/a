package iih.bd.srv.mrctmca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrctmca.d.desc.MrCtmCaDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录类型自定义分类 DO数据 
 * 
 */
public class MrCtmCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗记录类型自定义分类主键标识
	public static final String ID_MRCACTM= "Id_mrcactm";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//父级主键
	public static final String ID_PARENT= "Id_parent";
	//内部编码
	public static final String INNERCODE= "Innercode";
	//描述
	public static final String DES= "Des";
	//序号
	public static final String SORTNO= "Sortno";
	//启用状态
	public static final String ACTIVESTATE= "Activestate";
	//是否打印
	public static final String FG_CONTINUE_PRINT= "Fg_continue_print";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//医护标识
	public static final String DOCORNUR= "Docornur";
	//质控项目一级分类
	public static final String ID_FST= "Id_fst";
	//只能存在一份文书标识
	public static final String FG_ONLY= "Fg_only";
	//适配科室
	public static final String ID_DEPT= "Id_dept";
	//是否连续打印
	public static final String FG_CP= "Fg_cp";
	//是否类型组
	public static final String FG_TYPES= "Fg_types";
	//数据集分类
	public static final String ID_SETCA= "Id_setca";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//扫描范围
	public static final String SCANRANGE= "Scanrange";
	//扫描病历标志
	public static final String FG_SCANMR= "Fg_scanmr";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//编码
	public static final String PARENT_CODE= "Parent_code";
	//名称
	public static final String PARENT_NAME= "Parent_name";
	//就诊类型编码
	public static final String ENTP_CODE= "Entp_code";
	//就诊类型名称
	public static final String ENTP_NAME= "Entp_name";
	//编码
	public static final String FST_CODE= "Fst_code";
	//名称
	public static final String FST_NAME= "Fst_name";
	//名称
	public static final String DEPT_NAME= "Dept_name";
	//编码
	public static final String DEPT_CODE= "Dept_code";
	//数据集分类名称
	public static final String SETCA_NAME= "Setca_name";
	//编码
	public static final String SETCA_CODE= "Setca_code";
	//用户编码
	public static final String CREATEDBY_CODE= "Createdby_code";
	//用户名称
	public static final String CREATEDBY_NAME= "Createdby_name";
	//用户编码
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	//用户名称
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗记录类型自定义分类主键标识
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	/**
	 * 医疗记录类型自定义分类主键标识
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
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
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
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
	 * 父级主键
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	/**
	 * 父级主键
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 内部编码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	/**
	 * 内部编码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
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
	 * 启用状态
	 * @return Integer
	 */
	public Integer getActivestate() {
		return ((Integer) getAttrVal("Activestate"));
	}	
	/**
	 * 启用状态
	 * @param Activestate
	 */
	public void setActivestate(Integer Activestate) {
		setAttrVal("Activestate", Activestate);
	}
	/**
	 * 是否打印
	 * @return String
	 */
	public String getFg_continue_print() {
		return ((String) getAttrVal("Fg_continue_print"));
	}	
	/**
	 * 是否打印
	 * @param Fg_continue_print
	 */
	public void setFg_continue_print(String Fg_continue_print) {
		setAttrVal("Fg_continue_print", Fg_continue_print);
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
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 医护标识
	 * @return Integer
	 */
	public Integer getDocornur() {
		return ((Integer) getAttrVal("Docornur"));
	}	
	/**
	 * 医护标识
	 * @param Docornur
	 */
	public void setDocornur(Integer Docornur) {
		setAttrVal("Docornur", Docornur);
	}
	/**
	 * 质控项目一级分类
	 * @return String
	 */
	public String getId_fst() {
		return ((String) getAttrVal("Id_fst"));
	}	
	/**
	 * 质控项目一级分类
	 * @param Id_fst
	 */
	public void setId_fst(String Id_fst) {
		setAttrVal("Id_fst", Id_fst);
	}
	/**
	 * 只能存在一份文书标识
	 * @return FBoolean
	 */
	public FBoolean getFg_only() {
		return ((FBoolean) getAttrVal("Fg_only"));
	}	
	/**
	 * 只能存在一份文书标识
	 * @param Fg_only
	 */
	public void setFg_only(FBoolean Fg_only) {
		setAttrVal("Fg_only", Fg_only);
	}
	/**
	 * 适配科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 适配科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 是否连续打印
	 * @return FBoolean
	 */
	public FBoolean getFg_cp() {
		return ((FBoolean) getAttrVal("Fg_cp"));
	}	
	/**
	 * 是否连续打印
	 * @param Fg_cp
	 */
	public void setFg_cp(FBoolean Fg_cp) {
		setAttrVal("Fg_cp", Fg_cp);
	}
	/**
	 * 是否类型组
	 * @return FBoolean
	 */
	public FBoolean getFg_types() {
		return ((FBoolean) getAttrVal("Fg_types"));
	}	
	/**
	 * 是否类型组
	 * @param Fg_types
	 */
	public void setFg_types(FBoolean Fg_types) {
		setAttrVal("Fg_types", Fg_types);
	}
	/**
	 * 数据集分类
	 * @return String
	 */
	public String getId_setca() {
		return ((String) getAttrVal("Id_setca"));
	}	
	/**
	 * 数据集分类
	 * @param Id_setca
	 */
	public void setId_setca(String Id_setca) {
		setAttrVal("Id_setca", Id_setca);
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
	 * 扫描范围
	 * @return Integer
	 */
	public Integer getScanrange() {
		return ((Integer) getAttrVal("Scanrange"));
	}	
	/**
	 * 扫描范围
	 * @param Scanrange
	 */
	public void setScanrange(Integer Scanrange) {
		setAttrVal("Scanrange", Scanrange);
	}
	/**
	 * 扫描病历标志
	 * @return FBoolean
	 */
	public FBoolean getFg_scanmr() {
		return ((FBoolean) getAttrVal("Fg_scanmr"));
	}	
	/**
	 * 扫描病历标志
	 * @param Fg_scanmr
	 */
	public void setFg_scanmr(FBoolean Fg_scanmr) {
		setAttrVal("Fg_scanmr", Fg_scanmr);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getParent_code() {
		return ((String) getAttrVal("Parent_code"));
	}	
	/**
	 * 编码
	 * @param Parent_code
	 */
	public void setParent_code(String Parent_code) {
		setAttrVal("Parent_code", Parent_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getParent_name() {
		return ((String) getAttrVal("Parent_name"));
	}	
	/**
	 * 名称
	 * @param Parent_name
	 */
	public void setParent_name(String Parent_name) {
		setAttrVal("Parent_name", Parent_name);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}	
	/**
	 * 就诊类型编码
	 * @param Entp_code
	 */
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	/**
	 * 就诊类型名称
	 * @param Entp_name
	 */
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getFst_code() {
		return ((String) getAttrVal("Fst_code"));
	}	
	/**
	 * 编码
	 * @param Fst_code
	 */
	public void setFst_code(String Fst_code) {
		setAttrVal("Fst_code", Fst_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getFst_name() {
		return ((String) getAttrVal("Fst_name"));
	}	
	/**
	 * 名称
	 * @param Fst_name
	 */
	public void setFst_name(String Fst_name) {
		setAttrVal("Fst_name", Fst_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	/**
	 * 名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	/**
	 * 编码
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 数据集分类名称
	 * @return String
	 */
	public String getSetca_name() {
		return ((String) getAttrVal("Setca_name"));
	}	
	/**
	 * 数据集分类名称
	 * @param Setca_name
	 */
	public void setSetca_name(String Setca_name) {
		setAttrVal("Setca_name", Setca_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSetca_code() {
		return ((String) getAttrVal("Setca_code"));
	}	
	/**
	 * 编码
	 * @param Setca_code
	 */
	public void setSetca_code(String Setca_code) {
		setAttrVal("Setca_code", Setca_code);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCreatedby_code() {
		return ((String) getAttrVal("Createdby_code"));
	}	
	/**
	 * 用户编码
	 * @param Createdby_code
	 */
	public void setCreatedby_code(String Createdby_code) {
		setAttrVal("Createdby_code", Createdby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getCreatedby_name() {
		return ((String) getAttrVal("Createdby_name"));
	}	
	/**
	 * 用户名称
	 * @param Createdby_name
	 */
	public void setCreatedby_name(String Createdby_name) {
		setAttrVal("Createdby_name", Createdby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModifiedby_code() {
		return ((String) getAttrVal("Modifiedby_code"));
	}	
	/**
	 * 用户编码
	 * @param Modifiedby_code
	 */
	public void setModifiedby_code(String Modifiedby_code) {
		setAttrVal("Modifiedby_code", Modifiedby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}	
	/**
	 * 用户名称
	 * @param Modifiedby_name
	 */
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
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
		return "Id_mrcactm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrca_ctm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrCtmCaDODesc.class);
	}
	
}