package iih.ci.ord.s.bp.orsms.lis.mergetube;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 采集费对应的医嘱是否还存在
 * @author zhangwq
 *
 */
public class SampcolOrdersBP {
	public CiOrderDO[] exec(String[] id_ors) throws DAException{
		String sql = "select distinct c1.id_or, c1.name_or "+
				    "from ci_order c1 "+
				   "inner join bd_samp_pri_itm itm1 "+
				   "   on c1.id_srv = itm1.id_srv "+
				   "inner join bd_samp_pri pri "+
				   "on itm1.id_samp_pri=pri.id_samp_pri "+
				   "inner join ci_order c2 "+
				   "   on c2.id_srv = pri.id_srv "+
				  " where c2.fg_sign = 'Y' "+
				   "  and c2.fg_canc = 'N' "+
				   "  and c2.sd_su_bl <> '2' "+
				   "  and c1.id_en = c2.id_en and c1.id_or in ('"+CiOrdUtils.ConcatInSqlMark(id_ors)+"') ";
		SqlParam param = new SqlParam();
		List<CiOrderDO> ciOrders = (List<CiOrderDO>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(CiOrderDO.class));
		if(ciOrders!=null && ciOrders.size()>0){
			return ciOrders.toArray(new CiOrderDO[0]);
		}
		return null;
	}
}
