package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.bp.PatQryBP;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.OpRegPiContDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者注册加挂号
 * 
 * @author liubin
 */
public class RegPatAndOp4TLBP {
	/**
	 * 患者注册加挂号
	 * 
	 * @param opRegPatDTO
	 *            患者信息
	 * @param deptId
	 *            科室Id
	 * @param psnId
	 *            人员Id
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO exec(OpRegPatDTO opRegPatDTO) throws BizException {
		// 1.验证数据
		this.validate(opRegPatDTO);
		// 2.新增或修改患者信息
		opRegPatDTO = this.insertOrUpdatePat(opRegPatDTO);

		PatDO patDO = (PatDO) new DAFacade().findByPK(PatDO.class,
				opRegPatDTO.getId_pat());
		if (patDO == null)
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		// 获取患者已挂号有效记录
		PatiVisitDO patiVisitDO = getRegistEntInfo(opRegPatDTO);
		if (patiVisitDO != null)
			return patiVisitDO;

		RegInfoDTO regInfo = convertToRegInfo(opRegPatDTO, patDO);

		// 4.保存en_ent
		patiVisitDO = this.saveEnt(patDO, regInfo, opRegPatDTO);

		// 5.保存en_ent_op
		this.saveOp(patDO, regInfo);

		// 6.保存hp
		this.saveEntHp(regInfo);

		// 7.保存就诊联系人
		this.saveEntCont(regInfo);

		return patiVisitDO;
	}

	/**
	 * 验证数据
	 * 
	 * @param opRegPatDTO
	 * @throws BizException
	 */
	private void validate(OpRegPatDTO opRegPatDTO) throws BizException {
		if (EnValidator.isEmpty(opRegPatDTO))
			throw new BizException("患者信息为空！");
		if (EnValidator.isEmpty(opRegPatDTO.getId_dep()))
			throw new BizException("开单科室为空！");
		if (EnValidator.isEmpty(opRegPatDTO.getId_emp()))
			throw new BizException("开单医生为空！");
	}

	/**
	 * 获取已挂号记录
	 * 
	 * 
	 * 
	 * @author liubin
	 * 
	 * @param opRegPatDTO
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getRegistEntInfo(OpRegPatDTO opRegPatDTO)
			throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT EN.* FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append(" WHERE EN.FG_CANC = ? ");
		sqlBuilder.append(" AND EN.FG_ACPTVALID = ? ");
		sqlBuilder.append(" AND EN.ID_PAT = ?");
		sqlBuilder.append(" AND OP.ID_DEP_REG = ? ");
		sqlBuilder.append(" AND (OP.ID_EMP_REG = ? OR ISNULL(OP.ID_EMP_REG, '~')='~') ");
		sqlBuilder.append(" AND OP.DT_VALID_B <= ? ");
		sqlBuilder.append(" AND OP.DT_VALID_E >= ? ");
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.FALSE);
		param.addParam(FBoolean.TRUE);
		param.addParam(opRegPatDTO.getId_pat());
		param.addParam(opRegPatDTO.getId_dep());
		param.addParam(opRegPatDTO.getId_emp());
		FDateTime curDateTime = EnAppUtils.getServerDateTime();
		param.addParam(curDateTime);
		param.addParam(curDateTime);
		List<PatiVisitDO> patVisit = (List<PatiVisitDO>) new DAFacade()
				.execQuery(sqlBuilder.toString(), param, new BeanListHandler(
						PatiVisitDO.class));
		return EnValidator.isEmpty(patVisit) ? null : patVisit.get(0);
	}

	/**
	 * 新增或修改患者信息
	 * 
	 * @param opRegPatDTO
	 * @throws BizException
	 */
	private OpRegPatDTO insertOrUpdatePat(OpRegPatDTO opRegPatDTO)
			throws BizException {
		RegPatBP regBP = new RegPatBP();
		return regBP.regPat(opRegPatDTO,new FBoolean(EnValidator.isEmpty(opRegPatDTO.getId_pat())));
	}

	/**
	 * 组装
	 * 
	 * @param opRegPatDTO
	 * @return
	 * @throws BizException
	 */
	private RegInfoDTO convertToRegInfo(OpRegPatDTO opRegPatDTO, PatDO patDO)
			throws BizException {
		RegInfoDTO regInfo = new RegInfoDTO();
		RegResDTO regRes = new RegResDTO();
		regRes.setId_sch(null);
		regRes.setId_scres(null);
		String scsrvId = EnParamUtils.GetFreeRegistScSrvId();
		if(EnValidator.isEmpty(scsrvId))
			throw new BizException("免挂号费所使用排班服务[SC0110]未配置！");
		regRes.setId_scsrv(scsrvId);
		regRes.setId_dep(opRegPatDTO.getId_dep());
		regRes.setId_emp(opRegPatDTO.getId_emp());
		IScDaysLotService serv = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO dayslot = serv.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.TRUE);
		if (dayslot == null)
			throw new BizException("未找到当前日期分组！");
		regRes.setId_dayslot(dayslot.getId_dayslot());
		regRes.setD_sch(new FDate(dayslot.getDef1()));
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		//1.加载挂号资源价格
		schOutQryService.loadPatResPri(new RegResDTO[]{regRes}, opRegPatDTO.getId_pripat());
		regInfo.setRegresarray(EnAppUtils.doArray2List(regRes));
		regInfo.setId_pat(patDO.getId_pat());
		regInfo.setPat_code(patDO.getCode());
		regInfo.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		regInfo.setId_emp_entry(EnContextUtils.getPsnId());
		regInfo.setId_patca(patDO.getId_paticate());
		regInfo.setId_pripat(patDO.getId_patpritp());
		regInfo.setId_patcredtp(patDO.getId_patcrettp());
		regInfo.setMore(opRegPatDTO.getMore());
		regInfo.setId_hp(opRegPatDTO.getId_hp());
		regInfo.setNo_hp(opRegPatDTO.getNo_hp());
		regInfo.setId_hpkind(opRegPatDTO.getId_hpkind());
		regInfo.setCode_hpkind(opRegPatDTO.getCode_hpkind());
		regInfo.setCode_hppatca(opRegPatDTO.getCode_hppatca());
		regInfo.setCode_hparea(opRegPatDTO.getCode_hparea());
		regInfo.setCode_hpmedkind(opRegPatDTO.getCode_hpmedkind());
		regInfo.setFg_hp_card(opRegPatDTO.getFg_hp_card());
		regInfo.setFg_hpsettle(opRegPatDTO.getFg_hpsettle());
		regInfo.setFg_settlebycard(opRegPatDTO.getFg_settlebycard());
		regInfo.setId_hp_as(opRegPatDTO.getId_hp_sec());
		regInfo.setNo_hp_as(opRegPatDTO.getNo_hp_sec());
		regInfo.setEu_regtp(EuRegTp.FREENOSCH);
		regInfo.setIs_referral(FBoolean.FALSE);
		regInfo.setRegisted_date(regRes.getD_sch());
		regInfo.setId_sch(regRes.getId_sch());
		regInfo.setSd_tickmd(regRes.getId_tickmd());
		regInfo.setId_tick(null);// 号位
		regInfo.setId_ticks(null);// 号段
		regInfo.setTickno(0);// 票号
		regInfo.setId_dayslot(regRes.getId_dayslot());
		
		return regInfo;
	}

	/**
	 * 保存EN_ENT
	 * 
	 * @param patDO
	 * @param regInfo
	 * @throws BizException
	 */
	private PatiVisitDO saveEnt(PatDO patDO, RegInfoDTO regInfo, OpRegPatDTO opRegPatDTO) throws BizException{
		PatiVisitDO pvDO = new PatiVisitDO();
		pvDO.setStatus(DOStatus.NEW);
		pvDO.setId_grp(EnContextUtils.getGrpId());// 集团
		pvDO.setId_org(EnContextUtils.getOrgId()); // 机构
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(regInfo.getCode_entp())) {
			// 默认就诊类型为门诊
			pvDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_ET);// 就诊类型
			pvDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_ET);// 就诊类型
		} else {
			// 默认就诊类型为门诊
			pvDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);// 就诊类型
			pvDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);// 就诊类型
		}
		String entCode = EnCodeUtils.createEntCode();
		pvDO.setCode(entCode); 	
		// 患者信息
		pvDO.setId_pat(patDO.getId_pat());// 患者id
		pvDO.setName_pat(patDO.getName());// 患者姓名
		pvDO.setId_sex_pat(patDO.getId_sex());// 性别id
		pvDO.setSd_sex_pat(patDO.getSd_sex());// 性别编码
		pvDO.setId_mari_pat(patDO.getId_marry());//婚姻状况id
		pvDO.setSd_mari_pat(patDO.getSd_marry());// 婚姻状况
		pvDO.setDt_birth_pat(patDO.getDt_birth());// 出生日期
		if (!EnValidator.isEmpty(patDO.getMob())) {
			pvDO.setTelno_pat(patDO.getMob());// 优先取手机号码
		} else {
			pvDO.setTelno_pat(patDO.getTel());// 联系电话
		}
		pvDO.setDes("医生工作站");
		PatQryBP patQryBp = new PatQryBP();
		PatiAddrDO addrDo = patQryBp.getPatAddressDO(patDO.getId_pat(), IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		if (addrDo != null) {
			pvDO.setAddr_pat(addrDo.getAdmdiv_fullname()); // 地址
			pvDO.setId_admdiv_addr(addrDo.getId_admdiv()); // 区县码
		}
		pvDO.setDt_entry(new FDateTime(regInfo.getRegisted_date().asLocalBegin().toDate())); // 就诊登记日期时间
		pvDO.setFg_acptvalid(FBoolean.TRUE); // 接诊有效
		pvDO.setDt_acpt(EnAppUtils.getServerDateTime());
		pvDO.setId_dep_phy(opRegPatDTO.getId_dep()); // 当前就诊科室
		pvDO.setId_emp_phy(opRegPatDTO.getId_emp());
		pvDO.setId_emp_entry(regInfo.getId_emp_entry()); // 登记人员
		pvDO.setId_hp(regInfo.getId_hp()); // 主医保计划
		pvDO.setId_patca(regInfo.getId_patca()); // 患者分类
		pvDO.setId_pripat(regInfo.getId_pripat()); // 价格分类
		pvDO.setId_patcret(regInfo.getId_patcredtp()); // 信用分类
		pvDO.setFg_st(FBoolean.FALSE); // 结算标志
		pvDO.setFg_ip(FBoolean.FALSE); // 在院标志
		pvDO.setFg_flup(FBoolean.FALSE); // 随访标志
		pvDO.setFg_canc(FBoolean.FALSE); // 退诊标志
		pvDO.setFg_data_transf(FBoolean.FALSE);// 可转移标识
		pvDO.setDt_insert(EnAppUtils.getServerDateTime()); // 插入时间
		pvDO.setCode_hpmedkind(regInfo.getCode_hpmedkind());
		PvEP pvEP = new PvEP();
		pvDO = pvEP.savePv(pvDO);
		regInfo.setId_ent(pvDO.getId_ent());// 赋值id_ent
		return pvDO;
	}

	/**
	 * 保存EN_ENT_OP
	 * 
	 * @param patDO
	 * @param regInfo
	 * @throws BizException
	 */
	private void saveOp(PatDO patDO, RegInfoDTO regInfo) throws BizException {
		OpEP opEP = new OpEP();
		OutpatientDO opDO = opEP.createOpDO(regInfo);
		opDO.setCode_amr_oep(patDO.getCode_amr_oep());// 住院档案号
		opDO.setId_cg(regInfo.getId_cg());// 记账主键
		opDO.setFg_cg(FBoolean.FALSE);// 已结算标识
		opDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		opDO.setStatus(DOStatus.NEW);
		opEP.save(opDO);
	}

	/**
	 * 保存EN_ENT_HP
	 * 
	 * @param regInfo
	 * @throws BizException
	 */
	private void saveEntHp(RegInfoDTO regInfo) throws BizException {
		new EntHpEP().saveEntHp(regInfo);
	}

	/**
	 * 保存就诊联系人
	 * 
	 * @param regInfo
	 * @throws BizException
	 */
	private void saveEntCont(RegInfoDTO regInfo) throws BizException {
		if (regInfo.getMore() != null && regInfo.getMore().size() > 0) {
			OpRegPiContDTO regPiCont = (OpRegPiContDTO) regInfo.getMore()
					.get(0);
			EntContEP entContEP = new EntContEP();
			entContEP.saveEntCont(regInfo.getId_ent(), regPiCont);
		}
	}
}
