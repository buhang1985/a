package iih.ei.std.d.v1.en.opwaitque.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者候诊队列出参 DTO数据 
 * 
 */
public class OpWaitQueResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者的候诊队列
	 * @return String
	 */
	public FArrayList getOpwaitque() {
		return ((FArrayList) getAttrVal("Opwaitque"));
	}	
	/**
	 * 患者的候诊队列
	 * @param Opwaitque
	 */
	public void setOpwaitque(FArrayList Opwaitque) {
		setAttrVal("Opwaitque", Opwaitque);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public FArrayList getPageinfo() {
		return ((FArrayList) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(FArrayList Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}