package iih.sc.apt.custom.s;

import iih.sc.apt.custom.i.IScAptCustomService;
import iih.sc.apt.scapt.d.ScAptDO;
import xap.mw.core.data.BizException;
/***
 * 预约客开实现类
 * @author fanlq
 * @date: 2020年2月14日 下午1:17:42
 */
public class ScAptCustomBaseService implements IScAptCustomService{

	/***
	 * @Description:取号前客开处理
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean handle4TakeApptNoBefor(ScAptDO aptDO,String id_ent) throws BizException {
		return true;
	}
	/**
	 * BS003消息客开处理
	 */
	@Override
	public boolean handleWrapScApt4IeObj(Object obj) throws BizException {
		// TODO Auto-generated method stub
		return false;
	}
}
