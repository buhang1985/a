package iih.bd.srv.ems.bp;

import java.lang.reflect.InvocationTargetException;

import iih.bd.base.cache.ContextCache;
import iih.bd.base.utils.StringCodingUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.EmsRelSrvDO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsregistryMDORService;
import iih.bd.srv.ems.i.IEmsregistryRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗单匹配方法类
 * @author Young
 *
 */
public class EmsManagementBP extends ContextCache {

	private String euofreftp_flag = "", sdsrvtp_flag = "";
	
	private IEmsregistryMDORService emsRService;

	/**
	 * 构造函数
	 */
	public EmsManagementBP() {
		emsRService = ServiceFinder.find(IEmsregistryMDORService.class);
	}
	
	/**
	 * 根据ID获取医疗单匹配对象
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public SrvMatchEmsRstDTO getSrvMatchEmsRstDTO8Id(String id) throws BizException {
		EmsDO emsDO = emsRService.findById(id);
		return getEmsMatchRstDTO(emsDO);
	}
	
	/**
	 * 根据ID获取医疗单匹配对象
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	public FMap getSrvMatchEmsRstDTO8Ids(String[] ids) throws BizException {
		EmsDO[] emsDOs = emsRService.findByIds(ids, FBoolean.FALSE);
		FMap fMap = new FMap();
		if (emsDOs != null && emsDOs.length > 0) {
			for (EmsDO emsDO : emsDOs) {
				fMap.put(emsDO.getId_srvof(), getEmsMatchRstDTO(emsDO));
			}
		}
		return fMap;
	}
	
	/**
	 * 匹配医疗单
	 * @param paramDTOs
	 * @return
	 * @throws BizException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public FMap getEmsMatchResult(SrvMatchEmsParamDTO[] paramDTOs) throws BizException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		if (paramDTOs == null || paramDTOs.length <= 0)
			return null;
		FMap rst = new FMap();
		for (SrvMatchEmsParamDTO paramDTO : paramDTOs) {
			if (paramDTO != null) {
				if (!rst.containsKey(paramDTO.getId_srv())) {
					SrvMatchEmsRstDTO emsMatchRstDTO = null;
					//					emsMatchRstDTO = getEmsMatchResultFromCache(paramDTO);//逻辑有问题，暂时注释
					if (emsMatchRstDTO == null) {
						emsMatchRstDTO = getEmsMatchResultFromDB(paramDTO);
					}
					rst.put(paramDTO.getId_srv(), emsMatchRstDTO);
				}

				euofreftp_flag = "";
				sdsrvtp_flag = "";
			}
		}

		return rst;
	}
	
	/**
	 * 读取缓存匹配医疗单
	 * @return
	 */
	private SrvMatchEmsRstDTO getEmsMatchResultFromCache(SrvMatchEmsParamDTO paramDTO){
	
		EmsDO emsDO = BDMatchEmsInfoCache.GetCache(paramDTO);

		return emsDO != null?getEmsMatchRstDTO(emsDO):null;
		}

	
	/**
	 * 读取数据库匹配医疗单
	 * @return
	 * @throws BizException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private SrvMatchEmsRstDTO getEmsMatchResultFromDB(SrvMatchEmsParamDTO paramDTO) 
			throws BizException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		IEmsregistryRService service = ServiceFinder.find(IEmsregistryRService.class);
		EmsregistryAggDO[] aggDOs = service.find(String.format(" id_org='%s' and id_grp='%s' and fg_active='Y' and dt_effe<='%s' and dt_end>='%s' and eu_emsappmode=%s",
				paramDTO.getId_org(), paramDTO.getId_grp(), paramDTO.getDt_or().toString(), paramDTO.getDt_or().toString(), paramDTO.getEmsappmode()), "", FBoolean.FALSE);
		EmsDO emsDOMatch = null;
		if (aggDOs != null && aggDOs.length > 0) {
			for (EmsregistryAggDO aggDO : aggDOs) {
				EmsDO emsDO = aggDO.getParentDO();
				EmsRelSrvDO[] emsRelSrvDOs = aggDO.getEmsRelSrvDO();
				if (!getFgentp(emsDO, paramDTO.getCode_entp()) || emsRelSrvDOs == null || emsRelSrvDOs.length <= 0) {
					continue;
				}
				
				switch (emsDO.getSd_srvorrt()) {
				case IBdSrvDictCodeConst.SD_OWTP_PERSONAL:
					if (paramDTO.getId_emp().equals(emsDO.getId_dept())) {
						EmsDO emsDOMatchSrv = matchEmsRelSrvDOs(paramDTO.getSd_srvtp(), paramDTO.getId_srv(), emsRelSrvDOs, emsDO);
						if (emsDOMatchSrv != null) {
							emsDOMatch = emsDOMatchSrv;
						}
					}
					break;
				case IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT:
					if (emsDO.getId_dept() != null
							&& emsDO.getId_dept().contains(paramDTO.getId_dept())
							&& (emsDOMatch == null || !IBdSrvDictCodeConst.SD_OWTP_PERSONAL.equals(emsDOMatch.getSd_srvorrt()))) {
						EmsDO emsDOMatchSrv = matchEmsRelSrvDOs(paramDTO.getSd_srvtp(), paramDTO.getId_srv(), emsRelSrvDOs, emsDO);
						if (emsDOMatchSrv != null) {
							emsDOMatch = emsDOMatchSrv;
						}
					}
					break;
				case IBdSrvDictCodeConst.SD_OWTP_HOSPIAL:
					if (emsDOMatch == null || IBdSrvDictCodeConst.SD_OWTP_HOSPIAL.equals(emsDOMatch.getSd_srvorrt())) {
						EmsDO emsDOMatchSrv = matchEmsRelSrvDOs(paramDTO.getSd_srvtp(), paramDTO.getId_srv(), emsRelSrvDOs, emsDO);
						if (emsDOMatchSrv != null) {
							emsDOMatch = emsDOMatchSrv;
						}
					}
					break;
				}
			}
		}
		
		euofreftp_flag = BDMatchEmsInfoCache.PutCache(paramDTO, euofreftp_flag, emsDOMatch);
		return getEmsMatchRstDTO(emsDOMatch);
	}
	
	/**
	 * 匹配服务项
	 * @param emsRelSrvDOs
	 * @param emsDO
	 * @return
	 */
	private EmsDO matchEmsRelSrvDOs(String sdsrvtp, String idsrv, EmsRelSrvDO[] emsRelSrvDOs, EmsDO emsDO){
		String eu_ofreftp = "";
		EmsDO emsDOMatch = null;
		for (EmsRelSrvDO emsRelSrvDO : emsRelSrvDOs) {
			if ("0".equals(emsRelSrvDO.getEu_ofreftp())) {
				if (!"1".equals(euofreftp_flag) && !"1".equals(eu_ofreftp)) {
					if (sdsrvtp.equals(emsRelSrvDO.getSd_srvtp())) {
						euofreftp_flag = eu_ofreftp = "0";
						sdsrvtp_flag = sdsrvtp;
						emsDOMatch = emsDO;
					} else if (sdsrvtp.startsWith(emsRelSrvDO.getSd_srvtp())
							&& sdsrvtp_flag.length() <= emsRelSrvDO.getSd_srvtp().length()) {
						euofreftp_flag = eu_ofreftp = "0";
						sdsrvtp_flag = sdsrvtp;
						emsDOMatch = emsDO;
					}
				}
			} else if ("1".equals(emsRelSrvDO.getEu_ofreftp())) {
				if (idsrv.equals(emsRelSrvDO.getId_srv())) {
					euofreftp_flag = eu_ofreftp = "1";
					emsDOMatch = emsDO;
					break;
				}
			}
		}
		return emsDOMatch;
	}

	/**
	 * 放入缓存
	 * @param emsDO
	 */
//	private void putCache(EmsDO emsDO, SrvMatchEmsParamDTO paramDTO){
//		if (emsDO != null) {
//			String key = paramDTO.getId_org() + "|" + paramDTO.getId_grp() + "|" + paramDTO.getCode_entp() + "|" + emsDO.getSd_srvorrt() + "|";
//			switch (emsDO.getSd_srvorrt()) {
//			case IBdSrvDictCodeConst.SD_OWTP_PERSONAL:
//				key += paramDTO.getId_emp();
//				break;
//			case IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT:
//				key += paramDTO.getId_dept();
//				break;
//			case IBdSrvDictCodeConst.SD_OWTP_HOSPIAL:
//				key += "~";
//				break;
//			}
//
//			if ("0".equals(euofreftp_flag)) {
//				key += "|" + paramDTO.getSd_srvtp() + "|~";
//			} else if ("1".equals(euofreftp_flag)) {
//				key += "|~|" + paramDTO.getId_srv();
//			}
//
//			
//			putCache(L2SessionKeyWith(EmsReg_Cache_key), key, emsDO);
//			euofreftp_flag = "";
//		}
//	}

	/**
	 * 根据就诊类型获取适用类型
	 * @param sdentp
	 * @param emsDO
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private boolean getFgentp(EmsDO emsDO, String sdentp) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		String methodname = "getFg_entp";
		switch (sdentp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			methodname += "_op";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
			methodname += "_er";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
			methodname += "_er1";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
			methodname += "_er2";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			methodname += "_ip";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE:
			methodname += "_pip";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			methodname += "_fm";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			methodname += "_pe";
			break;
		}

		Class<?> clazz = emsDO.getClass();
		java.lang.reflect.Method method = clazz.getDeclaredMethod(methodname);
		return method.invoke(emsDO) != null && ((FBoolean) method.invoke(emsDO)).booleanValue();
	}
	
	/**
	 * 根据匹配的EmsDO获取EmsMatchRstDTO
	 * @param emsDO
	 * @return
	 */
	private SrvMatchEmsRstDTO getEmsMatchRstDTO(EmsDO emsDO){
		if (emsDO == null)
			return null;
		SrvMatchEmsRstDTO dto = new SrvMatchEmsRstDTO();
		dto.setId_ems(emsDO.getId_srvof());
		dto.setName_show(emsDO.getName_show());
		try {
			dto.setFuncclassstr(StringCodingUtils.Utf8_Base64_Encode(emsDO.getFunclassstr()));
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setFg_quickwflow(emsDO.getFg_quickwflow());

		return dto;
	}
}
