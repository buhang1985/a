package iih.pis.ivx.pisivxtrainsat.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 微信培训满意度调查 DTO数据 
 * 
 */
public class PisivxTrainSatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 满意度标识
	 * @return String
	 */
	public String getId_net_crs_ass() {
		return ((String) getAttrVal("Id_net_crs_ass"));
	}
	/**
	 * 满意度标识
	 * @param Id_net_crs_ass
	 */
	public void setId_net_crs_ass(String Id_net_crs_ass) {
		setAttrVal("Id_net_crs_ass", Id_net_crs_ass);
	}
	/**
	 * 培训安排
	 * @return String
	 */
	public String getId_net_trainmgr() {
		return ((String) getAttrVal("Id_net_trainmgr"));
	}
	/**
	 * 培训安排
	 * @param Id_net_trainmgr
	 */
	public void setId_net_trainmgr(String Id_net_trainmgr) {
		setAttrVal("Id_net_trainmgr", Id_net_trainmgr);
	}
	/**
	 * 培训课程
	 * @return String
	 */
	public String getId_net_trainmgr_crs() {
		return ((String) getAttrVal("Id_net_trainmgr_crs"));
	}
	/**
	 * 培训课程
	 * @param Id_net_trainmgr_crs
	 */
	public void setId_net_trainmgr_crs(String Id_net_trainmgr_crs) {
		setAttrVal("Id_net_trainmgr_crs", Id_net_trainmgr_crs);
	}
	/**
	 * 调查时间
	 * @return String
	 */
	public String getDt_survey() {
		return ((String) getAttrVal("Dt_survey"));
	}
	/**
	 * 调查时间
	 * @param Dt_survey
	 */
	public void setDt_survey(String Dt_survey) {
		setAttrVal("Dt_survey", Dt_survey);
	}
	/**
	 * 学员名称
	 * @return String
	 */
	public String getName_std() {
		return ((String) getAttrVal("Name_std"));
	}
	/**
	 * 学员名称
	 * @param Name_std
	 */
	public void setName_std(String Name_std) {
		setAttrVal("Name_std", Name_std);
	}
	/**
	 * 学员微信号
	 * @return String
	 */
	public String getId_wx_std() {
		return ((String) getAttrVal("Id_wx_std"));
	}
	/**
	 * 学员微信号
	 * @param Id_wx_std
	 */
	public void setId_wx_std(String Id_wx_std) {
		setAttrVal("Id_wx_std", Id_wx_std);
	}
	/**
	 * 试题标识
	 * @return String
	 */
	public String getId_net_crs_ass_qus() {
		return ((String) getAttrVal("Id_net_crs_ass_qus"));
	}
	/**
	 * 试题标识
	 * @param Id_net_crs_ass_qus
	 */
	public void setId_net_crs_ass_qus(String Id_net_crs_ass_qus) {
		setAttrVal("Id_net_crs_ass_qus", Id_net_crs_ass_qus);
	}
	/**
	 * 试题名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 试题名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 试题选项
	 * @return String
	 */
	public String getQus_opt() {
		return ((String) getAttrVal("Qus_opt"));
	}
	/**
	 * 试题选项
	 * @param Qus_opt
	 */
	public void setQus_opt(String Qus_opt) {
		setAttrVal("Qus_opt", Qus_opt);
	}
	/**
	 * 试题答案
	 * @return String
	 */
	public String getQus_ans() {
		return ((String) getAttrVal("Qus_ans"));
	}
	/**
	 * 试题答案
	 * @param Qus_ans
	 */
	public void setQus_ans(String Qus_ans) {
		setAttrVal("Qus_ans", Qus_ans);
	}
}