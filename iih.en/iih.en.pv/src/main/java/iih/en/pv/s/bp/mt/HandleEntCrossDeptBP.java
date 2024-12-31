package iih.en.pv.s.bp.mt;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.i.ICiorapptransdeptRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.desc.EnDepDODesc;
import iih.en.pv.enres.i.IEndepCudService;
import iih.en.pv.enres.i.IEndepRService;

import java.util.HashSet;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 跨科处置
 * 
 * @author liubin
 *	
 */
public class HandleEntCrossDeptBP {
	
	/**
	 * 跨科医嘱签署确认
	 * 
	 * @param ors
	 * @throws BizException 
	 */
	public void addEntCrossDept(CiOrderDO[] ors) throws BizException{
		this.crossOrProcessor(ors, FBoolean.FALSE);
	}
	/**
	 * 跨科医嘱停止确认，作废确认
	 * 
	 * @param ors
	 * @throws BizException 
	 */
	public void delEntCrossDept(CiOrderDO[] ors) throws BizException{
		this.crossOrProcessor(ors, FBoolean.TRUE);
	}
	/**
	 * 跨科医嘱处理
	 * 
	 * @param ors
	 * @param fg_del
	 * @throws BizException
	 */
	private void crossOrProcessor(CiOrderDO[] ors, FBoolean fg_del) throws BizException{
		if(EnValidator.isEmpty(ors))
			return;
		String[] orIds = this.getOrIds(ors);
		ICiorapptransdeptRService serv = ServiceFinder.find(ICiorapptransdeptRService.class);
		OrdApTransDO[] crossOrs = serv.findByAttrValStrings(OrdApTransDO.ID_OR, orIds);
		if(EnValidator.isEmpty(crossOrs))
			return;
		for(OrdApTransDO crossOr : crossOrs){
			if(!(FBoolean.TRUE.equals(crossOr.getFg_crossdept())))
				continue;
			for(CiOrderDO or : ors){
				if(!or.getId_or().equals(crossOr.getId_or()))
					continue;
				if(fg_del.booleanValue())
					this.delCrossDept(or.getId_en(), crossOr.getId_dep_to(), crossOr.getDt_effe(), crossOr.getDt_end());
				else
					this.addCrossDept(or.getId_en(), crossOr.getId_dep_from(), crossOr.getId_dep_to(), crossOr.getDt_effe(), crossOr.getDt_end());
			}
		}
	}
	/**
	 * 跨科医嘱签署确认
	 * 
	 * @param entId
	 * @param nDepId
	 * @param dt_begin
	 * @param dt_end
	 * @throws BizException 
	 */
	private void addCrossDept(String entId, String fromDepId, String toDepId, FDateTime dt_begin, FDateTime dt_end) throws BizException{
		//1.参数检查
		if (EnValidator.isEmpty(entId) || EnValidator.isEmpty(toDepId) || null == dt_begin || null == dt_end)
			return;
		//2.判断是否已经有重叠的跨科处置
		this.volidateEntCrossDept(entId, toDepId, dt_begin, dt_end);
		
		//3.创建新的跨科记录
		this.creatNewEnDep(entId, fromDepId, toDepId, dt_begin, dt_end);
	}
	/**
	 * 跨科医嘱停止确认，作废确认
	 * 
	 * @param entId
	 * @param nDepId
	 * @param dt_begin
	 * @param dt_end
	 * @throws BizException 
	 */
	private void delCrossDept(String entId, String nDepId, FDateTime dt_begin, FDateTime dt_end) throws BizException{
		//1.参数检查
		if (EnValidator.isEmpty(entId) || EnValidator.isEmpty(nDepId) || null == dt_begin || null == dt_end)
			return;
		//2.查询正在使用的跨科记录
		EnDepDO[] depts = this.getEntCrossDept(entId, nDepId, dt_begin);
		
		//3.更新撤销标识和结束时间
		this.updateEntCrossDept(depts, dt_end);
	}
	/**
	 * 取得跨科处置数据
	 * 
	 * @param entId 就诊id
	 * @param nDepId 科室id
	 * @param dt_begin 开始时间
	 * @return
	 * @throws BizException
	 */
	private EnDepDO[] getEntCrossDept(String entId, String nDepId, FDateTime dt_begin)
			throws BizException {
		IEndepRService rService = ServiceFinder.find(IEndepRService.class);
		EnDepDO[] depts = rService.find(EnDepDODesc.TABLE_ALIAS_NAME + ".id_ent  ='" + entId
				+ "' and " + EnDepDODesc.TABLE_ALIAS_NAME + ".id_dep = '" + nDepId + "'" + " and "
				+ EnDepDODesc.TABLE_ALIAS_NAME + " .sd_entdeprole = '"
				+ IEnDictCodeConst.SD_ENTDEPROLE_MT + "' and dt_b ='" + dt_begin + "'" + " and "
				+ EnDepDODesc.TABLE_ALIAS_NAME + ".fg_canc = 'N'", "", FBoolean.FALSE);
		return depts;
	}
	/**
	 * 设置撤销标识
	 * 
	 * @param depts 科室DO数组
	 * @param fgDel 是否删除标识
	 * @return
	 */
	private void updateEntCrossDept(EnDepDO[] depts, FDateTime dt_end) throws BizException {
		if(EnValidator.isEmpty(depts))
			return;
		for (EnDepDO depDO : depts) {
			depDO.setStatus(DOStatus.UPDATED);
			depDO.setFg_canc(FBoolean.TRUE);
			depDO.setDt_e(dt_end);
		}
		IEndepCudService cudService = ServiceFinder.find(IEndepCudService.class);
		cudService.update(depts);
	}

	/**
	 * 查找是否有交叉重叠的数据
	 * 
	 * @param entId 就诊id
	 * @param nDepId 科室id
	 * @param dt_begin 开始时间
	 * @param dt_end 结束时间
	 * @throws BizException
	 */
	private void volidateEntCrossDept(String entId, String nDepId, FDateTime dt_begin,
			FDateTime dt_end) throws BizException {
		IEndepRService rService = ServiceFinder.find(IEndepRService.class);
		EnDepDO[] deptDOs = rService.find(EnDepDODesc.TABLE_ALIAS_NAME + ".id_ent  ='" + entId
				+ "' and " + EnDepDODesc.TABLE_ALIAS_NAME + ".id_dep = '" + nDepId + "'" + " and "
				+ EnDepDODesc.TABLE_ALIAS_NAME + " .sd_entdeprole = '"
				+ IEnDictCodeConst.SD_ENTDEPROLE_MT + "' and " + EnDepDODesc.TABLE_ALIAS_NAME
				+ ".dt_b <='" + dt_end + "' and " + EnDepDODesc.TABLE_ALIAS_NAME + " .dt_e >='"
				+ dt_begin + "' and " + EnDepDODesc.TABLE_ALIAS_NAME + ".fg_canc = 'N'", "",
				FBoolean.FALSE);
		if (!EnValidator.isEmpty(deptDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ADDENTDEPX);
		}
	}

	/**
	 * 创建并保存新的部门do
	 * 
	 * @param entId 就诊id
	 * @param nDepId 科室id
	 * @param dt_begin 开始时间
	 * @param dt_end 结束时间
	 * @param fgDel 是否删除标识
	 * @throws BizException
	 */
	private void creatNewEnDep(String entId, String fromDepId, String toDepId, FDateTime dt_begin, FDateTime dt_end) throws BizException {
		IEndepCudService cudService = ServiceFinder.find(IEndepCudService.class);
		EnDepDO endepDO = new EnDepDO();
		endepDO.setStatus(DOStatus.NEW);
		endepDO.setId_ent(entId);
		endepDO.setId_dep(toDepId);
		endepDO.setId_dep_from(fromDepId);
		endepDO.setId_entdeprole(IEnDictCodeConst.ID_ENTDEPROLE_MT);
		endepDO.setSd_entdeprole(IEnDictCodeConst.SD_ENTDEPROLE_MT);
		endepDO.setDt_b(dt_begin);
		endepDO.setDt_e(dt_end);
		endepDO.setFg_admit(FBoolean.FALSE);
		endepDO.setFg_discharge(FBoolean.FALSE);
		endepDO.setSd_status(IEnDictCodeConst.SD_ENTDEP_STATUS_SUC);
		endepDO.setFg_canc(FBoolean.FALSE);
		cudService.save(new EnDepDO[] { endepDO });
	}
	/**
	 * 获取医嘱Id集合
	 * 
	 * @param ors
	 * @return
	 */
	private String[] getOrIds(CiOrderDO[] ors){
		Set<String> set = new HashSet<>();
		for(CiOrderDO or : ors)
			set.add(or.getId_or());
		return set.toArray(new String[0]);
	}
}
