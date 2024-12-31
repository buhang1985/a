package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.BdHpCtrDO;
import iih.bd.pp.hp.i.IBdHpCtrDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class BdHpCtrDOImportServiceImpl extends BDBaseDataImport<BdHpCtrDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpCtrDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpCtrDO.ID_HPCTR, BdHpCtrDO.ID_HP, BdHpCtrDO.OR_LIMIT_AMT, BdHpCtrDO.ID_GRP,
				BdHpCtrDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdHpCtrDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpCtrDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpCtrDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpCtrDOCudService.class).update(importDatas);
	}
}
