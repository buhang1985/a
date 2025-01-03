package iih.bl.st.i;

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
import xap.mw.core.data.BizException;

/**
 * 门诊收费命令服务
 * @author ly 2018/11/19
 *
 */
public interface IBlOepChargeCmdService {
 
	/**
	 * 门诊划价
	 * @param dtos 明细信息
	 * @param chargeSet 门诊收费配置信息
	 * @return 划价结果
	 * @throws BizException
	 * @author ly 2018/11/23
	 */
	public abstract BlOepChargePricingRltDTO[] pricing(BlOepChargePricingDTO[] dtos, BlOepChargeSetDTO chargeSet) throws BizException;
	
	/**
	 * 门诊划价(含发票预拆信息)
	 * @param dtos 明细信息
	 * @param chargeSet 门诊收费配置信息
	 * @return 划价结果
	 * @throws BizException
	 * @author ly 2019/05/07
	 */
	public abstract BlOepChargePricingRltHdDTO pricingWithInc(BlOepChargePricingDTO[] dtos, BlOepChargeSetDTO chargeSet) throws BizException;
	
	/**
	 * 门诊预划价
	 * @param dtos 明细信息
	 * @param chargeSet 门诊收费配置信息
	 * @return 预划价结果
	 * @throws BizException
	 * @author ly 2019/02/26
	 */
	public abstract BlOepChargePricingRltDTO[] prePricing(BlOepChargePricingDTO[] dtos, BlOepChargeSetDTO chargeSet) throws BizException;
	
	/**
	 * 门诊取消划价
	 * @param stId 结算id
	 * @throws BizException
	 * @author ly 2018/12/04
	 */
	public abstract void cancelPricing(String stId) throws BizException;
	
	/**
	 * 门诊取消划价
	 * @param patId
	 * @throws BizException
	 */
	public abstract void cancelPricingByPatId(String patId) throws BizException;
	
	/**
	 * 门诊收付款
	 * @param payoepDto 收付款信息
	 * @param payOepPmDtos 支付方式
	 * @param freeCgIds 减免项目
	 * @return 收付款结果
	 * @throws BizException
	 * @author ly 2018/12/03
	 */
	public abstract BlPayOepRltDTO oepPayment(BlPayOepDTO payoepDto,BlPayOepPmDTO[] payOepPmDtos,String[] freeCgIds) throws BizException;

	/**
	 * 门诊退费
	 * @param refundSet 退费信息
	 * @param cgItmDtos 退费明细
	 * @param payOepPmDtos 支付方式
	 * @return 退费结果
	 * @throws BizException
	 * @author ly 2018/12/07
	 */
	public abstract BlOepRefundRltDTO oepRefund(BlOepRefundSetDTO refundSet, BlOepRefundItmDTO[] cgItmDtos, BlPayOepPmDTO[] payOepPmDtos) throws BizException;

	/**
	 * 门诊重划重收
	 * @param rechargeSet 重划重收信息
	 * @param payOepPmDtos 支付方式
	 * @return 重划重收结果
	 * @throws BizException
	 * @author ly 2019/06/25
	 */
	public abstract BlOepRechargeRltDTO oepRecharge(BlOepRechargeSetDTO rechargeSet, BlPayOepPmDTO[] payOepPmDtos) throws BizException;

	/**
	 * 门诊挂号划价收费一体化方法
	 * (支持多号一起结算)
	 * @param chargeDto 收费信息
	 * @param chargeItmDtos 费用明细信息
	 * @param payPmDtos 支付方式信息
	 * @return 收费结果
	 * @throws BizException
	 * @author ly 2019/07/16
	 */
	public abstract BlOepRegChargePricingPayRltDTO oepRegPricingAndPay(BlOepRegChargePricingPayDTO chargeDto, BlOepRegChargePricingPayItmDTO[] chargeItmDtos, BlPayOepPmDTO[] payPmDtos) throws BizException;

	/**
	 * 门诊退号
	 * (支持多号结算半退)
	 * @param refundDto 退号数据
	 * @param payOepPmDtos 支付方式信息
	 * @return 收费结果
	 * @throws BizException
	 * @author ly 2019/07/16
	 */
	public abstract BlOepRegRefundRltDTO oepRegRefund(BlOepRegRefundDTO refundDto, BlPayOepPmDTO[] payOepPmDtos) throws BizException;

	/**
	 * 门诊合并结算
	 * @param stIds 待合并结算id数组
	 * @return 合并后结算id
	 * @throws BizException
	 * @author ly 2019/12/10
	 */
	public abstract String combineOepSt(String[] stIds) throws BizException;
	
	/**
	 * 门诊取消合并结算
	 * @param stId 合并结算id
	 * @throws BizException
	 * @return 拆分后结算id数组
	 * @author ly 2019/12/10
	 */
	public abstract String[] cancelCombinedOepSt(String stId) throws BizException;
	
	/**
	 * 门诊重拆票
	 * @param rechargeSet 重划重收信息
	 * @param payOepPmDtos 支付方式
	 * @return 重划重收结果
	 * @throws BizException
	 * @author xuebei 2019/06/25
	 */
	public abstract BlOepRechargeRltDTO oepReIncReCharge(BlOepRechargeSetDTO rechargeSet, BlPayOepPmDTO[] payOepPmDtos,BlReIncPageDTO[] cgitms) throws BizException;

}
