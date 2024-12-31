package iih.ci.mrqc.s.bp.task;


import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.s.MrPigeonholeUpdateAffair;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;

public class RecallAutoArchiveTask implements IBackgroundWorkPlugin {

	
	/**
	 * 已经审批的召回病历，如果超过截止时间自动归档
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		// TODO Auto-generated method stub
		
		MrPigeonholeUpdateAffair affair = new MrPigeonholeUpdateAffair();
		affair.updateStateWhenAutoPigeonhole();
		return null;
		
		
		
	}

}
