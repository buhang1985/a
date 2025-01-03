package iih.bl.pay.listrener;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.comm.thirdpayapi.BlThirdPayValidateUtil;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.itf.dto.thirdpayvalidate.d.BlThirdPayValidateRltDTO;
import iih.bl.itf.payplatform.d.BlOrdReqDTO;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import iih.bl.itf.trdtrans.d.TransStateEnum;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.pmp.pay.ordreqdto.d.CmbcSceneEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 预交金 退费 第三方支付监听
 * 
 * @author zhangxin
 * @date 2019年3月4日
 */
public class BlPayPatThirdRefundLinstener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		// 验证事件
		this.validate(arg0);
		// 退预交金
		this.RefundPrePat(arg0);

	}

	/**
	 * 退预交金
	 * 
	 * @param arg0
	 * @throws BizException
	 */
	private void RefundPrePat(IBusinessEvent event) throws BizException {
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		BlPrePayPatDO blPrePatPatDo = (BlPrePayPatDO) bizUserObj.getUserObj();
		// 根据id_par 查询原预交金记录
		BlPrePayPatDO oldPrePayDo = this.getOldPrePayDo(blPrePatPatDo.getId_par());
		if (oldPrePayDo == null) {
			return;
		}
		// 只退在收费窗口 收费的预交金
		if (!IBlDictCodeConst.SD_PTTP_WINDOW.equals(oldPrePayDo.getSd_pttp()) && 
				!IBlDictCodeConst.SD_PTTP_BEDSIDE.equals(oldPrePayDo.getSd_pttp())) {
			return;
		}
		String sd_bizsence = null;
		// 判断业务场景
		// 住院类型 住院预交金
		if (IEnDictCodeConst.SD_ENTP_INPATIENT.equals(blPrePatPatDo.getCode_enttp()) || 
				IEnDictCodeConst.SD_ENTP_IPPRE.equals(blPrePatPatDo.getCode_enttp())
				) {
			sd_bizsence = IBlDictCodeConst.SD_BIZSCENE_IP_REFUND;
			// 门诊类型 门诊预交金
		} else {
			sd_bizsence = IBlDictCodeConst.SD_BIZSCENE_OEP_PRE;
		}
		List<String> listPm = new ArrayList<String>();
		listPm.add(blPrePatPatDo.getId_pm());

		// 校验是否支付方式
		BlThirdPayValidateRltDTO dto = BlThirdPayValidateUtil.validate(listPm.toArray(new String[0]), sd_bizsence);
		
		boolean thirdFefund = BlThirdPayBP.isThirdFefund(blPrePatPatDo.getId_pm());
		//添加手工转账的不处理
		if (!thirdFefund||FBoolean.TRUE.equals(blPrePatPatDo.getFg_refund_manual())) {
			// 校验不通过 不符合第三方注册节点维护 不处理
			return;
		}
		if (FBoolean.TRUE.equals(dto.getFg_success()) && !StringUtils.isEmpty(dto.getId_pm())) {
			// 退费
			// 1.组织退费入参
			BlOrdReqDTO blOrdReqDTO = this.setRefundOrdReqDTO(blPrePatPatDo, sd_bizsence, dto.getSd_paychannel(),
					oldPrePayDo,dto.getTradetype());
			BlThirdPayBP blThirdPayBP = new BlThirdPayBP();
			// 2.先保存退费两个日志信息
			BlThirdTransRcdDO blThirdTransRcdDO = blThirdPayBP.setThirdPayDTO(blOrdReqDTO, null, TransStateEnum.UNFAIL);
			String id_transrcd = blThirdPayBP.saveThirdTradeLog(blThirdTransRcdDO);

			if (FBoolean.TRUE.equals(BlParams.BLPAY001())) {
				BlThirdPayBP BlThirdPayBP = new BlThirdPayBP();
				BlThirdPayBP.execRefund(blOrdReqDTO, id_transrcd);
			}
		}

	}

	/**
	 * 组织在线支付退费入参
	 * 
	 * @param blPrePatPatDo
	 * @param sd_bizsence
	 * @param string
	 * @return
	 * @throws BizException
	 */
	private BlOrdReqDTO setRefundOrdReqDTO(BlPrePayPatDO blPrePatPatDo, String sd_bizsence, String sd_channel,
			BlPrePayPatDO oldPrePat,String trade_type) throws BizException {
		BlOrdReqDTO blOrdReqDTO = new BlOrdReqDTO();
		blOrdReqDTO.setOrd_no(oldPrePat.getPaymodenode());// 原收费订单号
		blOrdReqDTO.setRefund_req_no(BlCodeUtils.generateThirdOrdNo());
		//
		String subject = "预交金退费";
		if (sd_bizsence.equals(IBlDictCodeConst.SD_BIZSCENE_IP_REFUND)) {
			subject = "住院预交金退费";
		} else if (sd_bizsence.equals(IBlDictCodeConst.SD_BIZSCENE_OEP_PRE)) {
			subject = "门诊预交金退费";
		}
		blOrdReqDTO.setSubject(subject + blPrePatPatDo.getAmt() + "元");
		blOrdReqDTO.setAmt(blPrePatPatDo.getAmt());
		blOrdReqDTO.setEu_direct(BookRtnDirectEnum.REFUND);
		String id_emp_pay = oldPrePat.getId_emp_pay();
		blOrdReqDTO.setId_psndoc(StringUtils.isEmpty(id_emp_pay) ? "" : id_emp_pay);
		if(!StringUtils.isEmpty(trade_type)){
			blOrdReqDTO.setTradetype(trade_type);
		}else{
			blOrdReqDTO.setTradetype(IBdPripmCodeConst.ID_PRI_PM_ALIPAY.equals(blPrePatPatDo.getId_pm())
					? CmbcSceneEnum.ZFBSCAN : CmbcSceneEnum.WXSCAN);
		}
		blOrdReqDTO.setCode_enttp(blPrePatPatDo.getCode_enttp());
		blOrdReqDTO.setFg_refund(FBoolean.TRUE);
		blOrdReqDTO.setId_pm(blPrePatPatDo.getId_pm());
		blOrdReqDTO.setId_pat(blPrePatPatDo.getId_pat());
		blOrdReqDTO.setId_ent((StringUtils.isEmpty(blPrePatPatDo.getId_ent()) ? "" : blPrePatPatDo.getId_ent()));
		blOrdReqDTO.setId_st("");
		blOrdReqDTO.setId_pay(blPrePatPatDo.getId_paypat());
		// 添加支付场景id zx 2019年3月18日
		blOrdReqDTO.setId_bizscene(IBlDictCodeConst.SD_BIZSCENE_IP_REFUND.equals(sd_bizsence)
				? IBlDictCodeConst.ID_BIZSCENE_IP_REFUND : IBlDictCodeConst.ID_BIZSCENE_OEP_PRE);
		blOrdReqDTO.setSd_bizscene(sd_bizsence);
		blOrdReqDTO.setSd_chl(sd_channel);
		return blOrdReqDTO;
	}

	/**
	 * 查询原预交金数据
	 * 
	 * @param id_par
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO getOldPrePayDo(String id_par) throws BizException {

		IBlpaypatRService serivce = ServiceFinder.find(IBlpaypatRService.class);
		if (!StringUtil.isEmpty(id_par)) {
			return serivce.findById(id_par);
		}
		return null;
	}

	/**
	 * 验证事件
	 * 
	 * @param event
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IBlEventConst.EVENT_SOURCE_PREPAY.equalsIgnoreCase(event.getSourceID())
				|| !IBlEventConst.EVENT_TYPE_PREPAY_REFUND.equals(event.getEventType())) {
			throw new BizException(IBlMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}
}
