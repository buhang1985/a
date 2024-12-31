package iih.ci.mrfp.dto.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import iih.ci.mr.cimrsource.i.ICimrsourceRService;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpZYDiDTO;
import iih.ci.mrfp.dto.i.CiMrFpService;
import iih.ci.ord.i.external.provide.ICiOrdIpPartnerService;
import iih.en.pv.dto.d.IpDetailDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.dto.d.EntForMedRecDTO;
import iih.pi.reg.dto.d.PatiInfoForMrDTO;
import iih.pi.reg.i.IPiRegQryService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap2;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院病案首页 实现
 * 
 * @author 杨建兵
 *
 */
@Service(serviceInterfaces = { CiMrFpService.class }, binding = Binding.JSONRPC)
public class CiMrFpServiceImpl implements CiMrFpService {

	@Override
	public PatiInfoForMrDTO getPatiInfoForMrDTO(String idPat, String idEnt) throws BizException {
		IPiRegQryService piRegQryService = ServiceFinder.find(IPiRegQryService.class);
		PatiInfoForMrDTO patiInfoForMrDTO = piRegQryService.getPatiInfoForMedicalRecord(idPat);// 刘羽处查询的相关信息数据
		// 单独查询患者的联系人信息并赋值
		IEnOutQryService enOutQryService = ServiceFinder.find(IEnOutQryService.class);
		IpDetailDTO entForMedRecDTO = enOutQryService.getIpDetailInfo(idEnt);

		patiInfoForMrDTO.setName_cont(entForMedRecDTO.getCont_name());
		patiInfoForMrDTO.setAddr_cont(entForMedRecDTO.getCont_address());
		patiInfoForMrDTO.setTel_cont(entForMedRecDTO.getCont_tel());
		patiInfoForMrDTO.setId_conttp(entForMedRecDTO.getId_conttp());
		patiInfoForMrDTO.setSd_conttp(entForMedRecDTO.getSd_conttp());
		patiInfoForMrDTO.setName_conttp(entForMedRecDTO.getName_conttp());
		return patiInfoForMrDTO;
	}

	@Override
	public EntForMedRecDTO getEntForMedRecDTO(String idEnt) throws BizException {
		IEnOutQryService enOutQryService = ServiceFinder.find(IEnOutQryService.class);
		EntForMedRecDTO entForMedRecDTO = enOutQryService.getEntInfo4firstPage(idEnt);// 颜刊处提供dto数据
		return entForMedRecDTO;
	}

	@Override
	public IpDetailDTO getIpDetailInfo(String idEnt) throws BizException {
		IEnOutQryService enOutQryService = ServiceFinder.find(IEnOutQryService.class);
		IpDetailDTO entForMedRecDTO = enOutQryService.getIpDetailInfo(idEnt);// 颜刊处提供dto数据
		return entForMedRecDTO;
	}

	/**
	 * 从医嘱中查询患者的护理天数 -by Vampire
	 */
	public FMap2 getNurDaysInfo(String idEnt) throws BizException {
		ICiOrdIpPartnerService iCiOrdIpPartnerService = ServiceFinder.find(ICiOrdIpPartnerService.class);
		Map<String, Integer> map = iCiOrdIpPartnerService.getNursingDays(idEnt);
		// 将查询的护理天数封装到FMap2中，返回
		FMap2 result = new FMap2();
		Set<Entry<String, Integer>> entrySet = map.entrySet();

		for (Entry<String, Integer> entry : entrySet) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	/**
	 * 从病历元内容查询患者的病案首页手术
	 */
	@Override
	public CiMrFpSugDTO[] getCiMrFpSugDTO(String idEnt) throws BizException {	
		DAFacade da = new DAFacade();
		String whereStr = "select CI.ID_CI_MR_SOU as ID_CI_MR_SOU,CI.ID_MR as ID_MR,"
				+ "CI.NAME_SOU as NAME_SOU,CI.NAME_PRO as NAME_PRO,CI.CONTENT as CONTENT,"
				+ "CI.DS as DS,CI.SV as SV ,CI.Refcontent as Refcontent from ci_mr_source ci"
				+ " LEFT JOIN ci_mr cr on ci.id_mr = cr.id_mr"
				+ " LEFT JOIN bd_mrtp bm on cr.id_mrtp = bm.id_mrtp where bm.code = ? "
				+ "and cr.sd_su_mr = ? and cr.id_ent = ?";
		SqlParam param = new SqlParam();
		param.addParam(ICiMrDictCodeConst.CD_MRTYPE_SHOUSHU);
		param.addParam(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
		param.addParam(idEnt);
		ArrayList<CiMrSourceDO> ciMrSourceDOs = (ArrayList<CiMrSourceDO>) da.execQuery(whereStr.toString(), param,
				new BeanListHandler(CiMrSourceDO.class));

		Map<String, CiMrFpSugDTO> map = new HashMap<>();
		for (CiMrSourceDO ciMrSourceDO : ciMrSourceDOs) {
			String id_mr = ciMrSourceDO.getId_mr();
			CiMrFpSugDTO ciMrFpSugDTO = map.get(id_mr);
			if (ciMrFpSugDTO == null) {
				ciMrFpSugDTO = new CiMrFpSugDTO();
				ciMrFpSugDTO.setStatus(DOStatus.NEW);
				map.put(id_mr, ciMrFpSugDTO);
			}
			String name_pro = ciMrSourceDO.getName_pro();
			String refcontent = ciMrSourceDO.getRefcontent();
			String[] valueArr = new String[3];
			switch (name_pro) {
			case "手术操作名称":
				valueArr = getValueArr(refcontent);
				ciMrFpSugDTO.setId_sug(valueArr[0]);
				ciMrFpSugDTO.setSd_sug(valueArr[1]);
				ciMrFpSugDTO.setName_sug(valueArr[2]);
				break;
			case "手术级别":
				valueArr = getValueArr(refcontent);
				ciMrFpSugDTO.setId_lvlsug(valueArr[0]);
				ciMrFpSugDTO.setSd_lvlsug(valueArr[1]);
				ciMrFpSugDTO.setName_lvlsug(valueArr[2]);
				break;
			case "手术开始时间":
				ciMrFpSugDTO.setDt_start_sug(new FDateTime(ciMrSourceDO.getContent()));
				break;
			case "手术结束时间":
				ciMrFpSugDTO.setDt_end_sug(new FDateTime(ciMrSourceDO.getContent()));
				break;
			case "手术方式":
				valueArr = getValueArr(refcontent);
				ciMrFpSugDTO.setId_method_sug(valueArr[0]);
				ciMrFpSugDTO.setSd_method_sug(valueArr[1]);
				ciMrFpSugDTO.setName_method_sug(valueArr[2]);
				break;
			case "术者":
				valueArr = getValueArr(refcontent);
				ciMrFpSugDTO.setId_emp_sug(valueArr[0]);
				ciMrFpSugDTO.setSd_emp_sug(valueArr[1]);
				ciMrFpSugDTO.setName_emp_sug(valueArr[2]);
				break;
			case "助手1":
				valueArr = getValueArr(refcontent);
				ciMrFpSugDTO.setId_emp_asst1(valueArr[0]);
				ciMrFpSugDTO.setSd_emp_asst1(valueArr[1]);
				ciMrFpSugDTO.setName_emp_asst1(valueArr[2]);
				break;
			case "助手2":
				valueArr = getValueArr(refcontent);
				ciMrFpSugDTO.setId_emp_asst2(valueArr[0]);
				ciMrFpSugDTO.setSd_emp_asst2(valueArr[1]);
				ciMrFpSugDTO.setName_emp_asst2(valueArr[2]);
				break;
			case "切口愈合等级":
				valueArr = getValueArr(refcontent);
				ciMrFpSugDTO.setId_incicondi(valueArr[0]);
				ciMrFpSugDTO.setSd_incicondi(valueArr[1]);
				ciMrFpSugDTO.setName_incicondi(valueArr[2]);
				break;
			case "麻醉方式":
				valueArr = getValueArr(refcontent);
				ciMrFpSugDTO.setId_anestp(valueArr[0]);
				ciMrFpSugDTO.setSd_anestp(valueArr[1]);
				ciMrFpSugDTO.setName_anestp(valueArr[2]);
				break;
			case "麻醉医师":
				valueArr = getValueArr(refcontent);
				ciMrFpSugDTO.setId_emp_anes(valueArr[0]);
				ciMrFpSugDTO.setSd_emp_anes(valueArr[1]);
				ciMrFpSugDTO.setName_emp_anes(valueArr[2]);
				break;
			}
		}
		Collection<CiMrFpSugDTO> values = map.values();
		return values.toArray(new CiMrFpSugDTO[values.size()]);
	}

	public String[] getValueArr(String arr) {
		String[] split = arr.split("\\|");
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			string = string.substring(string.indexOf(":") + 1);
			split[i] = string;
		}
		return split;
	}
}
