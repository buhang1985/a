package iih.ei.std.consis.v1.d;

import xap.mw.coreitf.d.FBoolean;

/**
 * 推送基础数据参数DTO
 * 
 * @author hao_wu 2018-12-17
 *
 */
public class PushBDDataParamDTO {

	/**
	 * 操作员
	 */
	private String operId;
	/**
	 * 药房 （选择门诊西药房）
	 */
	private String pharmacyId;
	/**
	 * 推送药品字典
	 */
	private FBoolean pushDrugDic;
	/**
	 * 推送窗口字典
	 */
	private FBoolean pushWinDic;
	/**
	 * 推送科室字典
	 */
	private FBoolean pushDeptDic;
	/**
	 * 推送药房人员字典
	 */
	private FBoolean pushPharmacyPsnDic;
	/**
	 * 推送药品货位字典
	 */
	private FBoolean pushDrugLocDic;

	/**
	 * 操作员
	 * 
	 * @return the operId
	 */
	public String getOperId() {
		return operId;
	}

	/**
	 * 操作员
	 * 
	 * @param operId the operId to set
	 */
	public void setOperId(String operId) {
		this.operId = operId;
	}

	/**
	 * 药房 （选择门诊西药房）
	 * 
	 * @return the pharmacyId
	 */
	public String getPharmacyId() {
		return pharmacyId;
	}

	/**
	 * 药房 （选择门诊西药房）
	 * 
	 * @param pharmacyId the pharmacyId to set
	 */
	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	/**
	 * 推送药品字典
	 * 
	 * @return the pushDrugDic
	 */
	public FBoolean getPushDrugDic() {
		return pushDrugDic;
	}

	/**
	 * 推送药品字典
	 * 
	 * @param pushDrugDic the pushDrugDic to set
	 */
	public void setPushDrugDic(FBoolean pushDrugDic) {
		this.pushDrugDic = pushDrugDic;
	}

	/**
	 * 推送窗口字典
	 * 
	 * @return the pushWinDic
	 */
	public FBoolean getPushWinDic() {
		return pushWinDic;
	}

	/**
	 * 推送窗口字典
	 * 
	 * @param pushWinDic the pushWinDic to set
	 */
	public void setPushWinDic(FBoolean pushWinDic) {
		this.pushWinDic = pushWinDic;
	}

	/**
	 * 推送科室字典
	 * 
	 * @return the pushDeptDic
	 */
	public FBoolean getPushDeptDic() {
		return pushDeptDic;
	}

	/**
	 * 推送科室字典
	 * 
	 * @param pushDeptDic the pushDeptDic to set
	 */
	public void setPushDeptDic(FBoolean pushDeptDic) {
		this.pushDeptDic = pushDeptDic;
	}

	/**
	 * 推送药房人员字典
	 * 
	 * @return the pushPharmacyPsnDic
	 */
	public FBoolean getPushPharmacyPsnDic() {
		return pushPharmacyPsnDic;
	}

	/**
	 * 推送药房人员字典
	 * 
	 * @param pushPharmacyPsnDic the pushPharmacyPsnDic to set
	 */
	public void setPushPharmacyPsnDic(FBoolean pushPharmacyPsnDic) {
		this.pushPharmacyPsnDic = pushPharmacyPsnDic;
	}

	/**
	 * 推送药品货位字典
	 * 
	 * @return the pushDrugLocDic
	 */
	public FBoolean getPushDrugLocDic() {
		return pushDrugLocDic;
	}

	/**
	 * 推送药品货位字典
	 * 
	 * @param pushDrugLocDic the pushDrugLocDic to set
	 */
	public void setPushDrugLocDic(FBoolean pushDrugLocDic) {
		this.pushDrugLocDic = pushDrugLocDic;
	}
}
