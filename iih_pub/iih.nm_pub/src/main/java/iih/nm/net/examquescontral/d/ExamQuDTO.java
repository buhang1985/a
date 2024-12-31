package iih.nm.net.examquescontral.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 试题 DTO数据 
 * 
 */
public class ExamQuDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 试题id
	 * @return String
	 */
	public String getId_qu() {
		return ((String) getAttrVal("Id_qu"));
	}
	/**
	 * 试题id
	 * @param Id_qu
	 */
	public void setId_qu(String Id_qu) {
		setAttrVal("Id_qu", Id_qu);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSerial_no() {
		return ((String) getAttrVal("Serial_no"));
	}
	/**
	 * 序号
	 * @param Serial_no
	 */
	public void setSerial_no(String Serial_no) {
		setAttrVal("Serial_no", Serial_no);
	}
	/**
	 * 试卷段落ID
	 * @return String
	 */
	public String getId_ppsec() {
		return ((String) getAttrVal("Id_ppsec"));
	}
	/**
	 * 试卷段落ID
	 * @param Id_ppsec
	 */
	public void setId_ppsec(String Id_ppsec) {
		setAttrVal("Id_ppsec", Id_ppsec);
	}
	/**
	 * 题目内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}
	/**
	 * 题目内容
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
	 * 答案项允许增删
	 * @return FBoolean
	 */
	public FBoolean getFg_itemedit() {
		return ((FBoolean) getAttrVal("Fg_itemedit"));
	}
	/**
	 * 答案项允许增删
	 * @param Fg_itemedit
	 */
	public void setFg_itemedit(FBoolean Fg_itemedit) {
		setAttrVal("Fg_itemedit", Fg_itemedit);
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
	 * 附件路径地址
	 * @return String
	 */
	public String getAddress_accessory() {
		return ((String) getAttrVal("Address_accessory"));
	}
	/**
	 * 附件路径地址
	 * @param Address_accessory
	 */
	public void setAddress_accessory(String Address_accessory) {
		setAttrVal("Address_accessory", Address_accessory);
	}
	/**
	 * 附件本地路径
	 * @return String
	 */
	public String getLocal_path_add() {
		return ((String) getAttrVal("Local_path_add"));
	}
	/**
	 * 附件本地路径
	 * @param Local_path_add
	 */
	public void setLocal_path_add(String Local_path_add) {
		setAttrVal("Local_path_add", Local_path_add);
	}
	/**
	 * 附件远端路径
	 * @return String
	 */
	public String getRemote_path_add() {
		return ((String) getAttrVal("Remote_path_add"));
	}
	/**
	 * 附件远端路径
	 * @param Remote_path_add
	 */
	public void setRemote_path_add(String Remote_path_add) {
		setAttrVal("Remote_path_add", Remote_path_add);
	}
	/**
	 * 答案集合
	 * @return FArrayList
	 */
	public FArrayList getQu_ans() {
		return ((FArrayList) getAttrVal("Qu_ans"));
	}
	/**
	 * 答案集合
	 * @param Qu_ans
	 */
	public void setQu_ans(FArrayList Qu_ans) {
		setAttrVal("Qu_ans", Qu_ans);
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
	 * 只读标志
	 * @return FBoolean
	 */
	public FBoolean getFg_readonly() {
		return ((FBoolean) getAttrVal("Fg_readonly"));
	}
	/**
	 * 只读标志
	 * @param Fg_readonly
	 */
	public void setFg_readonly(FBoolean Fg_readonly) {
		setAttrVal("Fg_readonly", Fg_readonly);
	}
	/**
	 * 答题标识
	 * @return FBoolean
	 */
	public FBoolean getFg_answer() {
		return ((FBoolean) getAttrVal("Fg_answer"));
	}
	/**
	 * 答题标识
	 * @param Fg_answer
	 */
	public void setFg_answer(FBoolean Fg_answer) {
		setAttrVal("Fg_answer", Fg_answer);
	}
	/**
	 * 试题结果
	 * @return Integer
	 */
	public Integer getEu_res() {
		return ((Integer) getAttrVal("Eu_res"));
	}
	/**
	 * 试题结果
	 * @param Eu_res
	 */
	public void setEu_res(Integer Eu_res) {
		setAttrVal("Eu_res", Eu_res);
	}
	/**
	 * 待定标志
	 * @return FBoolean
	 */
	public FBoolean getFg_doubt() {
		return ((FBoolean) getAttrVal("Fg_doubt"));
	}
	/**
	 * 待定标志
	 * @param Fg_doubt
	 */
	public void setFg_doubt(FBoolean Fg_doubt) {
		setAttrVal("Fg_doubt", Fg_doubt);
	}
}