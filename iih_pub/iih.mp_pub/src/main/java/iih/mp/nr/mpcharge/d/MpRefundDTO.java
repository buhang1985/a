package iih.mp.nr.mpcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行退记账参数 DTO数据 
 * 
 */
public class MpRefundDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
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
	 * 医嘱服务执行计划
	 * @return String
	 */
	public String getId_or_prsrv() {
		return ((String) getAttrVal("Id_or_prsrv"));
	}
	/**
	 * 医嘱服务执行计划
	 * @param Id_or_prsrv
	 */
	public void setId_or_prsrv(String Id_or_prsrv) {
		setAttrVal("Id_or_prsrv", Id_or_prsrv);
	}
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
	 * 退数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 退数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 实际退记账
	 * @return FBoolean
	 */
	public FBoolean getFg_refund() {
		return ((FBoolean) getAttrVal("Fg_refund"));
	}
	/**
	 * 实际退记账
	 * @param Fg_refund
	 */
	public void setFg_refund(FBoolean Fg_refund) {
		setAttrVal("Fg_refund", Fg_refund);
	}
}