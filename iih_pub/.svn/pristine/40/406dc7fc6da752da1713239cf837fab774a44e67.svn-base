package iih.bl.cg.service.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;

public class BL_Register_RefundDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 退挂号的记账主键
	 * @return
	 */
	public String getId_cgoep() {
		return ((String) getAttrVal("Id_cgoep"));
	}
	public void setId_cgoep(String Id_cgoep) {
		setAttrVal("Id_cgoep", Id_cgoep);
	}
	
	/**
	 * 退挂号的就诊ID
	 * @return
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	
	/**
	 * 是否全退重收。FBoolean.TRUE:全退重收;FBoolean.FALSE:退费
	 * @return
	 */
	public FBoolean getAllRefundAndAllCharge() {
		return ((FBoolean) getAttrVal("AllRefundAndAllCharge"));
	}
	public void setAllRefundAndAllCharge(FBoolean AllRefundAndAllCharge) {
		setAttrVal("AllRefundAndAllCharge", AllRefundAndAllCharge);
	}
	
	
	/**
	 * 收付款使用的终端类型
	 * @return
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	
	
	/**
	 * 是否打印红冲票。FBoolean.TRUE:打印红冲票;FBoolean.FALSE:不打印红冲票
	 * @return
	 */
	public FBoolean getPrintRedInc() {
		return ((FBoolean) getAttrVal("PrintRedInc"));
	}
	public void setPrintRedInc(FBoolean PrintRedInc) {
		setAttrVal("PrintRedInc", PrintRedInc);
	}
	
	/*****************如果退医保，则需要下列字段**************/
	/**
	 * 医保交易流水号
	 * @return
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 结算主键
	 * @return
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 分摊DTO1_退费的分摊
	 * @return String
	 */
	public FArrayList2 getBlPropOepDO() {
		return ((FArrayList2) getAttrVal("BlPropOepDO"));
	}
	/**
	 * 分摊DTO1_退费的分摊
	 * @param BlPropOepDO
	 */
	public void setBlPropOepDO(FArrayList2 BlPropOepDO) {
		setAttrVal("BlPropOepDO", BlPropOepDO);
	}
	
	/**
	 * 分摊DTO2_退费的分摊
	 * @return String
	 */
	public FArrayList2 getBlproparoepAggDO() {
		return ((FArrayList2) getAttrVal("BlproparoepAggDO"));
	}
	/**
	 * 分摊DTO2_退费的分摊
	 * @param BlproparoepAggDO
	 */
	public void setBlproparoepAggDO(FArrayList2 BlproparoepAggDO) {
		setAttrVal("BlproparoepAggDO", BlproparoepAggDO);
	}
	
	/**
	 * 分摊DTO1_重收的分摊
	 * @return String
	 */
	public FArrayList2 getBlPropOepDO_recharge() {
		return ((FArrayList2) getAttrVal("BlPropOepDO_recharge"));
	}
	/**
	 * 分摊DTO1_重收的分摊
	 * @param BlPropOepDO
	 */
	public void setBlPropOepDO_recharge(FArrayList2 BlPropOepDO_recharge) {
		setAttrVal("BlPropOepDO_recharge", BlPropOepDO_recharge);
	}
	
	/**
	 * 分摊DTO2_重收的分摊
	 * @return String
	 */
	public FArrayList2 getBlproparoepAggDO_recharge() {
		return ((FArrayList2) getAttrVal("BlproparoepAggDO_recharge"));
	}
	/**
	 * 分摊DTO2_重收的分摊
	 * @param BlproparoepAggDO
	 */
	public void setBlproparoepAggDO_recharge(FArrayList2 BlproparoepAggDO_recharge) {
		setAttrVal("BlproparoepAggDO_recharge", BlproparoepAggDO_recharge);
	}
	
	
	 

}
