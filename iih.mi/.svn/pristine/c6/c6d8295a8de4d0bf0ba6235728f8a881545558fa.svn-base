package iih.mi.inst.bizgrp.country.ruralcooperinsure.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.biz.insureprop.rural.d.MiHpPropArRuralIpDO;
import iih.mi.biz.insureprop.rural.i.IMihpproparruralipCudService;
import iih.mi.biz.insureprop.ruraltmp.d.MiHpPropRuralIpTmpDO;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院收付款医保分摊数据保存
 * @author yangyang
 * @Date 2018-04-26
 */
public class RuralHpPayPropArDataSaveBp {

	public FArrayList exec(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		//前置流程，不用返回业务结果
		if(hpPayRtnValDto==null){
			
		}
		//1、参数校验
		validateParam(hisPropertyDTO);
		//2、获取前置流程下的分摊数据
		IMihppropruraliptmpRService propRService=ServiceFinder.find(IMihppropruraliptmpRService.class);
		MiHpPropRuralIpTmpDO[] ruralIpTmpDoArr=propRService.findByAttrValString(MiHpPropRuralIpTmpDO.ID_REF, hisPropertyDTO.getId_ref_preflow());
		if(ArrayUtils.isEmpty(ruralIpTmpDoArr)){
			throw new BizException("获取患者医保结算信息失败！");
		}
		//3、业务流程获取
		MiHpPropArRuralIpDO arRuralIpDo=new MiHpPropArRuralIpDO();
		//费用总额
		arRuralIpDo.setAmt_all(ruralIpTmpDoArr[0].getAmt_all());
		//可报销总额
		arRuralIpDo.setAmt_hp(ruralIpTmpDoArr[0].getAmt_hp());
		//自付金额
		arRuralIpDo.setAmt_pat(ruralIpTmpDoArr[0].getAmt_pat());
		//实际报销总额
		arRuralIpDo.setAmt_hpactual(ruralIpTmpDoArr[0].getAmt_hpactual());
		//报销政策年度
		arRuralIpDo.setHppolicy(ruralIpTmpDoArr[0].getHppolicy());
		//单病种费用定额
		arRuralIpDo.setAmt_drgs(ruralIpTmpDoArr[0].getAmt_drgs());
		//大病保险可补偿额
		arRuralIpDo.setAmt_sill(ruralIpTmpDoArr[0].getAmt_sill());
		//大病保险实际补偿额
		arRuralIpDo.setAmt_sill_actual(ruralIpTmpDoArr[0].getAmt_sill_actual());
		//大病保险可补偿额
		arRuralIpDo.setAmt_civil(ruralIpTmpDoArr[0].getAmt_civil());
		//整体报销比例
		arRuralIpDo.setRatio_hp(ruralIpTmpDoArr[0].getRatio_hp());
		//本年度累计报销金额
		arRuralIpDo.setAmt_accumyear(ruralIpTmpDoArr[0].getAmt_accumyear());
		//本年度累计报销次数
		arRuralIpDo.setTimes_accumyear(ruralIpTmpDoArr[0].getTimes_accumyear());
		//起付线
		arRuralIpDo.setAmt_lower(ruralIpTmpDoArr[0].getAmt_lower());
		//封顶线
		arRuralIpDo.setAmt_top(ruralIpTmpDoArr[0].getAmt_top());
		//扣减总额
		arRuralIpDo.setAmt_deduc(ruralIpTmpDoArr[0].getAmt_deduc());
		//垫付总额
		arRuralIpDo.setAmt_advance(ruralIpTmpDoArr[0].getAmt_advance());
		arRuralIpDo.setId_proparip(hisPropertyDTO.getId_ref());
		arRuralIpDo.setStatus(DOStatus.NEW);
		IMihpproparruralipCudService cudService=ServiceFinder.find(IMihpproparruralipCudService.class);
		MiHpPropArRuralIpDO[]  propArRuralIpDo=cudService.save(new MiHpPropArRuralIpDO[]{arRuralIpDo});
		FArrayList arrayList=new FArrayList();
		arrayList.add(propArRuralIpDo);
		return arrayList;
	}
	
	/**校验参数信息
	 * @throws BizException
	 */
	private void validateParam(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{	
		if(hisPropertyDTO==null)
			throw new BizException("his业务参数为空！");
		if(hisPropertyDTO.getId_ref_preflow().isEmpty())
			throw new BizException("医保前置流程下，收付款分摊时获取原结算主键为空！");
	}
}
