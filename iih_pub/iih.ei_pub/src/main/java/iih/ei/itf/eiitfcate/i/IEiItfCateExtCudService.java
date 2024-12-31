package iih.ei.itf.eiitfcate.i;

import iih.ei.itf.eiitfcate.d.ItfDocTaskDO;
import xap.mw.core.data.BizException;

/**
 * 接口分类扩展服务接口
 * 
 * @author hao_wu 2019-10-28
 *
 */
public interface IEiItfCateExtCudService {
	/**
	 * 使用接口分类主键创建导出文档任务
	 * 
	 * @param itfCateId 接口分类主键
	 * @return 任务DO
	 * @throws BizException
	 */
	public abstract ItfDocTaskDO createExportDocTaskByCateId(String itfCateId) throws BizException;
}
