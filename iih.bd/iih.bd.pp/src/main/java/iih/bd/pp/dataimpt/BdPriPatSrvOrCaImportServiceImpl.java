package iih.bd.pp.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import iih.bd.pp.pripat.i.IPriPatSrvOrCaDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者价格分类服务或分类导入服务
 * 
 * @author hao_wu
 *
 */
public class BdPriPatSrvOrCaImportServiceImpl extends BDBaseDataImport<PriPatSrvOrCaDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new PriPatSrvOrCaDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { PriPatSrvOrCaDO.ID_PRIPATSRVORCA, PriPatSrvOrCaDO.ID_PRIPAT, PriPatSrvOrCaDO.ID_GRP,
				PriPatSrvOrCaDO.ID_ORG, PriPatSrvOrCaDO.ID_SRV, PriPatSrvOrCaDO.DT_B };
	}

	@Override
	protected void insertToDB(PriPatSrvOrCaDO[] importDatas) throws BizException {
		ServiceFinder.find(IPriPatSrvOrCaDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(PriPatSrvOrCaDO[] importDatas) throws BizException {
		ServiceFinder.find(IPriPatSrvOrCaDOCudService.class).update(importDatas);
	}

	@Override
	protected void updateImportNewData(PriPatSrvOrCaDO[] importDatas) throws BizException {
		super.updateImportNewData(importDatas);

		// 如果结束时间为空，则默认最大值
		FDateTime dtEnd = new FDateTime("2099-12-31 12:59:59");
		for (PriPatSrvOrCaDO priPatSrvOrCaDO : importDatas) {
			if (priPatSrvOrCaDO.getDt_e() == null) {
				priPatSrvOrCaDO.setDt_e(dtEnd);
			}
		}
	}
}
