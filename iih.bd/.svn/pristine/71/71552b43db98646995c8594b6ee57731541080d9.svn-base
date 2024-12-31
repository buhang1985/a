package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrtplvs.d.BdMrtplVsItmDO;
import iih.bd.srv.mrtplvs.i.IBdMrtplVsItmDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @description:生命体征项属性导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 下午1:10:49 
* 
*/
public class BdMrtplVsItmDataImptServiceImpl extends BDBaseDataImport<BdMrtplVsItmDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new BdMrtplVsItmDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdMrtplVsItmDO.ID_MRTPL_VS_ITM, BdMrtplVsItmDO.ID_MRTPL_VS };
	}

	@Override
	protected void insertToDB(BdMrtplVsItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdMrtplVsItmDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdMrtplVsItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdMrtplVsItmDOCudService.class).update(importDatas);
	}

}
