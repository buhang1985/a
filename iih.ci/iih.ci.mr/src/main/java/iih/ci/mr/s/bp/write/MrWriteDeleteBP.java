/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.s.bp.write;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MrWriteDeleteBP {
	/**
	 * 逻辑删除
	 * @param ciMrDO
	 * @throws BizException
	 */
	public void LogicDelMrWrite(CiMrDO ciMrDO) throws BizException {
		ICiemrCudService delService =ServiceFinder.find(ICiemrCudService.class);
		if ("".equals(ciMrDO.getModifiedby())||ciMrDO.getModifiedby()==null) {
			ciMrDO.setModifiedby(Context.get().getUserId());
			ciMrDO.setModifiedtime(new FDateTime());
			ciMrDO.setStatus(DOStatus.UPDATED);
			delService.update(new CiMrDO[]{ciMrDO});
		}
		delService.logicDelete(new CiMrDO[]{ciMrDO});
	}
	/**
	 * 驳货 取回的删除 要停止审批流
	 * @param ciMrDO
	 * @throws BizException
	 */
	public Boolean DelAndStopMrWrite(String id_user,CiMrDO ciMrDO) throws BizException {
		
		ICiemrCudService delService =ServiceFinder.find(ICiemrCudService.class);
		//先保存删除原因
		CiMrDO[] doArr=delService.update(new CiMrDO[]{ciMrDO});
		if (doArr.length>0) {
			return delService.deleteAndStop(id_user, doArr[0]);
		} else {
			return false;
		}
		
	}
}
