package iih.ci.ord.s.bp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.TransSrvSplitOrderDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.GetOrAndSrvSplitSqlRsBP;
import iih.ci.ord.s.bp.orsrvsplit.SplitOrAndSrvSplitSqlRsBP;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.mporplan.d.desc.MpOrPlanDODesc;
import iih.mp.nr.mporplan.i.IMporplanRService;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 新的药品组装逻辑   直接从执行域获取数据
 * @author li_cheng
 *
 */
public class splitSrvSplitSqlRsBPNew {
	
	public TransSrvSplitOrderDTO[] exec(OrSrvSplitParamDTO param)throws BizException{		

//		GetOrAndSrvSplitSqlRsBP getsrvbp=new GetOrAndSrvSplitSqlRsBP();	
//        BaseDTO[] splitDTO=getsrvbp.exec(param); 
		long span=System.currentTimeMillis();
		getMpSplitDataBP getsrvbp=new getMpSplitDataBP();	
        BaseDTO[] splitDTO=getsrvbp.exec(param);  
        System.out.println("查询医嘱时间"+(System.currentTimeMillis()-span));
        TransSrvSplitOrderDTO[] srvsplits=getTransDTO( param,splitDTO);
        return srvsplits;
		
	}
	
	private TransSrvSplitOrderDTO[] getTransDTO(OrSrvSplitParamDTO param,BaseDTO[] splitDTO) throws BizException{
		if(splitDTO==null||splitDTO.length==0)return null;
		List<TransSrvSplitOrderDTO> translist=new ArrayList<>();
		SrvSplitOrderDTO[] srvdto=srvfilter(splitDTO);
		if(srvdto==null||srvdto.length==0)return null;
		Map<String,List<SrvSplitOrderDTO>> orsrvmap= mapSrvSplitOrderDTO(srvdto);
		String[] idors= getidors(srvdto);
		MpOrPlanDO[] mps=ServiceFinder.find(IForeignService.class).getEffectiveOrPlans(idors,  param.getDt_split_start(), param.getDt_split_end());
//		MpOrPlanDO[] mps=getMpOrPlans(getidors2(idors), param);//临时方案，到时调执行域的接口
		for (MpOrPlanDO orPlanDO : mps) {
			if(!orsrvmap.containsKey(orPlanDO.getId_or()))continue;
			List<SrvSplitOrderDTO> sb=orsrvmap.get(orPlanDO.getId_or());
			for (SrvSplitOrderDTO o : sb) {				
				translist.add(createTransdto( orPlanDO,o ));
			}
				
		}
		return translist.toArray(new TransSrvSplitOrderDTO[0]);
	}
	/**
	 * 数据过滤
	 * @param splitDTO
	 * @return
	 */
	private SrvSplitOrderDTO[] srvfilter( BaseDTO[] splitDTO){
		List<SrvSplitOrderDTO> sb=new  ArrayList<>();
		
		for (BaseDTO baseDTO : splitDTO) {
			SrvSplitOrderDTO srvsplitorder=(SrvSplitOrderDTO)baseDTO;
			//过滤出院带药
			if((srvsplitorder.getFg_pres_outp()!=null)&&FBoolean.TRUE.equals(srvsplitorder.getFg_pres_outp()))continue;
			//过滤草药
			if(srvsplitorder.getSd_srvtp()!=null&&(srvsplitorder.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)||srvsplitorder.getSd_srvtp().indexOf(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)==0))continue;
			//过滤持续类医嘱
			if(srvsplitorder.getSd_frequnit()!=null&&IBdSrvDictCodeConst.SD_FREQNUNITCT_ALWAYS.equals(srvsplitorder.getSd_frequnit()))continue;
			//过滤掉fg_or=false的医嘱
			if(!FBoolean.TRUE.equals(srvsplitorder.getFg_or()))continue;
			
			sb.add(srvsplitorder);	    	
		}
		return sb.toArray(new SrvSplitOrderDTO[0]);
	}
	
	/**
	 * 获取id_or
	 * @param splitDTO
	 * @return
	 */
	private String[] getidors( BaseDTO[] splitDTO){
		List<String> sb=new  ArrayList<>();
		for (BaseDTO baseDTO : splitDTO) {
			SrvSplitOrderDTO srvsplitorder=(SrvSplitOrderDTO)baseDTO;			
			if(!sb.contains(srvsplitorder.getId_or())){
				sb.add(srvsplitorder.getId_or());
			}		    			
		}
		return sb.toArray(new String[0]);
	}
	
	private String getidors2(String[] sl){
		StringBuilder sb=new StringBuilder();
		for (String o : sl) {
			if(sb.length()==0){
				sb.append("'"+o+"'");
			}else{
				sb.append(",'"+o+"'");
			}
		}
		return "("+sb.toString()+")";
	}
	
	
	
	/**
	 * 构建组装的执行数据
	 * @param orPlanDO
	 * @param srvsplit
	 * @return
	 */
	private TransSrvSplitOrderDTO createTransdto(MpOrPlanDO orPlanDO,SrvSplitOrderDTO srvsplit ){
		
		TransSrvSplitOrderDTO tsrv=new TransSrvSplitOrderDTO();
		tsrv.setId_or(srvsplit.getId_or());
		tsrv.setDt_effe(srvsplit.getDt_effe());
		tsrv.setDt_mp_plan(orPlanDO.getDt_mp_plan());
		tsrv.setFg_long(srvsplit.getFg_long());
		tsrv.setDt_stop(srvsplit.getDt_stop());
		tsrv.setFreqcnt(srvsplit.getFreqcnt());
		tsrv.setId_orsrv(srvsplit.getId_orsrv());
		tsrv.setId_srv(srvsplit.getId_srv());
		
		tsrv.setId_srvtp(srvsplit.getId_srvtp());
		tsrv.setSd_srvtp(srvsplit.getSd_srvtp());
		tsrv.setCode_srv(srvsplit.getCode_srv());
		tsrv.setOrsrv_su_mp(orPlanDO.getEu_su()==null?"0":orPlanDO.getEu_su()+"");
		tsrv.setName_srv(srvsplit.getName_srv());
		return tsrv;
		
	}
	
	private Map<String,List<SrvSplitOrderDTO>> mapSrvSplitOrderDTO(SrvSplitOrderDTO[] srvdto){
		
		Map<String,List<SrvSplitOrderDTO>> map=new HashMap<>();
		for (SrvSplitOrderDTO srvSplitOrderDTO : srvdto) {
			if(map.containsKey(srvSplitOrderDTO.getId_or())){
				List<SrvSplitOrderDTO> sb=map.get(srvSplitOrderDTO.getId_or());
				sb.add(srvSplitOrderDTO);
			}else{
				List<SrvSplitOrderDTO> sb=new  ArrayList<>();
				sb.add(srvSplitOrderDTO);
				map.put(srvSplitOrderDTO.getId_or(), sb);
			}
		}
		return map;
	}
	
	//获取执行计划明细
	private MpOrPlanDO[] getMpOrPlans(String sql,OrSrvSplitParamDTO param) throws BizException{

		IMporplanRService rservice=ServiceFinder.find(IMporplanRService.class);
		MpOrPlanDO[] mps=rservice.find(MpOrPlanDODesc.TABLE_ALIAS_NAME+".id_or in "+sql
				+" and "+MpOrPlanDODesc.TABLE_ALIAS_NAME+".dt_mp_plan>='"+param.getDt_split_start()+
				"' and "+MpOrPlanDODesc.TABLE_ALIAS_NAME+".dt_mp_plan<='"+param.getDt_split_end()+"'", null, FBoolean.FALSE);

		return mps;
	}
}
