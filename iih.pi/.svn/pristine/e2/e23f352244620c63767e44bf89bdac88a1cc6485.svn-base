package iih.pi.reg.s;

import com.mysql.jdbc.StringUtils;

import iih.pi.reg.dto.patinfosupplement.d.PatAddDTO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class GetPatAddrBP {
	/**
	 * 
	 * 根据患者主键查询患者地址
	 * 
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public PatAddDTO[] exec(String id) throws BizException {
		if (StringUtils.isNullOrEmpty(id)) {
			return null;
		}
		IPatiRService service = ServiceFinder.find(IPatiRService.class);
		PatiAggDO aggDO = service.findById(id);
		if (aggDO == null) {
			return null;
		}
		PatiAddrDO[] patiAddrDO = aggDO.getPatiAddrDO();
		if (patiAddrDO != null && patiAddrDO.length > 0) {
			PatAddDTO[] PatAddDTO= new PatAddDTO[patiAddrDO.length];
			for (int i = 0; i < patiAddrDO.length; i++) {
				PatAddDTO patAddDTO = new PatAddDTO();
				patAddDTO.setId_pataddr(patiAddrDO[i].getId_pataddr());
				patAddDTO.setId_pat(patiAddrDO[i].getId_pat());
				patAddDTO.setSd_addrtp(patiAddrDO[i].getSd_addrtp());
				patAddDTO.setId_addrtp(patiAddrDO[i].getId_addrtp());
				patAddDTO.setSd_admdiv(patiAddrDO[i].getSd_admdiv());
				patAddDTO.setId_admdiv(patiAddrDO[i].getId_admdiv());
				patAddDTO.setStreet(patiAddrDO[i].getStreet());
				patAddDTO.setZip(patiAddrDO[i].getZip());
				patAddDTO.setTel(patiAddrDO[i].getTel());
				patAddDTO.setName_addrtp(patiAddrDO[i].getAddrtp_name());
				patAddDTO.setName_admdiv(patiAddrDO[i].getAdmdiv_fullname());
				PatAddDTO[i] = patAddDTO;
			}
			return PatAddDTO;

		} else {
			return null;
		}
	}
}
