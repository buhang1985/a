package iih.bd.pp.accountsrv.i;

import iih.bd.pp.accountsrv.d.AccountSrvDO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 核算科目与收费项目字典接口
 * 
 * @author hao_wu 2020-2-14
 *
 */
public interface IAccountSrvMap {

	/**
	 * 获取医疗服务的指定核算体系
	 * 
	 * @param srvId   医疗服务主键
	 * @param accCaId 核算体系分类主键
	 * @return
	 */
	public abstract AccountSrvDO get(String srvId, String accCaId);

	/**
	 * 医疗服务的指定核算体系是否存在
	 * 
	 * @param srvId   医疗服务主键
	 * @param accCaId 核算体系分类主键
	 * @return
	 */
	public abstract FBoolean contains(String srvId, String accCaId);
}
