package iih.ci.ord.s;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvPriceDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvPriceDORService;
import iih.bd.srv.medsrv.i.IMedSrvRisDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

public class BdSrvCreateUtil {
	private String id_srv = "0001Z810000000006BX4";
	private int count = 80;
	public void exec() throws BizException{
		IMedsrvMDORService srvService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO medSrvDO = srvService.findById(id_srv);
		IMedSrvRisDORService risService = ServiceFinder.find(IMedSrvRisDORService.class);
		MedSrvRisDO[] rises = risService.findByAttrValString(MedSrvRisDO.ID_SRV, id_srv);
		//IMedSrvPriceDORService priceService = ServiceFinder.find(IMedSrvPriceDORService.class);
		//MedSrvPriceDO[] pris = priceService.findByAttrValString(MedSrvPriceDO.ID_SRV, id_srv);
		IMedSrvSetItemDORService setService = ServiceFinder.find(IMedSrvSetItemDORService.class);
		MedSrvSetItemDO[] srvsets = setService.findByAttrValString(MedSrvSetItemDO.ID_SRV_ITM, id_srv);
		
		String[] ids = new DBUtil().getOIDs(count);
		String[] risids = new DBUtil().getOIDs(count);
		String[] priids = new DBUtil().getOIDs(count);
		String[] setids = new DBUtil().getOIDs(count);
		
		IMedsrvMDOCudService srvCudService = ServiceFinder.find(IMedsrvMDOCudService.class);
		IMedSrvRisDOCudService risCudService = ServiceFinder.find(IMedSrvRisDOCudService.class);
		//IMedSrvPriceDOCudService priCudService = ServiceFinder.find(IMedSrvPriceDOCudService.class);
		IMedSrvSetItemDOCudService serCudService = ServiceFinder.find(IMedSrvSetItemDOCudService.class);
		
		for(int i = 0;i<count;i++){
			medSrvDO.setStatus(DOStatus.NEW);
			medSrvDO.setId_srv(ids[i]);
			medSrvDO.setCode(i+"");
			srvCudService.save(new MedSrvDO[]{medSrvDO});
			
			rises[0].setStatus(DOStatus.NEW);
			rises[0].setId_srvobs(risids[i]);
			rises[0].setId_srv(ids[i]);
			risCudService.save(new MedSrvRisDO[]{rises[0]});
			
//			pris[0].setStatus(DOStatus.NEW);
//			pris[0].setId_srvprice(priids[i]);
//			pris[0].setId_srv(ids[i]);
//			priCudService.save(new MedSrvPriceDO[]{pris[0]});
			
			srvsets[0].setStatus(DOStatus.NEW);
			srvsets[0].setId_srv("1001Z8100000002L6V5O");
			srvsets[0].setId_srv_itm(ids[i]);
			srvsets[0].setId_srvsetdef(setids[i]);
			serCudService.save(new MedSrvSetItemDO[]{srvsets[0]});
		}
	}
}
