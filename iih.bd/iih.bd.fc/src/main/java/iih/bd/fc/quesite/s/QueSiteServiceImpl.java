package iih.bd.fc.quesite.s;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.bd.fc.quesite.i.IQuesiteService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;

public class QueSiteServiceImpl implements IQuesiteService {

	@Override
	public QueSiteDO[] findByDeptId(String str)  {
		IQuesiteRService quesiteService = new QuesiteCrudServiceImpl();
		QueSiteDO[] result = null;
		String wherePart = "id_org = '" + Context.get().getOrgId() + "' AND id_grp = '" + Context.get().getGroupId()
				+ "' AND id_que IN (SELECT id_que FROM bd_que WHERE id_dep = '" + str + "')";
		try {
			result = quesiteService.find(wherePart, "fg_active desc", FBoolean.FALSE);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return result;
	}

}
