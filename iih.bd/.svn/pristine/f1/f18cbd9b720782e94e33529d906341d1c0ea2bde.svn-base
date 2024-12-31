package iih.bd.pp.bdcpnca.bp;

import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.pp.bdcpnca.d.BdcpncaAggDO;
import iih.bd.pp.bdcpnca.i.IBdcpncaCudService;
import iih.bd.pp.bdcpnca.i.IBdcpncaRService;
import iih.bl.inc.blcpnin.d.BlCpnDO;
import iih.bl.inc.blcpnin.i.IBlCpnDOCudService;
import iih.bl.inc.blcpnin.i.IBlCpnDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class BdCpnCaBp {

	public FBoolean deleteBdcpnCaAndDOs(BdCpncaDO bdcpncaDO) throws BizException {
		// TODO Auto-generated method stub
		//IBdcpncaMDOCudService,IBdcpncaMDORService
//		IBdcpncaMDOCudService  caMCudService=ServiceFinder.find(IBdcpncaMDOCudService.class);
//		IBdcpncaMDORService    caMRService=ServiceFinder.find(IBdcpncaMDORService.class);
		IBdcpncaCudService  cpnCaCudSer=ServiceFinder.find(IBdcpncaCudService.class);
		IBdcpncaRService    cpnCaRSer=ServiceFinder.find(IBdcpncaRService.class);
		//删除BdCpnCaDO及其对应的子DO
	    BdcpncaAggDO cpnCaAggDO=cpnCaRSer.findById(bdcpncaDO.getId_cpnca()) ;
	    cpnCaCudSer.delete(new BdcpncaAggDO[]{cpnCaAggDO});
		
	   //删除BdCpnCaDO所包含的所有BlCpnDO
		IBlCpnDORService    blcpnDORSer=ServiceFinder.find(IBlCpnDORService.class);
		IBlCpnDOCudService  blcpnDOCudSer=ServiceFinder.find(IBlCpnDOCudService.class);
		BlCpnDO[] blCpnDOArr = blcpnDORSer.find(" a1.id_cpnca = '" + bdcpncaDO.getId_cpnca() + "' ", null, FBoolean.FALSE);
		blcpnDOCudSer.delete(blCpnDOArr);
		
		return FBoolean.TRUE;
	}

}
