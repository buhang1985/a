package iih.bl.inc.blecinctrans.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blecinctrans.d.desc.BlEcIncTransDODesc;
import java.math.BigDecimal;

/**
 * 电子票据交易记录 DO数据 
 * 
 */
public class BlEcIncTransDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//电子发票交易记录
	public static final String ID_ECINCTRAS= "Id_ecinctras";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//发票所属类型
	public static final String EU_INCTYPE= "Eu_inctype";
	//交易类型
	public static final String EU_TRANSTYPE= "Eu_transtype";
	//交易状态
	public static final String EU_TRANSSTATUS= "Eu_transstatus";
	//业务流水号
	public static final String BIZNO= "Bizno";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//所属结算id
	public static final String ID_ST= "Id_st";
	//所属发票id
	public static final String ID_INC= "Id_inc";
	//操作员
	public static final String ID_EMP_OPER= "Id_emp_oper";
	//操作员所在科室
	public static final String ID_DEP_OPER= "Id_dep_oper";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//计算机
	public static final String ID_PC= "Id_pc";
	//备注
	public static final String NOTE= "Note";
	//异常处理操作人员
	public static final String ID_EMP_EXPOPER= "Id_emp_expoper";
	//入参
	public static final String INPUTINFO= "Inputinfo";
	//出参
	public static final String OUTPUTINFO= "Outputinfo";
	//有效标识
	public static final String FG_ACTIVE= "Fg_active";
	//电子发票二维码图片
	public static final String EC_QRCODE_PIC= "Ec_qrcode_pic";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 电子发票交易记录
	 * @return String
	 */
	public String getId_ecinctras() {
		return ((String) getAttrVal("Id_ecinctras"));
	}	
	/**
	 * 电子发票交易记录
	 * @param Id_ecinctras
	 */
	public void setId_ecinctras(String Id_ecinctras) {
		setAttrVal("Id_ecinctras", Id_ecinctras);
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
	 * 发票所属类型
	 * @return String
	 */
	public String getEu_inctype() {
		return ((String) getAttrVal("Eu_inctype"));
	}	
	/**
	 * 发票所属类型
	 * @param Eu_inctype
	 */
	public void setEu_inctype(String Eu_inctype) {
		setAttrVal("Eu_inctype", Eu_inctype);
	}
	/**
	 * 交易类型
	 * @return String
	 */
	public String getEu_transtype() {
		return ((String) getAttrVal("Eu_transtype"));
	}	
	/**
	 * 交易类型
	 * @param Eu_transtype
	 */
	public void setEu_transtype(String Eu_transtype) {
		setAttrVal("Eu_transtype", Eu_transtype);
	}
	/**
	 * 交易状态
	 * @return String
	 */
	public String getEu_transstatus() {
		return ((String) getAttrVal("Eu_transstatus"));
	}	
	/**
	 * 交易状态
	 * @param Eu_transstatus
	 */
	public void setEu_transstatus(String Eu_transstatus) {
		setAttrVal("Eu_transstatus", Eu_transstatus);
	}
	/**
	 * 业务流水号
	 * @return String
	 */
	public String getBizno() {
		return ((String) getAttrVal("Bizno"));
	}	
	/**
	 * 业务流水号
	 * @param Bizno
	 */
	public void setBizno(String Bizno) {
		setAttrVal("Bizno", Bizno);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 所属结算id
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}	
	/**
	 * 所属结算id
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	/**
	 * 所属发票id
	 * @return String
	 */
	public String getId_inc() {
		return ((String) getAttrVal("Id_inc"));
	}	
	/**
	 * 所属发票id
	 * @param Id_inc
	 */
	public void setId_inc(String Id_inc) {
		setAttrVal("Id_inc", Id_inc);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	/**
	 * 操作员
	 * @param Id_emp_oper
	 */
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	/**
	 * 操作员所在科室
	 * @return String
	 */
	public String getId_dep_oper() {
		return ((String) getAttrVal("Id_dep_oper"));
	}	
	/**
	 * 操作员所在科室
	 * @param Id_dep_oper
	 */
	public void setId_dep_oper(String Id_dep_oper) {
		setAttrVal("Id_dep_oper", Id_dep_oper);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 计算机
	 * @return String
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}	
	/**
	 * 计算机
	 * @param Id_pc
	 */
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 异常处理操作人员
	 * @return String
	 */
	public String getId_emp_expoper() {
		return ((String) getAttrVal("Id_emp_expoper"));
	}	
	/**
	 * 异常处理操作人员
	 * @param Id_emp_expoper
	 */
	public void setId_emp_expoper(String Id_emp_expoper) {
		setAttrVal("Id_emp_expoper", Id_emp_expoper);
	}
	/**
	 * 入参
	 * @return String
	 */
	public String getInputinfo() {
		return ((String) getAttrVal("Inputinfo"));
	}	
	/**
	 * 入参
	 * @param Inputinfo
	 */
	public void setInputinfo(String Inputinfo) {
		setAttrVal("Inputinfo", Inputinfo);
	}
	/**
	 * 出参
	 * @return String
	 */
	public String getOutputinfo() {
		return ((String) getAttrVal("Outputinfo"));
	}	
	/**
	 * 出参
	 * @param Outputinfo
	 */
	public void setOutputinfo(String Outputinfo) {
		setAttrVal("Outputinfo", Outputinfo);
	}
	/**
	 * 有效标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 有效标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 电子发票二维码图片
	 * @return byte[]
	 */
	public byte[] getEc_qrcode_pic() {
		return ((byte[]) getAttrVal("Ec_qrcode_pic"));
	}	
	/**
	 * 电子发票二维码图片
	 * @param Ec_qrcode_pic
	 */
	public void setEc_qrcode_pic(byte[] Ec_qrcode_pic) {
		setAttrVal("Ec_qrcode_pic", Ec_qrcode_pic);
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
		return "Id_ecinctras";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_ec_inc_tras";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlEcIncTransDODesc.class);
	}
	
}