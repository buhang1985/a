package iih.bl.cc.s.bp;

import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.i.IBlccMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 结账后打印时，检验数据有效性（防止取消结账后，打印已取消的结账数据）
 * @author LIM
 *
 */
public class GetCheckDataValidityPrintBP {
	/**
	 * 结账后打印时，检验数据有效性（防止取消结账后，打印已取消的结账数据）
	 * @param id_cc
	 * @return
	 * @throws BizException
	 * @author Liwq
	 */
	public FBoolean exec(String id_cc) throws BizException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("select id_cc from bl_cc where fg_canc = 'N' and id_cc='");
		
		IBlccMDORService iBlccMDORService = ServiceFinder.find(IBlccMDORService.class);
		BlCcDO[] blCcDoArr = iBlccMDORService.find(" fg_canc = 'N' and id_cc = '" + id_cc +"'", "",FBoolean.TRUE);
		
		if(blCcDoArr == null || blCcDoArr.length <= 0)
		{
			return FBoolean.FALSE;
		}
		else {
			return FBoolean.TRUE;
		}	
	}
}
