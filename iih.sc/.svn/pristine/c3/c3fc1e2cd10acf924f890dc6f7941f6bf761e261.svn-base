package iih.sc.sch.s.task;

import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.sc.sch.dto.d.MtSchDTO;
import iih.sc.sch.s.bp.SaveMtSchBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
/**保存门诊/医技排班的后台任务
 * 
 * @author libaoliang
 *
 */
public class SaveMtSchTask implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext bwContext) throws BizException {
		SaveMtSchBP saveMtSchBP = new SaveMtSchBP();
		Map<String, Object> map = bwContext.getKeyMap();
		MtSchDTO[] mtschdto=null;
		String mtschdtoStr = (map.containsKey("mtschdto") ?  (String) map.get("mtschdto") : null);
		if(StringUtils.isNotBlank(mtschdtoStr)){
			//反序列化MtSchDTO的list
			FArrayList mtschdotList=new FArrayList();
			mtschdotList.deSerializeJson(mtschdtoStr);
			//MtSchDTO的List转成数组
			mtschdto = CollectionUtils.isNotEmpty(mtschdotList) ?(MtSchDTO[]) mtschdotList.toArray(new MtSchDTO[0]) : null;
		}
		FBoolean fg_cover = map.containsKey("fg_cover") ? new FBoolean(map.get("fg_cover").toString()): null;
		FDate dt_b = map.containsKey("dt_b") ? new FDate(map.get("dt_b").toString()) : null;
		FDate dt_e = map.containsKey("dt_e") ? new FDate(map.get("dt_e").toString()) : null;
		String tp = map.containsKey("tp") ? (String) map.get("tp") : null;
		String depId = map.containsKey("depId") ? (String) map.get("depId") : null;
		String delString =null;
		if (ArrayUtils.isNotEmpty(mtschdto) && fg_cover != null && dt_b != null && dt_e != null  && StringUtils.isNotBlank(depId)) {
			delString = saveMtSchBP.exec(mtschdto, fg_cover.booleanValue(), dt_b, dt_e, tp, depId);
		}
		PreAlertObject obj = new PreAlertObject();
		FArrayList2 returnObj=new FArrayList2();
		returnObj.add(delString);
		obj.setReturnObj(returnObj);
		return obj;
	}

}
