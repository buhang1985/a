package iih.bl.cg.bp.ip;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.dto.d.BlIpPatDTO;
import iih.bl.cg.dto.d.EntPatInfoDTO;
import iih.bl.cg.service.IBlcgqueryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @author 
 *
 */
public class GetIpPatConListInHosBP {
	/**
	 * 获取在院患者列表
	 * @param depId 科室id
	 * @param fuzzyCond 模糊查询条件
	 * @return 住院患者列表
	 * @throws BizException
	 * @author liming
	 */
	public BlIpPatDTO[] exec(String depId,String fuzzyCond) throws BizException{
		IBlcgqueryService blcgqueryService =ServiceFinder.find(IBlcgqueryService.class);
		EntPatInfoDTO[] entPatInfoDTO=blcgqueryService.findEntConPatInfoByCondition(depId,"0",fuzzyCond);
		List<BlIpPatDTO> blIpPatDTOList= new ArrayList<BlIpPatDTO>();
		for(EntPatInfoDTO dto:entPatInfoDTO){
			BlIpPatDTO blIpPatDTO= new BlIpPatDTO();
			blIpPatDTO.setId_ent(dto.getId_ent());
			blIpPatDTO.setCode_amr_ip(dto.getCode_amr_ip());
			blIpPatDTO.setId_pat(dto.getId_pat());
			blIpPatDTO.setName_pat(dto.getName_pat());
			if (dto.getDt_acpt()==null) {
				blIpPatDTO.setDt_entry(new FDateTime());
			}
			blIpPatDTO.setName_bed(dto.getName_bed());
			blIpPatDTO.setId_dep_nur(dto.getId_dep_nur());
			blIpPatDTO.setName_dep_nur(dto.getName_dep_nur());
			blIpPatDTO.setId_dep_phy(dto.getId_dep_phy());
			blIpPatDTO.setName_dep_phy(dto.getName_dep_phy());
			blIpPatDTOList.add(blIpPatDTO);
		}		
		return blIpPatDTOList.size()>0?blIpPatDTOList.toArray(new BlIpPatDTO[blIpPatDTOList.size()]):null;
	}
}
