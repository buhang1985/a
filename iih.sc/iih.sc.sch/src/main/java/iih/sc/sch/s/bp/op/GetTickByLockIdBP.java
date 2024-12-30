package iih.sc.sch.s.bp.op;

import iih.sc.sch.s.ep.SchLockEP;
import iih.sc.sch.sclock.d.ScSchLockDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 获取号位信息
 * @author fanlq
 * @date: 2019年10月23日 下午2:49:30
 */
public class GetTickByLockIdBP {

	/***
	 * @Description:获取号位信息
	 * @param id_schlock
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO exec(String id_schlock) throws BizException{
		ScSchLockDO scSchLockDO = new SchLockEP().findById(id_schlock);
		if(scSchLockDO != null){
			ISctickRService rService = ServiceFinder.find(ISctickRService.class);
			ScSchTickDO tickDO = rService.findById(scSchLockDO.getId_tick());
			return tickDO;
		}
		return null;
	}
}
