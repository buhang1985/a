package iih.bd.pp.cust.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.cust.d.CustCaDO;
import iih.bd.pp.cust.i.ICustMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_客户分类_
 * 
 * @author Liwq
 *
 */
public class BdCustCaImportServiceImpl extends BDBaseDataImport<CustCaDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new CustCaDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { CustCaDO.ID_CUSTTP, CustCaDO.SD_CUSTTP, CustCaDO.NAME, CustCaDO.CODE, CustCaDO.ID_GRP,
				CustCaDO.ID_ORG };
	}

	@Override
	protected void insertToDB(CustCaDO[] importDatas) throws BizException {
		ServiceFinder.find(ICustMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(CustCaDO[] importDatas) throws BizException {
		ServiceFinder.find(ICustMDOCudService.class).update(importDatas);
	}
}