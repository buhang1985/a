package iih.bd.mm.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AccPeriodSchemeDO;
import xap.sys.bdfw.bbd.i.IAccperiodschemeCudService;

/**
 * 会计期间方案数据导入服务实现
 * 
 * @author Administrator
 *
 */
public class AccpScheDataImptServiceImpl extends BDBaseDataImport<AccPeriodSchemeDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new AccPeriodSchemeDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { AccPeriodSchemeDO.ID_ACCPERIODSCHEME, AccPeriodSchemeDO.NAME, AccPeriodSchemeDO.CODE };
	}

	@Override
	protected void insertToDB(AccPeriodSchemeDO[] importDatas) throws BizException {
		ServiceFinder.find(IAccperiodschemeCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(AccPeriodSchemeDO[] importDatas) throws BizException {
		ServiceFinder.find(IAccperiodschemeCudService.class).update(importDatas);
	}
}
