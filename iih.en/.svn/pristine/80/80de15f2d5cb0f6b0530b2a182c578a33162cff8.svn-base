package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.dto.d.OpPayItmDTO;
import iih.bl.cg.dto.d.OpRegStDTO;
import iih.bl.cg.i.IBlOutQryService;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.dto.d.OpEntListDTO;
import iih.en.pv.s.bp.GetPatIdForAp;
import iih.en.pv.s.bp.op.ws.ep.WsEp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.desc.ent.dataobject.EnumDescUtil;
import xap.sys.appfw.orm.desc.ent.dataobject.EnumDescription;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者挂号记录列表BP
 * 
 * @author zhengcm，renying
 * @date 2017-10-17 08:18:54
 *
 */
public class GetPatOpEntListBP {

	/**
	 * 获取患者挂号记录列表 （未取消）
	 *
	 * @author zhengcm
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	public OpEntListDTO[] exec(String patCode, String beginDate, String endDate)
			throws BizException {
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetPatOpEntListBP参数为:patCode:"+patCode+";beginDate:"+beginDate+";endDate:"+endDate);
				
		if (EnValidator.isEmpty(beginDate)
				|| EnValidator.isEmpty(endDate)) {
			return null;
		}
		// 从chis同步患者
		String patId =null;
		if(!EnValidator.isEmpty(patCode)){
			GetPatIdForAp patap = new GetPatIdForAp();
			patId = patap.exec(patCode);
		}
		if(!EnValidator.isEmpty(patCode) && EnValidator.isEmpty(patId)){
			throw new BizException("未检索到code为"+patCode+"的患者");
		}
		FDate end = new FDate(endDate).getDateAfter(1);
		String beginDateStr = beginDate + " 00:00:00";
		String endDateStr = end.toLocalString() + " 00:00:00";
		OpEntListDTO[] entarray = this.queryDatas(patId, beginDateStr,
				endDateStr, false);
		this.setFg_bill(entarray);
		this.setStatus(entarray);
		this.setEntpCode(entarray);
		this.loadAddr(entarray);
		return entarray;
	}

	/**
	 * 获取患者挂号记录列表 （查取消的）
	 *
	 * @author renying
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	public OpEntListDTO[] exec2(String patCode, String beginDate, String endDate)
			throws BizException {
		if ( EnValidator.isEmpty(beginDate)
				|| EnValidator.isEmpty(endDate)) {
			return null;
		}
		// 从chis同步患者
		 String patId =null;
		if(!EnValidator.isEmpty(patCode)){
			GetPatIdForAp patap = new GetPatIdForAp();
            patId = patap.exec(patCode);
		}
		if(!EnValidator.isEmpty(patCode) && EnValidator.isEmpty(patId)){
			throw new BizException("未检索到code为"+patCode+"的患者");
		}
		FDate end = new FDate(endDate).getDateAfter(1);
		String beginDateStr = beginDate + " 00:00:00";
		String endDateStr = end.toLocalString() + " 00:00:00";
		OpEntListDTO[] entarray = this.queryDatas(patId, beginDateStr,
				endDateStr, true);
		this.setFg_bill(entarray);
		this.setStatus(entarray);
		this.setChlNameprivate(entarray);
		this.setEntpCode(entarray);
		this.loadAddr(entarray);//加载分诊台地址，fanlq-2018.03.28
		return entarray;
	}

	/**
	 * 查询数据
	 *
	 * @author zhengcm
	 * 
	 * @param patId
	 *            患者Id
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OpEntListDTO[] queryDatas(String patId, String beginDate,
			String endDate, boolean isGetCancel) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ");
		sb.append("apt.id_apt,");
		sb.append("pat.name as patName,");
		sb.append("pat.code as patCode,");
		sb.append("ca.code as patCa,");
		sb.append("dep.code as deptCode,");
		sb.append("dep.name as deptName,");
		sb.append("srv.code as srvCode,");
		sb.append("srv.name as srvName,");
		sb.append("res.code as resCode,");
		sb.append("op.id_cg, ");
		sb.append("res.name as resName,");
		sb.append("substr(ent.dt_entry,0,10) as entTime,");
		sb.append("ent.dt_insert as oprTime,");
		sb.append("lot.sd_dayslottp as dayslottp,");
		sb.append("lot.name as dayslotname,");
		sb.append("op.ticketno as seqno,");
		sb.append("exchl.code_apt as aptno,");
		sb.append("op.sd_status as sd_status_op,");
		sb.append("apt.sd_status as sd_status_apt,");
		sb.append("apt.code as aptCode,");
		//sb.append("(select bd_que_ben.des from bd_que bd_que inner join bd_que_ben bd_que_ben on bd_que.id_queben = bd_que_ben.id_queben  "
			//	+ "where bd_que.id_dep = pl.id_dep and bd_que.id_scres = pl.id_scres and bd_que.id_queben = pl.id_queben ) as address,");
		sb.append("op.times_op as timesOp,");
		sb.append("nvl(pat.mob, pat.tel) as mobile, ");
		sb.append("ent.id_ent,");
		sb.append("ent.fg_canc,");
		sb.append("chl.name as aptChl, ");
		sb.append("op.eu_regtp, ");
		sb.append("tick.t_b as t_b_tick, ");
		sb.append("tick.t_e as t_e_tick, ");
		sb.append("ent.code_entp as entpCode ");
		sb.append("from ");
		sb.append("en_ent ent ");
		sb.append("inner join en_ent_op op on op.id_ent = ent.id_ent ");
		sb.append("inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		sb.append("left join pi_pat_ca ca on ca.id_patca = ent.id_patca ");
		sb.append("left join pi_pat_ca pi_pat_ca on pat.id_paticate = pi_pat_ca.id_patca ");
		sb.append("left join sc_apt apt on apt.id_apt = op.id_schapt ");
		sb.append("left join sc_sch sch on sch.id_sch = op.id_sch ");
		sb.append("left join sc_pl pl on sch.id_scpl = pl.id_scpl ");
		sb.append("left join bd_dep dep on dep.id_dep = op.id_dep_reg ");
		sb.append("left join sc_srv srv on srv.id_scsrv = op.id_scsrv ");
		sb.append("left join sc_res res on res.id_scres = op.id_scres ");
		sb.append("left join bd_dayslot lot on lot.id_dayslot = op.id_dateslot ");
		sb.append("left join sc_apt_op aptop on aptop.id_apt = apt.id_apt ");
		sb.append("left join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("left join sc_apt_exchl exchl on exchl.id_apt = op.id_schapt ");
		sb.append("left join sc_tick tick on op.id_tick = tick.id_tick ");

		sb.append("where 1=1 ");
		SqlParam params = new SqlParam();
		if (!isGetCancel) {
			sb.append("and ent.fg_canc = 'N' ");
		}
		if(!EnValidator.isEmpty(patId)){
			sb.append("and pat.ID_PAT = ? ");
			params.addParam(patId);
		}
		sb.append("and ent.dt_entry >= ? ");
		sb.append("and ent.dt_entry < ? ");
		params.addParam(beginDate);
		params.addParam(endDate);
		List<OpEntListDTO> list = (List<OpEntListDTO>) new DAFacade()
				.execQuery(sb.toString(), params, new BeanListHandler(
						OpEntListDTO.class));
		// 地址处理
		if (!EnValidator.isEmpty(list)) {
			for (OpEntListDTO data : list) {
				if (null == data.getAddress()) {
					data.setAddress("");
				}
			}
			this.getEntPayDetail(list);
			return list.toArray(new OpEntListDTO[0]);
		}
		return null;
	}

	/**
	 * 设置支付标识
	 * 
	 * @param opPatApts
	 * @throws BizException
	 */
	private void setFg_bill(OpEntListDTO[] opPatEnts) throws BizException {
		if (EnValidator.isEmpty(opPatEnts))
			return;
		for (OpEntListDTO entDTO : opPatEnts) {
			if (entDTO.getFg_canc() != null
					&& entDTO.getFg_canc().booleanValue()) {
				entDTO.setFeeStatus("7");
			} else {
				if (EnValidator.isEmpty(entDTO.getId_cg()))
					entDTO.setFeeStatus("0");
				else {
					FBoolean res = ServiceFinder.find(IBlOutQryService.class)
							.hasSettled(entDTO.getId_cg());
					entDTO.setFeeStatus(res == null ? "0"
							: res.booleanValue() ? "1" : "0");
				}
			}
		}

	}

	/**
	 * 设置状态
	 * @param opPatEnts
	 */
	private void setStatus(OpEntListDTO[] opPatEnts) {
		if (EnValidator.isEmpty(opPatEnts))
			return;
		for (OpEntListDTO entDTO : opPatEnts) {
			if (entDTO.getFg_canc() != null&& entDTO.getFg_canc().booleanValue()) {
				entDTO.setStatus(WsEp.STATUS_OP_CANCEL);
			} else {
				if (IScDictCodeConst.SD_APTSTATUS_CANCEL.equals(entDTO
						.getSd_status_apt())) {
					entDTO.setStatus(WsEp.STATUS_OP_CANCEL);
					continue;
				}
				if (IScDictCodeConst.SD_APTSTATUS_ORDER.equals(entDTO.getSd_status_apt())|| 
						IScDictCodeConst.SD_APTSTATUS_PAY.equals(entDTO.getSd_status_apt())||
						IEnDictCodeConst.SD_ENSTATUS_OP_ORDER.equals(entDTO.getSd_status_op())) {					
					entDTO.setStatus(WsEp.STATUS_OP_APT);
				}
				if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(entDTO
						.getSd_status_apt())|| IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER.equals(entDTO
								.getSd_status_op())) {
					entDTO.setStatus(WsEp.STATUS_OP_REGIST);					
				}

				if (IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER.equals(entDTO.getSd_status_op())) {
					entDTO.setStatus(WsEp.STATUS_OP_ACPT);
				}
				if (IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(entDTO.getSd_status_op())) {
					entDTO.setStatus(WsEp.STATUS_OP_END);
				}
			}
		}
	}
    /**
     * 设置渠道名称
     * @param opPatEnts
     */
	private void setChlNameprivate(OpEntListDTO[] opPatEnts) {
		if (EnValidator.isEmpty(opPatEnts))
			return;
		Map<Object, EnumDescription> regTpMap = EnumDescUtil.getValue_EnumDescriptionMap(EuRegTp.class); 
		for (OpEntListDTO entDTO : opPatEnts) {
			if (!EnValidator.isEmpty(entDTO.getAptChl())) {
				continue;
			}
			if(entDTO.getAptChl() != null &&  regTpMap.get(entDTO.getAptChl()) != null){
				entDTO.setAptChl( regTpMap.get(entDTO.getAptChl()).getName());
			}		
		}
	}

	/**
	 * 设置就诊类型
	 * 
	 * @param entarray
	 */
	private void setEntpCode(OpEntListDTO[] entarray) {
		if (EnValidator.isEmpty(entarray))
			return;
		for (OpEntListDTO aptDTO : entarray) {
			if (IEnDictCodeConst.SD_ENTP_EMERGENCY.equals(aptDTO.getEntpCode())) {
				aptDTO.setEntpName("急诊");
			} else {
				aptDTO.setEntpName("门诊");
			}
		}
	}

	/***
	 * 调用费用接口，设置费用明细
	 * 
	 * @author fanlq 2017-11-24
	 * @param list
	 * @return
	 * @throws BizException
	 */
	private List<OpEntListDTO> getEntPayDetail(List<OpEntListDTO> list)
			throws BizException {
		List<OpEntListDTO> opEntListDTOList = new ArrayList<OpEntListDTO>();
		List<String> idList = new ArrayList<String>();
		for (OpEntListDTO data : list) {
			if (data.getId_cg() != null && !idList.contains(data.getId_cg())) {
				idList.add(data.getId_cg());
			}
		}
		Map<String, OpRegStDTO> map = this.getAllCgDatas(idList);
		for (OpEntListDTO data : list) {
			if (data != null && !EnValidator.isEmpty(data.getId_cg())) {
				if (map == null) {
					return null;
				}
				OpRegStDTO opRegStDTO = map.get(data.getId_cg());
				if (opRegStDTO != null) {
					List<OpPayItmDTO> itemList = this.filerItem(opRegStDTO
							.getPayitm_list());
					if (!EnValidator.isEmpty(itemList)) {
						double sumMoney = 0;
						for (OpPayItmDTO itemDTO : itemList) {
							data.setPaymodeno(itemDTO.getPaymodenode()); // 支付订单号
							data.setBankno(itemDTO.getBankno()); // 支付账户
							data.setPmCode(itemDTO.getCode_pm());// 支付方式
							sumMoney = sumMoney
									+ itemDTO.getAmt().doubleValue();
						}
						data.setAmtPat(sumMoney);// 患者自付金额
					}
					data.setAmt(opRegStDTO.getAmt_ratio()==null?0:opRegStDTO.getAmt_ratio().doubleValue());// 总费用
					opEntListDTOList.add(data);
				}
			}
		}
		return opEntListDTOList;
	}

	/**
	 * 获取详细支付信息
	 * 
	 * @author fanlq
	 * @param list
	 * @return
	 * @throws BizException
	 */
	public Map<String, OpRegStDTO> getAllCgDatas(List<String> cgIdList)
			throws BizException {
		if (EnValidator.isEmpty(cgIdList)) {
			return null;
		}
		Map<String, OpRegStDTO> map = new HashMap<String, OpRegStDTO>();
		IBlOutQryService blService = ServiceFinder.find(IBlOutQryService.class);
		OpRegStDTO[] cgDatas = null;
		if (!EnValidator.isEmpty(cgIdList)) {
			cgDatas = blService.batchGetOpRegStInfo(cgIdList
					.toArray(new String[0]));
		}
		if (EnValidator.isEmpty(cgDatas)) {
			return null;
		}
		for (OpRegStDTO data : cgDatas) {
			String key = data.getId_cg();
			if (!map.containsKey(key)) {
				map.put(key, data);
			}
		}
		return map;
	}

	/***
	 * 过滤非个人支付的金额
	 * 
	 * @author fanlq
	 * @param flist
	 * @return
	 * @throws BizException
	 */
	public List<OpPayItmDTO> filerItem(FArrayList flist) throws BizException {
		if (null == flist) {
			return null;
		}
		List<OpPayItmDTO> list = new ArrayList<OpPayItmDTO>();
		for (Object obj : flist) {
			OpPayItmDTO item = (OpPayItmDTO) obj;
			if (!EnValidator.isEmpty(item.getCode_pm())
					&& (item.getCode_pm().equals(
							IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT)
							|| item.getCode_pm().equals(
									IBdPripmCodeConst.CODE_PRI_PM_INSUR) || item
							.getCode_pm().equals(
									IBdPripmCodeConst.CODE_PRI_PM_BUSINESS))) {
				continue;
			}
			list.add(item);
		}
		return list;
	}
	/***
	 * 加载分诊台地址
	 * @author fanlq 2018.03.27
	 * @param list
	 * @return
	 * @throws BizException
	 */
	private void loadAddr(OpEntListDTO[] opEntListDTOs) throws BizException{
		String addrStr = "";
		if(opEntListDTOs != null && opEntListDTOs.length > 0){
			for(OpEntListDTO data : opEntListDTOs){
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
