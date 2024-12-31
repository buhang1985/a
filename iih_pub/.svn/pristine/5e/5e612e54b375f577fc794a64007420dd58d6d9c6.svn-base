package iih.bd.res.empdep.i;

import iih.bd.res.empdep.d.DepsEmpDTO;
import xap.mw.core.data.BizException;

/**
 * 科室员工关系维护
 * @author yank,liubin
 *
 */
public interface IDepsEmpService {
	/**
	 * 获取科室下的员工集合
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	DepsEmpDTO[] getDepsEmpList(String depId) throws BizException;
	/**
	 * 保存
	 * @param empDTOs
	 */
	void save(DepsEmpDTO[] empDTOs) throws BizException;	
}
