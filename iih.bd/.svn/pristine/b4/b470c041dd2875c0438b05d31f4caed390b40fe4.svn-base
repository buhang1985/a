package iih.bd.pp.hp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hp.d.HpFreqDO;
import iih.bd.pp.hp.i.IHpFreqDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_医保计划_医保频次
 * 
 * @author Liwq
 *
 */
public class BdHpFreqImportServiceImpl extends BDBaseDataImport<HpFreqDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new HpFreqDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { HpFreqDO.ID_HPFREQ, HpFreqDO.ID_HP, HpFreqDO.ID_FREQ, HpFreqDO.ID_GRP, HpFreqDO.ID_ORG };
	}

	@Override
	protected void insertToDB(HpFreqDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpFreqDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(HpFreqDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpFreqDOCudService.class).update(importDatas);
	}
}
