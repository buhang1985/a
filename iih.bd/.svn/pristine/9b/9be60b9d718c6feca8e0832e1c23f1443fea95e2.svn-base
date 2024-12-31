package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.BdHpOrgDO;
import iih.bd.pp.hp.i.IBdHpOrgDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_医保计划_医保机构
 * 
 * @author Liwq
 *
 */
public class BdHpOrgImportServiceImpl extends BDBaseDataImport<BdHpOrgDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpOrgDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpOrgDO.ID_HPORG, BdHpOrgDO.ID_HP, BdHpOrgDO.NAME_HP, BdHpOrgDO.ID_GRP,
				BdHpOrgDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdHpOrgDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpOrgDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpOrgDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdHpOrgDOCudService.class).update(importDatas);
	}
}
