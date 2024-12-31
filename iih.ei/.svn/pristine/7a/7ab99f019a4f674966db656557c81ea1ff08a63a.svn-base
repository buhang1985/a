package iih.ei.itf.eiitfcate.s.rule;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.FileServerUtils;
import iih.ei.itf.eiitfcate.d.ItfDocTaskDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 删除任务后删除任务对应的文件
 * 
 * @author hao_wu 2019-10-31
 *
 */
public class DelFileByTaskRule implements IRule<ItfDocTaskDO> {

	@Override
	public void process(ItfDocTaskDO... taskDos) throws BizException {
		if (ArrayUtils.isEmpty(taskDos)) {
			return;
		}

		for (ItfDocTaskDO itfDocTaskDO : taskDos) {
			String filePath = itfDocTaskDO.getPath_file();
			if (StringUtils.isBlank(filePath)) {
				continue;
			}

			try {
				FileServerUtils.Delete(filePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
