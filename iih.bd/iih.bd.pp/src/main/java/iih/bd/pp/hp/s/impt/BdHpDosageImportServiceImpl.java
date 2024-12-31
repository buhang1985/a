package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.HpDosageDO;
import iih.bd.pp.hp.i.IHpDosageDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_医保计划_医保剂型
 * 
 * @author Liwq
 *
 */
public class BdHpDosageImportServiceImpl extends BDBaseDataImport<HpDosageDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new HpDosageDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { HpDosageDO.ID_HP_DOSAGE, HpDosageDO.ID_HP, HpDosageDO.ID_DOSAGE, HpDosageDO.NAME_HP,
				HpDosageDO.ID_GRP, HpDosageDO.ID_ORG };
	}

	@Override
	protected void insertToDB(HpDosageDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpDosageDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(HpDosageDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpDosageDOCudService.class).update(importDatas);
	}
}
