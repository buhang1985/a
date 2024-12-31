package iih.ei.sc.s.bp.qry;

import java.util.List;

import iih.ei.sc.ws.bean.GetPatAptListBean;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPatAptByIdAptBP {

	public GetPatAptListBean[] exec(String idApt) throws BizException{
		this.validData(idApt);
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
		.append(" apt.dt_appt as oprTime,")
		.append(" dayslot.sd_dayslottp as dayslottp,")
		.append("  apt.queno as seqNo,")
		.append(" (case  appl.fg_bl when 'Y' then 1 when 'N' then 0 else null end) as feeStatus ,")
		.append(" apt.sd_status as status,")
		.append(" apt.code as aptCode,")
		.append(" ben.des as address,")
		.append("  (case pat.mob when null then pat.tel else pat.mob end) as mobile,")
		.append(" chl.name as chlTypeName,chl.code as chlTypeCode")
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
		.append(" where appl.fg_canc = 'N' and apt.id_apt = ?");
		param.addParam(idApt);

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
	private void validData (String idApt) throws BizException{
		if(StringUtil.isEmpty(idApt)){
			throw new BizException("查询患者医技预约记录失败：预约ID不能未空");
		}
	}
}
