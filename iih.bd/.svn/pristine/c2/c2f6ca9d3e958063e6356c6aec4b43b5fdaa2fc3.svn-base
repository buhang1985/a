package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.BdHpLimitPsdDO;
import iih.bd.pp.hp.i.IBdHpLimitPsdDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class BdHpLimitPsdDOImportServiceImpl extends BDBaseDataImport<BdHpLimitPsdDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpLimitPsdDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpLimitPsdDO.ID_HPLIMITPSD, BdHpLimitPsdDO.ID_HP, BdHpLimitPsdDO.ID_SRV,
				BdHpLimitPsdDO.ID_GRP, BdHpLimitPsdDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdHpLimitPsdDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpLimitPsdDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpLimitPsdDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpLimitPsdDOCudService.class).update(importDatas);
	}
}
