package iih.bd.fc.que.bp;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.d.desc.QueDODesc;
import iih.bd.fc.que.i.IQueRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 判断队列是否在分诊台管理之下
 * 
 * @author Liu bin
 *
 */
public class IsBenContainQueBP {

	/**
     * 判断队列是否在分诊台管理之下
     * 
     * @param benId 分诊台ID
     * @param queId 队列ID
     * @return
     * @throws BizException
     */
	public FBoolean exec(String benId, String queId) throws BizException {
		IQueRService queRService = ServiceFinder.find(IQueRService.class);
		String whereStr = String.format("%s.ID_QUE = '%s' AND %s.ID_QUEBEN = '%s' AND %s.FG_ACTIVE = '%s' ",
						QueDODesc.TABLE_ALIAS_NAME, queId,
						QueDODesc.TABLE_ALIAS_NAME, benId,
						QueDODesc.TABLE_ALIAS_NAME, 'Y');
		QueDO[] ques = queRService.find(whereStr, null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(ques)){
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
}
