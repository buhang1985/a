package iih.sc.apt.s.ep;

import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 住院预约DO
 * @author fanlq
 *
 */
public class AptIpEP {
	
	/***
	 * 获取住院预约DO
	 * @param id_scaptip 住院预约id
	 * @return
	 * @throws BizException
	 */
	public AptIpDO find(String id_scaptip) throws BizException {
		IAptipMDORService aptRService = ServiceFinder.find(IAptipMDORService.class);
		return aptRService.findById(id_scaptip);
	}
	/**
	 * 保存预约信息
	 * 
	 * @param aptDOs 预约DO数组
	 * @return
	 * @throws BizException
	 */
	public AptIpDO[] save(AptIpDO[] aptDOs) throws BizException {
		IAptipMDOCudService aptCudService = ServiceFinder.find(IAptipMDOCudService.class);
		aptDOs = aptCudService.save(aptDOs);
		return aptDOs;
	}
}
