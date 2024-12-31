package iih.bd.mhi.hpfeeca.s.bp.adapt;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.dto.d.HPFeeCaCompDTO;
import iih.bd.mhi.hpfeeca.d.HpFeecaDO;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;

/**
 * 适配器
 * 
 * @author dj.zhang
 *
 */
public class HpFeecaCompDOAdapter {

	public HpFeecaDO getFeecaCompDO(String hpId, HPFeeCaCompDTO compDTO) {
		HpFeecaDO hpFeecaDO = new HpFeecaDO();
		hpFeecaDO.setId_hpfeeca(compDTO.getId_hpfeeca());
		hpFeecaDO.setId_hp(hpId);
		hpFeecaDO.setCode(compDTO.getCode_hp());
		hpFeecaDO.setName(compDTO.getName_hp());
		if (StringUtils.isNotBlank(compDTO.getSv())) {
			hpFeecaDO.setSv(new FDateTime(compDTO.getSv()));
		}
		hpFeecaDO.setId_par(compDTO.getId_par());
		hpFeecaDO.setId_incca(compDTO.getId_incca());
		hpFeecaDO.setId_inccaitm(compDTO.getId_inccaitm());
		hpFeecaDO.setCode_inccaitm(compDTO.getCode_inccaitm());
		hpFeecaDO.setId_grp(Context.get().getGroupId());
		hpFeecaDO.setId_org(Context.get().getOrgId());
		if (StringUtils.isNotBlank(compDTO.getCreatedby())) {
			hpFeecaDO.setCreatedby(compDTO.getCreatedby());
		}
		if (StringUtils.isNotBlank(compDTO.getCreatedtime())) {
			hpFeecaDO.setCreatedtime(new FDateTime(compDTO.getCreatedtime()));
		}
		return hpFeecaDO;
	}

}
