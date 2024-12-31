package iih.pi.reg.s.ws;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.dto.d.PiPatRepeatDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiRService;

/**
 * empi不启用时，简单校验患者数据
 * @author Administrator
 *
 */
public class SimpleCheckWhenEmpiIsOffBP {

	/**
	 * 通过患者姓名证件号查询重复患者
	 * @param namePat
	 * @param sdIdTp
	 * @param idCode
	 * @return
	 * @throws BizException
	 */
	public PiPatRepeatDTO[] exec(String namePat, String sdIdTp, String idCode) throws BizException{
		
		if(StringUtil.isEmpty(idCode))
			return null;
		
		IPatiRService rService = ServiceFinder.find(IPatiRService.class);
		String wheresql = "a0.fg_invd = 'N' and a0.fg_active='Y' and a0.sd_idtp = '" + sdIdTp + "' and a0.id_code = '" + idCode + "' " ;
		if(!StringUtil.isEmpty(namePat)){
			wheresql += "and a0.name like '%" +namePat+ "%' ";
		}
		
		PatiAggDO[] aggDos = rService.find(wheresql, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(aggDos))
			return null;
		
		List<PiPatRepeatDTO> rltList = new ArrayList<PiPatRepeatDTO>();
		for (PatiAggDO aggDo : aggDos) {
			PiPatRepeatDTO dto = new PiPatRepeatDTO();
			PatDO patDo = aggDo.getParentDO();
			dto.setEmpi_id(patDo.getCode());
			dto.setData_flag("疑似");
			dto.setName(patDo.getName());
			dto.setCode(patDo.getCode());
			dto.setName_sex(patDo.getName_sex());
			dto.setDt_birth(patDo.getDt_birth());
			if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDo.getSd_idtp())){
				dto.setId_code(patDo.getId_code());
			}
			dto.setMobile(patDo.getTel());
			dto.setConttel(patDo.getMob());
			dto.setBirth_place(patDo.getWorkunit());
			dto.setCountry_code_name(patDo.getCountry_name());
			dto.setNation_code_name(patDo.getNation_name());
			//dto.setBorn_place(Born_place);
			dto.setEducation_code_name(patDo.getName_educ());
			dto.setOccupation_type_name(patDo.getOccu_name());
			dto.setMarry_code_name(patDo.getMarry_name());
			
			PatiAddrDO[] addrDos = aggDo.getPatiAddrDO();
			if(!ArrayUtil.isEmpty(addrDos)){
				for (PatiAddrDO addrDO : addrDos) {
					if(IPiDictCodeConst.SD_ADDR_TYPE_NOW.equals(addrDO.getSd_addrtp())){
						dto.setHome_address(addrDO.getAdmdiv_fullname());
						dto.setHome_street(addrDO.getStreet());
					}else if(IPiDictCodeConst.SD_ADDR_TYPE_FAMILY.equals(addrDO.getSd_addrtp())){
						dto.setLive_address(addrDO.getAdmdiv_fullname());
						dto.setLive_street(addrDO.getStreet());
						dto.setLive_postcode(addrDO.getZip());
					}else if(IPiDictCodeConst.SD_ADDR_TYPE_WORK.equals(addrDO.getSd_addrtp())){
						dto.setWork_address(addrDO.getAdmdiv_fullname());
						dto.setWork_street(addrDO.getStreet());
					}
				}
			}
			
			PiPatContDO[] contDos = aggDo.getPiPatContDO();
			if(!ArrayUtil.isEmpty(contDos)){
				PiPatContDO contDo = contDos[0];
				dto.setName_cont(contDo.getName());
				dto.setRelation_code_name(contDo.getConttp_name());
				dto.setRelation_tel(contDo.getConttel());
				dto.setRelation_street(contDo.getContaddr());
			}
			
			PiPatHpDO[] hpDos = aggDo.getPiPatHpDO();
			if(!ArrayUtil.isEmpty(hpDos)){
				for (PiPatHpDO hpDo : hpDos) {
					if(FBoolean.TRUE.equals(hpDo.getFg_deft())){
						dto.setNo_hp(hpDo.getNo_hp());
						break;
					}
				}
				
				if(StringUtil.isEmpty(dto.getNo_hp())){
					dto.setNo_hp(hpDos[0].getNo_hp());
				}
			}
			
			rltList.add(dto);
		}
		
		return rltList.toArray(new PiPatRepeatDTO[0]);
	}
}
