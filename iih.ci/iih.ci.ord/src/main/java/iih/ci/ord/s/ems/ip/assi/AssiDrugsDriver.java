package iih.ci.ord.s.ems.ip.assi;

import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.s.ems.base.BaseEmsDriver;
import iih.ci.ord.s.ems.ip.assi.cp.drugs.CpDrugsDriver;
import iih.ci.ord.s.ems.ip.assi.tpl.commondrugs.TplDrugsDriver;
import xap.mw.core.data.BizException;

/**
 * 西成药医嘱驱动
 * @author Young
 *
 */
public class AssiDrugsDriver extends BaseEmsDriver {
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		if(OrSourceFromEnum.IIHORTMPLHELPER.equals(ctx.getEu_orsrcmdtp())){
			// 医嘱模板逻辑
			return new TplDrugsDriver().save(ctx, ems);
		}
		else if(OrSourceFromEnum.IIHCPHELPER.equals(ctx.getEu_orsrcmdtp())){
			// 临床路径
			return new CpDrugsDriver().save(ctx, ems);
		}
		else if(OrSourceFromEnum.IIHPATIPASTHELPER.equals(ctx.getEu_orsrcmdtp())){
			//就诊历史
			
		}
		
		return null;
	}
}
