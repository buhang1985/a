package iih.mbh.mp.queryexe.d;

import java.util.List;

import iih.mbh.mp.entlv.d.EntLvUdidocDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class QueryExeCondtionDTO {

	// 用药途径
	@RPCField(id = 2)
	private List<EntLvUdidocDTO> routes;
	// 状态
	@RPCField(id = 3)
	private List<EntLvUdidocDTO> status;
	// 长期临时选择
	@RPCField(id = 4)
	private List<EntLvUdidocDTO> longFlag;	
	// 开始时间
	@RPCField(id = 5)
	private String startTime;
	// 结束时间
	@RPCField(id = 6)
	private String endTime;
	// 就诊id
	@RPCField(id = 7)
	private String id_ent;
	// 服务类型
	@RPCField(id = 8)
	private List<EntLvUdidocDTO> srvtps;

	public List<EntLvUdidocDTO> getRoutes() {
		return routes;
	}

	public void setRoutes(List<EntLvUdidocDTO> routes) {
		this.routes = routes;
	}

	public List<EntLvUdidocDTO> getStatus() {
		return status;
	}

	public void setStatus(List<EntLvUdidocDTO> status) {
		this.status = status;
	}

	public List<EntLvUdidocDTO> getLongFlag() {
		return longFlag;
	}

	public void setLongFlag(List<EntLvUdidocDTO> longFlag) {
		this.longFlag = longFlag;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public List<EntLvUdidocDTO> getSrvtps() {
		return srvtps;
	}

	public void setSrvtps(List<EntLvUdidocDTO> srvtps) {
		this.srvtps = srvtps;
	}

}
