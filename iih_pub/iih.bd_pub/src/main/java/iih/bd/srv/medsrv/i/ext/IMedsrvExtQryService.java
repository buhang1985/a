package iih.bd.srv.medsrv.i.ext;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.core.data.BizException;

/**
 * 医疗服务扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMedsrvExtQryService {

	/**
	 * 根据id值查找医疗服务数据
	 */
	public abstract MedsrvAggDO findById(String id) throws BizException;
}
