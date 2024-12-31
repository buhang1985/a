package iih.bd.res.s.dataimport;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.res.dayslotca.d.DaysLotcaDO;
import iih.bd.res.dayslotca.i.IDayslotcaCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 日期分组分类--数据导入服务
 * 
 * @author yank
 *
 */
public class DayslotCaImportServiceImpl extends BDBaseDataImport<DaysLotcaDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new DaysLotcaDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { DaysLotcaDO.ID_DAYSLOTCA, DaysLotcaDO.CODE, DaysLotcaDO.NAME, DaysLotcaDO.ID_DAYSLOTCATP,
				DaysLotcaDO.SD_DAYSLOTCATP, DaysLotcaDO.ID_GRP, DaysLotcaDO.ID_ORG };
	}

	@Override
	protected void insertToDB(DaysLotcaDO[] importDatas) throws BizException {
		ServiceFinder.find(IDayslotcaCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(DaysLotcaDO[] importDatas) throws BizException {
		ServiceFinder.find(IDayslotcaCudService.class).update(importDatas);
	}
}
