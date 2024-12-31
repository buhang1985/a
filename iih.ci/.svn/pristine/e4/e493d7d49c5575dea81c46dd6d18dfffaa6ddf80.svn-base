package iih.ci.mr.s.listener;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.en.pv.i.IEnOutCmdService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class AbstractCiAMrDOPigeListener extends AbstractCiAMrDOUpdateAfterListener {

	@Override
	protected void doActionCiAMrDOChange(AMrDO[] aMrDOs) throws BizException {
		
		if(aMrDOs==null||aMrDOs.length<=0)
		{
			return;
		}
		
		if(aMrDOs!=null)
		{
			
			for(AMrDO amrDO :aMrDOs)
			{
				if(amrDO.getSd_qa_doctor_part_sta()==null||!amrDO.getSd_qa_doctor_part_sta().equals("09"))
				{
					return;
				}
				
				IEnOutCmdService enOutCmdServiceImpl = ServiceFinder.find(IEnOutCmdService.class);
				
				enOutCmdServiceImpl.updateArchiveFlag(amrDO.getId_ent(), FBoolean.TRUE);
			}
		}
	}

}
