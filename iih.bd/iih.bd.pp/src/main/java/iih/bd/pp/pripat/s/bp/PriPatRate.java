package iih.bd.pp.pripat.s.bp;

public class PriPatRate {
	public String GetPriPatRateSql()
	{
		String sql="select rate from bd_pri_pat where id_pripat=?";
		return sql.toString();
	}

}
