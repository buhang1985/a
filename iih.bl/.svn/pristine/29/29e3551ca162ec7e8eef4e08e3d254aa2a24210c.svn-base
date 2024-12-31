package iih.bl.pay.s.bp.util;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.comm.util.BlUdidocIdSdConvertUtil;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.dto.blpayip.d.BlPayIpPmDTO;

/**
 * 收付款数据组装类
 * @author ly 2018/08/09
 *
 */
public class PayAssembleUtil {

	/**
	 * 组装住院收付款主DO数据
	 * @param stDO 结算DO
	 * @param sdPttp 终端类型
	 * @return
	 * @throws BizException
	 */
	public static BlPayPatIpDO assembleIpPayHeadData(BlStIpDO stDO,String sdPttp) throws BizException {
		
		BlPayPatIpDO payDO = new BlPayPatIpDO();
		payDO.setId_grp(Context.get().getGroupId());
		payDO.setId_org(Context.get().getOrgId());
		payDO.setId_stip(stDO.getId_stip());
		if(StTypeEnum.ST_INP.equals(stDO.getEu_sttp())){
			payDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);
			payDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);
		}else if(StTypeEnum.ST_INP_MIDWAY.equals(stDO.getEu_sttp())){
			payDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_MIDST);
			payDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_MIDST);
		}
		//payDO.setId_pecmpy(stDO.getId_pecmpy());
		payDO.setId_pat(stDO.getId_pat());
		payDO.setId_ent(stDO.getId_ent());
		payDO.setId_enttp(stDO.getId_enttp());
		payDO.setCode_entp(stDO.getCode_enttp());
		payDO.setId_pttp(BlUdidocIdSdConvertUtil.pttpSdTOId(sdPttp));
		payDO.setSd_pttp(sdPttp);
		payDO.setEu_direct(stDO.getEu_direct());
		payDO.setAmt(stDO.getAmt_ratio());
		payDO.setDt_pay(BlFlowContextUtil.getNowTime());
		payDO.setId_org_pay(Context.get().getOrgId());
		payDO.setId_dep_pay(Context.get().getDeptId());
		payDO.setId_emp_pay(Context.get().getStuffId());
		payDO.setFg_cc(FBoolean.FALSE);
		payDO.setNote(null);
		
		payDO.setStatus(DOStatus.NEW);
		return payDO;
	}

	
	/**
	 * 组装住院收付款明细DO数据
	 * @param payIpPmDto
	 * @return
	 * @throws BizException
	 */
	public static BlPayItmPatIpDO assembleIpPayDetailData(BlPayIpPmDTO payIpPmDto)throws BizException {
		
		BlPayItmPatIpDO payDetailDO = new BlPayItmPatIpDO();
		//payDetailDO.setId_grp(Context.get().getGroupId());
		payDetailDO.setId_org(Context.get().getOrgId());
		payDetailDO.setEu_direct(payIpPmDto.getEu_direct());
		payDetailDO.setFg_realpay(FBoolean.TRUE);
		//payDetailDO.setId_cust(payIpPmDto.getId_cust());
		payDetailDO.setId_pm(payIpPmDto.getId_pm());
		payDetailDO.setSd_pm(payIpPmDto.getSd_pm());
		payDetailDO.setAmt(payIpPmDto.getAmt());
		payDetailDO.setId_bank(payIpPmDto.getId_bank());
		payDetailDO.setBankno(payIpPmDto.getBankno());
		payDetailDO.setPaymodenode(payIpPmDto.getPaymodenode());
		payDetailDO.setId_paypat(payIpPmDto.getId_paypat());
		//payDetailDO.setFg_refund_manual(payIpPmDto.getFg_refund_manual());
		
		return payDetailDO;
	}
}
