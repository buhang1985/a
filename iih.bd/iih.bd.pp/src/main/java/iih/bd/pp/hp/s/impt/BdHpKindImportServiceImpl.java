package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.BdHpKindDO;
import iih.bd.pp.hp.i.IBdHpKindDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_医保计划_险种
 * 
 * @author Liwq
 *
 */
public class BdHpKindImportServiceImpl extends BDBaseDataImport<BdHpKindDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpKindDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpKindDO.ID_HPKIND, BdHpKindDO.ID_HP, BdHpKindDO.CODE_HPKIND, BdHpKindDO.NAME_HPKIND,
				BdHpKindDO.ID_GRP, BdHpKindDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdHpKindDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpKindDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpKindDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpKindDOCudService.class).update(importDatas);
	}
}
