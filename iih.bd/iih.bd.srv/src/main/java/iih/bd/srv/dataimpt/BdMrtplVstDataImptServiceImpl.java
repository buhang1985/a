package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrtplvst.d.BdMrtplVstDO;
import iih.bd.srv.mrtplvst.i.IMrtplvstMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/** 
* @description:生命体征模版导入数据
* @author : hehaochen
* @version 创建时间：2019年12月16日 上午11:51:18 
* 
*/
public class BdMrtplVstDataImptServiceImpl extends BDBaseDataImport<BdMrtplVstDO>{

	@Override
	protected BaseDO getDoInstance() {
		return new BdMrtplVstDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdMrtplVstDO.ID_MRTPL_VST, BdMrtplVstDO.ID_MRTPL };
	}

	@Override
	protected void insertToDB(BdMrtplVstDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplvstMDOCudService.class).insert(importDatas);	
	}

	@Override
	protected void updateToDB(BdMrtplVstDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplvstMDOCudService.class).update(importDatas);
	}
	
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_mrtpl_vst where fg_sys <> 'Y'");
		return true;
	}


}
