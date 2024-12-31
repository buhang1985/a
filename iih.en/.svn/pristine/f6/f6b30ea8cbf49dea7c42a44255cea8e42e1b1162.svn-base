package iih.en.pv.s.bp.ippre.qry;

import iih.bl.cg.i.IBlCgForEnService;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.s.bp.ippre.IppreTransHosCheckBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetIppreTransHosCheckBP {
	
	public EnIppreInfoDTO exec(EnIppreInfoDTO infoDto) throws BizException{
		IppreTransHosCheckBP bp = new IppreTransHosCheckBP();
		bp.exec(new EnIppreInfoDTO[]{infoDto});
		return infoDto;
	}
	
	/**
	 * 校验是否有费用转到门诊
	 * @param idEnt
	 * @param isOep
	 * @return
	 * @throws BizException
	 */
	public FBoolean isPreIpTrans(String idEnt, FBoolean isOep) throws BizException{
		
		IBlCgForEnService iEnService = ServiceFinder.find(IBlCgForEnService.class);
		return iEnService.isPreipTransf(idEnt, isOep);
	}
	
}
