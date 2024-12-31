package iih.bd.pp.i;

import java.util.Map;

import iih.bd.pp.mpayratiodf.d.MPayRatioDfDO;
import iih.bd.pp.srvmpayratio.d.SrvMPayRatioDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医保查询服务接口
 * @author yankan
 * @since 2017-07-10
 *
 */
public interface IBdHpQryService {
	/**
	 * 是否自费诊断
	 * @param hpId 医保计划ID
	 * @param entpCode 就诊类型编码
	 * @param diIds 诊断ID集合
	 * @return map，【key: 诊断ID，value: FBoolean】
	 * @throws BizException
	 * @author yankan
	 */
	public abstract Map<String,FBoolean> isSelfPaidDi(String hpId,String entpCode,String[] diIds) throws BizException;
	
	/**
	 * 获取多支付比例集合
	 * @param hpId 医保计划ID
	 * @param srvId 服务ID或物品ID
	 * @param isMm 是否物品
	 * @throws BizException
	 * @return
	 * @author yankan
	 */
	public abstract MPayRatioDfDO[] getSrvPayRatioList(String hpId,String srvId,FBoolean isMm) throws BizException;
	/**
	 * 获取所有服务多支付比例集合
	 * @return
	 * @author yankan
	 */
	public abstract SrvMPayRatioDO[] getAllSrvMutiPayRatio() throws BizException; 
	/**
	 * 转换为多支付比例的医保编码
	 * @param hpId 医保计划ID
	 * @param srvId 服务ID或物品ID
	 * @param mpayRatioId 多支付比例ID
	 * @param isMm 是否物品
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	public abstract String transToRatioHpCode(String hpId,String srvId,String mpayRatioId,FBoolean isMm) throws BizException;
	/**
	 * 获取所有多支付比例集合
	 * @return
	 * @author yankan
	 */
	public abstract MPayRatioDfDO[] getAllMutiPayRatioList() throws BizException; 
	/**
	 * 获取医保服务限制诊断集合
	 * @param hpId 医保计划ID
	 * @param srvIds 服务ID集合 
	 * @return map，【key:服务ID,value:List<诊断ID>】
	 * @throws BizException
	 * @author yankan
	 */
	public abstract FMap getHpSrvCtrDiList(String hpId,String[] srvIds) throws BizException;
}
