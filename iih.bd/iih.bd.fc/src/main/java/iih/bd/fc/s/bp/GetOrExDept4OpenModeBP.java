package iih.bd.fc.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.pub.BdFcUtils;
import xap.mw.core.data.BizException;

/*
 * 获得医嘱开立模式医嘱的执行科室列表操作BP
 */
public class GetOrExDept4OpenModeBP {
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
		
		//基数药管理
		String depid=getCardinalPharmDept(param);
		if(!BdFcUtils.isEmpty(depid)){
			return new OrWfExDeptDTO[]{createExDeptInfo(depid)};
		}
	
		//获得开立时的流向执行科室
		return getExDept(param);
	}
	
	/**
	 * 获得执行科室
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptDTO[] getExDept(OrWfExDeptParamDTO param) throws BizException{
		param.setReserv1(IBdFcDictCodeConst.SD_WFTP_OPENDEPT);
		GetExDept4CommonBP bp=new GetExDept4CommonBP();
		return bp.exec(param);
	}
	
	
	/**
	 * 获得基数药管理科室
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private String getCardinalPharmDept(OrWfExDeptParamDTO param) throws BizException{
		IsCardinalPharmBP bp=new IsCardinalPharmBP();
		return bp.exec(param);
	}

	/**
	 * 获得流向科室信息
	 * @param depid
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptDTO createExDeptInfo(String depid) throws BizException{
		GetExDeptInfo8DepIdBP bp=new GetExDeptInfo8DepIdBP();
		return bp.exec(depid);
	}
}
