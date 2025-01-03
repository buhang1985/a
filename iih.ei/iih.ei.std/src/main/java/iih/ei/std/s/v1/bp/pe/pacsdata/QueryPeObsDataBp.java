package iih.ei.std.s.v1.bp.pe.pacsdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ei.std.d.v1.mp.pacedata.d.ApObsDTO;
import iih.ei.std.d.v1.mp.pacedata.d.ObsApplyInfoSqlRstDTO;
import iih.ei.std.d.v1.mp.pacedata.d.ObsParamDTO;
import iih.ei.std.d.v1.mp.pacedata.d.ObsPatinfoDTO;
import iih.ei.std.d.v1.mp.pacedata.d.PriceDetailDTO;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.ei.std.s.v1.bp.mp.pacedata.qry.GetObsApInfoSql;
import iih.ei.std.s.v1.bp.pe.pacsdata.qry.GetPeObsApInfoSql;
import iih.pe.comm.constant.IPEParamConst;
import iih.pe.comm.utils.PEParamUtils;
import iih.pe.papt.pecorpappt.d.PeCorpApptDO;
import iih.pe.papt.pecorpappt.i.IPecorpapptMDORService;
import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import iih.pe.papt.pepsnappt.i.IPepsnapptRService;
import iih.pe.papt.pepsncatsel.d.PePsnapptCatDO;
import iih.pe.papt.pepsncatsel.i.IPepsncatselRService;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvCastApplyDO;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogDO;
import iih.pe.pitm.pesrvbcatlog.i.IPeSrvCastApplyDORService;
import iih.pe.pitm.pesrvbcatlog.i.IPesrvbcatlogMDORService;
import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import iih.pe.por.pepsnbinfo.i.IPepsnbinfoMDORService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import iih.pi.reg.pat.i.IPiPatHpDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 
* @ClassName: QueryObsDataBp
* @Description: 查询检查数据
* @author zhy
* @date 2019年9月25日
*
 */
public class QueryPeObsDataBp {

	/**
	 * 程序入口
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public ObsPatinfoDTO exec(ObsParamDTO param) throws BizException {
		
		//1. 获取患者ID
		String patID = getPatID(param.getApplyno(),param.getCode());
		if (StringUtil.isEmptyWithTrim(patID)) {
			throw new BizException("没有找到对应患者信息 !");
		}
		
		//2. 查询数据
		ObsApplyInfoSqlRstDTO[] sqlRstDTO = queryData(patID, param.getApplyno(), param.getCode(), param.getCode_dep_mp());
		if (sqlRstDTO == null || sqlRstDTO.length < 1) {
			throw new BizException("未查询到相关患者的检查数据");
		}
		
		//3. 判断是否是预交金模式,过滤门诊的数据
		List<ObsApplyInfoSqlRstDTO> rtnDTOs = filterData(sqlRstDTO);
		
		//4. 查询医嘱ID
		List<String> idors = getidors(rtnDTOs);
		
		//5. 查询收费项目
		List<ObsApplyInfoSqlRstDTO> prices = getItems(idors.toArray(new String[idors.size()]));
		
		//6. 获取医嘱id与收费项目集合的映射关系
		Map<String, FArrayList> priceMap = getPriceMap(prices);
 		
		//7. 维度拆分
		ObsPatinfoDTO patient = conVerToPatient(rtnDTOs,priceMap);
		
		return patient;
	}
	

	/**
	 * 获取患者ID
	 * @param applyno
	 * @param code
	 * @return
	 * @throws BizException 
	 */
	private String getPatID(String applyno, String code) throws BizException {
		//申请单号不为空,以申请单号为准
		if (!StringUtil.isEmptyWithTrim(applyno)) {
			PePsnApptDO[] pePsnApptDo = ServiceFinder.find(IPepsnapptRService.class).findByAttrValString(PePsnApptDO.PE_CODE, applyno);
			if(pePsnApptDo.length == 0) {
				throw new BizException("没有找到对应患者信息 !");
			}
			PePsnBInfoDO pePsnBInfoDo = ServiceFinder.find(IPepsnbinfoMDORService.class).findById(pePsnApptDo[0].getId_pepsnbinfo());
			if (pePsnBInfoDo != null) {
				return pePsnBInfoDo.getId_pat();
			}
			
		}
		if (!StringUtil.isEmptyWithTrim(code)) {
			
			//体检唯一码查询
			PePsnApptDO[] pePsnApptDo = ServiceFinder.find(IPepsnapptRService.class).findByAttrValString(PePsnApptDO.PE_CODE, code);
			if(pePsnApptDo.length == 0) {
				throw new BizException("没有找到对应患者信息 !");
			}
			PePsnBInfoDO pePsnBInfoDo = ServiceFinder.find(IPepsnbinfoMDORService.class).findById(pePsnApptDo[0].getId_pepsnbinfo());
			if (pePsnBInfoDo != null) {
				return pePsnBInfoDo.getId_pat();
			}		
		 }
		
		return null;
	}
	
	/**
	 * 通过sql查询数据
	 * @param patID
	 * @param applyno
	 * @param code_dep_mp
	 * @return
	 * @throws BizException 
	 */
	private ObsApplyInfoSqlRstDTO[] queryData(String patID, String apply_no, String code, String code_dep_mp) throws BizException {
		String dept_pe = PEParamUtils.codePeDept();
		IDeptRService rservice = ServiceFinder.find(IDeptRService.class);
		DeptDO dept = rservice.findById(dept_pe);
		if (dept == null) {
			throw new BizException("没有找到对应的科室信息 !，参数：" + IPEParamConst.PE000014);
		}		
		String code_dep_pe = dept.getCode();
		String name_dep_pe = dept.getName();
		String psn_pe = PEParamUtils.codePeChief();
		IPsndocMDORService psnservice = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO psn = psnservice.findById(psn_pe);
		String code_psn_pe = psn.getCode();
		String name_psn_pe = psn.getName();
		GetPeObsApInfoSql sql = new GetPeObsApInfoSql(patID, apply_no, code, code_dep_mp, code_dep_pe, name_dep_pe,code_psn_pe,name_psn_pe);
	    ObsApplyInfoSqlRstDTO[] sqlRstDTOs = (ObsApplyInfoSqlRstDTO[]) AppFwUtil.getDORstWithDao(sql, ObsApplyInfoSqlRstDTO.class);
		boolean isPsn = this.getIsPsn(apply_no, code);
		if (!isPsn){
		    return sqlRstDTOs;
		}else{
	 		//2.个检过滤返回结果
		    ObsApplyInfoSqlRstDTO[] rtnDtos = filterPeRst(sqlRstDTOs);
	 		if (rtnDtos == null || rtnDtos.length == 0) {
	 		    return null;
	 		}
	 	return rtnDtos;
		}
	}
	
	//体检是否为团检
	private boolean getIsPsn(String apply_no, String code) throws BizException {
		String pe_code = apply_no;
		if (!StringUtil.isEmptyWithTrim(apply_no)) {
			pe_code = apply_no;
		}
		
		if (!StringUtil.isEmptyWithTrim(code)) {
			pe_code = code;
		}
		
		//个检标识
		Boolean fg_psn =false;
		PePsnApptDO[] pePsnApptDo = ServiceFinder.find(IPepsnapptRService.class).find("pe_code='"+pe_code+"'","",FBoolean.FALSE);
		//团体预约单号是否为空
		if(pePsnApptDo[0].getId_pecorpappt() != null){
			//个检
			if("~".equals(pePsnApptDo[0].getId_pecorpappt())){
				fg_psn = true;
			}
			if(!"~".equals(pePsnApptDo[0].getId_pecorpappt())){
				PeCorpApptDO peCorpApptDo = ServiceFinder.find(IPecorpapptMDORService.class).findById(pePsnApptDo[0].getId_pecorpappt());
				//团体走个检
				if("Y".equals(peCorpApptDo.getFg_mode_person())){
					fg_psn = true;
				}
				else{//团检
					fg_psn =false;
				}
			}
		}//个检
		else{
			fg_psn = true;
		}
		return fg_psn;
	}	
	
	/**
	 * 过滤返回体检结果
	 * 
	 * @param rtns
	 * @return
	 */
	private ObsApplyInfoSqlRstDTO[] filterPeRst(ObsApplyInfoSqlRstDTO[] rtns) {
		List<ObsApplyInfoSqlRstDTO> reList = new ArrayList<ObsApplyInfoSqlRstDTO>();
		if (rtns != null && rtns.length > 0) {
			for (ObsApplyInfoSqlRstDTO rtn : rtns) {
				// 需要计费的医嘱
				if (ICiDictCodeConst.SD_SU_BL_ACCOUNT.equals(rtn.getSd_su_bl())) {
					reList.add(rtn);
				}
			}
		}
		return reList.toArray(new ObsApplyInfoSqlRstDTO[reList.size()]);
	}
	
	/**
	 * 判断是否是预交金模式过滤门诊的数据
	 * @param sqlRstDTO
	 * @return
	 * @throws BizException 
	 */
	private List<ObsApplyInfoSqlRstDTO> filterData(ObsApplyInfoSqlRstDTO[] sqlRstDTO) throws BizException {
		List<ObsApplyInfoSqlRstDTO> reList = new ArrayList<>();
		//预交金模式
		if (IBlDictCodeConst.PARAM_VALUE_EXECACCOUNT.equals(EiParamUtils.BLCG0002())) {
			reList.addAll(Arrays.asList(sqlRstDTO));
			return reList;
		}
		
		for (ObsApplyInfoSqlRstDTO rtn : sqlRstDTO) {
			if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(rtn.getCode_entp())) {
				reList.add(rtn);
				continue;
			}
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(rtn.getCode_entp())) {
				if (rtn.getNum_bl() == 0) {
					// 无需计费的医嘱
					reList.add(rtn);
				} else {
					// 需要计费的医嘱
					if (ICiDictCodeConst.SD_SU_BL_ACCOUNT.equals(rtn.getSd_su_bl())) {
						reList.add(rtn);
					}
				}
			}
		}
		return reList;
	}
	
	/**
	 * 获取医嘱id
	 * @param rtnDTOs
	 * @return
	 */
	private List<String> getidors(List<ObsApplyInfoSqlRstDTO> rtnDTOs) {
		List<String> idors = new ArrayList<>();
		for (ObsApplyInfoSqlRstDTO dto : rtnDTOs) {
			if (idors.contains(dto.getId_or())) {
				continue;
			}
			idors.add(dto.getId_or());
		}
		return idors;
	}
	
	
	/**
	 * 查询收费项目
	 * @param array
	 * @return
	 * @throws BizException 
	 */
	private List<ObsApplyInfoSqlRstDTO> getItems(String[] idors) throws BizException {
		List<ObsApplyInfoSqlRstDTO> prices = new ArrayList<ObsApplyInfoSqlRstDTO>();
		IPepsncatselRService srvDORService = ServiceFinder.find(IPepsncatselRService.class);
		IPeSrvCastApplyDORService peSrvCastApplyDORService = ServiceFinder.find(IPeSrvCastApplyDORService.class);
		IPesrvbcatlogMDORService pesrvbcatlogMDORService = ServiceFinder.find(IPesrvbcatlogMDORService.class);
		
		PePsnapptCatDO[] pePsnapptCatDos = srvDORService.findByAttrValStrings(PePsnapptCatDO.ID_PEPSNAPPTCAT, idors);
		if(pePsnapptCatDos != null && pePsnapptCatDos.length > 0){
			for (PePsnapptCatDO pePsnapptCatDo : pePsnapptCatDos) {
				//PeSrvbCatlogDO peSrvbCatlogDo = pesrvbcatlogMDORService.findById(pePsnapptCatDo.getId_pesrvcatlog());
				PeSrvCastApplyDO[] peSrvCastApplyDos = peSrvCastApplyDORService.find("id_pesrvbcatlog='"+pePsnapptCatDo.getId_pesrvcatlog()+"'", "", FBoolean.FALSE);
				if (peSrvCastApplyDos != null && peSrvCastApplyDos.length > 0) {
					for (PeSrvCastApplyDO peSrvCastApplyDo : peSrvCastApplyDos) {
						ObsApplyInfoSqlRstDTO price = new ObsApplyInfoSqlRstDTO();
						price.setId_or(pePsnapptCatDo.getId_pepsnapptcat());
						price.setName_srv_charge(peSrvCastApplyDo.getName_bdsrv());
						//price.setCode_srv_charge(peSrvCastApplyDo.getCode_bdsrv());// 收费项目
						if(pePsnapptCatDo.getPri_cat() != null) {
							price.setPrice(pePsnapptCatDo.getPri_cat());// 价格
						}else {
							price.setPrice(new FDouble(0));// 价格
						}
						price.setCode_srv_charge("");// 收费项目
						price.setQuan(new FDouble(1));// 收费数量
						if (FBoolean.TRUE.equals(pePsnapptCatDo.getFg_paid())) {
							prices.add(price);
						}
					}
			}
		}
		}

		return prices;
	}

	/**
	 * 获取医嘱id与收费项目集合的映射关系
	 * @param prices
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, FArrayList> getPriceMap(List<ObsApplyInfoSqlRstDTO> prices) {
		Map<String, FArrayList> map = new HashMap<String, FArrayList>();
		for (ObsApplyInfoSqlRstDTO dto : prices) {
			PriceDetailDTO price = new PriceDetailDTO();
			conVerToPrice(price,dto);//类型转换
			if (map.containsKey(dto.getId_or())) {
				map.get(dto.getId_or()).add(price);
			}else {
				FArrayList priceList = new FArrayList();
				priceList.add(price);
				map.put(dto.getId_or(), priceList);
			}
		}
		return map;
	}

	/**
	 * 转换为xml所需Price
	 * @param price
	 * @param dto
	 */
	private void conVerToPrice(PriceDetailDTO price, ObsApplyInfoSqlRstDTO dto) {
		for (String attr : price.getAttrNames()) {
			String attrName = attr.substring(0, 1).toUpperCase() + attr.substring(1);
			price.setAttrVal(attrName, dto.getAttrVal(attrName)==null?"":dto.getAttrVal(attrName));
		}
		
	}
	
	/**
	 * 维度拆分
	 * @param rtnDTOs
	 * @param priceMap
	 * @return
	 */
	private ObsPatinfoDTO conVerToPatient(List<ObsApplyInfoSqlRstDTO> rtnDTOs, Map<String, FArrayList> priceMap) {
		ObsPatinfoDTO patient = new ObsPatinfoDTO();
		FArrayList examList = new FArrayList();
		if (null != rtnDTOs && rtnDTOs.size()> 0) {
			conVerToPatient(patient, rtnDTOs.get(0));
			for (ObsApplyInfoSqlRstDTO dto : rtnDTOs) {
				FArrayList priceList = priceMap.get(dto.getId_or());
				FDouble pri = calPrice(priceList);//计算总价格
				ApObsDTO exam = conVerToApObs(dto);
				exam.setTotal_price(pri + "");
				exam.setPricedetaildtos(priceList);
				examList.add(exam);
			}
		}
		patient.setApobsdtos(examList);
		return patient;
	}
	

	/**
	 * 数据转换
	 * @param patient
	 * @param obsApplyInfoSqlRstDTO
	 */
	private void conVerToPatient(ObsPatinfoDTO patient, ObsApplyInfoSqlRstDTO prcDTO) {
		for (String attr : patient.getAttrNames()) {
			String attrName = attr.substring(0, 1).toUpperCase() + attr.substring(1);
			patient.setAttrVal(attrName, prcDTO.getAttrVal(attrName)==null?"":prcDTO.getAttrVal(attrName));
		}
		
	}
	
	/**
	 * 计算总价格
	 * @param priceList
	 * @return
	 */
	private FDouble calPrice(FArrayList priceList) {
		FDouble pri = new FDouble();
		if (priceList != null && priceList.size() > 0) {
			for (Object object : priceList) {
				PriceDetailDTO item = (PriceDetailDTO) object;
				if (item.getPrice() != null) {
					pri = pri.add(item.getPrice().multiply(item.getQuan()));
				}
			}
		}
		return pri;
	}
	
	/**
	 * 数据转换
	 * @param dto
	 * @return
	 */
	private ApObsDTO conVerToApObs(ObsApplyInfoSqlRstDTO rstDTO) {
		ApObsDTO exam = new ApObsDTO();
		for (String attr : exam.getAttrNames()) {
			String attrName = attr.substring(0, 1).toUpperCase() + attr.substring(1);
			exam.setAttrVal(attrName, rstDTO.getAttrVal(attrName)==null?"":rstDTO.getAttrVal(attrName));
		}
		return exam;
	}

}












