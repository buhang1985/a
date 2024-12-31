package iih.ci.ord.s.ems.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.d.desc.DeptDODesc;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 定义态科室信息缓存
 * 
 * @author wangqingzhu
 *
 */
public class BDDeptInfoCache {
	public static String BDDeptInfoCache_Key = "BDDeptInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private static BDDeptInfoCache ins = new BDDeptInfoCache();

	private BDDeptInfoCache() {
	}

	private DeptDO[] gets(String code_entp) throws BizException {
		String sql = "select a0.Id_dep, a0.Name from bd_dep a0 where ds<1 and "
				+ EnvContextUtil.processEnvContext("", new DeptDO(), DeptDODesc.TABLE_ALIAS_NAME)
				+ (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp) ? " and fg_op='Y' "
				: (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp) ? " and fg_ip='Y' "
				: (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp) ? " and fg_er='Y' "
				: (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp) ? " and fg_use_er1='Y' "
				: (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp) ? " and fg_use_er2='Y' "
				: (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp) ? " and fg_fm='Y' "
				: (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp) ? " and fg_pe='Y' " : (""))))))));
		List<DeptDO> rst = (List<DeptDO>) new DAFacade().execQuery(sql, new BeanListHandler(DeptDO.class));
		return null != rst ? rst.toArray(new DeptDO[rst.size()]) : null;
	}

	private DeptDO get(String id_dep) throws BizException {
		String sql = String.format("select a0.Id_dep, a0.Name from bd_dep a0 where a0.Id_dep = '%s'", id_dep);

		List<DeptDO> rst = (List<DeptDO>) new DAFacade().execQuery(sql, new BeanListHandler(DeptDO.class));
		return null != rst ? rst.get(0) : null;
	}

	private DeptDO getByCode(String code_dep) throws BizException {
		String sql = String.format("select a0.Id_dep, a0.Name from bd_dep a0 where a0.Code_dep = '%s'", code_dep);

		List<DeptDO> rst = (List<DeptDO>) new DAFacade().execQuery(sql, new BeanListHandler(DeptDO.class));
		return null != rst ? rst.get(0) : null;
	}

	public static DeptDO[] GetBdDeptInfos(CiEnContextDTO ctx) throws BizException {
		DeptDO[] szDeptDO = ContextCache.Get(BDDeptInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(),
				BDDeptInfoCache_Key, DefaultContext_ID);
		if (null == szDeptDO || szDeptDO.length == 0) {
			szDeptDO = ins.gets(ctx.getCode_entp());
			ContextCache.Put(BDDeptInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(),
					BDDeptInfoCache_Key, DefaultContext_ID, BDDeptInfoCache_Key);
		}
		return szDeptDO;
	}

	public static String GetNameOfBDeptInfo(String id_dep) throws BizException {
		DeptDO deptInfo = ContextCache.Get(BDDeptInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
				BDDeptInfoCache_Key, id_dep);
		if (null == deptInfo) {
			deptInfo = ins.get(id_dep);
			ContextCache.Put(BDDeptInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
					BDDeptInfoCache_Key, id_dep, deptInfo);
		}
		return deptInfo == null ? null : deptInfo.getName();
	}

	public static String GetIDOfBDeptInfo(String code_dep) throws BizException {
		DeptDO deptInfo = ContextCache.Get(BDDeptInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
				BDDeptInfoCache_Key, code_dep);
		if (null == deptInfo) {
			deptInfo = ins.getByCode(code_dep);
			ContextCache.Put(BDDeptInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
					BDDeptInfoCache_Key, code_dep, deptInfo);
		}
		return deptInfo == null ? null : deptInfo.getName();
	}

	public void Clear(){
			ContextCache.Clear(BDDeptInfoCache.class.getSimpleName());
	}

}
