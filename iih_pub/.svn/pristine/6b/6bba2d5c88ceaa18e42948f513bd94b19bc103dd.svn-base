package iih.mbh.ci.i;

import xap.mw.core.data.BizException;
import javax.jws.WebParam;
import javax.jws.WebService;
import iih.mbh.ci.memo.d.CiDrMemoDTO;

@WebService
public interface IMbhCiMaintanceService {

	public abstract boolean delDrMemoExec(@WebParam(name="id_memo") String id_memo) throws BizException;

	public abstract CiDrMemoDTO saveDrMemoExec(@WebParam(name="param") CiDrMemoDTO param) throws BizException;

}
