package iih.bd.fc.s.bp;

import iih.bd.fc.mdwfor.d.MdWfOrDO;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.pub.BdFcUtils;
import xap.mw.core.data.BizException;

/*
 * 获得执医嘱流向行科室信息操作BP
 */
public class GetExDept8WfOrArgu1BP {
	/**
	 * 获得执医嘱流向行科室信息
	 * @param wforinfo
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptDTO exec(MdWfOrDO wforinfo,OrWfExDeptParamDTO param) throws BizException{
		if(!BdFcUtils.isEmpty(wforinfo.getDeptmacro())){
			return createExDeptInfo(BdFcUtils.getWfCfgDepID(wforinfo.getDeptmacro(), param));
		}else{
			return getExDept8WfOrArgu(wforinfo);
		}
	}
	
	/**
	 * 获得执医嘱流向行科室信息
	 * @param wforinfo
	 * @return
	 * @throws BizException 
	 */
	private OrWfExDeptDTO getExDept8WfOrArgu(MdWfOrDO wforinfo) throws BizException{
		GetExDept8WfOrArguBP bp=new GetExDept8WfOrArguBP();
		return bp.exec(wforinfo);
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
