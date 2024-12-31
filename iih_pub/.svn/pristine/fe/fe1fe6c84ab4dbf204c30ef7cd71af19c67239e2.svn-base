package iih.en.pv.appoint.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import iih.bd.webservice.BaseWsResult;

/***
 * 
 * 
 * @author zhangpp
 *
 * @param <T>
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ SchListResult.class, ChlSchStatsResult.class, OpStopSchListResult.class,OpAptListResult.class, 
	BrokenAptListResult.class, WaitQueResult.class, PatOpAptListResult.class, PatOpEntListResult.class, 
	PatOpAptAndEntListResult.class, OpAptListByAgentPatCodeResult.class, PaidAptDetailResult.class,
	AptIdByAptCodeResult.class, EnPatCaInfoResult.class, SchTickInfoResult.class,EntListByPatcodeResult.class,
	VisitTimesStatResult.class, OEPDepListResult.class, OEPEmpDepMatchResult.class, EntArriveResult.class, 
	EntLisByQuebencodeResult.class, AptNewResult.class, MessageResult.class, EntListByDeptCodeResult.class })
public class AppointResultBean<T> extends BaseWsResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResultDatasBean<T> datas;

	public ResultDatasBean<T> getDatas() {
		return datas;
	}

	public void setDatas(ResultDatasBean<T> datas) {
		this.datas = datas;
	}
	
}
