package iih.sc.scbd.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.i.IScDeptParamDsDORService;
import iih.sc.scbd.scdeptparam.i.IScdeptparamMDORService;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.scp.i.IScScpOutCmdService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 同步推荐提前报到时间BP
 * 
 * @author zhengcm
 * @date 2017-11-29 13:43:43
 *
 */
public class SynchroSugestExmintBP {

	/**
	 * 重写保存：修改推荐提前报到时间时需要同步修改计划和排班
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 13:44:16
	 *
	 * @param paramDO
	 * @throws BizException
	 */
	public void exec(ScDeptParamDO paramDO,ScDeptParamDsDO[] newDsDOs) throws BizException {
		if (null == paramDO || StringUtil.isEmptyWithTrim(paramDO.getId_deptparam())) {
			return;
		}
		
		IScDeptParamDsDORService iScDeptParamDsDORService = ServiceFinder.find(IScDeptParamDsDORService.class);
		//获取科室参数明细
		ScDeptParamDsDO[] oldDsDO = iScDeptParamDsDORService.find(" id_deptparam = '"+paramDO.getId_deptparam()+"'", "",FBoolean.FALSE);
		
		//医技外都没有id_scca
		if(!paramDO.getSd_sctp().equals(IScDictCodeConst.ID_SCTP_MT))
		{
			ISchedulecaRService sccaService = ServiceFinder.find(ISchedulecaRService.class);
			ScheduleCADO[] sccaDO =  sccaService.find(String.format(" sd_sctp = '%s' ",paramDO.getSd_sctp()), "", FBoolean.FALSE);
			if(sccaDO == null || sccaDO.length == 0 )
			{
				throw new BizException("未找到对应排班分类");
			}
			paramDO.setId_scca(sccaDO[0].getId_scca());
		}
		
		// 同步计划
			IScScpOutCmdService planCmdService = ServiceFinder.find(IScScpOutCmdService.class);
		planCmdService.updatePlanWeekSugestExmint(paramDO,newDsDOs,oldDsDO);
		
		// 同步排班
			IScSchOutCmdService schCmdService = ServiceFinder.find(IScSchOutCmdService.class);
		schCmdService.updateSchSugestExmint(paramDO,newDsDOs,oldDsDO);
	}

}
