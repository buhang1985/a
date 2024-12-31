package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.BdHpUnlimitDrugDO;
import iih.bd.pp.hp.i.IBdHpUnlimitDrugDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class BdHpUnlimitDrugDOImportServiceImpl extends BDBaseDataImport<BdHpUnlimitDrugDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpUnlimitDrugDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpUnlimitDrugDO.ID_HPUNLIMITDRUG, BdHpUnlimitDrugDO.ID_HP, BdHpUnlimitDrugDO.ID_GRP,
				BdHpUnlimitDrugDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdHpUnlimitDrugDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpUnlimitDrugDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpUnlimitDrugDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpUnlimitDrugDOCudService.class).update(importDatas);
	}
}
