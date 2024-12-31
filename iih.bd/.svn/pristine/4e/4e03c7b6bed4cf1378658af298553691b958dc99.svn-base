package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.BdHpPatcaDO;
import iih.bd.pp.hp.i.IBdHpPatcaDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_医保计划_医保身份
 * 
 * @author Liwq
 *
 */
public class BdHpPatCaImportServiceImpl extends BDBaseDataImport<BdHpPatcaDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpPatcaDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpPatcaDO.ID_HP, BdHpPatcaDO.CODE_HPPATCA, BdHpPatcaDO.NAME_HPPATCA, BdHpPatcaDO.ID_GRP,
				BdHpPatcaDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdHpPatcaDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpPatcaDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpPatcaDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpPatcaDOCudService.class).update(importDatas);
	}
}
