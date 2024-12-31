package iih.mp.nr.iihtopacs.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检查申请收费明细 DTO数据 
 * 
 */
public class PriceDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 收费项目编码
	 * @return String
	 */
	public String getCode_srv_charge() {
		return ((String) getAttrVal("Code_srv_charge"));
	}
	/**
	 * 收费项目编码
	 * @param Code_srv_charge
	 */
	public void setCode_srv_charge(String Code_srv_charge) {
		setAttrVal("Code_srv_charge", Code_srv_charge);
	}
	/**
	 * 收费项目名称（文字）
	 * @return String
	 */
	public String getName_srv_charge() {
		return ((String) getAttrVal("Name_srv_charge"));
	}
	/**
	 * 收费项目名称（文字）
	 * @param Name_srv_charge
	 */
	public void setName_srv_charge(String Name_srv_charge) {
		setAttrVal("Name_srv_charge", Name_srv_charge);
	}
	/**
	 * 收费价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 收费价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 收费数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 收费数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 发生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}
	/**
	 * 发生时间
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
}