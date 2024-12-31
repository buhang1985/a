package iih.mp.nr.api.d;

import java.io.Serializable;
import java.util.List;
/**
 * 
* @ClassName: HCISResult 
* @Description: HCIS接口出参封装类
* @author zhy
* @date 2019年5月23日 下午6:12:00 
*
 */
public class HCISResult implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
   
	/**
	 * 头信息
	 */
	private HeadMessage HeadMessage;
	
	/**
	 * 患者信息
	 */
	private List list;

	public HeadMessage getHeadMessage() {
		return HeadMessage;
	}

	public List getList() {
		return list;
	}

	public void setHeadMessage(HeadMessage headMessage) {
		HeadMessage = headMessage;
	}

	public void setList(List list) {
		this.list = list;
	}

	
	
	
	
}
