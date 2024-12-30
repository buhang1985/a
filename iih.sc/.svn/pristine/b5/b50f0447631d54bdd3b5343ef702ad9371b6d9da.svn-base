package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import xap.mw.core.data.BizException;

/**
 * 获取医技卡片显示服务
 * 
 * @author ccj
 *
 */
public class GetMtSchCardSrvBp {

	/**
	 * 获取医技卡片显示服务
	 * 
	 * @param sd_md  票号模式
	 * @param id_sch  排班id
	 * @param id_srv 计划对应的服务id
	 * @throws BizException
	 */
	public String exec(String sd_md, String id_sch, String id_srv) throws BizException {
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(sd_md)) {
			TickEP tickEP = new TickEP();
			return tickEP.getAllSrvName(id_sch, id_srv);
		} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_md)) {
			TicksEP ticksEP = new TicksEP();
			return ticksEP.getAllSrvName(id_sch, id_srv);
		}
		return "";
	}
}
