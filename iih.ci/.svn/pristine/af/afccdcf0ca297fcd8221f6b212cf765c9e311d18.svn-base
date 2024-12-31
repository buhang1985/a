package iih.ci.event.ord.reissue.action.ris.pathy;

import iih.ci.event.ord.bps.sign.ip.listenerbp.IpPathSignStandardBP;
import iih.ci.event.ord.bps.sign.ip.listenerbp.IpRisSignStandardBP;
import iih.ci.event.ord.reissue.common.ReissueCommonBP;
import iih.ci.event.ord.utils.IOrdEventParams;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class IpReissuePathyBP extends ReissueCommonBP{
	
	public IpReissuePathyBP() {
		
		String pathParam="";
		try {
			pathParam=ParamsetQryUtil.getParaString(Context.get().getOrgId(), IOrdEventParams.ORD_EVENT_PATH_PATTERN);
		} catch (Exception e) {
			pathParam="01";
		}
		if ("01".equals(pathParam)) {
			this.listener = new IpRisSignStandardBP();
		} else if ("02".equals(pathParam)) {
			this.listener = new IpPathSignStandardBP();
		}
	}
}
