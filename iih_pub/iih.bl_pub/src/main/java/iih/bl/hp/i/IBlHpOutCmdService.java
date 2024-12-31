package iih.bl.hp.i;

import xap.mw.core.data.BizException;

/**
 * 医保对外命令服务
 * @author yankan
 * @since 2017-08-31
 *
 */
public interface IBlHpOutCmdService {

	/**
	 * 医保身份转换后更新数据
	 * @param entId 就诊id
	 * @throws BizException
	 * @author ly 2018/10/05
	 */
	public abstract void updteAfterChangeHpIdentity(String entId) throws BizException;
	
}
