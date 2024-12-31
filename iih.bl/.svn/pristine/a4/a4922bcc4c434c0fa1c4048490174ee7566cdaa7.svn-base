package iih.bl.pay.ep;

import iih.pi.patsrvpkg.patsrvpkg.d.PiPatSrvPkgDO;
import iih.pi.patsrvpkg.patsrvpkg.i.IPatsrvpkgCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class PiPatSrvPkgDOEp {
	/**
	 * 保存PiPatSrvPkgDO数据
	 * @param ppspDOArr
	 * @return
	 * @throws BizException
	 */
public PiPatSrvPkgDO[]  save(PiPatSrvPkgDO[]  ppspDOArr) throws BizException {
	//如果有需要更新的患者服务包数据，保存更新的服务包数据  2.
		IPatsrvpkgCudService patsrvpkg_Service =ServiceFinder.find(IPatsrvpkgCudService.class);
		PiPatSrvPkgDO[] pipatSrvPkgDOArr=  patsrvpkg_Service.save(ppspDOArr);
		return  pipatSrvPkgDOArr;
}

}
