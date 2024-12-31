package iih.bl.cg.s.bp.ip.backcg;

import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;

/**
 * 执行住院医嘱记费
 * @author yankan
 * @since 2017-10-20
 *
 */
public class IpOrdChargeBP {
	/**
	 * 执行住院医嘱记费
	 * 护理、持续医嘱
	 * @param patId 患者ID
	 * @param cgEndTime 计费时间
	 * @throws BizException
	 */
	public void exec(String patId,FDateTime cgEndTime) throws BizException{
		List<ICharge> chargeBPList = new LinkedList<ICharge>();
		//chargeBPList.add(new ChargeNurseBP());// 护理费
		chargeBPList.add(new ChargePrnOrderBP());// 持续医嘱费
		IpBackChargeBP ipChargeBP = new IpBackChargeBP(chargeBPList);
		
		Context.get().setAttribute("BlTurnDept", true);
		ipChargeBP.exec(patId, cgEndTime,false);
	}
}
