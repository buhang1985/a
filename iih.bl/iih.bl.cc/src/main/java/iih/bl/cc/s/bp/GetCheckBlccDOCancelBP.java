package iih.bl.cc.s.bp;

import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.i.IBlccMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 判断是否可以取消结账
 * @author LIM
 *
 */
public class GetCheckBlccDOCancelBP {
	/**
	 * 判断是否可以取消结账
	 * @param blccDo
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(BlCcDO blccDo) throws BizException{
		StringBuffer quStr = new StringBuffer();
		quStr.append(" a0.id_emp = '").append(blccDo.getId_emp()).append("'")
		     .append(" and a0.id_cctp = '").append(blccDo.getId_cctp()).append("'")
		     .append(" and a0.fg_canc = 'N'")
		     .append(" and a0.dt_e > '").append(blccDo.getDt_e()).append("'");
		IBlccMDORService service = ServiceFinder.find(IBlccMDORService.class);
		BlCcDO[] blCcDOArr = service.find(quStr.toString(), null, FBoolean.FALSE);
		if(blCcDOArr != null && blCcDOArr.length > 0){
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
}
