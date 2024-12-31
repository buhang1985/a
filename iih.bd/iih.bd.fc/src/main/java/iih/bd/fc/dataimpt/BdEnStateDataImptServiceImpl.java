package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.i.IEnstateCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊状况数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class BdEnStateDataImptServiceImpl extends BDBaseDataImport<BdEnStateDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdEnStateDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdEnStateDO.ID_GRP, BdEnStateDO.ID_ORG, BdEnStateDO.ID_ENSTATETP, BdEnStateDO.NAME,
				BdEnStateDO.VAL, BdEnStateDO.EU_PERIODTP };
	}

	@Override
	protected void insertToDB(BdEnStateDO[] importDatas) throws BizException {
		ServiceFinder.find(IEnstateCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdEnStateDO[] importDatas) throws BizException {
		ServiceFinder.find(IEnstateCudService.class).update(importDatas);
	}
}
