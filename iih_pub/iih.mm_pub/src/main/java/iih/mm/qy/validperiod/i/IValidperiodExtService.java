package iih.mm.qy.validperiod.i;

import iih.bd.mm.supplier.d.SupplierDO;
import xap.mw.core.data.BizException;

public interface IValidperiodExtService {

	public abstract SupplierDO[] getSupList(String idBl) throws BizException;
}
