package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpTotalInfoDTO;

import java.util.List;

import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊工作量BP
 * 
 * @author jizb
 *
 */
public class GetOpTotalInfoBP {

	/**
	 * 获取门诊工作量
	 * 
	 * @param depId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws DAException
	 */
	public OpTotalInfoDTO[] exec(String depId, FDate beginDate, FDate endDate) throws DAException {
		if (beginDate == null || endDate == null || beginDate.compareTo(endDate) == 1) {
			return null;
		}
		SqlParam param = new SqlParam();
		String sql = getSql(depId, beginDate, endDate, param);

		@SuppressWarnings("unchecked")
		List<OpTotalInfoDTO> list = (List<OpTotalInfoDTO>)new DAFacade().execQuery(sql, param, new BeanListHandler(OpTotalInfoDTO.class));
		return list.toArray(new OpTotalInfoDTO[0]);
	}
	
	/**
	 * 拼接sql
	 * 
	 * @return
	 */
	private String getSql(String depId, FDate beginDate, FDate endDate, SqlParam param){
		StringBuilder sb = new StringBuilder();
		sb.append(" select bddep.id_dep as id_dep_phy, ");//科室id
		sb.append(" bddep.name as name_dep_phy, ");//科室名称
		sb.append(" bddep.code as Sd_dep_phy, ");//科室编码，fanlq-2018-10-17
		sb.append(" substr(ent.dt_insert, 0, 10) as dt_statist, ");//时间
		sb.append(" srvtp.name as name_svrtp , ");//挂号类型
		sb.append(" count(*) as num_acpt ");//工作量
		sb.append(" from en_ent ent ");
		sb.append(" inner join en_ent_op op on ent.id_ent = op.id_ent");
		//sb.append(" inner join en_ent_dep dep on op.id_ent = dep.id_ent and dep.fg_admit = 'N' ");
		sb.append(" inner join bd_udidoc srvtp on srvtp.id_udidoc = op.id_svrtp ");//挂号类别，fanlq-2018-10-26
		//sb.append(" left join bd_srv srv on op.sd_svrtp = srv.sd_srvtp ");
		sb.append(" left join bd_dep bddep on bddep.id_dep = ent.id_dep_phy ");
		sb.append(" where ent.dt_insert >= ? " );
		param.addParam(beginDate + " 00:00:00");
		sb.append(" and ent.dt_insert <= ? " );
		param.addParam(endDate + " 23:59:59");
		if (!EnValidator.isEmpty(depId)) {
			sb.append(" and bddep.id_dep = ? ");
			param.addParam(depId);
		}
		sb.append(" and ent.fg_canc = ? ");
		param.addParam(FBoolean.FALSE);
		sb.append(" group by substr(ent.dt_insert, 0, 10), srvtp.name, bddep.id_dep,bddep.name,bddep.code");
		sb.append(" order by dt_statist");
		return sb.toString();
	}
}
