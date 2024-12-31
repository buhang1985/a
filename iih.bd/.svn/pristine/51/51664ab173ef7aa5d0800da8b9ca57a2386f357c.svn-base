package iih.bd.srv.s.bp;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import iih.bd.srv.mrtplvt.d.MrtplvtAggDO;
import iih.bd.srv.mrtplvt.i.IMrtplvtCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class MrvEmrExtServiceSavebp {

	public MrtplVtDO exec(MrtplvtAggDO AggDO, EmrTplDO MrtplDO) throws BizException {

		IEmrtplMDOCudService emrtplDoService = ServiceFinder.find(IEmrtplMDOCudService.class);
		IMrtplvtCudService aggDoService = ServiceFinder.find(IMrtplvtCudService.class);

		if (AggDO != null && MrtplDO != null) {

			if (MrtplDO.getStatus() == DOStatus.NEW) {

				MrtplDO.setId_org(Context.get().getOrgId());
				MrtplDO.setId_grp(Context.get().getGroupId());
			}
			
			EmrTplDO[] SavedMrtplDO = emrtplDoService.save(new EmrTplDO[] { MrtplDO });

			if (SavedMrtplDO != null && SavedMrtplDO.length == 1) {

				AggDO.getParentDO().setId_mrtpl(SavedMrtplDO[0].getId_mrtpl());

				aggDoService.save(new MrtplvtAggDO[] { AggDO });
			}

			return AggDO.getParentDO();
		}
		return null;
	}
}
