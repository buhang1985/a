package iih.bl.cg.bp;

import iih.bd.pp.pripat.i.IPripatCalService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.dto.d.BlCgItmOepMapDTO;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.service.i.IBLInvoiceService;
//import iih.bl.inc.blinciss.Service.i.IBLInvoiceService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 合计bl_cg_itm_oep中各种amt的逻辑
 * 
 * @author tcy
 *
 */
public class GetBlCgItmOepMap {

	/**
	 * <KEY,结算主键>
	 * 
	 * @param blStOepDO
	 * @param PrintOnlyOneInvoice
	 */
	public BlCgItmOepMapDTO blStOepConvertToMaps(BlStOepDO blStOepDO) {
		BlCgItmOepMapDTO blCgItmOepMapDTO = new BlCgItmOepMapDTO();
		HashMap<String, String> blStOepMapEnt = new HashMap<String, String>();
		String key = "";
		// for(int j1=0;j1<blStOepDO.length;j1++)
		// {
		// //
		// key=blStOepDO[j1].getId_pat()+" "+blStOepDO[j1].getId_ent()+" "+blStOepDO[j1].getId_enttp();
		// // if(PrintOnlyOneInvoice.equals(FBoolean.TRUE))
		// // {
		// key=blStOepDO[j1].getId_pat();//2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
		// // }
		// if(!blStOepMapEnt.containsKey(key))
		// {
		// blStOepMapEnt.put(key, blStOepDO[j1].getId_stoep()) ;
		// }
		// }
		// 2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
		blStOepMapEnt.put(blStOepDO.getId_pat(), blStOepDO.getId_stoep());
		blCgItmOepMapDTO.setBlStOepMapEnt(blStOepMapEnt);
		return blCgItmOepMapDTO;
	}

	/*
	 * 一次遍历获得个AMT分项合 Map<就诊,结账序号> Map<就诊，标志金额> Map<就诊,患者自付>
	 */
	public BlCgItmOepMapDTO BlCgItmOepConvertToMaps(BlcgoepAggDO[] blcgoepAggDO, String Id_emp_inc, String code_incca, FBoolean PrintInvocie) throws BizException {
		IBLInvoiceService obj11 = ServiceFinder.find(IBLInvoiceService.class);
		IPripatCalService obj22 = ServiceFinder.find(IPripatCalService.class);
		BlCgItmOepMapDTO blCgItmOepMapDTO = new BlCgItmOepMapDTO();
		HashMap<String, String> blCgItmOepMapEnt = new HashMap<String, String>();
		HashMap<String, FDouble> blCgItmOepAmtStdMap = new HashMap<String, FDouble>();
		HashMap<String, FDouble> blCgItmOepAmtPatMap = new HashMap<String, FDouble>();
		HashMap<String, FDouble> blCgItmOepAmtRatioMap = new HashMap<String, FDouble>();
		HashMap<String, FDouble> blCgItmOepAmtMap = new HashMap<String, FDouble>();
		HashMap<String, FDouble> blCgItmOepAmtHpMap = new HashMap<String, FDouble>();
		HashMap<String, String> blCgItmOepMapInc = new HashMap<String, String>();
		HashMap<String, String> blCgItmOepMapInc_temp = new HashMap<String, String>();
		HashMap<String, FDouble> blCgItmOepMapPripat = new HashMap<String, FDouble>();
		HashMap<String, String> blCgItmOepMapIdPripat = new HashMap<String, String>();
		// 《发票代码+“,"+发票名称，发票账单项_门急体》
		HashMap<String, BlIncItmOepDO> blCgIncTypeBlIncItmOepDOMap = new HashMap<String, BlIncItmOepDO>();

		String key = "", keyInvoice = "", keyInvoiceType = "";
		String entAndno = "";
		FDouble rate;

		String invoiceNo = "";
		// 记账明细
		BlCgItmOepDO[] blCgItmOepDOs;// =blcgoepAggDO.getBlCgItmOepDO();
		List<BlCgItmOepDO> BlCgItmOepDOlist = new ArrayList<BlCgItmOepDO>();
		BlcgoepAggDO tempBlcgoepAggDO;
		String keyEnt = "";
		DAFacade dafacade = new DAFacade();
		String[] fields = { "id_pripat" };
		for (int i = 0; i < blcgoepAggDO.length; i++) {
			blCgItmOepDOs = blcgoepAggDO[i].getBlCgItmOepDO();
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				BlCgItmOepDOlist.add(blCgItmOepDOs[j]);
			}
		}
		blCgItmOepDOs = BlCgItmOepDOlist.toArray(new BlCgItmOepDO[] {});

		FDouble amt = new FDouble(0);
		FDouble amt_std = new FDouble(0);
		FDouble amt_pat = new FDouble(0);
		FDouble amt_Ratio = new FDouble(0);
		FDouble amt_hp = new FDouble(0);

		FDouble amt_inctype = new FDouble(0);
		FDouble amt_std_inctype = new FDouble(0);
		FDouble amt_pat_inctype = new FDouble(0);
		FDouble amt_ratio_inctype = new FDouble(0);
		FDouble amt_hp_inctype = new FDouble(0);
		for (int j1 = 0; j1 < blCgItmOepDOs.length; j1++) // 记账明细
		{
			// TODO review by yangyang
			if (blCgItmOepDOs[j1].getFg_refund() != null && blCgItmOepDOs[j1].getFg_refund().booleanValue())
				continue;
			
			//by ly 2018/03/28 没啥用
			keyInvoiceType = blCgItmOepDOs[j1].getCode_inccaitm() + "," + blCgItmOepDOs[j1].getName_inccaitm();
			if (blCgIncTypeBlIncItmOepDOMap.containsKey(keyInvoiceType)) {
				BlIncItmOepDO blIncItmOepDO = blCgIncTypeBlIncItmOepDOMap.get(keyInvoiceType);
				amt_inctype = blIncItmOepDO.getAmt().add(blCgItmOepDOs[j1].getAmt());
				amt_pat_inctype = blIncItmOepDO.getAmt_pat().add(blCgItmOepDOs[j1].getAmt_pat());
				amt_std_inctype = blIncItmOepDO.getAmt_std().add(blCgItmOepDOs[j1].getAmt_std());
				amt_hp_inctype = blIncItmOepDO.getAmt_hp().add(blCgItmOepDOs[j1].getAmt_hp());
				amt_ratio_inctype = blIncItmOepDO.getAmt_ratio().add(blCgItmOepDOs[j1].getAmt_ratio());
				blIncItmOepDO.setCode(blCgItmOepDOs[j1].getCode_inccaitm());
				blIncItmOepDO.setName(blCgItmOepDOs[j1].getName_inccaitm());
				blIncItmOepDO.setAmt_std(amt_std_inctype);
				blIncItmOepDO.setAmt_pat(amt_pat_inctype);
				blIncItmOepDO.setAmt_hp(amt_hp_inctype);
				blIncItmOepDO.setAmt_ratio(amt_ratio_inctype);
				blIncItmOepDO.setAmt(amt_inctype);
				blIncItmOepDO.setStatus(DOStatus.NEW);
				blCgIncTypeBlIncItmOepDOMap.remove(keyInvoiceType);
				blCgIncTypeBlIncItmOepDOMap.put(keyInvoiceType, blIncItmOepDO);
			} else {
				BlIncItmOepDO blIncItmOepDO = new BlIncItmOepDO();
				blIncItmOepDO.setId_incitmoep(null);
				blIncItmOepDO.setId_incoep(null);
				blIncItmOepDO.setCode(blCgItmOepDOs[j1].getCode_inccaitm());
				blIncItmOepDO.setName(blCgItmOepDOs[j1].getName_inccaitm());
				blIncItmOepDO.setAmt_std(blCgItmOepDOs[j1].getAmt_std());
				blIncItmOepDO.setAmt_pat(blCgItmOepDOs[j1].getAmt_pat());
				blIncItmOepDO.setAmt_hp(blCgItmOepDOs[j1].getAmt_hp());
				blIncItmOepDO.setAmt_ratio(blCgItmOepDOs[j1].getAmt_ratio());
				blIncItmOepDO.setAmt(blCgItmOepDOs[j1].getAmt());
				blIncItmOepDO.setAmt_free(new FDouble(0));
				blIncItmOepDO.setStatus(DOStatus.NEW);
				blCgIncTypeBlIncItmOepDOMap.put(keyInvoiceType, blIncItmOepDO);
			}
			// if(PrintOnlyOneInvoice.booleanValue())
			// //多次就诊打印一张发票,2017-1-11，增加多次就诊一次结算只能打印一张发票
			// {
			key = blCgItmOepDOs[j1].getId_pat();
			// }
			// else//多次就诊打印多张发票
			// {
			// key=blCgItmOepDOs[j1].getId_pat()+" "+blCgItmOepDOs[j1].getId_ent()+" "+blCgItmOepDOs[j1].getId_enttp();
			// }
			//

			if (!blCgItmOepMapEnt.containsKey(key)) {
				blCgItmOepMapEnt.put(key, blCgItmOepDOs[j1].getId_cgitmoep());
			}

			if (!blCgItmOepMapInc_temp.containsKey(key))// 就诊，发票号
			{
				blCgItmOepMapInc_temp.put(key, "");
			}

			if (!blCgItmOepMapPripat.containsKey(key)) // 就诊，价格分类
			{
				if (blCgItmOepDOs[j1].getId_pripat() == null || ("~").equals(blCgItmOepDOs[j1].getId_pripat())) {
					// 在就诊表中查询价格分类
					List<PatiVisitDO> PatiVisitDOlist = (List<PatiVisitDO>) dafacade.findByCond(PatiVisitDO.class, " id_ent='" + blCgItmOepDOs[j1].getId_ent() + "'", fields);
					if (null == PatiVisitDOlist || PatiVisitDOlist.size() == 0) {
						throw new BizException("该患者没有设置价格分类");
					}

					blCgItmOepDOs[j1].setId_pripat(PatiVisitDOlist.toArray(new PatiVisitDO[] {})[0].getId_pripat());
				}
				// 查价格分类系数
				blCgItmOepMapPripat.put(key, blCgItmOepDOs[j1].getRatio_pripat());
				blCgItmOepMapIdPripat.put(key, blCgItmOepDOs[j1].getId_pripat());
			}

			if (blCgItmOepAmtMap.containsKey(key)) {
				amt = blCgItmOepAmtMap.get(key);
				amt = amt.add(blCgItmOepDOs[j1].getAmt());
			} else {
				amt = blCgItmOepDOs[j1].getAmt();
			}
			blCgItmOepAmtMap.put(key, amt);

			if (blCgItmOepAmtStdMap.containsKey(key)) {
				amt_std = blCgItmOepAmtStdMap.get(key);
				amt_std = amt_std.add(blCgItmOepDOs[j1].getAmt_std());
			} else {
				amt_std = blCgItmOepDOs[j1].getAmt_std();
			}
			blCgItmOepAmtStdMap.put(key, amt_std);

			if (blCgItmOepAmtPatMap.containsKey(key)) {
				amt_pat = blCgItmOepAmtPatMap.get(key);
				amt_pat = amt_pat.add(blCgItmOepDOs[j1].getAmt_pat());

			} else {
				amt_pat = blCgItmOepDOs[j1].getAmt_pat();
			}
			blCgItmOepAmtPatMap.put(key, amt_pat);
			
			if (blCgItmOepAmtRatioMap.containsKey(key)) {
				amt_Ratio = blCgItmOepAmtRatioMap.get(key);
				amt_Ratio = amt_Ratio.add(blCgItmOepDOs[j1].getAmt_ratio());
			} else {
				amt_Ratio = blCgItmOepDOs[j1].getAmt_ratio();
			}
			blCgItmOepAmtRatioMap.put(key, amt_Ratio);

			if (blCgItmOepAmtHpMap.containsKey(key)) {
				amt_hp = blCgItmOepAmtHpMap.get(key);
				if (blCgItmOepDOs[j1].getAmt_hp() != null) {
					amt_hp = amt_hp.add(blCgItmOepDOs[j1].getAmt_hp());
				}
			} else {
				if (blCgItmOepDOs[j1].getAmt_hp() != null) {
					amt_hp = blCgItmOepDOs[j1].getAmt_hp();
				} else {
					amt_hp = new FDouble(0);
				}
			}
			blCgItmOepAmtHpMap.put(key, amt_hp);
		}

		/*if (PrintInvocie.booleanValue()) // 需要打发票
		{
			invoiceNo = obj11.GetInvoiceNo(Id_emp_inc, code_incca);
			blCgItmOepMapDTO.setSt_first_incno(invoiceNo);

			// for(int j1=0;j1<blCgItmOepDOs.length;j1++)
			// {
			//
			// key=blCgItmOepDOs[j1].getId_pat()+" "+blCgItmOepDOs[j1].getId_ent()+" "+blCgItmOepDOs[j1].getId_enttp();
			// keyEnt=key;
			// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE))
			// {
			// keyInvoice=blCgItmOepDOs[j1].getId_pat();
			// }
			// else
			// {
			// keyInvoice=key;
			// }
			// if(PrintInvocie.booleanValue()) //需要打发票
			// {
			// if(!blCgItmOepMapInc.containsKey(keyInvoice))//就诊，发票号
			// {
			// blCgItmOepMapInc.put(keyInvoice, invoiceNo[j1]);
			// entAndno=entAndno+keyInvoice+","+invoiceNo[j1]+"|";
			// }
			// }
			// }
			entAndno = entAndno + keyInvoice + "," + invoiceNo + "|";
			blCgItmOepMapDTO.setEntAndno(entAndno);
		} else {
			blCgItmOepMapDTO.setSt_first_incno("");
		}*/
		blCgItmOepMapDTO.setBlCgItmOepMapInc(blCgItmOepMapInc);
		blCgItmOepMapDTO.setBlCgItmOepMapPripat(blCgItmOepMapPripat);
		blCgItmOepMapDTO.setBlCgItmOepMapIdPripat(blCgItmOepMapIdPripat);
		blCgItmOepMapDTO.setBlCgItmOepMapEnt(blCgItmOepMapEnt);
		blCgItmOepMapDTO.setBlCgItmOepAmtStdMap(blCgItmOepAmtStdMap);
		blCgItmOepMapDTO.setBlCgItmOepAmtPatMap(blCgItmOepAmtPatMap);
		blCgItmOepMapDTO.setBlCgItmOepAmtRatioMap(blCgItmOepAmtRatioMap);
		blCgItmOepMapDTO.setBlCgItmOepAmtMap(blCgItmOepAmtMap);
		blCgItmOepMapDTO.setBlCgItmOepAmtHpMap(blCgItmOepAmtHpMap);
		blCgItmOepMapDTO.setBlCgIncTypeBlIncItmOepDOMap(blCgIncTypeBlIncItmOepDOMap);
		return blCgItmOepMapDTO;
	}

	/*
	 * 一次遍历获得: Map<就诊,结账序号> Map<就诊，标志金额> Map<就诊,患者自付>
	 */
	public BlCgItmOepMapDTO BlCgItmOepConvertToAmtMaps(BlcgoepAggDO[] blcgoepAggDO) throws BizException {
		IBLInvoiceService obj11 = ServiceFinder.find(IBLInvoiceService.class);
		IPripatCalService obj22 = ServiceFinder.find(IPripatCalService.class);
		BlCgItmOepMapDTO blCgItmOepMapDTO = new BlCgItmOepMapDTO();
		HashMap<String, String> blCgItmOepMapEnt = new HashMap<String, String>();
		HashMap<String, FDouble> blCgItmOepAmtStdMap = new HashMap<String, FDouble>();
		HashMap<String, FDouble> blCgItmOepAmtPatMap = new HashMap<String, FDouble>();
		HashMap<String, FDouble> blCgItmOepAmtRatioMap = new HashMap<String, FDouble>();
		HashMap<String, FDouble> blCgItmOepAmtMap = new HashMap<String, FDouble>();
		HashMap<String, FDouble> blCgItmOepAmtHpMap = new HashMap<String, FDouble>();

		// 记账明细
		BlCgItmOepDO[] blCgItmOepDOs;// =blcgoepAggDO.getBlCgItmOepDO();
		List<BlCgItmOepDO> BlCgItmOepDOlist = new ArrayList<BlCgItmOepDO>();

		for (int i = 0; i < blcgoepAggDO.length; i++) {
			blCgItmOepDOs = blcgoepAggDO[i].getBlCgItmOepDO();
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				BlCgItmOepDOlist.add(blCgItmOepDOs[j]);
			}
		}
		blCgItmOepDOs = BlCgItmOepDOlist.toArray(new BlCgItmOepDO[] {});
		String key = "";
		FDouble amt = new FDouble(0);
		FDouble amt_std = new FDouble(0);
		FDouble amt_pat = new FDouble(0);
		FDouble amt_ratio = new FDouble(0);
		FDouble amt_hp = new FDouble(0);
		for (int j1 = 0; j1 < blCgItmOepDOs.length; j1++) // 记账明细
		{

			// if(PrintOnlyOneInvoice.booleanValue()) //多次就诊打印一张发票
			// {
			// //2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
			key = blCgItmOepDOs[j1].getId_pat();
			// }
			// else//多次就诊打印多张发票
			// {
			// key=blCgItmOepDOs[j1].getId_pat()+" "+blCgItmOepDOs[j1].getId_ent()+" "+blCgItmOepDOs[j1].getId_enttp();
			// }
			amt = amt.add(blCgItmOepDOs[j1].getAmt());
			amt_std = amt_std.add(blCgItmOepDOs[j1].getAmt_std());
			amt_ratio = amt_ratio.add(blCgItmOepDOs[j1].getAmt_ratio());
			amt_hp = amt_hp.add(blCgItmOepDOs[j1].getAmt_hp());
			amt_pat = amt_pat.add(blCgItmOepDOs[j1].getAmt_pat());

			//
			// if(blCgItmOepAmtMap.containsKey(key))
			// {
			// amt=blCgItmOepAmtMap.get(key);
			// amt=amt.add(blCgItmOepDOs[j1].getAmt());
			//
			// blCgItmOepAmtMap.remove(key);
			// blCgItmOepAmtMap.put(key,amt);
			// }
			// else
			// {
			// amt=blCgItmOepDOs[j1].getAmt();
			// blCgItmOepAmtMap.put(key, amt);
			// }
			//
			// if(blCgItmOepAmtStdMap.containsKey(key))
			// {
			// amt_std=blCgItmOepAmtStdMap.get(key);
			// amt_std=amt_std.add(blCgItmOepDOs[j1].getAmt_std());
			//
			// blCgItmOepAmtStdMap.remove(key);
			// blCgItmOepAmtStdMap.put(key,amt_std);
			// }
			// else
			// {
			// amt_std=blCgItmOepDOs[j1].getAmt_std();
			// blCgItmOepAmtStdMap.put(key, amt_std);
			// }
			//
			//
			// if(blCgItmOepAmtPatMap.containsKey(key))
			// {
			// amt_pat=blCgItmOepAmtPatMap.get(key);
			// amt_pat=amt_pat.add(blCgItmOepDOs[j1].getAmt_pat());
			//
			// blCgItmOepAmtPatMap.remove(key);
			// blCgItmOepAmtPatMap.put(key, amt_pat);
			// }
			// else
			// {
			// amt_pat=blCgItmOepDOs[j1].getAmt_pat();
			// blCgItmOepAmtPatMap.put(key, amt_pat);
			// }
			//
			// if(blCgItmOepAmtRatioMap.containsKey(key))
			// {
			// amt_ratio=blCgItmOepAmtRatioMap.get(key);
			// amt_ratio=amt_ratio.add(blCgItmOepDOs[j1].getAmt_ratio());
			//
			// blCgItmOepAmtRatioMap.remove(key);
			// blCgItmOepAmtRatioMap.put(key, amt_ratio);
			// }
			// else
			// {
			// amt_pat=blCgItmOepDOs[j1].getAmt_ratio();
			// blCgItmOepAmtRatioMap.put(key, amt_ratio);
			// }
			//
			// if(blCgItmOepAmtHpMap.containsKey(key))
			// {
			// amt_hp=blCgItmOepAmtHpMap.get(key);
			// if(blCgItmOepDOs[j1].getAmt_hp()!=null)
			// {
			// amt_hp=amt_hp.add(blCgItmOepDOs[j1].getAmt_hp());
			// blCgItmOepAmtHpMap.remove(key);
			// blCgItmOepAmtHpMap.put(key, amt_hp);
			// }
			// }
			// else
			// {
			// if(blCgItmOepDOs[j1].getAmt_hp()!=null)
			// {
			// amt_hp=blCgItmOepDOs[j1].getAmt_hp();
			// }
			// else
			// {
			// amt_hp=new FDouble(0);
			// }
			// blCgItmOepAmtHpMap.put(key, amt_hp);
			// }
		}
		blCgItmOepAmtStdMap.put(blCgItmOepDOs[0].getId_pat(), amt_std);
		blCgItmOepAmtPatMap.put(blCgItmOepDOs[0].getId_pat(), amt_pat);
		blCgItmOepAmtRatioMap.put(blCgItmOepDOs[0].getId_pat(), amt_ratio);
		blCgItmOepAmtMap.put(blCgItmOepDOs[0].getId_pat(), amt);
		blCgItmOepAmtHpMap.put(blCgItmOepDOs[0].getId_pat(), amt_hp);
		blCgItmOepMapDTO.setBlCgItmOepAmtStdMap(blCgItmOepAmtStdMap);
		blCgItmOepMapDTO.setBlCgItmOepAmtPatMap(blCgItmOepAmtPatMap);
		blCgItmOepMapDTO.setBlCgItmOepAmtRatioMap(blCgItmOepAmtRatioMap);
		blCgItmOepMapDTO.setBlCgItmOepAmtMap(blCgItmOepAmtMap);
		blCgItmOepMapDTO.setBlCgItmOepAmtHpMap(blCgItmOepAmtHpMap);
		return blCgItmOepMapDTO;
	}

	/*
	 * @PrintInvocie：是否打发票，如果打发票，则进行下面判断
	 * 
	 * @code_incpkg:如果打发票，对应的票据包编号 一次遍历获得: 就诊，发票号1|就诊，发票号2|...| （返回值）
	 * Map<就诊，患者本次就诊价格分类> 否则： 病人ID，发票号|
	 */
	public BlCgItmOepMapDTO BlCgItmOepConvertToMapIncPripats(BlOrderAppendBillParamDTO[] appendBillParamDTOs, String Id_emp_inc, String code_incca, FBoolean PrintInvocie, String code_incpkg) throws BizException {
		IBLInvoiceService obj11 = ServiceFinder.find(IBLInvoiceService.class);
		IPripatCalService obj22 = ServiceFinder.find(IPripatCalService.class);
		BlCgItmOepMapDTO blCgItmOepMapDTO = new BlCgItmOepMapDTO();
		// IPativisitRService
		// en_entS=ServiceFinder.find(IPativisitRService.class);
		HashMap<String, String> blCgItmOepMapInc = new HashMap<String, String>();
		HashMap<String, String> blCgItmOepMapInc_temp = new HashMap<String, String>();
		HashMap<String, FDouble> blCgItmOepMapPripat = new HashMap<String, FDouble>();
		HashMap<String, String> blCgItmOepMapIdPripat = new HashMap<String, String>();
		String key = "", keyInvoice = "";
		String entAndno = "", entAndno_pkgcode = "";
		FDouble rate;
		int i = 0;
		String invoiceNo = "";

		if (PrintInvocie.booleanValue()) // 需要打发票
		{
			// 2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
			// for(int j1=0;j1<appendBillParamDTOs.length;j1++)
			// {
			// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE)) //多次就诊打印一张发票
			// {
			// key=appendBillParamDTOs[j1].getId_pat();
			// }
			// else//多次就诊打印多张发票
			// {
			// key=appendBillParamDTOs[j1].getId_pat()+" "+appendBillParamDTOs[j1].getId_ent()+" "+appendBillParamDTOs[j1].getId_enttp();
			// }
			// if(!blCgItmOepMapInc_temp.containsKey(key))//就诊，发票号
			// {
			// blCgItmOepMapInc_temp.put(key, "");
			// }
			// }

			invoiceNo = obj11.GetInvoiceNo(Id_emp_inc, code_incca);
			// st_first_incno=invoiceNo[0];
			blCgItmOepMapDTO.setSt_first_incno(invoiceNo);
		} else {
			// st_first_incno=""; //不需要打发票，则发票号码为空
			blCgItmOepMapDTO.setSt_first_incno("");
		}
		String keyEnt = "";
		DAFacade dafacade = new DAFacade();
		String[] fields = { "id_pripat" };
		for (int j1 = 0; j1 < appendBillParamDTOs.length; j1++) {

			// key=appendBillParamDTOs[j1].getId_pat()+" "+appendBillParamDTOs[j1].getId_ent()+" "+appendBillParamDTOs[j1].getId_enttp();
			// keyEnt=key;
			// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE))
			// {
			// 2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
			keyInvoice = appendBillParamDTOs[j1].getId_pat();
			// }
			// else
			// {
			// keyInvoice=key;
			// }
			if (PrintInvocie.booleanValue()) // 需要打发票
			{
				if (!blCgItmOepMapInc.containsKey(keyInvoice))// 就诊，发票号
				{
					blCgItmOepMapInc.put(keyInvoice, invoiceNo);
					entAndno = entAndno + keyInvoice + "," + invoiceNo + "|";
					entAndno_pkgcode = entAndno_pkgcode + keyInvoice + "," + code_incpkg + "|";

					i++;
				}
			}
			if (!blCgItmOepMapPripat.containsKey(keyEnt)) // 就诊，价格分类
			{
				if (appendBillParamDTOs[j1].getId_pripat() == null || ("~").equals(appendBillParamDTOs[j1].getId_pripat())) {
					// 在就诊表中查询价格分类
					// PatiVisitDO[]
					// patiVisitDO=en_entS.find(" a0.id_ent='"+appendBillParamDTOs[j1].getId_ent()+"' ",
					// "", FBoolean.FALSE);

					List<PatiVisitDO> PatiVisitDOlist = (List<PatiVisitDO>) dafacade.findByCond(PatiVisitDO.class, " id_ent='" + appendBillParamDTOs[j1].getId_ent() + "'", fields);
					if (null == PatiVisitDOlist || PatiVisitDOlist.size() == 0) {
						throw new BizException("该患者没有设置价格分类");
					}

					appendBillParamDTOs[j1].setId_pripat(PatiVisitDOlist.toArray(new PatiVisitDO[] {})[0].getId_pripat());
				}
				// 查价格分类系数
				// rate=((IPripatCalService)obj22).GetPriPatRate(appendBillParamDTOs[j1].getId_pripat());
				blCgItmOepMapPripat.put(keyEnt, appendBillParamDTOs[j1].getRatio_pripat());
				blCgItmOepMapIdPripat.put(keyEnt, appendBillParamDTOs[j1].getId_pripat());
			}
		}
		blCgItmOepMapDTO.setBlCgItmOepMapInc(blCgItmOepMapInc);
		blCgItmOepMapDTO.setBlCgItmOepMapPripat(blCgItmOepMapPripat);
		blCgItmOepMapDTO.setBlCgItmOepMapIdPripat(blCgItmOepMapIdPripat);
		blCgItmOepMapDTO.setEntAndno(entAndno);
		blCgItmOepMapDTO.setEntAndno_pkgcode(entAndno_pkgcode);
		return blCgItmOepMapDTO;
	}

	/*
	 * 
	 * @PrintOnlyOneInvoice:多次就诊打印一张发票还是多次就诊打印多张发票，若是多次就诊打印多张发票，则 一次遍历获得:
	 * 就诊，发票号1|就诊，发票号2|...| 否则： 病人ID，发票号|
	 */
	public String GetEntInvoicenoFromDTO(BlOrderAppendBillParamDTO[] appendBillParamDTOs, String Id_emp_inc, String code_incca, String code_incpkg) throws BizException {
		IBLInvoiceService obj11 = ServiceFinder.find(IBLInvoiceService.class);
		HashMap<String, String> blCgItmOepMapInc1 = new HashMap<String, String>();
		HashMap<String, String> blCgItmOepMapInc_temp = new HashMap<String, String>();

		String key = "", keyInvoice = "";
		String entAndno = "";
		int i = 0;
		// 2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
		String[] invoiceNo = obj11.GetManyInvoiceNo(Id_emp_inc, code_incca, 1, code_incpkg);
		entAndno = appendBillParamDTOs[0].getId_pat() + "," + invoiceNo[0] + "|";
		return entAndno;
		// for(int j1=0;j1<appendBillParamDTOs.length;j1++)
		// {
		// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE)) //多次就诊打印一张发票
		// {
		//
		// key=appendBillParamDTOs[j1].getId_pat();
		// }
		// else//多次就诊打印多张发票
		// {
		// key=appendBillParamDTOs[j1].getId_pat()+" "+appendBillParamDTOs[j1].getId_ent()+" "+appendBillParamDTOs[j1].getId_enttp();
		// }
		// if(!blCgItmOepMapInc_temp.containsKey(key))//就诊，发票号
		// {
		// blCgItmOepMapInc_temp.put(key, "");
		// }
		// }
		// String[] invoiceNo=obj11.GetManyInvoiceNo(Id_emp_inc, code_incca,
		// blCgItmOepMapInc_temp.size(),code_incpkg);

		// for(int j1=0;j1<appendBillParamDTOs.length;j1++)
		// {
		// key=appendBillParamDTOs[j1].getId_pat()+" "+appendBillParamDTOs[j1].getId_ent()+" "+appendBillParamDTOs[j1].getId_enttp();
		// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE))
		// {
		// keyInvoice=appendBillParamDTOs[j1].getId_pat();
		// }
		// else
		// {
		// keyInvoice=key;
		// }
		// if(!blCgItmOepMapInc1.containsKey(keyInvoice))//就诊，发票号
		// {
		// blCgItmOepMapInc1.put(keyInvoice, invoiceNo[i]);
		// entAndno=entAndno+keyInvoice+","+invoiceNo[i]+"|";
		// i++;
		// }
		// }

	}

	public BlCgItmOepMapDTO GetBlCgItmOepEntVsNo(BlCgItmOepDO[] appendBillParamDTOs, String Id_emp_inc, String code_incca, FBoolean PrintOnlyOneInvoice, String code_incpkg) throws BizException {
		String key = "", keyInvoice = "";
		String entAndno = "";
		HashMap<String, String> blCgItmOepMapInc = new HashMap<String, String>();
		HashMap<String, String> blCgItmOepMapInc_temp = new HashMap<String, String>();
		int i = 0;

		// 2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
		IBLInvoiceService obj11 = ServiceFinder.find(IBLInvoiceService.class);
		String invoiceNo = obj11.GetInvoiceNo(Id_emp_inc, code_incca);
		entAndno = appendBillParamDTOs[0].getId_pat() + "," + invoiceNo + "|";
		BlCgItmOepMapDTO blCgItmOepMapDTO = new BlCgItmOepMapDTO();
		blCgItmOepMapDTO.setEntAndno(entAndno);
		return blCgItmOepMapDTO;

		// for(int j1=0;j1<appendBillParamDTOs.length;j1++)
		// {
		// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE)) //多次就诊打印一张发票
		// {
		// key=appendBillParamDTOs[j1].getId_pat();
		// }
		// else//多次就诊打印多张发票
		// {
		// key=appendBillParamDTOs[j1].getId_pat()+" "+appendBillParamDTOs[j1].getId_ent()+" "+appendBillParamDTOs[j1].getId_enttp();
		// }
		// if(!blCgItmOepMapInc_temp.containsKey(key))//就诊，发票号
		// {
		// blCgItmOepMapInc_temp.put(key, "");
		// }
		// }
		//
		// IBLInvoiceService obj11 =
		// ServiceFinder.find(IBLInvoiceService.class);
		// String[] invoiceNo=obj11.GetManyInvoiceNo(Id_emp_inc, code_incca,
		// blCgItmOepMapInc_temp.size(),code_incpkg);
		//
		// for(int j1=0;j1<appendBillParamDTOs.length;j1++)
		// {
		// key=appendBillParamDTOs[j1].getId_pat()+" "+appendBillParamDTOs[j1].getId_ent()+" "+appendBillParamDTOs[j1].getId_enttp();
		// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE))
		// {
		// keyInvoice=appendBillParamDTOs[j1].getId_pat();
		// }
		// else
		// {
		// keyInvoice=key;
		// }
		// if(!blCgItmOepMapInc.containsKey(keyInvoice))//就诊，发票号
		// {
		// blCgItmOepMapInc.put(keyInvoice, invoiceNo[i]);
		// entAndno=entAndno+keyInvoice+","+invoiceNo[i]+"|";
		// i++;
		// }
		// }
		// BlCgItmOepMapDTO blCgItmOepMapDTO=new BlCgItmOepMapDTO();
		// blCgItmOepMapDTO.setEntAndno(entAndno);
		// return blCgItmOepMapDTO;

	}

	/*
	 * @PrintOnlyOneInvoice:多次就诊打印一张发票还是多次就诊打印多张发票，若是多次就诊打印多张发票，则 一次遍历获得:
	 * 就诊，发票号1|就诊，发票号2|...| Map<就诊，患者本次就诊价格分类> 否则： 病人ID，发票号|
	 */
	public BlCgItmOepMapDTO BlCgItmOepConvertToMapIncPripats(BlCgItmOepDO[] appendBillParamDTOs, String Id_emp_inc, String code_incca, String code_incpkg) throws BizException {
		IBLInvoiceService obj11 = ServiceFinder.find(IBLInvoiceService.class);
		IPripatCalService obj22 = ServiceFinder.find(IPripatCalService.class);
		IPativisitRService en_entS = ServiceFinder.find(IPativisitRService.class);
		BlCgItmOepMapDTO blCgItmOepMapDTO = new BlCgItmOepMapDTO();
		HashMap<String, String> blCgItmOepMapInc = new HashMap<String, String>();
		HashMap<String, String> blCgItmOepMapInc_temp = new HashMap<String, String>();
		HashMap<String, FDouble> blCgItmOepMapPripat = new HashMap<String, FDouble>();
		HashMap<String, String> blCgItmOepMapIdPripat = new HashMap<String, String>();
		String key = "", keyInvoice = "";
		String entAndno = "";
		FDouble rate;
		int i = 0;

		// for(int j1=0;j1<appendBillParamDTOs.length;j1++)
		// {
		// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE)) //多次就诊打印一张发票
		// {
		// key=appendBillParamDTOs[j1].getId_pat();
		// }
		// else//多次就诊打印多张发票
		// {
		// key=appendBillParamDTOs[j1].getId_pat()+" "+appendBillParamDTOs[j1].getId_ent()+" "+appendBillParamDTOs[j1].getId_enttp();
		// }
		// if(!blCgItmOepMapInc_temp.containsKey(key))//就诊，发票号
		// {
		// blCgItmOepMapInc_temp.put(key, "");
		// }
		// }
		//
		// String[] invoiceNo=obj11.GetManyInvoiceNo(Id_emp_inc, code_incca,
		// blCgItmOepMapInc_temp.size(),code_incpkg);
		// 2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
		String invoiceNo = obj11.GetInvoiceNo(Id_emp_inc, code_incca);

		for (int j1 = 0; j1 < appendBillParamDTOs.length; j1++) {
			// key=appendBillParamDTOs[j1].getId_pat()+" "+appendBillParamDTOs[j1].getId_ent()+" "+appendBillParamDTOs[j1].getId_enttp();
			// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE))
			// {
			// keyInvoice=appendBillParamDTOs[j1].getId_pat();
			// }
			// else
			// {
			// keyInvoice=key;
			// }
			// if(!blCgItmOepMapInc.containsKey(keyInvoice))//就诊，发票号
			// {
			// blCgItmOepMapInc.put(keyInvoice, invoiceNo[i]);
			// entAndno=entAndno+keyInvoice+","+invoiceNo[i]+"|";
			// i++;
			// }
			if (!blCgItmOepMapPripat.containsKey(key)) // 就诊，价格分类
			{
				if (appendBillParamDTOs[j1].getId_pripat() == null || ("~").equals(appendBillParamDTOs[j1].getId_pripat())) {
					// 在就诊表中查询价格分类
					PatiVisitDO[] patiVisitDO = en_entS.find(" a0.id_ent='" + appendBillParamDTOs[j1].getId_ent() + "' ", "", FBoolean.FALSE);
					if (null == patiVisitDO) {
						throw new BizException("该患者没有设置价格分类");
					}
					appendBillParamDTOs[j1].setId_pripat(patiVisitDO[0].getId_pripat());
				}
				// 查价格分类系数
				// rate=((IPripatCalService)obj22).GetPriPatRate(appendBillParamDTOs[j1].getId_pripat());
				blCgItmOepMapPripat.put(key, appendBillParamDTOs[j1].getRatio_pripat());
				blCgItmOepMapIdPripat.put(key, appendBillParamDTOs[j1].getId_pripat());
			}
		}
		blCgItmOepMapDTO.setBlCgItmOepMapInc(blCgItmOepMapInc);
		blCgItmOepMapDTO.setBlCgItmOepMapPripat(blCgItmOepMapPripat);
		blCgItmOepMapDTO.setBlCgItmOepMapIdPripat(blCgItmOepMapIdPripat);
		entAndno = appendBillParamDTOs[0].getId_pat() + "," + invoiceNo + "|";
		blCgItmOepMapDTO.setEntAndno(entAndno);
		return blCgItmOepMapDTO;
	}

}
