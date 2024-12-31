package iih.bd.mm.mmalert.bp;

import java.util.Map;

import iih.mm.common.MMParams;
import iih.mm.qy.validperiod.d.ValidPeriodView;
import iih.mm.qy.validperiod.i.IValidperiodRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;

public class FindExpiDataBp {
	
	public static ValidPeriodView[] queryExpiData(BgWorkingContext bgwc) throws BizException {
		
		Map<String, Object> map = bgwc.getKeyMap();
		String id_grp = (String) map.get("id_grp");
		String id_org = (String) map.get("id_org");
		Context.get().setGroupId(id_grp);
		Context.get().setOrgId(id_org);
		
		IValidperiodRService validPerRSrv = ServiceFinder.find(IValidperiodRService.class);
		String whrStr = String.format("id_grp = '%s' and id_org = '%s' and invalid_dt <= %d", 
				Context.get().getGroupId(), Context.get().getOrgId(), MMParams.MMDG0006());
		ValidPeriodView[] DOList = validPerRSrv.find(whrStr, "a0.invalid_dt", new FBoolean(false));
		
		return DOList;
	}
}
