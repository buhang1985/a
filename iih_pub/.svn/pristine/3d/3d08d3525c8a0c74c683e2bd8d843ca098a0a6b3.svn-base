package iih.ci.mr.pub.listener;

import iih.ci.mr.cideathcert.d.CideathcertDO;
import iih.ci.mr.cideathcert.d.desc.CideathcertDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public abstract class AbstractCideathcertDOUpdateAfterListener implements IBusinessListener {
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
		if(!(event.getSourceID().equals(CideathcertDODesc.CLASS_FULLNAME)
			&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
		
		CideathcertDO[] cideathcertDOs = (CideathcertDO[])((BDCommonEvent)event).getNewObjs();
		
		if(ArrayUtil.isEmpty(cideathcertDOs))return;
		//执行修改命令
		this.doActionCiMrDOChange(cideathcertDOs);
	}
	
	protected abstract void doActionCiMrDOChange(CideathcertDO[] cideathcertDOs) throws BizException;
}
