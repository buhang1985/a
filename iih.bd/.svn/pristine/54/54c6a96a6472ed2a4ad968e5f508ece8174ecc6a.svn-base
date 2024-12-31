package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.bdhpspec.d.BdHpSpecDrugDO;
import iih.bd.pp.bdhpspec.i.IBdHpSpecDrugDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class BdHpSpecDrugDOImportServiceImpl extends BDBaseDataImport<BdHpSpecDrugDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpSpecDrugDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpSpecDrugDO.ID_HPSPECDRUG, BdHpSpecDrugDO.ID_HPSPEC, BdHpSpecDrugDO.ID_GRP,
				BdHpSpecDrugDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdHpSpecDrugDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpSpecDrugDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpSpecDrugDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpSpecDrugDOCudService.class).update(importDatas);
	}
}
