package iih.bd.srv.srvcate.s;

import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.i.ISrvCateQryService;
import iih.bd.srv.srvcate.s.bp.FindSrvCateBySrvTpsBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 服务分类查询服务
 * 
 * @author hao_wu
 *
 */
public class SrvCateQryServiceImpl implements ISrvCateQryService {

	/**
	 * 根据服务类型编码组和数据权限查询服务分类
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
	@Override
	public SrvCateDO[] find(String[] sdSrvTps, String orderStr, FBoolean isLazy) throws BizException {
		FindSrvCateBySrvTpsBp bp = new FindSrvCateBySrvTpsBp();
		SrvCateDO[] result = bp.exec(sdSrvTps, orderStr, isLazy);
		return result;
	}

}
