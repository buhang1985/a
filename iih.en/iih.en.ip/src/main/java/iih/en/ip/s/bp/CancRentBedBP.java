package iih.en.ip.s.bp;

import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.util.EnAppUtils;
import xap.mw.core.data.BizException;

/**
 * 取消包床
 * @author zhangpp
 *
 */
public class CancRentBedBP {

	public void exec(String entId,String bedId) throws BizException{	
		//1、释放床位
		BedEP bedBP = new BedEP();
		bedBP.releaseBed(null, bedId);
		
		//2、结束就诊使用
		EntBedEP enResBP = new EntBedEP();
		enResBP.endUseBed(entId, bedId, EnAppUtils.getServerDateTime());
	}
}
