package iih.bl.cg.blcgoeptf.bp;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfCudService;
import iih.bl.comm.util.BlBaseInfoUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存门诊记账转移记录
 * @author LIM
 * @since 2019-07-03
 */
public class BlCgOepTfBp {
	/**
	 * 保存门诊记账转移记录
	 * @param id_pat 患者id
	 * @param id_ent 就诊id
	 * @param cgOepTfInMap 门诊记账门诊转住院记账明细map
	 * @return
	 * @throws BizException 
	 */
	public BlCgItmOepTfRcdDO[] exec(String id_ent,Map<String,String> cgOepTfInMap) throws BizException{
		//1.参数校验
		this.valid(id_ent, cgOepTfInMap);
		//2.组织数据
		BlCgItmOepTfRcdDO[] tmpBlCgItmOepTfRcdDOArr=this.setBlPrePayPatDOArr(id_ent, cgOepTfInMap);
		//3.保存数据
		IBlcgoeptfCudService ser=ServiceFinder.find(IBlcgoeptfCudService.class);
		BlCgItmOepTfRcdDO[] blCgItmOepTfRcdDOArr=ser.save(tmpBlCgItmOepTfRcdDOArr);
		return blCgItmOepTfRcdDOArr;
	}
	
	/**
	 * 参数校验
	 * @param id_pat
	 * @param id_ent
	 * @param cgOepTfInMap
	 * @throws BizException
	 */
	private void valid(String id_ent,Map<String,String> cgOepTfInMap) throws BizException{
		if(StringUtil.isEmpty(id_ent)){
			throw new BizException("就诊ID不能为空！");
		}
		if(cgOepTfInMap==null){
			throw new BizException("门诊转住院记账明细数据不能为空！");
		}
	}
	
	/**
	 * 组织数据
	 * @param entId
	 * @param cgOepIds
	 * @param propData
	 * @return
	 * @throws BizException 
	 */
	private BlCgItmOepTfRcdDO[] setBlPrePayPatDOArr(String id_ent,Map<String,String> cgOepTfInMap) throws BizException{
		List<BlCgItmOepTfRcdDO> blCgItmOepTfRcdDOList= new ArrayList<BlCgItmOepTfRcdDO>();
		//1.获取服务器时间
		FDateTime serDate= AppUtils.getServerDateTime();
		//2.获取就诊信息
		PatiVisitDO enEnt=BlBaseInfoUtils.getIpEntInfo(id_ent);
		for(String strKey : cgOepTfInMap.keySet()){
			BlCgItmOepTfRcdDO blCgItmOepTfRcdDO= new BlCgItmOepTfRcdDO();
			blCgItmOepTfRcdDO.setId_grp(Context.get().getGroupId());
			blCgItmOepTfRcdDO.setId_org(Context.get().getOrgId());
			blCgItmOepTfRcdDO.setId_pat(enEnt!=null?enEnt.getId_pat():"");
			blCgItmOepTfRcdDO.setId_ent_tf(id_ent);
			blCgItmOepTfRcdDO.setId_cgitmoep(strKey);
			blCgItmOepTfRcdDO.setId_cgtfin(cgOepTfInMap.get(strKey));
			blCgItmOepTfRcdDO.setId_dep_tf(Context.get().getDeptId());
			blCgItmOepTfRcdDO.setId_emp_tf(Context.get().getStuffId());
			blCgItmOepTfRcdDO.setDt_tf(serDate);
			blCgItmOepTfRcdDO.setFg_active(FBoolean.TRUE);
			blCgItmOepTfRcdDO.setFg_realtf(FBoolean.TRUE);
			blCgItmOepTfRcdDO.setStatus(DOStatus.NEW);
			blCgItmOepTfRcdDOList.add(blCgItmOepTfRcdDO);
		}
		return blCgItmOepTfRcdDOList.toArray(new BlCgItmOepTfRcdDO[]{});
	}
}
