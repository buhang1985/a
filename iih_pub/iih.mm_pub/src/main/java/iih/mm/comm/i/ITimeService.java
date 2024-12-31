package iih.mm.comm.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

public interface ITimeService {
	/**
	 * 获取系统日期
	 * @return 系统日期
	 * @throws BizException
	 */
	public FDate getSysDate() throws BizException;
	
	/**
	 * 获取系统日期时间
	 * @return 系统日期时间
	 * @throws BizException
	 */
	public FDateTime getSysDateTime() throws BizException;
}
