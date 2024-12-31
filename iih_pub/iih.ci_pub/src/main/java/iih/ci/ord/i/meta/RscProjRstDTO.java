package iih.ci.ord.i.meta;

import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医嘱科研项目设置结果返回集
 * @author wangqingzhu
 *
 */
public class RscProjRstDTO extends BaseXapJsonSerialization {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RscProjRstDTO(FBoolean success, String msg){
		setSuccess(success);
		setMessage(msg);
	}
	/**
	 * 科研信息操作结果
	 * @return FBoolean
	 */
	public FBoolean getSuccess() {
		return ((FBoolean) getAttrVal("Success"));
	}
	/**
	 * 科研信息操作结果
	 * @param Success
	 */
	public void setSuccess(FBoolean Success) {
		setAttrVal("Success", Success);
	}
	
	/**
	 * 科研信息操作结果
	 * @return FBoolean
	 */
	public String getMessage() {
		return ((String) getAttrVal("Message"));
	}
	/**
	 * 科研信息操作结果
	 * @param Success
	 */
	public void setMessage(String Message) {
		setAttrVal("Message", Message);
	}

}
