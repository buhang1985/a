package iih.bd.mm.meterial.bp;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.s.MeterialMDOCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 启用或者停用物品。
 * @author wu.junhui
 *
 */
public class ChangeStatusBp {

	public MeterialDO[] changeStatus(MeterialDO[] meterialDOs, FBoolean isStart) throws BizException {
		
		if (meterialDOs == null || meterialDOs.length <= 0) {
			
			throw new BizException("传入参数信息为空。");
		}
		
		for(MeterialDO mmDO : meterialDOs) {
			
			mmDO.setStatus(DOStatus.UPDATED);
			//停用、启用状态
			mmDO.setFg_active(isStart);
		}
		
		MeterialMDOCrudServiceImpl mmCudSrv = new MeterialMDOCrudServiceImpl();
		return mmCudSrv.update(meterialDOs);
	}
}
