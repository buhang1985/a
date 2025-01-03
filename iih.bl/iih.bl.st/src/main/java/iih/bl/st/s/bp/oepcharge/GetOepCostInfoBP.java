package iih.bl.st.s.bp.oepcharge;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.i.external.provide.IBdPpBlQryService;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.dto.cglogic.d.BlCgApplyDTO;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.comm.util.BlSqlQueryUtil;
import iih.bl.itf.cg.IBlThirdFeeService;
import iih.bl.itf.cg.dto.d.BlThridFeeCondDTO;
import iih.bl.itf.cg.dto.d.BlThridFeeRltDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeCommonCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.s.bp.oepcharge.base.GetOepCostInfoBaseBP;
import iih.bl.st.s.bp.oepcharge.qry.BlOepCgInfoQry;
import iih.bl.st.s.bp.oepcharge.qry.BlOepCostOrdInfoQry;
import iih.pi.reg.pat.d.PatDO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 门诊调入通用逻辑
 * @author ly 2018/12/04
 *
 */
public class GetOepCostInfoBP extends GetOepCostInfoBaseBP{

	private Map<String, MedSrvDO> srvMap;//第三方调入用
	private Map<String, IncCaItmRelDO> incRelMap;//第三方调入用
	
	
	/**
	 * 门诊调入
	 * @param patId 患者id
	 * @param dtBegin
	 * @param dtEnd
	 * @param fgCheckValid 是否做有效期校验
	 * @return 待收费信息
	 * @throws BizException
	 */
	public BlOepChargeInputDTO[] exec(BlOepChargeCommonCondDTO cond, FBoolean fgCheckValid) throws BizException {

		this.validate(cond, fgCheckValid);
		
		//删除划价挂起数据
		this.deleteSuspData(cond.getId_pat());
		
		List<BlOepChargeInputDTO> chargeList = new ArrayList<BlOepChargeInputDTO>();
		
		//查询挂起记账挂号数据
		BlOepChargeInputDTO[] suspDtos = this.getSuspCgInfo(cond);
		if(!ArrayUtil.isEmpty(suspDtos)){
			
			if(FBoolean.TRUE.equals(cond.getFg_qrysusp())){
				//优先检索挂号挂起数据
				//返回第一条挂号费
				List<BlOepChargeInputDTO> suspList = new ArrayList<BlOepChargeInputDTO>();
				String entId = suspDtos[0].getId_ent();
				for (BlOepChargeInputDTO blOepChargeInputDTO : suspDtos) {
					if(entId.equals(blOepChargeInputDTO.getId_ent())){
						suspList.add(blOepChargeInputDTO);
					}
				}
				return suspList.toArray(new BlOepChargeInputDTO[0]);
			}else{
				chargeList.addAll(Arrays.asList(suspDtos));
			}
		}
		
		//查询待缴费医嘱信息
		List<String> orsrvIdList = this.getUnChargeOrdIds(cond);
		if(!ListUtil.isEmpty(orsrvIdList)){
			
			BlOepChargeInputDTO[] orDtos = this.getOrUnchargeInfo(cond.getId_pat(), orsrvIdList);
			
			if(FBoolean.TRUE.equals(fgCheckValid)){
				orDtos = this.filterOrDatas(orDtos);
			}
			
			if(!ArrayUtil.isEmpty(orDtos)){
				
				//补充单据信息
				this.addApplyInfo(orDtos);
				
				BlOepChargeInputDTO[] thirdDatas = this.getThirdFeeInfo(cond.getId_pat(), orDtos);
				chargeList.addAll(Arrays.asList(orDtos));
				if(!ArrayUtil.isEmpty(thirdDatas)){
					chargeList.addAll(Arrays.asList(thirdDatas));
				}
			}
		}

		//查询已记账信息
		BlOepChargeInputDTO[] cgDtos = this.getCgUnStInfo(cond);
		if(!ArrayUtil.isEmpty(cgDtos)){
			chargeList.addAll(Arrays.asList(cgDtos));
		}
		
		if(ListUtil.isEmpty(chargeList))
			return null;
		
		//排序 TODO
		
		return chargeList.toArray(new BlOepChargeInputDTO[0]);
	}
	
	/**
	 * 入参校验
	 * @param patId
	 * @param dtBegin
	 * @param dtEnd
	 * @param fgCheckValid
	 * @throws BizException
	 */
	private void validate(BlOepChargeCommonCondDTO cond, FBoolean fgCheckValid) throws BizException {
		
		if(StringUtil.isEmpty(cond.getId_pat())){
			throw new ArgumentNullException("门诊调入", "患者id");
		}
		
		if(cond.getDt_begin() == null){
			throw new ArgumentNullException("门诊调入", "开始时间");
		}
		
		if(cond.getDt_end() == null){
			throw new ArgumentNullException("门诊调入", "结束时间");
		}
	}
	
	/**
	 * 删除挂起数据
	 * @param patId
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void deleteSuspData(String patId) throws BizException{
		
		String sql = "select distinct id_stoep from bl_cg_itm_oep "
				+ "where id_pat = ? and fg_susp = 'Y' and eu_srctp <> 1 and fg_pricinginsertcg = 'Y' ";
		
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(patId);
		
		List<Object> rlt = (List<Object>)daf.execQuery(sql, param, new ColumnListHandler());
		if(ListUtil.isEmpty(rlt))
			return;
		
		BlOepCancelPricingBP cancelBp = new BlOepCancelPricingBP();
		for (Object obj : rlt) {
			String stId = (String)obj;
			cancelBp.exec(stId);
		}
	}
	
	/**
	 * 获取待缴费服务id
	 * @param patId
	 * @param day
	 * @return
	 * @throws BizException
	 */
	private List<String> getUnChargeOrdIds(BlOepChargeCommonCondDTO cond) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select orsrv.id_orsrv from ci_or_srv orsrv ");
		sqlSb.append("inner join ci_order ord ");
		sqlSb.append("on orsrv.id_or = ord.id_or ");
		sqlSb.append("where orsrv.sd_su_bl = ? ");
		sqlSb.append("and orsrv.fg_bl = 'Y' ");
		sqlSb.append("and ord.code_entp in (?,?,?,?) ");
		sqlSb.append("and ord.id_pat = ? ");
		sqlSb.append("and ord.fg_sign = 'Y' ");
		sqlSb.append("and ord.fg_canc = 'N' ");
		sqlSb.append("and ord.dt_sign between ? and ? ");

		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_BL_NONE);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);
		param.addParam(cond.getId_pat());
		param.addParam(cond.getDt_begin().toString() + " 00:00:00");
		param.addParam(cond.getDt_end().toString() + " 23:59:59");
		
		if(!StringUtil.isEmpty(cond.getId_ent())){
			sqlSb.append("and ord.id_en = ? ");
			param.addParam(cond.getId_ent());
		}
		
		if(!StringUtil.isEmpty(cond.getId_dep_or())){
			sqlSb.append("and ord.id_dep_or = ? ");
			param.addParam(cond.getId_dep_or());
			
		}
		
		if(!StringUtil.isEmpty(cond.getId_dep_mp())){
			sqlSb.append("and (orsrv.id_dep_mp = ? or orsrv.id_dep_wh = ? )");
			param.addParam(cond.getId_dep_mp());
			param.addParam(cond.getId_dep_mp());
		}
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<String> rlt = (List<String>)daf.execQuery(sqlSb.toString(), param, new ColumnListHandler());
		
		return rlt;
	}

	/**
	 * 查询待缴费医嘱信息
	 * @param orsrvIdList
	 * @return
	 * @throws BizException
	 */
	protected BlOepChargeInputDTO[] getOrUnchargeInfo(String patId, List<String> orsrvIdList) throws BizException {
		
		// TODO 
		BlOepCostOrdInfoQry qry = new BlOepCostOrdInfoQry(orsrvIdList);
		BlOepChargeInputDTO[] datas = (BlOepChargeInputDTO[]) AppFwUtil.getDORstWithDao(qry, BlOepChargeInputDTO.class);
		return datas;
	}
	
	/**
	 * 第三方数据调入
	 * @param orDtos
	 * @return
	 * @throws BizException
	 */
	private BlOepChargeInputDTO[] getThirdFeeInfo(String patId, BlOepChargeInputDTO[] orDtos) throws BizException {
		
		List<BlOepChargeInputDTO> thirdCgList = new ArrayList<BlOepChargeInputDTO>();
		
		// 补充第三方调入
		IBlThirdFeeService thirdFeeService = ServiceFinder.find(IBlThirdFeeService.class);
		if(thirdFeeService == null)
			return null;
		
		Set<String> orIdSet = new HashSet<String>();
		for (BlOepChargeInputDTO inputDto : orDtos) {
			if (!StringUtil.isEmpty(inputDto.getId_or())) {
				orIdSet.add(inputDto.getId_or());
			}
		}
			
		if(orIdSet.size() > 0){
			BlThridFeeCondDTO cond = new BlThridFeeCondDTO();
			cond.setId_pat(patId);
			
			DAFacade daf = new DAFacade();
			PatDO patDO = (PatDO)daf.findByPK(PatDO.class, patId);
			if(patDO != null){
				cond.setCode_pat(patDO.getCode());
			}
				
			FArrayList orIdFList = new FArrayList();
			orIdFList.addAll(orIdSet);
			cond.setId_ors(orIdFList);
			
			BlThridFeeRltDTO[] thirdDatas = thirdFeeService.getThirdFeeItem(cond);
			if(!ArrayUtil.isEmpty(thirdDatas)){
				
				//校验第三方调入数据
				this.checkAndPrepareThirdData(thirdDatas);
				
				for (BlThridFeeRltDTO thirdData : thirdDatas) {
					
					BlOepChargeInputDTO orInputDto = null;
					for (BlOepChargeInputDTO chargeInputDto : orDtos) {
						if(thirdData.getId_or().equals(chargeInputDto.getId_or())){
							orInputDto = chargeInputDto;
							break;
						}
					}
					
					if(orInputDto == null){
						throw new BizException("门诊调入: 第三方接口调入数据医嘱id不存在");
					}
					
					BlOepChargeInputDTO inputDto = (BlOepChargeInputDTO)orInputDto.clone();
					this.clearChargeInputClone(inputDto);
					inputDto.setId_srv(thirdData.getId_srv());
					inputDto.setQuan(thirdData.getQuan());
					inputDto.setPrice_std(thirdData.getPrice());
					inputDto.setPrice_ratio(thirdData.getPrice());
					
					MedSrvDO medSrvDO = this.srvMap.get(thirdData.getId_srv());
					if(medSrvDO != null){
						inputDto.setSd_srvtp(medSrvDO.getSd_srvtp());
						inputDto.setCode_srv(medSrvDO.getCode());
						inputDto.setName_srv(medSrvDO.getName());
						inputDto.setSrvu(medSrvDO.getId_unit_med());
						inputDto.setSrvu_name(null);
						inputDto.setEu_blmd(medSrvDO.getEu_blmd());
					}
					IncCaItmRelDO incRelDO = this.incRelMap.get(thirdData.getId_srv());
					if(incRelDO != null){
						inputDto.setCode_inccaitm(incRelDO.getInccaitm_code());
						inputDto.setName_inccaitm(incRelDO.getInccaitm_name());
					}
					
					thirdCgList.add(inputDto);
				}
				this.addOtherInfo(thirdCgList);
			}
		}
		
		return thirdCgList.toArray(new BlOepChargeInputDTO[0]);
	}
	
	/**
	 * 医嘱数据过滤
	 * @param orDtos
	 * @return
	 * @throws BizException
	 */
	private BlOepChargeInputDTO[] filterOrDatas(BlOepChargeInputDTO[] orDtos) throws BizException {
		GetFilterEffeOrderBP bp= new GetFilterEffeOrderBP();
		BlOepChargeInputDTO[] dtos=bp.getImputEffeData(orDtos);
		return dtos;
	}
	
	/**
	 * 补充单据信息
	 * @param orDtos
	 * @throws BizException
	 */
	protected void addApplyInfo(BlOepChargeInputDTO[] orDtos) throws BizException {
		
		Set<String> drugOrsrvSet = new HashSet<String>();// 药品
		Set<String> risOrSet = new HashSet<String>(); // 检查
		Set<String> lisOrSet = new HashSet<String>(); // 检验
		Set<String> bingliOrSet = new HashSet<String>(); // 病理
		Set<String> otherOrsrvSet = new HashSet<String>(); // 其他

		for (BlOepChargeInputDTO orDto : orDtos) {

			// 暂时只处理原医嘱数据
			if (StringUtil.isEmpty(orDto.getId_or()) || StringUtil.isEmpty(orDto.getId_orsrv()))
				continue;

			if (orDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				drugOrsrvSet.add(orDto.getId_orsrv());
			} else if (IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI.equals(orDto.getSd_srvtp())) {
				bingliOrSet.add(orDto.getId_or());
			} else if (orDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				risOrSet.add(orDto.getId_or());
			} else if (orDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
				lisOrSet.add(orDto.getId_or());
			} else {
				otherOrsrvSet.add(orDto.getId_orsrv());
			}
		}

		Map<String, BlCgApplyDTO> applyMap = new HashMap<String, BlCgApplyDTO>();

		if (drugOrsrvSet.size() > 0) {
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getPresCode(drugOrsrvSet.toArray(new String[0]));
			if (!ArrayUtil.isEmpty(applyDtos)) {
				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
				}
			}
		}

		if (risOrSet.size() > 0) {
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getRisCode(risOrSet.toArray(new String[0]));
			if (!ArrayUtil.isEmpty(applyDtos)) {
				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
				}
			}
		}

		if (lisOrSet.size() > 0) {
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getLisCode(lisOrSet.toArray(new String[0]));
			if (!ArrayUtil.isEmpty(applyDtos)) {
				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
				}
			}
		}

		if (bingliOrSet.size() > 0) {
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getBingliCode(bingliOrSet.toArray(new String[0]));
			if (!ArrayUtil.isEmpty(applyDtos)) {
				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
				}
			}
		}

		if (otherOrsrvSet.size() > 0) {
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getOtherPrnCode(otherOrsrvSet.toArray(new String[0]));
			if (!ArrayUtil.isEmpty(applyDtos)) {
				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
				}
			}
		}

		// 单据信息
		for (BlOepChargeInputDTO orDto : orDtos) {
			if (!StringUtil.isEmpty(orDto.getId_or()) && !StringUtil.isEmpty(orDto.getId_orsrv())) {

				BlCgApplyDTO applyDto = applyMap.get(orDto.getId_or());
				if (applyDto == null) {
					applyDto = applyMap.get(orDto.getId_orsrv());
				}

				if (applyDto != null) {
					orDto.setApplyno(applyDto.getApplyno());
					orDto.setCode_bill(applyDto.getApplyno());// TODO
				}
			}
		}
	}
	
	/**
	 * 获取记账未结算数据
	 * @param patId
	 * @param dtBegin
	 * @param dtEnd
	 * @return
	 * @throws BizException
	 */
	private BlOepChargeInputDTO[] getCgUnStInfo(BlOepChargeCommonCondDTO cond)throws BizException {
		
		if(!FBoolean.TRUE.equals(cond.getFg_qrycg()))
			return null;
		BlOepCgInfoQry qry = new BlOepCgInfoQry(cond, true, false);
		@SuppressWarnings("unchecked")
		List<BlOepChargeInputDTO> datas = (List<BlOepChargeInputDTO>) new DAFacade().execQuery(qry.getQrySQLStr(),qry.getQryParameter(null),new BeanListHandler(BlOepChargeInputDTO.class));
		this.addOtherInfo(datas);
		return datas.toArray(new BlOepChargeInputDTO[]{});
	}
	
	/**
	 * 查询挂起记账数据
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private BlOepChargeInputDTO[] getSuspCgInfo(BlOepChargeCommonCondDTO cond) throws BizException {
		BlOepCgInfoQry qry = new BlOepCgInfoQry(cond, false, true);
		return (BlOepChargeInputDTO[])AppFwUtil.getDORstWithDao(qry, BlOepChargeInputDTO.class);
	}

	/**
	 * 校验第三方调入数据
	 * @param thirdDatas
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void checkAndPrepareThirdData(BlThridFeeRltDTO[] thirdDatas) throws BizException {
		
		Set<String> srvIdSet = new HashSet<String>();
		for (BlThridFeeRltDTO thirdData : thirdDatas) {
			
			if(StringUtil.isEmpty(thirdData.getId_or())){
				throw new BizException("门诊调入: 第三方接口调入数据医嘱id为空");
			}
			
			if(StringUtil.isEmpty(thirdData.getId_srv())){
				throw new BizException("门诊调入: 第三方接口调入数据服务id为空");
			}

			if(thirdData.getQuan() == null || thirdData.getQuan().compareTo(FDouble.ZERO_DBL) <= 0){
				throw new BizException("门诊调入: 第三方接口调入数据数量为空或小于0");
			}
			
			if(thirdData.getPrice() != null && thirdData.getPrice().compareTo(FDouble.ZERO_DBL) < 0){
				throw new BizException("门诊调入: 第三方接口调入数据单价小于0");
			}
			
			srvIdSet.add(thirdData.getId_srv());
		}
		
		this.srvMap = new HashMap<String, MedSrvDO>();
		this.incRelMap = new HashMap<String, IncCaItmRelDO>();
		
		DAFacade daf = new DAFacade();
		List<MedSrvDO> medList = (List<MedSrvDO>)daf.findByPKs(MedSrvDO.class, srvIdSet.toArray(new String[0]));
		for (MedSrvDO medSrvDO : medList) {
			this.srvMap.put(medSrvDO.getId_srv(), medSrvDO);
		}
		IBdPpBlQryService ppblService = ServiceFinder.find(IBdPpBlQryService.class);
		IncCaItmRelDO[] incItmDos = ppblService.findCaItmRelBySrv(IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE, srvIdSet.toArray(new String[0]));
		if(!ArrayUtil.isEmpty(incItmDos)){
			for (IncCaItmRelDO incCaItmRelDO : incItmDos) {
				this.incRelMap.put(incCaItmRelDO.getId_srv(), incCaItmRelDO);
			}
		}
	}

	/**
	 * 清除克隆数据服务部分
	 * @param inputDto
	 */
	private void clearChargeInputClone(BlOepChargeInputDTO inputDto){
		
		inputDto.setId_orsrv(null);
		inputDto.setId_srv(null);
		inputDto.setCode_srv(null);
		inputDto.setName_srv(null);
		inputDto.setQuan(null);
		inputDto.setPrice_std(null);
		inputDto.setPrice_ratio(null);
		
		inputDto.setSrvu(null);
		inputDto.setSrvu_name(null);
		inputDto.setFg_mm(FBoolean.FALSE);
		inputDto.setId_mm(null);
		inputDto.setCode_mm(null);
		inputDto.setName_mm(null);
		inputDto.setSpec(null);
		inputDto.setId_pgku_cur(null);
		inputDto.setId_inccaitm(null);
		inputDto.setCode_inccaitm(null);
		inputDto.setName_inccaitm(null);
	}

	/**
	 * 补充第三方调入的其他信息
	 * @param thirdCgList
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void addOtherInfo(List<BlOepChargeInputDTO> thirdCgList) throws BizException{
		
		Set<String> unitIdSet = new HashSet<String>();
		for (BlOepChargeInputDTO thirdCgDto : thirdCgList) {
			unitIdSet.add(thirdCgDto.getSrvu());
		}
		DAFacade daf = new DAFacade();
		List<MeasDocDO> measDocList = (List<MeasDocDO>)daf.findByPKs(MeasDocDO.class, unitIdSet.toArray(new String[0]),
				new String[] { MeasDocDO.ID_MEASDOC, MeasDocDO.NAME });
		
		if(!ListUtil.isEmpty(measDocList)){
			Map<String, MeasDocDO> measDocMap = new HashMap<String, MeasDocDO>();
			for (MeasDocDO measDocDO : measDocList) {
				measDocMap.put(measDocDO.getId_measdoc(), measDocDO);
			}

			for (BlOepChargeInputDTO thirdCgDto : thirdCgList) {
				MeasDocDO measDocDO = measDocMap.get(thirdCgDto.getSrvu());
				if(measDocDO != null){
					thirdCgDto.setSrvu_name(measDocDO.getName());
				}
			}
		}
	}
}
