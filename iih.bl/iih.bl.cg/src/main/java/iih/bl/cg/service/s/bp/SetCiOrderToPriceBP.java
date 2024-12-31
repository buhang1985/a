package iih.bl.cg.service.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.bp.GetBlCgItmOepMap;
import iih.bl.cg.bp.GetStAndIncFromAppendDTO;
import iih.bl.cg.bp.SetBlOrderAppendBillParamDTOPricing;
import iih.bl.cg.dto.d.BlCgItmOepMapDTO;
import iih.bl.cg.ep.EntHpEP;
import iih.bl.cg.ep.OepCgEP;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.inc.service.i.IBlincQryService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.en.pv.entplan.d.EntHpDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class SetCiOrderToPriceBP {

	public BlCgOepAggDTO exec(BlOrderAppendBillParamDTO[] appendBillParamDTOs, OperatorInfoDTO operatorInfoDTO, FBoolean PrintInvocie) throws BizException {

		IBlincQryService iBlincQryService = ServiceFinder.find(IBlincQryService.class);
		/*String code_incpkg = "";// 票据包号
		String incno = ""; // 发票号 //BY LY 没啥用
*/		FDateTime fDateTime = AppUtils.getServerDateTime();

		// 1.部分数据校验和数据完善
		// TODO review:yangyang
		// 能否通过别种手段解决校验问题，如果只是自己构建的appendBillParamDTOs数据源，在创建之初能否就把集团组织赋值
		PriceSettleBP priceSettleBP = new PriceSettleBP();
		priceSettleBP.validateAndPerfect_Pricing(appendBillParamDTOs, operatorInfoDTO);

		// 添加日期2017年6月15日14:08:47 yang.lu
		if (appendBillParamDTOs != null) {
			for (BlOrderAppendBillParamDTO dto : appendBillParamDTOs) {
				// 判断当前预留字段为true的 如果是预交金和商保数据不再进行预留操作 提供计价方法
				if ((dto.getFg_reserveMaterials() != null && dto.getFg_reserveMaterials().booleanValue() && dto.getOutpBillDTO() != null && dto.getOutpBillDTO().getFg_acc() != null && !dto.getOutpBillDTO().getFg_acc().booleanValue() && dto.getOutpBillDTO().getFg_hpcg() != null && !dto.getOutpBillDTO().getFg_hpcg().booleanValue())) {
					dto.setFg_reserveMaterials(FBoolean.FALSE);
				}
				// 判断如果数据为手工记账则将金额赋值到对应的金额字段
				if ("1".equals(dto.getEu_blmd())) {
					if(dto.getFg_modifyprice() != null && dto.getFg_modifyprice().booleanValue()){
						dto.setPrice(dto.getPrice());
						dto.setPrice_ratio(dto.getPrice_ratio());
						dto.setAmt(dto.getPrice_ratio().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
						dto.setAmt_ratio(dto.getPrice_ratio().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
						dto.setAmt_std(dto.getPrice().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
						dto.setAmt_hp(new FDouble(0));
						dto.setAmt_pat(dto.getAmt_ratio());
						dto.setRatio_pripat(dto.getRatio_pripat());
					}else{
						dto.setPrice(dto.getPri());
						dto.setPrice_ratio(dto.getPri().multiply(dto.getPri_ratio()).setScale(-4, BigDecimal.ROUND_HALF_UP));
						dto.setAmt(dto.getPri_ratio().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
						dto.setAmt_ratio(dto.getPrice_ratio().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
						dto.setAmt_std(dto.getPri().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
						dto.setAmt_hp(new FDouble(0));
						dto.setAmt_pat(dto.getAmt_ratio());
						dto.setRatio_pripat(dto.getRatio_pripat());
					}
				}
				// 如果是补费项目,添加Sd_hpsrvtp，
				if (dto.getFg_additm() == FBoolean.TRUE) {
					IHpsrvorcaRService service = ServiceFinder.find(IHpsrvorcaRService.class);
					String whereStr = "ID_SRV='" + dto.getId_srv() + "'";
					HPSrvorcaDO[] srvorcas = service.find(whereStr, "", FBoolean.FALSE);
					if (srvorcas != null && srvorcas.length == 1) {
						dto.setId_hpsrvtp(srvorcas[0].getId_hpsrvtp());
						dto.setSd_hpsrvtp(srvorcas[0].getEu_hpsrvtp().toString());
					}
				}
			}
			// 判断当前划价数据是否是医保的数据并执行医保重复收费项目操作
			FilterHpDtosBP fhpDtosBP=new FilterHpDtosBP();
			fhpDtosBP.exec(appendBillParamDTOs);
		}
		// 2.计价
		SetBlOrderAppendBillParamDTOPricing GetMmToBlOrderAppendBillParamDTOIns = new SetBlOrderAppendBillParamDTOPricing();
		appendBillParamDTOs = GetMmToBlOrderAppendBillParamDTOIns.SetBlOrderAppendBillParamDTOPricing(appendBillParamDTOs);

		// TODO review by yangyang 如果挂号处不需要打发票，这里不需要校验？
		// 3.获得票据包和发票号
		if (PrintInvocie.booleanValue()) {
			////BY LY 没啥用
			/*code_incpkg = iBlincQryService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org_emp(), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
			IBLInvoiceService iBLInvoiceService = ServiceFinder.find(IBLInvoiceService.class);
			incno = iBLInvoiceService.GetInvoiceNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);*/
		}
		
		for (BlOrderAppendBillParamDTO dto : appendBillParamDTOs) {
			if (dto.getId_dep_cg() == null) {
				dto.setId_emp_cg(operatorInfoDTO.getId_emp());
			}
			if (dto.getId_org_cg() == null) {
				dto.setId_org_cg(operatorInfoDTO.getId_org_emp());
			}
		}

		// 4.生成记账表且保存：根据BlOrderAppendBillParamDTO等信息，生成记账表并保存记账表，且修改对应的ci_or_srv.sd_su_bl
		BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();
		BlcgoepAggDO[] blcgoepAggDOs = bLCiOrderToBlCgServiceImplBp.creatBlCgAggDOByDTO(appendBillParamDTOs, PrintInvocie, fDateTime);

		// 5.获得记账表中各个AMT的分项和
		GetBlCgItmOepMap blCgItmOepMapIns = new GetBlCgItmOepMap();
		BlCgItmOepMapDTO blCgItmOepMapDTO = blCgItmOepMapIns.BlCgItmOepConvertToMaps(blcgoepAggDOs, operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE, PrintInvocie);

		// 6.根据计价信息+操作员信息，生成对应的BlStOepDO，且保存
		GetStAndIncFromAppendDTO getStAndIncFromAppendDTO = new GetStAndIncFromAppendDTO();
		BlStOepDO blStOepDO = getStAndIncFromAppendDTO.createStFromCg_OEP(blcgoepAggDOs, operatorInfoDTO, PrintInvocie, blCgItmOepMapDTO, fDateTime);

		// 7.根据记账信息和结算信息，生成对应的发票信息BlincoepAggDO，且保存    
		//BY LY 没啥用
		//BlincoepAggDO blincoepAggDO = getStAndIncFromAppendDTO.createIncByCgAndSt_OEP(blcgoepAggDOs, blStOepDO, PrintInvocie, code_incpkg, incno, blCgItmOepMapDTO, fDateTime);

		// review by yangyang 能否先生成结算信息，再生成记账明细？？
		// 8.用结算ID回写记账表
		blcgoepAggDOs = bLCiOrderToBlCgServiceImplBp.writebackCgBySt(blcgoepAggDOs, blStOepDO, fDateTime);

		//调用分票逻辑  2018/03/28
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		BlincoepAggDO[] incAggDos = incService.saveOpInvoice(blcgoepAggDOs);
		
		
		//BY LY 没啥用 2018/03/28
		/*if (PrintInvocie.booleanValue()) // 如果打印票据，还需要这些内容
		{
			String steop_vs_invoiceno = "";
			String steop_vs_invoicename = "";
			GetBlPsnDocName name_ins = new GetBlPsnDocName();
			steop_vs_invoiceno = blStOepDO.getId_stoep() + "," + incno;
			steop_vs_invoicename = blStOepDO.getId_stoep() + "," + name_ins.GetBlPsnDocName(operatorInfoDTO.getId_emp());
			// 就诊，发票开立人1|就诊，发票开立人2|……|就诊，发票开立人n
			// 开票人姓名与发票关联
			String ent_emp_name = blincoepAggDO.getParentDO().getId_pat() + "," + name_ins.GetBlPsnDocName(operatorInfoDTO.getId_emp()) + "|";
			blcgoepAggDOs[0].getParentDO().setEnt_invoice_empname(ent_emp_name);
			// 结算号,发票号1|结算号，发票号2|……|结算号，发票号n
			blcgoepAggDOs[0].getParentDO().setStoep_invoiceno(steop_vs_invoiceno);
			// 结算号,发票号开立人1|结算号，发票号开立人2|……|结算号，发票号开立人n
			blcgoepAggDOs[0].getParentDO().setStoep_invoicename(steop_vs_invoicename);
		}*/

		// 9.查询医保计划
		EntHpDO[] EntHpDOs = getEntHpDOArrToCgAgg(appendBillParamDTOs);

		// 10.组装BlCgOepAggDTO，包括划价返回结果（记账结果）和记账对应的医保计划
		OepCgEP cgEP = new OepCgEP();
		BlCgOepAggDTO blCgOepAggDTO = cgEP.createBlCgOepAggDTO(blcgoepAggDOs, EntHpDOs);
		return blCgOepAggDTO;
	}

	/**
	 * 查询记账明细就诊对应的医保计划
	 * 
	 * @param blOrderAppendBillParamDTOArr
	 *            记账明细
	 * @return 记账明细就诊对应的医保计划
	 * @throws BizException
	 */
	private EntHpDO[] getEntHpDOArrToCgAgg(BlOrderAppendBillParamDTO[] blOrderAppendBillParamDTOArr) throws BizException {
		List<String> id_entList = new ArrayList<String>();
		// 获得就诊
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : blOrderAppendBillParamDTOArr) {
			if (id_entList.size() == 0) {
				id_entList.add(blOrderAppendBillParamDTO.getId_ent());
			} else {
				if (!id_entList.contains(blOrderAppendBillParamDTO.getId_ent())) {
					id_entList.add(blOrderAppendBillParamDTO.getId_ent());
				}
			}
		}
		EntHpEP enhpep = new EntHpEP();
		return enhpep.getEntHpById_ent(id_entList);

	}
}
