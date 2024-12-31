package iih.pi.reg.s.bp.util;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.dto.d.PiPatBS501CondDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatHpDO;

public class PiBS501CondSetUtil {

	public static PiPatBS501CondDTO getCond(PatiAggDO aggDO, String orgId) throws BizException {
		PatDO pat = aggDO.getParentDO();
		PiPatHpDO[] hpDos = aggDO.getPiPatHpDO();
		PatiAddrDO[] addrDos = aggDO.getPatiAddrDO();

		PiPatBS501CondDTO cond = new PiPatBS501CondDTO();
		cond.setDomain_id("01");
		cond.setPatient_id(pat.getId_pat());
		cond.setP_bar_code(pat.getCode_amr_oep());
		cond.setInpatient_no(pat.getCode_amr_ip());
		cond.setImg_no("");

		if (hpDos != null && hpDos.length > 0) {
			cond.setAddition_no1(hpDos[0].getHp_code());
		}

		switch (pat.getSd_idtp()) {
		case IPiDictCodeConst.SD_IDTP_IDENTITY:
			// 身份证
			cond.setSocial_no(pat.getId_code());
			break;
		case IPiDictCodeConst.SD_IDTP_JMHKB:
			// 户口本
			cond.setOther_card_no_jmhkb(pat.getId_code());
			break;
		case IPiDictCodeConst.SD_IDTP_HZ:
			// 护照
			cond.setOther_card_no_hz(pat.getId_code());
			break;
		case IPiDictCodeConst.SD_IDTP_JGZ:
			// 军官证
			cond.setOther_card_no_jgz(pat.getId_code());
			break;
		case IPiDictCodeConst.SD_IDTP_JSZ:
			// 驾驶证
			cond.setOther_card_no_jsz(pat.getId_code());
			break;
		case IPiDictCodeConst.SD_IDTP_GAJMZ:
			// 港澳通行证
			cond.setOther_card_no_gajm(pat.getId_code());
			break;
		case IPiDictCodeConst.SD_IDTP_TWJMZ:
			// 台湾通行证
			cond.setOther_card_no_twjm(pat.getId_code());
			break;
		case IPiDictCodeConst.SD_IDTP_QTFDZ:
			// 其他
			cond.setOther_card_no_qtfd(pat.getId_code());
			break;
		}

		cond.setName(pat.getName());
		cond.setSex(pat.getSd_sex());
		cond.setBirthday(pat.getDt_birth() == null ? "" : pat.getDt_birth()
				.toString());

		cond.setEmail(null);
		cond.setHome_tel(pat.getTel());
		cond.setMobile(pat.getMob());
		cond.setWork_phone("");

		if (addrDos != null && addrDos.length > 0) {
			for (PatiAddrDO item : addrDos) {
				switch (item.getSd_addrtp()) {
				case IPiDictCodeConst.SD_ADDR_TYPE_BORN:
					// 出生地
					cond.setHome_district(item.getAdmdiv_name()
							+ item.getStreet());
					break;
				case IPiDictCodeConst.SD_ADDR_TYPE_NOW:
					// 现住址
					cond.setLive_district_code(item.getSd_admdiv());
					cond.setLive_street(item.getStreet());
					cond.setLive_address(item.getStreet());
					cond.setLive_postcode(item.getZip());
					break;
				case IPiDictCodeConst.SD_ADDR_TYPE_FAMILY:
					cond.setHome_district_code(item.getSd_admdiv());
					cond.setHome_street(item.getStreet());
					cond.setHome_address(item.getStreet());
					cond.setHome_zipcode(item.getZip());
					break;
				case IPiDictCodeConst.SD_ADDR_TYPE_CENCUS:
					cond.setNative_district_code(item.getSd_admdiv());
					cond.setNative_street(item.getStreet());
					cond.setNative_address(item.getStreet());
					cond.setNative_postcode(item.getZip());
					break;
				case IPiDictCodeConst.SD_ADDR_TYPE_WORK:
					cond.setWork_district_code(item.getSd_admdiv());
					cond.setWork_street(item.getStreet());
					cond.setWork_address(item.getStreet());
					cond.setWork_postcode(item.getZip());
					break;
				}
			}
		}
		IOrgRService orgservice = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDo = orgservice.findById(orgId);
		if (orgDo != null) {
			cond.setHospital_code(orgDo.getOrgcode());// 医疗机构编码
		}		
		return cond;
	}

}
