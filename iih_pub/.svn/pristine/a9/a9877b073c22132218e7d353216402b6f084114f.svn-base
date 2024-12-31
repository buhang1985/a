package iih.mp.nr.splitplan.i;

import xap.mw.core.data.BizException;

public interface IResponseOrderHandelService {

	/**
	 * 执行域响应医嘱停止操作
	 * 
	 * @param id_ors
	 * @throws BizException
	 */
	public abstract Integer responseOrStop(String[] id_ors) throws BizException;

	/**
	 * 执行域响应医嘱作废操作
	 * 
	 * @param id_ors
	 * @throws BizException
	 */
	public abstract Integer responseOrInvalid(String[] id_ors) throws BizException;

	/**
	 * 响应医嘱停止时间变更
	 */
	public abstract Integer responseOrEndChanged(String[] id_ors) throws BizException;

	/**
	 * 响应门诊医嘱(作废，删除)
	 */
	public abstract void responseOpOrCancel(String[] id_ors) throws BizException;
}
