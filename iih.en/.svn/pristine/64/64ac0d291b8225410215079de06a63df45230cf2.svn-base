package iih.en.pv.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnEmrDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 获取病人就诊信息
 * 
 * @author liu bin
 */
public class GetEntInfoList4MrBP {

	/**
	 * 获取病人就诊信息
	 * 
	 * @param id_pat
	 * @param code_entp
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public EnEmrDTO[] exec(String patId, String codeEntp , String entId) throws BizException {
		if((EnValidator.isEmpty(patId)||"%".equals(patId))&&(EnValidator.isEmpty(entId)||"%".equals(entId))){
			return null;
		}
		List<PatiVisitDO> patiDOlist = getPatiVisitDO(patId, codeEntp, entId);
		if(EnValidator.isEmpty(patiDOlist)){
			return null;
		}
		Set<String> opEntIds = new HashSet<>();
		Set<String> ipEntIds = new HashSet<>();
		Set<String> ipPatIds = new HashSet<>();
		for (PatiVisitDO patiDO : patiDOlist) {
			ipPatIds.add(patiDO.getId_pat());
			if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(patiDO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(patiDO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(patiDO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(patiDO.getCode_entp())){
				opEntIds.add(patiDO.getId_ent());
				continue;
			}
			if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(patiDO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(patiDO.getCode_entp())){
				ipEntIds.add(patiDO.getId_ent());
				continue;
			}
		}
		GetEntInfo4MrBP enEmrBp = new GetEntInfo4MrBP();
		Set<EnEmrDTO> enEmrSet = new HashSet<>();
		if(opEntIds.size()>0){
			EnEmrDTO[] enEmrs = enEmrBp.getOpEnEmrDTO(opEntIds.toArray(new String[0]));
			if(!EnValidator.isEmpty(enEmrs)){
				List<EnEmrDTO> list =  filterBySdStatus(enEmrs);
				enEmrSet.addAll(list);
			}
		}
		if(ipEntIds.size()>0){
			EnEmrDTO[] enEmrs = enEmrBp.getIpEnEmrDTO(ipEntIds.toArray(new String[0]));
			if(!EnValidator.isEmpty(enEmrs)){
				List<EnEmrDTO> list =  filterBySdStatus(enEmrs);
				enEmrSet.addAll(list);
			}
		}
		if(enEmrSet.size() > 0){
			PatiAddrDO[] patiAddrDOs = enEmrBp.getPatiAddrDO(ipPatIds.toArray(new String[0]));
			UdidocDO[] udidocDOs = enEmrBp.getUdidocDOs();
			//加上地址和自定义档案
			EnEmrDTO[] enEmrs = enEmrBp.addAddrAndUdi4EnEmrDTO(enEmrSet.toArray(new EnEmrDTO[0]), patiAddrDOs, udidocDOs);
			if(!EnValidator.isEmpty(enEmrs)){
				Arrays.sort(enEmrs, new Comparator<EnEmrDTO>() {
					@Override
					public int compare(EnEmrDTO o1, EnEmrDTO o2) {
						return -(o1.getDt_entry().compareTo(o2.getDt_entry()));
					}
				});
				return enEmrs;
			}
		}
		return null;
	}
	
	private List<PatiVisitDO> getPatiVisitDO(String patId, String codeEntp , String entId) throws BizException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EN.* ");
		builder.append("FROM EN_ENT EN ");
		builder.append("WHERE EN.FG_CANC = 'N' ");
		builder.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		if(EnValidator.isEmpty(codeEntp)||"%".equals(codeEntp)){
			
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(codeEntp)){
			builder.append(String.format("AND EN.CODE_ENTP = '%s' ", IBdFcDictCodeConst.SD_CODE_ENTP_OP));
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(codeEntp)){
			builder.append(String.format("AND EN.CODE_ENTP = '%s' ", IBdFcDictCodeConst.SD_CODE_ENTP_IP));
		}
		if(!EnValidator.isEmpty(patId)&&!("%".equals(patId))){
			builder.append(String.format("AND EN.ID_PAT = '%s' ", patId));
		}
		if(!EnValidator.isEmpty(entId)&&!("%".equals(entId))){
			builder.append(String.format("AND EN.ID_ENT = '%s' ", entId));
		}
		String sql = builder.toString();
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sql, new BeanListHandler(PatiVisitDO.class));
		return list;
	}
	
	/**
	 * 过滤有效就诊 SdStatus为05 08 25 28的
	 * @param emrDTOs
	 * @return
	 */
	private List<EnEmrDTO> filterBySdStatus(EnEmrDTO[] emrDTOs){
		List<EnEmrDTO> list = new ArrayList<>();
		for (EnEmrDTO dto : emrDTOs) {
			if(dto != null && !StringUtil.isEmpty(dto.getSd_status()) && 
					(dto.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER) 
					|| dto.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH) 
					|| dto.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN)
					|| dto.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT))){
				list.add(dto);
			}
		}
		return list;
	}
}
