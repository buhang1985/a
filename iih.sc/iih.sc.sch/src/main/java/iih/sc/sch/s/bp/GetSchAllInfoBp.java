package iih.sc.sch.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**获取排班完整信息-服务-资源-排班日期-日期分组
 * @author ccj
 *
 */
public class GetSchAllInfoBp {
	/**获取排班完整信息-服务-资源-排班日期-日期分组
	 * @param ids_sch 排班ids
	 * @return  满足条件的排班信息集合
	 * @throws BizException
	 */
	//TODO 建议可以使用GetResBySchmBP
	public List exec(String ids_sch)throws BizException{
		if(StringUtils.isEmpty(ids_sch)) return null;
		StringBuffer sbSql = new StringBuffer(); //sql语句
		sbSql.append("select srv.name as srv_name ,res.name as res_name,sch.d_sch,lot.name as lot_name,sch.id_dayslot from ");
		sbSql.append("(select d_sch,id_dayslot,id_scpl from sc_sch where id_sch in ("+ids_sch+")  and sc_sch.ds = 0 ) sch ");
		sbSql.append("left join sc_pl pl on sch.id_scpl = pl.id_scpl and pl.ds = 0 ");
		sbSql.append("left join sc_srv srv on pl.id_scsrv = srv.id_scsrv and srv.ds = 0 ");
		sbSql.append("left join sc_res res on res.id_scres = pl.id_scres and res.ds = 0 ");
		sbSql.append("left join bd_dayslot lot on sch.id_dayslot = lot.id_dayslot and lot.ds = 0 ");
		List list = (List) new DAFacade().execQuery(sbSql.toString(), new MapListHandler());
		return list;
	}

}
