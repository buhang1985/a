package iih.pe.pqn.pehramodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.pehramodel.d.desc.PeHraModelRiskDODesc;
import java.math.BigDecimal;

/**
 * 体检疾病风险评估模型危险因素 DO数据 
 * 
 */
public class PeHraModelRiskDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检疾病风险评估模型危险因素主键标识
	public static final String ID_PEHRAMODELRISK= "Id_pehramodelrisk";
	//体检疾病风险评估模型危险因素父ID
	public static final String ID_PEHRAMODELRISK_PAR= "Id_pehramodelrisk_par";
	//体检疾病风险评估模型ID
	public static final String ID_PEHRAMODEL= "Id_pehramodel";
	//健康危险因素目录ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//组号
	public static final String GROUPNO= "Groupno";
	//序号
	public static final String SORTNO= "Sortno";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//计算等式
	public static final String OPT= "Opt";
	//结果值
	public static final String VAL= "Val";
	//低值
	public static final String VAL_LOW= "Val_low";
	//高值
	public static final String VAL_HIGH= "Val_high";
	//个体相对风险度
	public static final String RRI= "Rri";
	//专家风险度共识
	public static final String RRC= "Rrc";
	//危险因素人群暴露率
	public static final String P= "P";
	//编码
	public static final String CODE_RISK= "Code_risk";
	//名称
	public static final String NAME_RISK= "Name_risk";
	//数据类型
	public static final String DATATP_RISK= "Datatp_risk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检疾病风险评估模型危险因素主键标识
	 * @return String
	 */
	public String getId_pehramodelrisk() {
		return ((String) getAttrVal("Id_pehramodelrisk"));
	}	
	/**
	 * 体检疾病风险评估模型危险因素主键标识
	 * @param Id_pehramodelrisk
	 */
	public void setId_pehramodelrisk(String Id_pehramodelrisk) {
		setAttrVal("Id_pehramodelrisk", Id_pehramodelrisk);
	}
	/**
	 * 体检疾病风险评估模型危险因素父ID
	 * @return String
	 */
	public String getId_pehramodelrisk_par() {
		return ((String) getAttrVal("Id_pehramodelrisk_par"));
	}	
	/**
	 * 体检疾病风险评估模型危险因素父ID
	 * @param Id_pehramodelrisk_par
	 */
	public void setId_pehramodelrisk_par(String Id_pehramodelrisk_par) {
		setAttrVal("Id_pehramodelrisk_par", Id_pehramodelrisk_par);
	}
	/**
	 * 体检疾病风险评估模型ID
	 * @return String
	 */
	public String getId_pehramodel() {
		return ((String) getAttrVal("Id_pehramodel"));
	}	
	/**
	 * 体检疾病风险评估模型ID
	 * @param Id_pehramodel
	 */
	public void setId_pehramodel(String Id_pehramodel) {
		setAttrVal("Id_pehramodel", Id_pehramodel);
	}
	/**
	 * 健康危险因素目录ID
	 * @return String
	 */
	public String getId_riskdef() {
		return ((String) getAttrVal("Id_riskdef"));
	}	
	/**
	 * 健康危险因素目录ID
	 * @param Id_riskdef
	 */
	public void setId_riskdef(String Id_riskdef) {
		setAttrVal("Id_riskdef", Id_riskdef);
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
	 * 组号
	 * @return Integer
	 */
	public Integer getGroupno() {
		return ((Integer) getAttrVal("Groupno"));
	}	
	/**
	 * 组号
	 * @param Groupno
	 */
	public void setGroupno(Integer Groupno) {
		setAttrVal("Groupno", Groupno);
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
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 计算等式
	 * @return Integer
	 */
	public Integer getOpt() {
		return ((Integer) getAttrVal("Opt"));
	}	
	/**
	 * 计算等式
	 * @param Opt
	 */
	public void setOpt(Integer Opt) {
		setAttrVal("Opt", Opt);
	}
	/**
	 * 结果值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	/**
	 * 结果值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 低值
	 * @return FDouble
	 */
	public FDouble getVal_low() {
		return ((FDouble) getAttrVal("Val_low"));
	}	
	/**
	 * 低值
	 * @param Val_low
	 */
	public void setVal_low(FDouble Val_low) {
		setAttrVal("Val_low", Val_low);
	}
	/**
	 * 高值
	 * @return FDouble
	 */
	public FDouble getVal_high() {
		return ((FDouble) getAttrVal("Val_high"));
	}	
	/**
	 * 高值
	 * @param Val_high
	 */
	public void setVal_high(FDouble Val_high) {
		setAttrVal("Val_high", Val_high);
	}
	/**
	 * 个体相对风险度
	 * @return FDouble
	 */
	public FDouble getRri() {
		return ((FDouble) getAttrVal("Rri"));
	}	
	/**
	 * 个体相对风险度
	 * @param Rri
	 */
	public void setRri(FDouble Rri) {
		setAttrVal("Rri", Rri);
	}
	/**
	 * 专家风险度共识
	 * @return FDouble
	 */
	public FDouble getRrc() {
		return ((FDouble) getAttrVal("Rrc"));
	}	
	/**
	 * 专家风险度共识
	 * @param Rrc
	 */
	public void setRrc(FDouble Rrc) {
		setAttrVal("Rrc", Rrc);
	}
	/**
	 * 危险因素人群暴露率
	 * @return FDouble
	 */
	public FDouble getP() {
		return ((FDouble) getAttrVal("P"));
	}	
	/**
	 * 危险因素人群暴露率
	 * @param P
	 */
	public void setP(FDouble P) {
		setAttrVal("P", P);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_risk() {
		return ((String) getAttrVal("Code_risk"));
	}	
	/**
	 * 编码
	 * @param Code_risk
	 */
	public void setCode_risk(String Code_risk) {
		setAttrVal("Code_risk", Code_risk);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_risk() {
		return ((String) getAttrVal("Name_risk"));
	}	
	/**
	 * 名称
	 * @param Name_risk
	 */
	public void setName_risk(String Name_risk) {
		setAttrVal("Name_risk", Name_risk);
	}
	/**
	 * 数据类型
	 * @return Integer
	 */
	public Integer getDatatp_risk() {
		return ((Integer) getAttrVal("Datatp_risk"));
	}	
	/**
	 * 数据类型
	 * @param Datatp_risk
	 */
	public void setDatatp_risk(Integer Datatp_risk) {
		setAttrVal("Datatp_risk", Datatp_risk);
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
		return "Id_pehramodelrisk";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pehramodelrisk";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHraModelRiskDODesc.class);
	}
	
}