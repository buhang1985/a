package iih.bd.mm.comm.bp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserManageQuery;

public class ContextHelper {

	public PsndocAggDO getEmployeeInfoByUserId(String userId) throws BizException {

		IUserManageQuery userQueryService = ServiceFinder.find(IUserManageQuery.class);
		IPsndocRService psndocRService = ServiceFinder.find(IPsndocRService.class);

		UserDO[] userDOs = userQueryService.findUsersByPKs(new String[] { userId });
		if (userDOs == null || userDOs.length <= 0) {

			throw new BizException("获取用户信息失败.");
		}
		UserDO userDO = userDOs[0];

		String whrStr = String.format("id_psndoc = '%s'", userDO.getId_psn());
		PsndocAggDO[] psndocAggDOs = psndocRService.find(whrStr, "", FBoolean.FALSE);

		if (psndocAggDOs == null || psndocAggDOs.length <= 0) {

			return null;
		} else {

			return psndocAggDOs[0];
		}
	}
}
