package iih.sc.comm;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.runtime.config.ConfigManager;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

/**
 * 上下文帮助类
 * @author yankan
 *
 */
public class ScContextUtils {
	/**
	 * 获取集团id
	 * @return
	 */
	public static String getGrpId(){
		return Context.get().getGroupId();
	}
	/**
	 * 获取组织id
	 * @return
	 */
	public static String getOrgId(){
		return Context.get().getOrgId();
	}
	/**
	 * 获取部门id
	 * @return
	 */
	public static String getDeptId(){
		return Context.get().getDeptId();
	}
	/**
	 * 获取当前人员信息
	 * @return
	 */
	public static PsnDocDO getPsnDoc(){
		PsnDocDO psnDoc = null;	
		IPsndocMDORService psndocService = ServiceFinder.find(IPsndocMDORService.class);
		try {
			String psnId = getPsnId();
			if(StringUtils.isNotEmpty(psnId)){				
				psnDoc = psndocService.findById(psnId);
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return psnDoc;
	}
	/**
	 * 获取psnId
	 * @return
	 */
	public static String getPsnId(){		
		return Context.get().getStuffId();
	}
	/**
	 * 获取用户id
	 * @return
	 */
	public static String getUserId(){
		return Context.get().getUserId();
	}
	/**
	 * 获取客户端的PCID
	 * @return
	 */
	public static String getPcId(){
		return Context.get().getClientHost();
	}
	/**
	 * 获取PC的真实ID
	 * @return
	 */
	public static String getRealPcId() throws BizException{
		IWorkstationRService pcRService = ServiceFinder.find(IWorkstationRService.class);
		String whereStr =String.format("PCID='%s'",Context.get().getClientHost());
		WorkStationPcDO[] pcDOs = pcRService.find(whereStr, null, FBoolean.TRUE);
		if(ArrayUtil.isEmpty(pcDOs)){
			return null;
		}
		return pcDOs[0].getId_pc();	
	}
	
	/**
	 * 从中间件获取报表服务器地址
	 * @return
	 * @throws BizException
	 */
	public static String getReportUrlPath()throws BizException{
		return ConfigManager.INSTANCE.getSystemConfig().getItemAsString(IScDictCodeConst.REPORT_KEY);
	}
}
