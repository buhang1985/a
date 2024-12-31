package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrtplvs.d.BdMrtplVsDO;
import iih.bd.srv.mrtplvs.i.IMrtplvsMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @description:生命体征项导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 下午1:06:59 
* 
*/
public class BdMrtplVsDataImptServiceImpl extends BDBaseDataImport<BdMrtplVsDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new BdMrtplVsDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdMrtplVsDO.ID_MRTPL_VS };
	}

	@Override
	protected void insertToDB(BdMrtplVsDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplvsMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdMrtplVsDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplvsMDOCudService.class).update(importDatas);
	}

}
