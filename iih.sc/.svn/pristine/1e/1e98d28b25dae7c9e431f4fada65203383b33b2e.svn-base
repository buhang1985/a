package iih.sc.sch.s.bp.op;

import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.SchCancDTO;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.SchPlEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取科室除本排班外的其他排班信息BP
 * 
 * @author zhengcm
 * @date 2017-11-17 11:28:45
 *
 */
public class GetOpSchCancDeptSchInfoBP {

	/**
	 * 获取科室除本排班外的其他排班信息
	 * 
	 * @author zhengcm
	 * @date 2017-11-17 11:29:39
	 *
	 * @param id_dept
	 * @param id_sch
	 * @param d_sch
	 * @param fg_origin_scres
	 * @param fg_origin_scsrv
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public SchCancDTO[] exec(String id_dept, String id_sch, FDate d_sch, FBoolean fg_origin_scres,
			FBoolean fg_origin_scsrv) throws BizException {
		// 参数校验
		ScValidator.validateParam("id_dept", id_dept);
		ScValidator.validateParam("id_sch", id_sch);
		ScValidator.validateParam("d_sch", d_sch);
		ScValidator.validateParam("fg_origin_scres", fg_origin_scres);
		ScValidator.validateParam("fg_origin_scsrv", fg_origin_scsrv);

		// 当前科室可预约的午别
		List<String> dayslotIdList = new GetDeptCanAptDayslotBP().exec(id_dept, d_sch);

		// 查询数据
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("pl.name as name_scpl,");
		sb.append("lot.name as name_dayslot,");
		sb.append("sch.quan_total_appt,");
		sb.append("(decode(sch.quan_total_appt,null,0,sch.quan_total_appt) - decode(sch.quan_total_used,null,0,sch.quan_total_used)) as quan_total_left,");
		sb.append("(decode(sch.quan0_appt,null,0,sch.quan0_appt) - decode(sch.quan0_used,null,0,sch.quan0_used)) as quan0_left,");
		sb.append("(decode(sch.quan1_appt,null,0,sch.quan1_appt) - decode(sch.quan1_used,null,0,sch.quan1_used)) as quan1_left,");
		sb.append("(decode(sch.quan2_appt,null,0,sch.quan2_appt) - decode(sch.quan2_used,null,0,sch.quan2_used)) as quan2_left,");
		sb.append("(decode(sch.quan3_appt,null,0,sch.quan3_appt) - decode(sch.quan3_used,null,0,sch.quan3_used)) as quan3_left,");
		sb.append("(decode(sch.quan4_appt,null,0,sch.quan4_appt) - decode(sch.quan4_used,null,0,sch.quan4_used)) as quan4_left,");
		sb.append("(decode(sch.quan5_appt,null,0,sch.quan5_appt) - decode(sch.quan5_used,null,0,sch.quan5_used)) as quan5_left,");
		sb.append("(decode(sch.quan6_appt,null,0,sch.quan6_appt) - decode(sch.quan6_used,null,0,sch.quan6_used)) as quan6_left,");
		sb.append("(decode(sch.quan7_appt,null,0,sch.quan7_appt) - decode(sch.quan7_used,null,0,sch.quan7_used)) as quan7_left,");
		sb.append("(decode(sch.quan8_appt,null,0,sch.quan8_appt) - decode(sch.quan8_used,null,0,sch.quan8_used)) as quan8_left,");
		sb.append("(decode(sch.quan9_appt,null,0,sch.quan9_appt) - decode(sch.quan9_used,null,0,sch.quan9_used)) as quan9_left ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append("where ");
		sb.append("sch.fg_active = 'Y' ");
		sb.append("and pl.id_dep = ? ");
		sb.append("and sch.id_sch <> ? ");
		sb.append("and sch.d_sch = ? ");
		if (!ListUtil.isEmpty(dayslotIdList)) {
			sb.append("and " + ScSqlUtils.getInSqlByIds("lot.id_dayslot", dayslotIdList) + " ");
		} else {
			sb.append("and 1 = 2 ");
		}
		SqlParam params = new SqlParam();
		params.addParam(id_dept);
		params.addParam(id_sch);
		params.addParam(d_sch);
		if (fg_origin_scres.booleanValue() || fg_origin_scsrv.booleanValue()) {
			ScSchDO schDO = new SchEP().getById(id_sch);
			ScPlanDO planDO = new SchPlEP().getScPl(schDO.getId_scpl());
			if (null != planDO) {
				if (fg_origin_scres.booleanValue()) {
					sb.append("and pl.id_scres = ? ");
					params.addParam(planDO.getId_scres());
				}
				if (fg_origin_scsrv.booleanValue()) {
					sb.append("and pl.id_scsrv = ? ");
					params.addParam(planDO.getId_scsrv());
				}
			}
		}
		sb.append("order by sch.id_sch ");
		List<SchCancDTO> list = (List<SchCancDTO>) new DAFacade().execQuery(sb.toString(), params, new BeanListHandler(
				SchCancDTO.class));
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return list.toArray(new SchCancDTO[0]);
	}

}
