package iih.ci.ord.s.ems.ip.assi;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.s.ems.base.BaseEmsDriver;
import iih.ci.ord.s.ems.ip.assi.tpl.dead.TplDeadDriver;

/**
 * 死亡医嘱驱动
 * @author Young
 *
 */
public class AssiDeadDriver extends BaseEmsDriver {
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		if(OrSourceFromEnum.IIHORTMPLHELPER.equals(ctx.getEu_orsrcmdtp())){
			// 医嘱模板逻辑
			return new TplDeadDriver().save(ctx, ems);
		}
		else if(OrSourceFromEnum.IIHCPHELPER.equals(ctx.getEu_orsrcmdtp())){
			// 临床路径
//			return new CpDeadDriver().save(ctx, ems);
		}
		else if(OrSourceFromEnum.IIHPATIPASTHELPER.equals(ctx.getEu_orsrcmdtp())){
			//就诊历史
			
		}
		
		return null;
	}
}
