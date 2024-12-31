package iih.ci.rcm.contagion.s;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.rcm.contagion.dto.d.Contagiondto;
import iih.ci.rcm.contagion.dto.d.EntDto;
import iih.ci.rcm.contagion.i.IContagionCudServiceExt;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IContagionCudServiceExt.class }, binding = Binding.JSONRPC)
public class ContagionCrudServiceExtImpl extends PagingServiceImpl<EntDto>
		implements IContagionCudServiceExt {

	public Contagiondto[] getCotagions(String id_ent) throws BizException {
		// TODO Auto-generated method stub

		StringBuilder sbSql = new StringBuilder();
		String baseSql = " (select ccc.id_contagion from ci_contagion_card ccc where ccc.ds=0 and ccc.id_ent = '"
				+ id_ent + "')";
		String strsql = "";

		sbSql.append("select ccc.id_contagion,ccc.id_ent,ccc.p_id_contagion,'报告卡_'||ccc.eu_jlcrb_name||ccc.eu_ylcrb_name||ccc.eu_blcrb_name||ccc.name_other_diseases||'_' ||ccc.name_con_cardsu title,ccc.id_form,ccc.id_con_cardsu id_state,ccc.rehect_reason as reject_reason from ci_contagion_card ccc where ccc.ds=0 and ccc.id_ent='"
				+ id_ent + "'");
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select cmc.id_contagion_std,'' id_ent,cmc.id_contagion, '性病附卡' title,cmc.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_STD cmc where cmc.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select cch.id_contagion_hb,'' id_ent,cch.id_contagion, '乙肝附卡' title,cch.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_HB cch where cch.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select ccs.id_contagion_ss,'' id_ent,ccs.id_contagion, '梅毒附卡' title,ccs.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_SS ccs where ccs.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select hfm.id_contagion_hfm,'' id_ent,hfm.id_contagion, '手足口附卡' title,hfm.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_HFM hfm where hfm.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select aids.id_aids,'' id_ent,aids.id_contagion, '艾滋病附卡' title,aids.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_AIDS aids where aids.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select ca.id_condyloma,'' id_ent,ca.id_contagion, '尖锐湿疣附卡' title,ca.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_CA ca where ca.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select ncp.id_contagion_ncp,'' id_ent,ncp.id_contagion, '新冠肺炎附卡' title,ncp.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_NCP ncp where ncp.id_contagion in"
				+ baseSql);
		strsql = sbSql.toString();
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<Contagiondto> listContagionDto = (List<Contagiondto>) daf
				.execQuery(strsql, new BeanListHandler(Contagiondto.class));

		return listContagionDto.toArray(new Contagiondto[0]);

	}

	public Contagiondto[] getCotagionlist(String id_ent) throws BizException {
		StringBuilder sbSql = new StringBuilder();
		String baseSql = " (select ccc.id_contagion from ci_contagion_card ccc where ccc.sd_con_cardsu in(2,3,4) and ccc.ds=0 and ccc.id_ent = '"
				+ id_ent + "')";
		String strsql = "";

		sbSql.append("select ccc.id_contagion,ccc.id_ent,ccc.p_id_contagion,'报告卡_'||ccc.eu_jlcrb_name||ccc.eu_ylcrb_name||ccc.eu_blcrb_name||ccc.name_other_diseases||'_' ||ccc.name_con_cardsu title,ccc.id_form,ccc.id_con_cardsu id_state,ccc.rehect_reason as reject_reason from ci_contagion_card ccc where ccc.sd_con_cardsu in(2,3,4) and ccc.ds=0 and ccc.id_ent='"
				+ id_ent + "'");
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select cmc.id_contagion_std,'' id_ent,cmc.id_contagion, '性病附卡' title,cmc.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_STD cmc where cmc.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select cch.id_contagion_hb,'' id_ent,cch.id_contagion, '乙肝附卡' title,cch.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_HB cch where cch.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select ccs.id_contagion_ss,'' id_ent,ccs.id_contagion, '梅毒附卡' title,ccs.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_SS ccs where ccs.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select hfm.id_contagion_hfm,'' id_ent,hfm.id_contagion, '手足口附卡' title,hfm.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_HFM hfm where hfm.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select aids.id_aids,'' id_ent,aids.id_contagion, '艾滋病附卡' title,aids.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_AIDS aids where aids.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select ca.id_condyloma,'' id_ent,ca.id_contagion, '尖锐湿疣附卡' title,ca.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_CA ca where ca.id_contagion in"
				+ baseSql);
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select ncp.id_contagion_ncp,'' id_ent,ncp.id_contagion, '新冠肺炎附卡' title,ncp.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_NCP ncp where ncp.id_contagion in"
				+ baseSql);
		strsql = sbSql.toString();
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<Contagiondto> listContagionDto = (List<Contagiondto>) daf
				.execQuery(strsql, new BeanListHandler(Contagiondto.class));

		return listContagionDto.toArray(new Contagiondto[0]);
	}

	public Contagiondto[] getChildCotagions(String p_id) throws BizException {

		StringBuilder sbSql = new StringBuilder();
		String strsql = "";

		sbSql.append("  select cmc.id_contagion_std,'' id_ent,cmc.id_contagion, '性病附卡' title,cmc.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_STD cmc where cmc.id_contagion ='"
				+ p_id + "'");
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select cch.id_contagion_hb,'' id_ent,cch.id_contagion, '乙肝附卡' title,cch.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_HB cch where cch.id_contagion ='"
				+ p_id + "'");
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select ccs.id_contagion_ss,'' id_ent,ccs.id_contagion, '梅毒附卡' title,ccs.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_SS ccs where ccs.id_contagion ='"
				+ p_id + "'");
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select hfm.id_contagion_hfm,'' id_ent,hfm.id_contagion, '手足口附卡' title,hfm.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_HFM hfm where hfm.id_contagion ='"
				+ p_id + "'");
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select aids.id_aids,'' id_ent,aids.id_contagion, '艾滋病附卡' title,aids.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_AIDS aids where aids.id_contagion ='"
				+ p_id + "'");
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select ca.id_condyloma,'' id_ent,ca.id_contagion, '尖锐湿疣附卡' title,ca.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_CA ca where ca.id_contagion ='"
				+ p_id + "'");
		sbSql.append("  UNION ALL  ");
		sbSql.append("  select ncp.id_contagion_ncp,'' id_ent,ncp.id_contagion, '新冠肺炎附卡' title,ncp.id_form,'' id_state,'' as reject_reason from CI_MR_CONTAGION_CARD_NCP ncp where ncp.id_contagion ='"
				+ p_id + "'");

		strsql = sbSql.toString();
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<Contagiondto> listContagionDto = (List<Contagiondto>) daf
				.execQuery(strsql, new BeanListHandler(Contagiondto.class));

		return listContagionDto.toArray(new Contagiondto[0]);

	}

	public EntDto[] getEnts(QryRootNodeDTO qryRootNodeDTO) throws BizException {

		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}

		StringBuilder sql = new StringBuilder();
		String strsql = "";

		sql.append("       SELECT distinct ccc.id_ent,\n");
		sql.append("       en_ent.id_entp as id_entp,\n");
		sql.append("       amr.code_amr_ip hospital_code,\n");
		sql.append("       en_ent.id_pat,\n");
		sql.append("       amr.id_enhr id_amr,\n");
		sql.append("       eei.name_bed bed_code,\n");
		sql.append("       en_ent.name_pat,\n");
		sql.append("       en_ent.id_sex_pat,\n");
		sql.append("       en_ent.sd_sex_pat,\n");
		sql.append("       (CASE WHEN en_ent.sd_sex_pat= '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN en_ent.sd_sex_pat= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN en_ent.sd_sex_pat= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN en_ent.sd_sex_pat= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as name_sex,");
		sql.append("       amr.pat_age as pat_age,\n");
		sql.append("	   en_ent.dt_birth_pat as pat_birth,\n");
		sql.append("       en_ent.id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ccc.fbrq,\n");
		sql.append("       ccc.dt_contagion,\n");
		sql.append("       ccc.id_con_cardsu,\n");
		sql.append("       ccc.sd_con_cardsu sd_con_cardsn,\n");
		sql.append("       ccc.name_con_cardsu name_con_cardsn,\n");
		sql.append("       ccc.name_emp_entry,\n");
		sql.append("       ccc.modifiedtime dt_audit,\n");
		//审核人
		sql.append("       us_sign.name name_emp_audit,\n");
		sql.append("       ccc.id_emp_audit ,\n");
		sql.append("       us_sign.code sd_emp_audit,\n");
		//审核科室
		sql.append("       auditdep.name name_dep_audit,\n");
		sql.append("       auditdep.code sd_dep_audit,\n");
		sql.append("       ccc.id_dep_audit,\n");
		//报告科室
		sql.append("       submitdep.name name_dep_submit,\n");
		sql.append("       submitdep.code sd_dep_submit,\n");
		sql.append("       ccc.id_dep_submit,ccc.eu_bklb_name as report_category,\n");	
		sql.append("       ccc.id_code as idcard \n");
		sql.append("       FROM ci_contagion_card ccc\n");
		sql.append("       left join en_ent en_ent\n");
		sql.append("       on ccc.id_ent = en_ent.id_ent\n");
		sql.append("       left JOIN en_ent_ip eei\n");
		sql.append("       on en_ent.id_ent = eei.id_ent\n");
		sql.append("       left join ci_amr amr\n");
		sql.append("       on en_ent.id_ent = amr.id_ent\n");
		sql.append("       INNER JOIN bd_dep bd\n");
		sql.append("       ON en_ent.id_dep_phy = bd.id_dep\n");
		sql.append("       Left JOIN sys_user us_sign\n");
		sql.append("       ON us_sign.id_user = ccc.id_emp_audit\n");
		sql.append("       Left JOIN bd_dep auditdep\n");
		sql.append("       ON ccc.id_dep_audit = auditdep.id_dep\n");
		sql.append("       Left JOIN bd_dep submitdep\n");
		sql.append("       ON ccc.id_dep_submit = submitdep.id_dep\n");
		sql.append("       WHERE "
				+ EnvContextUtil
						.processEnvContext("", new PatiVisitDO(), false)
				+ " and ccc.sd_con_cardsu<>1 and ccc.ds=0 and " + sqlwhere
				+ " order by ccc.dt_contagion desc");

		strsql = sql.toString();
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<EntDto> listDto = (List<EntDto>) daf.execQuery(strsql,
				new BeanListHandler(EntDto.class));

		// 循环处理患者年龄
		if (listDto != null && listDto.size() > 0) {
			for (int i = 0; i < listDto.size(); i++) {
				EntDto dto = listDto.get(i);
				if (dto.getPat_birth() != null) {
					String age = AgeCalcUtil.getAge(dto.getPat_birth());
					dto.setPat_age(age);
				}
				
			}
		}

		return listDto.toArray(new EntDto[0]);
	}

	public EntDto[] getEnts2(QryRootNodeDTO qryRootNodeDTO) throws BizException {

		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}

		StringBuilder sql = new StringBuilder();
		String strsql = "";
		sql.append("  SELECT * FROM (");
		sql.append("       SELECT distinct ee.id_ent as id_ent,\n");
		sql.append("       cd.id_entp as id_entp,\n");
		sql.append("       eei.code_amr_ip as hosptial_code,\n");
		sql.append("       pp.id_pat as id_pat,\n");
		sql.append("       '' as id_amr,\n");
		sql.append("       eei.name_bed as bed_code,\n");
		sql.append("       pp.name as name_pat,\n");
		sql.append("       pp.id_sex as id_sex_pat,\n");
		sql.append("       pp.sd_sex as sd_sex_pat,\n");
		sql.append("       (CASE  WHEN pp.sd_sex = '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN pp.sd_sex= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN pp.sd_sex= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN pp.sd_sex= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as name_sex,");
		sql.append("       pp.dt_birth as pat_ag,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name as dep_phy_name,\n");
		sql.append("       ee.dt_insert as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       cd.dt_di as dt_diag,\n");
		sql.append("       bp.name as name_emp_phy,\n");
		sql.append("       cdi.id_didef as id_didef_dis,\n");
		sql.append("       cdi.id_didef_name as name_didef_dis,\n");
		sql.append("       (CASE when ccc.sd_con_cardsu = '2' then 'Y'");
		sql.append("          when ccc.sd_con_cardsu = '3' then 'Y'");
		sql.append("          else 'N' end) as iscard,\n");
		sql.append("		ccc.fbrq as fbrq,");
		sql.append("		ccc.dt_contagion as dt_contagion,");
		sql.append("		ccc.id_con_cardsu as id_con_cardsu,");
		sql.append("		ccc.sd_con_cardsu as sd_con_cardsu,");
		sql.append("		ccc.name_con_cardsu as name_con_cardsn,");
		sql.append("		pp.dt_birth as pat_birth");
		sql.append("       from ci_di_itm cdi\n");
		sql.append("       left join ci_di cd\n");
		sql.append("       on cdi.id_di = cd.id_di\n");
		sql.append("       left join bd_di_def bdd\n");
		sql.append("       on bdd.id_didef = cdi.id_didef\n");
		sql.append("       left join en_ent ee\n");
		sql.append("       on cd.id_en = ee.id_ent\n");
		sql.append("       left join en_ent_ip eei\n");
		sql.append("       on eei.id_ent = ee.id_ent\n");
		sql.append("       left join en_ent_op eeo\n");
		sql.append("       on eeo.id_ent = ee.id_ent\n");
		sql.append("	   left join ci_contagion_card ccc\n");
		sql.append(" 	   on ccc.id_ent = ee.id_ent\n");
		sql.append("	   left join pi_pat pp\n");
		sql.append("	   on pp.id_pat = ee.id_pat\n");
		sql.append("	   left join bd_dep bd\n");
		sql.append("	   on ee.id_dep_phy = bd.id_dep\n");
		sql.append("	   left join bd_psndoc bp\n");
		sql.append("	   on bp.id_psndoc = ee.id_emp_phy  where bdd.fg_ur = 'Y')\n");
		sql.append("       WHERE " + sqlwhere + "");
		strsql = sql.toString();
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<EntDto> listDto = (List<EntDto>) daf.execQuery(strsql,
				new BeanListHandler(EntDto.class));

		return listDto.toArray(new EntDto[0]);
	}

	public PagingRtnData<EntDto> getEntDTOList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}

		StringBuilder sql = new StringBuilder();
		String strsql = "";
		sql.append("	   SELECT * FROM (       SELECT distinct ee.id_ent as id_ent,");
		sql.append("	   ee.id_entp as id_entp,");
		sql.append("	   eei.code_amr_ip as hospital_code,");
		sql.append("	   pp.id_pat as id_pat,");
		sql.append("	   '' as id_amr,");
		sql.append("	   eei.name_bed as bed_code,");
		sql.append("	   pp.name as name_pat,");
		sql.append("	   pp.id_sex as id_sex_pat,");
		sql.append("	   pp.sd_sex as sd_sex_pat,");
		sql.append("	   eeo.fg_first as is_first_en,");
		sql.append("	   (CASE  WHEN pp.sd_sex = '0'");
		sql.append("	   THEN  '未知的性别'");
		sql.append("	   WHEN pp.sd_sex= '1'");
		sql.append("	   THEN  '男'");
		sql.append("	   WHEN pp.sd_sex= '2'");
		sql.append("	   THEN  '女'");
		sql.append("	   WHEN pp.sd_sex= '9'");
		sql.append("	   THEN  '未说明性别'");
		sql.append("	   end) as name_sex,       pp.dt_birth as pat_ag,");
		sql.append("	   ee.id_dep_phy as id_dep_phy,");
		sql.append("	   bd.name as dep_phy_name,");
		sql.append("	   ee.dt_insert as dt_acpt,");
		sql.append("	   ee.dt_end as dt_end,");
		sql.append("	   en_ent_di.dt_diag as dt_diag,");
		sql.append("	   bp.name as name_emp_phy,");
		sql.append("	   en_ent_di.id_didef_dis as id_didef_dis,");
		sql.append("	   en_ent_di.name_didef_dis as name_didef_dis,");
		sql.append("	   (CASE when ccc.sd_con_cardsu is null then 'N' else 'Y' end) as iscard,");
		sql.append("	   ccc.fbrq as fbrq,    ccc.dt_contagion as dt_contagion,    ccc.id_con_cardsu as id_con_cardsu,    ccc.sd_con_cardsu as sd_con_cardsu,    ccc.name_con_cardsu as name_con_cardsn,    pp.dt_birth as pat_birth,");
		sql.append("	   pa.id_mr_con_pa,");
		sql.append("	   bdu.name as sd_status,");
		sql.append("	   pa.id_status");
		sql.append("	   from en_ent_di en_ent_di");
		sql.append("	   left join en_ent ee");
		sql.append("	   on en_ent_di.id_ent = ee.id_ent");
		sql.append("	   left join en_ent_ip eei");
		sql.append("	   on eei.id_ent = ee.id_ent");
		sql.append("	   left join en_ent_op eeo");
		sql.append("	   on eeo.id_ent = ee.id_ent");
		sql.append("	   left join ci_contagion_card ccc");
		sql.append("	   on ccc.id_ent = ee.id_ent");
		sql.append("	   left join pi_pat pp");
		sql.append("	   on pp.id_pat = ee.id_pat");
		sql.append("	   left join bd_dep bd");
		sql.append("	   on ee.id_dep_phy = bd.id_dep");
		sql.append("	   left join bd_psndoc bp");
		sql.append("	   on bp.id_psndoc = ee.id_emp_phy");
		sql.append("	   left join ci_mr_contagion_card_pa pa on pa.id_ent = ee.id_ent");
		sql.append(" left join bd_udidoc bdu on bdu.id_udidoc = pa.id_status ");
		sql.append("	   where en_ent_di.fg_ur = 'Y' and ");
		sql.append(EnvContextUtil.processEnvContext("",new EntDiDO(),false));
		sql.append(" and (ccc.sd_con_cardsu in ('" );
		sql.append(ICiMrDictCodeConst.SD_CONTAGION_STATUS_NEW);
		sql.append("','");
		sql.append(ICiMrDictCodeConst.SD_CONTAGION_STATUS_REJECT);
		sql.append("') or ccc.sd_con_cardsu is null) and (pa.sd_status in ('");
		sql.append(ICiMrDictCodeConst.SD_CONPASS_SUBMIT);
		sql.append("','");
		sql.append(ICiMrDictCodeConst.SD_CONPASS_REJECT);
		sql.append("') or pa.sd_status is null))en");
		sql.append("       WHERE " + sqlwhere + "");
		strsql = sql.toString();
		PagingRtnData<EntDto> pagingRtnData = super.findByPageInfo(
				new EntDto(), paginationInfo, strsql,"order by en.dt_acpt desc", null);
		FArrayList list = pagingRtnData.getPageData();
		for (Object obj : list) {
			EntDto dto = (EntDto) obj;
			String age = AgeCalcUtil.getAge(dto.getPat_birth());
			dto.setPat_age(age);
			if (dto.getIs_first_en() == FBoolean.TRUE) {
				dto.setDef1("初诊");
			} else if (dto.getIs_first_en() == FBoolean.FALSE) {
				dto.setDef1("复诊");
			} else {
				dto.setDef1("");
			}
		}

		return pagingRtnData;
	}

	@SuppressWarnings("unchecked")
	public EntDto[] getAllPageData() throws BizException {
		StringBuilder sql = new StringBuilder();
		String strsql = "";
		sql.append("       SELECT distinct ee.id_ent as id_ent,\n");
		sql.append("       ci_di.id_entp as id_entp,\n");
		sql.append("       eei.code_amr_ip as hosptial_code,\n");
		sql.append("       pp.id_pat as id_pat,\n");
		sql.append("       '' as id_amr,\n");
		sql.append("       eei.name_bed as bed_code,\n");
		sql.append("       pp.name as name_pat,\n");
		sql.append("       pp.id_sex as id_sex_pat,\n");
		sql.append("       pp.sd_sex as sd_sex_pat,\n");
		sql.append("       (CASE  WHEN pp.sd_sex = '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN pp.sd_sex= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN pp.sd_sex= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN pp.sd_sex= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as name_sex,");
		sql.append("       pp.dt_birth as pat_ag,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name as dep_phy_name,\n");
		sql.append("       ee.dt_insert as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       ci_di.dt_di as dt_diag,\n");
		sql.append("       bp.name as name_emp_phy,\n");
		sql.append("       cdi.id_didef as id_didef_dis,\n");
		sql.append("       cdi.id_didef_name as name_didef_dis,\n");
		sql.append("       (CASE when ccc.sd_con_cardsu = '2' then 'Y'");
		sql.append("          when ccc.sd_con_cardsu = '3' then 'Y'");
		sql.append("          else 'N' end) as iscard,\n");
		sql.append("		ccc.fbrq as fbrq,");
		sql.append("		ccc.dt_contagion as dt_contagion,");
		sql.append("		ccc.id_con_cardsu as id_con_cardsu,");
		sql.append("		ccc.sd_con_cardsu as sd_con_cardsu,");
		sql.append("		ccc.name_con_cardsu as name_con_cardsn,");
		sql.append("		pp.dt_birth as pat_birth");
		sql.append("       from ci_di_itm cdi\n");
		sql.append("       left join ci_di ci_di\n");
		sql.append("       on cdi.id_di = ci_di.id_di\n");
		sql.append("       left join bd_di_def bdd\n");
		sql.append("       on bdd.id_didef = cdi.id_didef\n");
		sql.append("       left join en_ent ee\n");
		sql.append("       on ci_di.id_en = ee.id_ent\n");
		sql.append("       left join en_ent_ip eei\n");
		sql.append("       on eei.id_ent = ee.id_ent\n");
		sql.append("       left join en_ent_op eeo\n");
		sql.append("       on eeo.id_ent = ee.id_ent\n");
		sql.append("	   left join ci_contagion_card ccc\n");
		sql.append(" 	   on ccc.id_ent = ee.id_ent\n");
		sql.append("	   left join pi_pat pp\n");
		sql.append("	   on pp.id_pat = ee.id_pat\n");
		sql.append("	   left join bd_dep bd\n");
		sql.append("	   on ee.id_dep_phy = bd.id_dep\n");
		sql.append("	   left join bd_psndoc bp\n");
		sql.append("	   on bp.id_psndoc = ee.id_emp_phy  where bdd.fg_ur = 'Y' \n");
		sql.append("       and  ");
		sql.append(EnvContextUtil.processEnvContext("",new CiDiagDO(),false));
		sql.append("       order by ee.dt_insert desc");
		strsql = sql.toString();
		DAFacade daf = new DAFacade();
		List<EntDto> listDto = (List<EntDto>) daf.execQuery(strsql,
				new BeanListHandler(EntDto.class));

		return listDto.toArray(new EntDto[0]);
	}

	
	/**
	 * 根据人员id获取该人员应该未处理的传染病上报卡
	 * @param id_psndoc
	 * @return
	 * @throws BizException
	 */
	public EntDto[] getEntsByPsndoc(String id_psndoc) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT distinct ee.id_ent as id_ent, ");
		sb.append("ee.id_entp as id_entp, ");
		sb.append("eei.code_amr_ip as hospital_code, ");
		sb.append("pp.id_pat as id_pat, ");
		sb.append("'' as id_amr, ");
		sb.append("eei.name_bed as bed_code, ");
		sb.append("pp.name as name_pat, ");
		sb.append("pp.id_sex as id_sex_pat, ");
		sb.append("pp.sd_sex as sd_sex_pat, ");
		sb.append("(CASE  WHEN pp.sd_sex = '0' ");
		sb.append("THEN  '未知的性别' ");
		sb.append("WHEN pp.sd_sex= '1' ");
		sb.append("THEN  '男' ");
		sb.append("WHEN pp.sd_sex= '2' ");
		sb.append("THEN  '女' ");
		sb.append("WHEN pp.sd_sex= '9' ");
		sb.append("THEN  '未说明性别' ");
		sb.append("end) as name_sex,       pp.dt_birth as pat_ag, ");
		sb.append("ee.id_dep_phy as id_dep_phy, ");
		sb.append("bd.name as dep_phy_name, ");
		sb.append("ee.dt_insert as dt_acpt, ");
		sb.append("ee.dt_end as dt_end, ");
		sb.append("cdi.dt_diag as dt_diag, ");
		sb.append("bp.name as name_emp_phy, ");
		sb.append("cdi.id_didef_dis as id_didef_dis, ");
		sb.append("cdi.name_didef_dis as name_didef_dis, ");
		sb.append("(CASE when ccc.sd_con_cardsu is null then 'N' else 'Y' end) as iscard, ");
		sb.append("ccc.fbrq as fbrq,    ccc.dt_contagion as dt_contagion,    ccc.id_con_cardsu as id_con_cardsu,    ccc.sd_con_cardsu as sd_con_cardsu,     ");
		sb.append("case when ccc.sd_con_cardsu is null and pa.sd_status is null then '未填报' when ccc.sd_con_cardsu is null and pa.sd_status = '03' then '既往驳回' when pa.sd_status is null and ccc.sd_con_cardsu = '1' then '未提交' when pa.sd_status is null and ccc.sd_con_cardsu = '4' then '上报驳回' when pa.sd_status ='03' and ccc.sd_con_cardsu = '1' then '未提交(既往驳回)' when pa.sd_status ='03' and ccc.sd_con_cardsu = '4' then '上报驳回(既往驳回)' end as name_con_cardsn, ");
		sb.append("pp.dt_birth as pat_birth, ");
		sb.append("pa.id_mr_con_pa, ");
		sb.append("pa.sd_status, ");
		sb.append("pa.id_status, ");
		sb.append("ccc.rehect_reason, ");
		sb.append("us.id_user id_user, ");
		sb.append("ee.code  code_ent ");
        sb.append("from en_ent_di cdi ");
		sb.append("left join en_ent ee ");
		sb.append("on cdi.id_ent = ee.id_ent ");
		sb.append("left join en_ent_ip eei ");
		sb.append("on eei.id_ent = ee.id_ent ");
		sb.append("left join en_ent_op eeo ");
		sb.append("on eeo.id_ent = ee.id_ent ");
		sb.append("left join ci_contagion_card ccc ");
		sb.append("on ccc.id_ent = ee.id_ent ");
		sb.append("left join pi_pat pp ");
		sb.append("on pp.id_pat = ee.id_pat ");
		sb.append("left join bd_dep bd ");
		sb.append("on ee.id_dep_phy = bd.id_dep ");
		sb.append("left join bd_psndoc bp ");
		sb.append("on bp.id_psndoc = ee.id_emp_phy ");
		sb.append("left join sys_user us ");
		sb.append("on us.id_psn = bp.id_psndoc ");
		sb.append("left join ci_mr_contagion_card_pa pa on pa.id_ent = ee.id_ent ");
		sb.append("where ee.id_emp_phy = '");
		sb.append(id_psndoc);
		sb.append("' and cdi.fg_ur = 'Y' and (ccc.sd_con_cardsu in ('");
		sb.append(ICiMrDictCodeConst.SD_CONTAGION_STATUS_NEW);
		sb.append("','");
		sb.append(ICiMrDictCodeConst.SD_CONTAGION_STATUS_REJECT);
		sb.append("') or ccc.sd_con_cardsu is null) and (pa.sd_status in ('");
		sb.append(ICiMrDictCodeConst.SD_CONPASS_REJECT);
		sb.append("') or pa.sd_status is null) ");
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<EntDto> listDto = (List<EntDto>) daf.execQuery(sb.toString(),
				new BeanListHandler(EntDto.class));

		return listDto.toArray(new EntDto[0]);
	}

	
}
