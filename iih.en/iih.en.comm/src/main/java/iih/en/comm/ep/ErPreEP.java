package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.d.EnErPrePatDO;
import iih.en.er.pre.i.IEnerpreCudService;
import iih.en.er.pre.i.IEnerpreRService;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;

import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 预检信息EP
 * 
 * @author liubin
 *
 */
public class ErPreEP {
	/**
	 * 获取预检信息
	 * 
	 * @param erpreId
	 * @return
	 * @throws BizException
	 */
	public EnErPreDO findById(String erPreId) throws BizException{
		if(EnValidator.isEmpty(erPreId))
			return null;
		return getErPreRServ().findById(erPreId);
	}
	/**
	 * 获取预检信息
	 * 
	 * @param erpreId
	 * @return
	 * @throws BizException
	 */
	public EnErPreDO[] findByIds(String[] erPreIds) throws BizException{
		if(EnValidator.isEmpty(erPreIds))
			return null;
		return getErPreRServ().findByIds(erPreIds, FBoolean.FALSE);
	}
	/**
	 * 获取最后一个预检记录
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public EnErPreDO getLastErPre(String patId, String depId)
			throws BizException {
		String whereStr = String.format(
				"Id_pat = '%s' and sd_status = '%s' and dt_entry >='%s' ",
				patId,IEnDictCodeConst.SD_STATUS_ERPRE_NEW,
				EnAppUtils.getServerDateTime().subSeconds(EnParamUtils.getErPreValid() * 60 * 60));
		if(!EnValidator.isEmpty(depId))
			whereStr += String.format(" and Id_dep_to = '%s'", depId);
		EnErPreDO[] erPres = getErPreRServ().find(whereStr, "dt_entry desc", FBoolean.FALSE);
		return EnValidator.isEmpty(erPres) ? null : erPres[0];
	}
	/**
	 * 根据绿色通道ids对名称赋值
	 * 
	 * @param dos
	 * @param greenIdsAttsVal
	 * @param greenNamesAttsVal
	 * @throws BizException
	 */
	public void setGreenNames(BaseDO[] dos, String greenIdsAttsVal, String greenNamesAttsVal) throws BizException{
		if(EnValidator.isEmpty(dos))
			return;
		//获取绿色通道
		IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] greens = serv.findByUdidoclistCode(IEnDictCodeTypeConst.SD_ERPRE_GREEN);
		Map<String, UdidocDO> greenMap = EnFMapUtils.getMap(UdidocDO.ID_UDIDOC, greens);
		if(greenMap == null || greenMap.size() <= 0)
			return;
		for(BaseDO baseDo : dos){
			String greenIds = (String) baseDo.getAttrVal(greenIdsAttsVal);
			if(!EnValidator.isEmpty(greenIds)){
				String[] greenIdArr = greenIds.split(",");
				boolean isFirst = true;
				StringBuilder greenBuilder = new StringBuilder();
				for(String greenId : greenIdArr){
					if(greenMap != null && greenMap.containsKey(greenId)){
						UdidocDO green = greenMap.get(greenId);
						if(isFirst){
							greenBuilder.append(green.getName());
							isFirst = false;
						}else{
							greenBuilder.append(",").append(green.getName());
						}
					}
				}
				baseDo.setAttrVal(greenNamesAttsVal, greenBuilder.toString());
			}
		}
	}
	/**
	 * 根据急诊分级编码查询急诊分级名称
	 * 
	 * @param dos
	 * @param greenIdsAttsVal
	 * @param greenNamesAttsVal
	 * @throws BizException
	 */
	public void setErScoleName(BaseDO[] dos, String codeScoleAttsVal, String nameScoleAttsVal) throws BizException{
		if(EnValidator.isEmpty(dos))
			return;
		//获取绿色通道
		IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] scoles = serv.findByUdidoclistCode(IEnDictCodeTypeConst.SD_ERPRE_SCOLE);
		Map<String, UdidocDO> scolesMap = EnFMapUtils.getMap(UdidocDO.CODE, scoles);
		if(scolesMap == null || scolesMap.size() <= 0)
			return;
		for(BaseDO baseDo : dos){
			String code = (String) baseDo.getAttrVal(codeScoleAttsVal);
			if(!EnValidator.isEmpty(code) && scolesMap.containsKey(code)){
				UdidocDO scole = scolesMap.get(code);
				String name = EnValidator.isEmpty(scole.getCtrl1()) ? scole.getName() : scole.getCtrl1();
				baseDo.setAttrVal(nameScoleAttsVal, name);
			}
		}
	}
	/**
	 * 换患者处理
	 * 
	 * @param erPreId
	 * @param agg
	 * @throws BizException
	 */
	public void changePatHandle(String erPreId, PatiAggDO agg) throws BizException{
		if(EnValidator.isEmpty(erPreId) || agg == null)
			return;
		//修改预检表数据
		EnErPreDO erPre = findById(erPreId);
		erPre.setStatus(DOStatus.UPDATED);
		erPre.setId_pat(agg.getParentDO().getId_pat());
		erPre.setName_pat(agg.getParentDO().getName());
		erPre.setFg_nonperson(FBoolean.FALSE);
		save(new EnErPreDO[] {erPre});
		//修改预检患者信息
		ErPrePatEP erPrePatEp = new ErPrePatEP();
		EnErPrePatDO erPrePat = erPrePatEp.getErPrePatByPreId(erPreId);
		erPrePat.setStatus(DOStatus.UPDATED);
		erPrePat.setName(agg.getParentDO().getName());
		erPrePat.setId_sex(agg.getParentDO().getId_sex());
		erPrePat.setSd_sex(agg.getParentDO().getSd_sex());
		erPrePat.setTelno(agg.getParentDO().getMob());
		PatiAddrDO[] addrs = agg.getPatiAddrDO();
		if(!EnValidator.isEmpty(addrs)){
			for(PatiAddrDO addr : addrs){
				if(IPiDictCodeConst.SD_ADDR_TYPE_NOW.equals(addr.getSd_addrtp())){
					erPrePat.setId_admdiv_addr(addr.getId_admdiv());
					erPrePat.setSd_conttp(addr.getSd_admdiv());
					erPrePat.setAddr_cont(addr.getTel());
					erPrePat.setAddr(addr.getStreet());
					break;
				}
			}
		}
		erPrePatEp.save(new EnErPrePatDO[] {erPrePat});
	}
	/**
	 * 保存预检信息
	 * 
	 * @param erPres
	 * @return
	 * @throws BizException
	 */
	public EnErPreDO[] save(EnErPreDO[] erPres) throws BizException{
		if(EnValidator.isEmpty(erPres))
			return null;
		return getErPreCudServ().save(erPres);
	}
	/**
	 * 获取EN_ERPRE查询服务
	 * @return
	 */
	public IEnerpreRService getErPreRServ(){
		return ServiceFinder.find(IEnerpreRService.class);
	}
	/**
	 * 获取EN_ERPRE操作服务
	 * @return
	 */
	public IEnerpreCudService getErPreCudServ(){
		return ServiceFinder.find(IEnerpreCudService.class);
	}
	
	/**
	 * 取消急诊留观修改预计信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnErPreDO cancObsErPre(String entId) throws BizException{
		EnErPreDO[] obsErPres = getErPreRServ().findByAttrValString(EnErPreDO.ID_ENT_IP, entId);
		if(EnValidator.isEmpty(obsErPres))
			return null;
		obsErPres[0].setStatus(DOStatus.UPDATED);
		obsErPres[0].setSd_status_ip(IEnDictCodeConst.SD_STATUS_ERPRE_CANCEL);
		return save(new EnErPreDO[]{obsErPres[0]})[0];
	}
}
