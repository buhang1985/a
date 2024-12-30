package iih.sc.sch.s.bp;

import iih.sc.comm.DateTimeUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.dto.d.SchTickMdTimeDTO;
import iih.sc.sch.s.ep.SchChlEP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickChlEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.s.bp.OccupyTicks4TimeMdBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据排班和时间片时段占用号位(根据渠道)
 * 
 * @author liubin
 *
 */
public class OccupyChlTickByAchAndTimeBP {
	/**
	 * 根据排班和时间片时段占用号位
	 * 
	 * 
	 * @param schId
	 * @param schTickMdTime
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO exec(String id_sch, SchTickMdTimeDTO schTickMdTime, String id_scchl) throws BizException {
		//1.校验参数
		this.validateParam(id_sch, schTickMdTime, id_scchl);
		
		//2.查询排班渠道信息
		ScSchChlDO schChlDo = getScSchChlDO(id_sch, id_scchl);
		//3.排班加锁
		lockSch(id_sch);
		//4.验证排班剩余时间是否足够使用
		validateSch(id_sch, schTickMdTime, schChlDo.getScpolcn());
		//5.占用号段
		ScSchTicksDO schTicks = occupyTicks(id_sch, schTickMdTime);
		//6.占用号位
		ScSchTickDO schTickDO = occupyTick(schTicks, schChlDo.getScpolcn());
		//7.占用排班号源
		occupySch(id_sch, schTickMdTime, schChlDo.getScpolcn());
		return schTickDO;
	}
	
	/**
	 * 参数校验
	 * 
	 * @author liubin
	 * 
	 * @param schId
	 * @param schTickMdTime
	 * @param id_scchl
	 * @throws BizException
	 */
	private void validateParam(String id_sch, SchTickMdTimeDTO schTickMdTime, String id_scchl) throws BizException {
		ScValidator.validateParam("OccupyChlTickByAchAndTimeBP.exec()", "id_sch", id_sch);
		ScValidator.validateParam("OccupyChlTickByAchAndTimeBP.exec()", "schTickMdTime", schTickMdTime);
		ScValidator.validateParam("OccupyChlTickByAchAndTimeBP.exec()", "id_scchl", id_scchl);
		if(schTickMdTime.getT_b() == null)
			throw new BizException("选择时间段开始时间不能为空！");
		if(schTickMdTime.getT_e() == null)
			throw new BizException("选择时间段结束时间不能为空！");
		if(schTickMdTime.getT_b().after(schTickMdTime.getT_e()))
			throw new BizException("选择时间段开始时间不能小于结束时间！");
	}
	/**
	 * 排班加锁
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @throws BizException
	 */
	private void lockSch(String id_sch) throws BizException{
		TickChlEP tickEP = new TickChlEP();
		tickEP.lockSch(id_sch);
	}
	/**
	 * 获取排班渠道信息
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param id_schchl
	 * @return
	 * @throws BizException
	 */
	private ScSchChlDO getScSchChlDO(String id_sch, String id_scchl) throws BizException{
		SchChlEP schChlEp = new SchChlEP();
		ScSchChlDO[] schChlDOs = schChlEp.getSchChl(id_sch, id_scchl);
		if(ArrayUtil.isEmpty(schChlDOs)){
			IScBdOutQryService bdQry = ServiceFinder.find(IScBdOutQryService.class);
			SchedulechlDO chl = bdQry.getChlById(id_scchl);
			if(chl == null)
				throw new BizException("未找到该渠道排班信息!");
			else
				throw new BizException(String.format("未找到渠道[%s]排班信息!", chl.getName()));
		}
		return schChlDOs[0];
	}
	/**
	 * 验证排班剩余时间是否足够使用
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @throws BizException
	 */
	private void validateSch(String id_sch, SchTickMdTimeDTO schTickMdTime, Integer polcn) throws BizException{
		SchEP schBP = new SchEP();
		ScSchDO schDo = schBP.getByPK(id_sch);
		if(schTickMdTime.getT_b().before(schDo.getT_b_acpt())
				|| schTickMdTime.getT_e().after(schDo.getT_e_acpt()))
			throw new BizException(String.format("选择的时间段必须在诊疗时间内![%s-%s]", schDo.getT_b_acpt(), schDo.getT_e_acpt()));
		int mins = DateTimeUtils.getMins(schTickMdTime.getT_b(), schTickMdTime.getT_e());
		Integer canUse = (Integer)schDo.getAttrVal(String.format("Quan%s_appt", polcn)) - (Integer)schDo.getAttrVal(String.format("Quan%s_used", polcn));
		if(canUse.intValue() < mins)
			throw new BizException("选择的时间段时长大于排班剩余时长!");
	}
	/**
	 * 时间片模式占用号段处理
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO occupyTicks(String id_sch, SchTickMdTimeDTO schTickMdTime) throws BizException{
		OccupyTicks4TimeMdBP bp = new OccupyTicks4TimeMdBP();
		ScSchTicksDO schTicks = bp.exec(id_sch, schTickMdTime);
		if(schTicks == null)
			throw new BizException("时间片模式占用号段出错!");
		return schTicks;
	}
	/**
	 * 时间片模式占用号位处理
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO occupyTick(ScSchTicksDO schTicks, Integer polcn) throws BizException{
		TickEP ep = new TickEP();
		ScSchTickDO[] schTickDOs = ep.insert4TimeMd(schTicks, polcn,null);
		if(ArrayUtil.isEmpty(schTickDOs))
			throw new BizException("时间片模式新增号位出错!");
		return schTickDOs[0];
	}
	/**
	 * 占用排班号源
	 * 
	 * @author liubin
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @param polcn
	 * @throws BizException
	 */
	private void occupySch(String id_sch, SchTickMdTimeDTO schTickMdTime, Integer polcn)throws BizException{
		int mins = DateTimeUtils.getMins(schTickMdTime.getT_b(), schTickMdTime.getT_e());
		SchEP schBP = new SchEP();
		schBP.occupyTick(id_sch, polcn, mins);
	}
}
