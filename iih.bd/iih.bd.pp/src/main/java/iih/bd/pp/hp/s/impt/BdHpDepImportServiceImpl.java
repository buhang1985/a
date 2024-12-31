package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.HpDepDO;
import iih.bd.pp.hp.i.IHpDepDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_医保计划_医保科室
 * 
 * @author Liwq
 *
 */
public class BdHpDepImportServiceImpl extends BDBaseDataImport<HpDepDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new HpDepDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { HpDepDO.ID_HP_DEP, HpDepDO.ID_HP, HpDepDO.ID_DEP, HpDepDO.ID_GRP, HpDepDO.ID_DEP };
	}

	@Override
	protected void insertToDB(HpDepDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpDepDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(HpDepDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpDepDOCudService.class).update(importDatas);
	}
}
