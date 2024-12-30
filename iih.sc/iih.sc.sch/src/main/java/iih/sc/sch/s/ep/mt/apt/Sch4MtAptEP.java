package iih.sc.sch.s.ep.mt.apt;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.comm.DateTimeUtils;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.scsch.d.desc.ScSchDODesc;
import iih.sc.sch.scsch.i.IScschCudService;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.scsch.i.IScschRService;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksCudService;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 排班BP
 * 
 * @author yankan
 * @since 2015-12-17
 *
 */
public class Sch4MtAptEP {
	/**
	 * 根据ID获取排班DO
	 * 
	 * @param schId 排班ID
	 * @return 排班DO
	 * @throws BizException
	 */
	public ScSchDO getById(String schId) throws BizException {
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schRService.findById(schId);
		return schDO;
	}
	/**
	 * 根据ID获取排班DO
	 * (不查询关联字段)
	 * 
	 * @param schId 排班ID
	 * @return 排班DO
	 * @throws BizException
	 */
	public ScSchDO getByPK(String schId) throws BizException {
		return (ScSchDO) new DAFacade().findByPK(ScSchDO.class, schId);
	}
	/**
	 * 根据ID获取排班DO
	 * (不查询关联字段)
	 * 
	 * @param schId 排班ID
	 * @return 排班DO
	 * @throws BizException
	 */
	public ScSchDO[] getByPKs(String[] schIds) throws BizException {
		if(ArrayUtil.isEmpty(schIds))
			return null;
		List<ScSchDO> list =  (List<ScSchDO>) new DAFacade().findByPKs(ScSchDO.class, schIds);
		return ListUtil.isEmpty(list)?null:list.toArray(new ScSchDO[0]);
	}
	
	/**
	 * 根据ID获取排班DO
	 * 
	 * @param schId 排班ID
	 * @return 排班DO
	 * @throws BizException
	 */
	public ScschAggDO getAggById(String schId) throws BizException {
		IScschRService schRService = ServiceFinder.find(IScschRService.class);
		ScschAggDO schAggDO = schRService.findById(schId);
		return schAggDO;
	}
	/**
	 * 获取排班最大顺序号
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	public Integer getMaxTickNo(String schId) throws BizException{
		String sql = "SELECT MAX(QUENO) AS MAXTICKNO FROM SC_TICK WHERE ID_SCH=?";
		SqlParam param = new SqlParam();
		param.addParam(schId);
		
		Integer maxTickNo = (Integer)new DAFacade().execQuery(sql, param, new ColumnHandler());
		return maxTickNo;
	}
	/**
	 * 占用号源
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池号,0-9
	 * @throws BizException
	 */
	public void occupyTick(String schId, Integer polcn) throws BizException {
		this.occupyTick(schId, polcn, 1);
	}
	/**
	 * 占用号源
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池号,0-9
	 * @throws BizException
	 */
	public boolean occupyTick4Auto(String schId, Integer polcn) throws BizException {
		return this.occupyTick4Auto(schId, polcn, 1);
	}
	/**
	 * 占用号源
	 * 自动定位预约日期
	 * @param schId 排班id
	 * @param polcn 号源池号,0-9
	 * @throws BizException
	 */
	public boolean occupyTick4AutoLocate(String schId, Integer polcn) throws BizException {
		return this.occupyTick4AutoLocate(schId, polcn, 1);
	}
	/**
	 * 占用号源
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池号,0-9
	 * @param tickAmt 号位数
	 * @throws BizException
	 */
	public void occupyTick(String schId, Integer polcn, Integer tickAmt) throws BizException {
		ScSchDO schDO = this.getByPK(schId);
		if (schDO == null) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		}

		this.occupyTick(schDO, polcn, tickAmt);
	}
	/**
	 * 占用号源
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池号,0-9
	 * @param tickAmt 号位数
	 * @throws BizException
	 */
	public boolean occupyTick4Auto(String schId, Integer polcn, Integer tickAmt) throws BizException {
		ScSchDO schDO = this.getByPK(schId);
		if (schDO == null) {
			return false;
		}

		ScSchDO sch = this.occupyTick4Auto(schDO, polcn, tickAmt);
		if(sch == null){
			return false;
		}
		return true;
	}
	/**
	 * 占用号源
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池号,0-9
	 * @param tickAmt 号位数
	 * @throws BizException
	 */
	public boolean occupyTick4AutoLocate(String schId, Integer polcn, Integer tickAmt) throws BizException {
		ScSchDO schDO = this.getByPK(schId);
		if (schDO == null) {
			return false;
		}

		ScSchDO sch = this.occupyTick4AutoLocate(schDO, polcn, tickAmt);
		if(sch == null){
			return false;
		}
		return true;
	}
	/**
	 * 占用号源
	 * 
	 * @param schDO 排班DO
	 * @param polcn 号源池号,0-9
	 * @param tickAmt 号位数量
	 * @throws BizException
	 */
	public ScSchDO occupyTick(ScSchDO schDO, Integer polcn, Integer tickAmt) throws BizException {
		ScValidator.validateParam("schDO", schDO);
		this.validatePolCn(polcn);
		if (!FBoolean.TRUE.equals(schDO.getFg_active())) {
			throw new BizException(IScMsgConst.SC_SCH_CLOSE);// 停诊不能挂号
		}

		String quan_appt_attr = ScSchDO.QUAN0_APPT;
		String quan_used_attr = ScSchDO.QUAN0_USED;
		if (polcn >= 0) {
			quan_appt_attr = String.format("Quan%s_appt", polcn);
			quan_used_attr = String.format("Quan%s_used", polcn);
		}
		Integer apptTotal = Integer.parseInt(schDO.getAttrVal(quan_appt_attr) == null ? "0" : schDO
				.getAttrVal(quan_appt_attr).toString());
		Integer apptUsed = Integer.parseInt(schDO.getAttrVal(quan_used_attr) == null ? "0" : schDO
				.getAttrVal(quan_used_attr).toString());
		// 校验是否有剩余号源
		if ((apptTotal - apptUsed) <= 0) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_USEDUP);
		} else if (apptTotal < (apptUsed + tickAmt)) {
			throw new BizException(IScMsgConst.ERROR_SCH_TICK_NOT_ENOUGHT);
		}
		schDO.setAttrVal(quan_used_attr, apptUsed + tickAmt);// 已使用号源+tickAmt
		schDO.setQuan_total_used(schDO.getQuan_total_used() == null ? tickAmt : schDO
				.getQuan_total_used() + tickAmt);// 总使用数
		schDO.setStatus(DOStatus.UPDATED);
		new DAFacade().updateDO(schDO);
		return schDO;
	}
	/**
	 * 占用号源
	 * 
	 * @param schDO 排班DO
	 * @param polcn 号源池号,0-9
	 * @param tickAmt 号位数量
	 * @throws BizException
	 */
	public ScSchDO occupyTick4Auto(ScSchDO schDO, Integer polcn, Integer tickAmt) throws BizException {
		if(schDO == null) return null;
		boolean check = this.validatePolCn4Auto(polcn);
		if(!check){
			return null;
		}
		if (!FBoolean.TRUE.equals(schDO.getFg_active())) {
			return null;
		}

		String quan_appt_attr = ScSchDO.QUAN0_APPT;
		String quan_used_attr = ScSchDO.QUAN0_USED;
		if (polcn >= 0) {
			quan_appt_attr = String.format("Quan%s_appt", polcn);
			quan_used_attr = String.format("Quan%s_used", polcn);
		}
		Integer apptTotal = Integer.parseInt(schDO.getAttrVal(quan_appt_attr) == null ? "0" : schDO
				.getAttrVal(quan_appt_attr).toString());
		Integer apptUsed = Integer.parseInt(schDO.getAttrVal(quan_used_attr) == null ? "0" : schDO
				.getAttrVal(quan_used_attr).toString());
		// 校验是否有剩余号源
		if ((apptTotal - apptUsed) <= 0) {
			return null;
		} else if (apptTotal < (apptUsed + tickAmt)) {
			return null;
		}
		schDO.setAttrVal(quan_used_attr, apptUsed + tickAmt);// 已使用号源+tickAmt
		schDO.setQuan_total_used(schDO.getQuan_total_used() == null ? tickAmt : schDO
				.getQuan_total_used() + tickAmt);// 总使用数
		schDO.setStatus(DOStatus.UPDATED);
		new DAFacade().updateDO(schDO);
		return schDO;
	}
	/**
	 * 占用号源
	 * 
	 * @param schDO 排班DO
	 * @param polcn 号源池号,0-9
	 * @param tickAmt 号位数量
	 * @throws BizException
	 */
	public ScSchDO occupyTick4AutoLocate(ScSchDO schDO, Integer polcn, Integer tickAmt) throws BizException {
		if(schDO == null) return null;
		boolean check = this.validatePolCn4Auto(polcn);
		if(!check){
			return null;
		}
		if (!FBoolean.TRUE.equals(schDO.getFg_active())) {
			return null;
		}

		String quan_appt_attr = ScSchDO.QUAN0_APPT;
		String quan_used_attr = ScSchDO.QUAN0_USED;
		if (polcn >= 0) {
			quan_appt_attr = String.format("Quan%s_appt", polcn);
			quan_used_attr = String.format("Quan%s_used", polcn);
		}
		Integer apptTotal = Integer.parseInt(schDO.getAttrVal(quan_appt_attr) == null ? "0" : schDO
				.getAttrVal(quan_appt_attr).toString());
		Integer apptUsed = Integer.parseInt(schDO.getAttrVal(quan_used_attr) == null ? "0" : schDO
				.getAttrVal(quan_used_attr).toString());
		// 校验是否有剩余号源
		if ((apptTotal - apptUsed) <= 0) {
			return null;
		} else if (apptTotal < (apptUsed + tickAmt)) {
			return null;
		}
		return schDO;
	}
	/**
	 * 退还票号
	 * 
	 * @param schDO 排班DO
	 * @param polcn 号源池号0-9
	 * @throws BizException
	 */
	public ScSchDO drawbackTick(ScSchDO schDO, Integer polcn) throws BizException {
		return this.drawbackTick(schDO, polcn, 1);
	}

	/**
	 * 退还票号
	 * 
	 * @param schDO 排班DO
	 * @param polcn 号源池号0-9
	 * @param tickAmt 号位数量
	 * @throws BizException
	 */
	public ScSchDO drawbackTick(ScSchDO schDO, Integer polcn, Integer tickAmt) throws BizException {
		if (polcn == null || polcn < 0 || polcn > 10) {
			polcn = 0;// 默认为0号源池，挂号走0号源池
		}
		schDO.setQuan_total_used(schDO.getQuan_total_used() - tickAmt);// 总使用数
		String quan_used_attr = String.format("Quan%s_used", polcn);
		Integer quanUsed = Integer.parseInt(schDO.getAttrVal(quan_used_attr) == null ? "0" : schDO
				.getAttrVal(quan_used_attr).toString());
		if (quanUsed <= 0) {
			throw new BizException(IScMsgConst.ERROR_SCH_USED_IS_EMPTY_CANNOT_DRAWBACK);// 校验是否有剩余号源
		}
		schDO.setAttrVal(quan_used_attr, quanUsed - tickAmt);// 更新已使用号源
		schDO.setStatus(DOStatus.UPDATED);
		ScSchDO[] schDOArray = this.save(new ScSchDO[] { schDO });
		return schDOArray[0];
	}
	/**
	 * 退还票号(把a号源池的号退到b号源池)
	 * 
	 * @param schDO 排班DO
	 * @param polcn 号源池号0-9
	 * @param tickAmt 号位数量
	 * @throws BizException
	 */
	public ScSchDO drawbackTick(ScSchDO schDO, Integer polcn_a, Integer polcn_b, Integer tickAmt) throws BizException {
		if (polcn_a == null || polcn_a < 0 || polcn_a > 10 || polcn_b == null || polcn_b < 0 || polcn_b > 10) {
			throw new BizException("号源池数据错误！");
		}
		//更新总使用数
		schDO.setQuan_total_used(schDO.getQuan_total_used() - tickAmt);
		
		//更新a号源池已使用号源
		String quan_used_attr = String.format("Quan%s_used", polcn_a);
		Integer quanUsed = Integer.parseInt(schDO.getAttrVal(quan_used_attr) == null ? "0" : schDO.getAttrVal(quan_used_attr).toString());
		if (quanUsed <= 0) {
			throw new BizException(IScMsgConst.ERROR_SCH_USED_IS_EMPTY_CANNOT_DRAWBACK);// 校验是否有剩余号源
		}
		schDO.setAttrVal(quan_used_attr, quanUsed - tickAmt);
		
		//更新a号源池可使用号源
		String quan_appt_attr = String.format("Quan%s_appt", polcn_a);
		Integer quanAppt = Integer.parseInt(schDO.getAttrVal(quan_appt_attr) == null ? "0" : schDO.getAttrVal(quan_appt_attr).toString());
		if (quanAppt <= 0) {
			throw new BizException("可使用号源为0，不能退号!");// 校验是否有剩余号源
		}
		schDO.setAttrVal(quan_appt_attr, quanAppt - tickAmt);
		
		//更新b号源池可使用号源
		quan_appt_attr = String.format("Quan%s_appt", polcn_b);
		quanAppt = Integer.parseInt(schDO.getAttrVal(quan_appt_attr) == null ? "0" : schDO.getAttrVal(quan_appt_attr).toString());
		schDO.setAttrVal(quan_appt_attr, quanAppt + tickAmt);		
		
		schDO.setStatus(DOStatus.UPDATED);
		ScSchDO[] schDOArray = this.save(new ScSchDO[] { schDO });
		return schDOArray[0];
	}

	/**
	 * 加号
	 * 
	 * @param schDO 排班DO
	 * @param addNum 加号数量
	 * @param addEnum 加号类型
	 * @param polCn 号源池
	 * @throws BizException
	 */
	public void addTicket(ScSchDO schDO, Integer addNum, Integer addEnum, Integer polCn)
			throws BizException {
		if (addNum == null || addNum <= 0) {
			return;
		}
		this.validatePolCn(polCn);
		schDO.setQuan_total((schDO.getQuan_total() != null ? schDO.getQuan_total() : 0) + addNum); // 号源池加号
		schDO.setQuan_total_appt((schDO.getQuan_total_appt() != null ? schDO.getQuan_total_appt()
				: 0) + addNum); // 可预约总数加号
		String quan_appt_attr = String.format("Quan%s_appt", polCn);
		Integer apptTotal = Integer.parseInt(schDO.getAttrVal(quan_appt_attr) == null ? "0" : schDO
				.getAttrVal(quan_appt_attr).toString());
		schDO.setAttrVal(quan_appt_attr, apptTotal + addNum);// 在指定号源池上加号
		if (EuAddTickMod.JH.equals(addEnum)) {
			schDO.setAddquecn((schDO.getAddquecn() != null ? schDO.getAddquecn() : 0) + addNum); // 加号数增加
		}
		schDO.setStatus(DOStatus.UPDATED);
		IScschMDOCudService schCudService = ServiceFinder.find(IScschMDOCudService.class);
		schCudService.save(new ScSchDO[] { schDO });
	}

	/**
	 * 减号
	 * 
	 * @param schDO 排班DO
	 * @param subNum 减号数量
	 * @param addEnum 加号类型
	 * @param polcn 号源池
	 * @throws BizException
	 */
	public void subTicket(ScSchDO schDO, Integer subNum, Integer addEnum, Integer polcn)
			throws BizException {
		if (subNum == null || subNum <= 0) {
			return;
		}
		this.validatePolCn(polcn);
		if (schDO.getQuan_total_appt() < subNum) {
			throw new BizException(IScMsgConst.ERROR_SCH_NOT_ENOUGH_FOR_SUB);
		}
		schDO.setQuan_total_appt(schDO.getQuan_total_appt() - subNum); // 总预约号
		// 指定号源池上加号
		String quan_appt_attr = String.format("Quan%s_appt", polcn);
		String quan_used_attr = String.format("Quan%s_used", polcn);
		Integer apptTotal = Integer.parseInt(schDO.getAttrVal(quan_appt_attr) == null ? "0" : schDO
				.getAttrVal(quan_appt_attr).toString());
		Integer apptUsed = Integer.parseInt(schDO.getAttrVal(quan_used_attr) == null ? "0" : schDO
				.getAttrVal(quan_used_attr).toString());
		if (apptTotal - apptUsed < subNum) {
			throw new BizException(IScMsgConst.ERROR_SCH_POL_NOT_ENOUGH_FOR_SUB);
		}
		schDO.setAttrVal(quan_appt_attr, apptTotal - subNum);// 可预约号源
		schDO.setQuan_total((schDO.getQuan_total() != null ? schDO.getQuan_total() : 0) - subNum); // 总数减号
		schDO.setAddquecn((schDO.getAddquecn() != null ? schDO.getAddquecn() : 0) - subNum);// 加号数量也要减少
		schDO.setStatus(DOStatus.UPDATED);
		IScschMDOCudService schCudService = ServiceFinder.find(IScschMDOCudService.class);
		schCudService.save(new ScSchDO[] { schDO });
	}

	/**
	 * 保存排班
	 * 
	 * @param schDOs 排班DO集合
	 * @return
	 * @throws BizException
	 */
	public ScSchDO[] save(ScSchDO[] schDOs) throws BizException {
		if(ArrayUtil.isEmpty(schDOs)){
			return schDOs;
		}
		IScschMDOCudService schCudService = ServiceFinder.find(IScschMDOCudService.class);
		schCudService.save(schDOs);
		return schDOs;
	}
	/**
	 * 保存排班
	 * 
	 * @param schDOs 排班DO集合
	 * @return
	 * @throws BizException
	 */
	public ScSchDO[] update(ScSchDO[] schDOs) throws BizException {
		if(ArrayUtil.isEmpty(schDOs)){
			return schDOs;
		}
		IScschMDOCudService schCudService = ServiceFinder.find(IScschMDOCudService.class);
		schCudService.update(schDOs);
		return schDOs;
	}

	/**
	 * 验证号源池
	 * 
	 * @param polCn 号源池
	 */
	private void validatePolCn(Integer polCn) throws BizException {
		if (polCn == null || polCn < 0 || polCn > 9) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
		}
	}
	/**
	 * 验证号源池
	 * 
	 * @param polCn 号源池
	 */
	private boolean validatePolCn4Auto(Integer polCn) throws BizException {
		if (polCn == null || polCn < 0 || polCn > 9) {
			return false;
		}
		return true;
	}
	/**
	 * 根据条件获取排班
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchDO[] getSchByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		return schRService.find(cond, order, FBoolean.FALSE);
	}
	
	/**
	 * 查找某些日期的排班agg
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws BizException
	 */
	public  ScschAggDO[] getSchs( List<String> dataList,String plId,String sctp) throws BizException {
		IScschRService schRService = ServiceFinder.find(IScschRService.class);
		String str = ScSqlUtils.buildIdStr(dataList);
		ScschAggDO[] schAggs = schRService.find(ScSchDODesc.TABLE_ALIAS_NAME +".d_sch in ("+str
				+") and "+ScSchDODesc.TABLE_ALIAS_NAME+".id_scpl ='"+plId+"' and " + ScSchDODesc.TABLE_ALIAS_NAME
				+".Sd_sctp ='"+sctp+"'"  , "", FBoolean.FALSE);
		return schAggs;
	}
	/**
	 * 删除排班agg
	 * @param delList
	 * @throws BizException
	 */
	public void delSchs(List<ScschAggDO> delList ) throws BizException{
		if(ListUtil.isEmpty(delList))
			return;
		IScschCudService schCudService = ServiceFinder.find(IScschCudService.class);
		schCudService.delete(delList.toArray(new ScschAggDO[]{} ));
	}
	/**
	 * 保存排班agg
	 * @param saveList
	 * @throws BizException
	 */
	public ScschAggDO[] saveSchAggs(List<ScschAggDO> saveList ) throws BizException{
		if(ListUtil.isEmpty(saveList))
			return null;
		IScschCudService schCudService = ServiceFinder.find(IScschCudService.class);
		ScschAggDO[] aggdos = schCudService.save(saveList.toArray(new ScschAggDO[]{} ));
		return aggdos;
	}
	/**
	 * 保存号位
	 * @param tickDO
	 * @throws BizException
	 */
	public void SaveSchTick(ScSchTickDO[] tickDO) throws BizException{
		ISctickCudService rService = ServiceFinder.find(ISctickCudService.class);
		ScSchTickDO[] res = rService.save(tickDO);
	}
	
	/**
	 * 保存号段
	 * @param tickDO
	 * @throws BizException
	 */
	public ScSchTicksDO[] SaveSchTicks(ScSchTicksDO[] tickDO) throws BizException{
		IScticksCudService rService = ServiceFinder.find(IScticksCudService.class);
		return rService.save(tickDO);
	}
	/**
	 * 删除排班信息
	 * @param schIds 排班ID集合
	 * @throws BizException
	 */
	public void delete(String[] schIds) throws BizException{
		if(ArrayUtil.isEmpty(schIds))return;
		IScschRService schRService = ServiceFinder.find(IScschRService.class);
		ScschAggDO[] aggs = schRService.findByIds(schIds, FBoolean.FALSE);
		IScschCudService schCudService = ServiceFinder.find(IScschCudService.class);
		schCudService.delete(aggs);
	}

	/**
	 * SQL直接删除
	 * 不经过DO校验等
	 * @param schIds 排班ID集合
	 * @throws BizException
	 */
	public void deleteByIds(String[] schIds) throws BizException{
		if(ArrayUtil.isEmpty(schIds)) 
			return;
		
		new DAFacade().deleteByPKs(ScSchDO.class, schIds);
	}
	/**
	 * 删除排班
	 * 
	 * @param schDOs 排班DO集合
	 * @return
	 * @throws BizException
	 */
	public void delete(ScSchDO[] schDOs) throws BizException {
		if(ArrayUtil.isEmpty(schDOs)){
			return;
		}
		IScschMDOCudService schCudService = ServiceFinder.find(IScschMDOCudService.class);
		schCudService.delete(schDOs);
	}
	/**
	 * 判定排班已经使用
	 * 
	 * @param schDO
	 * @return
	 */
	public boolean isUsed(ScSchDO schDO) {
		return schDO.getQuan_total_used() != null && schDO.getQuan_total_used().compareTo(0) > 0;
	}

	/**
	 * 是否已经过时
	 * 
	 * @param schDO 排班DO
	 * @param currentTime 当前时间
	 * @return
	 * @throws BizException
	 */
	public boolean isPast(ScSchDO schDO, FDateTime currentTime) throws BizException {
		if (currentTime.getDate().before(schDO.getD_sch())) {
			return false;
		} else if (DateTimeUtils.isToday(schDO.getD_sch().asLocalBegin())) {
			return currentTime.getUFTime().after(schDO.getT_e_reg());
		}

		return true;
	}
	/**
	 * 根据ID获取排班DO
	 * 
	 * @param schId 排班ID
	 * @return 排班DO
	 * @throws BizException
	 */
	public ScSchDO[] getByIds(String[] schIds) throws BizException {
		if(ArrayUtil.isEmpty(schIds)){
			return null;
		}
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO[] schDOs = schRService.findByIds(schIds,FBoolean.FALSE);
		return schDOs;
	}
	
	/**
	 * 根据ID获取排班DO
	 * 
	 * @param schId 排班ID
	 * @return 排班DO
	 * @throws BizException
	 */
	public void saveSchDOs(ScSchDO[] schdos) throws BizException {
		if(ArrayUtil.isEmpty(schdos)){
			return ;
		}
		IScschMDOCudService schRService = ServiceFinder.find(IScschMDOCudService.class);
		schRService.save(schdos);
		return ;
	}
	/**
	 * 排班是否被使用
	 * @param schId
	 * @return
	 */
	public boolean isSchUsed(String schId) throws BizException{
		if(StringUtil.isEmpty(schId))
			return false;
		IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
		ScAptDO[] scAptDOs = aptRService.find("id_sch= '"+schId+"' and sd_status in('"+IScDictCodeConst.SD_APTSTATUS_ORDER+"','"
				+IScDictCodeConst.SD_APTSTATUS_PAY+"','"+IScDictCodeConst.SD_APTSTATUS_FINISH+"')", "", FBoolean.FALSE);// 获取预约数据
        if(!ArrayUtil.isEmpty(scAptDOs))
			return true;
    	
    	StringBuilder builder = new StringBuilder();
		builder.append("SELECT *");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN EN_ENT_OP OP ON OP.ID_ENT = EN.ID_ENT ");
		builder.append("INNER JOIN EN_ENT_QUE EQ ON EQ.ID_ENT = EN.ID_ENT ");
		builder.append("WHERE  OP.SD_STATUS in(?,?,?,?,?,?,?) ");
		builder.append(" AND OP.ID_SCH =?");
		builder.append(" AND EN.FG_CANC =?");
		SqlParam param = new SqlParam();

		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER);
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_CONTINUE);
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_EM_REGISTER);
		
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_EM_REPORT);
		param.addParam(schId);
		param.addParam(FBoolean.FALSE);
		List<OutpatientDO> opDOs = (List<OutpatientDO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(OutpatientDO.class));

		 if(!ListUtil.isEmpty(opDOs))
				return true;
		return false;
	}
	
}
