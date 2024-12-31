package iih.bd.srv.ems.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.ems.d.EmsPrnTmplDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

/**
 * 医疗打印模板动态参照补全逻辑
 * 
 * @author hao_wu
 *
 */
public class EmsprntmplDynamicBp {

	/**
	 * 补全医疗打印模板DeptName属性
	 * 
	 * @param DataList
	 * @throws BizException
	 */
	public void exec(FArrayList DataList) throws BizException {
		if (DataList == null || DataList.size() <= 0)
			return;

		Map<String, OrgDO> orgMap = GetOrgMap(DataList);
		Map<String, DeptDO> deptMap = GetDeptMap(DataList);

		for (Object obj : DataList) {

			EmsPrnTmplDO emdo = (EmsPrnTmplDO) obj;
			if (StringUtil.isEmptyWithTrim(emdo.getId_dept()))
				continue;
			if (StringUtil.isEmptyWithTrim(emdo.getSd_srvorrt()))
				continue;
			if (IBdSrvDictCodeTypeConst.SD_SRVORRT_ORG.equals(emdo.getSd_srvorrt())) {
				OrgDO orgDo = orgMap.get(emdo.getId_dept());
				if (orgDo != null) {
					emdo.setDepname(orgDo.getName());
				}
			} else if (IBdSrvDictCodeTypeConst.SD_SRVORRT_DEPT.equals(emdo.getSd_srvorrt())) {
				DeptDO deptDo = deptMap.get(emdo.getId_dept());
				if (deptDo != null) {
					emdo.setDepname(deptDo.getName());
				}
			}
		}
	}

	/**
	 * 获取组织字典
	 * 
	 * @param dataList
	 * @return
	 * @throws BizException
	 */
	private Map<String, OrgDO> GetOrgMap(FArrayList dataList) throws BizException {
		Map<String, OrgDO> orgMap = new HashMap<String, OrgDO>();
		IOrgRService orgRSrv = ServiceFinder.find(IOrgRService.class);

		String[] ids = this.getIdArray(dataList);
		if (ids == null || ids.length <= 0) {
			return orgMap;
		}
		OrgDO[] orgDOS = orgRSrv.findByIds(ids, FBoolean.TRUE);

		if (orgDOS == null) {
			return orgMap;
		}
		for (OrgDO orgDo : orgDOS) {
			orgMap.put(orgDo.getId_org(), orgDo);
		}
		return orgMap;
	}

	/**
	 * 获取科室字典
	 * 
	 * @param dataList
	 * @return
	 * @throws BizException
	 */
	private Map<String, DeptDO> GetDeptMap(FArrayList dataList) throws BizException {
		Map<String, DeptDO> deptMap = new HashMap<String, DeptDO>();
		IDeptRService deptRSrv = ServiceFinder.find(IDeptRService.class);

		String[] ids = this.getIdArray(dataList);
		if (ids == null || ids.length <= 0) {
			return deptMap;
		}
		DeptDO[] deptDOS = deptRSrv.findByIds(ids, FBoolean.TRUE);

		if (deptDOS == null) {
			return deptMap;
		}
		for (DeptDO deptDo : deptDOS) {
			deptMap.put(deptDo.getId_dep(), deptDo);
		}
		return deptMap;
	}

	/**
	 * 获取Id_dept数组
	 * 
	 * @param DataList
	 * @return
	 */
	private String[] getIdArray(FArrayList dataList) {

		List<String> ids = new ArrayList<String>();
		for (Object obj : dataList) {

			EmsPrnTmplDO emdo = (EmsPrnTmplDO) obj;
			if (StringUtil.isEmptyWithTrim(emdo.getId_dept()))
				continue;
			ids.add(emdo.getId_dept());
		}

		return ids.toArray(new String[ids.size()]);
	}
}
