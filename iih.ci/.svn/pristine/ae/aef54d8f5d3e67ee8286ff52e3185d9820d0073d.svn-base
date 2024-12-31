package iih.ci.mr.mrevent.s.bp;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.s.util.MrCommonUtils;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;

public class MrEventMaintainBp {
	/**
	 * 提交病案首页放出病案首页提交事件
	 * @param ciMrFpDto 病案首页dto
	 * @return
	 * @throws BizException
	 */
	public Boolean FireMrfpSubmitEvent(CiMrFpDTO ciMrFpDto) throws BizException {
		if(ciMrFpDto != null){
			CiMrFpDTO[] ciMrFpDtos = new CiMrFpDTO[]{ciMrFpDto};
			MrCommonUtils.fireBDEvent(IMrEventConst.EVENT_SOURCE_MRFP_SUBMIT, IEventType.TYPE_UPDATE_AFTER, ciMrFpDtos);
			return true;
		}
		return false;
	}
	/**
	 * 病历提交放出病历提交事件
	 * @param ciMrDo 病历do
	 * @return
	 * @throws BizException
	 */
	public Boolean FireMrSubmitEvent(CiMrDO ciMrDo) throws BizException {
		if(ciMrDo != null){
			CiMrDO[] ciMrDos = new CiMrDO[]{ciMrDo};
			MrCommonUtils.fireBDEvent(IMrEventConst.EVENT_SOURCE_MR_SUBMIT, IEventType.TYPE_UPDATE_AFTER, ciMrDos);
			return true;
		}
		return false;
	}

	/**
	 * 病历保存放出病历保存事件
	 * @param ciMrDo 病历do
	 * @return
	 * @throws BizException
	 */
	public Boolean FireMrSavedEvent(CiMrDO ciMrDo) throws BizException {
		if(ciMrDo != null){
			CiMrDO[] ciMrDos = new CiMrDO[]{ciMrDo};
			MrCommonUtils.fireBDEvent(IMrEventConst.EVENT_SOURCE_MR_SAVED, IEventType.TYPE_UPDATE_AFTER, ciMrDos);
			return true;
		}
		return false;
	}
	
	/**
	 * 病历删除放出病历删除事件
	 * @param ciMrDo 病历do
	 * @return
	 * @throws BizException
	 */
	public Boolean FireMrDeleteEvent(CiMrDO ciMrDo) throws BizException {
		if(ciMrDo != null){
			CiMrDO[] ciMrDos = new CiMrDO[]{ciMrDo};
			MrCommonUtils.fireBDEvent(IMrEventConst.EVENT_SOURCE_MR_DELETE, IEventType.TYPE_UPDATE_AFTER, ciMrDos);
			return true;
		}
		return false;
	}


}
