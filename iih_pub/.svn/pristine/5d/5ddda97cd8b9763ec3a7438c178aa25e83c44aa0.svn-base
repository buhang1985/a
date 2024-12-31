package iih.nm.nqm.nqmchk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmchk.d.desc.NmNqmChkItmDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_护理质量检查明细 DO数据 
 * 
 */
public class NmNqmChkItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检查指标主键
	public static final String ID_NQM_CHK_ITM= "Id_nqm_chk_itm";
	//质量检查外键
	public static final String ID_NQM_CHK= "Id_nqm_chk";
	//质量标准外键
	public static final String ID_NQM_CS= "Id_nqm_cs";
	//标准模板外键
	public static final String ID_NQM_CSMTPL= "Id_nqm_csmtpl";
	//检查指标外键
	public static final String ID_NQM_KPI= "Id_nqm_kpi";
	//父级检查指标
	public static final String ID_KPI_PAR= "Id_kpi_par";
	//评分结果
	public static final String ID_NQM_KPI_ITM= "Id_nqm_kpi_itm";
	//不检标识
	public static final String FG_NO= "Fg_no";
	//指标分值
	public static final String SCORE_KPI= "Score_kpi";
	//得分
	public static final String SCORE= "Score";
	//扣分原因
	public static final String REA_POINTS= "Rea_points";
	//存在问题
	public static final String EXIST_ISSUE= "Exist_issue";
	//图片路径
	public static final String URL= "Url";
	//备注
	public static final String DES= "Des";
	//扩展字段1
	public static final String CTR1= "Ctr1";
	//扩展字段2
	public static final String CTR2= "Ctr2";
	//扩展字段3
	public static final String CTR3= "Ctr3";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_NQM_CS= "Code_nqm_cs";
	//名称
	public static final String NAME_NQM_CS= "Name_nqm_cs";
	//模板名称
	public static final String NAME_NQM_CSMTPL= "Name_nqm_csmtpl";
	//指标编码
	public static final String CODE_NQM_KPI= "Code_nqm_kpi";
	//指标名称
	public static final String NAME_NQM_KPI= "Name_nqm_kpi";
	//上级指标
	public static final String ID_PAR_NQM_KPI= "Id_par_nqm_kpi";
	//指标编码
	public static final String CODE_KPI_PAR= "Code_kpi_par";
	//指标名称
	public static final String NAME_KPI_PAR= "Name_kpi_par";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 检查指标主键
	 * @return String
	 */
	public String getId_nqm_chk_itm() {
		return ((String) getAttrVal("Id_nqm_chk_itm"));
	}	
	/**
	 * 检查指标主键
	 * @param Id_nqm_chk_itm
	 */
	public void setId_nqm_chk_itm(String Id_nqm_chk_itm) {
		setAttrVal("Id_nqm_chk_itm", Id_nqm_chk_itm);
	}
	/**
	 * 质量检查外键
	 * @return String
	 */
	public String getId_nqm_chk() {
		return ((String) getAttrVal("Id_nqm_chk"));
	}	
	/**
	 * 质量检查外键
	 * @param Id_nqm_chk
	 */
	public void setId_nqm_chk(String Id_nqm_chk) {
		setAttrVal("Id_nqm_chk", Id_nqm_chk);
	}
	/**
	 * 质量标准外键
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	/**
	 * 质量标准外键
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	/**
	 * 标准模板外键
	 * @return String
	 */
	public String getId_nqm_csmtpl() {
		return ((String) getAttrVal("Id_nqm_csmtpl"));
	}	
	/**
	 * 标准模板外键
	 * @param Id_nqm_csmtpl
	 */
	public void setId_nqm_csmtpl(String Id_nqm_csmtpl) {
		setAttrVal("Id_nqm_csmtpl", Id_nqm_csmtpl);
	}
	/**
	 * 检查指标外键
	 * @return String
	 */
	public String getId_nqm_kpi() {
		return ((String) getAttrVal("Id_nqm_kpi"));
	}	
	/**
	 * 检查指标外键
	 * @param Id_nqm_kpi
	 */
	public void setId_nqm_kpi(String Id_nqm_kpi) {
		setAttrVal("Id_nqm_kpi", Id_nqm_kpi);
	}
	/**
	 * 父级检查指标
	 * @return String
	 */
	public String getId_kpi_par() {
		return ((String) getAttrVal("Id_kpi_par"));
	}	
	/**
	 * 父级检查指标
	 * @param Id_kpi_par
	 */
	public void setId_kpi_par(String Id_kpi_par) {
		setAttrVal("Id_kpi_par", Id_kpi_par);
	}
	/**
	 * 评分结果
	 * @return String
	 */
	public String getId_nqm_kpi_itm() {
		return ((String) getAttrVal("Id_nqm_kpi_itm"));
	}	
	/**
	 * 评分结果
	 * @param Id_nqm_kpi_itm
	 */
	public void setId_nqm_kpi_itm(String Id_nqm_kpi_itm) {
		setAttrVal("Id_nqm_kpi_itm", Id_nqm_kpi_itm);
	}
	/**
	 * 不检标识
	 * @return FBoolean
	 */
	public FBoolean getFg_no() {
		return ((FBoolean) getAttrVal("Fg_no"));
	}	
	/**
	 * 不检标识
	 * @param Fg_no
	 */
	public void setFg_no(FBoolean Fg_no) {
		setAttrVal("Fg_no", Fg_no);
	}
	/**
	 * 指标分值
	 * @return FDouble
	 */
	public FDouble getScore_kpi() {
		return ((FDouble) getAttrVal("Score_kpi"));
	}	
	/**
	 * 指标分值
	 * @param Score_kpi
	 */
	public void setScore_kpi(FDouble Score_kpi) {
		setAttrVal("Score_kpi", Score_kpi);
	}
	/**
	 * 得分
	 * @return FDouble
	 */
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	/**
	 * 得分
	 * @param Score
	 */
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 扣分原因
	 * @return String
	 */
	public String getRea_points() {
		return ((String) getAttrVal("Rea_points"));
	}	
	/**
	 * 扣分原因
	 * @param Rea_points
	 */
	public void setRea_points(String Rea_points) {
		setAttrVal("Rea_points", Rea_points);
	}
	/**
	 * 存在问题
	 * @return String
	 */
	public String getExist_issue() {
		return ((String) getAttrVal("Exist_issue"));
	}	
	/**
	 * 存在问题
	 * @param Exist_issue
	 */
	public void setExist_issue(String Exist_issue) {
		setAttrVal("Exist_issue", Exist_issue);
	}
	/**
	 * 图片路径
	 * @return String
	 */
	public String getUrl() {
		return ((String) getAttrVal("Url"));
	}	
	/**
	 * 图片路径
	 * @param Url
	 */
	public void setUrl(String Url) {
		setAttrVal("Url", Url);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtr1() {
		return ((String) getAttrVal("Ctr1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctr1
	 */
	public void setCtr1(String Ctr1) {
		setAttrVal("Ctr1", Ctr1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getCtr2() {
		return ((String) getAttrVal("Ctr2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ctr2
	 */
	public void setCtr2(String Ctr2) {
		setAttrVal("Ctr2", Ctr2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getCtr3() {
		return ((String) getAttrVal("Ctr3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ctr3
	 */
	public void setCtr3(String Ctr3) {
		setAttrVal("Ctr3", Ctr3);
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
	 * 编码
	 * @return String
	 */
	public String getCode_nqm_cs() {
		return ((String) getAttrVal("Code_nqm_cs"));
	}	
	/**
	 * 编码
	 * @param Code_nqm_cs
	 */
	public void setCode_nqm_cs(String Code_nqm_cs) {
		setAttrVal("Code_nqm_cs", Code_nqm_cs);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nqm_cs() {
		return ((String) getAttrVal("Name_nqm_cs"));
	}	
	/**
	 * 名称
	 * @param Name_nqm_cs
	 */
	public void setName_nqm_cs(String Name_nqm_cs) {
		setAttrVal("Name_nqm_cs", Name_nqm_cs);
	}
	/**
	 * 模板名称
	 * @return String
	 */
	public String getName_nqm_csmtpl() {
		return ((String) getAttrVal("Name_nqm_csmtpl"));
	}	
	/**
	 * 模板名称
	 * @param Name_nqm_csmtpl
	 */
	public void setName_nqm_csmtpl(String Name_nqm_csmtpl) {
		setAttrVal("Name_nqm_csmtpl", Name_nqm_csmtpl);
	}
	/**
	 * 指标编码
	 * @return String
	 */
	public String getCode_nqm_kpi() {
		return ((String) getAttrVal("Code_nqm_kpi"));
	}	
	/**
	 * 指标编码
	 * @param Code_nqm_kpi
	 */
	public void setCode_nqm_kpi(String Code_nqm_kpi) {
		setAttrVal("Code_nqm_kpi", Code_nqm_kpi);
	}
	/**
	 * 指标名称
	 * @return String
	 */
	public String getName_nqm_kpi() {
		return ((String) getAttrVal("Name_nqm_kpi"));
	}	
	/**
	 * 指标名称
	 * @param Name_nqm_kpi
	 */
	public void setName_nqm_kpi(String Name_nqm_kpi) {
		setAttrVal("Name_nqm_kpi", Name_nqm_kpi);
	}
	/**
	 * 上级指标
	 * @return String
	 */
	public String getId_par_nqm_kpi() {
		return ((String) getAttrVal("Id_par_nqm_kpi"));
	}	
	/**
	 * 上级指标
	 * @param Id_par_nqm_kpi
	 */
	public void setId_par_nqm_kpi(String Id_par_nqm_kpi) {
		setAttrVal("Id_par_nqm_kpi", Id_par_nqm_kpi);
	}
	/**
	 * 指标编码
	 * @return String
	 */
	public String getCode_kpi_par() {
		return ((String) getAttrVal("Code_kpi_par"));
	}	
	/**
	 * 指标编码
	 * @param Code_kpi_par
	 */
	public void setCode_kpi_par(String Code_kpi_par) {
		setAttrVal("Code_kpi_par", Code_kpi_par);
	}
	/**
	 * 指标名称
	 * @return String
	 */
	public String getName_kpi_par() {
		return ((String) getAttrVal("Name_kpi_par"));
	}	
	/**
	 * 指标名称
	 * @param Name_kpi_par
	 */
	public void setName_kpi_par(String Name_kpi_par) {
		setAttrVal("Name_kpi_par", Name_kpi_par);
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
		return "Id_nqm_chk_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_CHK_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmChkItmDODesc.class);
	}
	
}