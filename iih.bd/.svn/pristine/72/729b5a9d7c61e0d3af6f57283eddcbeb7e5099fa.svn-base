package iih.bd.mm.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplier.i.ISupplierCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 供应商与厂商数据导入服务实现
 * 
 * @author hao_wu
 *
 */
public class SupDataImptServiceImpl extends BDBaseDataImport<SupplierDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new SupplierDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { SupplierDO.ID_SUP, SupplierDO.NAME, SupplierDO.CODE, SupplierDO.FG_FAC,
				SupplierDO.FG_SUP };
	}

	@Override
	protected void insertToDB(SupplierDO[] importDatas) throws BizException {
		ServiceFinder.find(ISupplierCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(SupplierDO[] importDatas) throws BizException {
		ServiceFinder.find(ISupplierCudService.class).update(importDatas);
	}
}
