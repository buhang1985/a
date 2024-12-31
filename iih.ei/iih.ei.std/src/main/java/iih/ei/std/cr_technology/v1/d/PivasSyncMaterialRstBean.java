package iih.ei.std.cr_technology.v1.d;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bd.webservice.BaseWsResult;

/**
 * Pivas同步药品目录结果Bean
 * 
 * @author hao_wu 2018-6-15
 *
 */
public class PivasSyncMaterialRstBean extends BaseWsResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name = "body")
	@XmlElement(name = "drug")
	private PivasSyncMaterialRstBeanInfo[] pivasBeans;

	public PivasSyncMaterialRstBeanInfo[] getPivasBeans() {
		return pivasBeans;
	}

	public void setPivasBeans(PivasSyncMaterialRstBeanInfo[] pivasBeans) {
		this.pivasBeans = pivasBeans;
	}
}
