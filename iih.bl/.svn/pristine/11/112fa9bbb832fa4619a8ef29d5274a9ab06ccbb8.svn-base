package iih.bl.cg.s.bp.ip.ipoutpatprice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import iih.bd.pp.srvspecround.i.ISrvspecroundRService;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.bp.GetBlIpOutPatPriDTOBP;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.cg.s.bp.ip.backcg.BaseChargeBP;
import iih.bl.cg.s.bp.ip.backcg.SrvRoundResult;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.params.BlParams;
import iih.bl.pub.IBlExternalParamConst;
import iih.bl.st.dto.d.BlIpOutPatPriDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.ICiOrdQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 持续性医嘱是否已划价
 * @author LIM
 *
 */
public class GetCheckPrnOrderBP extends BaseChargeBP {
	
	private Map<String, MedSrvDO> medSrvMap = null;// 医疗服务
	private Map<String, SrvSpecRoundDO> medSrvSpecRoundMap = null;// 项目特殊取整方式
//	private Map<String, PriceResultDTO> priRstMap = null;// 计价结果
	private List<String> prnFreqIdList = null;// 持续频次集合
	private Map<String, MeasDocDO> timeUnitMap = null;// 时间单位map
	
	private String outUnCgSrvStr = null;//不计出的服务
	
	public BlIpOutPatPriDTO exec(String id_ent, FDateTime dt_end) throws BizException {
//		FBoolean bPrice=FBoolean.TRUE;
		
		BlIpOutPatPriDTO blIpOutPatPriDTO= new BlIpOutPatPriDTO();
		String message="";
		// 1、记载持续医嘱频次   如果不存在持续医嘱 直接返回true
		if (ListUtil.isEmpty(prnFreqIdList)) {
			prnFreqIdList = this.getPrnFreqIdList();
			if (ListUtil.isEmpty(prnFreqIdList)) {
//				return bPrice;
				message=BlMsgUtils.GetCheckPrnOrderSucessMsg();
				blIpOutPatPriDTO=this.getBlIpOutPatPriDTO(FBoolean.TRUE, message);
				return blIpOutPatPriDTO;
			}
		}
		// 2、获取持续医嘱集合
		CiorderAggDO[] ciOrdAggs = this.getPrnOrList(id_ent, prnFreqIdList);
		if (ArrayUtil.isEmpty(ciOrdAggs)) {
//			return bPrice;
			message=BlMsgUtils.GetCheckPrnOrderSucessMsg();
			blIpOutPatPriDTO=this.getBlIpOutPatPriDTO(FBoolean.TRUE, message);
			return blIpOutPatPriDTO;
		}
		// 3、加载系统数据
		this.initSysData();
		//4.判断是否存在未划价的信息
		for (final CiorderAggDO orAggDO : ciOrdAggs) {
			message +=this.getExistPrice( orAggDO, dt_end);
//			bPrice=this.getExistPrice( orAggDO, dt_end);
//			if(FBoolean.FALSE.equals(bPrice)){
//				break;
//			}
		}
		if(!StringUtils.isEmpty(message)){
			blIpOutPatPriDTO=this.getBlIpOutPatPriDTO(FBoolean.FALSE, message);
		}else{
			message=BlMsgUtils.GetCheckPrnOrderSucessMsg();
			blIpOutPatPriDTO=this.getBlIpOutPatPriDTO(FBoolean.TRUE, message);
		}
		return blIpOutPatPriDTO;
	}
	
	/**
	 * 组织返回数据DTO
	 * @param fg_Price
	 * @param message
	 * @return
	 */
	private BlIpOutPatPriDTO getBlIpOutPatPriDTO(FBoolean fg_Price,String message){		
		GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
		BlIpOutPatPriDTO blIpOutPatPriDTO=null;
		blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_ORDERFEE, fg_Price, message);
		return blIpOutPatPriDTO;
	}

	/**
	 * 判断是否存在未划价的信息
	 * @param ciOrdAggs
	 * @return
	 * @throws BizException 
	 */
	private String getExistPrice(CiorderAggDO ciOrdAggs, FDateTime dt_end) throws BizException{
		FBoolean bPrice=FBoolean.TRUE;
		String message ="";
		FDateTime dt_last_cg = dt_end;
		CiOrderDO ciOrdDO = ciOrdAggs.getParentDO();
		//长期医嘱    //如果结束日期 ciOrdDO.getDt_end().equals(new FDateTime("2099-01-01 00:00:00"))
		if(ciOrdDO.getDt_end()==null ){
			bPrice=FBoolean.FALSE;
			message=BlMsgUtils.GetCheckPrnOrderUnPriceMsg(ciOrdDO.getName_or());
		}else{
			
			if(ciOrdDO.getDt_effe().compareTo(ciOrdDO.getDt_end()) == 0){
				//持续性医嘱，生效时间和结束时间相同时，不用划价
				return message;
			}
			
			for (OrdSrvDO ordSrvDO : ciOrdAggs.getOrdSrvDO()) {
				if (!this.validateOrdSrv(ciOrdDO, ordSrvDO)) {
					continue;
				}
				SrvSpecRoundDO specDO = medSrvSpecRoundMap.get(ordSrvDO.getId_srv());
				
				if(!StringUtil.isEmpty(this.outUnCgSrvStr) && 
						this.outUnCgSrvStr.contains(ordSrvDO.getId_srv())){
					
					if(ordSrvDO.getDt_last_cg() != null && DateTimeUtils.isSameDay(ordSrvDO.getDt_last_cg(), dt_end)){
						continue;
					}
				}
				
				if(specDO!=null){
					// 计算数量
					SrvRoundResult roundRst = this.calcQuan(ciOrdDO, ordSrvDO, dt_end, dt_last_cg);
					//dt_last_cg = roundRst.getLastCgTime();// 最后记账时间取调整后的时间
					FDouble quan = roundRst.getQuan();
					if (quan == null || quan.doubleValue() <= 0) {
						continue;
					}
//					//对比计算后的划价日期与最近记账日期对比
//					if(!dt_last_cg.equals(ordSrvDO.getDt_last_cg())){
//						bPrice=FBoolean.FALSE;
//					}
					
					//最小量纲校验
					if (ordSrvDO.getDt_last_cg() == null || ciOrdDO.getDt_end().compareTo(ordSrvDO.getDt_last_cg()) > 0) {
						bPrice = FBoolean.FALSE;
						if(ordSrvDO.getDt_last_cg() == null){
							message+=BlMsgUtils.GetCheckPrnOrderUnPriceMsg(ciOrdDO.getName_or());
						}else{
							message+=this.getMessage(ciOrdDO,ordSrvDO);
						}
					}else{
						//判断最小量纲
						MeasDocDO timeUnitDO = timeUnitMap.get(ordSrvDO.getId_medu());
						int minRoundSeconds = timeUnitDO.getScalefactor().div(1000L).div(specDO.getRound_denominator()).intValue();
						int secs = FDateTime.getSecondsBetween(ciOrdDO.getDt_end(), ordSrvDO.getDt_last_cg());
						
						if(secs > minRoundSeconds){
							bPrice=FBoolean.FALSE;
							message+=this.getMessage(ciOrdDO,ordSrvDO);
						}
					}
				}else{
					//判断医嘱结束日期与最后划价日期是否相等
					if(!DateTimeUtils.isSameDay(ciOrdDO.getDt_end(), ordSrvDO.getDt_last_cg())){
						bPrice=FBoolean.FALSE;
						message+=this.getMessage(ciOrdDO,ordSrvDO);
					}
				}
			}
		}
		return message;
	}
	
	/**
	 *获取返回信息
	 * @param ciOrdDO
	 * @return
	 */
	private String getMessage(CiOrderDO ciOrdDO,OrdSrvDO ordSrvDO){
		String message="";
		if(ciOrdDO.getDt_end().compareTo(new FDateTime("2099-01-01 00:00:00"))>=0){
			message+=BlMsgUtils.GetCheckPrnOrderUnPriceMsg(ciOrdDO.getName_or());
		}else{
			message+=BlMsgUtils.GetCheckPrnOrderMsg(ciOrdDO.getName_or(), ordSrvDO.getDt_last_cg(), ciOrdDO.getDt_end());
		}
		return message;
	}
	
	/**
	 * 初始化
	 * 
	 * @throws BizException
	 */
	public void initSysData() throws BizException {
			// 1、加载时间单位
			timeUnitMap = this.getTimeUnitMap();

			// 2、获取所有的持续医嘱服务，不过当前其他服务在医嘱开立时都可修改为持续医嘱
			medSrvMap = this.getAllPrnSrvList();
			// 5、获取所有的项目特殊取整方式
			medSrvSpecRoundMap = this.getAllPrnSrvSpecRoundList();
			
			this.outUnCgSrvStr = BlParams.BLCG0022();
	}

	
	/**
	 * 获取持续频次ID集合
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<String> getPrnFreqIdList() throws BizException {
		String[] selectedFields = { FreqDefDO.ID_FREQ };
		@SuppressWarnings("unchecked")
		List<FreqDefDO> freqList = (List<FreqDefDO>) new DAFacade().findByAttrValString(FreqDefDO.class,
				FreqDefDO.ID_FREQUNITCT, IBdSrvDictCodeConst.ID_FREQNUNITCT_ALWAYS, selectedFields);
		if (ListUtil.isEmpty(freqList)) {
			return null;
		}

		List<String> freqIdList = new ArrayList<String>();
		for (FreqDefDO freqDO : freqList) {
			freqIdList.add(freqDO.getId_freq());
		}
		return freqIdList;
	}
	/**
	 * 获取持续医嘱集合
	 * 
	 * @param patInfo 就诊信息
	 * @param prnFreqIdList 持续频次ID集合
	 * @return
	 */
	private CiorderAggDO[] getPrnOrList(String id_ent,List<String> prnFreqIdList)throws BizException {
		StringBuffer sqlBuilder = new StringBuffer();
		sqlBuilder.append(SqlUtils.getInSqlByIds(" CI_ORDER.ID_FREQ", prnFreqIdList));// 持续医嘱
		sqlBuilder.append(" AND CI_ORDER.SD_SRVTP NOT LIKE '0601%' ");// 非护理
		sqlBuilder.append(" AND CI_ORDER.ID_EN = '").append(id_ent).append("'");
		sqlBuilder.append(" AND CI_OR_SRV.FG_BL='Y' AND CI_ORDER.FG_CHK='Y'");
		sqlBuilder.append(" AND CI_ORDER.FG_CANC='N'");// 非作废医嘱

		ICiOrdQryService ciOrRService = ServiceFinder.find(ICiOrdQryService.class);
		CiorderAggDO[] ciOrAggDOArr = ciOrRService.getBlFeeCiOrderSrvDto(sqlBuilder.toString(),
				this.getCiOrderAggConlumList());
		if (ArrayUtil.isEmpty(ciOrAggDOArr)) {
			return null;
		}
		return ciOrAggDOArr;
	}
	

	/**
	 * 计算数量
	 * 
	 * @param ciOrdDO
	 * @param ordSrvDO
	 * @param chargeTime
	 * @param dt_last_cg
	 * @return
	 */
	private SrvRoundResult calcQuan(CiOrderDO ciOrdDO, OrdSrvDO ordSrvDO, FDateTime chargeTime, FDateTime dt_last_cg) throws BizException {
		FDouble quan = FDouble.ZERO_DBL;
		// 计算毫秒数
		FDouble timeSpanMinSecs = this.calcQuanByMinSec(ciOrdDO, ordSrvDO, chargeTime);
		if (timeSpanMinSecs.doubleValue() > 0) {
			// 计算数量,换算为单位服务的数量,需要判断是不是特殊的取整方式
			MedSrvDO medSrvDO = medSrvMap.get(ordSrvDO.getId_srv());
			MeasDocDO timeUnitDO = timeUnitMap.get(medSrvDO.getId_unit_med());
			quan = this.convertByUnit(timeUnitDO, timeSpanMinSecs);// 单位转换			
			SrvSpecRoundDO srvSpecRoundDO = medSrvSpecRoundMap.get(medSrvDO.getId_srv());
			
			// 取整后续调整服务的最后记账时间
			FDateTime lastCgTime = this.getBeginTime(ciOrdDO.getDt_effe(), ordSrvDO.getDt_last_cg());
			
			if (srvSpecRoundDO != null) {
				quan = this.calcSpecRoundQuan(quan, srvSpecRoundDO);// 采用特殊的取整方式
				dt_last_cg = this.adjustDtAfterRound(timeUnitDO, quan, lastCgTime);
			} else {  
				
				//ly 2018/08/04  不取整
				//quan = new FDouble(Math.ceil(quan.doubleValue()));// 默认向上取整
				dt_last_cg = lastCgTime.addSeconds(timeSpanMinSecs.div(1000).intValue());
			}
		}
		SrvRoundResult roundRst = new SrvRoundResult();
		roundRst.setQuan(quan);
		roundRst.setLastCgTime(dt_last_cg);
		return roundRst;
	}
	
	/**
	 * 获得属于时间的单位
	 * 
	 * @return 单位map，【key:单位ID,value: 单位DO】
	 * @throws BizException
	 */
	public Map<String, MeasDocDO> getTimeUnitMap() throws BizException {
		Map<String, MeasDocDO> measDocDOMap = new HashMap<String, MeasDocDO>();
		String whereStr = "SD_OPPDIMEN=?";
		SqlParam param = new SqlParam();
		param.addParam(ISysDictCodeConst.SD_OPPDIMEN_T);// 时间类型
		List<MeasDocDO> measDocDOLst = (List<MeasDocDO>) new DAFacade().findByCond(MeasDocDO.class, whereStr, param);
		if (!ListUtil.isEmpty(measDocDOLst)) {
			for (MeasDocDO measDocDO : measDocDOLst) {
				measDocDOMap.put(measDocDO.getId_measdoc(), measDocDO);
			}
		}
		return measDocDOMap;
	}
	
	/**
	 * 获取所有的持续服务
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedSrvDO> getAllPrnSrvList() throws BizException {
		String whereStr = " SD_SRVTP NOT LIKE '0601%' ";// 非护理医嘱
		whereStr += " AND " + SqlUtils.getInSqlByIds(MedSrvDO.ID_UNIT_MED, timeUnitMap.keySet().toArray(new String[0]));
		return this.getSrvListByCond(whereStr);
	}	
	

	/**
	 * 获取所有服务特殊取整方式
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, SrvSpecRoundDO> getAllPrnSrvSpecRoundList() throws BizException {
		ISrvspecroundRService iSrvspecroundRService = ServiceFinder.find(ISrvspecroundRService.class);
		SrvSpecRoundDO[] srvSpecRoundDO_arr = iSrvspecroundRService.find("1=1", "", FBoolean.FALSE);
		Map<String, SrvSpecRoundDO> srvSpecRoundMap = new HashMap<String, SrvSpecRoundDO>();
		if (!ArrayUtil.isEmpty(srvSpecRoundDO_arr)) {
			for (SrvSpecRoundDO srvSpecRoundDO : srvSpecRoundDO_arr) {
				srvSpecRoundMap.put(srvSpecRoundDO.getId_srv(), srvSpecRoundDO);
			}
		}
		return srvSpecRoundMap;
	}

	/**
	 * 验证医嘱服务 验证持续服务、单位
	 * 
	 * @param ordSrvDO
	 * @return
	 */
	private Boolean validateOrdSrv(CiOrderDO ciOrdDO, OrdSrvDO ordSrvDO) {
		//判断医嘱服务是不是持续类型的服务
		if (!medSrvMap.containsKey(ordSrvDO.getId_srv())) {
			return false;
		}
		//判断医嘱服务：单位是不是时间单位
		if (!timeUnitMap.containsKey(ordSrvDO.getId_medu())) {
			return false;
		}
		return true;
	}

	@Override
	public void exec(IpCgPatDTO patInfo, PripatAggDO pripatAgg,
			FDateTime cgEndTime) throws BizException {
		// TODO Auto-generated method stub
		
	}
}
