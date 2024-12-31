package iih.bl.cg.s.bp.ip;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.bdpriadm.d.BDPriAdmDO;
import iih.bd.pp.bdpriadm.i.IBdpriadmRService;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPriCalcService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.service.d.BlOrderRefundBillParamDTO;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.bl.cg.service.s.bp.IBLOrderAppendBillServiceImplBp;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 入院登记自动记账接口
 * 
 * @author ly 2018/02/06
 *
 */
public class BlIpChargeForIpRegisterBP {

	/**
	 * 入院登记自动记账
	 * 
	 * @param entId 就诊id
	 * @param fgFirst 是否首次住院
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String entId, FBoolean fgFirst) throws BizException {

		//参数校验
		this.validateParam(entId, fgFirst);

		//1.相关就诊信息查询
		String[] datas = this.prepareEnData(entId);
		String patId = datas[0];
		String nurDepId = datas[1];

		//2.查询计费配置信息
		BDPriAdmDO[] sets = this.getPriSet(nurDepId);

		//3.已记账判断
		//查询本次记账数据
		BlCgIpDO[] ipDos = this.getCgIpDatasThisTime(entId);

		//病区变化判断
		this.dealWhenDepNurChanged(ipDos, entId, nurDepId);

		//已记账判断
		if (this.hasAccounting(ipDos, nurDepId))
			return FBoolean.TRUE;

		//配置信息判断
		if (ArrayUtil.isEmpty(sets))
			return FBoolean.TRUE;

		//4.记账
		//计费服务项目过滤
		BDPriAdmDO[] accSetList = this.filterSrvData(sets, fgFirst);
		if (!ArrayUtil.isEmpty(accSetList)){
			//住院记账处理
			this.chargeOld(patId, entId, accSetList);
		}

		return FBoolean.TRUE;
	}

	/**
	 * 校验参数
	 * 
	 * @param entId
	 * @param fgFirstcosp
	 * @throws BizException
	 */
	private void validateParam(String entId, FBoolean fgFirst) throws BizException {
		if (StringUtil.isEmpty(entId)) {
			throw new ArgumentNullException("入院登记自动记账", "entId");
		}

		if (fgFirst == null) {
			throw new ArgumentNullException("入院登记自动记账", "fgFirst");
		}
	}

	/**
	 * 准备就诊数据
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private String[] prepareEnData(String entId) throws BizException {
		String[] datas = new String[2];
		PatiVisitDO enDo = (PatiVisitDO) new DAFacade().findByPK( PatiVisitDO.class, entId, 
				new String[] { PatiVisitDO.ID_PAT, PatiVisitDO.ID_DEP_NUR });

		if (enDo == null) {
			throw new BizException("入院登记自动记账:未查询到就诊记录");
		}

		datas[0] = enDo.getId_pat();
		datas[1] = enDo.getId_dep_nur();

		return datas;
	}
	
	/**
	 * 获取收费配置 优先科室级别，无科室级别使用全院级别
	 * 
	 * @param nurDepId
	 * @return
	 * @throws BizException
	 */
	private BDPriAdmDO[] getPriSet(String nurDepId) throws BizException {

		IBdpriadmRService rService = ServiceFinder
				.find(IBdpriadmRService.class);
		String whereSql = BDPriAdmDO.SD_OWTP + " = '"
				+ IBdPpCodeTypeConst.SD_OWTP_ALL + "' " + "or ("
				+ BDPriAdmDO.SD_OWTP + " = '" + IBdPpCodeTypeConst.SD_OWTP_DEP
				+ "' and " + BDPriAdmDO.ID_DEP + " = '" + nurDepId + "') ";

		BDPriAdmDO[] admDos = rService.find(whereSql, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(admDos))
			return null;

		List<BDPriAdmDO> allAdmList = new ArrayList<BDPriAdmDO>();
		List<BDPriAdmDO> depAdmList = new ArrayList<BDPriAdmDO>();
		for (BDPriAdmDO admDo : admDos) {
			if (IBdPpCodeTypeConst.SD_OWTP_ALL.equals(admDo.getSd_owtp())) {
				allAdmList.add(admDo);
			} else {
				depAdmList.add(admDo);
			}
		}

		if (depAdmList.size() > 0) {
			return depAdmList.toArray(new BDPriAdmDO[0]);
		}

		return allAdmList.toArray(new BDPriAdmDO[0]);
	}

	/**
	 * 查询本次就诊记账数据
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlCgIpDO[] getCgIpDatasThisTime(String entId) throws BizException {

		String sql = "select id_cgip,id_dep_nur from bl_cg_ip where "
				+ "eu_direct = 1 and fg_refund = 'N' "
				+ "and eu_srctp = ? and srcfunc_des = ? ";
		SqlParam param = new SqlParam();
		param.addParam(FeeOriginEnum.ENCOUNTER_FEE);
		param.addParam(IBlCgCodeConst.IpRegister);

		if (!StringUtil.isEmpty(entId)) {
			sql += "and id_ent = ? ";
			param.addParam(entId);
		}

		List<BlCgIpDO> list = (List<BlCgIpDO>) new DAFacade().execQuery(sql,
				param, new BeanListHandler(BlCgIpDO.class));

		if (ListUtil.isEmpty(list))
			return null;
		return list.toArray(new BlCgIpDO[0]);
	}

	/**
	 * 处理病区变化
	 * 
	 * @param ipDos
	 * @param entId
	 * @param nurDepId
	 * @throws BizException
	 */
	private void dealWhenDepNurChanged(BlCgIpDO[] ipDos, String entId,
			String nurDepId) throws BizException {

		if (ArrayUtil.isEmpty(ipDos))
			return;

		List<BlCgIpDO> diffList = new ArrayList<BlCgIpDO>();
		for (BlCgIpDO ipDo : ipDos) {
			if (!nurDepId.equals(ipDo.getId_dep_nur())) {
				diffList.add(ipDo);
			}
		}

		if (diffList.size() == 0)
			return;

		//红冲处理
		List<BlOrderAppendBillParamDTO> OrginBlOrderAppendBillParamDTOList = new ArrayList<BlOrderAppendBillParamDTO>();
		for (BlCgIpDO idDo : diffList) {
			BlOrderAppendBillParamDTO dto = new BlOrderAppendBillParamDTO();
			BlOrderRefundBillParamDTO refundBillDTO = new BlOrderRefundBillParamDTO();
			refundBillDTO.setId_cg_pk(idDo.getId_cgip());
			refundBillDTO.setId_org_cg(Context.get().getOrgId());
			refundBillDTO.setId_dep_cg(Context.get().getDeptId());
			refundBillDTO.setId_emp_cg(Context.get().getStuffId());
			refundBillDTO.setId_ent(entId);
			dto.setSrcfunc_des(IBlCgCodeConst.IpRegister);
			dto.setRefundBillParamDTO(refundBillDTO);
			dto.setId_ent(entId);
			OrginBlOrderAppendBillParamDTOList.add(dto);
		}
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		bp.SetOrderRefundBill(OrginBlOrderAppendBillParamDTOList
				.toArray(new BlOrderAppendBillParamDTO[] {}), false,
				IBdFcDictCodeConst.SD_CODE_ENTP_IP);
	}

	/**
	 * 判断是否已经记账
	 * 
	 * @param ipDos
	 * @param nurDepId
	 * @return
	 */
	private boolean hasAccounting(BlCgIpDO[] ipDos, String nurDepId) {

		if (ArrayUtil.isEmpty(ipDos))
			return false;

		for (BlCgIpDO ipDo : ipDos) {
			if (nurDepId.equals(ipDo.getId_dep_nur())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 过滤需要计费项目
	 * 
	 * @param sets
	 * @param fgFirst
	 * @return
	 * @throws BizException
	 */
	private BDPriAdmDO[] filterSrvData(BDPriAdmDO[] sets, FBoolean fgFirst) throws BizException {

		List<BDPriAdmDO> rltList = new ArrayList<BDPriAdmDO>();
		for (BDPriAdmDO set : sets) {
			if(FBoolean.FALSE.equals(set.getFg_pay_firstadm())){
				rltList.add(set);
			}else if(FBoolean.TRUE.equals(fgFirst)){
				rltList.add(set);
			}
		}

		return rltList.toArray(new BDPriAdmDO[0]);
	}

	/**
	 * 住院记账(新逻辑)
	 * @param entId
	 * @param accSetArr
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void charge(String patId, String entId, BDPriAdmDO[] accSetArr) throws BizException {

		//TODO
	}
	
	/**
	 * 住院记账(旧逻辑)
	 * @param entId
	 * @param accSetArr
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void chargeOld(String patId, String entId, BDPriAdmDO[] accSetArr)throws BizException {

		DAFacade daf = new DAFacade();
		// 就诊信息
		PatiVisitDO enDO = (PatiVisitDO) daf.findByPK(PatiVisitDO.class, entId);

		// 服务信息
		List<String> srvIds = new ArrayList<String>();
		Map<String, MedSrvDO> srvMap = new HashMap<String, MedSrvDO>();
		for (BDPriAdmDO admDO : accSetArr) {
			srvIds.add(admDO.getId_srv());
		}

		List<MedSrvDO> srvDoList = (List<MedSrvDO>) daf.findByPKs(
				MedSrvDO.class, srvIds.toArray(new String[0]));
		if (!ListUtil.isEmpty(srvDoList)) {
			for (MedSrvDO srvDo : srvDoList) {
				srvMap.put(srvDo.getId_srv(), srvDo);
			}
		}

		// 价格信息
		IBdPriCalcService priService = ServiceFinder
				.find(IBdPriCalcService.class);
		Map<String, PriceResultDTO> priMap = priService.batchCalcPatPrice(
				srvIds.toArray(new String[0]), enDO.getId_pripat());

		// 组装记账数据
		FDateTime now = new FDateTime()     ;
		List<BlOrderAppendBillParamDTO> billParamList = new ArrayList<BlOrderAppendBillParamDTO>();

		for (BDPriAdmDO admDO : accSetArr) {

			BlOrderAppendBillParamDTO blCgDTO = new BlOrderAppendBillParamDTO();
			//患者就诊数据
			blCgDTO.setId_pat(enDO.getId_pat());
			blCgDTO.setId_ent(enDO.getId_ent());
			blCgDTO.setId_enttp(enDO.getId_entp());
			blCgDTO.setCode_enttp(enDO.getCode_entp());

			// 服务信息
			MedSrvDO medSrvDO = srvMap.get(admDO.getId_srv());
			blCgDTO.setId_srvtp(medSrvDO.getId_srvtp());
			blCgDTO.setSd_srvtp(medSrvDO.getSd_srvtp());
			blCgDTO.setId_srvca(medSrvDO.getId_srvca());
			blCgDTO.setId_srv(medSrvDO.getId_srv());
			blCgDTO.setCode_srv(medSrvDO.getCode());
			blCgDTO.setName_srv(medSrvDO.getName());
			blCgDTO.setSrvu(medSrvDO.getId_unit_med());

			// 价格信息 admDO.getId_srv()
			PriceResultDTO pri = priMap.get(admDO.getId_srv());
			if (pri == null) {
				continue;
			}
			blCgDTO.setPri_std(pri.getPrice_std());
			blCgDTO.setRatio_pripat(pri.getPrice_ratio());
			blCgDTO.setPri_ratio(pri.getRate());
			blCgDTO.setQuan(new FDouble(admDO.getQuan())); // 数量
			blCgDTO.setAmt_std(PrecisionUtils.formatAmt(pri.getPrice_std()
					.multiply(blCgDTO.getQuan()))); //标准金额=标准价格*数量
			blCgDTO.setAmt_ratio(PrecisionUtils.formatAmt(pri.getPrice_ratio()
					.multiply(blCgDTO.getQuan()))); //金额_价格比例=折后价格(标准价格*价格比例)*数量   
			blCgDTO.setAmt_pat(blCgDTO.getAmt_ratio());// 自付金额=折后金额
			blCgDTO.setAmt(blCgDTO.getAmt_ratio()); // 金额=折后金额
			blCgDTO.setAmt_hp(FDouble.ZERO_DBL);

			// 记账信息
			blCgDTO.setId_org(enDO.getId_org());
			blCgDTO.setId_grp(enDO.getId_grp());
			blCgDTO.setId_emp_cg(Context.get().getStuffId());// 记账员
			blCgDTO.setId_org_cg(enDO.getId_org());
			blCgDTO.setId_dep_cg(null);// 记账科室
			blCgDTO.setId_dep_mp(enDO.getId_dep_nur());// 执行科室默认为病区
			blCgDTO.setFg_mm(FBoolean.FALSE);
			blCgDTO.setDt_cg(now);
			blCgDTO.setSupportAppendBill(FBoolean.TRUE);// 后台划价支持后付费
			blCgDTO.setDt_last_bl(now);// 计费时间
			blCgDTO.setEu_direct(BookRtnDirectEnum.CHARGE);// 收费
			blCgDTO.setSrcfunc_des(IBlCgCodeConst.IpRegister);// 来源入院登记自动记账
			blCgDTO.setId_pripat(enDO.getId_pripat());//患者价格分类
			
			BlOrderAppendInpBillParamDTO inpBillDTO = new BlOrderAppendInpBillParamDTO();
			inpBillDTO.setFg_pddisc(null);// 出院带药标志
			inpBillDTO.setId_wg_or(null);// 医疗组
			inpBillDTO.setId_dep_nur(enDO.getId_dep_nur());
			inpBillDTO.setFg_bb(FBoolean.FALSE);// 婴儿标志
			blCgDTO.setInpBillDTO(inpBillDTO);

			billParamList.add(blCgDTO);
		}

		IBLOrderAppendBillService billService = ServiceFinder.find(IBLOrderAppendBillService.class);
		billService.SetOrderAppendBill_ByItms(
				billParamList.toArray(new BlOrderAppendBillParamDTO[0]),enDO.getCode_entp());
	}
}
