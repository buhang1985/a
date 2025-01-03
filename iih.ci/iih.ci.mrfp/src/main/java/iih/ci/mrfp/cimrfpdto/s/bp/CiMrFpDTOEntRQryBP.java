package iih.ci.mrfp.cimrfpdto.s.bp;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.operateprocess.d.OperateProcessDO;
import iih.bd.srv.operateprocess.i.IOperateprocessRService;
import iih.bd.srv.operatetype.d.OperateTypeDO;
import iih.bd.srv.operatetype.i.IOperatetypeRService;
import iih.bl.hp.hpentcode.d.HpEntCodeDO;
import iih.bl.hp.hpentcode.i.IHpentcodeCudService;
import iih.bl.hp.hpentcode.i.IHpentcodeRService;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.ci.mrqc.revisionnotice.i.IRevisionnoticeRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class CiMrFpDTOEntRQryBP  extends PagingServiceImpl<CiMrFpDTO> {

	/**
	 * 编目查询
	 * @throws BizException 
	 */
	public PagingRtnData<CiMrFpDTO> getCiMrFpPatData4CataQry(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,String param) throws BizException
	{
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sql = "";
					
		if("2".equals(param)){	
			String sqlwhere = " where EN_ENT.CODE_ENTP = '"+IEnDictCodeConst.SD_ENTP_INPATIENT+"' ";//住院患者	
			if (qryRootNodeDTO!=null){
	 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
	 		}				
			sqlwhere +=" and EN_ENT_IP.SD_STATUS = '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT+"'";//出院患者			
			sql = getCiMrFpPatData4CataQryByEn(sqlwhere);
		}
		
		if("1".equals(param)){
			sql = getSignOffSql(qryRootNodeDTO);	
		}
		
		PagingRtnData<CiMrFpDTO> pagingRtnData = super.findByPageInfo(new CiMrFpDTO(), paginationInfo, sql, "EN_ENT.DT_END desc", null);
		return pagingRtnData;	
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
		sql.append(" EN_ENT.DT_ACPT,");
		sql.append(" EN_ENT.ID_PAT,");
		sql.append(" EN_ENT.ID_HP,");
		sql.append(" EN_ENT_IP.CODE_AMR_IP,");
		sql.append(" EN_ENT_IP.TIMES_IP n_times_inhospital,");
		sql.append(" CI_AMR.DT_CATALOGUE dt_create,");
		sql.append(" FP_CATA.fg_cata,");
		sql.append(" bd_psndoc.name name_user_catalogue,");
		sql.append(" bd_psndoc.name name_author,");
		sql.append(" FP_CATA.dt_create as dt_catalogue,");
		sql.append(" c.id_cimrfppat as fg_cimrfp ");
		sql.append(" FROM");
		sql.append(" EN_ENT");
		sql.append(" LEFT JOIN CI_AMR ON EN_ENT.ID_ENT = CI_AMR.ID_ENT");
		sql.append(" LEFT JOIN EN_ENT_IP ON EN_ENT.ID_ENT = EN_ENT_IP.ID_ENT");
		sql.append(" LEFT JOIN BD_UDIDOC udi_sex ON EN_ENT.ID_SEX_PAT = udi_sex.ID_UDIDOC");
		sql.append(" LEFT JOIN BD_DEP ON EN_ENT_IP.ID_DEP_PHYDISC = BD_DEP.ID_DEP");
		sql.append(" LEFT JOIN ci_mr_fp_pat c ");
		sql.append(" on c.id_ent= EN_ENT.id_ent ");
		sql.append(" LEFT JOIN ci_mr_fp_cata FP_CATA ");
		sql.append(" on FP_CATA.id_ent= EN_ENT.id_ent ");
		sql.append(" LEFT JOIN bd_psndoc on FP_CATA.id_author = bd_psndoc.id_psndoc");
		sql.append(sqlWhere);		
		return sql.toString();
	}

	
	/**
	 * 医保上报查询
	 * @throws BizException 
	 */
	public PagingRtnData<CiMrFpDTO> getCiMrFpPatDataUpload(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException
	{
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = " where EN_ENT.CODE_ENTP = '"+IEnDictCodeConst.SD_ENTP_INPATIENT+"' ";//住院患者	
		sqlwhere +=" and EN_ENT_IP.SD_STATUS = '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT+"'";//出院患者
		sqlwhere +=" and EN_ENT.ID_HP in (SELECT ID_HP FROM BD_HP) ";//有医保患者
		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
		String sql = "";
		sql = getCiMrFpPatData4CataQryByEn(sqlwhere);
		PagingRtnData<CiMrFpDTO> pagingRtnData = super.findByPageInfo(new CiMrFpDTO(), paginationInfo, sql, "EN_ENT.DT_END desc", null);
		return pagingRtnData;
	}
	
	public CiMrFpDTO[] getCiMrFpDtos() throws BizException
	{		
		DAFacade da = new DAFacade();
		String sqlwhere = " where EN_ENT.CODE_ENTP = '"+IEnDictCodeConst.SD_ENTP_INPATIENT+"' ";//住院患者	
		sqlwhere +=" and EN_ENT_IP.SD_STATUS = '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT+"'";//出院患者
		sqlwhere +=" and EN_ENT.ID_HP in (SELECT ID_HP FROM BD_HP) ";//有医保患者
		String sql = "";
		sql = getCiMrFpPatData4CataQryByEn(sqlwhere);
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpDTO> list = (ArrayList<CiMrFpDTO>) da.execQuery(sql.toString(),	new BeanListHandler(CiMrFpDTO.class));
		return list.toArray(new CiMrFpDTO[list.size()]);	
	}
	
	
	/**
	 * 获取特殊的限制的id_ent;
	 * 郑州要求（现在版本）：只有没有问题的病案可以签收
	 * @return 
	 * @throws BizException 
	 */
	private String getSpecialIdEnt() throws BizException
	{
		String speWhere ="";
		IRevisionnoticeRService ser = ServiceFinder.find(IRevisionnoticeRService.class);
		if(ser!=null)
		{
			String sqlWhere ="sd_status <>'"+ICiMrDictCodeConst.SD_AUDIT+"'"; 
			RevisionNoticeDO[] arrNotice = ser.find(sqlWhere, "", FBoolean.FALSE);
			if(arrNotice!=null&&arrNotice.length>0)
			{
				speWhere =" and ci_amr.id_ent not in(";
				for(RevisionNoticeDO notice :arrNotice)
				{
					speWhere += "'"+notice.getId_ent()+"',";
				}
				//排除所有审核未通过的id_ent
				speWhere = speWhere.substring(0, speWhere.length()-1)+")";
			}
		}
		return speWhere;
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
		String specWhere =getSpecialIdEnt();		
		//取后退流程的操作类型数据
		OperateTypeDO opForwardTpyedo=opTypeService.findById(opProcessDo.getId_bd_mrm_ot_bo());
		if (opForwardTpyedo==null) {
			throw new BizException("请维护基础数据中【医疗服务-病案管理-操作类型维护】");
		}
		
		String sqlwhere = " where ci_amr.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"' and  ci_amr.id_bd_mrm_ot='"+opForwardTpyedo.getId_bd_mrm_ot()+"'";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		sqlwhere+= specWhere;
 		sqlwhere+= " and ci_amr.sd_qa_doctor_part_sta= '07'";
 		StringBuilder sql = getMrmQrySql(sqlwhere,opForwardTpyedo.getId_bd_mrm_ot());//操作类型主键
 		sqlStr=sql.toString();		
			
		return sqlStr;
	}
	
	private StringBuilder getMrmQrySql(String sqlWhere,String id_bd_mrm_ot){
 		 StringBuilder sql = new StringBuilder();
		 sql.append("  SELECT   ");
		 sql.append("       ci_amr.dt_catalogue   dt_create, ");
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
		 sql.append("       EN_ENT_IP.CODE_AMR_IP, ");
		 sql.append("       EN_ENT_IP.TIMES_IP    n_times_inhospital, ");
		 sql.append("       bd2.name as name_dep_phydisc,  ");   // 出院科室 
		 sql.append("       cata.fg_cata,   ");
		 sql.append("  en_ent.dt_acpt,  ");
		 sql.append(" bd_psndoc.name name_user_catalogue,");
		 sql.append(" bd_psndoc.name name_author,");
		 sql.append("       pat.id_cimrfppat        as fg_cimrfp ");
		 sql.append("       FROM ci_amr ci_amr ");
		 sql.append("       LEFT JOIN en_ent en_ent ");
		 sql.append("       ON ci_amr.id_ent = en_ent.id_ent ");
		 sql.append("       LEFT JOIN en_ent_ip EN_ENT_IP ");
		 sql.append("       ON ci_amr.id_ent = EN_ENT_IP.id_ent ");
		 sql.append("       LEFT JOIN bd_dep bd2 ");
		 sql.append("       ON EN_ENT_IP.id_dep_phydisc = bd2.id_dep ");
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
	
		
	/**
	 * 获取所有已结算医保住院患者信息
	 */
	public PagingRtnData<CiMrFpDTO> getSettleMeInsuHosPatInfo(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException{
		
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = " WHERE ST_IP.FG_CANC = 'N'"; // 过滤取消结算的
		sqlwhere += " and hp.fg_active = 'Y' and bl_pay_pat_ip.sd_paytp = '"+ IBlDictCodeConst.SD_PAYTP_ST +"' ";
		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
	
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT distinct en_ent.id_ent,en_ent.id_pat,en_ent.code_entp,en_ent.name_pat,udi.name as name_sex,\n");
		sb.append("ent_ip.code_amr_ip,ent_ip.times_ip as n_times_inhospital, en_ent.dt_end ,amr.dt_catalogue,\n");
		sb.append("dep.name as name_dep_phydisc,hp.fg_medupload as fg_upload,PROP_AR_IP.Id_Hp,bl_pay_pat_ip.dt_pay,ppc.name as pat_sort\n");
		sb.append("FROM BL_ST_IP ST_IP\n");
		sb.append("INNER join en_ent en_ent on en_ent.id_ent = st_ip.id_ent\n");
		sb.append("INNER JOIN BL_PROP_IP PROP_IP ON PROP_IP.ID_STIP = ST_IP.ID_STIP \n");
		sb.append("INNER JOIN BL_PROP_AR_IP PROP_AR_IP ON PROP_AR_IP.ID_PROPIP = PROP_IP.ID_PROPIP\n");
		sb.append("left join en_ent_ip ent_ip\n");
		sb.append("on ent_ip.id_ent=en_ent.id_ent\n");
		sb.append("left join bd_dep dep\n");
		sb.append("on dep.id_dep=ent_ip.id_dep_phydisc\n");
		sb.append("left join bd_udidoc udi\n");
		sb.append("on udi.id_udidoc=en_ent.id_sex_pat\n");
		sb.append("left join bl_hp_entcode hp\n");
		sb.append("on hp.id_ent=en_ent.id_ent\n");
		sb.append("left join ci_amr amr\n");
		sb.append("on amr.id_ent=en_ent.id_ent\n");
		sb.append("left join pi_pat_ca ppc\n");
		sb.append("on ppc.id_patca=ST_IP.id_patca\n");
		sb.append(" left join bl_pay_pat_ip bl_pay_pat_ip ");
		sb.append(" on en_ent.id_ent = bl_pay_pat_ip.id_ent ");
		sb.append(sqlwhere);
		
		PagingRtnData<CiMrFpDTO> pagingRtnData = super.findByPageInfo(new CiMrFpDTO(), paginationInfo,sb.toString(), "PROP_AR_IP.Id_Hp",null);
		IHpentcodeRService hpentcodeRService=ServiceFinder.find(IHpentcodeRService.class);
		IHpentcodeCudService hpentcodeCudService=ServiceFinder.find(IHpentcodeCudService.class);
		if(pagingRtnData!=null&&pagingRtnData.getPageData().size()>0)
		{
			for(Object obj :pagingRtnData.getPageData())
			{
				CiMrFpDTO ciMrFpDto = (CiMrFpDTO)obj;
				List<HpEntCodeDO> list=new ArrayList<HpEntCodeDO>();
				if(ciMrFpDto.getFg_upload()==null){				
					ciMrFpDto.setFg_upload(FBoolean.FALSE);
					HpEntCodeDO[] hpEntCode = hpentcodeRService.find("id_ent='" + ciMrFpDto.getId_ent() + "'", "", FBoolean.FALSE);
	                if (hpEntCode != null && hpEntCode.length > 0){
	                	 hpEntCode[0].setFg_medupload(FBoolean.FALSE);
	                	 hpEntCode[0].setStatus(DOStatus.UPDATED);
	                     list.add(hpEntCode[0]);
	                }            
				    hpentcodeCudService.update(list.toArray(new HpEntCodeDO[list.size()]));
			    }
			}		
		}
		return pagingRtnData;
	}
}

