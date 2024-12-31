package iih.bl.cg.s.bp.ip.ipoutpatprice;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.base.utils.FDoubleUtils;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.bp.GetBlIpOutPatPriDTOBP;
import iih.bl.cg.dto.backcg.d.BlBackCgBedDTO;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.cg.s.bp.ip.ipoutpatprice.qry.GetPriceBedQuanQry;
import iih.bl.cg.s.bp.ip.ipoutpatprice.qry.GetStIpSrvQuanQry;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.params.BlParams;
import iih.bl.pub.IBlExternalParamConst;
import iih.bl.st.dto.d.BlIpOutPatPriDTO;
import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.lang.ArrayUtils;
import org.apache.cxf.common.util.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 检索床位费(只统计主床)是否划价
 * @author LIM
 *
 */
public class GetCheckBedFeeBP {
	/**
	 * 检索床位费(只统计主床)是否划价
	 * @param id_ent 就诊id
	 * @param dt_end 出院时间
	 * @return
	 * @throws BizException 
	 */
	public BlIpOutPatPriDTO exec(String id_ent, FDateTime dt_end) throws BizException{
		//1.获取就诊信息
		PatiVisitDO enDO = ServiceFinder.find(IPativisitRService.class).findById(id_ent);
		NewbornDO bbDO = ServiceFinder.find(IEnOutQryService.class).getNewbornDO(id_ent);
		
		// 2.检索床位费(只统计主床)是否划价
		GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
		BlIpOutPatPriDTO blIpOutPatPriDTO= null;
		if(bbDO != null && !BlParams.BLCG0009().booleanValue()){
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_BEDFEE, FBoolean.TRUE, BlMsgUtils.GetCheckBedFeeMsg(FBoolean.TRUE));
			return blIpOutPatPriDTO;
		}
		//4.获取床位费
		GetPriceBedFeeBP bp= new GetPriceBedFeeBP();
		EnBedDO[] enBedDo =bp.exec(id_ent);
		//如果没有占用床位，则不再校验   by lim 2019-06-03
		if(ArrayUtil.isEmpty(enBedDo)){
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_BEDFEE, FBoolean.TRUE, BlMsgUtils.GetCheckBedFeeMsg(FBoolean.TRUE));
			return blIpOutPatPriDTO;	
		}
		//3.判断入院时间和出院时间是否同一天
		if(DateTimeUtils.isSameDay(enDO.getDt_acpt(), dt_end)){
			//如果最后划价时间大于出院时间 或者当天已经有床位费记账（出院当天召回，召回时在另一张床，就诊会产生一条最后划价时间和入院时间相同的数据）
//			FBoolean bchgBill=this.getExistCgByBed(id_ent, dt_end);
			FBoolean bchgBill=this.getExistTodayOutUnPriceBed(id_ent, dt_end);
//			if((enBedDo[0].getDt_chg_bill()!=null && enBedDo[0].getDt_chg_bill().compareTo(enBedDo[0].getDt_b())>0)||bchgBill.booleanValue()){
			if(bchgBill.booleanValue()){
				blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_BEDFEE, FBoolean.TRUE, BlMsgUtils.GetCheckBedFeeMsg(FBoolean.TRUE));			
			}else{
				blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_BEDFEE, FBoolean.FALSE, BlMsgUtils.GetCheckBedFeeMsg(FBoolean.FALSE));	
			}
			return blIpOutPatPriDTO;
		}

//		//4.获取床位费
//		GetPriceBedFeeBP bp= new GetPriceBedFeeBP();
//		EnBedDO[] enBedDo =bp.exec(id_ent);
		//4.1判断是否划价
		String message="";
		//Boolean fg_Price=this.getPrice_BedFee(enBedDo,dt_end);
		FBoolean fg_Price=this.getExistUnPriceBed(id_ent,dt_end);
		if(!fg_Price.booleanValue()){		
			message= BlMsgUtils.GetCheckBedFeeMsg(FBoolean.FALSE);		
		}
		//5.检索床位费数量核查
		message+=this.getBedQuan(id_ent);
		if(!StringUtils.isEmpty(message)){
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_BEDFEE, FBoolean.FALSE, message);
		}else{
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_BEDFEE, FBoolean.TRUE, BlMsgUtils.GetCheckBedFeeMsg(FBoolean.TRUE));	
		}	
		return blIpOutPatPriDTO;
	}
	
	/**
	 *  查询床位费 是否划价
	 * @param id_ent
	 * @param outDate
	 * @return
	 * @throws BizException
	 */
	private Boolean getPrice_BedFee(EnBedDO[] enBedDo,FDateTime dt_end) throws BizException {
		Boolean bPrice = Boolean.TRUE;
		if (! ArrayUtils.isEmpty(enBedDo)) {
			// 1.如果最后划价字段为空，则直接返回false，未划价
			if (enBedDo[0].getDt_chg_bill() != null) {
				if (enBedDo[0].getDt_e() != null) {
					// 出院（转床）日期与最后划价日期比较
					bPrice = DateTimeUtils.isSameDay(enBedDo[0].getDt_e(), enBedDo[0].getDt_chg_bill())|| enBedDo[0].getDt_chg_bill().compareTo(enBedDo[0].getDt_e())>=0;
				} else {
					// 预出院日期与最后划价日期比较
					if(DateTimeUtils.isSameDay(dt_end, enBedDo[0].getDt_chg_bill())|| enBedDo[0].getDt_chg_bill().compareTo(dt_end)>=0){
						bPrice=Boolean.TRUE;
					}else{
						bPrice = Boolean.FALSE;
					}
				}
			} else {
				bPrice = Boolean.FALSE;
			}
		}
		return bPrice;
	}

	/**
	 * 检索床位费数量核查
	 * @return
	 * @throws BizException 
	 */
	private String getBedQuan(String id_ent) throws BizException{
		String message="";
		//1.查询应收床位费
		BlCgIpDO[] blCgIpDOArr = (BlCgIpDO[]) AppFwUtil.getDORstWithDao(new GetPriceBedQuanQry(id_ent), BlCgIpDO.class);
		if(ArrayUtils.isEmpty(blCgIpDOArr)){
			Map<String,FDouble> srvMap = this.getStBedQuan(id_ent);
			for(BlCgIpDO blCgIpDO:blCgIpDOArr){
				if(srvMap.containsKey(blCgIpDO.getId_srv())){
					//应收数量和实收数量对比
					FDouble quan=srvMap.get(blCgIpDO.getId_srv());
					if(!FDoubleUtils.isEqualWithTwoFDouble(blCgIpDO.getQuan(), quan)){
						message+=BlMsgUtils.GetCheckBedQuanMsg(blCgIpDO.getName_srv(), blCgIpDO.getQuan(), quan);
					}		
				}else{
					//没有实收
					message+=BlMsgUtils.GetCheckBedQuanMsg(blCgIpDO.getName_srv(), blCgIpDO.getQuan(), new FDouble(0));
				}
			}
		}		
		return message;
	}

	/**
	 * 查询就诊实收服务数量
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	private Map<String,FDouble> getStBedQuan(String id_ent) throws BizException{
		Map<String,FDouble> srvMap = new HashMap<String,FDouble>();
		BlCgIpDO[] blCgIpDOArr = (BlCgIpDO[]) AppFwUtil.getDORstWithDao(new GetStIpSrvQuanQry(id_ent), BlCgIpDO.class);
		if(ArrayUtils.isEmpty(blCgIpDOArr)){
			for(BlCgIpDO blcgipDO:blCgIpDOArr){
				if(!srvMap.containsKey(blcgipDO.getId_srv())){
					srvMap.put(blcgipDO.getId_srv(), blcgipDO.getQuan());
				}
			}
		}
		return srvMap;
	}

	public FBoolean getExistUnPriceBed(String id_ent, FDateTime cgEndTime) throws BizException {
		FBoolean  bExist=FBoolean.TRUE;
		//获取床位最大记账日期
		FDateTime maxDtChg = this.getMaxDtChg(id_ent);
		if(maxDtChg != null && maxDtChg.compareTo(cgEndTime) >= 0)
			return bExist;
		
		//获取主床床位信息
		List<BlBackCgBedDTO> bedList = this.getUsedBed(id_ent, maxDtChg, cgEndTime);
		if(ListUtil.isEmpty(bedList))
			return bExist;
		//计算需记账的日期
		FDate[] cgDates = this.getNeedCgData(maxDtChg == null ? this.getDtb(id_ent) : maxDtChg, cgEndTime);		
		
		//计算需要收取的床位数据
		Map<String,BlBackCgBedDTO> bedMap = new HashMap<String,BlBackCgBedDTO>();
		for (FDate fDate : cgDates) {
			
			BlBackCgBedDTO mainBedDto = this.analysisMainBed(bedList, maxDtChg, fDate, cgEndTime);
			
			if(mainBedDto != null && !bedMap.containsKey(mainBedDto.getId_entbed())){
				bedMap.put(mainBedDto.getId_entbed(), mainBedDto);
			}
		}
		
		if(bedMap.size() != 0)
			bExist=FBoolean.FALSE;
		return bExist;
	}
	
	/**
	 * 分析当日入当日出床位费
	 * @param id_ent
	 * @param cgEndTime
	 * @return
	 * @throws BizException
	 */
	public FBoolean getExistTodayOutUnPriceBed(String id_ent, FDateTime cgEndTime) throws BizException{
		
		//获取床位信息
		List<BlBackCgBedDTO> bedList = this.getUsedBed(id_ent, null, cgEndTime);
		if(ListUtil.isEmpty(bedList))
			return FBoolean.TRUE;
		
		//主床包床分组处理
		List<BlBackCgBedDTO> mainBedList = new ArrayList<BlBackCgBedDTO>();
		List<BlBackCgBedDTO> subBedList = new ArrayList<BlBackCgBedDTO>();
		this.groupBed(bedList, mainBedList, subBedList);
		
		FDate fDate = cgEndTime.getBeginDate();
		
		//计算需要收取的床位数据
		Map<String,BlBackCgBedDTO> bedMap = new HashMap<String,BlBackCgBedDTO>();
		BlBackCgBedDTO mainBedDto = this.analysisMainBed(mainBedList, null, fDate, cgEndTime);
		List<BlBackCgBedDTO> sunBedDtos = this.analysisSubBed(subBedList, fDate, cgEndTime);
		
		if(mainBedDto != null && !bedMap.containsKey(mainBedDto.getId_entbed())&& (!StringUtil.isEmpty(mainBedDto.getId_bltpl())|| !StringUtil.isEmpty(mainBedDto.getId_bltpl_rent()))){
			bedMap.put(mainBedDto.getId_entbed(), mainBedDto);
		}
		
		if(sunBedDtos.size() > 0){
			for (BlBackCgBedDTO bedDto : sunBedDtos) {
				if(!bedMap.containsKey(bedDto.getId_entbed()) && (!StringUtil.isEmpty(bedDto.getId_bltpl())|| !StringUtil.isEmpty(bedDto.getId_bltpl_rent()))){
					bedMap.put(bedDto.getId_entbed(), bedDto);
				}
			}
		}
		return bedMap.size()> 0?FBoolean.FALSE:FBoolean.TRUE;
		
	}
	
	/**
	 * 分析当日需要记账的床位
	 * @param subBedList
	 * @param fDate
	 * @param cgEndTime
	 * @return
	 */
	private List<BlBackCgBedDTO> analysisSubBed(List<BlBackCgBedDTO> subBedList, FDate fDate, FDateTime cgEndTime) {
		
		FDateTime begin = DateTimeUtils.getDayBeginTime(fDate);
		FDateTime end = begin.equals(DateTimeUtils.getDayBeginTime(cgEndTime)) ? cgEndTime : DateTimeUtils.getDayEndTime(fDate);
		
		List<BlBackCgBedDTO> usedList = new ArrayList<BlBackCgBedDTO>();
		for (BlBackCgBedDTO bed : subBedList) {
			
			if(bed.getDt_b().compareTo(end) > 0 || bed.getDt_e().compareTo(begin) < 0)
				continue;
			
			if(bed.getDt_chg_bill() != null && DateTimeUtils.isSameDay(bed.getDt_chg_bill(), begin))
				continue;
			
			bed.setQuan(bed.getQuan() + 1);
			bed.setDt_chg_bill_new(end);
			
			usedList.add(bed);
		}
		
		return usedList;
	}
	
	/**
	 * 分组床数据
	 * @param bedList
	 * @param mainBedList
	 * @param subBedList
	 * @throws BizException
	 */
	private void groupBed(List<BlBackCgBedDTO> bedList, List<BlBackCgBedDTO> mainBedList, 
			List<BlBackCgBedDTO> subBedList) throws BizException {
		
		for (BlBackCgBedDTO bedDto : bedList) {	
			if(IEnDictCodeConst.SD_USETYPE_MAIN.equals(bedDto.getSd_usetype())){
				mainBedList.add(bedDto);
			}else{
				subBedList.add(bedDto);
			}
		}
	}
	
	/**
	 * 获取最大床位记账时间
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private FDateTime getMaxDtChg(String entId) throws BizException {
		
		DAFacade daf = new DAFacade();
		//取出床位最后记账时间
		String sql = "select max(dt_chg_bill) from en_ent_bed where id_ent = '" + entId + "' and dt_b <> dt_chg_bill";
		String maxDtChg = (String)daf.execQuery(sql, new ColumnHandler());
		
		if(!StringUtil.isEmpty(maxDtChg)){
			FDateTime maxDt = (FDateTime)FTypeManager.convert2FType(FType.FDateTime, maxDtChg);
			return maxDt;
		}

		return null;
	}
	/**
	 * 获取待记账主床位
	 * @param entId
	 * @param maxDtChg
	 * @param cgEndTime
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<BlBackCgBedDTO> getUsedBed(String entId, FDateTime maxDtChg, FDateTime cgEndTime) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();// 床位表全部字段
		sqlSb.append("select entbed.id_entbed,entbed.id_ent,entbed.id_dep_wrd,entbed.id_bed,");
		sqlSb.append("entbed.dt_b,nvl(entbed.dt_e,'2099-12-31 23:59:59') dt_e,entbed.sd_usetype,");
		sqlSb.append("case when entbed.dt_b = entbed.dt_chg_bill then null else entbed.dt_chg_bill end dt_chg_bill,");
		sqlSb.append("0 quan,");
		sqlSb.append("bed.id_bltpl,bed.sd_bedtp ");
		sqlSb.append("from en_ent_bed entbed ");
		sqlSb.append("inner join bd_bed bed ");
		sqlSb.append("on entbed.id_bed = bed.id_bed ");
		sqlSb.append("where entbed.id_ent = ? ");
		sqlSb.append("and bed.sd_bedtp <>  ? ");
		sqlSb.append(" and entbed.sd_usetype='0'");
		sqlSb.append(" and (bed.id_bltpl<>'~' or bed.id_bltpl_rent<>'~')");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addBlobParam(IBdResDictCodeConst.SD_BEDTYPE_VIRTUAL);

		if (maxDtChg != null) {
			sqlSb.append("and (entbed.dt_e is null or entbed.dt_e > ? ) ");
			param.addParam(maxDtChg);
		}

		sqlSb.append("and (entbed.dt_chg_bill is null or  entbed.dt_chg_bill < ? ) ");
		param.addParam(cgEndTime);
		//过滤下最后划价时间，防止转科患者再次查出新床信息 2019-11-25 by lim 
		sqlSb.append(" and exists (select * from en_ent_acc acc where acc.id_ent=entbed.id_ent and acc.dt_backcg< ?)");
		param.addParam(cgEndTime);
		List<BlBackCgBedDTO> bedList = (List<BlBackCgBedDTO>) new DAFacade()
				.execQuery(sqlSb.toString(), param, new BeanListHandler(
						BlBackCgBedDTO.class));
		return bedList;
	}
	
	/**
	 * 获取最小床位开始时间
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private FDateTime getDtb(String entId) throws BizException {

		//取出开始时间
		String sql = "select min(dt_b) from en_ent_bed where id_ent = '" + entId + "'";
		String maxDtChg = (String)new DAFacade().execQuery(sql, new ColumnHandler());
		FDateTime maxDt = (FDateTime)FTypeManager.convert2FType(FType.FDateTime, maxDtChg);
		return maxDt;
	}
	
	
	/**
	 * 获取需要记账的日期
	 * @param maxDtChg
	 * @param cgEndTime
	 * @return
	 * @throws BizException
	 */
	private FDate[] getNeedCgData(FDateTime maxDtChg, FDateTime cgEndTime) throws BizException {
		
		int day = DateTimeUtils.getNatDaysBetween(maxDtChg, cgEndTime);
		
		FDate[] dates = new FDate[day];
		
		FDate endDate = cgEndTime.getBeginDate();
		for (int i = day - 1; i >= 0; i--) {
			dates[i] = endDate.getDateBefore(day - i);
		}
		
		return dates;
	}
	
	/**
	 * 分析当日需要记账的床位
	 * @param mainBedList
	 * @param maxDtChg
	 * @param fDate
	 * @param cgEndTime
	 * @return
	 */
	private BlBackCgBedDTO analysisMainBed(List<BlBackCgBedDTO> mainBedList, FDateTime maxDtChg, FDate fDate, FDateTime cgEndTime) {
		
		// 按照终止时间倒序，返回第一条数据
		FDateTime begin = DateTimeUtils.getDayBeginTime(fDate);
		FDateTime end = begin.equals(DateTimeUtils.getDayBeginTime(cgEndTime)) ? cgEndTime : DateTimeUtils.getDayEndTime(fDate).addSeconds(1);

		// 最大划价日期和计算日期是同一日则返回
		if (maxDtChg != null && (maxDtChg.compareTo(begin) > 0 && DateTimeUtils.isSameDay(maxDtChg, begin)))
			return null;

		List<BlBackCgBedDTO> usedList = new ArrayList<BlBackCgBedDTO>();
		for (BlBackCgBedDTO bed : mainBedList) {

			// 不在收费区间
			if (bed.getDt_b().compareTo(end) > 0 || bed.getDt_e().compareTo(begin) < 0)
				continue;

			// 最大收费日期大于或等于当前计算日期
			if (bed.getDt_chg_bill() != null && (DateTimeUtils.isSameDay(bed.getDt_chg_bill().addSeconds(-1), begin) 
					|| bed.getDt_chg_bill().compareTo(begin) > 0)) {
				return null;
			}

			usedList.add(bed);
		}

		if (usedList.size() == 0)
			return null;

		Collections.sort(usedList, new Comparator<BlBackCgBedDTO>() {
			@Override
			public int compare(BlBackCgBedDTO o1, BlBackCgBedDTO o2) {
				return o2.getDt_e().compareTo(o1.getDt_e());
			}
		});

		BlBackCgBedDTO bed = usedList.get(0);
		bed.setQuan(bed.getQuan() + 1);
		bed.setDt_chg_bill_new(end);
		return bed;
	}

	/**
	 * 判断当天是否产生了床位费
	 * @param entId
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	private FBoolean getExistCgByBed(String entId,FDateTime dt_end) throws BizException {

		//取出开始时间
		String sql = "select id_ent from en_ent_bed where id_ent =? and  substr(dt_chg_bill,1,10)=? and dt_chg_bill>dt_b";
		SqlParam param= new SqlParam();
		param.addParam(entId);
		param.addParam(dt_end.getDate());
		
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sql,param,new ColumnListHandler());
		return !ListUtil.isEmpty(list)?FBoolean.TRUE:FBoolean.FALSE;
	}
}
