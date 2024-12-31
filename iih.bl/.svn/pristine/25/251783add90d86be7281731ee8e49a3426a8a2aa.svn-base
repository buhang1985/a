package iih.bl.st.blstproxyhp.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.comm.util.BlBaseInfoUtils;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.st.blstproxyhp.d.BlStProxyhpDO;
import iih.bl.st.blstproxyhp.d.BlStProxyhpItmDO;
import iih.bl.st.blstproxyhp.d.BlstproxyhpAggDO;
import iih.bl.st.blstproxyhp.i.IBlstproxyhpCudService;
import iih.bl.st.ettoipsettle.d.EtToIpSettleInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.biz.dto.d.CommonPropDataDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存代报结算_门急诊转住院信息
 * @author LIM
 * @since 2019-07-03
 */
public class BlStProxyhpBp {
	/**
	 * 保存代报结算_门急诊转住院信息
	 * @param entId 住院就诊id
	 * @param cgOepIds 门诊记账id
	 * @param propData 医保分摊数据
	 * @param preIdPmMap 预交金表id和支付方式map
	 * @return
	 * @throws BizException 
	 */
	public BlstproxyhpAggDO[] saveBlStProxyhpDO(EtToIpSettleInfoDTO stInfoDto,String[] cgOepIds,CommonPropDataDTO propData,Map<String,String> preIdPmMap) throws BizException{
		//1.参数校验
		this.valid(stInfoDto, cgOepIds, propData,preIdPmMap);
		//2.组织数据
		BlstproxyhpAggDO tmpBlstproxyhpAggDOArr=this.setBlstproxyhpAggDO(stInfoDto, cgOepIds, propData,preIdPmMap);
		//3.保存数据
		IBlstproxyhpCudService ser =ServiceFinder.find(IBlstproxyhpCudService.class);
		BlstproxyhpAggDO[] blstproxyhpAggDOArr= ser.save(new BlstproxyhpAggDO[]{tmpBlstproxyhpAggDOArr});
		return blstproxyhpAggDOArr;
	}
	
	/**
	 * 数据校验
	 * @param entId
	 * @param cgOepIds
	 * @param propData
	 * @throws BizException
	 */
	private void valid(EtToIpSettleInfoDTO stInfoDto,String[] cgOepIds,CommonPropDataDTO propData,Map<String,String> preIdPmMap) throws BizException{
		if(stInfoDto==null)
		{
			throw new BizException("结算信息不能为空");
		}
		
		if(StringUtil.isEmpty(stInfoDto.getEntid())){
			throw new BizException("就诊ID不能为空！");
		}
		
		if(StringUtil.isEmpty(stInfoDto.getPatcaid())){
			throw new BizException("患者分类不能为空");
		}
		
		if(ArrayUtil.isEmpty(cgOepIds)){
			throw new BizException("门诊记账ID不能为空！");
		}
		if(propData==null){
			throw new BizException("医保分摊数据不能为空！");
		}
		if(preIdPmMap==null){
			throw new BizException("预交金记录数据不能为空！");
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
	private BlstproxyhpAggDO setBlstproxyhpAggDO(EtToIpSettleInfoDTO stInfoDto,String[] cgOepIds,CommonPropDataDTO propData,Map<String,String> preIdPmMap) throws BizException{
		//1.获取服务器时间
		FDateTime serDate= AppUtils.getServerDateTime();
		//2.获取门诊记账数据
		BlCgItmOepDO[] blCgItmOepDOArr=this.getOepCgItmInfo(cgOepIds);
		if(ArrayUtil.isEmpty(blCgItmOepDOArr) ){
			throw new BizException("未查询到门诊记账数据");
		}
		FDouble amt_st = new FDouble();
		FDouble amt_hp = new FDouble();
		FDouble amt_pat = new FDouble();
		FDouble amt = new FDouble();
		for(BlCgItmOepDO cgitm :blCgItmOepDOArr){
			amt_st =amt_st.add(cgitm.getAmt_std());
			//amt_hp =amt_hp.add(cgitm.getAmt_hp());
			//amt_pat =amt_pat.add(cgitm.getAmt_pat());
			amt =amt.add(cgitm.getAmt());
		}
		//3.获取就诊数据
		PatiVisitDO enEnt=BlBaseInfoUtils.getIpEntInfo(stInfoDto.getEntid());
		if(enEnt==null){
			throw new BizException("未查询到患者住院就诊数据");
		}
		//4.组织主表数据
		BlStProxyhpDO blStProxyhpDO= new BlStProxyhpDO();
		blStProxyhpDO.setId_grp(Context.get().getGroupId());
		blStProxyhpDO.setId_org(Context.get().getOrgId());
		blStProxyhpDO.setId_pat(enEnt.getId_pat());
		blStProxyhpDO.setId_enttp(enEnt.getId_entp());
		blStProxyhpDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		blStProxyhpDO.setEu_sttp("39");//先写死，后续定义常量
		blStProxyhpDO.setCode_st(BlCodeUtils.generateOepStCode());
		blStProxyhpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		blStProxyhpDO.setAmt_st(amt_st.setScale(-2, BigDecimal.ROUND_HALF_UP));
		blStProxyhpDO.setAmt_hp(propData.getAmt_hp()==null?FDouble.ZERO_DBL:propData.getAmt_hp().setScale(-2, BigDecimal.ROUND_HALF_UP));
		blStProxyhpDO.setAmt_pat(amt.sub(blStProxyhpDO.getAmt_hp()).setScale(-2, BigDecimal.ROUND_HALF_UP));
		blStProxyhpDO.setAmt(amt.setScale(-2, BigDecimal.ROUND_HALF_UP));
		blStProxyhpDO.setId_emp_st(Context.get().getStuffId());
		blStProxyhpDO.setId_dep_st(Context.get().getDeptId());
		blStProxyhpDO.setDt_st(serDate);
		blStProxyhpDO.setFg_canc(FBoolean.FALSE);
		blStProxyhpDO.setId_ent_tf(stInfoDto.getEntid());
		blStProxyhpDO.setId_patca(stInfoDto.getPatcaid());
		blStProxyhpDO.setStatus(DOStatus.NEW);
		//5.组织子表数据
		List<BlStProxyhpItmDO> blStProxyhpItmDOList= new ArrayList<BlStProxyhpItmDO>();
		if(propData.getAmt_hp() != null && propData.getAmt_hp().compareTo(FDouble.ZERO_DBL) > 0){
			BlStProxyhpItmDO blStProxyhpItmDO= new BlStProxyhpItmDO();
			blStProxyhpItmDO.setEu_direct(BookRtnDirectEnum.CHARGES);
			blStProxyhpItmDO.setAmt(propData.getAmt_hp().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blStProxyhpItmDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_INSUR);
			if(preIdPmMap.containsKey(IBdPripmCodeConst.CODE_PRI_PM_INSUR)){
				blStProxyhpItmDO.setId_paypat(preIdPmMap.get(IBdPripmCodeConst.CODE_PRI_PM_INSUR));
			}else{
				throw new BizException("未找到对应预交金记录");
			}
			blStProxyhpItmDOList.add(blStProxyhpItmDO);
		}
		if(propData.getAmt_psn() != null && propData.getAmt_psn().compareTo(FDouble.ZERO_DBL) > 0){
			BlStProxyhpItmDO blStProxyhpItmDO= new BlStProxyhpItmDO();
			blStProxyhpItmDO.setEu_direct(BookRtnDirectEnum.CHARGES);
			blStProxyhpItmDO.setAmt(propData.getAmt_psn().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blStProxyhpItmDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT);
			if(preIdPmMap.containsKey(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT)){
				blStProxyhpItmDO.setId_paypat(preIdPmMap.get(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT));
			}else{
				throw new BizException("未找到对应预交金记录");
			}
			blStProxyhpItmDO.setStatus(DOStatus.NEW);
			blStProxyhpItmDOList.add(blStProxyhpItmDO);
		}
//		if(blStProxyhpItmDOList.size()<=0){
//			throw new BizException("医保分摊数据中医保基金和个人账户金额同时为0！");
//		}
		BlstproxyhpAggDO blstproxyhpAggDO= new BlstproxyhpAggDO();
		blstproxyhpAggDO.setParentDO(blStProxyhpDO);
		if(!ListUtil.isEmpty(blStProxyhpItmDOList))
		{
			blstproxyhpAggDO.setBlStProxyhpItmDO(blStProxyhpItmDOList.toArray(new BlStProxyhpItmDO[]{}));
			
		}
		return blstproxyhpAggDO;
	}
	
	/**
	 * 获取门诊记账信息
	 * @param cgOepIds
	 * @return
	 * @throws BizException
	 */
	private BlCgItmOepDO[] getOepCgItmInfo(String[] cgOepIds) throws BizException{
		IBlCgItmOepDORService ser = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] blCgItmOepDOArr=ser.findByBIds(cgOepIds, FBoolean.FALSE);
		return blCgItmOepDOArr;
	}
}
