package iih.bl.cg.s.bp.ip.backcg;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.dto.d.BlTplPriceDTO;
import iih.bd.pp.dto.d.PriceRateDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPriCalcService;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.d.BlCgEnBedDTO;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.comm.IBlImplicitParamKeyConst;
import iih.bl.comm.log.BLTaskLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 床位费记账
 * 
 * @author yankan
 * @since 2017-09-18
 * @version ly 2018/05/11 修改价格系数获取
 * 
 */
public class ChargeBedBP extends BaseChargeBP {
	private boolean hasLoaded = false;// 是否已经加载
	private Map<String, BlTplPriceDTO> tplPriMap;// 费用模板价格map
	private Map<String, MedSrvDO> srvMap;// 服务map

	/**
	 * 默认构造函数
	 */
	public ChargeBedBP() {}
	/**
	 * 构造函数
	 * @param isOutDept 是否出院
	 */
	public ChargeBedBP(Boolean isOutDept) {
		this.setOutDept(isOutDept);
	}
	/**
	 * 记账
	 * 
	 * @param patInfo 患者住院信息
	 * @param pripatAgg 患者价格分类
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 */
	public void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg, FDateTime cgEndTime) throws BizException {
		// 1、获取床位信息
		List<BlCgEnBedDTO> bedList = this.getUsedBedList(patInfo.getId_ent(), cgEndTime);

		// 2、过滤出需计费床位
		List<BlCgEnBedDTO> cgBedList = this.getNeedCgBedList(patInfo, bedList, cgEndTime);
		if (ListUtil.isEmpty(cgBedList)) {
			return;
		}

		// 3、加载系统数据
		this.initSysData();

		// 4、床位费记账，每个床位对应一条记账数据
		this.writeStartLog();
		for (BlCgEnBedDTO bedDTO : cgBedList) {
			this.chargeBed(patInfo, pripatAgg, bedDTO, cgEndTime);
		}
	}

	/**
	 * 获取使用的床位列表
	 * 
	 * @param entId 就诊ID
	 * @param cgEndTime 记账截止时间
	 * @return 床位列表
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<BlCgEnBedDTO> getUsedBedList(String entId, FDateTime cgEndTime) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ENBED.ID_ENT,ENBED.ID_ENTBED,");
		sqlBuilder.append("DT_B,DT_E,SD_USETYPE,DT_CHG_BILL,");
		sqlBuilder.append("ENBED.ID_BED,BED.CODE AS CODE_BED,BED.NAME,");
		sqlBuilder.append("BED.ID_BLTPL,BED.SD_BEDTP ");
		sqlBuilder.append(" FROM EN_ENT_BED ENBED ");
		sqlBuilder.append(" INNER JOIN BD_BED BED ON ENBED.ID_BED=BED.ID_BED ");
		sqlBuilder.append(" WHERE ID_ENT=? ");
		sqlBuilder.append(" AND (DT_CHG_BILL IS NULL OR DT_CHG_BILL<?) ");
		sqlBuilder.append(" AND BED.SD_BEDTP<>'");
		sqlBuilder.append(IBdResDictCodeConst.SD_BEDTYPE_VIRTUAL);
		sqlBuilder.append("'");
		sqlBuilder.append(" ORDER BY DT_B DESC ");

		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(cgEndTime);

		List<BlCgEnBedDTO> bedList = (List<BlCgEnBedDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(BlCgEnBedDTO.class));
		return bedList;
	}

	/**
	 * 获取 1、过滤结束使用且已记账 2、过滤今天已经记账 3、包床的单收，包一次收一次 4、如果是换床，一天只收一份床位费
	 * 
	 * @param patInfo
	 * @param bedList
	 * @param cgEndTime
	 * @return
	 */
	private List<BlCgEnBedDTO> getNeedCgBedList(IpCgPatDTO patInfo, List<BlCgEnBedDTO> bedList, FDateTime cgEndTime) {
		List<BlCgEnBedDTO> cgBedList = new ArrayList<BlCgEnBedDTO>();
		if (ListUtil.isEmpty(bedList)) {
			return cgBedList;
		}
		//判定主床今天已计费
		boolean isMajBedTodayCged = this.checkMajBedTodayCged(bedList,cgEndTime);
		// 2017-10-18 跟李永伟、王琪沟通确认，按计费点使用的医嘱为准，之前跨天的需计费，中间开立停掉的不参与计费，如若需要可进行补费
		// 主床和包床同样处理		
		for (BlCgEnBedDTO bedDTO : bedList) {
			if(isMajBedTodayCged && IEnDictCodeConst.SD_USETYPE_MAIN.equals(bedDTO.getSd_usetype())){
				continue;//主床已经计费，则过滤主床，不再重复计费
			}
			if (bedDTO.getDt_e() == null || bedDTO.getDt_e().equals(cgEndTime)) {
				cgBedList.add(bedDTO);// 当前依然在使用,或结束时间等于记费点，如出院转科
			} /*else if (!DateTimeUtils.isSameDay(bedDTO.getDt_b(), bedDTO.getDt_e())) {
				cgBedList.add(bedDTO);// 不再使用，但是跨天需参与计费
			}*/
		}

		return cgBedList;
	}
	/**
	 * 判定主床今天已计费
	 * @param bedList　床位集合
	 * @param cgEndTime　记账时间
	 * @return boolean
	 */
	private boolean checkMajBedTodayCged(List<BlCgEnBedDTO> bedList,FDateTime cgEndTime){
		if(ListUtil.isEmpty(bedList)){
			return false;
		}
		for(BlCgEnBedDTO bedDTO : bedList){
			if(IEnDictCodeConst.SD_USETYPE_MAIN.equals(bedDTO.getSd_usetype())){
				if(bedDTO.getDt_chg_bill()!=null && DateTimeUtils.isSameDay(bedDTO.getDt_chg_bill(),cgEndTime)
						&& bedDTO.getDt_b()!=null && bedDTO.getDt_chg_bill().compareTo(bedDTO.getDt_b())>0){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 初始化系统数据
	 * 
	 * @throws BizException
	 */
	private void initSysData() throws BizException {
		if (!hasLoaded) {
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
			hasLoaded = true;
		}
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
	 * 加载费用模板价格
	 * 
	 * @throws BizException
	 */
	private Map<String, BlTplPriceDTO> loadTplPrice() throws BizException {
		// 获取预处理的费用模板ID
		List<String> tplIdList = this.getBlTplIdList();
		if (ListUtil.isEmpty(tplIdList)) {
			return null;
		}

		// 计算模板价格
		IBdPriCalcService priCalcSrvice = ServiceFinder.find(IBdPriCalcService.class);
		Map<String, BlTplPriceDTO> tplPriMap = priCalcSrvice.batchCalcBlTplPrice(tplIdList.toArray(new String[0]));
		return tplPriMap;
	}

	/**
	 * 获取预处理的费用模板ID集合
	 * 
	 * 当前是全院的费用模板
	 * 
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<String> getBlTplIdList() throws BizException {
		String conditon = "1=1";
		String[] fields = new String[] { "ID_BLTPL" };
		List<BdBlTplDO> tplList = (List<BdBlTplDO>) new DAFacade().findByCond(BdBlTplDO.class, conditon, fields);
		if (ListUtil.isEmpty(tplList)) {
			return null;
		}
		List<String> tplIdList = new ArrayList<String>();
		for (BdBlTplDO tplDO : tplList) {
			tplIdList.add(tplDO.getId_bltpl());
		}
		return tplIdList;
	}

	/**
	 * 记录床位费含事务
	 * 
	 * @param patInfo
	 * @param pripatAgg
	 * @param bedDTO
	 * @param cgEndTime
	 */
	@SuppressWarnings("unused")
	private void chargeBedWithTran(final IpCgPatDTO patInfo, final PripatAggDO pripatAgg, final BlCgEnBedDTO bedDTO,
			final FDateTime cgEndTime) {
		TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus status) {
				try {
					chargeBed(patInfo, pripatAgg, bedDTO, cgEndTime);
				} catch (BizException e) {
					e.printStackTrace();
				}
				return null;
			}
		});
	}

	/**
	 * 记录床位费
	 * 
	 * @param patInfo
	 * @param pripatAgg
	 * @param bedDTO
	 * @param cgEndTime
	 */
	private void chargeBed(IpCgPatDTO patInfo, PripatAggDO pripatAgg, BlCgEnBedDTO bedDTO, FDateTime cgEndTime)
			throws BizException {
		BlTplPriceDTO tplPriceDTO = tplPriMap.get(bedDTO.getId_bltpl());
		if (tplPriceDTO == null || CollectionUtils.isEmpty(tplPriceDTO.getItm_list())) {
			BLTaskLogger.error(String.format("床位:%s,费用模板不存在",bedDTO.getName()));
			return;
		}
		// 4.1、计算数量
		FDouble quan = this.calcQuanByDay(bedDTO.getDt_b(),bedDTO.getDt_b(),bedDTO.getDt_e(),bedDTO.getDt_chg_bill(),cgEndTime);
		if (quan == null || quan.doubleValue() <= 0) {
			return;
		}

		// 4.2、计算费用模板服务折扣价
		this.calcPatPri(tplPriceDTO, pripatAgg);

		// 4.3、记账 （新接口，按明细补费）
		this.saveIpCgData(patInfo, bedDTO, tplPriceDTO, quan, cgEndTime);

		// 4.4 更新床位最后记账时间
		this.updateEnBedChgTime(bedDTO.getId_entbed(), cgEndTime);

		// 4.5、记录日志
		this.writeBedLog(bedDTO, tplPriceDTO, cgEndTime, quan);
	}

	/**
	 * 保存住院记账数据
	 * 
	 * @param patInfo 住院患者信息
	 * @param bedDTO 床位信息
	 * @param tplPriceDTO 费用模板DTO，含项目明细
	 * @throws BizException
	 */
	private void saveIpCgData(IpCgPatDTO patInfo, BlCgEnBedDTO bedDTO, BlTplPriceDTO tplPriceDTO, FDouble quan,
			FDateTime cgEndTime) throws BizException {
		if (quan == null || quan.doubleValue() <= 0) {
			return;
		}
		// 1、创建记账明细数据
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		for (Object priRstObj : tplPriceDTO.getItm_list()) {
			PriceResultDTO priRstDTO = (PriceResultDTO) priRstObj;
			MedSrvDO medSrvDO = srvMap.get(priRstDTO.getId_srv());
			FDouble quanCg = priRstDTO.getQuan() == null ? quan : quan.multiply(priRstDTO.getQuan());
			BlCgAccountDTO blCgDTO = this.createIpCgParam(patInfo, medSrvDO, priRstDTO, quanCg, null, null);
			//补充就诊床位id ly 2018/08/23
			blCgDTO.setAttrVal(IBlImplicitParamKeyConst.BL_ID_ENTBED, bedDTO.getId_entbed());
			cgAccList.add(blCgDTO);
		}

		// 2、保存记账数据
		this.chargeToBill(cgAccList, cgEndTime);
	}
	/**
	 * 更新就诊床位的最后记账时间
	 * 
	 * @param entBedId 就诊床位ID
	 * @param cgEndTime 记账时间
	 * @throws BizException
	 */
	private void updateEnBedChgTime(String entBedId, FDateTime cgEndTime) throws BizException {
		String sql = "UPDATE EN_ENT_BED SET DT_CHG_BILL=? WHERE ID_ENTBED=? ";
		SqlParam param = new SqlParam();
		param.addParam(cgEndTime);
		param.addParam(entBedId);

		new DAFacade().execUpdate(sql, param);
	}

	/**
	 * 写开始日志
	 */
	private void writeStartLog() {
		BLTaskLogger.info(IBackCgLogConst.ONE_LEBEL_INDENT + "**床位费 ");
	}

	/**
	 * 记录日志
	 * 
	 * @param bedDTO
	 * @param tplPriDTO
	 * @param cgEndTime
	 * @param quan
	 */
	private void writeBedLog(BlCgEnBedDTO bedDTO, BlTplPriceDTO tplPriDTO, FDateTime cgEndTime, FDouble quan) {
		FDateTime beginTime = this.getBeginTime(bedDTO.getDt_b(), bedDTO.getDt_chg_bill());
		FDateTime endTime = this.getEndTime(bedDTO.getDt_e(), cgEndTime);// 床位记账截止时间
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT + String.format("床号: %s 床位类型: %s 占用方式: %s", bedDTO.getCode_bed(),
				bedDTO.getSd_bedtp(), bedDTO.getSd_usetype()));
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT
				+ String.format("起=%s 止=%s 归整=1   天=%s 系数=1.0", beginTime, endTime, quan));
		for (Object priRstObj : tplPriDTO.getItm_list()) {
			PriceResultDTO priRstDTO = (PriceResultDTO)priRstObj;
			MedSrvDO medSrvDO = srvMap.get(priRstDTO.getId_srv());
			this.writeSrvItmLog(medSrvDO, priRstDTO, quan);
		}
	}
	/**
	 * 记录费用项目日志
	 * 
	 * @param medSrvDO
	 * @param priRst
	 * @param quan
	 */
	private void writeSrvItmLog(MedSrvDO medSrvDO, PriceResultDTO priRstDTO, FDouble quan) {
		if(medSrvDO==null || priRstDTO==null){
			return;
		}
		quan = PrecisionUtils.formatQuan(quan);
		FDouble price = PrecisionUtils.formatPrice(priRstDTO.getPrice_ratio());// 单价
		FDouble totalPrice = PrecisionUtils.formatAmt(priRstDTO.getPrice_ratio().multiply(quan));// 总价
		BLTaskLogger.info(IBackCgLogConst.TWO_LEBEL_INDENT
				+ String.format("--%s 类别: %s 代码: %s 规格:/ 单位:日  数量:1.00", medSrvDO.getName(),medSrvDO.getSd_srvtp(),medSrvDO.getCode()));
		BLTaskLogger.info(IBackCgLogConst.THREE_LEBEL_INDENT
				+ String.format("价格: %s 总数量:%s 金额:%s 应收:%s", price, quan, totalPrice, totalPrice));
	}
}
