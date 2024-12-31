package iih.bd.srv.scanformat.i;

import xap.mw.core.data.BizException;

/**
* 扫描格式扩展服务
*/
public interface IScanformatExtService {
	
	/**
	 * 获取扫描格式排序
	 * @return
	 * @throws BizException
	 */
	public abstract int getMaxNo() throws BizException;
}