package iih.mi.mibd.treatdircomp.s.bp.adapter;

import iih.mi.mibd.treatdircomp.d.TreatDirCompDTO;
import iih.mi.mibd.treatdircomp.d.TreatdircompDO;
import xap.mw.core.data.Context;

/**
 * @ClassName: TreatdircompDOAdapter
 * @Description: 适配器
 * @author: dj.zhang
 * @date: 2018年2月1日 下午8:13:32
 */
public class TreatdircompDOAdapter {

	public TreatdircompDO getTreatdircompDO(String misId, TreatDirCompDTO compDTO) {

		TreatdircompDO treatdircompDO = new TreatdircompDO();
		treatdircompDO.setId_comp_treat(compDTO.getId_treatcomp());
		treatdircompDO.setId_grp(Context.get().getGroupId());
		treatdircompDO.setId_org(Context.get().getOrgId());
		treatdircompDO.setId_mis(misId);
		treatdircompDO.setId_treat(compDTO.getId_treat());
		treatdircompDO.setCode(compDTO.getCode());
		treatdircompDO.setDt_approved(compDTO.getDt_approved());
		treatdircompDO.setCreatedby(compDTO.getCreatedby());
		treatdircompDO.setCreatedtime(compDTO.getCreatedtime());
		treatdircompDO.setModifiedby(compDTO.getModifiedby());
		treatdircompDO.setModifiedtime(compDTO.getModifiedtime());
		treatdircompDO.setSv(compDTO.getSv());

		return treatdircompDO;
	}
}
