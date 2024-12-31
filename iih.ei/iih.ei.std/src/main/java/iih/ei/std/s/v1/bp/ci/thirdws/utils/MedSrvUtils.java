package iih.ei.std.s.v1.bp.ci.thirdws.utils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class MedSrvUtils {
	/**
	 * 根据某字段属性查询服务信息
	 * @param column
	 * @param columnValue
	 * @return
	 */
	public static MedSrvDO getMedSrv(String column,String columnValue) {
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		try {
			MedSrvDO[] medsrvs = service.findByAttrValString(column, columnValue);
			if(medsrvs!=null && medsrvs.length > 0){
				return medsrvs[0];
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static MedSrvLisDO getMedLab(String id_srv) throws BizException {
		IMedSrvLisDORService  service = ServiceFinder.find(IMedSrvLisDORService.class);
		if(id_srv==null)
			return null;
		MedSrvLisDO[] medlis=service.find(" id_srv='"+id_srv+"'", "", FBoolean.FALSE);
		if(medlis!=null&&medlis.length>0)
			return medlis[0];
		return null;
		
	}
}
