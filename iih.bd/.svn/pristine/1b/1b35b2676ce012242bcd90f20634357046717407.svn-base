package iih.bd.srv.reportcardtype2.s;

import iih.bd.srv.reportcardtype2.bp.SaveDiagsFromTypeBp;
import iih.bd.srv.reportcardtype2.i.IReportcardtypeService;
import iih.bd.srv.reportcardtypediagdo.d.ReportCardTypeDiagDO;
import xap.mw.core.data.BizException;

/**
 * 报卡类型节点服务
 */
public class ReportcardtypeServiceImpl implements IReportcardtypeService{

	
	/**
	 * 报卡类型保存关联诊断
	 * @param diagDos
	 * @param isNewAdd
	 * @return
	 * @throws BizException
	 */
	@Override
	public String saveDiagsFromType(ReportCardTypeDiagDO[] diagDos, Boolean isNewAdd,String id_rcm_tp, String name_rcm_tp) throws BizException {
		SaveDiagsFromTypeBp bp = new SaveDiagsFromTypeBp();
		return bp.saveDiagsFromType(diagDos, isNewAdd,id_rcm_tp,name_rcm_tp);
	}
}
