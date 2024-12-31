package iih.mi.inst.bizgrp.country.ruralcooperinsure.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.insureprop.ruraltmp.d.MiHpPropRuralIpTmpDO;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取新农合医保分摊数据
 * @author yangyang
 * @Date 2018-04-23
 */
public class RuralGetPropDataBp {

	public FArrayList exec(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		//1、获取医保分摊数据
		IMihppropruraliptmpRService rService=ServiceFinder.find(IMihppropruraliptmpRService.class);
		MiHpPropRuralIpTmpDO[] hpPropRuralCoopDoArr=rService.findByAttrValString(MiHpPropRuralIpTmpDO.ID_REF,hisPropertyDTO.getId_ref());
		if(ArrayUtils.isEmpty(hpPropRuralCoopDoArr))
			throw new BizException("未找到原医保分摊信息！");
		MiHpPropRuralIpTmpDO hpPropRuralCoopDo=hpPropRuralCoopDoArr[0];
		//2、使用公式，提炼数据
		CommonPropDataDTO propDataDto=new CommonPropDataDTO();
		propDataDto.setAmt_all(hpPropRuralCoopDo.getAmt_all());
		propDataDto.setAmt_psn(new FDouble(0.00));
		//新农合报销金额 
		//实际报销总额仅仅是是基本农合报销的金额,故这里直接取垫付金额即可
		//N70848垫付总额 = N70836大病保险实际补偿额 + N70837民政救助补偿额 + N70831实际报销总额 - N70846扣减总额
		propDataDto.setAmt_hp(hpPropRuralCoopDo.getAmt_advance()); 
		propDataDto.setAmt_cash(hpPropRuralCoopDo.getAmt_all().sub(propDataDto.getAmt_hp()));
		FArrayList arrayList=new FArrayList();
		arrayList.add(propDataDto);
		return arrayList;
	}
}
