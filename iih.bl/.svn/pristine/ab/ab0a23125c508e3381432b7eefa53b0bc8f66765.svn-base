package iih.bl.st.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.xap.core.utils.StringUtils;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.comm.BlBizUtil;
import iih.bl.st.dto.d.BlEntVsCodeHp;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 获取需上传的外配处方信息
 * @author liwenqiang
 *
 */
public class GetUploadExtRePresBP {
	/**
	 * 获取需上传的外配处方信息
	 * @param patId 患者ID
	 * @param entpCode 就诊类型
	 * @param beginSignTime 签署开始时间
	 * @param endSignTime 签署结束时间	
	 * @return 外配处方信息
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] exec(String patId,String entpCode,FDateTime beginSignTime,FDateTime endSignTime) throws BizException{
		// 1、参数校验
		
		// 获取计量单位列表
		Map<String, MeasDocDO> measMap = new HashMap<String, MeasDocDO>();// 计量单位字典
		measMap = this.setMeasDocDOMap();

		//  2、从CI查询外配处方信息,组织ID从上下文获取
		ICiOrdQryService service = (ICiOrdQryService) ServiceFinder
				.find(ICiOrdQryService.class);
		ArrayList<PrescriptionConstBaseDto> dtoList=new ArrayList<PrescriptionConstBaseDto>();
		if(entpCode.equals("1")||entpCode.equals("0")){
		PrescriptionConstBaseDto prescriptionConstBaseDto = service
				.getExtdispenseDto(patId, beginSignTime, endSignTime, IBdFcDictCodeConst.SD_CODE_ENTP_OP,
						Context.get().getOrgId());
		
			if(prescriptionConstBaseDto!=null){
				dtoList.add(prescriptionConstBaseDto);
				}
		}
		if(entpCode.equals("2")||entpCode.equals("0")){
			PrescriptionConstBaseDto prescriptionConstBaseDto = service
					.getExtdispenseDto(patId, beginSignTime, endSignTime, IBdFcDictCodeConst.SD_CODE_ENTP_ET,
							Context.get().getOrgId());
			
			if(prescriptionConstBaseDto!=null){dtoList.add(prescriptionConstBaseDto);}
		}
		
		
		List<BlOrderAppendBillParamDTO> orderBillItmDtoLst = this
				.assemblyOrderSrvDetailDtos(dtoList, measMap);

		 //补充一些字段
		 List<BlOrderAppendBillParamDTO> orderBillItmDtoFullLst=this.supplymentOrderBillItemFields(orderBillItmDtoLst);
	
		// 3、根据外配处方记录过滤已上传的记录

		 if(orderBillItmDtoFullLst!=null){
			 return orderBillItmDtoFullLst.toArray(new BlOrderAppendBillParamDTO[0]);
		 }
		 return null;
	}
	
	
	/**
	 * 获取计量单位列表
	 * 
	 * @throws BizException
	 * */
	private Map<String, MeasDocDO> setMeasDocDOMap() throws BizException {

		Map<String, MeasDocDO> measMap = new HashMap<String, MeasDocDO>();// 计量单位字典

		// 查询：调用轻量级的服务
		String[] fields = { "Id_measdoc", "Name" }; // 需要查询的列
		DAFacade dAFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<MeasDocDO> measDocDOList = (List<MeasDocDO>) dAFacade.findByCond(MeasDocDO.class, "1=1", "1", fields);
		if (measDocDOList != null && measDocDOList.size() > 0) {
			for (MeasDocDO measDocDO : measDocDOList) {
				if (measMap.get(measDocDO.getId_measdoc()) == null) {
					measMap.put(measDocDO.getId_measdoc(), measDocDO);
				}
			}
			
		}
		return measMap;
	}
	
	/**
	 * 组装未记账的费用明细
	 * @param prescriptionConstBaseDto 从医嘱获取到的未记账数据
	 * @return
	 * @throws BizException
	 */
	private List<BlOrderAppendBillParamDTO> assemblyOrderSrvDetailDtos(ArrayList<PrescriptionConstBaseDto> dtoList,Map<String, MeasDocDO> measMap) throws BizException{
		if (dtoList == null||dtoList.size()==0)
			return null;
		List<BlOrderAppendBillParamDTO> billDetailDtos=new ArrayList<BlOrderAppendBillParamDTO>();
		FArrayList recipeDTOLstMz =new FArrayList();
		
		for(PrescriptionConstBaseDto prescriptionConstBaseDto : dtoList)
		{
			// 未结账的医嘱信息
			FArrayList PrescriptionCostDtoLst = prescriptionConstBaseDto.getPrescriptionCostDto();
			if (PrescriptionCostDtoLst != null && PrescriptionCostDtoLst.size() > 0) {
				for (int i = 0; i < PrescriptionCostDtoLst.size(); i++) {
					BlOrderAppendBillParamDTO blOrderAppendBillParamDTO = new BlOrderAppendBillParamDTO();
					blOrderAppendBillParamDTO = setBillDetailDtoField((PrescriptionCostDto) PrescriptionCostDtoLst.get(i),
							measMap);
					billDetailDtos.add(blOrderAppendBillParamDTO);
				}
				FArrayList recieList = prescriptionConstBaseDto.getRecipeDTO();
//				recipeDTOLst.addAll(recipeDTOLstMz);
				// 挂号交易流水号
				Map<String, List<BlEntVsCodeHp>> id_entMap = new HashMap<String, List<BlEntVsCodeHp>>();// 从效率考虑
				List<BlEntVsCodeHp> blEntVsCodeHpLst = null;
				RecipeDTO[] recipeDTOArr = (RecipeDTO[]) recieList.toArray(new RecipeDTO[0]);
				
				for (RecipeDTO recipeDTO : recipeDTOArr) {
					if (!id_entMap.containsKey(recipeDTO.getId_en())) {
						StringBuffer sqlb = new StringBuffer();
						sqlb.append("select distinct a.id_ent, d.code_hp ");
						sqlb.append("   from bl_cg_itm_oep a, bl_st_oep b, bl_prop_oep c, BL_PROP_AR_OEP d ");
						sqlb.append("  where a.id_stoep = b.id_stoep ");
						sqlb.append("    and b.id_stoep = c.id_stoep ");
						sqlb.append("    AND C.ID_PROPOEP=D.ID_PROPOEP ");
						sqlb.append("    and a.id_ent = ? ");
						sqlb.append("    and a.eu_srctp = 1 and b.eu_direct=1 and a.fg_refund='N'");
						SqlParam sqlp = new SqlParam();
						sqlp.addParam(recipeDTO.getId_en());
						DAFacade dafacade = new DAFacade();
						blEntVsCodeHpLst = (List<BlEntVsCodeHp>) dafacade.execQuery(sqlb.toString(), sqlp,
								new BeanListHandler(BlEntVsCodeHp.class));
						id_entMap.put(recipeDTO.getId_en(), blEntVsCodeHpLst);
					} else {
						blEntVsCodeHpLst = id_entMap.get(recipeDTO.getId_en());
					}

					recipeDTO.setBillstype(GetBillType(PrescriptionCostDtoLst,recipeDTO.getId_pres()));
					if (blEntVsCodeHpLst != null && blEntVsCodeHpLst.size() > 0) {
						recipeDTO.setRegistertradeno(blEntVsCodeHpLst.toArray(new BlEntVsCodeHp[0])[0].getCode_hp());
					}
				}//for循环
				
				recipeDTOLstMz.addAll(recieList);
				
			}
		}
		
		if(!ListUtil.isEmpty(billDetailDtos)){
			billDetailDtos.get(0).setRecipeDTO(recipeDTOLstMz);
		}
		return billDetailDtos;
	}
	
	
	
	/**
	 * 获取上传医保的单据类型（1-挂号，2-西药或中成药，4-中草药 5-检验治疗）
	 * @param dtoLst
	 * @param Id_pres
	 * @return
	 */
	private String GetBillType(FArrayList dtoLst,String Id_pres){
		
		for(int i = 0; i<dtoLst.size();i++){
			PrescriptionCostDto costDto=(PrescriptionCostDto)dtoLst.get(i);
			if(costDto.getId_pres().equals(Id_pres)){
				if(IBdSrvDictCodeConst.DRUG_TYPE.equals(costDto.getPrntype())){
					if(costDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG))
						return "4";
					return "2";
				}
			}
		}
		return "5";
	}
	
	/**	
	 * 将未记账医嘱信息转换为可展示DTO
	 * @param srvDTO
	 * @param measMap
	 * @return
	 * @throws BizException 
	 */
	private BlOrderAppendBillParamDTO setBillDetailDtoField(PrescriptionCostDto srvDTO, Map<String, MeasDocDO> measMap) throws BizException {
		BlOrderAppendBillParamDTO ordShow = new BlOrderAppendBillParamDTO();

		// ordShow.setId_org(ordDTO.getId_org());
		ordShow.setFg_free(FBoolean.FALSE);// 默认不减免
		// ordShow.setCode_apply(srvDTO.getCode()); 2017-6-9
		// 注释，为保证IIH窗口收费的显示与手机终端显示一致
		ordShow.setCode_apply(srvDTO.getPresno());
		ordShow.setCode_applytp(srvDTO.getPrntype());
		//打印单类型名称
		ordShow.setName_applytp(BlBizUtil.getPrntTpName(srvDTO.getPrntype()));
		ordShow.setId_org(srvDTO.getId_org());
		ordShow.setId_org_mp(srvDTO.getId_org_mp());
		ordShow.setId_org_or(srvDTO.getId_org_srv());
		ordShow.setName_dep_or(srvDTO.getName_dep_srv());
		ordShow.setId_dep_mp(srvDTO.getId_dep_mp());
		ordShow.setName_dep_mp(srvDTO.getName_dep_mp());
		ordShow.setId_dep_wh(srvDTO.getId_dep_wh());
		//2017年6月22日19:46:39 不能默认预留为true ，导致第三方不能结算 提示物品预留问题
		if (srvDTO.getFg_mm().booleanValue()) {
			ordShow.setFg_reserveMaterials(FBoolean.TRUE);// 调用物品预留
		} else {
			ordShow.setFg_reserveMaterials(FBoolean.FALSE);// 不调用物品预留
		}
		ordShow.setId_dep_or(srvDTO.getId_dep_srv());
		ordShow.setId_emp_or(srvDTO.getId_emp_srv());
		ordShow.setId_ent(srvDTO.getId_en());
		ordShow.setId_enttp(srvDTO.getId_entp());
		// ordShow.setId_grp(ordDTO.getId_grp());
		ordShow.setId_grp(srvDTO.getId_grp());
		ordShow.setId_mm(srvDTO.getId_mm());
		// ordShow.setId_pat(ordDTO.getId_pat());
		ordShow.setId_pat(srvDTO.getId_pat());
		ordShow.setId_srv(srvDTO.getId_srv());
		ordShow.setId_srvca(srvDTO.getId_srvca());

		// 医保计划
		ordShow.setId_hp(srvDTO.getId_hp());
		// 服务项目医保类别
		ordShow.setId_hpsrvtp(srvDTO.getId_hpsrvtp());
		// 服务项目医保类别
		ordShow.setSd_hpsrvtp(srvDTO.getSd_hpsrvtp());
		ordShow.setId_hpkind(srvDTO.getId_hpkind());
		ordShow.setFg_hpspcl(srvDTO.getFg_specill());
		ordShow.setFg_extdispense(srvDTO.getFg_extdispense());
		ordShow.setEu_direct(1);
		ordShow.setSd_srvtp(srvDTO.getSd_srvtp());
		ordShow.setId_srvtp(srvDTO.getId_srvtp());
		ordShow.setCode_enttp(srvDTO.getCode_entp());
		// tcy:在医嘱领域：物品信息取数为ci_or_srv_mm.quan_cur;非物品为ci_or_srv.quan_total_med(原来取值是ci_or_srv.quan_medu）
		if (!srvDTO.getFg_mm().booleanValue()) {
			ordShow.setQuan(new FDouble(srvDTO.getQuan_med()));
		} else {
			ordShow.setQuan(srvDTO.getQuan_cur());
		}
		//	TODO 当前如果为物品 规格字段没有数据，规格无数据 提交到医保会提示 规格为空 需要在后期优化时 揉到获取数据时
		if(!StringUtil.isEmpty(srvDTO.getId_mm())){
			IMeterialMDORService mmservice=ServiceFinder.find(IMeterialMDORService.class);
			MeterialDO mm =	mmservice.findById(srvDTO.getId_mm());
			if(mm!=null){
				ordShow.setSpec(mm.getSpec());
			}
		}
		
		ordShow.setQuan_base(srvDTO.getQuan_base());
		ordShow.setPgku_cur(srvDTO.getId_unit_cur());
		ordShow.setPgku_base(srvDTO.getId_unit_cur());
		ordShow.setFactor(srvDTO.getFactor_cb());
		ordShow.setFg_Cgoep(FBoolean.FALSE);

		// ordShow.setId_or(ordDTO.getId_or());
		// ordShow.setName_or(ordDTO.getDes());
		ordShow.setId_or(srvDTO.getId_or());
		ordShow.setName_or(srvDTO.getDes());
		ordShow.setId_orsrv(srvDTO.getId_orsrv());
		ordShow.setName_srv(srvDTO.getName_srv());
		ordShow.setName_mm(srvDTO.getName_mm());
		// tcy:医嘱日期
		ordShow.setDt_or(srvDTO.getDt_sign());

		ordShow.setCode_enttp(srvDTO.getCode_entp());// new
		ordShow.setCode_srv(srvDTO.getCode_srv());// new
		if (srvDTO.getFg_mm().booleanValue()) {
			MeasDocDO measDoc = measMap.get(srvDTO.getId_unit_cur());// 获取在医嘱服务数据中单位的ID值
			if (measDoc != null) {
				ordShow.setSrvu(measDoc.getId_measdoc());
				ordShow.setSrvu_name(measDoc.getName());
			}
		} else {

			MeasDocDO measDocDO = measMap.get(srvDTO.getId_unit_med());
			if (measDocDO != null) {
				// ordShow.setSrvu(measDocDO.getName());//new 服务项目单位
				ordShow.setSrvu(measDocDO.getId_measdoc());// new 服务项目单位
				ordShow.setSrvu_name(measDocDO.getName());// new 服务项目单位
			}
		}
		ordShow.setId_pres(srvDTO.getId_pres());// new 处方
		ordShow.setSrcfunc_des(IBlCgCodeConst.OpFeeCollect);// 来源门诊收费
		if (srvDTO.getId_pres() == null) {
			// ???????
			// ordShow.setId_pres(srvDTO());//new 处方
		}
		// if(!StringUtil.isEmptyWithTrim(srvDTO.getPrestp_name()))
		// {
		// if(true)
		// {
		// ordShow.setPresrption_name("处方："+srvDTO.getPrestp_name());
		// }
		// }
		// else
		// {
		// ordShow.setPresrption_name("处方：诊疗");
		// }

		// 拼接处方名称信息
		if (srvDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
			ordShow.setPresrption_name(srvDTO.getPrestp_name());
		} else {
			ordShow.setPresrption_name(srvDTO.getDes());
		}
		ordShow.setFg_hpspcl(srvDTO.getFg_specill());
		ordShow.setFg_extdispense(srvDTO.getFg_extdispense());
		if (ordShow.getFg_extdispense() != null && ordShow.getFg_extdispense().booleanValue()) {
			if (ordShow.getPresrption_name() != null) {
				ordShow.setPresrption_name(ordShow.getPresrption_name().toString() + "[外配处方]");
			} else {
				ordShow.setPresrption_name("[外配处方]");
			}
		}
		if (ordShow.getFg_hpspcl() != null && ordShow.getFg_hpspcl().booleanValue()) {
			if (ordShow.getPresrption_name() != null) {
				ordShow.setPresrption_name(ordShow.getPresrption_name().toString() + "[特殊病]");
			} else {
				ordShow.setPresrption_name("[特殊病]");
			}
		}
		// ordShow.setAmt_hp(null);//new 金额_医保计划
		// ordShow.setAmt_pat(null);//new 标准金额：数量*标准价格.补费接口调用时，设置为null
		// ordShow.setAmt_std(null);//new 标准金额：数量*标准价格.补费接口调用时，设置为null
		// ordShow.setAmt(null);//new 金额：数量*标准价格*价格比例.补费接口调用时，设置为null

		ordShow.setCode_mm(srvDTO.getCode_mm());// new 物品编码
		ordShow.setId_mmtp(srvDTO.getId_mmtp());// new 物品类型
		ordShow.setSd_mmtp(srvDTO.getSd_mmtp());// new 物品类型编码
		ordShow.setFg_mm(srvDTO.getFg_mm());// new 物品标示
		ordShow.setSrcfunc_des(IBlCgCodeConst.OpFeeCollect);// 来源门诊收费
		ordShow.setId_pripat(srvDTO.getId_pripat());// new 患者价格类型
		// 就诊来源
		ordShow.setEu_srctp(0);
		// FDateTime sv = srvDTO.getCi_sv();
		ordShow.setCi_sv(srvDTO.getCi_sv());
		ordShow.setFg_pricinginsertcg(FBoolean.TRUE); // 划价是插入cg表中的数据		
		// ordShow.setRatio_hp(null);//new 医保自付比例 ？？？
		// ordShow.setRatio_pripat(null);//new 价格比例 ？？？
		return ordShow;
	}
	
	

	/**
	 * 校验，看看是不是无卡的医保病人
	 * 
	 * @param orgSrvList
	 * @return
	 * @throws BizException
	 */
	private List<BlOrderAppendBillParamDTO> supplymentOrderBillItemFields(List<BlOrderAppendBillParamDTO> orgSrvList) throws BizException {
		
		if(ListUtil.isEmpty(orgSrvList))
			return null;
		// 就诊主键集合
		List<String> strIdEntLst = new ArrayList<String>();
		Map<String, OpBasicDTO> entOpBasicDtoMp = new HashMap<String, OpBasicDTO>();
		Map<String, EntHpDO[]> entHpMp = new HashMap<String, EntHpDO[]>();
		// 医保计划查询服务
		IEnthpRService iEnthpRService = ServiceFinder.find(IEnthpRService.class);
		for (BlOrderAppendBillParamDTO dto : orgSrvList) {
			dto.setFg_insurWithoutCard(FBoolean.FALSE);// 默认不是无卡的医保患者
			dto.setFg_cardregister(FBoolean.FALSE);// 持卡挂号
			// 初始化医保计划
			EntHpDO[] entHpDOs = new EntHpDO[0];
			OpBasicDTO opBasicDto = null;
			if (!strIdEntLst.contains(dto.getId_ent())) {
				strIdEntLst.add(dto.getId_ent());
				// 查询就诊对应的医保计划
				entHpDOs = iEnthpRService.find(" id_ent='" + dto.getId_ent() + "'", "", FBoolean.FALSE);
				// 就诊和就诊的医保计划对应关系是1对1
				entHpMp.put(dto.getId_ent(), entHpDOs);
				IEnOutQryService entOutService = ServiceFinder.find(IEnOutQryService.class);
				// 获取就诊门诊属性信息
				opBasicDto = entOutService.getOpBasicInfo(dto.getId_ent());
				entOpBasicDtoMp.put(dto.getId_ent(), opBasicDto);
			} else {
				entHpDOs = entHpMp.get(dto.getId_ent());
				opBasicDto = entOpBasicDtoMp.get(dto.getId_ent());
			}
			// 如果医保计划有值，代表选用了医保计划
			if (entHpDOs.length > 0) {
				if (entHpDOs[0].getFg_hp_card().booleanValue()) {
					dto.setFg_cardregister(FBoolean.TRUE);
				}

				// 医保计划+基金支付+不持卡，是无卡医保患者
				if (entHpDOs[0].getId_hp() != null && (entHpDOs[0].getFg_fundpay() != null && entHpDOs[0].getFg_fundpay().booleanValue())
						&& (entHpDOs[0].getFg_hp_card() != null && !entHpDOs[0].getFg_hp_card().booleanValue())) {
					dto.setFg_insurWithoutCard(FBoolean.TRUE);// 是无卡的医保患者
				}
			}
			if (!dto.getId_pripat().equals(opBasicDto.getId_pripat())) {
				throw new BizException("患者价格分类信息有更改，请确认！当前患者价格分类为" + opBasicDto.getName_pripat());
			}
			dto.setId_pripat(opBasicDto.getId_pripat());
			// 患者价格分类
			dto.setId_pripat_name(opBasicDto.getName_pripat());
			// 患者分类
			dto.setId_paticate_name(opBasicDto.getName_patca());
			// 就诊科室名称
			dto.setId_dep_phy_name(opBasicDto.getName_dep_phy());
			// 就诊次数
			dto.setEnt_times(opBasicDto.getTimes_op());
		}
		return orgSrvList;
	}
	
}
