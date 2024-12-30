package iih.sc.apt.s.bp;

import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预约检查BP：同一患者同一计划同一日期不能重复预约
 * 
 * @author zhengcm
 * @date 2017-05-22 11:31:38
 *
 */
public class AptCheckBP {

	/**
	 * 校验患者是否在同一计划同一日期有重复预约
	 *
	 * @param id_pat
	 * @param id_sch
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	public void exec(String id_pat, String id_sch) throws BizException {
		// 检查参数
		ScValidator.validateParam("id_pat", id_pat);
		ScValidator.validateParam("id_sch", id_sch);

		// 排班DO
		ScSchDO schDO = new OralAptEP().getSch(id_sch);
		if (null == schDO) {
			throw new BizException("排班不存在！");
		}

		// 排班计划
		ScPlanDO plDO = new OralAptEP().getScPlan(schDO.getId_scpl());
		if (null == plDO) {
			throw new BizException("排班计划不存在！");
		}

		// 查询Sql
		StringBuilder sql = this.getSql();

		// 查询参数
		SqlParam params = new SqlParam();
		params.addParam(schDO.getD_sch());
		// params.addParam(schDO.getId_dayslot());
		params.addParam(schDO.getId_scpl());
		// params.addParam(plDO.getId_scres());
		params.addParam(id_pat);

		// 查询数据
		List<ScAptDO> datas = (List<ScAptDO>) new DAFacade().execQuery(sql.toString(), params, new BeanListHandler(
				ScAptDO.class));

		// 校验
		if (!ListUtil.isEmpty(datas)) {
			throw new BizException("同一计划同一日期不能重复预约！");
		}
	}

	/**
	 * 查询预约Sql
	 *
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql() throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select * ");
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("inner join sc_sch sch on sch.id_sch = apt.id_sch ");
		// sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		// sb.append("inner join sc_res res on res.id_scres = pl.id_scres ");
		sb.append("where ");
		sb.append("apt.fg_canc = 'N' ");
		sb.append("and sch.d_sch = ? ");
		// sb.append("and sch.id_dayslot = ? ");
		sb.append("and sch.id_scpl = ? ");
		// sb.append("and res.id_scres = ? ");
		sb.append("and apt.id_pat = ? ");
		return sb;
	}
}
