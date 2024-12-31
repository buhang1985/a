package iih.pi.reg.s.bp;

import com.mysql.jdbc.StringUtils;

import iih.pi.reg.dto.patinfosupplement.d.PatinfoSupplementDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatBiolDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 通过患者主键查询患者信息
 */
public class GetSupplyPiPatByPatIdBP {

	public PatinfoSupplementDTO exec(String id) throws BizException {

		if (StringUtils.isNullOrEmpty(id)) {
			return null;
		}
		// 查询本地数据
		IPatiRService service = ServiceFinder.find(IPatiRService.class);
		PatiAggDO aggDos = service.findById(id);
		// 根据患者id查询数据为1条时，将信息赋值到patinfoSupplementDTO中
		if (aggDos != null) {
			PatinfoSupplementDTO patinfoSupplementDTO = new PatinfoSupplementDTO();
			PatDO parentDO = aggDos.getParentDO();
			PiPatBiolDO[] piPatBiolDO = aggDos.getPiPatBiolDO();
			PatiAddrDO[] patiAddrDO = aggDos.getPatiAddrDO();
			PiPatHpDO[] piPatHpDO = aggDos.getPiPatHpDO();
			patinfoSupplementDTO.setId_pat(parentDO.getId_pat());
			patinfoSupplementDTO.setId_occu(parentDO.getId_occu());
			patinfoSupplementDTO.setId_sex(parentDO.getId_sex());
			patinfoSupplementDTO.setId_admdiv(parentDO.getId_admdiv());
			patinfoSupplementDTO.setId_educ(parentDO.getId_educ());
			patinfoSupplementDTO.setId_nation(parentDO.getId_nation());
			patinfoSupplementDTO.setId_country(parentDO.getId_country());
			patinfoSupplementDTO.setId_marry(parentDO.getId_marry());
			patinfoSupplementDTO.setCode(parentDO.getCode());
			patinfoSupplementDTO.setPassword(parentDO.getPassword());
			patinfoSupplementDTO.setId_mark(parentDO.getId_mark());
			patinfoSupplementDTO.setName_pat(parentDO.getName());
			patinfoSupplementDTO.setName_sex(parentDO.getName_sex());
			patinfoSupplementDTO.setSd_sex(parentDO.getSd_sex());
			patinfoSupplementDTO.setDt_brith(parentDO.getDt_birth());
			patinfoSupplementDTO.setName_country(parentDO.getCountry_name());
			patinfoSupplementDTO.setSd_country(parentDO.getSd_country());
			patinfoSupplementDTO.setName_nation(parentDO.getNation_name());
			patinfoSupplementDTO.setSd_nation(parentDO.getSd_nation());
			patinfoSupplementDTO.setFg_realname(parentDO.getFg_realname());
			// 证件类型名称
			patinfoSupplementDTO.setName_idtp(parentDO.getIdtp_name());
			patinfoSupplementDTO.setCode_idtp(parentDO.getId_code());
			patinfoSupplementDTO.setMob(parentDO.getMob());
			patinfoSupplementDTO.setName_marry(parentDO.getMarry_name());
			patinfoSupplementDTO.setSd_marry(parentDO.getSd_marry());
			patinfoSupplementDTO.setName_occu(parentDO.getOccu_name());
			patinfoSupplementDTO.setSd_occu(parentDO.getSd_occu());
			// 患者分类
			patinfoSupplementDTO.setName_paticate(parentDO.getPaticate_name());
			patinfoSupplementDTO.setName_patcrettp(parentDO.getPatcrettp_name());
			patinfoSupplementDTO.setName_patpritp(parentDO.getPatpritp_name());
			patinfoSupplementDTO.setTel(parentDO.getTel());
			patinfoSupplementDTO.setWorkunit(parentDO.getWorkunit());
			patinfoSupplementDTO.setName_educ(parentDO.getName_educ());
			patinfoSupplementDTO.setSd_educ(parentDO.getSd_educ());
			patinfoSupplementDTO.setPycode(parentDO.getPycode());
			patinfoSupplementDTO.setWbcode(parentDO.getWbcode());
			patinfoSupplementDTO.setMnecode(parentDO.getMnecode());
			patinfoSupplementDTO.setBarcode_chis(parentDO.getBarcode_chis());
			for(int i = 0;i<patiAddrDO.length;i++){
				if(patiAddrDO[i].getId_addrtp().equals("@@@@AA1000000000VNNU")){
					// 现住址
					 patinfoSupplementDTO.setAdress(patiAddrDO[i].getStreet());
					 // 现住区县
					 patinfoSupplementDTO.setName_admdiv(patiAddrDO[i].getAdmdiv_fullname());
					 patinfoSupplementDTO.setId_admdiv(patiAddrDO[i].getId_admdiv());
					 patinfoSupplementDTO.setSd_admdiv(patiAddrDO[i].getSd_admdiv());
					 
				}
			}			
			patinfoSupplementDTO.setSd_patsrctp(parentDO.getSd_patsrctp());
			patinfoSupplementDTO.setName_patsrctp(parentDO.getName_patsrctp());
			patinfoSupplementDTO.setName_hp(parentDO.getHp_name());
			// 医保证件号码
			if (piPatHpDO != null && piPatHpDO.length > 0) {
				patinfoSupplementDTO.setCode_hp(piPatHpDO[0].getNo_hp());
			}
			patinfoSupplementDTO.setName_srcregiontps(parentDO.getSd_srcregiontp());
			patinfoSupplementDTO.setName_srcregiontps(parentDO.getName_srcregiontp());
			if (piPatBiolDO != null && piPatBiolDO.length > 0) {
				patinfoSupplementDTO.setSd_blood_adobo(piPatBiolDO[0].getSd_blood_abo());
				patinfoSupplementDTO.setName_blood_abo(piPatBiolDO[0].getBloodabo_name());
			}
			return patinfoSupplementDTO;
		} else {
			return null;
		}
	}
}
