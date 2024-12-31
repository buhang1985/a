package iih.bl.cg.s;

import iih.bl.cg.api.d.ApplyInfo;
import iih.bl.cg.api.d.InsurPriceInfo;
import iih.bl.cg.api.d.OpPayInfo;
import iih.bl.cg.api.d.OpPayParam;
import iih.bl.cg.api.d.OpPayReturn;
import iih.bl.cg.api.d.PayRecord;
import iih.bl.cg.api.d.PrepayTradeRecord;
import iih.bl.cg.api.d.PriceApplyInfo;
import iih.bl.cg.api.d.RechargeInfo;
import iih.bl.cg.api.d.RechargeResult;
import iih.bl.cg.api.d.ResultInfo;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.i.IBlOpCgSelfExternalService;
import iih.bl.hp.divideresult.d.DivideResultDTO;
import iih.bl.hp.insurecard.d.CardPersonInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 门诊自助机对外服务
 * 
 * @author yankan
 * @since 2017-07-15
 *
 */
@Service(serviceInterfaces={IBlOpCgSelfExternalService.class}, binding=Binding.JSONRPC)
public class BlOpCgSelfExternalServiceImpl implements IBlOpCgSelfExternalService {
	/**
	 * 获取处方信息
	 * 
	 * @param patCode 患者编码
	 * @param patType 患者类型
	 * @param beginTime 开始时间 ,格式： yyyy-MM-dd HH:mm:ss。比如：2017-06-22 13:04:52
	 * @param endTime 结束时间 ,格式： yyyy-MM-dd HH:mm:ss。比如：2017-06-22 13:04:52
	 * @return 处方信息
	 * @throws BizException
	 */
	@Override
	public ApplyInfo[] getApplyInfo(String patCode, String patType, String beginTime, String endTime)
			throws BizException{
		return null;
	}

	/**
	 * 医保分解
	 * 
	 * @param priceInfo 医保划价信息
	 * @throws BizException
	 */
	@Override
	public PriceApplyInfo getInsurPriceInfo(InsurPriceInfo priceInfo) throws BizException{
		return null;
	}

	/**
	 * 医保交易确认
	 * 
	 * @param priceInfo 医保划价信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public ResultInfo priceByInsur(InsurPriceInfo priceInfo) throws BizException{
		return null;
	}

//	/**
//	 * 门诊患者缴费
//	 * 
//	 * @param param 门诊付款信息
//	 * @return OpPayReturn.code 成功返回0，失败返回1 OpPayReturn.result (返回错误信息
//	 *         场景1，需付费处方不存在应返回错误信息：病人无交费记录！ 场景2，支付金额错误应返回错误信息：输入金额错误！
//	 *         场景3，第三方支付订单号重复应返回错误信息：该订单号无效！ 场景4，成功缴费应返回信息：操作成功！)
//	 */
//	@Override
//	public OpPayReturn pay(OpPayParam param) throws BizException{
//		return null;
//	}

	/**
	 * 获取门诊交费记录
	 * 
	 * @param patCode 患者编码
	 * @param beginTime 开始时间 ,格式： yyyy-MM-dd HH:mm:ss。比如：2017-06-22 13:04:52
	 * @param endTime 结束时间 ,格式： yyyy-MM-dd HH:mm:ss。比如：2017-06-22 13:04:52
	 * @return 缴费记录集合
	 * @throws BizException
	 * 
	 */
	@Override
	public PayRecord[] getPayRecord(String patCode, String beginTime, String endTime) throws BizException{
		return null;
	}

	/**
	 * 获取处方交费信息
	 * 
	 * @param patCode 患者编码
	 * @param opTimes 就诊次数
	 * @return 缴费记录集合
	 * @throws BizException
	 * 
	 */
//	@Override
//	public PayRecord[] getEntPayRecord(String patCode, Integer opTimes) throws BizException{
//		return null;
//	}

	/**
	 * 获取门诊缴费列表
	 * 
	 * @param patCode 患者编码
	 * @param opTimes 就诊次数
	 * @param applyCode 申请单号
	 * @return
	 * @throws BizException
	 */
//	@Override
//	public OpPayInfo getOpPayDetail(String patCode, Integer opTimes, String applyCode) throws BizException{
//		return null;
//	}

	/**
	 * 充值
	 * 
	 * @param rechargeInfo 充值信息
	 * @return 充值结果
	 * @throws BizException
	 */
	@Override
	public RechargeResult recharge(RechargeInfo rechargeInfo) throws BizException{
		return null;
	}

	/**
	 * 获取预交金交易记录
	 * 
	 * @param cardNo 患者卡号
	 * @param patCode 患者编码
	 * @param beginDate 开始日期，格式：yyyy-MM-dd，如：2017-07-15
	 * @param endDate 结束日期，格式：yyyy-MM-dd，如：2017-07-15
	 * @throws BizException
	 */
	@Override
	public PrepayTradeRecord[] getPrepatTradeList(String cardNo, String patCode, String beginDate,
			String endDate) throws BizException{
		return null;
	}

	/**
	 * 通过记账编号获取患者除医保外的自付金额
	 * @param cdId
	 */
	@Override
	public double getPatAmtBycgId(String cgId) throws BizException{
		return 	0;
	}

	@Override
	public OpPayReturn pay(OpPayParam param) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpPayReturn payByEnt(OpPayParam param, InsurPriceInfo priceInfo,
			BlOrderAppendBillParamDTO[] appendBillParamDTOs)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayRecord[] getEntPayRecord(String patCode, Integer opTimes)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpPayInfo getOpPayDetail(String patCode, Integer opTimes,
			String applyCode) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardPersonInfoDTO getPersonByXml(String xmlStr) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DivideResultDTO getResultByXml(String xmlStr) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}
