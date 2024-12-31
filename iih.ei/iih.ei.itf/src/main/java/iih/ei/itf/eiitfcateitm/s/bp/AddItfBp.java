package iih.ei.itf.eiitfcateitm.s.bp;

import iih.ei.itf.eiitfcateitm.d.ItfCateItmDO;
import iih.ei.itf.eiitfcateitm.i.IEiitfcateitmCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 添加接口到分类下
 * 
 * @author hao_wu 2019-10-24
 *
 */
public class AddItfBp {

	public void exec(String itfCateId, String[] itfIds) throws BizException {

		ItfCateItmDO[] cateItmDos = new ItfCateItmDO[itfIds.length];
		for (int i = 0; i < itfIds.length; i++) {
			ItfCateItmDO itmDo = new ItfCateItmDO();
			itmDo.setId_grp(Context.get().getGroupId());
			itmDo.setId_org(Context.get().getOrgId());
			itmDo.setId_itfcate(itfCateId);
			itmDo.setId_itf(itfIds[i]);
			cateItmDos[i] = itmDo;
		}

		IEiitfcateitmCudService cateItmCudService = ServiceFinder.find(IEiitfcateitmCudService.class);
		cateItmCudService.insert(cateItmDos);
	}

}
