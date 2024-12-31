package iih.pi.reg.s.customer.guoji;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.res.params.BdResParams;
import iih.pi.reg.dto.patap.d.PiPatChisInfoDTO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.s.customer.guoji.util.PatNeedSyncUtil;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 同步更新chis数据到iih
 * @author ly 2017/07/20
 *
 */
public class SyncPatiInfoFromChisByIdBP {
	
	/**
	 * 同步更新chis数据到iih
	 * @param codePat
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO exec(String codePat) throws BizException{
		
		if(StringUtil.isEmpty(codePat)){
			throw new BizException("chis同步服务:入参患者编码为空");
		}
		
		PiPatChisInfoDTO chisPatInfo = this.getChisPatInfo(codePat);
		if("1".equals(chisPatInfo.getBlack_flag())){
			chisPatInfo.setBlack_flag(IPiDictCodeConst.SD_IDTP_IDENTITY);
		}
		
		PatiAggDO aggDo = this.getIIHPatInfo(codePat);
	
		if(!PatNeedSyncUtil.needSync(chisPatInfo, aggDo))
			return null;
		
		IPatiCudService cudService = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO newAggDo = cudService.update(new PatiAggDO[]{aggDo})[0];
		
		newAggDo.getParentDO().setOrigin(null);
		return newAggDo;
	}
	
	/**
	 * 获取chis患者数据
	 * @param codePat
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private PiPatChisInfoDTO getChisPatInfo(String codePat) throws BizException{
		
		String dataSource = new BdResParams().CHISDB();
		if(StringUtil.isEmpty(dataSource)){
			throw new BizException("未定义chis数据源");
		}
			
		PiGetPatInfoFromOldChisQry qry = new PiGetPatInfoFromOldChisQry(codePat, false);
		StringBuffer sqlSb = new StringBuffer(qry.getQrySQLStr());
		SqlParam param = qry.getQryParameter(sqlSb);
		
		DAFacade daf = new DAFacade(dataSource);
		List<PiPatChisInfoDTO> result = (List<PiPatChisInfoDTO>) daf.execQuery(
				sqlSb.toString(), param, new BeanListHandler(PiPatChisInfoDTO.class));
		
		if(ListUtil.isEmpty(result)){
			throw new BizException("chis中不存在该患者，无法同步");
		}
		
		return result.get(0);
	}
	
	/**
	 * 获取iih患者数据
	 * @param codePat
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO getIIHPatInfo(String codePat) throws BizException{
		
		IPatiRService patiRservice = ServiceFinder.find(IPatiRService.class);
		String whereSql = "a0.code = '" + codePat + "' and a0.fg_invd = 'N' ";
		PatiAggDO[] aggDos = patiRservice.find(whereSql, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(aggDos)){
			throw new BizException("该患者不存在");
		}
		
		return aggDos[0];
	}
}
