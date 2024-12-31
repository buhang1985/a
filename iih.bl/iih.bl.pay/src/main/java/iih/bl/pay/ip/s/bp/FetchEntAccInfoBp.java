package iih.bl.pay.ip.s.bp;

import iih.bl.pay.dto.d.EntAccInfoDTO;
import iih.en.pv.i.IEnOutQryService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FetchEntAccInfoBp {

	/** 获取就诊信息
	 * @return
	 * @throws BizException
	 */
	public EntAccInfoDTO[] exec() throws BizException
	{
		IEnOutQryService entOutQryService=ServiceFinder.find(IEnOutQryService.class);
		StringBuilder sb=new StringBuilder();
		sb.append(" SELECT DISTINCT ENTACC.ID_PAT,ENTACC.ID_ENT,PAT.NAME AS NAME_PAT,ENTIP.NAME_BED AS BED_NO,ENT.CODE AS ENT_CODE,");
		sb.append(" PAT.CODE_AMR_IP,PAT.DT_BIRTH AS BIRTHDAY,BDDOC.NAME AS SEX,PATACC.CRED AS AMT_PATCRED,ENTACC.AMT_CRED AS AMT_ENTCRED,");
		sb.append(" ENTACC.AMT_PREPAY,ENTACC.AMT_UNCG,ENTACC.AMT_HP AS AMT_EXTRA,ENTACC.AMT_OWELIMIT AS AMT_LIMIT,");
		sb.append(" DECODE(HPPATCA.NAME_HPPATCA,NULL,'自费',HPPATCA.NAME_HPPATCA) AS PATCA");
		sb.append(" FROM EN_ENT_ACC ENTACC");
		sb.append(" INNER JOIN EN_ENT ENT ON ENT.ID_ENT=ENTACC.ID_ENT");
		sb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT=ENT.ID_PAT");
		sb.append(" INNER JOIN EN_ENT_IP ENTIP ON ENTIP.ID_ENT=ENT.ID_ENT");
		sb.append(" INNER JOIN BD_UDIDOC BDDOC ON PAT.ID_SEX=BDDOC.ID_UDIDOC");
		sb.append(" INNER JOIN PI_PAT_ACC PATACC ON PAT.ID_PAT=PATACC.ID_PAT");
		sb.append(" LEFT JOIN EN_ENT_HP ENTHP ON ENTHP.ID_ENT=ENT.ID_ENT");
		sb.append(" LEFT JOIN BD_HP_PATCA HPPATCA ON HPPATCA.CODE_HPPATCA=ENTHP.CODE_HPPATCA");
		sb.append(" WHERE ENT.FG_IP='Y' AND ENT.FG_CANC='N' AND ENT.ID_DEP_NUR='");
		sb.append(Context.get().getDeptId());//默认当前所在病区
		sb.append("'");
		sb.append(" ORDER BY ENTIP.NAME_BED");
		//		//根据病区检索患者就诊情况
//		EnAccountDO[] enAccountDoArr=entOutQryService.getEnIpAccsByDepId(Context.get().getDeptId());
		List<EntAccInfoDTO> lst=(List<EntAccInfoDTO>)new DAFacade().execQuery(sb.toString(),new BeanListHandler(EntAccInfoDTO.class));		
		return lst.toArray(new EntAccInfoDTO[lst.size()]);
	}
	
	
	private EntAccInfoDTO[] getEntAccInfo(String strIdEnt,String strDepId) throws BizException
	{
		IEnOutQryService entOutQryService=ServiceFinder.find(IEnOutQryService.class);
		StringBuilder sb=new StringBuilder();
		sb.append(" SELECT DISTINCT ENTACC.ID_PAT,ENTACC.ID_ENT,PAT.NAME AS NAME_PAT,ENTIP.NAME_BED AS BED_NO,ENT.CODE AS ENT_CODE,");
		sb.append(" PAT.CODE_AMR_IP,PAT.DT_BIRTH AS BIRTHDAY,BDDOC.NAME AS SEX,PATACC.CRED AS AMT_PATCRED,ENTACC.AMT_CRED AS AMT_ENTCRED,");
		sb.append(" ENTACC.AMT_PREPAY,ENTACC.AMT_UNCG,ENTACC.AMT_HP AS AMT_EXTRA,ENTACC.AMT_OWELIMIT AS AMT_LIMIT,");
		sb.append(" ENTHP.CODE_HPPATCA,HPPATCA.NAME_HPPATCA");
		sb.append(" FROM EN_ENT_ACC ENTACC");
		sb.append(" INNER JOIN EN_ENT ENT ON ENT.ID_ENT=ENTACC.ID_ENT");
		sb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT=ENT.ID_PAT");
		sb.append(" INNER JOIN EN_ENT_IP ENTIP ON ENTIP.ID_ENT=ENT.ID_ENT");
		sb.append(" INNER JOIN BD_UDIDOC BDDOC ON PAT.ID_SEX=BDDOC.ID_UDIDOC");
		sb.append(" INNER JOIN PI_PAT_ACC PATACC ON PAT.ID_PAT=PATACC.ID_PAT");
		sb.append(" LEFT JOIN EN_ENT_HP ENTHP ON ENTHP.ID_ENT=ENT.ID_ENT");
		sb.append(" LEFT JOIN BD_HP_PATCA HPPATCA ON HPPATCA.CODE_HPPATCA=ENTHP.CODE_HPPATCA");
		sb.append(" WHERE ENT.");
		return null;
	}
}
