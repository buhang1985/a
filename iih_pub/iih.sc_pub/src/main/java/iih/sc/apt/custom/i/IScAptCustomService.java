package iih.sc.apt.custom.i;

import iih.sc.apt.scapt.d.ScAptDO;
import xap.mw.core.data.BizException;
/***
 * 预约客开类
 * @author fanlq
 * @date: 2020年2月14日 下午1:16:30
 */
public interface IScAptCustomService {
	/***
	 * @Description:取号前客开处理
	 * @return 不限制取号条件要返回true！！！！！！返回false将无法取号。。。。
	 * @throws BizException
	 */
	public boolean handle4TakeApptNoBefor(ScAptDO aptDO,String id_ent) throws BizException;
	
	/**
	 * BS003 消息客开处理
	 * @param obj
	 * @return
	 * @throws BizException
	 */
	public boolean handleWrapScApt4IeObj(Object obj) throws BizException;
}
