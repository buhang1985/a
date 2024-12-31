package iih.bd.fc.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import xap.mw.core.data.BizException;

public class GetOrExDept4ExModeBP {
	/**
	 * 获得医嘱开立模式医嘱的执行科室列表
	 * 是物品时门急诊要设置就诊科室
	 *       住院要设置护理单位
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptDTO[] exec(OrWfExDeptParamDTO param)  throws BizException{
		//有效性判断
		if(param==null)return null;

		//获得执行时的流向执行科室
		return getExDept(param);
	}
	
	/**
	 * 获得执行科室
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptDTO[] getExDept(OrWfExDeptParamDTO param) throws BizException{
		param.setReserv1(IBdFcDictCodeConst.SD_WFTP_EXDEPT);
		GetExDept4CommonBP bp=new GetExDept4CommonBP();
		return bp.exec(param);
	}
}
