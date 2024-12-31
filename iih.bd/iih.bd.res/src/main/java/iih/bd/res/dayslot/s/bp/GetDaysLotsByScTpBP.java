package iih.bd.res.dayslot.s.bp;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.desc.DaysLotDODesc;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取日期分组
 * 
 * @author liubin
 *
 */
public class GetDaysLotsByScTpBP {
	/**
	 * 通过排班类型后去日期分组
	 * 
	 * @param scTp 排班类型编码
	 * <ul>
	 * <li>IScDictCodeConst.SD_SCTP_OP【01--门诊】</li>
	 * <li>IScDictCodeConst.SD_SCTP_IP【02--住院】</li>
	 * <li>IScDictCodeConst.SD_SCTP_MT【03--医技】</li>
	 * <li>IScDictCodeConst.SD_SCTP_OT【04--手术】</li>
	 * </ul>
	 * @return
	 * @throws BizException
	 */
	public DaysLotDO[] getDaysLotsByScTp(String scTp) throws BizException {
		ISchedulecaRService sccaRServ = ServiceFinder.find(ISchedulecaRService.class);
		ScheduleCADO[] sccas = sccaRServ.findByAttrValString(ScheduleCADO.SD_SCTP, scTp);
		if(ArrayUtil.isEmpty(sccas)){
			return null;
		}
		String whereStr = String.format("%s.ID_DAYSLOTCA = '%s' AND %s.FG_ACTIVE = '%s'", 
				DaysLotDODesc.TABLE_ALIAS_NAME, sccas[0].getId_dayslottp(), 
				DaysLotDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format("%s.SORTNO", DaysLotDODesc.TABLE_ALIAS_NAME);
		IDayslotMDORService dayslotMRServ = ServiceFinder.find(IDayslotMDORService.class);
		return dayslotMRServ.find(whereStr, orderStr, FBoolean.FALSE);
	}
}
