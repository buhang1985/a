package iih.en.utils;

import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

/**
 * 上下文帮助类
 * 
 * @author liubin
 *
 */
public class EnContextUtils {
	/**
	 * 获取集团id
	 * 
	 * @return
	 */
	public static String getGrpId() {
		return Context.get().getGroupId();
	}

	/**
	 * 获取组织id
	 * 
	 * @return
	 */
	public static String getOrgId() {
		return Context.get().getOrgId();
	}

	/**
	 * 获取部门id
	 * 
	 * @return
	 */
	public static String getDeptId() {
		return Context.get().getDeptId();
	}

	/**
	 * 获取当前人员信息
	 * 
	 * @return
	 */
	public static PsnDocDO getPsnDoc() throws BizException {
		String psnId = getPsnId();
		if(StringUtil.isEmptyWithTrim(psnId))
			return null;
		String key = IEnFlowKeyConst.EN_FLOW_CTX_KEY + psnId;
		Object value = getCtxAttribute(key);
		if(value != null){
			return (PsnDocDO)value;
		}
		IPsndocMDORService psndocService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO psnDoc = psndocService.findById(psnId);
		if(psnDoc == null)
			return null;
		setCtxAttribute(key, psnDoc);
		return psnDoc;
	}

	/**
	 * 获取psnId
	 * 
	 * @return
	 */
	public static String getPsnId() {
		return Context.get().getStuffId();
	}

	/**
	 * 获取用户id
	 * 
	 * @return
	 */
	public static String getUserId() {
		return Context.get().getUserId();
	}

	/**
	 * 获取客户端的PCID
	 * 
	 * @return
	 */
	public static String getPcId() {
		return Context.get().getClientHost();
	}

	/**
	 * 获取PC的真实ID
	 * 
	 * @return
	 */
	public static String getRealPcId() throws BizException {
		String key = IEnFlowKeyConst.EN_FLOW_CTX_KEY + getPcId();
		Object value = getCtxAttribute(key);
		if(value != null) {
			return (String)value;
		}
		IWorkstationRService serv = ServiceFinder.find(IWorkstationRService.class);
		WorkStationPcDO[] pcDOs = serv.findByAttrValString(WorkStationPcDO.PCID, getPcId());
		if (ArrayUtil.isEmpty(pcDOs)) {
			return null;
		}
		String id_pc = pcDOs[0].getId_pc();
		setCtxAttribute(key, id_pc);
		return id_pc;
	}
	
	/**
	 * 设置上下文信息
	 * 
	 * @param key
	 * @param value
	 */
	public static void setCtxAttribute(String key, Object value){
		Context.get().setAttribute(key, value);
	}
	
	/**
	 * 获取上下文信息
	 * 
	 * @param key
	 * @return
	 */
	public static Object getCtxAttribute(String key){
		try{
			return Context.get().getAttribute(key);
		}catch(Exception e){
			return null;
		}
	}
}
