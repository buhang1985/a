package iih.bd.srv.empphydto.s.bp;

import iih.bd.srv.empphydto.d.EmpphyDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医生处方权限取消授权Bp
 * 
 * @author guoyang
 *
 */
public class CancleAuthorizeBp {

	public void exec(EmpphyDTO[] empphyDtos) throws BizException {
		if (empphyDtos == null || empphyDtos.length <= 0) {
			throw new BizException("未选择取消授权人员！");
		} else {
			updatePresrt(empphyDtos);
		}
	}

	/**
	 * 更新人员的医生属性表
	 * 
	 * @param empphyDtos
	 * @throws BizException
	 */
	private void updatePresrt(EmpphyDTO[] empphyDtos) throws BizException {
		UpdatePresrtBp bp = new UpdatePresrtBp();
		bp.exec(empphyDtos, FBoolean.FALSE);
	}

}
