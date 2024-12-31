package iih.bl.itf.std.bp.opinc;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepMDORService;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.inc.WsParamGetIncItm;
import iih.bl.itf.std.bean.input.inc.sub.WsParamGetIncItmInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.inc.WsResultGetIncItm;
import iih.bl.itf.std.bean.output.inc.sub.WsResultGetIncItmDetail;
import iih.bl.itf.std.bean.output.inc.sub.WsResultGetIncItmInfo;
import iih.bl.itf.std.bean.output.inc.sub.WsResultGetIncItmStInfo;
import iih.bl.itf.std.bean.output.inc.sub.WsResultGetIncList;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamIncItmInfoValidator;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.bl.params.BlParams;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.d.OrgDO;

/**
 * 门诊自助发票明细查询
 * 
 * @author shaokx 2019/2/25
 *
 */
public class GetIncItmInfoBP extends BlItfBaseBP<WsParamGetIncItm,WsResultGetIncItm> {

	@Override
	protected String getBusiness() {

		return "门诊自助发票明细查询";
	}

	@Override
	protected void checkParam(WsParamGetIncItm param) throws BizException {
		WsParamIncItmInfoValidator validator = new WsParamIncItmInfoValidator();
		validator.validate(param);
		
		WsParamGetIncItmInfo prepayInfo = param.getPrepay();
		PsnDocDO psndocDO = super.getPsnInfo(prepayInfo.getOperaCode());
		if (psndocDO == null) {
			throw new BizException("门诊自助发票明细查询:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());
	}

	@Override
	protected WsResultGetIncItm doWork(WsParamGetIncItm param) throws BizException {
		WsParamGetIncItmInfo prepayInfo = param.getPrepay();
		IBlIncOutCmdService blIncOutService = ServiceFinder.find(IBlIncOutCmdService.class);

		// 门诊发票打印
		String[] stIds = new String[1];
		stIds[0] = prepayInfo.getStNO();
		BlIncPrintDTO printSet = new BlIncPrintDTO();
		printSet.setFgpay(FBoolean.FALSE);
		printSet.setSd_pttp(IBlDictCodeConst.SD_PTTP_SELF_TERMINAL);
		
		BlincoepAggDO[] incOepAggDo = blIncOutService.printOpInvoice(stIds, printSet);

		// 获得结算信息
		WsResultGetIncItmInfo rltInfo = this.GetStInfo(prepayInfo);

		WsResultGetIncItm rlt = new WsResultGetIncItm();
		WsResultMsg rltMsg = new WsResultMsg();// 0成功，1失败

		rlt.setRltInfo(rltInfo);
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		rltMsg.setMessage("成功");
		rlt.setRltMsg(rltMsg);
		return rlt;
	}

	/**
	 * 获得结算信息
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private WsResultGetIncItmInfo GetStInfo(WsParamGetIncItmInfo prepayInfo) throws BizException {
		// 获得结算DO
		IBlstoepRService blStOepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stOepDO = blStOepRService.findById(prepayInfo.getStNO());
		OrgDO orgDO = this.getOrgDO(stOepDO.getId_org());// 获得医院名称（组织信息）
		// 获得结算信息
		WsResultGetIncItmStInfo stinfo = new WsResultGetIncItmStInfo();
		stinfo.setStNO(prepayInfo.getStNO());
		stinfo.setMlType(BlParams.BLHP000001());// 医院类型
		stinfo.setHpType(GetPatCaInfo(stOepDO.getId_pat()) != null ? GetPatCaInfo(stOepDO.getId_pat()).getName() : "");// 患者分类
		stinfo.setMlName(getOrgDO(stOepDO.getId_org()) != null ? getOrgDO(stOepDO.getId_org()).getName() : "");// 医院名称
		stinfo.setOpCode(prepayInfo.getOperaCode());// 操作员编码
		stinfo.setStTime(stOepDO.getDt_st().toString());
		stinfo.setEntAmout(BlAmtConverUtil.toXmlString(stOepDO.getAmt_ratio()));// 本次结算总费用

		// 获得发票明细信息
		stinfo.setIncNoItm(this.GetIncItmInfo(prepayInfo));

		WsResultGetIncItmInfo rltInfo = new WsResultGetIncItmInfo();
		rltInfo.setStinfo(stinfo);
		return rltInfo;
	}

	/**
	 * 获得发票明细信息
	 * 
	 * @throws BizException
	 */
	private List<WsResultGetIncList> GetIncItmInfo(WsParamGetIncItmInfo prepayInfo) throws BizException {
		// 根据结算号来获得发票号
		IBlincoepMDORService blIncOepRService = ServiceFinder.find(IBlincoepMDORService.class);
		BlIncOepDO[] incOepDOs = blIncOepRService.findByAttrValString(BlIncOepDO.ID_STOEP, prepayInfo.getStNO());

		List<WsResultGetIncList> incNoList = new ArrayList<WsResultGetIncList>();
		if (!ArrayUtil.isEmpty(incOepDOs)) {
			for (BlIncOepDO itm : incOepDOs) {
				WsResultGetIncList incNo = new WsResultGetIncList();
				incNo.setIncNo(itm.getIncno());
				incNo.setItemDetail(this.getItemDetail(itm));
				incNoList.add(incNo);
			}
		}

		return incNoList;
	}

	/**
	 * 获得一张发票上的明细信息
	 */
	private List<WsResultGetIncItmDetail> getItemDetail(BlIncOepDO itm) throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" cgitmoep.name_srv itemName, ");
		sb.append(" cgitmoep.spec itemSpec, ");
		sb.append(" cgitmoep.quan itemNum, ");
		sb.append(" cgitmoep.price_ratio itemPrice, ");
		sb.append(" cgitmoep.amt_ratio*cgoep.eu_direct itemAmt ");
		sb.append(" from bl_inc_oep incoep ");
		sb.append(" left join bl_inc_cg_itm_oep incitmoep on incoep.id_incoep = incitmoep.id_incoep ");
		sb.append(" left join bl_cg_itm_oep cgitmoep on cgitmoep.id_cgitmoep = incitmoep.id_cgitmoep ");
		sb.append(" left join bl_cg_oep cgoep on cgoep.id_cgoep = cgitmoep.id_cgoep ");
		sb.append(" where 1=1 ");
		sb.append(" and incoep.incno = ? ");

		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		if (StringUtil.isEmpty(itm.getIncno())) {
			throw new BizException("未获取到发票号");
		}
		sp.addParam(itm.getIncno());

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<WsResultGetIncItmDetail> list = (List<WsResultGetIncItmDetail>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(WsResultGetIncItmDetail.class));

		// 价格由元转为分
		for (WsResultGetIncItmDetail itmChild : list) {
			itmChild.setItemPrice(BlAmtConverUtil.toXmlString(new FDouble(itmChild.getItemPrice())));
			itmChild.setItemAmt(BlAmtConverUtil.toXmlString(new FDouble(itmChild.getItemAmt())));
		}
		return list;
	}

	/**
	 * 获得医院名称（组织信息）
	 * 
	 * @param orgId
	 * @return
	 * @throws BizException
	 */
	private OrgDO getOrgDO(String orgId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" name ");
		sql.append(" from bd_org ");
		sql.append(" where 1=1 ");
		sql.append(" and id_org = ? ");

		SqlParam param = new SqlParam();
		param.addParam(orgId);

		@SuppressWarnings("unchecked")
		List<OrgDO> List = (List<OrgDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(OrgDO.class));

		return List.get(0);
	}

	/**
	 * 查询患者分类
	 * 
	 * @param patId
	 * @return
	 * @throws BIzException
	 */
	private PiPatCaDO GetPatCaInfo(String patId) throws BizException {

		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" patca.name ");
		sql.append(" from pi_pat pat ");
		sql.append(" left join pi_pat_ca patca ");
		sql.append(" on patca.id_patca = pat.id_paticate ");
		sql.append(" where 1=1 ");
		sql.append(" and pat.id_pat = ? ");

		SqlParam param = new SqlParam();
		param.addParam(patId);

		@SuppressWarnings("unchecked")
		List<PiPatCaDO> List = (List<PiPatCaDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(PiPatCaDO.class));

		return List.get(0);
	}

}
