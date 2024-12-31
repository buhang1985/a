package iih.bd.res.s.dataimport;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 日期分组--数据导入服务
 * 
 * @author yank
 *
 */
public class DayslotImportServiceImpl extends BDBaseDataImport<DaysLotDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new DaysLotDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { DaysLotDO.ID_DAYSLOTCA, DaysLotDO.CODE, DaysLotDO.NAME, DaysLotDO.TIME_BEGIN,
				DaysLotDO.TIME_END, DaysLotDO.ID_DAYSLOTTP, DaysLotDO.SD_DAYSLOTTP, DaysLotDO.ID_GRP,
				DaysLotDO.ID_ORG };
	}

	@Override
	protected void insertToDB(DaysLotDO[] importDatas) throws BizException {
		ServiceFinder.find(IDayslotMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(DaysLotDO[] importDatas) throws BizException {
		ServiceFinder.find(IDayslotMDOCudService.class).update(importDatas);
	}
}
