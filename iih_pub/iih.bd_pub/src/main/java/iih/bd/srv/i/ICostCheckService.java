package iih.bd.srv.i;

import iih.bd.srv.d.CostCheckDTO;
import xap.mw.core.data.BizException;

public interface ICostCheckService {

	public abstract CostCheckDTO[] getCostCheck(String id_srv) throws BizException;
}
