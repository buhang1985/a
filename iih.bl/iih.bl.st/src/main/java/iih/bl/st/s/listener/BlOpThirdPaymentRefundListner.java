package iih.bl.st.s.listener;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.itf.custom.IBlThirdPaymentRefundService;
import iih.bl.itf.custom.thirdpay.d.BlThirdPayRefundDTO;
import iih.bl.itf.custom.thirdpay.d.BlThirdPayReturnDTO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.bl.st.i.listener.IBlOpThirdPaymentRefundListner;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.appfw.businessevent.IBusinessEvent;

/**
 * 
 * 第三方支付门诊退费监听
 * 
 * @author ly 2019/04/12
 *
 */
public class BlOpThirdPaymentRefundListner implements IBlOpThirdPaymentRefundListner {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		// 验证事件
		if (!IBlEventConst.EVENT_SOURCE_OEP_REFUND.equalsIgnoreCase(arg0.getSourceID())
				|| !IBlEventConst.EVENT_TYPE_OEP_REFUND.equals(arg0.getEventType())) {
			return;
		}
		// 退费
		this.RefundAmt(arg0);
	}

	/**
	 * 调用公司支付平台退费
	 * 
	 * @param arg0
	 * @throws BizException
	 */
	private void RefundAmt(IBusinessEvent arg0) throws BizException {

		// 转化为 退费所用dto
		BusinessUserObj bizUserObj = (BusinessUserObj) arg0.getUserObject();
		BlPayOepRefundEventDTO eventSourceDTO = (BlPayOepRefundEventDTO) bizUserObj.getUserObj();

		// 原始收付款数据
		BlpaypatoepAggDO originPayData = eventSourceDTO.getOriginPayData();
		// 如果是窗口支付，则return
		if (IBlDictCodeConst.SD_PTTP_WINDOW.equals(originPayData.getParentDO().getSd_pttp())
				|| IBlDictCodeConst.SD_PTTP_ROOM.equals(originPayData.getParentDO().getSd_pttp())) {
			return;
		}
		BlStOepDO StData = eventSourceDTO.getOriginStData();
		// 判断是否是全退
		BlpaypatoepAggDO PayData = new BlpaypatoepAggDO();
		if (eventSourceDTO.getFg_allRefund().booleanValue()) {
			// 全退 去red
			PayData = eventSourceDTO.getRedPayData();
		} else {
			// 不全退 取 new
			PayData = eventSourceDTO.getNewPayData();
		}

		// 全退时获得红冲数据，半退时获得重收的真实退费数据
		// 判断交易场景
		String sd_biz = null;
		if (StData.getEu_sttp().equals(StTypeEnum.ST_REGISTER_RED)) {
			// 门诊挂号退费
			sd_biz = IBlDictCodeConst.SD_BIZSCENE_OEP_REENT;
		} else if (StringUtils.isNotEmpty(StData.getPecode())) {
			// 体检退费
			sd_biz = IBlDictCodeConst.SD_BIZSCENE_PE_REFUND;
		} else {
			// 门诊退费
			sd_biz = IBlDictCodeConst.SD_BIZSCENE_OEP_REFUND;
		}
		// 现 退费数据
		BlPayItmPatOepDO payItmPatOepDO = BlThirdPayBP.validateNew(PayData.getBlPayItmPatOepDO(), sd_biz,
				PayDirectEnum.CHANGE);
		// 原收款 数据 支付方式
		BlPayItmPatOepDO oldItmPatOepDO = BlThirdPayBP.validateNew(originPayData.getBlPayItmPatOepDO(), sd_biz,
				PayDirectEnum.CHARGE);
		
		// 不 满足第三方交易接口注册 不需要调用客开处理
		if (payItmPatOepDO == null || oldItmPatOepDO == null) {
			return;
		}
		boolean thirdFefund = BlThirdPayBP.isThirdFefund(payItmPatOepDO.getId_pm());
		if (!thirdFefund) {
			// 校验不通过 不符合第三方注册节点维护 不处理
			return;
		}
		// 组装退费数据
		BlThirdPayRefundDTO refundDto = new BlThirdPayRefundDTO();
		// 患者编码
		refundDto.setPatcode(originPayData.getParentDO().getPatcode());
		// 商户订单号(原始收付款子表中订单号)
		refundDto.setTradeno(oldItmPatOepDO.getPaymodenode());
		// 商户退款订单号
		refundDto.setRefundtradeno(BlCodeUtils.generateThirdOrdNo());
		// 订单总金额(原始收付款主表中金额)
		refundDto.setTotalfee(originPayData.getParentDO().getAmt().toString());
		// 退费金额(重收收付款明细表里的真实退费数据)
		refundDto.setRefundfee(payItmPatOepDO.getAmt() == null ? "0" : payItmPatOepDO.getAmt().toString());
		// 付款终端类型
		refundDto.setSdpttp(originPayData.getParentDO().getSd_pttp());
		// 交易号
		refundDto.setBankno(oldItmPatOepDO.getBankno());
		// 就诊类型编码
		refundDto.setCode_enttp(originPayData.getParentDO().getCode_enttp());
		// 场景编码
		refundDto.setSd_bizscene(sd_biz);
		// 支付方式
		refundDto.setSd_pm(payItmPatOepDO.getSd_pm());
		// 退费人员
		refundDto.setId_emp(PayData.getParentDO().getId_emp_pay());
		//本机识别码
		refundDto.setPcid(Context.get().getClientHost());
		BLThirdItfLogger.info("调用第三方退费客开接口入参" + refundDto.serializeJson());
		IBlThirdPaymentRefundService service = ServiceFinder.find(IBlThirdPaymentRefundService.class);
		if (service == null) {
			throw new BizException("第三方退费客开接口未注册");
		}
		try {
			BlThirdPayReturnDTO blThirdPayReturnDTO = service.refund(refundDto);
			BLThirdItfLogger.info("调用第三方退费客开接口出参" + blThirdPayReturnDTO.serializeJson());
			UpdateRefundInfo(blThirdPayReturnDTO,payItmPatOepDO);
		} catch (BizException e) {
			// 写日志
			BLThirdItfLogger.error(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * 回写收付款明细
	 * 
	 * @param blThirdPayReturnDTO
	 * @param payItmPatOepDO
	 * @throws BizException
	 */
	private void UpdateRefundInfo(BlThirdPayReturnDTO blThirdPayReturnDTO, BlPayItmPatOepDO payItmPatOepDO)
			throws BizException {
		// 添加返回值更新 收付款明细 do
		if (blThirdPayReturnDTO != null && StringUtils.isNotEmpty(blThirdPayReturnDTO.getBankno())
				&&StringUtils.isNotEmpty(blThirdPayReturnDTO.getPaymodenode())
				&&StringUtils.isNotEmpty(payItmPatOepDO.getId_payitmpatoep())) {
			StringBuilder sql = new StringBuilder();
			sql.append(" update bl_pay_itm_pat_oep  ");
			sql.append(" set bankno ='" + blThirdPayReturnDTO.getBankno() + "' ,");
			sql.append("  paymodenode ='" + blThirdPayReturnDTO.getPaymodenode() + "'");
			sql.append("  where bl_pay_itm_pat_oep.id_payitmpatoep='" + payItmPatOepDO.getId_payitmpatoep() + "'");
			new DAFacade().execUpdate(sql.toString());
		}
	}

}
