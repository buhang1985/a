package iih.bd.fc.que.s;

import iih.bd.fc.que.bp.PharmacyQueBP;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQuePharmacyService;
import iih.bd.fc.que.s.bp.FindPharmacyQueByDepIdBp;
import xap.mw.core.data.BizException;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 药房队列服务实现类
 * 
 * @author hao_wu
 *
 */
public class QuePharmacyServiceImpl implements IQuePharmacyService {

	/**
	 * 查询药房科室下的队列，存在返回队列DO，不存在创建队列DO
	 */
	@Override
	public QueDO getPharmacyQue(DeptDO deptDO) throws BizException {
		PharmacyQueBP pharmacyQueBP = new PharmacyQueBP();
		return pharmacyQueBP.whetherExistQue(deptDO);
	}

	@Override
	public QueDO findPharmacyQueByDepId(String depId) throws BizException {
		FindPharmacyQueByDepIdBp bp = new FindPharmacyQueByDepIdBp();
		QueDO que = bp.exec(depId);
		return que;
	}
}
