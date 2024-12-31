package iih.pi.reg.s.task;

import iih.pi.params.PiParams;
import iih.pi.reg.s.bp.PiSyncFromPsnBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRServiceExt;

/**
 * 
 * 从人员信息同步到患者信息定时任务
 * @author ly 2019/04/22
 *
 */
public class PiSyncFromPsnTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext context) throws BizException {
		
		PreAlertObject rlt = new PreAlertObject();
		
		IOrgRServiceExt orgService = ServiceFinder.find(IOrgRServiceExt.class);
		OrgDO[] orgDos =  orgService.queryAllOrgUnitVOs();
		
		if(ArrayUtil.isEmpty(orgDos))
			return rlt;
		
		PiParams piParams = new PiParams();
		PiSyncFromPsnBP syncBp = new PiSyncFromPsnBP();
		
		for (OrgDO orgDO : orgDos) {
			
			Context.get().setGroupId(orgDO.getId_grp());
			Context.get().setOrgId(orgDO.getId_org());
			Context.get().setGroupNumber(orgDO.getGroupno());
			
			FBoolean fgSync = piParams.PIPAT0029();
			if(FBoolean.FALSE.equals(fgSync))
				continue;
			
			IPsndocMDORService psnRService = ServiceFinder.find(IPsndocMDORService.class);
			PsnDocDO[] psnDos = psnRService.find("1=1", null, FBoolean.FALSE);
			
			if(ArrayUtil.isEmpty(psnDos))
				continue;
			
			syncBp.insert(psnDos);
		}
		
		return rlt;
	}
}
