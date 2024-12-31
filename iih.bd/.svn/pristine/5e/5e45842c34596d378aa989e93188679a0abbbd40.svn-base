package iih.bd.pp.bdhpsrvctr.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import iih.bd.pp.bdhpsrvctr.i.IBdhpsrvctrCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class BdHpSrvctrDOImportServiceImpl extends BDBaseDataImport<BdHpSrvctrDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpSrvctrDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpSrvctrDO.ID_SRV, BdHpSrvctrDO.ID_HP };
	}

	@Override
	protected void insertToDB(BdHpSrvctrDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdhpsrvctrCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpSrvctrDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdhpsrvctrCudService.class).insert(importDatas);
	}
}
