package iih.bd.pp.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.bdbltpl.i.IBdBltplItmDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 自定义费用模板明细导入服务
 * 
 * @author hao_wu
 *
 */
public class BdBltplItmImportServiceImpl extends BDBaseDataImport<BdBltplItmDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdBltplItmDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdBltplItmDO.ID_BLTPLITM, BdBltplItmDO.ID_BLTPL, BdBltplItmDO.ID_SRV,
				BdBltplItmDO.QUAN_MEDU, BdBltplItmDO.ID_GRP, BdBltplItmDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdBltplItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdBltplItmDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdBltplItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdBltplItmDOCudService.class).update(importDatas);
	}
}
