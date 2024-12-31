package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.EntStateEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.OpBasic4EditDTO;
import iih.en.pv.outpatient.i.IOutpatientRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取门诊基本信息
 * 
 * @author zhengcm
 * @date 2016-05-30 19:40:42
 *
 */
public class GetOpBasicInfo4EditBP {

	/**
	 * 获取门诊基本信息
	 * 
	 * @param entId
	 *            就诊id
	 * @return 门诊基本信息维护DTO
	 * @throws BizException
	 */
	public OpBasic4EditDTO exec(String entId) throws BizException {
		// 1、查询门诊基本信息DTO
		OpBasic4EditDTO dto = this.queryDTO(entId);
		// 2、设置医保数据
		this.setHPInfo(dto);
		// 3、设置联系人代办人数据
		new OpBasicInfoBP().setContactInfo(dto, 0);
		// 4、设置复诊数据
		this.setOpInfo(dto);
		// 5、设置就诊状况数据
		this.setOpEnStates(dto);
		
		return dto;
	}

	/**
	 * 根据就诊ID查询门诊基本信息
	 *
	 * @param entId
	 *            就诊ID
	 * @return 门诊基本信息DTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OpBasic4EditDTO queryDTO(String entId) throws BizException {
		if (EnValidator.isEmpty(entId)) {
			return null;
		}
		OpBasic4EditDTO dto = new OpBasic4EditDTO();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("EN.ID_ENT AS ID_ENT,"); // 就诊ID
		sql.append("PAT.ID_PAT AS ID_PAT,"); // 患者ID
		sql.append("PAT.CODE AS CODE_PAT,"); // 患者编码
		
		sql.append("EN.CODE AS CODE_ENT,"); // 就诊编码
		sql.append("EN.CODE_ENTP AS CODE_ENTTP,"); // 就诊类型
		sql.append("EN.ID_SEX_PAT AS ID_SEX,");// 性别id
		sql.append("EN.SD_SEX_PAT AS SD_SEX,");// 性别编码
		sql.append("CA.NAME AS NAME_PATCA,"); // 患者分类名称
		sql.append("PRI.NAME AS NAME_PRIPAT,"); // 价格分类名称
		sql.append("CRET.NAME AS NAME_PATCRET,"); // 信用分类名称
		sql.append("OP.ID_LEVEL_DISE,");// 病情等级ID
		sql.append("OP.SD_LEVEL_DISE,");// 病情等级编码
		sql.append("OP.DT_DI_MOR as dt_di_mor,");// 诊断发病日期，fanlq-2018-07-04
		sql.append("OP.SD_STATUS,");// 就诊状态
		sql.append("DISEDOC.NAME AS NAME_LEVEL_DISE,");// 病情等级名称
		sql.append("UDI.ID_UDIDOC AS ID_IDTP,"); // 证件类型ID
		sql.append("PAT.SD_IDTP AS SD_IDTP,"); // 证件类型编码
		sql.append("UDI.NAME AS NAME_IDTP,"); // 证件类型名称
		sql.append("PAT.ID_CODE AS CODE_ID,"); // 证件号码
		sql.append("EN.TELNO_PAT AS TELNO_PAT,"); // 联系号码
		
		sql.append("PATADDR.SD_ADMDIV AS SD_ADMDIV_ADDR, "); // 区县编码
		sql.append("PATADDR.ID_ADMDIV AS ID_ADMDIV_ADDR, "); // 
		sql.append("PATADDR.STREET AS ADDR_PAT,"); // 
		sql.append("AREA.FULLNAME AS  NAME_ADMDIV_ADDR,"); // 区县地址
		sql.append("AREA.FULLNAME AS AS NAME_ADMDIV_ADDR,"); // 
		
		sql.append("ADDR.SD_ADMDIV AS SD_ADMDIV_RESI,"); // 户口地址区县码
		sql.append("ADDR.ID_ADMDIV AS ID_ADMDIV_RESI,"); // 户口地址区县码ID
		sql.append("ADMINAREA.FULLNAME AS NAME_ADMDIV_RESI,"); //  户口地址区县码名称
		sql.append("ADDR.STREET AS DETAIL_ADDR_RESI,"); // 户口地址详细信息
		sql.append("PAT.PHOTO AS PHOTO_PAT ");// 患者照片
		sql.append("FROM EN_ENT EN ");// 就诊信息表
		sql.append("LEFT JOIN EN_ENT_OP OP ON OP.ID_ENT = EN.ID_ENT ");
		sql.append("LEFT JOIN BD_UDIDOC DISEDOC ON DISEDOC.ID_UDIDOC = OP.ID_LEVEL_DISE ");
		sql.append("LEFT JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");// 患者基本信息表
		sql.append("LEFT JOIN PI_PAT_CA CA ON CA.ID_PATCA = EN.ID_PATCA ");// 患者分类表
		sql.append("LEFT JOIN PI_PAT_CRET CRET ON CRET.ID_PATCRET = EN.ID_PATCRET ");// 患者信用分类表
		sql.append("LEFT JOIN BD_PRI_PAT PRI ON PRI.ID_PRIPAT = EN.ID_PRIPAT ");// 患者价格分类表
		sql.append("LEFT JOIN BD_UDIDOC UDI ON UDI.ID_UDIDOC = PAT.ID_IDTP ");// 身份标识类型表
		sql.append("LEFT JOIN PI_PAT_ADDR PATADDR ON PATADDR.ID_PAT = PAT.ID_PAT and PATADDR.sd_addrtp = '"+IPiDictCodeConst.SD_ADDR_TYPE_NOW+"' ");//患者现居地
		sql.append("LEFT JOIN BD_ADMINAREA AREA ON EN.ID_ADMDIV_ADDR = AREA.ID_ADMINAREA ");// 行政区域表
		
		sql.append("LEFT JOIN PI_PAT_ADDR ADDR ON ADDR.ID_PAT = PAT.ID_PAT  and ADDR.sd_addrtp = '"+IPiDictCodeConst.SD_ADDR_TYPE_CENCUS+"' ");// 患者户口地址
		sql.append("LEFT JOIN BD_ADMINAREA ADMINAREA ON ADMINAREA.ID_ADMINAREA = ADDR.ID_ADMDIV ");// 患者地址
		sql.append("WHERE  EN.ID_ENT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		List<OpBasic4EditDTO> list = (List<OpBasic4EditDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(OpBasic4EditDTO.class));
		if (!EnValidator.isEmpty(list)) {
			for (OpBasic4EditDTO opBasic4EditDTO : list) {
				if(!!EnValidator.isEmpty(opBasic4EditDTO.getSd_admdiv_resi())&&!!EnValidator.isEmpty(opBasic4EditDTO.getSd_admdiv_addr())){	
					dto = opBasic4EditDTO;
				}
				if(!EnValidator.isEmpty(opBasic4EditDTO.getSd_admdiv_resi())||!EnValidator.isEmpty(opBasic4EditDTO.getSd_admdiv_addr())){	
					dto = opBasic4EditDTO;
				}
				if(!EnValidator.isEmpty(opBasic4EditDTO.getSd_admdiv_resi())&&!EnValidator.isEmpty(opBasic4EditDTO.getSd_admdiv_addr())){	
					dto = opBasic4EditDTO;
					break;
				}
			}
			
		}
		return dto;
	}

	/**
	 * 设置主医保和辅医保数据
	 *
	 * @param dto
	 *            门诊基本信息DTO
	 * @throws BizException
	 */
	private void setHPInfo(OpBasic4EditDTO dto) throws BizException {
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
	 * 设置门诊数据
	 *
	 * @param dto
	 * @throws BizException
	 * @author zhengcm
	 */
	private void setOpInfo(OpBasic4EditDTO dto) throws BizException {
		if (null == dto) {
			return;
		}
		String cond = String.format("id_ent = '%s'", dto.getId_ent());
		IOutpatientRService qryService = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] opDOs = qryService.find(cond, null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(opDOs) && !opDOs[0].getFg_first().booleanValue()) {
			dto.setFg_visit(FBoolean.TRUE);
		} else {
			dto.setFg_visit(FBoolean.FALSE);
		}
	}
	/**
	 * 设置就诊状况数据
	 * 
	 * @throws BizException
	 */
	private void setOpEnStates(OpBasic4EditDTO dto) throws BizException {
		if (null == dto || EnValidator.isEmpty(dto.getId_ent())) {
			return;
		}
		EntStateEP ep = new EntStateEP();
		EntStateDO[] entStates = ep.getEntstates(dto.getId_ent(), dto.getId_pat(), dto.getCode_enttp());
		if(EnValidator.isEmpty(entStates))
			return;
		boolean isFirst = true;
		for(EntStateDO entState : entStates){
			if(isFirst){
				dto.setName_en_states(entState.getName_val());
				isFirst = false;
			}else{
				dto.setName_en_states(dto.getName_en_states() + "," + entState.getName_val());
			}
		}
	}

}
