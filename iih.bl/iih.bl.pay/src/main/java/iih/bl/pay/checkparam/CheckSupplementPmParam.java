package iih.bl.pay.checkparam;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.itf.trdtrans.d.BlThirdTransRegDO;
import iih.bl.itf.trdtrans.i.ITrdtransregRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.paramset.d.ParamSetDO;
import xap.sys.devcfg.paramset.i.ICheckPara;
import xap.sys.devcfg.paramset.util.CheckParaDO;

public class CheckSupplementPmParam implements ICheckPara {

	@Override
	public CheckParaDO paraBeforeSavingCheck(ParamSetDO arg0) {
		
		CheckParaDO rtnDo=new CheckParaDO();
		String pmValue = arg0.getValue();
		
		if(StringUtil.isEmpty(pmValue))
		{
			rtnDo.setIsLegal(FBoolean.TRUE);
		}
		
		try {
			ITrdtransregRService rService=ServiceFinder.find(ITrdtransregRService.class);
			BlThirdTransRegDO[] regDOArr =rService.find("1=1","",FBoolean.FALSE);
			if(ArrayUtil.isEmpty(regDOArr))
			{
				rtnDo.setIsLegal(FBoolean.TRUE);
			}
			

			Map<String,BlThirdTransRegDO> regMap=new HashedMap();
			
			for (BlThirdTransRegDO blThirdTransRegDO : regDOArr) {
				if(StringUtil.isEmpty(blThirdTransRegDO.getSd_scene()))
				{
					continue;
				}
				
				String[] sceneArr=blThirdTransRegDO.getSd_scene().split(",");
				
				if(ArrayUtil.isEmpty(sceneArr))
				{
					continue;
				}
				
				for (String scene : sceneArr) {
					if(IBlDictCodeConst.SD_BIZSCENE_IP_CHARGE.equals(scene))
					{
						regMap.put(blThirdTransRegDO.getId_pm(), blThirdTransRegDO);
						break;
					}
				}
				
			}
			
			String[] pmArr=pmValue.split(",");
			if(ArrayUtil.isEmpty(pmArr))
			{
				rtnDo.setIsLegal(FBoolean.TRUE);
			}
			
			for (String pm : pmArr) {
				
				if(regMap.containsKey(pm))
				{
					BlThirdTransRegDO regDo=regMap.get(pm);
					rtnDo.setIsLegal(FBoolean.FALSE);
					rtnDo.setErrMsg(regDo.getName_pm()+"是第三方支付，不允许作为补充支付方式");
					break;
				}
			}
			
		
		} catch (BizException e) {
			rtnDo.setIsLegal(FBoolean.FALSE);
			rtnDo.setErrMsg(e.getMessage());
			return rtnDo;
		}
		
		return rtnDo;
	}

}
