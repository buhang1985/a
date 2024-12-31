package iih.bd.srv.s.bp.iemsg;



import java.util.HashMap;
import java.util.Map;

import iih.bd.srv.iemsg.d.IESrvLisRelDictDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 集成平台服务和Lis项目关系处理
 * @author liu_xiaoying
 *
 */
public class SetIEMsgInfo4SrvLisRelBP {

	public boolean exec(IESrvLisRelDictDTO[] dtos) throws BizException{
		StringBuffer srvcods=new StringBuffer();
		Map<String,String> srvlismap=new HashMap<String,String>();
		for(IESrvLisRelDictDTO dto:dtos){
			srvcods.append("'"+dto.getCode()+"',");
			srvlismap.put(dto.getCode(), dto.getListestcode());
		}
		return setMsgInfo2Srv(srvcods.toString(),srvlismap);
	}
	/**
	 * 回写Lis编码
	 * @param srvcods
	 * @param srvlismap
	 * @return
	 * @throws BizException
	 */
	private boolean setMsgInfo2Srv(String srvcods,Map<String,String> srvlismap) throws BizException{
		MedSrvDO[] medsrvs=findMedsrvByCode(srvcods);
		if(medsrvs.length!=0){
			for(MedSrvDO medsrv:medsrvs){
				if(srvlismap.containsKey(medsrv.getCode())){
					medsrv.setCode_rel5(srvlismap.get(medsrv.getCode()));
					medsrv.setStatus(DOStatus.UPDATED);
				}
			}
			return saveMedsrv(medsrvs);
		}
		return false;
	}
	/**
	 * 根据服务编码查找服务DO
	 * @param strcodes
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] findMedsrvByCode(String strcodes) throws BizException{
		IMedsrvMDORService service=ServiceFinder.find(IMedsrvMDORService.class);
		String wherestr=" a0.code in ("+strcodes.substring(0, strcodes.length()-1)+")";
		return service.find(wherestr, null, FBoolean.FALSE);
	}
	/**
	 * 保存服务项目
	 * @param medsrvs
	 * @return
	 * @throws BizException
	 */
	private boolean saveMedsrv(MedSrvDO[] medsrvs) throws BizException{
		IMedsrvMDOCudService service=ServiceFinder.find(IMedsrvMDOCudService.class);
		MedSrvDO[] result= service.save(medsrvs);
		if(result.length==0)return false;
		return true;
	}

}
