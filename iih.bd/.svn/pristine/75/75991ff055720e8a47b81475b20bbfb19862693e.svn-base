package iih.bd.srv.mrpsnpower2.bp;

import iih.bd.srv.mrpsnpower.d.MrPsnPowerDO;
import iih.bd.srv.mrpsnpower.i.IMrpsnpowerRService;
import iih.bd.srv.mrpsnpower.i.IMrpsnpowerCudService;
import iih.bd.srv.mrpsnpowerdetail.d.MrPsnPowerDetailDO;
import iih.bd.srv.mrpsnpowerdetail.i.IMrpsnpowerdetailCudService;
import iih.bd.srv.mrpsnpowerdetail.i.IMrpsnpowerdetailRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class DeleteAll {

	/**
	* 删除某人员所有权限配置
	 * @throws BizException 
	*/
	public Boolean deleteAll(String id_psn) throws BizException {
		IMrpsnpowerRService psnSer=ServiceFinder.find(IMrpsnpowerRService.class);
		IMrpsnpowerCudService psnSer2=ServiceFinder.find(IMrpsnpowerCudService.class);
		MrPsnPowerDO[] psns=psnSer.findByAttrValString("Id_psn", id_psn);
		if(null!=psns && psns.length>0){
			IMrpsnpowerdetailRService detSer=ServiceFinder.find(IMrpsnpowerdetailRService.class);
			IMrpsnpowerdetailCudService detSer2=ServiceFinder.find(IMrpsnpowerdetailCudService.class);
			for (MrPsnPowerDO psn : psns) {
				MrPsnPowerDetailDO[] details=detSer.findByAttrValString("Idmrpsnpower", psn.getIdmrpsnpower());
				if(null!=details && details.length>0){
					detSer2.delete(details);
				}
			}
			psnSer2.delete(psns);
			return true;
		}
		return false;
	}

}
