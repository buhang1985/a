package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.BdHpPrestpDO;
import iih.bd.pp.hp.i.IBdHpPrestpDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_医保计划_医保处方类型
 * 
 * @author Liwq
 *
 */
public class BdHpPrestpImortServiceImpl extends BDBaseDataImport<BdHpPrestpDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpPrestpDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpPrestpDO.ID_HP, BdHpPrestpDO.ID_PRESTP, BdHpPrestpDO.ID_GRP, BdHpPrestpDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdHpPrestpDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpPrestpDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpPrestpDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpPrestpDOCudService.class).update(importDatas);
	}
}
