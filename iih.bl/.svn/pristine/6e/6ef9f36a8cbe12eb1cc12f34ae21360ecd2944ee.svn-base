package iih.bl.st.s.bp.oepcharge.util;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.comm.util.BlUdidocIdSdConvertUtil;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundSetDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊收费数据组装类
 * @author ly 2018/12/08
 *
 */
public class BlOepChargeDataUtil {

	/**
	 * 组装门诊收费收付款主数据
	 * @param payoepDto
	 * @param sdPttp
	 * @return
	 */
	public static BlPayPatOepDO buildPayHeadData(BlStOepDO stDO, String sdPttp){
		
		BlPayPatOepDO payDO = new BlPayPatOepDO();
		payDO.setId_grp(Context.get().getGroupId());
		payDO.setId_org(Context.get().getOrgId());
		payDO.setId_enttp(stDO.getId_enttp());
		payDO.setCode_enttp(stDO.getCode_enttp());
		payDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);
		payDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);
		payDO.setId_pat(stDO.getId_pat());
		payDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		payDO.setAmt(stDO.getAmt_ratio());
		payDO.setDt_pay(BlFlowContextUtil.getNowTime());
		payDO.setId_org_pay(Context.get().getOrgId());
		payDO.setId_dep_pay(Context.get().getDeptId());
		payDO.setId_emp_pay(Context.get().getStuffId());
		payDO.setFg_cc(FBoolean.FALSE);
		payDO.setId_cc(null);
		payDO.setId_pttp(BlUdidocIdSdConvertUtil.pttpSdTOId(sdPttp));
		payDO.setSd_pttp(sdPttp);
		payDO.setPecode(stDO.getPecode());
		payDO.setStatus(DOStatus.NEW);
		return payDO;
	}
	
	/**
	 * 组装门诊收费收付款明细数据
	 * @param pmDto
	 * @return
	 */
	public static BlPayItmPatOepDO buildPayItmData(BlPayOepPmDTO pmDto){
		
		BlPayItmPatOepDO payItmDO = new BlPayItmPatOepDO();
		payItmDO.setId_grp(Context.get().getGroupId());
		payItmDO.setId_org(Context.get().getOrgId());
		payItmDO.setEu_direct(pmDto.getEu_direct());
		payItmDO.setFg_realpay(FBoolean.TRUE);
		payItmDO.setId_cust(pmDto.getId_cust());
		payItmDO.setId_pm(pmDto.getId_pm());
		payItmDO.setSd_pm(pmDto.getSd_pm());
		payItmDO.setAmt(pmDto.getAmt());
		payItmDO.setId_bank(pmDto.getId_bank());
		payItmDO.setBankno(pmDto.getBankno());
		payItmDO.setPaymodenode(pmDto.getPaymodenode());
		payItmDO.setBankcardno(pmDto.getBankcardno());
		payItmDO.setId_paypat(pmDto.getId_paypat());
		payItmDO.setStatus(DOStatus.NEW);
		return payItmDO;
	}

	/**
	 * 组装红冲记账数据
	 * @param oldCgAggDO
	 * @param stId
	 * @return
	 */
	public static BlcgoepAggDO buildRedCgData(BlcgoepAggDO oldCgAggDO, String stId){
		
		BlcgoepAggDO redAggDO  = new BlcgoepAggDO();
		BlCgOepDO redCgDO = (BlCgOepDO)oldCgAggDO.getParentDO().clone();
		redCgDO.setId_cgoep(null);
		redCgDO.setCode_cg(null);
		redCgDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		redCgDO.setDt_cg(BlFlowContextUtil.getNowTime());
		redCgDO.setId_emp_cg(Context.get().getStuffId());
		redCgDO.setId_dep_cg(Context.get().getDeptId());
		redCgDO.setStatus(DOStatus.NEW);
		redAggDO.setParentDO(redCgDO);
		
		List<BlCgItmOepDO> cgItmList = new ArrayList<BlCgItmOepDO>();
		for (BlCgItmOepDO cgItmDO : oldCgAggDO.getBlCgItmOepDO()) {
			
			BlCgItmOepDO redCgItmDO = (BlCgItmOepDO)cgItmDO.clone();
			redCgItmDO.setId_cgoep(null);
			redCgItmDO.setId_cgitmoep(null);
			redCgItmDO.setId_par(cgItmDO.getId_cgitmoep());
			redCgItmDO.setFg_st(FBoolean.TRUE);
			redCgItmDO.setId_stoep(stId);
			redCgItmDO.setDt_st(BlFlowContextUtil.getNowTime());
			redCgItmDO.setNote(String.format("退费，对象：【%s】", cgItmDO.getId_cgitmoep()));
			redCgItmDO.setSrcfunc_des(IBlCgFuncConst.FUNC_OPBL_OPFEECOLLECT);
			redCgItmDO.setEu_direct(BookRtnDirectEnum.RETURNS);
			redCgItmDO.setDt_cg(BlFlowContextUtil.getNowTime());
			redCgItmDO.setId_root(StringUtil.isEmpty(cgItmDO.getId_root()) ? cgItmDO.getId_cgitmoep() : cgItmDO.getId_root());
			redCgItmDO.setStatus(DOStatus.NEW);
			
			cgItmList.add(redCgItmDO);
		}
		redAggDO.setBlCgItmOepDO(cgItmList.toArray(new BlCgItmOepDO[0]));
		return redAggDO;
	}
	
	/**
	 * 组装红冲结算数据
	 * @param oldStDO
	 * @param stId
	 * @param refundSet 退费信息
	 * @return
	 */
	public static BlStOepDO buildRedStDataWithRefundSet(BlStOepDO oldStDO, String stId, String payId,BlOepRefundSetDTO refundSet) throws BizException{
		
		BlStOepDO redStDO = getRedStData(oldStDO, stId, payId);
		if (refundSet != null) {
			redStDO.setId_reason_canc(refundSet.getId_reason_canc());
			redStDO.setSd_reason_cand(refundSet.getSd_reason_cand());
			redStDO.setDes_reason_canc(refundSet.getDes_reason_canc());
		}
		
		redStDO.setStatus(DOStatus.NEW);
		
		return redStDO;
	}
	
	/**
	 * 组装红冲结算数据
	 * @param oldStDO
	 * @param stId
	 * @return
	 */
	public static BlStOepDO buildRedStData(BlStOepDO oldStDO, String stId, String payId) throws BizException{
		
		BlStOepDO redStDO = getRedStData(oldStDO, stId, payId);
		redStDO.setStatus(DOStatus.NEW);
		
		return redStDO;
	}
	
	/**
	 * 组装红冲结算数据
	 * @param oldStDO
	 * @param stId
	 * @return
	 */
	private static BlStOepDO getRedStData(BlStOepDO oldStDO, String stId, String payId)throws BizException
	{
		BlStOepDO redStDO = (BlStOepDO)oldStDO.clone();
		redStDO.setId_stoep(stId);
		redStDO.setCode_st(BlCodeUtils.generateOepStCode());
		redStDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		redStDO.setEu_sttp(StTypeEnum.ST_OEP_MIDWAY);
		redStDO.setDt_st(BlFlowContextUtil.getNowTime());
		redStDO.setId_dep_st(Context.get().getDeptId());
		redStDO.setId_emp_st(Context.get().getStuffId());
		redStDO.setFg_cc(FBoolean.FALSE);
		redStDO.setId_cc(null);
		redStDO.setFg_canc(FBoolean.FALSE);
		redStDO.setId_par(oldStDO.getId_stoep());
		redStDO.setId_paypatoep(payId);
		if(StringUtil.isEmpty(oldStDO.getId_rootst())){
			redStDO.setId_rootst(oldStDO.getId_stoep());
		}else{
			redStDO.setId_rootst(oldStDO.getId_rootst());
		}
		
		return redStDO;
	}

	/**
	 * 组装红冲收付款主表数据
	 * @param oldPayDO
	 * @param pttpSd
	 * @param payId
	 * @return
	 */
	public static BlPayPatOepDO buildRedPayHeadData(BlPayPatOepDO oldPayDO, String pttpSd, String payId){
		
		BlPayPatOepDO redPayDO = new BlPayPatOepDO();
		redPayDO.setId_paypatoep(payId);
		redPayDO.setId_org(Context.get().getOrgId());
		redPayDO.setId_grp(Context.get().getGroupId());
		redPayDO.setId_enttp(oldPayDO.getId_enttp());
		redPayDO.setCode_enttp(oldPayDO.getCode_enttp());
		redPayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_STRED);
		redPayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_STRED);
		redPayDO.setId_pat(oldPayDO.getId_pat());
		redPayDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		redPayDO.setAmt(oldPayDO.getAmt());
		redPayDO.setDt_pay(BlFlowContextUtil.getNowTime());
		redPayDO.setId_org_pay(Context.get().getOrgId());
		redPayDO.setId_dep_pay(Context.get().getDeptId());
		redPayDO.setId_emp_pay(Context.get().getStuffId());
		redPayDO.setFg_cc(FBoolean.FALSE);
		redPayDO.setId_cc(null);
		redPayDO.setId_pttp(BlUdidocIdSdConvertUtil.pttpSdTOId(pttpSd));
		redPayDO.setSd_pttp(pttpSd);
		redPayDO.setPecode(oldPayDO.getPecode());
		redPayDO.setStatus(DOStatus.NEW);
		
		return redPayDO;
	}
	
	/**
	 * 组装红冲分摊数据
	 * @param redStId
	 * @return
	 */
	public static BlPropOepDO buildRedPropData(String redStId){
		
		BlPropOepDO redPropDO = new BlPropOepDO();
		redPropDO.setId_grp(Context.get().getGroupId());
		redPropDO.setId_org(Context.get().getOrgId());
		redPropDO.setDt_prop(BlFlowContextUtil.getNowTime());
		redPropDO.setFg_active(FBoolean.TRUE);
		redPropDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		redPropDO.setId_stoep(redStId);
		redPropDO.setStatus(DOStatus.NEW);
		return redPropDO;
	}
	
	/**
	 * 组装红冲应该收据
	 * @param oldPropArDO
	 * @param redPropId
	 * @param busiCode
	 * @return
	 */
	public static BlPropArOepDO buildRedPropArData(BlPropArOepDO oldPropArDO, String redPropId,String busiCode){
		
		BlPropArOepDO redPropArDO = (BlPropArOepDO)oldPropArDO.clone();
		redPropArDO.setId_proparoep(null);
		redPropArDO.setId_propoep(redPropId);
		redPropArDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		redPropArDO.setCode_business(busiCode);
		redPropArDO.setStatus(DOStatus.NEW);
		return redPropArDO;
	}
	
	/**
	 * 组装全退红冲收付款数据
	 * @param oldPayAggDO
	 * @param pttpSd
	 * @param payId
	 * @return
	 * @throws BizException
	 */
	public static BlpaypatoepAggDO buildAllRefundRedPayData(BlpaypatoepAggDO oldPayAggDO, String pttpSd, String payId) {
		
		BlPayPatOepDO oldPayDO = oldPayAggDO.getParentDO();
		BlpaypatoepAggDO redPayAggDO = new BlpaypatoepAggDO();
		
		BlPayPatOepDO redPayDO = buildRedPayHeadData(oldPayDO, pttpSd, payId);
		
		BlPayItmPatOepDO[] redPayItmDos = new BlPayItmPatOepDO[oldPayAggDO.getBlPayItmPatOepDO().length];
		for (int i = 0; i < oldPayAggDO.getBlPayItmPatOepDO().length; i++) {
			BlPayItmPatOepDO oldPayItmDO = oldPayAggDO.getBlPayItmPatOepDO()[i];
			BlPayItmPatOepDO redPayItmDO = (BlPayItmPatOepDO)oldPayItmDO.clone();
			redPayItmDO.setId_payitmpatoep(null);
			redPayItmDO.setId_paypatoep(payId);
			redPayItmDO.setId_paypat(null);
			redPayItmDO.setEu_direct(oldPayItmDO.getEu_direct() * -1);
			redPayItmDO.setFg_realpay(FBoolean.FALSE);
			redPayItmDO.setStatus(DOStatus.NEW);
			redPayItmDos[i] = redPayItmDO;
		}
		
		redPayAggDO.setParentDO(redPayDO);
		redPayAggDO.setBlPayItmPatOepDO(redPayItmDos);
		
		return redPayAggDO;
	}

	/**
	 * 组装门诊收费分摊数据
	 * @param propId
	 * @param stDO
	 * @return
	 */
	public static BlPropOepDO buildPropOepData(String propId, BlStOepDO stDO){
		BlPropOepDO propDO = new BlPropOepDO();
		propDO.setId_propoep(propId);
		propDO.setId_grp(Context.get().getGroupId());
		propDO.setId_org(Context.get().getOrgId());
		propDO.setDt_prop(BlFlowContextUtil.getNowTime());
		propDO.setFg_active(FBoolean.TRUE);
		propDO.setEu_direct(stDO.getEu_direct());
		propDO.setId_stoep(stDO.getId_stoep());
		propDO.setStatus(DOStatus.NEW);
		return propDO;
	}
	
	/**
	 * 组装门诊收费应收数据
	 * @param propId
	 * @param stDO
	 * @param payoepDto
	 * @return
	 */
	public static BlPropArOepDO buildPropArOepData(String propId, BlStOepDO stDO, BlPayOepDTO payoepDto){
		BlPropArOepDO propArDO = new BlPropArOepDO();
		propArDO.setId_grp(Context.get().getGroupId());
		propArDO.setId_org(Context.get().getOrgId());
		propArDO.setId_propoep(propId);
		propArDO.setId_hp(payoepDto.getId_hp());
		propArDO.setEu_direct(stDO.getEu_direct());
		propArDO.setAmt_all(stDO.getAmt_ratio());
		propArDO.setAmt_hp(payoepDto.getAmt_hp());
		propArDO.setAmt_psnacc(payoepDto.getAmt_psnacc());
		propArDO.setAmt_cash(payoepDto.getAmt_cash());
		propArDO.setAmt_hosbear(payoepDto.getAmt_hosbear());
		propArDO.setFg_clear(FBoolean.TRUE);
		propArDO.setCode_business(payoepDto.getCode_business());
		propArDO.setStatus(DOStatus.NEW);
		return propArDO;
	}
	
	/**
	 * 设置结算类型
	 * @param itmList
	 * @return 
	 */
	public static String getStType(BlCgItmOepDO[] cgItmDos){
		
		for (BlCgItmOepDO itm : cgItmDos) {

			if (FeeOriginEnum.ORDERS_FEE.equals(itm.getEu_srctp())
					|| FeeOriginEnum.PATREGISTER_FEE.equals(itm.getEu_srctp())
					|| FeeOriginEnum.THIRDPE_FEE.equals(itm.getEu_srctp())
					|| FeeOriginEnum.BL_FEE.equals(itm.getEu_srctp())) {
				return StTypeEnum.ST_OEP_CHARGE;
			}
		}

		return StTypeEnum.ST_OEP_REG;
	}

}
