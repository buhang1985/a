package iih.bd.pp.accountsrv.i;

import iih.bd.pp.accountsrvrel.d.MedsrvAccountRelDTO;
import xap.mw.core.data.BizException;

/**
 * 核算科目与收费项目的关联关系数据扩展维护服务
 * 
 * @author hao_wu 2018-10-27
 *
 */
public interface IAccountsrvExtCudService {

	/**
	 * 更新医疗服务与核算科目关系
	 * 
	 * @param srvAccountRelDtos 医疗服务与核算科目关系集合
	 * @throws BizException
	 */
	public abstract void updateMedsrvAccountRel(MedsrvAccountRelDTO[] srvAccountRelDtos) throws BizException;

	/**
	 * 根据医疗服务主键删除医疗服务与核算科目关系
	 * 
	 * @param medSrvId 医疗服务主键集合
	 * @throws BizException
	 */
	public abstract void deleteRelByMedsrvId(String[] medSrvIds) throws BizException;
}
