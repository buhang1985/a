package iih.bl.pay.listrener;

import java.math.BigDecimal;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.comm.s.bp.BlSendSmsMsgBP;
import iih.bl.comm.util.BlAdivceConvertUtil;
import iih.bl.itf.dto.blsendsmsdto.d.BlSendSmsDTO;
import iih.bl.params.BlParams;
import iih.bl.params.BlSmsConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.bp.qry.GetEnAccountDOBp;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.bl.st.dto.blpayoep.d.BlPayOepEventDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import iih.pi.reg.pat.d.PatDO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 预交金扣费短信通知
 * 
 * @author zhangxin
 * @date 2019年8月1日
 */
public class BlPayPatAccSmsListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		BusinessUserObj bizUserObj = (BusinessUserObj) arg0.getUserObject();
		String blitf0003 = BlParams.BLITF0003();
		if (StringUtils.isEmpty(blitf0003)) {
			return;
		}
		try {
			// 如果是预交金充值或者退费
			if (IBlEventConst.EVENT_TYPE_PREPAY_REFUND.equals(arg0.getEventType())
					&& IBlEventConst.EVENT_SOURCE_PREPAY.equalsIgnoreCase(arg0.getSourceID())
					|| IBlEventConst.EVENT_TYPE_PREPAY_CHARGE.equals(arg0.getEventType())
							&& IBlEventConst.EVENT_SOURCE_PREPAY.equalsIgnoreCase(arg0.getSourceID())
							&& blitf0003.contains(BlSmsConst.BL_ACC_PREPAY)) {
				this.SendPrePayAdive(bizUserObj);
				// 如果是门诊退费
			} else if (IBlEventConst.EVENT_TYPE_OEP_REFUND.equals(arg0.getEventType())
					&& IBlEventConst.EVENT_SOURCE_OEP_REFUND.equals(arg0.getSourceID())
					&& blitf0003.contains(BlSmsConst.BL_OP_REFUND)) {
				this.SendOepRefundAdive(bizUserObj);
				// 如果是门诊收费
			} else if (IBlEventConst.EVENT_TYPE_OEP_CHARGE.equals(arg0.getEventType())
					&& IBlEventConst.EVENT_SOURCE_OEP_CHARGE.equals(arg0.getSourceID())
					&& blitf0003.contains(BlSmsConst.BL_OP_CHARGE)) {
				this.SendOepChargeAdive(bizUserObj);
			} else {
				return;
			}
		} catch (Exception e) {
			BLThirdItfLogger.error("  门诊收退费预交金短信监听" + e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * 如果是门诊收费
	 * 
	 * @param bizUserObj
	 * @throws BizException
	 */
	private void SendOepChargeAdive(BusinessUserObj bizUserObj) throws BizException {
		BlPayOepEventDTO eventSourceDTO = (BlPayOepEventDTO) bizUserObj.getUserObj();
		BlpaypatoepAggDO blpaypatoepAggDO = eventSourceDTO.getPayData();
		BlPayPatOepDO blPayPatOepDO = blpaypatoepAggDO.getParentDO();
		//计算退费金额
		FDouble amt = BlAdivceConvertUtil.getOepPayRealyAmt( blpaypatoepAggDO.getBlPayItmPatOepDO(), PayDirectEnum.CHARGE);
		//组装短信dto
		this.setBlSendPreSmsDTO(blPayPatOepDO.getId_pat(), blPayPatOepDO.getId_enttp(),
				 amt, blPayPatOepDO.getDt_pay(), null, null,blPayPatOepDO.getEu_direct(),BlSmsConst.BL_OP_CHARGE_MSG);
	}

	/**
	 * 如果是门诊退费
	 * 
	 * @param arg0
	 * @throws BizException
	 */
	private void SendOepRefundAdive(BusinessUserObj arg0) throws BizException {
		BlPayOepRefundEventDTO eventSourceDTO = (BlPayOepRefundEventDTO) arg0.getUserObj();
		// 付款信息
		BlpaypatoepAggDO blpaypatoepAggDO = new BlpaypatoepAggDO();
		if (eventSourceDTO.getFg_allRefund().booleanValue()) {
			// 全退 去red
			blpaypatoepAggDO = eventSourceDTO.getRedPayData();
		} else {
			// 不全退 取 new
			blpaypatoepAggDO = eventSourceDTO.getNewPayData();
		}
		
		BlPayPatOepDO blPayPatOepDO = blpaypatoepAggDO.getParentDO();
		//计算退费金额
		FDouble amt = BlAdivceConvertUtil.getOepPayRealyAmt( blpaypatoepAggDO.getBlPayItmPatOepDO(), PayDirectEnum.CHANGE);
		//组装短信dto
		this.setBlSendPreSmsDTO(blPayPatOepDO.getId_pat(), blPayPatOepDO.getId_enttp(),
				 amt, blPayPatOepDO.getDt_pay(), null, null,blPayPatOepDO.getEu_direct(), BlSmsConst.BL_OP_REFUND_MSG);
	}

	/**
	 * 发生预交金短信通知
	 */
	private void SendPrePayAdive(BusinessUserObj arg0) throws BizException {
		BlPrePayPatDO blPrePatPatDo = (BlPrePayPatDO) arg0.getUserObj();
		//组装短信dto
		this.setBlSendPreSmsDTO(blPrePatPatDo.getId_pat(), blPrePatPatDo.getId_enttp(),
				 blPrePatPatDo.getAmt(), blPrePatPatDo.getDt_pay(), blPrePatPatDo.getId_ent(),
				blPrePatPatDo.getId_pm(),blPrePatPatDo.getEu_direct(),BlSmsConst.BL_ACC_PREPAY_MSG);
	}

	

	/**
	 * 设置消息传输dto
	 * 
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public void setBlSendPreSmsDTO(String id_pat, String id_enttp, FDouble amt,
			FDateTime dt_pay, String id_ent, String id_pm,int eu_direct,String code) throws BizException {
		BlSendSmsDTO smsDto = new BlSendSmsDTO();
		smsDto.setName_org(BlAdivceConvertUtil.getOrgName(Context.get().getOrgId()));
		// 获取患者信息
		PatDO patDo = BlAdivceConvertUtil.getPatData(id_pat);
		// 患者姓名
		smsDto.setName_pat(patDo.getName());
		EnTypeDO enTypeDO = BlAdivceConvertUtil.getEntpDo(id_enttp);
		// 场景
		smsDto.setScene_type(enTypeDO.getName()+BlAdivceConvertUtil.getFeeEudirect(eu_direct) );
		// 金额
		smsDto.setAmt(amt);
		// 时间
		smsDto.setDt_pay(dt_pay);
		// 支付方式名称
		smsDto.setName_pm(BlAdivceConvertUtil.getPmName(id_pm));
		// 如果是住院
		if (IEnDictCodeConst.SD_ENTP_INPATIENT.equals(enTypeDO.getCode()) && id_ent != null) {
			GetEnAccountDOBp bp = new GetEnAccountDOBp();
			EnAccountDO enAccountDO = bp.execQryEnAccountDOByIdentidpat(id_ent, id_pat);
			smsDto.setAccamt(
					enAccountDO.getAmt_prepay().sub(enAccountDO.getAmt_uncg().setScale(-2, BigDecimal.ROUND_HALF_UP)));

			// 如果是门诊
		} else if (IEnDictCodeConst.SD_ENTP_OUTPATIENT.equals(enTypeDO.getCode())) {
			// 预交金余额
			IPatAccServiceExt acc = ServiceFinder.find(IPatAccServiceExt.class);
			PatRelAmountInfoDTO patRelAmountInfo = acc.GetPatRelAmountInfo(id_pat);
			FDouble prepayAmount = patRelAmountInfo.getPrepay().sub(patRelAmountInfo.getAcc_lock()).setScale(-2,
					BigDecimal.ROUND_HALF_UP);
			smsDto.setAccamt(prepayAmount);
		}
		BlSendSmsMsgBP sendSmsBp = new BlSendSmsMsgBP();
		sendSmsBp.exec(patDo.getMob(), code, smsDto);
	}

}
