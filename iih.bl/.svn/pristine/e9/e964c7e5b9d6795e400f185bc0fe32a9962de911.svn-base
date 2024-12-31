package iih.bl.cg.bp;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
//import iih.bl.inc.blincitmoep.d.BlIncItmOepDO;
//import iih.bl.inc.blincitmoep.d.BlIncItmOepDO;
//import iih.bl.inc.blincitmoep.i.IBlincitmoepCudService;
import iih.bl.inc.blincoep.d.BlFreeMdEnum;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
//import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 处理门诊费用减免的业务逻辑
 * @author tcy
 *
 */
public class DoOepFgFree {


	
	/**
	 * 减免的业务逻辑：将减免费用分摊到发票各项中过去
	 * @param blcgoepAggDOArr 费用的明细
	 * @param blpaypatoepAggDO 收付款信息
	 * @param blincoepAggDO 发票信息
	 * @param DOStatus DO的状态,DOStatus.NEW（门诊收费）或者DOStatus.UPDATE（退费重收或者重划重收）
	 * @return int 返回减免方式：-1000是没有减免，1 金额减免，2 项目减免
	 * @throws BizException
	 */
	public BlincoepAggDO DoOep_FgFree_new(BlcgoepAggDO[] blcgoepAggDOArr,BlpaypatoepAggDO blpaypatoepAggDO,BlincoepAggDO blincoepAggDO,int DOStatus) throws BizException
	{		
		Map<String,FDouble> idInc_amtfree_map=new  HashMap<String,FDouble>();	
		FDouble temp=new FDouble(0);
		int Eu_freemd=-1000;
		//1.校验是否有减免
		//项目减免和金额减免不能同时使用
		BlPayItmPatOepDO[] blPayItmPatOepDOArr=blpaypatoepAggDO.getBlPayItmPatOepDO();
		for(BlPayItmPatOepDO blPayItmPatOepDO:blPayItmPatOepDOArr)
		{
			if(blPayItmPatOepDO.getSd_pm()!=null && blPayItmPatOepDO.getSd_pm().equals(IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION))  //15金额减免
			{
				Eu_freemd=BlFreeMdEnum.AMT_FREE_MD;
			}
			else if(blPayItmPatOepDO.getSd_pm()!=null && blPayItmPatOepDO.getSd_pm().equals(IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION)) //16项目减免
			{
				Eu_freemd=BlFreeMdEnum.ITM_FREE_MD;
			}
		}
		//2.无减免，则返回
		if(Eu_freemd==-1000)
		{
			if(blincoepAggDO.getParentDO().getId_incoep()==null || blincoepAggDO.getParentDO().getId_incoep().trim().length()==0)
			{
				IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);	
				BlincoepAggDO[] blincoepAggDOs=iBlincoepCudService.save(new BlincoepAggDO[]{blincoepAggDO});
				if(null==blincoepAggDOs)
				{
					throw new BizException("修改门诊结算发票减免信息失败");
				}
			}
			return blincoepAggDO;
		}
		
		
		//2.获得费用明细的发票分类AMT_ratio汇总和
		Map<String,FDouble> type_amt_ratio_map=new HashMap<String,FDouble>();//《发票编码+“，”+发票名称，比例金额》
		Map<String,FDouble> type_amt_free_map=new HashMap<String,FDouble>();//《发票编码，减免金额》

		String type="";
		FDouble tempAmt=new FDouble(0);
		FDouble sum_Amt_ratio=new FDouble(0);
		List<BlCgItmOepDO> blCgItmOepDOLst=new ArrayList<BlCgItmOepDO>();
		for(BlcgoepAggDO blcgoepAggDO:blcgoepAggDOArr)
		{
			BlCgItmOepDO[] blCgItmOepDOArr= blcgoepAggDO.getBlCgItmOepDO();
			for(BlCgItmOepDO blCgItmOepDO: blCgItmOepDOArr)
			{
				//TODO review by yangyang 
				if(blCgItmOepDO.getFg_refund()!=null && blCgItmOepDO.getFg_refund().booleanValue())
					continue;
				blCgItmOepDOLst.add(blCgItmOepDO);
				type=blCgItmOepDO.getCode_inccaitm()+","+blCgItmOepDO.getName_inccaitm();
		
				if(type_amt_ratio_map.containsKey(type))
				{
					tempAmt=type_amt_ratio_map.get(type).add(blCgItmOepDO.getAmt_ratio());
					type_amt_ratio_map.remove(type);
					type_amt_ratio_map.put(type, tempAmt);
				}
				else
				{
					type_amt_ratio_map.put(type, blCgItmOepDO.getAmt_ratio());
				}
				sum_Amt_ratio=sum_Amt_ratio.add(blCgItmOepDO.getAmt_ratio());
			}
		}
				
		//3.计算发票上的减免金额：《发票编码+“，”+发票名称，减免金额》
		//项目减免和金额减免不能同时使用	
		FDouble propfree_sum_Amt_ratio=new FDouble(0);		
		FDouble temp_Amt=new FDouble(0);
		FDouble amt_free=new FDouble(0);//减免金额
		FDouble temp_Amt_free=new FDouble(0);	
		FDouble total_free_amt=new FDouble(0);
		String inctype="";
		Map.Entry entry;
		//因为退费重收产生的数据是原收费方式附加退费的收费方式，因此，需要检查是否合并
		List<BlPayItmPatOepDO> blPayItmPatOepDOLst=new ArrayList<BlPayItmPatOepDO>();
		Map<String,FDouble> blPayItmPatOepDOMap=new HashMap<String,FDouble>();
		FDouble tempAmt1=new FDouble(0);
		for(BlPayItmPatOepDO blPayItmPatOepDO:blPayItmPatOepDOArr)
		{
			if(blPayItmPatOepDO.getSd_pm()!=null && blPayItmPatOepDO.getSd_pm().equals(IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION))  //15金额减免
			{
				if(blPayItmPatOepDOMap.containsKey(blPayItmPatOepDO.getSd_pm()))
				{
					tempAmt1=blPayItmPatOepDOMap.get(blPayItmPatOepDO.getSd_pm()).add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					blPayItmPatOepDOMap.remove(blPayItmPatOepDO.getSd_pm());
					blPayItmPatOepDOMap.put(blPayItmPatOepDO.getSd_pm(), tempAmt1);
				}
				else
				{
					blPayItmPatOepDOMap.put(blPayItmPatOepDO.getSd_pm(), blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
				}
			}
			else if(blPayItmPatOepDO.getSd_pm()!=null && blPayItmPatOepDO.getSd_pm().equals(IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION)) //16项目减免
			{
				if(blPayItmPatOepDOMap.containsKey(blPayItmPatOepDO.getSd_pm()))
				{
					tempAmt1=blPayItmPatOepDOMap.get(blPayItmPatOepDO.getSd_pm()).add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					blPayItmPatOepDOMap.remove(blPayItmPatOepDO.getSd_pm());
					blPayItmPatOepDOMap.put(blPayItmPatOepDO.getSd_pm(), tempAmt1);
				}
				else
				{
					blPayItmPatOepDOMap.put(blPayItmPatOepDO.getSd_pm(), blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
				}
			}
			else
			{
				blPayItmPatOepDOLst.add(blPayItmPatOepDO);
			}
		}
		Iterator iter1=blPayItmPatOepDOMap.entrySet().iterator();
		while (iter1.hasNext()) 
		{
			Map.Entry entry1 = (Map.Entry) iter1.next();
			if(!(new FDouble(entry1.getValue().toString()).compareTo(new FDouble(0))==0))
			{
				BlPayItmPatOepDO blPayItmPatOepDO=new BlPayItmPatOepDO();
				blPayItmPatOepDO.setSd_pm(entry1.getKey().toString());
				blPayItmPatOepDO.setAmt(new FDouble(entry1.getValue().toString()));
				blPayItmPatOepDOLst.add(blPayItmPatOepDO);
			}
		}
		for(BlPayItmPatOepDO blPayItmPatOepDO:blPayItmPatOepDOLst)
		{
			//3.1金额减免
			if(blPayItmPatOepDO.getSd_pm()!=null && blPayItmPatOepDO.getSd_pm().equals(IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION))  //15金额减免
			{				
				temp_Amt_free=blPayItmPatOepDO.getAmt();//总共需要减免的金额
				total_free_amt=blPayItmPatOepDO.getAmt();//总共需要减免的金额
				Iterator iter=type_amt_ratio_map.entrySet().iterator();//《发票编码+“，”+发票名称，比例金额》
				while(iter.hasNext())
				{
					entry = (Map.Entry) iter.next();
					temp_Amt=(FDouble) entry.getValue(); //原始发票分类对应的金额
					//减免金额*（发票账单金额/剩余未减免的发票账单金额之和）
					amt_free=temp_Amt_free.multiply(temp_Amt.div(sum_Amt_ratio.sub(propfree_sum_Amt_ratio))).setScale(-2, BigDecimal.ROUND_HALF_UP);
				    type_amt_free_map.put((String)entry.getKey(), amt_free);
					propfree_sum_Amt_ratio=propfree_sum_Amt_ratio.add(temp_Amt); //已经分摊减免的费用账单项金额
					temp_Amt_free=temp_Amt_free.sub(amt_free);					
				}
				idInc_amtfree_map.put(blincoepAggDO.getParentDO().getId_incoep(), blPayItmPatOepDO.getAmt());
			}
			else if(blPayItmPatOepDO.getSd_pm()!=null && blPayItmPatOepDO.getSd_pm().equals(IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION)) //16项目减免
			{
				//3.1 项目减免
				for(BlCgItmOepDO blCgItmOepDO:blCgItmOepDOLst)
				{
					if(blCgItmOepDO.getFg_free()!=null && blCgItmOepDO.getFg_free().booleanValue()) //项目减免
					{						
						inctype=blCgItmOepDO.getCode_inccaitm()+","+blCgItmOepDO.getName_inccaitm();
						if(!type_amt_free_map.containsKey(inctype))
						{
							type_amt_free_map.put(inctype, blCgItmOepDO.getAmt_ratio());
						}
						else
						{
							temp=type_amt_free_map.get(inctype).add(blCgItmOepDO.getAmt_ratio());
							type_amt_free_map.remove(inctype);
							type_amt_free_map.put(inctype, temp);
						}
						total_free_amt=total_free_amt.add(blCgItmOepDO.getAmt_ratio());
					}
				}
			}
		}	
		
		
		//4.将减免金额回写到发票主表里
		blincoepAggDO.getParentDO().setEu_freemd(Eu_freemd);
		blincoepAggDO.getParentDO().setAmt_free(total_free_amt);
		FDouble Amt=blincoepAggDO.getParentDO().getAmt().sub(total_free_amt);
		blincoepAggDO.getParentDO().setAmt(Amt);
		blincoepAggDO.getParentDO().setStatus(DOStatus);
		
		//5.将减免金额写到发票账单项表里
		if(!ArrayUtil.isEmptyNoNull(blincoepAggDO.getBlIncItmOepDO()))
		{
			if(blincoepAggDO.getBlIncItmOepDO()!=null)  //老数据没有
			{
				Iterator iter = type_amt_free_map.entrySet().iterator();
			//	BlIncItmOepDO[] blIncItmOepDOs=blincoepAggDO.getBlIncItmOepDO();
				while (iter.hasNext())
				{
					entry = (Map.Entry) iter.next();
					inctype = (String) entry.getKey();			
					for(BlIncItmOepDO blIncItmOepDO: blincoepAggDO.getBlIncItmOepDO())
					{
						if(inctype.equals(blIncItmOepDO.getCode()+","+blIncItmOepDO.getName()))
						{
							blIncItmOepDO.setAmt( blIncItmOepDO.getAmt().sub((FDouble) entry.getValue()));
							blIncItmOepDO.setAmt_free( (FDouble) entry.getValue());
							blIncItmOepDO.setStatus(DOStatus);
						}
					}
				}
			}
		}
		
		//6.保存发票
		IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);	
		BlincoepAggDO[] blincoepAggDOs=iBlincoepCudService.save(new BlincoepAggDO[]{blincoepAggDO});
		if(null==blincoepAggDOs)
		{
			throw new BizException("修改门诊结算发票减免信息失败");
		}
		

		return blincoepAggDOs[0];
	}
}
