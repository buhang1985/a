package iih.sc.sch.s.bp;

import iih.sc.comm.ScContextUtils;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**计划号段转化为排班号段
 * @author ccj
 *
 */
public class GetSchTicksByWeekTicksBp {
	/**计划号段转化为排班号段
	 * @param weekTicksDOs  计划号段arrays
	 * @param id_sch 排班id
	 * @return  排班号段arrays
	 * @throws BizException
	 */
	public List<ScSchTicksDO> exec(ScPlanWeekTicksDO[] weekTicksDOs,String id_sch)throws BizException{
		if(ArrayUtils.isEmpty(weekTicksDOs)|| StringUtils.isBlank(id_sch)) return new ArrayList<ScSchTicksDO>();
		List<ScSchTicksDO> schTicks = new ArrayList<ScSchTicksDO>();  
		for(int i=0;i<weekTicksDOs.length;i++){
			ScPlanWeekTicksDO plDO = weekTicksDOs[i];
	    	ScSchTicksDO schTickDO = new ScSchTicksDO();
	    	schTickDO.setId_sch(id_sch);  //排班id
	    	schTickDO.setId_grp(ScContextUtils.getGrpId()); //集团
	    	schTickDO.setId_org(ScContextUtils.getOrgId()); //组织
	    	schTickDO.setCode(plDO.getCode()); 
	    	schTickDO.setName(plDO.getCode()); 
	    	schTickDO.setFg_used(FBoolean.FALSE); 	// 已使用完成标识
	    	schTickDO.setName(plDO.getName());
	    	schTickDO.setQuecn(plDO.getQuecn());
	    	schTickDO.setQueno_b(plDO.getQueno_b());
	    	schTickDO.setQuecn_appt(plDO.getQuecn_appt()); 	// 可预约数量
	    	schTickDO.setId_scsrv(plDO.getId_scsrv()); // 对应服务
	    	schTickDO.setQuecn_used(0); // 已使用数量
	    	schTickDO.setT_b(plDO.getT_b());
	    	schTickDO.setT_e(plDO.getT_e());
	    	schTickDO.setFg_active(FBoolean.TRUE); //  启用标识
	    	schTickDO.setStatus(DOStatus.NEW);
	    	schTicks.add(schTickDO);
		}
		return schTicks;
	}
}
