package iih.pi.reg.s.external.provide;

import iih.bd.pp.cust.d.CustDO;
import iih.pi.reg.dto.picustpedto.d.PiCustPeDTO;
import iih.pi.reg.i.external.provide.IContractCustPeService;
import iih.pi.reg.s.external.provide.bp.GroupCustPeBP;
import iih.pi.reg.s.external.provide.bp.UpGroCustPatBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 团检单位对接体检接口
 * 
 * @author houll 2018/11/27
 *
 */
@Service(serviceInterfaces = { IContractCustPeService.class }, binding = Binding.JSONRPC)
public class ContractCustPeServiceImpl implements IContractCustPeService {
	
	/**
	 * 新增团检单位信息
	 * 
	 * @author houll 2018/11/27
	 * @param 团检单位信息dto
	 */
	@Override
	public CustDO[] createCusts(PiCustPeDTO[] custDTO) throws BizException {
		GroupCustPeBP groupCustPeBP = new GroupCustPeBP();
		return groupCustPeBP.exec(custDTO);
	}

	@Override
	public CustDO[] updateCusts(PiCustPeDTO[] custDTO) throws BizException {
		UpGroCustPatBP bp = new UpGroCustPatBP();
		return bp.exec(custDTO);
	}

	@Override
	public PiCustPeDTO[] find(PiCustPeDTO[] custDTO) throws BizException {
		return null;
	}

}
