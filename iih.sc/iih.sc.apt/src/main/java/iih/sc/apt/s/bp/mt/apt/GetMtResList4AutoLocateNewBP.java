package iih.sc.apt.s.bp.mt.apt;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.s.bp.GetAptChlMaxDateBP;
import iih.sc.apt.s.bp.mt.SetMtAptScSrvBP;
import iih.sc.apt.s.bp.mt.SetMtAptSchTicksBP;
import iih.sc.apt.s.bp.mt.apt.auto.AptCheckChlPeriodAutoBP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.i.IScSchEnDORService;
import iih.sc.sch.scsch.i.IScSchOptsrvDORService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
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
public class GetMtResList4AutoLocateNewBP {
	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	public MtResDTO[] exec(MtAppQryDTO qryDTO,MtAppDTO appDTO, String code_sctp) throws BizException {
		if (null == qryDTO) {
			return null;
		}
		//自动定位时使用的开始时间默认为当天
		qryDTO.setD_begin(ScAppUtils.getServerDate());
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
		List<MtResDTO> mtAptDTOs = this.queryDatas(qryDTO, code_sctp,true);
		if(StringUtil.isEmpty(code_sctp)){
			code_sctp = IScDictCodeConst.SD_SCTP_MT;
		}
		MtResDTO sch = this.getAptSch(mtAptDTOs,qryDTO,appDTO,code_sctp);
		if(sch != null){
			qryDTO.setD_begin(sch.getD_sch());
			qryDTO.setD_end(sch.getD_sch().getDateAfter(7));
			mtAptDTOs = this.queryDatas(qryDTO, code_sctp,false);
		}else{
			mtAptDTOs = null;
		}
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
	 * 获取可预约的排班
	 * @param schs
	 * @return
	 * @throws BizException 
	 */
	private MtResDTO getAptSch(List<MtResDTO> schs,MtAppQryDTO qryDTO,MtAppDTO appDTO,String sd_sctp) throws BizException{
		if(ListUtil.isEmpty(schs)) return null;
		if(appDTO == null) return null;

		
 		OralAptEP aptEP = new OralAptEP();
		if (StringUtil.isEmptyWithTrim(appDTO.getId_pat())) {
			throw new BizException("预约患者为空，请检查！");
		}
		MtResDTO[] scSchs = schs.toArray(new MtResDTO[0]);
		MtResDTO resDTO = new MtResDTO();
		// 3、 医技服务互斥检查 根据idSrv和患者id查询出患者从一定时间开始的所有预约记录并且计算出各种互斥类型的日期在resDTO中返回

		if (IScDictCodeConst.SD_SCTP_MT.equals(sd_sctp)) {
			this.checkSrvMutex(appDTO.getId_pat(), appDTO.getId_srv(),appDTO.getId_ent(), ScAppUtils.getServerDateTime(), resDTO,appDTO.getFg_hp());
		}
	
		// 4、 根据排斥日期筛选出可用排班
		scSchs = this.getScSch8ExclDate(scSchs, resDTO);
		if(ArrayUtil.isEmpty(scSchs)){
			throw new BizException(IScMsgConst.SC_APT_NOT_FIND_EXCL_SCH);
		}
		
		// 5、渠道期间检查
		scSchs = new AptCheckChlPeriodAutoBP().exec(qryDTO.getId_scchl(), sd_sctp,scSchs);
		if(ArrayUtil.isEmpty(scSchs)){
			throw new BizException(IScMsgConst.SC_APT_NOT_FIND_PERIOD_SCH);
		}
		
		ScPlanDO planDO = null;
		// 6、 循环处理排班数据
		for (MtResDTO scSchDO : scSchs) {
			// 本次排班是否可以预约
			 planDO = aptEP.getScPlan(scSchDO.getId_scpl());
			
			// 6.4、查询排班信息
			ScSchDO schDO = aptEP.getSch(scSchDO.getId_sch());
			
			// 6.5、查询渠道信息
			ScSchChlDO[] chlDOs = aptEP.getSchChlByCond(String.format("id_sch = '%s' and id_scchl = '%s'", scSchDO.getId_sch(), qryDTO.getId_scchl()),null);
			if(ArrayUtil.isEmpty(chlDOs)){
				continue;
			}
			// 6.6、校验排班数据
			if(!this.checkSchInfo(planDO, schDO, chlDOs[0])){
				continue;
			} 
			// 6.7 根据科室参数SC0030 判断是否需要校验排班服务
			if(ScParamUtils.getscAptCOI(ScContextUtils.getDeptId()).booleanValue()){
				this.checkSchSrv(appDTO.getId_srv(),scSchDO.getId_sch(),planDO);
			}
			// 6.8、 获取可用号位信息
			ScSchTickDO tickDO = this.getSchTick(planDO, resDTO, appDTO, qryDTO.getId_scchl(),chlDOs,schDO);
			if(tickDO == null){
				continue;
			}else{
				return scSchDO;
			}
		}
		return null;
	}
	/**
	 * 医技服务互斥检查
	 * @param id_pat 患者id
	 * @param id_srv 诊疗项目 id
	 * @param id_ent 就诊id
	 * @param aptTime 预约时间
	 * @param resDTO 排班数据
	 * @param fg_hp 医保支付标识
	 * @throws BizException
	 * @author yzh
	 */
	private void checkSrvMutex(String id_pat, String id_srv,String id_ent,FDateTime aptTime,MtResDTO resDTO,FBoolean fg_hp) throws BizException {
		// 检查患者是否存在有效期内的互斥项目
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		schOutQryService.mutexCheck4AutoMtApt8ExclDate(id_pat, id_srv,id_ent,aptTime,resDTO,fg_hp);
	}
	
	/**
	 * 通过互斥日期筛选可用的排班
	 * @author yzh
	 * @param scSchDOs
	 * @param resDTO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private MtResDTO[] getScSch8ExclDate(MtResDTO[] scSchDOs, MtResDTO resDTO) {
		this.duplicateExclDate(resDTO);
		List<MtResDTO> result = new ArrayList<MtResDTO>();
		List<MtResDTO> canuse_scsch_result = new ArrayList<MtResDTO>();
		List<MtResDTO> mustuse_scsch_result = new ArrayList<MtResDTO>();
		List<MtResDTO> mustsel_scsch_result = new ArrayList<MtResDTO>();
		
		FArrayList days_excl_must = resDTO.getDays_excl_must();// 排斥禁止
		FArrayList days_excl_times = resDTO.getDays_excl_times();// 排斥次数禁止
		FArrayList days_together_must = resDTO.getDays_together_must();// 并行禁止
		FArrayList days_together_hint = resDTO.getDays_together_hint();// 并行提示
		for (MtResDTO scSchDO : scSchDOs) {
			FDate d_sch = scSchDO.getD_sch().asBegin();
			boolean canUseCheck = true;//可用
			boolean mustUseCheck = false;//并行提示
			boolean mustSelCheck = false;//并行禁止
			// 1.过滤排斥禁止
			if (!ListUtil.isEmpty(days_excl_must)) {
				for (Object exclMust : days_excl_must) {
					FMap dtMap = (FMap) exclMust;
					if(MapUtils.isEmpty(dtMap)){
						continue;
					}
					FDate dt_b = new FDate(dtMap.get("dt_b").toString());
					FDate dt_e = new FDate(dtMap.get("dt_e").toString());
					if (d_sch.compareTo(dt_b) > 0 && d_sch.compareTo(dt_e) < 0) {
						canUseCheck = false;
					}
				}
			}
			// 2.过滤排斥次数
			if (!ListUtil.isEmpty(days_excl_times)) {
				if (canUseCheck) {
					Map<String,Integer> countMap = new HashMap<String,Integer>();
					for (Object exclTime : days_excl_times) {
						int countMax = 0;
						FArrayList timesList = (FArrayList) exclTime;
						if (!ListUtil.isEmpty(timesList)) {
							for (Object exclTimeMap : timesList) {
								FMap dtMap = (FMap) exclTimeMap;
								if(MapUtils.isEmpty(dtMap)){
									continue;
								}
								if (countMap.containsKey(dtMap.get("pk"))) {
									countMax = countMap.get(dtMap.get("pk"));
								}
								int times = Integer.parseInt(dtMap.get("times").toString());
								FDate dt_b = new FDate(dtMap.get("dt_b").toString());
								FDate dt_e = new FDate(dtMap.get("dt_e").toString());
								if (d_sch.compareTo(dt_b) >= 0 && d_sch.compareTo(dt_e) <= 0) {
									countMax++;
								}
								if (countMax == times) {
									canUseCheck = false;
									break;
								}
								countMap.put(dtMap.get("pk").toString(), countMax);
							}
						}
					}
				}
			}
			// 通过了排斥禁止和次数限制限制后校验并行禁止 符合并行禁止的排班要优先使用
			if(canUseCheck){
				// 3.过滤并行禁止
				if (!ListUtil.isEmpty(days_together_must)) {
					boolean select = false;
					for (Object togetherMust : days_together_must) {
						FMap dtMap = (FMap) togetherMust;
						if(MapUtils.isEmpty(dtMap)){
							continue;
						}
						FDate dt_b = new FDate(dtMap.get("dt_b").toString());
						FDate dt_e = new FDate(dtMap.get("dt_e").toString());
						FDate aptTime = new FDate(dtMap.get("aptTime").toString()).asBegin();
						if(d_sch.compareTo(dt_b) >= 0 || d_sch.compareTo(dt_e) <= 0 ){
							mustSelCheck = true;
							if(d_sch.compareTo(aptTime)==0){
								select = true;
							}
						}
					}
					if(mustSelCheck){
						if(select){
							scSchDO.setFg_release(FBoolean.TRUE);//强制并行释放号源类别明细
							mustsel_scsch_result.add(0, scSchDO);
						}else{
							if(mustsel_scsch_result.size() == 0)
							{
								mustsel_scsch_result.add(0,scSchDO);
							}
							else
							{
								mustsel_scsch_result.add(mustsel_scsch_result.size(),scSchDO);
							}
						}
						canUseCheck = false;
					}
				}
			}
				// 过滤并行提示
				if (canUseCheck) {
					if(!ListUtil.isEmpty(days_together_hint)){
						boolean select = false;
						for (Object togetherHint : days_together_hint) {
							FMap dtMap = (FMap) togetherHint;
							if(MapUtils.isEmpty(dtMap)){
								continue;
							}
							FDate dt_b = new FDate(dtMap.get("dt_b").toString());
							FDate dt_e = new FDate(dtMap.get("dt_e").toString());
							FDate aptTime = new FDate(dtMap.get("aptTime").toString()).asBegin();
							if(d_sch.compareTo(dt_b) >= 0 || d_sch.compareTo(dt_e) <= 0 ){
								mustUseCheck = true;
								if(d_sch.compareTo(aptTime)==0){
									select = true;
								}
							}
						}
						if(mustUseCheck){
							scSchDO.setFg_release(FBoolean.TRUE);//强制并行释放号源类别明细
							if(select){
								mustuse_scsch_result.add(0, scSchDO);
							}else{
								mustuse_scsch_result.add(mustuse_scsch_result.size(),scSchDO);
							}
						}
					}
				}
			
			
			// 非并行禁止和并行提示的可用数据归入可用
			if (canUseCheck && !mustSelCheck && !mustUseCheck) {
				canuse_scsch_result.add(scSchDO);
			}
		}
		 
		// 4.顺序添加并行禁止的排班
		if (!ListUtil.isEmpty(mustsel_scsch_result)) {
			result.addAll(this.levelPriSort(mustsel_scsch_result));
		}
		// 5.顺序添加并行提示的排班
		if (!ListUtil.isEmpty(mustuse_scsch_result)) {
			result.addAll(this.levelPriSort(mustuse_scsch_result));
		}
		// 6.顺序添加可用的排班
		if(!ListUtil.isEmpty(canuse_scsch_result)){
			result.addAll(this.levelPriSort(canuse_scsch_result)); 
		}
		return result.toArray(new MtResDTO[0]);
	}
	
	/**
	 * 优先级排序
	 * @param resList
	 */
	@SuppressWarnings("unchecked")
	private List<MtResDTO> levelPriSort(List<MtResDTO> resList){
 		List<MtResDTO> result = new ArrayList<MtResDTO>(); 
		FMap map = new FMap();
		for (MtResDTO mtResDTO : resList) {
			if(!map.containsKey(mtResDTO.getD_sch().toString())){
				List<MtResDTO> list = new ArrayList<MtResDTO>();
				list.add(mtResDTO);
				map.put(mtResDTO.getD_sch().toString(), list);
			}else{
				List<MtResDTO> list =  (List<MtResDTO>) map.get(mtResDTO.getD_sch().toString());
				list.add(mtResDTO);
			}
		}
		for (Entry<String, Object> entry : map.entrySet()) {
			List<MtResDTO> list = (List<MtResDTO>) entry.getValue();
			Collections.sort(list, new Comparator<MtResDTO>() {
				@Override
				public int compare(MtResDTO o1, MtResDTO o2) {
					// 按照优先级进行降序排序
					if (o1.getT_b_acpt().before(o2.getT_b_acpt())) {
						return -1;
					}
					if (o1.getT_b_acpt().compareTo(o2.getT_b_acpt()) == 0) {
						return 0;
					}
					return 1;
				}
			});
		}
		for (Entry<String, Object> entry : map.entrySet()) {
			List<MtResDTO> list = (List<MtResDTO>) entry.getValue();
			Collections.sort(list, new Comparator<MtResDTO>() {
				@Override
				public int compare(MtResDTO o1, MtResDTO o2) {
					// 按照优先级进行降序排序
					if (o1.getLevel_pri() > o2.getLevel_pri()) {
						return -1;
					}
					if (o1.getLevel_pri() == o2.getLevel_pri()) {
						if(o1.getT_b_acpt().compareTo(o2.getT_b_acpt()) == 0){
							int o1Remain = 0;
							int o2Remain = 0;
							if(IScDictCodeConst.SD_TICKMD_TIME.equals(o1.getSd_tickmd())){
								o1Remain = o1.getQuan_total_appt()-o1.getQuan_total_used();
								o1Remain = (int) Math.floor(o1Remain/((o1.getSrvlot() == null || o1.getSrvlot() == 0)?(o1.getSrvlot_min() == null || o1.getSrvlot_min()==0)?1:o1.getSrvlot_min():o1.getSrvlot()));
							}else{
								o1Remain = o1.getQuan_total_appt()-o1.getQuan_total_used();
							}
							if(IScDictCodeConst.SD_TICKMD_TIME.equals(o2.getSd_tickmd())){
								o2Remain = o2.getQuan_total_appt()-o2.getQuan_total_used();
								o2Remain = (int) Math.floor(o2Remain/((o1.getSrvlot() == null || o1.getSrvlot() == 0)?(o2.getSrvlot_min() == null || o2.getSrvlot_min() ==0)?1:o2.getSrvlot_min():o2.getSrvlot()));
							}else{
								o2Remain = o2.getQuan_total_appt()-o2.getQuan_total_used();
							}
							if(o1Remain > o2Remain){
								return -1;
							}
						}
						return 0;
					}
					return 1;
				}
			});
			result.addAll(list);
		}
		return result;
	}
	
	/**
	 * 去除排斥日期中重复的数据
	 * @param resDTO
	 */
	@SuppressWarnings("unchecked")
	private void duplicateExclDate(MtResDTO resDTO){
		FArrayList exclMust = resDTO.getDays_excl_must();
		FArrayList exclTimes = resDTO.getDays_excl_times();
		FArrayList togetherMust = resDTO.getDays_together_must();
		FArrayList exclHint = resDTO.getDays_excl_hint();
		FArrayList togetherHint = resDTO.getDays_together_hint();
		// 1.排斥禁止
		if(!ListUtil.isEmpty(exclMust)){
			FArrayList exclMustTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclMust);
			exclMustTemp.addAll(setData);
			resDTO.setDays_excl_must(exclMustTemp);
		}
		// 2.次数限制
		if (!ListUtil.isEmpty(exclTimes)) {
			FArrayList exclTimesTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclTimes);
			exclTimesTemp.addAll(setData);
			resDTO.setDays_excl_times(exclTimesTemp);
		}
		//3.并行禁止
		if(!ListUtil.isEmpty(togetherMust)){
			FArrayList togetherMustTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(togetherMust);
			togetherMustTemp.addAll(setData);
			resDTO.setDays_together_must(togetherMustTemp);
		}
		// 4.排斥提示
		if(!ListUtil.isEmpty(exclHint)){
			FArrayList exclHintTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclHint);
			exclHintTemp.addAll(setData);
			resDTO.setDays_excl_hint(exclHintTemp);
		}
		// 5.并行提示
		if(!ListUtil.isEmpty(togetherHint)){
			FArrayList togetherHintTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(togetherHint);
			togetherHintTemp.addAll(setData);
			resDTO.setDays_together_hint(togetherHintTemp);
		}
	}
	
	/**
	 * 校验数据
	 *
	 * @param planDO
	 * @param schDO
	 * @param chlDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private boolean checkSchInfo(ScPlanDO planDO, ScSchDO schDO, ScSchChlDO chlDO) throws BizException {
		if (null == planDO) {
			return false;
		}
		if (null == schDO) {
			return false;
		} else if (!schDO.getFg_active().booleanValue()) {
			return false;
		}
		if (null == chlDO) {
			return false;
		}
		return true;
	}
	
	/**
	 * 校验医疗服务是否在排班所对应排班服务当中
	 * @param id_srv
	 * @param schDO
	 * @throws BizException 
	 */
	private boolean checkSchSrv(String id_srv,String id_sch,ScPlanDO planDO) throws BizException{
		// 排班服务查询服务
		IScheduleSrvRelDORService relQryService = ServiceFinder.find(IScheduleSrvRelDORService.class);
		String where = String.format(ScheduleSrvRelDO.ID_MDSRV + " = '%s'", id_srv);
		ScheduleSrvRelDO[] relDOs = relQryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(relDOs)) {
			return false;
		}
		List<String> scSrvIds = new ArrayList<String>();
		for (ScheduleSrvRelDO relDO : relDOs) {
			scSrvIds.add(relDO.getId_scsrv());
		}
		//查询排班的备用排班服务
		IScSchOptsrvDORService iscschoptsrvdorservice = ServiceFinder.find(IScSchOptsrvDORService.class);
		ScSchOptsrvDO[] optsrvs = iscschoptsrvdorservice.find("id_sch='"+id_sch+"'", null, FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(optsrvs)){
			for (ScSchOptsrvDO scSchOptsrvDO : optsrvs) {
				scSrvIds.add(scSchOptsrvDO.getId_scsrv());
			}
		}
		if(!scSrvIds.contains(planDO.getId_scsrv())){
			return false;
		}
		return true;
	}
	/**
	 * 获取排班号位
	 *
	 * @param planDO
	 * @param resDTO
	 * @param appDTO
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchTickDO getSchTick(ScPlanDO planDO, MtResDTO resDTO, MtAppDTO appDTO, String id_scchl,ScSchChlDO[] chlDOs,ScSchDO schDO)
			throws BizException {
		List<Integer> polcnList = new ArrayList<Integer>();
		for (ScSchChlDO scschchldo : chlDOs) {
			polcnList.add(scschchldo.getScpolcn());
		}
		ScSchTickDO tickDO = null;
		IScSchOutCmdService outQryService = ServiceFinder.find(IScSchOutCmdService.class);
		String sd_tickmd = schDO.getSd_tickmd();// 票号模式
		List<String> schIdList = new ArrayList<String>();
		schIdList.add(schDO.getId_sch());
		Map<String, Map<Integer,Integer>> polcnMap = ServiceFinder.find(IScSchOutQryService.class).batchGetChlSchRemainFilterEntpAmount4AutoApt(schIdList,appDTO.getId_enttp(), id_scchl);
		if(polcnMap == null) return null;
		Map<Integer,Integer> polcnNumMap = polcnMap.get(schDO.getId_sch());
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(sd_tickmd)) {// 号位模式
			// 自动预约
			tickDO = outQryService.occupyChlTickBySch4AutoLocate(schDO.getId_sch(),polcnNumMap, null, id_scchl, appDTO.getId_enttp(), resDTO,appDTO.getId_srv());
			//tickDO = outQryService.occupyChlTickBySch4Manual(resDTO.getId_sch(),polcnNumMap, null, id_scchl, appDTO.getId_enttp(), resDTO,appDTO.getId_srv());
		} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_tickmd)) {// 号段模式
			// 占用号段号位
			tickDO = outQryService.occupyChlTickBySch4AutoLocate(schDO.getId_sch(), polcnNumMap,resDTO.getId_ticks(), id_scchl,appDTO.getId_enttp(),resDTO,appDTO.getId_srv());
			//tickDO = outQryService.occupyChlTickBySch4Manual(resDTO.getId_sch(), polcnNumMap,resDTO.getId_ticks(), id_scchl,appDTO.getId_enttp(),resDTO,appDTO.getId_srv());
		} else if(IScDictCodeConst.SD_TICKMD_TIME.equals(sd_tickmd)){//时间片模式
			// 占用时间段号位
			tickDO = outQryService.occupyChlTimeBySch4AutoLocate(planDO, appDTO, id_scchl,chlDOs,schDO,resDTO);
			//tickDO = outQryService.OccupyChlTimeBySchQuick4Manual(planDO,appDTO,id_scchl,chlDOs,schDO,resDTO);
		}
		return tickDO;
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
	private List<MtResDTO> queryDatas(MtAppQryDTO qryDTO, String code_sctp,boolean isAll) throws BizException {
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
	
		StringBuilder sql = this.getSql(qryDTO.getFg_autofilter().booleanValue(),isSccaFilter,qryDTO.getId_scchl(),isDepArray,isAll);
		
		if (null != code_sctp && !IScDictCodeConst.SD_SCTP_MT.equals(code_sctp)) {
			params.addParam(IScDictCodeConst.SD_SCTP_OT);// 手术
		} else {
			params.addParam(IScDictCodeConst.SD_SCTP_MT);// 医技
		}
		params.addParam(qryDTO.getId_scchl());
		params.addParam(qryDTO.getD_begin());
		if(!isAll){
			params.addParam(qryDTO.getD_end());
		}
		
		if(isSccaFilter){
			params.addParam(qryDTO.getId_scca());
		}
		if (qryDTO.getFg_autofilter().booleanValue()) {
			params.addParam(qryDTO.getId_srv_filter());
			params.addParam(qryDTO.getId_srv_filter());
		}
		List<MtResDTO> mtAptDTOs = (List<MtResDTO>) new DAFacade().execQuery(sql.toString(), params,
				new BeanListHandler(MtResDTO.class));
		//由于备用排班服务会导致排班查询出重复的 根据排班id进行一次去重
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
	private StringBuilder getSql(boolean isAutoFilter,boolean isSccaFilter,String id_scchl,boolean isDepArray,boolean isAll) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("pl.id_scca,");
		sb.append("pl.id_scpl,");
		sb.append("pl.name as name_scpl,");
		sb.append("pl.id_tickmd,");
		sb.append("pl.sd_tickmd,");
		sb.append("pl.level_pri,");
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
		if(!isAll){
			sb.append("and sch.d_sch <= ? ");
		}
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
		if (null != code_sctp) {
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
