package iih.ei.std.s.v1.bp.bl;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepMDORService;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.params.BlParams;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.ei.std.d.v1.bl.opincitminfodto.d.IncNoInfo;
import iih.ei.std.d.v1.bl.opincitminfodto.d.IncNoItm;
import iih.ei.std.d.v1.bl.opincitminfodto.d.OpIncItmInfoParamDTO;
import iih.ei.std.d.v1.bl.opincitminfodto.d.OpIncItmInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.d.OrgDO;

/***
 * 门诊自助发票明细查询（根据一个结算id查询发票明细信息）（带有发票打印逻辑）
 * 
 * @author shaokx
 * @date: 2019.09.30
 */
public class GetOpIncItmInfoBP extends IIHServiceBaseBP<OpIncItmInfoParamDTO, OpIncItmInfoResultDTO>{

	@Override
	protected void checkParam(OpIncItmInfoParamDTO param) throws BizException {
		if (param == null) {
			throw new BizException("入参为空");
		}

		if (StringUtil.isEmpty(param.getCode_stoep())) {
			throw new BizException("门诊自助发票明细查询入参结算号为空");
		}
		
		if(StringUtil.isEmpty(param.getCode_opera())){
			throw new BizException("门诊自助发票明细查询入参操作员编码为空");
		}

		//上下文赋值操作员编码
		PsnDocDO psndocDO = this.getPsnInfo(param.getCode_opera());
		if (psndocDO == null) {
			throw new BizException("门诊自助发票明细查询:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());
		
	}

	@Override
	protected OpIncItmInfoResultDTO process(OpIncItmInfoParamDTO param) throws BizException {
		
		IBlIncOutCmdService blIncOutService = ServiceFinder.find(IBlIncOutCmdService.class);

		// 门诊发票打印
		String[] stIds = new String[1];
		stIds[0] = param.getCode_stoep();
		BlIncPrintDTO printSet = new BlIncPrintDTO();
		printSet.setFgpay(FBoolean.FALSE);
		printSet.setSd_pttp(IBlDictCodeConst.SD_PTTP_SELF_TERMINAL);
		
		BlincoepAggDO[] incOepAggDo = blIncOutService.printOpInvoice(stIds, printSet);

		// 获得结算信息
		OpIncItmInfoResultDTO rlt1 = this.GetStInfo(param);
		
		return rlt1;
	}
	
	/**
	 * 查询人员信息
	 * @param code
	 * @return
	 * @throws BizException
	 */
	protected PsnDocDO getPsnInfo(String code) throws BizException{
		IPsndocMDORService rService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] dos = rService.findByAttrValString(PsnDocDO.CODE, code);
		if(ArrayUtil.isEmpty(dos))
			return null;
		
		return dos[0];
	}
	
	/**
	 * 获得结算信息
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private OpIncItmInfoResultDTO GetStInfo(OpIncItmInfoParamDTO param) throws BizException {
		// 获得结算DO
		IBlstoepRService blStOepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stOepDO = blStOepRService.findById(param.getCode_stoep());
		OrgDO orgDO = this.getOrgDO(stOepDO.getId_org());// 获得医院名称（组织信息）
		// 获得结算信息
		OpIncItmInfoResultDTO stinfo = new OpIncItmInfoResultDTO();
		stinfo.setCode_stoep(param.getCode_stoep());
		stinfo.setName_hostp(BlParams.BLHP000001());// 医院类型
		stinfo.setName_patca(GetPatCaInfo(stOepDO.getId_pat()) != null ? GetPatCaInfo(stOepDO.getId_pat()).getName() : "");// 患者分类
		stinfo.setName_hos(getOrgDO(stOepDO.getId_org()) != null ? getOrgDO(stOepDO.getId_org()).getName() : "");// 医院名称
		stinfo.setCode_opera(param.getCode_opera());// 操作员编码
		stinfo.setDt_st(stOepDO.getDt_st().toString());
		stinfo.setAmt_stoep(BlAmtConverUtil.toXmlString(stOepDO.getAmt_ratio()));// 本次结算总费用

		List<IncNoInfo> incNoInfo = this.GetIncItmInfo(param);
		FArrayList arr = new FArrayList();
		arr.addAll(incNoInfo);
		// 获得发票明细信息
		stinfo.setIncnoinfo(arr);

		return stinfo;
	}

	/**
	 * 获得发票明细信息
	 * 
	 * @throws BizException
	 */
	private List<IncNoInfo> GetIncItmInfo(OpIncItmInfoParamDTO param) throws BizException {
		// 根据结算号来获得发票号
		IBlincoepMDORService blIncOepRService = ServiceFinder.find(IBlincoepMDORService.class);
		BlIncOepDO[] incOepDOs = blIncOepRService.findByAttrValString(BlIncOepDO.ID_STOEP, param.getCode_stoep());

		List<IncNoInfo> incNoList = new ArrayList<IncNoInfo>();
		if (!ArrayUtil.isEmpty(incOepDOs)) {
			for (BlIncOepDO itm : incOepDOs) {
				IncNoInfo incNo = new IncNoInfo();
				incNo.setIncno(itm.getIncno());
				List<IncNoItm> incNoItm = this.getItemDetail(itm);
				FArrayList arr = new FArrayList();
				arr.addAll(incNoItm);
				incNo.setIncnoitm(arr);
				incNoList.add(incNo);
			}
		}

		return incNoList;
	}

	/**
	 * 获得一张发票上的明细信息
	 */
	private List<IncNoItm> getItemDetail(BlIncOepDO itm) throws BizException {
		if (StringUtil.isEmpty(itm.getIncno())) {
			throw new BizException("未获取到发票号");
		}
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" cgitmoep.name_srv, ");
		sb.append(" cgitmoep.spec, ");
		sb.append(" cgitmoep.quan, ");
		sb.append(" cgitmoep.price_ratio price, ");
		sb.append(" cgitmoep.amt_ratio*cgoep.eu_direct amt ");
		sb.append(" from bl_inc_oep incoep ");
		sb.append(" left join bl_inc_cg_itm_oep incitmoep on incoep.id_incoep = incitmoep.id_incoep ");
		sb.append(" left join bl_cg_itm_oep cgitmoep on cgitmoep.id_cgitmoep = incitmoep.id_cgitmoep ");
		sb.append(" left join bl_cg_oep cgoep on cgoep.id_cgoep = cgitmoep.id_cgoep ");
		sb.append(" where 1=1 ");
		sb.append(" and incoep.incno = ? ");
		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		sp.addParam(itm.getIncno());

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<IncNoItm> list = (List<IncNoItm>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(IncNoItm.class));

		// 价格由元转为分
		for (IncNoItm itmChild : list) {
			itmChild.setPrice(BlAmtConverUtil.toXmlString(new FDouble(itmChild.getPrice())));
			itmChild.setAmt(BlAmtConverUtil.toXmlString(new FDouble(itmChild.getAmt())));
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
