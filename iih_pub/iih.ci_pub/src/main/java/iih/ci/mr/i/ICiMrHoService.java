package iih.ci.mr.i;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;

/**
 * 病历住院综合接口
 * 通用的病历住院接口
 * @author    张静波
 * @version   2018-06-19
*/
public interface ICiMrHoService {

	/**
	 * 根据用户Id判断是否有处方权
	 * @param id_user
	 * @return
	 */
	public abstract FBoolean hasPresAuthorityByUser(String id_user)throws DAException;
	
	/**
	 * 根据人员Id判断是否有处方权
	 * @param id_user
	 * @return
	 */
	public abstract FBoolean hasPresAuthorityByPsn(String id_psn)throws DAException;
}
