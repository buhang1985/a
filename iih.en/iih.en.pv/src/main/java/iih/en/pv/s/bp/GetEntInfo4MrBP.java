package iih.en.pv.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnEmrDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.ip.CalculateHosDaysBP;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.i.IPatiAddrDORService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 获取病历就诊信息
 * 
 * @author liubin
 */
public class GetEntInfo4MrBP {

	// TODO 这些常量是否可放到相应的域
	// 性别类别
	private static final String UDITYPE_SEX_CODE = "PI.PI.0515";
	// 婚姻状况
	private static final String UDITYPE_MARI_CODE = "PI.PI.0520";
	// 护理等级
	private static final String UDITYPE_NUR_LEVEL_CODE = "EN.EN.0550";
	// 营养等级
	private static final String UDITYPE_NUTR_LEVEL_CODE = "EN.EN.0560";
	// 门诊病情等级
	private static final String UDITYPE_OP_DISE_CODE = "EN.OP.0546";
	// 住院病情等级
	private static final String UDITYPE_IP_DISE_CODE = "EN.EN.0555";
	// 新生儿离院转归
	private static final String UDITYPE_OUTCOMES_CODE = "EN.BBY.0565";
	// 门诊离院转归
	private static final String UDITYPE_OP_GOWHERE_CODE = "EN.OP.0545";
	// 住院离院转归
	private static final String UDITYPE_IP_GOWHERE_CODE = "EN.IP.1005";
	// 住院来院方式
	private static final String UDITYPE_REFERALSRC_CODE = "EN.IP.0570";

	/**
	 * 获取病历就诊信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnEmrDTO exec(String entId) throws BizException {
		// 验证entId是否为空
		if (EnValidator.isEmpty(entId)) {
			return null;
		}
		PvEP ep = new PvEP();
		PatiVisitDO patiVisitDO = ep.getPvByPK(entId);
		// 验证是否查到数据
		if (EnValidator.isEmpty(patiVisitDO)) {
			return null;
		}
		EnEmrDTO[] enEmrDTOs = null;
		if (!EnValidator.isEmpty(patiVisitDO.getCode_entp())) {
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(patiVisitDO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(patiVisitDO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(patiVisitDO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(patiVisitDO.getCode_entp())) {
				enEmrDTOs = getOpEnEmrDTO(new String[] { entId });// 门急诊
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(patiVisitDO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(patiVisitDO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(patiVisitDO.getCode_entp())) {
				// 住院、预住院、急诊留观 
				enEmrDTOs = getIpEnEmrDTO(new String[] { entId });
			}
		}
		if (!EnValidator.isEmpty(enEmrDTOs)) {
			PatiAddrDO[] patiAddrDOs = getPatiAddrDO(new String[] { patiVisitDO.getId_pat() });
			UdidocDO[] udidocDOs = getUdidocDOs();
			// 加上地址和自定义档案
			enEmrDTOs = addAddrAndUdi4EnEmrDTO(enEmrDTOs, patiAddrDOs, udidocDOs);
			if (!EnValidator.isEmpty(enEmrDTOs)) {
				return enEmrDTOs[0];
			}
		}
		return null;
	}

	/**
	 * 得到门诊的病历信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnEmrDTO[] getOpEnEmrDTO(String[] entIds) throws BizException {
		if (!EnValidator.isEmpty(entIds)) {
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT DISTINCT ");
			builder.append("EN.ID_ENT AS ID_ENT,");
			builder.append("EN.CODE AS CODE,");
			builder.append("EN.CODE_ENTP AS CODE_ENTP,");
			builder.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
			builder.append("EN.TELNO_PAT AS TELNO_PAT,");
			builder.append("EN.ADDR_PAT AS ADDR_PAT,");
			builder.append("EN.DT_ENTRY AS DT_ENTRY,");
			builder.append("EN.DT_ACPT AS DT_ACPT,");
			builder.append("EN.DT_END AS DT_END,");
			builder.append("EN.ID_PAT AS ID_PAT,");
			builder.append("EN.NAME_PAT AS PAT_NAME,");
			builder.append("EN.ID_SEX_PAT AS ID_SEX,");
			builder.append("EN.ID_MARI_PAT AS ID_MARI_PAT,");
			builder.append("EN.ID_DEP_NUR AS ID_DEP_NUR,");
			builder.append("EN.ID_WG_PHY AS ID_WG_PHY,");
			builder.append("EN.ID_DEP_PHY AS ID_DEP_PHY,");
			builder.append("PHYDEP.CODE AS DEP_PHY_CODE,");
			builder.append("PHYDEP.NAME AS DEP_PHY_NAME,");
			builder.append("EN.FG_IP AS FG_IP,");
			builder.append("EN.ID_EMP_PHY AS ID_EMP_PHY,");
			builder.append("SUPHY.ID_USER AS ID_PHY,");
			builder.append("SUPHY.CODE AS EMP_PHY_CODE,");
			builder.append("SUPHY.NAME AS EMP_PHY_NAME,");
			builder.append("OP.FG_FIRST,");
			builder.append("OP.ID_LEVEL_DISE AS ID_LEVEL_DISE,");
			builder.append("OP.ID_GOWHERE AS ID_GOWHERE,");
			builder.append("OP.SD_GOWHERE AS SD_GOWHERE,");
			builder.append("OP.SD_STATUS AS SD_STATUS,");
			builder.append("PAT.WORKUNIT AS WORKUNIT,");
			builder.append("DI.ID_DIDEF_DIS AS ID_MAIN_DI,");
			builder.append("DI.NAME_DIDEF_DIS AS MAIN_DI_NAME ");
			builder.append("FROM EN_ENT EN ");
			builder.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
			builder.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
			builder.append("LEFT JOIN BD_DEP PHYDEP ON EN.ID_DEP_PHY = PHYDEP.ID_DEP ");
			builder.append("LEFT JOIN SYS_USER SUPHY ON EN.ID_EMP_PHY = SUPHY.ID_PSN AND ISNULL(EN.ID_EMP_PHY,'~')<>'~' ");
			builder.append("LEFT JOIN EN_ENT_DI DI ON EN.ID_ENT = DI.ID_ENT AND DI.FG_MAJ = 'Y' ");
			builder.append(" WHERE ").append(EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds));
			builder.append(" ORDER BY EN.DT_ENTRY DESC ");
			String sql = builder.toString();
			List<EnEmrDTO> list = (List<EnEmrDTO>) new DAFacade().execQuery(sql,
					new BeanListHandler(EnEmrDTO.class));
			if (!EnValidator.isEmpty(list)) {
				return list.toArray(new EnEmrDTO[0]);
			}
		}
		return null;
	}

	/**
	 * 得到住院的病历信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnEmrDTO[] getIpEnEmrDTO(String[] entIds) throws BizException {
		if (!EnValidator.isEmpty(entIds)) {
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT DISTINCT ");
			builder.append("EN.ID_ENT AS ID_ENT,");
			builder.append("EN.CODE AS CODE,");
			builder.append("EN.CODE_ENTP AS CODE_ENTP,");
			builder.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
			builder.append("EN.TELNO_PAT AS TELNO_PAT,");
			builder.append("EN.ADDR_PAT AS ADDR_PAT,");
			builder.append("EN.DT_ENTRY AS DT_ENTRY,");
			builder.append("EN.DT_ACPT AS DT_ACPT,");
			builder.append("EN.DT_END AS DT_END,");
			builder.append("EN.ID_PAT AS ID_PAT,");
			builder.append("EN.NAME_PAT AS PAT_NAME,");
			builder.append("EN.ID_SEX_PAT AS ID_SEX,");
			builder.append("EN.ID_MARI_PAT AS ID_MARI_PAT,");
			builder.append("EN.ID_WG_PHY AS ID_WG_PHY,");
			builder.append("WG.CODE AS WG_PHY_CODE,");
			builder.append("WG.NAME AS WG_PHY_NAME,");
			builder.append("EN.ID_DEP_PHY AS ID_DEP_PHY,");
			builder.append("PHYDEP.CODE AS DEP_PHY_CODE,");
			builder.append("PHYDEP.NAME AS DEP_PHY_NAME,");
			builder.append("EN.ID_DEP_NUR AS ID_DEP_NUR,");
			builder.append("NURDEP.CODE AS DEP_NUR_CODE,");
			builder.append("NURDEP.NAME AS DEP_NUR_NAME,");
			builder.append("EN.FG_IP AS FG_IP,");
			builder.append("EN.ID_EMP_PHY AS ID_EMP_PHY,");
			builder.append("SUPHY.ID_USER AS ID_PHY,");
			builder.append("SUPHY.CODE AS EMP_PHY_CODE,");
			builder.append("SUPHY.NAME AS EMP_PHY_NAME,");
			builder.append("EN.ID_EMP_NUR AS ID_EMP_NUR,");
			builder.append("SUNUR.ID_USER AS ID_NUR,");
			builder.append("SUNUR.CODE AS EMP_NUR_CODE,");
			builder.append("SUNUR.NAME AS EMP_NUR_NAME,");
			builder.append("IP.CODE_AMR_IP AS HOSPITAL_CODE,");
			builder.append("IP.ID_BED AS ID_BED,");
			builder.append("IP.NAME_BED AS BED_NAME,");
			builder.append("BED.CODE BED_CODE, ");
			builder.append("BED.ROOM, ");
			builder.append("IP.ID_LEVEL_NUR AS ID_LEVEL_NUR,");
			builder.append("IP.ID_LEVEL_NUTR AS ID_LEVEL_NUTR,");
			builder.append("IP.FG_NEWBORN AS FG_NEWBORN,");
			builder.append("IP.NUM_NEWBORN AS NUM_NEWBORN,");
			builder.append("IP.ID_GOWHERE AS ID_GOWHERE,");
			builder.append("IP.SD_GOWHERE AS SD_GOWHERE,");
			builder.append("IP.ID_LEVEL_DISE AS ID_LEVEL_DISE,");
			builder.append("IP.SD_STATUS AS SD_STATUS,");
			builder.append("IP.ID_OUTCOMES AS ID_OUTCOMES,");
			builder.append("IP.ID_REFERALSRC AS ID_REFERALSRC,");
			builder.append("IP.ID_PATCONT AS ID_PATCONT,");
			builder.append("IP.CONT_NAME AS CONT_NAME,");
			builder.append("IP.CONT_TEL AS CONT_TEL,");
			builder.append("IP.FG_SURG AS FG_SURG,");
			builder.append("IP.TIMES_IP AS IP_TIMES,");
			builder.append("IP.ID_DEP_PHYDISC AS ID_DEP_PHYDISC,");
			builder.append("IP.ID_DEP_NURDISC AS ID_DEP_NURDISC,");
			builder.append("IP.ID_DEP_PHYADM AS ID_DEP_PHYADM,");
			builder.append("PHYADM.NAME AS DEP_PHYADM_NAME,");
			builder.append("IP.ID_DEP_NURADM AS ID_DEP_NURADM,");
			builder.append("NURADM.CODE AS DEP_NURADM_CODE,");
			builder.append("NURADM.NAME AS DEP_NURADM_NAME,");
			builder.append("PAT.WORKUNIT AS WORKUNIT,");
			builder.append("DI.ID_DIDEF_DIS AS ID_MAIN_DI,");
			builder.append("DI.NAME_DIDEF_DIS AS MAIN_DI_NAME ");
			builder.append("FROM EN_ENT EN ");
			builder.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
			builder.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
			builder.append("LEFT JOIN BD_WG WG ON EN.ID_WG_PHY = WG.ID_WG  ");
			builder.append("LEFT JOIN BD_DEP PHYDEP ON EN.ID_DEP_PHY = PHYDEP.ID_DEP ");
			builder.append("LEFT JOIN BD_DEP NURDEP ON EN.ID_DEP_NUR = NURDEP.ID_DEP ");
			builder.append("LEFT JOIN BD_DEP PHYADM ON IP.ID_DEP_PHYADM = PHYADM.ID_DEP ");
			builder.append("LEFT JOIN BD_DEP NURADM ON IP.ID_DEP_NURADM = NURADM.ID_DEP ");
			builder.append("LEFT JOIN BD_BED BED ON IP.ID_BED = BED.ID_BED ");
			builder.append("LEFT JOIN SYS_USER SUPHY ON EN.ID_EMP_PHY = SUPHY.ID_PSN AND ISNULL(EN.ID_EMP_PHY,'~')<>'~' ");
			builder.append("LEFT JOIN SYS_USER SUNUR ON EN.ID_EMP_NUR = SUNUR.ID_PSN AND ISNULL(EN.ID_EMP_NUR,'~')<>'~' ");
			builder.append("LEFT JOIN EN_ENT_DI DI ON EN.ID_ENT = DI.ID_ENT AND DI.FG_MAJ = 'Y' ");
			builder.append("WHERE ").append(EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds));;
			builder.append("ORDER BY EN.DT_ENTRY DESC ");
			String sql = builder.toString();
			List<EnEmrDTO> list = (List<EnEmrDTO>) new DAFacade().execQuery(sql,
					new BeanListHandler(EnEmrDTO.class));
			if (EnValidator.isEmpty(list))
				return null;
			//设置主治医生
			this.setZzPsn(list, entIds);
			//设置主任医生
			this.setZrPsn(list, entIds);
			
			return list.toArray(new EnEmrDTO[0]);
		}
		return null;
	}

	/**
	 * 为EnEmrDTO加上地址信息和自定义档案
	 * 
	 * @param emrDTOs
	 * @param patiAddrDOs
	 * @param udidocDOs
	 * @return
	 * @throws BizException 
	 */
	public EnEmrDTO[] addAddrAndUdi4EnEmrDTO(EnEmrDTO[] emrDTOs, PatiAddrDO[] patiAddrDOs,
			UdidocDO[] udidocDOs) throws BizException {
		if (!EnValidator.isEmpty(emrDTOs)) {
			for (EnEmrDTO emrDTO : emrDTOs) {
				// 加上地址信息
				emrDTO = this.addAddress4EnEmrDTO(emrDTO, patiAddrDOs);
				// 加上自定义档案
				emrDTO = this.addUdidoc4EnEmrDTO(emrDTO, udidocDOs);
				// 计算住院天数
				emrDTO = this.addInHosDays(emrDTO);
			}
		}
		return emrDTOs;
	}

	/**
	 * 根据患者ID得到患者地址DO
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public PatiAddrDO[] getPatiAddrDO(String[] patIds) throws BizException {
		IPatiAddrDORService patiAddrRservice = ServiceFinder.find(IPatiAddrDORService.class);
		return patiAddrRservice.findByAttrValStrings(PatiAddrDO.ID_PAT, patIds);
	}

	/**
	 * 得到自定义档案集合
	 * 
	 * @param udidocIds
	 * @return
	 * @throws BizException
	 */
	public UdidocDO[] getUdidocDOs() throws BizException {
		String[] codeList = { UDITYPE_SEX_CODE, UDITYPE_MARI_CODE, UDITYPE_NUR_LEVEL_CODE,
				UDITYPE_NUTR_LEVEL_CODE, UDITYPE_OP_DISE_CODE, UDITYPE_IP_DISE_CODE,
				UDITYPE_OUTCOMES_CODE, UDITYPE_OP_GOWHERE_CODE, UDITYPE_IP_GOWHERE_CODE,
				UDITYPE_REFERALSRC_CODE };
		FArrayList list = new FArrayList();
		list.addAll(Arrays.asList(codeList));
		IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		return serv.findByUdidoclistCodes(list);
	}

	/**
	 * 为EnEmrDTO加上地址信息
	 * 
	 * @param emrDTO
	 * @param patiAddrDOs
	 * @return
	 */
	private EnEmrDTO addAddress4EnEmrDTO(EnEmrDTO emrDTO, PatiAddrDO[] patiAddrDOs) {
		if (!EnValidator.isEmpty(patiAddrDOs) && !EnValidator.isEmpty(emrDTO)) {
			for (PatiAddrDO patiAddrDO : patiAddrDOs) {
				if (!EnValidator.isEmpty(patiAddrDO.getSd_addrtp())
						&& !EnValidator.isEmpty(emrDTO.getId_pat())
						&& emrDTO.getId_pat().equals(patiAddrDO.getId_pat())) {
					switch (patiAddrDO.getSd_addrtp()) {
					case IPiDictCodeConst.SD_ADDR_TYPE_FAMILY:
						emrDTO.setAddr_family(getFullAddress(patiAddrDO));
						break;
					case IPiDictCodeConst.SD_ADDR_TYPE_BORN:
						emrDTO.setAddr_born(getFullAddress(patiAddrDO));
						break;
					case IPiDictCodeConst.SD_ADDR_TYPE_WORK:
						emrDTO.setAddr_work(getFullAddress(patiAddrDO));
						break;
					case IPiDictCodeConst.SD_ADDR_TYPE_NOW:
						emrDTO.setId_addr_pat(patiAddrDO.getId_admdiv());
						emrDTO.setSd_addr_pat(patiAddrDO.getAdmdiv_code());
						emrDTO.setAddr_pat(patiAddrDO.getAdmdiv_fullname()+patiAddrDO.getStreet());
						emrDTO.setName_admdiv_addr_pat(getFullAddress(patiAddrDO));
						break;
					}
				}
			}
		}
		return emrDTO;
	}

	/**
	 * 为EnEmrDTO加上自定义档案信息
	 * 
	 * @param emrDTOs
	 * @param udidocDOs
	 * @return
	 */
	private EnEmrDTO addUdidoc4EnEmrDTO(EnEmrDTO emrDTO, UdidocDO[] udidocDOs) {
		if (!EnValidator.isEmpty(emrDTO) && !EnValidator.isEmpty(udidocDOs)) {
			for (UdidocDO udidocDO : udidocDOs) {
				// 性别
				if (!EnValidator.isEmpty(emrDTO.getId_sex())
						&& emrDTO.getId_sex().equals(udidocDO.getId_udidoc())) {
					emrDTO.setSex_name(udidocDO.getName());
					continue;
				}
				// 婚姻
				if (!EnValidator.isEmpty(emrDTO.getId_mari_pat())
						&& emrDTO.getId_mari_pat().equals(udidocDO.getId_udidoc())) {
					emrDTO.setSd_mari_pat(udidocDO.getCode());
					emrDTO.setMari_pat_name(udidocDO.getName());
					continue;
				}
				// 护理等级
				if (!EnValidator.isEmpty(emrDTO.getId_level_nur())
						&& emrDTO.getId_level_nur().equals(udidocDO.getId_udidoc())) {
					emrDTO.setSd_level_nur(udidocDO.getCode());
					emrDTO.setLevel_nur_name(udidocDO.getName());
					continue;
				}
				// 营养等级
				if (!EnValidator.isEmpty(emrDTO.getId_level_nutr())
						&& emrDTO.getId_level_nutr().equals(udidocDO.getId_udidoc())) {
					emrDTO.setSd_level_nutr(udidocDO.getCode());
					emrDTO.setLevel_nutr_name(udidocDO.getName());
					continue;
				}
				// 病情
				if (!EnValidator.isEmpty(emrDTO.getId_level_dise())
						&& emrDTO.getId_level_dise().equals(udidocDO.getId_udidoc())) {
					emrDTO.setLevel_dise_code(udidocDO.getCode());
					emrDTO.setLevel_dise_name(udidocDO.getName());
					continue;
				}
				// 病情转归
				if (!EnValidator.isEmpty(emrDTO.getId_outcomes())
						&& emrDTO.getId_outcomes().equals(udidocDO.getId_udidoc())) {
					emrDTO.setSd_outcomes(udidocDO.getCode());
					emrDTO.setOutcomes_name(udidocDO.getName());
					continue;
				}
				// 住院来院方式
				if (!EnValidator.isEmpty(emrDTO.getId_referalsrc())
						&& emrDTO.getId_referalsrc().equals(udidocDO.getId_udidoc())) {
					emrDTO.setSd_referalsrc(udidocDO.getCode());
					emrDTO.setReferalsrc_name(udidocDO.getName());
					continue;
				}
			}
		}
		return emrDTO;
	}

	/**
	 * 计算住院天数
	 * 
	 * @param enEmr
	 * @return
	 * @throws BizException 
	 */
	private EnEmrDTO addInHosDays(EnEmrDTO enEmr) throws BizException {
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(enEmr.getCode_entp())
				|| IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(enEmr.getCode_entp())) {
			CalculateHosDaysBP bp = new CalculateHosDaysBP();
			int days = bp.calculate(enEmr.getDt_acpt(), enEmr.getDt_end(), enEmr.getFg_ip());
			enEmr.setInhos_days(days);
		}
		return enEmr;
	}

	/**
	 * 得到完整的地址信息
	 * 
	 * @param patiAddrDO
	 * @return
	 */
	private String getFullAddress(PatiAddrDO patiAddrDO) {
		// StringBuilder address = new StringBuilder();
		// if (!EnValidator.isEmpty(patiAddrDO)) {
		// if (!EnValidator.isEmpty(patiAddrDO.getAdmdiv_name())) {
		// address.append(patiAddrDO.getAdmdiv_name());
		// }
		// if (!EnValidator.isEmpty(patiAddrDO.getStreet())) {
		// address.append(patiAddrDO.getStreet());
		// }
		// }
		return patiAddrDO.getAdmdiv_fullname();
	}
	/**
	 * 设置主治医生
	 * 
	 * @param list
	 * @param entIds
	 * @throws BizException
	 */
	private void setZzPsn(List<EnEmrDTO> list, String[] entIds) throws BizException{
		if(EnValidator.isEmpty(list) || EnValidator.isEmpty(entIds))
			return;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * ");
		sb.append("FROM (SELECT EMPZZ.ID_ENT ID_ENT, ");
		sb.append("EMPZZ.ID_EMP ID_EMP_MAST_DOCTOR, ");
		sb.append("SUZZ.ID_USER ID_MAST_DOCTOR, ");
		sb.append("SUZZ.CODE MAST_DOCTOR_CODE, ");
		sb.append("SUZZ.NAME MAST_DOCTOR_NAME, ");
		sb.append("ROW_NUMBER() OVER(PARTITION BY EMPZZ.ID_ENT ORDER by EMPZZ.DT_B DESC) AS ZZ_INDEX ");
		sb.append("FROM EN_ENT_EMP EMPZZ ");
		sb.append("LEFT outer JOIN SYS_USER SUZZ ");
		sb.append("ON EMPZZ.ID_EMP = SUZZ.ID_PSN ");
		sb.append("WHERE EMPZZ.SD_EMPROLE = ? ");
		sb.append("AND " + EnSqlUtils.getInSqlByIds("EMPZZ.ID_ENT", entIds));
		sb.append(") MR ");
		sb.append("WHERE ZZ_INDEX = 1 ");
		String sql = sb.toString();
		SqlParam param = new  SqlParam();
		param.addParam(IEnDictCodeConst.SD_EMPROLE_ZZDOC);
		List<EnEmrDTO> enMrList = (List<EnEmrDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnEmrDTO.class));               
		if(EnValidator.isEmpty(enMrList))
			return;
		Map<String, EnEmrDTO> enMrMap = this.assemblyEnEmrMap(enMrList);
		for(EnEmrDTO enMr : list){
			if(enMrMap.containsKey(enMr.getId_ent())){
				EnEmrDTO value = enMrMap.get(enMr.getId_ent());
				enMr.setId_emp_mast_doctor(value.getId_emp_mast_doctor());
				enMr.setId_mast_doctor(value.getId_mast_doctor());
				enMr.setMast_doctor_code(value.getMast_doctor_code());
				enMr.setMast_doctor_name(value.getMast_doctor_name());
			}
		}           
	}
	/**
	 * 设置主任医生
	 * 
	 * @param list
	 * @param entIds
	 * @throws BizException
	 */
	private void setZrPsn(List<EnEmrDTO> list, String[] entIds) throws BizException{
		if(EnValidator.isEmpty(list) || EnValidator.isEmpty(entIds))
			return;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * ");
		sb.append("FROM (SELECT EMPZR.ID_ENT ID_ENT, ");
		sb.append("EMPZR.ID_EMP ID_EMP_DIR_DOCTOR, ");
		sb.append("SUZR.ID_USER ID_DIR_DOCTOR, ");
		sb.append("SUZR.CODE DIR_DOCTOR_CODE, ");
		sb.append("SUZR.NAME DIR_DOCTOR_NAME, ");
		sb.append("ROW_NUMBER() OVER(PARTITION BY EMPZR.ID_ENT ORDER by EMPZR.DT_B DESC) AS ZR_INDEX ");
		sb.append("FROM EN_ENT_EMP EMPZR ");
		sb.append("LEFT outer JOIN SYS_USER SUZR ");
		sb.append("ON EMPZR.ID_EMP = SUZR.ID_PSN ");
		sb.append("WHERE EMPZR.SD_EMPROLE = ? ");
		sb.append("AND " + EnSqlUtils.getInSqlByIds("EMPZR.ID_ENT", entIds));
		sb.append(") MR ");
		sb.append("WHERE ZR_INDEX = 1 ");
		String sql = sb.toString();
		SqlParam param = new  SqlParam();
		param.addParam(IEnDictCodeConst.SD_EMPROLE_ZRDOC);
		List<EnEmrDTO> enMrList = (List<EnEmrDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnEmrDTO.class));               
		if(EnValidator.isEmpty(enMrList))
			return;
		Map<String, EnEmrDTO> enMrMap = this.assemblyEnEmrMap(enMrList);
		for(EnEmrDTO enMr : list){
			if(enMrMap.containsKey(enMr.getId_ent())){
				EnEmrDTO value = enMrMap.get(enMr.getId_ent());
				enMr.setId_emp_dir_doctor(value.getId_emp_dir_doctor());
				enMr.setId_dir_doctor(value.getId_dir_doctor());
				enMr.setDir_doctor_code(value.getDir_doctor_code());
				enMr.setDir_doctor_name(value.getDir_doctor_name());
			}
		}
	}
	/**
	 * 组装EnEmrList
	 * 
	 * @param list
	 * @return
	 */
	private Map<String, EnEmrDTO> assemblyEnEmrMap(List<EnEmrDTO> list){
		if(EnValidator.isEmpty(list))
			return null;
		Map<String, EnEmrDTO> map = new HashMap<String, EnEmrDTO>();
		for(EnEmrDTO enEmr : list)
			map.put(enEmr.getId_ent(), enEmr);
		return map;
	}
}
