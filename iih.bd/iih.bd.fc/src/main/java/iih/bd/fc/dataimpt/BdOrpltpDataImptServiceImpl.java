package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.i.IOrpltpMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/** 
* @description:医嘱执行闭环类型定义导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 上午10:57:41 
* 
*/
public class BdOrpltpDataImptServiceImpl extends BDBaseDataImport<OrpltpDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new OrpltpDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[]{OrpltpDO.ID_ORPLTP};
	}

	@Override
	protected void insertToDB(OrpltpDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(OrpltpDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpMDOCudService.class).update(importDatas);
	}
	
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_orpltp where fg_sys <> 'Y'");
		return true;

	}

}
