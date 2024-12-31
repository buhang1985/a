package iih.bl.cg.bp;

import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlOrderRefundBillParamDTO;
import iih.bl.st.blauditip.d.BlauditipAggDO;
import iih.bl.st.blauditip.i.IBlauditipRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.en.pv.enfee.d.EnaccountAggDO;
import iih.en.pv.enfee.i.IEnaccountRService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 参数检查
 * 
 * @author tcy
 *
 */
public class ValidateParam {
	/**
	 * 患者已经出院结算、患者的费用已经封账或患者的费用正在审核结算流程中，禁止执行与费用有关的操作
	 * （适用于住院）	 
	 * @param id_ent 就诊id_ent
	 * @throws BizException
	 */
	public void validateFreezeAccAndAuditStatus(String id_ent)
			throws BizException {
		//查询患者姓名
		IPativisitRService iPativisitRService =ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = iPativisitRService.findById(id_ent);
		
		//PatiVisitDO 
		// 判断是否进行出院结算
		IEnOutQryService iEnOutQryService = ServiceFinder
				.find(IEnOutQryService.class);
		if (iEnOutQryService.hasSettled(id_ent).booleanValue()) {
			throw new BizException(patiVisitDO.getName_pat()+"，患者已经出院结算，禁止执行与费用有关的操作！");
		}
		// 判断是否封账
		IEnaccountRService IEnaccountRService = ServiceFinder
				.find(IEnaccountRService.class);
		EnaccountAggDO[] enaccountAggDOArr = IEnaccountRService.find(
				" id_ent='" + id_ent + "' and fg_freeze='Y'", "",
				FBoolean.FALSE);
		if (enaccountAggDOArr != null && enaccountAggDOArr.length > 0) {
			throw new BizException(patiVisitDO.getName_pat()+"，患者的费用已经封账，禁止执行与费用有关的操作！");
		}
		// 该患者的费用正在审核结算流程中，禁止执行补/退费操作！fg_active = Y and (fg_pass_clinic = Y or
		// fg_pass_hp = Y)

		IBlauditipRService iBlauditipRService = ServiceFinder
				.find(IBlauditipRService.class);
		BlauditipAggDO[] BlauditipAggDOArr = iBlauditipRService
				.find(" id_ent='"
						+ id_ent
						+ "' and  fg_active='Y'  and (fg_pass_clinic = 'Y' or fg_pass_hp = 'Y')",
						"", FBoolean.FALSE);
		if (BlauditipAggDOArr != null && BlauditipAggDOArr.length > 0) {
			throw new BizException(patiVisitDO.getName_pat()+"，患者的费用正在审核结算流程中，禁止执行与费用有关的操作！");
		}

	}

	/**
	 * 医嘱补费：参数有效性验证
	 * 
	 * @param paramsDTO
	 * @return
	 */
	public boolean ValidateParamForAppendBill(
			BlOrderAppendBillParamDTO[] paramsDTO, boolean isCiOrder)
			throws BizException {
		boolean flag = true;
		if (paramsDTO == null || paramsDTO.length == 0) {
			throw new BizException("没有传入补费信息");
		}
		List<String> id_orLst = new ArrayList<String>();
		for (int i = 0; i < paramsDTO.length; i++) {
			if (StringUtils.isBlankWithTrim(paramsDTO[i].getId_pat())) {
				throw new BizException("未传入患者主键信息！");
			}
			//review by yangyang 2017-06-06 所有内部参数校验的地方由上游保证合法性，不在重复循环查询
//			if (!id_PatLst.contains(paramsDTO[i].getId_pat())) {
//				id_PatLst.add(paramsDTO[i].getId_pat());
//				
//				IPatiMDORService iPatiMDORService = ServiceFinder
//						.find(IPatiMDORService.class);
//				PatDO patDO = iPatiMDORService.findById(paramsDTO[i]
//						.getId_pat());
//				if (patDO == null) {
//					throw new BizException("患者信息不存在,患者ID:"
//							+ paramsDTO[i].getId_pat());
//				}
//				if (patDO.getFg_invd().booleanValue()) {
//					throw new BizException("患者主索引已停用,患者ID:"
//							+ paramsDTO[i].getId_pat());
//				}
//			}

			if (StringUtils.isBlankWithTrim(paramsDTO[i].getId_pat())) {
				throw new BizException("未传入患者就诊主键信息！");
			}
			//review by yangyang 2017-06-06 所有内部参数校验的地方由上游保证合法性，不在重复循环查询
//			if (!id_entLst.contains(paramsDTO[i].getId_ent())) {
//				id_entLst.add(paramsDTO[i].getId_ent());
//
//				IPativisitRService iPativisitRService = ServiceFinder
//						.find(IPativisitRService.class);
//				PatiVisitDO[] patiVisitDOs = iPativisitRService.find(
//						" id_ent='" + paramsDTO[i].getId_ent()
//								+ "' and  FG_CANC = 'N'", "", FBoolean.FALSE);
//				if (patiVisitDOs == null || patiVisitDOs.length == 0) {
//					throw new BizException("患者就诊信息不存在,ID_ENT="
//							+ paramsDTO[i].getId_ent());
//				}
//			}

			// 检查是否设置id_pripat
			// 检查是否设置id_pripat
			//reivew by yangyang 
//			if (!idEnt_idPripat.containsKey(paramsDTO[i].getId_ent())) {
//				List<PatiVisitDO> PatiVisitDOL = (List<PatiVisitDO>) dafacade
//						.findByCond(PatiVisitDO.class, " id_ent='"
//								+ paramsDTO[i].getId_ent() + "'", fields);
//				if (PatiVisitDOL == null || PatiVisitDOL.size() == 0) {
//					throw new BizException("该就诊下没有对应的环境价格分类");
//				}
//				paramsDTO[i].setId_pripat(PatiVisitDOL
//						.toArray(new PatiVisitDO[0])[0].getId_pripat());
//				idEnt_idPripat.put(paramsDTO[i].getId_ent(), PatiVisitDOL
//						.toArray(new PatiVisitDO[0])[0].getId_pripat());
//			} else {
//				paramsDTO[i].setId_pripat(idEnt_idPripat.get(paramsDTO[i]
//						.getId_ent()));
//			}

			if (!isCiOrder) {
				ValidateParamForAppendBillItms(paramsDTO[i]);
			}
			if (isCiOrder) // 若是医嘱补费，则需要判断医嘱及其医嘱下服务是否存在
			{
				if (StringUtils.isBlankWithTrim(paramsDTO[i].getId_or())) {
					throw new BizException("未传入患者医嘱主键信息！");
				}
				if (!id_orLst.contains(paramsDTO[i].getId_or())) {
					id_orLst.add(paramsDTO[i].getId_or());

					ICiorderMDORService iCiorderMDORService = ServiceFinder
							.find(ICiorderMDORService.class);
					CiOrderDO ciOrderDO = iCiorderMDORService
							.findById(paramsDTO[i].getId_or());
					if (ciOrderDO == null) {
						throw new BizException("医嘱不存在");
					}
				}
			}
			if (paramsDTO[i].getSupportAppendBill()==null) {
				throw new BizException("未定义是否支持后付费");
			}
		}
		return flag;
	}

	/**
	 * 多患者医嘱补费：参数有效性验证
	 * 
	 * @param paramsDTO
	 * @return
	 */
	public boolean ValidateParamForAppendBill_MultiPat_NotCiOrder(
			BlOrderAppendBillParamDTO[] paramsDTO, boolean isCiOrder)
			throws BizException {
		boolean flag = true;

		if (paramsDTO == null || paramsDTO.length == 0) {
			throw new BizException("没有传入补费信息");
		}
		for (int i = 0; i < paramsDTO.length; i++) {

			// if(paramsDTO[i].getInpBillDTO()!=null)
			// {
			// if(paramsDTO[i].getInpBillDTO().getFg_bb().toString().isEmpty()){
			// throw new BizException("未定义是否是婴儿");
			// }
			// if(!(paramsDTO[i].getInpBillDTO().getFg_bb().toString().equals("Y")||
			// paramsDTO[i].getInpBillDTO().getFg_bb().toString().equals("N"))){
			// throw new BizException("未定义是否是婴儿");
			// }
			//
			// if(paramsDTO[i].getInpBillDTO().getFg_bb().toString().equals("Y"))
			// {
			// if(paramsDTO[i].getInpBillDTO().getNo_bb()==null ||
			// String.valueOf(paramsDTO[i].getInpBillDTO().getNo_bb()).isEmpty())
			// {
			// throw new BizException("婴儿序号应该为 大于0 的正整数");
			// }
			// if(Integer.valueOf(paramsDTO[i].getInpBillDTO().getNo_bb())<0)
			// {
			// throw new BizException("婴儿序号应该为 大于0 的正整数");
			// }
			// }
			// }

			ValidateParamForAppendBillItms(paramsDTO[i]);

			if (paramsDTO[i].getSupportAppendBill().toString().isEmpty()) {
				throw new BizException("未定义是否支持后付费");
			}
			if (!(paramsDTO[i].getSupportAppendBill().toString().equals("Y") || paramsDTO[i]
					.getSupportAppendBill().toString().equals("N"))) {
				throw new BizException("未定义是否支持后付费");
			}
		}
		return flag;
	}

	/**
	 * 多患者医嘱补费：参数有效性验证
	 * 
	 * @param paramsDTO
	 * @return 为通过校验原因
	 */
	public String ValidateParamForAppendBill_MultiPat_NotCiOrder_new(
			BlOrderAppendBillParamDTO[] paramsDTO, boolean isCiOrder) {
		boolean flag = true;

		if (paramsDTO == null || paramsDTO.length == 0) {
			return "没有传入补费信息";
		}
		for (int i = 0; i < paramsDTO.length; i++) {

			// if(paramsDTO[i].getInpBillDTO()!=null)
			// {
			// if(paramsDTO[i].getInpBillDTO().getFg_bb().toString().isEmpty()){
			// return "未定义是否是婴儿";
			// }
			// if(!(paramsDTO[i].getInpBillDTO().getFg_bb().toString().equals("Y")||
			// paramsDTO[i].getInpBillDTO().getFg_bb().toString().equals("N"))){
			// return "未定义是否是婴儿";
			// }
			//
			// if(paramsDTO[i].getInpBillDTO().getFg_bb().toString().equals("Y"))
			// {
			// if(paramsDTO[i].getInpBillDTO().getNo_bb()==null ||
			// String.valueOf(paramsDTO[i].getInpBillDTO().getNo_bb()).isEmpty())
			// {
			// return "婴儿序号应该为 大于0 的正整数";
			// }
			// if(Integer.valueOf(paramsDTO[i].getInpBillDTO().getNo_bb())<0)
			// {
			// return "婴儿序号应该为 大于0 的正整数";
			// }
			// }
			// }

			try {
				ValidateParamForAppendBillItms(paramsDTO[i]);
			} catch (Exception e) {
				return e.getMessage();
			}

			if (paramsDTO[i].getSupportAppendBill().toString().isEmpty()) {
				return "未定义是否支持后付费";
			}
			if (!(paramsDTO[i].getSupportAppendBill().toString().equals("Y") || paramsDTO[i]
					.getSupportAppendBill().toString().equals("N"))) {
				return "未定义是否支持后付费";
			}
		}
		return "";
	}

	private void ValidateParamForAppendBillItms(
			BlOrderAppendBillParamDTO paramsDTO) throws BizException {
		if (paramsDTO.getPrice_ratio() != null && MedSrvBlModeEnum.AUTOBL.toString().equals(paramsDTO.getEu_blmd())) {
			if (paramsDTO.getPrice_ratio().compareTo(new FDouble(0)) == 0) {
				throw new BizException("参与计价的明细价格应大于0，项目："
						+ paramsDTO.getName_srv());
			}

			if (paramsDTO.getAmt() == null
					|| paramsDTO.getAmt().compareTo(new FDouble(0)) < 0) {
				throw new BizException("本人费用应该大于0 ！项目："
						+ paramsDTO.getName_srv());
			}
			if (paramsDTO.getAmt_std() == null
					|| paramsDTO.getAmt_std().compareTo(new FDouble(0)) < 0) {
				throw new BizException("标准金额应该大于0 ！项目："
						+ paramsDTO.getName_srv());
			}
			if (paramsDTO.getAmt_pat() == null
					|| paramsDTO.getAmt_pat().compareTo(new FDouble(0)) < 0) {
				throw new BizException("自付金额应该大于0 ！项目："
						+ paramsDTO.getName_srv());
			}
			if (paramsDTO.getAmt_hp() == null
					|| paramsDTO.getAmt_hp().compareTo(new FDouble(0)) < 0) {
				throw new BizException("医保费用应该大于等于0！");
			}
		}
		if (paramsDTO.getQuan() == null
				|| paramsDTO.getQuan().compareTo(new FDouble(0)) < 0) {
			throw new BizException("项目数量应该大于0 ！项目：" + paramsDTO.getName_srv());
		}
		// if(paramsDTO[i].getCode_srv()==null )
		// {
		// throw new BizException("项目的CODE不为空，项目："+paramsDTO[i].getName_srv());
		// }
		if (null == paramsDTO.getId_org()) {
			throw new BizException("集团不允许为空！服务名称：" + paramsDTO.getName_srv());
		}
		if (null == paramsDTO.getId_grp()) {
			throw new BizException("组织不允许为空！服务名称：" + paramsDTO.getName_srv());
		}
		// id_srvca与sd_srvtp的非空校验
		if (null == paramsDTO.getId_srvca()) {
			throw new BizException("服务项目分类不允许为空！服务名称："
					+ paramsDTO.getName_srv());
		}
		if (null == paramsDTO.getSd_srvtp()) {
			throw new BizException("服务项目类型不允许为空！服务名称："
					+ paramsDTO.getName_srv());
		}
		//2017-08-21单位可以为空，具体校验在价表维护时处理
//		if (paramsDTO.getSrvu() == null) {
//			throw new BizException("项目单位不允许为空！项目：" + paramsDTO.getName_srv());
//		}
		if (paramsDTO.getId_dep_mp() == null) {
			throw new BizException("执行科室不允许为空！项目：" + paramsDTO.getName_srv());
		}
		if (paramsDTO.getId_pripat() == null) {
			throw new BizException("患者价格分类不允许为空！项目：" + paramsDTO.getName_srv());
		}
		if (paramsDTO.getCode_enttp() == null) {
			throw new BizException("就诊类型代码不允许为空！项目：" + paramsDTO.getName_srv());
		}
		if (paramsDTO.getId_enttp() == null) {
			throw new BizException("就诊类型代码不允许为空！项目：" + paramsDTO.getName_srv());
		}
	}

	/**
	 * 医嘱退费：参数有效性验证
	 * 
	 * @param paramsDTO
	 * @return
	 */
	public boolean ValidateParamForRefundBill(
			BlOrderRefundBillParamDTO paramsDTO, boolean isCiOrder)
			throws BizException {
		boolean flag = true;
		String sql = "";
		if (isCiOrder) {
			ColumnHandler handler = new ColumnHandler();
			sql = "SELECT COUNT(*) " + "FROM CI_ORDER A " + "WHERE A.ID_OR = ?";
			SqlParam sqlParam = new SqlParam();
			sqlParam.addParam(paramsDTO.getId_or());
			DAFacade cade = new DAFacade();
			String num = cade.execQuery(sql, sqlParam, handler).toString();
			if (num.isEmpty() || num.equals("0")) {
				throw new BizException("医嘱信息不存在");
			}

			sql = "SELECT COUNT(*) " + "FROM CI_OR_SRV A "
					+ "WHERE A.ID_ORSRV = ?";
			sqlParam.clearParams();
			sqlParam.addParam(paramsDTO.getId_orsrv());
			num = cade.execQuery(sql, sqlParam, handler).toString();
			if (num.isEmpty() || num.equals("0")) {
				throw new BizException("医嘱下的服务不存在");
			}
		}

		return flag;
	}

	/**
	 * 医嘱退费：参数有效性验证
	 * 
	 * @param paramsDTO
	 * @return
	 */
	public boolean ValidateParamForRefundBill(
			BlOrderAppendBillParamDTO paramsDTO, boolean isCiOrder)
			throws BizException {
		boolean flag = true;
		String sql = "";
		if (isCiOrder) {
			ColumnHandler handler = new ColumnHandler();
			sql = "SELECT COUNT(*) " + "FROM CI_ORDER A " + "WHERE A.ID_OR = ?";
			SqlParam sqlParam = new SqlParam();
			sqlParam.addParam(paramsDTO.getId_or());
			DAFacade cade = new DAFacade();
			String num = cade.execQuery(sql, sqlParam, handler).toString();
			if (num.isEmpty() || num.equals("0")) {
				throw new BizException("医嘱信息不存在");
			}

			sql = "SELECT COUNT(*) " + "FROM CI_OR_SRV A "
					+ "WHERE A.ID_ORSRV = ?";
			sqlParam.clearParams();
			sqlParam.addParam(paramsDTO.getId_orsrv());
			num = cade.execQuery(sql, sqlParam, handler).toString();
			if (num.isEmpty() || num.equals("0")) {
				throw new BizException("医嘱下的服务不存在");
			}
		}

		return flag;
	}

}
