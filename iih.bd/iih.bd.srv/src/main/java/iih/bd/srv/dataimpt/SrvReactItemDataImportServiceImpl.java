package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.srvreact.d.SrvReactItemDO;
import iih.bd.srv.srvreact.i.ISrvReactItemDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 服务互斥项目数据导入服务实现类
 * 
 * @author hao_wu 2018-5-28
 *
 */
public class SrvReactItemDataImportServiceImpl extends BDBaseDataImport<SrvReactItemDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new SrvReactItemDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { SrvReactItemDO.ID_SRV, SrvReactItemDO.ID_SRVREACT, SrvReactItemDO.ID_SRVREACTITM };
	}

	@Override
	protected void insertToDB(SrvReactItemDO[] importDatas) throws BizException {
		ServiceFinder.find(ISrvReactItemDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(SrvReactItemDO[] importDatas) throws BizException {
		ServiceFinder.find(ISrvReactItemDOCudService.class).update(importDatas);
	}
}
