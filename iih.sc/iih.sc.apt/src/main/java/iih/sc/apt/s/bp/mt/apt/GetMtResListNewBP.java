package iih.sc.apt.s.bp.mt.apt;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.s.bp.GetAptChlMaxDateBP;
import iih.sc.apt.s.bp.mt.SetMtAptScSrvBP;
import iih.sc.apt.s.bp.mt.SetMtAptSchTicksBP;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.i.IScSchEnDORService;
import iih.sc.sch.scsch.i.IScschMDORService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医技排班信息
 * 
 * @author zhengcm
 * @modifier zhengcm 增加集团管控
 *
 */
public class GetMtResListNewBP {
	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	public MtResDTO[] exec(MtAppQryDTO qryDTO, String code_sctp) throws BizException {
		if (null == qryDTO) {
			return null;
		}
		// 检查参数
		ScValidator.validateParam("id_dep", qryDTO.getId_dep());
		ScValidator.validateParam("id_scchl", qryDTO.getId_scchl());
		ScValidator.validateParam("d_begin", qryDTO.getD_begin());
		ScValidator.validateParam("d_end", qryDTO.getD_end());
		if (qryDTO.getFg_autofilter().booleanValue()) {
			ScValidator.validateParam("id_srv", qryDTO.getId_srv_filter());
		}

		// 根据渠道最大预约日期修正查询的结束日期
		FDate end = this.getChlMaxDate(qryDTO,code_sctp);
		if (end != null && qryDTO.getD_end().after(end)) {
			qryDTO.setD_end(end);
		}

		// 查询数据
		List<MtResDTO> mtAptDTOs = this.queryDatas(qryDTO, code_sctp);
		
		if (ListUtil.isEmpty(mtAptDTOs)) {
			return null;
		}
		// 根据就诊类型过滤数据
		//mtAptDTOs = this.filterByEntp(mtAptDTOs, qryDTO);
		
		// 设置号位和号段数据
		new SetMtAptSchTicksBP().exec(mtAptDTOs);

		// 设置排班对应号位和号段的排班服务
		new SetMtAptScSrvBP().exec(mtAptDTOs);

		// 计算渠道剩余可预约数
		new CalcSchChlRemainNewBP().exec(mtAptDTOs,qryDTO);
		
		//设置用户的可选号预约权限
		this.handleCanPsnApt(mtAptDTOs);
		if ( qryDTO.getFg_entp_filter()!= null && qryDTO.getFg_entp_filter().booleanValue()) {
			// 按照就诊类型过滤选号快捷是否可用
			this.filterByEntp(mtAptDTOs, qryDTO);
		}else{
			this.countByEntp(mtAptDTOs, qryDTO);
		}
		return mtAptDTOs.toArray(new MtResDTO[0]);
	}

	/**
	 * 设置当前用户的可选号预约权限
	 * @param mtAptDTOs
	 */
	private void handleCanPsnApt(List<MtResDTO> mtAptDTOs){
		FBoolean fg_canapt = ScParamUtils.canPsnApt()?FBoolean.TRUE:FBoolean.FALSE;
		for (MtResDTO mtResDTO : mtAptDTOs) {
			mtResDTO.setFg_canapt(fg_canapt);
			mtResDTO.setFg_quickapt(FBoolean.TRUE);
		}
	}
	/**
	 * 查询数据
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private List<MtResDTO> queryDatas(MtAppQryDTO qryDTO, String code_sctp) throws BizException {
		boolean isSccaFilter = qryDTO.getId_scca() != null && !"".equals(qryDTO.getId_scca());
		SqlParam params = new SqlParam();
		boolean isDepArray = false;
		if(qryDTO.getId_dep().contains(",")){
			isDepArray = true;
			String  depCond = SqlUtils.getInSqlByIdsSplit(qryDTO.getId_dep());
			params.addParam(depCond);
		}else{
			params.addParam(qryDTO.getId_dep());
		}
		StringBuilder sql = this.getSql(qryDTO.getFg_autofilter().booleanValue(),isSccaFilter,qryDTO.getId_scchl(),isDepArray);
		
		if (!StringUtil.isEmptyWithTrim(code_sctp) && IScDictCodeConst.SD_SCTP_OT.equals(code_sctp)) {
			params.addParam(IScDictCodeConst.SD_SCTP_OT);// 手术
		} else {
			params.addParam(IScDictCodeConst.SD_SCTP_MT);// 医技
		}
		params.addParam(qryDTO.getId_scchl());
		params.addParam(qryDTO.getD_begin());
		params.addParam(qryDTO.getD_end());
		if(isSccaFilter){
			params.addParam(qryDTO.getId_scca());
		}
		if (qryDTO.getFg_autofilter().booleanValue()) {
			params.addParam(qryDTO.getId_srv_filter());
			params.addParam(qryDTO.getId_srv_filter());
		}

		List<MtResDTO> mtAptDTOs = (List<MtResDTO>) new DAFacade().execQuery(sql.toString(), params,
				new BeanListHandler(MtResDTO.class));
		//引入了备用排班服务导致数据会出现重复 根据排班id进行去重
		mtAptDTOs = this.duplicateData(mtAptDTOs);
		return mtAptDTOs;
	}

	/**
	 * 查询Sql
	 *
	 * @param isAutoFilter 是否自动过滤
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql(boolean isAutoFilter,boolean isSccaFilter,String id_scchl,boolean isDepArray) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("pl.id_scca,");
		sb.append("pl.id_scpl,");
		sb.append("pl.name as name_scpl,");
		sb.append("pl.id_tickmd,");
		sb.append("pl.sd_tickmd,");
		sb.append("pl.id_dep,");
		//判断是  排班时长  还是服务时长  都不是 或不存在 则取排班时长
		sb.append("pl.id_scsrv,");
		sb.append("(case pl.eu_timeslottp when 0 then pl.srvslot when 1 then  ");
		sb.append("(case srv.srvslot when null then pl.srvslot when 0 then  pl.srvslot else srv.srvslot end) else pl.srvslot end) as srvlot,");
		sb.append("pl.srvslot_min as srvlot_min,");
		sb.append("pl.eu_timeslottp as Eu_timeslottp,");//类型
		sb.append("res.id_scres as id_res,");
		sb.append("res.name as name_res,");
		sb.append("res.code as code_res,");
		sb.append("res.id_mt,");
		sb.append("'").append(id_scchl).append("' as id_scchl,");
		//sb.append("chl.id_scchl,");
		//sb.append("chl.scpolcn,");
		//sb.append("chl.id_entp as ids_entp,");
		sb.append("sch.id_dayslot,");
		sb.append("lot.code as sd_dayslot,");
		sb.append("lot.name as name_dayslot,");
		sb.append("sch.quan_total,");
		sb.append("sch.quan_total_appt,");
		sb.append("sch.quan_total_used,");
		sb.append("sch.fg_active,");
		sb.append("sch.t_b_acpt,");
		sb.append("sch.t_e_acpt,");
		sb.append("sch.fg_setentp,");
		sb.append("sch.quan0_appt,");
		sb.append("sch.quan1_appt,");
		sb.append("sch.quan2_appt,");
		sb.append("sch.quan3_appt,");
		sb.append("sch.quan4_appt,");
		sb.append("sch.quan5_appt,");
		sb.append("sch.quan6_appt,");
		sb.append("sch.quan7_appt,");
		sb.append("sch.quan8_appt,");
		sb.append("sch.quan9_appt,");
		sb.append("sch.quan0_used,");
		sb.append("sch.quan1_used,");
		sb.append("sch.quan2_used,");
		sb.append("sch.quan3_used,");
		sb.append("sch.quan4_used,");
		sb.append("sch.quan5_used,");
		sb.append("sch.quan6_used,");
		sb.append("sch.quan7_used,");
		sb.append("sch.quan8_used,");
		sb.append("sch.quan9_used ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		//sb.append("inner join sc_sch_chl chl on chl.id_sch = sch.id_sch ");
		sb.append("inner join sc_res res on res.id_scres = pl.id_scres ");
		sb.append("inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append(" inner join sc_srv srv on pl.id_scsrv = srv.id_scsrv ");
		sb.append(" left join sc_sch_optsrv optsrv on sch.id_sch = optsrv.id_sch ");
		sb.append("where ");
		if (isDepArray) {
			sb.append("pl.id_dep  ? ");
		}else{
			sb.append("pl.id_dep = ? ");
		}
		sb.append("and pl.sd_sctp = ? ");
		sb.append("and sch.id_sch in (select id_sch from sc_sch_chl where id_scchl=?)");
		//sb.append("and chl.id_scchl = ? ");
		sb.append("and sch.d_sch >= ? ");
		sb.append("and sch.d_sch <= ? ");
		if(isSccaFilter){
			sb.append("and pl.id_scca = ? ");
		}
		if (isAutoFilter) {
			sb.append("and (pl.id_scsrv in (select rel.id_scsrv from sc_srv_rel rel where rel.id_mdsrv = ?)or optsrv.id_scsrv in (select rel.id_scsrv from sc_srv_rel rel where rel.id_mdsrv = ?))");
		}
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch"));
		
		sb.append("order by sch.d_sch,pl.code");
		return sb;
	}

	/**
	 * 获取渠道最大预约日期
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private FDate getChlMaxDate(MtAppQryDTO qryDTO, String code_sctp) throws BizException {
		if (StringUtil.isEmptyWithTrim(qryDTO.getId_scchl())) {
			return null;
		}
		ISchedulechlMDORService chlQryService = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO chlDO = chlQryService.findById(qryDTO.getId_scchl());
		if (chlDO == null) {
			return null;
		}
		String sd_sctp = IScDictCodeConst.SD_SCTP_MT;
		if (!StringUtil.isEmptyWithTrim(code_sctp)) {
			sd_sctp = IScDictCodeConst.SD_SCTP_OT;
		}
		return new GetAptChlMaxDateBP().exec(chlDO.getCode_scchltp(), sd_sctp);
	}
	/**
	 * 根据就诊类型过滤排班数据
	 * @param mtAptDTOs
	 * @param qryDTO
	 * @return
	 */
	private List<MtResDTO> filterByEntp(List<MtResDTO> mtAptDTOs, MtAppQryDTO qryDTO) throws BizException {
		List<String> idSchList = new ArrayList<String>();
		List<String> idSchEnList = new ArrayList<String>();
		if (ListUtil.isEmpty(mtAptDTOs) || StringUtil.isEmpty(qryDTO.getId_entp())) {
			return mtAptDTOs;
		}
		for (MtResDTO mtResDTO : mtAptDTOs) {
			if (mtResDTO.getFg_setentp().booleanValue()) {
				idSchEnList.add(mtResDTO.getId_sch());
			}
				idSchList.add(mtResDTO.getId_sch());
			}
		if (ListUtil.isEmpty(idSchList)) {
			return mtAptDTOs;
		}
		// 申请单就诊类型
		String id_entp = qryDTO.getId_entp();
		// 获取idsch条件串
		String condition = ScSqlUtils.getInSqlByIds(ScSchChlDO.ID_SCH, idSchList);
		// 获取所有符合条件排班信息
		IScschMDORService iscschmdorservice = ServiceFinder.find(IScschMDORService.class);
		ScSchDO[] schs = iscschmdorservice.find(condition, null, FBoolean.FALSE);
		Map<String,ScSchDO> schMap = new HashMap<String,ScSchDO>();
		for (ScSchDO scSchDO : schs) {
			schMap.put(scSchDO.getId_sch(), scSchDO);
		}
		String schEnCondition = ScSqlUtils.getInSqlByIds(ScSchDO.ID_SCH, idSchEnList);
		// 获取所有符合条件排班的所有排班就诊信息
		IScSchEnDORService iscschendorservice = ServiceFinder.find(IScSchEnDORService.class);
		ScSchEnDO[] schens = iscschendorservice.find(schEnCondition, null, FBoolean.FALSE);
		Map<String, List<ScSchEnDO>> schEnMap = new HashMap<String, List<ScSchEnDO>>();
		if (!ArrayUtil.isEmpty(schens)) {
			// 按照id_sch给排班就诊信息分组
			for (ScSchEnDO scSchEnDO : schens) {
				if (schEnMap.containsKey(scSchEnDO.getId_sch())) {
					schEnMap.get(scSchEnDO.getId_sch()).add(scSchEnDO);
				} else {
					List<ScSchEnDO> schEnList = new ArrayList<ScSchEnDO>();
					schEnList.add(scSchEnDO);
					schEnMap.put(scSchEnDO.getId_sch(), schEnList);
				}
			}

		}
		this.filterSchEntpData(mtAptDTOs, schMap, schEnMap, id_entp);
		return mtAptDTOs;
	}
	/**
	 * 根据就诊类型过滤排班数据
	 * @param mtAptDTOs
	 * @param qryDTO
	 * @return
	 */
	private List<MtResDTO> countByEntp(List<MtResDTO> mtAptDTOs, MtAppQryDTO qryDTO) throws BizException {
		List<String> idSchList = new ArrayList<String>();
		List<String> idSchEnList = new ArrayList<String>();
		if (ListUtil.isEmpty(mtAptDTOs)) {
			return mtAptDTOs;
		}
		for (MtResDTO mtResDTO : mtAptDTOs) {
			if (mtResDTO.getFg_setentp().booleanValue()) {
				idSchEnList.add(mtResDTO.getId_sch());
			}
				idSchList.add(mtResDTO.getId_sch());
			}
		if (ListUtil.isEmpty(idSchList)) {
			return mtAptDTOs;
		}
		// 获取idsch条件串
		String condition = ScSqlUtils.getInSqlByIds(ScSchChlDO.ID_SCH, idSchList);
		// 获取所有符合条件排班信息
		IScschMDORService iscschmdorservice = ServiceFinder.find(IScschMDORService.class);
		ScSchDO[] schs = iscschmdorservice.find(condition, null, FBoolean.FALSE);
		Map<String,ScSchDO> schMap = new HashMap<String,ScSchDO>();
		for (ScSchDO scSchDO : schs) {
			schMap.put(scSchDO.getId_sch(), scSchDO);
		}
		String schEnCondition = ScSqlUtils.getInSqlByIds(ScSchChlDO.ID_SCH, idSchEnList);
		// 获取所有符合条件排班的所有排班就诊信息
		IScSchEnDORService iscschendorservice = ServiceFinder.find(IScSchEnDORService.class);
		ScSchEnDO[] schens = iscschendorservice.find(schEnCondition, null, FBoolean.FALSE);
		Map<String, List<ScSchEnDO>> schEnMap = new HashMap<String, List<ScSchEnDO>>();
		if (!ArrayUtil.isEmpty(schens)) {
			// 按照id_sch给排班就诊信息分组
			for (ScSchEnDO scSchEnDO : schens) {
				if (schEnMap.containsKey(scSchEnDO.getId_sch())) {
					schEnMap.get(scSchEnDO.getId_sch()).add(scSchEnDO);
				} else {
					List<ScSchEnDO> schEnList = new ArrayList<ScSchEnDO>();
					schEnList.add(scSchEnDO);
					schEnMap.put(scSchEnDO.getId_sch(), schEnList);
				}
			}

		}
		this.countSchEntpData(mtAptDTOs, schMap, schEnMap);
		return mtAptDTOs;
	}
	
	/**
	 * 通过号源池 排班就诊 过滤排班数据
	 * @param mtAptDTOs
	 * @param chlMap
	 * @param schEnMap
	 * @return
	 */
	private void countSchEntpData(List<MtResDTO> mtAptDTOs, Map<String,ScSchDO> schMap, Map<String, List<ScSchEnDO>> schEnMap) {
		for (MtResDTO mtAptDTO : mtAptDTOs) {
			String id_sch = mtAptDTO.getId_sch();
			if (schEnMap.containsKey(id_sch)) {
				int ip_remain = 0;
				int op_remain = 0;
				List<ScSchEnDO> schEnList = schEnMap.get(id_sch);
				List<Integer> opPolcsList = new ArrayList<Integer>();
				List<Integer> ipPolcsList = new ArrayList<Integer>();
				for (ScSchEnDO scSchEnDO : schEnList) {
					if (scSchEnDO.getId_entp().contains(IBdFcDictCodeConst.ID_CODE_ENTP_OP)) {
						opPolcsList.add(scSchEnDO.getScpolcn());
					}
					if (scSchEnDO.getId_entp().contains(IBdFcDictCodeConst.ID_CODE_ENTP_IP)) {
						ipPolcsList.add(scSchEnDO.getScpolcn());
					}
				}
				
				for (Integer polcn : ipPolcsList) {
					ScSchDO sch = schMap.get(id_sch);
					ip_remain += Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_appt").toString())
							- Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_used").toString());
				}
			
				for (Integer polcn : opPolcsList) {
					ScSchDO sch = schMap.get(id_sch);
					op_remain += Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_appt").toString())
								- Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_used").toString());
				}
				mtAptDTO.setIp_apt_num(ip_remain);
				mtAptDTO.setOp_apt_num(op_remain);
			}else if (!mtAptDTO.getFg_setentp().booleanValue()) {
				int remain = 0;
				for (int i = 0; i < 10; i++) {
					ScSchDO sch = schMap.get(id_sch);
					remain += Integer.parseInt(sch.getAttrVal("Quan" + i + "_appt").toString())
							- Integer.parseInt(sch.getAttrVal("Quan" + i + "_used").toString());
				}
				if (remain == 0) {
					mtAptDTO.setFg_quickapt(FBoolean.FALSE);
					mtAptDTO.setFg_canapt(FBoolean.FALSE);
				}
				mtAptDTO.setIp_apt_num(remain);
				mtAptDTO.setOp_apt_num(remain);
			}
		}
	}
	/**
	 * 通过号源池 排班就诊 过滤排班数据
	 * @param mtAptDTOs
	 * @param chlMap
	 * @param schEnMap
	 * @return
	 */
	private void filterSchEntpData(List<MtResDTO> mtAptDTOs, Map<String,ScSchDO> schMap, Map<String, List<ScSchEnDO>> schEnMap,
			String id_entp) {
		for (MtResDTO mtAptDTO : mtAptDTOs) {
			String id_sch = mtAptDTO.getId_sch();
			if (schEnMap.containsKey(id_sch)) {
				int remain = 0;
				int ip_remain = 0;
				int op_remain = 0;
				List<ScSchEnDO> schEnList = schEnMap.get(id_sch);
				List<Integer> polcnList = new ArrayList<Integer>();
				List<Integer> opPolcsList = new ArrayList<Integer>();
				List<Integer> ipPolcsList = new ArrayList<Integer>();
				for (ScSchEnDO scSchEnDO : schEnList) {
					if (scSchEnDO.getId_entp().contains(id_entp)) {
						polcnList.add(scSchEnDO.getScpolcn());
					}
					if (scSchEnDO.getId_entp().contains(IBdFcDictCodeConst.ID_CODE_ENTP_OP)) {
						opPolcsList.add(scSchEnDO.getScpolcn());
					}
					if (scSchEnDO.getId_entp().contains(IBdFcDictCodeConst.ID_CODE_ENTP_IP)) {
						ipPolcsList.add(scSchEnDO.getScpolcn());
					}
				}
				for (Integer polcn : polcnList) {
					ScSchDO sch = schMap.get(id_sch);
					remain += Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_appt").toString())
							- Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_used").toString());
				}
				
				for (Integer polcn : ipPolcsList) {
					ScSchDO sch = schMap.get(id_sch);
					ip_remain += Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_appt").toString())
							- Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_used").toString());
				}
				
				for (Integer polcn : opPolcsList) {
					ScSchDO sch = schMap.get(id_sch);
					op_remain += Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_appt").toString())
							- Integer.parseInt(sch.getAttrVal("Quan" + polcn + "_used").toString());
					}
				if (remain == 0) {
					mtAptDTO.setFg_quickapt(FBoolean.FALSE);
					mtAptDTO.setFg_canapt(FBoolean.FALSE);
				}
				mtAptDTO.setIp_apt_num(ip_remain);
				mtAptDTO.setOp_apt_num(op_remain);
			}else if (!mtAptDTO.getFg_setentp().booleanValue()){
				int remain = 0;
				for (int i = 0; i < 10; i++) {
					ScSchDO sch = schMap.get(id_sch);
					remain += Integer.parseInt(sch.getAttrVal("Quan" + i + "_appt").toString())
							- Integer.parseInt(sch.getAttrVal("Quan" + i + "_used").toString());
				}
				if (remain == 0) {
					mtAptDTO.setFg_quickapt(FBoolean.FALSE);
					mtAptDTO.setFg_canapt(FBoolean.FALSE);
				}
				mtAptDTO.setIp_apt_num(remain);
				mtAptDTO.setOp_apt_num(remain);
			}
		}
	}
	/**
	 * 排班日期去重 根据 排班id
	 * @param mtAptDTOs
	 * @return
	 */
	private List<MtResDTO> duplicateData(List<MtResDTO> mtAptDTOs){
		if(ListUtil.isEmpty(mtAptDTOs)) return null;
		List<MtResDTO> result = new ArrayList<MtResDTO>();
		Map<String,MtResDTO> schMap = new LinkedHashMap<String,MtResDTO>();
		for (MtResDTO mtResDTO : mtAptDTOs) {
			if(!schMap.containsKey(mtResDTO.getId_sch())){
				schMap.put(mtResDTO.getId_sch(), mtResDTO);
			}
		}
		for(Entry<String, MtResDTO> entry : schMap.entrySet()){
			MtResDTO resDto = entry.getValue();
			result.add(resDto);
		}
		return result;
	}
}
