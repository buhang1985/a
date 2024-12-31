package iih.mi.inst.bizgrp.country.ruralcooperinsure.bp;

import org.apache.commons.lang3.ArrayUtils;

import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.insureprop.ruraltmp.d.MiHpPropRuralIpTmpDO;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpCudService;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpRService;
import iih.mi.util.MiCollectionUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 新益华更新医保前置分摊his主键
 * @author xy.zhou
 * @date 2018年5月12日
 */
public class RuralUpdateTmpPropDataBp {
	
	public FArrayList exec(HisPropertyRefHpDTO hisPropertyDTO) throws BizException{
		//查出原来的
		IMihppropruraliptmpRService rService=ServiceFinder.find(IMihppropruraliptmpRService.class);
		MiHpPropRuralIpTmpDO[] miDos=rService.findByAttrValString(MiHpPropRuralIpTmpDO.ID_REF,hisPropertyDTO.getId_refold());
		if(ArrayUtils.isEmpty(miDos))
			throw new BizException("重新关联医保前置流程记录时，未找到原记录！");
		//换上新的关联主键
		miDos[0].setId_ref(hisPropertyDTO.getId_ref());
		miDos[0].setStatus(DOStatus.UPDATED);
		//更新一下
		IMihppropruraliptmpCudService cudService=ServiceFinder.find(IMihppropruraliptmpCudService.class);
		MiHpPropRuralIpTmpDO[] tmpDOs = cudService.update(miDos);
		//哦了
		return MiCollectionUtils.toFArrayList(tmpDOs);
	}
}
