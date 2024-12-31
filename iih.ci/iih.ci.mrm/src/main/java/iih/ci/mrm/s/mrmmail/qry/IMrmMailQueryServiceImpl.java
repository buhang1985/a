package iih.ci.mrm.s.mrmmail.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.mrmmail.qry.IMrmMailQueryService;
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

@Service(serviceInterfaces={IMrmMailQueryService.class}, binding=Binding.JSONRPC)
public class IMrmMailQueryServiceImpl extends PagingServiceImpl<CiMrmQryListDTO> implements IMrmMailQueryService {

	public PagingRtnData<CiMrmQryListDTO> getMrmMailDTOList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// 查询方案解析
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		
		StringBuilder sqlWhere = new StringBuilder();
		
		sqlWhere.append(" where en_ent.fg_ip = 'N' and ci_amr.code_entp = '");// 已出院
		sqlWhere.append(IBdFcDictCodeConst.SD_CODE_ENTP_IP);// 住院类型
		sqlWhere.append("' ");
		
 		if (qryRootNodeDTO != null){
 			sqlWhere.append(" and ");
 			sqlWhere.append(service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		sqlWhere.append(" and ci_amr.id_org = '"+Context.get().getOrgId()+"' ");
 		sqlWhere.append(" order by case when ci_mrm_sp.sv is null then 0 else 1 end desc ");
 		
 		// 调用sql方法
 		StringBuilder sql = getMrmQuerySql(sqlWhere.toString());
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
		sql.append(" bd_udidoc.name as name_mrm_mail,\n ");// 邮寄状态name
		sql.append(" ci_amr.id_enhr as id_amr,\n ");// 病案表主键
		sql.append(" ci_mrm_sp.id_mail_state as id_mrm_mail_sta,\n ");// 邮寄状态id
		sql.append(" ci_mrm_sp.sd_mail_state as sd_mrm_mail_sta\n, ");// 邮寄状态code
		sql.append(" en_ent_ip.id_dep_phydisc as id_dep_end\n, ");// 出院科室id
		sql.append(" en_ent.code_entp as code_entp\n ");// 就诊类型编码
		
		sql.append(" from ci_amr ci_amr\n ");
		sql.append(" left join en_ent_ip en_ent_ip\n ");
		sql.append(" on ci_amr.id_ent = en_ent_ip.id_ent\n ");
		sql.append(" left join ci_mrm_sp ci_mrm_sp\n ");
		sql.append(" on ci_mrm_sp.id_ci_amr = ci_amr.id_enhr\n ");
		sql.append(" left join en_ent en_ent\n ");
		sql.append(" on ci_amr.id_ent = en_ent.id_ent\n ");
		sql.append(" left join bd_dep bd_dep\n ");
		sql.append(" on en_ent_ip.id_dep_phydisc = bd_dep.id_dep\n ");
		sql.append(" left join bd_udidoc bd_udidoc\n ");
		sql.append(" on ci_mrm_sp.id_mail_state = bd_udidoc.id_udidoc\n ");
		
		sql.append(sqlwhere);
		
		return sql;
	}

}
