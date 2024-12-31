package iih.mi.mibd.drugdircomp.s.bp.adapter;

import iih.mi.mibd.drugdircomp.d.DrugDirCompDTO;
import iih.mi.mibd.drugdircomp.d.DrugdircompDO;
import xap.mw.core.data.Context;

/**
 * 
 * 适配器
 * @author hexx
 * 
 */
public class DrugdircompDOAdapter {

	public DrugdircompDO getDrugdircompDO(String misId, DrugDirCompDTO compDTO) {
		DrugdircompDO drugdircompDO = new DrugdircompDO();
		drugdircompDO.setId_comp_drug(compDTO.getId_drugcomp());
		drugdircompDO.setId_grp(Context.get().getGroupId());
		drugdircompDO.setId_org(Context.get().getOrgId());
		drugdircompDO.setId_mis(misId);
		drugdircompDO.setId_drug(compDTO.getId_drug());
		drugdircompDO.setCode(compDTO.getCode());
		drugdircompDO.setDt_approved(compDTO.getDt_approved());
		drugdircompDO.setCreatedby(compDTO.getCreatedby());
		drugdircompDO.setCreatedtime(compDTO.getCreatedtime());
		drugdircompDO.setModifiedby(compDTO.getModifiedby());
		drugdircompDO.setModifiedtime(compDTO.getModifiedtime());
		drugdircompDO.setSv(compDTO.getSv());
		return drugdircompDO;
	}
}
