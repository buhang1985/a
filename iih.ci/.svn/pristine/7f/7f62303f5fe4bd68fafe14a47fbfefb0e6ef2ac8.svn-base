package iih.ci.ord.s.external.obtain;

import java.util.Map;

import iih.ci.ord.i.external.obtain.ICiOrdPiRService;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.dic.cardtype.i.ICardtypeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 临床调用患者域接口
 * @author HUMS
 *
 */
@Service(serviceInterfaces = { ICiOrdPiRService.class }, binding = Binding.JSONRPC)
public class CiOrdPiRServiceImpl implements ICiOrdPiRService{

	/**
	 * 获取患者就诊卡类型接口
	 * @return key 就诊卡类型编码，就诊卡名称
	 * @throws BizException 
	 */
	@Override
	public FMap getPatCardType(String id_grp, String id_org) throws BizException {
		
		FMap patCardTpMap = new FMap();
		
		String whereStr = "id_grp = '"+id_grp+"' and id_org = '"+id_org+"'";		
		ICardtypeRService cardtypeRService = (ICardtypeRService)ServiceFinder.find(ICardtypeRService.class);
		PiPatCardTpDO[] patCardTps = cardtypeRService.find(whereStr, "code asc", FBoolean.FALSE);
		
		for(PiPatCardTpDO patCardTp : patCardTps){
			patCardTpMap.put(patCardTp.getCode(), patCardTp.getName());
		}
		
		return patCardTpMap;
	}
	
	/**
	 * 根据就诊id查询患者分类
	 * 
	 * @param id_en 患者本次就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getPatcaCodeByIden(String id_en) throws BizException {

		SqlParam param = new SqlParam();
		param.addParam(id_en);

		String qrySql = "select p.code from en_ent t , pi_pat_ca p where t.id_patca = p.id_patca and t.id_ent = ?";
		Map<String, Object> map = (Map<String, Object>) (new DAFacade().execQuery(qrySql,param, new MapHandler()));
		
		return map.get("code").toString();
	}

}
