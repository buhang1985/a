package iih.ci.mrqc.mrcompletestatusdto.s.bp;

import iih.ci.mrqc.mrcompletestatusdto.d.MrCompleteStatusDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class MrCompleteQryBp extends PagingServiceImpl<MrCompleteStatusDTO> {

	/**
	 * 通过数据库关联的方式
	 * 
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @param paramClient
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<MrCompleteStatusDTO> getMrCompleteStatusDTOResultByDb(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo, String paramClient) throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String querySchema = "";
		// 获取查询方案的sql条件
		if (qryRootNodeDTO != null) {
			querySchema = service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		String sqlWhere = " where 1= 1  ";
		if (querySchema != "" && querySchema != null) {
			switch (paramClient) {
			case "overUncomp":// 超时未完成
				sqlWhere += "and " + querySchema
						+ " and mr.date_submit is null  and TO_CHAR(SYSDATE,'YYYYMMDD HH24:MI:SS') > task.dt_end  ";
				break;
			case "overComp":// 超时已完成
				sqlWhere += "and " + querySchema + " and mr.date_submit is not null and mr.date_submit >task.dt_end  ";
				break;
			case "comp":// 超时已完成
				sqlWhere += "and " + querySchema + " and mr.date_submit is not null  ";
				break;
			case "unWrite":// 未创建
				sqlWhere += "and " + querySchema + " and mr.createdtime is null ";
				break;
			default:
				sqlWhere += "and " + querySchema;
				break;
			}
		} else {
			switch (paramClient) {
			case "overUncomp":// 超时未完成
				sqlWhere += " and mr.date_submit is null  and TO_CHAR(SYSDATE,'YYYYMMDD HH24:MI:SS') > task.dt_end  ";
				break;
			case "overComp":// 超时已完成
				sqlWhere += " and mr.date_submit is not null and mr.date_submit >task.dt_end  ";
				break;
			case "comp":// 超时已完成
				sqlWhere += " and mr.date_submit is not null  ";
				break;
			case "unWrite":// 未创建
				sqlWhere += " and mr.createdtime is null ";
				break;
			default:
				break;
			}
		}
		// 从病案表、病案首页患者表查询数据
		StringBuilder sqlStr = getQuerySQL(sqlWhere);
		PagingRtnData<MrCompleteStatusDTO> pagingRtnData = super.findByPageInfo(new MrCompleteStatusDTO(),
				paginationInfo, sqlStr.toString(), "", null);
		if (pagingRtnData != null) {
			for (int i = 0; i < pagingRtnData.getPageData().size(); i++) {
				MrCompleteStatusDTO cms = (MrCompleteStatusDTO) pagingRtnData.getPageData().get(i);
				cms.setSortno(i + 1);
				if (cms.getDt_submit() != null) {
					FDateTime fd_submit = new FDateTime(cms.getDt_submit());
					FDateTime fd_finish = cms.getDt_finish();
					long overH = fd_submit.getMillis() - fd_finish.getMillis();
					if (overH <= 0) {
						cms.setOvertime("未超时");
					} else {
						cms.setOvertime(overH / (60 * 60 * 1000) + "小时");
					}
				} else {
					FDateTime fd = new FDateTime();
					FDateTime fd_finish = cms.getDt_finish();
					long overH = fd.getMillis() - fd_finish.getMillis();
					if (overH <= 0) {
						cms.setOvertime("未超时");
					} else {
						cms.setOvertime(overH / (60 * 60 * 1000) + "小时");
					}
				}
				if (cms.getDt_creat() == null) {
					cms.setDt_creat("未创建");
				}
				if (cms.getDt_submit() == null) {
					cms.setDt_submit("未签署");
				}
			}
		}
		return pagingRtnData;
	}

	/**
	 * 查询语句
	 * 
	 * @param sqlWhere
	 * @return
	 */
	private StringBuilder getQuerySQL(String sqlWhere) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select en.id_ent        as id_ent, ");
		sb.append(" pat.id_pat         as id_pat, ");
		sb.append(" pat.code           as sd_pat, ");
		sb.append(" pat.name           as name_pat, ");
		sb.append(" ip.id_dep_phyadm   as id_dep_phyadm, ");
		sb.append(" dep.code           as sd_dep_phyadm, ");
		sb.append(" dep.name           as name_dep_phyadm, ");
		sb.append(" en.id_emp_phy      as id_doc, ");
		sb.append(" en.dt_acpt         as dt_acpt, ");
		sb.append(" en.dt_end          as dt_end, ");
		sb.append(" psn.code           as sd_doc, ");
		sb.append(" psn.name           as name_doc, ");
		sb.append(" ip.code_amr_ip     as code_amr_ip, ");
		sb.append(" ip.name_bed        as name_bed, ");
		sb.append(" task.id_mrtask     as id_mrtask, ");
		sb.append(" task.id_mrtask_sta as id_mrtask_sta, ");
		sb.append(" bu1.code           as sd_mrtask_sta, ");
		sb.append(" bu1.name           as name_mrtask_sta, ");
		sb.append(" task.dt_begin      as dt_start, ");
		sb.append(" task.dt_end        as dt_finish, ");
		sb.append(" task.id_mrtp       as id_mrtp, ");
		sb.append(" mr.id_mr           as id_mr,");
		sb.append(" mr.createdtime     as dt_creat,");
		sb.append(" mr.date_submit     as date_submit,");
		sb.append(" mrtp.code          as sd_mrtp, ");
		sb.append(" mrtp.name          as name_mrtp, ");
		sb.append(" ip.times_ip        as times_inhos, ");
		sb.append(" task.id_mrcactm    as id_mrcactm, ");
		sb.append(" ctm.code          as sd_mrcactm, ");
		sb.append(" ctm.name        as name_mrcactm ");
		sb.append(" from ci_qa_mrtask task ");
		sb.append(" left join ci_mr mr on task.id_mrtask = mr.task_id and mr.ds = 0");
		sb.append(" inner join en_ent en on task.id_ent = en.id_ent ");
		sb.append(" inner join en_ent_ip ip on task.id_ent = ip.id_ent ");
		sb.append(" inner join pi_pat pat on pat.id_pat = task.id_pat ");
		sb.append(" inner join bd_udidoc bu1 on task.id_mrtask_sta = bu1.id_udidoc ");
		sb.append(" inner join bd_dep dep on ip.id_dep_phyadm = dep.id_dep ");
		sb.append(" inner join bd_psndoc psn on en.id_emp_phy = psn.id_psndoc ");
		sb.append(" inner join bd_mrtp mrtp on task.id_mrtp = mrtp.id_mrtp ");
		sb.append(" inner join bd_mrca_ctm ctm on task.id_mrcactm = ctm.id_mrcactm ");
		sb.append(sqlWhere);
		return sb;
	}

}
