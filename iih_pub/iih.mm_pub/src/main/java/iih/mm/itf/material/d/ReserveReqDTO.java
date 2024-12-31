package iih.mm.itf.material.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * ReserveReqDTO DTO数据 
 * 
 */
public class ReserveReqDTO extends BaseDTO {
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
	 * 执行科室主键
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 执行科室主键
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
}