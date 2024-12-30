package iih.sc.sch.s.bp.mt.apt.bp;

import iih.sc.comm.ScContextUtils;
import iih.sc.sch.dto.d.SchTickMdTimeDTO;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import java.util.ArrayList;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 时间片模式号段处理
 * 
 * @author liubin
 * 
 */
public class OccupyTicks4TimeMd4ManualBP {
	/**
	 * 预约选择的时间点是否未使用
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO exec(String id_scsrv,String id_sch, SchTickMdTimeDTO schTickMdTime) throws BizException{
		//1.验证
		validate(id_sch, schTickMdTime);
		//2.获取排班信息
		SchEP schEp = new SchEP();
		ScSchDO sch = schEp.getByPK(id_sch);
		//3.获取需要拆分的号段信息
		ScSchTicksDO schTicksDo = getNeedSplitTicksDo(id_sch, schTickMdTime);
		//4.拆分号段
		return splitTicks(id_scsrv,schTicksDo, sch, schTickMdTime);
	}
	/**
	 * 获取需要拆分的号段信息
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO getNeedSplitTicksDo(String id_sch, SchTickMdTimeDTO schTickMdTime) throws BizException{
		TicksEP ticksEP = new TicksEP();
		ScSchTicksDO[] schTicksDOs = ticksEP.getTicksByCond(String.format("id_sch = '%s' and fg_used = 'N' ", id_sch), "T_b");
		if(ArrayUtil.isEmpty(schTicksDOs))
			return null;
		for(ScSchTicksDO schTicksDo : schTicksDOs)
			if(schTickMdTime.getT_b().compareTo(schTicksDo.getT_b()) >= 0
			&& schTickMdTime.getT_e().compareTo(schTicksDo.getT_e()) <= 0)
				return schTicksDo;
		throw new BizException("号段时间拆分错误!");
	}
	
	/**
	 * 拆分号段
	 *	 * @author liubin
	 * 
	 * @param schTicksDo
	 * @param schDo
	 * @param schTickMdTime
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO splitTicks(String id_scsrv,ScSchTicksDO schTicksDo, ScSchDO schDo, SchTickMdTimeDTO schTickMdTime) throws BizException{
		List<ScSchTicksDO> ticksDOList = new ArrayList<>();
		FTime t_b = schDo.getT_b_acpt();
		FTime t_e = schDo.getT_e_acpt();
		if(schTicksDo != null){
			t_b = schTicksDo.getT_b();
			t_e = schTicksDo.getT_e();
			schTicksDo.setStatus(DOStatus.DELETED);
			ticksDOList.add(schTicksDo);
		}
		if(t_b.before(schTickMdTime.getT_b()))
			ticksDOList.add(wrapInsertTicksDo(id_scsrv,schDo.getId_sch(), t_b, schTickMdTime.getT_b(), FBoolean.FALSE));
		ticksDOList.add(wrapInsertTicksDo(id_scsrv,schDo.getId_sch(), schTickMdTime.getT_b(), schTickMdTime.getT_e(), FBoolean.TRUE));
		if(t_e.after(schTickMdTime.getT_e()))
			ticksDOList.add(wrapInsertTicksDo(id_scsrv,schDo.getId_sch(), schTickMdTime.getT_e(), t_e, FBoolean.FALSE));
		TicksEP ticksEP = new TicksEP();
		ScSchTicksDO[] ticksDOs = ticksEP.save(ticksDOList.toArray(new ScSchTicksDO[0]));
		for(ScSchTicksDO ticksDO : ticksDOs)
			if(FBoolean.TRUE.equals(ticksDO.getFg_used()))
				return ticksDO;
		throw new BizException("号段时间拆分错误!");
	}
	
	/**
	 * 组装新增的号段do
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param t_b
	 * @param t_e
	 * @param fg_used
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO wrapInsertTicksDo(String id_scsrv,String id_sch, FTime t_b, FTime t_e, FBoolean fg_used)throws BizException{
		ScSchTicksDO schTicksDO = new ScSchTicksDO();
		schTicksDO.setId_scsrv(id_scsrv);
		schTicksDO.setStatus(DOStatus.NEW);
		schTicksDO.setId_grp(ScContextUtils.getGrpId());
		schTicksDO.setId_org(ScContextUtils.getOrgId());
		schTicksDO.setId_sch(id_sch);
		schTicksDO.setT_b(t_b);
		schTicksDO.setT_e(t_e);
		schTicksDO.setQuecn(1);
		schTicksDO.setQuecn_appt(1);
		schTicksDO.setFg_used(fg_used);
		schTicksDO.setFg_active(FBoolean.TRUE);
		
		if(FBoolean.TRUE.equals(fg_used))
			schTicksDO.setQuecn_used(1);
		else
			schTicksDO.setQuecn_used(0);
		return schTicksDO;
	}
	
	
	/**
	 * 预约选择的时间点是否未使用
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @throws BizException
	 */
	private void validate(String id_sch, SchTickMdTimeDTO schTickMdTime) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_TICKS FROM SC_TICKS ");
		sqlBuilder.append("WHERE ID_SCH = ? ");
		sqlBuilder.append("AND FG_USED = ? ");
		sqlBuilder.append("AND T_B < ? ");
		sqlBuilder.append("AND T_E > ? ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(id_sch);
		param.addParam(FBoolean.TRUE);
		param.addParam(schTickMdTime.getT_e());
		param.addParam(schTickMdTime.getT_b());
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!ListUtil.isEmpty(list))
			throw new BizException("开始时间、结束时间在已经使用的时间内，不允许使用。");
	}
}
