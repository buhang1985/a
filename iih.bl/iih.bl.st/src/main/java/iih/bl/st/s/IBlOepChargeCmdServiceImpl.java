package iih.bl.st.s;

import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltHdDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSetDTO;
import iih.bl.st.dto.bloeprecharge.d.BlOepRechargeRltDTO;
import iih.bl.st.dto.bloeprecharge.d.BlOepRechargeSetDTO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundItmDTO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundRltDTO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundSetDTO;
import iih.bl.st.dto.bloepregcharge.d.BlOepRegChargePricingPayDTO;
import iih.bl.st.dto.bloepregcharge.d.BlOepRegChargePricingPayItmDTO;
import iih.bl.st.dto.bloepregcharge.d.BlOepRegChargePricingPayRltDTO;
import iih.bl.st.dto.bloepregrefund.d.BlOepRegRefundDTO;
import iih.bl.st.dto.bloepregrefund.d.BlOepRegRefundRltDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRltDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.bl.st.s.bp.oepcharge.BlOepCancelPricingBP;
import iih.bl.st.s.bp.oepcharge.BlOepChargePrepricingBP;
import iih.bl.st.s.bp.oepcharge.BlOepChargePricingBP;
import iih.bl.st.s.bp.oepcharge.BlOepChargePricingWithIncBP;
import iih.bl.st.s.bp.oepcharge.BlOepCombineStBP;
import iih.bl.st.s.bp.oepcharge.BlOepCombinedStCancelBP;
import iih.bl.st.s.bp.oepcharge.BlOepPaymentBP;
import iih.bl.st.s.bp.oepcharge.BlOepRechargeBP;
import iih.bl.st.s.bp.oepcharge.BlOepRefundBP;
import iih.bl.st.s.bp.oepcharge.BlOepRegChargePricingPayBP;
import iih.bl.st.s.bp.oepcharge.BlOepRegRefundBP;
import iih.bl.st.s.bp.oepcharge.CancelPricingByPatIdBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 门诊收费命令服务
 * @author zhangxin 2018-11-24
 *
 */
@Service(serviceInterfaces={IBlOepChargeCmdService.class}, binding=Binding.JSONRPC)
public class IBlOepChargeCmdServiceImpl implements IBlOepChargeCmdService {

	/**
	 * 门诊划价
	 * @param dtos 明细信息
	 * @param chargeSet 门诊收费配置信息
	 * @return 划价结果
	 * @throws BizException
	 * @author ly 2018/11/23
	 */
	@Override
	public BlOepChargePricingRltDTO[] pricing(BlOepChargePricingDTO[] dtos, BlOepChargeSetDTO chargeSet) throws BizException {
		BlOepChargePricingBP bp =new BlOepChargePricingBP();
		return bp.exec(dtos, chargeSet);
	}
	
	/**
	 * 门诊划价(含发票预拆信息)
	 * @param dtos 明细信息
	 * @param chargeSet 门诊收费配置信息
	 * @return 划价结果
	 * @throws BizException
	 * @author ly 2019/05/07
	 */
	@Override
	public BlOepChargePricingRltHdDTO pricingWithInc(BlOepChargePricingDTO[] dtos, BlOepChargeSetDTO chargeSet) throws BizException{
		BlOepChargePricingWithIncBP bp = new BlOepChargePricingWithIncBP();
		return bp.exec(dtos, chargeSet);
	}
	
	/**
	 * 门诊预划价
	 * @param dtos 明细信息
	 * @param chargeSet 门诊收费配置信息
	 * @return 预划价结果
	 * @throws BizException
	 * @author ly 2019/02/26
	 */
	@Override
	public BlOepChargePricingRltDTO[] prePricing(BlOepChargePricingDTO[] dtos, BlOepChargeSetDTO chargeSet) throws BizException{
		BlOepChargePrepricingBP bp = new BlOepChargePrepricingBP();
		return bp.exec(dtos, chargeSet);
	}
	
	/**
	 * 门诊取消划价
	 * @param stId 结算id
	 * @throws BizException
	 * @author ly 2018/12/04
	 */
	@Override
	public void cancelPricing(String stId) throws BizException{
		BlOepCancelPricingBP bp = new BlOepCancelPricingBP();
		bp.exec(stId);
	}
	
	/**
	 * 门诊取消划价
	 */
	@Override
	public void cancelPricingByPatId(String patId) throws BizException {
		CancelPricingByPatIdBP bp=new CancelPricingByPatIdBP();
		bp.exec(patId);
	}
	
	/**
	 * 门诊收付款
	 * @param payoepDto 收付款信息
	 * @param payOepPmDtos 支付方式
	 * @param freeCgIds 减免项目
	 * @return 收付款结果
	 * @throws BizException
	 * @author ly 2018/12/03
	 */
	@Override
	public BlPayOepRltDTO oepPayment(BlPayOepDTO payoepDto,BlPayOepPmDTO[] payOepPmDtos,String[] freeCgIds) throws BizException{
		BlOepPaymentBP bp = new BlOepPaymentBP();
		return bp.exec(payoepDto, payOepPmDtos, freeCgIds);
	}

	/**
	 * 门诊退费
	 * @param refundSet 退费信息
	 * @param cgItmDtos 退费明细
	 * @param payOepPmDtos 支付方式
	 * @return 退费结果
	 * @throws BizException
	 * @author ly 2018/12/07
	 */
	@Override
	public BlOepRefundRltDTO oepRefund(BlOepRefundSetDTO refundSet, BlOepRefundItmDTO[] cgItmDtos, BlPayOepPmDTO[] payOepPmDtos) throws BizException {
		BlOepRefundBP bp = new BlOepRefundBP();
		return bp.exec(refundSet, cgItmDtos, payOepPmDtos);
	}
	
	/**
	 * 门诊重划重收
	 * @param rechargeSet 重划重收信息
	 * @param payOepPmDtos 支付方式
	 * @return 重划重收结果
	 * @throws BizException
	 * @author ly 2019/06/25
	 */
	@Override
	public BlOepRechargeRltDTO oepRecharge(BlOepRechargeSetDTO rechargeSet, BlPayOepPmDTO[] payOepPmDtos) throws BizException{
		BlOepRechargeBP bp = new BlOepRechargeBP();
		return bp.exec(rechargeSet, payOepPmDtos);
	}
	
	/**
	 * 门诊挂号划价收费一体化方法
	 * @param chargeDto 收费信息
	 * @param chargeItmDtos 费用明细信息
	 * @param payPmDtos 支付方式信息
	 * @return 收费结果
	 * @throws BizException
	 * @author ly 2019/07/16
	 */
	@Override
	public BlOepRegChargePricingPayRltDTO oepRegPricingAndPay(BlOepRegChargePricingPayDTO chargeDto, BlOepRegChargePricingPayItmDTO[] chargeItmDtos, BlPayOepPmDTO[] payPmDtos) throws BizException{
		BlOepRegChargePricingPayBP bp = new BlOepRegChargePricingPayBP();
		return bp.exec(chargeDto, chargeItmDtos, payPmDtos);
	}
	
	/**
	 * 门诊退号
	 * (支持多号结算半退)
	 * @param refundDto 退号数据
	 * @param payOepPmDtos 支付方式信息
	 * @return 收费结果
	 * @throws BizException
	 * @author ly 2019/07/16
	 */
	@Override
	public BlOepRegRefundRltDTO oepRegRefund(BlOepRegRefundDTO refundDto, BlPayOepPmDTO[] payOepPmDtos) throws BizException{
		BlOepRegRefundBP bp = new BlOepRegRefundBP();
		return bp.exec(refundDto, payOepPmDtos);
	}

	/**
	 * 门诊合并结算
	 * @param stIds 待合并结算id数组
	 * @return 合并后结算id
	 * @throws BizException
	 * @author ly 2019/12/10
	 */
	@Override
	public String combineOepSt(String[] stIds) throws BizException {
		BlOepCombineStBP bp = new BlOepCombineStBP();
		return bp.exec(stIds);
	}

	/**
	 * 门诊取消合并结算
	 * @param stId 合并结算id
	 * @return 拆分后结算id数组
	 * @throws BizException
	 * @author ly 2019/12/10
	 */
	@Override
	public String[] cancelCombinedOepSt(String stId) throws BizException {
		BlOepCombinedStCancelBP bp = new BlOepCombinedStCancelBP();
		return bp.exec(stId);
	}
	/**
	 * 门诊重拆票
	 * @param rechargeSet 重划重收信息
	 * @param payOepPmDtos 支付方式
	 * @return 重划重收结果
	 * @throws BizException
	 * @author xb 2019/06/25
	 */
	public BlOepRechargeRltDTO oepReIncReCharge(BlOepRechargeSetDTO rechargeSet, BlPayOepPmDTO[] payOepPmDtos, BlReIncPageDTO[] cgitms) throws BizException
	{
		BlOepRechargeBP bp = new BlOepRechargeBP();
		return bp.execReInc(rechargeSet, payOepPmDtos,cgitms);
	}

}
