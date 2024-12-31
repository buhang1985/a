package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.enstatetpext.d.BdEnStateTpExtDO;
import iih.bd.fc.enstatetpext.i.IBdenstatetpextCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊状况类型扩展数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class BdEnStateTpExtDataImptServiceImpl extends BDBaseDataImport<BdEnStateTpExtDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdEnStateTpExtDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdEnStateTpExtDO.ID_GRP, BdEnStateTpExtDO.ID_ORG, BdEnStateTpExtDO.ID_ENSTATETP,
				BdEnStateTpExtDO.EU_SOURCETP };
	}

	@Override
	protected void insertToDB(BdEnStateTpExtDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdenstatetpextCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdEnStateTpExtDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdenstatetpextCudService.class).update(importDatas);
	}
}
