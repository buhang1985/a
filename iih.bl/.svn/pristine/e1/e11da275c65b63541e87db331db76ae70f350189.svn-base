package iih.bl.cg.service.s.bp;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.service.s.bp.qry.OldBlPropArQry;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.desc.BlIncOepDODesc;
import iih.bl.inc.blincoep.i.IBlincoepMDOCudService;
import iih.bl.inc.blincoep.i.IBlincoepMDORService;
import iih.bl.prop.blproparoep.d.BlPropArItmOepDO;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.service.i.IBLPropMaintainService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.util.MiParamUtil;

import java.util.ArrayList;
import java.util.List;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class RefundAndSettlementInsurToSaveBp {
	/**
	 * 保存医保分摊，含三部分数据： 1.红冲的分摊（即退费的分摊） 2.重收的分摊
	 * 3.用分摊数据更新红冲的CG,ST,INC表AMT,AMP_PAT,AMT_HP
	 * 4.用分摊数据更新重收的CG,ST,INC表AMT,AMP_PAT,AMT_HP
	 * 
	 * @param refund_blPropOepDOArr医保退费的分摊1
	 * @param refund_blproparoepAggDOArr
	 *            ：医保退费的分摊1
	 * @param recharge_blPropOepDOArr
	 *            ：医保重收的分摊1
	 * @param recharge_blproparoepAggDOArr
	 *            ：医保重收的分摊1
	 * @param id_stoep
	 *            ：退费结算号
	 * @throws BizException
	 */
	public void exec(BlPropOepDO[] refund_blPropOepDOArr, BlproparoepAggDO[] refund_blproparoepAggDOArr, BlPropOepDO[] recharge_blPropOepDOArr, BlproparoepAggDO[] recharge_blproparoepAggDOArr,
			String id_stoep) throws BizException {

		// 1.处理医保退费产出的分摊信息
		// 1.1 根据id_stoep，找到红冲的结算DO
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] red_blStOepDOArr = iBlstoepRService.find("id_par='" + id_stoep + "' and eu_direct=-1 ", "", FBoolean.FALSE);
		refund_blPropOepDOArr[0].setId_propoep(null);
		refund_blPropOepDOArr[0].setId_stoep(red_blStOepDOArr[0].getId_stoep());
		refund_blPropOepDOArr[0].setEu_direct(-1);
		refund_blPropOepDOArr[0].setStatus(DOStatus.NEW);
		
		
		//根据  id_stoep 查询出原来应收的 id
		OldBlPropArQry qry=new OldBlPropArQry();
		String oldproparId = qry.query(id_stoep);
		

		List<BlPropArItmOepDO> refund_blPropArItmOepDOLst = new ArrayList<BlPropArItmOepDO>();
//		for (BlproparoepAggDO blproparoepAggDO : refund_blproparoepAggDOArr) {
//			BlPropArItmOepDO[] blPropArItmOepDOArr = blproparoepAggDO.getBlPropArItmOepDO();
//			for (BlPropArItmOepDO blPropArItmOepDO : blPropArItmOepDOArr) {
//				refund_blPropArItmOepDOLst.add(blPropArItmOepDO);
//			}
//		}
		for (BlproparoepAggDO blproparoepAggDO : refund_blproparoepAggDOArr) {
			BlPropArOepDO arOepDO = blproparoepAggDO.getParentDO();
			arOepDO.setId_proparoep(null);
			arOepDO.setId_propoep(null);
			arOepDO.setEu_direct(-1);
			arOepDO.setStatus(DOStatus.NEW);
		}
		
		// 医保退费分摊
		BlPropArItmOepDO[] refund_blPropArItmOepDOArr = refund_blPropArItmOepDOLst.toArray(new BlPropArItmOepDO[0]);
		// 1.2 保存退费分摊
		IBLPropMaintainService iBLPropMaintainService = ServiceFinder.find(IBLPropMaintainService.class);
		FMap2 map=iBLPropMaintainService.saveOepProp(refund_blPropOepDOArr, refund_blproparoepAggDOArr);// 保存退费分摊
		BlPropOepDO[] backPropOepDoArrSaved=(BlPropOepDO[])map.get("propoep");
		BlproparoepAggDO[] backPropArOepDoArrSaved=(BlproparoepAggDO[])map.get("proparoep");
		
		BlPropArOepDO backArOepDoSaved=backPropArOepDoArrSaved[0].getParentDO();
		//保存红冲扩展数据
		if( StringUtils.isNotEmpty(backArOepDoSaved.getId_proparoep()))	
		{
			//医保接口调用接口类型
			int miBd0001= MiParamUtil.MIBD0001();
			if(miBd0001==1){
				InsureContext insureContext=new InsureContext();
			    insureContext.setIdHp(backArOepDoSaved.getId_hp());
			    InsureFacade facade=new InsureFacade(insureContext);
			    
			    HisPropertyRefHpDTO dto =new HisPropertyRefHpDTO();
			    dto.setId_ref(backArOepDoSaved.getId_proparoep());
			    dto.setId_ref_prop(backArOepDoSaved.getId_propoep());
			    dto.setId_refold(oldproparId);
			    dto.setId_pat(red_blStOepDOArr[0].getId_pat());
			    facade.saveBackPropDataOep(dto);
			}else{
				MiContext miContext = new MiContext();
				miContext.setIdHp(backArOepDoSaved.getId_hp());
				MiFacade miFacade = new MiFacade(miContext);
				
				HisPropertyRefHpDTO refHpDto = new HisPropertyRefHpDTO();
				refHpDto.setId_ref(backArOepDoSaved.getId_proparoep());
				refHpDto.setId_ref_prop(backArOepDoSaved.getId_propoep());
				refHpDto.setId_refold(oldproparId);
				refHpDto.setId_pat(red_blStOepDOArr[0].getId_pat());
				miFacade.saveBackPropDataOep(refHpDto);	
			}
		}
		//setAmtByIdSt(red_blStOepDOArr[0].getId_stoep(), red_blStOepDOArr, refund_blPropArItmOepDOArr, refund_blproparoepAggDOArr);
		
		// 2.处理医保重收产生的分摊信息
		if (recharge_blPropOepDOArr == null || recharge_blPropOepDOArr.length == 0) {
			return; // 全退的，没有重收的分摊信息
		}

		List<BlPropArItmOepDO> recharge_blPropArItmOepDOLst = new ArrayList<BlPropArItmOepDO>();
		for (BlproparoepAggDO blproparoepAggDO : recharge_blproparoepAggDOArr) {
			BlPropArItmOepDO[] blPropArItmOepDOArr = blproparoepAggDO.getBlPropArItmOepDO();
			for (BlPropArItmOepDO blPropArItmOepDO : blPropArItmOepDOArr) {
				recharge_blPropArItmOepDOLst.add(blPropArItmOepDO);
			}
		}

		// 2.1 根据id_stoep，找到重收的id_stoep
		BlPropArItmOepDO[] recharge_blPropArItmOepDOArr = recharge_blPropArItmOepDOLst.toArray(new BlPropArItmOepDO[0]);
		BlStOepDO[] recharge_blStOepDOArr = iBlstoepRService.find("id_par='" + id_stoep + "' and eu_direct=1 ", "", FBoolean.FALSE);
		recharge_blPropOepDOArr[0].setId_stoep(recharge_blStOepDOArr[0].getId_stoep());
		recharge_blPropOepDOArr[0].setEu_direct(1);
		recharge_blPropOepDOArr[0].setStatus(DOStatus.NEW);

		// 2.2保存重收分摊
		iBLPropMaintainService.saveOepProp(recharge_blPropOepDOArr, recharge_blproparoepAggDOArr);

		setAmtByIdSt(recharge_blStOepDOArr[0].getId_stoep(), recharge_blStOepDOArr, recharge_blPropArItmOepDOArr, recharge_blproparoepAggDOArr);

	}

	/**
	 * 赋值 cg st inc 的 AMT AMT_HP AMT_PAT
	 * 
	 * @param idSt
	 * @param stOepDos
	 * @param propItmOep
	 * @throws BizException
	 */
	private void setAmtByIdSt(String idSt, BlStOepDO[] stOepDos, BlPropArItmOepDO[] propItmOep, BlproparoepAggDO[] propArOepAggs) throws BizException {

		FDouble amt = new FDouble(0);
		FDouble amt_pat = new FDouble(0);
		FDouble amt_hp = new FDouble(0);
		// 1 查找对应的记账明细信息
		IBlCgItmOepDORService red_iBlCgItmOepDORService = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] red_blCgItmOepDO = red_iBlCgItmOepDORService.find("id_stoep='" + idSt + "'", "", FBoolean.FALSE);
		for (BlCgItmOepDO blCgItmOepDO : red_blCgItmOepDO) {
			for (BlPropArItmOepDO blPropArItmOepDO : propItmOep) {
				if (blPropArItmOepDO.getCode().equals(blCgItmOepDO.getCode_srv()) || blPropArItmOepDO.getCode().equals(blCgItmOepDO.getCode_mm())) {
					blCgItmOepDO.setAmt_hp(blPropArItmOepDO.getAmt_hp());
					blCgItmOepDO.setAmt_pat(blPropArItmOepDO.getAmt_pat());
					blCgItmOepDO.setAmt(FDouble.ZERO_DBL.add(blPropArItmOepDO.getAmt_hp()).add(blPropArItmOepDO.getAmt_pat()));
					blCgItmOepDO.setStatus(DOStatus.UPDATED);
					
				}
			}
		}
			if(propArOepAggs!=null&&propArOepAggs.length!=0){
				for (BlproparoepAggDO propArOepAgg : propArOepAggs) {
					if(propArOepAgg.getParentDO()!=null){
						amt_pat = amt_pat.add(propArOepAgg.getParentDO().getAmt_psnacc().add(propArOepAgg.getParentDO().getAmt_cash()));
						amt_hp = amt_hp.add(propArOepAgg.getParentDO().getAmt_hp());
					}
					
				}
		}

		// 2 保存CG表中分摊数据
		IBlCgItmOepDOCudService iBlCgItmOepDOCudService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
		iBlCgItmOepDOCudService.save(red_blCgItmOepDO);
		// 3 修改st表中amt_hp,amt_pat,amt AMT=Amt_ratio-Amt_hp（实际的个人支付部分）
		amt=stOepDos[0].getAmt_ratio().sub(amt_hp);
		
		stOepDos[0].setAmt_hp(amt_hp);
		stOepDos[0].setAmt_pat(amt_pat);
		stOepDos[0].setAmt(amt);
		stOepDos[0].setStatus(DOStatus.UPDATED);
		IBlstoepCudService iBlstoepCudService = ServiceFinder.find(IBlstoepCudService.class);
		iBlstoepCudService.save(stOepDos);

		// 4 修改inc表中amt_hp,amt_pat,amt
		IBlincoepMDORService iBlincoepMDORService = ServiceFinder.find(IBlincoepMDORService.class);
		BlIncOepDO[] refund_BlIncOepDOArr = iBlincoepMDORService.find(" " + BlIncOepDODesc.TABLE_ALIAS_NAME + ".id_stoep='" + idSt + "'", "", FBoolean.FALSE);

		refund_BlIncOepDOArr[0].setAmt(stOepDos[0].getAmt());
		refund_BlIncOepDOArr[0].setAmt_pat(stOepDos[0].getAmt_pat());
		refund_BlIncOepDOArr[0].setAmt_hp(stOepDos[0].getAmt_hp());
		refund_BlIncOepDOArr[0].setStatus(DOStatus.UPDATED);
		// 5 保存发票信息
		IBlincoepMDOCudService iBlincoepMDOCudService = ServiceFinder.find(IBlincoepMDOCudService.class);
		iBlincoepMDOCudService.save(refund_BlIncOepDOArr);

	}
}
