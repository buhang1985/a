package iih.ci.ord.s.bp.ems.save.op;

import java.util.List;
import java.util.Random;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.content.d.CiOrIdentifcationInfo;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrContentManager;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDouble;

/**
 * @author yzh
 * 获得医嘱内容相关信息
 * code name content srvtp等
 */
public class GetOrContentRelInfoBP2 {
	
	/**
	 * CI医嘱开立医疗单保存操作
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public  CiOrIdentifcationInfo exec(CiEmsDTO ems,CiOrderDO order,OrdSrvDO[] ordsrvs,FMap mmMap)  throws BizException{
		CiOrIdentifcationInfo rtn=new CiOrIdentifcationInfo();
		if(ems==null)return rtn;
		String[] srvinfo=getCiEmsMainSrvInfo(order,ordsrvs);
		rtn.setCode(getOrCode());
		rtn.setName(srvinfo[2]);
		rtn.setId_srvtp(srvinfo[0]);
		rtn.setSd_srvtp(srvinfo[1]);
		rtn.setContent(getOrContent(ems,ordsrvs,mmMap));
		return rtn;
	}
	/**
	 * 获得医嘱内容
	 * @author yzh
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private String getOrContent(CiEmsDTO ems,OrdSrvDO[] ordsrvs,FMap mmMap) throws BizException{
		FArrayList  srvlist = ems.getEmssrvs();
		if(CiOrdUtils.isEmpty(srvlist)) return null;
		for (OrdSrvDO ordSrvDO : ordsrvs) {
			if(ordSrvDO.getStatus() == DOStatus.DELETED) continue;
			for (Object object : srvlist) {
				CiEmsSrvDTO ciemssrv = (CiEmsSrvDTO) object;
				if(ciemssrv.getId_srv().equals(ordSrvDO.getId_srv())){
					if(ciemssrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG) && !ciemssrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
						if(!CiOrdUtils.isEmpty(mmMap)){
							String key = ciemssrv.getId_srv()+"_"+ciemssrv.getId_mm();
							List<OrdSrvMmDO> mmdos = (List<OrdSrvMmDO>)mmMap.get(key);
							OrdSrvMmDO mmdo = null;
							for(OrdSrvMmDO mm :mmdos){
								if(mm.getStatus()!=DOStatus.DELETED)
								{
									mmdo = mm;
								}
							}
							ciemssrv.setTotal_pri(mmdo.getPrice_pgku_cur());
						}
					}else{
						if(ordSrvDO.getPri() != null){
							ciemssrv.setTotal_pri(new FDouble(CiOrdUtils.getPrettyNumber(ordSrvDO.getPri().toString())));
						}
					}
						continue;
				}
				else{
					ciemssrv.setTotal_pri(ciemssrv.getPrice());
				}
			}
		}
		return CiOrContentManager.getCiOrContentStr(ems,ordsrvs);
	}
	
	private String getOrCode() throws BizException{
		return CiOrdAppUtils.getCiOrdQryService().getCodeOr();
//		return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
		/*String code="";
		code=DateUtils.getDateTimeStr(new Date(),"yyyyMMddHHssSSS");	//暂时先这样吧
		//code=CiOrdUtils.getBillCode(CiOrderDODesc.CLASS_FULLNAME);    //配置编码规则后可取该逻辑
		return ICiDictCodeConst.IIH+code+getRandom();*/
	}
	

	
	/**
	 * 返回六位的随机数
	 * @return
	 * @throws BizException
	 */
	private String getRandom()throws BizException{
		int max = 999999;
   	    int min =100000;
   	   Random rand = new Random();
   	   int tmp = Math.abs(rand.nextInt());
       return (tmp % (max - min + 1) + min)+"";
		 
	}
	
	/**
	 * 获得医嘱主服务信息
	 * @param srvpdvos
	 * @return
	 */
	private OrdSrvDO getCiEmsSrv(CiOrderDO order,OrdSrvDO[] ordsrvs){
		if(CiOrdUtils.isEmpty(ordsrvs))return null;
		for (OrdSrvDO ordSrvDO : ordsrvs) {
			if(order.getId_srv().equals(ordSrvDO.getId_srv())) return ordSrvDO;
		}
		return null;
	}
	
	
	/**
	 * 获得医嘱主服务信息
	 * @param orsrvlist
	 * @return
	 */
	private String[] getCiEmsMainSrvInfo(CiOrderDO order,OrdSrvDO[] ordsrvs){
		String[] rtn=new String[]{"","",""};
		OrdSrvDO mainsrv=getCiEmsSrv(order,ordsrvs);
		if(mainsrv==null)return rtn;
		rtn[0]=mainsrv.getId_srvtp();
		rtn[1]=mainsrv.getSd_srvtp();
		rtn[2]=mainsrv.getName();
		return rtn;
	}
	
}
