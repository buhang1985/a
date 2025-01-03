package iih.ci.mr.mrevent.s;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.mrevent.i.IMrEventMaintainService;
import iih.ci.mr.mrevent.s.bp.MrEventMaintainBp;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = {IMrEventMaintainService.class }, binding = Binding.JSONRPC)
public class MrEventMaintainServiceImpl implements IMrEventMaintainService{
	/**
	 * 提交病案首页放出病案首页提交事件
	 * @param ciMrFpDto 病案首页dto
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean FireMrfpSubmitEvent(CiMrFpDTO ciMrFpDto) throws BizException {
		MrEventMaintainBp mrEventMaintainBp = new MrEventMaintainBp();
		return mrEventMaintainBp.FireMrfpSubmitEvent(ciMrFpDto);
	}
	/**
	 * 病历提交放出病历提交事件
	 * @param ciMrDo 病历do
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean FireMrSubmitEvent(CiMrDO ciMrDo) throws BizException {
		MrEventMaintainBp mrEventMaintainBp = new MrEventMaintainBp();
		return mrEventMaintainBp.FireMrSubmitEvent(ciMrDo);
	}
	/**
	 * 病历保存放出病历保存事件
	 * @param ciMrDo 病历do
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean FireMrSavedEvent(CiMrDO ciMrDo) throws BizException {
		MrEventMaintainBp mrEventMaintainBp = new MrEventMaintainBp();
		return mrEventMaintainBp.FireMrSavedEvent(ciMrDo);
	}
	/**
	 * 病历删除放出病历删除事件
	 * @param ciMrDo 病历do
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean FireMrDeleteEvent(CiMrDO ciMrDo) throws BizException {
		MrEventMaintainBp mrEventMaintainBp = new MrEventMaintainBp();
		return mrEventMaintainBp.FireMrDeleteEvent(ciMrDo);
	}

}
