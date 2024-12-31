package iih.bd.srv.medsrv.i;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医疗服务扩展查询服务
 * 
 * @author hao_wu
 *
 */
public interface IMedSrvExtRService {

	/**
	 * 使用医疗服务主键查询医疗服务信息
	 * 
	 * @param medsrvId
	 * @return
	 * @throws BizException
	 */
	public abstract MedsrvAggDO FindMedSrvAggById(String medsrvId) throws BizException;

	/**
	 * 使用主键数组查询医疗服务信息(保持主键顺序)
	 * 
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	public abstract MedsrvAggDO[] FindByIdsAndLength(String[] ids, FBoolean isLazy) throws BizException;
}
