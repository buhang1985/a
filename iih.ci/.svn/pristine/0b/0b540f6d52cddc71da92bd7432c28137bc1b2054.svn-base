package iih.ci.mr.s.listener;

import iih.ci.mr.mrsurdataclassi.i.IMrsurdataclassiExtService;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.AbstractOrSignCancelListener;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class SurgicalWithdrawListener extends AbstractOrSignCancelListener{

	@Override
	protected void doYourActionAfterOrSignCancel(CiOrderDO[] ors) throws BizException {
	
		if (ors==null||ors.length<=0) return;
		
		IMrsurdataclassiExtService service=ServiceFinder.find(IMrsurdataclassiExtService.class);
		ICiorappsurgeryMDORService orderService=ServiceFinder.find(ICiorappsurgeryMDORService.class);
		for (int j = 0; j < ors.length; j++) {
			CiOrderDO ciorderdo=ors[j];
			OrdApOpDO[] opDOs = orderService.find("id_or='"+ciorderdo.getId_or()+"'", "sv", FBoolean.FALSE);
			FDateTime time=null;
			if(opDOs!=null && opDOs.length>0){
			    time=opDOs[0].getDt_plan();
			}
			String id_ent=ciorderdo.getId_en();
			String name=ciorderdo.getName_or();
			String innercode=ciorderdo.getInnercode_srvca();
			service.deleteSurgicalClassification(id_ent, name, innercode, time);
		}
	}
}
