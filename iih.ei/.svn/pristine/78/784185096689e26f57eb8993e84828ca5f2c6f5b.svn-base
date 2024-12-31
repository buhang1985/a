package iih.ei.std.s.v1.bp.pe.updatestatusbylab;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ei.std.d.v1.mp.updatestatus.d.OrderstateDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.UpLabStatusDTO;
import iih.ei.std.s.v1.bp.mp.updatestatusbylab.qry.QueryApplynoSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 
* @ClassName: LabConverToAppBp
* @Description: 标本信息转换成申请信息
* @author zhy
* @date 2019年9月29日
*
 */
public class LabPeConverToAppBp {
	/**
	 * 
	 * @param paramList
	 * @return
	 * @throws BizException 
	 */
	public OrderstateDTO[] getApplyform(List<UpLabStatusDTO> paramList) throws BizException {

		// 1.获取所有的标本号
		List<String> nobarList = getNobarList(paramList);

		//2.根据标本号查询出所有的申请单号
		CiOrderDO[] ors = queryLabSamp(nobarList);
		if(ors == null || ors.length <1){
			throw new BizException("未查询到对应标本号的申请单信息！");
		}
		
		//3.根据申请单号实例化入参
		OrderstateDTO[] orderstates = HandleData(ors,paramList);
		
		return orderstates;
	}


	/**
	 * 获取标本号集合
	 * @param paramList
	 * @return
	 */
	private List<String> getNobarList(List<UpLabStatusDTO> paramList) {
		List<String> reList = new ArrayList<String>();
		for (UpLabStatusDTO upLabStatus : paramList) {
			if(reList.contains(upLabStatus.getNo_bar())){
				continue;
			}
			reList.add(upLabStatus.getNo_bar());
		}
		return reList;
	}
	
	/**
	 * 根据标本号查询申请单号
	 * @param nobarList
	 * @return 
	 * @throws BizException 
	 */
	private CiOrderDO[] queryLabSamp(List<String> nobarList) throws BizException {
		QueryApplynoSql qry = new QueryApplynoSql(nobarList);
		CiOrderDO[] orders = (CiOrderDO[]) AppFwUtil.getDORstWithDao(qry, CiOrderDO.class);
		return orders;
		
	}

	/**
	 * 处理数据封装改状态入参
	 * @param ors 
	 * @param paramList
	 * @return
	 */
	private OrderstateDTO[] HandleData(CiOrderDO[] ors, List<UpLabStatusDTO> paramList) {
		List<OrderstateDTO> stateList = new ArrayList<OrderstateDTO>();
		UpLabStatusDTO labStatus = paramList.get(0);
		for (CiOrderDO order : ors) {
			OrderstateDTO orderstate = new OrderstateDTO();
			orderstate.setNo_applyform(order.getApplyno());
			orderstate.setCode_status(labStatus.getCode_status());
			orderstate.setCode_emp(labStatus.getCode_emp());
			orderstate.setCode_dep(labStatus.getCode_dep());
			orderstate.setDt_exe(labStatus.getDt_exe());
			stateList.add(orderstate);
		}
		return stateList.toArray(new OrderstateDTO[0]);
	}
}
