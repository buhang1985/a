package iih.bl.cc.s.bp;

import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 修改住院结算表结账标志为未结账
 * @author LIM
 * @since 2017-06-26
 *
 */
public class UpdateBlStIpForCancelBP {
	/**
	 * 修改住院结算表(BL_ST_IP)中结账标志为未结账
	 * @param sqlStr
	 * @throws BizException
	 */
	public void exec(String sqlStr) throws BizException{
		IBlstipRService stIpRService = ServiceFinder.find(IBlstipRService.class);
		
		BlStIpDO[] blStIpDOArr = stIpRService.find(sqlStr, null, FBoolean.FALSE);
		if(blStIpDOArr != null && blStIpDOArr.length > 0){
			for(BlStIpDO blStIpDO : blStIpDOArr){
				blStIpDO.setId_cc(null);
				blStIpDO.setFg_cc(FBoolean.FALSE);
				blStIpDO.setStatus(DOStatus.UPDATED);
			}
			IBlstipCudService stIpCService = ServiceFinder.find(IBlstipCudService.class);
			stIpCService.save(blStIpDOArr);
		}
	}

}
