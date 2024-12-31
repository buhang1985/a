package iih.bd.pp.cust.impt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.cust.d.CustDO;
import iih.bd.pp.cust.i.ICustDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略_客户分类_客户单位
 * 
 * @author Liwq
 *
 */
public class BdCustImportServiceImpl extends BDBaseDataImport<CustDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new CustDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { CustDO.ID_CUSTCA, CustDO.NAME, CustDO.CODE, CustDO.ID_GRP, CustDO.ID_ORG };
	}

	@Override
	protected void insertToDB(CustDO[] importDatas) throws BizException {
		ServiceFinder.find(ICustDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(CustDO[] importDatas) throws BizException {
		ServiceFinder.find(ICustDOCudService.class).update(importDatas);
	}
}
