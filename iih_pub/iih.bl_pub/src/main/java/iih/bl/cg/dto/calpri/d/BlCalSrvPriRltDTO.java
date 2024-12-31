package iih.bl.cg.dto.calpri.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用计算服务价格返回值dto DTO数据 
 * 
 */
public class BlCalSrvPriRltDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱服务
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 患者价格分类
	 * @return String
	 */
	public String getId_patpritp() {
		return ((String) getAttrVal("Id_patpritp"));
	}
	/**
	 * 患者价格分类
	 * @param Id_patpritp
	 */
	public void setId_patpritp(String Id_patpritp) {
		setAttrVal("Id_patpritp", Id_patpritp);
	}
	/**
	 * 标准价
	 * @return FDouble
	 */
	public FDouble getPrice_std() {
		return ((FDouble) getAttrVal("Price_std"));
	}
	/**
	 * 标准价
	 * @param Price_std
	 */
	public void setPrice_std(FDouble Price_std) {
		setAttrVal("Price_std", Price_std);
	}
	/**
	 * 折扣率
	 * @return FDouble
	 */
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}
	/**
	 * 折扣率
	 * @param Rate
	 */
	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 折扣价
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 折扣价
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
}