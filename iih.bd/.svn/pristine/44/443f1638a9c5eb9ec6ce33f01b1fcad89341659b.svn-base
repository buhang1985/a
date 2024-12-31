package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrtplvst.d.BdMrtplVstItmDO;
import iih.bd.srv.mrtplvst.i.IBdMrtplVstItmDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @description:体征模板项目关系导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 上午11:57:51 
* 
*/
public class BdMrtplVstItmDataImptServiceImpl extends BDBaseDataImport<BdMrtplVstItmDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new BdMrtplVstItmDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdMrtplVstItmDO.ID_MRTPL_VST_ITM, BdMrtplVstItmDO.ID_MRTPL_VST, BdMrtplVstItmDO.ID_MRTPL_VS };
	}

	@Override
	protected void insertToDB(BdMrtplVstItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdMrtplVstItmDOCudService.class).insert(importDatas);	
	}

	@Override
	protected void updateToDB(BdMrtplVstItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdMrtplVstItmDOCudService.class).update(importDatas);
	}

}
