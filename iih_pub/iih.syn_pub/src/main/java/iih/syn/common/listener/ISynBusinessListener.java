package iih.syn.common.listener;

import xap.mw.core.data.BizException;

/**
 * @Description:数据同步类插件
 * @author: xu_xing@founder.com.cn
 * @version：2018年5月7日 下午4:53:44 创建
 */
public abstract interface ISynBusinessListener {
	
	/**
	 * 数据同步手动处理插件
	 * @param objParam
	 * @throws BizException
	 */
	public abstract void doAction(Object... objParams) throws BizException;
}
