package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.en.getusergroup.d.GetUserGroupParamDTO;
import iih.ei.std.d.v1.en.getusergroup.d.GetUserGroupResultDTO;
import iih.ei.std.d.v1.en.getusergroup.d.UserGroupInfo;
import iih.ei.std.d.v1.en.getusergroup.d.UserOrg;
import iih.ei.std.d.v1.en.getusergroup.d.UserResp;
import iih.ei.std.d.v1.en.getusergroup.d.UserRole;
import iih.ei.std.d.v1.utils.EiValidator;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.user.d.UserDO;
/***
 * 获取用户组织
 * @author fanlq
 * @date: 2020年3月28日 下午5:31:13
 */
public class GetUserGroupBP extends IIHServiceBaseBP<GetUserGroupParamDTO, GetUserGroupResultDTO> {

	/**
	 * 校验入参
	 */
	@Override
	protected void checkParam(GetUserGroupParamDTO param) throws BizException {
		if (EiValidator.isEmpty(param.getCode_user())) {
			throw new BizException("用户编码不能为空！");
		}
	}

	@Override
	protected GetUserGroupResultDTO process(GetUserGroupParamDTO param) throws BizException {
		List<String> id_users = getUserId(param.getCode_user());
		if(EiValidator.isEmpty(id_users)){
			throw new BizException("未查询到该编码对应的用户信息，请核对用户编码！入参编码为："+ param.getCode_user());
		}
		GetUserGroupResultDTO result = new GetUserGroupResultDTO();
		UserGroupInfo[]  userGroupInfos = this.getUserBaseInfo(id_users);
		FMap userRoleMap = this.GetUserRole(id_users);//角色
		FMap userOrgMap = this.GetUserOrg(id_users);//组织
		FMap userRespMap = this.GetUserResp(id_users);//职责
		for(UserGroupInfo info : userGroupInfos){
			info.setRole(!EiValidator.isEmpty(userRoleMap) && userRoleMap.get(info.getId_user()) != null ?(FArrayList)userRoleMap.get(info.getId_user()) :  null);
			info.setResp(!EiValidator.isEmpty(userRespMap) && userRespMap.get(info.getId_user()) != null ?(FArrayList)userRespMap.get(info.getId_user()) :  null);
			info.setOrg(!EiValidator.isEmpty(userOrgMap) && userOrgMap.get(info.getId_user()) != null ?(FArrayList)userOrgMap.get(info.getId_user()) :  null);
		}
		result.setUsergroupinfo(ArrayListUtil.ConvertToFArrayList(userGroupInfos));
		
		return result;
	}
	/***
	 * @Description:获取用户职责
	 * @param id_users
	 * @return
	 * @throws BizException
	 */
	private FMap GetUserResp(List<String> id_users) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT USROLE.ID_USER, ");
		sql.append("RESP.CODE AS CODE_RESP, " );
		sql.append("RESP.NAME AS NAME_RESP " );
		sql.append("FROM SYS_FUNC_PERMCFG CFG " );
		sql.append("INNER JOIN SYS_RESP RESP ON RESP.ID_RESP = CFG.ID_RESP " );
		sql.append("INNER JOIN SYS_USER_ROLE USROLE ON USROLE.ID_ROLE = CFG.SUBJECTID ");
		sql.append("WHERE "+SqlUtils.getInSqlByIds("USROLE.ID_USER", id_users));
		sql.append("ORDER BY RESP.CODE ");
		List<UserResp> list = (List<UserResp>) new DAFacade().execQuery(sql.toString(),new BeanListHandler(UserResp.class));
		if(EiValidator.isEmpty(list)) return null;
		FMap userRespMap = new FMap();
		for(String id_user : id_users){
			FArrayList respList = new FArrayList();
			for(UserResp resp : list){
				if(resp.getId_user().equals(id_user) && !respList.contains(resp.getCode_resp())){
					respList.add(resp);
				}
			}
			if(!userRespMap.containsKey(id_user)){
				userRespMap.put(id_user, respList);
			}
		}
		return  userRespMap;
	}
	
	/***
	 * @Description:获取用户组织
	 * @param id_users
	 * @return
	 * @throws BizException
	 */
	private FMap GetUserOrg(List<String> id_users) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT US.ID_USER, ");
		sql.append("BDORG.CODE AS CODE_ORG, " );
		sql.append("BDORG.NAME AS NAME_ORG, " );
		sql.append("GRP.CODE AS CODE_GRP, " );
		sql.append("GRP.NAME AS NAME_GRP " );
		sql.append("FROM SYS_SUBJECT_ORG ORG " );
		sql.append("INNER JOIN BD_ORG BDORG ON BDORG.ID_ORG = ORG.ID_ORG " );
		sql.append("INNER JOIN BD_GRP GRP ON GRP.ID_GRP = BDORG.ID_GRP ");
		sql.append("INNER JOIN SYS_USER US ON US.ID_USER = ORG.SUBJECTID " );
		sql.append("WHERE "+SqlUtils.getInSqlByIds("US.ID_USER", id_users));
		sql.append("ORDER BY BDORG.CODE ");
		List<UserOrg> list = (List<UserOrg>) new DAFacade().execQuery(sql.toString(),new BeanListHandler(UserOrg.class));
		if(EiValidator.isEmpty(list)) return null;
		FMap userOrgMap = new FMap();
		for(String id_user : id_users){
			FArrayList orgList = new FArrayList();
			for(UserOrg org : list){
				if(org.getId_user().equals(id_user) && !orgList.contains(org.getCode_org())){
					orgList.add(org);
				}
			}
			if(!userOrgMap.containsKey(id_user)){
				userOrgMap.put(id_user, orgList);
			}
		}
		return  userOrgMap;
	}
	
	/***
	 * @Description:获取用户角色
	 * @param id_users
	 * @return
	 * @throws BizException
	 */
	private FMap GetUserRole(List<String> id_users) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT ID_USER AS ID_USER, ");
		sql.append("SYSROLE.CODE AS CODE_ROLE, " );
		sql.append("SYSROLE.NAME AS NAME_ROLE " );
		sql.append("FROM SYS_ROLE SYSROLE " );
		sql.append("INNER JOIN SYS_USER_ROLE USROLE ON SYSROLE.ID_ROLE = USROLE.ID_ROLE " );
		sql.append("WHERE "+SqlUtils.getInSqlByIds("USROLE.ID_USER", id_users));
		sql.append(" ORDER BY SYSROLE.CODE ");
		List<UserRole> list = (List<UserRole>) new DAFacade().execQuery(sql.toString(),new BeanListHandler(UserRole.class));
		if(EiValidator.isEmpty(list)) return null;
		FMap userRoleMap = new FMap();
		for(String id_user : id_users){
			FArrayList roleList = new FArrayList();
			for(UserRole role : list){
				if(role.getId_user().equals(id_user) && !roleList.contains(role.getCode_role())){
					roleList.add(role);
				}
			}
			if(!userRoleMap.containsKey(id_user)){
				userRoleMap.put(id_user, roleList);
			}
		}
		return  userRoleMap;
	}

	/***
	 * @Description:获取用户基本信息
	 * @param id_users
	 * @return
	 * @throws BizException
	 */
	private UserGroupInfo[] getUserBaseInfo(List<String> id_users) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT US.CODE AS CODE_USER, ");
		sql.append("US.ID_USER AS ID_USER, " );
		sql.append("US.NAME AS NAME_USER, " );
		sql.append("PSN.CODE AS CODE_PSNDOC, " );
		sql.append("PSN.NAME AS NAME_PSNDOC, " );
		sql.append("USEGRP.CODE AS CODE_USERGRP, " );
		sql.append("USEGRP.NAME AS NAME_USERGRP, " );
		sql.append("US.ACTIVESTATE AS ACTIVESTATE, " );
		sql.append("CASE WHEN US.ACTIVESTATE = 1 THEN '未启用' " );
		sql.append("     WHEN US.ACTIVESTATE = 2 THEN '已启用' " );
		sql.append("     WHEN US.ACTIVESTATE = 3 THEN '已停用' " );
		sql.append("       END NAME_ACTIVESTATE " );
		sql.append("FROM SYS_USER US " );
		sql.append("LEFT JOIN BD_PSNDOC PSN ON PSN.ID_PSNDOC = US.ID_PSN " );
		sql.append("LEFT JOIN SYS_USERGROUP USEGRP ON USEGRP.ID_USERGROUP = US.ID_USERGRP " );
		sql.append("WHERE "+SqlUtils.getInSqlByIds("US.ID_USER", id_users));
		sql.append(" ORDER BY US.CODE ");
		List<UserGroupInfo> list = (List<UserGroupInfo>) new DAFacade().execQuery(sql.toString(),new BeanListHandler(UserGroupInfo.class));
		if(EiValidator.isEmpty(list)) return null;
		return  list.toArray(new UserGroupInfo[]{});
	}
	/***
	 * @Description:获取批量查询用户id
	 * @param code_users
	 * @return
	 * @throws DAException
	 */
	private List<String> getUserId(String code_users) throws DAException{
		String insql = SqlUtils.getInSqlByIdsSplit("US.CODE",code_users);
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT US.ID_USER FROM SYS_USER US ");
		sql.append("LEFT JOIN BD_PSNDOC PSN ON PSN.ID_PSNDOC = US.ID_PSN " );
		sql.append("WHERE "+insql);
		sql.append(" OR " + insql);
		List<UserDO> list = (List<UserDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(UserDO.class));
		if(EiValidator.isEmpty(list)){
			return null;
		}
		List<String> id_users = new ArrayList<String>();
		for(UserDO user : list){
			if(!id_users.contains(user.getId_user())){
				id_users.add(user.getId_user());
			}
		}
		return  EiValidator.isEmpty(list) ? null :id_users;
	}
}
