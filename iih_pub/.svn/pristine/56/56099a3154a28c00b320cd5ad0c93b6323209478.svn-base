package iih.ci.mr.mrevent.i;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import xap.mw.core.data.BizException;

public interface IMrEventMaintainService {
	/**
	 * 提交病案首页放出病案首页提交事件
	 * @param ciMrFpDto 病案首页dto
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean FireMrfpSubmitEvent(CiMrFpDTO ciMrFpDto) throws BizException;
	/**
	 * 病历提交放出病历提交事件
	 * @param ciMrDo 病历do
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean FireMrSubmitEvent(CiMrDO ciMrDo) throws BizException;
	/**
	 * 病历保存放出病历保存事件
	 * @param ciMrDo 病历do
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean FireMrSavedEvent(CiMrDO ciMrDo) throws BizException;
	/**
	 * 病历删除放出病历删除事件
	 * @param ciMrDo 病历do
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean FireMrDeleteEvent(CiMrDO ciMrDo) throws BizException;

}
