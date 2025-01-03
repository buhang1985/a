package iih.bl.st.s.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.comm.thirdpayapi.BlThirdPayValidateUtil;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.itf.custom.IBlThirdPaymentRefundService;
import iih.bl.itf.custom.thirdpay.d.BlThirdPayRefundDTO;
import iih.bl.itf.custom.thirdpay.d.BlThirdPayReturnDTO;
import iih.bl.itf.dto.thirdpayvalidate.d.BlThirdPayValidateRltDTO;
import iih.bl.itf.payplatform.d.BlOrdReqDTO;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import iih.bl.itf.trdtrans.d.TransStateEnum;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.pmp.pay.ordreqdto.d.CmbcSceneEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 住院收付款监听 处理第三方找零
 * 
 * @author wq.li
 *
 */
public class BlIpThirdPaymentListner implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		// 验证事件
		if (!IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS.equalsIgnoreCase(arg0.getSourceID())
				|| !IBlEventConst.EVENT_TYPE_ST_IP_PAY.equals(arg0.getEventType())) {
			return;
		}
		// 退费
		this.RefundAmt(arg0);
	}

	private void RefundAmt(IBusinessEvent arg0) throws BizException {
		// 转化为 退费所用dto
		BusinessUserObj bizUserObj = (BusinessUserObj) arg0.getUserObject();
		BlEventInfoDTO eventSourceDTO = (BlEventInfoDTO) bizUserObj.getUserObj();

		if (eventSourceDTO == null) {
			return;
		}

		// 支付信息
		BlpaypatipAggDO payAggDo = eventSourceDTO.getBlpaypatipAggDO();

		BlPayItmPatIpDO[] itmPayArr = payAggDo.getBlPayItmPatIpDO();

		if (ArrayUtil.isEmpty(itmPayArr)) {
			return;
		}

		Set<String> pmSet = new HashSet<>();
		// 预交金主键集合
		List<String> preIdList = new ArrayList<>();

		Map<String, BlPayItmPatIpDO> refundPayMap = new HashMap<>();

		for (BlPayItmPatIpDO itm : itmPayArr) {
			if (PayDirectEnum.CHANGE.equals(itm.getEu_direct())) {
				pmSet.add(itm.getId_pm());

				if (!StringUtil.isEmpty(itm.getId_paypat())) {
					preIdList.add(itm.getId_paypat());
					refundPayMap.put(itm.getId_paypat(), itm);
				}

			}
		}

		if (pmSet == null || pmSet.size() <= 0) {
			return;
		}

		// 校验需要第三方退费的支付方式
		BlThirdPayValidateRltDTO[] thirdDtoArr = BlThirdPayValidateUtil.getAllThirdPayPm(pmSet.toArray(new String[0]),
				IBlDictCodeConst.SD_BIZSCENE_IP_CHARGE);

		if (ArrayUtil.isEmpty(thirdDtoArr)) {
			return;
		}

		Map<String, BlThirdPayValidateRltDTO> thirdMap = new HashMap<String, BlThirdPayValidateRltDTO>();

		for (BlThirdPayValidateRltDTO thirdDto : thirdDtoArr) {
			if (!thirdMap.containsKey(thirdDto.getId_pm())) {
				thirdMap.put(thirdDto.getId_pm(), thirdDto);
			}
		}

		// 查询预交金信息
		IBlpaypatRService preRService = ServiceFinder.find(IBlpaypatRService.class);
		BlPrePayPatDO[] prePayPatArr = preRService.findByIds(preIdList.toArray(new String[0]), FBoolean.FALSE);
		if (ArrayUtil.isEmpty(prePayPatArr)) {
			throw new BizException("未查询第三方找零的预交金数据");
		}
         
		for (BlPrePayPatDO preDo : prePayPatArr) {
			BlPayItmPatIpDO payitmDo = refundPayMap.get(preDo.getId_paypat());
			BlThirdPayValidateRltDTO validate = thirdMap.get(preDo.getId_pm());
			// 只退在收费窗口 收费的预交金
			if (IBlDictCodeConst.SD_PTTP_WINDOW.equals(preDo.getSd_pttp()) || 
					IBlDictCodeConst.SD_PTTP_BEDSIDE.equals(preDo.getSd_pttp())) {
				this.windowsRefund(payitmDo, validate, IBlDictCodeConst.SD_BIZSCENE_IP_CHARGE, preDo);
			} else {
				this.customRefund(payitmDo,IBlDictCodeConst.SD_BIZSCENE_IP_CHARGE, preDo,payAggDo);
			}
		}

	}

	/**
	 * 窗口缴费退费
	 * 
	 * @param blPrePatPatDo
	 * @param validateRltDto
	 * @param sd_bizsence
	 * @param oldPrePat
	 * @throws BizException
	 */
	private void windowsRefund(BlPayItmPatIpDO payitmDo, BlThirdPayValidateRltDTO validateRltDto,
			String sd_bizsence, BlPrePayPatDO oldPrePat) throws BizException {
		//如果不是后端处理则返回 //添加手工转账的不处理
		if(!BlThirdPayBP.isThirdFefund(payitmDo.getId_pm())||FBoolean.TRUE.equals(payitmDo.getFg_refund_manual())){
			return ;
		}
		// 退费
		// 1.组织退费入参
		BlOrdReqDTO blOrdReqDTO = this.setRefundOrdReqDTO(payitmDo, validateRltDto, sd_bizsence, oldPrePat);
		BlThirdPayBP blThirdPayBP = new BlThirdPayBP();
		// 2.先保存退费两个日志信息
		BlThirdTransRcdDO blThirdTransRcdDO = blThirdPayBP.setThirdPayDTO(blOrdReqDTO, null, TransStateEnum.UNFAIL);
		String id_transrcd = blThirdPayBP.saveThirdTradeLog(blThirdTransRcdDO);

		if (FBoolean.TRUE.equals(BlParams.BLPAY001())) {
			BlThirdPayBP BlThirdPayBP = new BlThirdPayBP();
			BlThirdPayBP.execRefund(blOrdReqDTO, id_transrcd);
		}

	}

	/**
	 * 调用客开退费接口
	 * @param payAggDo 
	 * @throws BizException 
	 */
	private void customRefund(BlPayItmPatIpDO payItmDo,
			String sd_bizsence, BlPrePayPatDO oldPrePat, BlpaypatipAggDO payAggDo) throws BizException {
		
		boolean thirdFefund = BlThirdPayBP.isThirdFefund(payItmDo.getId_pm());
		//添加手工转账的不处理
		if (!thirdFefund||FBoolean.TRUE.equals(payItmDo.getFg_refund_manual())) {
			// 校验不通过 不符合第三方注册节点维护 不处理
			return;
		}
		// 组装退费数据
		BlThirdPayRefundDTO dto = new BlThirdPayRefundDTO();
		// 患者编码
		dto.setPatcode(oldPrePat.getPatcode());
		// 就诊类型
		dto.setCode_enttp(oldPrePat.getCode_enttp());
		// 商户订单号
		dto.setTradeno(oldPrePat.getPaymodenode());
		// 交易号
		dto.setBankno(oldPrePat.getBankno());
		// 新退款流水号
		dto.setRefundtradeno(BlCodeUtils.generateThirdOrdNo());
		// 退款金额
		dto.setRefundfee(payItmDo.getAmt().toString());
		// 终端类型
		dto.setSdpttp(oldPrePat.getSd_pttp());
		// 订单总金额
		dto.setTotalfee(oldPrePat.getAmt().toString());
		// 支付场景类型
		dto.setSd_bizscene(sd_bizsence);
		// 付款方式
		dto.setSd_pm(oldPrePat.getSd_pm());
		//退费人员
		dto.setId_emp(payAggDo.getParentDO().getId_emp_pay());
		//本机识别码
		dto.setPcid(Context.get().getClientHost());
		// 调用客开接口
		IBlThirdPaymentRefundService service = ServiceFinder.find(IBlThirdPaymentRefundService.class);
		if (service == null) {
			throw new BizException("第三方退费客开接口未注册");
		}
		try {
			BlThirdPayReturnDTO blThirdPayReturnDTO = service.refund(dto);
			//添加返回值更新 收付款明细 do
			UpdateRefundInfo(blThirdPayReturnDTO,payItmDo);
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
	private void UpdateRefundInfo(BlThirdPayReturnDTO blThirdPayReturnDTO, BlPayItmPatIpDO payItmPatIpDO)
			throws BizException {
		// 添加返回值更新 收付款明细 do
		if (blThirdPayReturnDTO != null && (StringUtils.isNotEmpty(blThirdPayReturnDTO.getBankno())
				&& StringUtils.isNotEmpty(blThirdPayReturnDTO.getPaymodenode())
				&&StringUtils.isNotEmpty(payItmPatIpDO.getId_payitmpatip()))) {
			StringBuilder sql = new StringBuilder();
			sql.append(" update bl_pay_itm_pat_ip  ");
			sql.append(" set bankno ='" + blThirdPayReturnDTO.getBankno() + "' ,");
			sql.append("  paymodenode ='" + blThirdPayReturnDTO.getPaymodenode() + "'");
			sql.append("  where bl_pay_itm_pat_ip.id_payitmpatip='" + payItmPatIpDO.getId_payitmpatip() + "'");
			new DAFacade().execUpdate(sql.toString());
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
	private BlOrdReqDTO setRefundOrdReqDTO(BlPayItmPatIpDO payItmPatIpDo, BlThirdPayValidateRltDTO validateRltDto,
			String sd_bizsence, BlPrePayPatDO oldPrePat) throws BizException {
		BlOrdReqDTO blOrdReqDTO = new BlOrdReqDTO();
		blOrdReqDTO.setOrd_no(oldPrePat.getPaymodenode());// 原收费订单号
		blOrdReqDTO.setRefund_req_no(BlCodeUtils.generateThirdOrdNo());
		//
		String subject = "预交金退费";
		if (sd_bizsence.equals(IBlDictCodeConst.SD_BIZSCENE_IP_REFUND)) {
			subject = "住院预交金退费";
		} else if (sd_bizsence.equals(IBlDictCodeConst.SD_BIZSCENE_OEP_PRE)) {
			subject = "门诊预交金退费";
		}else if (sd_bizsence.equals(IBlDictCodeConst.SD_BIZSCENE_IP_CHARGE))
		{
			subject = "住院收付款";
		}
		blOrdReqDTO.setSubject(subject + payItmPatIpDo.getAmt() + "元");
		blOrdReqDTO.setAmt(payItmPatIpDo.getAmt());
		blOrdReqDTO.setEu_direct(BookRtnDirectEnum.REFUND);
		String id_emp_pay = oldPrePat.getId_emp_pay();
		blOrdReqDTO.setId_psndoc(StringUtil.isEmpty(id_emp_pay) ? "" : id_emp_pay);

		if (StringUtil.isEmpty(validateRltDto.getTradetype())) {
			blOrdReqDTO.setTradetype(IBdPripmCodeConst.ID_PRI_PM_ALIPAY.equals(payItmPatIpDo.getId_pm())
					? CmbcSceneEnum.ZFBSCAN : CmbcSceneEnum.WXSCAN);
		} else {
			blOrdReqDTO.setTradetype(validateRltDto.getTradetype());
		}

		blOrdReqDTO.setCode_enttp(oldPrePat.getCode_enttp());
		blOrdReqDTO.setFg_refund(FBoolean.TRUE);
		blOrdReqDTO.setId_pm(payItmPatIpDo.getId_pm());
		blOrdReqDTO.setId_pat(oldPrePat.getId_pat());
		blOrdReqDTO.setId_ent((StringUtil.isEmpty(oldPrePat.getId_ent()) ? "" : oldPrePat.getId_ent()));
		blOrdReqDTO.setId_st("");
		blOrdReqDTO.setId_pay(payItmPatIpDo.getId_paypatip());
		// 添加支付场景id zx 2019年3月18日
		blOrdReqDTO.setId_bizscene(IBlDictCodeConst.ID_BIZSCENE_IP_CHARGE);
		blOrdReqDTO.setSd_bizscene(sd_bizsence);
		blOrdReqDTO.setSd_chl(validateRltDto.getSd_paychannel());
		return blOrdReqDTO;
	}

}
