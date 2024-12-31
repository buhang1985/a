package iih.mp.dg.i;

import xap.mw.core.data.BizException;

/**
 * @TODO 药品执行门诊主服务(针对第三方),实现类在各个客开
 * @author dj.zhang
 * @time 2019年2月25日 下午3:12:45
 */
public interface IMpDgOpPLMainService {

	/**
	 * 调用第三方接口获取窗口号，实现类在各个客开
	 * 
	 * @param presIds
	 * @throws BizException
	 */
	public abstract String getWinNoFromPL(String[] prestIds) throws BizException;

	/**
	 * 签到机提供患者队列信息，供HIS更新患者列表
	 * 
	 * @param presIds
	 * @throws BizException
	 */
	public abstract String addDispenseQueWithSite(String patInfoXml) throws BizException;

	/**
	 * 草药颗粒，包药机使用
	 * 
	 * @param presId
	 * @return
	 * @throws BizException
	 */
	public abstract void sendPresToPackMachine(String presId, boolean isAuto) throws BizException;
}
