package iih.hp.cp.hpcp.i;

import java.util.List;

import iih.hp.cp.hpcp.d.HpcpFormAggDO;
import iih.hp.cp.i.IHpCpFlowSysParamConst;
import xap.mw.core.data.Context;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * 
 * @author chenxiang
 *
 * @date 2019年9月9日下午19:59
 *
 * @classpath iih.hp.cp.hpcp.i.HpcpDeptAuditPsn
 *
 * 	临床路径科室审核人员
 *
 */
public class HpcpDeptAuditPsn implements IActorListener {

	private static final long serialVersionUID = 1722961087647149797L;

	@SuppressWarnings("unchecked")
	@Override
	public String[] getActors(WfFormInfoCtx wfFormInfoCtx) throws Exception {
		Logger.info("开始获得科室审批角色集合");
		if (!(wfFormInfoCtx instanceof HpcpFormAggDO)) {
			return new String[0];
		}
		//获得当前临床路径所属科室，所属组织，所属集团
		String deptId = Context.get().getDeptId();
		String orgId = Context.get().getOrgId();
		String grpId = Context.get().getGroupId();
		//根据科室id和角色id获得用户集合
		StringBuilder builder = new StringBuilder();
		builder.append(" select a.id_user")
			   .append(" from sys_user a")
			   .append(" join bd_psndoc b on a.id_psn = b.id_psndoc")
			   .append(" join sys_user_role c on a.id_user = c.id_user")
			   .append(" join sys_role d on c.id_role = d.id_role")
			   .append(" where d.code = ? and b.id_dep = ? and b.id_org = ? and b.id_group = ?");
		SqlParam param = new SqlParam();
		param.addParam(ParamsetQryUtil.getParaString(orgId, IHpCpFlowSysParamConst.SYS_PARAM_FLOW_DEPT_APPROVE));
		param.addParam(deptId);
		param.addParam(orgId);
		param.addParam(grpId);
		List<UserDO> userList = null;
		try {
			userList = (List<UserDO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(UserDO.class));
		} catch (DAException e) {
			e.printStackTrace();
			throw new RuntimeException("获取临床路径科室审批人失败！");
		}
		
		if(userList == null || userList.size() == 0) {
			return new String[0]; 
		}
		String[] userIdArr = new String[userList.size()];
		for (int i = 0; i < userList.size(); i++) {
			userIdArr[i] = userList.get(i).getId_user();
		}
		return userIdArr;
	}

}