package iih.ci.ord.s.bp.skintest;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.ci.ord.dto.d.ValidSkinOrInfo;
import iih.ci.ord.dto.skintest.d.SkinTestRstDTO;
import iih.ci.ord.pub.CiOrdUtils;

/**
 * 获得患者有效皮试医嘱数据信息操作BP
 */
public class GetPiValidSkinTestOrInfoBP {
	/**
	 * 获得患者有效皮试医嘱数据信息
	 * @param id_pi
	 * @param id_skinsrv
	 * @param secttime
	 * @return
	 * @throws BizException
	 */
	public ValidSkinOrInfo[] exec(String id_pi,String id_skinsrv,FDateTime[] secttime)  throws BizException{ 
		//有效性检验
		if(CiOrdUtils.isEmpty(id_pi) || CiOrdUtils.isEmpty(id_skinsrv) || CiOrdUtils.isEmpty(secttime))return null;
		
		//结果查询
		GetPiValidSkinTestOrQry qry=new GetPiValidSkinTestOrQry(id_pi,id_skinsrv,secttime);
		ValidSkinOrInfo[] rtn = (ValidSkinOrInfo[])AppFwUtil.getDORstWithDao(qry, ValidSkinOrInfo.class);
		
		//返回结果
		return rtn;
	}
	/**
	 * 获得患者有效皮试医嘱数据信息
	 * @param id_pi
	 * @param secttime
	 * @return
	 * @throws BizException
	 */
	public SkinTestRstDTO[] exec(String id_pi,FDateTime[] secttime)  throws BizException{ 
		//有效性检验
		if(CiOrdUtils.isEmpty(id_pi) || CiOrdUtils.isEmpty(secttime))return null;
		
		//结果查询
		GetAllPiValidSkinTestOrQry qry=new GetAllPiValidSkinTestOrQry(id_pi,secttime);
		SkinTestRstDTO[] rtn = (SkinTestRstDTO[])AppFwUtil.getDORstWithDao(qry, SkinTestRstDTO.class);
		
		//返回结果
		return rtn;
	}
}
