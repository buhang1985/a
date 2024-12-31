package iih.ci.preip.imp;

import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.coreitf.d.FBoolean;

/**
 * 预住院医嘱导入成正式住院医嘱接口返回值类型
 * @author wangqingzhu
 *
 */
public class CiPreIPImpRst extends BaseXapJsonSerialization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private FBoolean success;
	
	public CiPreIPImpRst(String message, FBoolean success) {
		this.message = message;
		this.success = success;
	}

	// 返回成功标志
	public FBoolean success() {
		return success;
	}

	// 返回信息
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
