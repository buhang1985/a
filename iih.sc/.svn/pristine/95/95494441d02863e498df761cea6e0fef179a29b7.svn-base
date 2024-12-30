package iih.sc.apt.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**获取门诊预约 自绘html所需
 * @author ccj
 *
 */
public class GetAptOpSchListBP {
	
	/**获取门诊预约所需所有数据
     * @param beginDate  开始时间
     * @param endDate	结束时间 
     * @param id_dep 部门id
     * @param id_scsrv  服务id
     * @param id_scres  资源id
     * @param sd_sctp 排班类型编码
     * @throws BizException
     */
	public List exec(String sd_sctp,String beginDate, String endDate, String id_dep, String id_scsrv,String id_scres) throws BizException{
		if(StringUtils.isBlank(beginDate) || StringUtils.isBlank(endDate) || StringUtils.isEmpty(id_dep) ) return null;
		SqlParam sqlParam = new SqlParam();
		StringBuilder sql = new StringBuilder("select res.name as resname, srv.name as srvname,dl.name as dayslotnsname");
		sql.append(",dl.id_dayslot,pl.sd_tickmd as sd_md ,res.sd_screstp,sch.*,pl.id_scsrv");
		sql.append(" from sc_sch sch ");
		sql.append(" left join sc_pl pl on sch.id_scpl = pl.id_scpl and pl.ds = 0 ");
		sql.append(" left join sc_res res ");
		sql.append(" on res.id_scres = pl.id_scres and res.ds = 0 ");
		sql.append(" left join sc_srv srv ");
		sql.append(" on srv.id_scsrv = pl.id_scsrv and srv.ds=0 ");
		sql.append(" left join bd_dayslot dl on dl.id_dayslot  = sch.id_dayslot ");
		sql.append(" where sch.ds = 0 and  sch.d_sch>= ? ");
		sqlParam.addParam(beginDate);
		sql.append(" and  sch.d_sch<= ? ");
		sqlParam.addParam(endDate);
		sql.append(" and pl.id_dep= ? ");
		sqlParam.addParam(id_dep);
		if(!StringUtils.isEmpty(id_scsrv)){
			sql.append(" and pl.id_scsrv = ? ");
			sqlParam.addParam(id_scsrv);
		}
		if(!StringUtils.isEmpty(id_scres)){
			sql.append(" and pl.id_scres = ? ");
			sqlParam.addParam(id_scres);
		}
		if(!StringUtils.isEmpty(sd_sctp)){
			sql.append(" and sch.sd_sctp = ? ");
			sqlParam.addParam(sd_sctp);
		}
		List list = (List) new DAFacade().execQuery(sql.toString(),sqlParam,new MapListHandler());
		return list;
	}
}
