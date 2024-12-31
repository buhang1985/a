package iih.en.comm.ep;

import iih.en.comm.util.EnAppUtils;
import iih.en.pv.enres.d.EnOrgDO;
import iih.en.pv.enres.i.IEnorgCudService;
import iih.en.pv.enres.i.IEnorgRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊组织EP
 * @author yankan
 *
 */
public class EntOrgEP {	
	/**
	 * 结束当前使用科室
	 * @param entId
	 * @throws BizException
	 */
	public void endOrg(String entId) throws BizException{
		//更新旧机构
		IEnorgRService retrieveService = ServiceFinder.find(IEnorgRService.class);
		IEnorgCudService cudService = ServiceFinder.find(IEnorgCudService.class);
		String whereStr = String.format("id_ent=%s AND dt_e=null", entId);
		EnOrgDO[] oriDOs = retrieveService.find(whereStr,"",FBoolean.FALSE);
		if(oriDOs!=null){
			EnOrgDO oriDO = oriDOs[0];
			FDateTime curTime = EnAppUtils.getServerDateTime();
			oriDO.setDt_e(curTime);//结束日期为当期时间
			cudService.save(new EnOrgDO[]{(oriDO)});			
		}
	}
	/**
	 * 更新就诊机构
	 * @param orgDO 就诊机构
	 * @throws BizException 
	 */
	public void changeOrg(EnOrgDO orgDO) throws BizException{
		this.endOrg(orgDO.getId_ent());
		
		//新增机构		
		IEnorgCudService cudService = ServiceFinder.find(IEnorgCudService.class);
		cudService.insert(new EnOrgDO[]{orgDO});		
	}
	
}
