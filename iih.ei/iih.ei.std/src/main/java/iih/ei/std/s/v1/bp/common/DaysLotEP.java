package iih.ei.std.s.v1.bp.common;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.scbd.i.IScDaysLotService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 日期分组EP
 * @author fanlq
 * @date: 2019年10月30日 上午10:59:53
 */
public class DaysLotEP {
	
	/**
	 * 获取门诊当前日期分组
	 * 
	 * @return
	 * @throws BizException
	 */
	public DaysLotDO getCurDaysLot() throws BizException{
		IScDaysLotService scDayslotServ = ServiceFinder.find(IScDaysLotService.class);
		return scDayslotServ.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.TRUE);
	}
}
