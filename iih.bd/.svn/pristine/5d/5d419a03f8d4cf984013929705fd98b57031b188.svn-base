package iih.bd.mm.webserviceinvokerec.bp.sql;

public class FindByQrySql {
	
	private String wherePart;
	
	public FindByQrySql(String _wherePart){
		this.wherePart = _wherePart;
	}
	
	public String getSql(){
		String baseSql = getBaseSql();
		return String.format("%s where %s", baseSql, wherePart);
	}

	public String getBaseSql() {
		StringBuffer baseSql = new StringBuffer();
		baseSql.append(" select a1.webserviceid, ");
		baseSql.append(" a1.ser_interface, ");
		baseSql.append(" a1.call_time, ");
		baseSql.append(" a1.return_time, ");
		baseSql.append(" a1.call_content,");
		baseSql.append(" a1.return_content");
		baseSql.append(" from SYS_LOG_WEBSERVICE a1 ");
		
		return baseSql.toString();
	}
}
