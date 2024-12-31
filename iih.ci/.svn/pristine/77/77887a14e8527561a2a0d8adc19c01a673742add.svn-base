package iih.ci.ord.s.bp.ems.save.ip;

import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpAgainDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/*
 * 手术申请保存操作BP
 */
public class CiOrappoptSaveBP {
	/**
	 * 手术申请保存
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public void exec(CiorappsurgeryAggDO orappmap,String id_or) throws BizException{
		if(orappmap==null || orappmap.getParentDO()==null)return;
		if(CiOrdUtils.isEmpty(orappmap.getParentDO().getId_or())){orappmap.getParentDO().setId_or(id_or);}
		OrdApOpAgainDO[] opAgains = orappmap.getOrdApOpAgainDO();
		if(opAgains!=null&&opAgains.length>0){
			for(OrdApOpAgainDO apOp : opAgains){
				apOp.setStatus(DOStatus.DELETED);
			}
		}
		CiOrdAppUtils.getOrappsurgerytService().save(new CiorappsurgeryAggDO[]{orappmap});
	}
}
