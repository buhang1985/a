/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.pub.listener;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.d.desc.AMrDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public abstract class AbstractCiAMrDOUpdateAfterListener implements IBusinessListener{
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
				if(!(event.getSourceID().equals(AMrDODesc.CLASS_FULLNAME)
					&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
				
				//病历文书记录
				AMrDO[] aMrDOs = (AMrDO[])((BDCommonEvent)event).getNewObjs();
				
				
				if(ArrayUtil.isEmpty(aMrDOs))return;
				
				//执行修改命令
				this.doActionCiAMrDOChange(aMrDOs);
		
	}
	
	/**
	 * 病案
	 * @param ciMrDOs
	 * @throws BizException 
	 */
	protected abstract void doActionCiAMrDOChange(AMrDO[] aMrDOs) throws BizException;
}
