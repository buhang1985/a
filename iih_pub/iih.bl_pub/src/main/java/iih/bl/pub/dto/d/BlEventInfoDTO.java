package iih.bl.pub.dto.d;

import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class BlEventInfoDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;

	/**
	 * 就诊信息
	 * */
	public PatiVisitDO getPatiVisitDO(){
		return ((PatiVisitDO) getAttrVal("PatiVisitDO"));
	}
	public void setPatiVisitDO(PatiVisitDO patiVisitDO){
		setAttrVal("PatiVisitDO", patiVisitDO);
	}
	
	/**
	 * 患者信息
	 * */
	public PatDO getPatDO(){
		return ((PatDO) getAttrVal("PatDO"));
	}
	public void setPatDO(PatDO patDO){
		setAttrVal("PatDO",patDO);
	}
	
	/**
	 * 记账信息
	 * */
	public FArrayList getBlCgIpDOList(){
		return ((FArrayList) getAttrVal("BlCgIpDOList"));
	}
	public void setBlCgIpDOList(FArrayList blCgIpDOList){
		setAttrVal("BlCgIpDOList",blCgIpDOList);
	}
	
	/**
	 * 结算信息
	 * */
	public BlStIpDO getBlStIpDO(){
		return ((BlStIpDO) getAttrVal("BlStIpDO"));
	}
	public void setBlStIpDO(BlStIpDO blStIpDO){
		setAttrVal("BlStIpDO",blStIpDO);
	}
	
	/**
	 * 住院结算收付款信息
	 * */
	public BlpaypatipAggDO getBlpaypatipAggDO(){
		return ((BlpaypatipAggDO)getAttrVal("BlpaypatipAggDO"));
	}
	public void setBlpaypatipAggDO(BlpaypatipAggDO blpaypatipAggDO){
		setAttrVal("BlpaypatipAggDO",blpaypatipAggDO);
	}
	
	/**
	 * 结算信息(红冲)
	 * */
	public BlStIpDO getBlStIpRedDO(){
		return ((BlStIpDO) getAttrVal("BlStIpRedDO"));
	}
	public void setBlStIpRedDO(BlStIpDO blStIpDO){
		setAttrVal("BlStIpRedDO",blStIpDO);
	}
	
	/**
	 * 住院结算收付款信息(红冲)
	 * */
	public BlpaypatipAggDO getBlpaypatipRedAggDO(){
		return ((BlpaypatipAggDO)getAttrVal("BlpaypatipRedAggDO"));
	}
	public void setBlpaypatipRedAggDO(BlpaypatipAggDO blpaypatipAggDO){
		setAttrVal("BlpaypatipRedAggDO",blpaypatipAggDO);
	}
	
	/**
	 * 结账信息
	 * */
	public BlccAggDO getBlccAggDO(){
		return ((BlccAggDO)getAttrVal("BlccAggDO"));
	}
	public void setBlccAggDO(BlccAggDO blccAggDO){
		setAttrVal("BlccAggDO",blccAggDO);
	}
	
	/**
	 * 住院发票信息
	 * */
	public BlincipAggDO getBlincipAggDO(){
		return ((BlincipAggDO)getAttrVal("BlincipAggDO"));
	}
	public void setBlincipAggDO(BlincipAggDO blincipAggDO){
		setAttrVal("BlincipAggDO",blincipAggDO);
	}
	
	/******以下是门诊信息****************/	
	/**
	 * 来源
	 * */
	public String getFunc_Status(){
		return ((String) getAttrVal("Func_Status"));
	}
	public void setFunc_Status(String Func_Status){
		setAttrVal("Func_Status",Func_Status);
	}
	
	/**
	 * 门诊记账信息
	 * */
	public FArrayList getBlCgItmOepDOList(){
		return ((FArrayList) getAttrVal("BlCgItmOepDOList"));
	}
	public void setBlCgItmOepDOList(FArrayList BlCgItmOepDOList){
		setAttrVal("BlCgItmOepDOList",BlCgItmOepDOList);
	}
	/**
	 * 门诊结算信息
	 * */
	public BlStOepDO getBlStOepDO(){
		return ((BlStOepDO) getAttrVal("BlStOepDO"));
	}
	public void setBlStOepDO(BlStOepDO blStOepDO){
		setAttrVal("BlStOepDO",blStOepDO);
	}
	/**
	 * 门诊发票信息
	 * */
	public BlIncOepDO getBlIncOepDO(){
		return ((BlIncOepDO) getAttrVal("BlIncOepDO"));
	}
	public void setBlIncOepDO(BlIncOepDO blIncOepDO){
		setAttrVal("BlIncOepDO",blIncOepDO);
	}
	/**门诊收付款信息
	 * */
	public BlpaypatoepAggDO getBlpaypatoepAggDO(){
		return ((BlpaypatoepAggDO) getAttrVal("BlpaypatoepAggDO"));
	}
	public void setBlpaypatoepAggDO(BlpaypatoepAggDO blpaypatoepAggDO){
		setAttrVal("BlpaypatoepAggDO",blpaypatoepAggDO);
	}

	
	
}
