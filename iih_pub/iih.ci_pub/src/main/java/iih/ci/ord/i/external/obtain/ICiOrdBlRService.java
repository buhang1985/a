package iih.ci.ord.i.external.obtain;

import java.util.Map;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.ci.ord.i.external.obtain.meta.bl.PrePaidAccAmt4CiDTO;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 调用费用相关接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdBlRService {

	/**
	 * 判断是否可以使用预交金 (北京市医保不支持预交金，高端商保记账不支持预交金)
	 * 
	 * @param patId 患者ID
	 * @param entId 就诊ID
	 * @param bizType 业务场景类型，暂为空，（后续可参考：iih.bl.pay.prepay.d.EuPrepayBizType）
	 * @return FBoolean
	 * @throws BizException
	 */
	public abstract FBoolean isPatUsePrePay(String patId, String entId, String bizType) throws BizException;

	/**
	 * 临床医嘱选择服务，服务价格计算 单服务价格计算
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MedSrvPriceDO ciOrBdSrvPriceCalByPriMode(BdSrvPriCalParamDTO param, String id_pripat)
			throws BizException;

	/**
	 * 临床医嘱选择服务，服务价格计算 单服务价格计算
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract FDouble ciOrBdSrvPriceCal(BdSrvPriCalParamDTO param) throws BizException;

	/**
	 * 临床医嘱服务价格计算 批量服务价格计算
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract FMap ciOrBdSrvPricesCal(BdSrvPriCalParamDTO[] params) throws BizException;
	/**
	 * 根据服务id,物品id 批量获取医保信息
	 * 
	 * @param idSrvIdmmMap
	 * @return
	 * @throws BizException
	 */
	public abstract Map<String, HPSrvorcaDO> getHpSrvorcaByIdSrvs(String idHp, Map<String, String> idSrvIdmmMap)
			throws BizException;

	/**
	 * 根据服务id,物品id 获取医保信息
	 * 
	 * @param idSrv 服务id
	 * @param idMm 物品id
	 * @return
	 * @throws BizException
	 */
	public abstract HPSrvorcaDO getHpSrvorcaBySrvMm(String idHp, String idSrv, String idMm) throws BizException;
	
	/**
	 * 根据服务项目id获取费用项目是否结算
	 * @param idOrSrvs
	 * @return key id_orsrv value Y 结算， N 未结算
	 * @throws BizException
	 */
	public abstract Map<String, FBoolean> getOrSrvBlStatus(String[] idOrSrvs) throws BizException;
	
	/**
	 * 获取待记账的医嘱id集合
	 * @param idEn
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	public String[] getWaitingAccountIdOrSrv(String idEn , String codeEntp , String idDepMp) throws BizException;
	/**
	 * 获取患者预交金查询判断是否欠费
	 * @return
	 * @throws BizException
	 */
	public PrePaidAccAmt4CiDTO GetPatAccJudge(String code_entp, String id_en, String id_pat,String id_patca) throws BizException;
}
