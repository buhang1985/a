package iih.pis.cqs.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 查询显示屏站点记录-
 * @author li.wm
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetEnBrdSiteResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 大屏站点信息
	 */
	private EnBrdSiteInfoDTO[] enBrdSiteInfoDTOs;
	public EnBrdSiteInfoDTO[] getEnBrdSiteInfoDTOs() {
		return enBrdSiteInfoDTOs;
	}
	public void setEnBrdSiteInfoDTOs(EnBrdSiteInfoDTO[] enBrdSiteInfoDTOs) {
		this.enBrdSiteInfoDTOs = enBrdSiteInfoDTOs;
	}

}
