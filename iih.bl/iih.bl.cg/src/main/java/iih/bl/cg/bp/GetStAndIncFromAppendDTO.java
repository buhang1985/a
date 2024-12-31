package iih.bl.cg.bp;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.RsHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
//import iih.bd.bc.udi.pub.IBlDictCodeTypeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.dto.d.BlCgItmOepMapDTO;
import iih.bl.cg.dto.d.BlStAndIncDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
//import iih.bl.cg.service.s.IBLCiOrderToBlCgServiceImpl;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlStIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.service.i.IBlincQryService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.blstoep.i.IBlstoepCudService;
/**
 * 根据BlOrderAppendBillParamDTO或者CG和ST，生成对应的发票信息
 * @author tcy
 *
 */
public class GetStAndIncFromAppendDTO {
//	private BlStOepDO[] blStOepDO=null;
//	private BlincoepAggDO[] blincoepAggDO=null;
//	List<BlStOepDO> blStOepDOLst=new ArrayList<BlStOepDO>();
//	List<BlincoepAggDO> blincoepAggDOLst=new ArrayList<BlincoepAggDO>();
	//IBLCiOrderToBlCgService 
	
	/**
	 * 根据记账信息，生成结算信息bl_st_oep
	 * @param blcgoepAggDOs 记账信息
	 * @param operatorInfoDTO 操作员信息
	 * @param PrintInvocie 是否打印发票
	 * @param blCgItmOepMapDTO  记账对应的各分项AMT和
	 * @param fDateTime 服务器时间
	 * @return
	 * @throws BizException
	 */
	public BlStOepDO createStFromCg_OEP (BlcgoepAggDO[] blcgoepAggDOs,OperatorInfoDTO operatorInfoDTO, FBoolean PrintInvocie, BlCgItmOepMapDTO blCgItmOepMapDTO,FDateTime fDateTime) throws BizException
	{		
		Map<String, FDouble> blCgItmOepAmtStdMap = blCgItmOepMapDTO
				.getBlCgItmOepAmtStdMap();// Map<就诊,标准金额>
		Map<String, FDouble> blCgItmOepAmtMap = blCgItmOepMapDTO
				.getBlCgItmOepAmtMap();// Map<就诊,应交金额>
		Map<String, FDouble> blCgItmOepAmtPatMap = blCgItmOepMapDTO
				.getBlCgItmOepAmtPatMap();// Map<就诊,医保自付金额>
		Map<String, FDouble> blCgItmOepAmtRatioMap = blCgItmOepMapDTO
				.getBlCgItmOepAmtRatioMap();// Map<就诊,金额_价格比例>
		Map<String, FDouble> blCgItmOepAmtHpMap = blCgItmOepMapDTO
				.getBlCgItmOepAmtHpMap();// Map<就诊,金额_医保支付比例>
        //1. 生成结算表
		BlStOepDO blStOepDo = new BlStOepDO();		
		blStOepDo.setEu_direct(1);
		BlCgItmOepDO blCgItmOepDO=blcgoepAggDOs[0].getBlCgItmOepDO()[0];//取必要字段，组装结算表
		/*// 通过就诊来源判别结算的结算类型，一般情况下挂号费肯定单结
		if (blCgItmOepDO.getEu_srctp().equals(0)) {
			blStOepDo.setEu_sttp(StTypeEnum.ST_OEP_CHARGE);
		} else if (blCgItmOepDO.getEu_srctp().equals(1)) {
			blStOepDo.setEu_sttp(StTypeEnum.ST_OEP_REG);
		}*/
		
		//修改计算类型设置 ly 2018/08/31
		blStOepDo.setEu_sttp(this.getStType(blcgoepAggDOs)); 
		
		blStOepDo.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		blStOepDo.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		blStOepDo.setId_org(operatorInfoDTO.getId_org());
		blStOepDo.setId_grp(operatorInfoDTO.getId_grp());
		blStOepDo.setId_pat(blCgItmOepDO.getId_pat());
		blStOepDo.setId_ent(blCgItmOepDO.getId_ent());
		blStOepDo.setId_dep_st(operatorInfoDTO.getId_dep());
		blStOepDo.setId_emp_st(operatorInfoDTO.getId_emp());
		blStOepDo.setId_enttp(blCgItmOepDO.getId_enttp());
		blStOepDo.setCode_enttp(blCgItmOepDO.getCode_enttp());
		blStOepDo.setAmt_std(blCgItmOepAmtStdMap.get(blCgItmOepDO.getId_pat()));
		blStOepDo.setAmt(blCgItmOepAmtMap.get(blCgItmOepDO.getId_pat()));
		blStOepDo.setAmt_pat(blCgItmOepAmtPatMap.get(blCgItmOepDO.getId_pat()));
		blStOepDo.setAmt_ratio(blCgItmOepAmtRatioMap.get(blCgItmOepDO.getId_pat()));// 金额——价格比例
		blStOepDo.setAmt_hp(blCgItmOepAmtHpMap.get(blCgItmOepDO.getId_pat()));
		//如果已经有结算编码，就不再生成
		String stCode = Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_ST_CODE, String.class);
		
		if(StringUtil.isEmpty(stCode))
		{
			stCode = BlCodeUtils.generateOepStCode();
		}
				
		blStOepDo.setCode_st(stCode);
		blStOepDo.setDt_st(fDateTime);			
		blStOepDo.setFg_cc(FBoolean.FALSE);//设置结账标志为FALSE
		blStOepDo.setId_paypatoep("");
		blStOepDo.setStatus(DOStatus.NEW);
		
		Object dftPatca = Context.get().getAttribute("DEFAULTPATCA");
		if(dftPatca != null){
			blStOepDo.setId_patca(dftPatca.toString());
		}else{
			blStOepDo.setId_patca(getIdPatCaByIdEnt(blCgItmOepDO.getId_ent()));
		}

		IBlstoepCudService iBlstoepCudService = ServiceFinder.find(IBlstoepCudService.class);	
		BlStOepDO[] blStOepDOs=iBlstoepCudService.save(new BlStOepDO[]{blStOepDo});
		if(null==blStOepDOs)
		{
			throw new BizException("保存门诊结算信息失败");
		}
		return blStOepDOs[0];
	}
	
	private String getIdPatCaByIdEnt(String idEnt) throws DAException{
		if(StringUtils.isBlank(idEnt))
			return null;
		DAFacade daf = new DAFacade();
		String sql = "select id_patca from en_ent where id_ent = ?";
		SqlParam par = new SqlParam();
		par.addParam(idEnt);
		String idPatCa = (String) daf.execQuery(sql, par, new ColumnHandler("id_patca"));
		return idPatCa;
	}
	
	/**
	 * 设置结算类型
	 * @param itmList
	 * @return
	 */
	private String getStType(BlcgoepAggDO[] blcgoepAggDOs){
		
		List<BlCgItmOepDO> itmList = new ArrayList<BlCgItmOepDO>();
		for (BlcgoepAggDO aggDO : blcgoepAggDOs) {
			itmList.addAll(Arrays.asList(aggDO.getBlCgItmOepDO()));
		}

		for (BlCgItmOepDO itm : itmList) {

			if (FeeOriginEnum.ORDERS_FEE.equals(itm.getEu_srctp())
					|| FeeOriginEnum.PATREGISTER_FEE.equals(itm.getEu_srctp())||FeeOriginEnum.THIRDPE_FEE.equals(itm.getEu_srctp())) {
				return StTypeEnum.ST_OEP_CHARGE;
			}
		}

		return StTypeEnum.ST_OEP_REG;
	}
	
	/**
	 * 根据记账信息和结算信息，生成对应的发票信息
	 * @param appendBillParamDTOs 待划价信息
	 * @param operatorInfoDTO 操作员信息
	 * @param PrintInvocie 是否打印发票
	 * @return 对应的bl_st_oep,bl_Inc_oep基础DO数据	 
	 * @throws BizException
	 * @author tcy
	 */ //by ly 2018/03/28 没啥用
	public BlincoepAggDO createIncByCgAndSt_OEP(BlcgoepAggDO[] blcgoepAggDOs,BlStOepDO blStOepDO, FBoolean PrintInvocie,String code_incpkg,String incno,BlCgItmOepMapDTO blCgItmOepMapDTO,FDateTime fDateTime) throws BizException
    {		
		Map<String, FDouble> blCgItmOepAmtStdMap = blCgItmOepMapDTO
				.getBlCgItmOepAmtStdMap();// Map<就诊,标准金额>
		Map<String, FDouble> blCgItmOepAmtMap = blCgItmOepMapDTO
				.getBlCgItmOepAmtMap();// Map<就诊,应交金额>
		Map<String, FDouble> blCgItmOepAmtPatMap = blCgItmOepMapDTO
				.getBlCgItmOepAmtPatMap();// Map<就诊,医保自付金额>
		Map<String, FDouble> blCgItmOepAmtRatioMap = blCgItmOepMapDTO
				.getBlCgItmOepAmtRatioMap();// Map<就诊,金额_价格比例>
		Map<String, FDouble> blCgItmOepAmtHpMap = blCgItmOepMapDTO
				.getBlCgItmOepAmtHpMap();// Map<就诊,金额_医保支付比例>
        
		//1.生成发票主表
		BlincoepAggDO blincoepAggDo = new BlincoepAggDO();
		BlIncOepDO blIncOepDo = new BlIncOepDO();
		blIncOepDo.setId_org(blStOepDO.getId_org());
		blIncOepDo.setId_grp(blStOepDO.getId_grp());
		blIncOepDo.setId_pat(blStOepDO.getId_pat());
		blIncOepDo.setId_enttp(blStOepDO.getId_enttp());
		blIncOepDo.setAmt_std(blCgItmOepAmtStdMap.get(blStOepDO.getId_pat()));
		blIncOepDo.setAmt(blCgItmOepAmtMap.get(blStOepDO.getId_pat()));
		blIncOepDo.setAmt_pat(blCgItmOepAmtPatMap.get(blStOepDO.getId_pat()));
		blIncOepDo.setAmt_ratio(blCgItmOepAmtRatioMap.get(blStOepDO.getId_pat()));// 金额——价格比例
		blIncOepDo.setAmt_hp(blCgItmOepAmtHpMap.get(blStOepDO.getId_pat()));
		blIncOepDo.setCode_enttp(blStOepDO.getCode_enttp());
		blIncOepDo.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		blIncOepDo.setEu_direct(BookRtnDirectEnum.CHARGES);
		blIncOepDo.setId_stoep(blStOepDO.getId_stoep());
		blIncOepDo.setDt_inc(fDateTime);
		// 划价未打印发票，收款才打印发票
		blIncOepDo.setFg_print(FBoolean.FALSE);		
		blIncOepDo.setFg_cc_in(FBoolean.FALSE);
		blIncOepDo.setFg_cc_out(FBoolean.FALSE);
		blIncOepDo.setId_cc_in(null);
		blIncOepDo.setId_cc_out(null);
		blIncOepDo.setStatus(DOStatus.NEW);
		
        //2.生成BlIncItmOepDO
		Map<String,BlIncItmOepDO> blCgIncTypeBlIncItmOepDOMap=blCgItmOepMapDTO.getBlCgIncTypeBlIncItmOepDOMap();
		List<BlIncItmOepDO> blIncItmOepDOLst=new ArrayList<BlIncItmOepDO>();
		Iterator iter=blCgIncTypeBlIncItmOepDOMap.entrySet().iterator();
		while(iter.hasNext())
		{
			Map.Entry entry = (Map.Entry) iter.next();
			blIncItmOepDOLst.add((BlIncItmOepDO)entry.getValue());
		}
		if(ListUtil.isEmpty(blIncItmOepDOLst))
		{
			throw new BizException("没有生成发票账单表数据");
		}
		
		//3.生成BlStIncOepDO
		BlStIncOepDO blStIncOepDO=new BlStIncOepDO();
		blStIncOepDO.setId_stoep(blStOepDO.getId_stoep());
		blStIncOepDO.setFg_active(FBoolean.TRUE);
		blStIncOepDO.setStatus(DOStatus.NEW);	
		
		//4.生成BlIncCgItmOep
		List<BlIncCgItmOep> blIncCgItmOepLst=new ArrayList<BlIncCgItmOep>();
		for(BlcgoepAggDO blcgoepAggDO: blcgoepAggDOs)
		{
			BlCgItmOepDO[] blCgItmOepDOs=blcgoepAggDO.getBlCgItmOepDO();
			for(int j=0;j<blCgItmOepDOs.length;j++)
			{
					if(blCgItmOepDOs[j].getFg_refund()!=null && blCgItmOepDOs[j].getFg_refund().booleanValue())
						continue;
					BlIncCgItmOep blIncCgItmOep=new BlIncCgItmOep();
					blIncCgItmOep.setId_cgitmoep(blCgItmOepDOs[j].getId_cgitmoep());
					blIncCgItmOep.setStatus(DOStatus.NEW);						
					blIncCgItmOepLst.add(blIncCgItmOep);
			
			}
		}
		
		
		//5.组装Agg
		blincoepAggDo.setParentDO(blIncOepDo);
		blincoepAggDo.setBlIncItmOepDO(blIncItmOepDOLst.toArray(new BlIncItmOepDO[0]));
		blincoepAggDo.setBlStIncOepDO(new BlStIncOepDO[]{blStIncOepDO});
		blincoepAggDo.setBlIncCgItmOep(blIncCgItmOepLst.toArray(new BlIncCgItmOep[0]));
		
		
		//6.保存BlincoepAggDO（bl_inc_oep,bl_inc_itm_oep,BL_ST_INC_OEPDO,BL_INC_CG_ITM_OEP)
		IBlincoepCudService iBlincoepCudService3 = ServiceFinder.find(IBlincoepCudService.class);
		BlincoepAggDO[] blincoepAggDOs=iBlincoepCudService3.save(new BlincoepAggDO[]{blincoepAggDo});
		if(null==blincoepAggDOs)
		{
			throw new BizException("保存门诊结算发票信息失败");
		}
		
		
	
		return blincoepAggDOs[0];
	}
	
	/**
	 * 根据待划价信息+操作员信息+是否打印发票，生成对应的bl_st_oep,bl_Inc_oep基础数据
	 * @param appendBillParamDTOs 待划价信息
	 * @param operatorInfoDTO 操作员信息
	 * @param PrintInvocie 是否打印发票
	 * @return 对应的bl_st_oep,bl_Inc_oep基础DO数据	 * 
	 * @throws BizException
	 * @author tcy
	 *//*
	public BlStAndIncDTO GeStAndIncFromBlOrderAppendBillParamDTO_OEP(BlOrderAppendBillParamDTO[] appendBillParamDTOs,OperatorInfoDTO operatorInfoDTO, FBoolean PrintInvocie) throws BizException
	{
		BlStAndIncDTO blStAndIncDTO=new BlStAndIncDTO();
		List<BlStOepDO> blStOepDOLst=new ArrayList<BlStOepDO>();
		List<BlincoepAggDO> blincoepAggDOLst=new ArrayList<BlincoepAggDO>();

		IBlincQryService iBlincQryService=ServiceFinder.find(IBlincQryService.class);
		String code_incpkg="";
		String ent_invoiceno="";
		
		if (PrintInvocie.booleanValue())
		{
			//获得票据包
			 code_incpkg=iBlincQryService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org_emp(), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		    //获得：就诊(病人)，发票号|
			 GetBlCgItmOepMap ins=new GetBlCgItmOepMap();
			 ent_invoiceno=ins.GetEntInvoicenoFromDTO(appendBillParamDTOs,  operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE, code_incpkg);
		}
		else
		{
			operatorInfoDTO.setId_dep("");
			operatorInfoDTO.setId_emp("");
			operatorInfoDTO.setId_grp("");
			operatorInfoDTO.setId_org("");
			operatorInfoDTO.setId_org_emp("");
		}
		
		//“.”和“|”都是转义字符，前边需要加上“\\"
		String[] arrEntInvoiceno = ent_invoiceno.split("\\|");
        String[] decodestr2 = null;	
        Map<String, String> ent_incno = new HashMap<String, String>();
        Map<String, String> temp = new HashMap<String, String>();
        String key = "", keyInvoice = "";
        //生成<就诊，发票号>
        for (int i = 0; i < arrEntInvoiceno.length; i++)
        {
        	if(StringUtil.isEmpty(arrEntInvoiceno[i]))
        		continue;
            decodestr2 = arrEntInvoiceno[i].split(",");
            ent_incno.put(decodestr2[0], decodestr2[1]);
        }
        BlStOepDO blStOepDos = new BlStOepDO();
        BlincoepAggDO blincoepAggDos = new BlincoepAggDO();
        if(ent_invoiceno.length()==0) //不打印发票，只有挂号才可能不打发票
        {
        	 //结算和就诊对应，是一对一的关系
//            BlStOepDO blStOepDos = new BlStOepDO();
            BlIncOepDO blIncOepDos = new BlIncOepDO();
//            BlincoepAggDO blincoepAggDos = new BlincoepAggDO();
        	blStOepDos.setEu_direct(1);
			//通过就诊来源判别结算的结算类型，一般情况下挂号费肯定单结
			if(appendBillParamDTOs[0].getEu_srctp().equals(0))
			{
				blStOepDos.setEu_sttp(StTypeEnum.ST_OEP_CHARGE);
			}
			else if(appendBillParamDTOs[0].getEu_srctp().equals(1))
			{
				blStOepDos.setEu_sttp(StTypeEnum.ST_OEP_REG);
			}
			blStOepDos
					.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
			blStOepDos
					.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
			blStOepDos.setId_org(appendBillParamDTOs[0].getId_org());
			blStOepDos.setId_grp(appendBillParamDTOs[0].getId_grp());
			blStOepDos.setId_pat(appendBillParamDTOs[0].getId_pat());
			blStOepDos.setId_ent(appendBillParamDTOs[0].getId_ent());
			blStOepDos.setId_dep_st(operatorInfoDTO.getId_dep());
			blStOepDos.setId_emp_st(operatorInfoDTO.getId_emp());
			blStOepDos.setId_enttp(appendBillParamDTOs[0].getId_enttp());
			blStOepDos.setCode_enttp(appendBillParamDTOs[0].getCode_enttp());
			blStOepDos.setStatus(DOStatus.NEW);
			blStOepDOLst.add(blStOepDos);

			blIncOepDos.setId_org(appendBillParamDTOs[0].getId_org());
			blIncOepDos.setId_grp(appendBillParamDTOs[0].getId_grp());
			blIncOepDos.setId_pat(appendBillParamDTOs[0].getId_pat());
		//	blIncOepDos.setId_ent(appendBillParamDTOs[0].getId_ent());
			blIncOepDos.setId_enttp(appendBillParamDTOs[0].getId_enttp());
//			if (PrintInvocie.booleanValue()) {
//				blIncOepDos.setIncno(ent_incno.get(key));
//				blIncOepDos.setTimes_prn(1);
//				blIncOepDos.setId_emp_inc(operatorInfoDTO.getId_emp());
//				blIncOepDos.setCode_incpkg(code_incpkg);
//			}
			
			blIncOepDos.setCode_enttp(appendBillParamDTOs[0].getCode_enttp());
			blIncOepDos
					.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
			blIncOepDos.setEu_direct(BookRtnDirectEnum.CHARGES);
			
			// 划价未打印发票，收款才打印发票
			blIncOepDos.setFg_print(FBoolean.FALSE);
			blIncOepDos.setStatus(DOStatus.NEW);
			blIncOepDos.setFg_cc_in(FBoolean.FALSE);
			blIncOepDos.setFg_cc_out(FBoolean.FALSE);
			blIncOepDos.setId_cc_in(null);
			blIncOepDos.setId_cc_out(null);
			blincoepAggDos.setParentDO(blIncOepDos);
			//blincoepAggDOLst.add(blincoepAggDos);
        }
        
        	
		for(int i = 0; i < ent_incno.size(); i++)
		{	             
             //结算和就诊对应，是一对一的关系
//             BlStOepDO blStOepDos = new BlStOepDO();
             BlIncOepDO blIncOepDos = new BlIncOepDO();
//             BlincoepAggDO blincoepAggDos = new BlincoepAggDO();
             decodestr2 = arrEntInvoiceno[i].split(",");
                   
			for (BlOrderAppendBillParamDTO item : appendBillParamDTOs) {
//				if (!PrintOnlyOneInvoice.booleanValue()) {
//					key = item.getId_pat() + " " + item.getId_ent() + " "
//							+ item.getId_enttp();
//				} else // 只打印一张发票
//				{
				//				2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
					key = item.getId_pat();
//				}
				if (!temp.containsKey(key)) {
					temp.put(key, "");

					if (key.equals(decodestr2[0].trim())) {
						blStOepDos.setEu_direct(1);
						//通过就诊来源判别结算的结算类型，一般情况下挂号费肯定单结
						if(item.getEu_srctp().equals(0))
						{
							blStOepDos.setEu_sttp(StTypeEnum.ST_OEP_CHARGE);
						}
						else if(item.getEu_srctp().equals(1))
						{
							blStOepDos.setEu_sttp(StTypeEnum.ST_OEP_REG);
						}
						blStOepDos
								.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
						blStOepDos
								.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
						blStOepDos.setId_org(item.getId_org());
						blStOepDos.setId_grp(item.getId_grp());
						blStOepDos.setId_pat(item.getId_pat());
						blStOepDos.setId_ent(item.getId_ent());
						blStOepDos.setId_dep_st(operatorInfoDTO.getId_dep());
						blStOepDos.setId_emp_st(operatorInfoDTO.getId_emp());
						blStOepDos.setId_enttp(item.getId_enttp());
						blStOepDos.setCode_enttp(item.getCode_enttp());
						blStOepDos.setStatus(DOStatus.NEW);
//						blStOepDOLst.add(blStOepDos);

						blIncOepDos.setId_org(item.getId_org());
						blIncOepDos.setId_grp(item.getId_grp());
						blIncOepDos.setId_pat(item.getId_pat());
				//		blIncOepDos.setId_ent(item.getId_ent());
						blIncOepDos.setId_enttp(item.getId_enttp());
						if (PrintInvocie.booleanValue()) {
							blIncOepDos.setIncno(ent_incno.get(key));
							blIncOepDos.setTimes_prn(1);
							blIncOepDos.setId_emp_inc(operatorInfoDTO.getId_emp());
							blIncOepDos.setCode_incpkg(code_incpkg);
						}
						
						blIncOepDos.setCode_enttp(item.getCode_enttp());
						blIncOepDos
								.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
						blIncOepDos.setEu_direct(BookRtnDirectEnum.CHARGES);
						
						// 划价未打印发票，收款才打印发票
						blIncOepDos.setFg_print(FBoolean.FALSE);
						blIncOepDos.setStatus(DOStatus.NEW);
						blincoepAggDos.setParentDO(blIncOepDos);
//						blincoepAggDOLst.add(blincoepAggDos);
					}
				}
			}
		}
//		blStAndIncDTO.setBlincoepAggDOLst(blincoepAggDOLst);
//		blStAndIncDTO.setBlStOepDOLst(blStOepDOLst);
		blStAndIncDTO.setBlStOepDO(blStOepDos);
		blStAndIncDTO.setBlincoepAggDO(blincoepAggDos);
		return blStAndIncDTO;
	}

	
*/
}
