package iih.bd.pp.incca.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.i.IInccaitmrelCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class InccaitmrelImportServiceImpl extends BDBaseDataImport<IncCaItmRelDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new IncCaItmRelDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { IncCaItmRelDO.ID_INCCAITMREL, IncCaItmRelDO.ID_SRV };
	}

	@Override
	protected void insertToDB(IncCaItmRelDO[] importDatas) throws BizException {
		ServiceFinder.find(IInccaitmrelCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(IncCaItmRelDO[] importDatas) throws BizException {
		ServiceFinder.find(IInccaitmrelCudService.class).update(importDatas);
	}
}
