package iih.ci.mr.iduserpsn;

import xap.sys.jdbc.facade.DAException;

public interface ExchangeIdUserPsn {

	/**
	 * 根据Id_psn获取 Id_user
	 * @param Id_psn
	 * @return String Id_user
	 */
	String getIdUserByIdPsn(String Id_psn) throws DAException;
	/**
	 * 根据Id_user 获取到 Id_psn
	 * @param Id_user 
	 * @return  String Id_psn
	 */
	String getIdPsnByIdUser(String Id_user) throws DAException;
	
}
