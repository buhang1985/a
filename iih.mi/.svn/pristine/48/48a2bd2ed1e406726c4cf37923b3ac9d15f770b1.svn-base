package iih.mi.inst.bizgrp.country.ruralcooperinsure.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.insureprop.ruraltmp.d.HpPropDirectEnum;
import iih.mi.biz.insureprop.ruraltmp.d.MiHpPropRuralIpTmpDO;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpCudService;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpRService;
import iih.mi.util.MiCollectionUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/** 前置流程下新农合医保分摊保存
 * @author yangyang
 * @Date 2018-04-18
 */
public class RuralBackHpPropDataSaveBp {

	public FArrayList exec(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		//1、参数校验
		validateParam(hisPropertyDTO);
		//2、获取原医保数据
		IMihppropruraliptmpCudService cudService=ServiceFinder.find(IMihppropruraliptmpCudService.class);
		IMihppropruraliptmpRService rService=ServiceFinder.find(IMihppropruraliptmpRService.class);
		MiHpPropRuralIpTmpDO[] hpPropRuralCoopDoArr=rService.findByAttrValString(MiHpPropRuralIpTmpDO.ID_REF,hisPropertyDTO.getId_refold());
		if(ArrayUtils.isEmpty(hpPropRuralCoopDoArr))
			throw new BizException("未找到原医保分摊信息！");
		//分摊数据初始化
		MiHpPropRuralIpTmpDO propDataOld=hpPropRuralCoopDoArr[0];
		MiHpPropRuralIpTmpDO propBackData=new MiHpPropRuralIpTmpDO();
		propBackData.setAmt_all(propDataOld.getAmt_all());
		propBackData.setAmt_pat(propDataOld.getAmt_pat());
		propBackData.setHppolicy(propDataOld.getHppolicy());
		propBackData.setAmt_hpactual(propDataOld.getAmt_hpactual());
		propBackData.setAmt_hp(propDataOld.getAmt_hp());
		propBackData.setAmt_drgs(propDataOld.getAmt_drgs());
		propBackData.setAmt_sill(propDataOld.getAmt_sill());
		propBackData.setAmt_sill_actual(propDataOld.getAmt_sill_actual());
		propBackData.setAmt_civil(propDataOld.getAmt_civil());
		propBackData.setRatio_hp(propDataOld.getRatio_hp());
		propBackData.setAmt_accumyear(propDataOld.getAmt_accumyear());
		propBackData.setAmt_lower(propDataOld.getAmt_lower());
		propBackData.setAmt_top(propDataOld.getAmt_top());
		propBackData.setAmt_deduc(propDataOld.getAmt_deduc());
		propBackData.setAmt_advance(propDataOld.getAmt_advance());
		propBackData.setId_ref(hisPropertyDTO.getId_ref());
		propBackData.setTimes_accumyear(propDataOld.getTimes_accumyear());
		//分摊方向
		propBackData.setEu_direct(HpPropDirectEnum.HPBACK);
		propBackData.setStatus(DOStatus.NEW);
		MiHpPropRuralIpTmpDO[] ruralCoopDos=cudService.save(new MiHpPropRuralIpTmpDO[]{propBackData});
		return MiCollectionUtils.toFArrayList(ruralCoopDos);
	}
	
	private void validateParam(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		if(hisPropertyDTO==null)
			throw new BizException("农合撤销结算，his业务数据HisPropertyRefHpDTO为null！");
//		if(hisPropertyDTO.getId_ref().isEmpty())
//			throw new BizException("农合撤销结算，his业务数据HisPropertyRefHpDTO中关联字段id_ref为null！");
		if(hisPropertyDTO.getId_refold().isEmpty())
			throw new BizException("农合撤销结算，his业务数据HisPropertyRefHpDTO中关联字段id_refold为null！");
	}
}
