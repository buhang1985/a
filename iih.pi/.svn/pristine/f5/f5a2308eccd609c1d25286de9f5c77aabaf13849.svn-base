package iih.pi.reg.s;

import com.mysql.jdbc.StringUtils;

import iih.pi.reg.dto.patinfosupplement.d.PatConDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 根据患者id查询查询PatConDTO
 * @author F
 *
 */
public class GetPatConByIdBP {
	public PatConDTO[] exec(String id) throws BizException{
		if(StringUtils.isNullOrEmpty(id)){
			return null;
		}
		// 查询本地数据
		IPatiRService service = ServiceFinder.find(IPatiRService.class);
		PatiAggDO aggDos = service.findById(id);
		PiPatContDO[] piPatContDO = aggDos.getPiPatContDO();
		if(piPatContDO != null && piPatContDO.length>0){
			PatConDTO[] patConDTOs = new PatConDTO[piPatContDO.length];
			for(int i = 0;i<piPatContDO.length;i++){
				PatConDTO patConDTO = new PatConDTO();
				patConDTO.setId_pat(piPatContDO[i].getId_pat());
				patConDTO.setId_patcon(piPatContDO[i].getId_patcont());
				patConDTO.setId_conttp(piPatContDO[i].getId_conttp());
				patConDTO.setSd_conttp(piPatContDO[i].getSd_conttp());
				patConDTO.setId_fmrole(piPatContDO[i].getId_fmrole());
				patConDTO.setSd_fmrole(piPatContDO[i].getSd_fmrole());
				patConDTO.setName(piPatContDO[i].getName());
				patConDTO.setConttel(piPatContDO[i].getConttel());
				patConDTO.setContaddr(piPatContDO[i].getContaddr());
				patConDTO.setZip(piPatContDO[i].getZip());
				patConDTO.setId_cont(piPatContDO[i].getId_cont());
				patConDTO.setSd_cont(piPatContDO[i].getSd_cont());
				patConDTO.setContid(piPatContDO[i].getContid());
				patConDTO.setFg_guardian(piPatContDO[i].getFg_guardian());
				patConDTO.setSortno(piPatContDO[i].getSortno());
				patConDTO.setName_cont(piPatContDO[i].getContname());
				patConDTO.setName_conttp(piPatContDO[i].getConttp_name());
				patConDTO.setName_fmrole(piPatContDO[i].getName_fmrole());
				patConDTOs[i] = patConDTO;
			}
			return patConDTOs;
		}else{
			return null;
		}
		
	}
}
