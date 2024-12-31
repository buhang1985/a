package iih.ci.mrm.s.mrmcatalog.bp;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCataListDTO;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCatalogerDTO;
import iih.ci.mrm.i.mrmcatalog.IMrmcatalogerdtoCrudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

public class IMrmCataSaveBp extends PagingServiceImpl<MrmCatalogerDTO>{
	
	public FBoolean SaveAmrDO(MrmCatalogerDTO mrmcatalogerdto,MrmCataListDTO []mrmcatalistdto) throws BizException{
		
		ICiamrCudService aservice = ServiceFinder.find(ICiamrCudService.class);
		ICiamrRService rservice = ServiceFinder.find(ICiamrRService.class);

		
		String[] arrIdEnt = new String[mrmcatalistdto.length];
		for(int i =0;i<mrmcatalistdto.length;i++){
			arrIdEnt[i] = mrmcatalistdto[i].getId_ent();
		}
		AMrDO[] Amrdo = rservice.findByAttrValStrings("Id_ent", arrIdEnt);
		
		String[] IdUderCata = new String[Amrdo.length];
		for (int i= 0; i<IdUderCata.length ; i++) {
			Amrdo[i].setId_user_catalogue(mrmcatalogerdto.getId_user_catalogue());
			Amrdo[i].setStatus(DOStatus.UPDATED);
		}
		
		aservice.save(Amrdo);
		
		return null;
	
	}

}
