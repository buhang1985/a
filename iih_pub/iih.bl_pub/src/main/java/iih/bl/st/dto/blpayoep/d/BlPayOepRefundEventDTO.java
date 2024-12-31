package iih.bl.st.dto.blpayoep.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;

/**
 * 门诊退费事件数据模型（手工dto,无法进行前台传输）
 * @author ly 2018/12/17
 * 
 */
public class BlPayOepRefundEventDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	public static final String OLDCGDATA= "OldCgData";
	public static final String OLDSTDATA= "OldStData";
	public static final String OLDPAYDATA= "OldPayData";
	public static final String OLDINCDATA= "OldIncData";
	public static final String REDCGDATA= "RedCgData";
	public static final String REDSTDATA= "RedStData";
	public static final String REDPAYDATA= "RedPayData";
	public static final String REDINCDATA= "RedIncData";
	public static final String NEWCGDATA= "NewCgData";
	public static final String NEWSTDATA= "NewStData";
	public static final String NEWPAYDATA= "NewPayData";
	public static final String NEWINCDATA= "NewIncData";
	public static final String ORIGINSTDATA = "OriginStData";
	public static final String ORIGINPAYDATA = "OriginPayData";
	public static final String ACTUALREUNDCGDATA = "ActualRefundCgData";
	public static final String ACTUALREUNDCGAGGDATA = "ActualRefundCgAggData";
	
	/**
	 * 是否全退
	 * @return FBoolean
	 */
	public FBoolean getFg_allRefund() {
		return ((FBoolean) getAttrVal("Fg_allRefund"));
	}
	/**
	 * 是否全退
	 * @param Fg_allRefund
	 */
	public void setFg_allRefund(FBoolean Fg_allRefund) {
		setAttrVal("Fg_allRefund", Fg_allRefund);
	}
	
	/**
	 * 原记账数据
	 * @return
	 */
	public BlcgoepAggDO[] getOldCgData() {
		return (BlcgoepAggDO[]) getAttrVal(OLDCGDATA);
	}

	/**
	 * 原记账数据
	 * @param cgData
	 */
	public void setOldCgData(BlcgoepAggDO[] oldCgData) {
		setAttrVal(OLDCGDATA, oldCgData);
	}

	/**
	 * 原结算数据
	 * @return
	 */
	public BlStOepDO getOldStData() {
		return (BlStOepDO) getAttrVal(OLDSTDATA);
	}

	/**
	 * 原结算数据
	 * @param oldStData
	 */
	public void setOldStData(BlStOepDO oldStData) {
		setAttrVal(OLDSTDATA, oldStData);
	}

	/**
	 * 原收付款数据
	 * @return
	 */
	public BlpaypatoepAggDO getOldPayData() {
		return (BlpaypatoepAggDO) getAttrVal(OLDPAYDATA);
	}

	/**
	 * 原收付款数据
	 * @param oldPayData
	 */
	public void setOldPayData(BlpaypatoepAggDO oldPayData) {
		setAttrVal(OLDPAYDATA, oldPayData);
	}

	/**
	 * 原发票数据
	 * @return
	 */
	public BlincoepAggDO[] getOldIncData() {
		return (BlincoepAggDO[]) getAttrVal(OLDINCDATA);
	}

	/**
	 * 原发票数据
	 * @param oldIncData
	 */
	public void setOldIncData(BlincoepAggDO[] oldIncData) {
		setAttrVal(OLDINCDATA, oldIncData);
	}
	
	/**
	 * 红冲记账数据
	 * @return
	 */
	public BlcgoepAggDO[] getRedCgData() {
		return (BlcgoepAggDO[]) getAttrVal(REDCGDATA);
	}

	/**
	 * 红冲记账数据
	 * @param cgData
	 */
	public void setRedCgData(BlcgoepAggDO[] redCgData) {
		setAttrVal(REDCGDATA, redCgData);
	}

	/**
	 * 红冲结算数据
	 * @return
	 */
	public BlStOepDO getRedStData() {
		return (BlStOepDO) getAttrVal(REDSTDATA);
	}

	/**
	 * 红冲结算数据
	 * @param redStData
	 */
	public void setRedStData(BlStOepDO redStData) {
		setAttrVal(REDSTDATA, redStData);
	}

	/**
	 * 红冲收付款数据
	 * @return
	 */
	public BlpaypatoepAggDO getRedPayData() {
		return (BlpaypatoepAggDO) getAttrVal(REDPAYDATA);
	}

	/**
	 * 红冲收付款数据
	 * @param redPayData
	 */
	public void setRedPayData(BlpaypatoepAggDO redPayData) {
		setAttrVal(REDPAYDATA, redPayData);
	}

	/**
	 * 红冲发票数据
	 * @return
	 */
	public BlincoepAggDO[] getRedIncData() {
		return (BlincoepAggDO[]) getAttrVal(REDINCDATA);
	}

	/**
	 * 红冲发票数据
	 * @param redIncData
	 */
	public void setRedIncData(BlincoepAggDO[] redIncData) {
		setAttrVal(REDINCDATA, redIncData);
	}
	
	/**
	 * 新记账数据
	 * @return
	 */
	public BlcgoepAggDO[] getNewCgData() {
		return (BlcgoepAggDO[]) getAttrVal(NEWCGDATA);
	}

	/**
	 * 新记账数据
	 * @param cgData
	 */
	public void setNewCgData(BlcgoepAggDO[] oldCgData) {
		setAttrVal(NEWCGDATA, oldCgData);
	}

	/**
	 * 新结算数据
	 * @return
	 */
	public BlStOepDO getNewStData() {
		return (BlStOepDO) getAttrVal(NEWSTDATA);
	}

	/**
	 * 新结算数据
	 * @param oldStData
	 */
	public void setNewStData(BlStOepDO oldStData) {
		setAttrVal(NEWSTDATA, oldStData);
	}

	/**
	 * 新收付款数据
	 * @return
	 */
	public BlpaypatoepAggDO getNewPayData() {
		return (BlpaypatoepAggDO) getAttrVal(NEWPAYDATA);
	}

	/**
	 * 新收付款数据
	 * @param oldPayData
	 */
	public void setNewPayData(BlpaypatoepAggDO oldPayData) {
		setAttrVal(NEWPAYDATA, oldPayData);
	}

	/**
	 * 新发票数据
	 * @return
	 */
	public BlincoepAggDO[] getNewIncData() {
		return (BlincoepAggDO[]) getAttrVal(NEWINCDATA);
	}

	/**
	 * 新发票数据
	 * @param oldIncData
	 */
	public void setNewIncData(BlincoepAggDO[] oldIncData) {
		setAttrVal(NEWINCDATA, oldIncData);
	}
	
	/**
	 * 原始结算数据
	 * @return
	 */
	public BlStOepDO getOriginStData() {
		return (BlStOepDO) getAttrVal(ORIGINSTDATA);
	}

	/**
	 * 原始冲结算数据
	 * @param redStData
	 */
	public void setOriginStData(BlStOepDO redStData) {
		setAttrVal(ORIGINSTDATA, redStData);
	}

	/**
	 * 原始收付款数据
	 * @return
	 */
	public BlpaypatoepAggDO getOriginPayData() {
		return (BlpaypatoepAggDO) getAttrVal(ORIGINPAYDATA);
	}

	/**
	 * 原始收付款数据
	 * @param oldPayData
	 */
	public void setOriginPayData(BlpaypatoepAggDO oldPayData) {
		setAttrVal(ORIGINPAYDATA, oldPayData);
	}
	
	/**
	 * 真实退记账数据
	 * @param actualCgData
	 */
	public void setActualRefundCgData(BlCgItmOepDO[] actualCgData){
		setAttrVal(ACTUALREUNDCGDATA, actualCgData);
	}
	
	/**
	 * 真实退记账数据
	 * @return
	 */
	public BlCgItmOepDO[] getActualRefundCgData(){
		return (BlCgItmOepDO[]) getAttrVal(ACTUALREUNDCGDATA);
	}
	
	/**
	 * 真实退记账Agg数据
	 * @param actualCgData
	 */
	public void setActualRefundCgAggData(BlcgoepAggDO[] actualCgAggData){
		setAttrVal(ACTUALREUNDCGAGGDATA, actualCgAggData);
	}
	
	/**
	 * 真实退记账Agg数据
	 * @return
	 */
	public BlcgoepAggDO[] getActualRefundCgAggData(){
		return (BlcgoepAggDO[]) getAttrVal(ACTUALREUNDCGAGGDATA);
	}
}
