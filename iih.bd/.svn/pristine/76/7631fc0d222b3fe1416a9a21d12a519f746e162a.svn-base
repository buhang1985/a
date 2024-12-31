package iih.bd.res.workstation.s.bp;

import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 终端注册业务逻辑
 * 
 * @author hao_wu
 *
 */
public class HostRegBp {

	/**
	 * 终端注册
	 * 
	 * @param hostId
	 *            主机id
	 * @param hostName
	 *            主机名称
	 * @param ip_Addr
	 *            ip地址
	 * @param desc
	 *            备注
	 * @param osName
	 *            系统名称
	 * @param memInfo
	 *            内存信息
	 * @return
	 * @throws BizException
	 */
	public boolean exec(String hostId, String hostName, String ip_Addr, String desc, String osName, String memInfo,
			String macAddr) throws BizException {
		WorkStationPcDO workStationPcDO = CreateNewWorkStationPc(hostId, hostName, ip_Addr, desc, osName, memInfo,
				macAddr);

		IWorkstationCudService workstationCudService = ServiceFinder.find(IWorkstationCudService.class);
		WorkStationPcDO[] result = workstationCudService.insert(new WorkStationPcDO[] { workStationPcDO });
		return result != null && result.length == 1;
	}

	/**
	 * 创建工作站数据
	 * 
	 * @param hostId
	 *            主机id
	 * @param hostName
	 *            主机名称
	 * @param ip_Addr
	 *            ip地址
	 * @param desc
	 *            备注
	 * @param osName
	 *            系统名称
	 * @param memInfo
	 *            内存信息
	 * @return
	 */
	private WorkStationPcDO CreateNewWorkStationPc(String hostId, String hostName, String ip_Addr, String desc,
			String osName, String memInfo, String macAddr) {
		WorkStationPcDO workStationPcDO = new WorkStationPcDO();

		workStationPcDO.setId_grp(Context.get().getGroupId());
		workStationPcDO.setId_org(Context.get().getOrgId());
		workStationPcDO.setPcid(hostId);
		workStationPcDO.setName(hostName);
		workStationPcDO.setIp_addr(ip_Addr);
		workStationPcDO.setDes(desc);
		workStationPcDO.setOsname(osName);
		workStationPcDO.setMeminfo(memInfo);
		workStationPcDO.setId_dep_belong("none");
		workStationPcDO.setFg_active(FBoolean.TRUE);
		workStationPcDO.setMacaddr(macAddr);
		return workStationPcDO;
	}
}
