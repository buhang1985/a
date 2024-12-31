package iih.ci.mrm.s.mrmtrackmanager.qry;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.mrm.dto.cimrmprocedurelistdto.d.CiMrmProcedureListDTO;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.mrmtrackmanager.qry.IMrmTrackQueryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { IMrmTrackQueryService.class }, binding = Binding.JSONRPC)
public class IMrmTrackQueryServiceImpl extends PagingServiceImpl<CiMrmQryListDTO> implements IMrmTrackQueryService {	
	/**
	 * 病案追踪管理节点-列表查询
	 */
	public PagingRtnData<CiMrmQryListDTO> getMrmTrackDTOList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// 查询方案解析
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);

		StringBuilder sqlWhere = new StringBuilder();
		// 查询就诊类型条件：住院
		sqlWhere.append(" where ci_amr.code_entp = '");
		sqlWhere.append(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		sqlWhere.append("' ");
		// 加入查询条件
		if (qryRootNodeDTO != null) {
			sqlWhere.append(" and ");
			sqlWhere.append(service.getQueryStringWithoutDesc(qryRootNodeDTO));
		}
		sqlWhere.append(" and ci_amr.id_org = '"+Context.get().getOrgId()+"' ");
		// 根据病案的最后修改时间进行排序，不包括为空情况
		sqlWhere.append(" order by case when ci_amr.modifiedtime is null then 0 else 1 end desc ");
		// 调用sql方法
		StringBuilder sql = getMrmTrackQuerySql(sqlWhere.toString());
		String sqlStr = sql.toString();

		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo,
				sqlStr, "", null);
		return pagingRtnData;
	}
	/**
	 * getMrmTrackDTOList方法查询sql
	 * @param sqlwhere
	 * @return StringBuilder
	 */
	private StringBuilder getMrmTrackQuerySql(String sqlwhere) {
		StringBuilder sql = new StringBuilder();

		sql.append(" select ci_amr.code_amr_ip as code_amr_ip,\n ");// 病案号
		sql.append(" ci_amr.id_enhr as id_amr,\n ");// 病案表主键
		sql.append(" en_ent.id_pat as id_pat,\n ");// 患者-id
		sql.append(" en_ent.name_pat as name_pat,\n ");// 患者-姓名
		sql.append(" en_ent.dt_end as dt_end,\n ");// 出院时间
		sql.append(" en_ent_ip.id_dep_phydisc as id_dep_end, \n ");// 出院科室-id
		sql.append(" bd_dep.name as name_dep_end,\n ");// 出院科室-名称
		sql.append(" ci_amr.id_bd_mrm_ot as id_bd_mrm_ot,\n ");// 病案流程-id
		sql.append(" bd_mrm_ot.name as name_mrm_ot,\n ");// 病案流程-名称
		sql.append(" ci_mrm_op.id_psn_op as id_psn_operate,\n ");// 操作人-id
		sql.append(" bd_psndoc.name as name_psn_operate,\n ");// 操作人-名称
		sql.append(" bd_mrm_ot.id_qa_doctor_part_sta as id_qa_doctor_part_sta,\n ");// 病案状态-id
		sql.append(" bd_mrm_ot.sd_qa_doctor_part_sta as sd_qa_doctor_part_sta,\n ");// 病案状态-code
		sql.append(" bd_udidoc.name as name_qa_doctor_part_sta,\n ");// 病案状态-名称
		sql.append(" en_ent.dt_acpt as admissiondate, ");//入院时间
		sql.append(" ci_amr.dt_catalogue as dt_catalogue\n,");// 编目时间
		sql.append(" ci_amr.reason_amr_back as reason_amr_back\n");// 备注（病案打回原因）
		sql.append(" from ci_amr ci_amr\n ");
		sql.append(" left join en_ent_ip en_ent_ip\n ");
		sql.append(" on ci_amr.id_ent = en_ent_ip.id_ent\n ");
		sql.append(" left join en_ent en_ent\n ");
		sql.append(" on ci_amr.id_ent = en_ent.id_ent\n ");
		sql.append(" left join bd_mrm_ot bd_mrm_ot\n ");
		sql.append(" on ci_amr.id_bd_mrm_ot = bd_mrm_ot.id_bd_mrm_ot\n ");
		sql.append(" left join bd_dep bd_dep\n ");
		sql.append(" on en_ent.id_dep_phy = bd_dep.id_dep\n ");
		sql.append(" left join ci_mrm_op ci_mrm_op\n ");
		sql.append(" on ci_amr.id_enhr = ci_mrm_op.id_amr and ci_amr.id_bd_mrm_ot = ci_mrm_op.id_bd_mrm_ot\n ");
		sql.append(" left join bd_psndoc bd_psndoc\n ");
		sql.append(" on ci_mrm_op.id_psn_op = bd_psndoc.id_psndoc\n ");
		sql.append(" left join bd_udidoc bd_udidoc\n ");
		sql.append(" on bd_mrm_ot.id_qa_doctor_part_sta = bd_udidoc.id_udidoc\n ");
		sql.append(" left join sys_user sys_user\n ");
		sql.append(" on ci_amr.modifiedby = sys_user.id_user\n ");

		sql.append(sqlwhere);
		return sql;
	}

	/**
	 * 病案示踪控件-初始流程名称显示查询
	 * @return CiMrmProcedureListDTO[]
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public CiMrmProcedureListDTO[] getProcessNameDTOList(String sqlWhere) throws BizException {
		// 调用sql方法
		StringBuilder sql = getMrmProcessNameQuerySql(sqlWhere);
		String sqlStr = sql.toString();

		DAFacade daf = new DAFacade();
		List<CiMrmProcedureListDTO> CMPList = 
				(List<CiMrmProcedureListDTO>) daf.execQuery(sqlStr, new BeanListHandler(CiMrmProcedureListDTO.class));
		
		if (CMPList == null) {
			return null;
		}
		List<CiMrmProcedureListDTO> ciMrmProcedureListDTO = new ArrayList<CiMrmProcedureListDTO>();
		// 记录回退流程id
		String processId = null;
		// 判断是否退出while循环
		boolean isFinish = true;
		// 用于拼接异常信息
		StringBuilder sb = new StringBuilder();
		
		int num = 1;
		while (isFinish) {
			// 判断是否可能无限循环
			boolean isChoice = false;
			// 如果processId为空，此次为首次遍历，确定结束流程并存储
			if (processId == null) {
				for (CiMrmProcedureListDTO cmp : CMPList) {
					if (cmp.getFg_end() != null && cmp.getFg_end() == FBoolean.TRUE) {
						// 将结束流程add到集合的首位，并将其回退流程id赋值给成员变量processId
						ciMrmProcedureListDTO.add(cmp);
						processId = cmp.getId_bd_mrm_ot_bo();
						sb.append(num + "." + cmp.getName_bd_mrm_ot_cu() + "/" + cmp.getId_bd_mrm_ot_cu() + "(" + cmp.getName_bd_mrm_ot_bo() + ")...");
						++num;
					}
				}
			}
			
			if (processId != null) {
				for (CiMrmProcedureListDTO cmp : CMPList) {
					if (processId != null && cmp.getId_bd_mrm_ot_cu().equals(processId)) {
						// 根据上一次流程的回退流程id查询到要存储的流程，并重新赋值processId
						ciMrmProcedureListDTO.add(cmp);
						processId = cmp.getId_bd_mrm_ot_bo();
						isChoice = true;
						sb.append(num + "." + cmp.getName_bd_mrm_ot_cu() + "/" + cmp.getId_bd_mrm_ot_cu() + "(" + cmp.getName_bd_mrm_ot_bo() + ")...");
						++num;
					}
				}
				// 如果因数据问题导致无法获取全部病案流程，结束循环并返回当前结果集
				if (isChoice == false) {
					return (CiMrmProcedureListDTO[]) ciMrmProcedureListDTO.toArray(new CiMrmProcedureListDTO[ciMrmProcedureListDTO.size()]);
				}
				// 循环完成后判断集合ciMrmProcedureListDTO长度是否与集合CMPList相同，来决定是否退出循环
				if (ciMrmProcedureListDTO.size() == CMPList.size()) {
					isFinish = false;
				} else if (ciMrmProcedureListDTO.size() > CMPList.size()) {
					throw new BizException(sb.toString());
				}
			}
		}
		return (CiMrmProcedureListDTO[]) ciMrmProcedureListDTO.toArray(new CiMrmProcedureListDTO[ciMrmProcedureListDTO.size()]);
	}
	/**
	 * getProcessNameDTOList方法查询sql
	 * @param 
	 * @return StringBuilder
	 */
	private StringBuilder getMrmProcessNameQuerySql(String sqlWhere) {
		StringBuilder sql = new StringBuilder();

		sql.append(" select bd_mrm_op.id_bd_mrm_ot_cu as id_bd_mrm_ot_cu,\n ");// 当前流程id
		sql.append(" bd_mrm_op.fg_start as fg_start,\n ");// 是否是起始流程
		sql.append(" bd_mrm_op.fg_end as fg_end,\n ");// 是否是结束流程
		sql.append(" bd_mrm_ot1.name as name_bd_mrm_ot_cu,\n ");// 当前流程名称
		sql.append(" bd_mrm_op.id_bd_mrm_ot_fw as id_bd_mrm_ot_fw,\n ");// 前进流程id
		sql.append(" bd_mrm_ot2.name as name_bd_mrm_ot_fw,\n ");// 前进流程名称
		sql.append(" bd_mrm_op.id_bd_mrm_ot_bo as id_bd_mrm_ot_bo,\n ");// 回退流程id
		sql.append(" bd_mrm_ot3.name as name_bd_mrm_ot_bo\n ");// 回退流程名称
		sql.append(" from bd_mrm_op bd_mrm_op\n ");
		sql.append(" left join bd_mrm_ot bd_mrm_ot1\n ");
		sql.append(" on bd_mrm_op.id_bd_mrm_ot_cu = bd_mrm_ot1.id_bd_mrm_ot\n ");
		sql.append(" left join bd_mrm_ot bd_mrm_ot2\n ");
		sql.append(" on bd_mrm_op.id_bd_mrm_ot_fw = bd_mrm_ot2.id_bd_mrm_ot\n ");
		sql.append(" left join bd_mrm_ot bd_mrm_ot3\n ");
		sql.append(" on bd_mrm_op.id_bd_mrm_ot_bo = bd_mrm_ot3.id_bd_mrm_ot\n ");
		sql.append(" where bd_mrm_op.id_org = '"+Context.get().getOrgId()+"' ");
		
		return sql;
	}
	
	/**
	 * 病案示踪控件-已完成流程信息显示查询
	 * @return CiMrmProcedureListDTO[]
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public CiMrmProcedureListDTO[] getProcessInfoDTOList(String id_amr) throws BizException {
		StringBuilder sqlWhere = new StringBuilder();
		// 根据当前病案号条件查询对应的病案操作数据
		sqlWhere.append(" where ci_mrm_op.id_amr = '");
		sqlWhere.append(id_amr);
		sqlWhere.append("' ");
		// 调用sql方法
		StringBuilder sql = getMrmProcessInfoQuerySql(sqlWhere.toString());
		String sqlStr = sql.toString();

		DAFacade daf = new DAFacade();
		List<CiMrmProcedureListDTO> CMPList = 
				(List<CiMrmProcedureListDTO>) daf.execQuery(sqlStr, new BeanListHandler(CiMrmProcedureListDTO.class));
		
		if (CMPList == null) {
			return null;
		}
		
		CiMrmProcedureListDTO[] CMPArray = (CiMrmProcedureListDTO[]) CMPList.toArray(new CiMrmProcedureListDTO[CMPList.size()]);
		return CMPArray;
	}
	/**
	 * getProcessInfoDTOList方法查询sql
	 * @param sqlwhere
	 * @return StringBuilder
	 */
	private StringBuilder getMrmProcessInfoQuerySql(String sqlwhere) {
		StringBuilder sql = new StringBuilder();

		sql.append(" select ci_mrm_op.id_amr as id_amr,\n ");// 
		sql.append(" ci_mrm_op.id_psn_op as id_psn_op,\n ");// 
		sql.append(" bd_psndoc.name as name_psn_op,\n ");// 
		sql.append(" ci_mrm_op.id_bd_mrm_ot as id_bd_mrm_ot_cu,\n ");// 
		sql.append(" bd_mrm_ot.name as name_bd_mrm_ot_cu,\n ");// 
		sql.append(" bd_mrm_ot.code as sd_bd_mrm_ot_cu,\n ");// 
		sql.append(" ci_mrm_op.dt_op as dt_op\n ");// 
		sql.append(" from ci_mrm_op ci_mrm_op\n ");
		sql.append(" left join bd_psndoc bd_psndoc\n ");
		sql.append(" on ci_mrm_op.id_psn_op = bd_psndoc.id_psndoc\n ");
		sql.append(" left join bd_mrm_ot bd_mrm_ot\n ");
		sql.append(" on ci_mrm_op.id_bd_mrm_ot = bd_mrm_ot.id_bd_mrm_ot\n ");
		sql.append(" left join bd_udidoc bd_udidoc\n ");
		sql.append(" on ci_mrm_op.id_optp = bd_udidoc.id_udidoc\n ");
		sql.append(sqlwhere);
		
		return sql;
	}
}
