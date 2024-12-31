package iih.bd.mm.supplierprotocol.s.ds;

import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import iih.bd.mm.supplierprotocol.i.ds.ISupplierProtocolService;
import iih.bd.mm.supplierprotocol.s.bp.UpdateSupproBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;

public class SupplierProtocolServiceImpl implements ISupplierProtocolService {

	@Override
	public void delete(String[] ids) throws BizException {

		UpdateSupproBp bp = new UpdateSupproBp();
		
		bp.Delete(ids);
	}

	@Override
	public SupplierprotocolAggDO[] enable(String[] ids) throws BizException {

		UpdateSupproBp bp = new UpdateSupproBp();
		
		return bp.Enable(ids);
	}

	@Override
	public SupplierprotocolAggDO[] disable(String[] ids) throws BizException {

		UpdateSupproBp bp = new UpdateSupproBp();
		
		return bp.Disable(ids);
	}

	@Override
	public FBoolean deleteCheck(String[] ids) throws BizException {

		UpdateSupproBp bp = new UpdateSupproBp();
		
		return bp.DeleteCheck(ids);
	}

	@Override
	public FDouble getMmSupproPrice(String id_sup, String id_mm, FDate date_reqr) throws BizException {
		
		return SupplierProtocolCache.getInstance().getMmSupproPrice(id_sup, id_mm, date_reqr);
	}
}
