package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

import iih.bd.base.utils.MapUtils;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.itf.pe.IBlPeChargeService;
import iih.bl.params.BlParams;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.pe.papi.i.his.IChargeService;
import iih.pe.papt.dto.peitfchargedto.d.PeItfChargeDTO;
import iih.pe.papt.dto.peitfchargedto.d.PeItfPatDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * 获取体检费用信息
 * 
 * @author zhangxin 2018年11月20日
 *
 */
public class GetPeChargeInputBP {
	/**
	 * 获取体检费用信息
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public BlOepChargeInputDTO[] exec(String id_pat, String pe_code) throws BizException {
		BlOepChargeInputDTO[] chargeSrvInfo = new BlOepChargeInputDTO[] {};
		//是否要调用第三方体检接口
		if (BlParams.BLITF0002().booleanValue()) {
			chargeSrvInfo = this.getItfPeChargeService(id_pat, pe_code);
		} else {
			chargeSrvInfo = this.getPeChargeService(id_pat,pe_code);
		}
		if (ArrayUtil.isEmpty(chargeSrvInfo)) {
			throw new BizException("没有需要缴纳的体检费用");
		}
		return chargeSrvInfo;
	}
    /**
     * 调用iih 体检接口
     * @param id_pat
     * @return
     * @throws BizException
     */
	private BlOepChargeInputDTO[] getPeChargeService(String id_pat,String pecode) throws BizException {
		// 根据患者id 获取患者信息
		IPatiMDORService ipatiRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDo = ipatiRService.findById(id_pat);
		if (patDo != null) {
			//如果存在挂起数据 则执行取消划价
			this.DePriceByPat(id_pat);
			// 组装体检接口入参
			PeItfPatDTO pePatInfo = this.getPePatInfo(patDo,pecode);
			if (pePatInfo != null) {
				// 调用体检查询费用接口
				IChargeService ichatgeService = ServiceFinder.find(IChargeService.class);
				if (ichatgeService == null) {
					throw new BizException("未获取到体检收费接口");
				}
				// 体检 返回参数
				BLThirdItfLogger.info("体检接口入参" + pePatInfo.getId_pat());
				PeItfChargeDTO[] pePatientConnectPi = ichatgeService.peChargeConnectBl(pePatInfo);
				BLThirdItfLogger.info("体检接口出参" + ArrayUtils.toString(pePatientConnectPi));
				// 入参校验
				this.validator(pePatientConnectPi);
				// 根据体检返回参数组装 费用信息
				BlOepChargeInputDTO[] chargeSrvInfo = this.getChargeSrvInfo(pePatientConnectPi, patDo);
				return chargeSrvInfo;

			}
		}
		return null;
	}
	 /**
     * 取消划价
     * @param id_pat
     * @throws BizException 
     */
	private void DePriceByPat(String id_pat) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("  select itmoep.id_cgoep,itmoep.id_cgitmoep, itmoep.fg_susp, itmoep.eu_srctp,itmoep.pecode ");
		sql.append("  from bl_cg_oep oep ");
		sql.append("  inner join bl_cg_itm_oep itmoep on itmoep.id_cgoep = oep.id_cgoep");
		sql.append("  where oep.eu_direct = 1 ");
		sql.append("  and itmoep.fg_refund = 'N' ");
		sql.append("  and itmoep.fg_susp ='Y' ");
		sql.append("  and itmoep.price_ratio > 0 ");
		sql.append("  and itmoep.id_pat = ? ");
		sql.append("  and itmoep.id_org = ? ");
		SqlParam sp = new SqlParam();
		sp.addParam(id_pat);
		sp.addParam(Context.get().getOrgId());
		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> list = (List<BlCgItmOepDO>) new DAFacade().execQuery(sql.toString(), sp, new BeanListHandler(BlCgItmOepDO.class));
		List<String> strIdCgOepDeletedLst = new ArrayList<String>();
		if(!ListUtil.isEmpty(list)){
			for (BlCgItmOepDO cg : list) {
				strIdCgOepDeletedLst.add(cg.getId_cgitmoep());
			}
			IBLCiOrderToBlCgService iBLCiOrderToBlCgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
			iBLCiOrderToBlCgService.DeleteOepPricingInfo(strIdCgOepDeletedLst.toArray(new String[0]));
		}
	}
   /**
    * 调用第三方体检接口
    * @param id_pat
    * @param pe_code
    * @return
    * @throws BizException
    */
	private BlOepChargeInputDTO[] getItfPeChargeService(String id_pat, String pe_code) throws BizException {
		IBlPeChargeService peChargeService  = ServiceFinder.find(IBlPeChargeService.class);
		if (peChargeService == null) {
			throw new BizException("未获取到第三方体检收费接口");
		}
		BlOepChargeInputDTO[] peFeeInfo = peChargeService.getPeFeeInfo(id_pat, pe_code);
		return peFeeInfo;
	}

	/**
	 * 校验参数
	 * 
	 * @param pePatientConnectPi
	 * @throws BizException
	 */
	private void validator(PeItfChargeDTO[] pePatientConnectPi) throws BizException {
		if (ArrayUtil.isEmpty(pePatientConnectPi)) {
			throw new BizException("没有需要缴纳的体检费用");
		}
		for (PeItfChargeDTO peItfChargeDTO : pePatientConnectPi) {
			String nameOr = peItfChargeDTO.getName_or();
			if (StringUtils.isEmpty(peItfChargeDTO.getId_srv())) {
				throw new BizException("服务id 不能为空 ");
			}
			if (StringUtils.isEmpty(peItfChargeDTO.getId_dep_or())) {
				throw new BizException("开立科室  不能为空 ");
			}
			if (StringUtils.isEmpty(peItfChargeDTO.getId_emp_or())) {
				throw new BizException("开立人员 不能为空 ");
			}
			if (StringUtils.isEmpty(peItfChargeDTO.getPe_code())) {
				throw new BizException("体检预约单 不能为空 ");
			}
			if (peItfChargeDTO.getDt_or() == null) {
				throw new BizException("开立时间 不能为空 ");
			}
			if (peItfChargeDTO.getQuan() == null) {
				throw new BizException("体检项目对应的医嘱服务“"+nameOr+"”数量 不能为空 ");
			}
			if (peItfChargeDTO.getRatio_pripat() == null) {
				throw new BizException("价格比例 不能为空 ");
			}
			if (peItfChargeDTO.getFg_charge() == null) {
				throw new BizException("收费标志 不能为空 ");
			}
		}

	}

	/**
	 * 根据患者id 获取患者信息
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PeItfPatDTO getPePatInfo(PatDO patDo,String pecode) throws BizException {
		// 组装体检所需要入参
		PeItfPatDTO peitfPatDto = new PeItfPatDTO();
		// 患者id
		peitfPatDto.setId_pat(patDo.getId_pat());
		// 证件号
		peitfPatDto.setId_code(patDo.getId_code());
		// 证件类型
		peitfPatDto.setSd_idtp(patDo.getSd_idtp());
		//体检流水号
		peitfPatDto.setPe_code(pecode);
		return peitfPatDto;
	}

	/**
	 * 根据体检返回参数组装 费用信息
	 * 
	 * @param peitfChargeDTO
	 * @return
	 * @throws BizException
	 */
	private BlOepChargeInputDTO[] getChargeSrvInfo(PeItfChargeDTO[] peitfChargeDTOs, PatDO patDo) throws BizException {
		List<BlOepChargeInputDTO> blOepChargeInputDtoList = new ArrayList<BlOepChargeInputDTO>();
		// 查询服务信息
		MedSrvDO[] medSrvDOs = this.initMedSvrInfo(peitfChargeDTOs);
		// 查询计量单位信息
		Map<String, MeasDocDO> mapMea = this.getMeadocName(medSrvDOs);
		// 查询部门信息
		Map<String, DeptDO> mapDep = this.getMapDep(peitfChargeDTOs);
		// 查询人员信息
		Map<String, PsnDocDO> mapEmp = this.getMapEmp(peitfChargeDTOs);
		// 计算价格
		// Map<String, BdPriViewDTO> priMap =this.getPriSrv(medSrvDOs,patDo);
		if (medSrvDOs != null) {
			for (PeItfChargeDTO peItfdto : peitfChargeDTOs) {
				MedSrvDO srvDo = this.getSrvChageItm(medSrvDOs, peItfdto);
				BlOepChargeInputDTO blOepChargeInputDto = this.getFeeDetail(srvDo, patDo, peItfdto, mapMea,
						mapDep, mapEmp);
				blOepChargeInputDtoList.add(blOepChargeInputDto);
			}
				
			
		}
		return blOepChargeInputDtoList.toArray(new BlOepChargeInputDTO[] {});
	}

	/**
	 * 计算价格
	 * 
	 * @param medSrvDOs
	 * @param patDo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private Map<String, BdPriViewDTO> getPriSrv(MedSrvDO[] medSrvDOs, PatDO patDo) throws BizException {
		Map<String, BdPriViewDTO> priMap = new HashMap<String, BdPriViewDTO>();
		// 服务id
		String[] id_srvs = new String[medSrvDOs.length];
		// 价格分类
		String[] pripat = new String[medSrvDOs.length];
		for (int i = 0; i < id_srvs.length; i++) {
			id_srvs[i] = medSrvDOs[i].getId_srv();
			pripat[i] = patDo.getId_patpritp();
		}
		if (medSrvDOs.length > 0) {
			IBdPriCalService calService = ServiceFinder.find(IBdPriCalService.class);
			BdPriViewDTO[] priViewDtos = calService.calSrvPrice(id_srvs, pripat);
			if (!ArrayUtil.isEmpty(priViewDtos)) {
				priMap = (Map<String, BdPriViewDTO>) MapUtils.convertArrayToMap(priViewDtos, "Id_srv");
			}
		}
		return priMap;
	}

	/**
	 * 对照id_srv
	 * 
	 * @param medSrvDO
	 * @param peitfChargeDTO
	 * @return
	 */
	private MedSrvDO getSrvChageItm(MedSrvDO[] medSrvDO, PeItfChargeDTO peitfChargeDTO) {
		String id_srv = peitfChargeDTO.getId_srv();
		for (MedSrvDO srvdo : medSrvDO) {
			if (srvdo.getId_srv().equals(id_srv)) {
				return srvdo;
			}
		}
		return null;

	}

	/**
	 * 获取费用明细
	 * 
	 * @param medSrvDO
	 * @param patDo
	 * @param peItfChargeDTO
	 * @param meaMap
	 * @param mapDep
	 * @param mapEmp
	 * @param priMap
	 * @return
	 */
	private BlOepChargeInputDTO getFeeDetail(MedSrvDO medSrvDO, PatDO patDo, PeItfChargeDTO peItfChargeDTO,
			Map<String, MeasDocDO> meaMap, Map<String, DeptDO> mapDep, Map<String, PsnDocDO> mapEmp) {
		// 当收费标志为false时
		if (!peItfChargeDTO.getFg_charge().booleanValue()) {
			BlOepChargeInputDTO blOepChargeInputDto = new BlOepChargeInputDTO();
			// 患者id
			blOepChargeInputDto.setId_pat(patDo.getId_pat());
			// 患者价格分类
			blOepChargeInputDto.setId_pripat(patDo.getId_patpritp());
			// 患者价格分类名称
			blOepChargeInputDto.setId_pripat_name(patDo.getPatpritp_name());
			// 患者分类
			blOepChargeInputDto.setId_paticate(patDo.getId_paticate());
			// 患者分类名称
			blOepChargeInputDto.setId_paticate_name(patDo.getPaticate_name());
			// 服务id
			blOepChargeInputDto.setId_srv(medSrvDO.getId_srv());
			// 服务编码
			blOepChargeInputDto.setCode_srv(medSrvDO.getCode());
			// 服务名称
			blOepChargeInputDto.setName_srv(medSrvDO.getName());
			// 记账方向
			//blOepChargeInputDto.setEu_direct(BookRtnDirectEnum.CHARGE);
			// 标准价格
			blOepChargeInputDto.setPrice_std(peItfChargeDTO.getAmount());
			// 实际价格
			blOepChargeInputDto.setPrice_ratio(peItfChargeDTO.getAmount());
			// 数量
			blOepChargeInputDto.setQuan(peItfChargeDTO.getQuan());
			// 价格比例
			blOepChargeInputDto.setRatio_pripat(peItfChargeDTO.getRatio_pripat());
			// 计量单位
			blOepChargeInputDto.setSrvu(medSrvDO.getId_unit_med());
			// 计量单位名称
			blOepChargeInputDto.setSrvu_name(meaMap.get(medSrvDO.getId_unit_med()).getName());
			// 开立科室
			blOepChargeInputDto.setId_dep_or(peItfChargeDTO.getId_dep_or());
			// 开立科室名称
			blOepChargeInputDto.setName_dep_or(mapDep.get(peItfChargeDTO.getId_dep_or()).getName());
			// 开立人
			blOepChargeInputDto.setId_emp_or(peItfChargeDTO.getId_emp_or());
			//医嘱名称
			if(!StringUtils.isEmpty(peItfChargeDTO.getName_or())){
				blOepChargeInputDto.setName_or(peItfChargeDTO.getName_or());
			}
			//医嘱id（对应体检项目id）
			if(!StringUtils.isEmpty(peItfChargeDTO.getId_pepsnapptcat())){
				blOepChargeInputDto.setId_or(peItfChargeDTO.getId_pepsnapptcat());
			}
			// 开立人名称
			//blOepChargeInputDto.setName_emp_cg(mapEmp.get(peItfChargeDTO.getId_emp_or()).getName());
			// 物品标志
			blOepChargeInputDto.setFg_mm((FBoolean.FALSE));
			// 执行科室
			blOepChargeInputDto.setId_dep_mp(peItfChargeDTO.getId_dep_or());
			// 执行科室名称
			blOepChargeInputDto.setName_dep_mp(mapDep.get(peItfChargeDTO.getId_dep_or()).getName());
			// 就诊来源
			blOepChargeInputDto.setEu_srctp(FeeOriginEnum.THIRDPE_FEE);
			// 记账来源
			//blOepChargeInputDto.setSrcfunc_des(IBlCgCodeConst.PeRtnCompensteFee);
			// 体检号
			blOepChargeInputDto.setPe_code(peItfChargeDTO.getPe_code());
			// 备注
			blOepChargeInputDto.setNote(peItfChargeDTO.getNote());
			//体检项目主键
			blOepChargeInputDto.setId_pesrv(peItfChargeDTO.getId_pesrvbcatlog());
			return blOepChargeInputDto;
		}
		return null;

	}


	/**
	 * 获取人员字典
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, PsnDocDO> getMapEmp(PeItfChargeDTO[] peitfChargeDTOs) throws BizException {
		List<String> listemp = new ArrayList<String>();
		//获取人员ids
		for (PeItfChargeDTO peItfChargeDTO : peitfChargeDTOs) {
			listemp.add(peItfChargeDTO.getId_emp_or());
		}
		//调用服务获取人员信息
		IPsndocMDORService service = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psnDocDOs = service.findByIds(listemp.toArray(new String[]{}), FBoolean.FALSE);
		Map<String, PsnDocDO> measMap =new HashMap<String, PsnDocDO>();
		if (psnDocDOs != null && psnDocDOs.length > 0) {
			for (PsnDocDO psndocDo : psnDocDOs) {
				if (measMap.get(psndocDo.getId_psndoc()) == null) {
					measMap.put(psndocDo.getId_psndoc(), psndocDo);
				}
			}
		}
		return measMap;
	}

	/**
	 * 获取计量单位字典
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, MeasDocDO> getMeadocName(MedSrvDO[] medSrvDOs) throws BizException {
		List<String> listmeas = new ArrayList<String>();
		//获取计量单位id集合
		for (MedSrvDO medSrv : medSrvDOs) {
			listmeas.add(medSrv.getId_unit_med());
		}
		Map<String,MeasDocDO>  measMap =new HashMap<String,MeasDocDO>();
		//调用基础服务查询 
		IMeasdocRService service = ServiceFinder.find(IMeasdocRService.class);
		MeasDocDO[] measDocDOs = service.findByIds(listmeas.toArray(new String[]{}), FBoolean.FALSE);
		if (measDocDOs != null && measDocDOs.length > 0) {
			for (MeasDocDO measDocDO : measDocDOs) {
				if (measMap.get(measDocDO.getId_measdoc()) == null) {
					measMap.put(measDocDO.getId_measdoc(), measDocDO);
				}
			}
		}
		return measMap;

	}

	/**
	 * 获取科别目录列表
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, DeptDO> getMapDep(PeItfChargeDTO[] peitfChargeDTOs) throws BizException {
		List<String> listdep = new ArrayList<String>();
		Map<String, DeptDO> depMap = new HashMap<String, DeptDO>();
		//获取计量单位id集合
		for (PeItfChargeDTO peItfDto : peitfChargeDTOs) {
			listdep.add(peItfDto.getId_dep_or());
		}
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptDOs = service.findByBIds(listdep.toArray(new String[]{}), FBoolean.FALSE);
		if(!ArrayUtils.isEmpty(deptDOs)){
			for (DeptDO deptDo : deptDOs) {
				if (depMap.get(deptDo.getId_dep()) == null) {
					depMap.put(deptDo.getId_dep(), deptDo);
				}
			}
		}	
		return depMap;
	}


	/**
	 * 查询服务信息
	 * 
	 * @param peitfChargeDTOs
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MedSrvDO[] initMedSvrInfo(PeItfChargeDTO[] peitfChargeDTOs) throws BizException {
		FArrayList listMedSrvForm = new FArrayList();
		for (PeItfChargeDTO peItfChargeDTO : peitfChargeDTOs) {
			listMedSrvForm.add(peItfChargeDTO.getId_srv());
		}
		if (listMedSrvForm.size() > 0) {
			// 获取医疗服务_项目
			IMedsrvMDORService srvSerivce = ServiceFinder.find(IMedsrvMDORService.class);// SRV服务
			MedSrvDO[] medsrvs = srvSerivce.findByAttrValList(MedSrvDO.ID_SRV, listMedSrvForm);
			if (medsrvs == null || medsrvs.length < 0) {
				throw new BizException("服务编码为" + listMedSrvForm + "的服务不存在！");
			}
			for (MedSrvDO medSrvDO : medsrvs) {

				if (!FBoolean.TRUE.equals(medSrvDO.getFg_active())) {
					throw new BizException("服务编码为" + medSrvDO.getCode() + "的服务无效！");
				}
//				if (listMedSrvForm.contains(medSrvDO.getCode())) {
//					listMedSrvForm.remove(medSrvDO.getCode());
//				}
			}

			return medsrvs;
		}

		return null;
	}

}
