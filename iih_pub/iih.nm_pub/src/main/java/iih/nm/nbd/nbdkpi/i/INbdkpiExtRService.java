package iih.nm.nbd.nbdkpi.i;

import xap.mw.core.data.BizException;

/**
* 指标定义扩展服务
* @author guoyang
*/
public interface INbdkpiExtRService {
	
	/**
	 * 获取指标定义排序
	 * @return
	 * @throws BizException
	 */
	public abstract int getMaxNo() throws BizException;
}