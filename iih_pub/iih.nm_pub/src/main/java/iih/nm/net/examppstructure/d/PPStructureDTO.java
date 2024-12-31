package iih.nm.net.examppstructure.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 试卷结构辅助结构 DTO数据 
 * 
 */
public class PPStructureDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 试卷ID
	 * @return String
	 */
	public String getId_pp() {
		return ((String) getAttrVal("Id_pp"));
	}
	/**
	 * 试卷ID
	 * @param Id_pp
	 */
	public void setId_pp(String Id_pp) {
		setAttrVal("Id_pp", Id_pp);
	}
	/**
	 * 试卷编码
	 * @return String
	 */
	public String getCode_pp() {
		return ((String) getAttrVal("Code_pp"));
	}
	/**
	 * 试卷编码
	 * @param Code_pp
	 */
	public void setCode_pp(String Code_pp) {
		setAttrVal("Code_pp", Code_pp);
	}
	/**
	 * 试卷名称
	 * @return String
	 */
	public String getName_pp() {
		return ((String) getAttrVal("Name_pp"));
	}
	/**
	 * 试卷名称
	 * @param Name_pp
	 */
	public void setName_pp(String Name_pp) {
		setAttrVal("Name_pp", Name_pp);
	}
	/**
	 * 试卷总分
	 * @return FDouble
	 */
	public FDouble getTotal_score() {
		return ((FDouble) getAttrVal("Total_score"));
	}
	/**
	 * 试卷总分
	 * @param Total_score
	 */
	public void setTotal_score(FDouble Total_score) {
		setAttrVal("Total_score", Total_score);
	}
	/**
	 * 段落ID
	 * @return String
	 */
	public String getId_ppsec() {
		return ((String) getAttrVal("Id_ppsec"));
	}
	/**
	 * 段落ID
	 * @param Id_ppsec
	 */
	public void setId_ppsec(String Id_ppsec) {
		setAttrVal("Id_ppsec", Id_ppsec);
	}
	/**
	 * 段落序号
	 * @return String
	 */
	public String getTitle_no() {
		return ((String) getAttrVal("Title_no"));
	}
	/**
	 * 段落序号
	 * @param Title_no
	 */
	public void setTitle_no(String Title_no) {
		setAttrVal("Title_no", Title_no);
	}
	/**
	 * 段落名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 段落名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 段落编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 段落编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 段落分值
	 * @return FDouble
	 */
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}
	/**
	 * 段落分值
	 * @param Score
	 */
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 段落描述
	 * @return String
	 */
	public String getName_des() {
		return ((String) getAttrVal("Name_des"));
	}
	/**
	 * 段落描述
	 * @param Name_des
	 */
	public void setName_des(String Name_des) {
		setAttrVal("Name_des", Name_des);
	}
	/**
	 * 试题ID
	 * @return String
	 */
	public String getId_qu() {
		return ((String) getAttrVal("Id_qu"));
	}
	/**
	 * 试题ID
	 * @param Id_qu
	 */
	public void setId_qu(String Id_qu) {
		setAttrVal("Id_qu", Id_qu);
	}
	/**
	 * 试题内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}
	/**
	 * 试题内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 试题类型
	 * @return String
	 */
	public String getSd_qu_tp() {
		return ((String) getAttrVal("Sd_qu_tp"));
	}
	/**
	 * 试题类型
	 * @param Sd_qu_tp
	 */
	public void setSd_qu_tp(String Sd_qu_tp) {
		setAttrVal("Sd_qu_tp", Sd_qu_tp);
	}
	/**
	 * 试题描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 试题描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 试题附件ID
	 * @return String
	 */
	public String getId_qu_accessory() {
		return ((String) getAttrVal("Id_qu_accessory"));
	}
	/**
	 * 试题附件ID
	 * @param Id_qu_accessory
	 */
	public void setId_qu_accessory(String Id_qu_accessory) {
		setAttrVal("Id_qu_accessory", Id_qu_accessory);
	}
	/**
	 * 试题附件地址
	 * @return String
	 */
	public String getQu_att_add() {
		return ((String) getAttrVal("Qu_att_add"));
	}
	/**
	 * 试题附件地址
	 * @param Qu_att_add
	 */
	public void setQu_att_add(String Qu_att_add) {
		setAttrVal("Qu_att_add", Qu_att_add);
	}
	/**
	 * 答案ID
	 * @return String
	 */
	public String getId_qu_ans() {
		return ((String) getAttrVal("Id_qu_ans"));
	}
	/**
	 * 答案ID
	 * @param Id_qu_ans
	 */
	public void setId_qu_ans(String Id_qu_ans) {
		setAttrVal("Id_qu_ans", Id_qu_ans);
	}
	/**
	 * 答案内容
	 * @return String
	 */
	public String getAns_content() {
		return ((String) getAttrVal("Ans_content"));
	}
	/**
	 * 答案内容
	 * @param Ans_content
	 */
	public void setAns_content(String Ans_content) {
		setAttrVal("Ans_content", Ans_content);
	}
	/**
	 * 答案编号
	 * @return String
	 */
	public String getAns_no() {
		return ((String) getAttrVal("Ans_no"));
	}
	/**
	 * 答案编号
	 * @param Ans_no
	 */
	public void setAns_no(String Ans_no) {
		setAttrVal("Ans_no", Ans_no);
	}
	/**
	 * 是否正确答案
	 * @return FBoolean
	 */
	public FBoolean getFg_right() {
		return ((FBoolean) getAttrVal("Fg_right"));
	}
	/**
	 * 是否正确答案
	 * @param Fg_right
	 */
	public void setFg_right(FBoolean Fg_right) {
		setAttrVal("Fg_right", Fg_right);
	}
	/**
	 * 答案附件ID
	 * @return String
	 */
	public String getId_ans_accessory() {
		return ((String) getAttrVal("Id_ans_accessory"));
	}
	/**
	 * 答案附件ID
	 * @param Id_ans_accessory
	 */
	public void setId_ans_accessory(String Id_ans_accessory) {
		setAttrVal("Id_ans_accessory", Id_ans_accessory);
	}
	/**
	 * 答案附件地址
	 * @return String
	 */
	public String getAns_att_add() {
		return ((String) getAttrVal("Ans_att_add"));
	}
	/**
	 * 答案附件地址
	 * @param Ans_att_add
	 */
	public void setAns_att_add(String Ans_att_add) {
		setAttrVal("Ans_att_add", Ans_att_add);
	}
}