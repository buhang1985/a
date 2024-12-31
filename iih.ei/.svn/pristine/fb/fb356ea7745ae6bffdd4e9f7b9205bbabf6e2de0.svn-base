package iih.ei.std.cr_technology.v1.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import iih.bd.bc.udi.pub.IMpDictCodeConst;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugParamBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugRstBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugRstBeanList;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindDgdtItemNewQry;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDtDTO;
import iih.mp.dg.ipdgapp.d.IpDgApStatusEnum;
import iih.mp.dg.ipdgapp.d.IpDgDispStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.lock.PKLock;

/**
 * Pivas发药业务逻辑
 * 
 * @author hou_sudan 2018-10-07
 *
 */
public class PivasDispDrugNewBp {
	
	/**
	 * 发药
	 * 
	 * @throws BizException
	 */
	public void exec(PivasDispDrugParamBean[] paramBeans, PivasDispDrugRstBeanList resultBean) throws BizException {
		if (paramBeans == null || paramBeans.length <= 0) {
			throw new BizException("paramBeans不允许为空。");
		}
		
		//资源加锁
		this.addLockByCodeor(paramBeans);
		
		//返回结果
		List<PivasDispDrugRstBean> rstBeanList = new ArrayList<PivasDispDrugRstBean>();
		
		//根据医嘱编码、执行时间分组
		LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> beanMap = this.initBeanMap(paramBeans);
		
		//初始化上下文
		initContext(paramBeans[0]);
		
		//根据传入信息获取请领明细数据
		IpDgDtDTO[] ipDgDtDtoList = this.getIpdgDTOS(paramBeans, beanMap, rstBeanList);
		if(ipDgDtDtoList == null || ipDgDtDtoList.length <= 0) {
			//返回结果
			this.initDispDrugRstBean(resultBean, rstBeanList);
			return;
		}
		
		//发药前数据校验  
		Boolean fg_success = this.checkDispDrugInfo(beanMap, rstBeanList, ipDgDtDtoList);
		if(fg_success) {
			//异常校验完成后发药
			this.drugDisp(beanMap, rstBeanList, ipDgDtDtoList);
		}
		
		//返回结果
		this.initDispDrugRstBean(resultBean, rstBeanList);
	}

	/**
	 * 资源加锁
	 * 
	 * @throws BizException
	 */
	private void addLockByCodeor(PivasDispDrugParamBean[] paramBeans) throws BizException {
		String lockKey=String.format("PIVAS_DispDrugBat_%s", paramBeans[0].getOrderNo() + paramBeans[0].getOrderSrvPlanTime());
		boolean locked=PKLock.getInstance().addDynamicLock(lockKey, 1000);
		if(!locked) {
			throw new BizException("正在发药。");
		}
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
	 * 根据传入医嘱编码和计划执行时间获取请领明细数据
	 * 
	 * @throws BizException
	 */
	private IpDgDtDTO[] getIpdgDTOS(PivasDispDrugParamBean[] paramBeans, LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> beanMap, 
			List<PivasDispDrugRstBean> rstBeanList) throws BizException {
		List<IpDgDtDTO> result = new ArrayList<IpDgDtDTO>();
		//医嘱编码集合
		List<String> code_ors = this.getCodeors(paramBeans);
		PivasFindDgdtItemNewQry Sql = new PivasFindDgdtItemNewQry(code_ors);
		//查询请领明细数据
		IpDgDtDTO[] ipDgDtDtoList = (IpDgDtDTO[])AppFwUtil.getDORstWithDao(Sql, IpDgDtDTO.class);
		if(ipDgDtDtoList == null || ipDgDtDtoList.length <= 0) {
			for(PivasDispDrugParamBean paramBean : paramBeans) {
				String error = String.format("未查询到请领明细数据。医嘱号：%s，计划执行时间：%s", paramBean.getOrderNo(), paramBean.getOrderSrvPlanTime());
				rstBeanList.add(PivasDispDrugCommBp.initExcRstBean(paramBean, new BizException(error)));
			}
			return null;
		}
		//根据医嘱编号、计划执行时间分组
		Map<String, List<IpDgDtDTO>> dgdtMap = new HashMap<String, List<IpDgDtDTO>>();
		for(IpDgDtDTO itemDTO : ipDgDtDtoList) {
			String key = itemDTO.getCode_or() + itemDTO.getDt_mp_plan();
			if(dgdtMap.containsKey(key)) {
				List<IpDgDtDTO> dgdtoList = dgdtMap.get(key);
				dgdtoList.add(itemDTO);
			} else {
				List<IpDgDtDTO> dgdtoList = new ArrayList<IpDgDtDTO>();
				dgdtoList.add(itemDTO);
				dgdtMap.put(key, dgdtoList);
			}
		}
		//验证传入数据是否全部匹配到有效数据
		PivasDispDrugChkBp bp = new PivasDispDrugChkBp();
		Map<String, IpDgDtDTO> invalidMap = new HashMap<String, IpDgDtDTO>();
		for(String code_or : beanMap.keySet()) {
			LinkedHashMap<String, PivasDispDrugParamBean> paramMap = beanMap.get(code_or);
			for(String dt_mp_plan : paramMap.keySet()) {
				String key = code_or + dt_mp_plan;
				PivasDispDrugParamBean paramBean = paramMap.get(dt_mp_plan);
				if(dgdtMap.containsKey(key)) {
					List<IpDgDtDTO> itemDTOList = dgdtMap.get(key);
					//请领明细数据是否有效
					FBoolean fg_valid = FBoolean.TRUE;
					for(IpDgDtDTO itemDTO : itemDTOList)
					{
						FBoolean fg_itemvalid = bp.checkItemDTO(paramBean, rstBeanList, itemDTO, FBoolean.FALSE);
						if(!fg_itemvalid.booleanValue()) {
							fg_valid = FBoolean.FALSE;
						}
					}
					
					if(fg_valid.booleanValue()) {
						result.addAll(itemDTOList);
					} else {
						for(IpDgDtDTO itemDTO : itemDTOList) {
							invalidMap.put(itemDTO.getId_dgipdt(), itemDTO);
						}
					}
				} else {
					String error = String.format("未查询到请领明细数据。医嘱号：%s，计划执行时间：%s", paramBean.getOrderNo(), paramBean.getOrderSrvPlanTime());
					rstBeanList.add(PivasDispDrugCommBp.initExcRstBean(paramBean, new BizException(error)));
				}
			}
		}
		
		//异常信息存储
		PivasDispDrugCommBp.saveIpdgItem(invalidMap, FBoolean.TRUE);
		
		return result.toArray(new IpDgDtDTO[0]);
	}
	
	/**
	 * 发药前数据校验
	 * @param rstBeanList 
	 * @param beanMap 
	 * 
	 * @throws BizException
	 */
	private Boolean checkDispDrugInfo(LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> beanMap, List<PivasDispDrugRstBean> rstBeanList, 
			final IpDgDtDTO[] ipDgDtDtoList) throws BizException {
		try
		{
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						//发药数据校验(费用、库存、仓库物品关系)
						PivasDispDrugChkBp bp = new PivasDispDrugChkBp();
						bp.exec(ipDgDtDtoList);
					} catch (Exception e) {
						throw new BizRuntimeException(e.getMessage(), e);
					}
					return null;
				}
			});
		} catch (Exception ex) {
			PivasDispDrugCommBp.recordFailNote(ipDgDtDtoList, ex, PivasDispDrugCommBp.OPER_TYPE_CHK);
			this.initExcRstBean(beanMap, rstBeanList, Arrays.asList(ipDgDtDtoList), ex);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 发药
	 * 
	 * @throws BizException
	 */
	private void drugDisp(LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> beanMap, 
			List<PivasDispDrugRstBean> rstBeanList, IpDgDtDTO[] ipDgDtDtoList) throws BizException {
		//排除校验异常数据
		PivasDispDrugChkBp bp = new PivasDispDrugChkBp();
		List<IpDgDtDTO> ipdgdtList = new ArrayList<IpDgDtDTO>();
		for(IpDgDtDTO itemDTO : ipDgDtDtoList) {
			//请领明细数据是否有效
			if(!bp.checkItemDTO(null, null, itemDTO, FBoolean.TRUE).booleanValue())
				continue;
			PivasDispDrugParamBean paramBean = beanMap.get(itemDTO.getCode_or()).get(String.valueOf(itemDTO.getDt_mp_plan()));
			if(IpDgApStatusEnum.INVALID.equals(itemDTO.getEn_opap())) {
				String note = itemDTO.getNote();
				if(IMpDictCodeConst.SD_BRUSHCHECKTYPE_PARARTICLES.equals(itemDTO.getSd_chktype())) {
					note = "物品停发";
				} else if(IMpDictCodeConst.SD_BRUSHCHECKTYPE_LACKSTOCK.equals(itemDTO.getSd_chktype())) {
					note = "库存不足";
				}
				rstBeanList.add(PivasDispDrugCommBp.initExcRstBean(paramBean, new BizException(note)));
			} else {
				ipdgdtList.add(itemDTO);
			}
		}
		//无可发药数据
		if(ipdgdtList == null || ipdgdtList.size() <= 0)
			return;
		//根据患者分组发药
		Map<String, List<IpDgDtDTO>> dispMap = new HashMap<String, List<IpDgDtDTO>>();
		for(IpDgDtDTO itemDTO : ipdgdtList) {
			//设置发药状态
			itemDTO.setEn_opde(IpDgDispStatusEnum.DISPENSED);
			if(dispMap.containsKey(itemDTO.getId_dgipap())) {
				List<IpDgDtDTO> ipdgList = dispMap.get(itemDTO.getId_dgipap());
				ipdgList.add(itemDTO);
			} else {
				List<IpDgDtDTO> ipdgList = new ArrayList<IpDgDtDTO>();
				ipdgList.add(itemDTO);
				dispMap.put(itemDTO.getId_dgipap(), ipdgList);
			}
		}
		
		//发药
		this.execDispDrug(beanMap, rstBeanList, dispMap);
	}

	/**
	 * 发药
	 * 
	 * @throws BizException
	 */
	private void execDispDrug(final LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> beanMap, 
			final List<PivasDispDrugRstBean> rstBeanList, Map<String, List<IpDgDtDTO>> dispMap) throws BizException {
		//根据患者分组发药
		final PivasDispDrugSplitNewBp bp = new PivasDispDrugSplitNewBp();
		for(String id_dgipap : dispMap.keySet()) {
			final List<IpDgDtDTO> ipdgList = dispMap.get(id_dgipap);
			try
			{
				TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
					@Override
					public String doInTransaction(TransactionStatus arg0) {
						try {
							bp.exec(beanMap, rstBeanList, ipdgList);
						} catch (Exception e) {
							throw new BizRuntimeException(e.getMessage(), e);
						}
						return null;
					}
				});
			} catch (Exception ex) {
				PivasDispDrugCommBp.recordFailNote(ipdgList.toArray(new IpDgDtDTO[0]), ex, PivasDispDrugCommBp.OPER_TYPE_DISP);
				this.initExcRstBean(beanMap, rstBeanList, ipdgList, ex);
			}
		}
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
		bp.getPsndocDO(paramBean.getOperCode());
	}

	/**
	 * 异常返回结果
	 * 
	 * @throws BizException
	 */
	private void initExcRstBean(LinkedHashMap<String, LinkedHashMap<String, PivasDispDrugParamBean>> beanMap,
			List<PivasDispDrugRstBean> rstBeanList, List<IpDgDtDTO> ipdgList, Exception e) {
		for(IpDgDtDTO itemDTO : ipdgList) {
			PivasDispDrugParamBean paramBean = beanMap.get(itemDTO.getCode_or()).get(String.valueOf(itemDTO.getDt_mp_plan()));
			rstBeanList.add(PivasDispDrugCommBp.initExcRstBean(paramBean, e));
		}
	}
	
	/**
	 * 获取传入的执行计划主键
	 * 
	 * @throws BizException
	 */
	private List<String> getCodeors(PivasDispDrugParamBean[] paramBeans) {
		List<String> code_ors = new ArrayList<String>();
		for(PivasDispDrugParamBean paramBean : paramBeans) {
			code_ors.add(paramBean.getOrderNo());
		}
		
		return code_ors;
	}
	
	/**
	 * 结果返回
	 * 
	 * @throws BizException
	 */
	private void initDispDrugRstBean(PivasDispDrugRstBeanList resultBean, List<PivasDispDrugRstBean> rstBeanList) {
		Map<String, PivasDispDrugRstBean> keyMap = new HashMap<String, PivasDispDrugRstBean>();
		for(PivasDispDrugRstBean rstBean : rstBeanList) {
			String key = rstBean.getOrderNo() + rstBean.getOrderSrvPlanTime();
			if(!keyMap.containsKey(key)) {
				keyMap.put(key, rstBean);
			} else {
				PivasDispDrugRstBean oringRstBean = keyMap.get(key);
				if(StringUtils.isBlank(rstBean.getResultMsg())) {
					continue;
				}
				if(StringUtils.isBlank(oringRstBean.getResultMsg())) {
					keyMap.put(key, rstBean);
					continue;
				}
				if(oringRstBean.getResultMsg().indexOf("物品停发") >= 0 || 
						oringRstBean.getResultMsg().indexOf("库存不足") >= 0)
					continue;
				keyMap.put(key, rstBean);
			}
		}
		resultBean.setPivasDispDrugRstBean(keyMap.values().toArray(new PivasDispDrugRstBean[0]));
	}
}
