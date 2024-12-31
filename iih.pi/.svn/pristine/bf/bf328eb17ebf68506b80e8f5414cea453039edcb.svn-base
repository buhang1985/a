package iih.pi.reg.s.ws;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.dto.d.PiPat4IpDTO;
import iih.pi.reg.dto.d.PiPatBS501CondDTO;
import iih.pi.reg.dto.d.PiPatBS520CondDTO;
import iih.pi.reg.dto.d.PiPatWSResultDTO;
import xap.ip.client.FuncClient;
import xap.ip.client.FuncClientFactory;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * Empi webservice调用类
 * 
 * @author ly
 *
 */
public class EmpiServiceCaller {

	/**
	 * 患者基本信息查询服务
	 * 
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PiPatWSResultDTO[] callBS501Service(PiPatBS501CondDTO cond) {

		PiPatWSResultDTO[] result = null;
		try {
			FuncClientFactory clientFactory = ServiceFinder.find(FuncClientFactory.class);
			FuncClient client = clientFactory.createClientByDomain("BS501", IPiDictCodeConst.DOMAIN_ID_MZ);
			cond.setDomain_id(null);
			FArrayList2 list = (FArrayList2) client.invoke(this.formatCond(cond));
			if (list == null || list.size() == 0)
				return null;

			result = (PiPatWSResultDTO[]) list.toArray(new PiPatWSResultDTO[list.size()]);

		} catch (Exception e) {
			// 独立日志 TODO
			Logger.error(e);
		}
		return result;
	}

	/**
	 * 患者新建服务
	 * 
	 * @param cond
	 * @return
	 */
	public void callBS504Service(PiPat4IpDTO patDto) {

		try {
			FuncClientFactory clientFactory = ServiceFinder.find(FuncClientFactory.class);
			FuncClient client = clientFactory.createClientByDomain("BS504", IPiDictCodeConst.DOMAIN_ID_MZ);
			client.invoke(patDto);
		} catch (Exception e) {
			// 独立日志 TODO
			Logger.error(e);
		}
	}

	/**
	 * 患者更新服务
	 * 
	 * @param cond
	 * @return
	 */
	public void callBS505Service(PiPat4IpDTO patDto) {
		try {
			FuncClientFactory clientFactory = ServiceFinder.find(FuncClientFactory.class);
			FuncClient client = clientFactory.createClientByDomain("BS505", IPiDictCodeConst.DOMAIN_ID_MZ);
			client.invoke(patDto);
		} catch (Exception e) {
			// 独立日志 TODO
			Logger.error(e);
		}
	}

	/**
	 * HIS专用患者基本信息查询服务
	 * 
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PiPatWSResultDTO[] callBS520Service(PiPatBS520CondDTO cond) {
		PiPatWSResultDTO[] result = null;
		try {
			FuncClientFactory clientFactory = ServiceFinder.find(FuncClientFactory.class);
			FuncClient client = clientFactory.createClientByDomain("BS520", IPiDictCodeConst.DOMAIN_ID_MZ);
			FArrayList2 list = (FArrayList2) client.invoke(this.formatCond(cond));

			if (list == null || list.size() == 0)
				return null;

			result = (PiPatWSResultDTO[]) list.toArray(new PiPatWSResultDTO[list.size()]);
		} catch (Exception e) {
			// 独立日志 TODO
			Logger.error(e);
		}
		return result;
	}

	/**
	 * 格式化条件BS501
	 */
	private PiPatBS501CondDTO formatCond(PiPatBS501CondDTO cond) {
		// 格式化日期
		cond.setBirthday(this.formatDateTime(cond.getBirthday()));
		return cond;
	}

	/**
	 * 格式化BS504,BS505入参
	 */
	@SuppressWarnings("unused")
	private PiPat4IpDTO formatCond(PiPat4IpDTO cond) {
		// 格式化日期
		cond.setBirthday(this.formatDateTime(cond.getBirthday()));
		return cond;
	}

	/**
	 * 格式化条件BS520
	 */
	private PiPatBS520CondDTO formatCond(PiPatBS520CondDTO cond) {
		// 格式化日期
		cond.setBirthday(this.formatDateTime(cond.getBirthday()));
		return cond;
	}

	/**
	 * 格式化时间
	 * 
	 * @param datetime
	 * @return
	 */
	private String formatDateTime(String datetime) {

		if (StringUtil.isEmptyWithTrim(datetime)) {
			return "";
		}

		String str = datetime.replace("/", "").replace("-", "").replace(":", "").replace(" ", "");

		int dif = 14 - str.length();
		while (dif > 0) {
			str += "0";
			dif--;
		}

		return str;
	}
}
