package iih.bd.srv.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDORService;
import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import iih.bd.srv.mrtplvt.i.IMrtplvtMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.dataper.i.IDataperExtQry;
import xap.sys.permfw.dataper.d.DataPerRuleDO;

public class getMrtplVtListBp {

	private final String SHEETCODE = "47304020";// 生命体征模板维护节点编号
	private IDataperExtQry iDataQry = ServiceFinder.find(IDataperExtQry.class);

	/**
	 * 获取生命体征模板
	 * 
	 * @return
	 * @throws BizException
	 */
	public MrtplVtDO[] exec() throws BizException {

		// 1、获取权限
		List<DataPerRuleDO> listPermission = getPermissionData();

		// 2、获取权限Sql串
		String whereStr = getWhereStr(listPermission);

		// 3、获取全部权限之内的医疗记录模板Key
		String[] mrtplKeys = getMrtplKey(whereStr);

		// 4、获取体征模板
		MrtplVtDO[] rtns = getMrtplVt(mrtplKeys);

		return rtns;
	}

	/**
	 * 获取权限
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<DataPerRuleDO> getPermissionData() throws BizException {

		List<DataPerRuleDO> reList = new ArrayList<DataPerRuleDO>();

		// 用户权限
		List<DataPerRuleDO> listUserDataperRule = iDataQry.getSysDataperRuleByUser(Context.get().getUserId(), SHEETCODE);
		if (listUserDataperRule != null && listUserDataperRule.size() > 0) {

			reList.addAll(listUserDataperRule);
		}

		// 角色权限
		List<DataPerRuleDO> listUserRoleDataperRule = iDataQry.getSysDataperRuleByUserRole(Context.get().getUserId(), SHEETCODE);
		if (listUserRoleDataperRule != null && listUserRoleDataperRule.size() > 0) {

			reList.addAll(listUserRoleDataperRule);
		}

		return reList;
	}

	/**
	 * 获取权限Sql串
	 * 
	 * @param listPermission
	 * @return
	 * @throws BizException
	 */
	private String getWhereStr(List<DataPerRuleDO> listPermission) throws BizException {

		String whereStr = "";

		List<String> listCode = new ArrayList<String>();

		if (listPermission != null && listPermission.size() > 0) {

			for (DataPerRuleDO permission : listPermission) {

				if (listCode.contains(permission.getCode())) {
					continue;
				}
				listCode.add(permission.getCode());

				String str = iDataQry.getwhere(permission);

				if (!StringUtil.isEmpty(str)) {

					String conStr = String.format(str, Context.get().getDeptId());

					whereStr += ((whereStr.length() == 0 ? "" : " or ") + "(" + conStr + ")");
				}
			}
		}

		if (listCode.size() > 0) {
			if (listCode.size() == 1) {
				return " and " + whereStr;
			} else {
				return " and (" + whereStr + ")";
			}
		}

		return whereStr;
	}

	/**
	 * 获取全部权限之内的医疗记录模板Key
	 * 
	 * @param whereStr
	 * @return
	 * @throws BizException
	 */
	private String[] getMrtplKey(String whereStr) throws BizException {

		List<String> reList = new ArrayList<String>();

		IEmrtplMDORService findService = ServiceFinder.find(IEmrtplMDORService.class);

		EmrTplDO[] mrtplDOS = findService.find(" id_mrtpl in(select id_mrtpl from bd_mrtpl_vt where ds=0) " + whereStr, "", FBoolean.FALSE);

		if (mrtplDOS != null && mrtplDOS.length > 0) {

			for (EmrTplDO emrTplDO : mrtplDOS) {

				reList.add(emrTplDO.getId_mrtpl());
			}
		}

		return reList.toArray(new String[reList.size()]);
	}

	/**
	 * 获取体征模板
	 * 
	 * @param mrtplKeys
	 * @return
	 * @throws BizException
	 */
	private MrtplVtDO[] getMrtplVt(String[] mrtplKeys) throws BizException {

		String whereStr = " 1=2";
		IMrtplvtMDORService findService = ServiceFinder.find(IMrtplvtMDORService.class);

		if (mrtplKeys != null && mrtplKeys.length > 0) {

			whereStr = "";

			for (String id_mrtpl : mrtplKeys) {

				whereStr += ((whereStr.length() == 0 ? "" : ",") + "'" + id_mrtpl + "'");
			}

			whereStr = " id_mrtpl in(" + whereStr + ")";
		}

		return findService.find(whereStr, "code", FBoolean.FALSE);
	}
}
