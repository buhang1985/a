package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.HpDiDO;
import iih.bd.pp.hp.i.IHpDiDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class HpDiImportServiceImpl extends BDBaseDataImport<HpDiDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new HpDiDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { HpDiDO.ID_HPDI, HpDiDO.ID_DI, HpDiDO.ID_GRP, HpDiDO.ID_ORG };
	}

	@Override
	protected void insertToDB(HpDiDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpDiDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(HpDiDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpDiDOCudService.class).update(importDatas);
	}
}
