package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.sc.apt.dto.d.OpSchStop4EsDTO;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.event.OpSchStopEvent;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 停诊门诊排班
 * @author renying
 *
 */
public class SetActiveStateOfSchBP {
	/**
	 * 停诊门诊排班
	 * @param schIds 排班ID集合
	 * @throws BizException
	 */
	public String[] exec(String[] schIds,FBoolean isactive) throws BizException{
		//1.校验参数
		ScValidator.validateParam("schId", schIds);	
		ScValidator.validateParam("isactive", isactive);
		//2.查找排班
		SchEP ep = new SchEP();
		ScSchDO[] schDOs = ep.getByIds(schIds);
		if(ArrayUtil.isEmpty(schDOs)){
			throw new BizException("未检索到排班");
		}
		//3.修改排班的启用状态
		List<String> list = new ArrayList<String>();
		for(ScSchDO schDO :schDOs){
//			if(schDO.getQuan_total_used() !=null && schDO.getQuan_total_used()!= 0)
//				continue;
			schDO.setFg_active(isactive);
			schDO.setStatus(DOStatus.UPDATED);
			list.add(schDO.getId_sch());
		}	
		//4.保存数据
		ep.save(schDOs);	
		//5.触发停诊事件
		this.invokeSchStopEvent(list);
		return list.toArray(new String[]{});
	}
	/**
	 * add by yzh 2019年8月5日16:16:06
	 * 触发门诊排班停诊事件
	 * @param schList
	 * @throws BizException
	 */
	private void invokeSchStopEvent(List<String> schList) throws BizException{
		FArrayList schs = new FArrayList();
		OpSchStop4EsDTO opschstop4esdto = new OpSchStop4EsDTO();
		if(!ListUtil.isEmpty(schList)){
			for (String id_sch : schList) {
				schs.add(id_sch);
			}
			opschstop4esdto.setId_sch_arr(schs);
		}
		new OpSchStopEvent().invoke(opschstop4esdto);
	}
}
