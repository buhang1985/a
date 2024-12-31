package iih.bd.pp.incca.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.i.IIncCaItmDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 付款策略_票据分类项目 导入服务实现
 * 
 * @author tcy
 *
 */
public class IncCaItmImportServiceImpl extends BDBaseDataImport<IncCaItmDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new IncCaItmDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { IncCaItmDO.ID_INCCAITM, IncCaItmDO.NAME, IncCaItmDO.CODE, IncCaItmDO.ID_GRP,
				IncCaItmDO.ID_ORG };
	}

	@Override
	protected void insertToDB(IncCaItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IIncCaItmDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(IncCaItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IIncCaItmDOCudService.class).update(importDatas);
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_incca_itm");
		daFacade.execUpdate("delete from bd_incca_itm_rel");
		return true;
	}
}
