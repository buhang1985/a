package iih.sc.sch.s.task.bp;

import java.util.List;
import java.util.Map;

import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.SchLockEP;
import iih.sc.sch.sclock.d.ScSchLockDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 删除历史锁记录
 * @author fanlq
 * @date: 2019年10月22日 下午2:11:06
 */
public class DeletePastLockTaskBP {
	
	private static final String ORG_ID = "orgId";
	private static final String DAYS_RESERVE = "days_reserve";
	/***
	 * @Description:删除历史锁记录
	 * @param map
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException{
		FDateTime dateTime = ScAppUtils.getServerDateTime();
		if(dateTime == null){
			Logger.error("定时诊毕任务：获取当前时间失败！");
			return;
		}
		String orgId = (String)map.get(ORG_ID);
		if(ScValidator.isEmptyIgnoreBlank(orgId)){
			Logger.error("定时诊毕任务：任务部署未设置组织！");
			return;
		}
		Context.get().setOrgId(orgId);
		int pastDays = 30;//默认30天
		String days_reserve = (String)map.get(DAYS_RESERVE);
		if(ScValidator.isNotEmptyIgnoreBlank(days_reserve))
			pastDays = Integer.parseInt(days_reserve);
		ScSchLockDO[] scSchLockDOs = getPastLock(dateTime,pastDays);
		new SchLockEP().getCudServ().delete(scSchLockDOs);
	}
	/***
	 * @Description:获取历史锁记录
	 * @param dto
	 * @throws BizException
	 */
	private ScSchLockDO[] getPastLock(FDateTime nowTime,int pastDays) throws BizException{
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select sclock.* ");
		sql.append("from sc_sch_lock sclock " );
		sql.append("inner join sc_sch sch on sch.id_sch = sclock.id_sch " );
		sql.append("where sclock.fg_unlock= 'Y' " );
		sql.append("and sclock.dt_e_lock < ? ");
		param.addParam(nowTime.getDateTimeAfter(-pastDays));
		List<ScSchLockDO> list = (List<ScSchLockDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(
				ScSchLockDO.class));
		return list != null && list.size() > 0 ? list.toArray(new ScSchLockDO[]{}) : null;
	}
}
