package iih.bd.srv.s.bp.qry;

/**
 * @author hums
 *
 */
public class GetModuleInfoBPSql {

	/**
	 * 获取查询领域模型属性sql语句
	 * @return
	 */
	public String getPropertySql(){
		// PropertyDO
		return "select * from dm_property where classid = ? order by seqno";
		
	}
	
	/**
	 * 获取枚举类型语句
	 * @return
	 */
	public String getEnumValueDOSql(){
		// fullclassname = iih.ci.ord.srvref.d.SrvRefRelInfoType
		return "select *  from dm_enumvalue where id = ? order by seqno";
	}
}
