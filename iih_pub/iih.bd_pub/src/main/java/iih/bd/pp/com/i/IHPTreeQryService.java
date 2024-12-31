package iih.bd.pp.com.i;

import iih.bd.pp.com.d.TreeDTO;
import xap.mw.core.data.BizException;

public interface IHPTreeQryService {

	/**
	 * 医保计划 获取树数据
	 * @return
	 * @throws BizException
	 */
	public abstract TreeDTO[] getHpTreeList() throws BizException;
	
	/**
	 * 删除医保计划
	 * @param treeDTO
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean deleteTreeDTO(TreeDTO treeDTO) throws BizException;
}
