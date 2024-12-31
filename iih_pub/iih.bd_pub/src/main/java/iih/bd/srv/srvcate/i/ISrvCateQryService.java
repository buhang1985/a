package iih.bd.srv.srvcate.i;

import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 服务分类查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface ISrvCateQryService {

	/**
	 * 根据服务类型编码组和查询服务分类
	 * 
	 * @param sdSrvTps
	 *            服务类型编码组
	 * @param orderStr
	 *            排序字段
	 * @param isLazy
	 *            懒加载
	 * @return
	 * @throws BizException
	 */
	public abstract SrvCateDO[] find(String[] sdSrvTps, String orderStr, FBoolean isLazy) throws BizException;
}
