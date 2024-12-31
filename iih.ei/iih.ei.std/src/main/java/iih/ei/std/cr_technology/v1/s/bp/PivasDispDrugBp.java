package iih.ei.std.cr_technology.v1.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import iih.bd.webservice.WsResultMsgCode;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugParaItemBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugParamBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugRstBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugRstBeanList;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindDgdtItemQry;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDtDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * Pivas发药业务逻辑
 * 
 * @author hao_wu 2018-6-6
 *
 */
public class PivasDispDrugBp {
	
	/**
	 * 发药
	 * 
	 * @throws BizException
	 */
	public void exec(PivasDispDrugParamBean[] paramBeans, PivasDispDrugRstBeanList resultBean) throws BizException {
		if (paramBeans == null || paramBeans.length <= 0) {
			throw new BizException("paramBeans不允许为空。");
		}
		//初始化上下文
		initContext(paramBeans[0]);
		//根据医嘱编码、执行时间分组、每个医嘱的每一顿计划单独作为一个事务提交
		LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> beanMap = this.initBeanMap(paramBeans);
		//返回结果
		final List<PivasDispDrugRstBean> rstBeanList = new ArrayList<PivasDispDrugRstBean>();
		//根据医嘱编码、执行时间分组、每个医嘱的每一顿计划单独作为一个事务提交
		Map<String, Map<String, List<IpDgDtDTO>>> ipdgdtMap = this.initIpdgdtMap(paramBeans, rstBeanList);
		if(ipdgdtMap == null || ipdgdtMap.size() <= 0) {
			//返回结果
			resultBean.setPivasDispDrugRstBean(rstBeanList.toArray(new PivasDispDrugRstBean[0]));
			return;
		}
		//分批发药
		final PivasDispDrugSplitBp bp = new PivasDispDrugSplitBp();
		for(String orderNo : beanMap.keySet()) {
			LinkedHashMap<String, PivasDispDrugParamBean> paramMap = beanMap.get(orderNo);
			final Map<String, List<IpDgDtDTO>> ipdgItemMap = ipdgdtMap.get(orderNo);
			for(String dt_mp_plan : paramMap.keySet()) {
				final PivasDispDrugParamBean paramBean = paramMap.get(dt_mp_plan);
				//发药
				try
				{
					TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
						@Override
						public String doInTransaction(TransactionStatus arg0) {
							try {
								PivasDispDrugRstBean rstBean = bp.exec(paramBean, ipdgItemMap);
								rstBeanList.add(rstBean);
							} catch (Exception e) {
								throw new BizRuntimeException(e.getMessage(), e);
							}
							return null;
						}
					});
				} catch (Exception ex) {
					bp.recordFailNote(ex);
					PivasDispDrugRstBean rstBean = this.initRstBean(paramBean, ex);
					rstBeanList.add(rstBean);
				}
			}
		}
		
		//返回结果
		resultBean.setPivasDispDrugRstBean(rstBeanList.toArray(new PivasDispDrugRstBean[0]));
	}
	
	/**
	 * 使用入参初始化上下文
	 * 
	 * @throws BizException
	 */
	private void initContext(PivasDispDrugParamBean paramBean) throws BizException {
		String deptCode = "600902";
		//设置当前科室
		InitContextByDepBp bp = new InitContextByDepBp();
		bp.exec(deptCode);
		//设置当前人员
		PivasDispDrugSplitBp splitBp = new PivasDispDrugSplitBp();
		splitBp.getPsndocDO(paramBean.getOperCode());
	}
	
	/**
	 * 根据医嘱编码、执行时间分组
	 * 
	 * @throws BizException
	 */
	private LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> initBeanMap(PivasDispDrugParamBean[] paramBeans) {
		//key:医嘱编码<key:执行计划时间>
		LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> result = new LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>>();
		for(PivasDispDrugParamBean paramBean : paramBeans) {
			if(result.containsKey(paramBean.getOrderNo())) {
				LinkedHashMap<String, PivasDispDrugParamBean> planTimeMap = result.get(paramBean.getOrderNo());
				planTimeMap.put(paramBean.getOrderSrvPlanTime(), paramBean);
			} else {
				LinkedHashMap<String, PivasDispDrugParamBean> planTimeMap = new LinkedHashMap<String, PivasDispDrugParamBean>();
				planTimeMap.put(paramBean.getOrderSrvPlanTime(), paramBean);
				result.put(paramBean.getOrderNo(), planTimeMap);
			}
		}
		
		//排序
		LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> sortedResult = 
				new LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>>();
		for(String orderNokey : result.keySet()) {
			Map<String, PivasDispDrugParamBean> planTimeMap = result.get(orderNokey);
			String[] timeKeys = planTimeMap.keySet().toArray(new String[0]);
			this.sort(timeKeys);
			LinkedHashMap<String, PivasDispDrugParamBean> sortedMap = new LinkedHashMap<String, PivasDispDrugParamBean>();
			for(String timeKey : timeKeys) {
				sortedMap.put(timeKey, planTimeMap.get(timeKey));
			}
			sortedResult.put(orderNokey, sortedMap);
		}
		
		return sortedResult;
	}
	
	/**
	 * 排序
	 * 
	 * @throws BizException
	 */
	private void sort(String[] keyList) {
		Arrays.sort(keyList, new Comparator<String>() {
			@Override
			public int compare(String key1, String key2) {
				return key1.compareTo(key2);
			}
		});
	}

	/**
	 * 根据传入的执行计划主键获取发药明细数据并分组
	 * 
	 * @throws BizException
	 */
	private Map<String, Map<String, List<IpDgDtDTO>>> initIpdgdtMap(PivasDispDrugParamBean[] paramBeans, List<PivasDispDrugRstBean> rstBeanList) throws BizException {
		//key:医嘱编码<key:执行计划时间>
		Map<String, Map<String, List<IpDgDtDTO>>> result = new HashMap<String, Map<String, List<IpDgDtDTO>>>();
		//根据传入的执行计划主键获取药品发放明细
		List<String> id_or_pr_srvs = this.getIdorprSrvList(paramBeans);
		PivasFindDgdtItemQry Sql = new PivasFindDgdtItemQry(id_or_pr_srvs);
		IpDgDtDTO[] ipDgDtDtoList = (IpDgDtDTO[])AppFwUtil.getDORstWithDao(Sql, IpDgDtDTO.class);
		if(ipDgDtDtoList == null || ipDgDtDtoList.length <= 0) {
			for(PivasDispDrugParamBean paramBean : paramBeans) {
				rstBeanList.add(this.initRstBean(paramBean, new BizException("根据传入数据未查询到执行计划，需发药数据无效，无法发药。")));
			}
			return null;
		}
		for(IpDgDtDTO ipdgdtDTO : ipDgDtDtoList) {
			if(result.containsKey(ipdgdtDTO.getCode_or())) {
				Map<String, List<IpDgDtDTO>> ipdgdtMap = result.get(ipdgdtDTO.getCode_or());
				if(ipdgdtMap.containsKey(ipdgdtDTO.getDt_mp_plan().toString())) {
					List<IpDgDtDTO> ipdgdtList = ipdgdtMap.get(ipdgdtDTO.getDt_mp_plan().toString());
					ipdgdtList.add(ipdgdtDTO);
				} else {
					List<IpDgDtDTO> ipdgdtList = new ArrayList<IpDgDtDTO>();
					ipdgdtList.add(ipdgdtDTO);
					ipdgdtMap.put(ipdgdtDTO.getDt_mp_plan().toString(), ipdgdtList);
				}
			} else {
				Map<String, List<IpDgDtDTO>> ipdgdtMap = new HashMap<String, List<IpDgDtDTO>>();
				List<IpDgDtDTO> ipdgdtList = new ArrayList<IpDgDtDTO>();
				ipdgdtList.add(ipdgdtDTO);
				ipdgdtMap.put(ipdgdtDTO.getDt_mp_plan().toString(), ipdgdtList);
				result.put(ipdgdtDTO.getCode_or(), ipdgdtMap);
			}
		}
		
		return result;
	}

	/**
	 * 获取传入的执行计划主键
	 * 
	 * @throws BizException
	 */
	private List<String> getIdorprSrvList(PivasDispDrugParamBean[] paramBeans) {
		List<String> id_or_pr_srvs = new ArrayList<String>();
		for(PivasDispDrugParamBean paramBean : paramBeans) {
			for(PivasDispDrugParaItemBean orderPrSrvID : paramBean.getOrderPrSrvID()) {
				id_or_pr_srvs.add(orderPrSrvID.getItemID());
			}
		}
		
		return id_or_pr_srvs;
	}
	
	/**
	 * 返回结果
	 * 
	 * @throws BizException
	 */
	public PivasDispDrugRstBean initRstBean(PivasDispDrugParamBean paramBean, Exception e) {
		PivasDispDrugRstBean rstBean = new PivasDispDrugRstBean();
		if(paramBean == null) {
			rstBean.setOrderNo("");
			rstBean.setOrderSrvPlanTime("");
			rstBean.setOrderPrSrvID(new PivasDispDrugParaItemBean[] {});
		} else {
			rstBean.setOrderNo(paramBean.getOrderNo());
			rstBean.setOrderSrvPlanTime(paramBean.getOrderSrvPlanTime());
			rstBean.setOrderPrSrvID(paramBean.getOrderPrSrvID());
		}
		rstBean.setResultCode(WsResultMsgCode.ERROR);
		rstBean.setResultMsg(e.getMessage());
		
		return rstBean;
	}
}
