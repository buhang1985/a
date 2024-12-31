package iih.bd.pp.incca.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.incca.d.IncCaDO;
import iih.bd.pp.incca.i.IInccaMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 付款策略_票据分类 导入服务实现
 * 
 * @author tcy
 *
 */
public class InccaImportServiceImpl extends BDBaseDataImport<IncCaDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new IncCaDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { IncCaDO.ID_INCCA, IncCaDO.NAME, IncCaDO.CODE, IncCaDO.ID_GRP, IncCaDO.ID_ORG };
	}

	@Override
	protected void insertToDB(IncCaDO[] importDatas) throws BizException {
		ServiceFinder.find(IInccaMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(IncCaDO[] importDatas) throws BizException {
		ServiceFinder.find(IInccaMDOCudService.class).update(importDatas);
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_incca");
		daFacade.execUpdate("delete from bd_incca_itm");
		daFacade.execUpdate("delete from bd_incca_itm_rel");
		return true;
	}
}
