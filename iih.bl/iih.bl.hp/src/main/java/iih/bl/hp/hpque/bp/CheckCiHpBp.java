package iih.bl.hp.hpque.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.hp.d.BdHpUnlimitDrugDO;
import iih.bd.pp.hp.i.IBdHpUnlimitDrugDORService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bl.hp.Service.s.Bp.BlHpInteractiveWithCHISBp;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.lui.core.scriptrule.XapScriptAPI;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

public class CheckCiHpBp {

	/**
	 * 用于医生开单的各服务的合计值和配合度等需要在最后保存签署环节才能校验的校验接口， 如单方、领量、持有量等
	 * 
	 * @param ciHpCheckDTO
	 *            开单需要进行校验的相关信息
	 * @return CiHpCheckResultDTO 开单结果。 首先，获得CiHpCheckResultDTO.CheckFlag，
	 *         如果为TRUE,则校验通过，可以保存； 如果为FALSE，则校验失败，
	 *         失败，通过CiHpCheckResultDTO.FailIdorsrvMap获得失败的原因<失败的id_srv,失败原因描述>
	 * @throws BizException
	 */
	public CiHpCheckResultDTO exec(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CiHpCheckResultDTO ciHpCheckResultDTO = new CiHpCheckResultDTO();
		ciHpCheckResultDTO.setCheckflag(FBoolean.TRUE);// 默认通过校验
		List<FMap2> errorLst = new ArrayList<FMap2>();

		// 1.组装检查数据
		PatiVisitDO patiVisitDO = getPatiVisitDO(ciHpCheckDTO.getId_ent());
		ciHpCheckDTO.setEntdo(patiVisitDO);
		//主医保计划
		ciHpCheckDTO.setId_mmLst(getBdHpUnlimitDrugDOLst(patiVisitDO.getId_hp()));
//		ciHpCheckDTO = iHpQueServiceBpImpl.cleanBeforeValidate(ciHpCheckDTO);// review by yangyang 2017-06-14  和ci域po确认过医保规则不限制不限量药品，过滤掉不限量药品
		ciHpCheckDTO.setPatdo(getPatDO(ciHpCheckDTO.getId_pat()));
		ciHpCheckDTO.setEnthpdo(getEntHpDOLst(ciHpCheckDTO.getId_ent()));
		ciHpCheckDTO.setQuerydays(30); // 默认30天
		ciHpCheckDTO.setHistorycidto(getHpQryCiorderDTOLst(ciHpCheckDTO, true, true));
        Map<String, Object> variable = new HashMap<String, Object>();
        variable.put("CiHpCheckDTO", ciHpCheckDTO);

		// 查找当日医嘱集合 ：此处，将ciHpCheckDTO.Querydays设置成1

		// 2.调用脚本规则,获得校验结果

		// 统一说明，true表示通过校验，false表示未通过校验
        //单方校验
        try
        {
            //规则引擎执行的业务代码出现异常，会直接向上层抛出
            CiHpCheckResultDTO singlePresCheckResultDto = (CiHpCheckResultDTO) XapScriptAPI.compileExeSingleRule("SINGLEIDSRV1", variable); // 单方限制
            if(!singlePresCheckResultDto.getCheckflag().booleanValue())
            {
                ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
                ciHpCheckResultDTO.setFailidorsrvmap(singlePresCheckResultDto.getFailidorsrvmap());
                //review by yangyang 对于单方的限制，医嘱只做提示，限制级别低，不直接返回
                //return ciHpCheckResultDTO;
            }
        }
        catch(Exception ex)
        {
            throw new BizException("医保单方规则校验失败，请联系工程师！");
        }



		CiHpCheckDTO hpcheckDtoWithOneDayOrs = new CiHpCheckDTO();
//	      CiHpCheckDTO ciHpCheckDTO_REPEAT_PRES_DRUG1 = new CiHpCheckDTO();
		hpcheckDtoWithOneDayOrs.setId_ent(ciHpCheckDTO.getId_ent());
		hpcheckDtoWithOneDayOrs.setId_pat(ciHpCheckDTO.getId_pat());
		hpcheckDtoWithOneDayOrs.setQuerydays(1);
		hpcheckDtoWithOneDayOrs.setHistorycidto(getHpQryCiorderDTOLst(hpcheckDtoWithOneDayOrs, true, false));// 自然日
		hpcheckDtoWithOneDayOrs.setCi_di_itms(ciHpCheckDTO.getCi_di_itms());
		hpcheckDtoWithOneDayOrs.setSavecidto(ciHpCheckDTO.getSavecidto());
		Map<String, Object> mpCiHpCheckDtoWithOneDayOrs = new HashMap<String, Object>();
		mpCiHpCheckDtoWithOneDayOrs.put("CiHpCheckDTO", hpcheckDtoWithOneDayOrs);
//	      variable_ciHpCheckDTO_REPEAT_PRES_DRUG1.put("CiHpCheckDTO", hpcheckDtoWithOneDayOrs);
		
		try
		{
		    // 放射类医嘱限制
		    CiHpCheckResultDTO radiateOrderCheckDto = (CiHpCheckResultDTO) XapScriptAPI.compileExeSingleRule("RADIATION_CLASS_ORDER1", mpCiHpCheckDtoWithOneDayOrs);
	        if(!radiateOrderCheckDto.getCheckflag().booleanValue())
	        {
	            ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
	            ciHpCheckResultDTO.setFailidorsrvmap(radiateOrderCheckDto.getFailidorsrvmap());
	            //放射类医嘱只是提示，这里不做强制返回
	        }
		}
		catch(Exception ex)
		{
            //规则引擎会吞掉异常，这里断言规则引擎肯定会返回值，若为空，则代表有异常发生
            throw new BizException("医保放射医嘱规则校验失败，请联系工程师！"); 
		}

		try{
		 // 重复开药限制
	        CiHpCheckResultDTO repeatDrugCheckResultDto = (CiHpCheckResultDTO) XapScriptAPI.compileExeSingleRule("REPEAT_PRES_DRUG1", mpCiHpCheckDtoWithOneDayOrs);
	        if (!repeatDrugCheckResultDto.getCheckflag().booleanValue()) // 未重复开药限制
	        {
	            ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
	            ciHpCheckResultDTO.setFailidorsrvmap(repeatDrugCheckResultDto.getFailidorsrvmap());
	            return ciHpCheckResultDTO;
	        }
		}
		catch(Exception ex)
		{
            //规则引擎会吞掉异常，这里断言规则引擎肯定会返回值，若为空，则代表有异常发生
            throw new BizException("医保重复开药规则校验失败，请联系工程师！");
		}

		try
		{
		      // 单次执行医嘱领量限制
	        CiHpCheckResultDTO freqOnceCheckResultDto = (CiHpCheckResultDTO) XapScriptAPI.compileExeSingleRule("GREATER_THAN_ONE_TIME1", variable);
            if (!freqOnceCheckResultDto.getCheckflag().booleanValue()) // 单次执行医嘱领量限制
            {
                ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
                ciHpCheckResultDTO.setFailidorsrvmap(freqOnceCheckResultDto.getFailidorsrvmap());
                return ciHpCheckResultDTO;
            }
		}catch(Exception ex)
		{
            //规则引擎会吞掉异常，这里断言规则引擎肯定会返回值，若为空，则代表有异常发生
            throw new BizException("医保单次执行规则校验失败，请联系工程师！");
		}
		
		//如果是门诊，判断门诊领量限制
		if(ciHpCheckDTO.getEntdo().getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP))
		{
		    try{
	            // 超过门诊领量限制
	            CiHpCheckResultDTO fetchMzCheckResultDto = (CiHpCheckResultDTO) XapScriptAPI.compileExeSingleRule("GREATER_THAN_GET_OEP", variable);
	              // 门诊领量限制
                if (!fetchMzCheckResultDto.getCheckflag().booleanValue()) // 超过门诊领量限制
                {
                    ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
                    ciHpCheckResultDTO.setFailidorsrvmap(fetchMzCheckResultDto.getFailidorsrvmap());
                    return ciHpCheckResultDTO;
                }
		    }
		    catch(Exception ex)
		    {
	              //规则引擎会吞掉异常，这里断言规则引擎肯定会返回值，若为空，则代表有异常发生
                throw new BizException("门诊领量规则校验失败，请联系工程师！");
		    }
	        
		    try{
		          // 门诊持有量限制
	            CiHpCheckResultDTO GREATER_THAN_OWN_OEP_dto = (CiHpCheckResultDTO) XapScriptAPI.compileExeSingleRule("GREATER_THAN_OWN_OEP", variable);
	              // 门诊持有量限制
                if (!GREATER_THAN_OWN_OEP_dto.getCheckflag().booleanValue()) // 门诊持有量限制
                {
                    ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
                    ciHpCheckResultDTO.setFailidorsrvmap(GREATER_THAN_OWN_OEP_dto.getFailidorsrvmap());
                    return ciHpCheckResultDTO;
                }
		    }
		    catch(Exception ex)
		    {
                //规则引擎会吞掉异常，这里断言规则引擎肯定会返回值，若为空，则代表有异常发生
                throw new BizException("医保门诊持有量规则校验失败，请联系工程师！");
		    }
		}//门诊领量以及持有量校验

		
		if(ciHpCheckDTO.getEntdo().getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET))
		{
		    try{
		          // 超过急诊领量限制
	            CiHpCheckResultDTO GREATER_THAN_GET_ER_dto = (CiHpCheckResultDTO) XapScriptAPI.compileExeSingleRule("GREATER_THAN_GET_ER", variable); 		    
	              // 急诊领量限制
                if (!GREATER_THAN_GET_ER_dto.getCheckflag().booleanValue()) // 超过急诊领量限制
                {
                    ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
                    ciHpCheckResultDTO.setFailidorsrvmap(GREATER_THAN_GET_ER_dto.getFailidorsrvmap());
                    return ciHpCheckResultDTO;
                }
            }
		    catch(Exception ex)
		    {
                //规则引擎会吞掉异常，这里断言规则引擎肯定会返回值，若为空，则代表有异常发生
               throw new BizException("医保急诊领量规则校验失败，请联系工程师！");
		    }
		}

		return ciHpCheckResultDTO;
	}

	/**
	 * 获取检查数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getPatiVisitDO(String id_ent) throws BizException {

		IPativisitRService iPativisitRService = (IPativisitRService) ServiceFinder.find(IPativisitRService.class);

		PatiVisitDO patiVisitDO = iPativisitRService.findById(id_ent);

		return patiVisitDO;
	}

	/**
	 * 获得指定医保计划下无限制用量的药品名单ID_MM
	 * 
	 * @param id_hp
	 *            医保计划
	 * @return
	 * @throws BizException
	 */
	private List<String> getBdHpUnlimitDrugDOLst(String id_hp) throws BizException {

		IBdHpUnlimitDrugDORService iBdHpUnlimitDrugDORService = ServiceFinder.find(IBdHpUnlimitDrugDORService.class);

		BdHpUnlimitDrugDO[] bdHpUnlimitDrugDOs = iBdHpUnlimitDrugDORService.find(" id_hp='" + id_hp + "'", "", FBoolean.TRUE);

		List<String> bdHpUnlimitDrugLst = new ArrayList<String>();// id_mm

		String sql = "select a.id_mm from bd_hp_srvorca a inner join bd_hp_unlimit_drug b on a.code=b.code_hp and a.id_hp=b.id_hp where a.id_hp=?";

		SqlParam sqlp = new SqlParam();

		sqlp.addParam(id_hp);

		//查询不限量药品
		List<HPSrvorcaDO> hPSrvorcaDOList = (List<HPSrvorcaDO>) new DAFacade().execQuery(sql, sqlp, new BeanListHandler(HPSrvorcaDO.class));

		if (hPSrvorcaDOList != null) {
			for (HPSrvorcaDO hPSrvorcaDO : hPSrvorcaDOList) {
				bdHpUnlimitDrugLst.add(hPSrvorcaDO.getId_mm());
			}
		}

		return bdHpUnlimitDrugLst;
	}

	/**
	 * 获取患者信息
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatDO(String id_pat) throws BizException {

		IPatiMDORService pipatService = (IPatiMDORService) ServiceFinder.find(IPatiMDORService.class);

		PatDO pipatdo = pipatService.findById(id_pat);

		return pipatdo;
	}

	/**
	 * 获取医保计划
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private FArrayList2 getEntHpDOLst(String id_ent) throws BizException {

		IEnthpRService iEnthpRService = (IEnthpRService) ServiceFinder.find(IEnthpRService.class);

		EntHpDO[] entHpDOArr = iEnthpRService.find(" id_ent='" + id_ent + "'", "", FBoolean.FALSE);

		FArrayList2 entHpDOFLst = new FArrayList2();

		if (entHpDOArr != null || entHpDOArr.length > 0) {

			for (EntHpDO entHpDO : entHpDOArr) {

				entHpDOFLst.add(entHpDO);

			}
		}

		return entHpDOFLst;
	}

	/**
	 * 查询历史医嘱信息
	 * 
	 * @param ciHpCheckDTO
	 * @param f_nature_day
	 *            是否按照自然日查询
	 * @param f_inCg
	 *            是否记账 true:只提取记账医嘱；false：提取所有医嘱（已签署，未作废）
	 * @return
	 * @throws BizException
	 */
	private FArrayList2 getHpQryCiorderDTOLst(CiHpCheckDTO ciHpCheckDTO, boolean f_nature_day, boolean f_inCg) throws BizException {

		FArrayList2 HpQryCiorderDTOLst = new FArrayList2();

		FArrayList2 HpQryCiorderDTOLst_temp = new FArrayList2();

		//获取当前日期
		FDateTime endTime = AppUtils.getServerDateTime();

		FDateTime startTime =null;

		if (!f_nature_day) {
			startTime = endTime.getDateTimeBefore(ciHpCheckDTO.getQuerydays());
		}
		else{
		    startTime= DateTimeUtils.getDateTimeBefore(endTime, ciHpCheckDTO.getQuerydays());
		}

		ICiOrdQryService ICiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);

		HpQryCiorderDTOLst = ICiOrdQryService.getCiorderDTOs(ciHpCheckDTO.getId_pat(), startTime, endTime); // 医保只能收72小时内的药品处方
		// 只提取记账医嘱
		if (f_inCg) {
			if (HpQryCiorderDTOLst == null || HpQryCiorderDTOLst.size() == 0) {
				return null;
			}
			for (Object hpQryCiorderDTO1 : HpQryCiorderDTOLst) {
				HpQryCiorderDTO hpQryCiorderDTO = (HpQryCiorderDTO) hpQryCiorderDTO1;
				FArrayList2 ordSrvDOLst = hpQryCiorderDTO.getOrdsrvs();
				if (ordSrvDOLst == null) {
					continue;
				}
				for (Object ordSrvDO1 : ordSrvDOLst) {
					OrdSrvDO ordSrvDO = (OrdSrvDO) ordSrvDO1;
					if (ordSrvDO.getSd_su_bl() != null && ordSrvDO.getSd_su_bl().equals("1")) {
						HpQryCiorderDTOLst_temp.add(hpQryCiorderDTO1);
						break;
					}
				}
			}
			HpQryCiorderDTOLst = HpQryCiorderDTOLst_temp;
		}
		// 加入老CHIS的数据
		BlHpInteractiveWithCHISBp blHpInteractiveWithCHISBp = new BlHpInteractiveWithCHISBp();
		CiHpCheckDTO ciHpCheckDTO_chis = blHpInteractiveWithCHISBp.getCiHpCheckDTOFromCHIS(getPatCode(ciHpCheckDTO.getId_pat()));
		//TODO review by yangyang 2017-06-09 这里有问题
//		if (HpQryCiorderDTOLst != null && HpQryCiorderDTOLst.size() > 0) {
//			if (ciHpCheckDTO_chis != null) {
//				HpQryCiorderDTOLst.add(ciHpCheckDTO_chis);
//			}
//		}
		return HpQryCiorderDTOLst;
	}

	/**
	 * 获取患者code
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private String getPatCode(String id_pat) throws BizException {
		String code = "";
		DAFacade dafacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<PatDO> patDOLst = (List<PatDO>) dafacade.execQuery(" select code from pi_pat where id_pat='" + id_pat + "'", new BeanListHandler(PatDO.class));
		if (patDOLst != null && patDOLst.size() > 0) {
			code = patDOLst.toArray(new PatDO[0])[0].getCode();
		}
		return code;
	}

}
