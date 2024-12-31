package iih.bl.st.s.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.AppUtils;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.params.BlParams;
import iih.bl.st.s.task.bp.OpAutoHighHpSettlementBP;
import iih.bl.st.s.task.bp.OpAutoPrepaySettlementBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRServiceExt;

/**
 * 用于患者离院未结算的情况下自动结算
 * 
 * @author ly 2018/05/16
 * zhangxin 添加患者分类与结算周期 2019-7-19
 */
public class OpAutoSettleNewTask implements IBackgroundWorkPlugin {

	
	private static final String PREPAY = "1";//预交金自动结算
	private static final String HIGHHP = "2";//高端商保自动结算
	
	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		PreAlertObject obj = new PreAlertObject();
		
		Map<String, Object> map = ctx.getKeyMap();
		String days = (String)map.get("days");// 执行天数
		String cgType = (String)map.get("cgtype");// 结算的记账类型
		String patId = (String)map.get("patId");// 患者id...测试用
		String patcaid = (String)map.get("patcaid");// 患者分类id
		String stcycle = (String)map.get("stcycle");//结算周期
		if(days == null || cgType == null){
			throw new BizException("入参days和cgtype未定义值,无法进行自动结算任务");
		}
		FDateTime startDate =null;
		if(stcycle==null){
			startDate = AppUtils.getServerDateTime();
		}else {
			startDate = AppUtils.getServerDateTime().getDateTimeBefore(Integer.parseInt(stcycle));
		}
		FDateTime dtBegin = new FDateTime(AppUtils.getServerDate().getDateBefore(Integer.parseInt(days)-1).getMillis());
		
		//多组织处理
		IOrgRServiceExt orgService = ServiceFinder.find(IOrgRServiceExt.class);
		OrgDO[] orgDos =  orgService.queryAllOrgUnitVOs();
		
		if(ArrayUtil.isEmpty(orgDos))
			return obj;
		
		for (OrgDO orgDO : orgDos) {
			
			BLTaskLogger.info(String.format("组织%s门诊自动结算任务开始", orgDO.getName()));
			
			Context.get().setGroupId(orgDO.getId_grp());
			Context.get().setOrgId(orgDO.getId_org());
			Context.get().setGroupNumber(orgDO.getGroupno());
			
			PsnDocDO psn = null;
			//查询记账人员信息
			try {
				psn = this.getPsn();
			} catch (BizException e) {
				BLTaskLogger.info(e.getMessage());
			}
			
			if(psn != null){
				Context.get().setStuffId(psn.getId_psndoc());
				Context.get().setDeptId(psn.getId_dep());
				
				String[] types = cgType.split(",");
				List<String> typeList = new ArrayList<String>();
				typeList.addAll(Arrays.asList(types));
				if(typeList.contains(PREPAY)){
					OpAutoPrepaySettlementBP bp = new OpAutoPrepaySettlementBP();
					bp.exec(patId, dtBegin,patcaid,startDate);
				}
				
				if(typeList.contains(HIGHHP)){
					OpAutoHighHpSettlementBP bp = new OpAutoHighHpSettlementBP();
					bp.exec(patId, dtBegin,patcaid,startDate);
				}
			}
			
			BLTaskLogger.info(String.format("组织%s门诊自动结算任务结束", orgDO.getName()));
		}
		
		return obj;
	}

	/**
	 * 获取人员信息
	 * @return
	 * @throws BizException
	 */
	private PsnDocDO getPsn() throws BizException {
		
		String psn = BlParams.BLSTBK0001();
		if(StringUtil.isEmpty(psn)){
			throw new BizException("参数BLSTBK0001未定义值");
		}
		
		IPsndocMDORService psnRService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO psnDO = psnRService.findById(psn);
		
		if(psnDO == null){
			throw new BizException("未查询到记账人员信息");
		}
		
		return psnDO;
	}
}
