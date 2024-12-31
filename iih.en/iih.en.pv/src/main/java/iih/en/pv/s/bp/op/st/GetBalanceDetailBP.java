package iih.en.pv.s.bp.op.st;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendIncParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendOutpBillParamDTO;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.comm.IBlCgFuncConst;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.RelSrvDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 设置挂号结算明细数据
 * @author yank
 *
 */
public class GetBalanceDetailBP {
	/**
	 * 设置挂号结算明细数据
	 * 
	 * @param patId 患者id
	 * @param regInfo 挂号信息
	 * @param pvDO 就诊DO
	 * @param fgPostPay 是否为后付费
	 * @return
	 * @throws BizException
	 */
	public ArrayList<BlOrderAppendBillParamDTO> exec(RegInfoDTO regInfo, PatiVisitDO pvDO,
			FBoolean fgPostPay) throws BizException {
		ArrayList<BlOrderAppendBillParamDTO> billList = new ArrayList<BlOrderAppendBillParamDTO>();
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		FArrayList array = regInfo.getRegresarray();
		if (array == null || array.size() <= 0) {
			throw new BizException("挂号资源信息为空！");
		}
		RegResDTO resDTO = (RegResDTO) array.get(0);
		if(resDTO.getSrvarray()==null || resDTO.getSrvarray().size() <= 0){
			throw new BizException(String.format("挂号排班服务[%s]未维护正确的诊疗项目！", getScSRvName(resDTO.getId_scsrv())));
		}
		for (Object obj : resDTO.getSrvarray()) {
			RelSrvDTO relSrvDTO = (RelSrvDTO) obj;
			MedSrvDO srvDO = medsrvMDORService.findById(relSrvDTO.getId_srv());
			if(srvDO == null){
				throw new BizException(String.format("挂号排班服务[%s]未维护正确的诊疗项目！", getScSRvName(resDTO.getId_scsrv())));
			}
			BlOrderAppendBillParamDTO billDTO = new BlOrderAppendBillParamDTO();
				billDTO.setId_pat(regInfo.getId_pat()); // 患者id
			billDTO.setId_ent(pvDO.getId_ent()); // 就诊id
			billDTO.setId_enttp(pvDO.getId_entp()); // 就诊类型id
			billDTO.setCode_enttp(pvDO.getCode_entp()); // 就诊类型编码

			billDTO.setId_srvtp(srvDO.getId_srvtp()); // 服务类型
			billDTO.setSd_srvtp(srvDO.getSd_srvtp()); // 服务类型编码
			billDTO.setId_srvca(srvDO.getId_srvca()); // 服务项目分类
			billDTO.setId_srv(srvDO.getId_srv()); // 服务项目ID
			billDTO.setCode_srv(srvDO.getCode()); // 服务项目编码
			billDTO.setName_srv(srvDO.getName()); // 服务项目名称
			billDTO.setSrvu(srvDO.getId_unit_med()); // 服务项目单位
			billDTO.setQuan(new FDouble(1)); // 数量

			billDTO.setId_hp(pvDO.getId_hp()); // 医保计划
			// billDTO.setRatio_hp(priceDetail.getRatio_hp()); //医保自付比例
			billDTO.setId_pripat(regInfo.getId_pripat()); // 价格分类
			// billDTO.setRatio_pripat(priceDetail.getRatio_pripat()); //价格比例
			// TODO
			billDTO.setPrice(relSrvDTO.getAmt_st()); // 标准价格
			billDTO.setAmt_std(relSrvDTO.getAmt_st());// 标准金额
			billDTO.setAmt_ratio(relSrvDTO.getAmt_st());// 应收金额
			billDTO.setAmt_hp(relSrvDTO.getAmt_hp() == null ? new FDouble(0) : relSrvDTO.getAmt_hp()); // 医保承担金额
			billDTO.setAmt_pat(relSrvDTO.getAmt_pat() == null ? relSrvDTO.getAmt_st() : relSrvDTO.getAmt_pat());// 患者支付金额
			billDTO.setAmt(relSrvDTO.getAmt() == null && relSrvDTO.getAmt().isTrimZero() ? relSrvDTO.getAmt_st()
					: relSrvDTO.getAmt());// 支付金额
			billDTO.setEu_srctp(FeeOriginEnum.ENCOUNTER_FEE);// 费用来源类型--就诊

			billDTO.setFg_mm(FBoolean.FALSE);
			billDTO.setId_grp(pvDO.getId_grp()); // 集团
			billDTO.setId_org(pvDO.getId_org()); // 机构
			
			billDTO.setId_org_or(pvDO.getId_org()); // 开立机构
			billDTO.setId_dep_or(pvDO.getId_dep_phy()); // 开立科室
			billDTO.setId_emp_or(EnContextUtils.getPsnId()); // 开立医生，暂空
			billDTO.setDt_or(pvDO.getDt_entry()); // 开立时间
			
			billDTO.setId_org_mp(pvDO.getId_org()); // 执行机构
			billDTO.setId_dep_mp(pvDO.getId_dep_phy());// 执行科室

			billDTO.setId_org_cg(EnContextUtils.getOrgId());// 记账组织
			billDTO.setId_dep_cg(EnContextUtils.getDeptId());// 记账科室
			billDTO.setId_emp_cg(EnContextUtils.getPsnId());// 记账人员

			billDTO.setEu_direct(Integer.parseInt(IBlDictCodeConst.SD_DIRECT_CHARGE));// 收费
			billDTO.setEu_srctp(FeeOriginEnum.ENCOUNTER_FEE);// 数据来源：就诊产生
			// 门诊记帐DTO
			BlOrderAppendOutpBillParamDTO opBillDTO = new BlOrderAppendOutpBillParamDTO();
			opBillDTO.setFg_acc(FBoolean.FALSE);
			//增加高端商保支持
			if(!EnValidator.isEmpty(pvDO.getId_hp())){
				IEnOutQryService enOutQryService = ServiceFinder.find(IEnOutQryService.class);
				FBoolean isHgcg = enOutQryService.isHpCmCl(pvDO.getId_hp());
				if(FBoolean.TRUE.equals(isHgcg)){
					opBillDTO.setFg_hpcg(FBoolean.TRUE);//高端商保
				}
			}
			billDTO.setOutpBillDTO(opBillDTO);

			billDTO.setSupportAppendBill(fgPostPay);// 后付费

			// 发票信息
			BlOrderAppendIncParamDTO opIncDTO = new BlOrderAppendIncParamDTO();
			opIncDTO.setId_emp_inc(regInfo.getId_emp_entry());
			opIncDTO.setCode_incca(IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE);
			// opIncDTO.setCode_incpkg(regInfo.getInvno());//发票号
			billDTO.setIncBillDTO(opIncDTO);
			billDTO.setSrcfunc_des(IBlCgCodeConst.RegisterFee); //费用来源描述:挂号费
			billDTO.setFg_pricinginsertcg(FBoolean.TRUE);
			billList.add(billDTO);
		}

		return billList;

	}
	/**
	 * 设置挂号结算明细数据
	 * 
	 * @param patId 患者id
	 * @param regInfo 挂号信息
	 * @param pvDO 就诊DO
	 * @param fgPostPay 是否为后付费
	 * @return
	 * @throws BizException
	 */
	public ArrayList<BlOrderAppendBillParamDTO> prePay(RegInfoDTO regInfo, PatiVisitDO pvDO) throws BizException {
		ArrayList<BlOrderAppendBillParamDTO> billList = new ArrayList<BlOrderAppendBillParamDTO>();
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		FArrayList array = regInfo.getRegresarray();
		if (array == null || array.size() <= 0) {
			throw new BizException("挂号资源信息为空！");
		}
		RegResDTO resDTO = (RegResDTO) array.get(0);
		if(resDTO.getSrvarray()==null || resDTO.getSrvarray().size() <= 0){
			throw new BizException(String.format("挂号排班服务[%s]未维护正确的诊疗项目！", getScSRvName(resDTO.getId_scsrv())));
		}
		for (Object obj : resDTO.getSrvarray()) {
			RelSrvDTO relSrvDTO = (RelSrvDTO) obj;
			MedSrvDO srvDO = medsrvMDORService.findById(relSrvDTO.getId_srv());
			if(srvDO == null){
				throw new BizException(String.format("挂号排班服务[%s]未维护正确的诊疗项目！", getScSRvName(resDTO.getId_scsrv())));
			}
			BlOrderAppendBillParamDTO billDTO = new BlOrderAppendBillParamDTO();
			billDTO.setId_pat(regInfo.getId_pat()); // 患者id
			billDTO.setId_ent(pvDO.getId_ent()); // 就诊id
			billDTO.setId_enttp(pvDO.getId_entp()); // 就诊类型id
			billDTO.setCode_enttp(pvDO.getCode_entp()); // 就诊类型编码

			billDTO.setId_srvtp(srvDO.getId_srvtp()); // 服务类型
			billDTO.setSd_srvtp(srvDO.getSd_srvtp()); // 服务类型编码
			billDTO.setId_srvca(srvDO.getId_srvca()); // 服务项目分类
			billDTO.setId_srv(srvDO.getId_srv()); // 服务项目ID
			billDTO.setCode_srv(srvDO.getCode()); // 服务项目编码
			billDTO.setName_srv(srvDO.getName()); // 服务项目名称
			billDTO.setSrvu(srvDO.getId_unit_med()); // 服务项目单位
			billDTO.setQuan(new FDouble(1)); // 数量

			billDTO.setId_hp(pvDO.getId_hp()); // 医保计划
			// billDTO.setRatio_hp(priceDetail.getRatio_hp()); //医保自付比例
			billDTO.setId_pripat(regInfo.getId_pripat()); // 价格分类
			// billDTO.setRatio_pripat(priceDetail.getRatio_pripat()); //价格比例
			// TODO
//			billDTO.setPrice(relSrvDTO.getAmt_st()); // 标准价格
//			billDTO.setAmt_std(relSrvDTO.getAmt_st());// 标准金额
//			billDTO.setAmt_ratio(relSrvDTO.getAmt_st());// 应收金额
//			billDTO.setAmt_hp(relSrvDTO.getAmt_hp() == null ? new FDouble(0) : relSrvDTO.getAmt_hp()); // 医保承担金额
//			billDTO.setAmt_pat(relSrvDTO.getAmt_pat() == null ? relSrvDTO.getAmt_st() : relSrvDTO.getAmt_pat());// 患者支付金额
//			billDTO.setAmt(relSrvDTO.getAmt() == null && relSrvDTO.getAmt().isTrimZero() ? relSrvDTO.getAmt_st()
//					: relSrvDTO.getAmt());// 支付金额
			if(FDoubleUtils.isNullOrZero(relSrvDTO.getAmt()) || FDoubleUtils.isNullOrZero(relSrvDTO.getAmt_st()))
				billDTO.setFg_zeroreg(FBoolean.TRUE);
				
			billDTO.setEu_srctp(FeeOriginEnum.ENCOUNTER_FEE);// 费用来源类型--就诊

			billDTO.setFg_mm(FBoolean.FALSE);
			billDTO.setId_grp(pvDO.getId_grp()); // 集团
			billDTO.setId_org(pvDO.getId_org()); // 机构
			
			billDTO.setId_org_or(pvDO.getId_org()); // 开立机构
			billDTO.setId_dep_or(pvDO.getId_dep_phy()); // 开立科室
			billDTO.setId_emp_or(EnContextUtils.getPsnId()); // 开立医生，暂空
			billDTO.setDt_or(pvDO.getDt_entry()); // 开立时间
			
			billDTO.setId_org_mp(pvDO.getId_org()); // 执行机构
			billDTO.setId_dep_mp(pvDO.getId_dep_phy());// 执行科室

			billDTO.setId_org_cg(EnContextUtils.getOrgId());// 记账组织
			billDTO.setId_dep_cg(EnContextUtils.getDeptId());// 记账科室
			billDTO.setId_emp_cg(EnContextUtils.getPsnId());// 记账人员

			billDTO.setEu_direct(Integer.parseInt(IBlDictCodeConst.SD_DIRECT_CHARGE));// 收费
			billDTO.setSrcfunc_des(IBlCgFuncConst.FUNC_OPEN_OPREGISTER);
			billDTO.setSupportAppendBill(FBoolean.FALSE);
			// 门诊记帐DTO
			BlOrderAppendOutpBillParamDTO opBillDTO = new BlOrderAppendOutpBillParamDTO();
			opBillDTO.setFg_acc(FBoolean.TRUE);
			billDTO.setOutpBillDTO(opBillDTO);
			
			billList.add(billDTO);
		}

		return billList;

	}
	/**
	 * 根据排班服务id获取排班服务名称
	 * 
	 * @param scSrvId
	 * @return
	 * @throws BizException
	 */
	private String getScSRvName(String scSrvId)throws BizException {
		if(EnValidator.isEmpty(scSrvId))
			throw new BizException("挂号所需排班服务不能为空！");
		String sql = "SELECT SCSRV.NAME FROM SC_SRV SCSRV WHERE SCSRV.ID_SCSRV = ? AND SCSRV.FG_ACTIVE = 'Y'";
		SqlParam param = new SqlParam();
		param.addParam(scSrvId);
		List<String> names = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(EnValidator.isEmpty(names))
			throw new BizException(String.format("未找到挂号所需排班服务[%S]信息!", scSrvId));
		return names.get(0);
	}
}
