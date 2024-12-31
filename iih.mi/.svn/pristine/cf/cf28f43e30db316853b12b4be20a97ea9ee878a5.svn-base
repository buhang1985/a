package iih.mi.mibd.srvfacdircomp.s.bp.adapter;

import iih.mi.mibd.srvfacdircomp.d.SrvFacDirCompDO;
import iih.mi.mibd.srvfacdircomp.d.SrvfacDirCompDTO;
import xap.mw.core.data.Context;

/** 
* @author hexx 
* @version 创建时间：2018年2月6日 下午4:13:47 
* 适配器
*/
public class SrvfacdircompDOAdapter {

	public SrvFacDirCompDO getSrvfacdircompDO(String misId, SrvfacDirCompDTO compDTO) {
		SrvFacDirCompDO  SrvFacDirCompDO= new SrvFacDirCompDO();
		SrvFacDirCompDO.setId_comp_srvfac(compDTO.getId_srvfaccomp());
		SrvFacDirCompDO.setId_grp(Context.get().getGroupId());
		SrvFacDirCompDO.setId_org(Context.get().getOrgId());
		SrvFacDirCompDO.setId_mis(misId);
		SrvFacDirCompDO.setId_srv(compDTO.getId_srv());
		SrvFacDirCompDO.setCode(compDTO.getCode());
		SrvFacDirCompDO.setDt_approved(compDTO.getDt_approved());
		SrvFacDirCompDO.setCreatedby(compDTO.getCreateby());
		SrvFacDirCompDO.setCreatedtime(compDTO.getCreatedtime());
		SrvFacDirCompDO.setModifiedby(compDTO.getModifiedby());
		SrvFacDirCompDO.setModifiedtime(compDTO.getModifiedtime());
		SrvFacDirCompDO.setSv(compDTO.getSv());
		return SrvFacDirCompDO;
	}
}
