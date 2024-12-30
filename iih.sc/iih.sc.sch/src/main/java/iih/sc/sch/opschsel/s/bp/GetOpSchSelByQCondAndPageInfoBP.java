package iih.sc.sch.opschsel.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.sch.dto.d.OpSchSelDTO;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门急诊排班查询
 * @author ltf
 *
 */
public class GetOpSchSelByQCondAndPageInfoBP {

	/**
	 * 门急诊排班查询
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 * @author ltf
	 */
	public PagingRtnData<OpSchSelDTO> exec(OpSchSelDTO OpSchSelDTO, PaginationInfo pg) throws BizException {

		PagingServiceImpl<OpSchSelDTO> pageQryService = new PagingServiceImpl<OpSchSelDTO>();
		SqlParam param = new SqlParam();
		String sql = this.getQrySQLStr(OpSchSelDTO, param);
		PagingRtnData<OpSchSelDTO> datas = pageQryService.findByPageInfo(new OpSchSelDTO(), pg, sql,
				"", param);
		this.processDatas(datas);
		return datas;
	}

	/**
	 * 处理数据
	 * @param datas
	 * @author ltf
	 */
	private void processDatas(PagingRtnData<OpSchSelDTO> datas) {
		if (datas == null || datas.getPageData() == null) {
			return;
		}
	}
	
	/**
	 * 获取sql
	 * @param opSchSelDTO
	 * @param param
	 * @return
	 * @author ltf
	 */
	private String getQrySQLStr(OpSchSelDTO opSchSelDTO, SqlParam param) {
		StringBuilder sb = new StringBuilder();
		sb.append("select rownum as sortno,a.* from ( ");
		sb.append("select sch.d_sch, ");  // 排班日期
		sb.append("t_b_acpt, ");  // 开始就诊时间
		sb.append("t_e_acpt, ");  // 结束就诊时间
		sb.append("sch.id_sch, ");  // 排班
		sb.append("pl.name as name_scpl, ");  // 排班计划名称
		sb.append("pl.id_dep, ");  // 计划科室部门
		sb.append("dep.name as name_dep, ");
		sb.append("bd.name as name_dayslot, ");  // 午别名称
		sb.append("res.name as name_scres, ");  // 排班资源名称 
		sb.append("srv.name as name_scsrv, ");  // 排班服务名称
		sb.append("pl.id_queben, ");  // 分诊台
		sb.append("sch.scpolcn, ");  // 号源池总数
		sb.append("sch.max_num_add, ");  // 最大加号数
		sb.append("sch.quan_total, ");  // 总号源数
		sb.append("sch.quan_total_appt, ");  // 开发号源数
		sb.append("sch.quan_total_used, ");  // 使用号源数
		sb.append("ca.name as name_scca, ");  // 排班分类名称
		sb.append("udidoc.name as name_sctp, ");  // 排班类型名称
		sb.append("qb.name as name_queben, ");  // 分诊台
		sb.append("pl.code as code_pl, ");  // 计划编码
		sb.append("sch.fg_active ");  // 状态
		sb.append("from sc_sch sch ");
		sb.append("left join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("left join bd_dayslot bd on bd.id_dayslot = sch.id_dayslot ");
		sb.append("left join sc_res res on res.id_scres = pl.id_scres ");
		sb.append("left join sc_srv srv on srv.id_scsrv = pl.id_scsrv ");
		sb.append("left join bd_dep dep on dep.id_dep = pl.id_dep ");
		sb.append("left join bd_que_ben qb on qb.id_queben = pl.id_queben ");
		sb.append("left join sc_ca ca on ca.id_scca = sch.id_scca ");
		// 排班渠道
		if(!StringUtil.isEmptyWithTrim(opSchSelDTO.getId_scchl())){
			sb.append("left join sc_sch_chl chl on chl.id_sch = sch.id_sch ");
		}
		sb.append("left join bd_udidoc udidoc on udidoc.id_udidoc = sch.id_sctp ");
		sb.append("where sch.sd_sctp in (?, ?)");
		// 门诊
		param.addParam(IScDictCodeConst.SD_SCTP_OP);
		// 急诊
		param.addParam(IScDictCodeConst.SD_SCTP_JZ);
		  // 排班开始日期
		  if(opSchSelDTO.getStart_sch() != null){
			  sb.append("and sch.d_sch >= ? ");
			  param.addParam(opSchSelDTO.getStart_sch().toStdString());
		  }
		  // 排班结束时间
		  if(opSchSelDTO.getEnd_sch() != null){
			  sb.append("and sch.d_sch <= ? ");
			  param.addParam(opSchSelDTO.getEnd_sch().toStdString());
		  }
		  // 排班科室
		if (!StringUtil.isEmptyWithTrim(opSchSelDTO.getId_dep())) {
			sb.append("and dep.id_dep = ? ");
			param.addParam(opSchSelDTO.getId_dep());
		  }
		  // 排班资源
		if (!StringUtil.isEmptyWithTrim(opSchSelDTO.getId_scres())) {
			sb.append("and res.id_scres = ? ");
			param.addParam(opSchSelDTO.getId_scres());
		  }
		  // 状态
			  sb.append("and sch.fg_active = ? ");
		if(opSchSelDTO.getFg_active() != null && opSchSelDTO.getFg_active().equals(FBoolean.TRUE)){
			param.addParam(FBoolean.FALSE);
		} else {
			param.addParam(FBoolean.TRUE);
		  }
		  // 排班服务
		if (!StringUtil.isEmptyWithTrim(opSchSelDTO.getId_scsrv())) {
			sb.append("and srv.id_scsrv = ? ");
			param.addParam(opSchSelDTO.getId_scsrv());
		  }
		  // 午别
		if (!StringUtil.isEmptyWithTrim(opSchSelDTO.getId_dayslot())) {
			sb.append("and bd.id_dayslot = ? ");
			param.addParam(opSchSelDTO.getId_dayslot());
		  }
		  // 排班计划
		if (!StringUtil.isEmptyWithTrim(opSchSelDTO.getId_scpl())) {
			sb.append("and pl.id_scpl = ? ");
			param.addParam(opSchSelDTO.getId_scpl());
		  }
		  // 分诊台
		if (!StringUtil.isEmptyWithTrim(opSchSelDTO.getId_queben())) {
			sb.append("and qb.Id_queben = ? ");
			param.addParam(opSchSelDTO.getId_queben());
		}
		// 排班渠道
		if(!StringUtil.isEmptyWithTrim(opSchSelDTO.getId_scchl())){
			sb.append("and chl.id_scchl = ?");
			param.addParam(opSchSelDTO.getId_scchl());
		  }
		// 组织管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch"));

		sb.append(" order by sch.d_sch,name_dayslot) a ");
		  return sb.toString();
	}
}
