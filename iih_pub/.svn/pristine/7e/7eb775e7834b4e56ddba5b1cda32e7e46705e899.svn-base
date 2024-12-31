package iih.pe.listener;

import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import iih.pe.por.pepsnbinfo.d.desc.PePsnBInfoDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class PePsnAddAfterListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
		if(!(event.getSourceID().equals(PePsnBInfoDODesc.CLASS_FULLNAME) && event.getEventType().equals(IEventType.TYPE_INSERT_AFTER)))
			return;
				
		//体检客户基本资料
		PePsnBInfoDO[] psnDosNew = (PePsnBInfoDO[])((BDCommonEvent)event).getNewObjs();
		
		if(ArrayUtil.isEmpty(psnDosNew))return;
				
		//执行新增后的操作
		this.doActionPePsnInfoDOAdd(psnDosNew);
	}
	/**
	 * 体检客户新增后的处理
	 * @param psnDosNew
	 */
	private void doActionPePsnInfoDOAdd(PePsnBInfoDO[] psnDosNew) {
		
	}


}
