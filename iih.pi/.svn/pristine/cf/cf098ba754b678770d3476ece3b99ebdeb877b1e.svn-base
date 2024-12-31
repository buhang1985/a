package iih.pi.reg.s;

import com.mysql.jdbc.StringUtils;

import iih.pi.reg.dto.patinfosupplement.d.PatBiloDTO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatBiolDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class GetPatBiloBP {
/**
 * 
 * 查血型
 * 
 * @param id
 * @return
 * @throws BizException
 */
	public PatBiloDTO exec(String id) throws BizException{
		if(StringUtils.isNullOrEmpty(id)){
			return null;
		}
		IPatiRService service = ServiceFinder.find(IPatiRService.class);
		PatiAggDO aggDO = service.findById(id);
		if(aggDO == null){
			return null;
		}
		PiPatBiolDO[] piPatBiolDO = aggDO.getPiPatBiolDO();
		if(piPatBiolDO != null && piPatBiolDO.length>0){
			PatBiloDTO patBiloDTO = new PatBiloDTO();
			patBiloDTO.setId_patbiol(piPatBiolDO[0].getId_patbiol());
			patBiloDTO.setId_blood_abo(piPatBiolDO[0].getId_blood_abo());
			patBiloDTO.setSd_bloo_rh(piPatBiolDO[0].getSd_blood_rh());
			patBiloDTO.setId_blood_rh(piPatBiolDO[0].getId_blood_rh());
			patBiloDTO.setSd_blood_abo(piPatBiolDO[0].getSd_blood_abo());
			patBiloDTO.setName_blood_abo(piPatBiolDO[0].getBloodabo_name());
			patBiloDTO.setName_blood_rh(piPatBiolDO[0].getBloodrh_name());
			return patBiloDTO;
		}else{
			return null;
		}
		
	}
}
