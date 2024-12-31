package iih.ci.mrm.cimrmdirheareportdto.s.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import iih.ci.mrm.bp.common.CiMrMParamUtils;
import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ArrayListHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;

public class CiMrmGenerateListBp {

	private String Name_src= "ci_mr_fp_pat"; 
	/**
	 * 通过前台传过来的条件，进行分页查询
	 * 分页需要页数和每页条数
	 */
	public PagingRtnData<CiMrmDirHeaReportDTO> getReportList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		int result = CiMrMParamUtils.GetSysParamCIMRFP_REPORT_DATA_SRC(Context.get().getOrgId());
		switch(result)
		{		
		case 2://编目获取
			
			Name_src= "ci_mr_fp_pat_cata";
			break;
		default://首页和编目（编目优先）、首页
			Name_src= "ci_mr_fp_pat";
			break;
		}
		CiMrmGenerateCSVBp cimrm = new CiMrmGenerateCSVBp();
		PagingRtnData<CiMrmDirHeaReportDTO> paging = new PagingRtnData<CiMrmDirHeaReportDTO>();
		//获取分页grid数据、赋值		
		String sqlWhere =  service.getQueryStringWithoutDesc(qryRootNodeDTO);
		int pageCount = getDataCount(sqlWhere,Name_src);
		//设置页数
		paginationInfo.setPageCount(getPageCount(pageCount,paginationInfo.getPageSize()));
		//查询数据
		String sql = getCiMrFpPatData4CataQryByEn(sqlWhere,paginationInfo.getPageSize(),paginationInfo.getPageIndex(),Name_src);
		 DAFacade da = new DAFacade();
		 List<PatiVisitDO> lstMrFpPat = (List<PatiVisitDO>)da.execQuery(sql,
					new BeanListHandler(PatiVisitDO.class));
		String[] arrIdEnt = getIdEntFromBlCgIp(lstMrFpPat);		
		List<CiMrmDirHeaReportDTO> lstRepDTO = cimrm.getMrmDirHeaReportDTOList(arrIdEnt);
		FArrayList flist = new FArrayList();
		if(lstRepDTO!=null&&lstRepDTO.size()>0)
		{
			for(CiMrmDirHeaReportDTO rep :lstRepDTO)
			{
				flist.add(rep);
			}
		}
		
		paging.setPageData(flist);
		paging.setPagingInfo(paginationInfo);
		return paging;
	}

	/**
	 * 获取就诊数据
	 * @param sqlWhere
	 * @return
	 * @throws BizException 
	 */
	public  String[] getIdEntFromBlCgIp(List<PatiVisitDO> vists) throws BizException
	{
		
		if(vists!=null)
		{
			
			String[] arrIdEnts = new String[vists.size()];
			for(int i=0;i<vists.size();i++)
			{
				arrIdEnts[i] = vists.get(i).getId_ent();
			}
			return arrIdEnts;
		}
		else
			return new String[]{};
		
	}
	
	/**
	 * 根据就诊信息查询
	 * @param sqlWhere
	 * @return
	 * @throws BizException
	 */
	public String getCiMrFpPatData4CataQryByEn(String sqlWhere,int sizePage,int pageIdx,String Name_src) throws BizException
	{		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM (SELECT");
		sql.append(" EN_ENT.ID_ENT,rownum rn");
		sql.append(" FROM "+Name_src+" PAT ");
		sql.append("  LEFT JOIN EN_ENT ON EN_ENT.Id_Ent = PAT.Id_Ent "); 
		sql.append(" LEFT JOIN EN_ENT_IP ON EN_ENT.ID_ENT = EN_ENT_IP.ID_ENT");
		sql.append(" LEFT JOIN BD_DEP ON EN_ENT_IP.ID_DEP_PHYDISC = BD_DEP.ID_DEP");
		sql.append(" where EN_ENT.CODE_ENTP = '"+IEnDictCodeConst.SD_ENTP_INPATIENT+"' ");//住院患者	
		sql.append(" and EN_ENT_IP.SD_STATUS = '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT+"'");//出院患者
		if(sqlWhere !=null)
		{
			sql.append(" and "+sqlWhere);		
			
		}
		sql.append(" )where rn<"+(sizePage*(pageIdx+1)+1));
		sql.append(" and rn>"+sizePage*(pageIdx));		
		return sql.toString();
	}
	/**
	 * 获取分页时总分页
	 * @param TotalCount
	 * @param size
	 * @return
	 */
	private int getPageCount(int TotalCount ,int size)
	{
		int pageCount = 1;
		if(size <= 0)//分页不合理，改完20
		{
			size = 1;
		}
		if(TotalCount>size)
		{
			pageCount = TotalCount/size +(TotalCount%size==0?0:1);
		}
		return pageCount;
	}
	
	/**
	 * 获取分页时总数据
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private int getDataCount(String sqlWhere,String Name_src) throws BizException
	{
		int pageCount =-1;
		IBlstipRService Iblcgquery = ServiceFinder.find(IBlstipRService.class);
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		StringBuilder sql = new StringBuilder();
		String countName ="count";
		sql.append(" SELECT");
		sql.append(" count(1) "+countName);
		sql.append(" FROM "+Name_src+" PAT ");
		sql.append("  LEFT JOIN EN_ENT ON EN_ENT.Id_Ent = PAT.Id_Ent "); 
		sql.append(" LEFT JOIN CI_AMR ON EN_ENT.ID_ENT = CI_AMR.ID_ENT");
		sql.append(" LEFT JOIN EN_ENT_IP ON EN_ENT.ID_ENT = EN_ENT_IP.ID_ENT");
		sql.append(" LEFT JOIN BD_DEP ON EN_ENT_IP.ID_DEP_PHYDISC = BD_DEP.ID_DEP");
		sql.append(" where EN_ENT.CODE_ENTP = '"+IEnDictCodeConst.SD_ENTP_INPATIENT+"' ");
		sql.append(" and EN_ENT_IP.SD_STATUS = '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT+"' and ");
		sql.append(sqlWhere);	
		DAFacade da = new DAFacade();
		ArrayList<Map<String,Object>> lstBlStIpDO =  (ArrayList<Map<String,Object>>)da.execQuery(sql.toString(), new MapListHandler());
		pageCount = (int)lstBlStIpDO.get(0).get(countName);
		return pageCount;
		
	}

	
}
