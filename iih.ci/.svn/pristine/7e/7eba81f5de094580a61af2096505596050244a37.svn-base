package iih.ci.ord.s.ems.utils.meta;

import java.util.List;

import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 检验医嘱内容拼接的DTO
 * 
 * @author zwq
 *
 */
public class LisOrContentParam extends BaseOrContentParam {

	private static final long serialVersionUID = 1L;

	public LisOrContentParam(String sd_srvtp, FBoolean fg_urgent, String name_samptp, String note,
			List<OrContentDTO> list) {
		this.setSd_srvtp(sd_srvtp);
		this.setFg_urgent(fg_urgent);
		this.setName_samptp(name_samptp);
		this.setNote(note);
		String[] name_srvs = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			OrContentDTO obslap = list.get(i);
			name_srvs[i] = obslap.getName_srv();
		}
		this.setName_srvs(name_srvs);
		
	}
	public LisOrContentParam(String id_or_old,String sd_srvtp,String name_srv , FBoolean fg_urgent, String name_samptp, String note,FBoolean fg_set,
			List<OrContentDTO> list) {
		this.setSd_srvtp(sd_srvtp);
		this.setFg_urgent(fg_urgent);
		this.setName_samptp(name_samptp);
		this.setNote(note);
		String[] name_srvs = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			OrContentDTO obslap = list.get(i);
			name_srvs[i] = obslap.getName_srv();
		}
		this.setName_srvs(name_srvs);
		this.setName_srv(name_srv);
		this.setId_or_old(id_or_old);
		this.setFg_set(fg_set);
	}
	public LisOrContentParam(OrdApLabDO ordApLabDO,CiOrderDO ciOrderDO,UdidocDO udidocDO,List<OrContentDTO> list) {
		OrdSrvDO[] ordSrvDOs = new OrdSrvDO[list.size()];
		OrdSrvMmDO[] ordSrvMmDOs = new OrdSrvMmDO[list.size()];
		for (int i = 0; i < list.size(); i++) {
			OrContentDTO drug = list.get(i);
			ordSrvDOs[i] = drug.getOrdSrvDo();//ci_or_srv数组 该数组与List<OrContentDTO> drugs个数保持一致
			ordSrvMmDOs[i] = drug.getSrvmmdo();//OrdSrvMmDO数组 该数组与List<OrContentDTO> drugs个数保持一致
		}
		this.setCi_or_srvs(ordSrvDOs);
		this.setOrdSrvMMs(ordSrvMmDOs);
		this.setOrdApLabDO(ordApLabDO);
		this.setCiOrderDO(ciOrderDO);
		this.setUdidocDO(udidocDO);
	}
	private OrdApLabDO ordApLabDO;
	private CiOrderDO ciOrderDO;
	private UdidocDO udidocDO;
	/**
	 *ci_or_srv数组 该数组与List<OrContentDTO> drugs个数保持一致
	 */
	private OrdSrvDO[] Ci_or_srvs; 
	/**
	 * ordSrvMMs数组 该数组与List<OrContentDTO> drugs个数保持一致
	 */
	private OrdSrvMmDO[] ordSrvMMs;
	/**
	 * 服务套
	 */
	private FBoolean Fg_set;
	
	public FBoolean getFg_set() {
		return Fg_set;
	}
	public void setFg_set(FBoolean fg_set) {
		Fg_set = fg_set;
	}
	/**
	 * 复制的id_or
	 */
	private String Id_or_old;
	
	public String getId_or_old() {
		return Id_or_old;
	}
	public void setId_or_old(String id_or_old) {
		Id_or_old = id_or_old;
	}
	/**
	 * 医嘱名
	 */
	private String Name_srv;
	

	public String getName_srv() {
		return Name_srv;
	}

	public void setName_srv(String name_srv) {
		Name_srv = name_srv;
	}

	/**
	 * 加急标识
	 * 
	 * @return
	 */
	private FBoolean Fg_urgent;

	/**
	 * 标本sd
	 * 
	 * @return
	 */
	private String Sd_samptp;

	/**
	 * 标本名称
	 * 
	 * @return
	 */
	private String Name_samptp;

	public FBoolean getFg_urgent() {
		return Fg_urgent;
	}

	public void setFg_urgent(FBoolean fg_urgent) {
		Fg_urgent = fg_urgent;
	}

	public String getSd_samptp() {
		return Sd_samptp;
	}

	public void setSd_samptp(String sd_samptp) {
		Sd_samptp = sd_samptp;
	}

	public String getName_samptp() {
		return Name_samptp;
	}

	public void setName_samptp(String name_samptp) {
		Name_samptp = name_samptp;
	}
	public OrdApLabDO getOrdApLabDO() {
		return ordApLabDO;
	}
	public void setOrdApLabDO(OrdApLabDO ordApLabDO) {
		this.ordApLabDO = ordApLabDO;
	}
	public CiOrderDO getCiOrderDO() {
		return ciOrderDO;
	}
	public void setCiOrderDO(CiOrderDO ciOrderDO) {
		this.ciOrderDO = ciOrderDO;
	}
	public void setCi_or_srvs(OrdSrvDO[] Ci_or_srvs) {
		this.Ci_or_srvs = Ci_or_srvs;
	}

	public OrdSrvDO[] getCi_or_srvs() {
		return Ci_or_srvs;
	}

	public OrdSrvMmDO[] getOrdSrvMMs() {
		return ordSrvMMs;
	}

	public void setOrdSrvMMs(OrdSrvMmDO[] ordSrvMMs) {
		this.ordSrvMMs = ordSrvMMs;
	}
	public UdidocDO getUdidocDO() {
		return udidocDO;
	}
	public void setUdidocDO(UdidocDO udidocDO) {
		this.udidocDO = udidocDO;
	}

}
