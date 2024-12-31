package iih.bl.st.s.listener;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.comm.thirdpayapi.BlThirdPayValidateUtil;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.itf.dto.thirdpayvalidate.d.BlThirdPayValidateRltDTO;
import iih.bl.itf.payplatform.d.BlOrdReqDTO;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import iih.bl.itf.trdtrans.d.TransStateEnum;
import iih.bl.params.BlParams;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.pmp.pay.ordreqdto.d.CmbcSceneEnum;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 第三方支付退费监听 窗口支付
 * 
 * @author zhangxin
 * @date 2019年4月19日
 */
public class OpRefundPmpPaymentListener implements IBusinessListener {

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
	 * 调用支付平台退费
	 * 
	 * @param arg0
	 * @throws BizException
	 */
	private void RefundAmt(IBusinessEvent arg0) throws BizException {
		// 转化为 退费所用dto
		BusinessUserObj bizUserObj = (BusinessUserObj) arg0.getUserObject();
		BlPayOepRefundEventDTO eventSourceDTO = (BlPayOepRefundEventDTO) bizUserObj.getUserObj();
		BlOrdReqDTO blOrdReqDTO = null;
		// 付款信息
		BlpaypatoepAggDO PayData = new BlpaypatoepAggDO();
		// 结算信息
		BlStOepDO StData = new BlStOepDO();
		if (eventSourceDTO.getFg_allRefund().booleanValue()) {
			// 全退 去red
			PayData = eventSourceDTO.getRedPayData();
			StData = eventSourceDTO.getRedStData();
		} else {
			// 不全退 取 new
			PayData = eventSourceDTO.getNewPayData();
			StData = eventSourceDTO.getNewStData();
		}
		// 查询原收款信息
		BlpaypatoepAggDO oldBlPayPatAggDO = eventSourceDTO.getOriginPayData();
		//如果不是窗口支付则不处理
		if (!IBlDictCodeConst.SD_PTTP_WINDOW.equals(oldBlPayPatAggDO.getParentDO().getSd_pttp())
				&&!IBlDictCodeConst.SD_PTTP_ROOM.equals(oldBlPayPatAggDO.getParentDO().getSd_pttp())
				) {
			return;
		}

		String sd_biz = null;
		// 判断交易场景
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
		// 判断是否是第三方支付费用   退款方向
		BlPayItmPatOepDO payItmPatOepDO = BlThirdPayBP.validateNew(PayData.getBlPayItmPatOepDO(), sd_biz,PayDirectEnum.CHANGE);
		if(payItmPatOepDO == null){
			return ;
		}
		boolean thirdFefund = BlThirdPayBP.isThirdFefund(payItmPatOepDO.getId_pm());
		if (!thirdFefund) {
			// 校验不通过 不符合第三方注册节点维护 不处理
			return;
		}
		// 1.组织退费入参
		blOrdReqDTO = this.setRefundOrdReqDTO(oldBlPayPatAggDO, payItmPatOepDO, StData, sd_biz);
		if (blOrdReqDTO == null) {
			return;
		}
		BlThirdPayBP blThirdPayBP = new BlThirdPayBP();
		// 2.先保存退费两个日志信息
		BlThirdTransRcdDO blThirdTransRcdDO = blThirdPayBP.setThirdPayDTO(blOrdReqDTO, null, TransStateEnum.UNFAIL);
		String id_transrcd = blThirdPayBP.saveThirdTradeLog(blThirdTransRcdDO);
        //实时退费则 进行退费操作
		if (FBoolean.TRUE.equals(BlParams.BLPAY001())) {
			FBoolean execRefund = blThirdPayBP.execRefund(blOrdReqDTO, id_transrcd);
			if(FBoolean.TRUE.equals(execRefund)){
				updatePayItm(blThirdPayBP,id_transrcd);
			}
		}

	}
	/**
	 * 更新 收付款表信息
	 * @param blThirdPayBP
	 * @param id_transrcd
	 * @throws BizException
	 */
   private void updatePayItm(BlThirdPayBP blThirdPayBP,String id_transrcd) throws BizException{
	   BlThirdTransRcdDO blThirdTransRcdDO = blThirdPayBP.getThirdDoById(id_transrcd);
	   if(blThirdTransRcdDO!=null&&StringUtils.isNotEmpty(blThirdTransRcdDO.getId_pay())){
		   StringBuilder sql= new StringBuilder();
		   sql.append(" update bl_pay_itm_pat_oep set bankno ='"+blThirdTransRcdDO.getVoucher_no()+"'");
		   sql.append(" ,  paymodenode ='"+blThirdTransRcdDO.getOrder_no()+"'");
		   sql.append("  where bl_pay_itm_pat_oep.id_payitmpatoep='"+blThirdTransRcdDO.getId_pay()+"'");
		   sql.append(" and bl_pay_itm_pat_oep.fg_realpay='Y' ");
		   new DAFacade().execUpdate(sql.toString());
	   }
	
	
   }
	/**
	 * 组装退费信息
	 * 
	 * @param oldBlPayPatAggDO
	 * @param patOep
	 * @param stData
	 * @return
	 * @throws BizException
	 */
	private BlOrdReqDTO setRefundOrdReqDTO(BlpaypatoepAggDO oldBlPayPatAggDO, BlPayItmPatOepDO patOep, BlStOepDO stData,String sd_biz)
			throws BizException {
		if (patOep.getAmt() == null || patOep.getAmt().isTrimZero()) {
			return null;
		}
		BlOrdReqDTO blOrdReqDTO = new BlOrdReqDTO();
		
		// 原收款交易记录  收款方向
		BlPayItmPatOepDO oldpatOep = BlThirdPayBP.validateNew(oldBlPayPatAggDO.getBlPayItmPatOepDO(), sd_biz,PayDirectEnum.CHARGE);
		if (oldpatOep == null) {
			// 校验不通过 不符合第三方注册节点维护 不处理
			return null;
		}
		blOrdReqDTO.setOrd_no(oldpatOep.getPaymodenode());// 原收费订单号
		blOrdReqDTO.setRefund_req_no(BlCodeUtils.generateThirdOrdNo());
		String id_bizscene =null;
		String subject = null;
		switch (sd_biz) {
		//门诊挂号退费
		case IBlDictCodeConst.SD_BIZSCENE_OEP_REENT:
			id_bizscene =IBlDictCodeConst.ID_BIZSCENE_OEP_REENT;
			subject ="门诊挂号退费";
			break;
		//体检退费
		case IBlDictCodeConst.SD_BIZSCENE_PE_REFUND:
			id_bizscene =IBlDictCodeConst.ID_BIZSCENE_PE_REFUND;
			subject ="体检退费";
			break;
        //默认门诊退费
		default:
			id_bizscene =IBlDictCodeConst.ID_BIZSCENE_OEP_REFUND;
			subject ="门诊退费";
			break;
		}
		blOrdReqDTO.setSubject(subject + patOep.getAmt() + "元");
		blOrdReqDTO.setAmt(patOep.getAmt());
		blOrdReqDTO.setEu_direct(BookRtnDirectEnum.REFUND);
		//修改为第三方交易表的收款人
		blOrdReqDTO.setId_psndoc(BlThirdPayBP.getEmpIdByOrdNo(oldpatOep.getPaymodenode()));
		BlThirdPayValidateRltDTO dto = BlThirdPayValidateUtil.validate(new String[] { patOep.getId_pm() },sd_biz
				);
		if (dto.getFg_success().booleanValue()) {
			blOrdReqDTO.setSd_chl(dto.getSd_paychannel());
		} else {
			throw new BizException(dto.getError_msg());
		}
		
		if(StringUtils.isNotEmpty(dto.getTradetype())){
			blOrdReqDTO.setTradetype(dto.getTradetype());
		}else {
			blOrdReqDTO.setTradetype(IBdPripmCodeConst.ID_PRI_PM_ALIPAY.equals(patOep.getId_pm()) ? CmbcSceneEnum.ZFBSCAN
					: CmbcSceneEnum.WXSCAN);
		}
		
		blOrdReqDTO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		blOrdReqDTO.setFg_refund(FBoolean.TRUE);
		blOrdReqDTO.setId_pm(patOep.getId_pm());
		blOrdReqDTO.setId_pat(stData.getId_pat());
		blOrdReqDTO.setId_st(stData.getId_stoep());
		blOrdReqDTO.setId_pay(patOep.getId_payitmpatoep());
		
		blOrdReqDTO.setId_bizscene(id_bizscene);
		/*blOrdReqDTO.setId_bizscene(
				issc == true ? IBlDictCodeConst.ID_BIZSCENE_OEP_REENT : IBlDictCodeConst.ID_BIZSCENE_OEP_REFUND);*/
		blOrdReqDTO.setSd_bizscene(sd_biz);
		return blOrdReqDTO;
	}
}
