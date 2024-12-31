package iih.ci.ord.orsms.d;

import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床检验医嘱数据信息
 * 检验医嘱打印合单时使用内部仅包含
 * CiOrderDO和OrdApLabDO数据
 */
public class CiLisOrInfo4Sms {
	
	private CiOrderDO ordo;
	private OrdApLabDO orlisapdo;
	// 特殊病标识，如果ci_or_srv中有一项时特殊病标识为TRUE， 该值为TRUE
	private FBoolean fg_specill = FBoolean.FALSE;
	
	// 是否为科研项目
	private FBoolean fg_research = FBoolean.FALSE;
	// 科研项目id
	private String id_researchproject;
	// 科研项目编码
	private String code_researchproject;
	// 科研项目名称
	private String name_researchproject;
	
	public CiOrderDO getOrdo() {
		return ordo;
	}
	public void setOrdo(CiOrderDO ordo) {
		this.ordo = ordo;
	}
	public OrdApLabDO getOrlisapdo() {
		return orlisapdo;
	}
	public void setOrlisapdo(OrdApLabDO orlisapdo) {
		this.orlisapdo = orlisapdo;
	}
	/**
	 * 特殊病标识
	 * @return
	 */
	public FBoolean getFg_specill() {
		return fg_specill;
	}
	/**
	 * 特殊病标识
	 * @param fg_specill
	 */
	public void setFg_specill(FBoolean fg_specill) {
		this.fg_specill = fg_specill;
	}
	/**
	 * 是否为科研项目
	 * @return
	 */
	public FBoolean getFg_research() {
		return fg_research;
	}
	/**
	 * 是否为科研项目
	 * @param fg_research
	 */
	public void setFg_research(FBoolean fg_research) {
		this.fg_research = fg_research;
	}
	/**
	 * 科研项目ID
	 * @return
	 */
	public String getId_researchproject() {
		return id_researchproject;
	}
	/** 
	 * 设置科研id
	 * @param id_researchproject 科研项目ID
	 */
	public void setId_researchproject(String id_researchproject) {
		this.id_researchproject = id_researchproject;
	}	
	/**
	 * 科研项目名称
	 * @return
	 */
	public String getName_researchproject() {
		return name_researchproject;
	}
	/**
	 * 科研项目名称
	 * @param name_researchproject
	 */
	public void setName_researchproject(String name_researchproject) {
		this.name_researchproject = name_researchproject;
	}
}
