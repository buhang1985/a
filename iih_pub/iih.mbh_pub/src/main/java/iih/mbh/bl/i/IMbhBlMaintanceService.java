package iih.mbh.bl.i;

import java.util.List;
import xap.mw.core.data.BizException;
import javax.jws.WebParam;
import javax.jws.WebService;
import iih.mbh.bl.fee.d.AddedFeeDTO;

@WebService
public interface IMbhBlMaintanceService {

	public abstract boolean ReFund(@WebParam(name="addedFeeDto") AddedFeeDTO addedFeeDto, @WebParam(name="id_dept") String id_dept, @WebParam(name="id_ent") String id_ent) throws BizException;

	public abstract boolean saveAddFee(@WebParam(name="addFeeList") List<AddedFeeDTO> addFeeList, @WebParam(name="id_ent") String id_ent,@WebParam(name="id_dept") String id_dept) throws BizException;

}
