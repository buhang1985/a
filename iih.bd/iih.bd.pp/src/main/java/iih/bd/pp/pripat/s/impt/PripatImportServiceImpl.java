package iih.bd.pp.pripat.s.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.i.IPripatMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 付款策略_患者价格分类 导入服务实现
 * 
 * @author tcy
 *
 */
public class PripatImportServiceImpl extends BDBaseDataImport<PriPatDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new PriPatDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { PriPatDO.ID_PRIPAT, PriPatDO.NAME, PriPatDO.CODE, PriPatDO.ID_ORG, PriPatDO.ID_GRP };
	}

	@Override
	protected void insertToDB(PriPatDO[] importDatas) throws BizException {
		ServiceFinder.find(IPripatMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(PriPatDO[] importDatas) throws BizException {
		ServiceFinder.find(IPripatMDOCudService.class).update(importDatas);
	}

	@Override
	protected void updateImportNewData(PriPatDO[] importDatas) throws BizException {
		super.updateImportNewData(importDatas);

		// 设置同步标识为false
		for (PriPatDO priPatDO : importDatas) {
			priPatDO.setFg_syncpri(FBoolean.FALSE);
		}
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		// 删除主子表
		daFacade.execUpdate("delete from BD_PRI_PAT");
		daFacade.execUpdate("delete from BD_PRI_PAT_SRVORCA");
		return true;
	}
}
