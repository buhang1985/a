package iih.ci.ord.s.ems.op.base;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.s.ems.itf.bp.IEmsCreateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 医疗单创建业务逻辑处理 -- 基类
 * 
 * @author wangqingzhu
 *
 */
public class OpBaseEmsCreateBP extends ContextCache implements IEmsCreateBP {

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	protected FArrayList handleReturnDocument(Object objInfo) throws BizException {
		FArrayList objList = new FArrayList();
		objList.add(objInfo);

		return objList;
	}
}
