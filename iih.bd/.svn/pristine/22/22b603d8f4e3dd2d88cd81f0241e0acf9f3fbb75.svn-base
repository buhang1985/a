package iih.bd.pp.prisrvcomp.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.IDataImport;

/**
 * 付款策略_服务定价模式(组合定价) 导入服务实现
 * 
 * @author tcy
 *
 */
public class PrisrvcompImportServiceImpl extends BDBaseDataImport<PriSrvCompDO> implements IDataImport {

	@Override
	protected BaseDO getDoInstance() {
		return new PriSrvCompDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { PriSrvCompDO.ID_PRISRVCOMP, PriSrvCompDO.QUAN, PriSrvCompDO.ID_GRP, PriSrvCompDO.ID_ORG };
	}

	@Override
	protected void insertToDB(PriSrvCompDO[] importDatas) throws BizException {
		ServiceFinder.find(IPrisrvcompCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(PriSrvCompDO[] importDatas) throws BizException {
		ServiceFinder.find(IPrisrvcompCudService.class).update(importDatas);
	}
}
