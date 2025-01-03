package iih.bl.st.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeTypeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.i.IInccaitmrelRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendOutpBillParamDTO;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.comm.BlBizUtil;
import iih.bl.comm.util.BlBaseInfoUtils;
import iih.bl.itf.cg.IBlThirdFeeService;
import iih.bl.itf.cg.dto.d.BlThridFeeCondDTO;
import iih.bl.itf.cg.dto.d.BlThridFeeRltDTO;
import iih.bl.params.BlParams;
import iih.bl.st.dto.d.BlEntVsCodeHp;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.i.IEnOutQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
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
 * 获取记账明细项目
 * 
 * @author yangyang
 * @date 2017-06-22
 */
public class GetChargingItemsBp {

	/**
	 * 获取未收费的记账信息
	 * 
	 * @param strIdPat
	 *            患者编号
	 * @param defaultDaysLoadOep
	 *            调入天数
	 * @param delCg
	 *            是否删除已记账信息
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] exec(String strIdPat, int defaultDaysLoadOep, boolean delCg) throws BizException {
		// 获取当前时间
		FDateTime fdEndTime = AppUtils.getServerDateTime();
		// 获取查询起始日期，以自然日计算
		FDateTime fdStartTime = DateTimeUtils.getDateTimeBefore(fdEndTime, defaultDaysLoadOep);
	//	FDateTime fdStartTime = Tools.getDateTimeBefore(fdEndTime, 1);

		// 获取计量单位列表
		Map<String, MeasDocDO> measMap = new HashMap<String, MeasDocDO>();// 计量单位字典
		measMap = this.setMeasDocDOMap();
		// 1、先查询患者是否有记帐信息以及待处理的其他数据
		// 分析数据来源，1、挂号产生的费用 2、医保记账和商保记账产生的费用
		List<BlCgItmOepDO> cgItmOepDoLst = this.getCgItems(strIdPat,FBoolean.FALSE,null);

		// 2、循环明细，得到对应的医嘱，以及哪些记账数据是中间态数据
		List<String> strIdCgOepDeletedLst = new ArrayList<String>();
		// TODO 优化掉以后要
		List<String> strIdOrLst = new ArrayList<String>();
		for (BlCgItmOepDO blCgItmOepDO : cgItmOepDoLst) {
			// 找到对应的医嘱信息
			if (blCgItmOepDO.getId_or() != null) {
				if (!strIdOrLst.contains(blCgItmOepDO.getId_or()) && FBoolean.FALSE.equals(blCgItmOepDO.getFg_susp())) {
					strIdOrLst.add(blCgItmOepDO.getId_or());
				}
			}
			
			if (delCg && FBoolean.TRUE.equals(blCgItmOepDO.getFg_susp()) &&
					FBoolean.TRUE.equals(blCgItmOepDO.getFg_pricinginsertcg())) {
				// 取消划价的范围，是挂起的，并排除挂号费，加个分支很复杂，下一步要同化诊间挂号的费用
				if (!strIdCgOepDeletedLst.contains(blCgItmOepDO.getId_cgoep())) {
					// 待取消划价的记账数据
					strIdCgOepDeletedLst.add(blCgItmOepDO.getId_cgoep());
				}
			}
		}
		Map<String, CiOrderDO> ordMap = new HashMap<String, CiOrderDO>();
		if (strIdOrLst != null && strIdOrLst.size() > 0) {
			CiOrderDO[] orderDOArr = getCiOrderDoLst(strIdOrLst);
			// 获得CI_ORDER表中ID_OR,Name_OR
			if (orderDOArr != null && orderDOArr.length > 0) {
				for (CiOrderDO orderDO : orderDOArr) {
					ordMap.put(orderDO.getId_or(), orderDO);
				}
			}
		}
		// TODO 3、如果有挂起状态数据，则取消划价，尽量以后干掉这部分内容
		IBLCiOrderToBlCgService iBLCiOrderToBlCgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		if (strIdCgOepDeletedLst.size() > 0)
			iBLCiOrderToBlCgService.DeleteOepPricingInfo(strIdCgOepDeletedLst.toArray(new String[0]));
		//4.获取急诊留观记账数据
		List<BlCgItmOepDO> etObsCgItmOepLst = this.getEtObsCgItems(strIdPat);
		if(!ListUtil.isEmpty(etObsCgItmOepLst)){
			cgItmOepDoLst.addAll(etObsCgItmOepLst);
		}
		//4.2获取预住院转到门诊的记账数据
		//List<BlCgItmOepDO> ippreList = this.getIppreToOepCgItems(strIdPat);
		//if(!ListUtil.isEmpty(ippreList)){
		//	cgItmOepDoLst.addAll(ippreList);
		//}
		
		// 5、记账数据源组装
		List<BlOrderAppendBillParamDTO> cgBillItmDtoLst = this.assemblyChargeDetailDtos(cgItmOepDoLst, ordMap);
		// 对于一些记账数据，需要字段补充,以后优化掉
		List<BlOrderAppendBillParamDTO> cgBillItmDtoFullLst = this.supplymentChargeBillItmsFileds(cgBillItmDtoLst);
		// 6、获取医嘱未记账费用
		ArrayList<PrescriptionConstBaseDto> parsList = new ArrayList<PrescriptionConstBaseDto>();
		ICiOrdQryService service = (ICiOrdQryService) ServiceFinder.find(ICiOrdQryService.class);
	
		PrescriptionConstBaseDto prescriptionConstBaseDto = service.getPrescriptionConstBaseDto(strIdPat, fdStartTime, fdEndTime, IBdFcDictCodeConst.SD_CODE_ENTP_OP, Context.get().getOrgId());
		if (prescriptionConstBaseDto != null)
			parsList.add(prescriptionConstBaseDto);
		// 6.1 添加急诊数据
		PrescriptionConstBaseDto prescriptionConstBaseDto_et_flow = service.getPrescriptionConstBaseDto(strIdPat, fdStartTime, fdEndTime, IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW, Context.get().getOrgId());
		if (prescriptionConstBaseDto_et_flow != null)
			parsList.add(prescriptionConstBaseDto_et_flow);
		
		PrescriptionConstBaseDto prescriptionConstBaseDto_et_fstaid = service.getPrescriptionConstBaseDto(strIdPat, fdStartTime, fdEndTime, IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID, Context.get().getOrgId());
		if (prescriptionConstBaseDto_et_fstaid != null)
			parsList.add(prescriptionConstBaseDto_et_fstaid);
		
		List<BlOrderAppendBillParamDTO> orderBillItmDtoLst = this.assemblyOrderSrvDetailDtos(parsList, measMap);
		if(FBoolean.TRUE.equals(BlParams.BLSTOEP0035())){
			//5.2添加第三方补费数据
			//查询人员信息
			IPatiMDORService patRService=ServiceFinder.find(IPatiMDORService.class);
			PatDO patInfo= patRService.findById(strIdPat);
			if(patInfo==null){
				throw new BizException("未查询到人员信息");
			}
			List<BlOrderAppendBillParamDTO> ThirdFeeList =this.getThirdFeeList(patInfo,parsList,measMap);
			if(!ListUtil.isEmpty(ThirdFeeList)){
				orderBillItmDtoLst.addAll(ThirdFeeList);
			}
		}
		// 补充一些字段
		List<BlOrderAppendBillParamDTO> orderBillItmDtoFullLst = this.supplymentOrderBillItemFields(orderBillItmDtoLst);
		// 7、组合数据
		List<BlOrderAppendBillParamDTO> totalBillItmDtoLst = new ArrayList<BlOrderAppendBillParamDTO>();
		if (!ListUtil.isEmpty(cgBillItmDtoFullLst))
			totalBillItmDtoLst.addAll(cgBillItmDtoFullLst);
		if (!ListUtil.isEmpty(orderBillItmDtoFullLst))
			totalBillItmDtoLst.addAll(orderBillItmDtoFullLst);
		//补充账单项字段
		List<BlOrderAppendBillParamDTO> totalBillItmDtoNew = new ArrayList<>(totalBillItmDtoLst.size());
		for(BlOrderAppendBillParamDTO itm:totalBillItmDtoLst){
			if(itm.getQuan() != null && !FDouble.ZERO_DBL.equals(itm.getQuan())){
				totalBillItmDtoNew.add(itm);
			}
		}
		return totalBillItmDtoNew.toArray(new BlOrderAppendBillParamDTO[totalBillItmDtoNew.size()]);
	}

	/**
	 * 获取患者急诊留观记账数据
	 * @param strIdPat
	 * @return
	 * @throws BizException
	 */
	private List<BlCgItmOepDO> getEtObsCgItems(String strIdPat) throws BizException {
		//1.获取患者急诊留观的出观就诊集合
		List<String> entIds= BlBaseInfoUtils.getPatEtObsEnts(strIdPat);
		//2.根据出观的就诊集合获取记账数据
		if(!ListUtil.isEmpty(entIds)){
			List<BlCgItmOepDO> list = this.getCgItems(strIdPat,FBoolean.TRUE,entIds);
			return list;
		}
		return null;
	}
	
	/**
	 * 获取预住院转门诊的记账数据
	 */
	private List<BlCgItmOepDO> getIppreToOepCgItems(String strIdPat) throws BizException {
		// 1.获取预住院转门诊的就诊集合
		List<String> entIds = BlBaseInfoUtils.getIppreToOepEnts(strIdPat);
		// 2.根据转门诊的就诊集合获取记账数据
		if(!ListUtil.isEmpty(entIds)){
			List<BlCgItmOepDO> list = this.getCgItems(strIdPat, FBoolean.FALSE, entIds);
			return list;
		}
		return null;
	}

	/**
	 * 组装账单项信息
	 * @param totalBillItmDtoLst
	 * @throws BizException 
	 */
	private void assinccaitm(List<BlOrderAppendBillParamDTO> totalBillItmDtoLst) throws BizException{
		if(ListUtil.isEmpty(totalBillItmDtoLst)){
			return;
		}
		
		//1.获取所有服务id
		Set<String> srvIdSet=new HashSet<String>();
		for (BlOrderAppendBillParamDTO parpamDto : totalBillItmDtoLst) {
			srvIdSet.add(parpamDto.getId_srv());
		}
		
		//2.根据服务id查询相应的服务信息
		FArrayList srvIdList=new FArrayList();
		srvIdList.addAll(srvIdSet);
		IInccaitmrelRService incCaitmSerivce =ServiceFinder.find(IInccaitmrelRService.class);
		IncCaItmRelDO[] relDoArr =incCaitmSerivce.findByAttrValList(IncCaItmRelDO.ID_SRV, srvIdList);
		
		
		Map<String, IncCaItmRelDO> srvMap=new HashMap<String, IncCaItmRelDO>();
		for (IncCaItmRelDO relDo : relDoArr) {
			srvMap.put(relDo.getId_srv(), relDo);
		}
		//3.把服务的账单信息赋回原dto
		for (BlOrderAppendBillParamDTO parpamDto : totalBillItmDtoLst) {
			IncCaItmRelDO relDo=srvMap.get(parpamDto.getId_srv());
			parpamDto.setCode_inccaitm(relDo.getSd_incca());
			parpamDto.setName_inccaitm(relDo.getInccaitm_name());
			
		}
		
	}

	/**
	 * 获取患者已记账，但未结算的数据 注：门诊收费划价记账数据是直接入库的，所以在特殊情况下拿到的数据会包括挂起的数据
	 * 
	 * @param strIdPat
	 *            患者主键
	 * @return 记账明细集合
	 * @throws BizException
	 */
	private List<BlCgItmOepDO> getCgItems(String strIdPat,FBoolean bEtObs,List<String> entIds) throws BizException {
		// FDateTime fdStartTime,FDateTime fdEndTime 日期时间暂时不加，待后续控制
		// review by yangyang 整体设计反思，不应该有所谓的中间态数据产生，不需要持久化就坚决不持久化
		// TODO 获取记账数据，这里包括挂起的费用
		
		//wq.li 2019-3-14 为查询记账时间修改，恶心，请原谅恶心还将进行下去
		StringBuilder strSql = new StringBuilder();
		strSql.append(" SELECT ");
		 strSql.append(" CGITM.ID_CGITMOEP,");
		 strSql.append(" CGITM.ID_GRP,");
		 strSql.append(" CGITM.ID_ORG,");
		 strSql.append(" CGITM.ID_PAT,");
		 strSql.append(" CGITM.ID_CGOEP,");
		 strSql.append(" CGITM.ID_ENT,");
		 strSql.append(" CGITM.ID_ENTTP,");
		 strSql.append(" CGITM.CODE_ENTTP,");
		 strSql.append(" CGITM.ID_PRES,");
		 strSql.append(" CGITM.ID_OR,");
		 strSql.append(" CGITM.ID_ORSRV,");
		 strSql.append(" CGITM.ID_SRVTP,");
		 strSql.append(" CGITM.SD_SRVTP,");
		 strSql.append(" CGITM.ID_SRVCA,");
		 strSql.append(" CGITM.ID_SRV,");
		 strSql.append(" CGITM.CODE_SRV,");
		 strSql.append(" CGITM.NAME_SRV,");
		 strSql.append(" CGITM.SRVU,");
		 strSql.append(" CGITM.PRICE,");
		 strSql.append(" CGITM.QUAN,");
		 strSql.append(" CGITM.AMT,");
		 strSql.append(" CGITM.RATIO_PRIPAT,");
		 strSql.append(" CGITM.AMT_STD,");
		 strSql.append(" CGITM.ID_PRIPAT,");
		 strSql.append(" CGITM.AMT_PAT,");
		 strSql.append(" CGITM.ID_HPSRVTP,");
		 strSql.append(" CGITM.SD_HPSRVTP,");
		 strSql.append(" CGITM.ID_HP,");
		 strSql.append(" CGITM.RATIO_HP,");
		 strSql.append(" CGITM.AMT_HP,");
		 strSql.append(" CGITM.FG_ACC,");
		 strSql.append(" CGITM.AMT_ACC,");
		 strSql.append(" CGITM.AMT_RATIO,");
		 strSql.append(" CGITM.DT_OR,");
		 strSql.append(" CGITM.ID_ORG_OR,");
		 strSql.append(" CGITM.ID_DEP_OR,");
		 strSql.append(" CGITM.ID_EMP_OR,");
		 strSql.append(" CGITM.ID_ORG_MP,");
		 strSql.append(" CGITM.ID_DEP_MP,");
		 strSql.append(" CGITM.ID_DEP_WH,");
		 strSql.append(" CGITM.FG_MM,");
		 strSql.append(" CGITM.ID_MM,");
		 strSql.append(" CGITM.ID_MMTP,");
		 strSql.append(" CGITM.SD_MMTP,");
		 strSql.append(" CGITM.CODE_MM,");
		 strSql.append(" CGITM.ONLYCODE,");
		 strSql.append(" CGITM.NAME_MM,");
		 strSql.append(" CGITM.SPEC,");
		 strSql.append(" CGITM.CD_BATCH,");
		 strSql.append(" CGITM.PGKU_BASE,");
		 strSql.append(" CGITM.PGKU_CUR,");
		 strSql.append(" CGITM.FACTOR,");
		 strSql.append(" CGITM.QUAN_BASE,");
		 strSql.append(" CGITM.PRI_SS,");
		 strSql.append(" CGITM.FG_ST,");
		 strSql.append(" CGITM.ID_STOEP,");
		 strSql.append(" CGITM.DT_ST,");
		 strSql.append(" CGITM.FG_HP,");
		 strSql.append(" CGITM.FG_SUSP,");
		 strSql.append(" CGITM.ID_PAR,");
		 strSql.append(" CGITM.EU_SRCTP,");
		 strSql.append(" CGITM.NOTE,");
		 strSql.append(" CGITM.FG_REFUND,");
		 strSql.append(" CGITM.FG_ADDITM,");
		 strSql.append(" CGITM.APPRNO,");
		 strSql.append(" CGITM.ID_RECG_OEP,");
		 strSql.append(" CGITM.FG_RECG,");
		 strSql.append(" CGITM.DT_SRV,");
		 strSql.append(" CGITM.SRCFUNC_DES,");
		 strSql.append(" CGITM.DS,");
		 strSql.append(" CGITM.SV,");
		 strSql.append(" CGITM.CODE_INCCAITM,");
		 strSql.append(" CGITM.NAME_INCCAITM,");
		 strSql.append(" CGITM.FG_FREE,");
		 strSql.append(" CGITM.CODE_APPLY,");
		 strSql.append(" CGITM.PRICE_RATIO,");
		 strSql.append(" CGITM.SD_ABRD,");
		 strSql.append(" CGITM.FG_HPCG,");
		 strSql.append(" CGITM.FG_PRICINGINSERTCG,");
		 strSql.append(" CGITM.CODE_APPLYTP,");
		 strSql.append(" CGITM.ID_HPSRVMPAYRATIO,");
		 strSql.append(" CGITM.FG_ZEROREG,");
		 strSql.append(" CGITM.ID_MIS,");
		 strSql.append(" CGITM.NAME_ACCOUNT,");
		 strSql.append(" CGITM.CODE_ACCOUNT,");
		 strSql.append(" CGITM.ID_DEP_PHY,");
		 strSql.append(" CGITM.ID_EMP_PHY,");
		 strSql.append(" CGOEP.DT_CG,");
		 strSql.append(" CGOEP.EU_DIRECT,");
		 strSql.append(" CGITM.PECODE,");
		 strSql.append(" 'N' AS FG_EXTDISPENDSE,");
		 strSql.append(" 'N' AS FG_SPECILL,");
		strSql.append(" DEPOR.NAME AS DEPOR_NAME,DEPMP.NAME AS DEPMP_NAME,DOC.NAME Empor_name,ASDOC.NAME AS srvu_name");
		strSql.append(" FROM BL_CG_ITM_OEP CGITM");
		strSql.append(" INNER JOIN BL_CG_OEP CGOEP ON CGITM.ID_CGOEP=CGOEP.ID_CGOEP");
		strSql.append(" LEFT JOIN BL_ST_OEP STOEP ON CGITM.ID_STOEP=STOEP.ID_STOEP"); // 关联结算表，此时可能未结算，也可能处于挂起状态
		strSql.append(" LEFT JOIN BD_DEP DEPOR ON CGITM.ID_DEP_OR=DEPOR.ID_DEP");
		strSql.append(" LEFT JOIN BD_DEP DEPMP ON CGITM.ID_DEP_MP=DEPMP.ID_DEP");
		strSql.append(" LEFT JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC=CGITM.ID_EMP_OR");
		strSql.append(" LEFT JOIN BD_MEASDOC ASDOC on ASDOC.ID_MEASDOC=CGITM.SRVU");
		// strSql.append(" LEFT JOIN CI_OR_SRV ORSRV ON CGITM.ID_ORSRV=ORSRV.ID_ORSRV");
		// //DO里没有冗余该字段，而且这里的查询最好是直接组装dto
		// strSql.append(" INNER JOIN CI_ORDER ORDER ON ORSRV.ID_OR=ORDER.ID_OR");
		strSql.append(" WHERE CGITM.ID_PAT=? AND CGOEP.EU_DIRECT=1 AND CGITM.FG_REFUND='N'");
		strSql.append(" AND nvl(STOEP.ID_PAYPATOEP,'~')='~' AND CGITM.ID_ORG=?");
		//注释调价格大于0的限制，否则调入删除挂起数据时，会把价格为0的剩下 2020-05-07 by liming06
		if(FBoolean.FALSE.equals(BlParams.BLSTOEP0067())){
			strSql.append(" AND CGITM.price_ratio > 0 ");
		}
		
		// 2017年8月8日 添加对没有就诊关联的记账数据不导入到收费中 yang.lu
		//strSql.append(" AND nvl(CGITM.ID_ENT,'~')<>'~'");
		//是否包含急诊急诊留观数据
		if(FBoolean.TRUE.equals(bEtObs)){
			strSql.append(" and CGITM.code_enttp=?");
		}else{
			strSql.append(" and CGITM.code_enttp<>?");
		}
		if(!ListUtil.isEmpty(entIds)){
			strSql.append(SqlUtils.getInSqlByIds(" and CGITM.id_ent ", entIds));
		}
		
		// 添加参数
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(strIdPat);
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);

		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> list = (List<BlCgItmOepDO>) new DAFacade().execQuery(strSql.toString(), sqlParam, new BeanListHandler(BlCgItmOepDO.class));
		return list;
	}

	/**
	 * 通过记账数据组装明细dto数据
	 * 
	 * @param cgItmDos
	 *            记账明细
	 * @param ordMap
	 *            医嘱map
	 * @return 数据源
	 * @throws BizException
	 */
	private List<BlOrderAppendBillParamDTO> assemblyChargeDetailDtos(List<BlCgItmOepDO> cgItmDos, Map<String, CiOrderDO> ordMap) throws BizException {
		if (ListUtil.isEmpty(cgItmDos))
			return null;

		List<BlOrderAppendBillParamDTO> billDetaillst = new ArrayList<BlOrderAppendBillParamDTO>();
		// DTO赋值
		for (BlCgItmOepDO blCgItmOepDO : cgItmDos) {
			// 排除已经挂起的费用
			if (FBoolean.TRUE.equals(blCgItmOepDO.getFg_susp()) && 
					FBoolean.TRUE.equals(blCgItmOepDO.getFg_pricinginsertcg())) {
				continue;
			}
			String strIdOr = blCgItmOepDO.getId_or();
			CiOrderDO orderDo = null;
			if (!StringUtil.isEmptyWithTrim(strIdOr)) {
				orderDo = ordMap.get(blCgItmOepDO.getId_or());
			}

			BlOrderAppendBillParamDTO ordShow = new BlOrderAppendBillParamDTO();
			ordShow.setEu_direct(blCgItmOepDO.getEu_direct());
			ordShow.setFg_free(blCgItmOepDO.getFg_free()); // 减免标志
			ordShow.setCode_apply(blCgItmOepDO.getCode_apply());// 医疗单号
			ordShow.setCode_applytp(blCgItmOepDO.getCode_applytp());// 医疗类型
			if (blCgItmOepDO.getFg_hpcg() != null && blCgItmOepDO.getFg_hpcg().booleanValue())// 如果是商保记账
			{
				if (blCgItmOepDO.getEu_srctp() == 1) {
					ordShow.setName_applytp("挂号[欠款记账]");
				} else {
					ordShow.setName_applytp(BlBizUtil.getPrntTpName(getValue(ordShow.getCode_applytp())) + "[欠款记账]");
				}

			} else if (blCgItmOepDO.getFg_acc() != null && blCgItmOepDO.getFg_acc().booleanValue()) {
				if (blCgItmOepDO.getEu_srctp() == 1) {
					ordShow.setName_applytp("挂号[记账]");
				} else {
					ordShow.setName_applytp(BlBizUtil.getPrntTpName(getValue(ordShow.getCode_applytp())) + "[记账]");
				}
			} else if (blCgItmOepDO.getEu_srctp() == 1)// 如果是挂号费
			{
				ordShow.setName_applytp("挂号");
			} else {
				ordShow.setName_applytp(BlBizUtil.getPrntTpName(getValue(ordShow.getCode_applytp())));
			}
			// 账单项编码
			ordShow.setCode_inccaitm(blCgItmOepDO.getCode_inccaitm());
			// 账单项名称
			ordShow.setName_inccaitm(blCgItmOepDO.getName_inccaitm());
			// 组织
			ordShow.setId_org(blCgItmOepDO.getId_org());
			// 执行组织
			ordShow.setId_org_mp(blCgItmOepDO.getId_org_mp());
			// 申请组织
			ordShow.setId_org_or(blCgItmOepDO.getId_org_or());
			// 执行科室
			if (blCgItmOepDO.getEu_srctp() == 1) {
				// 挂号费的执行科室为空，
				ordShow.setId_dep_mp("");
				ordShow.setName_dep_mp("");
			} else {
				// 非挂号费的执行部门
				ordShow.setId_dep_mp(blCgItmOepDO.getId_dep_mp());
				ordShow.setName_dep_mp(blCgItmOepDO.getDepmp_name());
			}
			// 取药仓库
			ordShow.setId_dep_wh(blCgItmOepDO.getId_dep_wh());
			// TODO review by yangyang 这里有异议，对于该字段的调用需谨慎，是否调用物品预留
			ordShow.setFg_reserveMaterials(FBoolean.TRUE);// 调用物品预留
			// 开单科室名称
			ordShow.setName_dep_or(blCgItmOepDO.getDepor_name());
			// 开单医生名称
			ordShow.setId_emp_or(blCgItmOepDO.getId_emp_or());
			ordShow.setName_emp_or(blCgItmOepDO.getEmpor_name());
			ordShow.setId_ent(blCgItmOepDO.getId_ent());
			ordShow.setId_enttp(blCgItmOepDO.getId_enttp());
			ordShow.setId_dep_or(blCgItmOepDO.getId_dep_or());

			// 设置医保计划
			ordShow.setId_hp(blCgItmOepDO.getId_hp());
			// 设置服务项目医保类别主键ID
			ordShow.setId_hpsrvtp(blCgItmOepDO.getId_hpsrvtp());
			// 设置服务项目医保类别编码
			ordShow.setSd_hpsrvtp(blCgItmOepDO.getSd_hpsrvtp());
			ordShow.setId_grp(blCgItmOepDO.getId_grp());

			// 物品属性
			ordShow.setFg_mm(blCgItmOepDO.getFg_mm());
			ordShow.setId_mm(blCgItmOepDO.getId_mm());
			ordShow.setId_pat(blCgItmOepDO.getId_pat());
			ordShow.setId_srv(blCgItmOepDO.getId_srv());
			ordShow.setId_srvca(blCgItmOepDO.getId_srvca());
			ordShow.setId_srvtp(blCgItmOepDO.getId_srvtp());
			ordShow.setSd_srvtp(blCgItmOepDO.getSd_srvtp());
			ordShow.setQuan_base(blCgItmOepDO.getQuan_base());
			ordShow.setPgku_cur(blCgItmOepDO.getPgku_cur());
			ordShow.setPgku_base(blCgItmOepDO.getPgku_base());
			ordShow.setFactor(blCgItmOepDO.getFactor());
			ordShow.setName_mm(blCgItmOepDO.getName_mm());
			ordShow.setId_mmtp(blCgItmOepDO.getId_mmtp());// new
			ordShow.setSd_mmtp(blCgItmOepDO.getSd_mmtp());// new
			ordShow.setSrvu_name(blCgItmOepDO.getSrvu_name());
			ordShow.setDt_cg(blCgItmOepDO.getDt_cg());
			ordShow.setFg_Cgoep(FBoolean.TRUE);
			ordShow.setFg_susp(blCgItmOepDO.getFg_susp());
			ordShow.setId_pres(blCgItmOepDO.getId_pres());
			if (blCgItmOepDO.getEu_srctp() == FeeOriginEnum.ENCOUNTER_FEE)
				ordShow.setId_pres(blCgItmOepDO.getId_ent());
			//by lim 如果是建档费，先赋值
			if(blCgItmOepDO.getEu_srctp() == FeeOriginEnum.PATREGISTER_FEE){
				ordShow.setId_pres(blCgItmOepDO.getId_srv());
				ordShow.setId_dep_or(blCgItmOepDO.getId_dep_mp());
				ordShow.setName_dep_or(blCgItmOepDO.getDepmp_name());			
			}
			ordShow.setSrcfunc_des(blCgItmOepDO.getSrcfunc_des());
			ordShow.setId_stoep(blCgItmOepDO.getId_stoep());
			ordShow.setId_or(blCgItmOepDO.getId_or());
			// 是否特殊病
			ordShow.setFg_hpspcl(blCgItmOepDO.getFg_specill());
			if (orderDo != null) {
				// 医嘱名称
				ordShow.setName_or(orderDo.getName_or());
				// 医嘱ID
				ordShow.setId_or(orderDo.getId_or());
			}
			ordShow.setFg_extdispense(blCgItmOepDO.getFg_extdispense());
			// 医嘱明细项目主键
			ordShow.setId_orsrv(blCgItmOepDO.getId_orsrv());
			// 医嘱服务名称
			ordShow.setName_srv(blCgItmOepDO.getName_srv());
			// 医嘱开立时间
			ordShow.setDt_or(blCgItmOepDO.getDt_or());
			// 价格
			ordShow.setPrice(blCgItmOepDO.getPrice());
			// 比例价格
			ordShow.setPrice_ratio(blCgItmOepDO.getPrice_ratio());
			// 数量
			ordShow.setQuan(blCgItmOepDO.getQuan());
			// 金额
			ordShow.setAmt(blCgItmOepDO.getAmt());
			// 就诊类型
			ordShow.setCode_enttp(blCgItmOepDO.getCode_enttp());// new
			// 医嘱服务编码
			ordShow.setCode_srv(blCgItmOepDO.getCode_srv());// new
			// 物品编码
			ordShow.setCode_mm(blCgItmOepDO.getCode_mm());// new:物品编码
			// 单位
			ordShow.setSrvu(blCgItmOepDO.getSrvu());// new
			// TODO yangyang
			// MeasDocDO measDocDO = measMap.get(blCgItmOepDO.getSrvu());
			// if (measDocDO != null) {
			// ordShow.setSrvu_name(measDocDO.getName());// new 服务项目单位
			// }
			ordShow.setRatio_hp(blCgItmOepDO.getRatio_hp());// new
			ordShow.setRatio_pripat(blCgItmOepDO.getRatio_pripat());// new
			ordShow.setId_pripat(blCgItmOepDO.getId_pripat());
			if (blCgItmOepDO.getAmt_hp() == null) {
				ordShow.setAmt_hp(new FDouble(0));// new
			} else {
				ordShow.setAmt_hp(blCgItmOepDO.getAmt_hp());// new
			}
			ordShow.setAmt_pat(blCgItmOepDO.getAmt_pat());// new
			ordShow.setAmt_std(blCgItmOepDO.getAmt_std());// new
			// 根据标准价格和患者价格分类系数计算出的金额
			ordShow.setAmt_ratio(blCgItmOepDO.getAmt_ratio());
			ordShow.setNote(blCgItmOepDO.getNote());// new
			// 设置费用来源
			ordShow.setEu_srctp(blCgItmOepDO.getEu_srctp());
			ordShow.setFg_pricinginsertcg(blCgItmOepDO.getFg_pricinginsertcg());
			
			BlOrderAppendOutpBillParamDTO outpParamDTO = new BlOrderAppendOutpBillParamDTO();
			outpParamDTO.setId_cgoep(blCgItmOepDO.getId_cgoep());
			outpParamDTO.setId_cgitmoep(blCgItmOepDO.getId_cgitmoep());
			outpParamDTO.setAmt_acc(blCgItmOepDO.getAmt_acc());
			outpParamDTO.setFg_acc(blCgItmOepDO.getFg_acc());
			outpParamDTO.setFg_hpcg(blCgItmOepDO.getFg_hpcg());

			ordShow.setOutpBillDTO(outpParamDTO);
			billDetaillst.add(ordShow);
		}
		return billDetaillst;
	}

	/**
	 * 组装未记账的费用明细
	 * 
	 * @param prescriptionConstBaseDto
	 *            从医嘱获取到的未记账数据
	 * @return
	 * @throws BizException
	 */
	private List<BlOrderAppendBillParamDTO> assemblyOrderSrvDetailDtos(ArrayList<PrescriptionConstBaseDto> dtoList, Map<String, MeasDocDO> measMap) throws BizException {
		if (dtoList == null || dtoList.size() == 0)
			return null;
		List<BlOrderAppendBillParamDTO> billDetailDtos = new ArrayList<BlOrderAppendBillParamDTO>();
		FArrayList recipeDTOLstMz = new FArrayList();
		IBlOutQryService oqService = ServiceFinder.find(IBlOutQryService.class);

		for (PrescriptionConstBaseDto prescriptionConstBaseDto : dtoList) {
			// 过滤未结账的医嘱信息
			FArrayList PrescriptionCostDtoLst = oqService.getImputEffeData(prescriptionConstBaseDto.getPrescriptionCostDto());
			
			//查询就诊医保计划
			List<String> entIdList = new ArrayList<String>();
			for (int i = 0; i < PrescriptionCostDtoLst.size(); i++) {
				PrescriptionCostDto presDto = (PrescriptionCostDto) PrescriptionCostDtoLst.get(i);
				if(!StringUtil.isEmpty(presDto.getId_en()) && !entIdList.contains(presDto.getId_en())){
					entIdList.add(presDto.getId_en());
				}
			}
			
			Map<String,String> entHpMap = new HashMap<String,String>();
			if(entIdList.size() > 0){
				IEnthpRService entHpService = ServiceFinder.find(IEnthpRService.class);
				EntHpDO[] hpDos = entHpService.find(SqlUtils.getInSqlByIds("a0.id_ent", entIdList)  + " and fg_maj = 'Y' ", null, FBoolean.FALSE);
				
				if(!ArrayUtil.isEmpty(hpDos)){
					for (EntHpDO entHpDO : hpDos) {
						entHpMap.put(entHpDO.getId_ent(), entHpDO.getId_hp());
					}
				}
			}
			
			if (PrescriptionCostDtoLst != null && PrescriptionCostDtoLst.size() > 0) {
				for (int i = 0; i < PrescriptionCostDtoLst.size(); i++) {

					BlOrderAppendBillParamDTO blOrderAppendBillParamDTO = new BlOrderAppendBillParamDTO();

					PrescriptionCostDto presdto = (PrescriptionCostDto) PrescriptionCostDtoLst.get(i);
					// 判断如果是外配处方 过滤
					if (FBoolean.TRUE.equals(presdto.getFg_extdispense())) {
						continue;
					}
					
					String hpId = null;
					if(!StringUtil.isEmpty(presdto.getId_en())){
						hpId = entHpMap.get(presdto.getId_en());
					}
					
					blOrderAppendBillParamDTO = setBillDetailDtoField(presdto, measMap, hpId);

					billDetailDtos.add(blOrderAppendBillParamDTO);
				}
				FArrayList recieList = prescriptionConstBaseDto.getRecipeDTO();

				// 挂号交易流水号
				Map<String, String> id_entMap = new HashMap<String, String>();// 从效率考虑
				List<BlEntVsCodeHp> blEntVsCodeHpLst = null;
				RecipeDTO[] recipeDTOArr = (RecipeDTO[]) recieList.toArray(new RecipeDTO[0]);
				if (recipeDTOArr != null && recipeDTOArr.length > 0) {
					String idents = "";
					SqlParam sqlp = new SqlParam();
					for (RecipeDTO recipeDTO : recipeDTOArr) {
						idents = idents + ("".equals(idents) ? "" : ",") + "?";
						sqlp.addParam(recipeDTO.getId_en());
						recipeDTO.setBillstype(GetBillType(PrescriptionCostDtoLst, recipeDTO.getId_pres()));
					}// for循环
					StringBuffer sqlb = new StringBuffer();
					sqlb.append("select distinct a.id_ent, d.code_hp ");
					sqlb.append("   from bl_cg_itm_oep a, bl_st_oep b, bl_prop_oep c, BL_PROP_AR_OEP d ");
					sqlb.append("  where a.id_stoep = b.id_stoep ");
					sqlb.append("    and b.id_stoep = c.id_stoep ");
					sqlb.append("    AND C.ID_PROPOEP=D.ID_PROPOEP ");
					sqlb.append("    and a.eu_srctp = 1 and b.eu_direct=1 and a.fg_refund='N'");
					sqlb.append("    and a.id_ent in (" + idents + ") ");
					DAFacade dafacade = new DAFacade();
					blEntVsCodeHpLst = (List<BlEntVsCodeHp>) dafacade.execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlEntVsCodeHp.class));
					for (BlEntVsCodeHp codeHp : blEntVsCodeHpLst) {
						id_entMap.put(codeHp.getId_ent(), codeHp.getCode_hp());
					}
					for (RecipeDTO recipeDTO : recipeDTOArr) {
						recipeDTO.setRegistertradeno(id_entMap.get(recipeDTO.getId_en()));
					}
				}
				recipeDTOLstMz.addAll(recieList);

			}
		}

		if (!ListUtil.isEmpty(billDetailDtos)) {
			billDetailDtos.get(0).setRecipeDTO(recipeDTOLstMz);
		}
		return billDetailDtos;
	}

	/**
	 * 获取上传医保的单据类型（1-挂号，2-西药或中成药，4-中草药 5-检验治疗）
	 * 
	 * @param dtoLst
	 * @param Id_pres
	 * @return
	 */
	private String GetBillType(FArrayList dtoLst, String Id_pres) {

		for (int i = 0; i < dtoLst.size(); i++) {
			PrescriptionCostDto costDto = (PrescriptionCostDto) dtoLst.get(i);
			if (!StringUtil.isEmpty(costDto.getId_pres())&&costDto.getId_pres().equals(Id_pres)) {
				if (IBdSrvDictCodeConst.DRUG_TYPE.equals(costDto.getPrntype())) {
					if (costDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG))
						return "4";
					return "2";
				}
			}
		}
		return "5";
	}

	/**
	 * 针对记账费用，需要获取医嘱信息，寻找对应的相关字段
	 * 
	 * @param strIdOrLst
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] getCiOrderDoLst(List<String> strIdOrLst) throws BizException {
		// 轻量级查询
		String[] fields = { "id_or,name_or" };
		String conStr = " id_or in(";
		for (String id_or : strIdOrLst) {
			conStr = conStr + "'" + id_or + "',";
		}
		conStr = conStr.substring(0, conStr.length() - 1) + ") ";

		DAFacade dafacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiOrderDO> ciOrderDoLst = (List<CiOrderDO>) dafacade.findByCond(CiOrderDO.class, conStr, fields);
		if (ciOrderDoLst == null || ciOrderDoLst.size() == 0) {
			throw new BizException("没有找到医嘱");
		}
		return ciOrderDoLst.toArray(new CiOrderDO[] {});
	}

	/**
	 * 补充一些缺少的字段，后期迭代掉
	 * 
	 * @param orgSrvList
	 * @return
	 * @throws BizException
	 */
	private List<BlOrderAppendBillParamDTO> supplymentChargeBillItmsFileds(List<BlOrderAppendBillParamDTO> orgSrvList) throws BizException {
		if (ListUtil.isEmpty(orgSrvList))
			return null;
		// by lim 如果id_ent为空，直接返回
		/*if(StringUtils.isEmpty(orgSrvList.get(0).getId_ent())){
			return orgSrvList;
		}*/
		// TODO 暂时商保记账和预交金不支持社保，所以就不传处方了。。。
		// FArrayList recipeDTOLst = getReceipeDto(orgSrvList);
		if (orgSrvList.size() > 0) {
			// 根据id_ent查询id_pripat
			List<String> strIdEntLst = new ArrayList<String>();
			Map<String, OpBasicDTO> entOpMap = new HashMap<String, OpBasicDTO>();
			Map<String, List<EntHpDO>> entHpDoMap = new HashMap<String, List<EntHpDO>>();
			Map<String,PatDO> patMap = new HashMap<String,PatDO>();
			DAFacade dafacade = new DAFacade();

			for (BlOrderAppendBillParamDTO dto : orgSrvList) {
				
				if(StringUtil.isEmpty(dto.getId_ent())){
					
					//查询患者信息 by ly
					PatDO patDO = null;
					if(patMap.containsKey(dto.getId_pat())){
						patDO = patMap.get(dto.getId_pat());
					}else{
						patDO = ServiceFinder.find(IPatiMDORService.class).findById(dto.getId_pat());
						patMap.put(dto.getId_pat(),patDO);
					}
					
					dto.setId_pripat(patDO.getId_patpritp());
					dto.setId_pripat_name(patDO.getPatpritp_name());
					dto.setId_paticate_name(patDO.getPaticate_name());
					
					continue;
				}
				
				// review by yangyang 2017-06-08 尽量避免在循环里了调用查询，字段补充调用查询越少越好
				List<EntHpDO> entHpDOL = new ArrayList<EntHpDO>();
				OpBasicDTO opBasicDto = null;
				IpBasicDTO ipBasicDto = null;
				if (!strIdEntLst.contains(dto.getId_ent())) {
					strIdEntLst.add(dto.getId_ent());
					// 查询医保计划
					entHpDOL = (List<EntHpDO>) dafacade.findByCond(EntHpDO.class, " id_ent='" + dto.getId_ent() + "' and fg_maj='Y'");
					entHpDoMap.put(dto.getId_ent(), entHpDOL);

					long start = System.currentTimeMillis();
					// 获取就诊门诊属性信息
					IEnOutQryService entOutService = ServiceFinder.find(IEnOutQryService.class);
					opBasicDto = entOutService.getOpBasicInfo(dto.getId_ent());
					//如果是急诊留观，需要查询住院信息 
					if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(dto.getCode_enttp())
							|| IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(dto.getCode_enttp())){
						ipBasicDto=entOutService.getIpBasicInfo(dto.getId_ent());
						opBasicDto= this.convertEntIpToOep(ipBasicDto);
					}

					long end = System.currentTimeMillis();
					long mill = end - start;
					// 把就诊信息的门诊属性放入map里
					entOpMap.put(dto.getId_ent(), opBasicDto);

				} else {
					opBasicDto = entOpMap.get(dto.getId_ent());
					entHpDOL = entHpDoMap.get(dto.getId_ent());
				}
				if (opBasicDto == null)
					throw new BizException("未查询到患者就诊对应的门诊属性");
				if (!dto.getId_pripat().equals(opBasicDto.getId_pripat())) {
					throw new BizException("患者价格分类信息有更改，请确认！当前患者价格分类为" + opBasicDto.getName_pripat());
				}
				dto.setId_pripat(opBasicDto.getId_pripat());
				// 患者价格分类
				dto.setId_pripat_name(opBasicDto.getName_pripat());
				// 患者分类
				dto.setId_paticate_name(opBasicDto.getName_patca());
				//患者分类id
				dto.setId_patica(opBasicDto.getId_patca());
				// 就诊科室名称
				dto.setId_dep_phy_name(opBasicDto.getName_dep_phy());
				// 就诊次数
				dto.setEnt_times(opBasicDto.getTimes_op());
				// 外配处方，肯定是药品，切必须从医嘱过来，这里不用重新查询一遍，后期迭代掉
				// TODO 假设记账数据不会产生外配处方
				// if (dto.getSd_srvtp().startsWith("01") && dto.getId_hp() !=
				// null) // 药品
				// {
				// @SuppressWarnings("unchecked")
				// List<OrdSrvDO> ordSrvDOL = (List<OrdSrvDO>)
				// dafacade.findByCond(OrdSrvDO.class, " id_orsrv='" +
				// dto.getId_orsrv() + "' ");
				// if (ordSrvDOL != null && ordSrvDOL.size() > 0) {
				// dto.setFg_extdispense(ordSrvDOL.toArray(new
				// OrdSrvDO[0])[0].getFg_extdispense()); // 是否外配处方
				// }
				// }
			}
			// TODO yangyang
			// if (recipeDTOLst != null && recipeDTOLst.size() > 0) {
			// orgSrvList.toArray(new
			// BlOrderAppendBillParamDTO[0])[0].setRecipeDTO(recipeDTOLst);
			//
			// } else {
			// orgSrvList.toArray(new
			// BlOrderAppendBillParamDTO[0])[0].setRecipeDTO(null);
			// }
		}
		return orgSrvList;
	}

	/**
	 * 获取处方信息
	 * 
	 * @param blOrderAppendBillParamDTOLst
	 * @return
	 * @throws BizException
	 */
	private FArrayList getReceipeDto(List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOLst) throws BizException {
		FArrayList recipeDtoLst = new FArrayList();
		List<String> strDrugIdPresLst = new ArrayList<String>();
		List<String> strUnDrugIdPresLst = new ArrayList<String>();
		if (blOrderAppendBillParamDTOLst != null && blOrderAppendBillParamDTOLst.size() > 0) {
			// 若有挂号费，优先处理挂号费
			for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO1 : blOrderAppendBillParamDTOLst) {
				if (blOrderAppendBillParamDTO1.getEu_srctp() != null && !blOrderAppendBillParamDTO1.getEu_srctp().equals(FeeOriginEnum.ENCOUNTER_FEE)) // 排除挂号费
				{
					if (blOrderAppendBillParamDTO1.getSd_srvtp().indexOf("01") == 0) // 药品处方
					{
						if (!strDrugIdPresLst.contains(blOrderAppendBillParamDTO1.getId_pres())) {
							strDrugIdPresLst.add(blOrderAppendBillParamDTO1.getId_pres());
						}
					} else// 检查检验
					{
						if (!strUnDrugIdPresLst.contains(blOrderAppendBillParamDTO1.getId_pres())) {
							strUnDrugIdPresLst.add(blOrderAppendBillParamDTO1.getId_pres());
						}
					}
				}
			}
			if (strDrugIdPresLst != null && strDrugIdPresLst.size() > 0) {
				RecipeDTO[] drugRecipeDtoArr = this.getDrugRecipeDto(strDrugIdPresLst.toArray(new String[0]));
				for (RecipeDTO recipeDTO : drugRecipeDtoArr) {
					recipeDtoLst.add(recipeDTO);
				}
			}
			if (strUnDrugIdPresLst != null && strUnDrugIdPresLst.size() > 0) {
				RecipeDTO[] unDrugRecipeDtoArr = this.getUnDrugRecipeDto(strUnDrugIdPresLst.toArray(new String[0]));
				for (RecipeDTO recipeDTO : unDrugRecipeDtoArr) {
					recipeDtoLst.add(recipeDTO);
				}
			}
		}
		return recipeDtoLst;
	}

	/**
	 * 根据处方号数组，获得该数组下的处方信息（药品）
	 * 
	 * @param id_presArr处方号数组
	 * @return 处方信息
	 * @throws BizException
	 */
	private RecipeDTO[] getDrugRecipeDto(String[] strIdPressArr) throws BizException {
		ICiOrdQryService iCiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		return iCiOrdQryService.getRecipeDTOByIdPres(strIdPressArr);
	}

	/**
	 * 根据bl_cg_itm_oep中检查检验对应的处方号数组，获得该数组下的处方信息（检查检验） 药品处方
	 * 
	 * @param id_presArr处方号数组
	 * @return 处方信息
	 * @throws BizException
	 */
	private RecipeDTO[] getUnDrugRecipeDto(String[] strIdOrArr) throws BizException {
		ICiOrdQryService iCiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		return iCiOrdQryService.getRecipeDTOByCodeOr(strIdOrArr);
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
	 * 将未记账医嘱信息转换为可展示DTO
	 * 
	 * @param srvDTO
	 * @param measMap
	 * @return
	 * @throws BizException
	 */
	private BlOrderAppendBillParamDTO setBillDetailDtoField(PrescriptionCostDto srvDTO, Map<String, MeasDocDO> measMap,String hpId) throws BizException {
		BlOrderAppendBillParamDTO ordShow = new BlOrderAppendBillParamDTO();

		// ordShow.setId_org(ordDTO.getId_org());
		ordShow.setFg_free(FBoolean.FALSE);// 默认不减免
		// ordShow.setCode_apply(srvDTO.getCode()); 2017-6-9
		// 注释，为保证IIH窗口收费的显示与手机终端显示一致
		ordShow.setCode_apply(srvDTO.getPresno());
		ordShow.setCode_applytp(srvDTO.getPrntype());
		// 打印单类型名称
		ordShow.setName_applytp(BlBizUtil.getPrntTpName(srvDTO.getPrntype()));
		ordShow.setId_org(srvDTO.getId_org());
		ordShow.setId_org_mp(srvDTO.getId_org_mp());
		ordShow.setId_org_or(srvDTO.getId_org_srv());
		ordShow.setName_dep_or(srvDTO.getName_dep_srv());
		ordShow.setId_dep_mp(srvDTO.getId_dep_mp());
		ordShow.setName_dep_mp(srvDTO.getName_dep_mp());
		ordShow.setId_dep_wh(srvDTO.getId_dep_wh());
		ordShow.setEu_blmd(srvDTO.getEu_blmd());
		ordShow.setPri(srvDTO.getPri());
		ordShow.setPri_std(srvDTO.getPri_std());
		ordShow.setPri_ratio(srvDTO.getPri_ratio());
		ordShow.setIndicitemid(srvDTO.getIndicitemid());
		// 2017年6月22日19:46:39 不能默认预留为true ，导致第三方不能结算 提示物品预留问题
		if (srvDTO.getFg_mm().booleanValue()) {
			ordShow.setFg_reserveMaterials(FBoolean.TRUE);// 调用物品预留
		} else {
			ordShow.setFg_reserveMaterials(FBoolean.FALSE);// 不调用物品预留
		}
		ordShow.setId_dep_or(srvDTO.getId_dep_srv());
		ordShow.setId_emp_or(srvDTO.getId_emp_srv());
		ordShow.setName_emp_or(srvDTO.getName_emp_srv());
		ordShow.setId_ent(srvDTO.getId_en());
		ordShow.setId_enttp(srvDTO.getId_entp());
		// ordShow.setId_grp(ordDTO.getId_grp());
		ordShow.setId_grp(srvDTO.getId_grp());
		ordShow.setId_mm(srvDTO.getId_mm());
		// ordShow.setId_pat(ordDTO.getId_pat());
		ordShow.setId_pat(srvDTO.getId_pat());
		ordShow.setId_srv(srvDTO.getId_srv());
		ordShow.setId_srvca(srvDTO.getId_srvca());
		ordShow.setId_srv_or(srvDTO.getId_srv_or());
		// 医保计划
		ordShow.setId_hp(hpId);
		
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
		// TODO 当前如果为物品 规格字段没有数据，规格无数据 提交到医保会提示 规格为空 需要在后期优化时 揉到获取数据时
		if (!StringUtil.isEmpty(srvDTO.getId_mm())) {
			IMeterialMDORService mmservice = ServiceFinder.find(IMeterialMDORService.class);
			MeterialDO mm = mmservice.findById(srvDTO.getId_mm());
			if (mm != null) {
				ordShow.setSpec(mm.getSpec());
			}
		}

		ordShow.setQuan_base(srvDTO.getQuan_base());
		ordShow.setPgku_cur(srvDTO.getId_unit_cur());
		ordShow.setPgku_base(srvDTO.getId_unit_base());
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
		 ordShow.setAmt_hp(FDouble.ZERO_DBL);//new 金额_医保计划
		// ordShow.setAmt_pat(null);//new 标准金额：数量*标准价格.补费接口调用时，设置为null
		// ordShow.setAmt_std(null);//new 标准金额：数量*标准价格.补费接口调用时，设置为null
		// ordShow.setAmt(null);//new 金额：数量*标准价格*价格比例.补费接口调用时，设置为null

		ordShow.setCode_mm(srvDTO.getCode_mm());// new 物品编码
		ordShow.setId_mmtp(srvDTO.getId_mmtp());// new 物品类型
		ordShow.setSd_mmtp(srvDTO.getSd_mmtp());// new 物品类型编码
		ordShow.setFg_mm(srvDTO.getFg_mm());// new 物品标示
		ordShow.setSrcfunc_des(IBlCgCodeConst.OpFeeCollect);// 来源门诊收费
		ordShow.setId_pripat(srvDTO.getId_pripat());// new 患者价格类型
		ordShow.setEu_orsrcmdtp(srvDTO.getEu_orsrcmdtp());//new 费用来源 提供零挂使用
		// 就诊来源
		ordShow.setEu_srctp(0);
		// FDateTime sv = srvDTO.getCi_sv();
		ordShow.setCi_sv(srvDTO.getCi_sv());
		ordShow.setFg_pricinginsertcg(FBoolean.TRUE); // 划价是插入cg表中的数据
		// ordShow.setRatio_hp(null);//new 医保自付比例 ？？？
		// ordShow.setRatio_pripat(null);//new 价格比例 ？？？
		ordShow.setFg_selfPay(srvDTO.getFg_selfpay());// 是否自费
		//医嘱的超量开单原因对照费用的医疗类别
		if(StringUtils.isNotEmpty(srvDTO.getSd_excessive_reason())){
			this.getHpStTp(srvDTO.getSd_excessive_reason(),ordShow);
		}
		
		//设置诊断
		ordShow.setId_didef(srvDTO.getId_didef());
		ordShow.setCode_didef(srvDTO.getCode_didef());
		ordShow.setName_didef(srvDTO.getName_didef());
		ordShow.setFg_or(srvDTO.getFg_or());
		
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

		if (ListUtil.isEmpty(orgSrvList))
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
				if (entHpDOs[0].getId_hp() != null && (entHpDOs[0].getFg_fundpay() != null && entHpDOs[0].getFg_fundpay().booleanValue()) && (entHpDOs[0].getFg_hp_card() != null && !entHpDOs[0].getFg_hp_card().booleanValue())) {
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
	
	private void getHpStTp(String sd_hpsttp,BlOrderAppendBillParamDTO ordShow){
		switch (sd_hpsttp){
		case ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC://慢性病
			ordShow.setSd_hpsttp(IBlDictCodeTypeConst.SD_HPSTTP_CHRONIC);
			ordShow.setId_hpsttp(IBlDictCodeTypeConst.ID_HPSTTP_CHRONIC);
			break;
		case ICiDictCodeConst.SD_EXCESSIVE_REASON_EXCEPTIONAL://特殊病
			ordShow.setSd_hpsttp(IBlDictCodeTypeConst.SD_HPSTTP_SPECIAL);
			ordShow.setId_hpsttp(IBlDictCodeTypeConst.ID_HPSTTP_SPECIAL);
			break;
		default:
			ordShow.setSd_hpsttp(IBlDictCodeTypeConst.SD_HPSTTP_HP);
			ordShow.setId_hpsttp(IBlDictCodeTypeConst.ID_HPSTTP_HP);
			break;
		}
		
	}
	
	/**
	 * 判断数据是否为null
	 * @param str
	 * @return
	 */
	private String getValue(String str){
		return str==null?"":str;
	}
	
	/**
	 * 组装未记账医嘱第三方补费信息
	 * @param patInfo
	 * @param parsList
	 * @return
	 * @throws BizException 
	 */
	private List<BlOrderAppendBillParamDTO> getThirdFeeList(PatDO patInfo,
			ArrayList<PrescriptionConstBaseDto> parsList,Map<String, MeasDocDO> measMap) throws BizException {
		
		if(patInfo==null || ListUtil.isEmpty(parsList)){
			return null;
		}
		
		//入参组装
		BlThridFeeCondDTO thridFeeDto=new BlThridFeeCondDTO();
		thridFeeDto.setId_pat(patInfo.getId_pat());
		thridFeeDto.setCode_pat(patInfo.getCode());
		
		//组装医嘱set
		Set<String> idOrSet=new HashSet<String>();
		//处方费用Map
		Map<String, PrescriptionCostDto> presMap=new HashMap<>();
		//就诊list
		List<String> entList=new ArrayList<>();
		for (PrescriptionConstBaseDto presDto : parsList) {
			FArrayList list = presDto.getPrescriptionCostDto();
			if(!ListUtil.isEmpty(list)){
				List<PrescriptionCostDto> preList=(List<PrescriptionCostDto>)list;
				if(!ListUtil.isEmpty(preList)){
					for (PrescriptionCostDto preDto : preList) {
						if(!StringUtil.isEmpty(preDto.getId_or())){
							idOrSet.add(preDto.getId_or());
							if(!presMap.containsKey(preDto.getId_or())){
								presMap.put(preDto.getId_or(), preDto);
							}
						}
						
						if (!StringUtil.isEmpty(preDto.getId_en()) && !entList.contains(preDto.getId_en())) {
							entList.add(preDto.getId_en());
						}
					}
				}
			}
		}
		if(idOrSet==null || idOrSet.size()<=0){
			return null;
		}
		
		List<String> list=new ArrayList<String>(idOrSet);
		FArrayList Flist=new FArrayList();
		Flist.addAll(list);
		thridFeeDto.setId_ors(Flist);
		
		// 查询就诊医保计划

		Map<String, String> entHpMap = new HashMap<String, String>();
		if (entList.size() > 0) {
			IEnthpRService entHpService = ServiceFinder.find(IEnthpRService.class);
			EntHpDO[] hpDos = entHpService.find(SqlUtils.getInSqlByIds("a0.id_ent", entList) + " and fg_maj = 'Y' ",
					null, FBoolean.FALSE);

			if (!ArrayUtil.isEmpty(hpDos)) {
				for (EntHpDO entHpDO : hpDos) {
					entHpMap.put(entHpDO.getId_ent(), entHpDO.getId_hp());
				}
			}
		}

		//调用第三方获取补费费用
		IBlThirdFeeService thirdFeeService=ServiceFinder.find(IBlThirdFeeService.class);
		
		if(thirdFeeService==null){
			return null;
		}
		
		BlThridFeeRltDTO[] thridFeeDtos = thirdFeeService.getThirdFeeItem(thridFeeDto);
		
		//组装可返回的数据
		List<BlOrderAppendBillParamDTO> thridFeeList=assThriddFeeList(thridFeeDtos,presMap,entHpMap,measMap);
		return thridFeeList;
	}
	
	/**
	 * 组装第三方补费可展示数据
	 * @param thridFeeDtos
	 * @return
	 * @throws BizException 
	 */
	private List<BlOrderAppendBillParamDTO> assThriddFeeList(BlThridFeeRltDTO[] thridFeeDtos,Map<String, PrescriptionCostDto> presMap,Map<String, String> entHpMap,Map<String, MeasDocDO> measMap) throws BizException{
		
		//入参校验
		if(ArrayUtil.isEmpty(thridFeeDtos)){
			return null;
		}
		
		//查询服务信息
		Map<String, MedSrvDO> medSrvMap=new HashMap<>();
		
		List<String> srvIdList=new ArrayList<>();
		for (BlThridFeeRltDTO thridFeeRltDto : thridFeeDtos) {
			srvIdList.add(thridFeeRltDto.getId_srv());
		}
		
		IMedsrvMDORService medRService=ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medSrvDos = medRService.findByIds(srvIdList.toArray(new String[0]), FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(medSrvDos)){
			throw new BizException("第三方调入，未查询到对应的服务信息");
		}
		
		for (MedSrvDO medSrvDO : medSrvDos) {
			medSrvMap.put(medSrvDO.getId_srv(), medSrvDO);
		}
		
		List<BlOrderAppendBillParamDTO> billDetailDtos = new ArrayList<BlOrderAppendBillParamDTO>();
		
		for (BlThridFeeRltDTO thridFeeRltDto : thridFeeDtos) {
			BlOrderAppendBillParamDTO paramDto=new BlOrderAppendBillParamDTO();
			
			//获取原处方费用信息
			PrescriptionCostDto srvDTO = presMap.get(thridFeeRltDto.getId_or());
			
			//获取服务信息
			MedSrvDO medSrvDO=medSrvMap.get(thridFeeRltDto.getId_srv());
			if(medSrvDO==null){
				throw new BizException("第三方调入：未查询到服务信息");
			}
			
			if(srvDTO==null){
				continue;
			}
			
			String hpId = null;
			if(!StringUtil.isEmpty(srvDTO.getId_en())){
				hpId = entHpMap.get(srvDTO.getId_en());
			}
			
			paramDto.setFg_free(FBoolean.FALSE);// 默认不减免
			paramDto.setId_org(Context.get().getOrgId());
			paramDto.setId_org_mp(Context.get().getOrgId());
			paramDto.setId_org_or(Context.get().getOrgId());
			paramDto.setName_dep_or(srvDTO.getName_dep_srv());
			paramDto.setId_dep_mp(srvDTO.getId_dep_mp());
			paramDto.setName_dep_mp(srvDTO.getName_dep_mp());
			paramDto.setId_dep_wh(srvDTO.getId_dep_wh());
			paramDto.setEu_blmd(medSrvDO.getEu_blmd().toString());
			paramDto.setPri(thridFeeRltDto.getPrice());
			paramDto.setPri_std(thridFeeRltDto.getPrice());
			paramDto.setPri_ratio(thridFeeRltDto.getPrice());
			paramDto.setFg_mm(medSrvDO.getFg_mm());
			//暂空
			//paramDto.setIndicitemid(srvDTO.getIndicitemid());
			paramDto.setId_dep_or(srvDTO.getId_dep_srv());
			paramDto.setId_emp_or(srvDTO.getId_emp_srv());
			paramDto.setName_emp_or(srvDTO.getName_emp_srv());
			paramDto.setId_ent(srvDTO.getId_en());
			paramDto.setId_enttp(srvDTO.getId_entp());
			paramDto.setId_grp(srvDTO.getId_grp());
			paramDto.setId_pat(srvDTO.getId_pat());
			paramDto.setId_srv(thridFeeRltDto.getId_srv());
			
			paramDto.setId_srvca(medSrvDO.getId_srvca());

			// 医保计划
			paramDto.setId_hp(hpId);
			
//			// 服务项目医保类别
//			paramDto.setId_hpsrvtp(srvDTO.getId_hpsrvtp());
//			// 服务项目医保类别
//			paramDto.setSd_hpsrvtp(srvDTO.getSd_hpsrvtp());
			paramDto.setId_hpkind(srvDTO.getId_hpkind());
			paramDto.setFg_hpspcl(srvDTO.getFg_specill());
			paramDto.setFg_extdispense(FBoolean.FALSE);
			paramDto.setEu_direct(1);
			paramDto.setSd_srvtp(medSrvDO.getSd_srvtp());
			paramDto.setId_srvtp(medSrvDO.getId_srvtp());
			paramDto.setCode_enttp(srvDTO.getCode_entp());
			paramDto.setQuan(thridFeeRltDto.getQuan());
			
			//paramDto.setQuan_base(srvDTO.getQuan_base());
			//paramDto.setPgku_cur(srvDTO.getId_unit_cur());
			//paramDto.setPgku_base(srvDTO.getId_unit_base());
			//paramDto.setFactor(srvDTO.getFactor_cb());
			paramDto.setFg_Cgoep(FBoolean.FALSE);

			paramDto.setId_or(thridFeeRltDto.getId_or());
			paramDto.setName_or(srvDTO.getDes());
			paramDto.setId_or(srvDTO.getId_or());
			paramDto.setName_or(srvDTO.getDes());
			//paramDto.setId_orsrv(srvDTO.getId_orsrv());
			paramDto.setName_srv(medSrvDO.getName());
			paramDto.setFg_additm(FBoolean.TRUE);
			// tcy:医嘱日期
			paramDto.setDt_or(srvDTO.getDt_sign());

			paramDto.setCode_srv(medSrvDO.getCode());// new

			MeasDocDO measDocDO = measMap.get(medSrvDO.getId_unit_med());
			if (measDocDO != null) {
				paramDto.setSrvu(measDocDO.getId_measdoc());// new 服务项目单位
				paramDto.setSrvu_name(measDocDO.getName());// new 服务项目单位
			}
			paramDto.setSrcfunc_des(IBlCgCodeConst.OpFeeCollect);// 来源门诊收费
			
			paramDto.setFg_hpspcl(srvDTO.getFg_specill());
			paramDto.setFg_extdispense(srvDTO.getFg_extdispense());
			if (paramDto.getFg_extdispense() != null && paramDto.getFg_extdispense().booleanValue()) {
				if (paramDto.getPresrption_name() != null) {
					paramDto.setPresrption_name(paramDto.getPresrption_name().toString() + "[外配处方]");
				} else {
					paramDto.setPresrption_name("[外配处方]");
				}
			}
			if (paramDto.getFg_hpspcl() != null && paramDto.getFg_hpspcl().booleanValue()) {
				if (paramDto.getPresrption_name() != null) {
					paramDto.setPresrption_name(paramDto.getPresrption_name().toString() + "[特殊病]");
				} else {
					paramDto.setPresrption_name("[特殊病]");
				}
			}
			paramDto.setAmt_hp(FDouble.ZERO_DBL);//new 金额_医保计划

			paramDto.setSrcfunc_des(IBlCgCodeConst.OpFeeCollect);// 来源门诊收费
			paramDto.setId_pripat(srvDTO.getId_pripat());// new 患者价格类型
			paramDto.setEu_orsrcmdtp(srvDTO.getEu_orsrcmdtp());//new 费用来源 提供零挂使用
			// 就诊来源
			paramDto.setEu_srctp(0);
			paramDto.setCi_sv(srvDTO.getCi_sv());
			paramDto.setFg_pricinginsertcg(FBoolean.TRUE); // 划价是插入cg表中的数据
			paramDto.setFg_selfPay(srvDTO.getFg_selfpay());// 是否自费
			//医嘱的超量开单原因对照费用的医疗类别
			if(StringUtils.isNotEmpty(srvDTO.getSd_excessive_reason())){
				this.getHpStTp(srvDTO.getSd_excessive_reason(),paramDto);
			}
			
			//设置诊断
			paramDto.setId_didef(srvDTO.getId_didef());
			paramDto.setCode_didef(srvDTO.getCode_didef());
			paramDto.setName_didef(srvDTO.getName_didef());
			
			billDetailDtos.add(paramDto);
		}
		
		return billDetailDtos;
	}
	
	/**
	 * 将急诊留观返回的就诊信息转换为门诊就诊信息
	 * @param ipBasicDTO
	 * @return
	 */
	private OpBasicDTO convertEntIpToOep(IpBasicDTO ipBasicDTO){
		OpBasicDTO dto = new OpBasicDTO();
		dto.setId_ent(ipBasicDTO.getId_ent());
		dto.setId_pripat(ipBasicDTO.getId_pripat());
		// 患者价格分类
		dto.setName_pripat(ipBasicDTO.getName_pripat());
		// 患者分类
		dto.setName_patca(ipBasicDTO.getName_patca());
		//患者分类id
		dto.setId_patca(ipBasicDTO.getId_patca());
		// 就诊科室名称
		dto.setName_dep_phy(ipBasicDTO.getName_dep_phy());
		// 就诊次数
		dto.setTimes_op(ipBasicDTO.getTimes_ip());
		return dto;
	}
	
}
