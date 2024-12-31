package iih.bd.utils;

import java.util.ArrayList;
import java.util.HashMap;

import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 上下文帮助类
 * 
 * @author yankan
 *
 */
public class ContextUtils {
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
		PsnDocDO psnDoc = null;
		IPsndocMDORService psndocService = ServiceFinder.find(IPsndocMDORService.class);
		String psnId = getPsnId();
		if (!StringUtil.isEmpty(psnId)) {
			psnDoc = psndocService.findById(psnId);
		}
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
		IWorkstationRService pcRService = ServiceFinder.find(IWorkstationRService.class);
		String whereStr = String.format("PCID='%s'", Context.get().getClientHost());
		WorkStationPcDO[] pcDOs = pcRService.find(whereStr, null, FBoolean.TRUE);
		if (ArrayUtil.isEmpty(pcDOs)) {
			return null;
		}
		return pcDOs[0].getId_pc();
	}

	/**
	 * 使用人员主键初始化上下文
	 * 
	 * @param psnId 人员主键
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static void initContextByPsnId(String psnId) throws BizException {

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT psndoc.id_psndoc,");
		sqlBuilder.append("sysuser.id_user,");
		sqlBuilder.append("psndoc.id_group as id_grp,");
		sqlBuilder.append("psndoc.id_org ");
		sqlBuilder.append("FROM bd_psndoc psndoc ");
		sqlBuilder.append("LEFT JOIN sys_user sysuser ");
		sqlBuilder.append("ON sysuser.id_psn = psndoc.id_psndoc ");
		sqlBuilder.append("WHERE psndoc.id_psndoc = ?");

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(psnId);

		DAFacade daFacade = new DAFacade();
		ArrayList<HashMap<String, Object>> table = (ArrayList<HashMap<String, Object>>) daFacade
				.execQuery(sqlBuilder.toString(), sqlParam, new MapListHandler());

		if (table == null || table.size() <= 0) {
			throw new BizException("根据人员主键获取人员信息失败。");
		}

		if (table.size() > 1) {
			throw new BizException("根据人员主键获取到多个人员信息。");
		}

		HashMap<String, Object> firstRow = table.get(0);
		Context.get().setStuffId((String) firstRow.get("id_psndoc"));

		Context.get().setGroupId((String) firstRow.get("id_grp"));
		Context.get().setOrgId((String) firstRow.get("id_org"));

		if (firstRow.containsKey("id_user")) {
			Context.get().setUserId((String) firstRow.get("id_user"));
		}
	}
}
