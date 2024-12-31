package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.d.desc.EntDiDODesc;
import iih.en.pv.entdi.i.IEntdiCudService;
import iih.en.pv.entdi.i.IEntdiRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊诊断EP
 * @author yankan
 * @since 2015-12-02
 *
 */
public class EntDiEP {
	
	/**
	 * 获取所有诊断
	 * @param entId 就诊id
	 * @param disunjtp 诊断类别，如果为null，则查询全部
	 * @return
	 * @throws BizException
	 */
	public  EntDiDO[] getAllEntDi(String entId) throws BizException {
		IEntdiRService entDiRService = ServiceFinder.find(IEntdiRService.class);
		String whereStr = String.format(EntDiDODesc.TABLE_ALIAS_NAME+".ID_ENT='%s'" , entId);
		EntDiDO[] entDiDOs = entDiRService.find(whereStr, null, FBoolean.FALSE);
		return entDiDOs;
	}
	/**
	 * 获取诊断
	 * @param entId 就诊id
	 * @param disunjtp 诊断类别，如果为null，则查询全部
	 * @return
	 * @throws BizException
	 */
	public  EntDiDO[] getEntDi(String entId,String disunjtp) throws BizException {
		IEntdiRService entDiRService = ServiceFinder.find(IEntdiRService.class);
		String whereStr = String.format(EntDiDODesc.TABLE_ALIAS_NAME+".ID_ENT='%s' and fg_maj = 'Y'" , entId);
		EntDiDO[] entDiDOs = entDiRService.find(whereStr, null, FBoolean.FALSE);
		return entDiDOs;
	}
	/**
	 * 获取主诊断
	 * 如果有西医主诊断，取西医主诊断，否则取中医主诊断  中医西医现在只有一个诊断，根据主诊断标识查询即可
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EntDiDO getMainDi(String entId) throws BizException{
		EntDiDO[] westDiDOs = this.getEntDi(entId,IEnDictCodeConst.SD_DI_SUNJ_TYPE_WEST);
		if(westDiDOs!=null && westDiDOs.length>0){
			return westDiDOs[0];
		}
		return null;
	}
	/**
	 * 获取主诊断
	 * @param entId 就诊id
	 * @param disunjtp 诊断类别
	 * @return
	 * @throws BizException
	 */
	public EntDiDO getMainDi(String entId,String disunjtp) throws BizException{
		IEntdiRService entDiRService = ServiceFinder.find(IEntdiRService.class);
		String whereStr = String.format("ID_ENT='%s'", entId);
		if(disunjtp!=null &&disunjtp.length()>0){
			whereStr += String.format(" AND SD_CDSYSTP='%s' AND FG_MAJ='Y'",disunjtp);
		}
		EntDiDO[] entDiDOs = entDiRService.find(whereStr, null, FBoolean.FALSE);
		if(entDiDOs!=null && entDiDOs.length>0){
			return entDiDOs[0];
		}
		
		return null;
	}
	/**
	 * 获取就诊主诊断集合
	 * @param entIdList 就诊id集合
	 * @return
	 * @throws BizException
	 */
	public EntDiDO[] getEntMajDiList(List<String> entIdList) throws BizException {
		if(EnValidator.isEmpty(entIdList))
			return null;
		String whereStr = " fg_maj = 'Y' and " + EnSqlUtils.getInSqlByIds("id_ent", entIdList);
		IEntdiRService rservice = ServiceFinder.find(IEntdiRService.class);
		EntDiDO[] entdiDOArr = rservice.find(whereStr, "id_ent,SD_CDSYSTP asc",
				FBoolean.FALSE);
		return entdiDOArr;
	}	
	/**
	 * 获取就诊诊断
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	public EntDiDO[] getEntDiByEntId(String entId) throws BizException {
		return getEntDiRServ().findByAttrValString(EntDiDO.ID_ENT, entId);
	}

	/**
	 * 获取就诊诊断查询服务
	 * 
	 * @return
	 */
	public IEntdiRService getEntDiRServ() {
		return ServiceFinder.find(IEntdiRService.class);
	}

	/**
	 * 获取就诊诊断增加，删除，修改服务
	 * 
	 * @return
	 */
	public IEntdiCudService getEntDiCudServ() {
		return ServiceFinder.find(IEntdiCudService.class);
	}
}
