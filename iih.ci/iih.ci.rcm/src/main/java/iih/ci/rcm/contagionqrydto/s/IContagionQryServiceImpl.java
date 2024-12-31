package iih.ci.rcm.contagionqrydto.s;

import iih.ci.rcm.contagionqrydto.d.ContagionQryDTO;
import iih.ci.rcm.contagionqrydto.i.IContagionQryService;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { IContagionQryService.class }, binding = Binding.JSONRPC)
public class IContagionQryServiceImpl extends
		PagingServiceImpl<ContagionQryDTO> implements IContagionQryService {

	public PagingRtnData<ContagionQryDTO> getContagionQryDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1 and ccc.ds<>'1' and ccc.sd_con_cardsu<>'1' and ee.id_org = '"+ Context.get().getOrgId() +"'";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}

		StringBuilder sql = new StringBuilder();

		sql.append("select ccc.dt_contagion as dt_contagion,\n");
		sql.append("       ccc.id_ent       as id_ent,\n");
		sql.append("       bu.name          as name_eu_bklb,\n");
		sql.append("       ccc.name_con_cardsu  as bk_status,\n");
		sql.append("       ccc.name         as name_pat,\n");
		sql.append("       ccc.hzjzxm       as hzjzxm,\n");
		sql.append("       (CASE\n");
		sql.append("         WHEN ccc.sd_sex = '0' THEN\n");
		sql.append("          '未知的性别'\n");
		sql.append("         WHEN ccc.sd_sex = '1' THEN\n");
		sql.append("          '男'\n");
		sql.append("         WHEN ccc.sd_sex = '2' THEN\n");
		sql.append("          '女'\n");
		sql.append("         WHEN ccc.sd_sex = '9' THEN\n");
		sql.append("          '未说明性别'\n");
		sql.append("       end) as name_sex,\n");
		sql.append("       ccc.eu_jlcrb_name || ccc.eu_ylcrb_name || ccc.eu_blcrb_name ||\n");
		sql.append("       ccc.name_other_diseases as name_disease,\n");
		sql.append("       ccc.name_province || ccc.street || ccc.village || ccc.housenum as addr_now,\n");
		sql.append("       ccc.exact_age as exact_age,\n");
		sql.append("       bu1.name as name_eu_rqfl,\n");
		sql.append("       ccc.workunit as workunit,\n");
		sql.append("       ccc.mob as mob,\n");
		sql.append("       bu2.name as name_eu_blfl,\n");
		sql.append("       ccc.fbrq as fbrq,\n");
		sql.append("       ccc.zdrq as zdrq,\n");
		sql.append("       ccc.swrq as swrq,\n");
		sql.append("       bd.name as dep_deport,\n");
		sql.append("       su.name as doctor_card,\n");
		sql.append("       ''      as dt_fangshi,\n");
		sql.append("       ''      as zhuangui,\n");
		sql.append("       ''      as code_dingzhika,\n");
		sql.append("       ''      as dingzhengren,\n");
		sql.append("       ''      as beizhu\n");
		sql.append("  from ci_contagion_card ccc\n");
		sql.append(" inner join en_ent ee\n");
		sql.append("    on ee.id_ent = ccc.id_ent\n");
		sql.append("  left join bd_udidoc bu\n");
		sql.append("    on bu.id_udidoc = ccc.eu_bklb\n");
		sql.append("  left join bd_udidoc bu1\n");
		sql.append("    on bu1.id_udidoc = ccc.eu_rqfl\n");
		sql.append("  left join bd_udidoc bu2\n");
		sql.append("    on bu2.id_udidoc = ccc.eu_blfl\n");
		sql.append(" inner join bd_dep bd\n");
		sql.append("    on bd.id_dep = ee.id_dep_phy\n");
		sql.append("  LEFT JOIN bd_psndoc su\n");
		sql.append("    on su.id_psndoc = ccc.id_emp_entry");
		sql.append("       WHERE " + sqlwhere + " ");

		String sqlStr = sql.toString();
		PagingRtnData<ContagionQryDTO> pagingRtnData = super.findByPageInfo(
				new ContagionQryDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}

	@SuppressWarnings("unchecked")
	public ContagionQryDTO[] getAllPageData() throws BizException {
		StringBuilder sql = new StringBuilder();

		sql.append("select ccc.dt_contagion as dt_contagion,\n");
		sql.append("       ccc.id_ent       as id_ent,\n");
		sql.append("       bu.name          as name_eu_bklb,\n");
		sql.append("       ccc.name         as name_pat,\n");
		sql.append("       ccc.hzjzxm       as hzjzxm,\n");
		sql.append("       (CASE\n");
		sql.append("         WHEN ccc.sd_sex = '0' THEN\n");
		sql.append("          '未知的性别'\n");
		sql.append("         WHEN ccc.sd_sex = '1' THEN\n");
		sql.append("          '男'\n");
		sql.append("         WHEN ccc.sd_sex = '2' THEN\n");
		sql.append("          '女'\n");
		sql.append("         WHEN ccc.sd_sex = '9' THEN\n");
		sql.append("          '未说明性别'\n");
		sql.append("       end) as name_sex,\n");
		sql.append("       ccc.eu_jlcrb_name || ccc.eu_ylcrb_name || ccc.eu_blcrb_name ||\n");
		sql.append("       ccc.name_other_diseases as name_disease,\n");
		sql.append("       ccc.name_province || ccc.street || ccc.village || ccc.housenum as addr_now,\n");
		sql.append("       ccc.exact_age as exact_age,\n");
		sql.append("       bu1.name as name_eu_rqfl,\n");
		sql.append("       ccc.workunit as workunit,\n");
		sql.append("       ccc.mob as mob,\n");
		sql.append("       bu2.name as name_eu_blfl,\n");
		sql.append("       ccc.fbrq as fbrq,\n");
		sql.append("       ccc.zdrq as zdrq,\n");
		sql.append("       ccc.swrq as swrq,\n");
		sql.append("       bd.name as dep_deport,\n");
		sql.append("       su.name as doctor_card,\n");
		sql.append("       ''      as dt_fangshi,\n");
		sql.append("       ''      as zhuangui,\n");
		sql.append("       ''      as code_dingzhika,\n");
		sql.append("       ''      as dingzhengren,\n");
		sql.append("       ''      as beizhu\n");
		sql.append(" from ci_contagion_card ccc\n");
		sql.append(" inner join en_ent ee\n");
		sql.append("    on ee.id_ent = ccc.id_ent\n");
		sql.append("  left join bd_udidoc bu\n");
		sql.append("    on bu.id_udidoc = ccc.eu_bklb\n");
		sql.append("  left join bd_udidoc bu1\n");
		sql.append("    on bu1.id_udidoc = ccc.eu_rqfl\n");
		sql.append("  left join bd_udidoc bu2\n");
		sql.append("    on bu2.id_udidoc = ccc.eu_blfl\n");
		sql.append(" inner join bd_dep bd\n");
		sql.append("    on bd.id_dep = ee.id_dep_phy\n");
		sql.append("  LEFT JOIN bd_psndoc su\n");
		sql.append("    on su.id_psndoc = ccc.id_emp_entry");
		sql.append("  WHERE 1=1 and ccc.ds<>'1' and ee.id_org = '"+ Context.get().getOrgId() +"' order by ee.dt_acpt desc");
		String sqlStr = sql.toString();
		DAFacade daf = new DAFacade();
		List<ContagionQryDTO> listDto = (List<ContagionQryDTO>) daf.execQuery(
				sqlStr, new BeanListHandler(ContagionQryDTO.class));
		return listDto.toArray(new ContagionQryDTO[0]);
	}

}
