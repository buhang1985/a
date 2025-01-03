package iih.ci.event.ord.reissue.action.ris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import bsh.This;
import iih.ci.event.ord.reissue.action.ris.pathy.IpReissuePathyBP;
import iih.ci.event.ord.reissue.action.ris.pathy.OpReissuePathyBP;
import iih.ci.event.ord.reissue.common.ReissueCommonAction;
import iih.ci.event.ord.reissue.common.ReissueCommonBP;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.event.reissue.d.IEMsgReissueConst;
import iih.ci.event.reissue.d.IEMsgReissueRstDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public abstract class ReissueRisCommonAction extends ReissueCommonAction  {

	private static final Map<String, ReissueCommonBP> opBpMap = new HashMap<>();
	private static final Map<String, ReissueCommonBP> ipBpMap = new HashMap<>();
	private static final Map<String, Map<String, ReissueCommonBP>> bpMap = new HashMap<>();
	 
	static {
		ipBpMap.put(OrdEventUtil.SD_SRVTP_RIS_BINGLI, new IpReissuePathyBP());//住院病理
		ipBpMap.put(OrdEventUtil.SD_SRVTP_RIS, new IpReissueRisBP());//住院检查
		bpMap.put(IEMsgReissueConst.IPVISITTYPE, ipBpMap);
		opBpMap.put(OrdEventUtil.SD_SRVTP_RIS_BINGLI, new OpReissuePathyBP());//门诊病理
		opBpMap.put(OrdEventUtil.SD_SRVTP_RIS, new OpReissueRisBP());//门诊检查
		bpMap.put(IEMsgReissueConst.OPVISITTYPE, opBpMap);
	}
	
	@Override
	public IEMsgReissueRstDTO asseble() throws BizException {

		Map<String, List<CiOrderDO>> ordMap = getRisOrPathyOrders();
		List<BaseDTO> dtos = new ArrayList<BaseDTO>();
		if (bpMap.containsKey(this.iEMsgReissueDTO.getVisittypecode())){
			Map<String, ReissueCommonBP> commonBpMap = bpMap.get(this.iEMsgReissueDTO.getVisittypecode());
			if (ordMap != null && ordMap.size() > 0) {
				for (String type : ordMap.keySet()) {
					if (commonBpMap.containsKey(type)) {
						ReissueCommonBP bp = commonBpMap.get(type);
						bp.setiEMsgReissueDTO(this.iEMsgReissueDTO);
						bp.setOrders(ordMap.get(type).toArray(new CiOrderDO[ordMap.get(type).size()]));
						BaseDTO[] risdtos = bp.getAssebleData();
						if(risdtos != null){
							dtos.addAll(Arrays.asList(risdtos));
						}
					}
				}
			}
		}
		
		if(dtos != null && dtos.size()>0){
			return assembleData(dtos);
		}
		return null;		
	}
	
	protected IEMsgReissueRstDTO assembleData(List<BaseDTO> dtos) throws BizException {
		return null;
	}
	
	public Map<String, List<CiOrderDO>> getRisOrPathyOrders() throws BizException {
		// TODO 过滤出检查、病理医嘱
		Map<String, List<CiOrderDO>> ordMap = new HashMap<>();
		List<CiOrderDO> pathyList = new ArrayList<>();//病理集合
		List<CiOrderDO> risList = new ArrayList<>();//检查集合
		CiOrderDO[] orders = this.getOrders();
		if (orders != null && orders.length > 0) {
			for (CiOrderDO order : orders) {
				FBoolean applyFlag = FBoolean.FALSE;
				if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getApplyid())) {//校验申请单号
					if (FBoolean.TRUE.equals(checkApplyId(order.getSd_srvtp(), order.getId_or()))) {
						applyFlag = FBoolean.TRUE;						
						if (StringUtils.isEmpty(this.iEMsgReissueDTO.getPrintingno())) {//打印单号为空
							if (OrdEventUtil.SD_SRVTP_RIS_BINGLI.equals(order.getSd_srvtp())) {
								pathyList.add(order);
							} else {
								risList.add(order);
							}
						}
					}
				} else if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getPrintingno())) {//校验打印单号
					if (FBoolean.TRUE.equals(checkPrintingNo(order.getSd_srvtp(), order.getId_or()))) {
						if (StringUtils.isEmpty(this.iEMsgReissueDTO.getApplyid()) || applyFlag.booleanValue()) {
							if (OrdEventUtil.SD_SRVTP_RIS_BINGLI.equals(order.getSd_srvtp())) {
								pathyList.add(order);
							} else {
								risList.add(order);
							}
						} 
					}
				} else {
					if (OrdEventUtil.SD_SRVTP_RIS_BINGLI.equals(order.getSd_srvtp())) {
						pathyList.add(order);
					} else {
						risList.add(order);
					}
				}
				if (pathyList != null && pathyList.size() > 0) {//病理
					ordMap.put(OrdEventUtil.SD_SRVTP_RIS_BINGLI, pathyList);
				} else if (risList != null && risList.size() > 0){
					ordMap.put(OrdEventUtil.SD_SRVTP_RIS, risList);//检查
				}
			}
		}
		//前面获取不到医嘱时，重新根据申请单号、打印单号查询医嘱
		else if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getApplyid()) || 
				StringUtils.isNotEmpty(this.iEMsgReissueDTO.getPrintingno())) { 
			//查询病理医嘱
			CiOrderDO[] pathys = getOrdersByAppIdOrPrnNo("ci_ap_pathgy", "ci_app_pathgy");
			if (pathys != null && pathys.length > 0) {
				ordMap.put(OrdEventUtil.SD_SRVTP_RIS_BINGLI, Arrays.asList(pathys));
			}
			//查询病理医嘱
			CiOrderDO[] ris = getOrdersByAppIdOrPrnNo("ci_ap_obs", "ci_app_ris");
			if (ris != null && ris.length > 0) {
				ordMap.put(OrdEventUtil.SD_SRVTP_RIS, Arrays.asList(ris));
			}
		}
		
		return ordMap;
	}

	@SuppressWarnings("unchecked")
	public FBoolean checkApplyId(String sd_srvtp, String id_or) throws BizException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(1) cnt ");
		if (OrdEventUtil.SD_SRVTP_RIS_BINGLI.equals(sd_srvtp)) {//病理
			sql.append("from ci_ap_pathgy ap ");
		} else  {//检查
			sql.append("from ci_ap_obs ap ");
		}
		sql.append("left join ci_order c on c.id_or = ap.id_or ");
		sql.append("where 1=1 ");
		sql.append(this.getWhereParamCtlStr());
		sql.append("and no_applyform = ? ");
		sql.append("and c.id_or = ? ");
		SqlParam param = new SqlParam();
		param.addParam(this.iEMsgReissueDTO.getApplyid());
		param.addParam(id_or);
		List<Map<String, Object>> sqlRst = (List<Map<String, Object>>) new DAFacade().execQuery(sql.toString(), param,
				new MapListHandler());
		FBoolean bool = new FBoolean(Integer.valueOf(sqlRst.get(0).get("cnt").toString()) > 0);
		return bool;
	}

	@SuppressWarnings("unchecked")
	public FBoolean checkPrintingNo(String sd_srvtp, String id_or) throws BizException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(1) cnt ");
		if (OrdEventUtil.SD_SRVTP_RIS_BINGLI.equals(sd_srvtp)) {//病理
			sql.append("from ci_app_pathgy app ");
		} else  {//检查
			sql.append("from ci_app_ris app ");
		}
		sql.append("left join ci_order c on c.id_or = app.id_or ");
		sql.append("where 1=1 ");
		sql.append(this.getWhereParamCtlStr());
		sql.append("and code_app = ? ");
		sql.append("and c.id_or = ? ");
		SqlParam param = new SqlParam();
		param.addParam(this.iEMsgReissueDTO.getPrintingno());
		param.addParam(id_or);
		List<Map<String, Object>> sqlRst = (List<Map<String, Object>>) new DAFacade().execQuery(sql.toString(), param,
				new MapListHandler());
		FBoolean bool = new FBoolean(Integer.valueOf(sqlRst.get(0).get("cnt").toString()) > 0);
		return bool;
	}
	
	//重新根据申请单号、打印单号查询
	@SuppressWarnings("unchecked")
	public CiOrderDO[] getOrdersByAppIdOrPrnNo(String appTable, String prnTable) 
			throws DAException {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from ci_order c ");
		if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getApplyid())) {
			sql.append("left join " + appTable + " l on c.id_or = l.id_or ");
		}
		if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getPrintingno())) {
			sql.append("left join " + prnTable + " s on s.id_or = c.id_or ");
		}
		sql.append("where 1=1 ");
		sql.append(this.getWhereParamCtlStr());
		SqlParam param = new SqlParam();
		if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getApplyid())) {
			sql.append("and l.no_applyform = ? ");//申请单号
			param.addParam(this.iEMsgReissueDTO.getApplyid());
		} else if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getPrintingno())) {
			
			sql.append("and s.code_app = ? ");//打印单号
			param.addParam(this.iEMsgReissueDTO.getPrintingno());
		} 
		List<CiOrderDO> orderDOs = (List<CiOrderDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(CiOrderDO.class));
		return orderDOs.toArray(new CiOrderDO[orderDOs.size()]);
	}
}
