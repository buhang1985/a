package iih.pe.listener;

import iih.pe.papt.pepsnappt.d.desc.PePsnApptDODesc;
import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class PePsnUpdateAfterListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!(event.getSourceID().equals(PePsnApptDODesc.CLASS_FULLNAME) && event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
	
	
	PePsnBInfoDO[] psnDosNew = (PePsnBInfoDO[])((BDCommonEvent)event).getNewObjs();
	PePsnBInfoDO[] psnDosOld = (PePsnBInfoDO[])((BDCommonEvent)event).getOldObjs();
	
	if(ArrayUtil.isEmpty(psnDosNew)||ArrayUtil.isEmpty(psnDosOld))return;
	
	//执行状态修改后体检报告信息上传操作
	this.doActionPePsnDOChange(psnDosNew,psnDosOld);
	}
/**
 * 
 * @param apptPsnDosNew
 * @param apptPsnDosOld
 */
	private void doActionPePsnDOChange(PePsnBInfoDO[] psnDosNew, PePsnBInfoDO[] psnDosOld) {
		
	}
}
