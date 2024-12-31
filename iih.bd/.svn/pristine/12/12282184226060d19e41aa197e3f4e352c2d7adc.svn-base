package iih.bd.res.s.dataimport;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.res.dayslot.d.DayslotSecDO;
import iih.bd.res.dayslot.i.IDayslotSecDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 日期分组时段导入
 * 
 * @author yank
 *
 */
public class DayslotSecImportServiceImpl extends BDBaseDataImport<DayslotSecDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new DayslotSecDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { DayslotSecDO.ID_DAYSLOTSEC, DayslotSecDO.CODE, DayslotSecDO.NAME, DayslotSecDO.ID_DAYSLOT,
				DayslotSecDO.TIME_BEGIN, DayslotSecDO.TIME_END, DayslotSecDO.ID_GRP, DayslotSecDO.ID_ORG };
	}

	@Override
	protected void insertToDB(DayslotSecDO[] importDatas) throws BizException {
		ServiceFinder.find(IDayslotSecDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(DayslotSecDO[] importDatas) throws BizException {
		ServiceFinder.find(IDayslotSecDOCudService.class).update(importDatas);
	}

}
