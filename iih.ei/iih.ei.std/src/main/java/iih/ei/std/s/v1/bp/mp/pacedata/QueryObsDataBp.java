package iih.ei.std.s.v1.bp.mp.pacedata;

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
import iih.ei.std.s.v1.bp.mp.pacedata.qry.GetTimesOpSql;
import iih.ei.std.s.v1.bp.mp.pacedata.sqldata.ObsApInfoSqlData;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import iih.pi.reg.pat.i.IPiPatHpDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
 * @ClassName: QueryObsDataBp
 * @Description: 查询检查数据
 * @author zhy
 * @date 2019年9月25日
 * @version 2020年7月8日11:32:12 by zhy
 *          申请单des_sympsign临床症状为大字段,系统框架查询报错,所以改为单独查询后赋值
 *
 */
public class QueryObsDataBp {

	/**
	 * 程序入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public ObsPatinfoDTO exec(ObsParamDTO param) throws BizException {

		// 1. 获取患者ID
		String patID = getPatID(param.getApplyno(), param.getCode());
		if (StringUtil.isEmptyWithTrim(patID)) {
			throw new BizException("没有找到对应患者信息 !");
		}
		// 2. 查询数据
		ObsApplyInfoSqlRstDTO[] sqlRstDTO = queryData(patID, param.getApplyno(), param.getCode_dep_mp(),param.getDt_begin(),param.getDt_end());
		if (sqlRstDTO == null || sqlRstDTO.length < 1) {
			throw new BizException("未查询到相关检查数据");
		}

		//门诊次数加住院次数
		queryList(sqlRstDTO);

		// 3. 判断是否是预交金模式,过滤门诊的数据
		List<ObsApplyInfoSqlRstDTO> rtnDTOs = filterData(sqlRstDTO);

		// 4. 查询医嘱ID
		List<String> idors = getidors(rtnDTOs);

		// 5. 查询收费项目
		List<ObsApplyInfoSqlRstDTO> prices = getItems(idors.toArray(new String[idors.size()]));

		// 6. 获取医嘱id与收费项目集合的映射关系
		Map<String, FArrayList> priceMap = getPriceMap(prices);

		// 7. 维度拆分
		ObsPatinfoDTO patient = conVerToPatient(rtnDTOs, priceMap);

		return patient;
	}

	/**
	 * 获取患者ID
	 * 
	 * @param applyno
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private String getPatID(String applyno, String code) throws BizException {

		// 申请单号不为空,以申请单号为准
		if (!StringUtil.isEmptyWithTrim(applyno)) {
			CiOrderDO[] orderDOs = ServiceFinder.find(ICiorderMDORService.class).findByAttrValString(CiOrderDO.APPLYNO, applyno);
			if (null != orderDOs && orderDOs.length > 0) {
				return orderDOs[0].getId_pat();
			}

		}
		if (!StringUtil.isEmptyWithTrim(code)) {

			// 按患者唯一标识查询(按使用频次)
			// 1.卡号
			PiPatCardDO[] patCardDOs = ServiceFinder.find(IPiPatCardDORService.class).findByAttrValString(PiPatCardDO.CODE, code);
			if (null != patCardDOs && patCardDOs.length > 0) {
				return patCardDOs[0].getId_pat();
			}

			// 2.医保卡号
			PiPatHpDO[] piPatHpDOs = ServiceFinder.find(IPiPatHpDORService.class).findByAttrValString(PiPatHpDO.NO_HP, code);
			if (null != piPatHpDOs && piPatHpDOs.length > 0) {
				return piPatHpDOs[0].getId_pat();
			}

			// 3.申请单号
			CiOrderDO[] orderDOs = ServiceFinder.find(ICiorderMDORService.class).findByAttrValString(CiOrderDO.APPLYNO, code);
			if (null != orderDOs && orderDOs.length > 0) {
				return orderDOs[0].getId_pat();
			}

			// 4.住院号
			PatDO[] ippatDOS = ServiceFinder.find(IPatiMDORService.class).findByAttrValString(PatDO.CODE_AMR_IP, code);
			if (ippatDOS != null && ippatDOS.length > 0) {
				return ippatDOS[0].getId_pat();
			}

			// 5.身份证号
			PatDO[] patDOs = ServiceFinder.find(IPatiMDORService.class).findByAttrValString(PatDO.ID_CODE, code);
			if (null != patDOs && patDOs.length > 0) {
				return patDOs[0].getId_pat();
			}

			// 6.患者编码
			PatDO[] patDOsByCode = ServiceFinder.find(IPatiMDORService.class).findByAttrValString(PatDO.CODE, code);
			if (null != patDOsByCode && patDOsByCode.length > 0) {
				return patDOsByCode[0].getId_pat();
			}

			// 7.chis条码号
			PatDO[] patDObyBar = ServiceFinder.find(IPatiMDORService.class).findByAttrValString(PatDO.BARCODE_CHIS, code);
			if (patDObyBar != null && patDObyBar.length > 0) {
				return patDObyBar[0].getId_pat();
			}
		}

		return null;
	}

	/**
	 * 通过sql查询数据
	 * 
	 * @param patID
	 * @param applyno
	 * @param code_dep_mp
	 * @return
	 * @throws BizException
	 */
	private ObsApplyInfoSqlRstDTO[] queryData(String patID, String applyno, String code_dep_mp,String dt_begin,String dt_end) throws BizException {
		GetObsApInfoSql sql = new GetObsApInfoSql(patID, applyno, code_dep_mp,dt_begin,dt_end);
		ObsApplyInfoSqlRstDTO[] sqlRstDTOs = (ObsApplyInfoSqlRstDTO[]) AppFwUtil.getDORstWithDao(sql, ObsApplyInfoSqlRstDTO.class);
		getDes_sympsign(sqlRstDTOs);
		return sqlRstDTOs;
	}

	/**
	 * 判断是否是预交金模式过滤门诊的数据
	 * 
	 * @param sqlRstDTO
	 * @return
	 * @throws BizException
	 */
	private List<ObsApplyInfoSqlRstDTO> filterData(ObsApplyInfoSqlRstDTO[] sqlRstDTO) throws BizException {
		List<ObsApplyInfoSqlRstDTO> reList = new ArrayList<>();
		// 预交金模式
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
	 * 
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
	 * 门诊次数加住院次数
	 * @param sqlRstDTO
	 * @throws BizException
	 */
	private void queryList(ObsApplyInfoSqlRstDTO[] sqlRstDTO) throws BizException {
		List<String> code_ors = new ArrayList<String>();
		for (ObsApplyInfoSqlRstDTO applyInfoSqlRstDTO : sqlRstDTO) {
			if (!StringUtil.isEmptyWithTrim(applyInfoSqlRstDTO.getCode_or())) {
				if (!code_ors.contains(applyInfoSqlRstDTO.getCode_or())) {
					code_ors.add(applyInfoSqlRstDTO.getCode_or());
				}
			}
		}
		if (code_ors.size() < 1)
			return;
		// 查询门诊就诊次数
		HashMap<String, String> map = new HashMap<String, String>();
		GetTimesOpSql sql = new GetTimesOpSql(code_ors.toArray(new String[0]));
		List<ObsApplyInfoSqlRstDTO> srvDTOs = (List<ObsApplyInfoSqlRstDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(ObsApplyInfoSqlRstDTO.class));
		if (srvDTOs == null || srvDTOs.size() < 1)
			return;
		for (ObsApplyInfoSqlRstDTO applyInfoSqlRstDTO : srvDTOs) {
			if (!StringUtil.isEmptyWithTrim(applyInfoSqlRstDTO.getTimes_ent())) {
				if (!map.containsKey(applyInfoSqlRstDTO.getCode_or())) {
					map.put(applyInfoSqlRstDTO.getCode_or(), applyInfoSqlRstDTO.getTimes_ent());
				}
			}
		}
		// 给页面展示的数据赋值
		for (ObsApplyInfoSqlRstDTO applyInfoSqlRstDTO : sqlRstDTO) {
			if (map.containsKey(applyInfoSqlRstDTO.getCode_or())) {
				applyInfoSqlRstDTO.setTimes_ent(Integer.toString(Integer.parseInt(map.get(applyInfoSqlRstDTO.getCode_or())) +  Integer.parseInt(applyInfoSqlRstDTO.getTimes_ent())));
			}
		}
	}

	/**
	 * 查询收费项目
	 * 
	 * @param array
	 * @return
	 * @throws BizException
	 */
	private List<ObsApplyInfoSqlRstDTO> getItems(String[] idors) throws BizException {
		List<ObsApplyInfoSqlRstDTO> prices = new ArrayList<ObsApplyInfoSqlRstDTO>();
		IOrdSrvDORService srvDORService = ServiceFinder.find(IOrdSrvDORService.class);
		OrdSrvDO[] itemDtos = srvDORService.findByAttrValStrings(OrdSrvDO.ID_OR, idors);
		if (itemDtos != null && itemDtos.length > 0) {
			for (OrdSrvDO srvDO : itemDtos) {
				ObsApplyInfoSqlRstDTO price = new ObsApplyInfoSqlRstDTO();
				price.setId_or(srvDO.getId_or());
				price.setName_srv_charge(srvDO.getName_srv());
				price.setCode_srv_charge(srvDO.getCode_srv());// 收费项目
				price.setPrice(srvDO.getPri());// 价格
				price.setQuan(srvDO.getQuan_total_medu().equals(new FDouble("0")) ? srvDO.getQuan_medu() : srvDO.getQuan_total_medu());// 收费数量
				if (FBoolean.TRUE.equals(srvDO.getFg_bl())) {
					prices.add(price);
				}
			}
		}

		return prices;
	}

	/**
	 * 获取医嘱id与收费项目集合的映射关系
	 * 
	 * @param prices
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, FArrayList> getPriceMap(List<ObsApplyInfoSqlRstDTO> prices) {
		Map<String, FArrayList> map = new HashMap<String, FArrayList>();
		for (ObsApplyInfoSqlRstDTO dto : prices) {
			PriceDetailDTO price = new PriceDetailDTO();
			conVerToPrice(price, dto);// 类型转换
			if (map.containsKey(dto.getId_or())) {
				map.get(dto.getId_or()).add(price);
			} else {
				FArrayList priceList = new FArrayList();
				priceList.add(price);
				map.put(dto.getId_or(), priceList);
			}
		}
		return map;
	}

	/**
	 * 转换为xml所需Price
	 * 
	 * @param price
	 * @param dto
	 */
	private void conVerToPrice(PriceDetailDTO price, ObsApplyInfoSqlRstDTO dto) {
		for (String attr : price.getAttrNames()) {
			String attrName = attr.substring(0, 1).toUpperCase() + attr.substring(1);
			price.setAttrVal(attrName, dto.getAttrVal(attrName) == null ? "" : dto.getAttrVal(attrName));
		}

	}

	/**
	 * 维度拆分
	 * 
	 * @param rtnDTOs
	 * @param priceMap
	 * @return
	 */
	private ObsPatinfoDTO conVerToPatient(List<ObsApplyInfoSqlRstDTO> rtnDTOs, Map<String, FArrayList> priceMap) {
		ObsPatinfoDTO patient = new ObsPatinfoDTO();
		FArrayList examList = new FArrayList();
		if (null != rtnDTOs && rtnDTOs.size() > 0) {
			conVerToPatient(patient, rtnDTOs.get(0));
			for (ObsApplyInfoSqlRstDTO dto : rtnDTOs) {
				FArrayList priceList = priceMap.get(dto.getId_or());
				FDouble pri = calPrice(priceList);// 计算总价格
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
	 * 
	 * @param patient
	 * @param obsApplyInfoSqlRstDTO
	 */
	private void conVerToPatient(ObsPatinfoDTO patient, ObsApplyInfoSqlRstDTO prcDTO) {
		for (String attr : patient.getAttrNames()) {
			String attrName = attr.substring(0, 1).toUpperCase() + attr.substring(1);
			patient.setAttrVal(attrName, prcDTO.getAttrVal(attrName) == null ? "" : prcDTO.getAttrVal(attrName));
		}

	}

	/**
	 * 计算总价格
	 * 
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
	 * 
	 * @param dto
	 * @return
	 */
	private ApObsDTO conVerToApObs(ObsApplyInfoSqlRstDTO rstDTO) {
		ApObsDTO exam = new ApObsDTO();
		for (String attr : exam.getAttrNames()) {
			String attrName = attr.substring(0, 1).toUpperCase() + attr.substring(1);
			exam.setAttrVal(attrName, rstDTO.getAttrVal(attrName) == null ? "" : rstDTO.getAttrVal(attrName));
		}
		return exam;
	}

	/**
	 * 获取临床症状体征信息
	 * 
	 * @param sqlRstDTOs
	 * @throws DAException
	 */
	private void getDes_sympsign(ObsApplyInfoSqlRstDTO[] sqlRstDTOs) throws DAException {
		if (null == sqlRstDTOs || sqlRstDTOs.length < 1)
			return;
		Map<String, ObsApplyInfoSqlRstDTO> map = new HashMap<>();
		StringBuffer applys = new StringBuffer();
		for (ObsApplyInfoSqlRstDTO dto : sqlRstDTOs) {
			if (!map.containsKey(dto.getNo_applyform())) {
				map.put(dto.getNo_applyform(), dto);
				if (applys.length() == 0) {
					applys.append("'");
					applys.append(dto.getNo_applyform());
					applys.append("'");
				} else {
					applys.append(",");
					applys.append("'");
					applys.append(dto.getNo_applyform());
					applys.append("'");
				}
			}
		}

		String sqlstr = "select no_applyform,  clinicalzztz as des_sympsign from CI_AP_OBS   where no_applyform in (" + applys.toString() + ")";
		List<ObsApInfoSqlData> list = (List<ObsApInfoSqlData>) new DAFacade().execQuery(sqlstr, new BeanListHandler(ObsApInfoSqlData.class));
		if (null == list || list.size() < 1)
			return;
		for (ObsApInfoSqlData sqlData : list) {
			map.get(sqlData.getNo_applyform()).setDes_sympsign(sqlData.getDes_sympsign());
		}

	}
}
