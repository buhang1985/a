package iih.bl.cg.i;

import iih.bl.cg.api.d.ApplyInfo;
import iih.bl.cg.api.d.PriceApplyInfo;
import iih.bl.cg.api.d.InsurPriceInfo;
import iih.bl.cg.api.d.OpPayInfo;
import iih.bl.cg.api.d.OpPayParam;
import iih.bl.cg.api.d.OpPayReturn;
import iih.bl.cg.api.d.PayRecord;
import iih.bl.cg.api.d.PrepayTradeRecord;
import iih.bl.cg.api.d.RechargeInfo;
import iih.bl.cg.api.d.RechargeResult;
import iih.bl.cg.api.d.ResultInfo;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.hp.divideresult.d.DivideResultDTO;
import iih.bl.hp.insurecard.d.CardPersonInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 门诊自助机对外服务
 * 
 * @author yankan
 * @since 2017-07-15
 *
 */
public interface IBlOpCgSelfExternalService {
	/**
	 * 获取申请单信息
	 * 
	 * @param patCode 患者编码
	 * @param patType 患者类型，0自费，1医保
	 * @param beginTime 开始时间 ,格式： yyyy-MM-dd HH:mm:ss。比如：2017-06-22 13:04:52
	 * @param endTime 结束时间 ,格式： yyyy-MM-dd HH:mm:ss。比如：2017-06-22 13:04:52
	 * @return 处方信息
	 * @throws BizException
	 */
	public abstract ApplyInfo[] getApplyInfo(String patCode, String patType, String beginTime, String endTime)
			throws BizException;

	/**
	 * 获取医保划价申请数据
	 * 
	 * @param priceInfo 医保划价信息
	 * @throws BizException
	 */
	public abstract PriceApplyInfo getInsurPriceInfo(InsurPriceInfo priceInfo) throws BizException;

	/**
	 * 医保划价
	 * 
	 * @param priceInfo 医保划价信息
	 * @return
	 * @throws BizException
	 */
	public abstract ResultInfo priceByInsur(InsurPriceInfo priceInfo) throws BizException;

	/**
	 * 门诊患者缴费
	 * 
	 * @param param 门诊付款信息
	 * @return
	 */
	public abstract OpPayReturn pay(OpPayParam param) throws BizException;
	/**
	 * 门诊患者挂号缴费调用
	 * 
	 * @param param 门诊付款信息
	 * @return
	 */
	public abstract OpPayReturn payByEnt(OpPayParam param,InsurPriceInfo priceInfo,BlOrderAppendBillParamDTO[] appendBillParamDTOs) throws BizException;

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
	public abstract PayRecord[] getPayRecord(String patCode, String beginTime, String endTime) throws BizException;

	/**
	 * 获取就诊交费信息
	 * 
	 * @param patCode 患者编码
	 * @param opTimes 就诊次数
	 * @return 缴费记录集合
	 * @throws BizException
	 * 
	 */
	public abstract PayRecord[] getEntPayRecord(String patCode, Integer opTimes) throws BizException;

	/**
	 * 获取门诊缴费列表
	 * 
	 * @param patCode 患者编码
	 * @param opTimes 就诊次数
	 * @param applyCode 申请单号
	 * @return
	 * @throws BizException
	 */
	public abstract OpPayInfo getOpPayDetail(String patCode, Integer opTimes, String applyCode) throws BizException;

	/**
	 * 充值
	 * 
	 * @param rechargeInfo 充值信息
	 * @return 充值结果
	 * @throws BizException
	 */
	public abstract RechargeResult recharge(RechargeInfo rechargeInfo) throws BizException;

	/**
	 * 获取预交金交易记录
	 * 
	 * @param cardNo 患者卡号
	 * @param patCode 患者编码
	 * @param beginDate 开始日期，格式：yyyy-MM-dd，如：2017-07-15
	 * @param endDate 结束日期，格式：yyyy-MM-dd，如：2017-07-15
	 * @throws BizException
	 */
	public abstract PrepayTradeRecord[] getPrepatTradeList(String cardNo, String patCode, String beginDate,
			String endDate) throws BizException;
	
	/**
	 * 通过记账编号获取患者除医保外的自付金额
	 * @param cdId
	 */
	public abstract double getPatAmtBycgId(String cgId) throws BizException;
	
	/**
	 * 解析医保卡xml信息
	 * 
	 * @param String XML
	 * @throws BizException
	 */
	public abstract CardPersonInfoDTO getPersonByXml(String xmlStr) throws BizException;
	/**
	 * 解析分摊xml信息
	 * 
	 * @param String xml
	 * @throws BizException
	 */
	public abstract DivideResultDTO getResultByXml(String xmlStr) throws BizException;
}
