package iih.ei.itf.eiitfcate.s;

import iih.ei.itf.eiitfcate.d.ItfDocTaskDO;
import iih.ei.itf.eiitfcate.i.IEiItfCateExtCudService;
import iih.ei.itf.eiitfcate.i.IEiItfCateExtRService;
import iih.ei.itf.eiitfcate.s.bp.CreateExportDocTaskByCateIdBp;
import xap.mw.core.data.BizException;

/**
 * 接口分类扩展服务
 * 
 * @author hao_wu 2019-10-28
 *
 */
public class EiItfCateExtCrudServiceImpl implements IEiItfCateExtCudService, IEiItfCateExtRService {

	@Override
	public ItfDocTaskDO createExportDocTaskByCateId(String itfCateId) throws BizException {
		CreateExportDocTaskByCateIdBp bp = new CreateExportDocTaskByCateIdBp();
		ItfDocTaskDO taskDo = bp.exec(itfCateId);
		return taskDo;
	}

}
