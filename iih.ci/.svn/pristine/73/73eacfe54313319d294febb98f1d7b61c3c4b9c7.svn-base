package iih.ci.mrm.s.mrmcatalog.bp;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCataListDTO;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCatalogerDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

public class IMrmCataSaveRepealBp extends PagingServiceImpl<MrmCataListDTO>{
	
	public  FBoolean SaveRepeal(MrmCataListDTO [] mrmcatalist) throws BizException{
		
		ICiamrCudService cservice = ServiceFinder.find(ICiamrCudService.class);
		ICiamrRService rservice = ServiceFinder.find(ICiamrRService.class);
		
		String [] arrIDEnt = new String [mrmcatalist.length];
		for(int i=0 ; i<mrmcatalist.length;i++){
			arrIDEnt[i]=mrmcatalist[i].getId_ent();
		}
		AMrDO [] Amrdo = rservice.findByAttrValStrings("Id_ent", arrIDEnt);
		
		String[] arrIdCata = new String [Amrdo.length];
		for(int i=0;i<Amrdo.length;i++){
			Amrdo[i].setId_user_catalogue(null);
			Amrdo[i].setStatus(DOStatus.UPDATED);
		}
		cservice.save(Amrdo);
		
		return null;
		
	}

}
