package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据号别获取推荐号源
 * @author Administrator
 *
 */
public class GetSuggestResBySrvBP {
	/**
	 * 根据号别获取推荐号源
	 * @param scsrvId 排班服务ID
	 * @return
	 * @throws BizException
	 */
	public RegResDTO[] exec(String scsrvId, String deptId) throws BizException{
		GetResBySchmBP getResBySchmBP = new GetResBySchmBP();
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		FArrayList farr = new FArrayList();
		farr.add(scsrvId); //号别ID
		qryScheme.setSd_scchltp(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_WINDOW);
		qryScheme.setIds_scsrv(farr);
		qryScheme.setD_begin(ScAppUtils.getServerDateTime().getDate()); //开始日期为今天
		qryScheme.setD_end(new GetMaxAvlRegDateBP().exec(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_WINDOW)); //最大挂号日期
		FArrayList farrDepIds = new FArrayList(); //对应科室ID
		farrDepIds.add(deptId);
		qryScheme.setIds_dep(farrDepIds);
		qryScheme.setFg_remain(FBoolean.TRUE); //过滤无剩余号源资源及停诊
		qryScheme.setRows(ScParamUtils.getSuggestNum()); //推荐号源数
		qryScheme.setOrderstr("D_SCH, LOT.SORTNO");//按日期和午别排序
		qryScheme.setFg_quan(FBoolean.TRUE);//加载号源
		qryScheme.setFg_suggest(FBoolean.TRUE);//推荐号源标识
		return getResBySchmBP.exec(qryScheme);
	}
}
