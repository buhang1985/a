package iih.bl.cc.s.bp;

import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 修改门诊结算表结账标志为未结账
 * @author LIM
 * @since 2017-06-26
 */
public class UpdateBlStOepForCancelBP {
	/**
	 * 修改门诊结算表(BL_ST_OEP)中结账标志为未结账
	 * @param blccAggDO
	 * @throws BizException
	 */
	public void exec(String sqlStr ,BlccAggDO blccAggDO) throws BizException{
		IBlstoepRService stOepRService = ServiceFinder.find(IBlstoepRService.class);		
		BlStOepDO[] blStOepDOArr = stOepRService.find(sqlStr.toString(), null, FBoolean.FALSE);
		if(blStOepDOArr != null && blStOepDOArr.length > 0){
			for(BlStOepDO blStOepDO : blStOepDOArr){
				blStOepDO.setId_cc(null);
				blStOepDO.setFg_cc(FBoolean.FALSE);
				blStOepDO.setStatus(DOStatus.UPDATED);
			}
			IBlstoepCudService stOepCService = ServiceFinder.find(IBlstoepCudService.class);
			stOepCService.save(blStOepDOArr);
		}
	}

}
