package iih.bl.hp.s.miparampack;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.hp.i.IBlHpQryService;
import iih.bl.hp.rural.dto.d.RuralPersonInfoDTO;
import iih.ci.mr.cimr.d.desc.JudgeIdentity.identity;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.pv.enhpreferral.d.EnHpReferralDO;
import iih.en.pv.enhpreferral.i.IEnhpreferralRService;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.mi.biz.dto.d.InpPayDataDTO;
import iih.mi.biz.dto.d.InpPayInParamDTO;
import iih.mi.biz.dto.d.ParamAttributeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.securityfw.switchdept.d.PsnInfo;

/**
 * 
 * @author wq.li
 * 2018-4-9 21:46:10
 *
 */
public class GetInpPrePayParamBp {
/**
 * 拼装预结入参据
 * @param entId
 * @param psnInfo
 * @param attrDto
 * @return
 * @throws BizException
 */
	public InpPayInParamDTO exec(String entId,PsnInfo psnInfo,
			ParamAttributeDTO attrDto) throws BizException {
		InpPayInParamDTO inpPayInParam = new InpPayInParamDTO();

		// 人员信息
		IBlHpQryService blHpQryService = ServiceFinder
				.find(IBlHpQryService.class);
		RuralPersonInfoDTO ruralPersonInfo = blHpQryService
				.getRuralPersonInfo(entId);

		IEnOutQryService ieService = ServiceFinder.find(IEnOutQryService.class);
		IpHpRegistDTO hpRegistDTO = ieService.getIpHpRegist(entId);
		// 转诊单数据
		IEnhpreferralRService referralService = ServiceFinder
				.find(IEnhpreferralRService.class);
		EnHpReferralDO[] referralDoArr = referralService.findByAttrValString(
				"Id_ent", entId);// 转诊单
		if (referralDoArr == null || referralDoArr.length <= 0) {
			throw new BizException("该患者转诊单数据为空");
		}
		EnHpReferralDO enHpReferralDO = referralDoArr[0];
		// 诊断信息
		ICiOrdQryService ciOrdQryService = ServiceFinder
				.find(ICiOrdQryService.class);
		EntDiDO[] entDiDOList = ciOrdQryService.getEntDiDOList(entId);
		if (entDiDOList == null || entDiDOList.length <= 0) {
			throw new BizException("该患者诊断信息为空");
		}
		// 诊断信息
		EntDiDO entDiDo = entDiDOList[0];
		//住院医保登记信息
		IpHpRegistDTO iDto = getIpHpRegistDTO(entId);
		// 获取当前时间
		FDateTime nowDateTime = AppUtils.getServerDateTime();
		/***** 一级参数 *****/
		inpPayInParam.setChareacode(ruralPersonInfo.getCh_areacode());// 患者参合地区编码
		inpPayInParam.setInpno(ruralPersonInfo.getHp_serialno());// 患者住院登记流水号
		inpPayInParam.setOperator(Context.get().getUserId());// 操作人
		inpPayInParam.setRedeemdate(nowDateTime);// 兑付日期
		inpPayInParam.setRedeemorgno("4120140519103528937");// 补偿机构编码
		/****** 二级参数 *******/
		InpPayDataDTO payDataDto = new InpPayDataDTO();
		GetCodeByCustomization codeUtil = new GetCodeByCustomization();
		String stCode = codeUtil.GetCodeStIp();
		payDataDto.setBillcode(stCode);// his系统单据编码
		payDataDto.setInpno(ruralPersonInfo.getHp_serialno()); // 住院登记流水号
		// 医疗机构信息
		payDataDto.setOperatorcode(psnInfo.getCode()); // 医院信息系统操作者代码
		payDataDto.setOperatorname(psnInfo.getName());// 医院信息系统操作者姓名
		// 患者信息
		payDataDto.setPatname(ruralPersonInfo.getPatname());// 患者姓名
		payDataDto.setSexcode(ruralPersonInfo.getSexcode());// 患者性别编码
		if (IPiDictCodeConst.SD_SEX_FEMALE.equals(ruralPersonInfo.getSexcode())) {
			payDataDto.setSexname(IPiDictCodeConst.NAME_SEX_FEMALE);// 患者性别名称
		} else if (IPiDictCodeConst.SD_SEX_MALE.equals(ruralPersonInfo
				.getSexcode())) {
			payDataDto.setSexname(IPiDictCodeConst.NAME_SEX_MALE);// 患者性别名称
		} else if (IPiDictCodeConst.SD_SEX_UNEXPLAIN.equals(ruralPersonInfo
				.getSexcode())) {
			payDataDto.setSexname(IPiDictCodeConst.NAME_SEX_UNEXPLAIN);// 患者性别名称
		} else if (IPiDictCodeConst.SD_SEX_UNKNOW.equals(ruralPersonInfo
				.getSexcode())) {
			payDataDto.setSexname(IPiDictCodeConst.NAME_SEX_UNKNOW);// 患者性别名称
		}
		payDataDto.setIdcard(ruralPersonInfo.getIdcard());// 患者身份证号
		Integer age = getAge(enHpReferralDO.getBirthday());
		payDataDto.setAge(age.toString());// 年龄
		payDataDto.setAddress(enHpReferralDO.getIdcardstore());// 通信地址
		payDataDto.setBirth(new FDateTime(enHpReferralDO.getBirthday().toString()+" 00:00:00"));// 出生日期
		// 参合信息
		payDataDto.setChprovcode(enHpReferralDO.getChprovcode());// 参合省代码
		payDataDto.setChprovname(enHpReferralDO.getChprovname());// 参合省名称
		payDataDto.setChcitycode(enHpReferralDO.getChcitycode());// 参合市代码
		payDataDto.setChcityname(enHpReferralDO.getChcityname());// 参合市名称
		payDataDto.setChareacode(enHpReferralDO.getChareacode());// 参合区代码
		payDataDto.setChareaname(enHpReferralDO.getChareaname());// 参合区名称
		payDataDto.setContactor(enHpReferralDO.getPatcontactor());// 联系人姓名
		payDataDto.setPhone(enHpReferralDO.getPatphone());// 电话号码
		// 就诊信息
		payDataDto.setEnttpcode(ruralPersonInfo.getEnttype_code());// 就诊类型编码
		payDataDto.setEnttpname(ruralPersonInfo.getEnttype_name());// 就诊类型名称
		payDataDto.setDt_entry(hpRegistDTO.getDt_entry());// 入院时间
		FDateTime dt_end = hpRegistDTO.getDt_end() == null ? new FDateTime() : hpRegistDTO.getDt_end();
		payDataDto.setDt_end(dt_end);// 出院时间
		payDataDto.setEnt_code(ruralPersonInfo.getEnt_code());// 住院号
		payDataDto.setMedicalcode(ruralPersonInfo.getMedicalcode());// 医疗证、卡号

		// ci
		payDataDto.setMaindicode(entDiDo.getCode_didef_dis());// 主要诊断
		payDataDto.setMaindiname(entDiDo.getName_didef_dis());// 主诊断名称
		payDataDto.setOtherdicode("");// 其他诊断代码
		payDataDto.setOtherdiname("");// 其他诊断名称
		payDataDto.setSurgerycode("");// 手术名称代码
		payDataDto.setSurgeryname("");// 手术名称
		payDataDto.setNeopathycode("");// 并发症代码
		payDataDto.setNeopathyname("");// 并发症名称

		// en
		payDataDto.setDepincode(iDto.getCode_dep_phyadm());// 入院科室代码
		payDataDto.setDepinname(iDto.getName_dep_phyadm());// 入院科室名称
		payDataDto.setDepoutcode(iDto.getCode_dep_phy());// 出院科室编码
		payDataDto.setDepoutname(iDto.getName_dep_phy());// 出院科室名称
		payDataDto.setInhos_status(iDto.getCode_level_diseadm());// 入院状态编码
		payDataDto.setInhos_statusname(iDto.getName_level_diseadm());// 入院状态名称
		payDataDto.setOuthos_status(iDto.getId_outcomes());// 出院状态代码
		payDataDto.setOuthos_statusname("");// 出院状态名称
		payDataDto.setDoctor(iDto.getName_emp_phy());// 医生姓名
		payDataDto.setOuthosnote("");// 出院情况
		payDataDto.setHealthcard("");// 居民健康卡

		// 查询明细上传费用信息
		StringBuffer sqlb = new StringBuffer();
		sqlb.append(" SELECT ");
		sqlb.append(" SUM (AMT_HP*EU_DIRECT) Hp_amtall, ");
		sqlb.append(" SUM (AMT_RATIO*EU_DIRECT) Amt_all ");
		sqlb.append(" FROM ");
		sqlb.append(" BL_CG_IP ");
		sqlb.append(" where ID_ENT = ? ");
		sqlb.append(" AND FG_ST = 'N' ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(entId);
		DAFacade dafacade = new DAFacade();
		List<InpPayDataDTO> amtInfos = (List<InpPayDataDTO>) dafacade
				.execQuery(sqlb.toString(), sqlp, new BeanListHandler(
						InpPayDataDTO.class));
		if (amtInfos == null || amtInfos.size() <= 0) {
			payDataDto.setAmt_all(new FDouble(0.00));// 费用总额
			payDataDto.setHp_amtall(new FDouble(0.00));// 可报销金额
		} else {
			payDataDto.setAmt_all(amtInfos.get(0).getAmt_all());// 费用总额
			payDataDto.setHp_amtall(amtInfos.get(0).getHp_amtall());// 可报销金额
		}

		payDataDto.setHppolicy(String.valueOf(nowDateTime.getYear()));// 年度
		payDataDto.setCreatedate(nowDateTime);// 创建时间
		payDataDto.setUpdatedate(nowDateTime);// 更新时间
		payDataDto.setDt_st(nowDateTime);// 结算日期
//		payDataDto.setDrgsamt("");// 单病种费用定额
//		payDataDto.setCivilamt("");// 民政补助补偿额
//		payDataDto.setBigill_amt("");// 大病保险可补偿额
//		payDataDto.setBigill_amtactual("");// 大病保险实际报销金额
		FArrayList inppayData = new FArrayList();
		inppayData.add(payDataDto);
		inpPayInParam.setInppaydata(inppayData);

		return inpPayInParam;
	}

	/**
	 * 通过出生日期计算年龄
	 * 
	 * @param birth
	 * @return
	 */
	private Integer getAge(FDate birth) {
		if (birth == null) {
			return 0;
		}
		Integer age = 0;
		Date now = new Date();
		SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
		SimpleDateFormat format_M = new SimpleDateFormat("MM");
		String birth_year = String.valueOf(birth.getYear());
		String this_year = format_y.format(now);
		String birth_month = String.valueOf(birth.getMonth());
		String this_month = format_M.format(now);
		// 初步，估算
		age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);
		// 如果未到出生月份，则age - 1
		if (this_month.compareTo(birth_month) < 0)
			age -= 1;
		if (age < 0)
			age = 0;
		return age;
	}
	/**
	 * 
	* @Description: 获取患者住院登记医保信息
	* @param @param entId
	* @param @return
	* @param @throws BizException    
	* @return IpHpRegistDTO    
	* @throws
	 */
	private IpHpRegistDTO getIpHpRegistDTO(String entId) throws BizException{
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		IpHpRegistDTO ipHpRegistDTO = service.getIpHpRegist(entId);
		return ipHpRegistDTO;
	}
}
