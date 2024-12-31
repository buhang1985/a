package iih.mm.itf.material.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * ReserveDeliverReqDTO DTO数据 
 * 
 */
public class ReserveDeliverReqDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 请求量
	 * @return FDouble
	 */
	public FDouble getReq_num() {
		return ((FDouble) getAttrVal("Req_num"));
	}
	/**
	 * 请求量
	 * @param Req_num
	 */
	public void setReq_num(FDouble Req_num) {
		setAttrVal("Req_num", Req_num);
	}
	/**
	 * 请求量单位
	 * @return String
	 */
	public String getReq_unit_id() {
		return ((String) getAttrVal("Req_unit_id"));
	}
	/**
	 * 请求量单位
	 * @param Req_unit_id
	 */
	public void setReq_unit_id(String Req_unit_id) {
		setAttrVal("Req_unit_id", Req_unit_id);
	}
	/**
	 * 服务条目ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 服务条目ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
}