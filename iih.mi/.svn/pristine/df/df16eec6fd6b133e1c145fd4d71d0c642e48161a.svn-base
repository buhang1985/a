package iih.mi.inst.bizgrp.country.ruralcooperinsure.bp;

import org.apache.commons.lang3.ArrayUtils;

import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.biz.insureprop.rural.d.MiHpPropArRuralIpDO;
import iih.mi.biz.insureprop.rural.i.IMihpproparruralipCudService;
import iih.mi.biz.insureprop.rural.i.IMihpproparruralipRService;
import iih.mi.util.MiCollectionUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/** 构建退费红冲分摊数据存储业务逻辑
 * @author yangyang
 *
 */
public class RuralPayBackPropDataSaveBp {

	public FArrayList exec(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		//1、校验参数
		validateParam(hisPropertyDTO);
		//医保分摊数据查询服务
		IMihpproparruralipRService rService=ServiceFinder.find(IMihpproparruralipRService.class);
		MiHpPropArRuralIpDO[] arIpDoArr=rService.findByAttrValString(MiHpPropArRuralIpDO.ID_PROPARIP,hisPropertyDTO.getId_refold());
		if(ArrayUtils.isEmpty(arIpDoArr))
			throw new BizException("未查询到原医保分摊数据！");
		MiHpPropArRuralIpDO arIpDoBack=(MiHpPropArRuralIpDO)arIpDoArr[0].clone();
		arIpDoBack.setId_propariprural(null);
		arIpDoBack.setStatus(DOStatus.NEW);
		arIpDoBack.setId_proparip(hisPropertyDTO.getId_ref());
		IMihpproparruralipCudService cudService=ServiceFinder.find(IMihpproparruralipCudService.class);
		MiHpPropArRuralIpDO[] savedAripDoArr=cudService.save(new MiHpPropArRuralIpDO[]{arIpDoBack});
		FArrayList arrayList=MiCollectionUtils.toFArrayList(savedAripDoArr);
		return arrayList;
	}
	
	private void validateParam(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		if(hisPropertyDTO==null)
			throw new BizException("获取原医保扩展表数据时，his业务数据为空！");
		if(hisPropertyDTO.getId_refold().isEmpty())
			throw new BizException("获取原医保扩展表数据时，his业务数据中原关联字段为空！");
		if(hisPropertyDTO.getId_ref().isEmpty())
			throw new BizException("获取原医保扩展表数据时，his业务数据中现关联字段id_ref为空！");
	}
}
