package iih.bd.res.s.dataimport;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.res.dayslot.d.DaysLotTimeDO;
import iih.bd.res.dayslot.i.IDaysLotTimeDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 日期分组时间导入
 * 
 * @author yank
 *
 */
public class DayslotTimeImportServiceImpl extends BDBaseDataImport<DaysLotTimeDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new DaysLotTimeDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { DaysLotTimeDO.ID_DAYSLOTTIME, DaysLotTimeDO.ID_DAYSLOT, DaysLotTimeDO.TIME_B,
				DaysLotTimeDO.TIME_E, DaysLotTimeDO.VALIDDAY_B, DaysLotTimeDO.VALIDDAY_E, DaysLotTimeDO.VALIDMONTH_B,
				DaysLotTimeDO.VALIDMONTH_E, DaysLotTimeDO.ID_GRP, DaysLotTimeDO.ID_ORG };
	}

	@Override
	protected void insertToDB(DaysLotTimeDO[] importDatas) throws BizException {
		ServiceFinder.find(IDaysLotTimeDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(DaysLotTimeDO[] importDatas) throws BizException {
		ServiceFinder.find(IDaysLotTimeDOCudService.class).update(importDatas);
	}
}
