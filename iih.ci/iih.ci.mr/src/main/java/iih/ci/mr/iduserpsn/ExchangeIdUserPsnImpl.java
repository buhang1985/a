package iih.ci.mr.iduserpsn;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

public class ExchangeIdUserPsnImpl implements ExchangeIdUserPsn{

	
	@Override
	public String getIdUserByIdPsn(String Id_psn) throws DAException{
		DAFacade daf = new DAFacade();
		String strSql = "select t.id_user from sys_user t where t.id_psn = '" + Id_psn + "'";
		return (String)daf.execQuery(strSql, new ColumnHandler());	    
	}

	@Override
	public String getIdPsnByIdUser(String Id_user) throws DAException {
		DAFacade daf = new DAFacade();
		String strSql = "select t.id_psn from sys_user t where t.id_user = '" + Id_user + "'";
		return (String)daf.execQuery(strSql, new ColumnHandler());
	}
	
}
