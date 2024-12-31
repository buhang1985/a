package iih.pi.reg.s.bp;

import iih.pi.reg.d.PiPatAddressDTO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据患者地址信息查询患者地址
 * 返回区县码对应全名称
 */
public class GetPatAddressBP {

	/**
	 * 根据患者地址信息查询患者地址
	 * @param addrDto
	 * @throws BizException
	 */
	public PiPatAddressDTO exec(String patAddrId) throws BizException {
		
		if(StringUtil.isEmpty(patAddrId))
			return null;
		
		IPatiAddrDORService addrService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO addrDo = addrService.findById(patAddrId);
		if(addrDo == null){
			throw new BizException("患者地址数据不存在 id：" + patAddrId);
		}
		
		PiPatAddressDTO addrDto = new PiPatAddressDTO();
		addrDto.setId_pataddr(patAddrId);
		addrDto.setName_admdiv(addrDo.getAdmdiv_name());
		addrDto.setStreet(addrDo.getStreet());
		
		return addrDto;
	}
}
