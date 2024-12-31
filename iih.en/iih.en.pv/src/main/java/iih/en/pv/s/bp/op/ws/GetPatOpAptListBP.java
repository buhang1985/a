package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bl.cg.dto.d.OpPayItmDTO;
import iih.bl.cg.dto.d.OpRegStDTO;
import iih.bl.cg.i.IBlOutQryService;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpPatAptDTO;
import iih.en.pv.s.bp.GetPatIdForAp;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者挂号记录
 * 
 * @author liubin,renying
 *
 */
public class GetPatOpAptListBP {
	/**
	 * 获取患者挂号记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 * @throws BizException
	 */
	public OpPatAptDTO[] exec(String patCode, String beginDate, String endDate)
			throws BizException {
		// 记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetPatOpAptListBP参数为:patCode:" + patCode + ";beginDate:"
						+ beginDate + ";endDate:" + endDate);
		// 从chis 同步患者
		String patId =null;
		if(!EnValidator.isEmpty(patCode)){
			GetPatIdForAp patap = new GetPatIdForAp();
			patId = patap.exec(patCode);
		}
		if(!EnValidator.isEmpty(patCode) && EnValidator.isEmpty(patId)){
			throw new BizException("未检索到code为"+patCode+"的患者");
		}
		FDate bDate = this.string2FDate(beginDate);
		FDate eDate = this.string2FDate(endDate);
		if (bDate == null || eDate == null)
			return null;
		OpPatAptDTO[] opPatApts = this.getOpPatApts(patId, bDate, eDate);
		opPatApts = this.filterBySrvId(opPatApts);
		this.process(opPatApts);
		this.setFg_bill(opPatApts);
		this.setEntpCode(opPatApts);
		this.loadAddr(opPatApts);
		return opPatApts;
	}

	/**
	 * 获取患者挂号记录
	 * 
	 * @param patCode
	 * @param bDate
	 * @param eDate
	 * @return
	 * @throws BizException
	 */
	private OpPatAptDTO[] getOpPatApts(String patId, FDate bDate, FDate eDate)
			throws BizException {
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT SC_APT.ID_APT AS ID_APT,");
		sb.append("PI_PAT.CODE AS PATCODE,");
		sb.append("PI_PAT.NAME AS PATNAME,");
		sb.append("PI_PAT_CA.CODE AS PATCA,");
		sb.append("NVL(PI_PAT.MOB, PI_PAT.TEL) AS MOBILE,");
		sb.append("BD_DEP.CODE AS DEPTCODE,");
		sb.append("BD_DEP.NAME AS DEPTNAME,");
		sb.append("SC_SRV.ID_SCSRV AS SRVID,");
		sb.append("SC_SRV.CODE AS SRVCODE,");
		sb.append("SC_SRV.NAME AS SRVNAME,");
		sb.append("SC_SRV.SD_SRVTP,");
		sb.append("SC_RES.CODE AS DOCTORCODE,");
		sb.append("SC_RES.NAME AS DOCTORNAME,");
		sb.append("SC_RES.CODE AS RESCODE,");
		sb.append("SC_RES.NAME AS RESNAME,");
		sb.append("SUBSTR(SC_APT.DT_B,0,10) AS ENTTIME,");
		sb.append("SC_APT.DT_APPT AS OPRTIME,");
		sb.append("SC_APT.SD_SCTP , ");
		sb.append("BD_DAYSLOT.SD_DAYSLOTTP AS DAYSLOTTYPE,");
		sb.append("BD_DAYSLOT.SD_DAYSLOTTP AS DAYSLOTTP,");
		sb.append("BD_DAYSLOT.NAME AS DAYSLOTNAME,");
		sb.append("SC_APT.QUENO AS SEQNO,");
		sb.append("SC_APT_EXCHL.CODE_APT AS APTNO,");
		sb.append("DECODE(SC_APT.SD_STATUS,'1','0','2','0','3','1','4','7') AS STATUS,");
		sb.append("SC_APT.CODE AS APTCODE,");
		sb.append("SC_APT.FG_PAYMENT AS FG_PAYMENT,");
		//sb.append("(SELECT BD_QUE_BEN.DES FROM BD_QUE BD_QUE INNER JOIN BD_QUE_BEN BD_QUE_BEN ON BD_QUE.ID_QUEBEN = BD_QUE_BEN.ID_QUEBEN "
		//		+ " WHERE BD_QUE.ID_DEP = SC_PL.ID_DEP AND BD_QUE.ID_SCRES = SC_PL.ID_SCRES  AND BD_QUE.ID_QUEBEN = SC_PL.ID_QUEBEN ) AS ADDRESS,");
		sb.append("EN_ENT_OP.TIMES_OP AS TIMES,");
		sb.append("EN_ENT_OP.TIMES_OP AS TIMESOP,");
		sb.append("EN_ENT_OP.ID_CG,");
		sb.append("TICK.T_B AS T_B_TICK ,");
		sb.append("TICK.T_E AS T_E_TICK ,");
		sb.append("SC_APT.DT_B, ");
		sb.append(" CHL.CODE APTCHL, ");
		sb.append("CHL.SD_SCCHLTP AS CHLTYPE, ");
		sb.append("CHL.NAME AS CHLTYPENAME ");
		sb.append("FROM SC_APT SC_APT ");
		sb.append("INNER JOIN SC_APT_OP SC_APT_OP ON SC_APT.ID_APT = SC_APT_OP.ID_APT ");
		sb.append("LEFT JOIN SC_APT_EXCHL SC_APT_EXCHL ON SC_APT.ID_APT = SC_APT_EXCHL.ID_APT ");
		sb.append("INNER JOIN PI_PAT PI_PAT ON SC_APT.ID_PAT = PI_PAT.ID_PAT ");
		sb.append("LEFT JOIN PI_PAT_CA PI_PAT_CA ON PI_PAT.ID_PATICATE = PI_PAT_CA.ID_PATCA ");	
		sb.append("INNER JOIN SC_RES SC_RES ON SC_APT.ID_SCRES = SC_RES.ID_SCRES ");
		sb.append("INNER JOIN SC_SRV SC_SRV ON SC_APT.ID_SCSRV = SC_SRV.ID_SCSRV ");
		sb.append("INNER JOIN SC_SCH SC_SCH ON SC_APT.ID_SCH = SC_SCH.ID_SCH ");
		sb.append("INNER JOIN SC_PL SC_PL ON SC_SCH.ID_SCPL = SC_PL.ID_SCPL ");
		sb.append("INNER JOIN BD_DEP BD_DEP ON SC_PL.ID_DEP = BD_DEP.ID_DEP ");
		sb.append("INNER JOIN BD_DAYSLOT BD_DAYSLOT ON SC_APT.ID_DATESLOT = BD_DAYSLOT.ID_DAYSLOT ");
		sb.append("LEFT  JOIN SC_CHL CHL ON SC_APT.ID_SCCHL = CHL.ID_SCCHL ");
		sb.append("LEFT JOIN SC_TICK TICK ON SC_APT.ID_TICK = TICK.ID_TICK ");
		sb.append("LEFT JOIN EN_ENT_OP EN_ENT_OP ON SC_APT.ID_APT = EN_ENT_OP.ID_SCHAPT ");
	
		sb.append("WHERE 1=1  ");
		if(!EnValidator.isEmpty(patId)){
			sb.append(" and PI_PAT.ID_PAT = ?");
			param.addParam(patId);
		}
		sb.append(" AND (SC_APT.SD_STATUS IN ('1','2','3') OR SC_APT.FG_CANC = 'N') ");
		sb.append("AND SC_APT.DT_B >= ? ");
		param.addParam(bDate);
		sb.append("AND SC_APT.DT_B < ? ");
		param.addParam(eDate.asLocalBegin().getDateAfter(1));
		sb.append("ORDER BY SC_APT.DT_B ");
		String sql = sb.toString();
		Logger.info(sql);
		List<OpPatAptDTO> list = (List<OpPatAptDTO>) new DAFacade().execQuery(
				sql, param, new BeanListHandler(OpPatAptDTO.class));
		if (!EnValidator.isEmpty(list)) {
			for (OpPatAptDTO data : list) {
				if (data.getAddress() == null) {
					data.setAddress("");
				}
			}
			list = this.loadPrice(list);
			this.getAptPayDetail(list);
			return list.toArray(new OpPatAptDTO[0]);
		}
		return null;
	}
	
	/**
	 * 过滤非门诊排班服务
	 * 
	 * @param opPatApts
	 * @return
	 * @throws BizException 
	 */
	private OpPatAptDTO[] filterBySrvId(OpPatAptDTO[] opPatApts) throws BizException {
		if (EnValidator.isEmpty(opPatApts))
			return null;
		IScBdOutQryService serv = ServiceFinder.find(IScBdOutQryService.class);
		String scsrvIds = serv.getScsrvIdsNoOpSch();
		if(EnValidator.isEmpty(scsrvIds))
			return opPatApts;
		List<OpPatAptDTO> list = new LinkedList<>();
		for(OpPatAptDTO opPatApt : opPatApts){
			if(scsrvIds.contains(opPatApt.getSrvId()))
				continue;
			list.add(opPatApt);
		}
		return EnValidator.isEmpty(list) ? null : list.toArray(new OpPatAptDTO[0]);
	}
	
	/**
	 * 设置支付标识
	 * 
	 * @param opPatApts
	 * @throws BizException
	 */
	private void setFg_bill(OpPatAptDTO[] opPatApts) throws BizException {
		if (EnValidator.isEmpty(opPatApts))
			return;
		for (OpPatAptDTO aptDTO : opPatApts) {
			if ("7".equals(aptDTO.getStatus())
					&& aptDTO.getFg_payment() != null && aptDTO.getFg_payment()) {
				aptDTO.setFeeStatus("7");
			} else {
				if (EnValidator.isEmpty(aptDTO.getId_cg()))
					aptDTO.setFeeStatus("0");
				else {
					FBoolean res = ServiceFinder.find(IBlOutQryService.class)
							.hasSettled(aptDTO.getId_cg());
					aptDTO.setFeeStatus(res == null ? "0"
							: res.booleanValue() ? "1" : "0");
				}
			}
		}

	}

	/**
	 * 设置就诊类型
	 * 
	 * @param opPatApts
	 */
	private void setEntpCode(OpPatAptDTO[] opPatApts) {
		if (EnValidator.isEmpty(opPatApts))
			return;
		for (OpPatAptDTO aptDTO : opPatApts) {
			if (IScDictCodeConst.SD_SCTP_JZ.equals(aptDTO.getSd_sctp())
					|| IScDictCodeConst.SD_SRVTP_EM
							.equals(aptDTO.getSd_srvTp())) {
				aptDTO.setEntpCode("01");
				aptDTO.setEntpName("急诊");
			} else {
				aptDTO.setEntpCode("00");
				aptDTO.setEntpName("门诊");
			}
		}
	}

	/**
	 * 做处理
	 * 
	 * @param opPatApts
	 * @throws BizException
	 */
	private void process(OpPatAptDTO[] opPatApts) throws BizException {
		if (EnValidator.isEmpty(opPatApts))
			return;
		Set<String> srvIdSets = new HashSet<String>();
		for (OpPatAptDTO opPatApt : opPatApts) {
			opPatApt.setAmpm(EnCodeUtils.dayslotTpTOHisCode(opPatApt
					.getDayslottp()));
			// 日期分组
			if (!EnValidator.isEmpty(opPatApt.getDayslotType())) {
				opPatApt.setDayslotType(EnCodeUtils.dayslotTpTOHisCode(opPatApt
						.getDayslottp()));
			}
			if (!EnValidator.isEmpty(opPatApt.getPmCode())) {
				opPatApt.setPmCode(ServiceFinder.find(IBlOutQryService.class)
						.getPayCodeToOut(opPatApt.getPmCode()).getSd_pmtp());
			}
			if (opPatApt.getAmtRatio() == null
					|| opPatApt.getAmtRatio().floatValue() == 0) {
				srvIdSets.add(opPatApt.getSrvId());
			}
		}
		if (srvIdSets.size() <= 0)
			return;
		RegResDTO[] regResDTOs = new RegResDTO[srvIdSets.size()];
		int i = 0;
		for (String srvId : srvIdSets) {
			RegResDTO regRes = new RegResDTO();
			regRes.setId_scsrv(srvId);
			regResDTOs[i] = regRes;
			i++;
		}
		IScSchOutQryService scSchOutQryService = ServiceFinder
				.find(IScSchOutQryService.class);
		RegResDTO[] resResult = scSchOutQryService.loadResPri(regResDTOs);

		Map<String, FDouble> regResMap = new LinkedHashMap<String, FDouble>();
		for (RegResDTO regResDTO : resResult) {
			regResMap.put(regResDTO.getId_scsrv(), regResDTO.getAmt_st());
		}
		// for (OpPatAptDTO opPatApt : opPatApts) {
		// if(opPatApt.getAmtRatio()==null||opPatApt.getAmtRatio().floatValue()==0){
		// float money = regResMap.get(opPatApt.getSrvId()).floatValue();
		// opPatApt.setAmt(money);
		// opPatApt.setAmtRatio(money);
		// }
		// }
	}

	/**
	 * 日期转换
	 * 
	 * @param str
	 * @return
	 */
	private FDate string2FDate(String str) {
		try {
			return new FDate(str);
		} catch (Throwable t) {
			Logger.error("日期转换出错", t);
		}
		return null;
	}

	/***
	 * 调用费用接口，设置费用明细
	 * 
	 * @author fanlq 2017-11-24
	 * @param list
	 * @return
	 * @throws BizException
	 */
	private List<OpPatAptDTO> getAptPayDetail(List<OpPatAptDTO> list)
			throws BizException {
		List<OpPatAptDTO> opEntListDTOList = new ArrayList<OpPatAptDTO>();
		List<String> idList = new ArrayList<String>();
		for (OpPatAptDTO data : list) {
			if (data.getId_cg() != null && !idList.contains(data.getId_cg())) {
				idList.add(data.getId_cg());
			}
		}
		GetPatOpEntListBP entbp = new GetPatOpEntListBP();
		Map<String, OpRegStDTO> map = entbp.getAllCgDatas(idList);
		for (OpPatAptDTO data : list) {
			if (data != null && !EnValidator.isEmpty(data.getId_cg())) {
				if (map == null) {
					return null;
				}
				OpRegStDTO opRegStDTO = map.get(data.getId_cg());
				if (opRegStDTO != null) {
					List<OpPayItmDTO> itemList = entbp.filerItem(opRegStDTO
							.getPayitm_list());
					if (!EnValidator.isEmpty(itemList)) {
						Float sumMoney = 0.00f;
						for (OpPayItmDTO itemDTO : itemList) {
							data.setPaymodeno(itemDTO.getPaymodenode()); // 支付订单号
							data.setBankno(itemDTO.getBankno()); // 支付账户
							data.setPmCode(itemDTO.getCode_pm());// 支付方式
							sumMoney = sumMoney + itemDTO.getAmt().floatValue();
						}
						data.setAmtPat(sumMoney);// 患者自付金额
					}
					data.setAmt(opRegStDTO.getAmt_ratio().floatValue());// 总费用
					data.setAmtRatio(opRegStDTO.getAmt_ratio().floatValue()); // 折扣金额
					opEntListDTOList.add(data);
				}
			}
		}
		return opEntListDTOList;
	}

	/***
	 * 加载服务价格
	 * @author fanlq 
	 * @param list
	 * @throws BizException
	 */
	private List<OpPatAptDTO> loadPrice(List<OpPatAptDTO> list) throws BizException{
		List<OpPatAptDTO> datas = new ArrayList<OpPatAptDTO>();
		List<String> srvList = new ArrayList<String>();
		for(OpPatAptDTO data : list){
			srvList.add(data.getSrvId());
		}
		LoadSrvPriceBP bp = new LoadSrvPriceBP();
		Map<String,FDouble> regResMap = bp.getPrice(srvList.toArray(new String[0]));
		for(OpPatAptDTO data : list){
			data.setAmt(regResMap.get(data.getSrvId()).floatValue());
			datas.add(data);
		}
		return datas;
	}
	
	/***
	 * 加载分诊台地址
	 * @author fanlq 2018.03.27
	 * @param list
	 * @return
	 * @throws BizException
	 */
	private void loadAddr(OpPatAptDTO[] opPatAptDTOs) throws BizException{
		String addrStr = "";
		if(opPatAptDTOs != null && opPatAptDTOs.length > 0){
			for(OpPatAptDTO data : opPatAptDTOs){
				StringBuilder sb = new StringBuilder();
				SqlParam param = new SqlParam();
				sb.append("SELECT distinct BD_QUE_BEN.DES FROM BD_QUE BD_QUE ");
				sb.append("INNER JOIN BD_QUE_BEN BD_QUE_BEN ON BD_QUE.ID_QUEBEN = BD_QUE_BEN.ID_QUEBEN ");
				sb.append("left join sc_pl sc_pl on  BD_QUE.ID_DEP = SC_PL.ID_DEP  ");
				sb.append(" AND BD_QUE.ID_SCRES = SC_PL.ID_SCRES  AND BD_QUE.ID_QUEBEN = SC_PL.ID_QUEBEN ");
				sb.append("left join sc_sch sch on sch.id_scpl = sc_pl.id_scpl  ");
				sb.append("left join sc_apt SC_APT on SC_APT.id_sch = sch.id_sch  ");
				sb.append("WHERE 1 = 1 ");
				if(!EnValidator.isEmpty(data.getId_apt())){
					sb.append(" and SC_APT.ID_APT = ?");
					param.addParam(data.getId_apt());
				}
				@SuppressWarnings("unchecked")
				Map<String, Object> addrSql = (Map<String, Object>) new DAFacade().execQuery(sb.toString(), param, new MapHandler());
				if (null != addrSql && !addrSql.isEmpty()) {
					addrStr = (String)FTypeManager.convert2FType(FType.String, addrSql.get("des"));
				}
				data.setAddress(addrStr);
			}
		}else 
			return;
	}
}
