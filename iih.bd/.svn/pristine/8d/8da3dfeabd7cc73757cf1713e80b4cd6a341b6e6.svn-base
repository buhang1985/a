package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.i.IBdhpspecMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class BdHpSpecDOImportServiceImpl extends BDBaseDataImport<BdHpSpecDO> {
	@Override
	protected BaseDO getDoInstance() {
		return new BdHpSpecDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpSpecDO.ID_HPSPEC, BdHpSpecDO.CODE_DI, BdHpSpecDO.ID_HP, BdHpSpecDO.ID_GRP,
				BdHpSpecDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdHpSpecDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdhpspecMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpSpecDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdhpspecMDOCudService.class).update(importDatas);
	}
}
