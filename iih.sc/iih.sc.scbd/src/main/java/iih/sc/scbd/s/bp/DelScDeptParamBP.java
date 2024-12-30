package iih.sc.scbd.s.bp;

import java.util.List;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 删除排班参数
 * 
 * @author 
 *
 */
public class DelScDeptParamBP {
	/**
	 * 保存排班参数
	 * 
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	public void exec(ScdeptparamAggDO aggdo) throws BizException {
		if (aggdo == null)
			throw new BizException("排班参数数据为空");
		
		ScDeptParamDO paramDO = aggdo.getParentDO();
		// 校验排班参数是否被排班计划引用
		if(!validateSc4Plan(paramDO)){
			throw new BizException("排班参数:“"+paramDO.getName_scca()+"” 已被排班计划引用");
		}
		
		IScdeptparamCudService cudService = ServiceFinder.find(IScdeptparamCudService.class);
		cudService.delete(new ScdeptparamAggDO[] { aggdo });
	}
	/**
	 * 判断该排班参数是否被排班计划引用
	 * @author yzh
	 * @param scDeptParamDO
	 * @return
	 * @throws BizException
	 */
	private boolean validateSc4Plan(ScDeptParamDO scDeptParamDO) throws BizException{
		DAFacade dafacade = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("select count(1) from sc_pl where  id_depparam = ? and ds ='0'");
		SqlParam param = new SqlParam();
		param.addParam(scDeptParamDO.getId_deptparam());
		List<String> list = (List<String>) dafacade.execQuery(sb.toString(),param, new ColumnListHandler());
		int count = 0;
		if (list != null && list.size() > 0) {
			Object o = list.get(0);
			count = Integer.parseInt(o.toString());
		}
		if (count > 0) {
			return false;
		}
		return true;
		
	}

}
