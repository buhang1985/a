package iih.ci.ord.s.bp.specant;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.database.DatabaseUtils;
import iih.bd.base.database.SqlConditionsParameter;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.specanti.d.SpeConsRstType;
import iih.ci.ord.specanti.d.SpecAntiConsDO;
import iih.ci.ord.specanti.d.SpecAntiReviewDO;
import iih.ci.ord.specanti.d.SpecOrderAntiDrugAppDTO;
import iih.ci.ord.specanti.d.SpecOrderAntiDrugDTO;
import iih.ci.ord.specanti.d.SpecantionApplyDTO;
import iih.ci.ord.specanti.i.ISpecAntiReviewDOCudService;
import iih.ci.ord.specanti.i.ISpecanticonsMDOCudService;
import iih.ci.ord.specanti.i.ISpecanticonsMDORService;
import iih.ci.ord.speconsqrydto.d.SpeConsEnumType;
import iih.ci.ord.speconsqrydto.d.SpeconsQryDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * <p>
 * Title: SpecantionOrderBP
 * </p>
 * <p>
 * Description: 特殊级抗菌药申请 审批DTO查询
 * </p>
 * 
 * @author LiYue
 * @date 2018年8月16日
 */
public class SpecantionOrderBP {

	/**
	 * 通过申请时间查询 患者列表
	 * @param speconsQryDTO
	 * @return
	 * @throws DAException
	 */
	public SpecantionApplyDTO[] exec(SpeconsQryDTO speconsQryDTO) throws DAException {
		if (CiOrdUtils.isEmpty(speconsQryDTO))
			return null;
		String sql = getSql(speconsQryDTO);

		@SuppressWarnings("unchecked")
		ArrayList<SpecantionApplyDTO> result = (ArrayList<SpecantionApplyDTO>) new DAFacade().execQuery(sql,
				new BeanListHandler(SpecantionApplyDTO.class));

		return result.toArray(new SpecantionApplyDTO[0]);
	}

	 
	/**
	 * 通过申请单ID查询
	 * @param id_apspecanticons
	 * @return
	 * @throws DAException
	 */
	public SpecantionApplyDTO[] exec1(String id_apspecanticons) throws DAException {
		if (CiOrdUtils.isEmpty(id_apspecanticons))
			return null;
		String sql = getSql1(id_apspecanticons);

		@SuppressWarnings("unchecked")
		ArrayList<SpecantionApplyDTO> result = (ArrayList<SpecantionApplyDTO>) new DAFacade().execQuery(sql,
				new BeanListHandler(SpecantionApplyDTO.class));

		return result.toArray(new SpecantionApplyDTO[0]);
	}

	/**
	 * 通过申请时间查询SQL
	 * @param speconsQryDTO
	 * @return
	 */
	private String getSql(SpeconsQryDTO speconsQryDTO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CON.id_apspecanticons, "); // 申请单号
		sql.append(" PAT.Name     AS Name_pat, "); // 患者姓名
		sql.append(" DEP.name   AS name_dep_phy, "); // 患者科室
		sql.append(" ENT.code     AS code_amr_ip, "); // 就诊号
		sql.append(" ORSRV.Name      AS type_apspe, "); // 药物
		sql.append(" ENTI.code_amr_ip,  "); // 住院号
		sql.append(" ENTI.name_bed  As bed_no,  "); // 病床
		sql.append(" CON.name_didef as str_name_diitm, "); // 诊断
		sql.append(" case when CON.sd_approve_meddep=0 then '同意' "); // 审批结果
		sql.append(" when CON.sd_approve_meddep=1 or CON.SD_APPROVE_EMP=1 then '驳回' "); 
		sql.append(" when CON.SD_APPROVE_EMP=0 then '待医务处审批'  "); 
		sql.append(" else '待审批' end as sd_approve_meddep, "); 
		sql.append(" b.name as name_emp, "); // 申请医生
		sql.append(" CON.createdtime as dt_cons_app "); // 创建时间
		sql.append(" FROM  ci_ap_spec_anti_cons CON  ");
		sql.append(" LEFT OUTER JOIN ci_order ORD  ON CON.Id_or   = ORD.Id_or ");
		sql.append(" LEFT OUTER JOIN ci_or_srv ORSRV ON ORD.Id_or   = ORSRV.Id_or ");
		sql.append(" LEFT OUTER JOIN pi_pat PAT ON ORD.Id_pat = PAT.Id_pat ");
		sql.append(" LEFT OUTER JOIN bd_udidoc PAT_SEX ON PAT.Id_sex = PAT_SEX.Id_udidoc ");
		sql.append(" LEFT OUTER JOIN bd_grp GRP ON GRP.Id_grp = ORD.Id_grp ");
		sql.append(" LEFT OUTER JOIN en_ent ENT ON ORD.Id_en = ENT.Id_ent ");
		sql.append(" LEFT OUTER JOIN en_ent_ip ENTI ON ORD.Id_en = ENTI.Id_ent ");
		sql.append(" LEFT OUTER JOIN bd_psndoc b on b.id_psndoc= con.id_emp ");
		sql.append(" LEFT OUTER JOIN bd_dep DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY  ");
		sql.append(" left join bd_srv_drug bd_srv_drug  ");
		sql.append(" on bd_srv_drug.id_srv = ORSRV.id_srv ");
		
		sql.append(" left outer join ci_ap_spec_anti_invites invit on invit.id_apspecanticons = CON.id_apspecanticons");
		sql.append(" where ORD.code_entp ='10'");// 开发测试条件
		sql.append("   and bd_srv_drug.sd_anti = '"+IBdMmDictCodeConst.SD_ANTI_SPECIAL+"'  "); //特殊级抗菌药code
		//过滤多组织
		sql.append("   and ORD.id_org='"+Context.get().getOrgId()+"'  ");
	    sql.append(getWherePart(speconsQryDTO));

		return sql.toString();
	}

	/**
	 * 获得查询过滤条件  
	 *  Yes 是否审核
	 * @param speconsQryDTO
	 * @return
	 */
	private String getWherePart(SpeconsQryDTO speconsQryDTO) {
		StringBuffer sql = new StringBuffer();
		if (speconsQryDTO.getDt_cons_app() != null) {
			sql.append(" and CON.dt_cons_app >= '" + speconsQryDTO.getDt_cons_app() + "'");
		}
		if (speconsQryDTO.getDt_end() != null) {
			sql.append(" and CON.dt_cons_app <= '" + speconsQryDTO.getDt_end() + "'");
		}
		
		// 专家会诊
		if (SpeConsEnumType.SPECONSEXPERT.equals(speconsQryDTO.getConsenum())) {
			// 会诊受邀人为当前登录人
			sql.append(" and invit.id_emp='" + speconsQryDTO.getId_emp_cons() + "'");
			
		  if("Yes".equals(speconsQryDTO.getCons_sh())){
			// 专家已审批
			sql.append(" and CON.sd_approve_emp is not null ");
		  }else{
			// 专家未审批
			sql.append(" and CON.sd_approve_emp is null ");
		  }
		
		} else if (SpeConsEnumType.SPECONSMSS.equals(speconsQryDTO.getConsenum())) {
			// 医务科会诊同意
			sql.append(" and CON.sd_approve_emp ='" + SpeConsRstType.SPECONSD_AGREE + "' ");
			  
			  if ("Yes".equals(speconsQryDTO.getCons_sh())){
			  // 医务科已审批
			  sql.append(" and CON.sd_approve_meddep is not null ");
			  }else{
			  // 医务科未审批
			  sql.append(" and CON.sd_approve_meddep is null ");	
			  
			}
			  //按时间倒序排序
			  sql.append(" ORDER BY CON.DT_CONS_APP desc ");	
		}else if(SpeConsEnumType.SPECONSDEPT.equals(speconsQryDTO.getConsenum())){
			sql.append(" and 1!=1 ");
		}
		return sql.toString();
	}
	
	
	/**
	 * 通过申请单ID查询SQL
	 * @param id_apspecanticons
	 * @return
	 */
	private String getSql1(String id_apspecanticons) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CON.id_apspecanticons, "); // 申请单号
		sql.append(" PAT.Name     AS Name_pat, "); // 患者姓名
		sql.append(" DEP.name   AS name_dep_phy, "); // 患者科室
		sql.append(" ENT.code     AS code_amr_ip, "); // 就诊号
		sql.append(" ORSRV.Name      AS type_apspe, "); // 药物
		sql.append(" ENTI.code_amr_ip,  "); // 住院号
		sql.append(" ENTI.name_bed  As bed_no,  "); // 病床
		sql.append(" CON.name_didef as str_name_diitm, "); // 诊断
		sql.append(" b.name as name_emp, "); // 申请医生
		sql.append(" CON.createdtime as dt_cons_app，"); // 创建时间

		sql.append(" CON.des_sympsign,  "); // 患者感染情况
		sql.append(" CON.microbeinspection, "); // 病原体检查
		sql.append(" CON.fg_microbeinspection, "); // 是否病原体检查
		sql.append(" CON.allerhyhistory,        "); // 患者过敏史
		sql.append(" CON.des_pps,               "); // 用药理由
		sql.append(" ORSRV.fg_propc As des_feasons,"); // 用药目的/是否预防
		sql.append(" CON.name_emp_title  , "); // 申请医生职称

		sql.append(" CON.dt_cons , "); // 会诊时间
		sql.append(" INV.name_dep , "); // 受邀科室
		sql.append(" INV.name_emp As name_invited_emp, "); // 受邀专家
		sql.append(" INV.id_emp_title, "); // 受邀专家职称
		sql.append(" CON.advice, "); // 受邀专家意见
		sql.append(" CON.sd_approve_meddep , "); // 医务部审核
		sql.append(" CON.sd_approve_emp,");//专家审核状态
		sql.append(" ORSRV.fg_propc "); // 是否预防用药

		sql.append(" FROM ci_ap_spec_anti_cons CON  ");
		sql.append(" LEFT OUTER JOIN ci_order ORD ON CON.Id_or   = ORD.Id_or ");
		sql.append(" LEFT OUTER JOIN ci_or_srv ORSRV ON ORD.Id_or   = ORSRV.Id_or ");
		sql.append(" LEFT OUTER JOIN ci_ap_spec_anti_invites INV ON ORD.Id_or   = INV.Id_or ");
		sql.append(" LEFT OUTER JOIN pi_pat PAT ON ORD.Id_pat = PAT.Id_pat ");
		sql.append(" LEFT OUTER JOIN bd_udidoc PAT_SEX ON PAT.Id_sex = PAT_SEX.Id_udidoc ");
		sql.append(" LEFT OUTER JOIN bd_grp GRP ON GRP.Id_grp = ORD.Id_grp ");
		sql.append(" LEFT OUTER JOIN en_ent ENT ON ORD.Id_en = ENT.Id_ent ");
		sql.append(" LEFT OUTER JOIN en_ent_ip ENTI ON ORD.Id_en = ENTI.Id_ent ");
		sql.append(" LEFT OUTER JOIN bd_psndoc b on b.id_psndoc= con.id_emp ");
		sql.append(" LEFT OUTER JOIN bd_dep DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY  ");
		sql.append(" LEFT OUTER JOIN bd_srv_drug drug on drug.id_srv = ORSRV.id_srv ");

		sql.append(" where ORD.code_entp ='10'  ");
		sql.append(" and   CON.id_apspecanticons = '" + id_apspecanticons + "' and drug.sd_anti='3' ");

		return sql.toString();
	}

	/**
	 * 特殊级抗菌药会诊审批
	 * @param specantionDTO
	 * @return 布尔 
	 * @throws BizException 
	 */
	public Boolean approval(SpecantionApplyDTO specantionDTO) throws BizException{
		ISpecanticonsMDORService service =  (ISpecanticonsMDORService)ServiceFinder.find(ISpecanticonsMDORService.class);
		ISpecanticonsMDOCudService 	saveService	= (ISpecanticonsMDOCudService)ServiceFinder.find(ISpecanticonsMDOCudService.class);
	   //取审批单数据
		SpecAntiConsDO consDo = service.findById(specantionDTO.getId_apspecanticons());
		
		switch (specantionDTO.getApprovetp()) {
		case SpeConsEnumType.SPECONSEXPERT://专家
			if(SpeConsRstType.SPECONSD_AGREE.equals(specantionDTO.getApprovrst())){
				consDo.setId_approve_emp(IBdSrvDictCodeConst.ID_SPECONS_RST_AGREE);
				consDo.setSd_approve_emp(IBdSrvDictCodeConst.SD_SPECONS_RST_AGREE);
			}else{
				consDo.setId_approve_emp(IBdSrvDictCodeConst.ID_SPECONS_RST_REJECT);
				consDo.setSd_approve_emp(IBdSrvDictCodeConst.SD_SPECONS_RST_REJECT);
			}
			consDo.setAdvice(specantionDTO.getAdvice());
			break;
        case SpeConsEnumType.SPECONSMSS://医务科
        	if(SpeConsRstType.SPECONSD_AGREE.equals(specantionDTO.getApprovrst())){
				consDo.setId_approve_meddep(IBdSrvDictCodeConst.ID_SPECONS_RST_AGREE);
				consDo.setSd_approve_meddep(IBdSrvDictCodeConst.SD_SPECONS_RST_AGREE);
			}else{
				consDo.setId_approve_meddep(IBdSrvDictCodeConst.ID_SPECONS_RST_REJECT);
				consDo.setSd_approve_meddep(IBdSrvDictCodeConst.SD_SPECONS_RST_REJECT);
			}
			break;
        case SpeConsEnumType.SPECONSDEPT://科室
        	if(SpeConsRstType.SPECONSD_AGREE.equals(specantionDTO.getApprovrst())){
				consDo.setId_approve_clidep(IBdSrvDictCodeConst.ID_SPECONS_RST_AGREE);
				consDo.setSd_approve_clidep(IBdSrvDictCodeConst.SD_SPECONS_RST_AGREE);
			}else{
				consDo.setId_approve_clidep(IBdSrvDictCodeConst.ID_SPECONS_RST_REJECT);
				consDo.setSd_approve_clidep(IBdSrvDictCodeConst.SD_SPECONS_RST_REJECT);
			}
			break;
		default:
			break;
		}
		//更新会诊结果
		consDo.setStatus(DOStatus.UPDATED);
		// mantis: 0170718 会诊时间改到专家审批时设置 
		consDo.setDt_cons(specantionDTO.getDt_cons());
		saveService.save(new SpecAntiConsDO[]{consDo});
		//创建审批记录
		SpecAntiReviewDO specdo = new SpecAntiReviewDO();
		specdo.setId_or(consDo.getId_or());
		specdo.setId_apspecanticons(consDo.getId_apspecanticons());
		specdo.setId_emp(Context.get().getStuffId());
		specdo.setId_dep(Context.get().getDeptId());
		specdo.setDt_approve(new FDateTime());
		specdo.setDes_approve(consDo.getAdvice());
		specdo.setId_approvetp(Integer.parseInt(specantionDTO.getApprovetp()));
		specdo.setStatus(DOStatus.NEW);
		ISpecAntiReviewDOCudService specAntiReviewSevice = ServiceFinder.find(ISpecAntiReviewDOCudService.class);
		specAntiReviewSevice.save(new SpecAntiReviewDO[]{specdo});
		return true;
		 
	}

    /**
     * 存在申请单
     * @param id_en
     * @param code_ent
     * @param Id_srv
     * @return -1：该就诊患者，在相应的业务线，没有该特抗药的申请；0：存在特抗药申请单，但流程没有走完；1：存在特抗药申请单，流程走完；
     * @throws BizException
     */
	public int hasApprovaled(String id_en, String code_ent, String[] Id_srv) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select distinct capac.sd_approve_meddep from ci_ap_spec_anti_cons capac ")
		.append(" where capac.fg_approve_meddep = 'Y' and capac.id_or in(")
		.append(" select distinct srv.id_or from ci_or_srv srv ")
		.append(" left join ci_or_srv_mm mm on srv.id_orsrv = mm.id_orsrv ")
		.append(" where  @id_en and  @code_ent and @Id_srv)");
		SqlConditionsParameter sp = new SqlConditionsParameter(sb.toString());
		sp.replaceSqlParam("@id_en", "srv.id_en", id_en)
		.replaceSqlParam("@code_ent", "srv.code_entp", code_ent)
		.replaceSqlInParam("@Id_srv", "srv.Id_srv", Id_srv);
		List<SpecantionApplyDTO> rstList = DatabaseUtils.Q(sp, SpecantionApplyDTO.class);
		if(rstList != null && rstList.size() > 0) {
			for(SpecantionApplyDTO item : rstList) {
				// 只要 存在医务科 审核过的 特抗药，则返回 不用重新申请
				if("0".equals(item.getSd_approve_meddep())) {
					return 1;
				}
			}
			return 0;
		}
		return -1;
	}


	/**
	 * 获取给定医嘱ID下的所有抗菌药基本信息
	 * @param szId_or
	 * @return
	 * @throws BizException
	 */
	public SpecOrderAntiDrugDTO[] getOrderAntiDrugsInfo(String[] szId_or ) throws BizException {
		SqlConditionsParameter sp =  new SqlConditionsParameter("select srv.id_en,srv.id_or,ord.code_or,srv.id_srv,mm.id_mm, mm.name_mm from  ci_or_srv srv ");
		sp.addSql(" left join ci_order ord on ord.id_or = srv.id_or ");
		sp.addSql(" left join ci_or_srv_mm mm on srv.id_orsrv = mm.id_orsrv  where srv.fg_mm = 'Y' and mm.sd_anti = '3' and srv.ds = 0 ");
		sp.andSqlInParam("srv.id_or", szId_or);
		List<SpecOrderAntiDrugDTO> rstList = DatabaseUtils.Q(sp, SpecOrderAntiDrugDTO.class);
		
		return rstList!= null && rstList.size() > 0?rstList.toArray(new SpecOrderAntiDrugDTO[rstList.size()]):null;
	}
	
	/**
	 * 获得就诊信息下的所有抗菌药申请信息
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public SpecOrderAntiDrugAppDTO[] getOrderAntiDrugAppsInfo(String id_en) throws BizException {
		SqlConditionsParameter sp = 
				new SqlConditionsParameter("select distinct  srvmm.id_en, srvmm.id_srv, srvmm.id_mm,capac.advice, capac.sd_approve_emp,capac.sd_approve_clidep, capac.sd_approve_meddep  from ");
		sp.addSql(" (select srv.id_en,srv.id_or,mm.id_mm,srv.id_srv from ci_or_srv srv")
		.addSql(" inner join ci_or_srv_mm mm on srv.id_orsrv = mm.id_orsrv and @id_en ")
		.addSql(" inner join ci_order ci on ci.id_or=srv.id_or")
		.addSql(" where  ci.code_entp = '10' and srv.fg_mm = 'Y' and mm.sd_anti = '3' ")
		.addSql(") srvmm left join ci_ap_spec_anti_cons capac  on capac.id_or = srvmm.id_or and capac.ds = 0 ")
		.replaceSqlParam("@id_en", "srv.id_en", id_en);
		
		List<SpecOrderAntiDrugAppDTO> rstList = DatabaseUtils.Q(sp, SpecOrderAntiDrugAppDTO.class);
		
		return rstList!= null && rstList.size() > 0?rstList.toArray(new SpecOrderAntiDrugAppDTO[rstList.size()]):null;
	}



}
