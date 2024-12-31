package iih.ci.event.ord.reissue.action.lis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.ci.event.ord.reissue.common.ReissueCommonAction;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public abstract class ReissueLisCommonAction extends ReissueCommonAction  {

	//申请单号、打印单号 检查、检验、病理 查询表不同，故将申请单号、打印单号查询逻辑分开
	public CiOrderDO[] checkOrders() throws BizException {
		
		CiOrderDO[] orders = this.getOrders();
		if (orders != null && orders.length > 0) {
			//入参中申请单号或打印单号不为空时进行过滤校验
			if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getApplyid()) || 
					StringUtils.isNotEmpty(this.iEMsgReissueDTO.getApplyid())) {
				List<CiOrderDO> ordList = new ArrayList<>();
				for (CiOrderDO order : orders) {
					FBoolean applyFlag = FBoolean.FALSE;
					if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getApplyid())) {//校验申请单号
						if (FBoolean.TRUE.equals(checkApplyId(order.getId_or()))) {
							applyFlag = FBoolean.TRUE;
							if (StringUtils.isEmpty(this.iEMsgReissueDTO.getPrintingno())) {//打印单号为空
								ordList.add(order);
							}
						}
					} else if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getPrintingno())) {//校验打印单号
						if (FBoolean.TRUE.equals(checkPrintingNo(order.getId_or()))) {
							if (StringUtils.isEmpty(this.iEMsgReissueDTO.getApplyid()) || applyFlag.booleanValue()) {
								ordList.add(order);
							} 
						}
					} 
				}
				return ordList.toArray(new CiOrderDO[ordList.size()]);
			} else {//否则直接返回
				return orders;
			}
			
		} else if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getApplyid()) || 
					StringUtils.isNotEmpty(this.iEMsgReissueDTO.getPrintingno())) {
			//前面获取不到医嘱，重新根据申请单号、打印获取
			return getOrdersByAppIdOrPrnNo();
		}
		
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	public FBoolean checkApplyId(String id_or) throws BizException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(1) cnt ");
		sql.append("from ci_ap_lab ");
		sql.append("where no_applyform = ? ");
		sql.append("and id_or = ? ");
		SqlParam param = new SqlParam();
		param.addParam(this.iEMsgReissueDTO.getApplyid());
		param.addParam(id_or);
		List<Map<String, Object>> sqlRst = (List<Map<String, Object>>) new DAFacade().execQuery(sql.toString(), param,
				new MapListHandler());
		FBoolean bool = new FBoolean(Integer.valueOf(sqlRst.get(0).get("cnt").toString()) > 0);
		return bool;
	}

	@SuppressWarnings("unchecked")
	public FBoolean checkPrintingNo(String id_or) throws BizException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(1) cnt ");
		sql.append("from ci_app_lis l ");
		sql.append("left join ci_app_lis_or o on l.id_ciapplissheet = o.id_ciapplissheet ");
		sql.append("where l.code_app = ? " );
		sql.append("and o.id_or = ? ");
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
	public CiOrderDO[] getOrdersByAppIdOrPrnNo() throws DAException {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from ci_order c ");
		if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getApplyid())) {
			sql.append("left join ci_ap_lab l on c.id_or = l.id_or ");
		}
		if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getPrintingno())) {
			sql.append("left join ci_app_lis_or or on or.id_or = c.id_or ");
			sql.append("left join ci_app_lis s on s.id_ciapplissheet = or.id_ciapplissheet ");
		}
		sql.append("where 1=1 ");
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
