package iih.pis.ivx.pisivxsfda.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxsfda.d.desc.PisIvxSfdaDODesc;
import java.math.BigDecimal;

/**
 * 微信服务-整体满意度调查 DO数据 
 * 
 */
public class PisIvxSfdaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信服务满意度调查主键标识
	public static final String ID_PISIVXSFDA= "Id_pisivxsfda";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医生的医疗技术
	public static final String Q1= "Q1";
	//医生接诊诊疗解释
	public static final String Q2= "Q2";
	//护士服务态度
	public static final String Q3= "Q3";
	//护士技术操作
	public static final String Q4= "Q4";
	//窗口工作人员服务态度
	public static final String Q5= "Q5";
	//预约挂号方式
	public static final String Q6= "Q6";
	//就医环境
	public static final String Q7= "Q7";
	//医院引导标识
	public static final String Q8= "Q8";
	//隐私保护
	public static final String Q9= "Q9";
	//本次就诊整体评价
	public static final String Q10= "Q10";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//患者编码
	public static final String PATCODE= "Patcode";
	//填写日期
	public static final String DT_ANSWER= "Dt_answer";
	//微信账户ID
	public static final String ID_PISIVXACCOUNT= "Id_pisivxaccount";
	//当前就诊人ID
	public static final String ID_PISIVXMEMBER= "Id_pisivxmember";
	//当前就诊记录ID
	public static final String ID_PISIVXENT= "Id_pisivxent";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信服务满意度调查主键标识
	 * @return String
	 */
	public String getId_pisivxsfda() {
		return ((String) getAttrVal("Id_pisivxsfda"));
	}	
	/**
	 * 微信服务满意度调查主键标识
	 * @param Id_pisivxsfda
	 */
	public void setId_pisivxsfda(String Id_pisivxsfda) {
		setAttrVal("Id_pisivxsfda", Id_pisivxsfda);
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
	 * 医生的医疗技术
	 * @return Integer
	 */
	public Integer getQ1() {
		return ((Integer) getAttrVal("Q1"));
	}	
	/**
	 * 医生的医疗技术
	 * @param Q1
	 */
	public void setQ1(Integer Q1) {
		setAttrVal("Q1", Q1);
	}
	/**
	 * 医生接诊诊疗解释
	 * @return Integer
	 */
	public Integer getQ2() {
		return ((Integer) getAttrVal("Q2"));
	}	
	/**
	 * 医生接诊诊疗解释
	 * @param Q2
	 */
	public void setQ2(Integer Q2) {
		setAttrVal("Q2", Q2);
	}
	/**
	 * 护士服务态度
	 * @return Integer
	 */
	public Integer getQ3() {
		return ((Integer) getAttrVal("Q3"));
	}	
	/**
	 * 护士服务态度
	 * @param Q3
	 */
	public void setQ3(Integer Q3) {
		setAttrVal("Q3", Q3);
	}
	/**
	 * 护士技术操作
	 * @return Integer
	 */
	public Integer getQ4() {
		return ((Integer) getAttrVal("Q4"));
	}	
	/**
	 * 护士技术操作
	 * @param Q4
	 */
	public void setQ4(Integer Q4) {
		setAttrVal("Q4", Q4);
	}
	/**
	 * 窗口工作人员服务态度
	 * @return Integer
	 */
	public Integer getQ5() {
		return ((Integer) getAttrVal("Q5"));
	}	
	/**
	 * 窗口工作人员服务态度
	 * @param Q5
	 */
	public void setQ5(Integer Q5) {
		setAttrVal("Q5", Q5);
	}
	/**
	 * 预约挂号方式
	 * @return Integer
	 */
	public Integer getQ6() {
		return ((Integer) getAttrVal("Q6"));
	}	
	/**
	 * 预约挂号方式
	 * @param Q6
	 */
	public void setQ6(Integer Q6) {
		setAttrVal("Q6", Q6);
	}
	/**
	 * 就医环境
	 * @return Integer
	 */
	public Integer getQ7() {
		return ((Integer) getAttrVal("Q7"));
	}	
	/**
	 * 就医环境
	 * @param Q7
	 */
	public void setQ7(Integer Q7) {
		setAttrVal("Q7", Q7);
	}
	/**
	 * 医院引导标识
	 * @return Integer
	 */
	public Integer getQ8() {
		return ((Integer) getAttrVal("Q8"));
	}	
	/**
	 * 医院引导标识
	 * @param Q8
	 */
	public void setQ8(Integer Q8) {
		setAttrVal("Q8", Q8);
	}
	/**
	 * 隐私保护
	 * @return Integer
	 */
	public Integer getQ9() {
		return ((Integer) getAttrVal("Q9"));
	}	
	/**
	 * 隐私保护
	 * @param Q9
	 */
	public void setQ9(Integer Q9) {
		setAttrVal("Q9", Q9);
	}
	/**
	 * 本次就诊整体评价
	 * @return Integer
	 */
	public Integer getQ10() {
		return ((Integer) getAttrVal("Q10"));
	}	
	/**
	 * 本次就诊整体评价
	 * @param Q10
	 */
	public void setQ10(Integer Q10) {
		setAttrVal("Q10", Q10);
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
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}	
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 填写日期
	 * @return FDate
	 */
	public FDate getDt_answer() {
		return ((FDate) getAttrVal("Dt_answer"));
	}	
	/**
	 * 填写日期
	 * @param Dt_answer
	 */
	public void setDt_answer(FDate Dt_answer) {
		setAttrVal("Dt_answer", Dt_answer);
	}
	/**
	 * 微信账户ID
	 * @return String
	 */
	public String getId_pisivxaccount() {
		return ((String) getAttrVal("Id_pisivxaccount"));
	}	
	/**
	 * 微信账户ID
	 * @param Id_pisivxaccount
	 */
	public void setId_pisivxaccount(String Id_pisivxaccount) {
		setAttrVal("Id_pisivxaccount", Id_pisivxaccount);
	}
	/**
	 * 当前就诊人ID
	 * @return String
	 */
	public String getId_pisivxmember() {
		return ((String) getAttrVal("Id_pisivxmember"));
	}	
	/**
	 * 当前就诊人ID
	 * @param Id_pisivxmember
	 */
	public void setId_pisivxmember(String Id_pisivxmember) {
		setAttrVal("Id_pisivxmember", Id_pisivxmember);
	}
	/**
	 * 当前就诊记录ID
	 * @return String
	 */
	public String getId_pisivxent() {
		return ((String) getAttrVal("Id_pisivxent"));
	}	
	/**
	 * 当前就诊记录ID
	 * @param Id_pisivxent
	 */
	public void setId_pisivxent(String Id_pisivxent) {
		setAttrVal("Id_pisivxent", Id_pisivxent);
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
		return "Id_pisivxsfda";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_sfda";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxSfdaDODesc.class);
	}
	
}