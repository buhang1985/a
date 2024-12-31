package iih.hp.cp.hpcp.i;

import java.util.ArrayList;
import java.util.List;

import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.role.d.RoleDO;

/**
 * 
 * @author chenxiang
 *
 * @date 2019年9月10日下午3:18:25
 *
 * @classpath iih.hp.cp.hpcp.i.HpcpConditionCommons
 *
 * 	流程分支线公共部分
 *
 */
public class HpcpConditionCommons {
	
	/**
	 *	根据用户id获得其角色集合 
	 *
	 * @param	userId
	 * @return List<RoleDO>    
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<RoleDO> getRoleListByUserId(String userId){
		//根据用户ID查找用户的角色集合
		StringBuilder builder = new StringBuilder();
		builder.append(" select c.id_role, c.code, c.name")
			   .append(" from sys_user a")
			   .append(" join sys_user_role b on a.id_user = b.id_user")
			   .append(" join sys_role c on b.id_role = c.id_role")
			   .append(" where a.id_user = ?");
		SqlParam param = new SqlParam();
		param.addParam(userId);
		List<RoleDO> roleList = new ArrayList<>();
		try {
			roleList = (List<RoleDO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(RoleDO.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("根据用户id获取角色集合失败！");
		}
		return roleList;
	}
}
