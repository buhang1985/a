package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.ipspectp.d.BdEnIpSpecDO;
import iih.bd.fc.ipspectp.i.IIpspectpCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院特定类型数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class BdEnIpSpecDataImptServiceImpl extends BDBaseDataImport<BdEnIpSpecDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdEnIpSpecDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdEnIpSpecDO.ID_GRP, BdEnIpSpecDO.ID_ORG, BdEnIpSpecDO.ID_IP_SPEC,
				BdEnIpSpecDO.CODE_CODEMAKER };
	}

	@Override
	protected void insertToDB(BdEnIpSpecDO[] importDatas) throws BizException {
		ServiceFinder.find(IIpspectpCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdEnIpSpecDO[] importDatas) throws BizException {
		ServiceFinder.find(IIpspectpCudService.class).update(importDatas);
	}
}
