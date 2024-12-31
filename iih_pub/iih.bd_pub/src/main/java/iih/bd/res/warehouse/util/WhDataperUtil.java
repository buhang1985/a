package iih.bd.res.warehouse.util;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.d.desc.WarehouseDODesc;
import iih.bd.res.warehouse.i.IWarehouseRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.dataper.i.IDataperExtQry;
import xap.sys.permfw.dataper.d.DataPerRuleDO;
import xap.sys.permfw.dataper.d.DataperAggDO;
import xap.sys.permfw.dataper.i.IDataperRService;
import xap.sys.permfw.dataperrulerole.d.DataPerRuleRoleDO;
import xap.sys.permfw.dataperrulerole.i.IDataperruleroleRService;
import xap.sys.permfw.dataperruleuser.d.DataPerRuleUserDO;
import xap.sys.permfw.dataperruleuser.i.IDataperruleuserRService;
import xap.sys.permfw.user.d.UserRoleDO;
import xap.sys.permfw.user.i.IUserroleRService;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 物品管理获取仓库数据权限工具类
 * @author ly 2017/06/16
 *
 */
public class WhDataperUtil {

	/**
	 * 仓库数据权限资源编码
	 */
	private static final String WH_DATAPER_RES_CODE = "412030";
	/**
	 * 是否开启仓库数据权限参数编码
	 */
	private static final String PARAM_MM0001 = "MM0001";
	
	/**
	 * 仓库资源编码
	 */
	private static final String DATAPER_CODE = "412030";
	/**
	 * 数据权限查询服务
	 */
	private static IDataperExtQry dataperQry = ServiceFinder.find(IDataperExtQry.class);
	
	/**
	 * 获取可使用仓库数据权限sql脚本
	 * @param userId 用户id
	 * @param useAliasName null/true:使用别名 false:使用表名
	 * @return sql脚本(条件前都是表名)
	 * @throws BizException
	 */
	public static String getDataperSql(String userId, FBoolean useAliasName) throws BizException {
		return getDataperSql(userId, null, useAliasName);
	}
	
	/**
	 * 获取可使用仓库数据权限sql脚本
	 * @param userId 用户id
	 * @param ruleCode 数据权限规则编码
	 * @param useAliasName null/true:使用别名 false:使用表名
	 * @return sql脚本(条件前都是表名)
	 * @throws BizException
	 */
	public static String getDataperSql(String userId, String ruleCode, FBoolean useAliasName) throws BizException {
		
		if(ifWhDataperIsAcctive() == false)
			return " 1 = 1";
		
		String dataperSql = "";
		
		String userSql = getUserDataperSql(userId, ruleCode);
		String roleSql = getRoleDataperSql(userId, ruleCode);
		
		if(StringUtil.isEmpty(userSql)){
			dataperSql = roleSql;
		}else if(StringUtil.isEmpty(roleSql)){
			dataperSql = userSql;
		}else{
			dataperSql = userSql + " or " + roleSql;
		}
		
		if(StringUtil.isEmpty(dataperSql)){
			return "1 <> 1";
		}
		
		return replaceAliasAndTableName(dataperSql, useAliasName == null ? true : useAliasName.booleanValue());
	}
	
	/**
	 * 获取可使用仓库id集合
	 * @param userId 用户id
	 * @return 仓库id集合
	 * @throws BizException
	 */
	public static String[] getDataperWhIds(String userId) throws BizException {
		return getDataperWhIds(userId, null);
	}
	
	/**
	 * 获取可使用仓库id集合
	 * @param userId 用户id
	 * @param ruleCode 数据权限规则编码
	 * @return 仓库id集合
	 * @throws BizException
	 */
	public static String[] getDataperWhIds(String userId, String ruleCode) throws BizException {
		
		String dataperSql = getDataperSql(userId, ruleCode, FBoolean.TRUE);
		dataperSql = replaceAliasAndTableName(dataperSql, true);
		
		IWarehouseRService whRService = ServiceFinder.find(IWarehouseRService.class);
		WarehouseDO[] whInfos = whRService.find(dataperSql, "", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(whInfos))
			return null;
		
		List<String> idList = new ArrayList<String>();
		for (WarehouseDO wh : whInfos) {
			idList.add(wh.getId_wh());
		}
		
		return idList.toArray(new String[idList.size()]);
	}

	/**
	 * 判断是够开启仓库数据权限
	 * @return true:开启 false:不开启
	 * @throws BizException
	 */
	private static Boolean ifWhDataperIsAcctive() throws BizException {
		
		FBoolean rlt = null;
		try {
			rlt = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(), PARAM_MM0001);
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		if(rlt == null)
			return false;
		
		return rlt.booleanValue();
	}
	
	/**
	 * 获取用户下配置的规则sql脚本
	 * @param userId 用户id
	 * @param ruleCode 数据权限规则编码
	 * @return sql脚本
	 * @throws BizException
	 */
	private static String getUserDataperSql(String userId,String ruleCode) throws BizException {
		
		List<DataPerRuleDO> ruleList = null;
		if(StringUtil.isEmpty(ruleCode)){
			ruleList = dataperQry.getSysDataperRuleByUser(userId, WH_DATAPER_RES_CODE);
		}else{
			ruleList = dataperQry.getSysDataperRuleByUserCode(
					userId, WH_DATAPER_RES_CODE, ruleCode);
		}
		
		return analysisRules(ruleList);
	}
	
	/**
	 * 获取角色下配置的规则sql脚本
	 * @param userId 用户id
	 * @param ruleCode 数据权限规则编码
	 * @return sql脚本
	 * @throws BizException
	 */
	private static String getRoleDataperSql(String userId,String ruleCode) throws BizException {
		
		List<DataPerRuleDO> ruleList = null;
		if(StringUtil.isEmpty(ruleCode)){
			ruleList = dataperQry.getSysDataperRuleByUserRole(userId, WH_DATAPER_RES_CODE);
		}else{
			ruleList = dataperQry.getSysDataperRuleByUserRoleCode(
					userId, WH_DATAPER_RES_CODE, ruleCode);
		}
		
		return analysisRules(ruleList);
	}
	
	/**
	 * 解析规则条件
	 * @param ruleList 规则列表
	 * @return sql脚本
	 * @throws BizException
	 */
	private static String analysisRules(List<DataPerRuleDO> ruleList) throws BizException{
		
		if(ListUtil.isEmpty(ruleList))
			return "";
		
		String dataperSql = "";
		for (DataPerRuleDO ruleDo : ruleList) {
			String sql = dataperQry.getwhere(ruleDo);
			
			//去掉开头可能有的and条件
			if(sql.startsWith("and")){
				sql = sql.substring(4, sql.length());
			}

			if(dataperSql.length()>0){
				dataperSql += " or ";
			}
			dataperSql += "(" + sql + ")";
		}
		
		return dataperSql;
	}
	
	/**
	 * 替换别名或者表名
	 * @param sql
	 * @param alias true:表名替换为别名 false:别名替换为表名
	 * @return
	 */
	private static String replaceAliasAndTableName(String sql, Boolean alias) {
		String aliasName = WarehouseDODesc.TABLE_ALIAS_NAME + ".";
		String tableName = WarehouseDODesc.TABLE_NAME + ".";
		
		if(alias == true){
			sql = sql.replace(tableName, aliasName);
		}else{
			sql = sql.replace(aliasName, tableName);
		}
		
		return sql;
	}
	
	/**
	 * 通过仓库，去的用户id
	 * @param sql
	 * @param alias true:表名替换为别名 false:别名替换为表名
	 * @return
	 * @throws BizException 
	 */
	public  static String[] getUSeridByWare(String id_wh) throws BizException {
		List<String> list = new ArrayList<String>();
		//根据仓库id获取仓库数据
		WarehouseDO wado = getWarehouseDOById(id_wh);
		Context.get().setOrgId(wado.getId_org());
		Context.get().setGroupId(wado.getId_grp());
		//获取资源下的规则
		DataperAggDO[] aggdos = getDataper();
		//根据规则，得到用户id
		getUserIdByDataper(list,aggdos,id_wh);
		return list.toArray(new String[0]);
	}
	private static WarehouseDO getWarehouseDOById(String id_wh) throws BizException {
		IWarehouseRService whRService = ServiceFinder.find(IWarehouseRService.class);
			WarehouseDO whInfos = whRService.findById(id_wh);
		return whInfos;
	}

	/**
	 * 根据规则，得到用户id
	 * @param 规则集合，仓库id
	 * @return
	 */
	private static void getUserIdByDataper(List<String> list,
			DataperAggDO[] aggdos,String id_wh) throws BizException {
		for(DataperAggDO aggdo : aggdos){
     		
     		DataPerRuleDO[] ruleDOs =  (DataPerRuleDO[]) aggdo.getChildrenDO();
     		for(DataPerRuleDO ruledo : ruleDOs){
     			
     			IWarehouseRService whRService = ServiceFinder.find(IWarehouseRService.class);
     			String qryWhere = "";
     			if(!StringUtil.isEmpty(ruledo.getRowwhere())&& ruledo.getRowwhere() !=null){
     				qryWhere = 	ruledo.getRowwhere();	 		    				
     			}else{
     				qryWhere ="1 = 1 ";
     			}
     			
     			WarehouseDO[] whInfos = whRService.find(qryWhere, "", FBoolean.FALSE);
     			// 判断是否包含目标仓库
     			if(hasWareId(whInfos,id_wh)){
     				//该规则下的用户id
     				IDataperruleuserRService iDataperruleRservice = ServiceFinder.find(IDataperruleuserRService.class);
     				DataPerRuleUserDO[] dataroledos = iDataperruleRservice.find("id_rule = '"+ruledo.getId_dataper_rule()+"'", "", FBoolean.FALSE);
     				for(DataPerRuleUserDO userdo : dataroledos){
     					if(!list.contains(userdo.getId_ruleuser())){
     						list.add(userdo.getId_ruleuser());   						
     					}	
     				}
     				//根据该规则下的角色id，取得关联的用户id       				
     				IDataperruleroleRService iDataperruleservice = ServiceFinder.find(IDataperruleroleRService.class);
 					DataPerRuleRoleDO[] roledos = iDataperruleservice.find("id_rule = '"+ruledo.getId_dataper_rule()+"'", "", FBoolean.FALSE);
					for(DataPerRuleRoleDO roledo : roledos){
						IUserroleRService userruleservice =   ServiceFinder.find(IUserroleRService.class);  
						UserRoleDO[] userdos =  userruleservice.find("id_role ='"+roledo.getId_role()+"'", "", FBoolean.FALSE);
						for(UserRoleDO userrole : userdos){
							if(!list.contains(userrole.getId_user())){
         						list.add(userrole.getId_user());   						
         					}	   							
						}   						
					}     									     						     					     					         				
     			}         			         				
     		} 		
     	} 
		
	}
	/**
	 * 获取资源下的规则
	 * @return
	 */
	private static DataperAggDO[] getDataper() throws BizException {
		IDataperRService igservice = ServiceFinder
					.find(IDataperRService.class);
		return igservice.find(" a0.code = '"+DATAPER_CODE+"'", "", FBoolean.FALSE);
	}
	/**
	 * 判断是否包含目标仓库
	 * @return
	 */
	private static boolean hasWareId(WarehouseDO[] whInfos,String id_wh) {
		for(WarehouseDO wado : whInfos){
				if(wado.getId_wh().equals(id_wh)){					
					return true;														            					
				}
		}
		return false;
	}
}
