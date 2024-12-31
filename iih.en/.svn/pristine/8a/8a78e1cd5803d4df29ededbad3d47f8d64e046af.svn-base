package iih.en.er.bp.baspat;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnErBasic4EditDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.en.pv.vt.d.EnVtDO;
import iih.en.pv.vt.d.EnVtSrvDO;
import iih.en.pv.vt.d.EnvtAggDO;
import iih.en.pv.vt.i.IEnvtRService;
import iih.pi.reg.pat.d.PatiAddrDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;


public class GetEnErBasic4editBP {
	/**
	 * 
	 * @param entId
	 * @return
	 * @throws DAException 
	 * @auther yaohl
	 * @date 2018年12月27日
	 */
	public EnErBasic4EditDTO exec(String entId) throws BizException {
		 //1.查询病人基本信息
		EnErBasic4EditDTO dto = this.queryDTO(entId);
		//2.设置现住址
		setNowAddr(dto);
		 //2.设置医保数据
		this.setHPInfo(dto);
		//3.设置联系人 代办人数据
		this.setContactInfo(dto, 0);
		//4.设置生命体征信息
		this.setVitalSign(dto);
		return dto;
	}
	/**
	 * 设置生命体征信息
	 * @param dto
	 * @throws BizException
	 */
	private void setNowAddr(EnErBasic4EditDTO dto) throws BizException {
		if(dto == null)
			return;
		PatiAddrDO addr = new PiPatEP().getNowPatAddr(dto.getId_pat());
		dto.setId_admdiv_addr(addr.getId_admdiv());
		dto.setSd_admdiv_addr(addr.getSd_admdiv());
		dto.setName_admdiv_addr(addr.getAdmdiv_fullname());
		dto.setAddr_pat(addr.getStreet());
	}
	/**
	 * 设置生命体征信息
	 * @param dto
	 * @throws BizException
	 */
	private void setVitalSign(EnErBasic4EditDTO dto) throws BizException {
		if(dto == null){
			return;
		}
		//1.获取AggDO
				EnvtAggDO agg = getEnvtAggDO(dto.getId_erpre());
				if(agg == null){
					return;
				}
				//2.查询体征信息
				EnVtDO envtDO = agg.getParentDO();
				EnVtSrvDO[] enVtSrvDOs = agg.getEnVtSrvDO();
				FArrayList vs_list = new FArrayList();
				for (EnVtSrvDO enVtSrvDO : enVtSrvDOs) {
					PhySignDTO phySign = new PhySignDTO();
					phySign.setId_srv(enVtSrvDO.getId_srv());
					phySign.setVal0(enVtSrvDO.getVal0());
					phySign.setVal1(enVtSrvDO.getVal1());
					phySign.setVal2(enVtSrvDO.getVal2());
					phySign.setVal3(enVtSrvDO.getVal3());
					phySign.setVal4(enVtSrvDO.getVal4());
					vs_list.add(phySign);
				}
				dto.setVs_list(vs_list);
	}
	/**
	 * 获取aggDO
	 * 
	 * @param enerpre
	 * @return
	 * @throws BizException
	 */
	private EnvtAggDO getEnvtAggDO(String id_erpre) throws BizException{
		if(id_erpre == null){
			return null;
		}
		IEnvtRService serv = ServiceFinder.find(IEnvtRService.class);
		EnvtAggDO[] aggs = serv.find(String.format(" ID_ERPRE = '%s' ",id_erpre),"", FBoolean.FALSE);
		if(aggs == null || aggs.length<=0)
			return new EnvtAggDO();
		EnvtAggDO agg = aggs[0];
		return agg;
	}
	/**
	 * 设置主医保和辅医保数据
	 *
	 * @param dto
	 *            门诊基本信息DTO
	 * @throws BizException
	 */
	private void setHPInfo(EnErBasic4EditDTO dto) throws BizException {
		if (null == dto || EnValidator.isEmpty(dto.getId_ent())) {
			return;
		}
		EntHpEP hpEp = new EntHpEP();
		EntHpDO[] hpDOs = hpEp.getEntHpList(dto.getId_ent());
		if (EnValidator.isEmpty(hpDOs)) {
			return;
		}
		for (EntHpDO hpDO : hpDOs) {
			FBoolean fg = hpDO.getFg_maj();
			if (EnValidator.isEmpty(dto.getName_hp()) && fg.booleanValue()) {
				dto.setName_hp(hpDO.getName_hp());
				dto.setNo_hp(hpDO.getNo_hp());
			}
			if (EnValidator.isEmpty(dto.getName_hp_as()) && !fg.booleanValue()) {
				dto.setName_hp_as(hpDO.getName_hp());
				dto.setNo_hp_as(hpDO.getNo_hp());
			}
		}
	}
	/**
	 * 设置联系人 代办人数据
	 * @param dto
	 * @param type
	 * @throws BizException
	 * @auther yaohl
	 * @date 2018年12月28日
	 */
	private void setContactInfo(EnErBasic4EditDTO dto,int type) throws BizException{
	    if (null == dto || EnValidator.isEmpty(dto.getId_ent())) {
			return;
		}
		EntContDO[] entDOs = new EntContEP().getEntContByEntId(dto.getId_ent());
		if (EnValidator.isEmpty(entDOs)) {
			return;
		}
		for (EntContDO entDO : entDOs) {
			int emtype = entDO.getEu_entconttp();
			// 联系人
			if (type == 0 || type == EuEntContTp.CONTACT.intValue()) {
				if (EnValidator.isEmpty(dto.getName_cont())
						&& emtype == EuEntContTp.CONTACT.intValue()) {
					dto.setName_cont(entDO.getName());// 联系人名称
					dto.setId_patcont(entDO.getId_patcontid());// 联系人ID
					dto.setId_entcont(entDO.getId_entcont());
					dto.setSd_conttp(entDO.getSd_conttp());// 联系人类型编码
					dto.setId_conttp(entDO.getId_conttp());// 联系人类型ID
					dto.setName_conttp(entDO.getName_conttp());// 联系人类型名称
					dto.setConttel(entDO.getConttel());// 联系人电话
					dto.setContaddr(entDO.getContaddr());// 联系人地址
				}
			}
			// 代办人
			if (type == 0 || type == EuEntContTp.AGENT.intValue()) {
				if (EnValidator.isEmpty(dto.getName_cont_agent())
						&& emtype == EuEntContTp.AGENT.intValue()) {
					dto.setName_cont_agent(entDO.getName());// 代办人名称
					dto.setId_patcont_agent(entDO.getId_patcontid());// 代办人ID
					dto.setId_entcont_agent(entDO.getId_entcont());
					dto.setSd_conttp_agent(entDO.getSd_conttp());// 代办人类型编码
					dto.setId_conttp_agent(entDO.getId_conttp());// 代办人类型ID
					dto.setName_conttp_agent(entDO.getName_conttp());// 代办人类型名称
					dto.setConttel_agent(entDO.getConttel());// 代办人电话
					dto.setContaddr_agent(entDO.getContaddr());// 代办人地址
					dto.setId_idtp_agent(entDO.getId_idtp());// 代办人证件类型id
					dto.setSd_idtp_agent(entDO.getSd_idtp());// 代办人证件类型编码
					dto.setName_idtp_agent(entDO.getName_idtp());// 代办人证件类型名称
					dto.setIdcode_agent(entDO.getIdcode());// 证件号码
				}
			}
		}
	}
	/**
	 * 
	 * 
	 * @param entId
	 * @return 根据就诊id查询基本信息
	 * @throws BizException
	 * @auther yaohl
	 * @date 2018年12月28日
	 */
	private EnErBasic4EditDTO queryDTO(String entId) throws BizException{
		if(EnValidator.isEmpty(entId)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("EN.ID_ENT AS ID_ENT,"); // 就诊ID
		sql.append("PAT.ID_PAT AS ID_PAT,"); // 患者ID
		sql.append("PAT.CODE AS CODE_PAT,"); // 患者ID
		sql.append("PAT.NAME AS NAME_PAT,"); // 患者姓名
		sql.append("PAT.PHOTO AS PHOTO,");// 患者照片
		sql.append("PAT.DT_BIRTH AS DT_BIRTH,");//患者出生日期
		sql.append("EN.CODE AS CODE_ENT,"); // 就诊编码
		sql.append("EN.ID_SEX_PAT AS ID_SEX,");// 性别id
		sql.append("EN.SD_SEX_PAT AS SD_SEX,");// 性别编码
		sql.append("DOCB.NAME AS NAME_SEX,");// 性别编码
		sql.append("CA.NAME AS NAME_PATCA,"); // 患者分类名称
		sql.append("PRI.NAME AS NAME_PRIPAT,"); // 价格分类名称
		sql.append("CRET.NAME AS NAME_PRICRET,"); // 信用分类名称
		//sql.append("OP.ID_LEVEL_DISE,");// 病情等级ID
		//sql.append("OP.SD_LEVEL_DISE,");// 病情等级编码
		sql.append("OP.DT_DI_MOR as dt_di_mor,");// 诊断发病日期，fanlq-2018-07-04
		sql.append("DISEDOC.NAME AS NAME_LEVEL_DISE,");// 病情等级名称
		sql.append("UDI.ID_UDIDOC AS ID_IDTP,"); // 证件类型ID
		sql.append("PAT.SD_IDTP AS SD_IDTP,"); // 证件类型编码
		sql.append("UDI.NAME AS NAME_IDTP,"); // 证件类型名称
		sql.append("PAT.ID_CODE AS CODE_ID,"); // 证件号码
		sql.append("EN.ID_HP AS ID_HP,"); // 医保计划id
		sql.append("EN.TELNO_PAT AS TELNO_PAT,"); // 联系号码
		sql.append("DEP.NAME AS NAME_DEP, ");//科室
		sql.append("NUR.NAME AS NAME_DEP_AREA,");//病区
		sql.append("PSN.NAME AS NAME_DOCTOR, ");//主管医生
		sql.append("DOCA.NAME AS NAME_SCALE_TRIAGE, ");//分检级别
		sql.append("ER.ID_ERPRE AS ID_ERPRE, ");//预检id
		sql.append("BED.NAME AS NAME_BED  ");//床位
		sql.append("FROM EN_ENT EN ");// 就诊信息表
		sql.append("LEFT JOIN EN_ENT_OP OP ON OP.ID_ENT = EN.ID_ENT ");
		sql.append("LEFT JOIN BD_UDIDOC DISEDOC ON DISEDOC.ID_UDIDOC = OP.ID_LEVEL_DISE ");
		sql.append("LEFT JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");// 患者基本信息表
		sql.append("LEFT JOIN PI_PAT_CA CA ON CA.ID_PATCA = EN.ID_PATCA ");// 患者分类表
		sql.append("LEFT JOIN PI_PAT_CRET CRET ON CRET.ID_PATCRET = EN.ID_PATCRET ");// 患者信用分类表
		sql.append("LEFT JOIN BD_PRI_PAT PRI ON PRI.ID_PRIPAT = EN.ID_PRIPAT ");// 患者价格分类表
		sql.append("LEFT JOIN BD_UDIDOC UDI ON UDI.ID_UDIDOC = PAT.ID_IDTP ");// 身份标识类型表
		sql.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");//当前就诊科室
		sql.append("LEFT JOIN BD_PSNDOC  PSN ON EN.ID_EMP_PHY = PSN.ID_PSNDOC ");//当前就诊医生
		sql.append("LEFT JOIN BD_DEP NUR ON EN.ID_DEP_NUR = NUR.ID_DEP ");//病区
		sql.append("LEFT JOIN EN_ENT_OP_ER ER ON EN.ID_ENT = ER.ID_ENT ");//急诊就诊
		sql.append("LEFT JOIN BD_BED BED ON ER.ID_BED = BED.ID_BED ");//床位
		sql.append("LEFT JOIN BD_UDIDOC DOCA ON ER.ID_SCALE_TRIAGE = DOCA.ID_UDIDOC ");//分检
		sql.append("LEFT JOIN BD_UDIDOC DOCB ON EN.ID_SEX_PAT = DOCB.ID_UDIDOC ");//分检
		sql.append("WHERE EN.ID_ENT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		List<EnErBasic4EditDTO> list = (List<EnErBasic4EditDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(EnErBasic4EditDTO.class));
		
		if(!EnValidator.isEmpty(list)){
			EnErBasic4EditDTO enErDTO = new EnErBasic4EditDTO();
			enErDTO = list.get(0);
			
			String age = AgeCalcUtil.getAge(enErDTO.getDt_birth());
			enErDTO.setAge(age);
			return enErDTO;
		}else{
			return null;
		}
	}
}
