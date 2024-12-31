package iih.bl.pay.listrener;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.comm.s.bp.BlSendWXPublicMsgBP;
import iih.bl.comm.util.BlAdivceConvertUtil;
import iih.bl.itf.std.bean.input.wxpublic.WsParamWxPublic;
import iih.bl.itf.std.bean.input.wxpublic.sub.WsParamWxPublicPatient;
import iih.bl.params.BlParams;
import iih.bl.params.BlSmsConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.bl.st.dto.blpayoep.d.BlPayOepEventDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.pi.reg.pat.d.PatDO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 预交金,收费,退费 微信公众号通知
 * 
 * @author zhangxin
 * @date 2019年11月7日
 */
public class BlPayPatAccWxPublicListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		BusinessUserObj bizUserObj = (BusinessUserObj) arg0.getUserObject();
		String blitf0004 = BlParams.BLITF0004();
		if (StringUtils.isEmpty(blitf0004)) {
			return;
		}
		
		try {
			// 如果是预交金充值或者退费
			if (IBlEventConst.EVENT_TYPE_PREPAY_REFUND.equals(arg0.getEventType())
					&& IBlEventConst.EVENT_SOURCE_PREPAY.equalsIgnoreCase(arg0.getSourceID())
					|| IBlEventConst.EVENT_TYPE_PREPAY_CHARGE.equals(arg0.getEventType())
							&& IBlEventConst.EVENT_SOURCE_PREPAY.equalsIgnoreCase(arg0.getSourceID())
							&& blitf0004.contains(BlSmsConst.BL_ACC_PREPAY)) {
				this.SendPrePayAdive(bizUserObj);
				// 如果是门诊退费
			} else if (IBlEventConst.EVENT_TYPE_OEP_REFUND.equals(arg0.getEventType())
					&& IBlEventConst.EVENT_SOURCE_OEP_REFUND.equals(arg0.getSourceID())
					&& blitf0004.contains(BlSmsConst.BL_OP_REFUND)) {
				this.SendOepRefundAdive(bizUserObj);
				// 如果是门诊收费
			} else if (IBlEventConst.EVENT_TYPE_OEP_CHARGE.equals(arg0.getEventType())
					&& IBlEventConst.EVENT_SOURCE_OEP_CHARGE.equals(arg0.getSourceID())
					&& blitf0004.contains(BlSmsConst.BL_OP_CHARGE)) {
				this.SendOepChargeAdive(bizUserObj);
			} else {
				return;
			}
		} catch (Exception e) {
			BLThirdItfLogger.error("  门诊收退费预交金公众号消息监听" + e.getMessage());
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
		// 发送消息
		SendAdive(blPayPatOepDO.getId_pat(),blPayPatOepDO.getId_enttp(),amt,blPayPatOepDO.getDt_pay(),
				null,BlSmsConst.BL_OP_REFUND_MSG,PayDirectEnum.CHARGE);
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
		//发生消息
		SendAdive(blPayPatOepDO.getId_pat(),blPayPatOepDO.getId_enttp(),amt,blPayPatOepDO.getDt_pay(),
				null,BlSmsConst.BL_OP_REFUND_MSG,PayDirectEnum.CHANGE);
	}

	/**
	 * 发生预交金短信通知
	 */
	private void SendPrePayAdive(BusinessUserObj arg0) throws BizException {
		BlPrePayPatDO blPrePatPatDo = (BlPrePayPatDO) arg0.getUserObj();
		// 发送消息
		SendAdive(blPrePatPatDo.getId_pat(), blPrePatPatDo.getId_enttp(),
				blPrePatPatDo.getAmt(), blPrePatPatDo.getDt_pay(), blPrePatPatDo.getId_ent(),
				BlSmsConst.BL_ACC_PREPAY_MSG, blPrePatPatDo.getEu_direct());
	}

	/**
	 * 发生消息
	 * 
	 * @param sendPreSmsDTO
	 * @throws BizException
	 */
	private void SendAdive(String id_pat, String id_enttp, FDouble amt, FDateTime dt_pay,
			String id_ent, String tempcode, int eu_direct) throws BizException {
		BlSendWXPublicMsgBP sendSmsBp = new BlSendWXPublicMsgBP();
		WsParamWxPublic setBlSendWxPublicDTO = sendSmsBp.setBlSendWxPublicDTO(id_pat, id_enttp, amt, dt_pay, id_ent, tempcode, eu_direct);
		sendSmsBp.exec(setBlSendWxPublicDTO);
	}

	/**
	 * 设置消息传输dto
	 * 
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public WsParamWxPublic setBlSendWxPublicDTO(String id_pat, String id_enttp, FDouble amt, FDateTime dt_pay,
			String id_ent, String tempcode, int eu_direct) throws BizException {
		WsParamWxPublic wxDto = new WsParamWxPublic();
		WsParamWxPublicPatient patient = new WsParamWxPublicPatient();
		// 获取患者信息
		PatDO patDo = BlAdivceConvertUtil.getPatData(id_pat);
		// 患者id
		patient.setId_pat(patDo.getId_pat());
		// 患者编码
		patient.setCodepat(patDo.getCode());
		// 患者姓名
		patient.setNamepat(patDo.getName());
		EnTypeDO enTypeDO =BlAdivceConvertUtil.getEntpDo(id_enttp);
		// // 如果是住院
		if (IEnDictCodeConst.SD_ENTP_INPATIENT.equals(enTypeDO.getCode()) && id_ent != null) {
			// 查询住院号
			IInpatientRService inpatint = ServiceFinder.find(IInpatientRService.class);
			InpatientDO[] inpatientDOs = inpatint.findByAttrValString(InpatientDO.ID_ENT, id_ent);
			if (!ArrayUtil.isEmpty(inpatientDOs)) {
				patient.setIpcode(inpatientDOs[0].getCode_amr_ip());
			}
		}
		patient.setTemplcode("blmsg");
		List<String> param = new ArrayList<>();

		if (BlSmsConst.BL_ACC_PREPAY_MSG.equals(tempcode)) {
			param.add(enTypeDO.getName() + "预交金");
		} else if (BlSmsConst.BL_OP_CHARGE_MSG.equals(tempcode)) {
			param.add("门诊收费");
		} else if (BlSmsConst.BL_OP_REFUND_MSG.equals(tempcode)) {
			param.add("门诊退费");
		}
		String eudirect = BlAdivceConvertUtil.getFeeEudirect(eu_direct);
		// 支付获取退费
		param.add(eudirect);
		// 金额
		param.add(amt.toString());
		// 时间
		param.add(dt_pay.toStdString());

		wxDto.setPatient(patient);
		wxDto.setInfo(param);
		return wxDto;
	}

}
