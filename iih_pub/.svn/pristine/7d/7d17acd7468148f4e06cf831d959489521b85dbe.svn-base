package iih.ci.mr.pub.listener;

import iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO;
import iih.ci.mrfp.other2mrfp.d.Other2mrfpAggDO;
import iih.ci.mrfp.other2mrfp.d.desc.CiMrFpOtherDODesc;
import iih.ci.mrfp.other2mrfp.d.desc.Other2mrfpAggDODesc;
import iih.ci.mrfp.pat2mrfp.d.desc.CiMrFpPatDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public abstract class AbstractCiAmrOtherDoUpdateAfterListener implements IBusinessListener {
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
				if(!(event.getSourceID().equals("iih.ci.mrfp.other2mrfp.d.Other2mrfpAggDO")
					&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
				
				//病历文书记录
				Other2mrfpAggDO[] CiMrFpOtherDOs = (Other2mrfpAggDO[])((BDCommonEvent)event).getNewObjs();
				
				
				if(ArrayUtil.isEmpty(CiMrFpOtherDOs))return;
				
				//执行修改命令
				this.doActionCiAMrDOChange(new CiMrFpOtherDO[]{ CiMrFpOtherDOs[0].getParentDO()});
		
	}
	
	/**
	 * 病案
	 * @param ciMrDOs
	 * @throws BizException 
	 */
	protected abstract void doActionCiAMrDOChange(CiMrFpOtherDO[] CiMrFpOtherDOs) throws BizException;
}
