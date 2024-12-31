package iih.en.pv.s.bp;

import iih.en.comm.util.EnCollectionUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.op.GetOpRegListByPatBP;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 获取就诊或者患者信息
 * 先查就诊信息，如果就诊信息未查到再查患者信息
 * 
 * @author liubin
 * 
 */
public class GetEntOrPat4BannerBP {

	private static final String KEY_ENT = "ent";
	private static final String KEY_PAT = "pat";
	/**
	 * 获取就诊或者患者信息
	 * 先查就诊信息，如果就诊信息未查到再查患者信息
	 * @param condTypeList 条件类型集合
	 * @param inputValue 输入值
	 * @param wherePart 限定条件部分
	 * @return ent:就诊信息，pat:患者信息
	 * @throws BizException
	 */
	public FMap getEntOrPat4Banner(String[] condTypeList,String inputValue,String wherePart) throws BizException{
		if(EnValidator.isEmpty(condTypeList)||EnValidator.isEmpty(wherePart)){
			return null;
		}
		FMap map = new FMap();
		map.put(KEY_ENT, null);
		map.put(KEY_PAT, null);
		//1.查找就诊信息	
		List<String> entIds = this.getEntList(wherePart);
		if(!EnValidator.isEmpty(entIds)){
			OpRegDTO[] regs = this.getOpRegDTOs(entIds);
			if(!EnValidator.isEmpty(regs)){
				map.put(KEY_ENT, EnCollectionUtils.toFArrayList(regs));
				return map;
			}
		}
		
		//2.查找患者信息
		List<String> patIds = this.getPatList(wherePart);
		if(!EnValidator.isEmpty(patIds)){
			PatDO[] pats = this.getPats(patIds);
			if(!EnValidator.isEmpty(pats)){
				map.put(KEY_PAT, EnCollectionUtils.toFArrayList(pats));
				return map;
			}
		}
		return map;
	}
	
	/**
	 * 获取就诊记录
	 * 
	 * @param entIdList
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO[] getOpRegDTOs(List<String> entIdList) throws BizException{
		if(EnValidator.isEmpty(entIdList)){
			return null;
		}
		GetOpRegListByPatBP bp = new GetOpRegListByPatBP();
		return bp.getOpRegList(entIdList, null, null, null, null,null);
	}
	
	/**
	 * 获取患者信息
	 * 
	 * @param patIdList
	 * @return
	 * @throws BizException
	 */
	private PatDO[] getPats(List<String> patIdList) throws BizException{
		if(EnValidator.isEmpty(patIdList)){
			return null;
		}
		IPatiMDORService patMRService = ServiceFinder.find(IPatiMDORService.class);
		return patMRService.findByIds(patIdList.toArray(new String[0]), FBoolean.FALSE);
	}
	
	/**
	 * 获取就诊ID集合
	 * 
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	private List<String> getEntList(String wherePart) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT ID_ENT FROM (");
		sb.append(getEntSQL());
		sb.append(")");
		sb.append(" WHERE ");
		sb.append(wherePart);
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(), new ColumnListHandler());
		return list;
	}
	
	/**
	 * 获取患者ID集合
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	private List<String> getPatList(String wherePart) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT ID_PAT FROM (");
		sb.append(getPatSQL());
		sb.append(")");
		sb.append(" WHERE ");
		sb.append(wherePart);
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(), new ColumnListHandler());
		return list;
	}
	
	/**
	 * 获取查询就诊的SQL
	 * @return
	 */
	private String getEntSQL(){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT AS ID_ENT,");
		sb.append("PAT.CODE AS CODE,");
		sb.append("EN.ID_PAT AS ID_PAT,");
		sb.append("EN.CODE AS CODE_ENT,");
		sb.append("PAT.CODE AS CODE_PAT,");
		sb.append("PAT.ID_CODE AS ID_CODE,");
		sb.append("NVL(PAT.MOB,PAT.TEL) AS PHONENUM,");
		sb.append("PAT.MOB AS MOB,");
		sb.append("PAT.TEL AS TEL,");
		sb.append("PAT.BARCODE_CHIS AS BARCODE_CHIS,");
		sb.append("PATCARD.CODE AS PATCODE ");
		sb.append("FROM EN_ENT EN ");
		sb.append("LEFT JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT AND PAT.FG_INVD = 'N' ");
		sb.append("LEFT JOIN PI_PAT_CARD PATCARD ON EN.ID_PAT = PATCARD.ID_PAT AND PATCARD.FG_ACT='Y' ");
		sb.append("WHERE " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		return sb.toString();
	}
	
	/**
	 * 获取查询患者的SQL
	 * 
	 * @return
	 */
	private String getPatSQL(){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT AS ID_ENT,");
		sb.append("PAT.ID_PAT AS ID_PAT,");
		sb.append("PAT.CODE AS CODE,");
		sb.append("EN.CODE AS CODE_ENT,");
		sb.append("PAT.CODE AS CODE_PAT,");
		sb.append("PAT.ID_CODE AS ID_CODE,");
		sb.append("NVL(PAT.MOB,PAT.TEL) AS PHONENUM,");
		sb.append("PAT.MOB AS MOB,");
		sb.append("PAT.TEL AS TEL,");
		sb.append("PAT.BARCODE_CHIS AS BARCODE_CHIS, ");
		sb.append("PATCARD.CODE AS PATCODE ");
		sb.append("FROM PI_PAT PAT ");
		sb.append("LEFT JOIN EN_ENT EN ON PAT.ID_PAT = EN.ID_PAT AND PAT.FG_INVD = 'N' ");
		sb.append("LEFT JOIN PI_PAT_CARD PATCARD ON EN.ID_PAT = PATCARD.ID_PAT AND PATCARD.FG_ACT='Y' ");
		sb.append("WHERE " + ScGroupControlUtils.getGroupControlFitler(new PatDO(), "PAT") + " ");
		return sb.toString();
	}
}
