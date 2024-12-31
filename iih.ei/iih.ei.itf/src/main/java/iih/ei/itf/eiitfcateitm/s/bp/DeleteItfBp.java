package iih.ei.itf.eiitfcateitm.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.ei.itf.eiitfcateitm.d.ItfCateItmDO;
import iih.ei.itf.eiitfcateitm.i.IEiitfcateitmCudService;
import iih.ei.itf.eiitfcateitm.i.IEiitfcateitmRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 删除分类下接口
 * 
 * @author hao_wu 2019-10-24
 *
 */
public class DeleteItfBp {

	public void exec(String itfCateId, String[] itfIds) throws BizException {
		String wherePart = String.format("Id_itfcate = '%s' and %s", itfCateId,
				SqlUtils.getInSqlByIds(ItfCateItmDO.ID_ITF, itfIds));
		IEiitfcateitmRService cateItmRService = ServiceFinder.find(IEiitfcateitmRService.class);
		ItfCateItmDO[] cateItms = cateItmRService.find(wherePart, "", FBoolean.FALSE);

		IEiitfcateitmCudService cateItmCudService = ServiceFinder.find(IEiitfcateitmCudService.class);
		cateItmCudService.delete(cateItms);
	}

}
