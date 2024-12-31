package iih.bd.pp.medsrvrealpriceqry.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;

/**
 * 医疗服务真实价格查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMedSrvRealPriceQryService {

	/**
	 * 根据医疗服务主键集合查询真实价格字典</br>
	 * 推荐使用 FMap findMedSrvRefPriMapByIds(String[] medSrvIds)
	 * 
	 * @param medSrvIds
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public abstract FMap2 FindMedSrvRealPriMapByIds(String[] medSrvIds) throws BizException;

	/**
	 * 根据医疗服务主键集合查询参考价格字典
	 * 
	 * @param medSrvIds 医疗服务主键
	 * @return
	 * @throws BizException
	 */
	public abstract FMap findMedSrvRefPriMapByIds(String[] medSrvIds) throws BizException;

}
