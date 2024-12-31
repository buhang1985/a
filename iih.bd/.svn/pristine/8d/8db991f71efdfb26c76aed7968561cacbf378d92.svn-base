package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltp.i.IOrpltpStaDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/** 
* @description:医嘱执行闭环类型状态导入数据 
* @author : hehaochen
* @version 创建时间：2019年12月16日 上午11:15:12 
* 
*/
public class BdOrpltpstaDataImptServiceImpl extends BDBaseDataImport<OrpltpStaDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new OrpltpStaDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[]{ OrpltpStaDO.ID_ORPLTPSTA, OrpltpStaDO.ID_ORPLTP };
	}

	@Override
	protected void insertToDB(OrpltpStaDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpStaDOCudService.class).insert(importDatas);	
	}

	@Override
	protected void updateToDB(OrpltpStaDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpStaDOCudService.class).update(importDatas);	
	}
	
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_orpltpsta where fg_sys <> 'Y'");
		return true;
	}
}
