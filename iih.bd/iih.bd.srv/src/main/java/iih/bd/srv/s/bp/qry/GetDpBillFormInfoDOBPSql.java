package iih.bd.srv.s.bp.qry;

/**
 * @author hums
 *
 */
public class GetDpBillFormInfoDOBPSql {

	/**
	 * 获取查询表达实体sql语句
	 * @return
	 */
	public String getBillFormDOSql(){
		
		return "select * from dp_billform where metadataclass = ? order by sv";
		
	}
}
