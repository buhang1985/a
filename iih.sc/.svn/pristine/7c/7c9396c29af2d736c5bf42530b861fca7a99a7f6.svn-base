package iih.sc.apt.s.bp.op.qry;

import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.s.bp.CalcSchChlRemainBP;
import iih.sc.comm.ScValidator;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询门诊预约具体排班数据BP
 * 
 * @author zhengcm
 * @date 2017-01-06 15:21:13
 *
 */
public class GetOpResInfoBP {

	/**
	 * 查询门诊预约具体排班数据BP
	 *
	 * @param id_dept
	 * @param id_sch
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	public MtResDTO exec(String id_dept, String id_sch, String id_scchl) throws BizException {
		// 参数检查
		ScValidator.validateParam("id_dept", id_dept);
		ScValidator.validateParam("id_sch", id_sch);
		ScValidator.validateParam("id_scchl", id_scchl);

		// 查询数据
		StringBuilder sql = this.getSql();
		SqlParam params = new SqlParam();
		params.addParam(id_dept);
		params.addParam(id_scchl);
		params.addParam(id_sch);
		List<MtResDTO> mtAptDTOs = (List<MtResDTO>) new DAFacade().execQuery(sql.toString(), params,
				new BeanListHandler(MtResDTO.class));
		if (ListUtil.isEmpty(mtAptDTOs)) {
			return null;
		}
		// 计算渠道剩余可预约数
		new CalcSchChlRemainBP().exec(mtAptDTOs);
		return mtAptDTOs.get(0);
	}

	/**
	 * 查询Sql
	 *
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql() throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("sch.quan_total,");
		sb.append("sch.quan_total_appt,");
		sb.append("sch.quan_total_used,");
		sb.append("sch.fg_active,");
		sb.append("sch.id_dayslot,");
		sb.append("sch.quan0_appt,");
		sb.append("sch.quan1_appt,");
		sb.append("sch.quan2_appt,");
		sb.append("sch.quan3_appt,");
		sb.append("sch.quan4_appt,");
		sb.append("sch.quan5_appt,");
		sb.append("sch.quan6_appt,");
		sb.append("sch.quan7_appt,");
		sb.append("sch.quan8_appt,");
		sb.append("sch.quan9_appt,");
		sb.append("sch.quan0_used,");
		sb.append("sch.quan1_used,");
		sb.append("sch.quan2_used,");
		sb.append("sch.quan3_used,");
		sb.append("sch.quan4_used,");
		sb.append("sch.quan5_used,");
		sb.append("sch.quan6_used,");
		sb.append("sch.quan7_used,");
		sb.append("sch.quan8_used,");
		sb.append("sch.quan9_used,");
		sb.append("chl.id_scchl,");
		sb.append("chl.scpolcn,");
		sb.append("lot.code as sd_dayslot,");
		sb.append("lot.name as name_dayslot,");
		sb.append("pl.id_scpl,");
		sb.append("pl.name as name_scpl,");
		sb.append("pl.id_dep,");
		sb.append("pl.id_scsrv,");
		sb.append("pl.id_tickmd,");
		sb.append("pl.sd_tickmd,");
		sb.append("dep.name as name_dep,");
		sb.append("srv.name as name_scsrv,");
		sb.append("res.id_scres as id_res,");
		sb.append("res.name as name_res,");
		sb.append("res.code as code_res ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on sch.id_scpl = pl.id_scpl ");
		sb.append("inner join sc_res res on pl.id_scres = res.id_scres ");
		sb.append("inner join sc_sch_chl chl on chl.id_sch = sch.id_sch ");
		sb.append("inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append("inner join bd_dep dep on dep.id_dep = pl.id_dep ");
		sb.append("inner join sc_srv srv on srv.id_scsrv = pl.id_scsrv ");
		sb.append("where ");
		sb.append("pl.id_dep = ? ");
		sb.append("and chl.id_scchl = ? ");
		// sb.append("and pl.eu_edit_tp = '0' ");
		sb.append("and sch.id_sch = ? ");
		return sb;
	}
}
