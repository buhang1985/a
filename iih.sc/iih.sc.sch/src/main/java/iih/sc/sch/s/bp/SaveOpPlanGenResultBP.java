package iih.sc.sch.s.bp;

import iih.sc.sch.dto.d.PlanGenResult;
import iih.sc.sch.s.ep.ScSchEmpEP;
import iih.sc.sch.s.ep.ScSchOptSrvEP;
import iih.sc.sch.s.ep.SchChlEP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.SchEnEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEmpDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;

/**
 * 保存计划生成结果
 * @author yankan
 *
 */
public class SaveOpPlanGenResultBP {
	/**
	 * 保存计划生成结果
	 * @param result
	 * @throws BizException
	 */
	public void exec(PlanGenResult result) throws BizException{
		if(result==null || ListUtil.isEmpty(result.getSchDOList())){
			return;
		}
		
		//1、保存排班
		new SchEP().save(result.getSchDOList().toArray(new ScSchDO[0]));
		
		//2、保存排班渠道
		if(!ListUtil.isEmpty(result.getSchChlDOList())){
			new SchChlEP().save(result.getSchChlDOList().toArray(new ScSchChlDO[0]));
		}
		
		//3、保存排班就诊
		if(!ListUtil.isEmpty(result.getSchEnDOList())){
			new SchEnEP().save(result.getSchEnDOList().toArray(new ScSchEnDO[0]));
		}
		
		//4、保存排班人员
		if(!ListUtil.isEmpty(result.getSchEmpDOList())){
			new ScSchEmpEP().save(result.getSchEmpDOList().toArray(new ScSchEmpDO[0]));
		}
		
		//5、保存备用排班服务ScSchOptsrvDO
		if(!ListUtil.isEmpty(result.getscSchOptsrvDOList())){
			new ScSchOptSrvEP().save(result.getscSchOptsrvDOList().toArray(new ScSchOptsrvDO[0]));
		}
		
		//6、保存排班号段
		if(!ListUtil.isEmpty(result.getSchTicksDOList())){
			new TicksEP().save(result.getSchTicksDOList().toArray(new ScSchTicksDO[0]));
		}
		
		//7、保存排班号位
		if(!ListUtil.isEmpty(result.getSchTickDOList())){
			new TickEP().save(result.getSchTickDOList().toArray(new ScSchTickDO[0]));
		}		
	}
}
