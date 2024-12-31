package iih.bd.res.empdep.s;

import iih.bd.res.empdep.d.DepsEmpDTO;
import iih.bd.res.empdep.i.IDepsEmpService;
import iih.bd.res.empdep.s.bp.DepsEmpBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;

/**
 * 科室员工关系维护
 * @author yank,liubin
 *
 */
@Service(serviceInterfaces={IDepsEmpService.class}, binding=Binding.JSONRPC)
public class DepsEmpServiceImpl implements  IDepsEmpService{
	/**
	 * 获取科室下的员工集合
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	public DepsEmpDTO[] getDepsEmpList(String depId) throws BizException{
		if(StringUtil.isEmptyWithTrim(depId))
			return null;
		DepsEmpBP depsEmpBP= new DepsEmpBP();
		return depsEmpBP.getDepsEmpList(depId);
	}
	/**
	 * 保存
	 * @param empDTOs
	 */
	@Override
	public void save(DepsEmpDTO[] empDTOs) throws BizException {
		DepsEmpBP depsEmpBP= new DepsEmpBP();
		depsEmpBP.save(empDTOs);
	}
}
