package iih.sc.apt.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**获取医技预约所需所有数据
 * @author ccj
 *
 */
public class GetAptmtSchBp {
	
	/**获取医技预约所需所有数据 
	 * @param beginDate  开始时间
	 * @param endData  结束时间
	 * @param id_dep  部门id
	 * @param sd_scchltp 渠道类型编码
	 * @param id_srv 医疗服务id
	 * @return 医技预约排班情况显示数据
	 * @throws BizException
	 */
	public List exec(String beginDate,String endData,String id_dep,String sd_scchltp,String id_srv) throws BizException{
		if(StringUtils.isBlank(id_dep) || StringUtils.isBlank(endData) || StringUtils.isBlank(beginDate)) return null;
		StringBuffer sb = new StringBuffer();
		SqlParam param = new SqlParam();
		sb.append("select sch.id_sch,res.name as resname,srv.name as srvname,dl.name as dayslotnsname,dl.id_dayslot,pl.sd_tickmd as sd_md,pl.id_scsrv,sch.d_sch,");
		sb.append("sch.id_dayslot,sch.quan_total,sch.quan_total_appt,sch.quan_total_used,sch_chl.scpolcn as scpolcn_number ,sch.* ");
		sb.append("from sc_sch sch ");
		sb.append(" inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		if(StringUtils.isNotEmpty(id_srv)){
			sb.append(" inner join sc_tick tick on sch.id_sch = tick.id_sch  ");
			sb.append(" inner join sc_srv_rel rel on rel.id_scsrv = tick.id_scsrv and rel.id_mdsrv = ?  ");
			param.addParam(id_srv);
		}
		sb.append(" inner join sc_sch_chl sch_chl on sch_chl.id_sch = sch.id_sch ");
		sb.append(" inner join SC_CHL sc_chl on sch_chl.id_scchl = sc_chl.id_scchl and sc_chl.sd_scchltp = ? ");
		sb.append(" inner join sc_res res on res.id_scres = pl.id_scres and res.ds = 0 ");
		sb.append("inner join sc_srv srv on srv.id_scsrv = pl.id_scsrv and srv.ds = 0 ");
		sb.append("inner join bd_dayslot dl on dl.id_dayslot  = sch.id_dayslot ");
		sb.append("where sch.ds = 0 and pl.id_dep = ? ");
		sb.append("and sch.d_sch >= ? ");
		sb.append("and sch.d_sch <= ? ");
		param.addParam(sd_scchltp);
		param.addParam(id_dep);
		param.addParam(beginDate);
		param.addParam(endData);
		List list = (List) new DAFacade().execQuery(sb.toString(), param, new MapListHandler());
		return list;
	}
}
