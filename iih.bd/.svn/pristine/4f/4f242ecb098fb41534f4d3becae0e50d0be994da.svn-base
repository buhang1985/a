package iih.bd.mm.supplierprotocol.s.ds;

import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import iih.bd.mm.supplierprotocol.i.ds.ISupplierProFlowService;
import iih.bd.mm.supplierprotocol.s.bp.SupproExamBp;
import xap.mw.core.data.BizException;

public class SupplierProFlowServiceImpl implements ISupplierProFlowService {

	@Override
	public SupplierprotocolAggDO[] submitSupplierPro(String[] ids) throws BizException {

		SupproExamBp bp = new SupproExamBp();
		
		return bp.Submit(ids);
	}

	@Override
	public SupplierprotocolAggDO acceptSupplierPro(SupplierprotocolAggDO supplierProAggDO) throws BizException {

		SupproExamBp bp = new SupproExamBp();
		
		return bp.Accept(supplierProAggDO);
	}

	@Override
	public SupplierprotocolAggDO rejectSupplierPro(SupplierprotocolAggDO supplierProAggDO) throws BizException {

        SupproExamBp bp = new SupproExamBp();
		
		return bp.Reject(supplierProAggDO);
	}
}
