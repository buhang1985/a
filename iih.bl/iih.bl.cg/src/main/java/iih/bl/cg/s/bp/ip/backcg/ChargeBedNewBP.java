package iih.bl.cg.s.bp.ip.backcg;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.dto.d.BlTplPriceDTO;
import iih.bd.pp.dto.d.PriceRateDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPriCalcService;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.dto.backcg.d.BlBackCgBedDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.comm.IBlImplicitParamKeyConst;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.params.BlParams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 床位费记账新逻辑
 * @author ly 2018/09/04
 *
 */
public class ChargeBedNewBP extends BaseChargeBP {

	private boolean hasLoaded = false;// 是否已经加载
	private Map<String, BlTplPriceDTO> tplPriMap;// 费用模板价格map
	private Map<String, MedSrvDO> srvMap;// 服务map
	
	private FBoolean BLCG0041;
	public ChargeBedNewBP(boolean outDept){
		this.setOutDept(outDept);
	}
	
	/**
	 * 记账
	 * 
	 * @param patInfo 患者住院信息
	 * @param pripatAgg 患者价格分类
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 */
	@Override
	public void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException {
		
		//获取床位最大记账日期
		FDateTime maxDtChg = this.getMaxDtChg(patInfo.getId_ent());
		if(maxDtChg != null && maxDtChg.compareTo(cgEndTime) >= 0)
			return;
		
		//获取床位信息
		List<BlBackCgBedDTO> bedList = this.getUsedBed(patInfo.getId_ent(), maxDtChg, cgEndTime);
		if(ListUtil.isEmpty(bedList))
			return;
		
		//初始化数据
		this.initSysData();
		
		//主床包床分组处理
		List<BlBackCgBedDTO> mainBedList = new ArrayList<BlBackCgBedDTO>();
		List<BlBackCgBedDTO> subBedList = new ArrayList<BlBackCgBedDTO>();
		this.groupBed(bedList, mainBedList, subBedList);
		
		//计算需记账的日期
		FDate[] cgDates = this.getNeedCgData(maxDtChg == null ? this.getDtb(patInfo.getId_ent()) : maxDtChg, cgEndTime);		
		
		//计算需要收取的床位数据
		Map<String,BlBackCgBedDTO> bedMap = new HashMap<String,BlBackCgBedDTO>();
		for (FDate fDate : cgDates) {
			
			BlBackCgBedDTO mainBedDto = this.analysisMainBed(mainBedList, maxDtChg, fDate, cgEndTime);
			List<BlBackCgBedDTO> sunBedDtos = this.analysisSubBed(subBedList,fDate, cgEndTime);
			
			if(mainBedDto != null && !bedMap.containsKey(mainBedDto.getId_entbed())){
				bedMap.put(mainBedDto.getId_entbed(), mainBedDto);
			}
			
			if(sunBedDtos.size() > 0){
				for (BlBackCgBedDTO bedDto : sunBedDtos) {
					if(!bedMap.containsKey(bedDto.getId_entbed())){
						bedMap.put(bedDto.getId_entbed(), bedDto);
					}
				}
			}
		}
		
		if(bedMap.size() == 0)
			return;
		
		//记账
		for (BlBackCgBedDTO bed : bedMap.values()) {
			this.chargeBed(patInfo, pripatAgg, bed, cgEndTime);
		}
	}

	/**
	 * 当日出院记账
	 * @param patInfo
	 * @param pripatAgg
	 * @param cgEndTime
	 * @throws BizException
	 */
	@Override
	public void execTodayOut(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException{
		
		//初始化数据
		this.initSysData();
		
		//获取床位信息
		List<BlBackCgBedDTO> bedList = this.getUsedBed(patInfo.getId_ent(), null, cgEndTime);
		if(ListUtil.isEmpty(bedList))
			return;
		
		//主床包床分组处理
		List<BlBackCgBedDTO> mainBedList = new ArrayList<BlBackCgBedDTO>();
		List<BlBackCgBedDTO> subBedList = new ArrayList<BlBackCgBedDTO>();
		this.groupBed(bedList, mainBedList, subBedList);
		
		FDate fDate = cgEndTime.getBeginDate();
		
		//计算需要收取的床位数据
		Map<String,BlBackCgBedDTO> bedMap = new HashMap<String,BlBackCgBedDTO>();
		BlBackCgBedDTO mainBedDto = this.analysisMainBed(mainBedList, null, fDate, cgEndTime);
		List<BlBackCgBedDTO> sunBedDtos = this.analysisSubBed(subBedList, fDate, cgEndTime);
		
		if(mainBedDto != null && !bedMap.containsKey(mainBedDto.getId_entbed())){
			bedMap.put(mainBedDto.getId_entbed(), mainBedDto);
		}
		
		if(sunBedDtos.size() > 0){
			for (BlBackCgBedDTO bedDto : sunBedDtos) {
				if(!bedMap.containsKey(bedDto.getId_entbed())){
					bedMap.put(bedDto.getId_entbed(), bedDto);
				}
			}
		}
		
		if(bedMap.size() == 0)
			return;
		
		//记账
		for (BlBackCgBedDTO bed : bedMap.values()) {
			this.chargeBed(patInfo, pripatAgg, bed, cgEndTime);
		}
	}
	
	/**
	 * 记账
	 * @param patInfo
	 * @param pripatAgg
	 * @param bed
	 * @param cgEndTime
	 */
	private void chargeBed(IpCgPatDTO patInfo, PripatAggDO pripatAgg, BlBackCgBedDTO bed, FDateTime cgEndTime) throws BizException {
		
		BLTaskLogger.info(String.format("患者:%s 床位:%s 收费开始", patInfo.getName_pat(), bed.getName_bed()));
		
		BlTplPriceDTO tplPriceDTO = null;
		if(IEnDictCodeConst.SD_USETYPE_MAIN.equals(bed.getSd_usetype()) || StringUtil.isEmpty(bed.getId_bltpl_rent())){
			tplPriceDTO = tplPriMap.get(bed.getId_bltpl());
		}else{
			tplPriceDTO = tplPriMap.get(bed.getId_bltpl_rent());
		}
		
		if (tplPriceDTO == null || CollectionUtils.isEmpty(tplPriceDTO.getItm_list())) {
			BLTaskLogger.error(String.format("床位:%s,费用模板不存在",bed.getName_bed()));
			return;
		}
		
		// 计算费用模板服务折扣价
		this.calcPatPri(tplPriceDTO, pripatAgg);
		
		// 记账
		this.saveIpCgData(patInfo, bed, tplPriceDTO, cgEndTime);
		
		// 更新床位最后记账时间
		this.updateEnBedChgTime(bed);
		
		// 记录日志
		this.writeLog(bed, tplPriceDTO);
	}

	/**
	 * 初始化系统数据
	 * 
	 * @throws BizException
	 */
	private void initSysData() throws BizException {
		
		if(!this.hasLoaded){
			// 加载费用模板价格
			tplPriMap = this.loadTplPrice();
	
			// 加载所有服务信息
			List<String> srvIdList = new ArrayList<String>();
			for (BlTplPriceDTO tplPriDTO : tplPriMap.values()) {
				for (Object priRstObj : tplPriDTO.getItm_list()) {
					PriceResultDTO priRst = (PriceResultDTO) priRstObj;
					if (priRst == null)
						continue;
					srvIdList.add(priRst.getId_srv());
				}
			}
			srvMap = this.getSrvList(srvIdList.toArray(new String[0]));
			BLCG0041 = BlParams.BLCG0041();
		}
		
		this.hasLoaded = true;
	}
	
	/**
	 * 加载费用模板价格
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, BlTplPriceDTO> loadTplPrice() throws BizException {
		
		String conditon = "1=1";
		String[] fields = new String[] { "ID_BLTPL" };
		List<BdBlTplDO> tplList = (List<BdBlTplDO>) new DAFacade().findByCond(BdBlTplDO.class, conditon, fields);
		if (ListUtil.isEmpty(tplList)) {
			return new HashMap<String, BlTplPriceDTO>();
		}
		List<String> tplIdList = new ArrayList<String>();
		for (BdBlTplDO tplDO : tplList) {
			tplIdList.add(tplDO.getId_bltpl());
		}

		// 计算模板价格
		IBdPriCalcService priCalcSrvice = ServiceFinder.find(IBdPriCalcService.class);
		Map<String, BlTplPriceDTO> tplPriMap = priCalcSrvice.batchCalcBlTplPrice(tplIdList.toArray(new String[0]));
		return tplPriMap;
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
	 * 获取待记账床位
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
		sqlSb.append("bed.id_bltpl,bed.id_bltpl_rent,bed.sd_bedtp ");
		sqlSb.append("from en_ent_bed entbed ");
		sqlSb.append("inner join bd_bed bed ");
		sqlSb.append("on entbed.id_bed = bed.id_bed ");
		sqlSb.append("where entbed.id_ent = ? ");
		sqlSb.append("and bed.sd_bedtp <>  ? ");

		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(IBdResDictCodeConst.SD_BEDTYPE_VIRTUAL);

		if (maxDtChg != null) {
			sqlSb.append("and (entbed.dt_e is null or entbed.dt_e > ? ) ");
			param.addParam(maxDtChg);
		}

		sqlSb.append("and (entbed.dt_chg_bill is null or  entbed.dt_chg_bill < ? ) ");
		param.addParam(cgEndTime);

		List<BlBackCgBedDTO> bedList = (List<BlBackCgBedDTO>) new DAFacade()
				.execQuery(sqlSb.toString(), param, new BeanListHandler(
						BlBackCgBedDTO.class));
		return bedList;
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
			//未维护并且BLCG0041为false则不收费
			boolean isNotSafe = StringUtil.isEmpty(bed.getId_bltpl_rent()) || tplPriMap.get(bed.getId_bltpl_rent()) == null;
			if(isNotSafe && FBoolean.FALSE.equals(BLCG0041)){
				continue;
			}
			
			
			bed.setQuan(bed.getQuan() + 1);
			bed.setDt_chg_bill_new(end);
			
			usedList.add(bed);
		}
		
		return usedList;
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
	 * 计算费用模板折扣价
	 * 
	 * @param tplPriceDTO 费用模板计价DTO
	 * @param pripatAgg 患者价格分类Agg
	 * @throws BizException
	 */
	private void calcPatPri(BlTplPriceDTO tplPriceDTO, PripatAggDO pripatAgg) throws BizException {
		FDateTime currentTime = AppUtils.getServerDateTime();
		IBdPriCalcService calcService = ServiceFinder.find(IBdPriCalcService.class);
		for (Object priRstObj : tplPriceDTO.getItm_list()) {
			PriceResultDTO priRst = (PriceResultDTO) priRstObj;
			PriceRateDTO rateDto = calcService.calcPatPriRate(pripatAgg, priRst.getId_srv(), priRst.getSd_srvtp(), currentTime);
			priRst.setRate(rateDto.getRate());
			if(rateDto.getPrice_ratio() == null){
				priRst.setPrice_ratio(priRst.getPrice_std().multiply(priRst.getRate()));// 折扣价
			}else{
				priRst.setPrice_ratio(rateDto.getPrice_ratio());
			}
			
			tplPriceDTO.setPrice_ratio(tplPriceDTO.getPrice_ratio().add(priRst.getPrice_ratio()));
		}
	}
	
	/**
	 * 记账
	 * @param patInfo
	 * @param bed
	 * @param tplPriceDTO
	 * @param cgEndTime
	 * @throws BizException 
	 */
	private void saveIpCgData(IpCgPatDTO patInfo, BlBackCgBedDTO bed, BlTplPriceDTO tplPriceDTO, FDateTime cgEndTime) throws BizException {
		
		// 1、创建记账明细数据
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		for (Object priRstObj : tplPriceDTO.getItm_list()) {
			PriceResultDTO priRstDTO = (PriceResultDTO) priRstObj;
			MedSrvDO medSrvDO = srvMap.get(priRstDTO.getId_srv());
			FDouble quanCg = priRstDTO.getQuan() == null ? new FDouble(bed.getQuan()) : priRstDTO.getQuan().multiply(bed.getQuan());
			BlCgAccountDTO blCgDTO = this.createIpCgParam(patInfo, medSrvDO, priRstDTO, quanCg, null, null);
			blCgDTO.setAttrVal(IBlImplicitParamKeyConst.BL_ID_ENTBED, bed.getId_entbed());
			cgAccList.add(blCgDTO);
		}

		// 2、保存记账数据
		this.chargeToBill(cgAccList, cgEndTime);
	}
	
	/**
	 * 更新床位最后记账时间
	 * @param bed
	 * @throws BizException 
	 */
	private void updateEnBedChgTime(BlBackCgBedDTO bed) throws BizException {
		
		String sql = "UPDATE EN_ENT_BED SET DT_CHG_BILL=? WHERE ID_ENTBED=? ";
		SqlParam param = new SqlParam();
		param.addParam(bed.getDt_chg_bill_new());
		param.addParam(bed.getId_entbed());

		new DAFacade().execUpdate(sql, param);
	}
	
	/**
	 * 记录成功日志
	 * @param bed
	 * @param tplPriceDTO
	 * @throws BizException
	 */
	private void writeLog(BlBackCgBedDTO bed,BlTplPriceDTO tplPriceDTO) throws BizException {
		
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT + String.format("床号: %s 床位类型: %s 占用方式: %s", bed.getName_bed(),
				bed.getSd_bedtp(), bed.getSd_usetype()));
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT
				+ String.format("起=%s 止=%s 归整=1   天=%s 系数=1.0", this.getBeginTime(bed.getDt_b(), bed.getDt_chg_bill()), bed.getDt_chg_bill_new(), bed.getQuan()));
		
		for (Object priRstObj : tplPriceDTO.getItm_list()) {
			PriceResultDTO priRstDTO = (PriceResultDTO)priRstObj;
			MedSrvDO medSrvDO = srvMap.get(priRstDTO.getId_srv());
			FDouble quan = priRstDTO.getQuan().multiply(bed.getQuan());
			FDouble price = PrecisionUtils.formatPrice(priRstDTO.getPrice_ratio());// 单价
			FDouble totalPrice = PrecisionUtils.formatAmt(priRstDTO.getPrice_ratio().multiply(quan));// 总价
			BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT
					+ String.format("--%s 类别: %s 代码: %s 规格:/ 单位:日  数量:1.00", medSrvDO.getName(),medSrvDO.getSd_srvtp(),medSrvDO.getCode()));
			BLTaskLogger.info(IBackCgLogConst.THREE_LEBEL_INDENT
					+ String.format("价格: %s 总数量:%s 金额:%s 应收:%s", price, quan, totalPrice, totalPrice));
		}
	}
}
