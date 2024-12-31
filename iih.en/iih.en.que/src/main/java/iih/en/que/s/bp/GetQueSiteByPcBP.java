package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.d.desc.QueSiteDODesc;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取工作站点
 * 
 * @author liubin
 */
public class GetQueSiteByPcBP {
	
	/**
	 * 根据计算机的HostId，获取工作站点
	 * 
	 * @param hostId
	 * 		计算机注册时唯一标识符
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO exec(String hostId) throws BizException {
		if(EnValidator.isEmpty(hostId)){
			return null;
		}
		IWorkstationRService pcRService = ServiceFinder.find(IWorkstationRService.class);
		WorkStationPcDO[] pcs = pcRService.findByAttrValString(WorkStationPcDO.PCID, hostId);
		if(!EnValidator.isEmpty(pcs)){
			String pcId = pcs[0].getId_pc();
			IQuesiteRService queRService = ServiceFinder.find(IQuesiteRService.class);
			String whereStr = String.format("%s.ID_PC='%s' AND %s.SD_QUESITETP='%s' AND %s.FG_ACTIVE = '%s'",
					QueSiteDODesc.TABLE_ALIAS_NAME, pcId,
					QueSiteDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUESITETP_OP,
					QueSiteDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
			QueSiteDO[] queSites = queRService.find(whereStr, null,FBoolean.FALSE);
			if (!EnValidator.isEmpty(queSites)) {
				return queSites[0];
			}
		}
		return null;
	}
}
