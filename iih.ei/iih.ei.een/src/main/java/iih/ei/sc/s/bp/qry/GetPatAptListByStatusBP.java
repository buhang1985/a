package iih.ei.sc.s.bp.qry;

import java.util.List;

import iih.ei.sc.ws.bean.GetPatAptListBean;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPatAptListByStatusBP {

	public GetPatAptListBean[] exec(String patCode,String beginDate,String endDate,String chlType,String aptStatus) throws BizException{
		
  		//this.validData(beginDate, endDate);
 		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("  select apt.id_apt as idApt,")
		.append(" pat.code as patCode,")
		.append(" pat.name as patName,")
		.append(" appl.code_entp as enTpCode,")
		.append(" ca.name as patCa,")
		.append(" dep.code as deptCode,")
		.append(" dep.name as deptName,")
		.append(" srv.code as srvCode,")
		.append(" srv.name as srvName,")
		.append(" res.code as resCode,")
		.append(" res.name as resName,")
		.append(" substr(apt.dt_b,0,10) as entTime,")
		.append(" apt.dt_b as beginTime,")
		.append(" apt.dt_e as endTime,")
		.append(" apt.dt_appt as oprTime,")
		.append(" dayslot.sd_dayslottp as dayslottp,")
		.append("  apt.queno as seqNo,")
		.append(" (case  appl.fg_bl when 'Y' then 1 when 'N' then 0 else null end) as feeStatus ,")
		.append(" apt.sd_status as status,")
		.append(" apt.code as aptCode,")
		.append(" ben.des as address,")
		.append("  (case pat.mob when null then pat.tel else pat.mob end) as mobile,")
		.append(" chl.name as chlTypeName,chl.code as chlTypeCode,")
		.append(" appl.id_aptappl as idaptappl,")
		.append(" appl.dt_effe_or as dtEffeOr,")
		.append(" appl.applyno as applyNo,")
		.append(" appl.name as applName,")
		.append(" bdsrv.name as applSrvName")
		.append(" from sc_apt apt")
		.append(" inner join pi_pat pat on apt.id_pat = pat.id_pat")
		.append(" inner join pi_pat_ca ca on pat.id_paticate = ca.id_patca")
		.append(" inner join bd_dep dep on dep.id_dep = apt.id_dep_appt ")
		.append(" inner join sc_srv srv on apt.id_scsrv = srv.id_scsrv")
		.append(" inner join sc_res  res on apt.id_scres = res.id_scres")
		.append(" inner join bd_dayslot dayslot on dayslot.id_dayslot  = apt.id_dateslot")
		.append(" inner join sc_chl chl on apt.id_scchl  = chl.id_scchl")
		.append(" inner join sc_apt_appl appl on apt.id_apt = appl.id_scapt")
		.append(" inner join sc_sch sch on apt.id_sch = sch.id_sch")
		.append(" inner join sc_pl pl on pl.id_scpl = sch.id_scpl")
		.append(" inner join bd_que_ben ben on pl.id_queben = ben.id_queben")
		.append(" left outer join bd_srv bdsrv on appl.id_srv=bdsrv.id_srv")
		.append(" where appl.fg_canc = 'N' and apt.sd_sctp = '03'");
		if(!StringUtil.isEmpty(patCode)){
			param.addParam(patCode);
			sqlBuilder.append(" and pat.code = ?");
		}
		
		if(!StringUtil.isEmpty(chlType)){
			param.addParam(chlType);
			sqlBuilder.append(" and   chl.code = ?");
		}
		if(!StringUtil.isEmpty(beginDate) || !StringUtil.isEmpty(endDate)){
			param.addParam(beginDate);
			param.addParam(endDate);
			sqlBuilder.append(" and apt.dt_b >= ?");
			sqlBuilder.append(" and apt.dt_e <= ?");
		}
		if(!StringUtil.isEmpty(aptStatus)){
			String[] statusArr = aptStatus.split(",");
			String statusCondition = this.buildIdStr(statusArr);
			sqlBuilder.append(" and apt.sd_status in (").append(statusCondition).append(")");
		}
		sqlBuilder.append(" order by apt.sv desc");
		
		List<GetPatAptListBean> list = (List<GetPatAptListBean>) new DAFacade().execQuery(sqlBuilder.toString(),param,new BeanListHandler(GetPatAptListBean.class));
		return ListUtil.isEmpty(list)?null:list.toArray(new GetPatAptListBean[0]);
		
	}
	/**
	 * 校验数据
	 * @param beginDate
	 * @param endDate
	 * @throws BizException
	 * @auther yaohl
	 * @date 2018年10月30日
	 */
	private void validData (String beginDate,String endDate) throws BizException{
		if(StringUtil.isEmpty(beginDate)){
			throw new BizException("查询患者医技预约记录失败：开始时间不能为空");
		}
		if(StringUtil.isEmpty(endDate)){
			throw new BizException("查询患者医技预约记录失败：结束时间不能为空");
		}
	}
	
	/**
	 * 生成id的查询串
	 * 
	 * @param ids id集合
	 * @return
	 */
	private String buildIdStr(String[] ids) {
		if (ArrayUtil.isEmpty(ids)) {
			return null;
		}

		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String id : ids) {
			if (StringUtil.isEmpty(id)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", id));
		}

		return builder.toString();
	}
}
