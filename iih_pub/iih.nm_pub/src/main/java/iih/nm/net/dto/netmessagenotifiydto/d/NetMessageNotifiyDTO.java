package iih.nm.net.dto.netmessagenotifiydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 消息模板DTO DTO数据 
 * 
 */
public class NetMessageNotifiyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 消息id
	 * @return String
	 */
	public String getId_msg() {
		return ((String) getAttrVal("Id_msg"));
	}
	/**
	 * 消息id
	 * @param Id_msg
	 */
	public void setId_msg(String Id_msg) {
		setAttrVal("Id_msg", Id_msg);
	}
	/**
	 * 标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}
	/**
	 * 标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 消息内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}
	/**
	 * 消息内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 接收人员集合
	 * @return FArrayList2
	 */
	public FArrayList2 getReceivepsnlist() {
		return ((FArrayList2) getAttrVal("Receivepsnlist"));
	}
	/**
	 * 接收人员集合
	 * @param Receivepsnlist
	 */
	public void setReceivepsnlist(FArrayList2 Receivepsnlist) {
		setAttrVal("Receivepsnlist", Receivepsnlist);
	}
}