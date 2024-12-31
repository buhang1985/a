package iih.bd.srv.medsrv.bf;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.dto.d.MedSrvPriDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 更新医疗服务定价模式信息BP
 */
public class UpdateSrvPriMdInfoBP {

	/**
	 * 更新医疗服务定价模式信息操作
	 * @param srvprimddto
	 * @return
	 * @throws BizException
	 */
	public  boolean exec(MedSrvPriDTO[] srvprimddto)  throws BizException
	{
		//有效性校验
		if(!isValidate(srvprimddto))return true;
		
		//获得医疗服务集合
		MedSrvDO[] medsrvs=getMedSrvDOs(srvprimddto);
		
		//更新服务定价信息
		MedSrvDO[] rtns=updatePriMdInfo(medsrvs);
		
		return true;
	}
	
	/**
	 * 有效性校验 
	 * @param srvprimddto
	 * @return
	 */
	private boolean isValidate(MedSrvPriDTO[] srvprimddto){
		if(srvprimddto==null || srvprimddto.length==0)return false;
		return true;
	}
	
	/**
	 * 获得医疗服务集合
	 * @param srvprimddto
	 * @return
	 * @throws BizException 
	 */
	private MedSrvDO[] getMedSrvDOs(MedSrvPriDTO[] srvprimddto) throws BizException
	{
		int iL=srvprimddto.length;
		String[] ids=getIDs(srvprimddto,iL);
		MedSrvDO[] rtns=getMedSrvDOs(ids);
		PriMdDataHandle(rtns,srvprimddto,iL);
		return rtns;
	}
	
	/**
	 * 获得医疗服务id集合
	 * @param srvprimddto
	 * @param iL
	 * @return
	 */
	private String[] getIDs(MedSrvPriDTO[] srvprimddto,int iL){
		String[] ids=new String[iL];
		for(int i=0;i<iL;i++){
			ids[i]=srvprimddto[i].getId_srv();
		}
		return ids;
	}
	
	/**
	 * 获得医疗服务集合
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] getMedSrvDOs(String[] ids) throws BizException
	{
		IMedsrvMDORService service=(IMedsrvMDORService)ServiceFinder.find(IMedsrvMDORService.class.getName());
		MedSrvDO[] rtns=service.findByIds(ids, new FBoolean(false));
		
		return rtns;
	}
	
	/**
	 * 医疗服务定价模式设置
	 * @param rtns
	 * @param srvprimddto
	 * @param iL
	 */
	private void PriMdDataHandle(MedSrvDO[] rtns,MedSrvPriDTO[] srvprimddto,int iL){
		String id0="",id1="";
		for(int i=0;i<iL;i++){
			id0=rtns[i].getId_primd();
			id1=srvprimddto[i].getId_primd();
			if(!isUpdated(id0,id1))continue;
			rtns[i].setId_primd(id1);
			rtns[i].setStatus(DOStatus.UPDATED);
		}
	}
	
	/**
	 * 值变化比较
	 * @param id0
	 * @param id1
	 * @return
	 */
	private boolean isUpdated(String id0,String id1){
		if(StringUtils.isBlank(id0) && StringUtils.isBlank(id1))return false;
		if(StringUtils.isBlank(id0) || StringUtils.isBlank(id1))return true;
		if(id0.equals(id1))return false;
		return true;
	}
	
	/**
	 * 更新服务定价信息
	 * @param medsrvs
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] updatePriMdInfo(MedSrvDO[] medsrvs) throws BizException
	{
		IMedsrvMDOCudService service=ServiceFinder.find(IMedsrvMDOCudService.class);
		MedSrvDO[] rtns=service.update(medsrvs);
		
		return rtns;
	}
}
