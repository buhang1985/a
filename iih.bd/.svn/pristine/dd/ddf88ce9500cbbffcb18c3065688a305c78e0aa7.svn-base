package iih.bd.pp.prisrvsetfix.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.prisrvsetfix.d.PriSrvSetFixDO;
import iih.bd.pp.prisrvsetfix.i.IPrisrvsetfixCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class PrisrvsetfixImportServiceImpl extends BDBaseDataImport<PriSrvSetFixDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new PriSrvSetFixDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { PriSrvSetFixDO.ID_SRVSET, PriSrvSetFixDO.ID_SRVADD, PriSrvSetFixDO.QUAN_MAX,
				PriSrvSetFixDO.QUAN_MIN, PriSrvSetFixDO.ID_GRP, PriSrvSetFixDO.ID_ORG };
	}

	@Override
	protected void insertToDB(PriSrvSetFixDO[] importDatas) throws BizException {
		ServiceFinder.find(IPrisrvsetfixCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(PriSrvSetFixDO[] importDatas) throws BizException {
		ServiceFinder.find(IPrisrvsetfixCudService.class).update(importDatas);
	}
}
