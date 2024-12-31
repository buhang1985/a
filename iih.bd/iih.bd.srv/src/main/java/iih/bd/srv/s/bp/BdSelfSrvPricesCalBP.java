package iih.bd.srv.s.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.primd.i.IPriCalService;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 临床医嘱批量计算本服务价格计算操作BP，注：不计算非本服务定价的价格
 */
public class BdSelfSrvPricesCalBP {
	/**
	 * 计算出标准服务在多种患者价格分类下的标准价格，以及对应的价格分类 
	 * @author yzh 2017-05-15 11:11:23
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public Map<String, Map<String, Map<String, SrvPricalRateAndPriceDTO>>> exec1(PriStdSrvDTO[] params) throws BizException{
		if (params == null ||  params.length == 0) return null;
		IPriCalService ipricalsrv = (IPriCalService)ServiceFinder.find(IPriCalService.class);
		if (ipricalsrv == null) return null;
		Map<String, Map<String, Map<String, SrvPricalRateAndPriceDTO>>> result =ipricalsrv.calSrvPriUnderPripatsBatch(params);
		return result;
	}
	
	
	
	
	/**
	 * 临床医嘱服务价格计算
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public PriStdSrvDTO[] exec(BdSrvPriCalParamDTO[] params)  throws BizException{
		//有效性判断处理
		if(!validateCheck(params))return null;
		List<PriStdSrvDTO> selfSrvParams = new ArrayList<PriStdSrvDTO>();
		List<BdSrvPriCalParamDTO> notSrvParams = new ArrayList<BdSrvPriCalParamDTO>();
		List<PriStdSrvDTO> reSrvs = new ArrayList<PriStdSrvDTO>();
		for(BdSrvPriCalParamDTO p:params){
			if(p.getId_primd()==null)continue;
			if(IBdPrimdCodeConst.CODE_PRI_SRV.equals(p.getId_primd()) || 
					   IBdPrimdCodeConst.ID_PRI_SRV.equals(p.getId_primd()))
			{
				PriStdSrvDTO pristd = new PriStdSrvDTO();
				pristd.setId_srv(p.getId_srv());
				pristd.setName_srv(p.getName_srv());
				selfSrvParams.add(pristd);
			}else{
				notSrvParams.add(p);
			}
		}
		IPriCalService ipricalsrv = (IPriCalService)ServiceFinder.find(IPriCalService.class);
		if(selfSrvParams!=null&&selfSrvParams.size()>0)
		{
			PriStdSrvDTO[] self= ipricalsrv.CalManySrvsStdPrices((PriStdSrvDTO[])selfSrvParams.toArray(new PriStdSrvDTO[selfSrvParams.size()]));
			for(PriStdSrvDTO pd :self)
			{
				reSrvs.add(pd);
			}
		}
		if(notSrvParams!=null&&notSrvParams.size()>0)
		{
			if(!validateCheck(params))return null;
			//遍历
			for(int i=0;i<notSrvParams.size();i++){
				FDouble price =getCiOrSrvPrice(notSrvParams.get(i));
				PriStdSrvDTO srvDto = new PriStdSrvDTO();
				srvDto.setId_srv(notSrvParams.get(i).getId_srv());
				srvDto.setPrice(price);
				reSrvs.add(srvDto);
			}
		}
		return reSrvs.toArray(new PriStdSrvDTO[reSrvs.size()]);
	}
	
	/**
	 * 有效性校验
	 * @param id_srv
	 * @param id_primd
	 * @return
	 */
	private boolean validateCheck(BdSrvPriCalParamDTO[] notSrvParams){
		if(notSrvParams==null || notSrvParams.length==0)return false;

		return true;
	}
	/**
	 * 获得医嘱项目参考价格
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private FDouble getCiOrSrvPrice(BdSrvPriCalParamDTO param) throws BizException{
		BdSrvPriceCalBP bp=new BdSrvPriceCalBP();
		return bp.exec(param);
	}
	public static void main(String[] args) throws BizException
	{
		BdSelfSrvPricesCalBP bp = new BdSelfSrvPricesCalBP();
		BdSrvPriCalParamDTO dto = new BdSrvPriCalParamDTO();
		dto.setId_srv("0001AA100000000937WT");
		dto.setName_srv("黑白B超部位加收T1");
		dto.setId_primd("0001AA1000000000VBBV");
		dto.setNum(4);
		FArrayList Srvsetitms = new FArrayList();
		BdSrvPriCalParamDTO dto1 = new BdSrvPriCalParamDTO();
		dto1.setId_srv("0001AA1000000006B70L");
		dto1.setId_primd("0001AA1000000000VBBS");
		BdSrvPriCalParamDTO dto2 = new BdSrvPriCalParamDTO();
		dto2.setId_srv("0001AA10000000090MI7");
		dto2.setId_primd("0001AA1000000000VBBQ");
		BdSrvPriCalParamDTO dto3 = new BdSrvPriCalParamDTO();
		dto3.setId_srv("0001AA10000000090MIC");
		dto3.setId_primd("0001AA1000000000VBBQ");
		BdSrvPriCalParamDTO dto4 = new BdSrvPriCalParamDTO();
		dto4.setId_srv("0001AB1000000005V092");
		dto4.setId_primd("0001AA1000000000VBBQ");
		Srvsetitms.add(dto1);
		Srvsetitms.add(dto2);
		Srvsetitms.add(dto3);
		Srvsetitms.add(dto4);
		dto.setSrvsetitms(Srvsetitms);
		PriStdSrvDTO[] pristo = bp.exec(new BdSrvPriCalParamDTO[]{dto});
		String s="";
	}
}
