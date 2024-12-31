package iih.bl.st.opfeeout.bp.qry;

import iih.bl.hp.blinterfaceacttime.d.BlInterfaceActTimeDO;
import iih.bl.hp.blinterfaceacttime.i.IBlinterfaceacttimeRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class QryLastedFeeOutDate {

	public FDateTime exec() throws BizException {
			
		IBlinterfaceacttimeRService service = ServiceFinder.find(IBlinterfaceacttimeRService.class);
		BlInterfaceActTimeDO[] actDos = service.find("1=1", "dt_act desc", FBoolean.TRUE);
		if(ArrayUtil.isEmpty(actDos)) {
			return null;
		}
		return actDos[0].getDt_act();
	}
}
