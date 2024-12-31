package iih.bd.pp.hp.bp;

import iih.bd.pp.srvmpayratio.d.SrvMPayRatioDO;
import iih.bd.pp.srvmpayratio.i.ISrvmpayratioRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取所有服务多支付比例集合
 * @author yankan
 *
 */
public class GetAllSrvMutiPayRatioBP {
	/**
	 * 获取所有服务多支付比例集合
	 * @return
	 * @author yankan
	 */
	public SrvMPayRatioDO[] exec() throws BizException{
		ISrvmpayratioRService ratioRService = ServiceFinder.find(ISrvmpayratioRService.class);
		return ratioRService.find("1=1", null, FBoolean.FALSE);
	}
}
