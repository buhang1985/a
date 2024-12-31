package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnOperateLogDTO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.securityfw.operatelog.d.OperateLogDO;
/***
 * 查询登录日志
 * 
 * @author li.wm
 *
 */
public class GetAllOperateLogListBP {
	/***
	 * 查询登录日志
	 * 
	 * @param pg
	 * @param nodeDTO
	 * @return
	 * @throws BizException
	 */
	public EnOperateLogDTO[] exec( EnOperateLogDTO nodeDTO) throws BizException{
		return getsql(nodeDTO);
	}
	/***
	 * 获取登录日志sql
	 * @param pg
	 * @param queryNoteSql
	 * @return
	 * @throws BizException
	 */
	private EnOperateLogDTO[] getsql(EnOperateLogDTO nodeDTO) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select oplog.user_name as name_user, ");
		sql.append("psn.name as name_psn, " );
		sql.append("sysu.user_type as usertype, " );
		sql.append("oplog.clienthostip as ip, " );
		sql.append("oplog.clienthostname as name_pc, " );
		sql.append("oplog.clienthostversion as name_version, " );
		sql.append("oplog.type as operatetype, " );
		sql.append("oplog.enterdatetime as dt_b_oper, " );
		sql.append("oplog.leavedatetime as dt_e_oper, " );
		sql.append("oplog.funcname as name_fun, " );
		sql.append("dep.name as name_dep, " );
		sql.append("org.name as name_org, " );
		sql.append("grp.name as name_grp, " );
		sql.append("oplog.entersystemresult as fg_success, " );
		sql.append("oplog.detail as details " );
		sql.append("from sys_log_operatelog oplog " );
		sql.append("left join sys_user sysu on sysu.id_user = oplog.id_user " );
		sql.append("left join bd_psndoc psn on psn.id_psndoc = oplog.id_psndoc " );
		sql.append("left join bd_dep dep on dep.id_dep = oplog.id_dep " );
		sql.append("left join bd_org org on org.id_org = oplog.id_org " );
		sql.append("left join bd_grp grp on grp.id_grp = oplog.id_group ");
		sql.append("where 1=1 ");
		SqlParam param = new SqlParam();
		//1.进入时间
		if(nodeDTO.getDt_b_oper() != null){
			sql.append("and oplog.enterdatetime >= ? "); 
			param.addParam(nodeDTO.getDt_b_oper());
		}
		//2.离开时间
		if(nodeDTO.getDt_e_oper() != null){
			sql.append("and oplog.leavedatetime <= ? ");
			param.addParam(nodeDTO.getDt_e_oper());
		}
		//3.用户
		if(!EnValidator.isEmpty(nodeDTO.getId_user())){
			sql.append("and oplog.id_user = ? ");
			param.addParam(nodeDTO.getId_user());
		}
		//4.人员
		if(!EnValidator.isEmpty(nodeDTO.getId_psndoc())){
			sql.append("and oplog.id_psndoc = ? ");
			param.addParam(nodeDTO.getId_psndoc());
		}
		//5.打开节点
		if(!EnValidator.isEmpty(nodeDTO.getId_fun())){
			sql.append("and oplog.id_fun = ? ");
			param.addParam(nodeDTO.getId_fun());
		}
		//6.登录ip
		if(!EnValidator.isEmpty(nodeDTO.getIp())){
			sql.append("and oplog.clienthostip = ? ");
			param.addParam(nodeDTO.getIp());
		}
		//7.操作类型
		if(nodeDTO.getOperatetype() != null){
			sql.append("and oplog.type = ? ");
			param.addParam(nodeDTO.getOperatetype());
		}
		//8.集团管控
		String orgWhere = ScGroupControlUtils.getGroupControlFitler(new OperateLogDO(), "oplog");
		if(!EnValidator.isEmpty(orgWhere)){
			sql.append(" and ").append(orgWhere);
		}
		sql.append("order by oplog.enterdatetime desc");
		
		List<EnOperateLogDTO> results = (List<EnOperateLogDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(EnOperateLogDTO.class));
		EnOperateLogDTO[] enOperateLogDTOs = results.toArray(new EnOperateLogDTO[results.size()]);
		return enOperateLogDTOs;
	}
}
