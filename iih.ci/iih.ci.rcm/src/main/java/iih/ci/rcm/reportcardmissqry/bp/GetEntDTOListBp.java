package iih.ci.rcm.reportcardmissqry.bp;

import iih.ci.rcm.contagion.dto.d.EntDto;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.permfw.pub.EnvContextUtil;

/**
* 报卡漏报查询节点就诊查询
*/
public class GetEntDTOListBp extends PagingServiceImpl<EntDto>{
	
	
	public PagingRtnData<EntDto> getEntDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			String getSql=service.getQueryStringWithoutDesc(qryRootNodeDTO);
			if(getSql!=null){
				sqlwhere += "  AND "+getSql;
			}
		}

		StringBuilder sql = new StringBuilder();
		String strsql = "";
		sql.append("select * from(	         ");
		sql.append("       select  EN_ENT.id_ent as id_ent,");
		sql.append("	   EN_ENT.id_entp as id_entp,");
		sql.append("	   eeo.fg_first as is_first_en,");
		sql.append("	   eei.code_amr_ip as hospital_code,");
		sql.append("	   eei.name_bed as bed_code,");
		sql.append("	   pp.id_pat as id_pat,");
		sql.append("	   pp.name as name_pat,");
		sql.append("	   pp.dt_birth as pat_birth,");
		sql.append("	   bp.name as name_emp_phy,");
		sql.append("	   pp.id_sex as id_sex_pat,");
		sql.append("	   pp.sd_sex as sd_sex_pat,");
		sql.append("	   (CASE  WHEN pp.sd_sex = '0'");
		sql.append("	   THEN  '未知的性别'");
		sql.append("	   WHEN pp.sd_sex= '1'");
		sql.append("	   THEN  '男'");
		sql.append("	   WHEN pp.sd_sex= '2'");
		sql.append("	   THEN  '女'");
		sql.append("	   WHEN pp.sd_sex= '9'");
		sql.append("	   THEN  '未说明性别'");
		sql.append("	   end) as name_sex,  ");
		sql.append("	   pp.dt_birth as pat_ag,");
		sql.append("	   EN_ENT.id_dep_phy as id_dep_phy,");
		sql.append("	   bd.name as dep_phy_name,");
		sql.append("	   EN_ENT.dt_insert as dt_acpt,");
		sql.append("	   EN_ENT.dt_end as dt_end,");
		sql.append("	   di.dt_diag as dt_diag,");
		sql.append("	   di.id_didef_dis as id_didef_dis,");
		sql.append("	   di.name_didef_dis as name_didef_dis,");		
		sql.append("       rd.id_ci_rcm_rd as id_ci_rcm_rd,");//报卡文书主键
		sql.append("	   (CASE when rd.id_ci_rcm_rd is null then 'N' else 'Y' end) as iscard,");
		sql.append("	   rd.fg_reported_history  as sd_status,");
		sql.append("	   rd.id_bd_rcm_tp  as id_bd_rcm_tp, ");//文书类型id
		sql.append("	   tp.name  as report_category ");//报卡类别
		sql.append("	   from en_ent EN_ENT");
		sql.append("	   right join en_ent_di di");
		sql.append("	   on di.id_ent = EN_ENT.id_ent");
		sql.append("	   left join pi_pat pp");
		sql.append("	   on pp.id_pat = EN_ENT.id_pat");
		sql.append("	   left join en_ent_op eeo");
		sql.append("	   on eeo.id_ent = EN_ENT.id_ent");
		sql.append("	   left join en_ent_ip eei");
		sql.append("	   on eei.id_ent = EN_ENT.id_ent");
		sql.append("	   left join bd_dep bd");
		sql.append("	   on EN_ENT.id_dep_phy = bd.id_dep");
		sql.append("	   left join bd_psndoc bp");
		sql.append("	   on bp.id_psndoc = EN_ENT.id_emp_phy");	
		sql.append("	   left join ci_rcm_rd rd");
		sql.append("	   on rd.id_di = di.id_didef_dis and rd.id_ent = di.id_ent ");
		sql.append("	   left join bd_rcm_tp tp");
		sql.append("	   on rd.id_bd_rcm_tp=tp.id_bd_rcm_tp");
		sql.append("	   where  ");
		sql.append(EnvContextUtil.processEnvContext("",new PatiVisitDO(),false));
		sql.append("      ) where " + sqlwhere + "");
		strsql = sql.toString();
		PagingRtnData<EntDto> pagingRtnData = super.findByPageInfo(
				new EntDto(), paginationInfo, strsql,"order by dt_diag desc", null);
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
}
