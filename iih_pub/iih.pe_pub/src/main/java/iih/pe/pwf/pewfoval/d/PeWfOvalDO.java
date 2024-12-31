package iih.pe.pwf.pewfoval.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pewfoval.d.desc.PeWfOvalDODesc;
import java.math.BigDecimal;

/**
 * 体检总检主表 DO数据 
 * 
 */
public class PeWfOvalDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检总检主键标识
	public static final String ID_PEWFOVAL= "Id_pewfoval";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//总检标识
	public static final String FG_OVAL= "Fg_oval";
	//总检医生
	public static final String ID_DOC_OVAL= "Id_doc_oval";
	//总检时间
	public static final String DT_OVAL= "Dt_oval";
	//审核标识
	public static final String FG_ADUIT= "Fg_aduit";
	//审核医生
	public static final String ID_DOC_AUDIT= "Id_doc_audit";
	//审核时间
	public static final String DT_AUDIT= "Dt_audit";
	//报告领取方式
	public static final String RELEASE_WAY= "Release_way";
	//报告代领人
	public static final String RELEASE_BAILEE= "Release_bailee";
	//报告发放标识
	public static final String FG_RELEASE= "Fg_release";
	//报告发放人
	public static final String ID_RELEASE= "Id_release";
	//报告领取时间
	public static final String DT_RELEASE= "Dt_release";
	//报告核对人
	public static final String ID_CONFIRMER= "Id_confirmer";
	//报告核对标识
	public static final String FG_CONFIRM= "Fg_confirm";
	//报告打印标识
	public static final String FG_PRINT= "Fg_print";
	//报告打印时间
	public static final String DT_PRINT= "Dt_print";
	//报告核对时间
	public static final String DT_CONFIRM= "Dt_confirm";
	//纳入慢性病管理
	public static final String FG_CHRO= "Fg_chro";
	//总检报告封面语
	public static final String COVER_WORD= "Cover_word";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//追踪标识
	public static final String FG_FOLLOWUP= "Fg_followup";
	//追踪日期
	public static final String DT_FOLLOWUP= "Dt_followup";
	//随访标识
	public static final String FG_INTERVIEW= "Fg_interview";
	//随访日期
	public static final String DT_INTERVIEW= "Dt_interview";
	//心电图完成标识
	public static final String ENUM_ECG= "Enum_ecg";
	//检验完成标识
	public static final String ENUM_LIS= "Enum_lis";
	//X线完成标识
	public static final String ENUM_X= "Enum_x";
	//CT完成标识
	public static final String ENUM_CT= "Enum_ct";
	//用餐标识
	public static final String ST_DINING= "St_dining";
	//用餐时间
	public static final String DT_DINING= "Dt_dining";
	//合格标识
	public static final String FG_QUALIFIED= "Fg_qualified";
	//发证日期
	public static final String DT_CERTIFICATE= "Dt_certificate";
	//检查次数
	public static final String REGISTRY_TIMES= "Registry_times";
	//复查次数
	public static final String REEXAM_TIMES= "Reexam_times";
	//检查结果
	public static final String EXAM_RESULT= "Exam_result";
	//处理意见
	public static final String HANDLE_IDEA= "Handle_idea";
	//检查结论
	public static final String EXAM_DECISION= "Exam_decision";
	//检查备注
	public static final String EXAM_COMMENT= "Exam_comment";
	//建议离岗标识
	public static final String FG_SUGGESTLEAVE= "Fg_suggestleave";
	//诊断标识
	public static final String FG_DIAGNOSIS= "Fg_diagnosis";
	//追踪标识_职业病
	public static final String FG_FOLLUP= "Fg_follup";
	//通过标识
	public static final String FG_PASSED= "Fg_passed";
	//总检锁定标识
	public static final String FG_LOCKING= "Fg_locking";
	//总检锁定医生
	public static final String ID_LOCKING_DOC= "Id_locking_doc";
	//体检次数
	public static final String PE_TIMES= "Pe_times";
	//体检流程号
	public static final String CARD_PE= "Card_pe";
	//体检唯一码
	public static final String PE_CODE= "Pe_code";
	//姓名
	public static final String NAME_PSN= "Name_psn";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//移动电话
	public static final String MOB= "Mob";
	//用户名称
	public static final String NAME_OVAL= "Name_oval";
	//用户编码
	public static final String CODE_OVAL= "Code_oval";
	//用户名称
	public static final String NAME_ADUIT= "Name_aduit";
	//用户编码
	public static final String CODE_ADUIT= "Code_aduit";
	//用户名称
	public static final String NAME_RELEASE= "Name_release";
	//用户编码
	public static final String CODE_RELEASE= "Code_release";
	//用户编码
	public static final String CODE_CONFIRM= "Code_confirm";
	//用户名称
	public static final String NAME_LOCKING= "Name_locking";
	//用户编码
	public static final String CODE_LOCKING= "Code_locking";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检总检主键标识
	 * @return String
	 */
	public String getId_pewfoval() {
		return ((String) getAttrVal("Id_pewfoval"));
	}	
	/**
	 * 体检总检主键标识
	 * @param Id_pewfoval
	 */
	public void setId_pewfoval(String Id_pewfoval) {
		setAttrVal("Id_pewfoval", Id_pewfoval);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 总检标识
	 * @return FBoolean
	 */
	public FBoolean getFg_oval() {
		return ((FBoolean) getAttrVal("Fg_oval"));
	}	
	/**
	 * 总检标识
	 * @param Fg_oval
	 */
	public void setFg_oval(FBoolean Fg_oval) {
		setAttrVal("Fg_oval", Fg_oval);
	}
	/**
	 * 总检医生
	 * @return String
	 */
	public String getId_doc_oval() {
		return ((String) getAttrVal("Id_doc_oval"));
	}	
	/**
	 * 总检医生
	 * @param Id_doc_oval
	 */
	public void setId_doc_oval(String Id_doc_oval) {
		setAttrVal("Id_doc_oval", Id_doc_oval);
	}
	/**
	 * 总检时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oval() {
		return ((FDateTime) getAttrVal("Dt_oval"));
	}	
	/**
	 * 总检时间
	 * @param Dt_oval
	 */
	public void setDt_oval(FDateTime Dt_oval) {
		setAttrVal("Dt_oval", Dt_oval);
	}
	/**
	 * 审核标识
	 * @return FBoolean
	 */
	public FBoolean getFg_aduit() {
		return ((FBoolean) getAttrVal("Fg_aduit"));
	}	
	/**
	 * 审核标识
	 * @param Fg_aduit
	 */
	public void setFg_aduit(FBoolean Fg_aduit) {
		setAttrVal("Fg_aduit", Fg_aduit);
	}
	/**
	 * 审核医生
	 * @return String
	 */
	public String getId_doc_audit() {
		return ((String) getAttrVal("Id_doc_audit"));
	}	
	/**
	 * 审核医生
	 * @param Id_doc_audit
	 */
	public void setId_doc_audit(String Id_doc_audit) {
		setAttrVal("Id_doc_audit", Id_doc_audit);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}	
	/**
	 * 审核时间
	 * @param Dt_audit
	 */
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
	}
	/**
	 * 报告领取方式
	 * @return Integer
	 */
	public Integer getRelease_way() {
		return ((Integer) getAttrVal("Release_way"));
	}	
	/**
	 * 报告领取方式
	 * @param Release_way
	 */
	public void setRelease_way(Integer Release_way) {
		setAttrVal("Release_way", Release_way);
	}
	/**
	 * 报告代领人
	 * @return String
	 */
	public String getRelease_bailee() {
		return ((String) getAttrVal("Release_bailee"));
	}	
	/**
	 * 报告代领人
	 * @param Release_bailee
	 */
	public void setRelease_bailee(String Release_bailee) {
		setAttrVal("Release_bailee", Release_bailee);
	}
	/**
	 * 报告发放标识
	 * @return FBoolean
	 */
	public FBoolean getFg_release() {
		return ((FBoolean) getAttrVal("Fg_release"));
	}	
	/**
	 * 报告发放标识
	 * @param Fg_release
	 */
	public void setFg_release(FBoolean Fg_release) {
		setAttrVal("Fg_release", Fg_release);
	}
	/**
	 * 报告发放人
	 * @return String
	 */
	public String getId_release() {
		return ((String) getAttrVal("Id_release"));
	}	
	/**
	 * 报告发放人
	 * @param Id_release
	 */
	public void setId_release(String Id_release) {
		setAttrVal("Id_release", Id_release);
	}
	/**
	 * 报告领取时间
	 * @return FDateTime
	 */
	public FDateTime getDt_release() {
		return ((FDateTime) getAttrVal("Dt_release"));
	}	
	/**
	 * 报告领取时间
	 * @param Dt_release
	 */
	public void setDt_release(FDateTime Dt_release) {
		setAttrVal("Dt_release", Dt_release);
	}
	/**
	 * 报告核对人
	 * @return String
	 */
	public String getId_confirmer() {
		return ((String) getAttrVal("Id_confirmer"));
	}	
	/**
	 * 报告核对人
	 * @param Id_confirmer
	 */
	public void setId_confirmer(String Id_confirmer) {
		setAttrVal("Id_confirmer", Id_confirmer);
	}
	/**
	 * 报告核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_confirm() {
		return ((FBoolean) getAttrVal("Fg_confirm"));
	}	
	/**
	 * 报告核对标识
	 * @param Fg_confirm
	 */
	public void setFg_confirm(FBoolean Fg_confirm) {
		setAttrVal("Fg_confirm", Fg_confirm);
	}
	/**
	 * 报告打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}	
	/**
	 * 报告打印标识
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 报告打印时间
	 * @return FDateTime
	 */
	public FDateTime getDt_print() {
		return ((FDateTime) getAttrVal("Dt_print"));
	}	
	/**
	 * 报告打印时间
	 * @param Dt_print
	 */
	public void setDt_print(FDateTime Dt_print) {
		setAttrVal("Dt_print", Dt_print);
	}
	/**
	 * 报告核对时间
	 * @return FDateTime
	 */
	public FDateTime getDt_confirm() {
		return ((FDateTime) getAttrVal("Dt_confirm"));
	}	
	/**
	 * 报告核对时间
	 * @param Dt_confirm
	 */
	public void setDt_confirm(FDateTime Dt_confirm) {
		setAttrVal("Dt_confirm", Dt_confirm);
	}
	/**
	 * 纳入慢性病管理
	 * @return FBoolean
	 */
	public FBoolean getFg_chro() {
		return ((FBoolean) getAttrVal("Fg_chro"));
	}	
	/**
	 * 纳入慢性病管理
	 * @param Fg_chro
	 */
	public void setFg_chro(FBoolean Fg_chro) {
		setAttrVal("Fg_chro", Fg_chro);
	}
	/**
	 * 总检报告封面语
	 * @return String
	 */
	public String getCover_word() {
		return ((String) getAttrVal("Cover_word"));
	}	
	/**
	 * 总检报告封面语
	 * @param Cover_word
	 */
	public void setCover_word(String Cover_word) {
		setAttrVal("Cover_word", Cover_word);
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
	 * 追踪标识
	 * @return FBoolean
	 */
	public FBoolean getFg_followup() {
		return ((FBoolean) getAttrVal("Fg_followup"));
	}	
	/**
	 * 追踪标识
	 * @param Fg_followup
	 */
	public void setFg_followup(FBoolean Fg_followup) {
		setAttrVal("Fg_followup", Fg_followup);
	}
	/**
	 * 追踪日期
	 * @return FDateTime
	 */
	public FDateTime getDt_followup() {
		return ((FDateTime) getAttrVal("Dt_followup"));
	}	
	/**
	 * 追踪日期
	 * @param Dt_followup
	 */
	public void setDt_followup(FDateTime Dt_followup) {
		setAttrVal("Dt_followup", Dt_followup);
	}
	/**
	 * 随访标识
	 * @return FBoolean
	 */
	public FBoolean getFg_interview() {
		return ((FBoolean) getAttrVal("Fg_interview"));
	}	
	/**
	 * 随访标识
	 * @param Fg_interview
	 */
	public void setFg_interview(FBoolean Fg_interview) {
		setAttrVal("Fg_interview", Fg_interview);
	}
	/**
	 * 随访日期
	 * @return FDateTime
	 */
	public FDateTime getDt_interview() {
		return ((FDateTime) getAttrVal("Dt_interview"));
	}	
	/**
	 * 随访日期
	 * @param Dt_interview
	 */
	public void setDt_interview(FDateTime Dt_interview) {
		setAttrVal("Dt_interview", Dt_interview);
	}
	/**
	 * 心电图完成标识
	 * @return Integer
	 */
	public Integer getEnum_ecg() {
		return ((Integer) getAttrVal("Enum_ecg"));
	}	
	/**
	 * 心电图完成标识
	 * @param Enum_ecg
	 */
	public void setEnum_ecg(Integer Enum_ecg) {
		setAttrVal("Enum_ecg", Enum_ecg);
	}
	/**
	 * 检验完成标识
	 * @return Integer
	 */
	public Integer getEnum_lis() {
		return ((Integer) getAttrVal("Enum_lis"));
	}	
	/**
	 * 检验完成标识
	 * @param Enum_lis
	 */
	public void setEnum_lis(Integer Enum_lis) {
		setAttrVal("Enum_lis", Enum_lis);
	}
	/**
	 * X线完成标识
	 * @return Integer
	 */
	public Integer getEnum_x() {
		return ((Integer) getAttrVal("Enum_x"));
	}	
	/**
	 * X线完成标识
	 * @param Enum_x
	 */
	public void setEnum_x(Integer Enum_x) {
		setAttrVal("Enum_x", Enum_x);
	}
	/**
	 * CT完成标识
	 * @return Integer
	 */
	public Integer getEnum_ct() {
		return ((Integer) getAttrVal("Enum_ct"));
	}	
	/**
	 * CT完成标识
	 * @param Enum_ct
	 */
	public void setEnum_ct(Integer Enum_ct) {
		setAttrVal("Enum_ct", Enum_ct);
	}
	/**
	 * 用餐标识
	 * @return Integer
	 */
	public Integer getSt_dining() {
		return ((Integer) getAttrVal("St_dining"));
	}	
	/**
	 * 用餐标识
	 * @param St_dining
	 */
	public void setSt_dining(Integer St_dining) {
		setAttrVal("St_dining", St_dining);
	}
	/**
	 * 用餐时间
	 * @return FDateTime
	 */
	public FDateTime getDt_dining() {
		return ((FDateTime) getAttrVal("Dt_dining"));
	}	
	/**
	 * 用餐时间
	 * @param Dt_dining
	 */
	public void setDt_dining(FDateTime Dt_dining) {
		setAttrVal("Dt_dining", Dt_dining);
	}
	/**
	 * 合格标识
	 * @return FBoolean
	 */
	public FBoolean getFg_qualified() {
		return ((FBoolean) getAttrVal("Fg_qualified"));
	}	
	/**
	 * 合格标识
	 * @param Fg_qualified
	 */
	public void setFg_qualified(FBoolean Fg_qualified) {
		setAttrVal("Fg_qualified", Fg_qualified);
	}
	/**
	 * 发证日期
	 * @return FDate
	 */
	public FDate getDt_certificate() {
		return ((FDate) getAttrVal("Dt_certificate"));
	}	
	/**
	 * 发证日期
	 * @param Dt_certificate
	 */
	public void setDt_certificate(FDate Dt_certificate) {
		setAttrVal("Dt_certificate", Dt_certificate);
	}
	/**
	 * 检查次数
	 * @return Integer
	 */
	public Integer getRegistry_times() {
		return ((Integer) getAttrVal("Registry_times"));
	}	
	/**
	 * 检查次数
	 * @param Registry_times
	 */
	public void setRegistry_times(Integer Registry_times) {
		setAttrVal("Registry_times", Registry_times);
	}
	/**
	 * 复查次数
	 * @return Integer
	 */
	public Integer getReexam_times() {
		return ((Integer) getAttrVal("Reexam_times"));
	}	
	/**
	 * 复查次数
	 * @param Reexam_times
	 */
	public void setReexam_times(Integer Reexam_times) {
		setAttrVal("Reexam_times", Reexam_times);
	}
	/**
	 * 检查结果
	 * @return String
	 */
	public String getExam_result() {
		return ((String) getAttrVal("Exam_result"));
	}	
	/**
	 * 检查结果
	 * @param Exam_result
	 */
	public void setExam_result(String Exam_result) {
		setAttrVal("Exam_result", Exam_result);
	}
	/**
	 * 处理意见
	 * @return String
	 */
	public String getHandle_idea() {
		return ((String) getAttrVal("Handle_idea"));
	}	
	/**
	 * 处理意见
	 * @param Handle_idea
	 */
	public void setHandle_idea(String Handle_idea) {
		setAttrVal("Handle_idea", Handle_idea);
	}
	/**
	 * 检查结论
	 * @return String
	 */
	public String getExam_decision() {
		return ((String) getAttrVal("Exam_decision"));
	}	
	/**
	 * 检查结论
	 * @param Exam_decision
	 */
	public void setExam_decision(String Exam_decision) {
		setAttrVal("Exam_decision", Exam_decision);
	}
	/**
	 * 检查备注
	 * @return String
	 */
	public String getExam_comment() {
		return ((String) getAttrVal("Exam_comment"));
	}	
	/**
	 * 检查备注
	 * @param Exam_comment
	 */
	public void setExam_comment(String Exam_comment) {
		setAttrVal("Exam_comment", Exam_comment);
	}
	/**
	 * 建议离岗标识
	 * @return FBoolean
	 */
	public FBoolean getFg_suggestleave() {
		return ((FBoolean) getAttrVal("Fg_suggestleave"));
	}	
	/**
	 * 建议离岗标识
	 * @param Fg_suggestleave
	 */
	public void setFg_suggestleave(FBoolean Fg_suggestleave) {
		setAttrVal("Fg_suggestleave", Fg_suggestleave);
	}
	/**
	 * 诊断标识
	 * @return FBoolean
	 */
	public FBoolean getFg_diagnosis() {
		return ((FBoolean) getAttrVal("Fg_diagnosis"));
	}	
	/**
	 * 诊断标识
	 * @param Fg_diagnosis
	 */
	public void setFg_diagnosis(FBoolean Fg_diagnosis) {
		setAttrVal("Fg_diagnosis", Fg_diagnosis);
	}
	/**
	 * 追踪标识_职业病
	 * @return FBoolean
	 */
	public FBoolean getFg_follup() {
		return ((FBoolean) getAttrVal("Fg_follup"));
	}	
	/**
	 * 追踪标识_职业病
	 * @param Fg_follup
	 */
	public void setFg_follup(FBoolean Fg_follup) {
		setAttrVal("Fg_follup", Fg_follup);
	}
	/**
	 * 通过标识
	 * @return FBoolean
	 */
	public FBoolean getFg_passed() {
		return ((FBoolean) getAttrVal("Fg_passed"));
	}	
	/**
	 * 通过标识
	 * @param Fg_passed
	 */
	public void setFg_passed(FBoolean Fg_passed) {
		setAttrVal("Fg_passed", Fg_passed);
	}
	/**
	 * 总检锁定标识
	 * @return FBoolean
	 */
	public FBoolean getFg_locking() {
		return ((FBoolean) getAttrVal("Fg_locking"));
	}	
	/**
	 * 总检锁定标识
	 * @param Fg_locking
	 */
	public void setFg_locking(FBoolean Fg_locking) {
		setAttrVal("Fg_locking", Fg_locking);
	}
	/**
	 * 总检锁定医生
	 * @return String
	 */
	public String getId_locking_doc() {
		return ((String) getAttrVal("Id_locking_doc"));
	}	
	/**
	 * 总检锁定医生
	 * @param Id_locking_doc
	 */
	public void setId_locking_doc(String Id_locking_doc) {
		setAttrVal("Id_locking_doc", Id_locking_doc);
	}
	/**
	 * 体检次数
	 * @return Integer
	 */
	public Integer getPe_times() {
		return ((Integer) getAttrVal("Pe_times"));
	}	
	/**
	 * 体检次数
	 * @param Pe_times
	 */
	public void setPe_times(Integer Pe_times) {
		setAttrVal("Pe_times", Pe_times);
	}
	/**
	 * 体检流程号
	 * @return String
	 */
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}	
	/**
	 * 体检流程号
	 * @param Card_pe
	 */
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
	}
	/**
	 * 体检唯一码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	/**
	 * 体检唯一码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_oval() {
		return ((String) getAttrVal("Name_oval"));
	}	
	/**
	 * 用户名称
	 * @param Name_oval
	 */
	public void setName_oval(String Name_oval) {
		setAttrVal("Name_oval", Name_oval);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_oval() {
		return ((String) getAttrVal("Code_oval"));
	}	
	/**
	 * 用户编码
	 * @param Code_oval
	 */
	public void setCode_oval(String Code_oval) {
		setAttrVal("Code_oval", Code_oval);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_aduit() {
		return ((String) getAttrVal("Name_aduit"));
	}	
	/**
	 * 用户名称
	 * @param Name_aduit
	 */
	public void setName_aduit(String Name_aduit) {
		setAttrVal("Name_aduit", Name_aduit);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_aduit() {
		return ((String) getAttrVal("Code_aduit"));
	}	
	/**
	 * 用户编码
	 * @param Code_aduit
	 */
	public void setCode_aduit(String Code_aduit) {
		setAttrVal("Code_aduit", Code_aduit);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_release() {
		return ((String) getAttrVal("Name_release"));
	}	
	/**
	 * 用户名称
	 * @param Name_release
	 */
	public void setName_release(String Name_release) {
		setAttrVal("Name_release", Name_release);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_release() {
		return ((String) getAttrVal("Code_release"));
	}	
	/**
	 * 用户编码
	 * @param Code_release
	 */
	public void setCode_release(String Code_release) {
		setAttrVal("Code_release", Code_release);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_confirm() {
		return ((String) getAttrVal("Code_confirm"));
	}	
	/**
	 * 用户编码
	 * @param Code_confirm
	 */
	public void setCode_confirm(String Code_confirm) {
		setAttrVal("Code_confirm", Code_confirm);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_locking() {
		return ((String) getAttrVal("Name_locking"));
	}	
	/**
	 * 用户名称
	 * @param Name_locking
	 */
	public void setName_locking(String Name_locking) {
		setAttrVal("Name_locking", Name_locking);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_locking() {
		return ((String) getAttrVal("Code_locking"));
	}	
	/**
	 * 用户编码
	 * @param Code_locking
	 */
	public void setCode_locking(String Code_locking) {
		setAttrVal("Code_locking", Code_locking);
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
		return "Id_pewfoval";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_pewfoval";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeWfOvalDODesc.class);
	}
	
}