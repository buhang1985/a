package iih.mp.nr.msg.warningnotice.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预警信息确认消息 DTO数据 
 * 
 */
public class WarningSureDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 消息代码
	 * @return String
	 */
	public String getMsgid() {
		return ((String) getAttrVal("Msgid"));
	}
	/**
	 * 消息代码
	 * @param Msgid
	 */
	public void setMsgid(String Msgid) {
		setAttrVal("Msgid", Msgid);
	}
	/**
	 * 确认信息
	 * @return String
	 */
	public String getMsgname() {
		return ((String) getAttrVal("Msgname"));
	}
	/**
	 * 确认信息
	 * @param Msgname
	 */
	public void setMsgname(String Msgname) {
		setAttrVal("Msgname", Msgname);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatetime() {
		return ((FDateTime) getAttrVal("Createtime"));
	}
	/**
	 * 创建时间
	 * @param Createtime
	 */
	public void setCreatetime(FDateTime Createtime) {
		setAttrVal("Createtime", Createtime);
	}
	/**
	 * 返回信息明细
	 * @return FArrayList2
	 */
	public FArrayList2 getWarningsureitem() {
		return ((FArrayList2) getAttrVal("Warningsureitem"));
	}
	/**
	 * 返回信息明细
	 * @param Warningsureitem
	 */
	public void setWarningsureitem(FArrayList2 Warningsureitem) {
		setAttrVal("Warningsureitem", Warningsureitem);
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
	 * 确认角色
	 * @return Integer
	 */
	public Integer getType() {
		return ((Integer) getAttrVal("Type"));
	}
	/**
	 * 确认角色
	 * @param Type
	 */
	public void setType(Integer Type) {
		setAttrVal("Type", Type);
	}
}