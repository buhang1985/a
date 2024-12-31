package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.orwf.d.OrWfCfgDO;
import iih.bd.fc.orwf.i.IOrwfMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @description:流向配置导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 下午1:40:33 
* 
*/
public class BdWfCfgDataImplServiceImpl extends BDBaseDataImport<OrWfCfgDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new OrWfCfgDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { OrWfCfgDO.ID_WF_CFG, OrWfCfgDO.ID_WF };
	}

	@Override
	protected void insertToDB(OrWfCfgDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrwfMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(OrWfCfgDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrwfMDOCudService.class).update(importDatas);
	}

}
