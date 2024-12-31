package iih.ci.ord.i;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.DeptQryParam;
import iih.ci.ord.i.meta.DeptQryRstInfo;
import xap.mw.core.data.BizException;

public interface ICiDeptMainService {

	/**
	 * 临床项目科室信息查询接口
	 * @param ctx
	 * @param szParams
	 * @return
	 */
	abstract DeptQryRstInfo[] QueryDeptInfos(CiEnContextDTO ctx,DeptQryParam[] szParams)  throws BizException;
	
	/**
	 * 临床项目科室信息查询接口
	 * @param ctx
	 * @param szParams
	 * @return
	 */
	abstract DeptQryRstInfo QueryDeptInfo(CiEnContextDTO ctx,DeptQryParam param)  throws BizException;
}
