package iih.mi.mibd.didircomp.s.bp.adapter;

import iih.mi.mibd.didircomp.d.DiDirCompDTO;
import iih.mi.mibd.didircomp.d.DidircompDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;

public class DidircompDoAdapter {

	public DidircompDO getDidircompDO(String misId, DiDirCompDTO diDirCompDTO) throws BizException {

		DidircompDO didircompDO = new DidircompDO();
		didircompDO.setId_comp_di(diDirCompDTO.getId_dicomp());
		didircompDO.setId_grp(Context.get().getGroupId());
		didircompDO.setId_org(Context.get().getOrgId());
		didircompDO.setId_mis(misId);
		didircompDO.setId_di(diDirCompDTO.getId_di());
		didircompDO.setCode(diDirCompDTO.getCode());
		didircompDO.setDt_approved(diDirCompDTO.getDt_approved());
		didircompDO.setCreatedby(diDirCompDTO.getCreatedby());
		didircompDO.setCreatedtime(diDirCompDTO.getCreatedtime());
		didircompDO.setModifiedby(diDirCompDTO.getModifiedby());
		didircompDO.setModifiedtime(diDirCompDTO.getModifiedtime());
		didircompDO.setSv(diDirCompDTO.getSv());

		return didircompDO;
	}

}
