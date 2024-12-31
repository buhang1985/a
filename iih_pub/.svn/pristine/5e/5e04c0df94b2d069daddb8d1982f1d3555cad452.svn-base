package iih.pe.phm.pehmriskdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmriskdef.d.desc.PeHmRiskSurveyDODesc;
import java.math.BigDecimal;

/**
 * 健康危险因素-问卷关系定义 DO数据 
 * 
 */
public class PeHmRiskSurveyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康危险因素-问卷关系定义主键标识
	public static final String ID_PEHMRISKSURVEY= "Id_pehmrisksurvey";
	//问卷分组ID
	public static final String ID_PEQACATLOG= "Id_peqacatlog";
	//问卷问题库ID
	public static final String ID_PEQACONTENTDEF= "Id_peqacontentdef";
	//问题选项库ID
	public static final String ID_PEQAKEYDEF= "Id_peqakeydef";
	//健康危险因素目录ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//问卷分组编码
	public static final String CODE_TOPIC= "Code_topic";
	//问卷分组名称
	public static final String NAME_TOPIC= "Name_topic";
	//体检问卷问题编码
	public static final String CODE_SUBJECT= "Code_subject";
	//体检问卷问题
	public static final String NAME_SUBJECT= "Name_subject";
	//编码
	public static final String CODE_KEY= "Code_key";
	//名称
	public static final String NAME_KEY= "Name_key";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康危险因素-问卷关系定义主键标识
	 * @return String
	 */
	public String getId_pehmrisksurvey() {
		return ((String) getAttrVal("Id_pehmrisksurvey"));
	}	
	/**
	 * 健康危险因素-问卷关系定义主键标识
	 * @param Id_pehmrisksurvey
	 */
	public void setId_pehmrisksurvey(String Id_pehmrisksurvey) {
		setAttrVal("Id_pehmrisksurvey", Id_pehmrisksurvey);
	}
	/**
	 * 问卷分组ID
	 * @return String
	 */
	public String getId_peqacatlog() {
		return ((String) getAttrVal("Id_peqacatlog"));
	}	
	/**
	 * 问卷分组ID
	 * @param Id_peqacatlog
	 */
	public void setId_peqacatlog(String Id_peqacatlog) {
		setAttrVal("Id_peqacatlog", Id_peqacatlog);
	}
	/**
	 * 问卷问题库ID
	 * @return String
	 */
	public String getId_peqacontentdef() {
		return ((String) getAttrVal("Id_peqacontentdef"));
	}	
	/**
	 * 问卷问题库ID
	 * @param Id_peqacontentdef
	 */
	public void setId_peqacontentdef(String Id_peqacontentdef) {
		setAttrVal("Id_peqacontentdef", Id_peqacontentdef);
	}
	/**
	 * 问题选项库ID
	 * @return String
	 */
	public String getId_peqakeydef() {
		return ((String) getAttrVal("Id_peqakeydef"));
	}	
	/**
	 * 问题选项库ID
	 * @param Id_peqakeydef
	 */
	public void setId_peqakeydef(String Id_peqakeydef) {
		setAttrVal("Id_peqakeydef", Id_peqakeydef);
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
	 * 问卷分组编码
	 * @return String
	 */
	public String getCode_topic() {
		return ((String) getAttrVal("Code_topic"));
	}	
	/**
	 * 问卷分组编码
	 * @param Code_topic
	 */
	public void setCode_topic(String Code_topic) {
		setAttrVal("Code_topic", Code_topic);
	}
	/**
	 * 问卷分组名称
	 * @return String
	 */
	public String getName_topic() {
		return ((String) getAttrVal("Name_topic"));
	}	
	/**
	 * 问卷分组名称
	 * @param Name_topic
	 */
	public void setName_topic(String Name_topic) {
		setAttrVal("Name_topic", Name_topic);
	}
	/**
	 * 体检问卷问题编码
	 * @return String
	 */
	public String getCode_subject() {
		return ((String) getAttrVal("Code_subject"));
	}	
	/**
	 * 体检问卷问题编码
	 * @param Code_subject
	 */
	public void setCode_subject(String Code_subject) {
		setAttrVal("Code_subject", Code_subject);
	}
	/**
	 * 体检问卷问题
	 * @return String
	 */
	public String getName_subject() {
		return ((String) getAttrVal("Name_subject"));
	}	
	/**
	 * 体检问卷问题
	 * @param Name_subject
	 */
	public void setName_subject(String Name_subject) {
		setAttrVal("Name_subject", Name_subject);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_key() {
		return ((String) getAttrVal("Code_key"));
	}	
	/**
	 * 编码
	 * @param Code_key
	 */
	public void setCode_key(String Code_key) {
		setAttrVal("Code_key", Code_key);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_key() {
		return ((String) getAttrVal("Name_key"));
	}	
	/**
	 * 名称
	 * @param Name_key
	 */
	public void setName_key(String Name_key) {
		setAttrVal("Name_key", Name_key);
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
		return "Id_pehmrisksurvey";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pehmrisksurvey";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmRiskSurveyDODesc.class);
	}
	
}