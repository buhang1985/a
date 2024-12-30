package iih.sc.sch.s.task.bp;

import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.bp.op.UnLockSchOpBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 定时释放过期锁
 * @author fanlq
 * @date: 2019年10月22日 下午1:12:53
 */
public class ReleaseOverdueLockTaskBP {
	
	private static final String ORG_ID = "orgId";
	private static final String SD_SCTP = "sd_sctp";
	/***
	 * @Description:定时释放过期锁
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
		int maxDiTimes = ScParamUtils.getScLockValidityMin();//获取排班锁有效时间，以分钟为单位
		if(maxDiTimes > 0) {
			String sd_sctp = (String)map.get(SD_SCTP);
			if(StringUtils.isNullOrEmpty(sd_sctp)){
				sd_sctp = IScDictCodeConst.SD_SCTP_OP;
			}
			String[] id_sclocks = getOveerduleLock(sd_sctp,dateTime,maxDiTimes);
			if(id_sclocks != null && id_sclocks.length > 0){
				for(String id_sclock : id_sclocks){
					new UnLockSchOpBP().exec(id_sclock);
				}
			}
		}
	}
	/***
	 * @Description:获取过期锁记录
	 * @param dto
	 * @throws BizException
	 */
	private String[] getOveerduleLock(String sd_sctp,FDateTime nowTime,int maxDiTimes) throws BizException{
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select sclock.id_sclock ");
		sql.append("from sc_sch_lock sclock " );
		sql.append("inner join sc_sch sch on sch.id_sch = sclock.id_sch " );
		sql.append("where sch.sd_sctp = ? " );
		sql.append("and sclock.fg_unlock= 'N' " );
		sql.append("and sclock.dt_e_lock < ? ");
		param.addParam(sd_sctp);
		param.addParam(nowTime);
		List<String> list = (List<String>) new DAFacade().execQuery(sql.toString(), param, new ColumnListHandler());
		return list != null && list.size() > 0 ? list.toArray(new String[]{}) : null;
	}
	
}
