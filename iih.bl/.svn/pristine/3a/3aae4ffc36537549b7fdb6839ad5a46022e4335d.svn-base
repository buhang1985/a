package iih.bl.cg.blcgoep.bp;

import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepMDOCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepMDORService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blrecgip.d.BlRecgIpDO;
import iih.bl.cg.blrecgip.i.IBlrecgipCudService;
import iih.bl.cg.blrecgoep.d.BlRecgOepDO;
import iih.bl.cg.blrecgoep.i.IBlrecgoepCudService;
import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.GetCodeByCustomization;
import iih.en.pv.i.IEnOutCmdService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 门诊重划价业务逻辑
 * @author 唐婵懿
 *
 */
public class OepRePricingCgBp {
	
	/**
	 * 对指定就诊进行门诊重划价
	 * 备注：只针对补费产生的数据（即尽在CG表中存在的数据）。如果是医嘱产生的数据，则不能直接在计费阶段修改价格分类
	 * @param id_ent 就诊ID
	 * @param id_pripat_from 原价格分类
	 * @param id_pripat_to 新价格分类
	 * @param operatorInfo 操作员人员信息
	 * @return 重划价成功返回FBoolean.true ,重划价失败返回FBoolean.false
	 * @throws BizException
	 */
	public FBoolean oepRePricingCgBp(String id_pat,String id_ent,String id_pripat_from,String id_pripat_to,OperatorInfoDTO operatorInfo) throws BizException
	{
		FBoolean fRePricingSuccess=FBoolean.TRUE;
		TimeService timeService = new TimeServiceImpl();
		FDateTime strDateTime = timeService.getUFDateTime();
		//1.查找指定就诊下未完成结算的费用明细	
		IBlCgItmOepDORService iBlCgItmOepDORService = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] blCgItmOepDOs =iBlCgItmOepDORService.find(" fg_st = 'N' and id_ent='"+id_ent+"' and id_pat='"+id_pat+"'", "  id_or,id_orsrv,id_srv ", FBoolean.TRUE);		
		if (blCgItmOepDOs == null || blCgItmOepDOs.length == 0) {
			//fRePricingSuccess = FBoolean.FALSE;
			//当重划价时cg表里没有明细时，更新en_ent表中id_pripat
			// 1.1 保存重划价记录
			BlRecgOepDO blRecgOepDO = new BlRecgOepDO();
			blRecgOepDO.setId_recg_oep(null);
			blRecgOepDO.setDt_recg(strDateTime);
			blRecgOepDO.setId_pripat_from(id_pripat_from);
			blRecgOepDO.setId_pripat_to(id_pripat_to);
			blRecgOepDO.setId_emp_recg(operatorInfo.getId_emp());
			blRecgOepDO.setId_org(operatorInfo.getId_org());
			blRecgOepDO.setId_grp(operatorInfo.getId_grp());
			blRecgOepDO.setStatus(DOStatus.NEW);

			IBlrecgoepCudService iBlrecgoepCudService = ServiceFinder
					.find(IBlrecgoepCudService.class);
			BlRecgOepDO[] blRecgOepDOArr1 = new BlRecgOepDO[] { blRecgOepDO };
			BlRecgOepDO[] blRecgOepDOArr = iBlrecgoepCudService.save(blRecgOepDOArr1);
			if (blRecgOepDOArr == null || blRecgOepDOArr.length == 0) {
				throw new BizException("保存重划价记录失败！");
			}
			//1.2 更新en_ent表中id_pripat 和 pi_pat中id_pripat
			IEnOutCmdService iEnOutCmdService=ServiceFinder.find(IEnOutCmdService.class);
			iEnOutCmdService.updateEntPriPat(id_ent,id_pripat_to);
			//更新pi_pat中id_pripat字段
			IPatiMDORService iPatiMDORService = ServiceFinder.find(IPatiMDORService.class);
			PatDO patDo = iPatiMDORService.findById(id_pat);
			patDo.setId_patpritp(id_pripat_to);
			patDo.setStatus(DOStatus.UPDATED);
			PatDO[] patDos = new PatDO[]{patDo};
			IPatiMDOCudService iPatiMDOCudService = ServiceFinder.find(IPatiMDOCudService.class);
			PatDO[] patDoArr = iPatiMDOCudService.save(patDos);
			if (patDoArr == null || patDoArr.length == 0) {
				throw new BizException("保存重划价记录失败！");
			}
			return FBoolean.TRUE;
		}
		
		// 2.保存重划价记录
		BlRecgOepDO blRecgOepDO = new BlRecgOepDO();
		blRecgOepDO.setId_recg_oep(null);
		blRecgOepDO.setDt_recg(strDateTime);
		blRecgOepDO.setId_pripat_from(id_pripat_from);
		blRecgOepDO.setId_pripat_to(id_pripat_to);
		blRecgOepDO.setId_emp_recg(operatorInfo.getId_emp());
		blRecgOepDO.setId_org(operatorInfo.getId_org());
		blRecgOepDO.setId_grp(operatorInfo.getId_grp());
		blRecgOepDO.setStatus(DOStatus.NEW);

		IBlrecgoepCudService iBlrecgoepCudService = ServiceFinder
				.find(IBlrecgoepCudService.class);
		BlRecgOepDO[] blRecgOepDOArr1 = new BlRecgOepDO[] { blRecgOepDO };
		BlRecgOepDO[] blRecgOepDOArr = iBlrecgoepCudService.save(blRecgOepDOArr1);
		if (blRecgOepDOArr == null || blRecgOepDOArr.length == 0) {
			throw new BizException("保存重划价记录失败！");
		}

		// 3.按id_par=id_cgitmoep合并记录,体现在修改数量上
		Map<String, BlCgItmOepDO> temp_map = new HashMap<String, BlCgItmOepDO>();
		String id_par="",id_cgitmoep="";
		FDouble new_Quan=new FDouble(0);
	    List<String> id_cgoepLst=new ArrayList<String>();
	    String id_cgoepCond=""; //CG主表主键
		for(BlCgItmOepDO blCgItmOepDO1: blCgItmOepDOs)
		{
			if(!id_cgoepLst.contains(blCgItmOepDO1.getId_cgoep()))
			{
				id_cgoepLst.add(blCgItmOepDO1.getId_cgoep());
				id_cgoepCond=id_cgoepCond+",'"+blCgItmOepDO1.getId_cgoep()+"'";
			}
			id_par=blCgItmOepDO1.getId_par();
			if(id_par!=null && id_par.length()>1)
			{
				if(temp_map.containsKey(id_par))
				{
					BlCgItmOepDO tempdo=temp_map.get(id_par);
					new_Quan=tempdo.getQuan().multiply(tempdo.getEu_direct()).add(blCgItmOepDO1.getQuan().multiply(blCgItmOepDO1.getEu_direct()));
					if(new_Quan.compareTo(new FDouble())<0)
					{
						tempdo.setEu_direct(-1);
					}
					else if(new_Quan.compareTo(new FDouble())>0)
					{
						tempdo.setEu_direct(1);
					}
					tempdo.setQuan(new_Quan.abs());							
				}
				else
				{
					temp_map.put(blCgItmOepDO1.getId_cgitmoep(), blCgItmOepDO1);
				}
			}
			else
			{
				temp_map.put(blCgItmOepDO1.getId_cgitmoep(), blCgItmOepDO1);
			}
			//更新原记录退费标志			
			blCgItmOepDO1.setFg_refund(FBoolean.TRUE);
			blCgItmOepDO1.setStatus(DOStatus.UPDATED);			
		}
		// 更新原记录
		IBlCgItmOepDOCudService cgService = ServiceFinder
				.find(IBlCgItmOepDOCudService.class);
		cgService.save(blCgItmOepDOs);
		
		
		List<BlCgItmOepDO> blCgItmOepDOLst1=new ArrayList<BlCgItmOepDO>();
		Iterator iter_cg= temp_map.entrySet().iterator();
		while (iter_cg.hasNext())
		{
			Entry e = (Entry)iter_cg.next();			
			id_cgitmoep = (String)e.getKey();
			blCgItmOepDOLst1.add(temp_map.get(id_cgitmoep));
		}
		BlCgItmOepDO[] orgin_BlCgOeItmpDO=blCgItmOepDOLst1.toArray(new BlCgItmOepDO[0]);		
		
		
		//4.获得价格分类下的特殊项目
		IPriCalService iPriCalService=ServiceFinder.find(IPriCalService.class);
		SrvPricalRateAndPriceDTO[] srvPricalRateAndPriceDTOArr=iPriCalService.GetAllSrvRatelByIdPripat(id_pripat_to);
		
		//5.获得新价格分类下的默认比例
		String[] fields={"Id_pripat","Rate"};
		DAFacade dAFacade=new DAFacade();
		List<PriPatDO> priPatDOList=(List<PriPatDO>)dAFacade.findByCond(PriPatDO.class, " Id_pripat='"+id_pripat_to+"' ","1",fields);		
		if(ListUtil.isEmpty(priPatDOList) || priPatDOList.size() == 0)
        {
        	throw new BizException("没有找到患者就诊对应的价格分类 ！");
        }
		FDouble new_ration=priPatDOList.toArray(new PriPatDO[0])[0].getRate();
		
		//5.红冲原费用明细,并生成新的费用明细
		if(id_cgoepCond.length()>1)
		{
			id_cgoepCond=id_cgoepCond.substring(1);//取掉前面","
		}
		//查找记账主表
		IBlcgoepMDORService iBlcgoepMDORService=ServiceFinder.find(IBlcgoepMDORService.class);
		BlCgOepDO[] blCgOepDOArr=iBlcgoepMDORService.find("id_cgoep in ("+id_cgoepCond+")", "", FBoolean.TRUE);
		FDouble amt_acc_orgin=new FDouble(0); //原来消费额度
		FDouble amt_acc_new=new FDouble(0); //新消费额度
		BlCgItmOepDO new_blCgItmOepDO=new BlCgItmOepDO();
		List<BlCgItmOepDO> save_red_blCgItmOepDOList=new ArrayList<BlCgItmOepDO>();
		List<BlCgItmOepDO> save_recharge_blCgItmOepDOList=new ArrayList<BlCgItmOepDO>();
		List<BlCgOepDO> new_BlCgOepDOList=new ArrayList<BlCgOepDO>();
		for(BlCgItmOepDO blCgItmOepDO: orgin_BlCgOeItmpDO)
		{
			//红冲记录
			save_red_blCgItmOepDOList.add(getRedBlCgItmOepDO(blCgItmOepDO,operatorInfo,blRecgOepDOArr[0].getId_recg_oep(),strDateTime));
			//重收记录
			new_blCgItmOepDO=getNewChargeBlCgItmOepDO(blCgItmOepDO,operatorInfo,blRecgOepDOArr[0].getId_recg_oep(),strDateTime,srvPricalRateAndPriceDTOArr,new_ration);
			save_recharge_blCgItmOepDOList.add(new_blCgItmOepDO);
			for(BlCgOepDO blCgOepDO: blCgOepDOArr)
			{
				
				if(blCgItmOepDO.getId_cgoep().equals(blCgOepDO.getId_cgoep()))
				{					
					//原来消费额度
					amt_acc_orgin=amt_acc_orgin.add(blCgItmOepDO.getAmt_ratio().multiply(blCgOepDO.getEu_direct()));
					
					//新消费额度
					amt_acc_new=amt_acc_new.add(new_blCgItmOepDO.getAmt_ratio().multiply(blCgOepDO.getEu_direct()));
					break;
				}
			}
		}
		
		//6.保存门诊费用明细
		fRePricingSuccess=saveRedandRechargeCg(orgin_BlCgOeItmpDO,blCgOepDOArr,operatorInfo,strDateTime,save_red_blCgItmOepDOList,save_recharge_blCgItmOepDOList);
		
		//7.修改就诊账户的消费额度
		patAccConsume(id_pat,amt_acc_orgin,amt_acc_new);
		
		//8.更新就诊域的EN_ENT.id_pripat
		IEnOutCmdService iEnOutCmdService=ServiceFinder.find(IEnOutCmdService.class);
		iEnOutCmdService.updateEntPriPat(id_ent,id_pripat_to);
		//9.更新PI域的Pi_pat.id_pripat
		IPatiMDORService iPatiMDORService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDo = iPatiMDORService.findById(id_pat);
		patDo.setId_patpritp(id_pripat_to);
		patDo.setStatus(DOStatus.UPDATED);
		PatDO[] patDos = new PatDO[]{patDo};
		IPatiMDOCudService iPatiMDOCudService = ServiceFinder.find(IPatiMDOCudService.class);
		PatDO[] patDoArr = iPatiMDOCudService.save(patDos);
		if (patDoArr == null || patDoArr.length == 0) {
			throw new BizException("更新PI领域价格分类失败！");
		}
		
		return fRePricingSuccess;
	}


	/**
	 * 保存红冲和重收的记账主子表
	 * @param orgin_BlCgOepDOs 原记账明细记录
	 * @param operatorInfo 操作员信息
	 * @param strDateTime 时间
	 * @param save_red_blCgItmOepDOList 红冲的记账明细记录
	 * @param save_recharge_blCgItmOepDOList 重收的记账明细记录
	 * @return 成功返回FBoolean.True,失败返回FBoolean.False
	 * @throws BizException
	 */
	private FBoolean saveRedandRechargeCg(BlCgItmOepDO[] orgin_BlCgOepDOs,BlCgOepDO[] orgin_blCgOepDOArr,OperatorInfoDTO operatorInfo,FDateTime strDateTime,List<BlCgItmOepDO> save_red_blCgItmOepDOList,List<BlCgItmOepDO> save_recharge_blCgItmOepDOList)  throws BizException
	{
		FBoolean fRePricingSuccess = FBoolean.TRUE;
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder
				.find(IBlcgoepCudService.class);
		List<BlCgItmOepDO> red_BlCgItmOepDOList=null;
		List<BlCgItmOepDO> recharge_BlCgItmOepDOList=null;
		//因此门诊记账是主子表，因此，对应的红冲和重收也按照主子表处理
		for(BlCgOepDO orgin_blCgOepDO:orgin_blCgOepDOArr)
		{
			red_BlCgItmOepDOList=new ArrayList<BlCgItmOepDO>();
			recharge_BlCgItmOepDOList=new ArrayList<BlCgItmOepDO>();
			// 保存红冲和重划价记录
			// 生成红冲主记录
			BlCgOepDO red_blCgOepDO = getRedBlCgOepDO(orgin_blCgOepDO,operatorInfo, strDateTime);
			// 生成重收主记录
			BlCgOepDO recharge_blCgOepDO = getRechargeBlCgOepDO(orgin_blCgOepDO,operatorInfo,
					strDateTime);
			BlcgoepAggDO[] blcgoepAggDOArr = new BlcgoepAggDO[2];
			//红冲明细
			for(BlCgItmOepDO red_BlCgItmOepDO:save_red_blCgItmOepDOList)
			{
				if(orgin_blCgOepDO.getId_cgoep().equals(red_BlCgItmOepDO.getId_cgoep()))
				{			
					red_BlCgItmOepDOList.add(red_BlCgItmOepDO);
					red_BlCgItmOepDO.setId_cgoep(null);
				}
			}
			// 生成红冲AGG
			BlcgoepAggDO redBlcgoepAggDO = new BlcgoepAggDO();
			redBlcgoepAggDO.setParentDO(red_blCgOepDO);		
			redBlcgoepAggDO.setBlCgItmOepDO(red_BlCgItmOepDOList.toArray(new BlCgItmOepDO[0]));
			blcgoepAggDOArr[0] = redBlcgoepAggDO;
			
			//重收明细
			for(BlCgItmOepDO recharge_BlCgItmOepDO:save_recharge_blCgItmOepDOList)
			{
				if(orgin_blCgOepDO.getId_cgoep().equals(recharge_BlCgItmOepDO.getId_cgoep()))
				{			
					recharge_BlCgItmOepDOList.add(recharge_BlCgItmOepDO);
					recharge_BlCgItmOepDO.setId_cgoep(null);
				}
			}
			// 生成重收AGG
			BlcgoepAggDO rechargeBlcgoepAggDO = new BlcgoepAggDO();
			rechargeBlcgoepAggDO.setParentDO(recharge_blCgOepDO);
			rechargeBlcgoepAggDO.setBlCgItmOepDO(recharge_BlCgItmOepDOList
					.toArray(new BlCgItmOepDO[0]));
			blcgoepAggDOArr[1] = rechargeBlcgoepAggDO;
			// 保存
			
			BlcgoepAggDO[] blcgoepAggDOArr1 = iBlcgoepCudService
					.save(blcgoepAggDOArr);
			if (blcgoepAggDOArr1 == null || blcgoepAggDOArr1.length == 0) {
				fRePricingSuccess = FBoolean.FALSE;
			}
		}
		return fRePricingSuccess;
	}
	
	/**
	 * 获得记账码
	 * @return
	 * @throws BizException
	 */
	private String getCodeCg() throws BizException
	{
		GetCodeByCustomization code_ins=new GetCodeByCustomization();
	    return code_ins.GetCodeBlCgOep();
	}
	
	/**
	 * 修改患者账户的消费额度
	 * @param id_ent 就诊ID
	 * @param amt_acc_orgin 红冲的总金额
	 * @param amt_acc_new 重收的总金额
	 */
	private void patAccConsume(String id_pat,FDouble amt_acc_orgin,FDouble amt_acc_new)  throws BizException
	{
		
		//程序用的add，但业务逻辑是减少消费锁定额
				IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder
						.find(IPatAccServiceExt.class);
				PiPatAccDO piPatAccDO1 = patAccImpls.PatiAccPreAuthor(id_pat,
						amt_acc_orgin.multiply(-1).add(amt_acc_new));
				if (null == piPatAccDO1) {
					throw new BizException("修改患者预交金预授权失败");
				}
		
	}
	
	/**
	 * 修改就诊账户的消费额度
	 * @param id_ent 就诊ID
	 * @param amt_acc_orgin 红冲的总金额
	 * @param amt_acc_new 重收的总金额
	 */
	private void entAccConsume(String id_ent,FDouble amt_acc_orgin,FDouble amt_acc_new)  throws BizException
	{
		IEnOutCmdService enAccService = ServiceFinder.find(IEnOutCmdService.class);
		enAccService.consume(id_ent,amt_acc_orgin.multiply(-1).add(amt_acc_new));//sql中采用的加，因此先还原以前的消费额在减去新额度
	}
	
	/**
	 * 生成重收的记账主信息
	 * @param orgin_blCgOepDO 原记账主信息
	 * @param operatorInfo 操作员信息
	 * @param strDateTime 重划价日期
	 * @return 红冲的记账信息
	 */
	private BlCgOepDO getRechargeBlCgOepDO(BlCgOepDO orgin_blCgOepDO,OperatorInfoDTO operatorInfo,FDateTime strDateTime)   throws BizException
	{
		BlCgOepDO recharge_blCgOepDO=new BlCgOepDO();
		recharge_blCgOepDO.setId_cgoep(null);
		recharge_blCgOepDO.setId_org(operatorInfo.getId_org());
		recharge_blCgOepDO.setCode_cg(getCodeCg());
		
		recharge_blCgOepDO.setEu_direct(orgin_blCgOepDO.getEu_direct()); //重收方向与原来的方向一致
		
		recharge_blCgOepDO.setDt_cg(strDateTime);
		recharge_blCgOepDO.setId_org_cg(operatorInfo.getId_org_emp());
		recharge_blCgOepDO.setId_emp_cg(operatorInfo.getId_emp());
		recharge_blCgOepDO.setId_dep_cg(operatorInfo.getId_dep());
		recharge_blCgOepDO.setStatus(DOStatus.NEW);
		return recharge_blCgOepDO;
	}
	
	/**
	 * 生成红冲的记账主信息
	 * @param orgin_blCgOepDO 原记账主信息
	 * @param operatorInfo 操作员信息
	 * @param strDateTime 重划价日期
	 * @return 红冲的记账信息
	 */
	private BlCgOepDO getRedBlCgOepDO(BlCgOepDO orgin_blCgOepDO,OperatorInfoDTO operatorInfo,FDateTime strDateTime)   throws BizException
	{
		BlCgOepDO red_blCgOepDO=new BlCgOepDO();
		red_blCgOepDO.setId_cgoep(null);
		red_blCgOepDO.setId_org(operatorInfo.getId_org());
		red_blCgOepDO.setCode_cg(getCodeCg());
		if(orgin_blCgOepDO.getEu_direct()==BookRtnDirectEnum.CHARGES)  //红冲方向与原方向相反
		{
			red_blCgOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
		}
		else
		{
			red_blCgOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		}
		red_blCgOepDO.setDt_cg(strDateTime);
		red_blCgOepDO.setId_org_cg(operatorInfo.getId_org_emp());
		red_blCgOepDO.setId_emp_cg(operatorInfo.getId_emp());
		red_blCgOepDO.setId_dep_cg(operatorInfo.getId_dep());
		red_blCgOepDO.setStatus(DOStatus.NEW);
		return red_blCgOepDO;
	}
	
	/**
	 * 获得红冲的记账明细信息
	 * @param orgin_blCgIpDO 原记账信息
	 * @param operatorInfo 操作员信息
	 * @param id_recg_ip 重划价操作员记录主键
	 * @param strDateTime 重划价日期
	 * @return 红冲的记账信息
	 */
	private BlCgItmOepDO getRedBlCgItmOepDO(BlCgItmOepDO orgin_blCgOepDO,OperatorInfoDTO operatorInfo,String id_recg_ip,FDateTime strDateTime)
	{
		BlCgItmOepDO r_blCgItmOepDO=new BlCgItmOepDO();
		r_blCgItmOepDO=(BlCgItmOepDO)orgin_blCgOepDO.clone();
		r_blCgItmOepDO.setId_cgitmoep(null);
	//	r_blCgItmOepDO.setId_cgoep(null);  先不设置为空，后面设置
		if(r_blCgItmOepDO.getEu_direct()==BookRtnDirectEnum.REFUND)
		{
			r_blCgItmOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		}
		else
		{
			r_blCgItmOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
		}
		r_blCgItmOepDO.setQuan(orgin_blCgOepDO.getQuan());
		r_blCgItmOepDO.setAmt_std(orgin_blCgOepDO.getAmt_std());
		r_blCgItmOepDO.setAmt_ratio(orgin_blCgOepDO.getAmt_ratio());
		r_blCgItmOepDO.setAmt(orgin_blCgOepDO.getAmt());
		r_blCgItmOepDO.setAmt_pat(orgin_blCgOepDO.getAmt_pat());
		r_blCgItmOepDO.setAmt_hp(orgin_blCgOepDO.getAmt_hp());
		
		r_blCgItmOepDO.setId_par(orgin_blCgOepDO.getId_cgitmoep()); //by liwq 2017年7月3日14:38:23 记录原记账id
		r_blCgItmOepDO.setFg_recg(FBoolean.TRUE);		
		r_blCgItmOepDO.setFg_refund(FBoolean.FALSE);		
		r_blCgItmOepDO.setId_recg_oep(id_recg_ip);
		r_blCgItmOepDO.setDt_srv(strDateTime);		
		r_blCgItmOepDO.setStatus(DOStatus.NEW);
		r_blCgItmOepDO.setNote("重划价：红冲");
		return r_blCgItmOepDO;
	}
	/**
	 * 获得重划价的记账信息
	 * @param orgin_blCgIpDO 原记账信息
	 * @param operatorInfo 操作员信息
	 * @param id_recg_ip 重划价操作员记录主键
	 * @param strDateTime 重划价日期
	 * @param specicalSrvPricalRateAndPriceDTOArr 新价格分类下的特需项目价格比例
	 * @param new_ration 新价格分类下的默认价格比例
	 * @return 重划价的记账信息
	 */
	private BlCgItmOepDO getNewChargeBlCgItmOepDO(BlCgItmOepDO orgin_blCgOepDO,OperatorInfoDTO operatorInfo,String id_recg_ip,FDateTime strDateTime,SrvPricalRateAndPriceDTO[] specicalSrvPricalRateAndPriceDTOArr,FDouble new_ration)
	{
		FDouble amt_ratio=null;
		
		BlCgItmOepDO n_blCgItmOepDO=new BlCgItmOepDO();
		n_blCgItmOepDO=(BlCgItmOepDO)orgin_blCgOepDO.clone();
		n_blCgItmOepDO.setId_cgitmoep(null);
	//	n_blCgItmOepDO.setId_cgoep(null); //先不设置为空，后面设置
		//重收不改原记录方便
		//n_blCgIpDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		
//		if(n_blCgIpDO.getEu_direct()==BookRtnDirectEnum.REFUND)
//		{
//			n_blCgIpDO.setEu_direct(BookRtnDirectEnum.CHARGES);
//		}
//		else
//		{
//			n_blCgIpDO.setEu_direct(BookRtnDirectEnum.REFUND);
//		}
		
		n_blCgItmOepDO.setQuan(orgin_blCgOepDO.getQuan());
		n_blCgItmOepDO.setAmt_std(orgin_blCgOepDO.getAmt_std());
		 
		//情况单价和比例
		FDouble orgin_Price=n_blCgItmOepDO.getPrice();
	
		n_blCgItmOepDO.setRatio_pripat(null);
		n_blCgItmOepDO.setAmt_ratio(null);
		n_blCgItmOepDO.setAmt_pat(null);
		n_blCgItmOepDO.setAmt(null);
		for (SrvPricalRateAndPriceDTO pri:specicalSrvPricalRateAndPriceDTOArr)
		{
			if(pri.getId_srv()!=null)
			{
				if(n_blCgItmOepDO.getId_srv().equals(pri.getId_srv()))
				{
					if(pri.getPrice()!=null)
					{
						n_blCgItmOepDO.setPrice(pri.getPrice());  //价格和比例同时存在时，价格优先
						amt_ratio=pri.getPrice().multiply(n_blCgItmOepDO.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
						n_blCgItmOepDO.setRatio_pripat(new FDouble(1));	
					}
					else
					{
						n_blCgItmOepDO.setRatio_pripat(pri.getRate());					
					}
					break;
				}
			}
		}
		
		if(n_blCgItmOepDO.getRatio_pripat()==null) //没有特殊的就按价格分类的默认比例走
		{
			n_blCgItmOepDO.setRatio_pripat(new_ration);
		}
		//折扣价格
		n_blCgItmOepDO.setPrice_ratio(n_blCgItmOepDO.getPrice().multiply(n_blCgItmOepDO.getRatio_pripat()).setScale(-2, BigDecimal.ROUND_HALF_UP));
		
		if(amt_ratio==null)
		{
			amt_ratio=n_blCgItmOepDO.getPrice_ratio().multiply(n_blCgItmOepDO.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
		}
		
		n_blCgItmOepDO.setAmt_ratio(amt_ratio);
		n_blCgItmOepDO.setAmt(amt_ratio);
		n_blCgItmOepDO.setAmt_pat(amt_ratio);
		n_blCgItmOepDO.setAmt_hp(orgin_blCgOepDO.getAmt_hp());
		
		n_blCgItmOepDO.setId_par(orgin_blCgOepDO.getId_cgitmoep()); //by liwq 2017年7月3日14:38:23 记录原记账id
		n_blCgItmOepDO.setFg_recg(FBoolean.TRUE);	
		n_blCgItmOepDO.setFg_refund(FBoolean.FALSE);		
		n_blCgItmOepDO.setId_recg_oep(id_recg_ip);
		n_blCgItmOepDO.setDt_srv(strDateTime);
		n_blCgItmOepDO.setStatus(DOStatus.NEW);
		n_blCgItmOepDO.setNote("重划价：重收");
		return n_blCgItmOepDO;
	}
	

	/**
	 * 根据患者id_pat 查询门诊记账明细表bl_cg_itm_oep 是否 含有挂起的数据
	 * @param id_pat
	 * @author liwq
	 */
	public BlRecgOepDTO[] getBlCgItmOepFgSuspInfo(String id_pat) throws BizException {
	
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT distinct B.id_ent     Pat_id_ent,  ");
		sql.append("        PI_PAT.Name     Pat_name, ");
		sql.append("        bd_pri_pat.name Pat_pripat_name, ");
		sql.append("        bd_dep.name     Id_dep_reg, ");
		sql.append("        en_ent.dt_acpt  Pat_dt_acpt, ");
		sql.append("        en_ent.code     en_code, ");
		sql.append("        bd_pri_pat.id_pripat Pat_id_pripat, ");
		sql.append("        PI_PAT.code     Pat_code,  ");
		sql.append("        PI_PAT.id_pat     Id_pat ");		
		sql.append("   FROM PI_PAT ");
		sql.append("   JOIN EN_ENT ");
		sql.append("     ON PI_PAT.ID_PAT = EN_ENT.ID_PAT ");
		sql.append(" INNER JOIN BL_CG_ITM_OEP B ON EN_ENT.ID_ENT = B.ID_ENT ");
		sql.append("   join bd_pri_pat ");
		sql.append("     on en_ent.id_pripat = bd_pri_pat.id_pripat ");
		sql.append("   join en_ent_op ");
		sql.append("     on EN_ENT.ID_ENT = en_ent_op.id_ent ");
		sql.append("   join bd_dep ");
		sql.append("     on en_ent_op.id_dep_reg=bd_dep.id_dep ");
		sql.append("  where (en_ent.code_entp = '00' or en_ent.code_entp = '01') and b.fg_susp='Y'  ");
		sql.append(" and b.id_pat = ? ");
		sql.append("order by en_ent.code  ");

		SqlParam parameter=new SqlParam();
		
		parameter.addParam(id_pat);
		
		@SuppressWarnings("unchecked")
		List<BlRecgOepDTO> list = (List<BlRecgOepDTO>) new DAFacade().execQuery(sql.toString(),parameter, new BeanListHandler(BlRecgOepDTO.class));
		// 用取出的结果集给对应属性赋.
		if (list.isEmpty())
		{
			//System.out.println("查询数据为空");	
			//throw new BizException("没有找到该患者的就诊信息");
			return null;
		}
		else
			return list.toArray(new BlRecgOepDTO[list.size()]);		
	}
}
