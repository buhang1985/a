package iih.ci.mrm.s.mrmcatapatlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.operateprocess.d.OperateProcessDO;
import iih.bd.srv.operateprocess.i.IOperateprocessRService;
import iih.bd.srv.operatetype.d.OperateTypeDO;
import iih.bd.srv.operatetype.i.IOperatetypeRService;
import iih.ci.mrm.i.mrmcatapatlist.IMrmCataPatListService;
import iih.ci.mrm.mrmcatapatlistdto.d.MrmCataPatListDTO;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.ci.mrqc.revisionnotice.i.IRevisionnoticeRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class MrmCataPatListServiceImpl extends PagingServiceImpl<MrmCataPatListDTO> implements IMrmCataPatListService {

	@Override
	public PagingRtnData<MrmCataPatListDTO> getCiMrFpPatData(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,
			String orgparam) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sql = "";		
		if("2".equals(orgparam)){	
			String sqlwhere = " where EN_ENT.CODE_ENTP = '"+IEnDictCodeConst.SD_ENTP_INPATIENT+"' ";//住院患者	
			if (qryRootNodeDTO!=null){
	 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
	 		}				
			sqlwhere +=" and EEI.SD_STATUS = '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT+"'";//出院患者			
			sql = getCiMrFpPatData4CataQryByEn(sqlwhere);
		}
		
		if("1".equals(orgparam)){
			sql = getSignOffSql(qryRootNodeDTO);	
		}
		PagingRtnData<MrmCataPatListDTO> pagingRtnData = super.findByPageInfo(new MrmCataPatListDTO(), paginationInfo, sql, "EN_ENT.DT_END desc", null);
		return pagingRtnData;	
	}

	@Override
	public MrmCataPatListDTO[] getAllPageData(QryRootNodeDTO qryRootNodeDTO, String orgparam) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sql = "";
					
		if("2".equals(orgparam)){	
			String sqlwhere = " where EN_ENT.CODE_ENTP = '"+IEnDictCodeConst.SD_ENTP_INPATIENT+"' ";//住院患者	
			if (qryRootNodeDTO!=null){
	 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
	 		}				
			sqlwhere +=" and EEI.SD_STATUS = '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT+"'";//出院患者			
			sql = getCiMrFpPatData4CataQryByEn(sqlwhere);
		}
		
		if("1".equals(orgparam)){
			sql = getSignOffSql(qryRootNodeDTO);	
		}
		
		sql = sql+"  order by EN_ENT.DT_END desc  ";
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<MrmCataPatListDTO> listDto = (List<MrmCataPatListDTO>) daf.execQuery(sql,
				new BeanListHandler(MrmCataPatListDTO.class));
		return listDto.toArray(new MrmCataPatListDTO[0]);
	}
	
	/**
	 * 根据就诊信息查询
	 * @param sqlWhere
	 * @return
	 * @throws BizException
	 */
	public String getCiMrFpPatData4CataQryByEn(String sqlWhere) throws BizException
	{		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append(" EN_ENT.NAME_PAT,");

		sql.append(" udi_sex.NAME name_sex,");
		sql.append(" BD_DEP.NAME name_dep_phydisc,");
		sql.append(" EN_ENT.DT_END,");
		sql.append(" EN_ENT.ID_ENT,");
		sql.append(" EN_ENT.dt_acpt,");
		sql.append(" EN_ENT.ID_PAT,");
		sql.append(" EN_ENT.ID_HP,");
		sql.append(" EEI.CODE_AMR_IP,");
		sql.append(" EEI.TIMES_IP n_times_inhospital,");
		//sql.append(" CI_AMR.DT_CATALOGUE dt_create,");
		sql.append(" FP_CATA.createdtime as dt_create,");
		sql.append(" FP_CATA.fg_cata as fg_complete_cata,");
		sql.append(" bd_psndoc.name name_user_catalogue,");
		sql.append(" bd_psndoc.name name_author,");
		sql.append(" FP_CATA.dt_create as dt_catalogue,");
		sql.append(" bd_dep2.name as out_id_bed, ");
		sql.append(" c.id_cimrfppat as fg_cimrfp ");
		sql.append(" FROM");
		sql.append(" EN_ENT");
		sql.append(" LEFT JOIN CI_AMR ON EN_ENT.ID_ENT = CI_AMR.ID_ENT");
		sql.append(" LEFT JOIN EN_ENT_IP EEI ON EN_ENT.ID_ENT = EEI.ID_ENT");
		sql.append(" LEFT JOIN BD_UDIDOC udi_sex ON EN_ENT.ID_SEX_PAT = udi_sex.ID_UDIDOC");
		sql.append(" LEFT JOIN BD_DEP ON EEI.ID_DEP_PHYDISC = BD_DEP.ID_DEP");
		sql.append(" left join bd_dep bd_dep2 on eei.id_dep_nurdisc = bd_dep2.id_dep ");
		sql.append(" LEFT JOIN ci_mr_fp_pat c ");
		sql.append(" on c.id_ent= EN_ENT.id_ent ");
		sql.append(" LEFT JOIN ci_mr_fp_cata FP_CATA ");
		sql.append(" on FP_CATA.id_ent= EN_ENT.id_ent ");
		sql.append(" LEFT JOIN bd_psndoc on FP_CATA.id_author = bd_psndoc.id_psndoc");
		sql.append(sqlWhere);		
		return sql.toString();
	}
	
	/**
	 * 病案签收查询sql
	 */
	public String getSignOffSql(QryRootNodeDTO qryRootNodeDTO) throws BizException{
		//取操作类型表数据
		IOperatetypeRService opTypeService =ServiceFinder.find(IOperatetypeRService.class);
		OperateTypeDO[] opTpyedoArr=opTypeService.find(" code='02' ", "", FBoolean.FALSE);
		if (opTpyedoArr==null||opTpyedoArr.length<=0) {			
			throw new BizException("请维护基础数据中【医疗服务-病案管理-操作类型维护】");
		}
		OperateTypeDO opTypeDo=opTpyedoArr[0];
		//取操作流程表数据
		IOperateprocessRService opProcessService =ServiceFinder.find(IOperateprocessRService.class);
		OperateProcessDO[] opProcessdoArr=opProcessService.find(" id_bd_mrm_ot_cu='"+opTypeDo.getId_bd_mrm_ot()+"'", "", FBoolean.FALSE);
		if (opProcessdoArr==null||opProcessdoArr.length<=0) {			
			throw new BizException("请维护基础数据中【医疗服务-病案管理-操作流程维护】");
		}
		OperateProcessDO opProcessDo=opProcessdoArr[0];
		
		//定义查询方案解析服务
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlStr="";
		//String specWhere =getSpecialIdEnt();		
		//取后退流程的操作类型数据
		OperateTypeDO opForwardTpyedo=opTypeService.findById(opProcessDo.getId_bd_mrm_ot_bo());
		if (opForwardTpyedo==null) {
			throw new BizException("请维护基础数据中【医疗服务-病案管理-操作类型维护】");
		}
		
		String sqlwhere = " where ci_amr.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"' and  ci_amr.id_bd_mrm_ot='"+opForwardTpyedo.getId_bd_mrm_ot()+"'";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		//sqlwhere+= specWhere;
 		sqlwhere+= " and (ci_amr.sd_qa_doctor_part_sta= '07' or ci_amr.sd_qa_doctor_part_sta = '"+ICiMrDictCodeConst.SD_MR_COMDEPTQC+"')";
 		StringBuilder sql = getMrmQrySql(sqlwhere,opForwardTpyedo.getId_bd_mrm_ot());//操作类型主键
 		sqlStr=sql.toString();		
			
		return sqlStr;
	}
	
//	/**
//	 * 获取特殊的限制的id_ent;
//	 * 郑州要求（现在版本）：只有没有问题的病案可以签收
//	 * @return 
//	 * @throws BizException 
//	 */
//	private String getSpecialIdEnt() throws BizException
//	{
//		String speWhere ="";
//		IRevisionnoticeRService ser = ServiceFinder.find(IRevisionnoticeRService.class);
//		if(ser!=null)
//		{
//			String sqlWhere ="sd_status <>'"+ICiMrDictCodeConst.SD_AUDIT+"'"; 
//			RevisionNoticeDO[] arrNotice = ser.find(sqlWhere, "", FBoolean.FALSE);
//			Set<String> s=new HashSet<String>();
//			for(RevisionNoticeDO notice :arrNotice)
//			{
//				if(notice.getId_ent()!=null){
//					s.add(notice.getId_ent());
//				}
//
//			}
//			if(arrNotice!=null&&arrNotice.length>0)
//			{
//				speWhere =" and ci_amr.id_ent not in(";
//				for(String ss:s)
//				{
//						speWhere += "'"+ss+"',";
//					
//				}
//				//排除所有审核未通过的id_ent
//				speWhere = speWhere.substring(0, speWhere.length()-1)+")";
//			}
//		}
//		return speWhere;
//	}
	
	private StringBuilder getMrmQrySql(String sqlWhere,String id_bd_mrm_ot){
		 StringBuilder sql = new StringBuilder();
		 sql.append(" SELECT ");
		 //sql.append("       ci_amr.dt_catalogue   dt_create, ");
		 sql.append("       cata.createdtime as dt_create, ");
		 sql.append("       cata.dt_create   dt_catalogue, ");
		 sql.append("       en_ent.NAME_PAT, ");
		 sql.append("       en_ent.DT_END, ");
		 sql.append("       en_ent.ID_ENT, ");
		 sql.append("       en_ent.ID_PAT, ");
		 sql.append("       en_ent.ID_HP,        ");
		 sql.append("        (CASE WHEN en_ent.sd_sex_pat= '0' ");
		 sql.append("          THEN  '未知的性别' ");
		 sql.append("        WHEN en_ent.sd_sex_pat= '1' ");
		 sql.append("          THEN  '男' ");
		 sql.append("        WHEN en_ent.sd_sex_pat= '2' ");
		 sql.append("          THEN  '女' ");
		 sql.append("        WHEN en_ent.sd_sex_pat= '9' ");
		 sql.append("          THEN  '未说明性别' ");
		 sql.append("       end) as name_sex,   ");
		 sql.append("       eei.CODE_AMR_IP, ");
		 sql.append("       eei.TIMES_IP as n_times_inhospital, ");
		 sql.append("       bd2.name as name_dep_phydisc, ");   // 出院科室 
		 sql.append("       cata.fg_cata, ");
		// sql.append("       cata.dt_create as dt_catalogue, ");
		 sql.append("  en_ent.dt_acpt,  ");
		 sql.append(" bd_psndoc.name name_user_catalogue,");
		 sql.append(" bd_psndoc.name name_author,");
		 sql.append("       pat.id_cimrfppat        as fg_cimrfp ");
		 sql.append("       FROM ci_amr ci_amr ");
		 sql.append("       LEFT JOIN en_ent en_ent ");
		 sql.append("       ON ci_amr.id_ent = en_ent.id_ent ");
		 sql.append("       AND en_ent.id_ent not in(select cqrn.id_ent from ci_qa_revision_notice cqrn where cqrn.id_ent=en_ent.id_ent and cqrn.sd_status<>'"+ICiMrDictCodeConst.SD_AUDIT+"') "); //注释上方getSpecialIdEnt方法	,修改SQL	 
		 sql.append("       LEFT JOIN en_ent_ip eei ");
		 sql.append("       ON ci_amr.id_ent = eei.id_ent ");
		 sql.append("       LEFT JOIN bd_dep bd2 ");
		 sql.append("       ON eei.id_dep_phydisc = bd2.id_dep ");
		 sql.append("       LEFT JOIN ci_mrm_op ci_mrm_op ");
		 sql.append("       ON ci_amr.id_enhr = ci_mrm_op.id_amr ");
		 sql.append("       AND ci_mrm_op.id_bd_mrm_ot = '"+id_bd_mrm_ot+"' ");
		 sql.append("       LEFT JOIN bd_mrm_ot bd_mrm_ot ");
		 sql.append("       ON ci_amr.id_bd_mrm_ot = bd_mrm_ot.id_bd_mrm_ot ");
		 sql.append("       LEFT JOIN ci_mr_fp_pat pat ");
		 sql.append("       on pat.id_ent = en_ent.id_ent ");
		 sql.append("       LEFT JOIN ci_mr_fp_cata cata ");
		 sql.append("       on cata.id_ent = en_ent.id_ent ");
		 sql.append(" LEFT JOIN bd_psndoc on cata.id_author = bd_psndoc.id_psndoc");
		 sql.append(sqlWhere);
		 return sql;		
	}
}
