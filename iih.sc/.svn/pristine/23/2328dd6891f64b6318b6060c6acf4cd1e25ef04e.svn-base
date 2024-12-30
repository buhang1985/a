package iih.sc.sch.s.ep;

import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchEmpDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.i.IScSchChlDOCudService;
import iih.sc.sch.scsch.i.IScSchChlDORService;
import iih.sc.sch.scsch.i.IScSchEnDOCudService;
import iih.sc.sch.scsch.i.IScSchEnDORService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 排班渠道EP
 * 
 * @author yank
 *
 */
public class SchChlEP {
	/**
	 * 保存
	 * 
	 * @param schChlDOs 排班渠道集合
	 * @throws BizException
	 */
	public ScSchChlDO[] save(ScSchChlDO[] schChlDOs) throws BizException {
		if (ArrayUtil.isEmpty(schChlDOs)) {
			return null;
		}
		IScSchChlDOCudService chlCudService = ServiceFinder.find(IScSchChlDOCudService.class);
		return chlCudService.save(schChlDOs);
	}
	
	/**
	 * 保存
	 * 
	 * @param schChlDOs 排班就诊集合
	 * @throws BizException
	 */
	public ScSchEnDO[] saveEn(ScSchEnDO[] schChlDOs) throws BizException {
		if (ArrayUtil.isEmpty(schChlDOs)) {
			return null;
		}
		IScSchEnDOCudService chlCudService = ServiceFinder.find(IScSchEnDOCudService.class);
		return chlCudService.save(schChlDOs);
	}

	/**
	 * 根据排班ID删除--渠道
	 * 
	 * @param schIdList 排班ID集合
	 * @throws BizException
	 */
	public void deleteBySchIds(List<String> schIdList) throws BizException {
		if (ListUtil.isEmpty(schIdList)) {
			return;
		}
		String whereStr = ScSqlUtils.getInSqlByIds("id_sch", schIdList);
		new DAFacade().deleteByWhere(ScSchChlDO.class, whereStr);
	}
	
	/**
	 * 根据排班ID删除--就诊
	 * 
	 * @param schIdList 排班ID集合
	 * @throws BizException
	 */
	public void deleteByEnIds(List<String> enIdList) throws BizException {
		if (ListUtil.isEmpty(enIdList)) {
			return;
		}
		String whereStr = ScSqlUtils.getInSqlByIds("id_sch", enIdList);
		new DAFacade().deleteByWhere(ScSchEnDO.class, whereStr);
	}
	
	/**
	 * 根据排班ID删除--人员
	 * 
	 * @param schIdList 排班ID集合
	 * @throws BizException
	 */
	public void deleteByEmpIds(List<String> empIdList) throws BizException {
		if (ListUtil.isEmpty(empIdList)) {
			return;
		}
		String whereStr = ScSqlUtils.getInSqlByIds("id_sch", empIdList);
		new DAFacade().deleteByWhere(ScSchEmpDO.class, whereStr);
	}

	/**
	 * 根据排班ID获取排班渠道
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 10:20:12
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	public ScSchChlDO[] getSchChlBySchId(String id_sch) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_sch)) {
			return null;
		}
		IScSchChlDORService qryService = ServiceFinder.find(IScSchChlDORService.class);
		ScSchChlDO[] chlDOs = qryService.find(String.format("id_sch = '%s'", id_sch), null, FBoolean.FALSE);
		return chlDOs;
	}
	/**
	 * 根据排班ID获取排班就诊
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 10:20:12
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	public ScSchEnDO[] getSchChlByEnId(String id_sch) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_sch)) {
			return null;
		}
		IScSchEnDORService qryService = ServiceFinder.find(IScSchEnDORService.class);
		ScSchEnDO[] enDOs = qryService.find(String.format("id_sch = '%s'", id_sch), null, FBoolean.FALSE);
		return enDOs;
	}
	
	/**
	 * 根据排班ID和渠道ID获取排班渠道
	 * 
	 * @param id_sch
	 * @param id_schchl
	 * @return
	 * @throws BizException
	 */
	public ScSchChlDO[] getSchChl(String id_sch, String id_scchl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_sch) || StringUtil.isEmptyWithTrim(id_scchl)) {
			return null;
		}
		IScSchChlDORService qryService = ServiceFinder.find(IScSchChlDORService.class);
		ScSchChlDO[] chlDOs = qryService.find(String.format("id_sch = '%s' and Id_scchl = '%s'", id_sch, id_scchl), null, FBoolean.FALSE);
		return chlDOs;
	}
	/**
	 * 根据排班ID和渠道ID获取排班渠道
	 * 
	 * @param id_sch
	 * @param id_schchl
	 * @return
	 * @throws BizException
	 */
	public ScSchChlDO[] getSchChlByChlCode(String id_sch, String sd_scchl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_sch) || StringUtil.isEmptyWithTrim(sd_scchl)) {
			return null;
		}
		StringBuilder sb  = new StringBuilder();
		sb.append("SELECT SCHL.* FROM SC_SCH_CHL SCHL ");
		sb.append("INNER JOIN SC_CHL CHL ON SCHL.ID_SCCHL = CHL.ID_SCCHL ");
		sb.append("WHERE SCHL.ID_SCH = ? ");
		sb.append("AND CHL.SD_SCCHLTP = ? ");
		sb.append("AND CHL.FG_ACTIVE = ? ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(id_sch);
		param.addParam(sd_scchl);
		param.addParam(FBoolean.TRUE);
		List<ScSchChlDO> list = (List<ScSchChlDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(ScSchChlDO.class));
		return ListUtil.isEmpty(list)?null:list.toArray(new ScSchChlDO[0]);
	}
	/**
	 * 界面数据组装的渠道DO与原数据对比，分出新增，删除，修改的渠道DO
	 * 
	 * @param schId 排版id
	 * @param uiSchChls 界面数据组装的排班渠道
	 * @param schChls 真正保存的排班渠道
	 * @throws BizException
	 */
	public void assemlySchChls(String schId, List<ScSchChlDO> uiSchChls, List<ScSchChlDO> schChls,FBoolean fg_entp) throws BizException{
		ScSchChlDO[] schls = getSchChlBySchId(schId);
		Map<String, ScSchChlDO> oldChlMap = assemlyChlMap(schls);
		if(oldChlMap == null || oldChlMap.size() <= 0){
			schChls.addAll(uiSchChls);
			return;
		}
		for(ScSchChlDO chl : uiSchChls){
			String key = chl.getId_scchl() + chl.getScpolcn();
			if(oldChlMap.containsKey(key)){
				//加入修改的渠道DO
				ScSchChlDO updateChl = oldChlMap.remove(key);
				updateChl.setStatus(DOStatus.UPDATED);
				updateChl.setIds_dep_spec(chl.getIds_dep_spec());
				updateChl.setIds_emp_spec(chl.getIds_emp_spec());
				updateChl.setName_dep_spec(chl.getName_dep_spec());
				updateChl.setName_emp_spec(chl.getName_emp_spec());
				if(fg_entp != null && fg_entp.booleanValue())
				{
					updateChl.setId_entp(chl.getId_entp());
				}
				schChls.add(updateChl);
			}else{
				//加入新增的渠道DO
				chl.setFg_active(FBoolean.TRUE);
				schChls.add(chl);
			}
		}
		//加入删除的渠道DO
		for(ScSchChlDO delChl : oldChlMap.values()){
			delChl.setStatus(DOStatus.DELETED);
			schChls.add(delChl);
		}
	}
	
	/**
	 * 界面数据组装的就诊DO与原数据对比，分出新增，删除，修改的渠道DO
	 * 
	 * @param schId 排版id
	 * @param uiSchChls 界面数据组装的排班渠道
	 * @param schChls 真正保存的排班渠道
	 * @throws BizException
	 */
	public void assemlySchEns(String enId, List<ScSchEnDO> uiSchEns, List<ScSchEnDO> schEns) throws BizException{
		ScSchEnDO[] sens = getSchChlByEnId(enId);
		Map<String, ScSchEnDO> oldChlMap = assemlyEnMap(sens);
		if(oldChlMap == null || oldChlMap.size() <= 0){
			schEns.addAll(uiSchEns);
			return;
		}
		for(ScSchEnDO chl : uiSchEns){
			String key = chl.getId_entp() + chl.getScpolcn();
			if(oldChlMap.containsKey(key)){
				//加入修改的渠道DO
				ScSchEnDO updateChl = oldChlMap.remove(key);
				updateChl.setStatus(DOStatus.UPDATED);
				updateChl.setSd_entp(chl.getSd_entp());
				updateChl.setId_entp(chl.getId_entp());
				schEns.add(updateChl);
			}else{
				//加入新增的渠道DO
				schEns.add(chl);
			}
		}
		//加入删除的渠道DO
		for(ScSchEnDO delChl : oldChlMap.values()){
			delChl.setStatus(DOStatus.DELETED);
			schEns.add(delChl);
		}
	}
	
	/**
	 * 组装渠道字典
	 * 
	 * 因号源池开发数为0时，渠道可以为空，因此以（渠道 + 号源池）为字典key值
	 * @param chls
	 * @return
	 */
	private static Map<String, ScSchChlDO> assemlyChlMap(ScSchChlDO[] schls){
		Map<String, ScSchChlDO> map = new HashMap<>();
		if(ArrayUtil.isEmpty(schls))
			return map;
		for(ScSchChlDO chl : schls){
			//因号源池开发数为0时，渠道可以为空，因此以（渠道 + 号源池）为字典key值
			String key = chl.getId_scchl() + chl.getScpolcn();
			map.put(key, chl);
		}
		return map;
	}
	
	/**
	 * 组装就诊字典
	 * 
	 * 因号源池开发数为0时，渠道可以为空，因此以（就诊 + 号源池）为字典key值
	 * @param chls
	 * @return
	 */
	private static Map<String, ScSchEnDO> assemlyEnMap(ScSchEnDO[] schls){
		Map<String, ScSchEnDO> map = new HashMap<>();
		if(ArrayUtil.isEmpty(schls))
			return map;
		for(ScSchEnDO chl : schls){
			//因号源池开发数为0时，渠道可以为空，因此以（就诊 + 号源池）为字典key值
			String key = chl.getId_entp() + chl.getScpolcn();
			map.put(key, chl);
		}
		return map;
	}
}
