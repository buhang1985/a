package iih.ci.mrm.s.mrmcatalog.bp;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 扼要说明
 * @author 张静波
 * @date 2018年9月6日 下午8:19:11
 */
public class MrmCataListMainSubmitBP {
	/**
	 * 提交病案编目
	 * @param id_ent 就诊号
	 * @param id_cata_user 编目人
	 * @param id_cata_dep 编目科室
	 * @return
	 * @throws BizException 
	 */
	public FBoolean cataLogSubmit(String id_ent,String id_cata_user,String id_cata_dep) throws BizException
	{
		FBoolean isSuc = null;
		ICiamrRService serR = ServiceFinder.find(ICiamrRService.class);
		ICiamrCudService  serCud = ServiceFinder.find(ICiamrCudService.class);
		AMrDO[]  amrs = serR.findByAttrValString("Id_ent", id_ent);
		if(amrs!=null&&amrs.length>0)
		{
			for(AMrDO amr:amrs)
			{
				amr.setId_user_catalogue(id_cata_user);
				amr.setId_dep_catalogue(id_cata_dep);
				amr.setDt_catalogue(new FDateTime());
				amr.setStatus(DOStatus.UPDATED);
			}
			AMrDO[]  arrAmrs  = serCud.save(amrs);
			if(arrAmrs!=null&&arrAmrs.length == amrs.length)
				isSuc = FBoolean.TRUE;
			else
				isSuc = FBoolean.FALSE;
		}
		return isSuc;
	}
}
