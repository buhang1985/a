package iih.bd.pp.prisrv.s.impt;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.pp.prisrv.i.IPrisrvCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_服务定价模式 导入服务实现
 * 
 * @author tcy
 *
 */
public class PrisrvImportServiceImpl extends BDBaseDataImport<PriSrvDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new PriSrvDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { PriSrvDO.ID_PRISRV, PriSrvDO.PRICE, PriSrvDO.DT_B, PriSrvDO.DT_E, PriSrvDO.ID_SRV,
				PriSrvDO.FG_ACTIVE, PriSrvDO.ID_GRP, PriSrvDO.ID_ORG };
	}

	@Override
	protected void insertToDB(PriSrvDO[] importDatas) throws BizException {
		ServiceFinder.find(IPrisrvCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(PriSrvDO[] importDatas) throws BizException {
		ServiceFinder.find(IPrisrvCudService.class).update(importDatas);
	}

	@Override
	protected void updateImportNewData(PriSrvDO[] importDatas) throws BizException {
		super.updateImportNewData(importDatas);

		if (ArrayUtils.isEmpty(importDatas)) {
			return;
		}

		FDateTime nowTime = AppUtils.getServerDateTime();
		for (PriSrvDO priSrvDO : importDatas) {
			if (priSrvDO.getDt_b() == null) {
				priSrvDO.setDt_b(nowTime);
			}
		}
	}
}
