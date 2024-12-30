package iih.sc.scbd.s.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存排班参数
 * 
 * @author 
 *
 */
public class SaveScDeptParamBP {
	/**
	 * 保存排班参数
	 * 
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	public ScdeptparamAggDO exec(ScdeptparamAggDO aggdo) throws BizException {
		if (aggdo == null)
			return null;
		
		ScDeptParamDsDO[] paramDsDOs = aggdo.getScDeptParamDsDO();
		ScDeptParamDO paramDO = aggdo.getParentDO();
		// 校验一个排班分类下只能有一个排班参数
		if(!validateSc4Dept(paramDO)){
			throw new BizException(paramDO.getName_dept()+"下已经存在类型为 “"+paramDO.getName_scca()+"” 的排班参数");
		}
		if (paramDO == null || paramDsDOs == null || paramDsDOs.length <= 0)
			return null;
		if(StringUtil.isEmpty(paramDO.getSd_sctp())){
			throw new BizException("未取到日期分组！");
		}
		IScDaysLotService service = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO[] daysLotDOs = service.getAllDaysLotDOs(paramDO.getSd_sctp());
		
		Map<String, DaysLotDO> daysLotMap = new HashMap<String, DaysLotDO>();
		for (DaysLotDO daysLotDO : daysLotDOs) {
			daysLotMap.put(daysLotDO.getId_dayslot(), daysLotDO);
		}
		for (ScDeptParamDsDO paramDsDO : paramDsDOs) {
			DaysLotDO daysLotDO = daysLotMap.get(paramDsDO.getId_dayslot());
			if(daysLotDO ==null){
				throw new BizException("日期分组获取错误！");
			}
			if (daysLotDO.getFg_active()!=null && !daysLotDO.getFg_active().booleanValue() && paramDsDO.getFg_active().booleanValue()) {
				throw new BizException( "“"+daysLotDO.getName() + "”在日期分组中已停用，请返回修改！");
			}
		}
		//同步计划和排班时会修改数据,在这克隆出一个进行保存操作
		ScdeptparamAggDO aggdoNew =  (ScdeptparamAggDO)aggdo.clone();
		
		//同步修改计划和排班
		if(paramDO.getStatus() == DOStatus.UPDATED)
		{
			new SynchroSugestExmintBP().exec(paramDO,paramDsDOs);
		}
		
		IScdeptparamCudService cudService = ServiceFinder.find(IScdeptparamCudService.class);
		ScdeptparamAggDO[] aggDOs = cudService.save(new ScdeptparamAggDO[] { aggdoNew });
		return aggDOs[0];
	}
	/**
	 * 判断部门下该排班类型是否已经存在排班参数
	 * @author yzh
	 * @param scDeptParamDO
	 * @return
	 * @throws BizException
	 */
	private boolean validateSc4Dept(ScDeptParamDO scDeptParamDO) throws BizException{
		DAFacade dafacade = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("select count(1) from sc_dep_param where  id_dep = ? and id_scca = ? ");
		SqlParam param = new SqlParam();
		param.addParam(scDeptParamDO.getId_dep());
		param.addParam(scDeptParamDO.getId_scca());
		List<String> list = (List<String>) dafacade.execQuery(sb.toString(),param, new ColumnListHandler());
		int count = 0;
		if (list != null && list.size() > 0) {
			Object o = list.get(0);
			count = Integer.parseInt(o.toString());
		}
		if (scDeptParamDO.getStatus() == DOStatus.NEW) {
		if (count > 0) {
			return false;
		}
		}else if(scDeptParamDO.getStatus() == DOStatus.UPDATED){
			if (count > 1) {
				return false;
			}
		}
		
		return true;
		
	}

}
