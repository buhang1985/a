package iih.ci.mrqc.randomqc.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.randomqc.d.MrQcRandomItmDTO;
import iih.ci.mrqc.randomqc.i.IMrQcOutRandomItmQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

@Service(serviceInterfaces = { IMrQcOutRandomItmQryService.class }, binding = Binding.JSONRPC)
public class IMrQcOutRandomItmQryServiceImpl extends
		PagingServiceImpl<MrQcRandomItmDTO> implements
		IMrQcOutRandomItmQryService {

	@Override
	public PagingRtnData<MrQcRandomItmDTO> getMrQcOutRandomItmListDtos(
			String id_random_itm, PaginationInfo paginationInfo)
			throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("select itm.id_random_check_itm as id_random_itm,\n");
		sql.append("       itm.id_check_status as id_check_status,\n");
		sql.append("       itm.sd_check_status as sd_check_status,\n");
		sql.append("       bu.name as name_check_status,\n");		
		sql.append("       ee.id_ent as id_ent,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.code as code_ent,\n");
		sql.append("       ee.name_pat as name_pat,\n");
		sql.append("       ee.dt_birth_pat as Dt_birth,\n");
		sql.append("       (CASE\n");
		sql.append("         WHEN ee.sd_sex_pat = '0' THEN\n");
		sql.append("          '未知的性别'\n");
		sql.append("         WHEN ee.sd_sex_pat = '1' THEN\n");
		sql.append("          '男'\n");
		sql.append("         WHEN ee.sd_sex_pat = '2' THEN\n");
		sql.append("          '女'\n");
		sql.append("         WHEN ee.sd_sex_pat = '9' THEN\n");
		sql.append("          '未说明性别'\n");
		sql.append("       end) as pat_sex,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       psn.name as name_emp_phy,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       dep.name as name_dep_phy,\n");
		sql.append("       ee.dt_entry as dt_entry,\n");
		sql.append("       itm.dt_check as dt_random,\n");
 		sql.append("(select count(1) from ci_qa_flt cqf where cqf.id_ent=itm.id_ent and cqf.sd_qa_ty='"+ICiMrDictCodeConst.SD_EXEC_OUTQC+"'  and cqf.ds='0') as flt_times,\n");
		sql.append("       amr.id_enhr as id_amr,\n");
		sql.append("       amr.fg_dept_qa as fg_mrqc,\n");
		sql.append("       amr.score_dept_qa as score,\n");
		sql.append("       amr.fg_terminal_qa as fg_mrqc_terminal,\n");
		sql.append("       amr.score_terminal_qa as score_terminal,\n");
		sql.append("       amr.code_amr_ip as hospital_code\n");
		sql.append("  from ci_mr_qc_record_itm itm\n");
		sql.append("  left join en_ent ee\n");
		sql.append("    on ee.id_ent = itm.id_ent\n");
		sql.append("  left join ci_amr amr\n");
		sql.append("    on amr.id_ent = itm.id_ent\n");
		sql.append("  left join bd_psndoc psn\n");
		sql.append("    on psn.id_psndoc = ee.id_emp_phy\n");
		sql.append("  left join bd_dep dep\n");
		sql.append("    on dep.id_dep = ee.id_dep_phy\n");
		sql.append("  left join bd_udidoc bu\n");
		sql.append("    on bu.id_udidoc = itm.id_check_status\n");
		sql.append(" where itm.id_random_record='"+id_random_itm+"'");
		sql.append("    order by ee.code asc");
 		String sqlStr=sql.toString();
		PagingRtnData<MrQcRandomItmDTO> pagingRtnData = super.findByPageInfo(new MrQcRandomItmDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}

	@Override
	public PagingRtnData<MrQcRandomItmDTO> getMrQcOpdOutRandomItmListDtos(
			String id_random_itm, PaginationInfo paginationInfo)
			throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("select itm.id_random_check_itm as id_random_itm,\n");
		sql.append("       itm.id_check_status as id_check_status,\n");
		sql.append("       itm.sd_check_status as sd_check_status,\n");
		sql.append("       bu.name as name_check_status,\n");		
		sql.append("       ee.id_ent as id_ent,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.code as code_ent,\n");
		sql.append("       ee.name_pat as name_pat,\n");
		sql.append("       ee.dt_birth_pat as Dt_birth,\n");
		sql.append("       (CASE\n");
		sql.append("         WHEN ee.sd_sex_pat = '0' THEN\n");
		sql.append("          '未知的性别'\n");
		sql.append("         WHEN ee.sd_sex_pat = '1' THEN\n");
		sql.append("          '男'\n");
		sql.append("         WHEN ee.sd_sex_pat = '2' THEN\n");
		sql.append("          '女'\n");
		sql.append("         WHEN ee.sd_sex_pat = '9' THEN\n");
		sql.append("          '未说明性别'\n");
		sql.append("       end) as pat_sex,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       psn.name as name_emp_phy,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       dep.name as name_dep_phy,\n");
		sql.append("       ee.dt_entry as dt_entry,\n");
		sql.append("       itm.dt_check as dt_random,\n");
 		sql.append("(select count(1) from ci_qa_flt cqf where cqf.id_ent=itm.id_ent and cqf.sd_qa_ty='"+ICiMrDictCodeConst.SD_EXEC_OPDOUTQC+"'  and cqf.ds='0') as flt_times,\n");
		sql.append("       amr.id_enhr as id_amr,\n");
		sql.append("       amr.fg_dept_qa as fg_mrqc,\n");
		sql.append("       amr.score_dept_qa as score,\n");
		sql.append("       amr.fg_terminal_qa as fg_mrqc_terminal,\n");
		sql.append("       amr.score_terminal_qa as score_terminal,\n");
		sql.append("       amr.code_amr_ip as hospital_code\n");
		sql.append("  from ci_mr_qc_record_itm itm\n");
		sql.append("  left join en_ent ee\n");
		sql.append("    on ee.id_ent = itm.id_ent\n");
		sql.append("  left join ci_amr amr\n");
		sql.append("    on amr.id_ent = itm.id_ent\n");
		sql.append("  left join bd_psndoc psn\n");
		sql.append("    on psn.id_psndoc = ee.id_emp_phy\n");
		sql.append("  left join bd_dep dep\n");
		sql.append("    on dep.id_dep = ee.id_dep_phy\n");
		sql.append("  left join bd_udidoc bu\n");
		sql.append("    on bu.id_udidoc = itm.id_check_status\n");
		sql.append(" where itm.id_random_record='"+id_random_itm+"'");
		sql.append("    order by ee.code asc");
 		String sqlStr=sql.toString();
		PagingRtnData<MrQcRandomItmDTO> pagingRtnData = super.findByPageInfo(new MrQcRandomItmDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}

}
