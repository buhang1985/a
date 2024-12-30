package iih.sc.sch.s.bp.mt.apt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.scsrvexcl.d.ScSrvExclDO;
import iih.sc.sch.s.bp.AptCheckPatHpEnBP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * 医技预约项目互斥检查BP
 * 
 * @author yzh
 * @date 2018年8月1日 15:57:11
 *
 */

public class SrvMutexCheck4AutoMtAptBP {

	/**
	 * 自动预约 项目互斥检查
	 * @param id_pat 患者id
	 * @param id_srv 诊疗项目id
	 * @param id_ent 就诊id
	 * @param aptTime 预约时间
	 * @param resDTO 排班数据
	 * @param fg_hp 医保支付标识
	 * @throws BizException
	 * @author yzh
	 */
	public void exec(String id_pat, String id_srv,String id_ent, FDateTime aptTime, MtResDTO resDTO,FBoolean fg_hp) throws BizException {

		// 1、根据系统参数[最大检查互斥天数]计算开始时间
		int days = ScParamUtils.getExcluMaxDay();
		FDate today = aptTime.getDate().asBegin();
		FDate begin_date = today.getDateBefore(days);

		//是否适用医保互斥规则
		FBoolean isHp = FBoolean.FALSE;
		// 判断患者该次就诊是否是医保就诊
		FBoolean isHpPat = new AptCheckPatHpEnBP().exec(id_ent);
		//患者为医保就诊并且医保支付则适用医保互斥规则
		if(isHpPat.booleanValue() && fg_hp.booleanValue()){
			isHp = FBoolean.TRUE;
		}
		//自费时处理
		if(!isHp.booleanValue()){
			// 1、查询日期区间内患者已预约的所有预约记录
			List<ScAptApplDO> aptApplDOList = this.getPatAptScSrvList(id_pat, begin_date,isHp);
			// 2、互斥检查
			this.mutexCheck(id_srv,id_ent, aptApplDOList, aptTime, resDTO,isHp);
		}else{//医保时处理
			// 1.查询日期区间内患者已预约的所有预约记录
			List<ScAptApplDO> aptApplDONotHpList = this.getPatAptScSrvList(id_pat, begin_date,FBoolean.FALSE);
			// 2、互斥检查 自费规则
			this.mutexCheck(id_srv,id_ent, aptApplDONotHpList, aptTime, resDTO,FBoolean.FALSE);
			// 3、查询日期区间内患者已预约的医保支付的预约记录
			List<ScAptApplDO> aptApplDOHpList = this.getPatAptScSrvList(id_pat, begin_date,isHp);
			// 4、 互斥检查 医保规则
			this.mutexCheck(id_srv,id_ent, aptApplDOHpList, aptTime, resDTO,isHp);
		}
	}

	@SuppressWarnings("unchecked")
	private List<ScAptApplDO> getPatAptScSrvList(String id_pat, FDate begin,FBoolean isHp) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select a.id_aptappl,apt.dt_b, apt.dt_e, a.id_srv,a.name,res.name as scres_name ");
		sb.append("from ");
		sb.append("sc_apt_appl a ");
		sb.append("inner join sc_apt apt on a.id_scapt = apt.id_apt ");
		sb.append("left join sc_res res on a.id_scres = res.id_scres ");
		sb.append("where apt.id_pat =? ");
		sb.append("and apt.fg_canc = 'N' ");
		sb.append("and apt.dt_b >? ");
		sb.append("and a.id_srv is not null ");
		if(isHp.booleanValue()){
			sb.append("and a.fg_hp='Y' ");
		}
		SqlParam params = new SqlParam();
		params.addParam(id_pat);
		params.addParam(begin);

		List<ScAptApplDO> list = (List<ScAptApplDO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(ScAptApplDO.class));

		return list;
	}

	/**
	 * 查询项目排斥记录
	 * 
	 * @param id_srv
	 * @param type
	 *            0 为单向
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<ScSrvExclDO> getExclSrvList(String id_srv, int type,FBoolean isHpPat) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select b.id_mdsrv as id_srv,a.id_scsrvexcltp,a.note,")
			.append("a.fg_hp,a.times,a.period,a.id_measdoc_period,a.id_scsrvexcl,a.fg_direct  ")
			.append("from ")
			.append("sc_srv_excl a ");
		if (type == 0) {
			sb.append("inner join sc_srv_rel b on a.id_scsrv_b = b.id_scsrv ")
				.append("where a.id_scsrv_a in ");
		} else {
			sb.append("inner join sc_srv_rel b on a.id_scsrv_a = b.id_scsrv ")
				.append("where a.id_scsrv_b in ");
		}
		sb.append("(select id_scsrv from sc_srv_rel where id_mdsrv =?) ");
		sb.append("and a.fg_active='Y' ");
		if (!isHpPat.booleanValue()) {
			sb.append("and a.fg_hp = 'N'");
		}else{
			sb.append("and a.fg_hp = 'Y'");
		}

		SqlParam params = new SqlParam();
		params.addParam(id_srv);
		List<ScSrvExclDO> list = (List<ScSrvExclDO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(ScSrvExclDO.class));

		return list;
	}

	/**
	 * 服务互斥检查
	 * @param id_srv 申请单服务id
	 * @param id_ent 就诊id
	 * @param aptApplDOList 申请单list
	 * @param nowTime 当前时间
	 * @param resDTO 排班数据
	 * @param fg_hp 医保支付标识
	 * @param resDTO中存放互斥关系的集合是否初始化
	 * @throws BizException
	 * @author yzh
	 */
	// FIXME 根据排斥类型要有返回值
	private void mutexCheck(String id_srv,String id_ent, List<ScAptApplDO> aptApplDOList, FDateTime nowTime, MtResDTO resDTO,FBoolean isHp)
			throws BizException {
  		this.initDaysList(resDTO);
		if (ListUtil.isEmpty(aptApplDOList)) {
			return;
		}

		List<String> scsrvList = new ArrayList<String>();
		for (ScAptApplDO aptDO : aptApplDOList) {
			scsrvList.add(aptDO.getId_srv());
		}
		// 正向检查
		List<ScSrvExclDO> forward_datas = getExclSrvList(id_srv, 0,isHp);
		// 反向检查
		List<ScSrvExclDO> reverse_datas = getExclSrvList(id_srv, 1,isHp);
		this.check(id_srv, forward_datas, aptApplDOList, ScAppUtils.getServerDateTime(), 0, resDTO);
		this.check(id_srv, reverse_datas, aptApplDOList, ScAppUtils.getServerDateTime(), 1, resDTO);
	}
	
	/**
	 * 初始化
	 * @param resDTO
	 */
	private void initDaysList(MtResDTO resDTO){
		if(resDTO.getDays_excl_must() != null) return;
		resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
		resDTO.setDays_excl_must(new FArrayList());
		resDTO.setDays_excl_hint(new FArrayList());
		resDTO.setDays_together_must(new FArrayList());
		resDTO.setDays_together_hint(new FArrayList());
		resDTO.setDays_excl_times(new FArrayList());
	}
	/***
	 * @author yzh
	 * @param id_srv 医疗项目id
	 * @param datas 满足条件的互斥服务
	 * @param aptApplDOList 预约记录
	 * @param nowTime 当前时间
	 * @param type 正向反向类型
	 * @param resDTO
	 * @throws BizException
	 */
	private void check(String id_srv, List<ScSrvExclDO> datas, List<ScAptApplDO> aptApplDOList, FDateTime nowTime,
			int type,MtResDTO resDTO) throws BizException {
		if(ListUtil.isEmpty(datas)){
			return;
		}
		Map<String,List<ScAptApplDO>> scAptAppMap = new HashMap<String,List<ScAptApplDO>>();
		String aptIdSrvs = handleAptApplList(aptApplDOList,scAptAppMap);
		// 互斥单位
		List<String> measIdList = new ArrayList<String>();
		for (ScSrvExclDO scSrvExclDO : datas) {
			measIdList.add(scSrvExclDO.getId_measdoc_period());
		}
		IMedsrvMDORService imedsrvmdorservice = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO medsrv = imedsrvmdorservice.findById(id_srv);
		// 互斥单位
		Map<String, MeasDocDO> docMap = this.getMeasMap(measIdList);
		// 存放预约单排斥的 开始时间dt_b 和 结束时间dt_e
 		FMap dtMap = new FMap();
 		int direct_type = type;
		for (ScSrvExclDO scSrvExclDO : datas) {
			type = direct_type;
			dtMap.clear();
			if (!scSrvExclDO.getFg_direct().booleanValue()) {
				type = 1;
			}
   			String idSrv = scSrvExclDO.getId_srv();
			if(aptIdSrvs.contains(idSrv)){
				MeasDocDO measDocDO = docMap.get(scSrvExclDO.getId_measdoc_period());
				if (null == measDocDO) {
					continue;
				}
				
				List<ScAptApplDO> scAptApplList = scAptAppMap.get(idSrv);
				if(ListUtil.isEmpty(scAptApplList)) continue;
				if(IScDictCodeConst.ID_SCSRVEXCLTP_TIMES_LIMIT.equals(scSrvExclDO.getId_scsrvexcltp())){
					// 校验次数互斥限制
					this.handleScAptExclTimes(type, resDTO, scAptApplList, measDocDO, nowTime, scSrvExclDO,medsrv);
				}else{
					// 校验日期互斥限制
					this.handleScAptExclDate(type, resDTO, scAptApplList, measDocDO, nowTime, scSrvExclDO,medsrv);
				}
			}
		}
	}
	
	/**
	 * 限制次数的互斥类型数据处理
	 * @param type
	 * @param resDTO
	 * @param aptApplDOList
	 * @param measDocDO
	 * @param nowTime
	 * @param scSrvExclDO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void handleScAptExclTimes(int type, MtResDTO resDTO, List<ScAptApplDO> aptApplDOList, MeasDocDO measDocDO,
			FDateTime nowTime, ScSrvExclDO scSrvExclDO,MedSrvDO medsrv)throws BizException{
		//FIXME 暂时按照一天内不得超出多少次来限制 次数限制默认单向
		FArrayList timesList = new FArrayList();
		int countMax = 0;
		for (ScAptApplDO scAptApplDO : aptApplDOList) {
			FMap dtMap = new FMap();
			FDate dt_b= scAptApplDO.getDt_b().getDate().getDateBefore(scSrvExclDO.getPeriod()-1).asBegin();
			FDate dt_e = dt_b.getDateAfter(scSrvExclDO.getPeriod()-1).asEnd();
			String pk = scSrvExclDO.getId_scsrvexcl();
			StringBuffer note = new StringBuffer();
			note.append(medsrv.getName()).append(" 与 ")
			.append(scAptApplDO.getName()).append("在限制时间内已达到最大次数限制(")
			.append(countMax).append("次).互斥规则:").append(scSrvExclDO.getNote());
			dtMap.put("msg", note.toString());
			dtMap.put("dt_b", dt_b.toString()); 
			dtMap.put("dt_e", dt_e.toString());
			dtMap.put("pk", pk);
			dtMap.put("times", scSrvExclDO.getTimes().toString());
			timesList.add(dtMap);
		}
		resDTO.getDays_excl_times().add(timesList);
		
	}
	/**
	 * 非限制次数的互斥类型数据处理
	 * @param type
	 * @param resDTO
	 * @param aptApplDOList
	 * @param measDocDO
	 * @param nowTime
	 * @param scSrvExclDO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void handleScAptExclDate(int type, MtResDTO resDTO, List<ScAptApplDO> aptApplDOList, MeasDocDO measDocDO,
			FDateTime nowTime, ScSrvExclDO scSrvExclDO,MedSrvDO medsrv) throws BizException {
		// 存放dt_b 和 dt_e
		for (ScAptApplDO scAptApplDO : aptApplDOList) {
			FMap dtMap = new FMap();
			FDateTime dt_b = scAptApplDO.getDt_b();
			FDateTime dt_e = scAptApplDO.getDt_e();
			//FDate d_b = scAptApplDO.getDt_b().getBeginDate();
			//FDate d_e = scAptApplDO.getDt_e().getBeginDate();
			int period = scSrvExclDO.getPeriod() -1;
			if (scSrvExclDO.getId_scsrvexcltp().equals(IScDictCodeConst.ID_SCSRVEXCLTP_PARALLEL_PROHIBIT) || scSrvExclDO.getId_scsrvexcltp().equals(IScDictCodeConst.ID_SCSRVEXCLTP_PARALLEL_HINT)) {
				type = 1;
			}
			if (type == 0) {
				
				if (measDocDO.getCode().equals("D")) {// 天按照自然天来处理
					dt_b = new FDateTime(dt_b.getDateTimeBefore(period).getBeginDate(), new FTime("00:00:00"));
				} else {
					long exclSeconds = this.getExclSeconds(scSrvExclDO, measDocDO, null);
					dt_b = dt_b.addSeconds(-(int) exclSeconds);
				}
					if (nowTime.getBeginDate().after(dt_b.getBeginDate()) && nowTime.getBeginDate().after(dt_e.getBeginDate())) {
						continue;
					}
					dtMap.put("dt_e", dt_e.toString());
					dtMap.put("dt_b", dt_b.toString());
			} else {
				if (measDocDO.getCode().equals("D")) {// 天按照自然天来处理
					
					//单项标识: true:结束时间不加天数
					if(scSrvExclDO.getFg_direct().booleanValue())// 反向查询时 会查询出单向标识为true的数据 需要进行处理
					{
						dt_e = new FDateTime(dt_e.getDateTimeAfter(period).getBeginDate(),new FTime("23:59:59"));
					}
					else
					{
						dt_b = new FDateTime( dt_b.getDateTimeBefore(scSrvExclDO.getPeriod() -1).getBeginDate(), new FTime("00:00:00"));
						dt_e = new FDateTime( dt_e.getDateTimeAfter(scSrvExclDO.getPeriod() -1).getBeginDate(), new FTime("23:59:59"));
					}
				} else {
					long exclSeconds = this.getExclSeconds(scSrvExclDO, measDocDO, null);
					if(scSrvExclDO.getFg_direct().booleanValue())// 反向查询时 会查询出单向标识为true的数据 需要进行处理
					{
						dt_e = dt_e.addSeconds((int) exclSeconds);
					}
					else
					{
					dt_b = dt_b.addSeconds(-(int) exclSeconds);
					dt_e = dt_e.addSeconds((int) exclSeconds);
					}
				}
					dtMap.put("dt_b", dt_b.toString());
					dtMap.put("dt_e", dt_e.toString());
				if (nowTime.getBeginDate().after(dt_b.getBeginDate()) && nowTime.getBeginDate().after(dt_e.getBeginDate())) {
					continue;
				}
			}
			String pk = scSrvExclDO.getId_scsrvexcl()+scSrvExclDO.getId_srv();
			dtMap.put("pk", pk);
			StringBuffer note = new StringBuffer();
			if(IScDictCodeConst.ID_SCSRVEXCLTP_REJECT_PROHIBIT.equals(scSrvExclDO.getId_scsrvexcltp())){
				note.append("患者已经预约了在[").append(scAptApplDO.getScres_name())
				.append("]于").append(scAptApplDO.getDt_b()).append("进行[")
				.append(scAptApplDO.getName()).append("]检查,不允许一起进行预约检查.互斥规则:")
				.append(scSrvExclDO.getNote());
				dtMap.put("msg", note.toString());
				resDTO.getDays_excl_must().add(dtMap);
			}
			if(IScDictCodeConst.ID_SCSRVEXCLTP_REJECT_HINT.equals(scSrvExclDO.getId_scsrvexcltp())){
				note.append("患者已经预约了在[").append(scAptApplDO.getScres_name())
				.append("]于").append(scAptApplDO.getDt_b()).append("进行[")
				.append(scAptApplDO.getName()).append("]检查,建议不一起进行预约检查.互斥规则:")
				.append(scSrvExclDO.getNote());
				dtMap.put("msg", note.toString());
				resDTO.getDays_excl_hint().add(dtMap);
			}
			if(IScDictCodeConst.ID_SCSRVEXCLTP_PARALLEL_PROHIBIT.equals(scSrvExclDO.getId_scsrvexcltp())){
				note.append("患者已经预约了在[").append(scAptApplDO.getScres_name())
				.append("]于").append(scAptApplDO.getDt_b()).append("进行[")
				.append(scAptApplDO.getName()).append("]检查,必须一起进行预约检查.互斥规则:")
				.append(scSrvExclDO.getNote());
				dtMap.put("msg", note.toString());
				dtMap.put("aptTime",scAptApplDO.getDt_b().getDate().toString());
				resDTO.getDays_together_must().add(dtMap);
			}
			if (IScDictCodeConst.ID_SCSRVEXCLTP_PARALLEL_HINT.equals(scSrvExclDO.getId_scsrvexcltp())) {
				note.append("患者已经预约了在[").append(scAptApplDO.getScres_name())
				.append("]于").append(scAptApplDO.getDt_b()).append("进行[")
				.append(scAptApplDO.getName()).append("]检查,建议一起进行预约检查.互斥规则:")
				.append(scSrvExclDO.getNote());
				dtMap.put("msg", note.toString());
				dtMap.put("aptTime",scAptApplDO.getDt_b().getDate().toString());
				resDTO.getDays_together_hint().add(dtMap);
			}
		}
	}
	/**
	 * 根据id_srv 将预约记录分组
	 * @author yzh
	 * @param aptApplDOList
	 * @param scAptAppMap
	 * @return
	 */
	private String handleAptApplList(List<ScAptApplDO> aptApplDOList,Map<String, List<ScAptApplDO>> scAptAppMap){
		StringBuffer sb = new StringBuffer();
		for (ScAptApplDO scAptApplDO : aptApplDOList) {
			String key = scAptApplDO.getId_srv();
			if(key == null) continue;
			if(!scAptAppMap.containsKey(key)){
				List<ScAptApplDO> scAptApplList = new ArrayList<ScAptApplDO>();
				scAptApplList.add(scAptApplDO);
				scAptAppMap.put(key, scAptApplList);
				sb.append(key).append(",");
			}else{
				scAptAppMap.get(key).add(scAptApplDO);
			}
		}
		return sb.toString().substring(0,sb.length()-1);
	}
	

	/**
	 * 根据服务排斥DO获取间隔时间的秒数
	 *
	 * @param exclDO
	 *            服务排斥DO
	 * @param docDO
	 *            单位DO
	 * @param aptDO
	 *            预约DO
	 * @return 时间间隔秒数
	 * @throws BizException
	 * @author zhengcm
	 */
	private long getExclSeconds(ScSrvExclDO exclDO, MeasDocDO docDO, ScAptDO aptDO) throws BizException {
		long multiple = 1;
		switch (docDO.getCode()) {
		case IScDictCodeConst.S:// 秒
			multiple = 1;
			break;
		case IScDictCodeConst.MIN:// 分
			multiple = 60;
			break;
		case IScDictCodeConst.HR:// 时
			multiple = 60 * 60;
			break;
		case IScDictCodeConst.D:// 天
			multiple = 60 * 60 * 24;
			break;
		default:
			multiple = 1;
			break;
		}
		return exclDO.getPeriod() * multiple;
	}

	/**
	 * 获取服务互斥计量单位
	 * 
	 * @author zhengcm
	 *
	 * @param measIdList
	 * @return
	 * @throws BizException
	 */
	private Map<String, MeasDocDO> getMeasMap(List<String> measIdList) throws BizException {
		if (ListUtil.isEmpty(measIdList)) {
			return null;
		}
		IMeasdocRService qryService = ServiceFinder.find(IMeasdocRService.class);
		MeasDocDO[] docDOs = qryService.find(ScSqlUtils.getInSqlByIds("id_measdoc", measIdList), null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(docDOs)) {
			return null;
		}
		Map<String, MeasDocDO> map = new HashMap<String, MeasDocDO>();
		for (MeasDocDO docDO : docDOs) {
			String key = docDO.getId_measdoc();
			if (!map.containsKey(key)) {
				map.put(key, docDO);
			}
		}
		return map;
	}
	
}
