package iih.mi.inst.bizgrp.country.ruralcooperinsure.bp;

import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.biz.insureprop.ruraltmp.d.HpPropDirectEnum;
import iih.mi.biz.insureprop.ruraltmp.d.MiHpPropRuralIpTmpDO;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpCudService;
import iih.mi.util.MiCollectionUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/**农合医保分摊数据保存
 * @author yangyang
 * @Date 2018-04-13
 */
public class RuralHpPropDataSaveBp {

	public FArrayList exec(InpPayRtnValDTO inpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		//国家新农合医保分摊数据存储
		MiHpPropRuralIpTmpDO hpPropRuralCoopDo=new MiHpPropRuralIpTmpDO();
		//总金额
		hpPropRuralCoopDo.setAmt_all(inpPayRtnValDto.getAmt_all());
		hpPropRuralCoopDo.setAmt_pat(inpPayRtnValDto.getAmt_pat());
		hpPropRuralCoopDo.setHppolicy(inpPayRtnValDto.getHppolicy());
		//可报销总额
		hpPropRuralCoopDo.setAmt_hp(inpPayRtnValDto.getHp_amtall());
		//实际报销总额
		hpPropRuralCoopDo.setAmt_hpactual(inpPayRtnValDto.getHp_amtallactual());
		hpPropRuralCoopDo.setAmt_drgs(inpPayRtnValDto.getDrgsamt());
		//大病保险可补偿额
		hpPropRuralCoopDo.setAmt_sill(inpPayRtnValDto.getBigill_amt());
		//大病保险实际补偿额
		hpPropRuralCoopDo.setAmt_sill_actual(inpPayRtnValDto.getBigill_amtactual());
		hpPropRuralCoopDo.setAmt_civil(inpPayRtnValDto.getCivilamt());
		hpPropRuralCoopDo.setRatio_hp(inpPayRtnValDto.getHp_ratio());
		//本年度累计报销金额
		hpPropRuralCoopDo.setAmt_accumyear(inpPayRtnValDto.getAccumamt_year());
		//本年度累计报销次数
		hpPropRuralCoopDo.setTimes_accumyear(inpPayRtnValDto.getTimes());
		hpPropRuralCoopDo.setAmt_lower(inpPayRtnValDto.getLower_amt());
		hpPropRuralCoopDo.setAmt_top(inpPayRtnValDto.getTop_amt());
		hpPropRuralCoopDo.setAmt_deduc(inpPayRtnValDto.getAmtall_deduc());
		hpPropRuralCoopDo.setAmt_advance(inpPayRtnValDto.getAmt_advance());
		//正向分摊
		hpPropRuralCoopDo.setEu_direct(HpPropDirectEnum.HPCHARGE);
		//引用的关联字段
		hpPropRuralCoopDo.setId_ref(hisPropertyDTO.getId_ref());
		hpPropRuralCoopDo.setStatus(DOStatus.NEW);
		//分摊数据初始化
		IMihppropruraliptmpCudService service=ServiceFinder.find(IMihppropruraliptmpCudService.class);
		MiHpPropRuralIpTmpDO[] ruralCoopDos=service.save(new MiHpPropRuralIpTmpDO[]{hpPropRuralCoopDo});
		return MiCollectionUtils.toFArrayList(ruralCoopDos);
	}
}
