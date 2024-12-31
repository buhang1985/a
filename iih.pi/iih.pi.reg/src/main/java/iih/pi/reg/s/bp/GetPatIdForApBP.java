package iih.pi.reg.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.params.PiParams;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.customer.guoji.SyncPatiInfoFromChisBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 预约挂号取患者id
 * 处理同GetPatInfoForApBP，仅查询id
 * @author ly 2017/10/25
 *
 */
public class GetPatIdForApBP {

	/**
	 * 预约挂号取患者id
	 * @param codePat
	 * @return
	 * @throws BizException
	 */
	public String exec(String codePat) throws BizException{
		
		if(StringUtil.isEmpty(codePat))
			return null;
		
		String id  = this.getPatFromLocal(codePat);
		if(id != null)
			return id;
		
		//未开启chis同步功能
		if(!FBoolean.TRUE.equals(new PiParams().PIPAT0002()))
			return null;
		
		//从chis同步患者数据
		SyncPatiInfoFromChisBP chisBp = new SyncPatiInfoFromChisBP();
		PatiAggDO aggDo = chisBp.exec(codePat);
		if(aggDo != null)
			return aggDo.getParentDO().getId_pat();
		
		return null;
	}
	
	/**
	 * 从本地获取患者数据
	 * @param codePat
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private String getPatFromLocal(String codePat) throws BizException{
		
		DAFacade daf = new DAFacade();
		String whereSql = "(code = '" + codePat + "' "
				+ "or (sd_idtp = '"+ IPiDictCodeConst.SD_IDTP_IDENTITY +"' "
				+ "and id_code = '" + codePat + "') "
				+ "or barcode_chis = '" + codePat + "') "
				+ "and ds = 0 and fg_invd ='N' ";
		List<PatDO> dos = (List<PatDO>)daf.findByCond(PatDO.class, whereSql, new String[]{"id_pat"});
		if(!ListUtil.isEmpty(dos)){
			return dos.get(0).getId_pat();
		}
		
		return null;
	}
}
