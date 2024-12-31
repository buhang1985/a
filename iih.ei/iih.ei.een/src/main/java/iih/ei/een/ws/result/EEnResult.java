package iih.ei.een.ws.result;

import iih.bd.webservice.BaseWsResult;
import iih.ei.een.ws.bean.GetDepListBean;
import iih.ei.een.ws.bean.GetEmpListBean;
import iih.ei.een.ws.bean.GetOpQueListBean;
import iih.ei.een.ws.bean.GetPatInfoBean;
import iih.ei.sc.ws.bean.GetAptApplyBean;
import iih.ei.sc.ws.bean.GetAptNoteRptBean;
import iih.ei.sc.ws.bean.GetAptPhotoUrlBean;
import iih.ei.sc.ws.bean.GetBrokenAptListBean;
import iih.ei.sc.ws.bean.GetMtScCaListBean;
import iih.ei.sc.ws.bean.GetMtScDbSrvListBean;
import iih.ei.sc.ws.bean.GetPatAptListBean;
import iih.ei.sc.ws.bean.GetScTicks4ApplyBean;
import iih.ei.sc.ws.bean.GetSchListBean;
import iih.ei.sc.ws.bean.GetStopSchListBean;
import iih.ei.sc.ws.bean.GetUnaptApplyBean;
import iih.ei.sc.ws.bean.GetValidPeriodBean;
import iih.ei.sc.ws.bean.IsSelfAptableBean;
import iih.ei.sc.ws.bean.IsSelfCancableBean;
import iih.ei.sc.ws.bean.ReturnScAptNonOrdBean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ GetDepListBean.class,
				GetEmpListBean.class,
				GetOpQueListBean.class,
				GetPatInfoBean.class,
				GetMtScCaListBean.class,
				GetMtScDbSrvListBean.class,
				GetPatAptListBean.class,
				GetSchListBean.class,
				GetBrokenAptListBean.class,
				GetStopSchListBean.class,
				GetAptNoteRptBean.class,
				ReturnScAptNonOrdBean.class,
				GetAptPhotoUrlBean.class,
				GetValidPeriodBean.class,
				IsSelfAptableBean.class,
				IsSelfCancableBean.class,
				GetUnaptApplyBean.class,
				GetScTicks4ApplyBean.class,
				ReturnScAptNonOrdBean.class,
				GetAptApplyBean.class})
public class EEnResult<T> extends BaseWsResult implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAnyElement(lax = true)
	private T[] data;

	public T[] getData() {
		return data;
	}

	public void setData(T[] data) {
		this.data = data;
	}
}
