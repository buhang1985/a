package iih.en.comm.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatContDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者查询BP
 * @author yankan
 *
 */
public class PatQryBP {	
	public PatQryBP(){}
	/**
	 * 获取患者现住址
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	public String getPresentAddress(String patId) throws BizException{
		return this.getPatAddress(patId, IPiDictCodeConst.SD_ADDR_TYPE_NOW);
	}
	/**
	 * 获取家庭住址
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public String getFamilyAddress(String patId) throws BizException{		
		return this.getPatAddress(patId, IPiDictCodeConst.SD_ADDR_TYPE_FAMILY);
	}
	/**
	 * 获取患者地址
	 * @param patId 患者ID
	 * @param addrTpCode 地址类型编码
	 * @return
	 * @throws BizException
	 */
	public String getPatAddress(String patId,String addrTpCode) throws BizException{
		StringBuilder addressBuilder = new StringBuilder();
		PatiAddrDO addrDO = this.getPatAddressDO(patId,addrTpCode);
		if(addrDO!=null){
			if(!EnValidator.isEmpty(addrDO.getAdmdiv_fullname())){
				addressBuilder.append(addrDO.getAdmdiv_fullname());
			}
			if(!EnValidator.isEmpty(addrDO.getStreet())){
				addressBuilder.append(addrDO.getStreet());
			}
		}
		
		return addressBuilder.toString();
	}
	/**
	 * 获取患者地址集合
	 * @param patId 患者ID
	 * @param addrTpCode 地址类型编码
	 * @return
	 * @throws BizException
	 */
	public PatiAddrDO getPatAddressDO(String patId,String addrTpCode) throws BizException{
		IPatiAddrDORService patAddrService = ServiceFinder.find(IPatiAddrDORService.class);
		String whereStr =String.format("%s.id_pat='%s' and %s.sd_addrtp='%s'",PatiAddrDODesc.TABLE_ALIAS_NAME,patId
				,PatiAddrDODesc.TABLE_ALIAS_NAME,addrTpCode);
		PatiAddrDO[] addrDOArray = patAddrService.find(whereStr, null, FBoolean.FALSE);
		if(EnValidator.isEmpty(addrDOArray))
			return null;
		
		return addrDOArray[0];
	}
	/**
	 * 获取患者地址集合
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	public PatiAddrDO[] getAddressList(String patId) throws BizException{
		IPatiAddrDORService patAddrService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] addrDOArray = patAddrService.findByAttrValString(PatiAddrDO.ID_PAT, patId);
		return addrDOArray;
	}
	/**
	 * 获取患者联系人地址
	 * @param contactId
	 * @return
	 * @throws BizException
	 */
	public String getContactAddress(String contactId) throws BizException{
		IPiPatContDORService patContService = ServiceFinder.find(IPiPatContDORService.class);
		PiPatContDO contDO = patContService.findById(contactId);
		return contDO!=null ? contDO.getContaddr() : null;
	}
	/**
	 * 获取第一个联系人
	 * @param patId 患者
	 * @return
	 * @throws BizException
	 */
	public PiPatContDO getFirstContact(String patId) throws BizException{
		IPiPatContDORService patContService = ServiceFinder.find(IPiPatContDORService.class);
		PiPatContDO[] contDOs= patContService.findByAttrValString(PiPatContDO.ID_PAT, patId);
		if(!EnValidator.isEmpty(contDOs)){
			return contDOs[0];
		}
		return null;
	}
	/**
	 * 查询患者信息
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public PatDO getPat(String patId) throws BizException{
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = patRService.findById(patId);
		return patDO;
	}	
}
