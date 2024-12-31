package iih.bd.srv.s.bp;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.srv.emrtpl.i.IEmrtplMDORService;
import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import iih.bd.srv.mrtplvt.d.MrtplvtAggDO;
import iih.bd.srv.mrtplvt.i.IMrtplvtCudService;
import iih.bd.srv.mrtplvt.i.IMrtplvtRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

public class MrvEmrExtServiceDeletebp {

	public void exec(MrtplVtDO dataObj) throws BizException {

		IEmrtplMDOCudService SaveEmrtplService = ServiceFinder.find(IEmrtplMDOCudService.class);
		IMrtplvtCudService SaveMrtplvtService = ServiceFinder.find(IMrtplvtCudService.class);

		IEmrtplMDORService FindEmrtplService = ServiceFinder.find(IEmrtplMDORService.class);
		IMrtplvtRService FindMrtplvtService = ServiceFinder.find(IMrtplvtRService.class);

		if(dataObj == null) {
			return;
		}
		if (!StringUtil.isEmpty(dataObj.getId_mrtplvt())) {

			MrtplvtAggDO AggDO = FindMrtplvtService.findById(dataObj.getId_mrtplvt());

			if (AggDO != null && !StringUtil.isEmpty(AggDO.getParentDO().getId_mrtpl())) {

				EmrTplDO MrtplDO = FindEmrtplService.findById(AggDO.getParentDO().getId_mrtpl());

				AggDO.getParentDO().setStatus(DOStatus.DELETED);

				SaveMrtplvtService.logicDelete(new MrtplvtAggDO[] { AggDO });

				if (MrtplDO != null) {

					MrtplDO.setStatus(DOStatus.DELETED);

					SaveEmrtplService.logicDelete(new EmrTplDO[] { MrtplDO });

				}
			}

		}
	}
}
