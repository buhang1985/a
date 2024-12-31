package iih.bd.srv.ems.s;

import java.util.ArrayList;

import iih.bd.srv.ems.d.EmsPrnTmplCaDO;
import iih.bd.srv.ems.d.EmsPrnTmplDO;
import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.bd.srv.ems.i.IEmsprntmplCudService;
import iih.bd.srv.ems.i.IEmsprntmplRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗单打印模板分类BP
 * 
 * @author hao_wu
 *
 */
public class EmsprntmplcaCrudServiceBp {

	/**
	 * 逻辑删除分类下的打印模板
	 * 
	 * @param dos
	 *            分类列表
	 * @throws BizException
	 */
	public void logicDeleteEmsPrnTmpl(EmsPrnTmplCaDO[] dos) throws BizException {
		if (dos == null || dos.length <= 0)
			return;

		EmsprntmplAggDO[] aggDOs = GetEmsPrnTmplList(dos);
		IEmsprntmplCudService emsprntmplCudService = ServiceFinder.find(IEmsprntmplCudService.class);
		emsprntmplCudService.logicDelete(aggDOs);
	}

	/**
	 * 删除分类下的打印模板
	 * 
	 * @param dos
	 *            分类列表
	 * @throws BizException
	 */
	public void deleteEmsPrnTmpl(EmsPrnTmplCaDO[] dos) throws BizException {
		if (dos == null || dos.length <= 0)
			return;

		EmsprntmplAggDO[] aggDOs = GetEmsPrnTmplList(dos);
		IEmsprntmplCudService emsprntmplCudService = ServiceFinder.find(IEmsprntmplCudService.class);
		emsprntmplCudService.delete(aggDOs);
	}

	/**
	 * 获取分类下 的所有打印模板
	 * 
	 * @param dos
	 *            分类列表
	 * @return 打印模板列表
	 * @throws BizException
	 */
	private EmsprntmplAggDO[] GetEmsPrnTmplList(EmsPrnTmplCaDO[] dos) throws BizException {
		String[] caIdArray = getCaIdList(dos);
		IEmsprntmplRService emsprntmplRService = ServiceFinder.find(IEmsprntmplRService.class);
		EmsprntmplAggDO[] aggDOs = emsprntmplRService.findByAttrValStrings(EmsPrnTmplDO.ID_EMSPRNCA, caIdArray);
		return aggDOs;
	}

	/**
	 * 获取分类列表的分类主键列表
	 * 
	 * @param dos
	 * @return
	 */
	private String[] getCaIdList(EmsPrnTmplCaDO[] dos) {
		ArrayList<String> idcaList = new ArrayList<String>();
		for (String id_ca : idcaList) {
			idcaList.add(id_ca);
		}
		return idcaList.toArray(new String[] {});
	}
}
