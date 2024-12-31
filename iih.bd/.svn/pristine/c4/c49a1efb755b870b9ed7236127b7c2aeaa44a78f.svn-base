package iih.bd.pp.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import iih.bd.pp.srvctrdi.i.ISrvctrdiCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保内诊断限制导入服务
 * 
 * @author hao_wu
 *
 */
public class BdHpSrvCtrDiImportServiceImpl extends BDBaseDataImport<BdHpSrvCtrDiDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpSrvCtrDiDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpSrvCtrDiDO.ID_SRVCTR_ID, BdHpSrvCtrDiDO.ID_HP, BdHpSrvCtrDiDO.ID_GRP,
				BdHpSrvCtrDiDO.ID_ORG, BdHpSrvCtrDiDO.ID_DI_DEF, BdHpSrvCtrDiDO.ID_SRV, BdHpSrvCtrDiDO.EU_HPSRVTP };
	}

	@Override
	protected void insertToDB(BdHpSrvCtrDiDO[] importDatas) throws BizException {
		ServiceFinder.find(ISrvctrdiCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpSrvCtrDiDO[] importDatas) throws BizException {
		ServiceFinder.find(ISrvctrdiCudService.class).update(importDatas);
	}
}
