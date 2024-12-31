package iih.ci.mr.cimrcontentdto.s.bp;

import iih.ci.mr.cimrcontentdto.d.CiMrContentDTO;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mrqc.cimrrecallentdto.d.CiMrRecallEntDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;

public class CiMrContentQryBp extends PagingServiceImpl<CiMrContentDTO> {
	
	public  PagingRtnData<CiMrContentDTO> getMrContentByPageInfo(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlWhere = " where 1=1 ";
		if(qryRootNodeDTO!=null)
		{
			sqlWhere += "and " +service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" MR.ID_MR ,");
		sb.append(" MR.ID_ENT ,");
		sb.append(" MR.CREATEDTIME createtime,");
		sb.append(" ORG.NAME AS name_org,");
		sb.append(" ENT.CODE AS code_ent,");
		sb.append("  entip.CODE_AMR_IP,");
		sb.append(" entip.times_ip as N_TIMES_INHOSPITAL,");
		sb.append(" ent.code_entp,");
		sb.append(" ent.ID_PAT ,");
		sb.append(" pipat.code code_pat,");
		sb.append(" MR.DT_RD ,");
		sb.append(" MR.NAME AS name_mr,");
		sb.append(" MR.ID_ORG,");
		sb.append(" ORG.BIZORGCODE,");
		sb.append(" ent.NAME_PAT,");
		sb.append(" MRTP.NAME AS name_mrtp,");
		sb.append(" MRTP.ID_MRTP,");
		sb.append(" MRTP.CODE AS sd_mrtp,");
		sb.append(" MR.DS,");
		sb.append(" MR.SD_SU_MR,");
		sb.append(" MR.CREATEDBY,");
		sb.append(" MR.DATE_SUBMIT,");
		sb.append(" MR.ID_EMP_SUBMIT as id_submit_emp,");
		sb.append(" MR.id_dep");
		sb.append(" FROM");
		sb.append(" CI_MR MR");
		sb.append(" LEFT JOIN CI_MR_FP_PAT PAT ON MR.ID_ENT = PAT.ID_ENT");
		sb.append(" LEFT JOIN CI_MR_FP_OTHER OTH ON MR.ID_ENT = OTH.ID_ENT"); 	    
	    sb.append(" inner join en_ent_ip entip on mr.id_ent = entip.id_ent");
		sb.append(" INNER JOIN BD_DI_DEF DIDEF ON OTH.id_dipathology = DIDEF.id_didef");
		sb.append(" INNER JOIN BD_MRTP MRTP ON MR.ID_MRTP = MRTP.ID_MRTP");
		sb.append(" INNER JOIN BD_ORG ORG ON MR.ID_ORG = ORG.id_org");
		sb.append(" INNER JOIN EN_ENT ENT ON MR.ID_ENT = ENT.ID_ENT");
	    sb.append(" inner join pi_pat pipat on ent.id_pat = pipat.id_pat");
		sb.append(sqlWhere);
		sb.append(" order by mr.id_ent asc,mr.sv asc");
		PagingRtnData<CiMrContentDTO> pagingRtnData = super.findByPageInfo(new CiMrContentDTO(), paginationInfo, sb.toString(), "", null);
		ICiMrOutQryServices mrQrySrv = ServiceFinder.find(ICiMrOutQryServices.class);
		if(pagingRtnData!=null&&pagingRtnData.getPageData().size()>0)
		{
			for(Object obj :pagingRtnData.getPageData())
			{
				CiMrContentDTO mrc = (CiMrContentDTO)obj;
				if(mrc!=null)
					mrc.setContent(mrQrySrv.getCimrArea(mrc.getId_mr()));
			}
		}
		return pagingRtnData;
	}
}
