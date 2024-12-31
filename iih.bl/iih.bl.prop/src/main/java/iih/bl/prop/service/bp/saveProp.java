package iih.bl.prop.service.bp;

import org.apache.commons.lang.StringUtils;

import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blproparoep.i.IBlproparoepCudService;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.blpropoep.i.IBlpropoepCudService;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存医保分摊
 * @author tcy
 *
 */
public class saveProp {
	/**
	 * 保存门诊分摊的数据
	 * @param blPropOepDOArr
	 * @param blproparoepAggDOArr
	 */
	public FMap2 saveOepProp(BlPropOepDO[] blPropOepDOArr,BlproparoepAggDO[] blproparoepAggDOArr)  throws BizException
	{
		//获取服务器当前时间
		TimeService timeService = new TimeServiceImpl();
		for(int i=0;i<blPropOepDOArr.length;i++)
		{
			//分摊时间
			blPropOepDOArr[0].setDt_prop(timeService.getUFDateTime());
		}
		//保存门诊分摊信息，根据业务流程来说，只具有一个分摊信息
		IBlpropoepCudService iBlpropoepCudService=ServiceFinder.find(IBlpropoepCudService.class);
		
		BlPropOepDO[]  blPropOepDOArrSaved =iBlpropoepCudService.save(blPropOepDOArr);
		if(blPropOepDOArrSaved==null||blPropOepDOArrSaved.length==0)
		{
			//保存门诊分摊信息失败
			throw new BizException("未能获取到医保分摊信息，无法继续结算");
		}
		//分摊数据保存后的记录
		BlPropOepDO propOepDo=blPropOepDOArrSaved[0];
		//应收记录里填写分摊主键
		BlPropArOepDO propArOepDo=blproparoepAggDOArr[0].getParentDO();
		propArOepDo.setId_propoep(propOepDo.getId_propoep());
		//保存应收记录
		IBlproparoepCudService blproparoepCrudService=ServiceFinder.find(IBlproparoepCudService.class);
		BlproparoepAggDO[] propArOepAggDoArrSaved=blproparoepCrudService.save(blproparoepAggDOArr);
		if(propArOepAggDoArrSaved==null)
		{
			throw new BizException("保存门诊分摊信息失败");
		}
		BlPropArOepDO propArOepDoSaved=propArOepAggDoArrSaved[0].getParentDO();
		FMap2 map=new FMap2();
		map.put("propoep", blPropOepDOArrSaved);
		map.put("proparoep", propArOepAggDoArrSaved);
		return map;
	}
}
