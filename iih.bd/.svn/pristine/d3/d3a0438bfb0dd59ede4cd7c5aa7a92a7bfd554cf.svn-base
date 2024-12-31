package iih.bd.res.dayslot.s.bp;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.desc.DaysLotDODesc;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 通过日期分诊分类获取日期分组
 * 
 * @author liubin
 *
 */
public class GetDaysLotsByCaIdBP {
	/**
	 * 通过日期分诊分类获取日期分组
	 * 
	 * @param dayslotcaId
	 * @return
	 * @throws BizException
	 */
	public DaysLotDO[] exec(String dayslotcaId) throws BizException {
		if(StringUtil.isEmptyWithTrim(dayslotcaId))
			return null;
		String whereStr = String.format("%s.ID_DAYSLOTCA = '%s' AND %s.FG_ACTIVE = '%s'", 
				DaysLotDODesc.TABLE_ALIAS_NAME, dayslotcaId, 
				DaysLotDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format("%s.SORTNO", DaysLotDODesc.TABLE_ALIAS_NAME);
		IDayslotMDORService dayslotMRServ = ServiceFinder.find(IDayslotMDORService.class);
		return dayslotMRServ.find(whereStr, orderStr, FBoolean.FALSE);
	}
	
	/**
	 * 通过日期分诊分类获取日期分组
	 * 
	 * @param dayslotcaId
	 * @return
	 * @throws BizException
	 */
	public DaysLotDO[] exec2(String dayslotcaId) throws BizException {
		if(StringUtil.isEmptyWithTrim(dayslotcaId))
			return null;
		String whereStr = String.format("%s.ID_DAYSLOTCA = '%s' ", 
				DaysLotDODesc.TABLE_ALIAS_NAME, dayslotcaId, 
				DaysLotDODesc.TABLE_ALIAS_NAME);
		String orderStr = String.format("%s.SORTNO", DaysLotDODesc.TABLE_ALIAS_NAME);
		IDayslotMDORService dayslotMRServ = ServiceFinder.find(IDayslotMDORService.class);
		return dayslotMRServ.find(whereStr, orderStr, FBoolean.FALSE);
	}
}
