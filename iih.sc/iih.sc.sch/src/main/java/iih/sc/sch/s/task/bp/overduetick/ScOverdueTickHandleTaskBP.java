package iih.sc.sch.s.task.bp.overduetick;

import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScParamUtils;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预约过期号位处理
 * 
 * @author li.wm
 *
 */
public class ScOverdueTickHandleTaskBP {
	private static final String Key_Id_Org = "id_org";
	private static final String Key_Id_Grp = "id_grp";
	
	/**
	 * 执行任务
	 * 
	 * @param map
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException {
		// 1.参数校验
		validate(map);
		// 2.设置上下文
		setContext(map);
		
		
		// 3.1 获取门诊 保留sc_tick时长
		String id_org = map.get(Key_Id_Org).toString();
		Integer opDays =  ScParamUtils.getScScpOpDuration(id_org);
		// 3.2 获取医技 保留sc_tick时长
		Integer mtDays =  ScParamUtils.getScScpMtDuration(id_org);
		// 3.3 获取手术 保留sc_tick时长
		Integer optDays =  ScParamUtils.getScScpOptDuration(id_org);
		// 3.4 获取其他 保留sc_tick时长
		Integer otherDays =  ScParamUtils.getScScpOtherDuration(id_org);
		
		// 处理门诊 过期的号位信息
		this.setAllOverdueTick(IScDictCodeConst.SD_SCTP_OP,id_org,opDays);
		
		// 处理医技 过期的号位信息
		this.setAllOverdueTick(IScDictCodeConst.SD_SCTP_MT,id_org,mtDays);
		
		// 处理手术 过期的号位信息
		this.setAllOverdueTick(IScDictCodeConst.SD_SCTP_OT,id_org,optDays);
		
		// 处理其他 过期的号位信息
		this.setAllOverdueTick(null,id_org,otherDays);
		

	}
	/**
	 * 参数校验
	 * 
	 * @param map
	 * @throws BizException
	 */
	private void validate(Map<String, Object> map) throws BizException {
		if(map == null)
			throw new BizException("参数不能为空！");
		if(!map.containsKey(Key_Id_Grp) || map.get(Key_Id_Grp) == null)
			throw new BizException("参数id_grp不能为空！");
		if(!map.containsKey(Key_Id_Org) || map.get(Key_Id_Org) == null)
			throw new BizException("参数id_org不能为空！");
	}
	/**
	 * 设置上下文
	 * 
	 * @param map
	 * @throws BizException
	 */
	private void setContext(Map<String, Object> map)throws BizException {
		Context.get().setGroupId((String) map.get(Key_Id_Grp));
		Context.get().setOrgId((String) map.get(Key_Id_Org));
	}
	
	
	/**
	 * 获取当前日期 过期的号位信息
	 * @param type
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private  void setAllOverdueTick(String type,String id_org, Integer param) throws  BizException {
		// 检验参数  
		if(param<30){
			throw new BizException("号位时长至少要保留30天");
		}
		
		//  获取开始时间、加号时间、当前时间
		FDate begin =  this.getMinSch(type, id_org);
		
		// 获取结束时间
		FDate end = new FDate().getDateBefore(param+1);
		

		// 开始时间在结束时间之后
		if(end.beforeDate(begin)){
			return;
		}
		
		
		// 3. 设置 sc_tickb 数据 
		StringBuffer sql = new StringBuffer();
		SqlParam sqlParam = new SqlParam();
		sql.append(" insert into  sc_tickb  nologging  ");
		sql.append("  select tick.* from sc_tick tick  ");
		sql.append(" left join sc_sch sch on sch.id_sch = tick.id_sch ");
		sql.append(" where  sch.d_sch = ? ");
		if(type == null){
			sql.append(" and sch.SD_SCTP IN (?,?,?) ");
		}else{
			sql.append(" and sch.SD_SCTP = ? ");
		}
		sql.append(" AND sch.ID_ORG = ?  ");
		
		sqlParam.addParam(begin);
		if(type == null){
			sqlParam.addParam(IScDictCodeConst.SD_SCTP_IP);
			sqlParam.addParam(IScDictCodeConst.SD_SCTP_JZ);
			sqlParam.addParam(IScDictCodeConst.SD_SCTP_TY);
		}else{
			sqlParam.addParam(type);
		}
		sqlParam.addParam(id_org);

		
		Integer count = new DAFacade().execUpdate(sql.toString(), sqlParam);
		
		// 删除 sc_tick 号位表的数据
		sql = new StringBuffer();
		sqlParam = new SqlParam();
		sql.append(" delete  from  sc_tick tick");
		sql.append(" where  tick.id_sch in ( select sch.id_sch from sc_sch sch where sch.d_sch = ?  ");
		if(type == null){
			sql.append(" and sch.SD_SCTP IN (?,?,?) ");
		}else{
			sql.append(" and sch.SD_SCTP = ? ");
		}
		sql.append(" AND sch.ID_ORG = ?  )");
		
		sqlParam.addParam(begin);
		if(type == null){
			sqlParam.addParam(IScDictCodeConst.SD_SCTP_IP);
			sqlParam.addParam(IScDictCodeConst.SD_SCTP_JZ);
			sqlParam.addParam(IScDictCodeConst.SD_SCTP_TY);
		}else{
			sqlParam.addParam(type);
		}
		sqlParam.addParam(id_org);
		Integer eInteger =  new DAFacade().execUpdate(sql.toString(), sqlParam);
		if(!count.equals(eInteger)){
			return;
		}
		
		
		// 设置 sc_sch fg_trans = 'Y'
		this.setScSch(begin, type, id_org);
		
		return ;

	}
	
	/**
	 * 设置 sc_sch 里的数据
	 * @param type
	 * @param id_org
	 * @param days
	 * @return
	 * @throws BizException
	 */
	private  Integer setScSch(FDate begin,String type,String id_org) throws  BizException {
		
		//  进行数据修改
		StringBuffer sql = new StringBuffer();
		SqlParam sqlParam = new SqlParam();
		sql.append(" update   sc_sch sch ");
		sql.append("  set  sch.fg_transed = ?  ");
		sql.append(" where  sch.d_sch = ? ");
		if(type == null){
			sql.append(" and sch.SD_SCTP IN (?,?,?) ");
		}else{
			sql.append(" and sch.SD_SCTP = ? ");
		}
		sql.append(" AND sch.ID_ORG = ?  ");
		sqlParam.addParam(FBoolean.TRUE);
		sqlParam.addParam(begin);
		if(type == null){
			sqlParam.addParam(IScDictCodeConst.SD_SCTP_IP);
			sqlParam.addParam(IScDictCodeConst.SD_SCTP_JZ);
			sqlParam.addParam(IScDictCodeConst.SD_SCTP_TY);
		}else{
			sqlParam.addParam(type);
		}
		sqlParam.addParam(id_org);
		 
		return new DAFacade().execUpdate(sql.toString(), sqlParam);
	}
	
	/**
	 * 获取 号位的最开始的时间
	 * @param type  
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FDate  getMinSch(String type,String id_org) throws BizException {
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append(" SELECT MIN(SCSCH.D_SCH) AS D_SCH ");
		sql.append(" from SC_SCH SCSCH ");
		if(type == null){
			sql.append(" WHERE SCSCH.SD_SCTP IN (?,?,?) ");
		}else{
			sql.append(" WHERE SCSCH.SD_SCTP = ? ");
		}
		sql.append(" AND SCSCH.ID_ORG = ?  ");
		sql.append(" AND SCSCH.fg_transed = ?  ");
		if(type == null){
			param.addParam(IScDictCodeConst.SD_SCTP_IP);
			param.addParam(IScDictCodeConst.SD_SCTP_JZ);
			param.addParam(IScDictCodeConst.SD_SCTP_TY);
		}else{
			param.addParam(type);
		}
		param.addParam(id_org);
		param.addParam(FBoolean.FALSE);
		List<ScSchDO> list = (List<ScSchDO>)new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(ScSchDO.class));
		if(ListUtil.isEmpty(list)){
			return  null;
		}
		return list.get(0).getD_sch();
	}

}
