package iih.en.pv.s.bp.op;

import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取候诊出诊人数（点击排班时候）
 * 
 * @param id_sch
 * @return
 * @author li.wm
 * @throws BizException 
 */
public class GetFirstWaitNumBP {
	
	public String exec(String id_sch,String code_entp) throws BizException {
		if(StringUtil.isEmpty(id_sch)){
			throw new BizException("排班ID不能为空");
		}
		if(StringUtil.isEmpty(code_entp)){
			throw new BizException("就诊类型不能为空");
		}
		// 获取出诊队列
		String queDos = this.getQueDos(id_sch);
		
		// 获取查询次数
		String waitNum = this.getWaitNum(id_sch,queDos,code_entp).toString();
		return waitNum;
	}
	
	
	
	/**
	 * 初始化查询条件
	 * 
	 * @param regQry
	 * @param sb
	 * @param param
	 * @throws BizException 
	 */
	private Integer getWaitNum(String id_sch,String id_que,String code_entp) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT COUNT(1) ");
		sqlBuilder.append(" FROM EN_ENT_QUE EQ ");
		sqlBuilder.append(" INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP ENTOP ON EN.ID_ENT = ENTOP.ID_ENT ");
		sqlBuilder.append(" INNER JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		sqlBuilder.append(" WHERE BQ.ID_QUE = ? ");
		param.addParam(id_que);
		sqlBuilder.append(" AND EQ.DT_REGIST = ? ");
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schRService.findById(id_sch);
		if(schDO == null){
			throw new BizException("排班ID查不到对应的数据");
		}
		param.addParam(schDO.getD_sch());
		if(code_entp.equals(IEnDictCodeConst.SD_ENTP_EMERGENCY)){
			sqlBuilder.append(" AND EN.CODE_ENTP  like  ? ");
			param.addParam(code_entp+"%");
		}else if (code_entp.equals(IEnDictCodeConst.SD_ENTP_OUTPATIENT)) {
			sqlBuilder.append(" AND EN.CODE_ENTP = ? ");
			param.addParam(code_entp);
		}
		
		
		sqlBuilder.append(" AND EN.FG_CANC = ? ");
		param.addParam(FBoolean.FALSE);
		sqlBuilder.append(" AND ENTOP.SD_STATUS IN (?,?) ");
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER);
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
		Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return count == null ? 0 : count;
	}
	/**
	 * 获取出诊队列ID
	 * 
	 * @param r
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private String getQueDos(String id_sch) throws BizException{
		//1.查询有排班的队列
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT SCPL.ID_DEP,SCPL.ID_SCRES,SCPL.ID_QUEBEN ");
		builder.append(" FROM SC_SCH SCH ");
		builder.append(" INNER JOIN SC_PL SCPL ON SCPL.ID_SCPL = SCH.ID_SCPL ");
		builder.append("WHERE SCH.ID_SCH = ? ");
		
		String sql  = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(id_sch);
		
		List<ScPlanDO> list = (List<ScPlanDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(ScPlanDO.class));
		if(ListUtil.isEmpty(list)){
			throw new BizException("排班没有对应的计划。");
		}
		builder = new StringBuilder();
		param = new SqlParam();
		builder.append(" SELECT  BQ.ID_QUE AS ID_QUE ");
		builder.append(" FROM BD_QUE BQ ");
		builder.append(" WHERE BQ.ID_QUEBEN = ? ");
		builder.append(" AND BQ.ID_SCRES = ? ");
		builder.append(" AND BQ.ID_DEP = ? ");
		builder.append(" AND BQ.FG_ACTIVE = ? ");
		sql  = builder.toString();
		
		ScPlanDO scPlanDO = list.get(0);
		param.addParam(scPlanDO.getId_queben());
		param.addParam(scPlanDO.getId_scres());
		param.addParam(scPlanDO.getId_dep());
		
		param.addParam(FBoolean.TRUE);
		
		String id_que = (String) new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(StringUtil.isEmpty(id_que)){
			throw new BizException("没有查到对应的队列");
		}
		
		return id_que;
	}
	
}
