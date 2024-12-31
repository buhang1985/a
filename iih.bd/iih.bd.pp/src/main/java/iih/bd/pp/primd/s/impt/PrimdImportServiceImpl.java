package iih.bd.pp.primd.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.primd.d.PrimdDO;
import iih.bd.pp.primd.i.IPrimdCudService;
import xap.mw.core.data.BaseDO;
//import org.apache.commons.lang3.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_定价模式 导入服务实现
 * 
 * @author tcy
 *
 */
public class PrimdImportServiceImpl extends BDBaseDataImport<PrimdDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new PrimdDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { PrimdDO.ID_PRI, PrimdDO.NAME, PrimdDO.CODE, PrimdDO.ID_GRP, PrimdDO.ID_ORG };
	}

	@Override
	protected void insertToDB(PrimdDO[] importDatas) throws BizException {
		ServiceFinder.find(IPrimdCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(PrimdDO[] importDatas) throws BizException {
		ServiceFinder.find(IPrimdCudService.class).update(importDatas);
	}
}
