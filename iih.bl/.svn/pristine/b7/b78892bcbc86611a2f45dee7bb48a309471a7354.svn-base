package iih.bl.cg.bliptfin.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.i.IBlcgoepMDORService;
import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import iih.bl.cg.bliptfin.i.IBliptfinCudService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存门诊转住院记账明细
 * @author LIM
 * @since 2019-07-03
 */
public class BlIpTfInBp {
	/**
	 * 保存门诊转住院记账明细
	 * @param entId 住院就诊id
	 * @param blcgoepAggDO 门诊记账数据
	 * @param tfInids 费用转移记录id
	 * @param id_st_proxyhp 代报结算_门急转住院id
	 * @return
	 * @throws BizException 
	 */
	public BlCgIpTfInDO[] exec(String entId,BlCgItmOepDO[] cgItmArr,String[] tfInids,String id_st_proxyhp) throws BizException{
		//1.参数校验
		this.valid(entId, cgItmArr,tfInids, id_st_proxyhp);
		//2.组织数据
		BlCgIpTfInDO[] tmpBlCgIpTfInDOArr=this.setBlCgIpTfInDO(entId, cgItmArr,tfInids,id_st_proxyhp);
		//3.保存数据
		IBliptfinCudService ser = ServiceFinder.find(IBliptfinCudService.class);
		BlCgIpTfInDO[] blCgIpTfInDOArr=ser.save(tmpBlCgIpTfInDOArr);
		return blCgIpTfInDOArr;
	}
	
	/**
	 * 数据校验
	 * @param entId
	 * @param cgOepIds
	 * @param tfInids
	 * @throws BizException
	 */
	private void valid(String entId,BlCgItmOepDO[] cgItmArr ,String[] tfInids,String id_st_proxyhp) throws BizException{
		if(StringUtil.isEmpty(entId)){
			throw new BizException("就诊ID不能为空！");
		}
		if(ArrayUtil.isEmpty(cgItmArr)){
			throw new BizException("门诊记账数据不能为空！");
		}
		if(ArrayUtil.isEmpty(tfInids)){
			throw new BizException("费用转移记录id数据不能为空！");
		}
		if(StringUtil.isEmpty(id_st_proxyhp)){
			throw new BizException("代报结算_门急转住院ID不能为空！");
		}
	}
	
	/**
	 * 组织数据
	 * @param entId
	 * @param blcgoepAggDO
	 * @param tfInids
	 * @return
	 * @throws BizException 
	 */
	private BlCgIpTfInDO[] setBlCgIpTfInDO(String entId,BlCgItmOepDO[] cgItmArr,String[] tfInids,String id_st_proxyhp) throws BizException{
		List<BlCgIpTfInDO> blCgIpTfInDOList= new ArrayList<BlCgIpTfInDO>();

		//查询记账主表
		List<String> cgOepIdList=new ArrayList<>();
		for (BlCgItmOepDO itm : cgItmArr) {
			if(!StringUtil.isEmpty(itm.getId_cgoep())&& !cgOepIdList.contains(itm.getId_cgoep()))
			{
				cgOepIdList.add(itm.getId_cgoep());
			}
		}
		
		Map<String, BlCgOepDO> cgMap=new HashMap<>();
		
		if(!ListUtil.isEmpty(cgOepIdList))
		{
			IBlcgoepMDORService cgService=ServiceFinder.find(IBlcgoepMDORService.class);
			BlCgOepDO[] cgDoArr = cgService.findByIds(cgOepIdList.toArray(new String[0]), FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(cgDoArr))
			{
				for (BlCgOepDO cgDo : cgDoArr) {
					cgMap.put(cgDo.getId_cgoep(), cgDo);
				}
			}
		}
				 
		
		BlCgItmOepDO[] blCgItmOepDOArr= cgItmArr;
		String id_stoep="";
		//1.根据门诊记账id获取门诊结算发票号
		if(!ArrayUtil.isEmpty(blCgItmOepDOArr)){
			for(BlCgItmOepDO blCgItmOepDO : blCgItmOepDOArr){
				if(!StringUtil.isEmpty(blCgItmOepDO.getId_stoep())){
					id_stoep=blCgItmOepDO.getId_stoep();
					break;
				}
			}
		}
		String incNoOep =this.getOpStIncNo(id_stoep);
		//2.获取住院结算信息
		BlStIpDO blStIpDO =this.getBlIpStInfo(entId);
		
		if(!ArrayUtil.isEmpty(blCgItmOepDOArr)){
			//3.组织门诊转住院记账明细数据
			for(int i=0;i<blCgItmOepDOArr.length;i++){
				BlCgIpTfInDO blCgIpTfInDO= new BlCgIpTfInDO();
				BlCgItmOepDO blCgItmOepDO=blCgItmOepDOArr[i];
				blCgIpTfInDO.setId_grp(Context.get().getGroupId());
				blCgIpTfInDO.setId_org(Context.get().getOrgId());
				blCgIpTfInDO.setId_pat(blCgItmOepDO.getId_pat());
				blCgIpTfInDO.setId_ent_tf(entId);
				blCgIpTfInDO.setId_pres(blCgItmOepDO.getId_pres());
				blCgIpTfInDO.setId_or(blCgItmOepDO.getId_or());
				blCgIpTfInDO.setId_orsrv(blCgItmOepDO.getId_orsrv());
				blCgIpTfInDO.setSd_srvtp(blCgItmOepDO.getSd_srvtp());
				blCgIpTfInDO.setId_srvtp(blCgItmOepDO.getId_srvtp());
				blCgIpTfInDO.setId_srv(blCgItmOepDO.getId_srv());
				blCgIpTfInDO.setCode_srv(blCgItmOepDO.getCode_srv());
				blCgIpTfInDO.setName_srv(blCgItmOepDO.getName_srv());
				blCgIpTfInDO.setSrvu(blCgItmOepDO.getSrvu());
				blCgIpTfInDO.setPrice(blCgItmOepDO.getPrice());
				blCgIpTfInDO.setPrice_ratio(blCgItmOepDO.getPrice_ratio());
				blCgIpTfInDO.setRatio_pripat(blCgItmOepDO.getRatio_pripat());
				blCgIpTfInDO.setQuan(blCgItmOepDO.getQuan());
				blCgIpTfInDO.setAmt(blCgItmOepDO.getAmt());
				blCgIpTfInDO.setAmt_std(blCgItmOepDO.getAmt_std());
				blCgIpTfInDO.setAmt_pat(blCgItmOepDO.getAmt_pat());
				blCgIpTfInDO.setAmt_hp(blCgItmOepDO.getAmt_hp());
				blCgIpTfInDO.setAmt_ratio(blCgItmOepDO.getAmt_ratio());
				blCgIpTfInDO.setDt_or(blCgItmOepDO.getDt_or());
				blCgIpTfInDO.setId_dep_or(blCgItmOepDO.getId_dep_or());
				blCgIpTfInDO.setId_emp_or(blCgItmOepDO.getId_emp_or());
				blCgIpTfInDO.setId_dep_mp(blCgItmOepDO.getId_dep_mp());
				blCgIpTfInDO.setFg_mm(blCgItmOepDO.getFg_mm());
				blCgIpTfInDO.setId_mmtp(blCgItmOepDO.getId_mmtp());
				blCgIpTfInDO.setSd_mmtp(blCgItmOepDO.getSd_mmtp());
				blCgIpTfInDO.setId_mm(blCgItmOepDO.getId_mm());
				blCgIpTfInDO.setCode_mm(blCgItmOepDO.getCode_mm());
				blCgIpTfInDO.setName_mm(blCgItmOepDO.getName_mm());
				blCgIpTfInDO.setOnlycode(blCgItmOepDO.getOnlycode());
				blCgIpTfInDO.setSpec(blCgItmOepDO.getSpec());
				blCgIpTfInDO.setCd_batch(blCgItmOepDO.getCd_batch());
				blCgIpTfInDO.setFactor(blCgItmOepDO.getFactor());
				blCgIpTfInDO.setFg_hp_tf(blCgItmOepDO.getFg_hp());
				blCgIpTfInDO.setId_pkgu_base(blCgItmOepDO.getPgku_base());
				blCgIpTfInDO.setId_pkgu_cur(blCgItmOepDO.getPgku_cur());

				BlCgOepDO blCgOepDO= cgMap.get(blCgItmOepDO.getId_cgoep());
				if(blCgOepDO!=null)
				{
					blCgIpTfInDO.setId_emp_cg(blCgOepDO.getId_emp_cg());
					blCgIpTfInDO.setId_dep_cg(blCgOepDO.getId_dep_cg());
					blCgIpTfInDO.setDt_cg(blCgOepDO.getDt_cg());
				}
				blCgIpTfInDO.setIncno(incNoOep);
				if(blStIpDO!=null){
					blCgIpTfInDO.setId_stip_tf(blStIpDO.getId_stip());
					blCgIpTfInDO.setFg_st_tf(FBoolean.TRUE);
					blCgIpTfInDO.setDt_st_tf(blStIpDO.getDt_st());
				}else{
					blCgIpTfInDO.setFg_st_tf(FBoolean.FALSE);
				}
				blCgIpTfInDO.setId_st_proxyhp(id_st_proxyhp);
				blCgIpTfInDO.setId_cgip_tfin(tfInids[i]);
				blCgIpTfInDO.setStatus(DOStatus.NEW);
				blCgIpTfInDOList.add(blCgIpTfInDO);
			}
		}
		return blCgIpTfInDOList.toArray(new BlCgIpTfInDO[]{});
	}
	
	/**
	 * 根据记账id获取门诊发票号
	 * @param cgOepIds
	 * @return
	 * @throws DAException 
	 */
	private String getOpStIncNo(String id_stoep) throws DAException{
		StringBuilder sb= new StringBuilder();
		sb.append("select distinct inc.incno ");
		sb.append(" from bl_inc_oep inc");
		sb.append(" where nvl(inc.incno,'~')<>'~' ");
		sb.append(" and inc.id_stoep=? ");
		SqlParam sqlParam= new SqlParam();
		sqlParam.addParam(id_stoep);
		@SuppressWarnings({ "unchecked"})
		List<String> incNoList = (List<String>) new DAFacade().execQuery(sb.toString(),sqlParam ,new ColumnListHandler());
		if(!ListUtil.isEmpty(incNoList)){
			return incNoList.get(0);
		}
		return "";
	}
	/**
	 * 获取就诊下的住院结算信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private BlStIpDO getBlIpStInfo(String id_ent) throws BizException{
		String sWhere =" Fg_canc='N' and id_ent='"+ id_ent +"'";
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO[] blstipDoArr = stRService.find(sWhere, "", FBoolean.FALSE);
		return !ArrayUtil.isEmpty(blstipDoArr)? blstipDoArr[0]:new BlStIpDO();
	}
	
}
