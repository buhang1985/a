package iih.ci.rcm.hospitalsenmonitordto.i;

import iih.ci.rcm.hospitalsenmonitordto.d.HospitalSenMonitorDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IHospitalSenMonitor {
	
	public abstract PagingRtnData<HospitalSenMonitorDTO> getHospitalSenMonitorList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;

	 void sendHosReminderMsg(HospitalSenMonitorDTO senMonitorDto) throws BizException;
}
