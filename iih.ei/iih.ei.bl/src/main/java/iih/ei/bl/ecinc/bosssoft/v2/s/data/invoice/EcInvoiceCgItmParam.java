package iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice;

import java.io.Serializable;

/**
 * 电子票据开具记账信息
 * @author ly 2019/12/31
 *
 */
public class EcInvoiceCgItmParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String listDetailNo;//明细流水号
	private String chargeCode;//收费项目代码
	private String chargeName;//收费项目名称
    private String code;//编码
    private String name;//药品名称/剂型
    private String unit;//计量单位 
    private Double std;//单价
    private Double number;//数量
    private Double amt;//金额
    private Double selfAmt;//自费金额
    private String receivableAmt;//应收费用
    private String medCareItemType;//医保项目类型
    private String medReimburseRate;//医保报销比例
    private String remark;//备注
    
	public String getListDetailNo() {
		return listDetailNo;
	}
	public void setListDetailNo(String listDetailNo) {
		this.listDetailNo = listDetailNo;
	}
	public String getChargeCode() {
		return chargeCode;
	}
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}
	public String getChargeName() {
		return chargeName;
	}
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getStd() {
		return std;
	}
	public void setStd(Double std) {
		this.std = std;
	}
	public Double getNumber() {
		return number;
	}
	public void setNumber(Double number) {
		this.number = number;
	}
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	public Double getSelfAmt() {
		return selfAmt;
	}
	public void setSelfAmt(Double selfAmt) {
		this.selfAmt = selfAmt;
	}
	public String getReceivableAmt() {
		return receivableAmt;
	}
	public void setReceivableAmt(String receivableAmt) {
		this.receivableAmt = receivableAmt;
	}
	public String getMedCareItemType() {
		return medCareItemType;
	}
	public void setMedCareItemType(String medCareItemType) {
		this.medCareItemType = medCareItemType;
	}
	public String getMedReimburseRate() {
		return medReimburseRate;
	}
	public void setMedReimburseRate(String medReimburseRate) {
		this.medReimburseRate = medReimburseRate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}