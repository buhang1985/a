package iih.ci.ord.s.ems.op.base;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.DiagRstDTO;
import iih.ci.ord.i.meta.DiagSaveDTO;
import iih.ci.ord.s.ems.itf.bp.IDiagSignBP;
import xap.mw.core.data.BizException;

/**
 * 诊断签署逻辑基类
 * 
 * @author wangqingzhu
 *
 */
public class OpBaseDiagSignBP extends OpBaseDiagSaveBP implements IDiagSignBP {

	@Override
	public DiagRstDTO save(CiEnContextDTO ctx, DiagSaveDTO diSaveInfo) throws BizException {
		// TODO Auto-generated method stub
		return super.save(ctx, diSaveInfo);
	}

	@Override
	public DiagRstDTO sign(CiEnContextDTO ctx, DiagSaveDTO diSignInfo) throws BizException {
		// TODO Auto-generated method stub
		return this.save(ctx, diSignInfo);
	}

}
