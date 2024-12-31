package iih.pis.ivx.account.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement(name = "results")
	@XmlAccessorType(XmlAccessType.FIELD)
	public class PayInfoResultList implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@XmlElement(name = "resultmsg")
		private WsResultMsg msg;
		@XmlElement(name = "resultinfo")
		private PayInfoResult rltInfo;
		public WsResultMsg getMsg() {
			return msg;
		}
		public void setMsg(WsResultMsg msg) {
			this.msg = msg;
		}
		public PayInfoResult getRltInfo() {
			return rltInfo;
		}
		public void setRltInfo(PayInfoResult rltInfo) {
			this.rltInfo = rltInfo;
		}

	}