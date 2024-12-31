package iih.ei.sc.s.bp.qry;

import java.util.List;

import iih.ei.sc.ws.bean.GetBrokenAptListBean;
import iih.ei.sc.ws.bean.GetStopSchListBean;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetStopSchListBP {

	/**
	 * 获取医技停诊列表
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return
	 */
	public GetStopSchListBean[] exec(String beginDate,String endDate) throws BizException {
		
		this.validData(beginDate, endDate);
		
		StringBuilder sql = new StringBuilder();
		sql.append("  select ");
		sql.append(" sch.id_sch as idSch,");
		sql.append(" sch.d_sch as schDate,");
		sql.append(" pl.id_dep as deptCode,");
		sql.append(" dep.name as deptName,");
		sql.append(" res.name as resName,");
		sql.append(" res.code as resCode,");
		sql.append(" srv.name as srvName,");
		sql.append(" srv.code as srvCode,");
		sql.append(" days.sd_dayslottp as dayslottp,");
		sql.append(" days.name as ampm,");
		sql.append(" (sch.quan_total_appt - sch.quan_total_used) as remain,");
		sql.append(" pl.note as note,");
		sql.append(" '0' as fgActive");
		sql.append(" from sc_sch sch");
		sql.append(" inner join sc_pl pl on sch.id_scpl = pl.id_scpl");
		sql.append(" inner join bd_dep dep on dep.id_dep = pl.id_dep");
		sql.append(" inner join sc_res res on res.id_scres = pl.id_scres");
		sql.append(" inner join sc_srv srv on srv.id_scsrv = pl.id_scsrv");
		sql.append(" inner join bd_dayslot days on days.id_dayslot = sch.id_dayslot");
		sql.append(" where sch.fg_active = 'N'");
		sql.append(" and pl.sd_sctp = '03'");
		sql.append(" and sch.d_sch >= ? ");
		sql.append(" and sch.d_sch <= ? ");
		SqlParam param = new SqlParam();
		param.addParam(beginDate);
		FDate endFDate = new FDate(endDate).getDateAfter(1);
		param.addParam(endFDate.asBegin());
		List<GetStopSchListBean> list = (List<GetStopSchListBean>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(GetStopSchListBean.class));
		return ListUtil.isEmpty(list)?null:list.toArray(new GetStopSchListBean[0]);
	}
	
	/**
	 * 校验数据
	 * @param patCode
	 * @param eus_bbrtp
	 * @throws BizException
	 */
	private void validData(String beginDate,String endDate) throws BizException
	{
		if(StringUtil.isEmpty(beginDate))
		{
			throw new BizException("获取医技停诊列表失败:开始时间传入为空!");
		}
		if(StringUtil.isEmpty(endDate))
		{
			throw new BizException("获取医技停诊列表失败:结束时间传入为空!");
		}
	}
}
