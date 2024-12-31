package iih.en.que.s.bp.pharm;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.d.desc.QueDODesc;
import iih.bd.fc.que.i.IQueRService;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取药房队列
 * @author yank
 *
 */
public class GetPharmQueByDepBP {
	/**
	 * 获取药房队列
	 * @param deptId 药房科室
	 * @return
	 */
	public QueDO exec(String deptId) throws BizException{
		IQueRService queService = ServiceFinder.find(IQueRService.class);
		String whereStr = String.format("%s.id_dep='%s' and %s.sd_quetp = '%s'",QueDODesc.TABLE_ALIAS_NAME,deptId, QueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_PHARMACY);
		QueDO[] queDOs = queService.find(whereStr, null, FBoolean.TRUE);
		if(!EnValidator.isEmpty(queDOs)){
			return queDOs[0];
		}
		return null;
	}
}
