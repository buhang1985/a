package iih.bl.pay.s;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import iih.bl.pay.dto.blprepayrefund.d.BlPrepayRefundDTO;
import iih.bl.pay.dto.d.BlIpRegisKnotsPayDTO;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.dto.prepayreceipt.d.BlPrepayReceiptDTO;
import iih.bl.pay.i.IBlPayCmdService;
import iih.bl.pay.refundpay.BP.RefundpayBP;
import iih.bl.pay.s.bp.BlPaySaveReprintPrepayInfoBP;
import iih.bl.pay.s.bp.BlPrepayReceiptReprintBP;
import iih.bl.pay.s.bp.DoInsurSettledPaymentBp;
import iih.bl.pay.s.bp.DoIpPaymentBP;
import iih.bl.pay.s.bp.UpdateCodeStBp;
import iih.bl.pay.s.bp.ip.BlIpPaymentBP;
import iih.bl.pay.s.bp.ip.BlIpReginPrePayInputBp;
import iih.bl.pay.s.bp.ip.BlKontsPrePayInputBp;
import iih.bl.pay.s.bp.op.OpCollectPrepayBP;
import iih.bl.pay.s.bp.op.OpReturnCardDepositBP;
import iih.bl.prop.blproparip.d.BlproparipAggDO;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.dto.blpayip.d.BlPayIpDTO;
import iih.bl.st.dto.blpayip.d.BlPayIpPmDTO;
import iih.bl.st.dto.blpayip.d.BlPayIpRltDTO;
import iih.bl.st.dto.d.BlStIpInccanoDTO;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.itf.context.InsureContext;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 收付款命令服务
 * 
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces = { IBlPayCmdService.class }, binding = Binding.JSONRPC)
public class BlPayCmdServiceImpl implements IBlPayCmdService {

	/**
	 * 住院收付款
	 * 
	 * @param operator	操作员信息
	 * @param ipPayDo	收付款主表DO
	 * @param ipPrepayDoArr	预交金DO
	 * @param ipPayItmDoArr	收付款子表DO
	 * @param reductionCgDoArr	项目减免明细
	 * @param incAndPayNo	发票号和押金票据号
	 * @param isArrears	是否欠款结算
	 * @param isTransfer	是否结转
	 * @return
	 * @throws BizException
	 * @author liwq
	 * @since 2017-7-13 11:26:06
	 */
	public BlStIpPayInvoceInfoDTO doIpStPayment(OperatorInfoDTO operator,
			BlPayPatIpDO ipPayDo, BlPrePayPatDO[] ipPrepayDoArr,
			BlPayItmPatIpDO[] ipPayItmDoArr, BlCgIpDO[] reductionCgDoArr,
			BlStIpInccanoDTO incAndPayNo, FBoolean isArrears,
			FBoolean isTransfer) throws BizException {
		DoIpPaymentBP bp = new DoIpPaymentBP();
		return bp.exec(operator, ipPayDo, ipPrepayDoArr, ipPayItmDoArr,
				reductionCgDoArr, incAndPayNo, isArrears, isTransfer,FBoolean.TRUE);
	}
	
	/**
	 * 保存预交金重打记录
	 * @param paypatId 患者预交金收付款id
	 * @param idResReprint 重打原因
	 * @throws BizException
	 */
	@Override
	public void saveReprintPrepayInfo(String paypatId,String idResReprint) throws BizException {
		BlPaySaveReprintPrepayInfoBP bp = new BlPaySaveReprintPrepayInfoBP();
		bp.exec(paypatId,idResReprint);
	}
	
	/**
	 * 铜陵住院医保患者HIS结算
	 * @author liwq
	 * @since 2017-9-26 9:43:52
	 */
	public BlStIpPayInvoceInfoDTO doInsurSettledPayment(InsureContext insureContext,OperatorInfoDTO operator, BlPayPatIpDO ipPayDo, BlPrePayPatDO[] ipPrepayDoArr,
			BlPayItmPatIpDO[] ipPayItmDoArr, BlCgIpDO[] reductionCgDoArr,BlStIpInccanoDTO incAndPayNo, FBoolean isArrears,
			FBoolean isTransfer,FBoolean isPrintInvoice,BlPropIpDO ipPropDO,BlproparipAggDO ipPropArAggDO,InpPayRtnValDTO hpPayRtnValDto ) throws BizException {
		DoInsurSettledPaymentBp bp = new DoInsurSettledPaymentBp();		
		return bp.exec(insureContext,operator, ipPayDo, ipPrepayDoArr, ipPayItmDoArr, reductionCgDoArr, incAndPayNo, isArrears, isTransfer, isPrintInvoice, ipPropDO, ipPropArAggDO,hpPayRtnValDto);
	}

	/**
	 * 医保交易撤消后，调用此接口
	 * @author liwq
	 */
	public FBoolean updateCodeSt(String idEnt,String idStIp) throws BizException {
		UpdateCodeStBp bp =new UpdateCodeStBp();
		return bp.exec(idEnt,idStIp);
	}
	
	/**
	 * 门诊收取预交金
	 * (含卡费处理)
	 * 
	 * @param dto 预交金含卡信息dto
	 * @throws BizException
	 * @author ly 2018/05/19
	 */
	@Override
	public BlPrePayPatDO opCollectPrepay(BlPrepayDTO dto) throws BizException{
		OpCollectPrepayBP bp = new OpCollectPrepayBP();
		return bp.exec(dto);
	}
	
	/**
	 * 患者卡退押金
	 * 
	 * @param dto 预交金含卡信息dto
	 * @throws BizException
	 * @author ly 2018/05/20
	 */
	@Override
	public void returnCardDeposit(BlPrepayDTO dto) throws BizException {
		OpReturnCardDepositBP bp = new OpReturnCardDepositBP();
		bp.exec(dto);
	}
	
	/**
	 * 
	 * @Description: 住院结算结转押金转入      
	 * @author: xy.zhou     
	 * @throws
	 */
	@Override
	public BlPrePayPatDO[] KontsPrePayInput(BlIpRegisKnotsPayDTO[] blIpRegisKnots,String id_ent) throws BizException {
		BlKontsPrePayInputBp bp=new BlKontsPrePayInputBp();
		return bp.exec(blIpRegisKnots,id_ent);
	}
	/**
	 * 
	 * @Description: 入院登记录入预交金保存     
	 * @author: xy.zhou     
	 * @throws
	 */
	@Override
	public BlPrePayPatDO ipReginPrePayInput(BlPayPatItemDTO blPayPatItemDto) throws BizException {
		BlIpReginPrePayInputBp bp=new BlIpReginPrePayInputBp();
		return bp.exec(blPayPatItemDto);
	}
	
	/**
	 * 预交金票据重打
	 * 
	 * @param rcptDto
	 * @throws BizException
	 */
	@Override
	public void reprintPrepayReceipt(BlPrepayReceiptDTO rcptDto) throws BizException {
		BlPrepayReceiptReprintBP bp = new BlPrepayReceiptReprintBP();
		bp.exec(rcptDto);
	}
    /**
     * 强制退预交金
     * @throws BizException
     * @author houll
     */
	@Override
	public void doSave(BlPrepayRefundDTO refundDTO, BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException {
		RefundpayBP payBP=new RefundpayBP();
		payBP.savePrepay(refundDTO,dto,setDto);
	}
	
	/**
	 * 住院收付款(新)
	 * @param payIpDto 收付款信息
	 * @param payIpPmDtos 付款方式
	 * @param freeCgIds 减免项目
	 * @return 
	 * @throws BizException
	 * @author ly 2018/07/19
	 */
	@Override
	public BlPayIpRltDTO ipPayment(BlPayIpDTO payIpDto, BlPayIpPmDTO[] payIpPmDtos, String[] freeCgIds) throws BizException {
		BlIpPaymentBP bp = new BlIpPaymentBP();
		return bp.exec(payIpDto, payIpPmDtos, freeCgIds);
	}
}
