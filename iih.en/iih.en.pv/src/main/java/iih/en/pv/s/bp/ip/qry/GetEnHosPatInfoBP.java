package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 保存患者信息
 * @author renying
 *
 */
public class GetEnHosPatInfoBP {

	/**
	 * 获取患者信息
	 * 
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public EnHosPatDTO exec(String patId) throws BizException {
		EnHosPatDTO enhosPatDTO = new EnHosPatDTO();
		this.getEnHosPatDTOValue(patId, enhosPatDTO);
		return enhosPatDTO;
	}

	/**
	 * 查询EnHosPatDTO信息
	 * 
	 * @param patId
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void getEnHosPatDTOValue(String patId, EnHosPatDTO enhosPatDTO) throws BizException {
		if (EnValidator.isEmpty(patId)) {
			throw new BizException("患者信息id为空");
		}
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatiVisitDO entDO = this.getEntInfo(patId);
		PatDO patdo = patRService.findById(patId);
		// 1.根据就诊信息设置婚姻状况
		this.getMarryInfo4PatDTO(entDO, enhosPatDTO);
		// 2.根据就诊信息设置行政区划
		this.getAddrInfo4PatDTO(entDO, enhosPatDTO);
		// 3。根据患者信息设置婚姻状况
		this.getPatMarryInfo4PatDTO(patdo, enhosPatDTO);
		// 4。根据患者信息设置用户地址
		this.getPatAddrInfo4PatDTO(patId, enhosPatDTO);
		// 5。设置患者基本信息
		this.getPatBasicInfo(patdo, enhosPatDTO);
		// 6.设置联系人信息
		// this.getPatContValue(patId, enhosPatDTO);
	}

	/**
	 * 设置患者的基本信息值
	 * 
	 * @param patdo
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void getPatBasicInfo(PatDO patdo, EnHosPatDTO enhosPatDTO) throws BizException {
		enhosPatDTO.setId_pat(patdo.getId_pat());
		enhosPatDTO.setCode_pat(patdo.getCode());
		enhosPatDTO.setName_pat(patdo.getName());
		enhosPatDTO.setCode_amr_ip(patdo.getCode_amr_ip());

		enhosPatDTO.setId_sex(patdo.getId_sex());// 性别
		enhosPatDTO.setSd_sex(patdo.getSd_sex());
		enhosPatDTO.setName_sex(patdo.getName_sex());

		enhosPatDTO.setId_idtp(patdo.getId_idtp());// 证件类型
		enhosPatDTO.setSd_idtp(patdo.getSd_idtp());
		enhosPatDTO.setName_idtp(patdo.getIdtp_name());
		enhosPatDTO.setId(patdo.getId_code());// 证件号码

		enhosPatDTO.setDt_birth(patdo.getDt_birth());
		enhosPatDTO.setId_marry(patdo.getId_marry());
		enhosPatDTO.setSd_marry(patdo.getSd_marry());
		enhosPatDTO.setName_marry(patdo.getMarry_name());
		enhosPatDTO.setTel(patdo.getTel());// 电话
		enhosPatDTO.setMob(patdo.getMob());// 移动电话

		enhosPatDTO.setId_nation(patdo.getId_nation()); // 民族
		enhosPatDTO.setName_nation(patdo.getNation_name());

		enhosPatDTO.setId_country(patdo.getId_country());// 国籍
		enhosPatDTO.setName_country(patdo.getCountry_name());

		enhosPatDTO.setId_patca(patdo.getId_paticate());
		enhosPatDTO.setName_patca(patdo.getPaticate_name());
	}

	/**
	 * 查找用户地址相关信息
	 * 
	 * @param patId
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void getPatAddrInfo4PatDTO(String patId, EnHosPatDTO enhosPatDTO) throws BizException {
		IPatiAddrDORService addRService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patAddrDOArr = addRService.find(PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_pat ='" + patId + "'", "", FBoolean.FALSE);
		if (EnValidator.isEmpty(patAddrDOArr)) {
			return;
		}
		for (PatiAddrDO addrPatDO : patAddrDOArr) {// 现住址
			if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_NOW) && EnValidator.isEmpty(enhosPatDTO.getName_admdiv())) {
				enhosPatDTO.setName_admdiv(addrPatDO.getAdmdiv_name());
				enhosPatDTO.setId_admdiv(addrPatDO.getId_admdiv());
				enhosPatDTO.setSd_admdiv(addrPatDO.getSd_admdiv());
				enhosPatDTO.setAddr_pat(addrPatDO.getStreet());
				enhosPatDTO.setTel_admdiv(addrPatDO.getTel());
				enhosPatDTO.setPostcode_addr(addrPatDO.getZip());
			}
			// 户籍地址
			if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS)) {
				enhosPatDTO.setId_admdiv_resi(addrPatDO.getId_admdiv());
				enhosPatDTO.setSd_admdiv_resi(addrPatDO.getSd_admdiv());
				enhosPatDTO.setName_admdiv_resi(addrPatDO.getAdmdiv_name());
				enhosPatDTO.setDetail_addr_resi(addrPatDO.getStreet());
				enhosPatDTO.setPostcode_resi(addrPatDO.getZip());
			}
			// 工作地址
			if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_WORK)) {
				enhosPatDTO.setId_admdiv_work(addrPatDO.getId_admdiv());
				enhosPatDTO.setSd_admdiv_work(addrPatDO.getSd_admdiv());
				enhosPatDTO.setName_admdiv_work(addrPatDO.getAdmdiv_name());
				enhosPatDTO.setDetail_addr_work(addrPatDO.getStreet());
				enhosPatDTO.setPostcode_work(addrPatDO.getZip());
				enhosPatDTO.setTel_work(addrPatDO.getTel());
			}
			// 籍贯地址
			if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN)) {
				enhosPatDTO.setId_nativeaddr(addrPatDO.getId_admdiv());
				enhosPatDTO.setName_nativeaddr(addrPatDO.getAdmdiv_name());
				enhosPatDTO.setSd_nativeaddr(addrPatDO.getSd_admdiv());
			}
		}
	}

	/**
	 * 根据患者信息设置婚姻状况
	 * 
	 * @param patdo
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void getPatMarryInfo4PatDTO(PatDO patdo, EnHosPatDTO enhosPatDTO) throws BizException {
		if (!EnValidator.isEmpty(enhosPatDTO.getName_marry())) {
			return;
		}
		if (EnValidator.isEmpty(patdo.getId_marry())) {
			return;
		}
		enhosPatDTO.setName_marry(patdo.getMarry_name());
		enhosPatDTO.setId_marry(patdo.getId_marry());
	}

	/**
	 * 查找en_ent中是否有保存的地址
	 * 
	 * @param patId
	 * @return
	 * @throws DAException
	 */
	private PatiVisitDO getEntInfo(String patId) throws DAException {
		PatiVisitDO entDO = null;
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" select ent.id_ent,");
		sqlSb.append(" ent.id_admdiv_addr,");
		sqlSb.append(" ent.sd_admdiv_addr,");
		sqlSb.append(" ent.addr_pat,");
		sqlSb.append(" ent.id_mari_pat");
		sqlSb.append(" from en_ent ent");
		sqlSb.append(" inner join en_ent_ip ip");
		sqlSb.append("  on ent.id_ent = ip.id_ent");
		sqlSb.append(" where ent.id_pat = ?");
		sqlSb.append("  and ip.sd_status in ('" + IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "','" // del
																									// +IEnDictCodeConst.SD_ENSTATUS_IN_ORDER+"','"
				+ IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN + "')");
		SqlParam param = new SqlParam();
		param.addParam(patId);
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(PatiVisitDO.class));

		if (!EnValidator.isEmpty(list)) {
			entDO = list.get(0);
		}
		return entDO;
	}

	/**
	 * 将婚姻信息设置到enthosPatdo
	 * 
	 * @param entDO
	 * @param enhosPatDTO
	 * @throws BizException
	 * 
	 */
	private void getMarryInfo4PatDTO(PatiVisitDO entDO, EnHosPatDTO enhosPatDTO) throws BizException {
		if (entDO == null) {
			return;
		}
		// 如果婚姻id都是空就不查了
		if (EnValidator.isEmpty(entDO.getId_mari_pat())) {
			return;
		}
		enhosPatDTO.setName_marry(entDO.getId_mari_pat());
		enhosPatDTO.setId_marry(entDO.getName_mari());
	}

	/**
	 * 设置行政区划的值
	 * 
	 * @param entDO
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void getAddrInfo4PatDTO(PatiVisitDO entDO, EnHosPatDTO enhosPatDTO) throws BizException {
		if (entDO == null) {
			return;
		}
		if (EnValidator.isEmpty(entDO.getId_admdiv_addr())) {// 如果行政区划的id不为空
			return;
		}
		enhosPatDTO.setAddr_pat(entDO.getAddr_pat());
		enhosPatDTO.setId_admdiv(entDO.getId_admdiv_addr());
		enhosPatDTO.setSd_admdiv(entDO.getSd_admdiv_addr());
		enhosPatDTO.setName_admdiv(entDO.getAddr_pat());
	}

}
