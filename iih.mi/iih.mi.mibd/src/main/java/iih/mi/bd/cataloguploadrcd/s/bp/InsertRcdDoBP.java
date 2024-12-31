package iih.mi.bd.cataloguploadrcd.s.bp;

import iih.mi.bd.cataloguploadrcd.d.MiCatalogUploadRcdDO;
import iih.mi.bd.cataloguploadrcd.i.ICataloguploadrcdCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 插入医保目录下载记录
 * Title: InsertRcdDoBP.java
 * @author zhang.hw
 * @date 2019年5月16日  
 * @version 1.0
 */
public class InsertRcdDoBP {

	public FBoolean exec(MiCatalogUploadRcdDO miCatalogUploadRcdDO) throws BizException{
		miCatalogUploadRcdDO.setId_grp(Context.get().getGroupId());
		miCatalogUploadRcdDO.setId_org(Context.get().getOrgId());
		miCatalogUploadRcdDO.setStatus(DOStatus.NEW);
		ICataloguploadrcdCudService service = ServiceFinder.find(ICataloguploadrcdCudService.class);
		MiCatalogUploadRcdDO[] miCatalogUploadRcdDOs = service.save(new MiCatalogUploadRcdDO[]{miCatalogUploadRcdDO});
		if(miCatalogUploadRcdDOs.length>0){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
}
