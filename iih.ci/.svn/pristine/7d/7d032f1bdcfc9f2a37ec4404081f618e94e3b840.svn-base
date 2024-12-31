package iih.ci.mrm.s.mrmmailquery.qry;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.mrmmailquery.qry.IMrmMailQryQueryService;
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

@Service(serviceInterfaces={IMrmMailQryQueryService.class}, binding=Binding.JSONRPC)
public class IMrmMailQryQueryServiceImpl extends PagingServiceImpl<CiMrmQryListDTO> implements IMrmMailQryQueryService {

	public PagingRtnData<CiMrmQryListDTO> getMrmMailDTOList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		
		// 查询方案解析
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		
		String sqlwhere = " where nvl(ci_mrm_sp.id_mail_state, 'isnull') != 'isnull' ";
		
 		if (qryRootNodeDTO != null){
 			sqlwhere += " and " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		
 		sqlwhere += " and ci_amr.id_org = '"+Context.get().getOrgId()+"' ";
 		
 		// 调用sql方法
 		StringBuilder sql = getMrmQuerySql(sqlwhere.toString());
 		String sqlStr = sql.toString();
 		
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlStr, "", null);
			
		return pagingRtnData;
	}
	
	private StringBuilder getMrmQuerySql(String sqlwhere) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select ci_amr.code_amr_times as mrmcode_and_times,\n ");// 病案条码号
		sql.append(" en_ent.name_pat as name_pat,\n ");// 患者姓名
		sql.append(" en_ent.dt_end as dt_end,\n ");// 出院时间
		sql.append(" bd_dep.name as name_dep_end,\n ");// 科室名称
		sql.append(" ci_mrm_sp.copies as print_count,\n ");// 打印份数
		sql.append(" ci_mrm_sp.receivable_pay as receivable_pay,\n ");// 预计金额
		sql.append(" ci_mrm_sp.ma_contacts as name_psn_contact,\n ");// 联系人
		sql.append(" ci_mrm_sp.ma_telephone as tel_psn_contact,\n ");// 联系人电话
		sql.append(" ci_mrm_sp.advance_pay as advance_pay,\n ");// 预收金额
		sql.append(" bd_udidoc.name as name_mrm_mail,\n ");// 邮寄状态name
		sql.append(" bd_psndoc_r.name as name_psn_register,\n ");// 登记人
		sql.append(" bd_psndoc_c.name as name_psn_confirm,\n ");// 确认人
		sql.append(" ci_amr.id_enhr as id_amr,\n ");// 病案表主键
		sql.append(" ci_mrm_sp.id_mail_state as id_mrm_mail_sta,\n ");// 邮寄状态id
		sql.append(" ci_mrm_sp.sd_mail_state as sd_mrm_mail_sta\n, ");// 邮寄状态code
		sql.append(" en_ent_ip.id_dep_phydisc as id_dep_end\n, ");// 出院科室id
		sql.append(" ci_mrm_sp.id_psn_register as id_psn_register\n, ");// 登记人id
		sql.append(" ci_mrm_sp.dt_register as dt_psn_register\n, ");// 登记时间
		sql.append(" ci_mrm_sp.id_psn_confirm as id_psn_confirm\n, ");// 确认人id
		sql.append(" ci_mrm_sp.dt_confirm as dt_psn_confirm\n ");// 确认时间
		
		sql.append(" from ci_amr ci_amr\n ");
		sql.append(" left join ci_mrm_sp ci_mrm_sp\n ");
		sql.append(" on ci_mrm_sp.id_ci_amr = ci_amr.id_enhr\n ");
		sql.append(" left join bd_udidoc bd_udidoc\n ");
		sql.append(" on ci_mrm_sp.id_mail_state = bd_udidoc.id_udidoc ");
		sql.append(" left join en_ent_ip en_ent_ip\n ");
		sql.append(" on ci_amr.id_ent = en_ent_ip.id_ent\n ");
		sql.append(" left join en_ent en_ent\n ");
		sql.append(" on ci_amr.id_ent = en_ent.id_ent\n ");
		sql.append(" left join bd_dep bd_dep\n ");
		sql.append(" on en_ent_ip.id_dep_phydisc = bd_dep.id_dep\n ");
		sql.append(" left join bd_psndoc bd_psndoc_r\n ");
		sql.append(" on ci_mrm_sp.id_psn_register = bd_psndoc_r.id_psndoc\n ");
		sql.append(" left join bd_psndoc bd_psndoc_c\n ");
		sql.append(" on ci_mrm_sp.id_psn_confirm = bd_psndoc_c.id_psndoc\n ");
		
		sql.append(sqlwhere);
		
		return sql;
	}

}
