package iih.sc.scp.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.base.utils.StringUtils;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekCudService;
import iih.sc.scp.scplweek.i.IScplweekRService;

/**
 * 删除某一周的周计划
 * @author zhouliming
 *
 */
public class DelScplMtWeeksBp {
	
	/**
	 * 删除某一周的周计划
	 * @param id_scpl 排班计划id
	 * @param Sd_tickmd 票号模式
	 * @param idx_week 周序号
	 * @throws BizException 
	 */
	public void exec(String id_scpl,Integer idx_week,String Sd_tickmd) throws BizException{
		//查询周计划
		IScplweekRService weekSrv = ServiceFinder.find(IScplweekRService.class);
		StringBuffer sql = new StringBuffer();
		sql.append("1=1 ");
		if(StringUtils.isNotEmpty(id_scpl)){
			sql.append("and id_scpl = '"+id_scpl+"' ");
		}
		if(StringUtils.isNotEmpty(Sd_tickmd)){
			sql.append("and idx_week = '"+idx_week+"' ");
		}
		ScplweekAggDO[] aggDOs = weekSrv.find(sql.toString(), "", FBoolean.FALSE);
		if(aggDOs == null || aggDOs.length == 0) return;
		
		//删除周计划
		IScplweekCudService weekCudSrv = ServiceFinder.find(IScplweekCudService.class);
		weekCudSrv.delete(aggDOs);
		
		StringBuffer id_scplweek = new StringBuffer();
		id_scplweek.append("(");
		for(ScplweekAggDO aggDO: aggDOs){
			id_scplweek.append("'"+aggDO.getParentDO().getId_scplweek()+"',");
		}
		String id_scplweeksets = id_scplweek.toString();
		id_scplweeksets = id_scplweeksets.substring(0,id_scplweeksets.length()-1);
		id_scplweeksets += ")";
		
		//删除号位或号段
		DelScPlTickOrTicksBp bp = new DelScPlTickOrTicksBp();
		bp.exec(id_scplweeksets, Sd_tickmd);
		
	}
}
