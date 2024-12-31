package iih.en.pv.out.i;

import iih.en.pv.out.d.EnOpRegistBean;
import xap.mw.core.data.BizException;

/**
 * 就诊对应急系统接口
 * 
 * @author liubin
 *
 */
public interface IEn4ESCmdService {
	/**
	 * 上传挂号信息
	 * 
	 * @param opRegistInfo
	 * @throws BizException
	 */
	public abstract void uploadOpRegist(EnOpRegistBean opRegistInfo) throws BizException;
}
