package iih.ei.itf.eiitfcate.s.bp;

import iih.ei.itf.eiitfcate.d.ItfDocTaskDO;
import iih.ei.itf.eiitfcate.i.IItfdocCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 使用接口分类主键创建导出文档任务
 * 
 * @author hao_wu 2019-10-28
 *
 */
public class CreateExportDocTaskByCateIdBp {

	public ItfDocTaskDO exec(String itfCateId) throws BizException {
		ItfDocTaskDO taskDo = new ItfDocTaskDO();
		taskDo.setId_grp(Context.get().getGroupId());
		taskDo.setId_org(Context.get().getOrgId());
		taskDo.setId_itfca(itfCateId);

		IItfdocCudService taskCudService = ServiceFinder.find(IItfdocCudService.class);
		ItfDocTaskDO[] result = taskCudService.insert(new ItfDocTaskDO[] { taskDo });
		return result[0];
	}

}
