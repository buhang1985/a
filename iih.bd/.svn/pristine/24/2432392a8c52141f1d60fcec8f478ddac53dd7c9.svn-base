package iih.bd.srv.s.bp;

import java.lang.reflect.Array;
import java.util.ArrayList;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;

/**
 * 临床医嘱选择服务，服务套套内项目合计价格计算操作BP
 */
public class BdSrvSetSumPriMdCalBP {
	/**
	 * 临床医嘱选择服务，服务套套内项目合计价格计算
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public FDouble exec(BdSrvPriCalParamDTO param)  throws BizException{
		//有效性判断处理
		if(!validateCheck(param))return null;
		
		//获得价格计算服务对象数组信息
		Object[] calsrvgrps=getPriCalSrvObjs(param.getSrvsetitms());
		IPriCalService ipricalsrv=BdAppUtils.getPriCalService();
		
		//参数设置
		FDouble rtn=null;
		PriStdSrvDTO[] stdpris=null;
		
		//本服务定价价格
		if(!BdSrvUtils.isEmpty(calsrvgrps[0])){
			stdpris=ipricalsrv.CalManySrvsStdPrices((PriStdSrvDTO[])calsrvgrps[0]);
			rtn=BdSrvPriHelper.getPriceSum(stdpris);
		}
		
		//组合定价价格
		if(!BdSrvUtils.isEmpty(calsrvgrps[1])){
			stdpris=ipricalsrv.CalMultiSrvCompPrice((String[])calsrvgrps[1]);
			FDouble rtn1=BdSrvPriHelper.getPriceSum(stdpris);
			if(!BdSrvUtils.isEmpty(rtn1)){rtn=rtn1.add(rtn);}
		}
		
		
		return rtn;
	}
	
	/**
	 * 有效性校验
	 * @param id_srv
	 * @param id_primd
	 * @return
	 */
	private boolean validateCheck(BdSrvPriCalParamDTO param){
		if(BdSrvUtils.isEmpty(param))return false;
		if(BdSrvUtils.isEmpty(param.getSrvsetitms()))return false;
		return true;
	}
	
	/**
	 * 获得价格计算服务对象数组信息
	 * @param list
	 * @return
	 */
	private Object[] getPriCalSrvObjs(FArrayList list){
		Object[] rtn=new Object[2];
		BdSrvPriCalParamDTO param=null;
		String id_primd=null;
		ArrayList<PriStdSrvDTO> pristdsrvdtos=new ArrayList<PriStdSrvDTO>();
		ArrayList<String> compoundsrvs=new ArrayList<String>();
		//遍历
		for(int i=0;i<list.size();i++){
			param=(BdSrvPriCalParamDTO)list.get(i);
			id_primd=param.getId_primd();
			if(BdSrvUtils.isEmpty(id_primd))
			{
				try {
					id_primd=BdAppUtils.getMedsrvMDORService().findById(param.getId_srv()).getId_primd();
				} catch (BizException e) {
					e.printStackTrace();
				}
			}
			//判断
			if(BdSrvPriHelper.isSrvSelfPrimd(id_primd)){
				pristdsrvdtos.add(getPriStdSrvDTO(param));
			}else if(BdSrvPriHelper.isSrvCompPrimd(id_primd)){
				compoundsrvs.add(param.getId_srv());
			}else{
				
			}
		}
		if(!BdSrvUtils.isEmpty(pristdsrvdtos)){
			rtn[0]=(PriStdSrvDTO[]) pristdsrvdtos.toArray((PriStdSrvDTO[]) Array.newInstance(PriStdSrvDTO.class, 0));
		}
		if(!BdSrvUtils.isEmpty(compoundsrvs)){
			rtn[1]=(String[]) compoundsrvs.toArray((String[]) Array.newInstance(String.class, 0));
		}
		
		return rtn;
	}
	
	/**
	 * 获得本服务定价数据DTO信息
	 * @param id_srv
	 * @return
	 */
	private PriStdSrvDTO getPriStdSrvDTO(BdSrvPriCalParamDTO param){
		PriStdSrvDTO rtn=new PriStdSrvDTO();
		rtn.setId_srv(param.getId_srv());
		rtn.setName_srv(param.getName_srv());
		return rtn;
	}
}
