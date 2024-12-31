package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.orpltpstafunc.i.IOrpltpstafuncCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年5月24日 上午11:22:07 类说明：闭环状态点配置导入数据 Company: Copyright 2017
 *          by PKU healthcare IT Co.,Ltd.
 */
public class BdOrpltpstaFuncDataImplServiceImpl extends BDBaseDataImport<OrpltpStaFuncDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new OrpltpStaFuncDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { OrpltpStaFuncDO.ID_ORPLTPSTAFUNC, OrpltpStaFuncDO.ID_FUN, OrpltpStaFuncDO.ID_ORPLTP,
				OrpltpStaFuncDO.ID_ORPLTPSTA };
	}

	@Override
	protected void insertToDB(OrpltpStaFuncDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpstafuncCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(OrpltpStaFuncDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpstafuncCudService.class).insert(importDatas);
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_orpltpsta_func where fg_sys <> 'Y'");
		return true;

	}
}
