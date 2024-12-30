package iih.sc.apt.s.bp;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.OptApt4OrmDTO;
import iih.sc.apt.s.event.OptAptCancConfirmEvent;
import iih.sc.apt.s.event.OptAptConfirmEvent;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplOptDO;
import iih.sc.apt.scaptappl.i.IScAptApplOptDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 科室手术确认/取消确认操作
 * @author yzh
 * @date 2020年5月12日17:14:55
 */
public class OptAptConfirmOperBP {
	
	/**
	 * 科室手术确认/取消确认操作
	 * @param appls
	 * @param oper confirm:确认操作|canc:取消确认操作
	 * @throws BizException
	 */
	public void exec(ScAptApplOptDO[] appls, String oper) throws BizException
	{
		if(ArrayUtil.isEmpty(appls)){
			return;
		}
		if(IScDictCodeConst.SC_OPT_APT_CONFIRM.equals(oper) || IScDictCodeConst.SC_OPT_APT_CANC_CONFIRM.equals(oper)){
			IScAptApplOptDOCudService iscaptapploptdocudservice = ServiceFinder.find(IScAptApplOptDOCudService.class);
			iscaptapploptdocudservice.save(appls);
			this.invoke(appls, oper);
		}
	}
	/**
	 * 发送科室手术确认/取消确认事件
	 * @param appls
	 * @param oper
	 * @throws BizException
	 */
	private void invoke(ScAptApplOptDO[] appls, String oper) throws BizException{
		List<OptApt4OrmDTO> dataList =  this.getInvokeData(appls);
		if(ListUtil.isEmpty(dataList)) return;
		//科室手术确认事件
		if(IScDictCodeConst.SC_OPT_APT_CONFIRM.equals(oper)){
			new OptAptConfirmEvent().invoke(dataList);
		}
		//科室手术取消确认事件
		if(IScDictCodeConst.SC_OPT_APT_CANC_CONFIRM.equals(oper)){
			//new OptAptCancConfirmEvent().invoke(dataList);
		}
	}
	/**
	 * 获取事件源发送数据
	 * @param appls
	 * @return
	 * @throws BizException
	 */
	private List<OptApt4OrmDTO> getInvokeData(ScAptApplOptDO[] appls) throws BizException{
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		List<String> idList = new ArrayList<String>();
		for (ScAptApplOptDO applOptDO : appls) {
			idList.add(applOptDO.getId_aptappl());
		}
		ScAptApplDO[] applDOs = iscaptapplmdorservice.findByIds(idList.toArray(new String[0]), FBoolean.FALSE);
		if(ArrayUtil.isEmpty(applDOs)) return null;
		List<OptApt4OrmDTO> result = new ArrayList<OptApt4OrmDTO>();
		for (ScAptApplDO scAptApplDO : applDOs) {
			OptApt4OrmDTO dto = new OptApt4OrmDTO();
			dto.setId_or(scAptApplDO.getId_or());
			result.add(dto);
		}
		return result;
	}
}
