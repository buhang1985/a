package iih.sc.sch.s.task;

import iih.sc.sch.dto.d.OpSchTplDTO;
import iih.sc.sch.s.bp.BatchGenOpSchBP;

import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 批量生成门诊/医技排班后台任务
 * 
 * @author libaoliang
 *
 */
public class BatchGenOpSchTask implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext bwContext) throws BizException {
		BatchGenOpSchBP batchGenBP = new BatchGenOpSchBP();
		Map<String, Object> map = bwContext.getKeyMap();
		FArrayList plIdsList = new FArrayList();
		String planIds = (String) map.get("planIds");
		plIdsList.deSerializeJson(planIds);

		FArrayList schTplsList = new FArrayList();
		String schTpls = (String) map.get("schTpls");
		schTplsList.deSerializeJson(schTpls);

		String fgCover = (String) map.get("fgCover");
		if (CollectionUtils.isNotEmpty(plIdsList) && CollectionUtils.isNotEmpty(schTplsList)
				&& StringUtils.isNotBlank(fgCover)) {
			FBoolean fg_cover = new FBoolean(Boolean.parseBoolean(fgCover));
			batchGenBP.exec((String[]) plIdsList.toArray(new String[0]),
					(OpSchTplDTO[]) schTplsList.toArray(new OpSchTplDTO[0]), fg_cover);
		}
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

}
