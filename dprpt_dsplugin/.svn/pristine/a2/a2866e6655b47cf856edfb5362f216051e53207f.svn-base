package iih.ci.ord.ciordsheet;

import iih.ci.ord.printmanage.dto.UtilsDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

/**
 * 医嘱服务内容拼接格式配置
 * @author Young
 *
 */
public class CiOrdSheetContentCfgUtils {

	/**
	 * 非成组西药医嘱服务内容拼接（商品打印名称  单次剂量+剂量单位,用法,频次,嘱托）
	 * @param dto
	 * @return
	 */
	public static String getOrSrvContent4Drug(CiOrdSheetDTO dto) {
		String name_prn = ("Y".equals(dto.getFg_self()) ? "(自备)" : "") + dto.getName_prn();
		String name_route = dto.getRoute_name();
		String name_freq = dto.getFreq_name();
		String des_or = dto.getDes_or();
		return name_prn + dto.getQuan_medu() + dto.getMedu_name()
				+ (!StringUtils.isNullOrEmpty(name_route) ? "," + name_route : "")
				+ ("Y".equals(dto.getFg_long()) && !StringUtils.isNullOrEmpty(name_freq) ? "," + name_freq : "")
				+ (!StringUtils.isNullOrEmpty(des_or) ? "," + des_or : "");
	}
	
	/**
	 * 成组西药医嘱服务级别内容拼接（商品打印名称  单次剂量+剂量单位）
	 * @param dto
	 * @return
	 */
	public static String getOrSrvContent4Drugs(CiOrdSheetDTO dto) {
		String name_prn = ("Y".equals(dto.getFg_self()) ? "(自备)" : "") + dto.getName_prn();
		return name_prn + dto.getQuan_medu() + dto.getMedu_name();
	}
	
	/**
	 * 成组西药医嘱级别内容拼接（用法,频次,嘱托）
	 * @param dto
	 * @return
	 */
	public static String getOrContent4Drugs(CiOrdSheetDTO dto) {
		String name_route = dto.getRoute_name();
		String name_freq = dto.getFreq_name();
		String des_or = dto.getDes_or();
		return (!StringUtils.isNullOrEmpty(name_route) ? name_route : "")
				+ ("Y".equals(dto.getFg_long()) && !StringUtils.isNullOrEmpty(name_freq) ? "," + name_freq : "")
				+ (!StringUtils.isNullOrEmpty(des_or) ? "," + des_or : "");
	}
	
	/**
	 * 非成组诊疗医嘱服务内容拼接（服务名称  单次剂量+剂量单位,频次,嘱托）
	 * @param dto
	 * @return
	 */
	public static String getOrSrvContent4Treat(CiOrdSheetDTO dto) {
		String quan_medu = "Y".equals(dto.getFg_selfsrv()) ? "" : dto.getQuan_medu();
		String name_medu = dto.getMedu_name();
		String name_freq = dto.getFreq_name();
		String des_or = dto.getDes_or();
		return dto.getName_srv()
				+ (!StringUtils.isNullOrEmpty(quan_medu) ? quan_medu : "")
				+ (!StringUtils.isNullOrEmpty(name_medu) ? name_medu : "")
				+ (!StringUtils.isNullOrEmpty(name_freq) ? "," + name_freq : "")
				+ (!StringUtils.isNullOrEmpty(des_or) ? "," + des_or : "");
	}
	
	/**
	 * 成组诊疗医嘱服务内容拼接（服务名称  单次剂量+剂量单位）
	 * @param dto
	 * @return
	 */
	public static String getOrSrvContent4Treats(CiOrdSheetDTO dto) {
		String quan_medu = "Y".equals(dto.getFg_selfsrv()) ? "" : dto.getQuan_medu();
		String name_medu = "Y".equals(dto.getFg_selfsrv()) ? "" : dto.getMedu_name();
		return dto.getName_srv()
				+ (!StringUtils.isNullOrEmpty(quan_medu) ? quan_medu : "")
				+ (!StringUtils.isNullOrEmpty(name_medu) ? name_medu : "");
	}
	/**
	 * 成组诊疗医嘱服务内容拼接（频次,嘱托）
	 * @param dto
	 * @return
	 */
	public static String getOrContent4Treats(CiOrdSheetDTO dto) {
		String name_freq = dto.getFreq_name();
		String des_or = dto.getDes_or();
		return (!StringUtils.isNullOrEmpty(name_freq) ? name_freq : "")
				+ (!StringUtils.isNullOrEmpty(des_or) ? "," + des_or : "");
	}
	
	/**
	 * 检查部位拼接
	 * @param idors_ris_set
	 * @param idors_ris
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> getRisBodyName(String[] idors_ris_set, String[] idors_ris) 
			throws Exception{
		Map<String, String> mapBodyNames = new HashMap<String, String>();
		if (idors_ris_set.length > 0) {
			List<UtilsDTO> lstBodyNames = CiorderPrintUtils.getRisBodyName(idors_ris_set, true);
			if (lstBodyNames != null && lstBodyNames.size() > 0) {
				for (UtilsDTO utilsDTO : lstBodyNames) {
					if (utilsDTO.getDef2() != null) {
						mapBodyNames.put(utilsDTO.getDef1(), utilsDTO.getDef2());
					}
				}
			}
		}
		if (idors_ris.length > 0) {
			List<UtilsDTO> lstBodyNames = CiorderPrintUtils.getRisBodyName(idors_ris, false);
			if (lstBodyNames != null && lstBodyNames.size() > 0) {
				for (UtilsDTO utilsDTO : lstBodyNames) {
					if (utilsDTO.getDef2() != null) {
						mapBodyNames.put(utilsDTO.getDef1(), utilsDTO.getDef2());
					}
				}
			}
		}
		return mapBodyNames;
	}

	/**
	 * 检验医嘱服务内容拼接
	 * @param dto
	 * @return
	 */
	public static String getOrSrvContent4Lis(CiOrdSheetDTO dto) {
		String des_or = dto.getDes_or();
		return dto.getName_srv() + (!StringUtils.isNullOrEmpty(des_or) ? "(" + des_or + ")" : "");
	}
	
	/**
	 * 手术医嘱服务内容拼接
	 * @param dto
	 * @return
	 */
	public static String getOrSrvContent4Opr(CiOrdSheetDTO dto) {
		String des_or = dto.getDes_or();
		return dto.getName_srv() + (!StringUtils.isNullOrEmpty(des_or) ? "(" + des_or + ")" : "");
	}
	
	/**
	 * 卫材医嘱服务内容拼接
	 * @param dto
	 * @return
	 */
	public static String getOrSrvContent4Sani(CiOrdSheetDTO dto) {
		String quan_medu = dto.getQuan_medu();
		String name_medu = dto.getMedu_name();
		String des_or = dto.getDes_or();
		return dto.getName_srv() 
				+ (!StringUtils.isNullOrEmpty(quan_medu) ? quan_medu : "")
				+ (!StringUtils.isNullOrEmpty(name_medu) ? name_medu : "")
				+ (!StringUtils.isNullOrEmpty(des_or) ? "(" + des_or + ")" : "");
	}
	
	/**
	 * 血医嘱服务内容拼接
	 * @param dto
	 * @return
	 */
	public static String getOrSrvContent4Blood(CiOrdSheetDTO dto) {
		String quan_medu = dto.getQuan_medu();
		String name_medu = dto.getMedu_name();
		String des_or = dto.getDes_or();
		return dto.getName_srv() 
				+ (!StringUtils.isNullOrEmpty(quan_medu) ? quan_medu : "")
				+ (!StringUtils.isNullOrEmpty(name_medu) ? name_medu : "")
				+ (!StringUtils.isNullOrEmpty(des_or) ? "(" + des_or + ")" : "");
	}
	
	/**
	 * 嘱托医嘱服务内容拼接
	 * @param dto
	 * @return
	 */
	public static String getOrSrvContent4Entrust(CiOrdSheetDTO dto) {
		String des_or = dto.getDes_or();
		return "(嘱托)" + dto.getName_srv()
				+ (!StringUtils.isNullOrEmpty(des_or) ? "(" + des_or + ")" : "");
	}

	/**
	 * 护理医嘱服务内容拼接
	 * @param dto
	 * @return
	 */
	public static String getOrSrvContent4Nurse(CiOrdSheetDTO dto) {
		String des_or = dto.getDes_or();
		return dto.getName_srv() + (!StringUtils.isNullOrEmpty(des_or) ? "(" + des_or + ")" : "");
	}
}
