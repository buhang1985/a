package iih.ci.event.ord.reissue.action.ris.pathy;

import iih.ci.event.ord.bps.sign.op.listenerbp.OpPathSignStandardBP;
import iih.ci.event.ord.bps.sign.op.listenerbp.OpRisSignStandardBP;
import iih.ci.event.ord.reissue.common.ReissueCommonBP;
import iih.ci.event.ord.utils.IOrdEventParams;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class OpReissuePathyBP extends ReissueCommonBP{
	
	public OpReissuePathyBP() {
		
		String pathParam="";
		try {
			pathParam=ParamsetQryUtil.getParaString(Context.get().getOrgId(), IOrdEventParams.ORD_EVENT_PATH_PATTERN);
		} catch (Exception e) {
			pathParam="01";//出异常 默认002
		}
		if ("01".equals(pathParam)) {
			this.listener = new OpRisSignStandardBP();
		} else if ("02".equals(pathParam)) {
			this.listener = new OpPathSignStandardBP();
		}
	}
}
