package iih.en.er.bp.stay;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.bp.stay.qry.ObsStayApplyQry;
import iih.en.er.bp.stay.qry.ObsStayEntInfoQry;
import iih.en.er.dto.d.EnObsPermitDTO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPiPatContDORService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.util.AgeCalcUtil;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 查询留观申请单信息
 * 
 * @author liubin
 *
 */
public class GetObsPerInfoBP {
	/**
	 * 获取急诊留观许可信息
	 * 
	 * @param patSearch
	 * @return
	 * @throws BizException
	 */
	public EnObsPermitDTO exec(String entId) throws BizException {
		if (EnValidator.isEmpty(entId))
			return null;
		// 1.判断该就诊是否存在留观申请单
		String aptIpId = getObsApply(entId);
		// 2.存在申请单，查询申请单信息，不存在申请单，查询就诊信息
		EnObsPermitDTO resultDto = EnValidator.isEmpty(aptIpId) ? assemlyByEntId(entId)
				: assemlyByAptIpId(aptIpId);
		// 3.设置自定义档案名称
		setUdidocInfo(resultDto);
		// 4.设置科室名称
		setDeptInfo(resultDto);
		// 5.设置联系人
		setPatContInfo(resultDto);
		// 6.设置现住址
		setNowAddrInfo(resultDto);
		// 7.设置预检信息
		setErPreInfo(resultDto);
		// 8.设置其他信息（年龄，是否留观在院，是否有其他有效的留观申请单）
		setOtherInfo(resultDto);

		return resultDto;
	}

	/**
	 * 组装留观申请单信息(存在申请单)
	 * 
	 * @param aptIpId
	 * @return
	 * @throws BizException
	 */
	private EnObsPermitDTO assemlyByAptIpId(String aptIpId) throws BizException {
		EnObsPermitDTO[] enObsPermitDtos = (EnObsPermitDTO[]) AppFwUtil
				.getDORstWithDao(new ObsStayApplyQry(aptIpId),
						EnObsPermitDTO.class);
		if (EnValidator.isEmpty(enObsPermitDtos))
			throw new BizException("获取患者留观申请单失败！");
		return enObsPermitDtos[0];
	}

	/**
	 * 组装留观申请单所需要的就诊信息(不存在申请单)
	 * 
	 * @param aptIpId
	 * @return
	 * @throws BizException
	 */
	private EnObsPermitDTO assemlyByEntId(String entId) throws BizException {
		EnObsPermitDTO[] enObsPermitDtos = (EnObsPermitDTO[]) AppFwUtil
				.getDORstWithDao(new ObsStayEntInfoQry(entId),
						EnObsPermitDTO.class);
		if (EnValidator.isEmpty(enObsPermitDtos))
			throw new BizException("获取患者就诊信息失败！");
		return enObsPermitDtos[0];
	}

	/**
	 * 组装自定义数据信息
	 * 
	 * @param resultDto
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setUdidocInfo(EnObsPermitDTO resultDto) throws BizException {
		if (resultDto == null)
			return;
		Set<String> set = new HashSet<>();
		if (!EnValidator.isEmpty(resultDto.getId_sex()))
			set.add(resultDto.getId_sex());
		if (!EnValidator.isEmpty(resultDto.getId_marry()))
			set.add(resultDto.getId_marry());
		if (!EnValidator.isEmpty(resultDto.getId_idtp()))
			set.add(resultDto.getId_idtp());
		if (!EnValidator.isEmpty(resultDto.getId_level_dise()))
			set.add(resultDto.getId_level_dise());
		if (set.isEmpty())
			return;
		List<UdidocDO> udis = (List<UdidocDO>) new DAFacade().findByPKs(
				UdidocDO.class, set.toArray(new String[0]), new String[] {
						UdidocDO.ID_UDIDOC, UdidocDO.CODE, UdidocDO.NAME });
		Map<String, UdidocDO> map = EnFMapUtils.getMap(
				UdidocDO.ID_UDIDOC,
				EnValidator.isEmpty(udis) ? null : udis
						.toArray(new UdidocDO[0]));
		if (EnValidator.isEmpty(map))
			return;
		// 性别
		if (!EnValidator.isEmpty(resultDto.getId_sex())
				&& map.containsKey(resultDto.getId_sex())) {
			UdidocDO udi = map.get(resultDto.getId_sex());
			resultDto.setSd_sex(udi.getCode());
			resultDto.setName_sex(udi.getName());
		}
		// 婚姻状况
		if (!EnValidator.isEmpty(resultDto.getId_marry())
				&& map.containsKey(resultDto.getId_marry())) {
			UdidocDO udi = map.get(resultDto.getId_marry());
			resultDto.setName_marry(udi.getName());
		}
		// 证件类型
		if (!EnValidator.isEmpty(resultDto.getId_idtp())
				&& map.containsKey(resultDto.getId_idtp())) {
			UdidocDO udi = map.get(resultDto.getId_idtp());
			resultDto.setSd_idtp(udi.getCode());
			resultDto.setName_idtp(udi.getName());
		}
		// 病情等级
		if (!EnValidator.isEmpty(resultDto.getId_level_dise())
				&& map.containsKey(resultDto.getId_level_dise())) {
			UdidocDO udi = map.get(resultDto.getId_level_dise());
			resultDto.setSd_level_dise(udi.getCode());
			resultDto.setName_level_dise(udi.getName());
		}
	}

	/**
	 * 组装科室名称
	 * 
	 * @param resultDto
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setDeptInfo(EnObsPermitDTO resultDto) throws BizException {
		if (resultDto == null)
			return;
		Set<String> set = new HashSet<>();
		if (!EnValidator.isEmpty(resultDto.getId_dep_to()))
			set.add(resultDto.getId_dep_to());
		if (!EnValidator.isEmpty(resultDto.getId_dep_phy_ip()))
			set.add(resultDto.getId_dep_phy_ip());
		if (!EnValidator.isEmpty(resultDto.getId_dep_nur_ip()))
			set.add(resultDto.getId_dep_nur_ip());
		if (!EnValidator.isEmpty(resultDto.getId_dep_op()))
			set.add(resultDto.getId_dep_op());
		if (set.isEmpty())
			return;
		List<DeptDO> depts = (List<DeptDO>) new DAFacade().findByPKs(
				DeptDO.class, set.toArray(new String[0]), new String[] {
						DeptDO.ID_DEP, DeptDO.CODE, DeptDO.NAME });
		Map<String, DeptDO> map = EnFMapUtils.getMap(DeptDO.ID_DEP, EnValidator
				.isEmpty(depts) ? null : depts.toArray(new DeptDO[0]));
		if (EnValidator.isEmpty(map))
			return;
		if (!EnValidator.isEmpty(resultDto.getId_dep_to())
				&& map.containsKey(resultDto.getId_dep_to())) {
			DeptDO dept = map.get(resultDto.getId_dep_to());
			resultDto.setName_dep_to(dept.getName());
		}
		if (!EnValidator.isEmpty(resultDto.getId_dep_phy_ip())
				&& map.containsKey(resultDto.getId_dep_phy_ip())) {
			DeptDO dept = map.get(resultDto.getId_dep_phy_ip());
			resultDto.setName_dep_phy_ip(dept.getName());
		}
		if (!EnValidator.isEmpty(resultDto.getId_dep_nur_ip())
				&& map.containsKey(resultDto.getId_dep_nur_ip())) {
			DeptDO dept = map.get(resultDto.getId_dep_nur_ip());
			resultDto.setName_dep_nur_ip(dept.getName());
		}
		if (!EnValidator.isEmpty(resultDto.getId_dep_op())
				&& map.containsKey(resultDto.getId_dep_op())) {
			DeptDO dept = map.get(resultDto.getId_dep_op());
			resultDto.setName_dep_op(dept.getName());
		}
	}

	/**
	 * 设置联系人信息
	 * 
	 * @param resultDto
	 * @throws BizException
	 */
	private void setPatContInfo(EnObsPermitDTO resultDto) throws BizException {
		if (resultDto == null || EnValidator.isEmpty(resultDto.getId_patcont()))
			return;
		IPiPatContDORService serv = ServiceFinder
				.find(IPiPatContDORService.class);
		PiPatContDO patCont = serv.findById(resultDto.getId_patcont());
		if (patCont == null)
			return;
		resultDto.setName_patcont(patCont.getName());
		resultDto.setId_conttp(patCont.getId_conttp());
		resultDto.setSd_conttp(patCont.getSd_conttp());
		resultDto.setName_conttp(patCont.getConttp_name());
		resultDto.setConttel(patCont.getConttel());
		resultDto.setContaddr(patCont.getContaddr());
	}

	/**
	 * 设置现住址信息
	 * 
	 * @param resultDto
	 * @throws BizException
	 */
	private void setNowAddrInfo(EnObsPermitDTO resultDto) throws BizException {
		if (resultDto == null)
			return;
		PatiAddrDO addr = new PiPatEP().getNowPatAddr(resultDto.getId_pat());
		if (addr == null)
			return;
		resultDto.setId_addr_now(addr.getId_admdiv());
		resultDto.setCode_addr_now(addr.getAdmdiv_code());
		resultDto.setName_addr_now(addr.getAdmdiv_fullname());
		resultDto.setStreet_addr_now(addr.getStreet());
	}

	/**
	 * 设置预检信息
	 * 
	 * @param resultDto
	 * @throws BizException
	 */
	private void setErPreInfo(EnObsPermitDTO resultDto) throws BizException {
		if (resultDto == null)
			return;
		ErPreEP ep = new ErPreEP();
		ep.setErScoleName(new EnObsPermitDTO[] { resultDto },
				"Sd_scale_triage", "Name_scale_triage");
		ep.setGreenNames(new EnObsPermitDTO[] { resultDto },
				"Ids_green_channel", "Names_green_channel");
	}

	/**
	 * 设置其他信息（年龄，是否留观在院，是否有其他有效的留观申请单）
	 * 
	 * @param resultDto
	 * @throws BizException
	 */
	private void setOtherInfo(EnObsPermitDTO resultDto) throws BizException {
		if (resultDto == null)
			return;
		// 年龄
		resultDto.setAge(AgeCalcUtil.getAge(resultDto.getDt_birth()));
		// 是否留观在院
		resultDto
				.setFg_inhos(FBoolean.valueOf(isObsInHos(resultDto.getId_pat())));
		// 是否有其他有效的留观申请单
		resultDto.setFg_other_apply(FBoolean.valueOf(hasOtherApplys(
				resultDto.getId_pat(), resultDto.getId_ent())));
	}

	/**
	 * 获取该次对应的留观申请
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private String getObsApply(String entId) throws BizException {
		String sql = "SELECT ID_APTIP FROM SC_APT_IP WHERE FG_CANC = 'N' AND FG_EMGSTAY = 'Y' AND ID_ENT = ?";
		SqlParam param = new SqlParam();
		param.addParam(entId);
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param,
				new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.get(0);
	}

	/**
	 * 患者是否留观在院
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private boolean isObsInHos(String patId) throws BizException {
		if (EnValidator.isEmpty(patId))
			return false;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT COUNT(1) ");
		sqlBuilder.append("FROM EN_ENT ENT ");
		sqlBuilder.append("INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT = IP.ID_ENT ");
		sqlBuilder.append("WHERE ENT.FG_EMGSTAY = 'Y' ");
		sqlBuilder.append(String.format("AND IP.SD_STATUS IN ('%s','%s') ",
				IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN,
				IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN));
		sqlBuilder.append("AND ENT.ID_PAT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(patId);
		Integer count = (Integer) new DAFacade().execQuery(
				sqlBuilder.toString(), param, new ColumnHandler());
		return count != null && count > 0;
	}

	/**
	 * 是否有其他有效的留观申请单
	 * 
	 * @param patId
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private boolean hasOtherApplys(String patId, String entId)
			throws BizException {
		if (EnValidator.isEmpty(patId) || EnValidator.isEmpty(entId))
			return false;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT COUNT(1) FROM SC_APT_IP APTIP ");
		sqlBuilder.append("WHERE APTIP.FG_CANC = 'N' ");
		sqlBuilder.append("AND APTIP.FG_EMGSTAY = 'Y' ");
		sqlBuilder.append(String.format("AND APTIP.SD_STATUS <> '%s' ", IScDictCodeConst.SD_APTIP_STATUS_INHOS));
		sqlBuilder.append("AND APTIP.DT_VALID >= ? ");
		sqlBuilder.append("AND APTIP.ID_PAT = ? ");
		sqlBuilder.append("AND APTIP.ID_ENT <> ? ");
		SqlParam param = new SqlParam();
		param.addParam(EnAppUtils.getServerDateTime());
		param.addParam(patId);
		param.addParam(entId);
		Integer count = (Integer) new DAFacade().execQuery(
				sqlBuilder.toString(), param, new ColumnHandler());
		return count != null && count > 0;
	}
}
