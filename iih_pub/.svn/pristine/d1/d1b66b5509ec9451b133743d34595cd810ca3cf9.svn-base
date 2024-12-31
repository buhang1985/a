package iih.ci.ord.i.error;

import java.util.List;

import iih.ci.ord.dws.ip.order.d.OrderErrorDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 错误医疗单对象
 * 
 * @author wangqingzhu
 *
 */
public class ErrorEmsDTO extends OrderErrorDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorEmsDTO() {
	}

	public ErrorEmsDTO( BaseDTO docObj) {
	
		FArrayList doc = new FArrayList();
		doc.add(docObj);
		setDocument(doc);

	}

	public ErrorEmsDTO( String code_or,String name_or, String errorInfo) {
		this.setCode_or(code_or);
		this.setName_or(name_or);	
		this.setError_message(errorInfo);
		this.setError_level("E");
	}
	public ErrorEmsDTO( String code_or,String name_or,List<String> msglist) {
		this.setCode_or(code_or);
		this.setName_or(name_or);	
		if(null != msglist && msglist.size() > 0){
			StringBuilder sb = new StringBuilder();
			for(String msg : msglist){
				sb.append(msg);
			}
			this.setError_message(sb.toString());
		}
		this.setError_level("E");
	}
}
