package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.sc.comm.ScContextUtils;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**计划号位转化为排班号位
 * @author ccj
 *
 */
public class GetSchTickByWeekTickBp {
	/**计划号位转化为排班号位
	 * @param weekTicksDOs  计划号段arrays
	 * @param id_sch 排班id
	 * @return  排班号段arrays
	 * @throws BizException
	 */
	public List<ScSchTickDO> exec(ScPlanWeekTickDO[] weekTicksDOs,String id_sch)throws BizException{
		if(ArrayUtils.isEmpty(weekTicksDOs) || StringUtils.isBlank(id_sch)) return new ArrayList<ScSchTickDO>();
		List<ScSchTickDO> schTick = new ArrayList<ScSchTickDO>();  
		for(int i=0;i<weekTicksDOs.length;i++){
			ScPlanWeekTickDO plDO = weekTicksDOs[i];
	    	ScSchTickDO schTickDO = new ScSchTickDO();
	    	schTickDO.setId_sch(id_sch);
	    	schTickDO.setId_grp(ScContextUtils.getGrpId()); //集团
	    	schTickDO.setId_org(ScContextUtils.getOrgId()); //组织
	    	schTickDO.setCode(plDO.getCode());
	    	schTickDO.setEu_used(EuUseState.WY);  //使用状态
	    	schTickDO.setName(plDO.getName());
	    	schTickDO.setStatus(DOStatus.NEW);
	    	schTickDO.setId_scsrv(plDO.getId_scsrv()); //对应服务
	    	schTickDO.setT_b(plDO.getT_b());
	    	schTickDO.setT_e(plDO.getT_e());  
	    	schTickDO.setEu_usescope(plDO.getEu_usescope());    	
	    	schTickDO.setQueno(plDO.getQueno());
	    	schTickDO.setEu_add(EuAddTickMod.ZCH); //加号模式
	    	schTickDO.setFg_active(FBoolean.TRUE); // 启用标识
	    	schTick.add(schTickDO);
		}
		return schTick;
	}
}
