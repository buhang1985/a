package iih.ei.std.d.v1.bl.oppaydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收款出参 DTO数据 
 * 
 */
public class OpPayResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单流水号
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}	
	/**
	 * 订单流水号
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
	}
	/**
	 * 指引单提示执行科室位置
	 * @return String
	 */
	public String getGuideinfo() {
		return ((String) getAttrVal("Guideinfo"));
	}	
	/**
	 * 指引单提示执行科室位置
	 * @param Guideinfo
	 */
	public void setGuideinfo(String Guideinfo) {
		setAttrVal("Guideinfo", Guideinfo);
	}
	/**
	 * 操作员编码
	 * @return String
	 */
	public String getCode_opera() {
		return ((String) getAttrVal("Code_opera"));
	}	
	/**
	 * 操作员编码
	 * @param Code_opera
	 */
	public void setCode_opera(String Code_opera) {
		setAttrVal("Code_opera", Code_opera);
	}
	/**
	 * 终端类型
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}	
	/**
	 * 终端类型
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 票据类型
	 * @return String
	 */
	public String getInc_type() {
		return ((String) getAttrVal("Inc_type"));
	}	
	/**
	 * 票据类型
	 * @param Inc_type
	 */
	public void setInc_type(String Inc_type) {
		setAttrVal("Inc_type", Inc_type);
	}
	/**
	 * 支付顺序号
	 * @return String
	 */
	public String getPayno() {
		return ((String) getAttrVal("Payno"));
	}	
	/**
	 * 支付顺序号
	 * @param Payno
	 */
	public void setPayno(String Payno) {
		setAttrVal("Payno", Payno);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 门诊收费出参发票信息
	 * @return String
	 */
	public FArrayList getIncinfo() {
		return ((FArrayList) getAttrVal("Incinfo"));
	}	
	/**
	 * 门诊收费出参发票信息
	 * @param Incinfo
	 */
	public void setIncinfo(FArrayList Incinfo) {
		setAttrVal("Incinfo", Incinfo);
	}
	/**
	 * 药品窗口号
	 * @return String
	 */
	public FArrayList getWindownoinfo() {
		return ((FArrayList) getAttrVal("Windownoinfo"));
	}	
	/**
	 * 药品窗口号
	 * @param Windownoinfo
	 */
	public void setWindownoinfo(FArrayList Windownoinfo) {
		setAttrVal("Windownoinfo", Windownoinfo);
	}
}