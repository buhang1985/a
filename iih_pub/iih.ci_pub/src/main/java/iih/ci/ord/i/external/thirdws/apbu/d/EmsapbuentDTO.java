package iih.ci.ord.i.external.thirdws.apbu.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import java.util.List;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;

/**
 * 第三方接口用血门诊dto DTO数据 
 * 
 */
public class EmsapbuentDTO extends EntWsDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱list
	 * @return List<EmsapbuordDTO>
	 */
	public List<EmsapbuordDTO> getOrdlist() {
		return ((List<EmsapbuordDTO>) getAttrVal("Ordlist"));
	}
	/**
	 * 医嘱list
	 * @param Ordlist
	 */
	public void setOrdlist(List<EmsapbuordDTO> Ordlist) {
		setAttrVal("Ordlist", Ordlist);
	}
	/**
	 * 婴儿标识
	 * @return String
	 */
	public String getFg_bb() {
		return ((String) getAttrVal("Fg_bb"));
	}
	/**
	 * 婴儿标识
	 * @param Fg_bb
	 */
	public void setFg_bb(String Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 患者血型编码
	 * @return String
	 */
	public String getSd_bloodtype_pi() {
		return ((String) getAttrVal("Sd_bloodtype_pi"));
	}
	/**
	 * 患者血型编码
	 * @param Sd_bloodtype_pi
	 */
	public void setSd_bloodtype_pi(String Sd_bloodtype_pi) {
		setAttrVal("Sd_bloodtype_pi", Sd_bloodtype_pi);
	}
	/**
	 * 患者Rh(D)编码
	 * @return String
	 */
	public String getSd_rhd_pi() {
		return ((String) getAttrVal("Sd_rhd_pi"));
	}
	/**
	 * 患者Rh(D)编码
	 * @param Sd_rhd_pi
	 */
	public void setSd_rhd_pi(String Sd_rhd_pi) {
		setAttrVal("Sd_rhd_pi", Sd_rhd_pi);
	}
}