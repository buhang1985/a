package iih.ci.ord.s.ems.utils;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.Context;

public class CiEnContextUtils {
	/**
	 * 铜陵疫苗执行，临时获得就诊上下文信息
	 * @param pat
	 * @return
	 */
	public CiEnContextDTO getCiEnContextDTO(PatiVisitDO pat) {
		CiEnContextDTO conetxtDTO = new CiEnContextDTO();
		//conetxtDTO.setEnt4BannerDTO(getEnt4BannerDTO(pat));
		conetxtDTO.setId_grp(Context.get().getGroupId()); // 所属集团
		conetxtDTO.setId_org(Context.get().getOrgId()); // 属组织
		conetxtDTO.setId_dep_or(Context.get().getDeptId()); // 开立科室
		//conetxtDTO.setId_dep_or(pat.getId_dep_phy());
		conetxtDTO.setId_emp_or(pat.getId_emp_phy()); // 开立医生

		conetxtDTO.setId_entp(pat.getId_entp()); // 就诊类型id
		conetxtDTO.setCode_entp(pat.getCode_entp()); // 就诊类型编码
		conetxtDTO.setId_pat(pat.getId_pat()); // 患者
		conetxtDTO.setId_en(pat.getId_ent()); // 就诊
		conetxtDTO.setId_hp(pat.getId_hp()); // 主医保数据
		conetxtDTO.setId_dep_en(pat.getId_dep_phy()); // 当前就诊科室
		conetxtDTO.setId_dep_ns(pat.getId_dep_nur()); // 当前就诊病区
		conetxtDTO.setId_pripat(pat.getId_pripat());
		return conetxtDTO;
	}
	public Ent4BannerDTO getEnt4BannerDTO(PatiVisitDO pat){
		Ent4BannerDTO entbanner = new Ent4BannerDTO();
		entbanner.setId_pripat(pat.getId_pripat());
		entbanner.setId_pat(pat.getId_pat());
		entbanner.setCode_entp(pat.getCode_entp());
		entbanner.setSd_hptp(pat.getCode_hp());
		return entbanner;
	}
}
