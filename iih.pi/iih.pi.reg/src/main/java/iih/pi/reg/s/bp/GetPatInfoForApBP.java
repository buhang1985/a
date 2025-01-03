package iih.pi.reg.s.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.params.PiParams;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.s.customer.guoji.SyncPatiInfoFromChisBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.i.IBaseDO;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 预约挂号取患者信息
 * @author ly 2017/04/26
 *
 */
public class GetPatInfoForApBP {
	
	/**
	 * 预约挂号取患者信息接口
	 * 先从IIH取患者信息,取不到患者信息则从CHIS取患者信息
	 * CHIS取的患者信息，执行IIH患者注册
	 * CHIS取不到数据，从Empi取数据(废弃)
	 * Empi取的患者信息，执行IIH患者注册(废弃)
	 * @param codePat 入参有可能是患者编码，条码或者身份证
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO exec(String codePat) throws BizException{
		
		if(StringUtil.isEmpty(codePat))
			return null;
	
		PatiAggDO aggDo = null;
		
		//从本地取得患者信息
		aggDo = this.getPatFromLocal(codePat);
		if(aggDo != null)
			return aggDo;
		
		//未开启chis同步功能
		if(!FBoolean.TRUE.equals(new PiParams().PIPAT0002()))
			return null;
		
		//从chis同步患者数据
		SyncPatiInfoFromChisBP chisBp = new SyncPatiInfoFromChisBP();
	    aggDo = chisBp.exec(codePat);
		if(aggDo != null)
			return aggDo;
		
		//从empi同步患者数据
		//SyncPatiInfoFromEmpiBP empiBp = new SyncPatiInfoFromEmpiBP();
		//aggDo = empiBp.exec(codePat);
		//if(aggDo != null)
			//return aggDo;
		
		return null;
	}
	
	/**
	 * 从本地获取患者数据
	 * @param codePat
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO getPatFromLocal(String codePat) throws BizException{
		
		String a0 = PatDODesc.TABLE_ALIAS_NAME;
		IPatiRService prService = ServiceFinder.find(IPatiRService.class);
		String whereSql = "("+a0 + ".code = '" + codePat + "' "
				+ "or (" + a0 + ".sd_idtp = '"+ IPiDictCodeConst.SD_IDTP_IDENTITY +"'"
				+ " and " + a0 + ".id_code = '" + codePat + "') "
				+ "or " + a0 + ".barcode_chis = '" + codePat + "') "
                + " and " +a0+".id_org = '" + Context.get().getOrgId()+"'"
                + " and "+a0+".id_grp = '" + Context.get().getGroupId()+"'";
		PatiAggDO[] aggDos = prService.find(whereSql, "", FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(aggDos)){
			//有效性校验
			PatiAggDO aggDo = this.checkInvalid(aggDos);
			if(aggDo == null){
				//throw new BizException("该患者已经失效，患者编码:" + codePat);
			}
			
			//返回数据
			return aggDo;
		}
		
		return null;
	}
	
	/**
	 * 患者有有效性校验
	 * @param aggDos
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO checkInvalid(PatiAggDO[] aggDos) throws BizException{
		
		PatiAggDO rtn = null;
		for (PatiAggDO patiAggDO : aggDos) {
			PatDO pat = patiAggDO.getParentDO();
			if(!FBoolean.TRUE.equals(pat.getFg_invd()) && FBoolean.TRUE.equals(pat.getFg_active())){
				rtn = patiAggDO;
				break;
			}
		}
		
		return rtn;
	}
}
