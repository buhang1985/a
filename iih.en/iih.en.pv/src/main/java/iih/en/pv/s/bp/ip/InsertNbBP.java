package iih.en.pv.s.bp.ip;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.fc.enstatetpext.d.BdEnStateTpExtDO;
import iih.en.comm.IEnConst;
import iih.en.comm.ep.EnAccEP;
import iih.en.comm.ep.EnDcgEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntStateEP;
import iih.en.comm.ep.EntWgEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.enres.d.EnMedGrpDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.i.IEnIpQryService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.ChgEmp4EsDTO;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import iih.en.pv.inpatient.dto.d.IpReg4EsDTO;
import iih.en.pv.inpatient.dto.d.NewbornDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.EnIpCmdServiceImpl;
import iih.en.pv.s.bp.SetEntStateBP;
import iih.en.pv.s.event.IpChgEmpEvent;
import iih.en.pv.s.event.IpEnterDeptEvent;
import iih.en.pv.s.event.IpRegEvent;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

/**
 * 新增新生儿记录BP
 * @author zhengcm
 * @date 2016-08-10 09:25:43
 *
 */
public class InsertNbBP {

	/**
	 * 新增新生儿记录
	 * 
	 * @param nbDO
	 *            新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String exec(NewbornDTO nbDTO) throws BizException{
	    NewbornDO nbDO = new NewbornDO();
	    try {
            BeanUtils.copyProperties(nbDO, nbDTO);
            if(FDoubleUtils.isNullOrZero(nbDO.getWeight_reg()))
				nbDO.setWeight_reg(nbDO.getWeight());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new BizException("新增新生儿记录失败!");
        }

		// 当前服务器时间日期
		FDateTime nowTime = EnAppUtils.getServerDateTime();

		// 0、母亲住院信息
		InpatientDO momIp = this.getMomIpInfo(nbDO);
		// 1、保存新生儿患者信息
		PatDO nbPatDO = this.saveNewbornPatInfo(nbDO, momIp.getCode_amr_ip());

		// 2、设置新生儿患者信息ID
		if (null != nbPatDO) {
			nbDO.setId_pat_bb(nbPatDO.getId_pat());
		}

		// 3、保存新生儿就诊信息
		PatiVisitDO nbEntDO = this.saveNewbornEntInfo(nbDO, nowTime,nbDTO);

		// 4、设置新生儿就诊信息ID
		if (null != nbEntDO) {
			nbDO.setId_ent_bb(nbEntDO.getId_ent());
		}

		// 5、保存新生儿就诊住院信息
		InpatientDO ipDO = this.saveNewbornIpInfo(nbDO, momIp);

		// 6、保存就诊状况
		this.saveEntState(nbEntDO, ipDO);

		// 7、保存新生儿就诊医疗组信息
		this.saveNewbornWgInfo(nbEntDO, nowTime);

		// 8、保存新生儿就诊人员信息
		this.saveNewbornEmpInfo(nbEntDO, nbDO, nowTime);

		// 9、创建新生儿就诊账户
		this.saveEntAccInfo(nbDO, nbPatDO, nbEntDO);

		// 10、新增新生儿的入科固定费用
		this.insertNewbornDcg(nbEntDO);

		// 11、设置登记日期和登记人员
		this.setRegData(nbDO, nowTime);

		// 12、保存新生儿记录数据
		new NbEP().insertNbDOs(new NewbornDO[] { nbDO });

		// 13、更新新生儿母亲就诊住院信息
		new NbEP().updateMomEntIpInfo(nbDO);

		// 14、同步新生儿联系人信息
		new EnIpCmdServiceImpl().syncBabyInfo(nbDO.getId_ent_mom());
		// 15、发送入院登记事件
		this.invokeIpRegEvent(nbEntDO,ipDO);
		
		// 16、发送入科事件
		this.invokeIpEnterDeptEvent(nbEntDO,ipDO,nbDTO);
		// 17、触发BS359保存医务人员
		invokeIpEnterDeptEvent(nbEntDO);
		return nbEntDO.getId_ent();
	}

	/**
	 * 保存新生儿患者信息
	 * 
	 * @author zhengcm
	 * @param nbDO
	 *            新生儿记录DO
	 * @param codeAmrIpMom
	 * @return 新生儿患者信息DO
	 * @throws BizException
	 */
	private PatDO saveNewbornPatInfo(NewbornDO nbDO, String codeAmrIpMom) throws BizException {
		PatEP patEP = new PatEP();

		// 婴儿母亲就诊信息
		PatiVisitDO momEntDO = new PvEP().getPvById(nbDO.getId_ent_mom());
		// 新生儿母亲患者信息
		PatDO momPatInfo = patEP.getPatById(momEntDO.getId_pat());

		// 校验新生儿的出生日期与母亲的出生日期
		if (momPatInfo.getDt_birth().after(nbDO.getDt_birth().getDate())) {
			throw new BizException("新生儿出生日期不能早于母亲出生日期！");
		}
		// 新生儿的出生日期应大于母亲的入院时间-24小时
		FDateTime momDate = momEntDO.getDt_acpt().addSeconds(-24 * 3600);
		if (momDate.after(nbDO.getDt_birth())) {
			throw new BizException("新生儿出生日期不能早于母亲入院时间前24小时！");
		}

		// 患者分类（默认）
		PiPatCaDO cateDO = patEP.getPatDefaultCate();

		PatDO patDO = new PatDO();
		patDO.setStatus(DOStatus.NEW);
		patDO.setId_grp(nbDO.getId_grp());
		patDO.setId_org(nbDO.getId_org());
		patDO.setCode(EnCodeUtils.createPatCode());
		patDO.setName(nbDO.getName_bb());
		patDO.setMob(momPatInfo.getMob());
		// 拼音
		if (!EnValidator.isEmpty(nbDO.getName_bb())) {
			patDO.setPycode(EnAppUtils.getPyCode(nbDO.getName_bb()));
			// 助记码
			patDO.setMnecode(patDO.getPycode());
		}
		// 五笔
		if (!EnValidator.isEmpty(nbDO.getName_bb())) {
			patDO.setWbcode(EnAppUtils.getWbCode(nbDO.getName_bb()));
		}
		patDO.setId_sex(nbDO.getId_sex());
		patDO.setSd_sex(nbDO.getSd_sex());
		patDO.setName_sex(nbDO.getName_sex());
		patDO.setDt_birth(nbDO.getDt_birth().getBeginDate());
		patDO.setDt_birth_hms(nbDO.getDt_birth());
		patDO.setId_marry(IPiDictCodeConst.ID_NO_MARRAY_STATUS);// 未婚
		patDO.setSd_marry(IPiDictCodeConst.SD_NO_MARRAY_STATUS);
		patDO.setFg_invd(FBoolean.FALSE);
		patDO.setFg_realname(FBoolean.TRUE);
		patDO.setId_idtp("@@@@AA1000000000MNFJ");
		patDO.setSd_idtp("99");
		patDO.setId_code("~");
		patDO.setLast_times_ip(0);//需求新生儿办理住院需重新生成住院次数，从1开始算，出生不能算作一次住院。
		patDO.setCode_amr_ip(codeAmrIpMom + "B" + nbDO.getNo_bb());
		if (null != momPatInfo) {
			patDO.setId_nation(momPatInfo.getId_nation());
			patDO.setSd_nation(momPatInfo.getSd_nation());
			patDO.setId_country(momPatInfo.getId_country());
			patDO.setSd_country(momPatInfo.getSd_country());
		}
		if (null != cateDO) {
			patDO.setId_paticate(cateDO.getId_patca());// 患者分类
			patDO.setId_patcrettp(cateDO.getId_patcrettp());// 信用分类
			patDO.setId_patpritp(cateDO.getId_patpritp());// 价格分类
		}

		IPatiCudService service = ServiceFinder.find(IPatiCudService.class);

		PatiAggDO aggDo = new PatiAggDO();
		
		patDO.setDomain(IPiDictCodeConst.DOMAIN_ID_ZY);
		aggDo.setParentDO(patDO);
		aggDo = service.insert(new PatiAggDO[] { aggDo })[0];
//		PatDO[] datas = patEP.insertPatDOs(new PatDO[] { patDO });
		if (aggDo != null) {
			return aggDo.getParentDO();
		}
		return null;
	}

	/**
	 * 保存新生儿就诊信息
	 * 
	 * @author zhengcm
	 * @param nbDO
	 *            新生儿记录DO
	 * @param nowTime
	 *            当前服务器时间日期
	 * @return 新生儿就诊信息DO
	 * @throws BizException
	 */
	private PatiVisitDO saveNewbornEntInfo(NewbornDO nbDO, FDateTime nowTime,NewbornDTO nbDTO) throws BizException {
		PvEP pvEP = new PvEP();

		// 婴儿母亲就诊信息
		PatiVisitDO momEntDO = pvEP.getPvById(nbDO.getId_ent_mom());

		// 患者分类（默认）
		PiPatCaDO cateDO = new PatEP().getPatDefaultCate();

		PatiVisitDO entDO = new PatiVisitDO();
		//添加患者分类
		if ( !EnValidator.isEmpty(nbDTO.getId_pripat()) ) {
		    entDO.setId_pripat(nbDTO.getId_pripat());
	    }
		entDO.setStatus(DOStatus.NEW);
		entDO.setId_grp(nbDO.getId_grp());
		entDO.setId_org(nbDO.getId_org());
		entDO.setId_pat(nbDO.getId_pat_bb());
		nbDO.setId_pat_mom(momEntDO.getId_pat());// 母亲的患者id
		entDO.setCode(EnCodeUtils.createEntCode());
		entDO.setName_pat(nbDO.getName_bb());
		entDO.setId_sex_pat(nbDO.getId_sex());
		entDO.setSd_sex_pat(nbDO.getSd_sex());
		entDO.setName_sex(nbDO.getName_sex());
		entDO.setId_mari_pat(IPiDictCodeConst.ID_NO_MARRAY_STATUS);// 未婚
		entDO.setSd_mari_pat(IPiDictCodeConst.SD_NO_MARRAY_STATUS);
		entDO.setDt_birth_pat(nbDO.getDt_birth().getBeginDate());
		entDO.setFg_acptvalid(FBoolean.TRUE);
		// 取母亲的入院日期与新生儿出生日期的最大值
		if (momEntDO.getDt_acpt().after(nbDO.getDt_birth())) {
			entDO.setDt_entry(momEntDO.getDt_acpt());
			entDO.setDt_acpt(momEntDO.getDt_acpt());
		} else {
			entDO.setDt_entry(nbDO.getDt_birth());
			entDO.setDt_acpt(nbDO.getDt_birth());
		}

		entDO.setId_emp_entry(EnContextUtils.getPsnId());// 当前操作员
		entDO.setFg_st(FBoolean.FALSE);
		entDO.setFg_ip(FBoolean.TRUE);
		entDO.setFg_flup(FBoolean.FALSE);
		entDO.setFg_canc(FBoolean.FALSE);
		entDO.setFg_data_transf(FBoolean.FALSE);
		entDO.setDt_insert(nowTime);
		if (null != momEntDO) {
			entDO.setId_entp(momEntDO.getId_entp());
			entDO.setCode_entp(momEntDO.getCode_entp());
			entDO.setTelno_pat(momEntDO.getTelno_pat());
			entDO.setAddr_pat(momEntDO.getAddr_pat());
			entDO.setId_dep_phy(momEntDO.getId_dep_phy());
			entDO.setId_wg_phy(momEntDO.getId_wg_phy());
			entDO.setId_dep_nur(momEntDO.getId_dep_nur());
			entDO.setId_emp_phy(momEntDO.getId_emp_phy());
			entDO.setId_emp_nur(momEntDO.getId_emp_nur());
		}
		if (null != cateDO) {
			entDO.setId_patca(cateDO.getId_patca());
			entDO.setId_patcret(cateDO.getId_patcrettp());
			entDO.setId_pripat(cateDO.getId_patpritp());
		}

		return pvEP.savePv(entDO);
	}

	/**
	 * 保存新生儿住院信息
	 * 
	 * @author zhengcm
	 * @param nbDO
	 *            新生儿记录DO
	 * @throws BizException
	 */
	private InpatientDO saveNewbornIpInfo(NewbornDO nbDO, InpatientDO momIpInfo) throws BizException {
		// 新生儿母亲住院信息
//		InpatientDO momIpInfo = this.getMomIpInfo(nbDO);
		Map<String, BdEnStateTpExtDO> enMap = new EntStateEP().getBdEnStateTpExtMap(new String[]{
				IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD, IBdFcDictCodeConst.SD_ENSTSTATETP_DISE, IBdFcDictCodeConst.SD_ENSTSTATETP_NUR});
		InpatientDO ipDO = new InpatientDO();
		ipDO.setStatus(DOStatus.NEW);
		ipDO.setId_ent(nbDO.getId_ent_bb());
		ipDO.setFg_surg(FBoolean.FALSE);
		ipDO.setId_level_nur(enMap.get(IBdFcDictCodeConst.SD_ENSTSTATETP_NUR).getId_def_val());// 护理等级：三级护理
		ipDO.setSd_level_nur(enMap.get(IBdFcDictCodeConst.SD_ENSTSTATETP_NUR).getDef_val());
		ipDO.setId_level_dise(enMap.get(IBdFcDictCodeConst.SD_ENSTSTATETP_DISE).getId_def_val());// 病情等级：普通
		ipDO.setSd_level_dise(enMap.get(IBdFcDictCodeConst.SD_ENSTSTATETP_DISE).getDef_val());
		ipDO.setId_level_nutr(enMap.get(IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD).getId_def_val());// 营养等级：普通
		ipDO.setSd_level_nutr(enMap.get(IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD).getDef_val());
		ipDO.setFg_newborn(FBoolean.TRUE);
		ipDO.setNum_newborn(0);
		ipDO.setFg_doc_commit(FBoolean.FALSE);
		ipDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN);// 住院入科
		ipDO.setTimes_ip(0);//需求新生儿办理住院需重新生成住院次数，从1开始算，出生不能算作一次住院。
		if (null != momIpInfo) {
			ipDO.setCode_amr_ip(momIpInfo.getCode_amr_ip() + "B" + nbDO.getNo_bb());
			ipDO.setId_dep_phyadm(momIpInfo.getId_dep_phyadm());
			ipDO.setId_dep_nuradm(momIpInfo.getId_dep_nuradm());
			ipDO.setId_bed(momIpInfo.getId_bed());
			ipDO.setName_bed(momIpInfo.getName_bed());
		}
		new IpEP().insertIpDOs(new InpatientDO[] { ipDO });
		return ipDO;
	}

	/**
	 * 回写就诊状态表
	 * 
	 * @param entDO
	 * @param ipDO
	 * @throws BizException
	 */
	private void saveEntState(PatiVisitDO entDO, InpatientDO ipDO) throws BizException {
		if (null == entDO || null == ipDO) {
			return;
		}
		EntStateDTO disEntState = new EntStateDTO();
		disEntState.setId_ent(entDO.getId_ent());
		disEntState.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTSTATETP_DISE);
		disEntState.setVal(ipDO.getSd_level_dise());
		disEntState.setDt_occ(entDO.getDt_acpt());
		
		EntStateDTO nurEntState = new EntStateDTO();
		nurEntState.setId_ent(entDO.getId_ent());
		nurEntState.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTSTATETP_NUR);
		nurEntState.setVal(ipDO.getSd_level_nur());
		nurEntState.setDt_occ(entDO.getDt_acpt());
		
		EntStateDTO foodEntState = new EntStateDTO();
		foodEntState.setId_ent(entDO.getId_ent());
		foodEntState.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD);
		foodEntState.setVal(ipDO.getSd_level_nutr());
		foodEntState.setDt_occ(entDO.getDt_acpt());
		
		SetEntStateBP setEntStateBP = new SetEntStateBP();
		setEntStateBP.exec(new EntStateDTO[]{disEntState, nurEntState, foodEntState});
	}

	/**
	 * 保存新生儿就诊人员信息
	 * 
	 * @author zhengcm
	 * @param nbEntDO
	 *            新生儿就诊信息DO
	 * @param nowTime
	 *            当前服务器时间日期
	 * @throws BizException
	 */
	private void saveNewbornEmpInfo(PatiVisitDO nbEntDO, NewbornDO nbDO, FDateTime nowTime) throws BizException {
		EntEmpEP entEmp = new EntEmpEP();
		entEmp.endOldEmp(nbEntDO.getId_ent(), null, null);
		EnPsnDO[] emp = new EnPsnDO[5];
		// 主治大夫
		emp[0] = entEmp.createEmp(nbEntDO.getId_ent(), nbEntDO.getId_emp_phy(), IEnDictCodeConst.ID_EMPROLE_DOCTOR,
				IEnDictCodeConst.SD_EMPROLE_DOCTOR, nowTime);
		// 责任护士
		emp[1] = entEmp.createEmp(nbEntDO.getId_ent(), nbEntDO.getId_emp_nur(), IEnDictCodeConst.ID_EMPROLE_NURSE,
				IEnDictCodeConst.SD_EMPROLE_NURSE, nowTime);
		IEnIpQryService service = ServiceFinder.find(IEnIpQryService.class);
		EnDepDTO depDTO = service.getEnDepInfo(nbDO.getId_ent_mom());
		if (null != depDTO) {
			// 主任医师
			emp[2] = entEmp.createEmp(nbEntDO.getId_ent(), depDTO.getId_zr_doc(), IEnDictCodeConst.ID_EMPROLE_ZRDOC,
					IEnDictCodeConst.SD_EMPROLE_ZRDOC, nowTime);
			// 主治医师
			emp[3] = entEmp.createEmp(nbEntDO.getId_ent(), depDTO.getId_zz_doc(), IEnDictCodeConst.ID_EMPROLE_ZZDOC,
					IEnDictCodeConst.SD_EMPROLE_ZZDOC, nowTime);
			// 住院医师
			emp[4] = entEmp.createEmp(nbEntDO.getId_ent(), depDTO.getId_zy_doc(), IEnDictCodeConst.ID_EMPROLE_ZYDOC,
					IEnDictCodeConst.SD_EMPROLE_ZYDOC, nowTime);
		}
		IEnpsnCudService enpsnService = ServiceFinder.find(IEnpsnCudService.class);
		enpsnService.insert(emp);
	}

	/**
	 * 保存新生儿就诊医疗组
	 * 
	 * @author zhengcm
	 * @param nbEntDO
	 *            新生儿就诊信息DO
	 * @param nowTime
	 *            当前服务器时间日期
	 * @throws BizException
	 */
	private void saveNewbornWgInfo(PatiVisitDO nbEntDO, FDateTime nowTime) throws BizException {
		// 患者就诊_医疗组 更新 插入 操作
		EnMedGrpDO enMedGrpDO = new EnMedGrpDO();
		enMedGrpDO.setId_ent(nbEntDO.getId_ent()); // 就诊id
		enMedGrpDO.setId_wg(nbEntDO.getId_wg_phy()); // 医疗组id
		enMedGrpDO.setSd_enwgrole(IEnDictCodeConst.SD_ENWGROLE_PHY);// 角色编码
		enMedGrpDO.setId_enwgrole(IEnDictCodeConst.ID_ENWGROLE_PHY);
		enMedGrpDO.setDt_b(nowTime); // 开始时间
		enMedGrpDO.setFg_psn(FBoolean.FALSE);
		enMedGrpDO.setStatus(DOStatus.NEW);
		new EntWgEP().changeMedGrp(enMedGrpDO);
	}

	/**
	 * 获取新生儿母亲的住院信息
	 * 
	 * @author zhengcm
	 * @param nbDO
	 *            新生儿记录DO
	 * @return 新生儿母亲就诊住院信息DO
	 * @throws BizException
	 */
	private InpatientDO getMomIpInfo(NewbornDO nbDO) throws BizException {
		if (EnValidator.isEmpty(nbDO.getId_ent_mom())) {
			return null;
		}
		InpatientDO[] datas = new IpEP().getIpDOByEntId(nbDO.getId_ent_mom());
		if (!EnValidator.isEmpty(datas)) {
			return datas[0];
		}
		return null;
	}

	/**
	 * 获取当前用户对应的人员
	 * 
	 * @author zhengcm
	 * @return 当前用户对应的人员ID
	 * @throws BizException
	 */
	private String getPsndocByCurrentUser() throws BizException {
		// 用户查询服务
		IUserRService qryService = ServiceFinder.find(IUserRService.class);
		UserDO userDO = qryService.findById(Context.get().getUserId());
		if (null != userDO) {
			return userDO.getId_psn();
		}
		return null;
	}

	/**
	 * 设置登记时间和登记人员
	 * 
	 * @author zhengcm
	 * @param nbDO
	 *            新生儿记录DO
	 * @param nowTime
	 *            当前服务器时间日期
	 * @throws BizException
	 */
	private void setRegData(NewbornDO nbDO, FDateTime nowTime) throws BizException {
		nbDO.setDt_reg(nowTime);
		nbDO.setId_emp_reg(this.getPsndocByCurrentUser());
	}

	/**
	 * 创建新生儿就诊账户信息
	 *
	 * @param nbDO
	 *            新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void saveEntAccInfo(NewbornDO nbDO, PatDO nbPatDO, PatiVisitDO nbEntDO) throws BizException {
		new EnAccEP().saveEnAccData(nbPatDO.getId_pat(), nbDO.getId_ent_bb(), nbEntDO.getDt_entry(),
				nbPatDO.getId_patcrettp());
	}

	/**
	 * 插入新生儿入科固定费用
	 *
	 * @param nbEntDO
	 *            新生儿就诊信息DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void insertNewbornDcg(PatiVisitDO nbEntDO) throws BizException {
		new EnDcgEP().insertEnDcg(nbEntDO.getId_ent(), nbEntDO.getDt_entry());
	}
	
	/**
	 * 触发入科事件
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	private void invokeIpEnterDeptEvent(PatiVisitDO nbEntDO,InpatientDO ipDO,NewbornDTO nbDTO) throws BizException {
		// 1、构造事件源
		EnterDept4EsDTO enterDept4EsDTO = new EnterDept4EsDTO();
		enterDept4EsDTO.setId_ent(nbEntDO.getId_ent());
		enterDept4EsDTO.setId_pat(nbEntDO.getId_pat());
		enterDept4EsDTO.setDt_acpt(nbEntDO.getDt_acpt());
		enterDept4EsDTO.setName_pat(nbEntDO.getName_pat());
		enterDept4EsDTO.setDt_birth_pat(nbEntDO.getDt_birth_pat());
		enterDept4EsDTO.setName_dep_phy(nbEntDO.getName_dep_phy());
		enterDept4EsDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		enterDept4EsDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		enterDept4EsDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		enterDept4EsDTO.setDt_opr(EnAppUtils.getServerDateTime());
		enterDept4EsDTO.setId_dep_nur(nbEntDO.getId_dep_nur());
		enterDept4EsDTO.setCode(IEnConst.NEW);
		enterDept4EsDTO.setName_bed(ipDO.getName_bed()); //0147293
		// 新生儿字段
		enterDept4EsDTO.setNo_bb(nbDTO.getNo_bb());
		enterDept4EsDTO.setId_sex(nbDTO.getId_sex());
		enterDept4EsDTO.setSd_sex(nbDTO.getSd_sex());
		enterDept4EsDTO.setName_sex(nbDTO.getName_sex());
		enterDept4EsDTO.setDt_birth_nb(nbDTO.getDt_birth());
		enterDept4EsDTO.setId_birthtp(nbDTO.getId_birthtp());
		enterDept4EsDTO.setSd_birthtp(nbDTO.getSd_birthtp());
		enterDept4EsDTO.setName_birthtp(nbDTO.getName_birthtp());
		enterDept4EsDTO.setWeight(nbDTO.getWeight());
		enterDept4EsDTO.setHeight(nbDTO.getHeight());
		enterDept4EsDTO.setNo_birthcert(nbDTO.getNo_birthcert());
		enterDept4EsDTO.setId_newbb_health(nbDTO.getId_newbb_health());
		enterDept4EsDTO.setSd_newbb_health(nbDTO.getSd_newbb_health());
		enterDept4EsDTO.setName_newbb_health(nbDTO.getName_newbb_health());
		enterDept4EsDTO.setGestation(nbDTO.getGestation());
		enterDept4EsDTO.setGestation_dis(nbDTO.getGestation_dis());
		enterDept4EsDTO.setId_paticate(nbDTO.getId_pripat());
		enterDept4EsDTO.setSd_paticate(nbDTO.getSd_paticate());
		enterDept4EsDTO.setName_paticate(nbDTO.getName_paticate());
		enterDept4EsDTO.setFg_newborn(FBoolean.TRUE);

		// 2、触发事件
		IpEnterDeptEvent enterDeptEvent = new IpEnterDeptEvent();
		enterDeptEvent.invoke(enterDept4EsDTO);
	}
	/**
	 * 触发入院登记事件 lilei   0147292 
	 * @throws BizException 
	 */
	private void invokeIpRegEvent(PatiVisitDO patiVisitDO,InpatientDO inpatientDO) throws BizException{
		// 1、构造事件源
		IpReg4EsDTO esDTO = new IpReg4EsDTO();
		esDTO.setIsnew(FBoolean.TRUE);	
		esDTO.setId_ent(patiVisitDO.getId_ent());
		esDTO.setCode_ent(patiVisitDO.getCode());// 就诊编码
		esDTO.setCode_pat(patiVisitDO.getCode_pat());//患者编码
		esDTO.setId_pat(patiVisitDO.getId_pat());// 患者ID，传patient_id
		esDTO.setName_pat(patiVisitDO.getName_pat());// 患者姓名
		esDTO.setDt_birth_pat(patiVisitDO.getDt_birth_pat());// 出生日期
		esDTO.setId_dep_phy(patiVisitDO.getId_dep_phy());
		esDTO.setId_dep_nur(patiVisitDO.getId_dep_nur());

		esDTO.setName_bed(inpatientDO.getName_bed());

		esDTO.setSd_referalsrc(inpatientDO.getSd_referalsrc());
		esDTO.setReferalsrc_name(inpatientDO.getName_referalsrc());
		esDTO.setSd_level_diseadm(inpatientDO.getSd_level_diseadm());
		esDTO.setName_level_diseadm(inpatientDO.getName_level_diseadm());
		esDTO.setId_prim(patiVisitDO.getId_hp());

		esDTO.setSd_sex(patiVisitDO.getSd_sex_pat());
		esDTO.setName_paticate(patiVisitDO.getName_patca());
		esDTO.setSd_paticate(patiVisitDO.getSd_patca());
	
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		esDTO.setDt_acpt(patiVisitDO.getDt_entry());
		esDTO.setSd_emp_ry(inpatientDO.getCode_emp_phy_op());//门诊医生sd
		esDTO.setName_emp_ry(inpatientDO.getName_emp_phy_op());//门诊医生
		esDTO.setCode_enttp(patiVisitDO.getCode_entp());//就诊类型编码
		esDTO.setName_enttp(patiVisitDO.getName_entp());//就诊类型名称
		esDTO.setFg_newborn(FBoolean.TRUE);
		if(inpatientDO!=null){
			esDTO.setCode_amr_ip(inpatientDO.getCode_amr_ip()); // 就诊号，传inpatient_no
			esDTO.setTimes_ip(inpatientDO.getTimes_ip());
		}
		// 2、触发事件
		IpRegEvent ipRegEvent = new IpRegEvent();
		ipRegEvent.invoke(esDTO);
	}
	
	/**
	 * 触发事件 保存医务人员
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	private void invokeIpEnterDeptEvent(PatiVisitDO nbEntDO) throws BizException {
		// 1、构造事件源
		ChgEmp4EsDTO esDTO = new ChgEmp4EsDTO();
		esDTO.setId_ent( nbEntDO.getId_ent());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		
		// 2、触发事件
		IpChgEmpEvent enterDeptEvent = new IpChgEmpEvent();
		enterDeptEvent.invoke(esDTO);
	}
}
