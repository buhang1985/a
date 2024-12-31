package iih.bl.pay.i;

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
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 收付款命令服务
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlPayCmdService {

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
			FBoolean isTransfer) throws BizException;

	/**
	 * 保存预交金重打记录
	 * @param paypatId 患者预交金收付款id
	 * @param idResReprint 重打原因
	 * @throws BizException
	 */
	public abstract void saveReprintPrepayInfo(String paypatId,String idResReprint) throws BizException;
	
	/**
	 * 铜陵住院医保患者HIS结算
	 * @author liwq
	 * @since 2017-9-26 9:43:52
	 */
	public BlStIpPayInvoceInfoDTO doInsurSettledPayment(InsureContext insureContext,OperatorInfoDTO operator,BlPayPatIpDO ipPayDo, BlPrePayPatDO[] ipPrepayDoArr,
			BlPayItmPatIpDO[] ipPayItmDoArr, BlCgIpDO[] reductionCgDoArr,BlStIpInccanoDTO incAndPayNo, FBoolean isArrears,
			FBoolean isTransfer,FBoolean isPrintInvoice,BlPropIpDO ipPropDO,BlproparipAggDO ipPropArAggDO,InpPayRtnValDTO hpPayRtnValDto ) throws BizException ;
		
	/**
	 * 医保交易撤消后，调用此接口
	 * @author liwq
	 */
	public FBoolean updateCodeSt(String idEnt,String idStIp) throws BizException;
	
	/**
	 * 门诊收取预交金
	 * (含卡费处理)
	 * @param dto 预交金含卡信息dto
	 * @throws BizException
	 * @author ly 2018/05/19
	 */
	public BlPrePayPatDO opCollectPrepay(BlPrepayDTO dto) throws BizException;

	/**
	 * 患者卡退押金
	 * 
	 * @param dto 预交金含卡信息dto
	 * @throws BizException
	 * @author ly 2018/05/20
	 */
	public abstract void returnCardDeposit(BlPrepayDTO dto) throws BizException;
	
	
	/**
	 * 
	 * @Title: KontsPrePayInput   
	 * @Description: 住院结算结转押金转入 
	 * @param: @param blIpRegisKnots
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlPrePayPatDO[] 
	 * @author: xy.zhou     
	 * @throws
	 */
	public abstract BlPrePayPatDO[] KontsPrePayInput(BlIpRegisKnotsPayDTO[] blIpRegisKnots,String id_ent)throws BizException;
	/**
	 * 
	 * @Title: ipReginPrePayInput   
	 * @Description: 入院登记录入预交金保存 
	 * @param: @param blPayPatItemDto
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlPrePayPatDO[] 
	 * @author: xy.zhou     
	 * @throws
	 */
	public BlPrePayPatDO ipReginPrePayInput(BlPayPatItemDTO blPayPatItemDto)throws BizException;

	/**
	 * 预交金票据重打
	 * 
	 * @param rcptDto
	 * @throws BizException
	 * @author ly 2018/06/23
	 */
	public abstract void reprintPrepayReceipt(BlPrepayReceiptDTO rcptDto) throws BizException;
    /**
     * 强制退预交金
     * @param refundDTO
     * @throws BizException
     * @author houll
     */
    public abstract void doSave(BlPrepayRefundDTO refundDTO,BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException; 

    /**
	 * 住院收付款(新)
	 * @param payIpDto 收付款信息
	 * @param payIpPmDtos 付款方式
	 * @param freeCgIds 减免项目
	 * @return 
	 * @throws BizException
	 * @author ly 2018/07/19
	 */
	public abstract BlPayIpRltDTO ipPayment(BlPayIpDTO payIpDto, BlPayIpPmDTO[] payIpPmDtos, String[] freeCgIds)throws BizException;

}
