package iih.sc.scbd.s.bp.dayslot;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotQryService;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取该排班分类日期分组
 * 
 * @author liubin
 *
 */
public class GetDaysLotDOBP {
	/**
	 * 获取该排班分类日期分组
	 * 
	 * @param sctp
	 *            排班类型
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public DaysLotDO[] exec(String sctp) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(sctp))
			return null;
		ScheduleCADO caDO =this.getDaylLotCa(sctp);
		if(caDO ==null)
			return null;
		IDayslotQryService serv = ServiceFinder.find(IDayslotQryService.class);
		return serv.getDaysLotsByCaId(caDO.getId_dayslottp());
	}
	
	/**
	 * 获取该排班分类日期分组
	 * 
	 * @param sctp
	 *            排班类型
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public DaysLotDO[] exec2(String sctp) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(sctp))
			return null;
		ScheduleCADO caDO =this.getDaylLotCa(sctp);
		if(caDO ==null)
			return null;
		IDayslotQryService serv = ServiceFinder.find(IDayslotQryService.class);
		return serv.getAllDaysLotsByCaId(caDO.getId_dayslottp());
	}
	
	
	/**
	 * 根据sctp获取排班分类
	 * @param sctp
	 * @return
	 * @throws DAException
	 */
	private ScheduleCADO getDaylLotCa(String sctp) throws DAException{
		String cond = " sd_sctp = ? and fg_active = ?  and " + ScGroupControlUtils.getGroupControlFitler(new ScheduleCADO(), "");
		SqlParam param = new SqlParam();
		param.addParam(sctp);
		param.addParam(FBoolean.TRUE);
		List<ScheduleCADO> list = (List<ScheduleCADO>) new DAFacade()
				.findByCond(ScheduleCADO.class, cond, null, new String[] {
						ScheduleCADO.ID_SCCA, ScheduleCADO.ID_DAYSLOTTP },
						param);
		if (ListUtil.isEmpty(list))
			return null;
		return list.get(0);
	}
}
