package iih.ci.ord.s.bp.ems.save.ip;

import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 转科申请保存操作BP
 */
public class CiOrapptransdepSaveBP {
	/**
	 * 转科申请保存
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public void exec(OrdApTransDO orappmap,String id_or) throws BizException{
		if(orappmap==null)return;
		if(CiOrdUtils.isEmpty(orappmap.getId_or())){orappmap.setId_or(id_or);}
		CiOrdAppUtils.getOrapptransdepService().save(new OrdApTransDO[]{orappmap});
	}
}
