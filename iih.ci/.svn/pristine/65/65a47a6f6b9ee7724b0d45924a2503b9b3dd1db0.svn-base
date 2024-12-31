package iih.ci.mrm.s.mrmcatalog.bp;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author 张静波
 * @date 2018年8月27日 下午2:46:42
 * 
 */
public class MrmCataListRecallBP {
	
	/**
	 * 召回（分配）编目记录，分派给某人
	 * @param id_ent
	 * @param id_current_sign_off
	 * @return
	 * @throws BizException 
	 */
	public FBoolean reCallMrmCataRecord(String[] id_ent,
			String id_user_catalogue,String id_dep_catalogue) throws BizException {
		// TODO Auto-generated method stub
		if(id_ent!=null)
		{
			ICiamrRService serR = ServiceFinder.find(ICiamrRService.class);
			ICiamrCudService  serCud = ServiceFinder.find(ICiamrCudService.class);
			AMrDO[]  amrs = serR.findByAttrValStrings("Id_ent", id_ent);
			if(amrs!=null)
			{
				for(AMrDO amr : amrs)
				{
					amr.setId_user_catalogue(id_user_catalogue);;
					amr.setId_dep_catalogue(id_dep_catalogue);
					amr.setDt_catalogue(null);
					amr.setStatus(DOStatus.UPDATED);
				}
				AMrDO[] results = serCud.update(amrs);
				if(results!=null &&results.length == amrs.length)
					return FBoolean.TRUE;
				else
					return FBoolean.FALSE;
			}
			else
				return null;
		}
		else 
			return null;
		
		
	}
}
