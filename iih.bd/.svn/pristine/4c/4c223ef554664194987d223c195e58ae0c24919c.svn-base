package iih.bd.mm.wahouseunittype.s.bp;

import iih.bd.mm.comm.i.ICommService;
import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.d.PsndocAggDO;

/**
 * 更新操作员信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class UpdateOperaterBp {

	public void exec(WahouseUnitTypeDO... wahouseUnitTypeArr) throws BizException {

		ICommService commSrv = ServiceFinder.find(ICommService.class);
		
		PsndocAggDO psnInfo = commSrv.getEmployeeInfoByUserId(Context.get().getUserId());
		PsnDocDO psndoc = psnInfo.getParentDO();
		
		for (WahouseUnitTypeDO wahouseUnitTypeDO : wahouseUnitTypeArr) {
			
			wahouseUnitTypeDO.setId_operater(psndoc.getId_psndoc());
			wahouseUnitTypeDO.setOper_name(psndoc.getName());
		}
	}
}
