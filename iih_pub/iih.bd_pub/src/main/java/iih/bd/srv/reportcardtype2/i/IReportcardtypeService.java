package iih.bd.srv.reportcardtype2.i;

import iih.bd.srv.reportcardtypediagdo.d.ReportCardTypeDiagDO;
import xap.mw.core.data.BizException;

/**
 * 报卡类型节点服务
 */
public interface IReportcardtypeService {

	/**
	 * 报卡类型保存关联诊断
	 * @param diagDos
	 * @param isNewAdd
	 * @return
	 * @throws BizException
	 */
	public abstract String saveDiagsFromType(ReportCardTypeDiagDO[] diagDos, Boolean isNewAdd,String id_rcm_tp, String name_rcm_tp) throws BizException;
}
