package iih.bd.fc.wf.s.bp;

import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.fc.entp.i.IEntpRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class getEntpListBp {

	/**
	 * 获取就诊类型列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public EnTypeDO[] exec() throws BizException {

		IEntpRService findService = ServiceFinder.find(IEntpRService.class);

		// String condition=String.format("id_grp = '%s' and id_org = '%s'",
		// Context.get().getGroupId(),Context.get().getOrgId());
		return findService.find("1=1", "", FBoolean.FALSE);
	}
}
