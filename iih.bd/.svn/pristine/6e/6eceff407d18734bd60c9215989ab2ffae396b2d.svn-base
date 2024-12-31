package iih.bd.pp.pripm.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_付款模式 导入服务实现
 * 
 * @author tcy
 *
 */
public class PripmImportServiceImpl extends BDBaseDataImport<PriPmDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new PriPmDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { PriPmDO.ID_PM, PriPmDO.NAME, PriPmDO.CODE, PriPmDO.ID_GRP, PriPmDO.ID_ORG };
	}

	@Override
	protected void insertToDB(PriPmDO[] importDatas) throws BizException {
		ServiceFinder.find(IPripmCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(PriPmDO[] importDatas) throws BizException {
		ServiceFinder.find(IPripmCudService.class).update(importDatas);
	}
}
