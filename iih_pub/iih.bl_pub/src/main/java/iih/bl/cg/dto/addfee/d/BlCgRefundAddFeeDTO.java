package iih.bl.cg.dto.addfee.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 纯补费退费dto DTO数据 
 * 
 */
public class BlCgRefundAddFeeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记账id
	 * @return String
	 */
	public String getId_cg() {
		return ((String) getAttrVal("Id_cg"));
	}
	/**
	 * 记账id
	 * @param Id_cg
	 */
	public void setId_cg(String Id_cg) {
		setAttrVal("Id_cg", Id_cg);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 退费数量
	 * @return FDouble
	 */
	public FDouble getQuan_ret() {
		return ((FDouble) getAttrVal("Quan_ret"));
	}
	/**
	 * 退费数量
	 * @param Quan_ret
	 */
	public void setQuan_ret(FDouble Quan_ret) {
		setAttrVal("Quan_ret", Quan_ret);
	}
	/**
	 * 费用来源
	 * @return String
	 */
	public String getSrcfunc_des() {
		return ((String) getAttrVal("Srcfunc_des"));
	}
	/**
	 * 费用来源
	 * @param Srcfunc_des
	 */
	public void setSrcfunc_des(String Srcfunc_des) {
		setAttrVal("Srcfunc_des", Srcfunc_des);
	}
}