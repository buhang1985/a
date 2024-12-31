package iih.bd.srv.mrmtype.i;

import xap.mw.core.data.BizException;

/**
* 病案分类扩展服务
*/
public interface IMrmtypeExtService {
	
	/**
	 * 获取病案分类排序
	 * @param idStr
	 * @param isentp 就诊类型为true,科室类型为false
	 * @return
	 * @throws BizException
	 */
	public abstract int getMaxNo(String idStr, Boolean isentp) throws BizException;
}