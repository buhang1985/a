package iih.ci.ord.s.ems.utils.meta;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 用于西成药医嘱内容拼接的DTO
 * 
 * @author zwq
 *
 */
public class DrugOrContentParam extends BaseOrContentParam {

	private static final long serialVersionUID = 1L;

	public DrugOrContentParam(String sd_srvtp, String name_freq, Integer use_days, String name_route, String note_or,
			List<OrContentDTO> drugs) {
		super(sd_srvtp, note_or, drugs);
		boolean[] fg_selfs = new boolean[drugs.size()];
		FBoolean[] fg_highrisks = new FBoolean[drugs.size()];
		String[] name_dep_wh = new String[drugs.size()];
		String[] id_pgku_cur = new String[drugs.size()];
		OrdSrvDO[] ordSrvDOs = new OrdSrvDO[drugs.size()];
		OrdSrvMmDO[] ordSrvMmDOs = new OrdSrvMmDO[drugs.size()];
		for (int i = 0; i < drugs.size(); i++) {
			OrContentDTO drug = drugs.get(i);
			fg_selfs[i] = drug.isFg_self();
			fg_highrisks[i] = drug.getFg_highrisk();
			name_dep_wh[i] = drug.getName_dep_wh();
			id_pgku_cur[i]=drug.getId_pgku_cur();
			ordSrvDOs[i] = drug.getOrdSrvDo();//ci_or_srv数组 该数组与List<OrContentDTO> drugs个数保持一致
			ordSrvMmDOs[i] = drug.getSrvmmdo();//OrdSrvMmDO数组 该数组与List<OrContentDTO> drugs个数保持一致
		}
		this.setId_pgku_cur(id_pgku_cur);
		this.setName_freq(name_freq);
		this.setName_route(name_route);
		this.setFg_selfs(fg_selfs);
		this.setUse_days(use_days);
		this.setFg_highrisks(fg_highrisks);
		this.setName_dep_wh(name_dep_wh);
		this.setCi_or_srvs(ordSrvDOs);
		this.setOrdSrvMMs(ordSrvMmDOs);
	}

	public DrugOrContentParam(String sd_srvtp, String name_freq, Integer use_days, String name_route, String note_or,
			FBoolean fg_pres_out, FBoolean fg_wholepack, List<OrContentDTO> drugs) {
		super(sd_srvtp, note_or, drugs);
		boolean[] fg_selfs = new boolean[drugs.size()];
		FBoolean[] fg_highrisks = new FBoolean[drugs.size()];
		String[] name_dep_wh = new String[drugs.size()];
		String[] id_pgku_cur = new String[drugs.size()];
		OrdSrvDO[] ordSrvDOs = new OrdSrvDO[drugs.size()];
		OrdSrvMmDO[] ordSrvMmDOs = new OrdSrvMmDO[drugs.size()];
		for (int i = 0; i < drugs.size(); i++) {
			OrContentDTO drug = drugs.get(i);
			fg_selfs[i] = drug.isFg_self();
			fg_highrisks[i] = drug.getFg_highrisk();
			name_dep_wh[i] = drug.getName_dep_wh();
			id_pgku_cur[i]=drug.getId_pgku_cur();
			ordSrvDOs[i] = drug.getOrdSrvDo();//ci_or_srv数组 该数组与List<OrContentDTO> drugs个数保持一致
			ordSrvMmDOs[i] = drug.getSrvmmdo();//OrdSrvMmDO数组 该数组与List<OrContentDTO> drugs个数保持一致
		}
		this.setId_pgku_cur(id_pgku_cur);
		this.setName_freq(name_freq);
		this.setName_route(name_route);
		this.setFg_selfs(fg_selfs);
		this.setUse_days(use_days);
		this.setFg_highrisks(fg_highrisks);
		this.setName_dep_wh(name_dep_wh);
		this.setFg_pres_out(fg_pres_out);
		this.setFg_wholepack(fg_wholepack);
		this.setCi_or_srvs(ordSrvDOs);
		this.setOrdSrvMMs(ordSrvMmDOs);
	}

	public DrugOrContentParam(CiorderAggDO aggDO, List<OrContentDTO> drugs) {
		
		super(aggDO.getParentDO().getSd_srvtp(), aggDO.getParentDO().getDes_or(), drugs);
		CiOrderDO ciOrderDO = aggDO.getParentDO();
		boolean[] fg_selfs = new boolean[drugs.size()];
		FBoolean[] fg_highrisks = new FBoolean[drugs.size()];
		String[] name_dep_wh = new String[drugs.size()];
		String[] id_pgku_cur = new String[drugs.size()];
		OrdSrvDO[] ordSrvDOs = new OrdSrvDO[drugs.size()];
		OrdSrvMmDO[] ordSrvMmDOs = new OrdSrvMmDO[drugs.size()];
		for (int i = 0; i < drugs.size(); i++) {
			OrContentDTO drug = drugs.get(i);
			fg_selfs[i] = drug.isFg_self();
			fg_highrisks[i] = drug.getFg_highrisk();
			name_dep_wh[i] = drug.getName_dep_wh();
			id_pgku_cur[i]=drug.getId_pgku_cur();
			ordSrvDOs[i] = drug.getOrdSrvDo();//ci_or_srv数组 该数组与List<OrContentDTO> drugs个数保持一致
			ordSrvMmDOs[i] = drug.getSrvmmdo();//OrdSrvMmDO数组 该数组与List<OrContentDTO> drugs个数保持一致
		}
		this.setCode_entp(ciOrderDO.getCode_entp());
		this.setId_pgku_cur(id_pgku_cur);
		this.setName_freq(ciOrderDO.getFreq_name());
		this.setName_route(ciOrderDO.getRoute_name());
		this.setFg_selfs(fg_selfs);
		this.setUse_days(ciOrderDO.getDays_or());
		this.setFg_highrisks(fg_highrisks);
		this.setName_dep_wh(name_dep_wh);
		this.setFg_pres_out(ciOrderDO.getFg_pres_outp());
		this.setFg_wholepack(ciOrderDO.getFg_wholepack());
		this.setSd_excessive_reason(ciOrderDO.getSd_excessive_reason());
		this.setCiorderAggDO(aggDO);
		this.setCi_or_srvs(ordSrvDOs);
		this.setOrdSrvMMs(ordSrvMmDOs);
	}
	
	private String Code_entp;
	private String[] Id_pgku_cur;
	private FDouble[] Quan_cur;
	
	

	public String[] getId_pgku_cur() {
		return Id_pgku_cur;
	}

	public void setId_pgku_cur(String[] id_pgku_cur) {
		Id_pgku_cur = id_pgku_cur;
	}

	public String getCode_entp() {
		return Code_entp;
	}

	public void setCode_entp(String code_entp) {
		Code_entp = code_entp;
	}

	

	private CiorderAggDO ciorderAggDO;
	
	public CiorderAggDO getCiorderAggDO() {
		return ciorderAggDO;
	}

	public void setCiorderAggDO(CiorderAggDO ciorderAggDO) {
		this.ciorderAggDO = ciorderAggDO;
	}

	/**
	 * 超量开单原因
	 */
	private String Sd_excessive_reason;
	
	public String getSd_excessive_reason() {
		return Sd_excessive_reason;
	}

	public void setSd_excessive_reason(String sd_excessive_reason) {
		Sd_excessive_reason = sd_excessive_reason;
	}

	/**
	 * 出院带药标识
	 */
	private FBoolean Fg_pres_out;
	/**
	 * 在院整领标识
	 */
	private FBoolean Fg_wholepack;
	/**
	 * 药房信息
	 */
	private String[] name_dep_wh;

	public FBoolean getFg_pres_out() {
		return Fg_pres_out;
	}

	public void setFg_pres_out(FBoolean fg_pres_out) {
		Fg_pres_out = fg_pres_out;
	}

	public FBoolean getFg_wholepack() {
		return Fg_wholepack;
	}

	public void setFg_wholepack(FBoolean fg_wholepack) {
		Fg_wholepack = fg_wholepack;
	}

	public String[] getName_dep_wh() {
		return name_dep_wh;
	}

	public void setName_dep_wh(String[] name_dep_wh) {
		this.name_dep_wh = name_dep_wh;
	}

	/**
	 * 用法
	 * 
	 * @return
	 */
	private String Name_route;
	/**
	 * 频次
	 * 
	 * @return
	 */
	private String Name_freq;
	/**
	 * 自备药标识
	 * 
	 * @return
	 */
	private boolean[] Fg_selfs;
	/**
	 * 高危药品标识
	 */
	private FBoolean[] fg_highrisks;
	/**
	 * 药品ids
	 */
	private String[] id_mms;
	/**
	 *ci_or_srv数组 该数组与List<OrContentDTO> drugs个数保持一致
	 */
	private OrdSrvDO[] Ci_or_srvs; 
	/**
	 * ordSrvMMs数组 该数组与List<OrContentDTO> drugs个数保持一致
	 */
	private OrdSrvMmDO[] ordSrvMMs;
	public String getName_route() {
		return Name_route;
	}

	public void setName_route(String name_route) {
		Name_route = name_route;
	}

	public String getName_freq() {
		return Name_freq;
	}

	public void setName_freq(String name_freq) {
		Name_freq = name_freq;
	}

	public boolean[] getFg_selfs() {
		return Fg_selfs;
	}

	public void setFg_selfs(boolean[] fg_selfs) {
		Fg_selfs = fg_selfs;
	}

	public FBoolean[] getFg_highrisks() {
		return fg_highrisks;
	}

	public void setFg_highrisks(FBoolean[] fg_highrisks) {
		this.fg_highrisks = fg_highrisks;
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
	
}
